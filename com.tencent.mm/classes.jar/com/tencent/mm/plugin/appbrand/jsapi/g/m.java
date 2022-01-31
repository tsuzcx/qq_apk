package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class m
  extends a
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "getMapSkew";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(93850);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiGetMapSkew", "data is null");
      paramc.h(paramInt, j("fail:invalid data", null));
      AppMethodBeat.o(93850);
      return;
    }
    ab.i("MicroMsg.JsApiGetMapSkew", "data:%s", new Object[] { paramJSONObject });
    paramJSONObject = f(paramc, paramJSONObject);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiGetMapSkew", "mapView is null, return");
      paramc.h(paramInt, j("fail:mapview is null", null));
      AppMethodBeat.o(93850);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("skew", Float.valueOf(paramJSONObject.getSkew()));
    ab.i("MicroMsg.JsApiGetMapSkew", "getMapSkew ok, values:%s", new Object[] { localHashMap.toString() });
    a(paramc, paramInt, j("ok", localHashMap), true, paramJSONObject.aDx());
    AppMethodBeat.o(93850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.m
 * JD-Core Version:    0.7.0.1
 */