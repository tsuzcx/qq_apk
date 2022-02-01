package com.tencent.upload.biz;

import FileUpload.FileUploadControlReq;
import FileUpload.FileUploadControlRsp;
import FileUpload.FileUploadProgressRsp;
import FileUpload.SvcRequestHead;
import FileUpload.SvcResponsePacket;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.upload.common.Const;
import com.tencent.upload.common.FileUtils;
import com.tencent.upload.common.FileUtils.UploaderMD5;
import com.tencent.upload.common.StringUtils;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.common.UploadLog;
import com.tencent.upload.network.IUploadSessionService;
import com.tencent.upload.network.action.ActionResponse;
import com.tencent.upload.network.action.IActionRequest;
import com.tencent.upload.network.base.ConnectionImpl;
import com.tencent.upload.network.route.UploadRoute;
import com.tencent.upload.network.session.IUploadSession;
import com.tencent.upload.protocol.utils.ProtocolUtil;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.AbstractUploadTask.IProgressDelegate;
import com.tencent.upload.uinterface.IUploadAction;
import com.tencent.upload.uinterface.IUploadAction.SessionError;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadReport;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.IUploadTaskType;
import com.tencent.upload.uinterface.Report;
import java.io.File;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public abstract class UploadActionFlowWrapper
  implements IUploadAction
{
  public static final String REPORT_MSG_DIVIDER = " || ";
  protected static final int STATE_CANCEL = 50;
  protected static final int STATE_INIT = 0;
  protected static final int STATE_RECEIVE_UPLOAD_SUCCESS = 40;
  protected static final int STATE_SEND_CONTROL = 10;
  protected static final int STATE_SEND_FILE = 30;
  protected static final int STATE_SEND_OVER_INDEED = 35;
  protected static final int STATE_SEND_PART_FILE = 20;
  protected static final String tag = "FlowWrapper";
  protected AbstractUploadTask mAbstractUploadTask;
  protected String mClientIp;
  protected IUploadConfig mConfig;
  protected String mConnectedIp;
  long mContolPkgEndTime;
  long mContolPkgStartTime;
  int mDescLength;
  int mFileLength;
  boolean mPartFileMode = false;
  long mPartFileProgress = 0L;
  long mProgressRecvDataLen = 0L;
  long mProgressTotalLen = 0L;
  String mReportAppendMsg;
  int mRetryControlCount = 0;
  int mRetryPartFileCount = 0;
  long mSendDescFileLen = 0L;
  long mSendDescFileOffset = 0L;
  long mSendFileLen = 0L;
  long mSendFileOffset = 0L;
  private WeakReference<IUploadSessionService> mSessionServiceRef;
  long mStartTime;
  protected volatile int mState;
  protected SvcRequestHead mSvcRequestHead;
  protected byte[] mUploadFileInfoReqBytes;
  UploadRoute mUploadRoute;
  protected IUploadTaskCallback mUploadTaskCallback;
  int reSendCount = 0;
  
  public UploadActionFlowWrapper(AbstractUploadTask paramAbstractUploadTask)
  {
    this.mUploadTaskCallback = paramAbstractUploadTask.uploadTaskCallback;
    this.mAbstractUploadTask = paramAbstractUploadTask;
    this.mConfig = UploadGlobalConfig.getConfig();
  }
  
  private void cancelTaskInner(int paramInt1, int paramInt2, String paramString)
  {
    WeakReference localWeakReference = this.mSessionServiceRef;
    if (localWeakReference == null) {}
    String str;
    do
    {
      return;
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "cancelTaskInner";
      }
      paramString = (IUploadSessionService)localWeakReference.get();
    } while (paramString == null);
    paramString.cancel(paramInt1, paramInt2);
    UploadLog.d("FlowWrapper", str + " cancel flowId=" + paramInt1);
  }
  
  private final boolean isNetworkRelevant(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return true;
    }
    return false;
  }
  
  protected static final void printSvcRequestHead(SvcRequestHead paramSvcRequestHead)
  {
    UploadLog.v("FlowWrapper", "SvcRequestHead [iVersionId=" + paramSvcRequestHead.iVersionId + ", iUin=" + paramSvcRequestHead.iUin + ", sRefer=" + paramSvcRequestHead.sRefer + ", iLoginType=" + paramSvcRequestHead.iLoginType + ", iUploadType=" + paramSvcRequestHead.iUploadType + ", iCmdID=" + paramSvcRequestHead.iCmdID + ", iFileLen=" + paramSvcRequestHead.iFileLen + ", iOffset=" + paramSvcRequestHead.iOffset + ", iNetType=" + paramSvcRequestHead.iNetType + ", sOperator=" + paramSvcRequestHead.sOperator + ", iSync=" + paramSvcRequestHead.iSync + ", iSource=" + paramSvcRequestHead.iSource + ", iFileType=" + paramSvcRequestHead.iFileType + ", iDescLen=" + paramSvcRequestHead.iDescLen + ", sQua=" + paramSvcRequestHead.sQua + ", iPartDataLen=" + paramSvcRequestHead.iPartDataLen + ", md5type=" + paramSvcRequestHead.md5type + ", md5filelen=" + paramSvcRequestHead.md5filelen + ", noRspProcess=" + paramSvcRequestHead.noRspProcess + ", seq=" + paramSvcRequestHead.seq + ", httpRspProcess=" + paramSvcRequestHead.httpRspProcess + ", uintype=" + paramSvcRequestHead.uintype + ", preupload=" + paramSvcRequestHead.preupload + "]");
    if ((paramSvcRequestHead.vLoginData == null) || (paramSvcRequestHead.vLoginData.length == 0)) {
      UploadLog.w("FlowWrapper", "svcRequestHead.vLoginData is null or length=0");
    }
    if ((paramSvcRequestHead.vLoginKey == null) || (paramSvcRequestHead.vLoginKey.length == 0)) {
      UploadLog.w("FlowWrapper", "svcRequestHead.vLoginKey is null or length=0");
    }
  }
  
  protected static final void printSvcResponsePacket(SvcResponsePacket paramSvcResponsePacket)
  {
    UploadLog.d("FlowWrapper", "SvcResponsePacket [iRetCode=" + paramSvcResponsePacket.iRetCode + ", iRetSubCode=" + paramSvcResponsePacket.iRetSubCode + ", sResultDes=" + paramSvcResponsePacket.sResultDes + ", iUploadType=" + paramSvcResponsePacket.iUploadType + ", iCmdID=" + paramSvcResponsePacket.iCmdID + ", seq=" + paramSvcResponsePacket.seq + ", iUin=" + paramSvcResponsePacket.iUin + "]");
  }
  
  private void processFileUploadControlRsp(IUploadSession paramIUploadSession, FileUploadControlRsp paramFileUploadControlRsp)
  {
    UploadLog.d("FlowWrapper", "FileUploadControlRsp [iOffset=" + paramFileUploadControlRsp.iOffset + ", iRetCode=" + paramFileUploadControlRsp.iRetCode + ", iServerTime=" + paramFileUploadControlRsp.iServerTime + "]");
    this.mSendFileOffset = 0L;
    this.mSendFileLen = 0L;
    if (paramFileUploadControlRsp.iOffset < 0L)
    {
      cancelActionForException(501, 0, true, true, "processFileUploadControlRsp fileUploadControlRsp.iOffset:" + paramFileUploadControlRsp.iOffset, "文件不存在");
      return;
    }
    this.mSendDescFileOffset = paramFileUploadControlRsp.iOffset;
    this.mPartFileProgress = paramFileUploadControlRsp.iOffset;
    if (this.mUploadTaskCallback != null)
    {
      this.mUploadTaskCallback.onUploadStateChange(this.mAbstractUploadTask, 1);
      UploadLog.v("FlowWrapper", "onUploadStateChange=1");
    }
    sendFilePkg(paramIUploadSession);
    int j;
    int i;
    if (this.mPartFileMode)
    {
      j = UploadConfiguration.getVideoPartConcurrentCount();
      i = 1;
    }
    for (;;)
    {
      if (i >= j)
      {
        this.mStartTime = System.currentTimeMillis();
        return;
      }
      UploadLog.d("FlowWrapper", "多线程分片 i=" + i + " mFileLength=" + this.mFileLength + " mSendFileOffset=" + this.mSendFileOffset + " mSendFileLen=" + this.mSendFileLen);
      if (this.mSendFileOffset + this.mSendFileLen < this.mFileLength)
      {
        this.mSendDescFileOffset += this.mSendDescFileLen;
        sendFilePkg(paramIUploadSession);
      }
      i += 1;
    }
  }
  
  private void processFileUploadProgressRsp(IUploadSession paramIUploadSession, FileUploadProgressRsp paramFileUploadProgressRsp)
  {
    UploadLog.d("FlowWrapper", "ProgressRsp [" + paramFileUploadProgressRsp.iRecvDataLen + ", " + paramFileUploadProgressRsp.iTotalLen + "]");
    this.mProgressTotalLen = paramFileUploadProgressRsp.iTotalLen;
    this.mProgressRecvDataLen = paramFileUploadProgressRsp.iRecvDataLen;
    if (this.mUploadTaskCallback != null)
    {
      this.mUploadTaskCallback.onUploadProgress(this.mAbstractUploadTask, this.mProgressTotalLen, this.mProgressRecvDataLen);
      UploadLog.v("FlowWrapper", "processFileUploadProgressRsp() mUploadTaskCallback progress");
      paramIUploadSession = this.mAbstractUploadTask.progressListener;
      if (paramIUploadSession != null) {
        paramIUploadSession.onProgress(this.mAbstractUploadTask, this.mProgressTotalLen, this.mProgressRecvDataLen);
      }
    }
    this.mRetryControlCount = 0;
    this.mRetryPartFileCount = 0;
  }
  
  private void reSend(IUploadSession paramIUploadSession, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    UploadLog.i("FlowWrapper", String.format("reSend() mState=%d mRetryPartFileCount=%d mRetryControlCount=%d", new Object[] { Integer.valueOf(this.mState), Integer.valueOf(this.mRetryPartFileCount), Integer.valueOf(this.mRetryControlCount) }));
    if (this.mAbstractUploadTask.preupload == 1)
    {
      paramInt1 = 1;
      if (this.mPartFileMode) {
        switch (this.mState)
        {
        }
      }
    }
    for (;;)
    {
      if ((this.mRetryControlCount <= UploadConfiguration.getVideoFileRetryCount()) && (this.reSendCount < UploadConfiguration.getResendCount()) && (paramInt1 == 0))
      {
        sendFirstPkg(paramIUploadSession);
        this.mRetryControlCount += 1;
        this.reSendCount += 1;
        report(paramInt2, paramString1, this.mAbstractUploadTask);
        return;
        paramInt1 = 0;
        break;
        if ((this.mRetryPartFileCount <= this.mConfig.getVideoPartRetryCount()) && (paramInt1 == 0))
        {
          sendFilePkg(paramIUploadSession);
          this.mRetryPartFileCount += 1;
          report(paramInt2, paramString1, this.mAbstractUploadTask);
          return;
        }
      }
    }
    cancelActionForException(paramInt2, 0, true, true, paramString1, paramString2);
  }
  
  private boolean sendControlPkg(IUploadSession paramIUploadSession)
  {
    this.mSvcRequestHead.iCmdID = 0;
    this.mSvcRequestHead.iOffset = 0L;
    this.mSvcRequestHead.iPartDataLen = 0L;
    this.mSvcRequestHead.iFileLen = (this.mUploadFileInfoReqBytes.length + this.mFileLength);
    IActionRequest localIActionRequest = getControlRequest();
    if (localIActionRequest == null) {
      return false;
    }
    this.mContolPkgStartTime = System.currentTimeMillis();
    if (paramIUploadSession.send(localIActionRequest))
    {
      this.mState = 10;
      UploadLog.d("FlowWrapper", "sendControlPkg() " + localIActionRequest.toString() + " preupload:" + this.mSvcRequestHead.preupload);
      return true;
    }
    cancelActionForException(504, 0, true, true, "sendControlPkg() session send fail", null);
    return false;
  }
  
  private void sendFilePkg(IUploadSession paramIUploadSession)
  {
    IActionRequest localIActionRequest = getBodyRequest();
    if (localIActionRequest == null) {
      return;
    }
    if (paramIUploadSession.send(localIActionRequest))
    {
      if (this.mPartFileMode) {}
      for (int i = 20;; i = 30)
      {
        this.mState = i;
        UploadLog.d("FlowWrapper", "sendFilePkg() " + localIActionRequest.toString());
        return;
      }
    }
    cancelActionForException(504, 0, true, true, "sendFilePkg() session send fail", null);
  }
  
  protected final void cancelActionForException(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    UploadLog.w("FlowWrapper", "cancelActionForException() flowId=" + this.mAbstractUploadTask.flowId + " errorCode=" + paramInt1 + " errorMsg=" + paramString1 + " errorSubCode=" + paramInt2 + " path=" + this.mAbstractUploadTask.uploadFilePath);
    this.mState = 50;
    String str;
    if (paramString2 != null)
    {
      str = paramString2;
      if (paramString2.length() != 0) {}
    }
    else
    {
      str = "上传错误";
    }
    int i;
    if ((paramBoolean1) && (this.mAbstractUploadTask.preupload != 1) && (ConnectionImpl.isLibraryPrepared()))
    {
      paramString2 = paramString1;
      if (paramBoolean2) {
        paramString2 = Log.getStackTraceString(new Exception(paramString1));
      }
      if (paramInt2 != 0) {
        report(paramInt2, paramString2, this.mAbstractUploadTask);
      }
    }
    else
    {
      i = -1000;
      if (this.mUploadTaskCallback != null) {
        if ((-7 != paramInt1) && ((-4000 != paramInt1) || (paramInt2 != -400))) {
          break label265;
        }
      }
    }
    label265:
    for (paramInt2 = 2;; paramInt2 = 1)
    {
      if (!ConnectionImpl.isLibraryPrepared()) {
        str = "库加载失败，请尝试退出程序重启或重新安装";
      }
      this.mUploadTaskCallback.onUploadError(this.mAbstractUploadTask, paramInt1, str);
      UploadLog.d("FlowWrapper", "onUploadError");
      i = paramInt2;
      cancelTaskInner(this.mAbstractUploadTask.flowId, i, "cancelActionForException()");
      return;
      report(paramInt1, paramString2, this.mAbstractUploadTask);
      break;
    }
  }
  
  protected final SvcRequestHead createSvcRequestHead(AbstractUploadTask paramAbstractUploadTask)
  {
    SvcRequestHead localSvcRequestHead = new SvcRequestHead();
    localSvcRequestHead.iVersionId = 1;
    localSvcRequestHead.iUin = paramAbstractUploadTask.iUin;
    Object localObject;
    if (paramAbstractUploadTask.sRefer == null)
    {
      localObject = "";
      localSvcRequestHead.sRefer = ((String)localObject);
      localSvcRequestHead.iLoginType = paramAbstractUploadTask.iLoginType;
      if (paramAbstractUploadTask.vLoginData != null) {
        break label355;
      }
      localObject = new byte[0];
      label61:
      localSvcRequestHead.vLoginData = ((byte[])localObject);
      localSvcRequestHead.vLoginKey = paramAbstractUploadTask.vLoginKey;
      localSvcRequestHead.preupload = paramAbstractUploadTask.preupload;
      localObject = paramAbstractUploadTask.getUploadTaskType();
      localSvcRequestHead.iUploadType = ((IUploadTaskType)localObject).getProtocolUploadType();
      localSvcRequestHead.iFileType = ((IUploadTaskType)localObject).getProtocolFileType();
      localSvcRequestHead.iCmdID = 0;
      localObject = null;
      if (!TextUtils.isEmpty(paramAbstractUploadTask.uploadFilePath)) {
        localObject = new File(paramAbstractUploadTask.uploadFilePath);
      }
      if (localObject != null) {
        this.mFileLength = ((int)((File)localObject).length());
      }
      if ((localObject != null) && (this.mFileLength == 0)) {
        UploadLog.w("FlowWrapper", "createSvcRequestHead() mFileLength==0");
      }
      localObject = getMd5((File)localObject);
      localSvcRequestHead.md5type = ((FileUtils.UploaderMD5)localObject).getType();
      localSvcRequestHead.md5filelen = this.mFileLength;
      localSvcRequestHead.sFileMD5 = ((FileUtils.UploaderMD5)localObject).getValue();
      localSvcRequestHead.sDescMD5 = FileUtils.getMd5(this.mUploadFileInfoReqBytes);
      localSvcRequestHead.iFileLen = (this.mUploadFileInfoReqBytes.length + this.mFileLength);
      localSvcRequestHead.iOffset = 0L;
      localSvcRequestHead.iNetType = UploadConfiguration.getCurrentNetworkCategory();
      localSvcRequestHead.sOperator = UploadConfiguration.getProviderName();
      localSvcRequestHead.iSync = paramAbstractUploadTask.iSync;
      localSvcRequestHead.iSource = 1;
      if (this.mConfig != null) {
        break label363;
      }
      paramAbstractUploadTask = null;
      label281:
      localSvcRequestHead.sQua = paramAbstractUploadTask;
      if (this.mConfig != null) {
        localSvcRequestHead.sDeviceInfo = this.mConfig.getDeviceInfo();
      }
      localSvcRequestHead.iPartDataLen = 0L;
      localSvcRequestHead.seq = String.valueOf(this.mAbstractUploadTask.flowId);
      if (this.mConfig != null) {
        break label376;
      }
    }
    label355:
    label363:
    label376:
    for (int i = 0;; i = this.mConfig.getAppId())
    {
      localSvcRequestHead.appid = i;
      return localSvcRequestHead;
      localObject = paramAbstractUploadTask.sRefer;
      break;
      localObject = paramAbstractUploadTask.vLoginData;
      break label61;
      paramAbstractUploadTask = this.mConfig.getQUA3();
      break label281;
    }
  }
  
  public int getActionSequence()
  {
    return this.mAbstractUploadTask.flowId;
  }
  
  protected IActionRequest getBodyRequest()
  {
    Object localObject2 = null;
    if (!TextUtils.isEmpty(this.mAbstractUploadTask.uploadFilePath)) {
      localObject2 = new File(this.mAbstractUploadTask.uploadFilePath);
    }
    if ((localObject2 == null) || (this.mFileLength == 0))
    {
      cancelActionForException(-7, 0, true, true, "getBodyRequest() file !exist or length=0. path=" + this.mAbstractUploadTask.uploadFilePath, "文件不存在");
      return null;
    }
    int k = ProtocolUtil.nextRequestSequence();
    this.mSvcRequestHead.iCmdID = 1;
    this.mSvcRequestHead.iOffset = this.mSendDescFileOffset;
    this.mDescLength = this.mUploadFileInfoReqBytes.length;
    this.mSvcRequestHead.iFileLen = (this.mDescLength + this.mFileLength - this.mSendDescFileOffset);
    this.mSvcRequestHead.iDescLen = this.mDescLength;
    this.mSvcRequestHead.iPartDataLen = 0L;
    this.mSvcRequestHead.seq = ProtocolUtil.toProtocolSequence(this.mAbstractUploadTask.flowId, k);
    int i = 0;
    int j = 0;
    int m = UploadConfiguration.getVideoPartSizeByNetworkSetting();
    if (this.mDescLength > this.mSendDescFileOffset)
    {
      j = (int)this.mSendDescFileOffset;
      i = this.mDescLength - j;
      this.mSendFileOffset = 0L;
      if (this.mPartFileMode)
      {
        this.mSendDescFileLen = Math.min(m, this.mSvcRequestHead.iFileLen);
        this.mSendFileLen = (this.mSendDescFileLen - (this.mDescLength - this.mSendDescFileOffset));
      }
    }
    while (this.mPartFileMode)
    {
      this.mSvcRequestHead.iPartDataLen = this.mSendDescFileLen;
      if (this.mSendFileOffset != this.mFileLength) {
        break;
      }
      return null;
      this.mSendFileLen = this.mFileLength;
      continue;
      this.mSendFileOffset = (this.mSendDescFileOffset - this.mDescLength);
      if (this.mPartFileMode)
      {
        this.mSendDescFileLen = Math.min(m, this.mSvcRequestHead.iFileLen);
        this.mSendFileLen = this.mSendDescFileLen;
      }
      else
      {
        this.mSendFileLen = (this.mFileLength - this.mSendFileOffset);
      }
    }
    if ((this.mSendFileOffset < 0L) || (this.mSendFileOffset >= this.mFileLength))
    {
      cancelActionForException(501, 0, true, true, "not valid: mSendFileOffset=" + this.mSendFileOffset + " mFileLength=" + this.mFileLength, null);
      return null;
    }
    if ((this.mSendFileLen <= 0L) || (this.mSendFileOffset + this.mSendFileLen > this.mFileLength))
    {
      cancelActionForException(501, 0, true, true, "not valid: mSendFileLen=" + this.mSendFileLen + " mSendFileOffset=" + this.mSendFileOffset + " mFileLength=" + this.mFileLength, null);
      return null;
    }
    printSvcRequestHead(this.mSvcRequestHead);
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      byte[] arrayOfByte = ProtocolUtil.pack(this.mSvcRequestHead.getClass().getSimpleName(), this.mSvcRequestHead);
      localObject3 = arrayOfByte;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject1 = Log.getStackTraceString(localException);
        UploadLog.w("FlowWrapper", localException);
      }
      localObject1 = ByteBuffer.allocate(localObject3.length + i);
      ((ByteBuffer)localObject1).put(localObject3);
      ((ByteBuffer)localObject1).put(this.mUploadFileInfoReqBytes, j, i);
      UploadLog.v("FlowWrapper", "getBodyRequest() mSendDescFileOffset=" + this.mSendDescFileOffset + " descOffset=" + j + " descBufferSize=" + i + " mSendFileOffset=" + this.mSendFileOffset + " mSendFileLen=" + this.mSendFileLen + " mFileLength=" + this.mFileLength + " mSendDescFileLen=" + this.mSendDescFileLen + " mDescLength=" + this.mDescLength + " headLength=" + localObject3.length);
    }
    if (localObject3 == null)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "getBodyRequest() pack SvcRequestHead=null. " + this.mSvcRequestHead;
      }
      UploadLog.e("FlowWrapper", (String)localObject2);
      cancelActionForException(499, 0, true, true, (String)localObject2, null);
      return null;
    }
    return new UploadActionRequest(((ByteBuffer)localObject1).array(), (File)localObject2, this.mPartFileMode, (int)this.mSendFileOffset, (int)this.mSendFileLen, this.mAbstractUploadTask.flowId, this.mSvcRequestHead.iCmdID, k);
  }
  
  protected IActionRequest getControlRequest()
  {
    localObject4 = new FileUploadControlReq();
    ((FileUploadControlReq)localObject4).sData = getControlRequestData();
    localObject2 = null;
    localObject1 = null;
    try
    {
      byte[] arrayOfByte = ProtocolUtil.pack(localObject4.getClass().getSimpleName(), localObject4);
      localObject2 = arrayOfByte;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        localObject1 = Log.getStackTraceString(localException1);
        UploadLog.w("FlowWrapper", localException1);
      }
      this.mSvcRequestHead.iDescLen = localObject2.length;
      int i = ProtocolUtil.nextRequestSequence();
      this.mSvcRequestHead.seq = ProtocolUtil.toProtocolSequence(this.mAbstractUploadTask.flowId, i);
      Object localObject3 = null;
      localObject1 = null;
      try
      {
        localObject4 = ProtocolUtil.pack(this.mSvcRequestHead.getClass().getSimpleName(), this.mSvcRequestHead);
        localObject3 = localObject4;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localObject1 = Log.getStackTraceString(localException2);
          UploadLog.w("FlowWrapper", localException2);
        }
        localObject1 = ByteBuffer.allocate(localObject3.length + localObject2.length);
        ((ByteBuffer)localObject1).put(localObject3);
        ((ByteBuffer)localObject1).put((byte[])localObject2);
      }
      printSvcRequestHead(this.mSvcRequestHead);
      if (localObject3 != null) {
        break label231;
      }
      localObject2 = localObject1;
      if (localObject1 != null) {
        break label199;
      }
      localObject2 = "getControlRequest() pack SvcRequestHead=null. " + this.mSvcRequestHead;
      cancelActionForException(499, 0, true, true, (String)localObject2, null);
      return null;
      return new UploadActionRequest(((ByteBuffer)localObject1).array(), null, this.mPartFileMode, 0, 0, this.mAbstractUploadTask.flowId, 0, i);
    }
    if (localObject2 == null)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "getControlRequest() pack fileUploadControlReq=null. " + localObject4;
      }
      cancelActionForException(499, 0, true, true, (String)localObject2, null);
      return null;
    }
  }
  
  protected byte[] getControlRequestData()
  {
    return new byte[0];
  }
  
  protected FileUtils.UploaderMD5 getMd5(File paramFile)
  {
    return FileUtils.getMd5ByFile_FAKE(paramFile);
  }
  
  public int getSendState()
  {
    switch (this.mState)
    {
    default: 
      UploadLog.e("FlowWrapper", "getSendState() state error");
    case 40: 
    case 50: 
      return 3;
    case 0: 
      return 0;
    case 10: 
    case 20: 
    case 30: 
      return 1;
    }
    return 2;
  }
  
  public final int getServerCategory()
  {
    return this.mAbstractUploadTask.getUploadTaskType().getServerCategory();
  }
  
  public void onCancel(int paramInt)
  {
    boolean bool2 = true;
    UploadLog.i("FlowWrapper", "onCancel() actionId=" + this.mAbstractUploadTask.flowId + " mState=" + this.mState + "cancelState:" + paramInt);
    int i = -1000;
    switch (paramInt)
    {
    default: 
      i = -1000;
    }
    for (;;)
    {
      if ((i != -1000) && (this.mUploadTaskCallback != null))
      {
        this.mUploadTaskCallback.onUploadStateChange(this.mAbstractUploadTask, i);
        UploadLog.d("FlowWrapper", "onUploadStateChange=" + i);
      }
      if (paramInt == 3)
      {
        String str = "user cancel task, RetryControlCount:" + this.mRetryControlCount + " RetryPartFileCount:" + this.mRetryPartFileCount;
        if ((this.mAbstractUploadTask.preupload != 1) && (getSendState() != 0))
        {
          UploadLog.i("FlowWrapper", "report -20," + str);
          report(-20, str, this.mAbstractUploadTask);
        }
      }
      this.mState = 50;
      boolean bool1 = bool2;
      if (paramInt != 0)
      {
        bool1 = bool2;
        if (paramInt != 3) {
          bool1 = false;
        }
      }
      onDestroy(bool1);
      return;
      i = 2;
      continue;
      i = 5;
      continue;
      i = 5;
      continue;
      i = 2;
    }
  }
  
  public void onConnecting()
  {
    this.mUploadTaskCallback.onUploadStateChange(this.mAbstractUploadTask, 4);
    UploadLog.v("FlowWrapper", "onUploadStateChange=4");
  }
  
  protected void onDestroy(boolean paramBoolean) {}
  
  public void onError(IUploadSession paramIUploadSession, int paramInt, String paramString, boolean paramBoolean)
  {
    paramIUploadSession = null;
    int i;
    switch (paramInt)
    {
    default: 
      i = paramInt;
      boolean bool = IUploadAction.SessionError.isRetryable(paramInt);
      paramString = "onError() actionId=" + this.mAbstractUploadTask.flowId + " isRetryable=" + bool + " sessionError=" + paramInt + " description=" + paramString + " causedByNoNetwork:" + paramBoolean;
      if (paramBoolean) {
        i = 35000;
      }
      if ((i == 35000) && (this.mRetryControlCount > 0)) {
        this.mRetryControlCount -= 1;
      }
      if (this.mAbstractUploadTask.preupload == 1)
      {
        paramInt = 1;
        label215:
        if ((paramBoolean) || (paramInt == 0)) {
          break label371;
        }
        paramBoolean = false;
        label227:
        if ((this.mRetryControlCount <= UploadConfiguration.getVideoFileRetryCount()) && (bool) && (paramInt == 0)) {
          break label377;
        }
        cancelActionForException(i, 0, paramBoolean, true, paramString, paramIUploadSession);
      }
      break;
    }
    label371:
    label377:
    while (!paramBoolean)
    {
      return;
      i = -18;
      paramIUploadSession = "连接服务器失败";
      break;
      i = -7;
      paramIUploadSession = "文件不存在.";
      break;
      i = -15;
      paramIUploadSession = "读取本地数据异常";
      break;
      i = -8;
      paramIUploadSession = "解析服务器回应数据失败";
      break;
      i = -4;
      paramIUploadSession = "服务器回应数据超时";
      break;
      i = -60;
      paramIUploadSession = "服务器断开";
      break;
      paramIUploadSession = "发送数据超时";
      i = -11;
      break;
      paramIUploadSession = "网络不可用";
      i = paramInt;
      break;
      paramIUploadSession = "上传压缩文件不存在";
      i = paramInt;
      break;
      paramIUploadSession = "上传文件被删除或不存在";
      i = paramInt;
      break;
      paramInt = 0;
      break label215;
      paramBoolean = true;
      break label227;
    }
    report(i, paramString, this.mAbstractUploadTask);
  }
  
  public void onRequest(IUploadSession paramIUploadSession, IActionRequest paramIActionRequest)
  {
    UploadLog.d("FlowWrapper", "onRequest() actionId=" + paramIActionRequest.getActionSequence() + " commandId=" + paramIActionRequest.getCommandId());
    if ((30 == this.mState) && (paramIActionRequest.getCommandId() == 1)) {
      this.mState = 35;
    }
  }
  
  public void onResponse(IUploadSession paramIUploadSession, ActionResponse paramActionResponse)
  {
    UploadLog.v("FlowWrapper", "onResponse() actionId=" + this.mAbstractUploadTask.flowId + " mState=" + this.mState);
    if ((paramIUploadSession == null) || (paramActionResponse == null))
    {
      cancelActionForException(503, 0, false, true, "onResponse() null param. state=" + this.mState, null);
      return;
    }
    if ((this.mState == 40) || (this.mState == 50) || (this.mState == 0))
    {
      cancelActionForException(503, 0, false, true, "onResponse() error state=" + this.mState, null);
      return;
    }
    paramActionResponse = paramActionResponse.getReponsePacket();
    if (paramActionResponse == null)
    {
      cancelActionForException(500, 0, true, true, "SvcResponsePacket==null", null);
      return;
    }
    if (paramActionResponse.iRetCode < 0) {
      UploadLog.d("FlowWrapper", "ret: " + paramActionResponse.iRetCode + " " + paramActionResponse.iRetSubCode + " des:" + paramActionResponse.sResultDes + " flow:" + paramActionResponse.seq + " desMd5:" + paramActionResponse.sDescMD5 + " fileMd5:" + paramActionResponse.sFileMD5);
    }
    if (paramActionResponse.iRetCode == 0)
    {
      processSvcResponsePacket(paramIUploadSession, paramActionResponse);
      return;
    }
    if ((paramActionResponse.iRetCode == -3000) || ((paramActionResponse.iRetCode <= -300) && (paramActionResponse.iRetCode >= -399)))
    {
      reSend(paramIUploadSession, -3000, paramActionResponse.iRetSubCode, "iRetSubCode=" + paramActionResponse.iRetSubCode + " sResultDes=" + paramActionResponse.sResultDes, paramActionResponse.sResultDes);
      return;
    }
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramActionResponse.iRetCode == -1000) {
      switch (paramActionResponse.iRetSubCode)
      {
      }
    }
    for (bool1 = bool2;; bool1 = false)
    {
      cancelActionForException(paramActionResponse.iRetCode, paramActionResponse.iRetSubCode, bool1, true, "iRetSubCode=" + paramActionResponse.iRetSubCode + " sResultDes=" + paramActionResponse.sResultDes, paramActionResponse.sResultDes);
      return;
    }
  }
  
  public boolean onSend(IUploadSession paramIUploadSession)
  {
    if (paramIUploadSession == null)
    {
      UploadLog.e("FlowWrapper", "onSend() session==null");
      return false;
    }
    UploadLog.i("FlowWrapper", "onSend() uin=" + this.mAbstractUploadTask.iUin + " flowId=" + this.mAbstractUploadTask.flowId);
    this.mUploadRoute = paramIUploadSession.getUploadRoute();
    this.mConnectedIp = paramIUploadSession.getConnectedIp();
    this.mClientIp = paramIUploadSession.getClientIp();
    if (this.mUploadRoute == null)
    {
      UploadLog.e("FlowWrapper", "onSend() 在session里获取不到UploadRoute");
      return false;
    }
    UploadLog.i("FlowWrapper", "mUploadRoute=" + this.mUploadRoute.toString());
    if (this.mUploadRoute.getProtocol() == 2) {
      this.mPartFileMode = true;
    }
    for (this.mSvcRequestHead.httpRspProcess = 0;; this.mSvcRequestHead.httpRspProcess = 1)
    {
      this.mState = 0;
      this.reSendCount = 0;
      this.mRetryControlCount += 1;
      return sendFirstPkg(paramIUploadSession);
      this.mPartFileMode = false;
    }
  }
  
  public void onTimeout(IUploadSession paramIUploadSession, IActionRequest paramIActionRequest)
  {
    if (!this.mPartFileMode) {
      return;
    }
    String str = "onTimeout(). actionId=" + paramIActionRequest.getActionSequence() + " mPartFileMode=" + this.mPartFileMode + " mState=" + this.mState + " mRetryControlCount=" + this.mRetryControlCount + " mRetryPartFileCount=" + this.mRetryPartFileCount + " path=" + this.mAbstractUploadTask.uploadFilePath + " cmdId=" + paramIActionRequest.getCommandId() + " iFileOffset=" + paramIActionRequest.getFileOffset();
    switch (this.mState)
    {
    default: 
    case 10: 
      do
      {
        cancelActionForException(-4, 0, true, true, str, null);
        return;
      } while (this.mRetryControlCount > UploadConfiguration.getVideoFileRetryCount());
      this.mRetryControlCount += 1;
      if (paramIUploadSession.send(paramIActionRequest))
      {
        UploadLog.d("FlowWrapper", "onTimeout() send control " + paramIActionRequest.toString());
        return;
      }
      cancelActionForException(504, 0, true, true, "onTimeout() send control fail", null);
      return;
    }
    if (this.mRetryPartFileCount <= this.mConfig.getVideoPartRetryCount())
    {
      this.mRetryPartFileCount += 1;
      if (paramIUploadSession.send(paramIActionRequest))
      {
        UploadLog.d("FlowWrapper", "onTimeout() send file " + paramIActionRequest.toString());
        return;
      }
      cancelActionForException(504, 0, true, true, "onTimeout() send file fail", null);
      return;
    }
    this.mRetryControlCount += 1;
    boolean bool = sendFirstPkg(paramIUploadSession);
    UploadLog.d("FlowWrapper", "onTimeout() send control2 " + paramIActionRequest.toString() + " ret:" + bool);
  }
  
  protected void processFileUploadFinishRsp(byte[] paramArrayOfByte)
  {
    this.mState = 40;
    report(0, null, this.mAbstractUploadTask);
    cancelTaskInner(this.mAbstractUploadTask.flowId, 0, "processFileUploadFinishRsp");
  }
  
  protected void processSvcResponsePacket(IUploadSession paramIUploadSession, SvcResponsePacket paramSvcResponsePacket)
  {
    Object localObject;
    String str;
    boolean bool;
    switch (paramSvcResponsePacket.iCmdID)
    {
    default: 
      cancelActionForException(502, 0, true, true, "svcResponsePacket.iCmdID=" + paramSvcResponsePacket.iCmdID, null);
      return;
    case 0: 
      this.mContolPkgEndTime = System.currentTimeMillis();
      printSvcResponsePacket(paramSvcResponsePacket);
      localObject = null;
      str = null;
      try
      {
        FileUploadControlRsp localFileUploadControlRsp = (FileUploadControlRsp)ProtocolUtil.unpack(FileUploadControlRsp.class.getSimpleName(), paramSvcResponsePacket.vRspData);
        localObject = localFileUploadControlRsp;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          str = Log.getStackTraceString(localException1);
          UploadLog.w("FlowWrapper", localException1);
        }
        processFileUploadControlRsp(paramIUploadSession, localObject);
        return;
      }
      if (localObject == null)
      {
        bool = false;
        paramIUploadSession = str;
        if (str == null)
        {
          paramIUploadSession = "processFileUploadFinishRsp() unpack FileUploadControlRsp=null. " + paramSvcResponsePacket.vRspData;
          bool = true;
        }
        cancelActionForException(500, 0, true, bool, paramIUploadSession, null);
        return;
      }
    case 2: 
      localObject = null;
      str = null;
      try
      {
        FileUploadProgressRsp localFileUploadProgressRsp = (FileUploadProgressRsp)ProtocolUtil.unpack(FileUploadProgressRsp.class.getSimpleName(), paramSvcResponsePacket.vRspData);
        localObject = localFileUploadProgressRsp;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          str = Log.getStackTraceString(localException2);
          UploadLog.w("FlowWrapper", localException2);
        }
        processFileUploadProgressRsp(paramIUploadSession, localObject);
        return;
      }
      if (localObject == null)
      {
        bool = false;
        paramIUploadSession = str;
        if (str == null)
        {
          paramIUploadSession = "processFileUploadFinishRsp() unpack FileUploadProgressRsp=null. " + paramSvcResponsePacket.vRspData;
          bool = true;
        }
        cancelActionForException(500, 0, true, bool, paramIUploadSession, null);
        return;
      }
    case 1: 
      printSvcResponsePacket(paramSvcResponsePacket);
      processFileUploadFinishRsp(paramSvcResponsePacket.vRspData);
      return;
    }
    this.mSendDescFileOffset += this.mSendDescFileLen;
    this.mPartFileProgress += this.mSendDescFileLen;
    long l2 = this.mPartFileProgress - this.mDescLength;
    long l1 = l2;
    if (l2 > this.mFileLength) {
      l1 = this.mFileLength;
    }
    this.mProgressTotalLen = this.mFileLength;
    this.mProgressRecvDataLen = l1;
    this.mUploadTaskCallback.onUploadProgress(this.mAbstractUploadTask, this.mProgressTotalLen, this.mProgressRecvDataLen);
    paramSvcResponsePacket = this.mAbstractUploadTask.progressListener;
    if (paramSvcResponsePacket != null) {
      paramSvcResponsePacket.onProgress(this.mAbstractUploadTask, this.mProgressTotalLen, this.mProgressRecvDataLen);
    }
    this.mRetryControlCount = 0;
    this.mRetryPartFileCount = 0;
    UploadLog.v("FlowWrapper", "_CMD_PART mSendDescFileOffset=" + this.mSendDescFileOffset + " mSendDescFileLen=" + this.mSendDescFileLen + " progress=" + (this.mSendDescFileOffset - this.mDescLength) + "/" + this.mFileLength + " taskId=" + this.mAbstractUploadTask.flowId);
    sendFilePkg(paramIUploadSession);
  }
  
  protected final void report(int paramInt, String paramString, AbstractUploadTask paramAbstractUploadTask)
  {
    UploadLog.d("FlowWrapper", "report() errorCode=" + paramInt + " flow:" + paramAbstractUploadTask.flowId + " errorMsg=" + paramString + " retry=" + (this.mRetryPartFileCount + this.mRetryControlCount));
    if (paramInt == -60) {
      return;
    }
    Report localReport = new Report();
    localReport.source = Const.getVideoSource(paramAbstractUploadTask);
    localReport.retCode = paramInt;
    localReport.errMsg = paramString;
    localReport.refer = paramAbstractUploadTask.reportRefer;
    if (paramInt != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder(50);
      localStringBuilder.append(paramString);
      localStringBuilder.append(" || ");
      localStringBuilder.append(" clientIp=");
      if (this.mClientIp == null)
      {
        paramString = "";
        localStringBuilder.append(paramString);
        localStringBuilder.append(" mState=");
        localStringBuilder.append(this.mState);
        localStringBuilder.append(" mPartFileMode=");
        localStringBuilder.append(this.mPartFileMode);
        localStringBuilder.append(" mProgressTotalLen=");
        localStringBuilder.append(this.mProgressTotalLen);
        localStringBuilder.append(" mProgressRecvDataLen=");
        localStringBuilder.append(this.mProgressRecvDataLen);
        localStringBuilder.append(" || ");
        localStringBuilder.append(this.mReportAppendMsg);
        this.mReportAppendMsg = null;
        if ((paramInt == -7) || (paramInt == -15) || (paramInt == 30700) || (paramInt == 31500))
        {
          boolean bool = Environment.getExternalStorageState().equals("mounted");
          long l = FileUtils.getSdCardAvailableSize();
          paramString = this.mConfig.getDeviceInfo();
          localStringBuilder.append(" || ");
          localStringBuilder.append(" sdExsit=");
          localStringBuilder.append(bool);
          localStringBuilder.append(" sdCardAvailableSize=");
          localStringBuilder.append(l);
          localStringBuilder.append("M deviceInfo=");
          localStringBuilder.append(paramString);
        }
        localStringBuilder.append(" || ");
        localStringBuilder.append("contolPackTimeCost=");
        localStringBuilder.append(this.mContolPkgEndTime - this.mContolPkgStartTime);
        localReport.errMsg = localStringBuilder.toString();
      }
    }
    else
    {
      localReport.flowId = paramAbstractUploadTask.flowId;
      localReport.filePath = paramAbstractUploadTask.uploadFilePath;
      localReport.uploadType = paramAbstractUploadTask.getUploadTaskType();
      localReport.fileSize = this.mFileLength;
      if (this.mStartTime != 0L)
      {
        localReport.startTime = this.mStartTime;
        localReport.endTime = System.currentTimeMillis();
      }
      if (this.mUploadRoute != null) {
        break label630;
      }
      paramString = "";
      label492:
      localReport.serverIp = paramString;
      if (!StringUtils.isIpv4String(localReport.serverIp)) {
        localReport.serverIp = this.mConnectedIp;
      }
      if (TextUtils.isEmpty(localReport.serverIp)) {
        localReport.serverIp = "ip is null";
      }
      if (this.mUploadRoute != null) {
        break label641;
      }
    }
    label641:
    for (int i = 0;; i = this.mUploadRoute.getRouteCategory())
    {
      localReport.ipsrctype = i;
      localReport.networkType = UploadConfiguration.getCurrentNetworkCategory();
      if (!isNetworkRelevant(paramInt)) {
        localReport.networkType = 0;
      }
      localReport.retry = (this.mRetryPartFileCount + this.mRetryControlCount);
      localReport.uppAppId = Const.getUppAppId(paramAbstractUploadTask);
      localReport.transfer = this.mAbstractUploadTask.transferData;
      UploadGlobalConfig.getUploadReport().onUploadReport(localReport);
      return;
      paramString = this.mClientIp;
      break;
      label630:
      paramString = this.mUploadRoute.getIp();
      break label492;
    }
  }
  
  protected boolean sendFirstPkg(IUploadSession paramIUploadSession)
  {
    return sendControlPkg(paramIUploadSession);
  }
  
  public final void setReportAppendMsg(String paramString)
  {
    this.mReportAppendMsg = paramString;
  }
  
  public void setSessionService(IUploadSessionService paramIUploadSessionService)
  {
    this.mSessionServiceRef = new WeakReference(paramIUploadSessionService);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.upload.biz.UploadActionFlowWrapper
 * JD-Core Version:    0.7.0.1
 */