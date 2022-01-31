package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.content.Context;
import android.os.Vibrator;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class m
  extends a
{
  public static final int CTRL_INDEX = 230;
  public static final String NAME = "vibrateShort";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    y.d("MicroMsg.JsApiVibrateShort", "JsApiVibrateShort services!");
    paramJSONObject = (Vibrator)paramc.getContext().getSystemService("vibrator");
    if (paramJSONObject != null) {
      paramJSONObject.vibrate(15L);
    }
    paramc.C(paramInt, h("ok", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.m
 * JD-Core Version:    0.7.0.1
 */