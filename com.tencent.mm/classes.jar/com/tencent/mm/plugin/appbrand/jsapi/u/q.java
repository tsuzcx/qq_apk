package com.tencent.mm.plugin.appbrand.jsapi.u;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONObject;

public final class q
  extends a
{
  public static final int CTRL_INDEX = 230;
  public static final String NAME = "vibrateShort";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137690);
    ac.d("MicroMsg.JsApiVibrateShort", "JsApiVibrateShort services!");
    int i;
    if (paramJSONObject == null)
    {
      i = -1;
      ac.d("MicroMsg.JsApiVibrateShort", "vibrationIntensity: ".concat(String.valueOf(i)));
    }
    for (;;)
    {
      try
      {
        paramJSONObject = (Vibrator)paramc.getContext().getSystemService("vibrator");
        if (paramJSONObject == null)
        {
          paramc.h(paramInt, e("fail: vibrate is not support", null));
          AppMethodBeat.o(137690);
          return;
          if (!paramJSONObject.has("style"))
          {
            i = -1;
            break;
          }
          paramJSONObject = paramJSONObject.optString("style");
          if (!bs.isNullOrNil(paramJSONObject)) {}
          switch (paramJSONObject.hashCode())
          {
          default: 
            i = -1;
            switch (i)
            {
            default: 
              i = -2;
            }
            break;
          case 102970646: 
            if (!paramJSONObject.equals("light")) {
              continue;
            }
            i = 0;
            break;
          case -1078030475: 
            if (!paramJSONObject.equals("medium")) {
              continue;
            }
            i = 1;
            break;
          case 99152071: 
            if (!paramJSONObject.equals("heavy")) {
              continue;
            }
            i = 2;
            continue;
            i = 1;
            break;
            i = 2;
            break;
            i = 3;
            break;
          }
        }
        if (-2 == i)
        {
          paramJSONObject.vibrate(15L);
          paramJSONObject = "fail: style is illegal";
          paramc.h(paramInt, e(paramJSONObject, null));
          AppMethodBeat.o(137690);
          return;
        }
        if (-1 == i)
        {
          paramJSONObject.vibrate(15L);
          paramJSONObject = "ok";
          continue;
        }
        if ((Build.VERSION.SDK_INT >= 26) && (paramJSONObject.hasAmplitudeControl()))
        {
          ac.d("MicroMsg.JsApiVibrateShort", "vibrateSupportAmplitude");
          switch (i)
          {
          default: 
            if (-1 == i) {
              paramJSONObject.vibrate(15L);
            } else {
              paramJSONObject.vibrate(VibrationEffect.createOneShot(15L, i));
            }
            break;
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        ac.w("MicroMsg.JsApiVibrateShort", "vibrateShort exception %s", new Object[] { paramJSONObject.getMessage() });
        paramc.h(paramInt, e("fail: system internal error", null));
        AppMethodBeat.o(137690);
        return;
      }
      paramJSONObject.vibrate(15L);
      paramJSONObject = "fail: style is not support";
      continue;
      i = -1;
      continue;
      paramJSONObject = "ok";
      continue;
      i = 128;
      continue;
      i = 192;
      continue;
      i = 255;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.q
 * JD-Core Version:    0.7.0.1
 */