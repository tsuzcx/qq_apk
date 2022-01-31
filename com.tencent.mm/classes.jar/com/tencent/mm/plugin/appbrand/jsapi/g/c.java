package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
  extends a
{
  public static final int CTRL_INDEX = 140;
  public static final String NAME = "addMapControls";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(93840);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiAddMapControls", "data is null");
      paramc.h(paramInt, j("fail:invalid data", null));
      AppMethodBeat.o(93840);
      return;
    }
    ab.d("MicroMsg.JsApiAddMapControls", "data:%s", new Object[] { paramJSONObject.toString() });
    com.tencent.mm.plugin.appbrand.jsapi.g.a.b localb = f(paramc, paramJSONObject);
    if (localb == null)
    {
      ab.e("MicroMsg.JsApiAddMapControls", "mapView is null, return");
      paramc.h(paramInt, j("fail:mapview is null", null));
      AppMethodBeat.o(93840);
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        if (paramJSONObject.has("controls"))
        {
          localb.aDA();
          JSONArray localJSONArray = new JSONArray(paramJSONObject.optString("controls"));
          i = 0;
          if (i < localJSONArray.length())
          {
            JSONObject localJSONObject1 = (JSONObject)localJSONArray.get(i);
            b.c localc = new b.c();
            localc.hPe = ((com.tencent.mm.plugin.appbrand.e.b)paramc.q(com.tencent.mm.plugin.appbrand.e.b.class)).b(paramc, localJSONObject1.optString("iconPath"));
            localc.hPf = localJSONObject1.optBoolean("clickable");
            localc.data = localJSONObject1.optString("data");
            JSONObject localJSONObject2 = localJSONObject1.getJSONObject("position");
            int j = g.a(localJSONObject2, "left", 0);
            int k = g.a(localJSONObject2, "top", 0);
            localc.left = j;
            localc.top = k;
            if (localJSONObject2.has("width")) {
              localc.width = g.a(localJSONObject2, "width", 0);
            }
            if (localJSONObject2.has("height")) {
              localc.height = g.a(localJSONObject2, "height", 0);
            }
            if (localJSONObject1.optBoolean("clickable")) {
              localb.a(localc, new c.1(this, f.G(paramJSONObject), paramc), (com.tencent.mm.plugin.appbrand.e.a)paramc.q(com.tencent.mm.plugin.appbrand.e.a.class));
            } else {
              localb.a(localc, null, (com.tencent.mm.plugin.appbrand.e.a)paramc.q(com.tencent.mm.plugin.appbrand.e.a.class));
            }
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        ab.e("MicroMsg.JsApiAddMapControls", "parse controls error, exception : %s", new Object[] { paramJSONObject });
        a(paramc, paramInt, j("fail:internal error", null), false, localb.aDx());
        AppMethodBeat.o(93840);
        return;
      }
      a(paramc, paramInt, j("ok", null), true, localb.aDx());
      AppMethodBeat.o(93840);
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.c
 * JD-Core Version:    0.7.0.1
 */