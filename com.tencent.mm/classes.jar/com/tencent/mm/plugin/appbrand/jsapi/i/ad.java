package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public final class ad
  extends b
{
  public static final int CTRL_INDEX = 860;
  public static final String NAME = "setMapIndoorMaskColor";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(206471);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.JsApiSetMapIndoorMaskColor", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(206471);
      return;
    }
    ae.i("MicroMsg.JsApiSetMapIndoorMaskColor", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.i.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ae.e("MicroMsg.JsApiSetMapIndoorMaskColor", "mapView is null, return");
      paramc.h(paramInt, e("fail:mapview is null", null));
      AppMethodBeat.o(206471);
      return;
    }
    localb.setIndoorMaskColor(g.ck(paramJSONObject.optString("maskColor", "#000000"), Color.parseColor("#000000")));
    paramc.h(paramInt, e("ok", null));
    AppMethodBeat.o(206471);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.ad
 * JD-Core Version:    0.7.0.1
 */