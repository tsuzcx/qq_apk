package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class y
  extends b
{
  public static final int CTRL_INDEX = 786;
  public static final String NAME = "removeMapCustomLayer";
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(183552);
    super.a(parame, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiRemoveMapCustomLayer", "data is null");
      parame.j(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(183552);
      return;
    }
    Log.i("MicroMsg.JsApiRemoveMapCustomLayer", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.l.a.b localb = g(parame, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiRemoveMapCustomLayer", "mapView is null, return");
      parame.j(paramInt, h("fail:mapview is null", null));
      AppMethodBeat.o(183552);
      return;
    }
    localb.ahI(paramJSONObject.optString("layerId", ""));
    a(parame, paramInt, h("ok", null), true, localb.bSF());
    AppMethodBeat.o(183552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.y
 * JD-Core Version:    0.7.0.1
 */