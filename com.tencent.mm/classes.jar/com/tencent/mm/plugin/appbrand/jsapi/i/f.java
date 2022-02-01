package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  extends b
{
  public static final int CTRL_INDEX = 889;
  public static final String NAME = "addMapGroundOverlay";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(206453);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.JsApiAddMapGroundOverlay", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(206453);
      return;
    }
    ae.i("MicroMsg.JsApiAddMapGroundOverlay", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.i.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ae.e("MicroMsg.JsApiAddMapGroundOverlay", "mapView is null, return");
      paramc.h(paramInt, e("fail:mapview is null", null));
      AppMethodBeat.o(206453);
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
          locale.kVp = new b.i(localJSONObject2.optDouble("latitude", 0.0D), localJSONObject2.optDouble("longitude", 0.0D));
        }
        if (localJSONObject1.has("northeast"))
        {
          localJSONObject1 = localJSONObject1.getJSONObject("northeast");
          locale.kVq = new b.i(localJSONObject1.optDouble("latitude", 0.0D), localJSONObject1.optDouble("longitude", 0.0D));
        }
      }
      boolean bool = paramJSONObject.optBoolean("visible", true);
      int j = paramJSONObject.optInt("zIndex", 1);
      double d = paramJSONObject.optDouble("opacity", 1.0D);
      locale.kVn = str;
      locale.visible = bool;
      locale.zIndex = j;
      locale.alpha = ((float)d);
      if (localb.a(i, locale, (a)paramc.K(a.class)))
      {
        ae.i("MicroMsg.JsApiAddMapGroundOverlay", "addGroundOverlay ok");
        paramc.h(paramInt, e("ok", null));
        AppMethodBeat.o(206453);
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      ae.i("MicroMsg.JsApiAddMapGroundOverlay", "");
      ae.e("MicroMsg.JsApiAddMapGroundOverlay", "parse add groundOverlay error, exception : %s", new Object[] { paramJSONObject });
      a(paramc, paramInt, e("fail:internal error", null), false, localb.blB());
      AppMethodBeat.o(206453);
      return;
    }
    ae.i("MicroMsg.JsApiAddMapGroundOverlay", "addGroundOverlay fail");
    paramc.h(paramInt, e("fail", null));
    AppMethodBeat.o(206453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.f
 * JD-Core Version:    0.7.0.1
 */