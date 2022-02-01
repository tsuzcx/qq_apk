package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class v
  extends b
{
  public static final int CTRL_INDEX = 141;
  public static final String NAME = "moveToMapLocation";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143686);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiMoveToMapLocation", "data is null");
      paramf.i(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(143686);
      return;
    }
    Log.i("MicroMsg.JsApiMoveToMapLocation", "moveToMapLocation data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.k.a.b localb = h(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiMoveToMapLocation", "mapView is null, return");
      paramf.i(paramInt, h("fail:mapview is null", null));
      AppMethodBeat.o(143686);
      return;
    }
    if ((paramJSONObject.has("latitude")) || (paramJSONObject.has("longitude"))) {
      localb.f(Util.getDouble(paramJSONObject.optString("latitude"), 0.0D), Util.getDouble(paramJSONObject.optString("longitude"), 0.0D));
    }
    for (;;)
    {
      a(paramf, paramInt, h("ok", null), true, localb.bGX());
      AppMethodBeat.o(143686);
      return;
      localb.bGV();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.v
 * JD-Core Version:    0.7.0.1
 */