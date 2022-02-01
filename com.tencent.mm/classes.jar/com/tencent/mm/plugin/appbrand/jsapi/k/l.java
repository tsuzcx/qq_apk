package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class l
  extends b
{
  public static final int CTRL_INDEX = 144;
  public static final String NAME = "getMapCenterLocation";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143664);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiGetMapCenterLocation", "data is null");
      paramf.i(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(143664);
      return;
    }
    Log.i("MicroMsg.JsApiGetMapCenterLocation", "data:%s", new Object[] { paramJSONObject });
    paramJSONObject = h(paramf, paramJSONObject);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiGetMapCenterLocation", "mapView is null, return");
      paramf.i(paramInt, h("fail:mapview is null", null));
      AppMethodBeat.o(143664);
      return;
    }
    HashMap localHashMap = new HashMap();
    b.i locali = paramJSONObject.bGY();
    localHashMap.put("latitude", Double.valueOf(locali.latitude));
    localHashMap.put("longitude", Double.valueOf(locali.longitude));
    Log.i("MicroMsg.JsApiGetMapCenterLocation", "ok, values:%s", new Object[] { localHashMap.toString() });
    a(paramf, paramInt, n("ok", localHashMap), true, paramJSONObject.bGX());
    AppMethodBeat.o(143664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.l
 * JD-Core Version:    0.7.0.1
 */