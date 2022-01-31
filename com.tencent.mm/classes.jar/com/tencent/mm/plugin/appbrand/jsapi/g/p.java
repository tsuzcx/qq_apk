package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class p
  extends a
{
  public static final int CTRL_INDEX = 141;
  public static final String NAME = "moveToMapLocation";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(93866);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiMoveToMapLocation", "data is null");
      paramc.h(paramInt, j("fail:invalid data", null));
      AppMethodBeat.o(93866);
      return;
    }
    ab.i("MicroMsg.JsApiMoveToMapLocation", "moveToMapLocation data:%s", new Object[] { paramJSONObject });
    b localb = f(paramc, paramJSONObject);
    if (localb == null)
    {
      ab.e("MicroMsg.JsApiMoveToMapLocation", "mapView is null, return");
      paramc.h(paramInt, j("fail:mapview is null", null));
      AppMethodBeat.o(93866);
      return;
    }
    if ((paramJSONObject.has("latitude")) || (paramJSONObject.has("longitude"))) {
      localb.L(bo.getFloat(paramJSONObject.optString("latitude"), 0.0F), bo.getFloat(paramJSONObject.optString("longitude"), 0.0F));
    }
    for (;;)
    {
      a(paramc, paramInt, j("ok", null), true, localb.aDx());
      AppMethodBeat.o(93866);
      return;
      localb.aDu();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.p
 * JD-Core Version:    0.7.0.1
 */