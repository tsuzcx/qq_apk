package com.tencent.upload.uinterface.action;

import FileUpload.UploadUppInfoV2Req;
import FileUpload.UploadUppInfoV2Rsp;
import FileUpload.stPhotoSepcInfo;
import android.util.Log;
import com.tencent.imageservice.ImageProcessUtil;
import com.tencent.upload.biz.UploadActionFlowWrapper;
import com.tencent.upload.common.FileUtils.UploaderMD5;
import com.tencent.upload.common.StringUtils;
import com.tencent.upload.common.UploadLog;
import com.tencent.upload.protocol.utils.ProtocolUtil;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.data.QunUppUploadResult;
import com.tencent.upload.uinterface.data.QunUppUploadTask;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class QunUppUploadAction
  extends UploadActionFlowWrapper
{
  boolean mDeleteFileAfterUpload;
  
  public QunUppUploadAction(QunUppUploadTask paramQunUppUploadTask, boolean paramBoolean)
    throws Exception
  {
    super(paramQunUppUploadTask);
    UploadUppInfoV2Req localUploadUppInfoV2Req = getDescriptionObject(paramQunUppUploadTask);
    this.mDeleteFileAfterUpload = paramBoolean;
    Object localObject = null;
    try
    {
      this.mUploadFileInfoReqBytes = ProtocolUtil.pack(localUploadUppInfoV2Req.getClass().getSimpleName(), localUploadUppInfoV2Req);
      if (this.mUploadFileInfoReqBytes == null)
      {
        paramQunUppUploadTask = localObject;
        if (localObject == null) {
          paramQunUppUploadTask = new Exception("ImageUploadAction() pack mUploadUppInfoReq=null. " + localUploadUppInfoV2Req);
        }
        throw paramQunUppUploadTask;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject = localException;
        UploadLog.w("FlowWrapper", localException);
      }
      this.mSvcRequestHead = createSvcRequestHead(paramQunUppUploadTask);
    }
  }
  
  private final UploadUppInfoV2Req getDescriptionObject(QunUppUploadTask paramQunUppUploadTask)
  {
    UploadUppInfoV2Req localUploadUppInfoV2Req = new UploadUppInfoV2Req();
    localUploadUppInfoV2Req.sAppId = "qun";
    localUploadUppInfoV2Req.sUserId = paramQunUppUploadTask.userId;
    localUploadUppInfoV2Req.sAlbumId = paramQunUppUploadTask.albumId;
    localUploadUppInfoV2Req.sTitle = paramQunUppUploadTask.title;
    localUploadUppInfoV2Req.sDesc = paramQunUppUploadTask.desc;
    localUploadUppInfoV2Req.sPicPath = paramQunUppUploadTask.uploadFilePath;
    localUploadUppInfoV2Req.iType = 0;
    localUploadUppInfoV2Req.iUploadIp = 1L;
    localUploadUppInfoV2Req.iBatchID = paramQunUppUploadTask.batchId;
    Object localObject = new stPhotoSepcInfo();
    File localFile = new File(paramQunUppUploadTask.uploadFilePath);
    ((stPhotoSepcInfo)localObject).iPhotoSize = localFile.length();
    IUploadConfig.UploadImageSize localUploadImageSize = ImageProcessUtil.decodeBitmapSize(paramQunUppUploadTask.uploadFilePath);
    ((stPhotoSepcInfo)localObject).iPhotoWidth = localUploadImageSize.width;
    ((stPhotoSepcInfo)localObject).iPhotoHeight = localUploadImageSize.height;
    ((stPhotoSepcInfo)localObject).iPhotoType = paramQunUppUploadTask.photoType;
    localUploadUppInfoV2Req.PhotoSpecInfo = ((stPhotoSepcInfo)localObject);
    localUploadUppInfoV2Req.mutlipicinfo = paramQunUppUploadTask.mutipic;
    localObject = new HashMap();
    ((Map)localObject).put("sFileMD5", getMd5(localFile).getValue());
    ((Map)localObject).put("sFirm", paramQunUppUploadTask.deviceInfo);
    ((Map)localObject).put("dLongitude", paramQunUppUploadTask.poiX);
    ((Map)localObject).put("dLatitude", paramQunUppUploadTask.poiY);
    ((Map)localObject).put("sPOIName", paramQunUppUploadTask.poiName);
    ((Map)localObject).put("sPOIType", Integer.toString(paramQunUppUploadTask.poiType));
    ((Map)localObject).put("mobile_fakefeeds_clientkey", StringUtils.getEmptyString(paramQunUppUploadTask.clientFakeKey));
    ((Map)localObject).put("a2", StringUtils.getEmptyString(paramQunUppUploadTask.A2));
    localUploadUppInfoV2Req.mapExt = ((Map)localObject);
    return localUploadUppInfoV2Req;
  }
  
  protected byte[] getControlRequestData()
  {
    try
    {
      Object localObject = (QunUppUploadTask)this.mAbstractUploadTask;
      localObject = ProtocolUtil.pack(localObject.getClass().getSimpleName(), localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      UploadLog.w("FlowWrapper", localException);
    }
    return super.getControlRequestData();
  }
  
  protected void processFileUploadFinishRsp(byte[] paramArrayOfByte)
  {
    Object localObject1 = null;
    try
    {
      localObject2 = (UploadUppInfoV2Rsp)ProtocolUtil.unpack(UploadUppInfoV2Rsp.class.getSimpleName(), paramArrayOfByte);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        Log.getStackTraceString(localException);
        UploadLog.w("FlowWrapper", localException);
        continue;
        this.mUploadTaskCallback.onUploadSucceed(this.mAbstractUploadTask, null);
      }
    }
    if ((this.mUploadTaskCallback != null) && (localObject1 != null))
    {
      localObject2 = new QunUppUploadResult();
      ((QunUppUploadResult)localObject2).flowId = this.mAbstractUploadTask.flowId;
      ((QunUppUploadResult)localObject2).url = localObject1.sUrl;
      ((QunUppUploadResult)localObject2).photoId = localObject1.sPhotoId;
      ((QunUppUploadResult)localObject2).mapSpecInfo = localObject1.mapSpecInfo;
      this.mUploadTaskCallback.onUploadSucceed(this.mAbstractUploadTask, localObject2);
      super.processFileUploadFinishRsp(paramArrayOfByte);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.upload.uinterface.action.QunUppUploadAction
 * JD-Core Version:    0.7.0.1
 */