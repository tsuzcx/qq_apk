package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
      ae.e("MicroMsg.JsApiAddMapCircles", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(143657);
      return;
    }
    ae.i("MicroMsg.JsApiAddMapCircles", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.i.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ae.e("MicroMsg.JsApiAddMapCircles", "mapView is null, return");
      paramc.h(paramInt, e("fail:mapview is null", null));
      AppMethodBeat.o(143657);
      return;
    }
    try
    {
      if (paramJSONObject.has("circles"))
      {
        localb.blD();
        paramJSONObject = new JSONArray(paramJSONObject.optString("circles"));
        int i = 0;
        while (i < paramJSONObject.length())
        {
          JSONObject localJSONObject = (JSONObject)paramJSONObject.get(i);
          double d1 = bu.getDouble(localJSONObject.optString("latitude"), 0.0D);
          double d2 = bu.getDouble(localJSONObject.optString("longitude"), 0.0D);
          int j = g.ck(localJSONObject.optString("color", ""), Color.parseColor("#000000"));
          int k = g.ck(localJSONObject.optString("fillColor", ""), Color.parseColor("#000000"));
          int m = localJSONObject.optInt("radius");
          float f = g.a(localJSONObject, "strokeWidth", 0.0F);
          b.b localb1 = new b.b();
          localb1.latitude = d1;
          localb1.longitude = d2;
          localb1.radius = m;
          localb1.strokeColor = j;
          localb1.strokeWidth = ((int)f);
          localb1.fillColor = k;
          localb1.kVm = localJSONObject.optString("level");
          localb.a(localb1);
          i += 1;
        }
      }
      a(paramc, paramInt, e("ok", null), true, localb.blB());
    }
    catch (Exception paramJSONObject)
    {
      ae.e("MicroMsg.JsApiAddMapCircles", "parse circles error, exception : %s", new Object[] { paramJSONObject });
      a(paramc, paramInt, e("fail:internal error", null), false, localb.blB());
      AppMethodBeat.o(143657);
      return;
    }
    AppMethodBeat.o(143657);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.c
 * JD-Core Version:    0.7.0.1
 */