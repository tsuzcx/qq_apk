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

public final class ae
  extends b
{
  public static final int CTRL_INDEX = 892;
  public static final String NAME = "toScreenLocation";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(234560);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiToScreenLocation", "data is null");
      paramf.i(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(234560);
      return;
    }
    Log.i("MicroMsg.JsApiToScreenLocation", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.k.a.b localb = h(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiToScreenLocation", "mapView is null, return");
      paramf.i(paramInt, h("fail:mapview is null", null));
      AppMethodBeat.o(234560);
      return;
    }
    try
    {
      double d = paramJSONObject.getDouble("longitude");
      paramJSONObject = localb.a(new b.i(paramJSONObject.getDouble("latitude"), d));
      if (paramJSONObject != null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("x", Integer.valueOf(g.zC(paramJSONObject.x)));
        localHashMap.put("y", Integer.valueOf(g.zC(paramJSONObject.y)));
        Log.i("MicroMsg.JsApiToScreenLocation", "toScreenLocation ok values:%s", new Object[] { localHashMap.toString() });
        paramf.i(paramInt, n("ok", localHashMap));
        AppMethodBeat.o(234560);
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      Log.i("MicroMsg.JsApiToScreenLocation", "");
      Log.e("MicroMsg.JsApiToScreenLocation", "parse toScreenLocation error, exception : %s", new Object[] { paramJSONObject });
      a(paramf, paramInt, h("fail:internal error", null), false, localb.bGX());
      AppMethodBeat.o(234560);
      return;
    }
    Log.i("MicroMsg.JsApiToScreenLocation", "toScreenLocation fail");
    paramf.i(paramInt, h("fail:point is empty", null));
    AppMethodBeat.o(234560);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.ae
 * JD-Core Version:    0.7.0.1
 */