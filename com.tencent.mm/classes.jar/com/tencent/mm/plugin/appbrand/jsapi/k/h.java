package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.q;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.v;
import com.tencent.mm.plugin.appbrand.jsapi.p;
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
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.f paramf, final JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143661);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiAddMapMarkers", "data is null");
      paramf.i(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(143661);
      return;
    }
    Log.i("MicroMsg.JsApiAddMapMarkers", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.k.a.b localb = h(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiAddMapMarkers", "mapView is null, return");
      paramf.i(paramInt, h("fail:mapview is null", null));
      AppMethodBeat.o(143661);
      return;
    }
    boolean bool = paramJSONObject.optBoolean("clear", true);
    Log.i("MicroMsg.JsApiAddMapMarkers", "clear:%b", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      localb.bHc();
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
          Log.e("MicroMsg.JsApiAddMapMarkers", "markersArray is null, return");
          paramf.i(paramInt, h("fail:internal error", null));
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
              if ((localv.maN) && (!localb.bHg()) && (!localb.bHh())) {
                localb.a(true, true, 2, 60, new b.q()
                {
                  public final void aa(JSONObject paramAnonymousJSONObject)
                  {
                    AppMethodBeat.i(234543);
                    s.a locala = new s.a();
                    HashMap localHashMap = new HashMap();
                    localHashMap.put("cluster", paramAnonymousJSONObject);
                    localHashMap.put("mapId", Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.k.a.f.ab(paramJSONObject)));
                    locala.L(localHashMap);
                    Log.i("MicroMsg.JsApiAddMapMarkers", "click clusterInfo:%s", new Object[] { paramAnonymousJSONObject });
                    paramAnonymousJSONObject = ((g)paramf.M(g.class)).c(paramf, paramJSONObject);
                    if (paramAnonymousJSONObject != null)
                    {
                      paramAnonymousJSONObject.a(locala, null);
                      AppMethodBeat.o(234543);
                      return;
                    }
                    paramf.a(locala);
                    AppMethodBeat.o(234543);
                  }
                  
                  public final void p(JSONArray paramAnonymousJSONArray)
                  {
                    AppMethodBeat.i(234542);
                    s.b localb = new s.b();
                    HashMap localHashMap = new HashMap();
                    localHashMap.put("clusters", paramAnonymousJSONArray);
                    localHashMap.put("mapId", Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.k.a.f.ab(paramJSONObject)));
                    localb.L(localHashMap);
                    Log.i("MicroMsg.JsApiAddMapMarkers", "create clusterInfo:%s", new Object[] { paramAnonymousJSONArray });
                    paramAnonymousJSONArray = ((g)paramf.M(g.class)).c(paramf, paramJSONObject);
                    if (paramAnonymousJSONArray != null)
                    {
                      paramAnonymousJSONArray.a(localb, null);
                      AppMethodBeat.o(234542);
                      return;
                    }
                    paramf.a(localb);
                    AppMethodBeat.o(234542);
                  }
                });
              }
              localb.a((String)localObject2, localv, (a)paramf.M(a.class));
            }
            i += 1;
          }
          catch (JSONException localJSONException2)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.JsApiAddMapMarkers", localJSONException2, "", new Object[0]);
              Object localObject3 = null;
            }
          }
        }
      }
    }
    a(paramf, paramInt, h("ok", null), true, localb.bGX());
    AppMethodBeat.o(143661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.h
 * JD-Core Version:    0.7.0.1
 */