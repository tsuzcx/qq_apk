package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.q;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.v;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
  extends b
{
  public static final int CTRL_INDEX = 133;
  public static final String NAME = "addMapMarkers";
  
  public final void a(final c paramc, final JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143661);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiAddMapMarkers", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(143661);
      return;
    }
    ad.i("MicroMsg.JsApiAddMapMarkers", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.i.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ad.e("MicroMsg.JsApiAddMapMarkers", "mapView is null, return");
      paramc.h(paramInt, e("fail:mapview is null", null));
      AppMethodBeat.o(143661);
      return;
    }
    boolean bool = paramJSONObject.optBoolean("clear", true);
    ad.i("MicroMsg.JsApiAddMapMarkers", "clear:%b", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      localb.bkW();
    }
    if (paramJSONObject.has("markers"))
    {
      Object localObject1;
      int i;
      try
      {
        JSONArray localJSONArray = new JSONArray(paramJSONObject.optString("markers"));
        if (localJSONArray == null)
        {
          ad.e("MicroMsg.JsApiAddMapMarkers", "markersArray is null, return");
          paramc.h(paramInt, e("fail:internal error", null));
          AppMethodBeat.o(143661);
          return;
        }
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          localObject1 = null;
        }
        i = 0;
      }
      for (;;)
      {
        if (i < localObject1.length()) {
          try
          {
            Object localObject2 = (JSONObject)localObject1.get(i);
            if (localObject2 != null)
            {
              b.v localv = a(paramc, paramJSONObject, (JSONObject)localObject2);
              localObject2 = ((JSONObject)localObject2).optString("id");
              if ((localv.kRV) && (!localb.bla())) {
                localb.a(true, true, 2, 60, new b.q()
                {
                  public final void R(JSONObject paramAnonymousJSONObject)
                  {
                    AppMethodBeat.i(186140);
                    s.a locala = new s.a();
                    HashMap localHashMap = new HashMap();
                    localHashMap.put("cluster", paramAnonymousJSONObject);
                    localHashMap.put("mapId", Integer.valueOf(f.S(paramJSONObject)));
                    locala.B(localHashMap);
                    ad.i("MicroMsg.JsApiAddMapMarkers", "click clusterInfo:%s", new Object[] { paramAnonymousJSONObject });
                    paramAnonymousJSONObject = ((g)paramc.K(g.class)).c(paramc, paramJSONObject);
                    if (paramAnonymousJSONObject != null)
                    {
                      paramAnonymousJSONObject.b(locala);
                      AppMethodBeat.o(186140);
                      return;
                    }
                    paramc.a(locala);
                    AppMethodBeat.o(186140);
                  }
                  
                  public final void o(JSONArray paramAnonymousJSONArray)
                  {
                    AppMethodBeat.i(186139);
                    s.b localb = new s.b();
                    HashMap localHashMap = new HashMap();
                    localHashMap.put("clusters", paramAnonymousJSONArray);
                    localHashMap.put("mapId", Integer.valueOf(f.S(paramJSONObject)));
                    localb.B(localHashMap);
                    ad.i("MicroMsg.JsApiAddMapMarkers", "create clusterInfo:%s", new Object[] { paramAnonymousJSONArray });
                    paramAnonymousJSONArray = ((g)paramc.K(g.class)).c(paramc, paramJSONObject);
                    if (paramAnonymousJSONArray != null)
                    {
                      paramAnonymousJSONArray.b(localb);
                      AppMethodBeat.o(186139);
                      return;
                    }
                    paramc.a(localb);
                    AppMethodBeat.o(186139);
                  }
                });
              }
              localb.a((String)localObject2, localv, (a)paramc.K(a.class));
            }
            i += 1;
          }
          catch (JSONException localJSONException2)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.JsApiAddMapMarkers", localJSONException2, "", new Object[0]);
              Object localObject3 = null;
            }
          }
        }
      }
    }
    a(paramc, paramInt, e("ok", null), true, localb.bkR());
    AppMethodBeat.o(143661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.h
 * JD-Core Version:    0.7.0.1
 */