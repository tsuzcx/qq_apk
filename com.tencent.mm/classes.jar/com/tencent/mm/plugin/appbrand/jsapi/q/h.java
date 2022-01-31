package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class h
  extends a
{
  public static final int CTRL_INDEX = 533;
  public static final String NAME = "setDisplayOrientation";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (paramc == null)
    {
      y.e("MicroMsg.SameLayer.JsApiSetDisplayOrientation", "fail:component is null");
      return;
    }
    Context localContext = paramc.getContext();
    if (localContext == null)
    {
      y.e("MicroMsg.SameLayer.JsApiSetDisplayOrientation", "fail:context is null");
      paramc.C(paramInt, h("fail:context is null", null));
      return;
    }
    if (!(localContext instanceof Activity))
    {
      y.e("MicroMsg.SameLayer.JsApiSetDisplayOrientation", "fail:context is not Activity");
      paramc.C(paramInt, h("fail:context is not Activity", null));
      return;
    }
    int i = paramJSONObject.optInt("orientation", 0);
    y.i("MicroMsg.SameLayer.JsApiSetDisplayOrientation", "invoke setDisplayOrientation, orientation:%d", new Object[] { Integer.valueOf(i) });
    ai.d(new h.1(this, paramc, i));
    paramc.C(paramInt, h("ok", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.h
 * JD-Core Version:    0.7.0.1
 */