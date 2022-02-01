package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONObject;

public final class v
  extends b
{
  public static final int CTRL_INDEX = 141;
  public static final String NAME = "moveToMapLocation";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143686);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.JsApiMoveToMapLocation", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(143686);
      return;
    }
    ae.i("MicroMsg.JsApiMoveToMapLocation", "moveToMapLocation data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.i.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ae.e("MicroMsg.JsApiMoveToMapLocation", "mapView is null, return");
      paramc.h(paramInt, e("fail:mapview is null", null));
      AppMethodBeat.o(143686);
      return;
    }
    if ((paramJSONObject.has("latitude")) || (paramJSONObject.has("longitude"))) {
      localb.f(bu.getDouble(paramJSONObject.optString("latitude"), 0.0D), bu.getDouble(paramJSONObject.optString("longitude"), 0.0D));
    }
    for (;;)
    {
      a(paramc, paramInt, e("ok", null), true, localb.blB());
      AppMethodBeat.o(143686);
      return;
      localb.blz();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.v
 * JD-Core Version:    0.7.0.1
 */