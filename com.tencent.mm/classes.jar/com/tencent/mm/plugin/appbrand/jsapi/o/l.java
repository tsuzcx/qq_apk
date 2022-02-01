package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class l
  extends b
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "eraseMapLines";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143663);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiEraseMapLines", "data is null");
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(143663);
      return;
    }
    Log.i("MicroMsg.JsApiEraseMapLines", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.o.a.b localb = g(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiEraseMapLines", "mapView is null, return");
      paramf.callback(paramInt, ZP("fail:mapview is null"));
      AppMethodBeat.o(143663);
      return;
    }
    if (paramJSONObject.has("lines")) {}
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = new JSONArray(paramJSONObject.optString("lines"));
        i = 0;
        if (i < localJSONArray.length())
        {
          JSONObject localJSONObject1 = (JSONObject)localJSONArray.get(i);
          String str = localJSONObject1.optString("id");
          if (Util.isNullOrNil(str)) {
            break label342;
          }
          paramJSONObject = null;
          JSONObject localJSONObject2 = localJSONObject1.optJSONObject("point");
          if (localJSONObject2 != null) {
            paramJSONObject = new b.i(Util.getDouble(localJSONObject2.optString("latitude"), 0.0D), Util.getDouble(localJSONObject2.optString("longitude"), 0.0D));
          }
          if (paramJSONObject == null) {
            break label342;
          }
          localb.a(str, localJSONObject1.optInt("index", 0), paramJSONObject, localJSONObject1.optBoolean("clear", true));
          break label342;
        }
        a(paramf, paramInt, ZP("ok"), true, localb.csM());
        AppMethodBeat.o(143663);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        Log.printInfoStack("MicroMsg.JsApiEraseMapLines", "", new Object[] { paramJSONObject });
        a(paramf, paramInt, ZP("fail:internal error"), false, localb.csM());
        AppMethodBeat.o(143663);
        return;
      }
      Log.e("MicroMsg.JsApiEraseMapLines", "data has not lines info");
      a(paramf, paramInt, ZP("fail:invalid data"), false, localb.csM());
      AppMethodBeat.o(143663);
      return;
      label342:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.l
 * JD-Core Version:    0.7.0.1
 */