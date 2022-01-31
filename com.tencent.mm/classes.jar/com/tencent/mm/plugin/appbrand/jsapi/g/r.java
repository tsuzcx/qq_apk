package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class r
  extends a
{
  public static final int CTRL_INDEX = 555;
  public static final String NAME = "removeMapLines";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(93869);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiRemoveMapLines", "data is null");
      paramc.h(paramInt, j("fail:invalid data", null));
      AppMethodBeat.o(93869);
      return;
    }
    ab.i("MicroMsg.JsApiRemoveMapLines", "data:%s", new Object[] { paramJSONObject });
    b localb = f(paramc, paramJSONObject);
    if (localb == null)
    {
      ab.e("MicroMsg.JsApiRemoveMapLines", "mapView is null, return");
      paramc.h(paramInt, j("fail:mapview is null", null));
      AppMethodBeat.o(93869);
      return;
    }
    if (paramJSONObject.has("lines")) {
      try
      {
        paramJSONObject = new JSONArray(paramJSONObject.optString("lines"));
        int i = 0;
        while (i < paramJSONObject.length())
        {
          localb.Cg(paramJSONObject.getString(i));
          i += 1;
        }
        a(paramc, paramInt, j("ok", null), true, localb.aDx());
      }
      catch (JSONException paramJSONObject)
      {
        ab.printErrStackTrace("MicroMsg.JsApiRemoveMapLines", paramJSONObject, "", new Object[0]);
        paramc.h(paramInt, j("fail:internal error", null));
        AppMethodBeat.o(93869);
        return;
      }
    }
    AppMethodBeat.o(93869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.r
 * JD-Core Version:    0.7.0.1
 */