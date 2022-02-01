package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class e
  extends b
{
  public static final int CTRL_INDEX = 785;
  public static final String NAME = "addMapCustomLayer";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(183551);
    super.a(parame, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiAddMapCustomLayer", "data is null");
      parame.j(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(183551);
      return;
    }
    Log.i("MicroMsg.JsApiAddMapCustomLayer", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.l.a.b localb = g(parame, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiAddMapCustomLayer", "mapView is null, return");
      parame.j(paramInt, h("fail:mapview is null", null));
      AppMethodBeat.o(183551);
      return;
    }
    localb.ahH(paramJSONObject.optString("layerId", ""));
    a(parame, paramInt, h("ok", null), true, localb.bSF());
    AppMethodBeat.o(183551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.e
 * JD-Core Version:    0.7.0.1
 */