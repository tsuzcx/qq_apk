package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class h
  extends a
{
  public static final int CTRL_INDEX = 144;
  public static final String NAME = "getMapCenterLocation";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(93845);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiGetMapCenterLocation", "data is null");
      paramc.h(paramInt, j("fail:invalid data", null));
      AppMethodBeat.o(93845);
      return;
    }
    ab.i("MicroMsg.JsApiGetMapCenterLocation", "data:%s", new Object[] { paramJSONObject });
    paramJSONObject = f(paramc, paramJSONObject);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiGetMapCenterLocation", "mapView is null, return");
      paramc.h(paramInt, j("fail:mapview is null", null));
      AppMethodBeat.o(93845);
      return;
    }
    HashMap localHashMap = new HashMap();
    b.h localh = paramJSONObject.aDy();
    localHashMap.put("latitude", Double.valueOf(localh.latitude));
    localHashMap.put("longitude", Double.valueOf(localh.longitude));
    ab.i("MicroMsg.JsApiGetMapCenterLocation", "ok, values:%s", new Object[] { localHashMap.toString() });
    a(paramc, paramInt, j("ok", localHashMap), true, paramJSONObject.aDx());
    AppMethodBeat.o(93845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.h
 * JD-Core Version:    0.7.0.1
 */