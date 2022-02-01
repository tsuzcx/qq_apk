package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONException;
import org.json.JSONObject;

public final class ah
  extends b
{
  public static final int CTRL_INDEX = 891;
  public static final String NAME = "updateMapGroundOverlay";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(186158);
    super.a(paramc, paramJSONObject, paramInt);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiUpdateMapGroundOverlay", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(186158);
      return;
    }
    ad.i("MicroMsg.JsApiUpdateMapGroundOverlay", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.i.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ad.e("MicroMsg.JsApiUpdateMapGroundOverlay", "mapView is null, return");
      paramc.h(paramInt, e("fail:mapview is null", null));
      AppMethodBeat.o(186158);
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
          locale.kRG = new b.i(localJSONObject2.optDouble("latitude", 0.0D), localJSONObject2.optDouble("longitude", 0.0D));
        }
        if (localJSONObject1.has("northeast"))
        {
          localJSONObject1 = localJSONObject1.getJSONObject("northeast");
          locale.kRH = new b.i(localJSONObject1.optDouble("latitude", 0.0D), localJSONObject1.optDouble("longitude", 0.0D));
        }
      }
      boolean bool = paramJSONObject.optBoolean("visible", true);
      int j = paramJSONObject.optInt("zIndex", 1);
      double d = paramJSONObject.optDouble("opacity", 1.0D);
      locale.kRE = str;
      locale.visible = bool;
      locale.zIndex = j;
      locale.alpha = ((float)d);
      if (localb.b(i, locale, (a)paramc.K(a.class)))
      {
        ad.i("MicroMsg.JsApiUpdateMapGroundOverlay", "updateGroundOverlay ok");
        paramc.h(paramInt, e("ok", null));
        AppMethodBeat.o(186158);
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      ad.i("MicroMsg.JsApiUpdateMapGroundOverlay", "");
      ad.e("MicroMsg.JsApiUpdateMapGroundOverlay", "parse update groundOverlay error, exception : %s", new Object[] { paramJSONObject });
      a(paramc, paramInt, e("fail:internal error", null), false, localb.bkR());
      AppMethodBeat.o(186158);
      return;
    }
    ad.i("MicroMsg.JsApiUpdateMapGroundOverlay", "updateGroundOverlay fail");
    paramc.h(paramInt, e("fail", null));
    AppMethodBeat.o(186158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.ah
 * JD-Core Version:    0.7.0.1
 */