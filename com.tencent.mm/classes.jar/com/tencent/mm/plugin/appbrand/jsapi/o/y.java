package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class y
  extends b
{
  public static final int CTRL_INDEX = 890;
  public static final String NAME = "removeMapGroundOverlay";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(329467);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiRemoveGroundOverlay", "data is null");
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(329467);
      return;
    }
    Log.i("MicroMsg.JsApiRemoveGroundOverlay", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.o.a.b localb = g(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiRemoveGroundOverlay", "mapView is null, return");
      paramf.callback(paramInt, ZP("fail:mapview is null"));
      AppMethodBeat.o(329467);
      return;
    }
    try
    {
      if (localb.AO(paramJSONObject.getInt("id")))
      {
        Log.i("MicroMsg.JsApiRemoveGroundOverlay", "removeGroundOverlay success");
        paramf.callback(paramInt, ZP("ok"));
        AppMethodBeat.o(329467);
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      Log.i("MicroMsg.JsApiRemoveGroundOverlay", "");
      Log.e("MicroMsg.JsApiRemoveGroundOverlay", "parse remove groundOverlay error, exception : %s", new Object[] { paramJSONObject });
      a(paramf, paramInt, ZP("fail:internal error"), false, localb.csM());
      AppMethodBeat.o(329467);
      return;
    }
    Log.i("MicroMsg.JsApiRemoveGroundOverlay", "removeGroundOverlay fail");
    paramf.callback(paramInt, ZP("fail"));
    AppMethodBeat.o(329467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.y
 * JD-Core Version:    0.7.0.1
 */