package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ag
  extends d
{
  public static final int CTRL_INDEX = 4;
  public static final String NAME = "updateMap";
  
  public final int A(JSONObject paramJSONObject)
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
      ae.e("MicroMsg.JsApiUpdateMap", "get mapId error, exception : %s", new Object[] { paramJSONObject });
      AppMethodBeat.o(143701);
    }
    return -1;
  }
  
  public final boolean c(com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143702);
    com.tencent.mm.plugin.appbrand.jsapi.i.a.e.tk(3);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.JsApiUpdateMap", "data is null");
      AppMethodBeat.o(143702);
      return false;
    }
    paramView = parame.getAppId();
    ae.i("MicroMsg.JsApiUpdateMap", "updateView appId:%s viewId:%d data:%s", new Object[] { paramView, Integer.valueOf(paramInt), paramJSONObject });
    paramView = g.dk(paramView, f.i(parame, paramJSONObject));
    if (paramView == null)
    {
      ae.e("MicroMsg.JsApiUpdateMap", "mapView is null, return");
      AppMethodBeat.o(143702);
      return false;
    }
    if (paramJSONObject.has("enableZoom")) {
      paramView.gz(paramJSONObject.optBoolean("enableZoom", true));
    }
    if (paramJSONObject.has("enableScroll")) {
      paramView.gA(paramJSONObject.optBoolean("enableScroll", true));
    }
    if (paramJSONObject.has("enableRotate")) {
      paramView.gB(paramJSONObject.optBoolean("enableRotate", true));
    }
    if (paramJSONObject.has("showCompass")) {
      paramView.gC(paramJSONObject.optBoolean("showCompass", false));
    }
    if (paramJSONObject.has("enable3D")) {
      paramView.setBuilding3dEffectEnable(paramJSONObject.optBoolean("enable3D", false));
    }
    if (paramJSONObject.has("enableOverlooking")) {
      paramView.gD(paramJSONObject.optBoolean("enableOverlooking", false));
    }
    if (paramJSONObject.has("enableSatellite")) {
      paramView.gE(paramJSONObject.optBoolean("enableSatellite", false));
    }
    if (paramJSONObject.has("enableTraffic")) {
      paramView.gF(paramJSONObject.optBoolean("enableTraffic", false));
    }
    if (paramJSONObject.has("enableIndoor")) {
      paramView.gG(paramJSONObject.optBoolean("enableIndoor", false));
    }
    if (paramJSONObject.has("enableIndoorLevelPick")) {
      paramView.gH(paramJSONObject.optBoolean("enableIndoorLevelPick", false));
    }
    if (paramJSONObject.has("showLocation")) {
      paramView.gK(paramJSONObject.optBoolean("showLocation", false));
    }
    if (paramJSONObject.has("showScale")) {
      paramView.gI(paramJSONObject.optBoolean("showScale", true));
    }
    if (paramJSONObject.has("styleId")) {
      paramView.setMapStyle(paramJSONObject.optInt("styleId", 0));
    }
    if (paramJSONObject.has("maxScale")) {
      paramView.setMaxZoomLevel(bu.getInt(paramJSONObject.optString("maxScale"), 20));
    }
    if (paramJSONObject.has("minScale")) {
      paramView.setMinZoomLevel(bu.getInt(paramJSONObject.optString("minScale"), 3));
    }
    if (paramJSONObject.has("enablePoi")) {
      paramView.setPoisEnabled(paramJSONObject.optBoolean("enablePoi", true));
    }
    if (paramJSONObject.has("enableBuilding")) {
      paramView.gJ(paramJSONObject.optBoolean("enableBuilding", true));
    }
    float f1;
    try
    {
      if (paramJSONObject.has("covers"))
      {
        paramView.blH();
        JSONArray localJSONArray = new JSONArray(paramJSONObject.optString("covers"));
        paramInt = 0;
        while (paramInt < localJSONArray.length())
        {
          Object localObject = (JSONObject)localJSONArray.get(paramInt);
          double d1 = bu.getDouble(((JSONObject)localObject).optString("latitude"), 0.0D);
          double d2 = bu.getDouble(((JSONObject)localObject).optString("longitude"), 0.0D);
          String str = ((com.tencent.mm.plugin.appbrand.f.b)parame.K(com.tencent.mm.plugin.appbrand.f.b.class)).b(parame, ((JSONObject)localObject).optString("iconPath"));
          f1 = (float)((JSONObject)localObject).optDouble("rotate", 0.0D);
          localObject = new b.d();
          ((b.d)localObject).g(d1, d2);
          ((b.d)localObject).kVn = str;
          ((b.d)localObject).kVl = f1;
          paramView.a((b.d)localObject, (a)parame.K(a.class));
          paramInt += 1;
        }
      }
      if (paramJSONObject.has("scale")) {
        break label761;
      }
    }
    catch (Exception parame)
    {
      ae.e("MicroMsg.JsApiUpdateMap", "parse covers error, exception : %s", new Object[] { parame });
      AppMethodBeat.o(143702);
      return false;
    }
    if ((paramJSONObject.has("rotate")) || (paramJSONObject.has("skew")) || (paramJSONObject.has("centerLatitude")) || (paramJSONObject.has("centerLongitude")))
    {
      label761:
      f1 = (float)paramJSONObject.optDouble("scale", -1.0D);
      float f2 = (float)paramJSONObject.optDouble("rotate", -1.0D);
      float f3 = (float)paramJSONObject.optDouble("skew", -1.0D);
      paramView.a(bu.getDouble(paramJSONObject.optString("centerLatitude", "-1"), -1.0D), bu.getDouble(paramJSONObject.optString("centerLongitude", "-1"), -1.0D), -1.0F, -1.0F, -1.0F, false);
      paramView.a(-1.0D, -1.0D, f1, f2, f3, true);
    }
    com.tencent.mm.plugin.appbrand.jsapi.i.a.e.tk(4);
    AppMethodBeat.o(143702);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.ag
 * JD-Core Version:    0.7.0.1
 */