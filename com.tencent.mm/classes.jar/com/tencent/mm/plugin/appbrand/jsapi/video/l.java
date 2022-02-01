package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public final class l
{
  public static void b(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(193794);
    if (!(paramContext instanceof Activity))
    {
      AppMethodBeat.o(193794);
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
      AppMethodBeat.o(193794);
      return;
      f = paramFloat;
      if (paramFloat > 1.0F) {
        f = 1.0F;
      }
    }
  }
  
  private static int bbZ()
  {
    AppMethodBeat.i(193793);
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
      ad.d("MicroMsg.VideoPlayerUtils", "getMaxBrightness %d", new Object[] { Integer.valueOf(i) });
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.i("MicroMsg.VideoPlayerUtils", "get max brightness fail, fallback to 255");
        int i = j;
      }
    }
    AppMethodBeat.o(193793);
    return i;
  }
  
  private static float dn(Context paramContext)
  {
    AppMethodBeat.i(137848);
    paramContext = paramContext.getContentResolver();
    float f1 = 0.0F;
    try
    {
      float f2 = Settings.System.getInt(paramContext, "screen_brightness");
      f1 = f2;
      int i = bbZ();
      f1 = f2 / i;
    }
    catch (Settings.SettingNotFoundException paramContext)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.VideoPlayerUtils", paramContext, "", new Object[0]);
      }
    }
    AppMethodBeat.o(137848);
    return f1;
  }
  
  public static float dp(Context paramContext)
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
      f = dn(paramContext);
      AppMethodBeat.o(137849);
      return f;
    }
    float f = localLayoutParams.screenBrightness;
    AppMethodBeat.o(137849);
    return f;
  }
  
  public static boolean f(b paramb)
  {
    return paramb instanceof c;
  }
  
  public static String mz(long paramLong)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.l
 * JD-Core Version:    0.7.0.1
 */