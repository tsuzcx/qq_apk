package com.tencent.upload.uinterface.data;

import FileUpload.MultiPicInfo;
import FileUpload.PicExtendInfo;
import FileUpload.stPoi;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.upload.common.Const;
import com.tencent.upload.common.FileUtils;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.common.UploadLog;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadAction;
import com.tencent.upload.uinterface.IUploadService.IUploadServiceContext;
import com.tencent.upload.uinterface.IUploadTaskType;
import com.tencent.upload.uinterface.action.ImageUploadAction;
import com.tencent.upload.uinterface.protocol.HeadUploadTaskType;
import com.tencent.upload.uinterface.protocol.ImageUploadTaskType;
import java.util.HashMap;

public class ImageUploadTask
  extends AbstractUploadTask
{
  public boolean autoRotate = false;
  public boolean bWaterType = false;
  public String clientFakeKey;
  public int iAlbumTypeID = 0;
  public long iBatchID = 0L;
  public int iBitmap = 0;
  public int iBusiNessType = 0;
  public int iDistinctUse = 0;
  public int iUpPicType = 0;
  public long iUploadTime = 0L;
  public int iUploadType = 0;
  public final boolean isHead;
  public HashMap<String, String> mapExt = null;
  public MultiPicInfo mutliPicInfo = null;
  public final String originalPath;
  public String sAlbumID = "";
  public String sAlbumName = "";
  public String sPicDesc = "";
  public String sPicTitle = "";
  public PicExtendInfo stExtendInfo = null;
  public HashMap<String, String> stExternalMapExt = null;
  public stPoi uploadPoi = null;
  public byte[] vBusiNessData = null;
  public String waterTemplateId;
  public String watermarkPoiName;
  
  public ImageUploadTask(boolean paramBoolean, String paramString)
  {
    this.isHead = paramBoolean;
    this.originalPath = paramString;
    this.uploadFilePath = paramString;
  }
  
  public final String getOriginalUploadFilePath()
  {
    return this.originalPath;
  }
  
  public IUploadTaskType getUploadTaskType()
  {
    if (this.isHead) {
      return new HeadUploadTaskType();
    }
    return new ImageUploadTaskType();
  }
  
  public IUploadAction onCreateUploadAction(boolean paramBoolean)
    throws Exception
  {
    if (this.preupload == 1) {
      paramBoolean = false;
    }
    return new ImageUploadAction(this, paramBoolean);
  }
  
  public void onProcessUploadTask(IUploadService.IUploadServiceContext paramIUploadServiceContext)
  {
    UploadLog.d("ServiceImpl", " onProcessUploadTask, iUploadType:" + this.iUploadType + " flowId:" + this.flowId);
    if (this.iUploadType == 3)
    {
      Const.copyAndUploadTaskBySize(paramIUploadServiceContext, this, "", 3145728);
      return;
    }
    boolean bool2 = false;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    boolean bool1 = bool2;
    if (this.preupload == 2)
    {
      Context localContext = UploadGlobalConfig.getContext();
      String str = FileUtils.getFilePathByPrefix(localContext, this.uploadFilePath, this.md5);
      localObject1 = localObject2;
      bool1 = bool2;
      if (!TextUtils.isEmpty(str))
      {
        localObject1 = FileUtils.getTempFilePath(localContext, this.uploadFilePath, this.md5, this.flowId);
        bool1 = FileUtils.copyFile(str, (String)localObject1);
      }
    }
    if (bool1)
    {
      Const.uploadTaskByTempFile(paramIUploadServiceContext, this, (String)localObject1, "uploadByTempFile");
      return;
    }
    Const.processPictureTypeUploadTask(paramIUploadServiceContext, this, this.iUploadType, this.autoRotate);
  }
  
  public boolean onVerifyUploadFile()
  {
    return Const.verifyUploadFileFully(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.ImageUploadTask
 * JD-Core Version:    0.7.0.1
 */