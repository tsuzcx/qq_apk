package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.g;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
  extends b
{
  public static final int CTRL_INDEX = 135;
  public static final String NAME = "addMapCircles";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143657);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiAddMapCircles", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(143657);
      return;
    }
    ad.i("MicroMsg.JsApiAddMapCircles", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.g.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ad.e("MicroMsg.JsApiAddMapCircles", "mapView is null, return");
      paramc.h(paramInt, e("fail:mapview is null", null));
      AppMethodBeat.o(143657);
      return;
    }
    try
    {
      if (paramJSONObject.has("circles"))
      {
        localb.bav();
        paramJSONObject = new JSONArray(paramJSONObject.optString("circles"));
        int i = 0;
        while (i < paramJSONObject.length())
        {
          Object localObject = (JSONObject)paramJSONObject.get(i);
          double d1 = bt.getDouble(((JSONObject)localObject).optString("latitude"), 0.0D);
          double d2 = bt.getDouble(((JSONObject)localObject).optString("longitude"), 0.0D);
          int j = g.bY(((JSONObject)localObject).optString("color", ""), Color.parseColor("#000000"));
          int k = g.bY(((JSONObject)localObject).optString("fillColor", ""), Color.parseColor("#000000"));
          int m = ((JSONObject)localObject).optInt("radius");
          float f = g.a((JSONObject)localObject, "strokeWidth", 0.0F);
          localObject = new b.b();
          ((b.b)localObject).latitude = d1;
          ((b.b)localObject).longitude = d2;
          ((b.b)localObject).radius = m;
          ((b.b)localObject).strokeColor = j;
          ((b.b)localObject).strokeWidth = ((int)f);
          ((b.b)localObject).fillColor = k;
          localb.a((b.b)localObject);
          i += 1;
        }
      }
      a(paramc, paramInt, e("ok", null), true, localb.bat());
    }
    catch (Exception paramJSONObject)
    {
      ad.e("MicroMsg.JsApiAddMapCircles", "parse circles error, exception : %s", new Object[] { paramJSONObject });
      a(paramc, paramInt, e("fail:internal error", null), false, localb.bat());
      AppMethodBeat.o(143657);
      return;
    }
    AppMethodBeat.o(143657);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.c
 * JD-Core Version:    0.7.0.1
 */