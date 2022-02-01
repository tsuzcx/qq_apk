package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.y.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ae
  extends b
{
  public static final int CTRL_INDEX = 892;
  public static final String NAME = "toScreenLocation";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(206472);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.JsApiToScreenLocation", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(206472);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.JsApiToScreenLocation", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.i.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.JsApiToScreenLocation", "mapView is null, return");
      paramc.h(paramInt, e("fail:mapview is null", null));
      AppMethodBeat.o(206472);
      return;
    }
    try
    {
      double d = paramJSONObject.getDouble("longitude");
      paramJSONObject = localb.a(new b.i(paramJSONObject.getDouble("latitude"), d));
      if (paramJSONObject != null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("x", Integer.valueOf(g.vN(paramJSONObject.x)));
        localHashMap.put("y", Integer.valueOf(g.vN(paramJSONObject.y)));
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.JsApiToScreenLocation", "toScreenLocation ok values:%s", new Object[] { localHashMap.toString() });
        paramc.h(paramInt, n("ok", localHashMap));
        AppMethodBeat.o(206472);
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.JsApiToScreenLocation", "");
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.JsApiToScreenLocation", "parse toScreenLocation error, exception : %s", new Object[] { paramJSONObject });
      a(paramc, paramInt, e("fail:internal error", null), false, localb.blB());
      AppMethodBeat.o(206472);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.JsApiToScreenLocation", "toScreenLocation fail");
    paramc.h(paramInt, e("fail:point is empty", null));
    AppMethodBeat.o(206472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.ae
 * JD-Core Version:    0.7.0.1
 */