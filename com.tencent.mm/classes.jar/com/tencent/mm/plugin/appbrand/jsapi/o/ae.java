package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class ae
  extends b
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "removeMapVisualLayer";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(329474);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiRemoveMapVisualLayer", "data is null");
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(329474);
      return;
    }
    Log.i("MicroMsg.JsApiRemoveMapVisualLayer", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.o.a.b localb = g(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiRemoveMapVisualLayer", "mapView is null, return");
      paramf.callback(paramInt, ZP("fail:mapview is null"));
      AppMethodBeat.o(329474);
      return;
    }
    paramJSONObject = paramJSONObject.optString("layerId");
    if (TextUtils.isEmpty(paramJSONObject))
    {
      Log.e("MicroMsg.JsApiRemoveMapVisualLayer", "layerId is empty");
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(329474);
      return;
    }
    if (localb.aaN(paramJSONObject))
    {
      Log.i("MicroMsg.JsApiRemoveMapVisualLayer", "removeMapVisualLayer ok");
      paramf.callback(paramInt, ZP("ok"));
      AppMethodBeat.o(329474);
      return;
    }
    Log.i("MicroMsg.JsApiRemoveMapVisualLayer", "removeMapVisualLayer fail");
    paramf.callback(paramInt, ZP("fail"));
    AppMethodBeat.o(329474);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.ae
 * JD-Core Version:    0.7.0.1
 */