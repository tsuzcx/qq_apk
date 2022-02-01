package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class k
  extends b
{
  public static final int CTRL_INDEX = 893;
  public static final String NAME = "fromScreenLocation";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(186141);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiFromScreenLocation", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(186141);
      return;
    }
    ad.i("MicroMsg.JsApiFromScreenLocation", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.i.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ad.e("MicroMsg.JsApiFromScreenLocation", "mapView is null, return");
      paramc.h(paramInt, e("fail:mapview is null", null));
      AppMethodBeat.o(186141);
      return;
    }
    try
    {
      int i = paramJSONObject.getInt("x");
      int j = paramJSONObject.getInt("y");
      paramJSONObject = new Point();
      paramJSONObject.x = g.vJ(i);
      paramJSONObject.y = g.vJ(j);
      ad.i("MicroMsg.JsApiFromScreenLocation", "x:%d, y:%d", new Object[] { Integer.valueOf(paramJSONObject.x), Integer.valueOf(paramJSONObject.y) });
      paramJSONObject = localb.d(paramJSONObject);
      HashMap localHashMap = new HashMap();
      localHashMap.put("latitude", Double.valueOf(paramJSONObject.latitude));
      localHashMap.put("longitude", Double.valueOf(paramJSONObject.longitude));
      ad.i("MicroMsg.JsApiFromScreenLocation", "fromScreenLocation ok values:%s", new Object[] { localHashMap.toString() });
      paramc.h(paramInt, m("ok", localHashMap));
      AppMethodBeat.o(186141);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      ad.i("MicroMsg.JsApiFromScreenLocation", "");
      ad.e("MicroMsg.JsApiFromScreenLocation", "parse fromScreenLocation error, exception : %s", new Object[] { paramJSONObject });
      a(paramc, paramInt, e("fail:internal error", null), false, localb.bkR());
      AppMethodBeat.o(186141);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.k
 * JD-Core Version:    0.7.0.1
 */