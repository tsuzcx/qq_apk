package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
  extends b
{
  public static final int CTRL_INDEX = 140;
  public static final String NAME = "addMapControls";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143659);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiAddMapControls", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(143659);
      return;
    }
    ad.d("MicroMsg.JsApiAddMapControls", "data:%s", new Object[] { paramJSONObject.toString() });
    com.tencent.mm.plugin.appbrand.jsapi.i.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ad.e("MicroMsg.JsApiAddMapControls", "mapView is null, return");
      paramc.h(paramInt, e("fail:mapview is null", null));
      AppMethodBeat.o(143659);
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        if (paramJSONObject.has("controls"))
        {
          localb.bkU();
          JSONArray localJSONArray = new JSONArray(paramJSONObject.optString("controls"));
          i = 0;
          if (i < localJSONArray.length())
          {
            JSONObject localJSONObject1 = (JSONObject)localJSONArray.get(i);
            b.c localc = new b.c();
            localc.kRE = ((com.tencent.mm.plugin.appbrand.f.b)paramc.K(com.tencent.mm.plugin.appbrand.f.b.class)).b(paramc, localJSONObject1.optString("iconPath"));
            localc.kRF = localJSONObject1.optBoolean("clickable");
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
              localb.a(localc, new d.1(this, f.S(paramJSONObject), paramc), (a)paramc.K(a.class));
            } else {
              localb.a(localc, null, (a)paramc.K(a.class));
            }
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        ad.e("MicroMsg.JsApiAddMapControls", "parse controls error, exception : %s", new Object[] { paramJSONObject });
        a(paramc, paramInt, e("fail:internal error", null), false, localb.bkR());
        AppMethodBeat.o(143659);
        return;
      }
      a(paramc, paramInt, e("ok", null), true, localb.bkR());
      AppMethodBeat.o(143659);
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.d
 * JD-Core Version:    0.7.0.1
 */