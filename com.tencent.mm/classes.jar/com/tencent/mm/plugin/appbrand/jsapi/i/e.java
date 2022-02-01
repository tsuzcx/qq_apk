package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public final class e
  extends b
{
  public static final int CTRL_INDEX = 785;
  public static final String NAME = "addMapCustomLayer";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(183551);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.JsApiAddMapCustomLayer", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(183551);
      return;
    }
    ae.i("MicroMsg.JsApiAddMapCustomLayer", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.i.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ae.e("MicroMsg.JsApiAddMapCustomLayer", "mapView is null, return");
      paramc.h(paramInt, e("fail:mapview is null", null));
      AppMethodBeat.o(183551);
      return;
    }
    localb.Qq(paramJSONObject.optString("layerId", ""));
    a(paramc, paramInt, e("ok", null), true, localb.blB());
    AppMethodBeat.o(183551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.e
 * JD-Core Version:    0.7.0.1
 */