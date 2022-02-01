package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class z
  extends b
{
  public static final int CTRL_INDEX = 555;
  public static final String NAME = "removeMapLines";
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143689);
    super.a(parame, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiRemoveMapLines", "data is null");
      parame.j(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(143689);
      return;
    }
    Log.i("MicroMsg.JsApiRemoveMapLines", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.l.a.b localb = g(parame, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiRemoveMapLines", "mapView is null, return");
      parame.j(paramInt, h("fail:mapview is null", null));
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
          localb.ahJ(paramJSONObject.getString(i));
          i += 1;
        }
        a(parame, paramInt, h("ok", null), true, localb.bSF());
      }
      catch (JSONException paramJSONObject)
      {
        Log.printErrStackTrace("MicroMsg.JsApiRemoveMapLines", paramJSONObject, "", new Object[0]);
        parame.j(paramInt, h("fail:internal error", null));
        AppMethodBeat.o(143689);
        return;
      }
    }
    AppMethodBeat.o(143689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.z
 * JD-Core Version:    0.7.0.1
 */