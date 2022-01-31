package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
  extends a
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "eraseMapLines";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(93844);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiEraseMapLines", "data is null");
      paramc.h(paramInt, j("fail:invalid data", null));
      AppMethodBeat.o(93844);
      return;
    }
    ab.i("MicroMsg.JsApiEraseMapLines", "data:%s", new Object[] { paramJSONObject });
    b localb = f(paramc, paramJSONObject);
    if (localb == null)
    {
      ab.e("MicroMsg.JsApiEraseMapLines", "mapView is null, return");
      paramc.h(paramInt, j("fail:mapview is null", null));
      AppMethodBeat.o(93844);
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
          if (bo.isNullOrNil(str)) {
            break label357;
          }
          paramJSONObject = null;
          JSONObject localJSONObject2 = localJSONObject1.optJSONObject("point");
          if (localJSONObject2 != null)
          {
            float f1 = bo.getFloat(localJSONObject2.optString("latitude"), 0.0F);
            float f2 = bo.getFloat(localJSONObject2.optString("longitude"), 0.0F);
            paramJSONObject = new b.h(f1, f2);
          }
          if (paramJSONObject == null) {
            break label357;
          }
          localb.a(str, localJSONObject1.optInt("index", 0), paramJSONObject, localJSONObject1.optBoolean("clear", true));
          break label357;
        }
        a(paramc, paramInt, j("ok", null), true, localb.aDx());
        AppMethodBeat.o(93844);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        ab.b("MicroMsg.JsApiEraseMapLines", "", new Object[] { paramJSONObject });
        a(paramc, paramInt, j("fail:internal error", null), false, localb.aDx());
        AppMethodBeat.o(93844);
        return;
      }
      ab.e("MicroMsg.JsApiEraseMapLines", "data has not lines info");
      a(paramc, paramInt, j("fail:invalid data", null), false, localb.aDx());
      AppMethodBeat.o(93844);
      return;
      label357:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.g
 * JD-Core Version:    0.7.0.1
 */