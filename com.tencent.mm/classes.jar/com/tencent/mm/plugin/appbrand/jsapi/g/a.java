package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.graphics.Color;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.f;
import com.tencent.mm.plugin.appbrand.u.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
  extends c
{
  public static final int CTRL_INDEX = 135;
  public static final String NAME = "addMapCircles";
  
  protected final boolean c(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiAddMapCircles", "data is null");
      return false;
    }
    parame = f.o(parame.getAppId(), parame.ahJ(), p(paramJSONObject));
    if (parame == null)
    {
      y.e("MicroMsg.JsApiAddMapCircles", "mapView is null, return");
      return false;
    }
    try
    {
      if (paramJSONObject.has("circles"))
      {
        parame.ajl();
        paramView = new JSONArray(paramJSONObject.optString("circles"));
        paramInt = 0;
        while (paramInt < paramView.length())
        {
          paramJSONObject = (JSONObject)paramView.get(paramInt);
          float f1 = bk.getFloat(paramJSONObject.optString("latitude"), 0.0F);
          float f2 = bk.getFloat(paramJSONObject.optString("longitude"), 0.0F);
          int i = h.bd(paramJSONObject.optString("color", ""), Color.parseColor("#000000"));
          int j = h.bd(paramJSONObject.optString("fillColor", ""), Color.parseColor("#000000"));
          int k = paramJSONObject.optInt("radius");
          float f3 = h.a(paramJSONObject, "strokeWidth", 0.0F);
          paramJSONObject = new b.b();
          double d1 = f1;
          double d2 = f2;
          paramJSONObject.latitude = d1;
          paramJSONObject.longitude = d2;
          paramJSONObject.radius = k;
          paramJSONObject.strokeColor = i;
          paramJSONObject.strokeWidth = ((int)f3);
          paramJSONObject.fillColor = j;
          parame.a(paramJSONObject);
          paramInt += 1;
        }
      }
      return true;
    }
    catch (Exception parame)
    {
      y.e("MicroMsg.JsApiAddMapCircles", "parse circles error, exception : %s", new Object[] { parame });
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
      y.e("MicroMsg.JsApiAddMapCircles", "get mapId error, exception : %s", new Object[] { paramJSONObject });
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a
 * JD-Core Version:    0.7.0.1
 */