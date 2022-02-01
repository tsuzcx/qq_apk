package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class r
  extends b
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "getMapScale";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143668);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiGetMapScale", "data is null");
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(143668);
      return;
    }
    Log.i("MicroMsg.JsApiGetMapScale", "data:%s", new Object[] { paramJSONObject });
    paramJSONObject = g(paramf, paramJSONObject);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiGetMapScale", "mapView is null, return");
      paramf.callback(paramInt, ZP("fail:mapview is null"));
      AppMethodBeat.o(143668);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("scale", Float.valueOf(paramJSONObject.getZoom()));
    Log.i("MicroMsg.JsApiGetMapScale", "getMapScale ok, values:%s", new Object[] { localHashMap.toString() });
    a(paramf, paramInt, m("ok", localHashMap), true, paramJSONObject.csM());
    AppMethodBeat.o(143668);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.r
 * JD-Core Version:    0.7.0.1
 */