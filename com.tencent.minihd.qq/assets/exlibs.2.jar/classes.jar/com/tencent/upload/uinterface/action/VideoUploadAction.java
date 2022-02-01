package com.tencent.upload.uinterface.action;

import FileUpload.UploadVideoInfoReq;
import FileUpload.UploadVideoInfoRsp;
import android.util.Log;
import com.tencent.upload.biz.UploadActionFlowWrapper;
import com.tencent.upload.common.FileUtils;
import com.tencent.upload.common.UploadLog;
import com.tencent.upload.protocol.utils.ProtocolUtil;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.data.VideoUploadResult;
import com.tencent.upload.uinterface.data.VideoUploadTask;

public class VideoUploadAction
  extends UploadActionFlowWrapper
{
  public VideoUploadAction(VideoUploadTask paramVideoUploadTask)
    throws Exception
  {
    super(paramVideoUploadTask);
    UploadVideoInfoReq localUploadVideoInfoReq = createUploadVideoInfoReq(paramVideoUploadTask);
    printUploadVideoInfoReq(localUploadVideoInfoReq);
    Object localObject = null;
    try
    {
      this.mUploadFileInfoReqBytes = ProtocolUtil.pack(localUploadVideoInfoReq.getClass().getSimpleName(), localUploadVideoInfoReq);
      if (this.mUploadFileInfoReqBytes == null)
      {
        paramVideoUploadTask = localObject;
        if (localObject == null) {
          paramVideoUploadTask = new Exception("ImageUploadAction() pack UploadVideoInfoReq=null. " + localUploadVideoInfoReq);
        }
        throw paramVideoUploadTask;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject = localException;
        UploadLog.w("FlowWrapper", localException);
      }
      this.mSvcRequestHead = createSvcRequestHead(paramVideoUploadTask);
    }
  }
  
  private static UploadVideoInfoReq createUploadVideoInfoReq(VideoUploadTask paramVideoUploadTask)
  {
    UploadVideoInfoReq localUploadVideoInfoReq = new UploadVideoInfoReq();
    localUploadVideoInfoReq.sTitle = paramVideoUploadTask.sTitle;
    localUploadVideoInfoReq.sDesc = paramVideoUploadTask.sDesc;
    localUploadVideoInfoReq.iFlag = paramVideoUploadTask.iFlag;
    localUploadVideoInfoReq.iIsNew = paramVideoUploadTask.iIsNew;
    localUploadVideoInfoReq.iUploadTime = paramVideoUploadTask.iUploadTime;
    localUploadVideoInfoReq.sCoverUrl = paramVideoUploadTask.sCoverUrl;
    localUploadVideoInfoReq.iPlayTime = paramVideoUploadTask.iPlayTime;
    if (paramVideoUploadTask.vBusiNessData == null) {}
    for (byte[] arrayOfByte = new byte[0];; arrayOfByte = paramVideoUploadTask.vBusiNessData)
    {
      localUploadVideoInfoReq.vBusiNessData = arrayOfByte;
      localUploadVideoInfoReq.iBusiNessType = paramVideoUploadTask.iBusiNessType;
      return localUploadVideoInfoReq;
    }
  }
  
  private static final void printUploadVideoInfoReq(UploadVideoInfoReq paramUploadVideoInfoReq)
  {
    UploadLog.d("FlowWrapper", "UploadVideoInfoReq [sTitle=" + paramUploadVideoInfoReq.sTitle + ", sDesc=" + paramUploadVideoInfoReq.sDesc + ", iFlag=" + paramUploadVideoInfoReq.iFlag + ", iUploadTime=" + paramUploadVideoInfoReq.iUploadTime + "]");
  }
  
  private static final void printUploadVideoInfoRsp(UploadVideoInfoRsp paramUploadVideoInfoRsp)
  {
    UploadLog.d("FlowWrapper", "UploadVideoInfoRsp [sVid=" + paramUploadVideoInfoRsp.sVid + "]");
  }
  
  protected void onDestroy(boolean paramBoolean)
  {
    if (paramBoolean) {
      FileUtils.deleteTempFile(this.mAbstractUploadTask.uploadFilePath);
    }
  }
  
  protected void processFileUploadFinishRsp(byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      UploadVideoInfoRsp localUploadVideoInfoRsp = (UploadVideoInfoRsp)ProtocolUtil.unpack(UploadVideoInfoRsp.class.getSimpleName(), paramArrayOfByte);
      localObject2 = localUploadVideoInfoRsp;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool;
        localObject1 = Log.getStackTraceString(localException);
        UploadLog.w("FlowWrapper", localException);
      }
      printUploadVideoInfoRsp((UploadVideoInfoRsp)localObject2);
      if (this.mUploadTaskCallback == null) {
        break label161;
      }
      localObject1 = new VideoUploadResult();
      ((VideoUploadResult)localObject1).flowId = this.mAbstractUploadTask.flowId;
      ((VideoUploadResult)localObject1).sVid = ((UploadVideoInfoRsp)localObject2).sVid;
      ((VideoUploadResult)localObject1).iBusiNessType = ((UploadVideoInfoRsp)localObject2).iBusiNessType;
      ((VideoUploadResult)localObject1).vBusiNessData = ((UploadVideoInfoRsp)localObject2).vBusiNessData;
      this.mUploadTaskCallback.onUploadSucceed(this.mAbstractUploadTask, localObject1);
      label161:
      super.processFileUploadFinishRsp(paramArrayOfByte);
    }
    if (localObject2 == null)
    {
      bool = false;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = "processFileUploadFinishRsp() unpack UploadVideoInfoRsp=null. " + paramArrayOfByte;
        bool = true;
      }
      cancelActionForException(500, 0, true, bool, (String)localObject2, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.upload.uinterface.action.VideoUploadAction
 * JD-Core Version:    0.7.0.1
 */