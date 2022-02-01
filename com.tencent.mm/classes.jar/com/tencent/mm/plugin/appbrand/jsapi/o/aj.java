package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class aj
  extends b
{
  public static final int CTRL_INDEX = 993;
  public static final String NAME = "setMapLocMarkerIcon";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(329481);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiSetMapLocMarkerIcon", "data is null");
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(329481);
      return;
    }
    Log.i("MicroMsg.JsApiSetMapLocMarkerIcon", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.o.a.b localb = g(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiSetMapLocMarkerIcon", "mapView is null, return");
      paramf.callback(paramInt, ZP("fail:mapview is null"));
      AppMethodBeat.o(329481);
      return;
    }
    paramJSONObject = paramJSONObject.optString("iconPath");
    Log.i("MicroMsg.JsApiSetMapLocMarkerIcon", "iconPath:%s", new Object[] { paramJSONObject });
    if (TextUtils.isEmpty(paramJSONObject))
    {
      Log.e("MicroMsg.JsApiSetMapLocMarkerIcon", "iconPath is null, return");
      paramf.callback(paramInt, ZP("fail:iconPath is null"));
      AppMethodBeat.o(329481);
      return;
    }
    if ((!Util.isNullOrNil(paramJSONObject)) && (paramf.T(com.tencent.mm.plugin.appbrand.f.b.class) != null)) {
      localb.a(((com.tencent.mm.plugin.appbrand.f.b)paramf.T(com.tencent.mm.plugin.appbrand.f.b.class)).b(paramf, paramJSONObject), (a)paramf.T(a.class));
    }
    paramf.callback(paramInt, ZP("ok"));
    AppMethodBeat.o(329481);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.aj
 * JD-Core Version:    0.7.0.1
 */