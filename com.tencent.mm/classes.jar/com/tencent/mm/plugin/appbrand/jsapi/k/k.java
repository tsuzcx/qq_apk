package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class k
  extends b
{
  public static final int CTRL_INDEX = 893;
  public static final String NAME = "fromScreenLocation";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(234544);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiFromScreenLocation", "data is null");
      paramf.i(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(234544);
      return;
    }
    Log.i("MicroMsg.JsApiFromScreenLocation", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.k.a.b localb = h(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiFromScreenLocation", "mapView is null, return");
      paramf.i(paramInt, h("fail:mapview is null", null));
      AppMethodBeat.o(234544);
      return;
    }
    try
    {
      int i = paramJSONObject.getInt("x");
      int j = paramJSONObject.getInt("y");
      paramJSONObject = new Point();
      paramJSONObject.x = g.zD(i);
      paramJSONObject.y = g.zD(j);
      Log.i("MicroMsg.JsApiFromScreenLocation", "x:%d, y:%d", new Object[] { Integer.valueOf(paramJSONObject.x), Integer.valueOf(paramJSONObject.y) });
      paramJSONObject = localb.e(paramJSONObject);
      HashMap localHashMap = new HashMap();
      localHashMap.put("latitude", Double.valueOf(paramJSONObject.latitude));
      localHashMap.put("longitude", Double.valueOf(paramJSONObject.longitude));
      Log.i("MicroMsg.JsApiFromScreenLocation", "fromScreenLocation ok values:%s", new Object[] { localHashMap.toString() });
      paramf.i(paramInt, n("ok", localHashMap));
      AppMethodBeat.o(234544);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Log.i("MicroMsg.JsApiFromScreenLocation", "");
      Log.e("MicroMsg.JsApiFromScreenLocation", "parse fromScreenLocation error, exception : %s", new Object[] { paramJSONObject });
      a(paramf, paramInt, h("fail:internal error", null), false, localb.bGX());
      AppMethodBeat.o(234544);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.k
 * JD-Core Version:    0.7.0.1
 */