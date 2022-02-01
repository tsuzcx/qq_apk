package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
  extends b
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "eraseMapLines";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143663);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiEraseMapLines", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(143663);
      return;
    }
    ad.i("MicroMsg.JsApiEraseMapLines", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.i.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ad.e("MicroMsg.JsApiEraseMapLines", "mapView is null, return");
      paramc.h(paramInt, e("fail:mapview is null", null));
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
          if (bt.isNullOrNil(str)) {
            break label347;
          }
          paramJSONObject = null;
          JSONObject localJSONObject2 = localJSONObject1.optJSONObject("point");
          if (localJSONObject2 != null) {
            paramJSONObject = new b.i(bt.getDouble(localJSONObject2.optString("latitude"), 0.0D), bt.getDouble(localJSONObject2.optString("longitude"), 0.0D));
          }
          if (paramJSONObject == null) {
            break label347;
          }
          localb.a(str, localJSONObject1.optInt("index", 0), paramJSONObject, localJSONObject1.optBoolean("clear", true));
          break label347;
        }
        a(paramc, paramInt, e("ok", null), true, localb.bkR());
        AppMethodBeat.o(143663);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        ad.m("MicroMsg.JsApiEraseMapLines", "", new Object[] { paramJSONObject });
        a(paramc, paramInt, e("fail:internal error", null), false, localb.bkR());
        AppMethodBeat.o(143663);
        return;
      }
      ad.e("MicroMsg.JsApiEraseMapLines", "data has not lines info");
      a(paramc, paramInt, e("fail:invalid data", null), false, localb.bkR());
      AppMethodBeat.o(143663);
      return;
      label347:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.j
 * JD-Core Version:    0.7.0.1
 */