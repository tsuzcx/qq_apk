package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class k
  extends b
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "addMapVisualLayer";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(329468);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiAddMapVisualLayer", "data is null");
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(329468);
      return;
    }
    Log.i("MicroMsg.JsApiAddMapVisualLayer", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.o.a.b localb = g(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiAddMapVisualLayer", "mapView is null, return");
      paramf.callback(paramInt, ZP("fail:mapview is null"));
      AppMethodBeat.o(329468);
      return;
    }
    String str = paramJSONObject.optString("layerId");
    if (TextUtils.isEmpty(str))
    {
      Log.e("MicroMsg.JsApiAddMapVisualLayer", "layerId is empty");
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(329468);
      return;
    }
    if (localb.a(str, paramJSONObject.optInt("interval", 0), paramJSONObject.optDouble("opacity", 1.0D), paramJSONObject.optInt("zIndex", 0), paramJSONObject.optString("level")))
    {
      Log.i("MicroMsg.JsApiAddMapVisualLayer", "addMapVisualLayer ok");
      paramf.callback(paramInt, ZP("ok"));
      AppMethodBeat.o(329468);
      return;
    }
    Log.i("MicroMsg.JsApiAddMapVisualLayer", "addMapVisualLayer fail");
    paramf.callback(paramInt, ZP("fail"));
    AppMethodBeat.o(329468);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.k
 * JD-Core Version:    0.7.0.1
 */