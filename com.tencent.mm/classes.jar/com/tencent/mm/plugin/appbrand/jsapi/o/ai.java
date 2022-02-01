package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class ai
  extends b
{
  public static final int CTRL_INDEX = 860;
  public static final String NAME = "setMapIndoorMaskColor";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(329470);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiSetMapIndoorMaskColor", "data is null");
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(329470);
      return;
    }
    Log.i("MicroMsg.JsApiSetMapIndoorMaskColor", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.o.a.b localb = g(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiSetMapIndoorMaskColor", "mapView is null, return");
      paramf.callback(paramInt, ZP("fail:mapview is null"));
      AppMethodBeat.o(329470);
      return;
    }
    localb.setIndoorMaskColor(i.dq(paramJSONObject.optString("maskColor", "#000000"), Color.parseColor("#000000")));
    paramf.callback(paramInt, ZP("ok"));
    AppMethodBeat.o(329470);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.ai
 * JD-Core Version:    0.7.0.1
 */