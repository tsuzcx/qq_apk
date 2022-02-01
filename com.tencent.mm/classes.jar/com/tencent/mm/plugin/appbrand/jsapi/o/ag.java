package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ag
  extends b
{
  public static final int CTRL_INDEX = 690;
  public static final String NAME = "setMapCenterOffset";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143691);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiSetMapCenterOffset", "data is null");
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(143691);
      return;
    }
    Log.i("MicroMsg.JsApiSetMapCenterOffset", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.o.a.b localb = g(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiSetMapCenterOffset", "mapView is null, return");
      paramf.callback(paramInt, ZP("fail:mapview is null"));
      AppMethodBeat.o(143691);
      return;
    }
    try
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray("offset");
      localb.g((float)localJSONArray.optDouble(0, 0.5D), (float)localJSONArray.optDouble(1, 0.5D), paramJSONObject.optBoolean("animated", false));
      a(paramf, paramInt, ZP("ok"), true, localb.csM());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.ag
 * JD-Core Version:    0.7.0.1
 */