package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONArray;
import org.json.JSONObject;

public final class v
  extends c
{
  public static final int CTRL_INDEX = 4;
  public static final String NAME = "updateMap";
  
  public final boolean c(com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(93881);
    com.tencent.mm.plugin.appbrand.jsapi.g.a.e.oe(3);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiUpdateMap", "data is null");
      AppMethodBeat.o(93881);
      return false;
    }
    paramView = parame.getAppId();
    ab.i("MicroMsg.JsApiUpdateMap", "updateView appId:%s viewId:%d data:%s", new Object[] { paramView, Integer.valueOf(paramInt), paramJSONObject });
    paramView = g.cl(paramView, f.g(parame, paramJSONObject));
    if (paramView == null)
    {
      ab.e("MicroMsg.JsApiUpdateMap", "mapView is null, return");
      AppMethodBeat.o(93881);
      return false;
    }
    if (paramJSONObject.has("scale")) {
      paramView.ar((float)paramJSONObject.optDouble("scale", 16.0D));
    }
    if (paramJSONObject.has("rotate")) {
      paramView.as((float)paramJSONObject.optDouble("rotate", 0.0D));
    }
    if (paramJSONObject.has("skew")) {
      paramView.at((float)paramJSONObject.optDouble("skew", 0.0D));
    }
    float f1;
    float f2;
    if ((paramJSONObject.has("centerLatitude")) && (paramJSONObject.has("centerLongitude")))
    {
      f1 = bo.getFloat(paramJSONObject.optString("centerLatitude"), 0.0F);
      f2 = bo.getFloat(paramJSONObject.optString("centerLongitude"), 0.0F);
      if ((Math.abs(f1) <= 90.0F) && (Math.abs(f2) <= 180.0F)) {
        paramView.M(f1, f2);
      }
    }
    if (paramJSONObject.has("enableZoom")) {
      paramView.ej(paramJSONObject.optBoolean("enableZoom", true));
    }
    if (paramJSONObject.has("enableScroll")) {
      paramView.ek(paramJSONObject.optBoolean("enableScroll", true));
    }
    if (paramJSONObject.has("enableRotate")) {
      paramView.el(paramJSONObject.optBoolean("enableRotate", true));
    }
    if (paramJSONObject.has("showCompass")) {
      paramView.em(paramJSONObject.optBoolean("showCompass", false));
    }
    if (paramJSONObject.has("enable3D")) {
      paramView.en(paramJSONObject.optBoolean("enable3D", false));
    }
    if (paramJSONObject.has("enableOverlooking")) {
      paramView.eo(paramJSONObject.optBoolean("enableOverlooking", false));
    }
    if (paramJSONObject.has("enableSatellite")) {
      paramView.ep(paramJSONObject.optBoolean("enableSatellite", false));
    }
    if (paramJSONObject.has("enableTraffic")) {
      paramView.eq(paramJSONObject.optBoolean("enableTraffic", false));
    }
    if (paramJSONObject.has("enableIndoor")) {
      paramView.er(paramJSONObject.optBoolean("enableIndoor", false));
    }
    if (paramJSONObject.has("enableIndoorLevelPick")) {
      paramView.es(paramJSONObject.optBoolean("enableIndoorLevelPick", false));
    }
    if (paramJSONObject.has("showLocation")) {
      paramView.eu(paramJSONObject.optBoolean("showLocation", false));
    }
    if (paramJSONObject.has("showScale")) {
      paramView.et(paramJSONObject.optBoolean("showScale", true));
    }
    try
    {
      if (paramJSONObject.has("covers"))
      {
        paramView.aDD();
        paramJSONObject = new JSONArray(paramJSONObject.optString("covers"));
        paramInt = 0;
        while (paramInt < paramJSONObject.length())
        {
          Object localObject = (JSONObject)paramJSONObject.get(paramInt);
          f1 = bo.getFloat(((JSONObject)localObject).optString("latitude"), 0.0F);
          f2 = bo.getFloat(((JSONObject)localObject).optString("longitude"), 0.0F);
          String str = ((com.tencent.mm.plugin.appbrand.e.b)parame.q(com.tencent.mm.plugin.appbrand.e.b.class)).b(parame, ((JSONObject)localObject).optString("iconPath"));
          float f3 = (float)((JSONObject)localObject).optDouble("rotate", 0.0D);
          localObject = new b.d();
          ((b.d)localObject).g(f1, f2);
          ((b.d)localObject).hPe = str;
          ((b.d)localObject).rotate = f3;
          paramView.a((b.d)localObject, (a)parame.q(a.class));
          paramInt += 1;
        }
      }
      com.tencent.mm.plugin.appbrand.jsapi.g.a.e.oe(4);
    }
    catch (Exception parame)
    {
      ab.e("MicroMsg.JsApiUpdateMap", "parse covers error, exception : %s", new Object[] { parame });
      AppMethodBeat.o(93881);
      return false;
    }
    AppMethodBeat.o(93881);
    return true;
  }
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(93880);
    try
    {
      int i = paramJSONObject.optInt("mapId");
      AppMethodBeat.o(93880);
      return i;
    }
    catch (Exception paramJSONObject)
    {
      ab.e("MicroMsg.JsApiUpdateMap", "get mapId error, exception : %s", new Object[] { paramJSONObject });
      AppMethodBeat.o(93880);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.v
 * JD-Core Version:    0.7.0.1
 */