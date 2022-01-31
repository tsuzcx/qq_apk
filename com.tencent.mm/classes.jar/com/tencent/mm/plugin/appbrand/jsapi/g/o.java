package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONArray;
import org.json.JSONObject;

public final class o
  extends c
{
  public static final int CTRL_INDEX = 4;
  public static final String NAME = "updateMap";
  
  protected final boolean c(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiUpdateMap", "data is null");
      return false;
    }
    paramView = parame.getAppId();
    y.i("MicroMsg.JsApiUpdateMap", "updateView appId:%s viewId:%d data:%s", new Object[] { paramView, Integer.valueOf(paramInt), paramJSONObject });
    paramView = f.o(paramView, parame.ahJ(), p(paramJSONObject));
    if (paramView == null)
    {
      y.e("MicroMsg.JsApiUpdateMap", "mapView is null, return");
      return false;
    }
    if (paramJSONObject.has("scale")) {
      paramView.lv(paramJSONObject.optInt("scale", 16));
    }
    float f1;
    float f2;
    if ((paramJSONObject.has("centerLatitude")) && (paramJSONObject.has("centerLongitude")))
    {
      f1 = bk.getFloat(paramJSONObject.optString("centerLatitude"), 0.0F);
      f2 = bk.getFloat(paramJSONObject.optString("centerLongitude"), 0.0F);
      if ((Math.abs(f1) <= 90.0F) && (Math.abs(f2) <= 180.0F)) {
        paramView.F(f1, f2);
      }
    }
    if (paramJSONObject.has("enableZoom")) {
      paramView.dg(paramJSONObject.optBoolean("enableZoom", true));
    }
    if (paramJSONObject.has("enableScroll")) {
      paramView.dh(paramJSONObject.optBoolean("enableScroll", true));
    }
    if (paramJSONObject.has("enableRotate")) {
      paramView.di(paramJSONObject.optBoolean("enableRotate", true));
    }
    if (paramJSONObject.has("showCompass")) {
      paramView.dj(paramJSONObject.optBoolean("showCompass", false));
    }
    if (paramJSONObject.has("enable3D")) {
      paramView.dk(paramJSONObject.optBoolean("enable3D", false));
    }
    if (paramJSONObject.has("enableOverlooking")) {
      paramView.dl(paramJSONObject.optBoolean("enableOverlooking", false));
    }
    if (paramJSONObject.has("enableSatellite")) {
      paramView.dm(paramJSONObject.optBoolean("enableSatellite", false));
    }
    if (paramJSONObject.has("enableTraffic")) {
      paramView.dn(paramJSONObject.optBoolean("enableTraffic", false));
    }
    try
    {
      if (paramJSONObject.has("covers"))
      {
        paramView.ajp();
        paramJSONObject = new JSONArray(paramJSONObject.optString("covers"));
        paramInt = 0;
        while (paramInt < paramJSONObject.length())
        {
          Object localObject = (JSONObject)paramJSONObject.get(paramInt);
          f1 = bk.getFloat(((JSONObject)localObject).optString("latitude"), 0.0F);
          f2 = bk.getFloat(((JSONObject)localObject).optString("longitude"), 0.0F);
          String str = ((com.tencent.mm.plugin.appbrand.d.b)parame.i(com.tencent.mm.plugin.appbrand.d.b.class)).b(parame, ((JSONObject)localObject).optString("iconPath"));
          float f3 = (float)((JSONObject)localObject).optDouble("rotate", 0.0D);
          localObject = new b.d();
          double d1 = f1;
          double d2 = f2;
          ((b.d)localObject).latitude = d1;
          ((b.d)localObject).longitude = d2;
          ((b.d)localObject).gum = str;
          ((b.d)localObject).rotate = f3;
          paramView.a((b.d)localObject);
          paramInt += 1;
        }
      }
      return true;
    }
    catch (Exception parame)
    {
      y.e("MicroMsg.JsApiUpdateMap", "parse covers error, exception : %s", new Object[] { parame });
      return false;
    }
  }
  
  protected final int p(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("mapId");
      return i;
    }
    catch (Exception paramJSONObject)
    {
      y.e("MicroMsg.JsApiUpdateMap", "get mapId error, exception : %s", new Object[] { paramJSONObject });
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.o
 * JD-Core Version:    0.7.0.1
 */