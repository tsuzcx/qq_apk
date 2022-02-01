package com.tencent.upload.uinterface.action;

import FileUpload.UploadUppInfoReq;
import FileUpload.UploadUppInfoRsp;
import android.util.Log;
import com.tencent.upload.biz.UploadActionFlowWrapper;
import com.tencent.upload.common.FileUtils;
import com.tencent.upload.common.UploadLog;
import com.tencent.upload.protocol.utils.ProtocolUtil;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.data.UppUploadResult;
import com.tencent.upload.uinterface.data.UppUploadTask;

public class UppUploadAction
  extends UploadActionFlowWrapper
{
  private boolean mDeleteFileAfterUpload;
  
  public UppUploadAction(UppUploadTask paramUppUploadTask, boolean paramBoolean)
    throws Exception
  {
    super(paramUppUploadTask);
    this.mDeleteFileAfterUpload = paramBoolean;
    UploadUppInfoReq localUploadUppInfoReq = createUploadUppInfoReq();
    printUploadUppInfoReq(localUploadUppInfoReq);
    Object localObject = null;
    try
    {
      this.mUploadFileInfoReqBytes = ProtocolUtil.pack(localUploadUppInfoReq.getClass().getSimpleName(), localUploadUppInfoReq);
      if (this.mUploadFileInfoReqBytes == null)
      {
        paramUppUploadTask = localObject;
        if (localObject == null) {
          paramUppUploadTask = new Exception("ImageUploadAction() pack UploadUppInfoReq=null. " + localUploadUppInfoReq);
        }
        throw paramUppUploadTask;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject = localException;
        UploadLog.w("FlowWrapper", localException);
      }
      this.mSvcRequestHead = createSvcRequestHead(paramUppUploadTask);
    }
  }
  
  private static UploadUppInfoReq createUploadUppInfoReq()
  {
    UploadUppInfoReq localUploadUppInfoReq = new UploadUppInfoReq();
    localUploadUppInfoReq.appid = "diy";
    return localUploadUppInfoReq;
  }
  
  private static final void printUploadUppInfoReq(UploadUppInfoReq paramUploadUppInfoReq)
  {
    UploadLog.d("FlowWrapper", "UploadUppInfoReq [appid=" + paramUploadUppInfoReq.appid + "]");
  }
  
  private static final void printUploadUppInfoRsp(UploadUppInfoRsp paramUploadUppInfoRsp)
  {
    UploadLog.v("FlowWrapper", "UploadUppInfoRsp [sUrl=" + paramUploadUppInfoRsp.sUrl + "]");
  }
  
  protected void onDestroy(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.mDeleteFileAfterUpload)) {
      FileUtils.deleteTempFile(this.mAbstractUploadTask.uploadFilePath);
    }
  }
  
  protected void processFileUploadFinishRsp(byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      UploadUppInfoRsp localUploadUppInfoRsp = (UploadUppInfoRsp)ProtocolUtil.unpack(UploadUppInfoRsp.class.getSimpleName(), paramArrayOfByte);
      localObject2 = localUploadUppInfoRsp;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool;
        localObject1 = Log.getStackTraceString(localException);
        UploadLog.w("FlowWrapper", localException);
      }
      printUploadUppInfoRsp((UploadUppInfoRsp)localObject2);
      if (this.mUploadTaskCallback == null) {
        break label143;
      }
      localObject1 = new UppUploadResult();
      ((UppUploadResult)localObject1).flowId = this.mAbstractUploadTask.flowId;
      ((UppUploadResult)localObject1).sUrl = ((UploadUppInfoRsp)localObject2).sUrl;
      this.mUploadTaskCallback.onUploadSucceed(this.mAbstractUploadTask, localObject1);
      label143:
      super.processFileUploadFinishRsp(paramArrayOfByte);
    }
    if (localObject2 == null)
    {
      bool = false;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = "processFileUploadFinishRsp() unpack UploadUppInfoRsp=null. " + paramArrayOfByte;
        bool = true;
      }
      cancelActionForException(500, 0, true, bool, (String)localObject2, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.upload.uinterface.action.UppUploadAction
 * JD-Core Version:    0.7.0.1
 */