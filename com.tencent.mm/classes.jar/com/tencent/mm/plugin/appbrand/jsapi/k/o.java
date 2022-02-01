package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class o
  extends b
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "getMapRotate";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143667);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiGetMapRotate", "data is null");
      paramf.i(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(143667);
      return;
    }
    Log.i("MicroMsg.JsApiGetMapRotate", "data:%s", new Object[] { paramJSONObject });
    paramJSONObject = h(paramf, paramJSONObject);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiGetMapRotate", "mapView is null, return");
      paramf.i(paramInt, h("fail:mapview is null", null));
      AppMethodBeat.o(143667);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("rotate", Float.valueOf(paramJSONObject.getRotate()));
    Log.i("MicroMsg.JsApiGetMapRotate", "getMapRotate ok, values:%s", new Object[] { localHashMap.toString() });
    a(paramf, paramInt, n("ok", localHashMap), true, paramJSONObject.bGX());
    AppMethodBeat.o(143667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.o
 * JD-Core Version:    0.7.0.1
 */