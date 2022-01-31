package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class h
  extends a
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "getMapScale";
  
  private static int p(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("mapId");
      return i;
    }
    catch (Exception paramJSONObject)
    {
      y.e("MicroMsg.JsApiGetMapScale", "get mapId error, exception : %s", new Object[] { paramJSONObject });
    }
    return -1;
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiGetMapScale", "JsApiGetMapScale data is null");
      paramc.C(paramInt, h("fail:data is null", null));
      return;
    }
    Object localObject = ((com.tencent.mm.plugin.appbrand.jsapi.base.f)paramc.i(com.tencent.mm.plugin.appbrand.jsapi.base.f.class)).a(paramc);
    if (localObject == null)
    {
      y.e("MicroMsg.JsApiGetMapScale", "pageView is null");
      paramc.C(paramInt, h("fail", null));
      return;
    }
    paramJSONObject = com.tencent.mm.plugin.appbrand.jsapi.g.a.f.o(paramc.getAppId(), ((e)localObject).ahJ(), p(paramJSONObject));
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiGetMapScale", "mapView is null, return");
      paramc.C(paramInt, h("fail", null));
      return;
    }
    localObject = new HashMap();
    ((Map)localObject).put("scale", Integer.valueOf(paramJSONObject.getZoomLevel()));
    y.i("MicroMsg.JsApiGetMapScale", "getMapScale ok, values:%s", new Object[] { localObject.toString() });
    paramc.C(paramInt, h("ok", (Map)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.h
 * JD-Core Version:    0.7.0.1
 */