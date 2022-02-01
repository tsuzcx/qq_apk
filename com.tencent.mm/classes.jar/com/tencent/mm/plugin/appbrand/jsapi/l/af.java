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

public final class af
  extends b
{
  public static final int CTRL_INDEX = 892;
  public static final String NAME = "toScreenLocation";
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(192544);
    super.a(parame, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiToScreenLocation", "data is null");
      parame.j(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(192544);
      return;
    }
    Log.i("MicroMsg.JsApiToScreenLocation", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.l.a.b localb = g(parame, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiToScreenLocation", "mapView is null, return");
      parame.j(paramInt, h("fail:mapview is null", null));
      AppMethodBeat.o(192544);
      return;
    }
    try
    {
      double d = paramJSONObject.getDouble("longitude");
      paramJSONObject = localb.a(new b.i(paramJSONObject.getDouble("latitude"), d));
      if (paramJSONObject != null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("x", Integer.valueOf(g.Dh(paramJSONObject.x)));
        localHashMap.put("y", Integer.valueOf(g.Dh(paramJSONObject.y)));
        Log.i("MicroMsg.JsApiToScreenLocation", "toScreenLocation ok values:%s", new Object[] { localHashMap.toString() });
        parame.j(paramInt, m("ok", localHashMap));
        AppMethodBeat.o(192544);
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      Log.i("MicroMsg.JsApiToScreenLocation", "");
      Log.e("MicroMsg.JsApiToScreenLocation", "parse toScreenLocation error, exception : %s", new Object[] { paramJSONObject });
      a(parame, paramInt, h("fail:internal error", null), false, localb.bSF());
      AppMethodBeat.o(192544);
      return;
    }
    Log.i("MicroMsg.JsApiToScreenLocation", "toScreenLocation fail");
    parame.j(paramInt, h("fail:point is empty", null));
    AppMethodBeat.o(192544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.af
 * JD-Core Version:    0.7.0.1
 */