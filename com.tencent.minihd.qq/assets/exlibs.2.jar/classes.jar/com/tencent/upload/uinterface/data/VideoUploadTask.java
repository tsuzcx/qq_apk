package com.tencent.upload.uinterface.data;

import com.tencent.upload.common.Const;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadAction;
import com.tencent.upload.uinterface.IUploadService.IUploadServiceContext;
import com.tencent.upload.uinterface.IUploadTaskType;
import com.tencent.upload.uinterface.action.VideoUploadAction;
import com.tencent.upload.uinterface.protocol.VideoUploadTaskType;

public class VideoUploadTask
  extends AbstractUploadTask
{
  public int iBusiNessType = 0;
  public int iFlag = 0;
  public final int iIsNew;
  public int iPlayTime = 0;
  public long iUploadTime = 0L;
  public String sCoverUrl = "";
  public String sDesc = "";
  public String sTitle = "";
  public byte[] vBusiNessData = null;
  
  public VideoUploadTask(int paramInt)
  {
    this.iIsNew = paramInt;
  }
  
  public IUploadTaskType getUploadTaskType()
  {
    return new VideoUploadTaskType();
  }
  
  public IUploadAction onCreateUploadAction(boolean paramBoolean)
    throws Exception
  {
    return new VideoUploadAction(this);
  }
  
  public void onProcessUploadTask(IUploadService.IUploadServiceContext paramIUploadServiceContext)
  {
    Const.copyAndUploadTaskBySize(paramIUploadServiceContext, this, null, 3145728);
  }
  
  public boolean onVerifyUploadFile()
  {
    return Const.verifyUploadFileDirectly(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.VideoUploadTask
 * JD-Core Version:    0.7.0.1
 */