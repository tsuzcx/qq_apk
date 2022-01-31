package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.t;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.u;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g
  extends a
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "getMapRegion";
  
  private static int p(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("mapId");
      return i;
    }
    catch (Exception paramJSONObject)
    {
      y.e("MicroMsg.JsApiGetMapRegion", "get mapId error, exception : %s", new Object[] { paramJSONObject });
    }
    return -1;
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiGetMapRegion", "JsApiGetMapRegion data is null");
      paramc.C(paramInt, h("fail:data is null", null));
      return;
    }
    Object localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.base.f)paramc.i(com.tencent.mm.plugin.appbrand.jsapi.base.f.class)).a(paramc);
    if (localObject1 == null)
    {
      y.e("MicroMsg.JsApiGetMapRegion", "pageView is null");
      paramc.C(paramInt, h("fail", null));
      return;
    }
    paramJSONObject = com.tencent.mm.plugin.appbrand.jsapi.g.a.f.o(paramc.getAppId(), ((e)localObject1).ahJ(), p(paramJSONObject));
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiGetMapRegion", "appBrandMapView is null, return");
      paramc.C(paramInt, h("fail", null));
      return;
    }
    paramJSONObject = paramJSONObject.aji().guK;
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiGetMapRegion", "visibleRegion is  null");
      paramc.C(paramInt, h("fail:visibleRegion is null", null));
      return;
    }
    paramJSONObject = paramJSONObject.guL;
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiGetMapRegion", "latLngBounds is  null");
      paramc.C(paramInt, h("fail:latLngBounds is null", null));
      return;
    }
    localObject1 = paramJSONObject.guq;
    Object localObject2 = paramJSONObject.gur;
    paramJSONObject = new HashMap();
    if (localObject1 != null)
    {
      paramJSONObject.put("latitude", Double.valueOf(((b.f)localObject1).latitude));
      paramJSONObject.put("longitude", Double.valueOf(((b.f)localObject1).longitude));
    }
    localObject1 = new HashMap();
    if (localObject2 != null)
    {
      ((Map)localObject1).put("latitude", Double.valueOf(((b.f)localObject2).latitude));
      ((Map)localObject1).put("longitude", Double.valueOf(((b.f)localObject2).longitude));
    }
    localObject2 = new HashMap();
    ((Map)localObject2).put("southwest", paramJSONObject);
    ((Map)localObject2).put("northeast", localObject1);
    y.i("MicroMsg.JsApiGetMapRegion", "getMapRegion ok, values:%s", new Object[] { localObject2.toString() });
    paramc.C(paramInt, h("ok", (Map)localObject2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.g
 * JD-Core Version:    0.7.0.1
 */