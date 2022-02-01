package com.tencent.mobileqq.activity.photo;

import android.content.Intent;

public class PhotoCropMenuForQzone
  extends PhotoCropAction
{
  public PhotoCropMenuForQzone(PhotoCropActivity paramPhotoCropActivity)
  {
    super(paramPhotoCropActivity);
  }
  
  public void a(int paramInt)
  {
    this.a.getIntent().putExtra("PhotoConst.QZONE_COVER_SYNC_FLAG", paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoCropMenuForQzone
 * JD-Core Version:    0.7.0.1
 */