package com.tencent.mm.plugin.appbrand.jsapi.f;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

public final class z
  extends b
{
  public static final int CTRL_INDEX = 860;
  public static final String NAME = "setMapIndoorMaskColor";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(205031);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.JsApiSetMapIndoorMaskColor", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(205031);
      return;
    }
    ac.i("MicroMsg.JsApiSetMapIndoorMaskColor", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.f.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ac.e("MicroMsg.JsApiSetMapIndoorMaskColor", "mapView is null, return");
      paramc.h(paramInt, e("fail:mapview is null", null));
      AppMethodBeat.o(205031);
      return;
    }
    localb.setIndoorMaskColor(g.cd(paramJSONObject.optString("maskColor", "#000000"), Color.parseColor("#000000")));
    paramc.h(paramInt, e("ok", null));
    AppMethodBeat.o(205031);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.z
 * JD-Core Version:    0.7.0.1
 */