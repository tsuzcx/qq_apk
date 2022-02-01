package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class q
  extends b
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "getMapSkew";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143669);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiGetMapSkew", "data is null");
      paramf.i(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(143669);
      return;
    }
    Log.i("MicroMsg.JsApiGetMapSkew", "data:%s", new Object[] { paramJSONObject });
    paramJSONObject = h(paramf, paramJSONObject);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiGetMapSkew", "mapView is null, return");
      paramf.i(paramInt, h("fail:mapview is null", null));
      AppMethodBeat.o(143669);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("skew", Float.valueOf(paramJSONObject.getSkew()));
    Log.i("MicroMsg.JsApiGetMapSkew", "getMapSkew ok, values:%s", new Object[] { localHashMap.toString() });
    a(paramf, paramInt, n("ok", localHashMap), true, paramJSONObject.bGX());
    AppMethodBeat.o(143669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.q
 * JD-Core Version:    0.7.0.1
 */