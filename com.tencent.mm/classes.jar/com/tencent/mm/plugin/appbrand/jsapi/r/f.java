package com.tencent.mm.plugin.appbrand.jsapi.r;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f
  extends a
{
  public static final int CTRL_INDEX = 232;
  public static final String NAME = "getScreenBrightness";
  
  private static float cN(Context paramContext)
  {
    AppMethodBeat.i(126414);
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
        ab.e("MicroMsg.JsApiGetScreenBrightness", "getSystemBrightnessPercent err %s", new Object[] { paramContext.getMessage() });
      }
    }
    catch (IllegalArgumentException paramContext)
    {
      for (;;)
      {
        ab.e("MicroMsg.JsApiGetScreenBrightness", "getSystemBrightnessPercent IllegalArgumentException: %s", new Object[] { paramContext.getMessage() });
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ab.e("MicroMsg.JsApiGetScreenBrightness", "getSystemBrightnessPercent err %s", new Object[] { paramContext.getMessage() });
      }
    }
    AppMethodBeat.o(126414);
    return f;
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(126413);
    ab.d("MicroMsg.JsApiGetScreenBrightness", "JsApiGetScreenBrightness!");
    paramJSONObject = paramc.getContext();
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, j("fail", null));
      ab.e("MicroMsg.JsApiGetScreenBrightness", "context is null, invoke fail!");
      AppMethodBeat.o(126413);
      return;
    }
    if (!(paramJSONObject instanceof Activity))
    {
      paramc.h(paramInt, j("fail", null));
      ab.e("MicroMsg.JsApiGetScreenBrightness", "context is not Activity, invoke fail!");
      AppMethodBeat.o(126413);
      return;
    }
    WindowManager.LayoutParams localLayoutParams = ((Activity)paramJSONObject).getWindow().getAttributes();
    float f2 = localLayoutParams.screenBrightness;
    float f1 = f2;
    if (f2 < 0.0F) {
      f1 = cN(paramJSONObject);
    }
    ab.i("MicroMsg.JsApiGetScreenBrightness", "JsApiGetScreenBrightness %f/%f", new Object[] { Float.valueOf(f1), Float.valueOf(localLayoutParams.screenBrightness) });
    paramJSONObject = new HashMap();
    paramJSONObject.put("value", Float.valueOf(f1));
    paramc.h(paramInt, j("ok", paramJSONObject));
    AppMethodBeat.o(126413);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.f
 * JD-Core Version:    0.7.0.1
 */