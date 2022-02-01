package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.i;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ak
  extends b
{
  public static final int CTRL_INDEX = 892;
  public static final String NAME = "toScreenLocation";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(329479);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiToScreenLocation", "data is null");
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(329479);
      return;
    }
    Log.i("MicroMsg.JsApiToScreenLocation", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.o.a.b localb = g(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiToScreenLocation", "mapView is null, return");
      paramf.callback(paramInt, ZP("fail:mapview is null"));
      AppMethodBeat.o(329479);
      return;
    }
    try
    {
      double d = paramJSONObject.getDouble("longitude");
      paramJSONObject = localb.a(new b.i(paramJSONObject.getDouble("latitude"), d));
      if (paramJSONObject != null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("x", Integer.valueOf(i.DB(paramJSONObject.x)));
        localHashMap.put("y", Integer.valueOf(i.DB(paramJSONObject.y)));
        Log.i("MicroMsg.JsApiToScreenLocation", "toScreenLocation ok values:%s", new Object[] { localHashMap.toString() });
        paramf.callback(paramInt, m("ok", localHashMap));
        AppMethodBeat.o(329479);
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      Log.i("MicroMsg.JsApiToScreenLocation", "");
      Log.e("MicroMsg.JsApiToScreenLocation", "parse toScreenLocation error, exception : %s", new Object[] { paramJSONObject });
      a(paramf, paramInt, ZP("fail:internal error"), false, localb.csM());
      AppMethodBeat.o(329479);
      return;
    }
    Log.i("MicroMsg.JsApiToScreenLocation", "toScreenLocation fail");
    paramf.callback(paramInt, ZP("fail:point is empty"));
    AppMethodBeat.o(329479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.ak
 * JD-Core Version:    0.7.0.1
 */