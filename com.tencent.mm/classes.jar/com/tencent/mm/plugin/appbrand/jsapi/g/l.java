package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.f;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class l
  extends b
{
  public static final int CTRL_INDEX = 3;
  public static final String NAME = "removeMap";
  
  protected final boolean b(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiRemoveMap", "data is null");
      return false;
    }
    f.p(parame.getAppId(), parame.ahJ(), p(paramJSONObject));
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
      y.e("MicroMsg.JsApiRemoveMap", "get mapId error, exception : %s", new Object[] { paramJSONObject });
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.l
 * JD-Core Version:    0.7.0.1
 */