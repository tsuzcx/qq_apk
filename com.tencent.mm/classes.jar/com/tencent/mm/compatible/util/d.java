package com.tencent.mm.compatible.util;

import android.os.Build.VERSION;

public final class d
{
  public static boolean rb(int paramInt)
  {
    return Build.VERSION.SDK_INT >= paramInt;
  }
  
  public static boolean rc(int paramInt)
  {
    return Build.VERSION.SDK_INT < paramInt;
  }
  
  public static boolean rd(int paramInt)
  {
    return Build.VERSION.SDK_INT > paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.util.d
 * JD-Core Version:    0.7.0.1
 */