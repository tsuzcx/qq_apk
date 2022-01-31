package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  extends a
{
  public static final int CTRL_INDEX = 135;
  public static final String NAME = "addMapCircles";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(93838);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiAddMapCircles", "data is null");
      paramc.h(paramInt, j("fail:invalid data", null));
      AppMethodBeat.o(93838);
      return;
    }
    ab.i("MicroMsg.JsApiAddMapCircles", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.g.a.b localb = f(paramc, paramJSONObject);
    if (localb == null)
    {
      ab.e("MicroMsg.JsApiAddMapCircles", "mapView is null, return");
      paramc.h(paramInt, j("fail:mapview is null", null));
      AppMethodBeat.o(93838);
      return;
    }
    try
    {
      if (paramJSONObject.has("circles"))
      {
        localb.aDz();
        paramJSONObject = new JSONArray(paramJSONObject.optString("circles"));
        int i = 0;
        while (i < paramJSONObject.length())
        {
          Object localObject = (JSONObject)paramJSONObject.get(i);
          float f1 = bo.getFloat(((JSONObject)localObject).optString("latitude"), 0.0F);
          float f2 = bo.getFloat(((JSONObject)localObject).optString("longitude"), 0.0F);
          int j = g.bA(((JSONObject)localObject).optString("color", ""), Color.parseColor("#000000"));
          int k = g.bA(((JSONObject)localObject).optString("fillColor", ""), Color.parseColor("#000000"));
          int m = ((JSONObject)localObject).optInt("radius");
          float f3 = g.a((JSONObject)localObject, "strokeWidth", 0.0F);
          localObject = new b.b();
          double d1 = f1;
          double d2 = f2;
          ((b.b)localObject).latitude = d1;
          ((b.b)localObject).longitude = d2;
          ((b.b)localObject).radius = m;
          ((b.b)localObject).strokeColor = j;
          ((b.b)localObject).strokeWidth = ((int)f3);
          ((b.b)localObject).fillColor = k;
          localb.a((b.b)localObject);
          i += 1;
        }
      }
      a(paramc, paramInt, j("ok", null), true, localb.aDx());
    }
    catch (Exception paramJSONObject)
    {
      ab.e("MicroMsg.JsApiAddMapCircles", "parse circles error, exception : %s", new Object[] { paramJSONObject });
      a(paramc, paramInt, j("fail:internal error", null), false, localb.aDx());
      AppMethodBeat.o(93838);
      return;
    }
    AppMethodBeat.o(93838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.b
 * JD-Core Version:    0.7.0.1
 */