package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public final class m
{
  private static float cN(Context paramContext)
  {
    AppMethodBeat.i(126590);
    paramContext = paramContext.getContentResolver();
    float f = 0.0F;
    try
    {
      int i = Settings.System.getInt(paramContext, "screen_brightness");
      f = i / 255.0F;
    }
    catch (Settings.SettingNotFoundException paramContext)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.VideoPlayerUtils", paramContext, "", new Object[0]);
      }
    }
    AppMethodBeat.o(126590);
    return f;
  }
  
  public static float cP(Context paramContext)
  {
    AppMethodBeat.i(126591);
    if (!(paramContext instanceof Activity))
    {
      AppMethodBeat.o(126591);
      return 1.0F;
    }
    WindowManager.LayoutParams localLayoutParams = ((Activity)paramContext).getWindow().getAttributes();
    if (localLayoutParams.screenBrightness < 0.0F)
    {
      f = cN(paramContext);
      AppMethodBeat.o(126591);
      return f;
    }
    float f = localLayoutParams.screenBrightness;
    AppMethodBeat.o(126591);
    return f;
  }
  
  public static String ha(long paramLong)
  {
    AppMethodBeat.i(126592);
    if (paramLong < 3600000L) {}
    for (Object localObject = "mm:ss";; localObject = "HH:mm:ss")
    {
      localObject = new SimpleDateFormat((String)localObject);
      ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
      localObject = ((SimpleDateFormat)localObject).format(Long.valueOf(paramLong));
      AppMethodBeat.o(126592);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.m
 * JD-Core Version:    0.7.0.1
 */