package com.tencent.map.lib.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SystemUtil
{
  public static final int SMALL_SCREEN_THRESHOLD = 400;
  
  public static float getDensity(Context paramContext)
  {
    AppMethodBeat.i(98228);
    if (paramContext == null)
    {
      AppMethodBeat.o(98228);
      return 1.0F;
    }
    float f = paramContext.getResources().getDisplayMetrics().density;
    AppMethodBeat.o(98228);
    return f;
  }
  
  public static int getOpenglesVersion(Context paramContext)
  {
    AppMethodBeat.i(98231);
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getDeviceConfigurationInfo();
    if (paramContext != null)
    {
      int i = paramContext.reqGlEsVersion;
      AppMethodBeat.o(98231);
      return i;
    }
    AppMethodBeat.o(98231);
    return 65537;
  }
  
  public static int getWindowHeight(Context paramContext)
  {
    AppMethodBeat.i(98230);
    int i = paramContext.getResources().getDisplayMetrics().heightPixels;
    AppMethodBeat.o(98230);
    return i;
  }
  
  public static int getWindowWidth(Context paramContext)
  {
    AppMethodBeat.i(98229);
    int i = paramContext.getResources().getDisplayMetrics().widthPixels;
    AppMethodBeat.o(98229);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.map.lib.util.SystemUtil
 * JD-Core Version:    0.7.0.1
 */