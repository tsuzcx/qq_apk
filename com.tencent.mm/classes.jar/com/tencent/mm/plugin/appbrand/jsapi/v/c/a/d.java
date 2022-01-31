package com.tencent.mm.plugin.appbrand.jsapi.v.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
  extends a
{
  private static final int CTRL_INDEX = -2;
  public static final String NAME = "updateXWebMap";
  
  public static boolean h(c paramc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(117364);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiUpdateXWebMap", "data is null");
      AppMethodBeat.o(117364);
      return false;
    }
    Object localObject1 = paramc.getAppId();
    ab.i("MicroMsg.JsApiUpdateXWebMap", "data:%s", new Object[] { paramJSONObject });
    localObject1 = com.tencent.mm.plugin.appbrand.jsapi.g.a.g.cl((String)localObject1, f.g(paramc, paramJSONObject));
    if (localObject1 == null)
    {
      ab.e("MicroMsg.JsApiUpdateXWebMap", "mapView is null, return");
      AppMethodBeat.o(117364);
      return false;
    }
    Object localObject2;
    if (paramJSONObject.has("position"))
    {
      localObject2 = paramJSONObject.optJSONObject("position");
      if ((localObject2 != null) && (((JSONObject)localObject2).has("width")) && (((JSONObject)localObject2).has("height"))) {
        ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)localObject1).onSizeChanged(com.tencent.mm.plugin.appbrand.s.g.a((JSONObject)localObject2, "width", 0), com.tencent.mm.plugin.appbrand.s.g.a((JSONObject)localObject2, "height", 0));
      }
    }
    if (paramJSONObject.has("scale")) {
      ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)localObject1).ar((float)paramJSONObject.optDouble("scale", 16.0D));
    }
    if (paramJSONObject.has("rotate")) {
      ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)localObject1).as((float)paramJSONObject.optDouble("rotate", 0.0D));
    }
    if (paramJSONObject.has("skew")) {
      ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)localObject1).at((float)paramJSONObject.optDouble("skew", 0.0D));
    }
    float f1;
    float f2;
    if ((paramJSONObject.has("centerLatitude")) && (paramJSONObject.has("centerLongitude")))
    {
      f1 = bo.getFloat(paramJSONObject.optString("centerLatitude"), 0.0F);
      f2 = bo.getFloat(paramJSONObject.optString("centerLongitude"), 0.0F);
      if ((Math.abs(f1) <= 90.0F) && (Math.abs(f2) <= 180.0F)) {
        ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)localObject1).M(f1, f2);
      }
    }
    if (paramJSONObject.has("enableZoom")) {
      ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)localObject1).ej(paramJSONObject.optBoolean("enableZoom", true));
    }
    if (paramJSONObject.has("enableScroll")) {
      ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)localObject1).ek(paramJSONObject.optBoolean("enableScroll", true));
    }
    if (paramJSONObject.has("enableRotate")) {
      ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)localObject1).el(paramJSONObject.optBoolean("enableRotate", true));
    }
    if (paramJSONObject.has("showCompass")) {
      ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)localObject1).em(paramJSONObject.optBoolean("showCompass", false));
    }
    if (paramJSONObject.has("enable3D")) {
      ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)localObject1).en(paramJSONObject.optBoolean("enable3D", false));
    }
    if (paramJSONObject.has("enableOverlooking")) {
      ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)localObject1).eo(paramJSONObject.optBoolean("enableOverlooking", false));
    }
    if (paramJSONObject.has("enableSatellite")) {
      ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)localObject1).ep(paramJSONObject.optBoolean("enableSatellite", false));
    }
    if (paramJSONObject.has("enableTraffic")) {
      ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)localObject1).eq(paramJSONObject.optBoolean("enableTraffic", false));
    }
    if (paramJSONObject.has("enableIndoor")) {
      ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)localObject1).er(paramJSONObject.optBoolean("enableIndoor", false));
    }
    if (paramJSONObject.has("enableIndoorLevelPick")) {
      ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)localObject1).es(paramJSONObject.optBoolean("enableIndoorLevelPick", false));
    }
    if (paramJSONObject.has("showLocation")) {
      ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)localObject1).eu(paramJSONObject.optBoolean("showLocation", false));
    }
    if (paramJSONObject.has("showScale")) {
      ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)localObject1).et(paramJSONObject.optBoolean("showScale", true));
    }
    try
    {
      if (paramJSONObject.has("covers"))
      {
        ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)localObject1).aDD();
        paramJSONObject = new JSONArray(paramJSONObject.optString("covers"));
        int i = 0;
        while (i < paramJSONObject.length())
        {
          Object localObject3 = (JSONObject)paramJSONObject.get(i);
          f1 = bo.getFloat(((JSONObject)localObject3).optString("latitude"), 0.0F);
          f2 = bo.getFloat(((JSONObject)localObject3).optString("longitude"), 0.0F);
          localObject2 = ((com.tencent.mm.plugin.appbrand.e.b)paramc.q(com.tencent.mm.plugin.appbrand.e.b.class)).b(paramc, ((JSONObject)localObject3).optString("iconPath"));
          float f3 = (float)((JSONObject)localObject3).optDouble("rotate", 0.0D);
          localObject3 = new b.d();
          ((b.d)localObject3).g(f1, f2);
          ((b.d)localObject3).hPe = ((String)localObject2);
          ((b.d)localObject3).rotate = f3;
          ((com.tencent.mm.plugin.appbrand.jsapi.g.a.b)localObject1).a((b.d)localObject3, (com.tencent.mm.plugin.appbrand.e.a)paramc.q(com.tencent.mm.plugin.appbrand.e.a.class));
          i += 1;
        }
      }
      AppMethodBeat.o(117364);
    }
    catch (Exception paramc)
    {
      ab.e("MicroMsg.JsApiUpdateXWebMap", "parse covers error, exception : %s", new Object[] { paramc });
      AppMethodBeat.o(117364);
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.c.a.d
 * JD-Core Version:    0.7.0.1
 */