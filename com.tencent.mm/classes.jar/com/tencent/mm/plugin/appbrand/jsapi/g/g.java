package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.t;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
  extends b
{
  public static final int CTRL_INDEX = 133;
  public static final String NAME = "addMapMarkers";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
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
    com.tencent.mm.plugin.appbrand.jsapi.g.a.b localb = h(paramc, paramJSONObject);
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
      localb.bay();
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
            JSONObject localJSONObject = (JSONObject)localObject1.get(i);
            if (localJSONObject != null)
            {
              b.t localt = a(paramc, paramJSONObject, localJSONObject);
              localb.a(localJSONObject.optString("id"), localt, (a)paramc.K(a.class));
            }
            i += 1;
          }
          catch (JSONException localJSONException2)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.JsApiAddMapMarkers", localJSONException2, "", new Object[0]);
              Object localObject2 = null;
            }
          }
        }
      }
    }
    a(paramc, paramInt, e("ok", null), true, localb.bat());
    AppMethodBeat.o(143661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.g
 * JD-Core Version:    0.7.0.1
 */