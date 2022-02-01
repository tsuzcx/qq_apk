package com.tencent.mm.plugin.appbrand.jsapi.l;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.l.a.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
  extends b
{
  public static final int CTRL_INDEX = 135;
  public static final String NAME = "addMapCircles";
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143657);
    super.a(parame, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiAddMapCircles", "data is null");
      parame.j(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(143657);
      return;
    }
    Log.i("MicroMsg.JsApiAddMapCircles", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.l.a.b localb = g(parame, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiAddMapCircles", "mapView is null, return");
      parame.j(paramInt, h("fail:mapview is null", null));
      AppMethodBeat.o(143657);
      return;
    }
    try
    {
      if (paramJSONObject.has("circles"))
      {
        localb.bSH();
        paramJSONObject = new JSONArray(paramJSONObject.optString("circles"));
        int i = 0;
        while (i < paramJSONObject.length())
        {
          JSONObject localJSONObject = (JSONObject)paramJSONObject.get(i);
          double d1 = Util.getDouble(localJSONObject.optString("latitude"), 0.0D);
          double d2 = Util.getDouble(localJSONObject.optString("longitude"), 0.0D);
          int j = g.cO(localJSONObject.optString("color", ""), Color.parseColor("#000000"));
          int k = g.cO(localJSONObject.optString("fillColor", ""), Color.parseColor("#000000"));
          int m = localJSONObject.optInt("radius");
          float f = g.a(localJSONObject, "strokeWidth", 0.0F);
          b.b localb1 = new b.b();
          localb1.latitude = d1;
          localb1.longitude = d2;
          localb1.radius = m;
          localb1.strokeColor = j;
          localb1.strokeWidth = ((int)f);
          localb1.fillColor = k;
          localb1.oYl = localJSONObject.optString("level");
          localb.a(localb1);
          i += 1;
        }
      }
      a(parame, paramInt, h("ok", null), true, localb.bSF());
    }
    catch (Exception paramJSONObject)
    {
      Log.e("MicroMsg.JsApiAddMapCircles", "parse circles error, exception : %s", new Object[] { paramJSONObject });
      a(parame, paramInt, h("fail:internal error", null), false, localb.bSF());
      AppMethodBeat.o(143657);
      return;
    }
    AppMethodBeat.o(143657);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.c
 * JD-Core Version:    0.7.0.1
 */