package com.tencent.map.lib.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class SystemUtil
{
  public static final int SMALL_SCREEN_THRESHOLD = 400;
  
  public static float getDensity(Context paramContext)
  {
    if (paramContext == null) {
      return 1.0F;
    }
    return paramContext.getResources().getDisplayMetrics().density;
  }
  
  public static int getOpenglesVersion(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getDeviceConfigurationInfo();
    if (paramContext != null) {
      return paramContext.reqGlEsVersion;
    }
    return 65537;
  }
  
  public static int getWindowHeight(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  public static int getWindowWidth(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.map.lib.util.SystemUtil
 * JD-Core Version:    0.7.0.1
 */