package com.tencent.luggage.g;

import android.os.Build.VERSION;

public final class b
{
  public static boolean fv(int paramInt)
  {
    return Build.VERSION.SDK_INT >= paramInt;
  }
  
  public static boolean fw(int paramInt)
  {
    return Build.VERSION.SDK_INT < paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.g.b
 * JD-Core Version:    0.7.0.1
 */