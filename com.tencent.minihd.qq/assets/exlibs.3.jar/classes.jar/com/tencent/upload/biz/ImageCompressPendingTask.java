package com.tencent.upload.biz;

import com.tencent.upload.uinterface.AbstractUploadTask;

public class ImageCompressPendingTask
{
  public final boolean autoRotate;
  public final boolean compressToWebp;
  public int mTargetHeight;
  public int mTargetQuality;
  public int mTargetWidth;
  public AbstractUploadTask mUploadTask;
  
  public ImageCompressPendingTask(AbstractUploadTask paramAbstractUploadTask, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mUploadTask = paramAbstractUploadTask;
    this.mTargetWidth = paramInt1;
    this.mTargetHeight = paramInt2;
    this.mTargetQuality = paramInt3;
    this.autoRotate = paramBoolean1;
    this.compressToWebp = paramBoolean2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.upload.biz.ImageCompressPendingTask
 * JD-Core Version:    0.7.0.1
 */