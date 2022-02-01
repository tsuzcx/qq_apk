package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ag
  extends d
{
  public static final int CTRL_INDEX = 4;
  public static final String NAME = "updateMap";
  
  public final int H(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143701);
    try
    {
      int i = paramJSONObject.optInt("mapId");
      AppMethodBeat.o(143701);
      return i;
    }
    catch (Exception paramJSONObject)
    {
      Log.e("MicroMsg.JsApiUpdateMap", "get mapId error, exception : %s", new Object[] { paramJSONObject });
      AppMethodBeat.o(143701);
    }
    return -1;
  }
  
  public final boolean c(h paramh, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143702);
    e.xg(3);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiUpdateMap", "data is null");
      AppMethodBeat.o(143702);
      return false;
    }
    paramView = paramh.getAppId();
    Log.i("MicroMsg.JsApiUpdateMap", "updateView appId:%s viewId:%d data:%s", new Object[] { paramView, Integer.valueOf(paramInt), paramJSONObject });
    paramView = g.dz(paramView, f.i(paramh, paramJSONObject));
    if (paramView == null)
    {
      Log.e("MicroMsg.JsApiUpdateMap", "mapView is null, return");
      AppMethodBeat.o(143702);
      return false;
    }
    if (paramJSONObject.has("enableZoom")) {
      paramView.hw(paramJSONObject.optBoolean("enableZoom", true));
    }
    if (paramJSONObject.has("enableScroll")) {
      paramView.hx(paramJSONObject.optBoolean("enableScroll", true));
    }
    if (paramJSONObject.has("enableRotate")) {
      paramView.hy(paramJSONObject.optBoolean("enableRotate", true));
    }
    if (paramJSONObject.has("showCompass")) {
      paramView.hz(paramJSONObject.optBoolean("showCompass", false));
    }
    if (paramJSONObject.has("enable3D")) {
      paramView.setBuilding3dEffectEnable(paramJSONObject.optBoolean("enable3D", false));
    }
    if (paramJSONObject.has("enableOverlooking")) {
      paramView.hA(paramJSONObject.optBoolean("enableOverlooking", false));
    }
    if (paramJSONObject.has("enableSatellite")) {
      paramView.hB(paramJSONObject.optBoolean("enableSatellite", false));
    }
    if (paramJSONObject.has("enableTraffic")) {
      paramView.hC(paramJSONObject.optBoolean("enableTraffic", false));
    }
    if (paramJSONObject.has("enableIndoor")) {
      paramView.hD(paramJSONObject.optBoolean("enableIndoor", false));
    }
    if (paramJSONObject.has("enableIndoorLevelPick")) {
      paramView.hE(paramJSONObject.optBoolean("enableIndoorLevelPick", false));
    }
    if (paramJSONObject.has("showLocation")) {
      paramView.hH(paramJSONObject.optBoolean("showLocation", false));
    }
    if (paramJSONObject.has("showScale")) {
      paramView.hF(paramJSONObject.optBoolean("showScale", true));
    }
    if (paramJSONObject.has("styleId")) {
      paramView.setMapStyle(paramJSONObject.optInt("styleId", 0));
    }
    if (paramJSONObject.has("maxScale")) {
      paramView.setMaxZoomLevel(Util.getInt(paramJSONObject.optString("maxScale"), 20));
    }
    if (paramJSONObject.has("minScale")) {
      paramView.setMinZoomLevel(Util.getInt(paramJSONObject.optString("minScale"), 3));
    }
    if (paramJSONObject.has("enablePoi")) {
      paramView.setPoisEnabled(paramJSONObject.optBoolean("enablePoi", true));
    }
    if (paramJSONObject.has("enableBuilding")) {
      paramView.hG(paramJSONObject.optBoolean("enableBuilding", true));
    }
    float f1;
    try
    {
      if (paramJSONObject.has("covers"))
      {
        paramView.bHd();
        JSONArray localJSONArray = new JSONArray(paramJSONObject.optString("covers"));
        paramInt = 0;
        while (paramInt < localJSONArray.length())
        {
          Object localObject = (JSONObject)localJSONArray.get(paramInt);
          double d1 = Util.getDouble(((JSONObject)localObject).optString("latitude"), 0.0D);
          double d2 = Util.getDouble(((JSONObject)localObject).optString("longitude"), 0.0D);
          String str = ((com.tencent.mm.plugin.appbrand.f.b)paramh.M(com.tencent.mm.plugin.appbrand.f.b.class)).b(paramh, ((JSONObject)localObject).optString("iconPath"));
          f1 = (float)((JSONObject)localObject).optDouble("rotate", 0.0D);
          localObject = new b.d();
          ((b.d)localObject).g(d1, d2);
          ((b.d)localObject).mav = str;
          ((b.d)localObject).mat = f1;
          paramView.a((b.d)localObject, (a)paramh.M(a.class));
          paramInt += 1;
        }
      }
      if (paramJSONObject.has("scale")) {
        break label761;
      }
    }
    catch (Exception paramh)
    {
      Log.e("MicroMsg.JsApiUpdateMap", "parse covers error, exception : %s", new Object[] { paramh });
      AppMethodBeat.o(143702);
      return false;
    }
    if ((paramJSONObject.has("rotate")) || (paramJSONObject.has("skew")) || (paramJSONObject.has("centerLatitude")) || (paramJSONObject.has("centerLongitude")))
    {
      label761:
      f1 = (float)paramJSONObject.optDouble("scale", -1.0D);
      float f2 = (float)paramJSONObject.optDouble("rotate", -1.0D);
      float f3 = (float)paramJSONObject.optDouble("skew", -1.0D);
      paramView.a(Util.getDouble(paramJSONObject.optString("centerLatitude", "-1"), -1.0D), Util.getDouble(paramJSONObject.optString("centerLongitude", "-1"), -1.0D), -1.0F, -1.0F, -1.0F, false);
      paramView.a(-1.0D, -1.0D, f1, f2, f3, true);
    }
    e.xg(4);
    AppMethodBeat.o(143702);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.ag
 * JD-Core Version:    0.7.0.1
 */