package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.v;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ao
  extends b
{
  public static final int CTRL_INDEX = 133;
  public static final String NAME = "updateMapMarkers";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(183553);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.Map.JsApiUpdateMapMarkers", "data is null");
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(183553);
      return;
    }
    Log.i("MicroMsg.Map.JsApiUpdateMapMarkers", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.o.a.b localb = g(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.Map.JsApiUpdateMapMarkers", "mapView is null, return");
      paramf.callback(paramInt, ZP("fail:mapview is null"));
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
          Log.e("MicroMsg.Map.JsApiUpdateMapMarkers", "markersArray is null, return");
          paramf.callback(paramInt, ZP("fail:internal error"));
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
              b.v localv = a(paramf, paramJSONObject, (JSONObject)localObject2);
              localObject2 = ((JSONObject)localObject2).optString("id");
              paramf.T(a.class);
              localb.a((String)localObject2, localv);
            }
            i += 1;
          }
          catch (JSONException localJSONException2)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.Map.JsApiUpdateMapMarkers", localJSONException2, "", new Object[0]);
              Object localObject3 = null;
            }
          }
        }
      }
    }
    a(paramf, paramInt, ZP("ok"), true, localb.csM());
    AppMethodBeat.o(183553);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.ao
 * JD-Core Version:    0.7.0.1
 */