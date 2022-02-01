package com.tencent.upload.uinterface.action;

import FileUpload.HeadDesc;
import FileUpload.PicExtendInfo;
import FileUpload.PicUploadControlInfo;
import FileUpload.UploadPicInfoReq;
import FileUpload.UploadPicInfoRsp;
import FileUpload.stWaterTemplate;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.imageservice.ImageProcessUtil;
import com.tencent.upload.biz.UploadActionFlowWrapper;
import com.tencent.upload.common.Const;
import com.tencent.upload.common.FileUtils;
import com.tencent.upload.common.FileUtils.UploaderMD5;
import com.tencent.upload.common.StringUtils;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.common.UploadLog;
import com.tencent.upload.network.session.IUploadSession;
import com.tencent.upload.protocol.utils.ProtocolUtil;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.IUploadTaskType;
import com.tencent.upload.uinterface.Utility;
import com.tencent.upload.uinterface.data.ImageUploadResult;
import com.tencent.upload.uinterface.data.ImageUploadTask;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ImageUploadAction
  extends UploadActionFlowWrapper
{
  private boolean mDeleteFileAfterUpload;
  private PicUploadControlInfo mPicUploadControlInfo;
  
  public ImageUploadAction(ImageUploadTask paramImageUploadTask, boolean paramBoolean)
    throws Exception
  {
    super(paramImageUploadTask);
    this.mDeleteFileAfterUpload = paramBoolean;
    Object localObject1;
    if (paramImageUploadTask.isHead) {
      localObject1 = createHeadDesc();
    }
    for (;;)
    {
      String str = localObject1.getClass().getSimpleName();
      Object localObject2 = null;
      try
      {
        this.mUploadFileInfoReqBytes = ProtocolUtil.pack(str, localObject1);
        if (this.mUploadFileInfoReqBytes == null)
        {
          paramImageUploadTask = localObject2;
          if (localObject2 == null) {
            paramImageUploadTask = new Exception("ImageUploadAction() pack " + str + " =null. " + localObject1);
          }
          throw paramImageUploadTask;
          localObject1 = createUploadPicInfoReq(paramImageUploadTask);
          printUploadPicInfoReq((UploadPicInfoReq)localObject1, paramImageUploadTask.flowId);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localObject2 = localException;
          UploadLog.w("FlowWrapper", localException);
        }
      }
    }
    if (!(localObject1 instanceof UploadPicInfoReq)) {
      localObject1 = createUploadPicInfoReq(paramImageUploadTask);
    }
    for (;;)
    {
      this.mPicUploadControlInfo = createPicUploadControlInfo(paramImageUploadTask, (UploadPicInfoReq)localObject1);
      printPicUploadControlInfo(this.mPicUploadControlInfo);
      this.mSvcRequestHead = createSvcRequestHead(paramImageUploadTask);
      return;
    }
  }
  
  private static HeadDesc createHeadDesc()
  {
    HeadDesc localHeadDesc = new HeadDesc();
    localHeadDesc.portrait_type = 0L;
    localHeadDesc.uc_platform_qzone_subid = 0L;
    return localHeadDesc;
  }
  
  private static PicUploadControlInfo createPicUploadControlInfo(ImageUploadTask paramImageUploadTask, UploadPicInfoReq paramUploadPicInfoReq)
  {
    PicUploadControlInfo localPicUploadControlInfo = new PicUploadControlInfo();
    localPicUploadControlInfo.iAlbumTypeID = paramImageUploadTask.iAlbumTypeID;
    localPicUploadControlInfo.sAlbumID = paramImageUploadTask.sAlbumID;
    localPicUploadControlInfo.iNeedCheckAlbum = 1;
    if (paramImageUploadTask.preupload != 1)
    {
      localPicUploadControlInfo.picinfoReq = paramUploadPicInfoReq;
      return localPicUploadControlInfo;
    }
    localPicUploadControlInfo.iNeedCheckAlbum = 0;
    return localPicUploadControlInfo;
  }
  
  public static UploadPicInfoReq createUploadPicInfoReq(ImageUploadTask paramImageUploadTask)
  {
    UploadPicInfoReq localUploadPicInfoReq = new UploadPicInfoReq();
    localUploadPicInfoReq.sPicTitle = StringUtils.getEmptyString(paramImageUploadTask.sPicTitle);
    localUploadPicInfoReq.sPicDesc = StringUtils.getEmptyString(paramImageUploadTask.sPicDesc);
    localUploadPicInfoReq.sAlbumID = StringUtils.getEmptyString(paramImageUploadTask.sAlbumID);
    localUploadPicInfoReq.sAlbumName = StringUtils.getEmptyString(paramImageUploadTask.sAlbumName);
    localUploadPicInfoReq.iAlbumTypeID = paramImageUploadTask.iAlbumTypeID;
    localUploadPicInfoReq.iBitmap = paramImageUploadTask.iBitmap;
    localUploadPicInfoReq.iUploadType = paramImageUploadTask.iUploadType;
    localUploadPicInfoReq.iUpPicType = paramImageUploadTask.iUpPicType;
    localUploadPicInfoReq.iBatchID = paramImageUploadTask.iBatchID;
    localUploadPicInfoReq.mutliPicInfo = paramImageUploadTask.mutliPicInfo;
    localUploadPicInfoReq.mapExt = paramImageUploadTask.mapExt;
    localUploadPicInfoReq.stExtendInfo = paramImageUploadTask.stExtendInfo;
    localUploadPicInfoReq.stExternalMapExt = paramImageUploadTask.stExternalMapExt;
    localUploadPicInfoReq.sPicPath = paramImageUploadTask.getOriginalUploadFilePath();
    Object localObject1 = ImageProcessUtil.decodeBitmapSize(paramImageUploadTask.uploadFilePath);
    localUploadPicInfoReq.iPicWidth = ((IUploadConfig.UploadImageSize)localObject1).width;
    localUploadPicInfoReq.iPicHight = ((IUploadConfig.UploadImageSize)localObject1).height;
    int i;
    if (paramImageUploadTask.bWaterType) {
      i = 1;
    }
    for (;;)
    {
      localUploadPicInfoReq.iWaterType = i;
      label205:
      Object localObject3;
      Object localObject2;
      if (Build.VERSION.SDK_INT >= 5)
      {
        if (localUploadPicInfoReq.stExtendInfo != null) {
          break label1283;
        }
        localObject1 = null;
        if (localObject1 != null)
        {
          localObject3 = (String)((Map)localObject1).get(UploadConfiguration.getExifTagCode("Make"));
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          localUploadPicInfoReq.sExif_CameraMaker = ((String)localObject2);
          localObject3 = (String)((Map)localObject1).get(UploadConfiguration.getExifTagCode("Model"));
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          localUploadPicInfoReq.sExif_CameraModel = ((String)localObject2);
          localObject3 = (String)((Map)localObject1).get(UploadConfiguration.getExifTagCode("GPSLatitude"));
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          localUploadPicInfoReq.sExif_Latitude = ((String)localObject2);
          localObject3 = (String)((Map)localObject1).get(UploadConfiguration.getExifTagCode("GPSLatitudeRef"));
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          localUploadPicInfoReq.sExif_LatitudeRef = ((String)localObject2);
          localObject3 = (String)((Map)localObject1).get(UploadConfiguration.getExifTagCode("GPSLongitude"));
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          localUploadPicInfoReq.sExif_Longitude = ((String)localObject2);
          localObject3 = (String)((Map)localObject1).get(UploadConfiguration.getExifTagCode("GPSLongitudeRef"));
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          localUploadPicInfoReq.sExif_LongitudeRef = ((String)localObject2);
          if (paramImageUploadTask.iUploadType == 3) {
            localObject1 = (String)((Map)localObject1).get(UploadConfiguration.getExifTagCode("Orientation"));
          }
        }
      }
      try
      {
        switch (Integer.parseInt((String)localObject1))
        {
        case 4: 
        case 5: 
        case 7: 
          localObject1 = "0";
          if (localUploadPicInfoReq.stExtendInfo.mapParams == null) {
            localUploadPicInfoReq.stExtendInfo.mapParams = new HashMap();
          }
          localObject3 = localUploadPicInfoReq.stExtendInfo.mapParams;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          ((Map)localObject3).put("rotation", localObject2);
          localUploadPicInfoReq.iUploadTime = paramImageUploadTask.iUploadTime;
          localObject2 = (HashMap)localUploadPicInfoReq.mapExt;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new HashMap();
          }
          ((HashMap)localObject1).put("mobile_fakefeeds_clientkey", StringUtils.getEmptyString(paramImageUploadTask.clientFakeKey));
          if ((localUploadPicInfoReq.stExtendInfo != null) && (localUploadPicInfoReq.stExtendInfo.mapParams == null)) {
            localUploadPicInfoReq.stExtendInfo.mapParams = new HashMap();
          }
          if (localUploadPicInfoReq.stExtendInfo == null) {
            break;
          }
        case 6: 
        case 8: 
          try
          {
            label488:
            localObject2 = paramImageUploadTask.getOriginalUploadFilePath();
            localObject3 = ImageProcessUtil.decodeBitmapOptions((String)localObject2);
            localUploadPicInfoReq.stExtendInfo.mapParams.put("raw_width", Integer.toString(((BitmapFactory.Options)localObject3).outWidth));
            localUploadPicInfoReq.stExtendInfo.mapParams.put("raw_height", Integer.toString(((BitmapFactory.Options)localObject3).outHeight));
            localUploadPicInfoReq.stExtendInfo.mapParams.put("raw_size", Long.toString(new File((String)localObject2).length()));
            localObject3 = (String)paramImageUploadTask.stExtendInfo.mapParams.get("geo_x");
            Map localMap = localUploadPicInfoReq.stExtendInfo.mapParams;
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localMap.put("geo_x", localObject2);
            localObject3 = (String)paramImageUploadTask.stExtendInfo.mapParams.get("geo_y");
            localMap = localUploadPicInfoReq.stExtendInfo.mapParams;
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localMap.put("geo_y", localObject2);
            localObject3 = (String)paramImageUploadTask.stExtendInfo.mapParams.get("geo_id");
            localMap = localUploadPicInfoReq.stExtendInfo.mapParams;
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localMap.put("geo_id", localObject2);
            localObject3 = (String)paramImageUploadTask.stExtendInfo.mapParams.get("geo_idname");
            localMap = localUploadPicInfoReq.stExtendInfo.mapParams;
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localMap.put("geo_idname", localObject2);
            localObject3 = (String)paramImageUploadTask.stExtendInfo.mapParams.get("geo_name");
            localMap = localUploadPicInfoReq.stExtendInfo.mapParams;
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localMap.put("geo_name", localObject2);
            localObject2 = (String)paramImageUploadTask.stExtendInfo.mapParams.get("Exif_Time");
            localMap = localUploadPicInfoReq.stExtendInfo.mapParams;
            if (localObject2 != null) {
              break label1309;
            }
            localObject3 = "";
            label1035:
            localMap.put("Exif_Time", localObject3);
            localObject3 = localObject2;
            if (localObject2 == null) {
              localObject3 = "";
            }
            localUploadPicInfoReq.sExif_Time = ((String)localObject3);
          }
          catch (Exception localException)
          {
            label1283:
            label1309:
            break;
          }
          localObject2 = Const.getProperty(paramImageUploadTask, "appid");
          if ((localObject2 != null) && ((localObject2 instanceof String))) {
            ((HashMap)localObject1).put("appid", (String)localObject2);
          }
          localObject2 = Const.getProperty(paramImageUploadTask, "userid");
          if ((localObject2 != null) && (((localObject2 instanceof String)) || ((localObject2 instanceof Long)))) {
            ((HashMap)localObject1).put("userid", localObject2.toString());
          }
          localObject2 = Const.getProperty(paramImageUploadTask, "a2_key");
          if ((localObject2 != null) && ((localObject2 instanceof byte[]))) {
            ((HashMap)localObject1).put("a2_key", new String((byte[])localObject2));
          }
          if (!TextUtils.isEmpty(paramImageUploadTask.uiRefer)) {
            ((HashMap)localObject1).put("refer", paramImageUploadTask.uiRefer);
          }
          localUploadPicInfoReq.mapExt = ((Map)localObject1);
          localUploadPicInfoReq.iDistinctUse = paramImageUploadTask.iDistinctUse;
          localUploadPicInfoReq.uploadPoi = paramImageUploadTask.uploadPoi;
          localUploadPicInfoReq.waterTemplate = new stWaterTemplate(paramImageUploadTask.waterTemplateId, paramImageUploadTask.watermarkPoiName);
          localUploadPicInfoReq.iBusiNessType = paramImageUploadTask.iBusiNessType;
          if (localUploadPicInfoReq.iBusiNessType == 1)
          {
            if (paramImageUploadTask.vBusiNessData == null) {}
            for (paramImageUploadTask = new byte[0];; paramImageUploadTask = paramImageUploadTask.vBusiNessData)
            {
              localUploadPicInfoReq.vBusiNessData = paramImageUploadTask;
              return localUploadPicInfoReq;
              i = 0;
              break;
              localObject1 = localUploadPicInfoReq.stExtendInfo.mapExif;
              break label205;
              localObject1 = "90";
              break label488;
              localObject1 = "270";
              break label488;
              localObject3 = localObject2;
              break label1035;
            }
          }
          localUploadPicInfoReq.vBusiNessData = new byte[0];
          return localUploadPicInfoReq;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          continue;
          continue;
          localObject1 = "180";
        }
      }
    }
  }
  
  private boolean needRetryCompress(int paramInt)
  {
    if ((paramInt != 30500) && (paramInt != 30600)) {
      return false;
    }
    ImageUploadTask localImageUploadTask = (ImageUploadTask)this.mAbstractUploadTask;
    if ((localImageUploadTask == null) || (TextUtils.isEmpty(localImageUploadTask.getOriginalUploadFilePath()))) {
      return false;
    }
    if ((localImageUploadTask.iUploadType == 3) || (TextUtils.isEmpty(localImageUploadTask.uploadFilePath)) || (!localImageUploadTask.uploadFilePath.endsWith(".qtmp"))) {
      return false;
    }
    Object localObject1 = new File(localImageUploadTask.getOriginalUploadFilePath());
    if ((localObject1 == null) || (!((File)localObject1).exists()) || (((File)localObject1).length() <= 0L)) {
      return false;
    }
    localImageUploadTask.uploadFilePath = localImageUploadTask.getOriginalUploadFilePath();
    Object localObject2 = ImageProcessUtil.decodeBitmapOptions(localImageUploadTask.uploadFilePath);
    String str;
    if ("image/gif".equalsIgnoreCase(((BitmapFactory.Options)localObject2).outMimeType))
    {
      long l = ((File)localObject1).length();
      paramInt = UploadConfiguration.getCurrentNetworkCategory();
      if (((paramInt != 1) || (l >= 5242880L)) && ((paramInt != 3) || (l >= 819200L)) && ((paramInt != 2) || (l >= 2097152L))) {}
      for (paramInt = 0;; paramInt = 1)
      {
        if (paramInt == 0)
        {
          localObject1 = new BitmapFactory.Options();
          localObject2 = ImageProcessUtil.decodeFileWithRetry(localImageUploadTask.uploadFilePath, (BitmapFactory.Options)localObject1);
          str = FileUtils.getTempFilePath(UploadGlobalConfig.getContext(), localImageUploadTask.uploadFilePath, localImageUploadTask.md5, localImageUploadTask.flowId);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (str != null)
            {
              localObject1 = localObject2;
              if (ImageProcessUtil.bitmapToFile((Bitmap)localObject2, str, 80, false, false, null))
              {
                localImageUploadTask.uploadFilePath = str;
                ((Bitmap)localObject2).recycle();
                localObject1 = null;
              }
            }
          }
          if (localObject1 != null) {
            ((Bitmap)localObject1).recycle();
          }
        }
        Const.copyTaskFile(localImageUploadTask);
        return true;
      }
    }
    paramInt = 100;
    if ("image/jpeg".equalsIgnoreCase(((BitmapFactory.Options)localObject2).outMimeType)) {
      paramInt = UploadConfiguration.getPictureQuality(localImageUploadTask.uploadFilePath);
    }
    int i = paramInt;
    if (paramInt <= 0) {
      i = 100;
    }
    localObject2 = new IUploadConfig.UploadImageSize(((BitmapFactory.Options)localObject2).outWidth, ((BitmapFactory.Options)localObject2).outHeight, 100);
    if ((((IUploadConfig.UploadImageSize)localObject2).width == 0) && (((IUploadConfig.UploadImageSize)localObject2).height == 0)) {
      return false;
    }
    localObject1 = UploadGlobalConfig.getConfig().getUploadImageSize((IUploadConfig.UploadImageSize)localObject2, localImageUploadTask.iUploadType, localImageUploadTask);
    if ((localObject1 != null) && (((IUploadConfig.UploadImageSize)localObject1).height > 0) && (((IUploadConfig.UploadImageSize)localObject1).width > 0) && (((IUploadConfig.UploadImageSize)localObject1).quality > 0)) {}
    for (paramInt = 0; (paramInt != 0) || ((((IUploadConfig.UploadImageSize)localObject2).width <= ((IUploadConfig.UploadImageSize)localObject1).width) && (((IUploadConfig.UploadImageSize)localObject2).height <= ((IUploadConfig.UploadImageSize)localObject1).height) && (i <= ((IUploadConfig.UploadImageSize)localObject1).quality)); paramInt = 1)
    {
      Const.copyTaskFile(localImageUploadTask);
      return true;
    }
    if (i < ((IUploadConfig.UploadImageSize)localObject1).quality) {
      ((IUploadConfig.UploadImageSize)localObject1).quality = i;
    }
    boolean bool1 = Utility.isCompressToWebp(this.mConfig.getCompressToWebpFlag(), localImageUploadTask.iUploadType);
    localObject2 = this.mAbstractUploadTask.getUploadTaskType();
    if ((localObject2 != null) && (((IUploadTaskType)localObject2).getProtocolUploadType() == 0))
    {
      paramInt = 1;
      localObject2 = FileUtils.getTempFilePath(UploadGlobalConfig.getContext(), localImageUploadTask.uploadFilePath, localImageUploadTask.md5, localImageUploadTask.flowId);
      str = localImageUploadTask.uploadFilePath;
      i = ((IUploadConfig.UploadImageSize)localObject1).width;
      int j = ((IUploadConfig.UploadImageSize)localObject1).height;
      int k = ((IUploadConfig.UploadImageSize)localObject1).quality;
      boolean bool2 = localImageUploadTask.autoRotate;
      if ((!bool1) || (paramInt == 0)) {
        break label670;
      }
      bool1 = true;
      label634:
      localObject1 = ImageProcessUtil.compressFile(str, (String)localObject2, i, j, k, bool2, bool1);
      if (localObject1 == null) {
        break label676;
      }
      localImageUploadTask.uploadFilePath = ((String)localObject1);
    }
    for (;;)
    {
      return true;
      paramInt = 0;
      break;
      label670:
      bool1 = false;
      break label634;
      label676:
      Const.copyTaskFile(localImageUploadTask);
    }
  }
  
  private static final void printPicUploadControlInfo(PicUploadControlInfo paramPicUploadControlInfo)
  {
    UploadLog.d("FlowWrapper", "PicUploadControlInfo [sAlbumID=" + paramPicUploadControlInfo.sAlbumID + ", iAlbumTypeID=" + paramPicUploadControlInfo.iAlbumTypeID + "]");
  }
  
  public static final void printUploadPicInfoReq(UploadPicInfoReq paramUploadPicInfoReq, int paramInt)
  {
    UploadLog.d("FlowWrapper", "UploadPicInfoReq flow:" + paramInt + "[sPicTitle=" + paramUploadPicInfoReq.sPicTitle + ", sPicDesc=" + paramUploadPicInfoReq.sPicDesc + ", sAlbumName=" + paramUploadPicInfoReq.sAlbumName + ", sAlbumID=" + paramUploadPicInfoReq.sAlbumID + ", iAlbumTypeID=" + paramUploadPicInfoReq.iAlbumTypeID + ", iBitmap=" + paramUploadPicInfoReq.iBitmap + ", iUploadType=" + paramUploadPicInfoReq.iUploadType + ", iUpPicType=" + paramUploadPicInfoReq.iUpPicType + ", iBatchID=" + paramUploadPicInfoReq.iBatchID + ", sPicPath=" + paramUploadPicInfoReq.sPicPath + ", iPicWidth=" + paramUploadPicInfoReq.iPicWidth + ", iPicHight=" + paramUploadPicInfoReq.iPicHight + ", iWaterType=" + paramUploadPicInfoReq.iWaterType + ", sExif_CameraMaker=" + paramUploadPicInfoReq.sExif_CameraMaker + ", sExif_CameraModel=" + paramUploadPicInfoReq.sExif_CameraModel + ", sExif_Time=" + paramUploadPicInfoReq.sExif_Time + ", sExif_LatitudeRef=" + paramUploadPicInfoReq.sExif_LatitudeRef + ", sExif_Latitude=" + paramUploadPicInfoReq.sExif_Latitude + ", sExif_LongitudeRef=" + paramUploadPicInfoReq.sExif_LongitudeRef + ", sExif_Longitude=" + paramUploadPicInfoReq.sExif_Longitude + ", iNeedFeeds=" + paramUploadPicInfoReq.iNeedFeeds + ", iUploadTime=" + paramUploadPicInfoReq.iUploadTime + ", iDistinctUse=" + paramUploadPicInfoReq.iDistinctUse + ", uploadPoi=" + paramUploadPicInfoReq.uploadPoi + ", otherParams=" + paramUploadPicInfoReq.otherParams + "]");
  }
  
  private static final void printUploadPicInfoRsp(UploadPicInfoRsp paramUploadPicInfoRsp)
  {
    UploadLog.d("FlowWrapper", "UploadPicInfoRsp [sSURL=" + paramUploadPicInfoRsp.sSURL + ", sBURL=" + paramUploadPicInfoRsp.sBURL + ", sAlbumID=" + paramUploadPicInfoRsp.sAlbumID + ", sPhotoID=" + paramUploadPicInfoRsp.sPhotoID + ", sSloc=" + paramUploadPicInfoRsp.sSloc + ", iWidth=" + paramUploadPicInfoRsp.iWidth + ", iHeight=" + paramUploadPicInfoRsp.iHeight + ", sOriUrl=" + paramUploadPicInfoRsp.sOriUrl + ", iOriWidth=" + paramUploadPicInfoRsp.iOriWidth + ", iOriHeight=" + paramUploadPicInfoRsp.iOriHeight + ", sOriPhotoID=" + paramUploadPicInfoRsp.sOriPhotoID + ", iPicType=" + paramUploadPicInfoRsp.iPicType + " ...]");
  }
  
  protected byte[] getControlRequestData()
  {
    Object localObject1 = null;
    str = null;
    try
    {
      localObject2 = ProtocolUtil.pack(this.mPicUploadControlInfo.getClass().getSimpleName(), this.mPicUploadControlInfo);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        str = Log.getStackTraceString(localException);
        UploadLog.w("FlowWrapper", localException);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = str;
      if (str == null) {
        localObject1 = "getControlRequestData() pack PicUploadControlInfo=null. " + this.mPicUploadControlInfo;
      }
      UploadLog.e("FlowWrapper", (String)localObject1);
      localObject2 = super.getControlRequestData();
    }
    return localObject2;
  }
  
  protected FileUtils.UploaderMD5 getMd5(File paramFile)
  {
    return new FileUtils.UploaderMD5(1, FileUtils.getMd5ByFile_REAL(paramFile));
  }
  
  protected void onDestroy(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.mDeleteFileAfterUpload)) {
      FileUtils.deleteTempFile(this.mAbstractUploadTask.uploadFilePath);
    }
  }
  
  public void onError(IUploadSession paramIUploadSession, int paramInt, String paramString, boolean paramBoolean)
  {
    boolean bool = needRetryCompress(paramInt);
    UploadLog.d("FlowWrapper", "needRetryCompress:" + bool);
    int i;
    if (bool) {
      i = 31500;
    }
    for (;;)
    {
      super.onError(paramIUploadSession, i, paramString, paramBoolean);
      return;
      if (paramInt != 30500)
      {
        i = paramInt;
        if (paramInt != 30600) {}
      }
      else
      {
        i = 31600;
      }
    }
  }
  
  protected void processFileUploadFinishRsp(byte[] paramArrayOfByte)
  {
    ImageUploadTask localImageUploadTask = (ImageUploadTask)this.mAbstractUploadTask;
    UploadPicInfoRsp localUploadPicInfoRsp = null;
    Object localObject2 = null;
    Object localObject1 = localUploadPicInfoRsp;
    if (!localImageUploadTask.isHead)
    {
      localObject1 = localUploadPicInfoRsp;
      if (paramArrayOfByte != null)
      {
        localObject1 = localUploadPicInfoRsp;
        if (paramArrayOfByte.length > 0)
        {
          localObject1 = null;
          try
          {
            localUploadPicInfoRsp = (UploadPicInfoRsp)ProtocolUtil.unpack(UploadPicInfoRsp.class.getSimpleName(), paramArrayOfByte);
            localObject2 = localUploadPicInfoRsp;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              boolean bool;
              localObject1 = Log.getStackTraceString(localException);
              UploadLog.w("FlowWrapper", localException);
            }
            printUploadPicInfoRsp((UploadPicInfoRsp)localObject2);
            localObject1 = localObject2;
          }
          if (localObject2 == null)
          {
            bool = false;
            localObject2 = localObject1;
            if (localObject1 == null)
            {
              localObject2 = "processFileUploadFinishRsp() unpack UploadPicInfoRsp=null. " + paramArrayOfByte;
              bool = true;
            }
            cancelActionForException(500, 0, true, bool, (String)localObject2, null);
            return;
          }
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new UploadPicInfoRsp();
    }
    localObject1 = new ImageUploadResult(localImageUploadTask.iUin, localImageUploadTask.flowId, localImageUploadTask.iBatchID, (UploadPicInfoRsp)localObject2);
    if (this.mUploadTaskCallback != null) {
      this.mUploadTaskCallback.onUploadSucceed(this.mAbstractUploadTask, localObject1);
    }
    super.processFileUploadFinishRsp(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.upload.uinterface.action.ImageUploadAction
 * JD-Core Version:    0.7.0.1
 */