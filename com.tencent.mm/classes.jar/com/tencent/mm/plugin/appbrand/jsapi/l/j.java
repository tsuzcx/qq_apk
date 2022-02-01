package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.l.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
  extends b
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "eraseMapLines";
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143663);
    super.a(parame, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiEraseMapLines", "data is null");
      parame.j(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(143663);
      return;
    }
    Log.i("MicroMsg.JsApiEraseMapLines", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.l.a.b localb = g(parame, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiEraseMapLines", "mapView is null, return");
      parame.j(paramInt, h("fail:mapview is null", null));
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
            break label347;
          }
          paramJSONObject = null;
          JSONObject localJSONObject2 = localJSONObject1.optJSONObject("point");
          if (localJSONObject2 != null) {
            paramJSONObject = new b.i(Util.getDouble(localJSONObject2.optString("latitude"), 0.0D), Util.getDouble(localJSONObject2.optString("longitude"), 0.0D));
          }
          if (paramJSONObject == null) {
            break label347;
          }
          localb.a(str, localJSONObject1.optInt("index", 0), paramJSONObject, localJSONObject1.optBoolean("clear", true));
          break label347;
        }
        a(parame, paramInt, h("ok", null), true, localb.bSF());
        AppMethodBeat.o(143663);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        Log.printInfoStack("MicroMsg.JsApiEraseMapLines", "", new Object[] { paramJSONObject });
        a(parame, paramInt, h("fail:internal error", null), false, localb.bSF());
        AppMethodBeat.o(143663);
        return;
      }
      Log.e("MicroMsg.JsApiEraseMapLines", "data has not lines info");
      a(parame, paramInt, h("fail:invalid data", null), false, localb.bSF());
      AppMethodBeat.o(143663);
      return;
      label347:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.j
 * JD-Core Version:    0.7.0.1
 */