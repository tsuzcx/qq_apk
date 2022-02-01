package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class ah
  extends b
{
  public static final int CTRL_INDEX = 891;
  public static final String NAME = "updateMapGroundOverlay";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(234561);
    super.a(paramf, paramJSONObject, paramInt);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiUpdateMapGroundOverlay", "data is null");
      paramf.i(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(234561);
      return;
    }
    Log.i("MicroMsg.JsApiUpdateMapGroundOverlay", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.k.a.b localb = h(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiUpdateMapGroundOverlay", "mapView is null, return");
      paramf.i(paramInt, h("fail:mapview is null", null));
      AppMethodBeat.o(234561);
      return;
    }
    try
    {
      b.e locale = new b.e();
      int i = paramJSONObject.getInt("id");
      String str = paramJSONObject.getString("src");
      if (paramJSONObject.has("bounds"))
      {
        JSONObject localJSONObject1 = paramJSONObject.getJSONObject("bounds");
        if (localJSONObject1.has("southwest"))
        {
          JSONObject localJSONObject2 = localJSONObject1.getJSONObject("southwest");
          locale.may = new b.i(localJSONObject2.optDouble("latitude", 0.0D), localJSONObject2.optDouble("longitude", 0.0D));
        }
        if (localJSONObject1.has("northeast"))
        {
          localJSONObject1 = localJSONObject1.getJSONObject("northeast");
          locale.maz = new b.i(localJSONObject1.optDouble("latitude", 0.0D), localJSONObject1.optDouble("longitude", 0.0D));
        }
      }
      boolean bool = paramJSONObject.optBoolean("visible", true);
      int j = paramJSONObject.optInt("zIndex", 1);
      double d = paramJSONObject.optDouble("opacity", 1.0D);
      locale.mav = str;
      locale.visible = bool;
      locale.zIndex = j;
      locale.alpha = ((float)d);
      if (localb.b(i, locale, (a)paramf.M(a.class)))
      {
        Log.i("MicroMsg.JsApiUpdateMapGroundOverlay", "updateGroundOverlay ok");
        paramf.i(paramInt, h("ok", null));
        AppMethodBeat.o(234561);
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      Log.i("MicroMsg.JsApiUpdateMapGroundOverlay", "");
      Log.e("MicroMsg.JsApiUpdateMapGroundOverlay", "parse update groundOverlay error, exception : %s", new Object[] { paramJSONObject });
      a(paramf, paramInt, h("fail:internal error", null), false, localb.bGX());
      AppMethodBeat.o(234561);
      return;
    }
    Log.i("MicroMsg.JsApiUpdateMapGroundOverlay", "updateGroundOverlay fail");
    paramf.i(paramInt, h("fail", null));
    AppMethodBeat.o(234561);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.ah
 * JD-Core Version:    0.7.0.1
 */