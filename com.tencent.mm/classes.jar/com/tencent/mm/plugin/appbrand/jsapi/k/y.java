package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class y
  extends b
{
  public static final int CTRL_INDEX = 786;
  public static final String NAME = "removeMapCustomLayer";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(183552);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiRemoveMapCustomLayer", "data is null");
      paramf.i(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(183552);
      return;
    }
    Log.i("MicroMsg.JsApiRemoveMapCustomLayer", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.k.a.b localb = h(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiRemoveMapCustomLayer", "mapView is null, return");
      paramf.i(paramInt, h("fail:mapview is null", null));
      AppMethodBeat.o(183552);
      return;
    }
    localb.ZS(paramJSONObject.optString("layerId", ""));
    a(paramf, paramInt, h("ok", null), true, localb.bGX());
    AppMethodBeat.o(183552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.y
 * JD-Core Version:    0.7.0.1
 */