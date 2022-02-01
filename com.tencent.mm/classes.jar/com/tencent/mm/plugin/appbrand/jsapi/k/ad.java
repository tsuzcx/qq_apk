package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class ad
  extends b
{
  public static final int CTRL_INDEX = 860;
  public static final String NAME = "setMapIndoorMaskColor";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(234559);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiSetMapIndoorMaskColor", "data is null");
      paramf.i(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(234559);
      return;
    }
    Log.i("MicroMsg.JsApiSetMapIndoorMaskColor", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.k.a.b localb = h(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiSetMapIndoorMaskColor", "mapView is null, return");
      paramf.i(paramInt, h("fail:mapview is null", null));
      AppMethodBeat.o(234559);
      return;
    }
    localb.setIndoorMaskColor(g.cu(paramJSONObject.optString("maskColor", "#000000"), Color.parseColor("#000000")));
    paramf.i(paramInt, h("ok", null));
    AppMethodBeat.o(234559);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.ad
 * JD-Core Version:    0.7.0.1
 */