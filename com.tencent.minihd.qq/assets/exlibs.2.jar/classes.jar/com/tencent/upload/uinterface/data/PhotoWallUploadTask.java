package com.tencent.upload.uinterface.data;

import com.tencent.upload.common.Const;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadAction;
import com.tencent.upload.uinterface.IUploadService.IUploadServiceContext;
import com.tencent.upload.uinterface.IUploadTaskType;
import com.tencent.upload.uinterface.action.PhotoWallUploadAction;
import com.tencent.upload.uinterface.protocol.PhotoWallUploadTaskType;

public class PhotoWallUploadTask
  extends AbstractUploadTask
{
  public boolean autoRotate = false;
  public String clientIp;
  public int iUploadType = 0;
  public int op;
  public int source;
  public String title;
  
  public IUploadTaskType getUploadTaskType()
  {
    return new PhotoWallUploadTaskType();
  }
  
  public IUploadAction onCreateUploadAction(boolean paramBoolean)
    throws Exception
  {
    return new PhotoWallUploadAction(this, paramBoolean);
  }
  
  public void onProcessUploadTask(IUploadService.IUploadServiceContext paramIUploadServiceContext)
  {
    Const.processPictureTypeUploadTask(paramIUploadServiceContext, this, this.iUploadType, this.autoRotate);
  }
  
  public boolean onVerifyUploadFile()
  {
    return Const.verifyUploadFileFully(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.PhotoWallUploadTask
 * JD-Core Version:    0.7.0.1
 */