package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ac
  extends b
{
  public static final int CTRL_INDEX = 555;
  public static final String NAME = "removeMapLines";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143689);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiRemoveMapLines", "data is null");
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(143689);
      return;
    }
    Log.i("MicroMsg.JsApiRemoveMapLines", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.o.a.b localb = g(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiRemoveMapLines", "mapView is null, return");
      paramf.callback(paramInt, ZP("fail:mapview is null"));
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
          localb.aaG(paramJSONObject.getString(i));
          i += 1;
        }
        a(paramf, paramInt, ZP("ok"), true, localb.csM());
      }
      catch (JSONException paramJSONObject)
      {
        Log.printErrStackTrace("MicroMsg.JsApiRemoveMapLines", paramJSONObject, "", new Object[0]);
        paramf.callback(paramInt, ZP("fail:internal error"));
        AppMethodBeat.o(143689);
        return;
      }
    }
    AppMethodBeat.o(143689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.ac
 * JD-Core Version:    0.7.0.1
 */