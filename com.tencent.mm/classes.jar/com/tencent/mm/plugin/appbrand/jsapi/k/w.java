package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class w
  extends b
{
  public static final int CTRL_INDEX = 890;
  public static final String NAME = "removeMapGroundOverlay";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(234558);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiRemoveGroundOverlay", "data is null");
      paramf.i(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(234558);
      return;
    }
    Log.i("MicroMsg.JsApiRemoveGroundOverlay", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.k.a.b localb = h(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiRemoveGroundOverlay", "mapView is null, return");
      paramf.i(paramInt, h("fail:mapview is null", null));
      AppMethodBeat.o(234558);
      return;
    }
    try
    {
      if (localb.xf(paramJSONObject.getInt("id")))
      {
        Log.i("MicroMsg.JsApiRemoveGroundOverlay", "removeGroundOverlay success");
        paramf.i(paramInt, h("ok", null));
        AppMethodBeat.o(234558);
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      Log.i("MicroMsg.JsApiRemoveGroundOverlay", "");
      Log.e("MicroMsg.JsApiRemoveGroundOverlay", "parse remove groundOverlay error, exception : %s", new Object[] { paramJSONObject });
      a(paramf, paramInt, h("fail:internal error", null), false, localb.bGX());
      AppMethodBeat.o(234558);
      return;
    }
    Log.i("MicroMsg.JsApiRemoveGroundOverlay", "removeGroundOverlay fail");
    paramf.i(paramInt, h("fail", null));
    AppMethodBeat.o(234558);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.w
 * JD-Core Version:    0.7.0.1
 */