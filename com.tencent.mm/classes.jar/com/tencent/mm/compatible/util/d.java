package com.tencent.mm.compatible.util;

import android.os.Build.VERSION;

public final class d
{
  public static boolean qV(int paramInt)
  {
    return Build.VERSION.SDK_INT >= paramInt;
  }
  
  public static boolean qW(int paramInt)
  {
    return Build.VERSION.SDK_INT < paramInt;
  }
  
  public static boolean qX(int paramInt)
  {
    return Build.VERSION.SDK_INT > paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.util.d
 * JD-Core Version:    0.7.0.1
 */