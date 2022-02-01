package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class p
  extends b
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "getMapScale";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143668);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.JsApiGetMapScale", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(143668);
      return;
    }
    ae.i("MicroMsg.JsApiGetMapScale", "data:%s", new Object[] { paramJSONObject });
    paramJSONObject = h(paramc, paramJSONObject);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.JsApiGetMapScale", "mapView is null, return");
      paramc.h(paramInt, e("fail:mapview is null", null));
      AppMethodBeat.o(143668);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("scale", Float.valueOf(paramJSONObject.getZoom()));
    ae.i("MicroMsg.JsApiGetMapScale", "getMapScale ok, values:%s", new Object[] { localHashMap.toString() });
    a(paramc, paramInt, n("ok", localHashMap), true, paramJSONObject.blB());
    AppMethodBeat.o(143668);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.p
 * JD-Core Version:    0.7.0.1
 */