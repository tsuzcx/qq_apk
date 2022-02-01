package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
  extends b
{
  public static final int CTRL_INDEX = 140;
  public static final String NAME = "addMapControls";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143659);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiAddMapControls", "data is null");
      paramf.i(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(143659);
      return;
    }
    Log.d("MicroMsg.JsApiAddMapControls", "data:%s", new Object[] { paramJSONObject.toString() });
    com.tencent.mm.plugin.appbrand.jsapi.k.a.b localb = h(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiAddMapControls", "mapView is null, return");
      paramf.i(paramInt, h("fail:mapview is null", null));
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
          localb.bHa();
          JSONArray localJSONArray = new JSONArray(paramJSONObject.optString("controls"));
          i = 0;
          if (i < localJSONArray.length())
          {
            JSONObject localJSONObject1 = (JSONObject)localJSONArray.get(i);
            b.c localc = new b.c();
            localc.mav = ((com.tencent.mm.plugin.appbrand.f.b)paramf.M(com.tencent.mm.plugin.appbrand.f.b.class)).b(paramf, localJSONObject1.optString("iconPath"));
            localc.maw = localJSONObject1.optBoolean("clickable");
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
              localb.a(localc, new d.1(this, com.tencent.mm.plugin.appbrand.jsapi.k.a.f.ab(paramJSONObject), paramf), (a)paramf.M(a.class));
            } else {
              localb.a(localc, null, (a)paramf.M(a.class));
            }
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        Log.e("MicroMsg.JsApiAddMapControls", "parse controls error, exception : %s", new Object[] { paramJSONObject });
        a(paramf, paramInt, h("fail:internal error", null), false, localb.bGX());
        AppMethodBeat.o(143659);
        return;
      }
      a(paramf, paramInt, h("ok", null), true, localb.bGX());
      AppMethodBeat.o(143659);
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.d
 * JD-Core Version:    0.7.0.1
 */