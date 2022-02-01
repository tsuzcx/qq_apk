package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONException;
import org.json.JSONObject;

public final class w
  extends b
{
  public static final int CTRL_INDEX = 890;
  public static final String NAME = "removeMapGroundOverlay";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(186155);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiRemoveGroundOverlay", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(186155);
      return;
    }
    ad.i("MicroMsg.JsApiRemoveGroundOverlay", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.i.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ad.e("MicroMsg.JsApiRemoveGroundOverlay", "mapView is null, return");
      paramc.h(paramInt, e("fail:mapview is null", null));
      AppMethodBeat.o(186155);
      return;
    }
    try
    {
      if (localb.tg(paramJSONObject.getInt("id")))
      {
        ad.i("MicroMsg.JsApiRemoveGroundOverlay", "removeGroundOverlay success");
        paramc.h(paramInt, e("ok", null));
        AppMethodBeat.o(186155);
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      ad.i("MicroMsg.JsApiRemoveGroundOverlay", "");
      ad.e("MicroMsg.JsApiRemoveGroundOverlay", "parse remove groundOverlay error, exception : %s", new Object[] { paramJSONObject });
      a(paramc, paramInt, e("fail:internal error", null), false, localb.bkR());
      AppMethodBeat.o(186155);
      return;
    }
    ad.i("MicroMsg.JsApiRemoveGroundOverlay", "removeGroundOverlay fail");
    paramc.h(paramInt, e("fail", null));
    AppMethodBeat.o(186155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.w
 * JD-Core Version:    0.7.0.1
 */