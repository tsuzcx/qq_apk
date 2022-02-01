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

public final class m
  extends b
{
  public static final int CTRL_INDEX = 893;
  public static final String NAME = "fromScreenLocation";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(329469);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiFromScreenLocation", "data is null");
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(329469);
      return;
    }
    Log.i("MicroMsg.JsApiFromScreenLocation", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.o.a.b localb = g(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiFromScreenLocation", "mapView is null, return");
      paramf.callback(paramInt, ZP("fail:mapview is null"));
      AppMethodBeat.o(329469);
      return;
    }
    try
    {
      int i = paramJSONObject.getInt("x");
      int j = paramJSONObject.getInt("y");
      paramJSONObject = new Point();
      paramJSONObject.x = i.DC(i);
      paramJSONObject.y = i.DC(j);
      Log.i("MicroMsg.JsApiFromScreenLocation", "x:%d, y:%d", new Object[] { Integer.valueOf(paramJSONObject.x), Integer.valueOf(paramJSONObject.y) });
      paramJSONObject = localb.f(paramJSONObject);
      if (paramJSONObject != null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("latitude", Double.valueOf(paramJSONObject.latitude));
        localHashMap.put("longitude", Double.valueOf(paramJSONObject.longitude));
        Log.i("MicroMsg.JsApiFromScreenLocation", "fromScreenLocation ok values:%s", new Object[] { localHashMap.toString() });
        paramf.callback(paramInt, m("ok", localHashMap));
        AppMethodBeat.o(329469);
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      Log.i("MicroMsg.JsApiFromScreenLocation", "");
      Log.e("MicroMsg.JsApiFromScreenLocation", "parse fromScreenLocation error, exception : %s", new Object[] { paramJSONObject });
      a(paramf, paramInt, ZP("fail:internal error"), false, localb.csM());
      AppMethodBeat.o(329469);
      return;
    }
    Log.i("MicroMsg.JsApiFromScreenLocation", "fromScreenLocation fail");
    paramf.callback(paramInt, ZP("fail:location is empty"));
    AppMethodBeat.o(329469);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.m
 * JD-Core Version:    0.7.0.1
 */