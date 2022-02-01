package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class ac
  extends b
{
  public static final int CTRL_INDEX = 526;
  public static final String NAME = "setMapIndoorFloor";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143692);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiSetMapIndoorFloor", "data is null");
      paramf.i(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(143692);
      return;
    }
    Log.i("MicroMsg.JsApiSetMapIndoorFloor", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.k.a.b localb = h(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiSetMapIndoorFloor", "mapView is null, return");
      paramf.i(paramInt, h("fail:mapview is null", null));
      AppMethodBeat.o(143692);
      return;
    }
    localb.dy(paramJSONObject.optString("buildingId"), paramJSONObject.optString("floorName"));
    a(paramf, paramInt, h("ok", null), true, localb.bGX());
    AppMethodBeat.o(143692);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.ac
 * JD-Core Version:    0.7.0.1
 */