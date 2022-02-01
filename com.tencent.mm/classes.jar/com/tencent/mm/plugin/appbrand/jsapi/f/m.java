package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class m
  extends b
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "getMapRotate";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143667);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.JsApiGetMapRotate", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(143667);
      return;
    }
    ac.i("MicroMsg.JsApiGetMapRotate", "data:%s", new Object[] { paramJSONObject });
    paramJSONObject = h(paramc, paramJSONObject);
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.JsApiGetMapRotate", "mapView is null, return");
      paramc.h(paramInt, e("fail:mapview is null", null));
      AppMethodBeat.o(143667);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("rotate", Float.valueOf(paramJSONObject.getRotate()));
    ac.i("MicroMsg.JsApiGetMapRotate", "getMapRotate ok, values:%s", new Object[] { localHashMap.toString() });
    a(paramc, paramInt, k("ok", localHashMap), true, paramJSONObject.bhm());
    AppMethodBeat.o(143667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.m
 * JD-Core Version:    0.7.0.1
 */