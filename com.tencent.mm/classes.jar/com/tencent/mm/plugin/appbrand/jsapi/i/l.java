package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class l
  extends b
{
  public static final int CTRL_INDEX = 144;
  public static final String NAME = "getMapCenterLocation";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143664);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.JsApiGetMapCenterLocation", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(143664);
      return;
    }
    ae.i("MicroMsg.JsApiGetMapCenterLocation", "data:%s", new Object[] { paramJSONObject });
    paramJSONObject = h(paramc, paramJSONObject);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.JsApiGetMapCenterLocation", "mapView is null, return");
      paramc.h(paramInt, e("fail:mapview is null", null));
      AppMethodBeat.o(143664);
      return;
    }
    HashMap localHashMap = new HashMap();
    b.i locali = paramJSONObject.blC();
    localHashMap.put("latitude", Double.valueOf(locali.latitude));
    localHashMap.put("longitude", Double.valueOf(locali.longitude));
    ae.i("MicroMsg.JsApiGetMapCenterLocation", "ok, values:%s", new Object[] { localHashMap.toString() });
    a(paramc, paramInt, n("ok", localHashMap), true, paramJSONObject.blB());
    AppMethodBeat.o(143664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.l
 * JD-Core Version:    0.7.0.1
 */