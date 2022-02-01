package com.tencent.mm.plugin.appbrand.jsapi.ai.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.l.a.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.l.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
  extends a
{
  private static final int CTRL_INDEX = -2;
  public static final String NAME = "updateXWebMap";
  
  public static boolean i(e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139552);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiUpdateXWebMap", "data is null");
      AppMethodBeat.o(139552);
      return false;
    }
    Object localObject1 = parame.getAppId();
    Log.i("MicroMsg.JsApiUpdateXWebMap", "data:%s", new Object[] { paramJSONObject });
    localObject1 = com.tencent.mm.plugin.appbrand.jsapi.l.a.g.dK((String)localObject1, f.h(parame, paramJSONObject));
    if (localObject1 == null)
    {
      Log.e("MicroMsg.JsApiUpdateXWebMap", "mapView is null, return");
      AppMethodBeat.o(139552);
      return false;
    }
    Object localObject2;
    if (paramJSONObject.has("position"))
    {
      localObject2 = paramJSONObject.optJSONObject("position");
      if ((localObject2 != null) && (((JSONObject)localObject2).has("width")) && (((JSONObject)localObject2).has("height"))) {
        ((com.tencent.mm.plugin.appbrand.jsapi.l.a.b)localObject1).onSizeChanged(com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject2, "width", 0), com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject2, "height", 0));
      }
    }
    if (paramJSONObject.has("enableZoom")) {
      ((com.tencent.mm.plugin.appbrand.jsapi.l.a.b)localObject1).im(paramJSONObject.optBoolean("enableZoom", true));
    }
    if (paramJSONObject.has("enableScroll")) {
      ((com.tencent.mm.plugin.appbrand.jsapi.l.a.b)localObject1).in(paramJSONObject.optBoolean("enableScroll", true));
    }
    if (paramJSONObject.has("enableRotate")) {
      ((com.tencent.mm.plugin.appbrand.jsapi.l.a.b)localObject1).io(paramJSONObject.optBoolean("enableRotate", true));
    }
    if (paramJSONObject.has("showCompass")) {
      ((com.tencent.mm.plugin.appbrand.jsapi.l.a.b)localObject1).ip(paramJSONObject.optBoolean("showCompass", false));
    }
    if (paramJSONObject.has("enable3D")) {
      ((com.tencent.mm.plugin.appbrand.jsapi.l.a.b)localObject1).setBuilding3dEffectEnable(paramJSONObject.optBoolean("enable3D", false));
    }
    if (paramJSONObject.has("enableOverlooking")) {
      ((com.tencent.mm.plugin.appbrand.jsapi.l.a.b)localObject1).iq(paramJSONObject.optBoolean("enableOverlooking", false));
    }
    if (paramJSONObject.has("enableSatellite")) {
      ((com.tencent.mm.plugin.appbrand.jsapi.l.a.b)localObject1).ir(paramJSONObject.optBoolean("enableSatellite", false));
    }
    if (paramJSONObject.has("enableTraffic")) {
      ((com.tencent.mm.plugin.appbrand.jsapi.l.a.b)localObject1).is(paramJSONObject.optBoolean("enableTraffic", false));
    }
    if (paramJSONObject.has("enableIndoor")) {
      ((com.tencent.mm.plugin.appbrand.jsapi.l.a.b)localObject1).it(paramJSONObject.optBoolean("enableIndoor", false));
    }
    if (paramJSONObject.has("enableIndoorLevelPick")) {
      ((com.tencent.mm.plugin.appbrand.jsapi.l.a.b)localObject1).iu(paramJSONObject.optBoolean("enableIndoorLevelPick", false));
    }
    if (paramJSONObject.has("showLocation")) {
      ((com.tencent.mm.plugin.appbrand.jsapi.l.a.b)localObject1).ix(paramJSONObject.optBoolean("showLocation", false));
    }
    if (paramJSONObject.has("showScale")) {
      ((com.tencent.mm.plugin.appbrand.jsapi.l.a.b)localObject1).iv(paramJSONObject.optBoolean("showScale", true));
    }
    if (paramJSONObject.has("styleId")) {
      ((com.tencent.mm.plugin.appbrand.jsapi.l.a.b)localObject1).setMapStyle(paramJSONObject.optInt("styleId", 0));
    }
    if (paramJSONObject.has("maxScale")) {
      ((com.tencent.mm.plugin.appbrand.jsapi.l.a.b)localObject1).setMaxZoomLevel((int)Util.getFloat(paramJSONObject.optString("maxScale"), 20.0F));
    }
    if (paramJSONObject.has("minScale")) {
      ((com.tencent.mm.plugin.appbrand.jsapi.l.a.b)localObject1).setMinZoomLevel((int)Util.getFloat(paramJSONObject.optString("minScale"), 3.0F));
    }
    if (paramJSONObject.has("enablePoi")) {
      ((com.tencent.mm.plugin.appbrand.jsapi.l.a.b)localObject1).setPoisEnabled(paramJSONObject.optBoolean("enablePoi", true));
    }
    if (paramJSONObject.has("enableBuilding")) {
      ((com.tencent.mm.plugin.appbrand.jsapi.l.a.b)localObject1).iw(paramJSONObject.optBoolean("enableBuilding", true));
    }
    float f1;
    float f2;
    float f3;
    try
    {
      if (paramJSONObject.has("covers"))
      {
        ((com.tencent.mm.plugin.appbrand.jsapi.l.a.b)localObject1).bSL();
        localObject2 = new JSONArray(paramJSONObject.optString("covers"));
        int i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          Object localObject3 = (JSONObject)((JSONArray)localObject2).get(i);
          f1 = Util.getFloat(((JSONObject)localObject3).optString("latitude"), 0.0F);
          f2 = Util.getFloat(((JSONObject)localObject3).optString("longitude"), 0.0F);
          String str = ((com.tencent.mm.plugin.appbrand.f.b)parame.K(com.tencent.mm.plugin.appbrand.f.b.class)).b(parame, ((JSONObject)localObject3).optString("iconPath"));
          f3 = (float)((JSONObject)localObject3).optDouble("rotate", 0.0D);
          localObject3 = new b.d();
          ((b.d)localObject3).f(f1, f2);
          ((b.d)localObject3).oYm = str;
          ((b.d)localObject3).oYk = f3;
          ((com.tencent.mm.plugin.appbrand.jsapi.l.a.b)localObject1).a((b.d)localObject3, (com.tencent.mm.plugin.appbrand.f.a)parame.K(com.tencent.mm.plugin.appbrand.f.a.class));
          i += 1;
        }
      }
      if (paramJSONObject.has("scale")) {
        break label796;
      }
    }
    catch (Exception parame)
    {
      Log.e("MicroMsg.JsApiUpdateXWebMap", "parse covers error, exception : %s", new Object[] { parame });
      AppMethodBeat.o(139552);
      return false;
    }
    if ((paramJSONObject.has("rotate")) || (paramJSONObject.has("skew")) || (paramJSONObject.has("centerLatitude")) || (paramJSONObject.has("centerLongitude")))
    {
      label796:
      f1 = (float)paramJSONObject.optDouble("scale", -1.0D);
      f2 = (float)paramJSONObject.optDouble("rotate", -1.0D);
      f3 = (float)paramJSONObject.optDouble("skew", -1.0D);
      ((com.tencent.mm.plugin.appbrand.jsapi.l.a.b)localObject1).a(Util.getDouble(paramJSONObject.optString("centerLatitude", "-1"), -1.0D), Util.getDouble(paramJSONObject.optString("centerLongitude", "-1"), -1.0D), -1.0F, -1.0F, -1.0F, false);
      ((com.tencent.mm.plugin.appbrand.jsapi.l.a.b)localObject1).a(-1.0D, -1.0D, f1, f2, f3, true);
    }
    AppMethodBeat.o(139552);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.d.a.d
 * JD-Core Version:    0.7.0.1
 */