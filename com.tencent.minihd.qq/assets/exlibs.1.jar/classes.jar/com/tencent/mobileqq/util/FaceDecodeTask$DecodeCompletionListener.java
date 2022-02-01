package com.tencent.mobileqq.util;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract interface FaceDecodeTask$DecodeCompletionListener
{
  public abstract void a(QQAppInterface paramQQAppInterface, FaceInfo paramFaceInfo);
  
  public abstract void a(FaceInfo paramFaceInfo, Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.FaceDecodeTask.DecodeCompletionListener
 * JD-Core Version:    0.7.0.1
 */