package com.tencent.mm.plugin.appbrand.jsapi.z;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class t<C extends f>
  extends d<C>
{
  public static final int CTRL_INDEX = 230;
  public static final String NAME = "vibrateShort";
  
  public void a(C paramC, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137690);
    Log.d("MicroMsg.JsApiVibrateShort", "JsApiVibrateShort services!");
    if (paramC.getAppState() != b.kQH)
    {
      paramC.i(paramInt, h("fail:not allowed in background", null));
      AppMethodBeat.o(137690);
      return;
    }
    int i;
    if (paramJSONObject == null)
    {
      i = -1;
      Log.d("MicroMsg.JsApiVibrateShort", "vibrationIntensity: ".concat(String.valueOf(i)));
    }
    for (;;)
    {
      try
      {
        paramJSONObject = (Vibrator)paramC.getContext().getSystemService("vibrator");
        if (paramJSONObject == null)
        {
          paramC.i(paramInt, h("fail: vibrate is not support", null));
          AppMethodBeat.o(137690);
          return;
          if (!paramJSONObject.has("style"))
          {
            i = -1;
            break;
          }
          paramJSONObject = paramJSONObject.optString("style");
          if (!Util.isNullOrNil(paramJSONObject)) {}
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
          paramC.i(paramInt, h(paramJSONObject, null));
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
          Log.d("MicroMsg.JsApiVibrateShort", "vibrateSupportAmplitude");
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
        Log.w("MicroMsg.JsApiVibrateShort", "vibrateShort exception %s", new Object[] { paramJSONObject.getMessage() });
        paramC.i(paramInt, h("fail: system internal error", null));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.t
 * JD-Core Version:    0.7.0.1
 */