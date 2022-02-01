package com.tencent.mm.plugin.appbrand.jsapi.z;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class h
  extends d
{
  public static final int CTRL_INDEX = 232;
  public static final String NAME = "getScreenBrightness";
  
  private static int bIT()
  {
    AppMethodBeat.i(137669);
    j = 255;
    try
    {
      Resources localResources = Resources.getSystem();
      int k = localResources.getIdentifier("config_screenBrightnessSettingMaximum", "integer", "android");
      i = j;
      if (k != 0) {
        i = localResources.getInteger(k);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.i("MicroMsg.JsApiGetScreenBrightness", "get max brightness fail, fallback to 255");
        int i = j;
      }
    }
    AppMethodBeat.o(137669);
    return i;
  }
  
  private static float dT(Context paramContext)
  {
    AppMethodBeat.i(137668);
    paramContext = paramContext.getContentResolver();
    float f1 = 0.0F;
    try
    {
      float f2 = Settings.System.getInt(paramContext, "screen_brightness");
      int i = bIT();
      f1 = f2 / i;
    }
    catch (Settings.SettingNotFoundException paramContext)
    {
      for (;;)
      {
        Log.e("MicroMsg.JsApiGetScreenBrightness", "getSystemBrightnessPercent err %s", new Object[] { paramContext.getMessage() });
      }
    }
    catch (IllegalArgumentException paramContext)
    {
      for (;;)
      {
        Log.e("MicroMsg.JsApiGetScreenBrightness", "getSystemBrightnessPercent IllegalArgumentException: %s", new Object[] { paramContext.getMessage() });
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.e("MicroMsg.JsApiGetScreenBrightness", "getSystemBrightnessPercent err %s", new Object[] { paramContext.getMessage() });
      }
    }
    AppMethodBeat.o(137668);
    return f1;
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137667);
    Log.d("MicroMsg.JsApiGetScreenBrightness", "JsApiGetScreenBrightness!");
    paramJSONObject = paramf.getContext();
    if (paramJSONObject == null)
    {
      paramf.i(paramInt, h("fail", null));
      Log.e("MicroMsg.JsApiGetScreenBrightness", "context is null, invoke fail!");
      AppMethodBeat.o(137667);
      return;
    }
    if (!(paramJSONObject instanceof Activity))
    {
      paramf.i(paramInt, h("fail", null));
      Log.e("MicroMsg.JsApiGetScreenBrightness", "context is not Activity, invoke fail!");
      AppMethodBeat.o(137667);
      return;
    }
    WindowManager.LayoutParams localLayoutParams = ((Activity)paramJSONObject).getWindow().getAttributes();
    float f2 = localLayoutParams.screenBrightness;
    float f1 = f2;
    if (f2 < 0.0F) {
      f1 = dT(paramJSONObject);
    }
    Log.i("MicroMsg.JsApiGetScreenBrightness", "JsApiGetScreenBrightness %f/%f", new Object[] { Float.valueOf(f1), Float.valueOf(localLayoutParams.screenBrightness) });
    paramJSONObject = new HashMap();
    paramJSONObject.put("value", Float.valueOf(f1));
    paramf.i(paramInt, n("ok", paramJSONObject));
    AppMethodBeat.o(137667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.h
 * JD-Core Version:    0.7.0.1
 */