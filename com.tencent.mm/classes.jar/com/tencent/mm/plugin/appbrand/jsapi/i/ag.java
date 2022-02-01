package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
      ad.e("MicroMsg.JsApiUpdateMap", "get mapId error, exception : %s", new Object[] { paramJSONObject });
      AppMethodBeat.o(143701);
    }
    return -1;
  }
  
  public final boolean c(com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143702);
    com.tencent.mm.plugin.appbrand.jsapi.i.a.e.th(3);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiUpdateMap", "data is null");
      AppMethodBeat.o(143702);
      return false;
    }
    paramView = parame.getAppId();
    ad.i("MicroMsg.JsApiUpdateMap", "updateView appId:%s viewId:%d data:%s", new Object[] { paramView, Integer.valueOf(paramInt), paramJSONObject });
    paramView = g.di(paramView, f.i(parame, paramJSONObject));
    if (paramView == null)
    {
      ad.e("MicroMsg.JsApiUpdateMap", "mapView is null, return");
      AppMethodBeat.o(143702);
      return false;
    }
    if (paramJSONObject.has("enableZoom")) {
      paramView.gA(paramJSONObject.optBoolean("enableZoom", true));
    }
    if (paramJSONObject.has("enableScroll")) {
      paramView.gB(paramJSONObject.optBoolean("enableScroll", true));
    }
    if (paramJSONObject.has("enableRotate")) {
      paramView.gC(paramJSONObject.optBoolean("enableRotate", true));
    }
    if (paramJSONObject.has("showCompass")) {
      paramView.gD(paramJSONObject.optBoolean("showCompass", false));
    }
    if (paramJSONObject.has("enable3D")) {
      paramView.gE(paramJSONObject.optBoolean("enable3D", false));
    }
    if (paramJSONObject.has("enableOverlooking")) {
      paramView.gF(paramJSONObject.optBoolean("enableOverlooking", false));
    }
    if (paramJSONObject.has("enableSatellite")) {
      paramView.gG(paramJSONObject.optBoolean("enableSatellite", false));
    }
    if (paramJSONObject.has("enableTraffic")) {
      paramView.gH(paramJSONObject.optBoolean("enableTraffic", false));
    }
    if (paramJSONObject.has("enableIndoor")) {
      paramView.gI(paramJSONObject.optBoolean("enableIndoor", false));
    }
    if (paramJSONObject.has("enableIndoorLevelPick")) {
      paramView.gJ(paramJSONObject.optBoolean("enableIndoorLevelPick", false));
    }
    if (paramJSONObject.has("showLocation")) {
      paramView.gL(paramJSONObject.optBoolean("showLocation", false));
    }
    if (paramJSONObject.has("showScale")) {
      paramView.gK(paramJSONObject.optBoolean("showScale", true));
    }
    if (paramJSONObject.has("styleId")) {
      paramView.setMapStyle(paramJSONObject.optInt("styleId", 0));
    }
    if (paramJSONObject.has("maxScale")) {
      paramView.setMaxZoomLevel(bt.getInt(paramJSONObject.optString("maxScale"), 20));
    }
    if (paramJSONObject.has("minScale")) {
      paramView.setMinZoomLevel(bt.getInt(paramJSONObject.optString("minScale"), 3));
    }
    if (paramJSONObject.has("enablePoi")) {
      paramView.setPoisEnabled(paramJSONObject.optBoolean("enablePoi", true));
    }
    float f1;
    try
    {
      if (paramJSONObject.has("covers"))
      {
        paramView.bkX();
        JSONArray localJSONArray = new JSONArray(paramJSONObject.optString("covers"));
        paramInt = 0;
        while (paramInt < localJSONArray.length())
        {
          Object localObject = (JSONObject)localJSONArray.get(paramInt);
          double d1 = bt.getDouble(((JSONObject)localObject).optString("latitude"), 0.0D);
          double d2 = bt.getDouble(((JSONObject)localObject).optString("longitude"), 0.0D);
          String str = ((com.tencent.mm.plugin.appbrand.f.b)parame.K(com.tencent.mm.plugin.appbrand.f.b.class)).b(parame, ((JSONObject)localObject).optString("iconPath"));
          f1 = (float)((JSONObject)localObject).optDouble("rotate", 0.0D);
          localObject = new b.d();
          ((b.d)localObject).g(d1, d2);
          ((b.d)localObject).kRE = str;
          ((b.d)localObject).kRD = f1;
          paramView.a((b.d)localObject, (a)parame.K(a.class));
          paramInt += 1;
        }
      }
      if (paramJSONObject.has("scale")) {
        break label736;
      }
    }
    catch (Exception parame)
    {
      ad.e("MicroMsg.JsApiUpdateMap", "parse covers error, exception : %s", new Object[] { parame });
      AppMethodBeat.o(143702);
      return false;
    }
    if ((paramJSONObject.has("rotate")) || (paramJSONObject.has("skew")) || (paramJSONObject.has("centerLatitude")) || (paramJSONObject.has("centerLongitude")))
    {
      label736:
      f1 = (float)paramJSONObject.optDouble("scale", -1.0D);
      float f2 = (float)paramJSONObject.optDouble("rotate", -1.0D);
      float f3 = (float)paramJSONObject.optDouble("skew", -1.0D);
      paramView.a(bt.getDouble(paramJSONObject.optString("centerLatitude", "-1"), -1.0D), bt.getDouble(paramJSONObject.optString("centerLongitude", "-1"), -1.0D), -1.0F, -1.0F, -1.0F, false);
      paramView.a(-1.0D, -1.0D, f1, f2, f3, true);
    }
    com.tencent.mm.plugin.appbrand.jsapi.i.a.e.th(4);
    AppMethodBeat.o(143702);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.ag
 * JD-Core Version:    0.7.0.1
 */