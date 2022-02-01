package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ab
  extends b
{
  public static final int CTRL_INDEX = 690;
  public static final String NAME = "setMapCenterOffset";
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143691);
    super.a(parame, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiSetMapCenterOffset", "data is null");
      parame.j(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(143691);
      return;
    }
    Log.i("MicroMsg.JsApiSetMapCenterOffset", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.l.a.b localb = g(parame, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiSetMapCenterOffset", "mapView is null, return");
      parame.j(paramInt, h("fail:mapview is null", null));
      AppMethodBeat.o(143691);
      return;
    }
    try
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray("offset");
      localb.c((float)localJSONArray.optDouble(0, 0.5D), (float)localJSONArray.optDouble(1, 0.5D), paramJSONObject.optBoolean("animated", false));
      a(parame, paramInt, h("ok", null), true, localb.bSF());
      AppMethodBeat.o(143691);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        Log.e("MicroMsg.JsApiSetMapCenterOffset", "parse offset err:%s", new Object[] { paramJSONObject });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.ab
 * JD-Core Version:    0.7.0.1
 */