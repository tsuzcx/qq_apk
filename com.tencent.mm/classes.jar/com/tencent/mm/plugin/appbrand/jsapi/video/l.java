package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public final class l
{
  public static String AF(long paramLong)
  {
    AppMethodBeat.i(137850);
    if (paramLong < 3600000L) {}
    for (Object localObject = "mm:ss";; localObject = "HH:mm:ss")
    {
      localObject = new SimpleDateFormat((String)localObject);
      ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
      localObject = ((SimpleDateFormat)localObject).format(Long.valueOf(paramLong));
      AppMethodBeat.o(137850);
      return localObject;
    }
  }
  
  public static boolean aaW(String paramString)
  {
    AppMethodBeat.i(234647);
    boolean bool = h.aaW(paramString);
    AppMethodBeat.o(234647);
    return bool;
  }
  
  public static void b(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(234649);
    if (!(paramContext instanceof Activity))
    {
      AppMethodBeat.o(234649);
      return;
    }
    float f;
    if (paramFloat < 0.01F) {
      f = 0.01F;
    }
    for (;;)
    {
      paramContext = (Activity)paramContext;
      WindowManager.LayoutParams localLayoutParams = paramContext.getWindow().getAttributes();
      localLayoutParams.screenBrightness = f;
      paramContext.getWindow().setAttributes(localLayoutParams);
      AppMethodBeat.o(234649);
      return;
      f = paramFloat;
      if (paramFloat > 1.0F) {
        f = 1.0F;
      }
    }
  }
  
  private static int bIT()
  {
    AppMethodBeat.i(234648);
    int k = 255;
    j = k;
    try
    {
      Resources localResources = Resources.getSystem();
      j = k;
      int m = localResources.getIdentifier("config_screenBrightnessSettingMaximum", "integer", "android");
      i = k;
      if (m != 0)
      {
        j = k;
        i = localResources.getInteger(m);
      }
      j = i;
      Log.d("MicroMsg.VideoPlayerUtils", "getMaxBrightness %d", new Object[] { Integer.valueOf(i) });
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.i("MicroMsg.VideoPlayerUtils", "get max brightness fail, fallback to 255");
        int i = j;
      }
    }
    AppMethodBeat.o(234648);
    return i;
  }
  
  private static float dT(Context paramContext)
  {
    AppMethodBeat.i(137848);
    paramContext = paramContext.getContentResolver();
    float f1 = 0.0F;
    try
    {
      float f2 = Settings.System.getInt(paramContext, "screen_brightness");
      f1 = f2;
      int i = bIT();
      f1 = f2 / i;
    }
    catch (Settings.SettingNotFoundException paramContext)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.VideoPlayerUtils", paramContext, "", new Object[0]);
      }
    }
    AppMethodBeat.o(137848);
    return f1;
  }
  
  public static float dV(Context paramContext)
  {
    AppMethodBeat.i(137849);
    if (!(paramContext instanceof Activity))
    {
      AppMethodBeat.o(137849);
      return 1.0F;
    }
    WindowManager.LayoutParams localLayoutParams = ((Activity)paramContext).getWindow().getAttributes();
    if (localLayoutParams.screenBrightness < 0.0F)
    {
      f = dT(paramContext);
      AppMethodBeat.o(137849);
      return f;
    }
    float f = localLayoutParams.screenBrightness;
    AppMethodBeat.o(137849);
    return f;
  }
  
  public static boolean f(c paramc)
  {
    return paramc instanceof f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.l
 * JD-Core Version:    0.7.0.1
 */