package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ad
  extends b
{
  public static final int CTRL_INDEX = 343;
  public static final String NAME = "removeMapMarkers";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143690);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.Map.JsApiRemoveMapMarkers", "data is null");
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(143690);
      return;
    }
    Log.i("MicroMsg.Map.JsApiRemoveMapMarkers", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.o.a.b localb = g(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.Map.JsApiRemoveMapMarkers", "mapView is null, return");
      paramf.callback(paramInt, ZP("fail:mapview is null"));
      AppMethodBeat.o(143690);
      return;
    }
    if (paramJSONObject.has("markers")) {
      try
      {
        paramJSONObject = new JSONArray(paramJSONObject.optString("markers"));
        int i = 0;
        while (i < paramJSONObject.length())
        {
          localb.aaI(paramJSONObject.getString(i));
          i += 1;
        }
        a(paramf, paramInt, ZP("ok"), true, localb.csM());
      }
      catch (JSONException paramJSONObject)
      {
        Log.printErrStackTrace("MicroMsg.Map.JsApiRemoveMapMarkers", paramJSONObject, "", new Object[0]);
        paramf.callback(paramInt, ZP("fail:internal error"));
        AppMethodBeat.o(143690);
        return;
      }
    }
    AppMethodBeat.o(143690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.ad
 * JD-Core Version:    0.7.0.1
 */