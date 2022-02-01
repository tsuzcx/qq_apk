package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.i;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class c
  extends b
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "addMapArc";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(329472);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiAddMapArc", "data is null");
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(329472);
      return;
    }
    Log.i("MicroMsg.JsApiAddMapArc", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.o.a.b localb = g(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiAddMapArc", "mapView is null, return");
      paramf.callback(paramInt, ZP("fail:mapview is null"));
      AppMethodBeat.o(329472);
      return;
    }
    if ((paramJSONObject.has("id")) && (paramJSONObject.has("start")) && (paramJSONObject.has("end")))
    {
      try
      {
        int i = paramJSONObject.getInt("id");
        Object localObject1 = paramJSONObject.getJSONObject("start");
        Object localObject2 = paramJSONObject.getJSONObject("end");
        JSONObject localJSONObject = paramJSONObject.optJSONObject("pass");
        double d1 = paramJSONObject.optDouble("angle", 0.0D);
        double d2 = paramJSONObject.optDouble("width", 0.0D);
        int j = i.dq(paramJSONObject.optString("color", ""), Color.parseColor("#000000"));
        localObject1 = new b.i(((JSONObject)localObject1).optDouble("latitude", 0.0D), ((JSONObject)localObject1).optDouble("longitude", 0.0D));
        localObject2 = new b.i(((JSONObject)localObject2).optDouble("latitude", 0.0D), ((JSONObject)localObject2).optDouble("longitude", 0.0D));
        paramJSONObject = null;
        if (localJSONObject != null) {
          paramJSONObject = new b.i(localJSONObject.optDouble("latitude", 0.0D), localJSONObject.optDouble("longitude", 0.0D));
        }
        if (localb.a(i, (b.i)localObject1, (b.i)localObject2, paramJSONObject, (float)d1, (float)d2, j))
        {
          paramf.callback(paramInt, ZP("ok"));
          AppMethodBeat.o(329472);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        Log.printErrStackTrace("MicroMsg.JsApiAddMapArc", paramJSONObject, "", new Object[0]);
        Log.e("MicroMsg.JsApiAddMapArc", "handle data has exception");
        paramf.callback(paramInt, ZP("fail:invalid data"));
        AppMethodBeat.o(329472);
        return;
      }
      Log.e("MicroMsg.JsApiAddMapArc", "add fail");
      paramf.callback(paramInt, ZP("fail:addMapArc is invalid"));
      AppMethodBeat.o(329472);
      return;
    }
    Log.e("MicroMsg.JsApiAddMapArc", "id or start or end point is empty");
    paramf.callback(paramInt, ZP("fail:invalid data"));
    AppMethodBeat.o(329472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.c
 * JD-Core Version:    0.7.0.1
 */