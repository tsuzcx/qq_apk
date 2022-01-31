package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends a
{
  public static final int CTRL_INDEX = 232;
  public static final String NAME = "getScreenBrightness";
  
  private static float cl(Context paramContext)
  {
    paramContext = paramContext.getContentResolver();
    try
    {
      int i = Settings.System.getInt(paramContext, "screen_brightness");
      return i / 255.0F;
    }
    catch (Settings.SettingNotFoundException paramContext)
    {
      y.e("MicroMsg.JsApiGetScreenBrightness", "getSystemBrightnessPercent err %s", new Object[] { paramContext.getMessage() });
    }
    return 0.0F;
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    y.d("MicroMsg.JsApiGetScreenBrightness", "JsApiGetScreenBrightness!");
    paramJSONObject = paramc.getContext();
    if (paramJSONObject == null)
    {
      paramc.C(paramInt, h("fail", null));
      y.e("MicroMsg.JsApiGetScreenBrightness", "context is null, invoke fail!");
      return;
    }
    if (!(paramJSONObject instanceof Activity))
    {
      paramc.C(paramInt, h("fail", null));
      y.e("MicroMsg.JsApiGetScreenBrightness", "context is not Activity, invoke fail!");
      return;
    }
    WindowManager.LayoutParams localLayoutParams = ((Activity)paramJSONObject).getWindow().getAttributes();
    float f2 = localLayoutParams.screenBrightness;
    float f1 = f2;
    if (f2 < 0.0F) {
      f1 = cl(paramJSONObject);
    }
    y.i("MicroMsg.JsApiGetScreenBrightness", "JsApiGetScreenBrightness %f/%f", new Object[] { Float.valueOf(f1), Float.valueOf(localLayoutParams.screenBrightness) });
    paramJSONObject = new HashMap();
    paramJSONObject.put("value", Float.valueOf(f1));
    paramc.C(paramInt, h("ok", paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.d
 * JD-Core Version:    0.7.0.1
 */