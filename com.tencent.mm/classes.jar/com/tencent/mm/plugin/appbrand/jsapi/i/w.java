package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONException;
import org.json.JSONObject;

public final class w
  extends b
{
  public static final int CTRL_INDEX = 890;
  public static final String NAME = "removeMapGroundOverlay";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(206470);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.JsApiRemoveGroundOverlay", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(206470);
      return;
    }
    ae.i("MicroMsg.JsApiRemoveGroundOverlay", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.i.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ae.e("MicroMsg.JsApiRemoveGroundOverlay", "mapView is null, return");
      paramc.h(paramInt, e("fail:mapview is null", null));
      AppMethodBeat.o(206470);
      return;
    }
    try
    {
      if (localb.tj(paramJSONObject.getInt("id")))
      {
        ae.i("MicroMsg.JsApiRemoveGroundOverlay", "removeGroundOverlay success");
        paramc.h(paramInt, e("ok", null));
        AppMethodBeat.o(206470);
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      ae.i("MicroMsg.JsApiRemoveGroundOverlay", "");
      ae.e("MicroMsg.JsApiRemoveGroundOverlay", "parse remove groundOverlay error, exception : %s", new Object[] { paramJSONObject });
      a(paramc, paramInt, e("fail:internal error", null), false, localb.blB());
      AppMethodBeat.o(206470);
      return;
    }
    ae.i("MicroMsg.JsApiRemoveGroundOverlay", "removeGroundOverlay fail");
    paramc.h(paramInt, e("fail", null));
    AppMethodBeat.o(206470);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.w
 * JD-Core Version:    0.7.0.1
 */