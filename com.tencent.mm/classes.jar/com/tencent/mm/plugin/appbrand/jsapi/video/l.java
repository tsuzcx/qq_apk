package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public final class l
{
  public static void b(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(205953);
    if (!(paramContext instanceof Activity))
    {
      AppMethodBeat.o(205953);
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
      AppMethodBeat.o(205953);
      return;
      f = paramFloat;
      if (paramFloat > 1.0F) {
        f = 1.0F;
      }
    }
  }
  
  private static int bmG()
  {
    AppMethodBeat.i(205952);
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
    AppMethodBeat.o(205952);
    return i;
  }
  
  private static float du(Context paramContext)
  {
    AppMethodBeat.i(137848);
    paramContext = paramContext.getContentResolver();
    float f1 = 0.0F;
    try
    {
      float f2 = Settings.System.getInt(paramContext, "screen_brightness");
      f1 = f2;
      int i = bmG();
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
  
  public static float dw(Context paramContext)
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
      f = du(paramContext);
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
  
  public static String sm(long paramLong)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.l
 * JD-Core Version:    0.7.0.1
 */