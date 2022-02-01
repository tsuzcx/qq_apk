package com.tencent.qav.ipc;

import android.graphics.Bitmap;
import android.os.IInterface;

public abstract interface IQavCallback
  extends IInterface
{
  public abstract Bitmap a(int paramInt, String paramString);
  
  public abstract String a(int paramInt, String paramString);
  
  public abstract void a(QavMsgRecord paramQavMsgRecord);
  
  public abstract void a(QavState paramQavState);
  
  public abstract void b(QavState paramQavState);
  
  public abstract void c(QavState paramQavState);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qav.ipc.IQavCallback
 * JD-Core Version:    0.7.0.1
 */