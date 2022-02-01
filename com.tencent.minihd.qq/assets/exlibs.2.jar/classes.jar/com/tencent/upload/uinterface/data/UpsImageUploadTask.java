package com.tencent.upload.uinterface.data;

import com.tencent.upload.common.Const;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadAction;
import com.tencent.upload.uinterface.IUploadService.IUploadServiceContext;
import com.tencent.upload.uinterface.IUploadTaskType;
import com.tencent.upload.uinterface.action.UpsImageUploadAction;
import com.tencent.upload.uinterface.protocol.UpsUploadTaskType;

public class UpsImageUploadTask
  extends AbstractUploadTask
{
  public static final String BUSINESS_COVER = "mqzonecover";
  public static final String BUSINESS_FAVOR_PHOTO = "favpic";
  public static final String BUSINESS_SHAREALBUM = "qqshare_photo";
  public static final String BUSINESS_SMART_VIDEO_COVER = "micro_video";
  public static final int TYPE_COVER = 2;
  public static final int TYPE_FAVOR_PHOTO = 3;
  public static final int TYPE_NONE = 0;
  public static final int TYPE_SHAREALBUM_PHOTO = 1;
  public final int appid;
  public int dataType;
  public String fileId;
  public long iBatchID;
  public int iBatchUploadCount;
  public int iBusiNessType;
  public int iCurrentUploadOrder;
  public int iUploadType = 0;
  public int keepRaw;
  public String sBusinessId = "";
  public String sCommand;
  public byte[] vBusiNessData;
  
  public UpsImageUploadTask(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 65538;; i = 1000027)
    {
      this.appid = i;
      return;
    }
  }
  
  public IUploadTaskType getUploadTaskType()
  {
    return new UpsUploadTaskType();
  }
  
  public IUploadAction onCreateUploadAction(boolean paramBoolean)
    throws Exception
  {
    return new UpsImageUploadAction(this, paramBoolean);
  }
  
  public void onProcessUploadTask(IUploadService.IUploadServiceContext paramIUploadServiceContext)
  {
    Const.processPictureTypeUploadTask(paramIUploadServiceContext, this, this.iUploadType, true);
  }
  
  public boolean onVerifyUploadFile()
  {
    return Const.verifyUploadFileFully(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.UpsImageUploadTask
 * JD-Core Version:    0.7.0.1
 */