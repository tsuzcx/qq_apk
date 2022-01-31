package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.f;
import com.tencent.mm.plugin.appbrand.u.h;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  extends c
{
  public static final int CTRL_INDEX = 140;
  public static final String NAME = "addMapControls";
  
  protected final boolean c(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiAddMapControls", "data is null");
      return false;
    }
    y.d("MicroMsg.JsApiAddMapControls", "onUpdateView, data:%s", new Object[] { paramJSONObject.toString() });
    paramView = f.o(parame.getAppId(), parame.ahJ(), p(paramJSONObject));
    if (paramView == null)
    {
      y.e("MicroMsg.JsApiAddMapControls", "mapView is null, return");
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        if (paramJSONObject.has("controls"))
        {
          paramView.ajm();
          paramJSONObject = new JSONArray(paramJSONObject.optString("controls"));
          i = 0;
          if (i < paramJSONObject.length())
          {
            JSONObject localJSONObject1 = (JSONObject)paramJSONObject.get(i);
            b.c localc = new b.c();
            localc.gum = ((com.tencent.mm.plugin.appbrand.d.b)parame.i(com.tencent.mm.plugin.appbrand.d.b.class)).b(parame, localJSONObject1.optString("iconPath"));
            localc.gun = localJSONObject1.optBoolean("clickable");
            localc.data = localJSONObject1.optString("data");
            JSONObject localJSONObject2 = localJSONObject1.getJSONObject("position");
            int j = h.a(localJSONObject2, "left", 0);
            int k = h.a(localJSONObject2, "top", 0);
            localc.left = j;
            localc.top = k;
            if (localJSONObject2.has("width")) {
              localc.width = h.a(localJSONObject2, "width", 0);
            }
            if (localJSONObject2.has("height")) {
              localc.height = h.a(localJSONObject2, "height", 0);
            }
            if (localJSONObject1.optBoolean("clickable")) {
              paramView.a(localc, new b.1(this, paramInt, parame));
            } else {
              paramView.a(localc);
            }
          }
        }
      }
      catch (Exception parame)
      {
        y.e("MicroMsg.JsApiAddMapControls", "parse circles error, exception : %s", new Object[] { parame });
        return false;
      }
      return true;
      i += 1;
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
      y.e("MicroMsg.JsApiAddMapControls", "get mapId error, exception : %s", new Object[] { paramJSONObject });
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.b
 * JD-Core Version:    0.7.0.1
 */