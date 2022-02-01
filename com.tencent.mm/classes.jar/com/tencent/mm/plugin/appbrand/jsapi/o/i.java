package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.q;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.v;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.v.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class i
  extends b
{
  public static final int CTRL_INDEX = 133;
  public static final String NAME = "addMapMarkers";
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.f paramf, final JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143661);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.Map.JsApiAddMapMarkers", "data is null");
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(143661);
      return;
    }
    Log.i("MicroMsg.Map.JsApiAddMapMarkers", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.o.a.b localb = g(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.Map.JsApiAddMapMarkers", "mapView is null, return");
      paramf.callback(paramInt, ZP("fail:mapview is null"));
      AppMethodBeat.o(143661);
      return;
    }
    boolean bool = paramJSONObject.optBoolean("clear", true);
    Log.i("MicroMsg.Map.JsApiAddMapMarkers", "clear:%b", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      localb.csR();
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
          paramf.callback(paramInt, ZP("fail:internal error"));
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
              b.v localv = a(paramf, paramJSONObject, (JSONObject)localObject2);
              localObject2 = ((JSONObject)localObject2).optString("id");
              if (localv.sej != null) {
                Log.i("MicroMsg.Map.JsApiAddMapMarkers", "id:%s, label:%s, joinCluster:%b, clusterId:%d", new Object[] { localObject2, localv.sej.content, Boolean.valueOf(localv.sed), Integer.valueOf(localv.sdH) });
              }
              if ((localv.sed) && (!localb.csV()) && (!localb.csW())) {
                localb.a(true, true, 2, 60, new b.q()
                {
                  public final void ao(JSONObject paramAnonymousJSONObject)
                  {
                    AppMethodBeat.i(329475);
                    u.a locala = new u.a();
                    HashMap localHashMap = new HashMap();
                    localHashMap.put("cluster", paramAnonymousJSONObject);
                    localHashMap.put("mapId", Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.o.a.f.ap(paramJSONObject)));
                    locala.L(localHashMap);
                    Log.i("MicroMsg.Map.JsApiAddMapMarkers", "click clusterInfo:%s", new Object[] { paramAnonymousJSONObject });
                    paramAnonymousJSONObject = ((g)paramf.T(g.class)).c(paramf, paramJSONObject);
                    if (paramAnonymousJSONObject != null)
                    {
                      paramAnonymousJSONObject.a(locala, null);
                      AppMethodBeat.o(329475);
                      return;
                    }
                    paramf.a(locala);
                    AppMethodBeat.o(329475);
                  }
                  
                  public final void s(JSONArray paramAnonymousJSONArray)
                  {
                    AppMethodBeat.i(329473);
                    u.b localb = new u.b();
                    HashMap localHashMap = new HashMap();
                    localHashMap.put("clusters", paramAnonymousJSONArray);
                    localHashMap.put("mapId", Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.o.a.f.ap(paramJSONObject)));
                    localb.L(localHashMap);
                    Log.i("MicroMsg.Map.JsApiAddMapMarkers", "create clusterInfo:%s", new Object[] { paramAnonymousJSONArray });
                    paramAnonymousJSONArray = ((g)paramf.T(g.class)).c(paramf, paramJSONObject);
                    if (paramAnonymousJSONArray != null)
                    {
                      paramAnonymousJSONArray.a(localb, null);
                      AppMethodBeat.o(329473);
                      return;
                    }
                    paramf.a(localb);
                    AppMethodBeat.o(329473);
                  }
                });
              }
              localb.a((String)localObject2, localv, (a)paramf.T(a.class));
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
    a(paramf, paramInt, ZP("ok"), true, localb.csM());
    AppMethodBeat.o(143661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.i
 * JD-Core Version:    0.7.0.1
 */