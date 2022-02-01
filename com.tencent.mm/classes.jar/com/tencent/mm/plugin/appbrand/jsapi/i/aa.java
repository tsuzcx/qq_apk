package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class aa
  extends b
{
  public static final int CTRL_INDEX = 343;
  public static final String NAME = "removeMapMarkers";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143690);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiRemoveMapMarkers", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(143690);
      return;
    }
    ad.i("MicroMsg.JsApiRemoveMapMarkers", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.i.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ad.e("MicroMsg.JsApiRemoveMapMarkers", "mapView is null, return");
      paramc.h(paramInt, e("fail:mapview is null", null));
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
          localb.PM(paramJSONObject.getString(i));
          i += 1;
        }
        a(paramc, paramInt, e("ok", null), true, localb.bkR());
      }
      catch (JSONException paramJSONObject)
      {
        ad.printErrStackTrace("MicroMsg.JsApiRemoveMapMarkers", paramJSONObject, "", new Object[0]);
        paramc.h(paramInt, e("fail:internal error", null));
        AppMethodBeat.o(143690);
        return;
      }
    }
    AppMethodBeat.o(143690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.aa
 * JD-Core Version:    0.7.0.1
 */