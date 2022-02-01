package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.l.a.b.q;
import com.tencent.mm.plugin.appbrand.jsapi.l.a.b.v;
import com.tencent.mm.plugin.appbrand.jsapi.l.a.b.v.b;
import com.tencent.mm.plugin.appbrand.jsapi.l.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
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
  
  public final void a(final e parame, final JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143661);
    super.a(parame, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.Map.JsApiAddMapMarkers", "data is null");
      parame.j(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(143661);
      return;
    }
    Log.i("MicroMsg.Map.JsApiAddMapMarkers", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.l.a.b localb = g(parame, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.Map.JsApiAddMapMarkers", "mapView is null, return");
      parame.j(paramInt, h("fail:mapview is null", null));
      AppMethodBeat.o(143661);
      return;
    }
    boolean bool = paramJSONObject.optBoolean("clear", true);
    Log.i("MicroMsg.Map.JsApiAddMapMarkers", "clear:%b", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      localb.bSK();
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
          Log.e("MicroMsg.Map.JsApiAddMapMarkers", "markersArray is null, return");
          parame.j(paramInt, h("fail:internal error", null));
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
              b.v localv = a(parame, paramJSONObject, (JSONObject)localObject2);
              localObject2 = ((JSONObject)localObject2).optString("id");
              if (localv.oYJ != null) {
                Log.i("MicroMsg.Map.JsApiAddMapMarkers", "id:%s, label:%s, joinCluster:%b, clusterId:%d", new Object[] { localObject2, localv.oYJ.content, Boolean.valueOf(localv.oYD), Integer.valueOf(localv.oYg) });
              }
              if ((localv.oYD) && (!localb.bSO()) && (!localb.bSP())) {
                localb.a(true, true, 2, 60, new b.q()
                {
                  public final void ae(JSONObject paramAnonymousJSONObject)
                  {
                    AppMethodBeat.i(193449);
                    s.a locala = new s.a();
                    HashMap localHashMap = new HashMap();
                    localHashMap.put("cluster", paramAnonymousJSONObject);
                    localHashMap.put("mapId", Integer.valueOf(f.af(paramJSONObject)));
                    locala.E(localHashMap);
                    Log.i("MicroMsg.Map.JsApiAddMapMarkers", "click clusterInfo:%s", new Object[] { paramAnonymousJSONObject });
                    paramAnonymousJSONObject = ((com.tencent.mm.plugin.appbrand.jsapi.base.g)parame.K(com.tencent.mm.plugin.appbrand.jsapi.base.g.class)).c(parame, paramJSONObject);
                    if (paramAnonymousJSONObject != null)
                    {
                      paramAnonymousJSONObject.a(locala, null);
                      AppMethodBeat.o(193449);
                      return;
                    }
                    parame.a(locala);
                    AppMethodBeat.o(193449);
                  }
                  
                  public final void p(JSONArray paramAnonymousJSONArray)
                  {
                    AppMethodBeat.i(193447);
                    s.b localb = new s.b();
                    HashMap localHashMap = new HashMap();
                    localHashMap.put("clusters", paramAnonymousJSONArray);
                    localHashMap.put("mapId", Integer.valueOf(f.af(paramJSONObject)));
                    localb.E(localHashMap);
                    Log.i("MicroMsg.Map.JsApiAddMapMarkers", "create clusterInfo:%s", new Object[] { paramAnonymousJSONArray });
                    paramAnonymousJSONArray = ((com.tencent.mm.plugin.appbrand.jsapi.base.g)parame.K(com.tencent.mm.plugin.appbrand.jsapi.base.g.class)).c(parame, paramJSONObject);
                    if (paramAnonymousJSONArray != null)
                    {
                      paramAnonymousJSONArray.a(localb, null);
                      AppMethodBeat.o(193447);
                      return;
                    }
                    parame.a(localb);
                    AppMethodBeat.o(193447);
                  }
                });
              }
              localb.a((String)localObject2, localv, (a)parame.K(a.class));
            }
            i += 1;
          }
          catch (JSONException localJSONException2)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.Map.JsApiAddMapMarkers", localJSONException2, "", new Object[0]);
              Object localObject3 = null;
            }
          }
        }
      }
    }
    a(parame, paramInt, h("ok", null), true, localb.bSF());
    AppMethodBeat.o(143661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.h
 * JD-Core Version:    0.7.0.1
 */