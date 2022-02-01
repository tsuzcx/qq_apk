package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class ac
  extends b
{
  public static final int CTRL_INDEX = 526;
  public static final String NAME = "setMapIndoorFloor";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143692);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiSetMapIndoorFloor", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(143692);
      return;
    }
    ad.i("MicroMsg.JsApiSetMapIndoorFloor", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.i.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ad.e("MicroMsg.JsApiSetMapIndoorFloor", "mapView is null, return");
      paramc.h(paramInt, e("fail:mapview is null", null));
      AppMethodBeat.o(143692);
      return;
    }
    localb.dh(paramJSONObject.optString("buildingId"), paramJSONObject.optString("floorName"));
    a(paramc, paramInt, e("ok", null), true, localb.bkR());
    AppMethodBeat.o(143692);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.ac
 * JD-Core Version:    0.7.0.1
 */