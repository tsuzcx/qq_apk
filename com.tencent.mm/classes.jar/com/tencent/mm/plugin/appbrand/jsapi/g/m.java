package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.f;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class m
  extends c
{
  public static final int CTRL_INDEX = 343;
  public static final String NAME = "removeMapMarkers";
  
  protected final boolean c(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    if (parame.agW().F(paramInt, false) == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.JsApiRemoveMapMarkers", "KeyValueSet(%s) is null.", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    if (paramJSONObject == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.JsApiRemoveMapMarkers", "data is null");
      return false;
    }
    parame = f.o(parame.getAppId(), parame.ahJ(), p(paramJSONObject));
    if (parame == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.JsApiRemoveMapMarkers", "mapView is null, return");
      return false;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.JsApiRemoveMapMarkers", "removeMapMarkers, data:%s", new Object[] { paramJSONObject.toString() });
    if (paramJSONObject.has("markers")) {
      try
      {
        paramView = new JSONArray(paramJSONObject.optString("markers"));
        paramInt = 0;
        while (paramInt < paramView.length())
        {
          parame.uh(paramView.getString(paramInt));
          paramInt += 1;
        }
        return true;
      }
      catch (JSONException parame)
      {
        com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.JsApiRemoveMapMarkers", parame, "", new Object[0]);
        return false;
      }
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
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.JsApiRemoveMapMarkers", "get mapId error, exception : %s", new Object[] { paramJSONObject });
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.m
 * JD-Core Version:    0.7.0.1
 */