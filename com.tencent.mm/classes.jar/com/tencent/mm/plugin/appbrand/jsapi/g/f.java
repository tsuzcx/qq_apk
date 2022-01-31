package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f
  extends a
{
  public static final int CTRL_INDEX = 144;
  public static final String NAME = "getMapCenterLocation";
  
  private static int p(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("mapId");
      return i;
    }
    catch (Exception paramJSONObject)
    {
      y.e("MicroMsg.JsApiGetMapCenterLocation", "get mapId error, exception : %s", new Object[] { paramJSONObject });
    }
    return -1;
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiGetMapCenterLocation", "getMapCenterLocation data is null");
      paramc.C(paramInt, h("fail:data is null", null));
      return;
    }
    Object localObject = ((com.tencent.mm.plugin.appbrand.jsapi.base.f)paramc.i(com.tencent.mm.plugin.appbrand.jsapi.base.f.class)).a(paramc);
    if (localObject == null)
    {
      y.e("MicroMsg.JsApiGetMapCenterLocation", "pageView is null");
      paramc.C(paramInt, h("fail", null));
      return;
    }
    localObject = com.tencent.mm.plugin.appbrand.jsapi.g.a.f.o(paramc.getAppId(), ((e)localObject).ahJ(), p(paramJSONObject));
    if (localObject == null)
    {
      y.e("MicroMsg.JsApiGetMapCenterLocation", "mapView is null, return");
      paramc.C(paramInt, h("fail", null));
      return;
    }
    paramJSONObject = new HashMap();
    localObject = ((b)localObject).ajk();
    paramJSONObject.put("latitude", Double.valueOf(((b.f)localObject).latitude));
    paramJSONObject.put("longitude", Double.valueOf(((b.f)localObject).longitude));
    y.i("MicroMsg.JsApiGetMapCenterLocation", "ok, values:%s", new Object[] { paramJSONObject.toString() });
    paramc.C(paramInt, h("ok", paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.f
 * JD-Core Version:    0.7.0.1
 */