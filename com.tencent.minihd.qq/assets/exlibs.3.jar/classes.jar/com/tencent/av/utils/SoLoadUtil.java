package com.tencent.av.utils;

import android.content.Context;
import com.tencent.qav.log.AVLog;

public class SoLoadUtil
{
  private static final String TAG = "SoLoadUtil";
  
  public static boolean loadNativeLibrary(Context paramContext, String paramString)
  {
    try
    {
      System.loadLibrary(paramString);
      return true;
    }
    catch (Exception paramContext)
    {
      AVLog.e("SoLoadUtil", "loadNativeLibrary fail.", paramContext);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.utils.SoLoadUtil
 * JD-Core Version:    0.7.0.1
 */