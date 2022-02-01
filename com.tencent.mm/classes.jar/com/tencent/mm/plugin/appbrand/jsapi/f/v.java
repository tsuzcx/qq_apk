package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class v
  extends b
{
  public static final int CTRL_INDEX = 555;
  public static final String NAME = "removeMapLines";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143689);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.JsApiRemoveMapLines", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(143689);
      return;
    }
    ac.i("MicroMsg.JsApiRemoveMapLines", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.f.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ac.e("MicroMsg.JsApiRemoveMapLines", "mapView is null, return");
      paramc.h(paramInt, e("fail:mapview is null", null));
      AppMethodBeat.o(143689);
      return;
    }
    if (paramJSONObject.has("lines")) {
      try
      {
        paramJSONObject = new JSONArray(paramJSONObject.optString("lines"));
        int i = 0;
        while (i < paramJSONObject.length())
        {
          localb.Mo(paramJSONObject.getString(i));
          i += 1;
        }
        a(paramc, paramInt, e("ok", null), true, localb.bhm());
      }
      catch (JSONException paramJSONObject)
      {
        ac.printErrStackTrace("MicroMsg.JsApiRemoveMapLines", paramJSONObject, "", new Object[0]);
        paramc.h(paramInt, e("fail:internal error", null));
        AppMethodBeat.o(143689);
        return;
      }
    }
    AppMethodBeat.o(143689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.v
 * JD-Core Version:    0.7.0.1
 */