package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ab
  extends b
{
  public static final int CTRL_INDEX = 690;
  public static final String NAME = "setMapCenterOffset";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143691);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiSetMapCenterOffset", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(143691);
      return;
    }
    ad.i("MicroMsg.JsApiSetMapCenterOffset", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.i.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ad.e("MicroMsg.JsApiSetMapCenterOffset", "mapView is null, return");
      paramc.h(paramInt, e("fail:mapview is null", null));
      AppMethodBeat.o(143691);
      return;
    }
    try
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray("offset");
      localb.c((float)localJSONArray.optDouble(0, 0.5D), (float)localJSONArray.optDouble(1, 0.5D), paramJSONObject.optBoolean("animated", false));
      a(paramc, paramInt, e("ok", null), true, localb.bkR());
      AppMethodBeat.o(143691);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        ad.e("MicroMsg.JsApiSetMapCenterOffset", "parse offset err:%s", new Object[] { paramJSONObject });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.ab
 * JD-Core Version:    0.7.0.1
 */