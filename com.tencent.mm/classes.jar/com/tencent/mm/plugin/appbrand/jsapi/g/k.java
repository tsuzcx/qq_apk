package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.f;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class k
  extends c
{
  public static final int CTRL_INDEX = 141;
  public static final String NAME = "moveToMapLocation";
  
  protected final boolean c(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiMoveToMapLocation", "data is null");
      return false;
    }
    parame = f.o(parame.getAppId(), parame.ahJ(), p(paramJSONObject));
    if (parame == null)
    {
      y.e("MicroMsg.JsApiMoveToMapLocation", "appBrandMapView is null, return");
      return false;
    }
    y.i("MicroMsg.JsApiMoveToMapLocation", "moveToMapLocation");
    parame.ajj();
    return true;
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
      y.e("MicroMsg.JsApiMoveToMapLocation", "get mapId error, exception : %s", new Object[] { paramJSONObject });
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.k
 * JD-Core Version:    0.7.0.1
 */