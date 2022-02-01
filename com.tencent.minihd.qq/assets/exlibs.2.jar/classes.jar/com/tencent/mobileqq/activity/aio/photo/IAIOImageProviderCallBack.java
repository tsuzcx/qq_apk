package com.tencent.mobileqq.activity.aio.photo;

import android.os.IInterface;

public abstract interface IAIOImageProviderCallBack
  extends IInterface
{
  public static final String a = "IAIOImageProviderCallBack";
  
  public abstract void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean);
  
  public abstract void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean);
  
  public abstract void a(AIOImageData[] paramArrayOfAIOImageData, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack
 * JD-Core Version:    0.7.0.1
 */