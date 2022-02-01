package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

public final class y
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
      ac.e("MicroMsg.JsApiSetMapIndoorFloor", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(143692);
      return;
    }
    ac.i("MicroMsg.JsApiSetMapIndoorFloor", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.f.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ac.e("MicroMsg.JsApiSetMapIndoorFloor", "mapView is null, return");
      paramc.h(paramInt, e("fail:mapview is null", null));
      AppMethodBeat.o(143692);
      return;
    }
    localb.de(paramJSONObject.optString("buildingId"), paramJSONObject.optString("floorName"));
    a(paramc, paramInt, e("ok", null), true, localb.bhm());
    AppMethodBeat.o(143692);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.y
 * JD-Core Version:    0.7.0.1
 */