package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.v;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ai
  extends b
{
  public static final int CTRL_INDEX = 133;
  public static final String NAME = "updateMapMarkers";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(183553);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.JsApiUpdateMapMarkers", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(183553);
      return;
    }
    ae.i("MicroMsg.JsApiUpdateMapMarkers", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.i.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ae.e("MicroMsg.JsApiUpdateMapMarkers", "mapView is null, return");
      paramc.h(paramInt, e("fail:mapview is null", null));
      AppMethodBeat.o(183553);
      return;
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
          ae.e("MicroMsg.JsApiUpdateMapMarkers", "markersArray is null, return");
          paramc.h(paramInt, e("fail:internal error", null));
          AppMethodBeat.o(183553);
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
              paramc.K(a.class);
              localb.a((String)localObject2, localv);
            }
            i += 1;
          }
          catch (JSONException localJSONException2)
          {
            for (;;)
            {
              ae.printErrStackTrace("MicroMsg.JsApiUpdateMapMarkers", localJSONException2, "", new Object[0]);
              Object localObject3 = null;
            }
          }
        }
      }
    }
    a(paramc, paramInt, e("ok", null), true, localb.blB());
    AppMethodBeat.o(183553);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.ai
 * JD-Core Version:    0.7.0.1
 */