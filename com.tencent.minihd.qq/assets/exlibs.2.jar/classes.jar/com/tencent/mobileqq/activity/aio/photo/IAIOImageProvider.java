package com.tencent.mobileqq.activity.aio.photo;

import android.content.Intent;
import android.os.IInterface;

public abstract interface IAIOImageProvider
  extends IInterface
{
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final String d = "IAIOImageProvider";
  public static final int e = 3;
  
  public abstract Intent a(long paramLong, int paramInt);
  
  public abstract void a();
  
  public abstract void a(long paramLong, int paramInt);
  
  public abstract void a(long paramLong, int paramInt1, int paramInt2);
  
  public abstract void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract void a(IAIOImageProviderCallBack paramIAIOImageProviderCallBack);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void b();
  
  public abstract void b(long paramLong, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider
 * JD-Core Version:    0.7.0.1
 */