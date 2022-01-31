package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.app.Activity;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class j
  extends a
{
  public static final int CTRL_INDEX = 229;
  public static final String NAME = "setScreenBrightness";
  float gCm = (0.0F / 0.0F);
  float gCn;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    y.d("MicroMsg.JsApiSetScreenBrightness", "JsApiSetScreenBrightness!");
    if (paramJSONObject == null)
    {
      paramc.C(paramInt, h("fail:data is null", null));
      y.e("MicroMsg.JsApiSetScreenBrightness", "data is null");
      return;
    }
    if (!(paramc.getContext() instanceof Activity))
    {
      y.e("MicroMsg.JsApiSetScreenBrightness", "setScreenBrightness, server context is not activity, don't do invoke");
      paramc.C(paramInt, h("fail:context is not activity", null));
      return;
    }
    ai.d(new j.1(this, paramJSONObject, paramc, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.j
 * JD-Core Version:    0.7.0.1
 */