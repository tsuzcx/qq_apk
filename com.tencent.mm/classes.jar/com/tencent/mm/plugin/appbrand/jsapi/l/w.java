package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class w
  extends b
{
  public static final int CTRL_INDEX = 890;
  public static final String NAME = "removeMapGroundOverlay";
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(193443);
    super.a(parame, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiRemoveGroundOverlay", "data is null");
      parame.j(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(193443);
      return;
    }
    Log.i("MicroMsg.JsApiRemoveGroundOverlay", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.l.a.b localb = g(parame, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiRemoveGroundOverlay", "mapView is null, return");
      parame.j(paramInt, h("fail:mapview is null", null));
      AppMethodBeat.o(193443);
      return;
    }
    try
    {
      if (localb.AB(paramJSONObject.getInt("id")))
      {
        Log.i("MicroMsg.JsApiRemoveGroundOverlay", "removeGroundOverlay success");
        parame.j(paramInt, h("ok", null));
        AppMethodBeat.o(193443);
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      Log.i("MicroMsg.JsApiRemoveGroundOverlay", "");
      Log.e("MicroMsg.JsApiRemoveGroundOverlay", "parse remove groundOverlay error, exception : %s", new Object[] { paramJSONObject });
      a(parame, paramInt, h("fail:internal error", null), false, localb.bSF());
      AppMethodBeat.o(193443);
      return;
    }
    Log.i("MicroMsg.JsApiRemoveGroundOverlay", "removeGroundOverlay fail");
    parame.j(paramInt, h("fail", null));
    AppMethodBeat.o(193443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.w
 * JD-Core Version:    0.7.0.1
 */