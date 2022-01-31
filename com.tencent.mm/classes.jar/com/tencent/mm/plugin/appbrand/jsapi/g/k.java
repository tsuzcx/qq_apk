package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k
  extends a
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "getMapRotate";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(93848);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiGetMapRotate", "data is null");
      paramc.h(paramInt, j("fail:invalid data", null));
      AppMethodBeat.o(93848);
      return;
    }
    ab.i("MicroMsg.JsApiGetMapRotate", "data:%s", new Object[] { paramJSONObject });
    paramJSONObject = f(paramc, paramJSONObject);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiGetMapRotate", "mapView is null, return");
      paramc.h(paramInt, j("fail:mapview is null", null));
      AppMethodBeat.o(93848);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("rotate", Float.valueOf(paramJSONObject.aDv()));
    ab.i("MicroMsg.JsApiGetMapRotate", "getMapRotate ok, values:%s", new Object[] { localHashMap.toString() });
    a(paramc, paramInt, j("ok", localHashMap), true, paramJSONObject.aDx());
    AppMethodBeat.o(93848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.k
 * JD-Core Version:    0.7.0.1
 */