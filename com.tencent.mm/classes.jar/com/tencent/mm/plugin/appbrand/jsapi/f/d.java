package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b.m;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends b
{
  public static final int CTRL_INDEX = 140;
  public static final String NAME = "addMapControls";
  
  public final void a(final c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143659);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.JsApiAddMapControls", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(143659);
      return;
    }
    ac.d("MicroMsg.JsApiAddMapControls", "data:%s", new Object[] { paramJSONObject.toString() });
    com.tencent.mm.plugin.appbrand.jsapi.f.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ac.e("MicroMsg.JsApiAddMapControls", "mapView is null, return");
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
          localb.bhp();
          JSONArray localJSONArray = new JSONArray(paramJSONObject.optString("controls"));
          i = 0;
          if (i < localJSONArray.length())
          {
            JSONObject localJSONObject1 = (JSONObject)localJSONArray.get(i);
            b.c localc = new b.c();
            localc.kvC = ((com.tencent.mm.plugin.appbrand.g.b)paramc.K(com.tencent.mm.plugin.appbrand.g.b.class)).b(paramc, localJSONObject1.optString("iconPath"));
            localc.kvD = localJSONObject1.optBoolean("clickable");
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
              localb.a(localc, new b.m()
              {
                public final void Ml(String paramAnonymousString)
                {
                  AppMethodBeat.i(143658);
                  d.a locala = new d.a((byte)0);
                  JSONObject localJSONObject = new JSONObject();
                  try
                  {
                    localJSONObject.put("mapId", this.ktV);
                    localJSONObject.put("data", paramAnonymousString);
                    locala.LO(localJSONObject.toString());
                    paramc.b(locala);
                    AppMethodBeat.o(143658);
                    return;
                  }
                  catch (JSONException paramAnonymousString)
                  {
                    for (;;)
                    {
                      ac.e("MicroMsg.JsApiAddMapControls", "put JSON data error : %s", new Object[] { paramAnonymousString });
                    }
                  }
                }
              }, (a)paramc.K(a.class));
            } else {
              localb.a(localc, null, (a)paramc.K(a.class));
            }
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        ac.e("MicroMsg.JsApiAddMapControls", "parse controls error, exception : %s", new Object[] { paramJSONObject });
        a(paramc, paramInt, e("fail:internal error", null), false, localb.bhm());
        AppMethodBeat.o(143659);
        return;
      }
      a(paramc, paramInt, e("ok", null), true, localb.bhm());
      AppMethodBeat.o(143659);
      return;
      i += 1;
    }
  }
  
  static final class a
    extends ar
  {
    private static final int CTRL_INDEX = 143;
    private static final String NAME = "onMapControlClick";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.d
 * JD-Core Version:    0.7.0.1
 */