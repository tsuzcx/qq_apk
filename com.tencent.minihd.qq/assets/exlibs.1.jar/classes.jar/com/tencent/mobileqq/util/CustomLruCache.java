package com.tencent.mobileqq.util;

import android.support.v4.util.LruCache;

public class CustomLruCache
  extends LruCache
{
  private static final String a = "CUSTOMLRUCACHE";
  
  public CustomLruCache(int paramInt)
  {
    super(paramInt);
  }
  
  protected Object create(Object paramObject)
  {
    return super.create(paramObject);
  }
  
  protected void entryRemoved(boolean paramBoolean, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    super.entryRemoved(paramBoolean, paramObject1, paramObject2, paramObject3);
  }
  
  protected int sizeOf(Object paramObject1, Object paramObject2)
  {
    return super.sizeOf(paramObject1, paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.CustomLruCache
 * JD-Core Version:    0.7.0.1
 */