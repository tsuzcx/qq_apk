package com.tencent.qav.ipc;

import android.graphics.Bitmap;
import android.os.IInterface;

public abstract interface IQavService
  extends IInterface
{
  public abstract void a(IQavCallback paramIQavCallback);
  
  public abstract void a(String paramString, Bitmap paramBitmap);
  
  public abstract void a(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qav.ipc.IQavService
 * JD-Core Version:    0.7.0.1
 */