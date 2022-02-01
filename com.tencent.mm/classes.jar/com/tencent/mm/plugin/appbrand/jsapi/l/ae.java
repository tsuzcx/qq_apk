package com.tencent.mm.plugin.appbrand.jsapi.l;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class ae
  extends b
{
  public static final int CTRL_INDEX = 993;
  public static final String NAME = "setMapLocMarkerIcon";
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(193014);
    super.a(parame, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiSetMapLocMarkerIcon", "data is null");
      parame.j(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(193014);
      return;
    }
    Log.i("MicroMsg.JsApiSetMapLocMarkerIcon", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.l.a.b localb = g(parame, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiSetMapLocMarkerIcon", "mapView is null, return");
      parame.j(paramInt, h("fail:mapview is null", null));
      AppMethodBeat.o(193014);
      return;
    }
    paramJSONObject = paramJSONObject.optString("iconPath");
    Log.i("MicroMsg.JsApiSetMapLocMarkerIcon", "iconPath:%s", new Object[] { paramJSONObject });
    if (TextUtils.isEmpty(paramJSONObject))
    {
      Log.e("MicroMsg.JsApiSetMapLocMarkerIcon", "iconPath is null, return");
      parame.j(paramInt, h("fail:iconPath is null", null));
      AppMethodBeat.o(193014);
      return;
    }
    if ((!Util.isNullOrNil(paramJSONObject)) && (parame.K(com.tencent.mm.plugin.appbrand.f.b.class) != null)) {
      localb.a(((com.tencent.mm.plugin.appbrand.f.b)parame.K(com.tencent.mm.plugin.appbrand.f.b.class)).b(parame, paramJSONObject), (a)parame.K(a.class));
    }
    parame.j(paramInt, h("ok", null));
    AppMethodBeat.o(193014);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.ae
 * JD-Core Version:    0.7.0.1
 */