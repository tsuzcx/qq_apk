package com.tencent.mm.plugin.appbrand.jsapi.l;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.l.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.o;
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
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(192237);
    super.a(parame, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiFromScreenLocation", "data is null");
      parame.j(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(192237);
      return;
    }
    Log.i("MicroMsg.JsApiFromScreenLocation", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.l.a.b localb = g(parame, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiFromScreenLocation", "mapView is null, return");
      parame.j(paramInt, h("fail:mapview is null", null));
      AppMethodBeat.o(192237);
      return;
    }
    try
    {
      int i = paramJSONObject.getInt("x");
      int j = paramJSONObject.getInt("y");
      paramJSONObject = new Point();
      paramJSONObject.x = g.Di(i);
      paramJSONObject.y = g.Di(j);
      Log.i("MicroMsg.JsApiFromScreenLocation", "x:%d, y:%d", new Object[] { Integer.valueOf(paramJSONObject.x), Integer.valueOf(paramJSONObject.y) });
      paramJSONObject = localb.e(paramJSONObject);
      HashMap localHashMap = new HashMap();
      localHashMap.put("latitude", Double.valueOf(paramJSONObject.latitude));
      localHashMap.put("longitude", Double.valueOf(paramJSONObject.longitude));
      Log.i("MicroMsg.JsApiFromScreenLocation", "fromScreenLocation ok values:%s", new Object[] { localHashMap.toString() });
      parame.j(paramInt, m("ok", localHashMap));
      AppMethodBeat.o(192237);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Log.i("MicroMsg.JsApiFromScreenLocation", "");
      Log.e("MicroMsg.JsApiFromScreenLocation", "parse fromScreenLocation error, exception : %s", new Object[] { paramJSONObject });
      a(parame, paramInt, h("fail:internal error", null), false, localb.bSF());
      AppMethodBeat.o(192237);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.k
 * JD-Core Version:    0.7.0.1
 */