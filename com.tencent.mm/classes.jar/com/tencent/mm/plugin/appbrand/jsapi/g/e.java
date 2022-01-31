package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.graphics.Color;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.s;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.f;
import com.tencent.mm.plugin.appbrand.u.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e
  extends c
{
  public static final int CTRL_INDEX = 492;
  public static final String NAME = "addMapPolygons";
  
  protected final boolean c(com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiAddMapPolygons", "data is null");
      return false;
    }
    y.d("MicroMsg.JsApiAddMapPolygons", "onUpdateView, data:%s", new Object[] { paramJSONObject.toString() });
    parame = f.o(parame.getAppId(), parame.ahJ(), p(paramJSONObject));
    if (parame == null)
    {
      y.e("MicroMsg.JsApiAddMapPolygons", "mapView is null, return");
      return false;
    }
    try
    {
      if (paramJSONObject.has("polygons"))
      {
        parame.ajq();
        paramView = new JSONArray(paramJSONObject.optString("polygons"));
        paramInt = 0;
        while (paramInt < paramView.length())
        {
          Object localObject = (JSONObject)paramView.get(paramInt);
          paramJSONObject = new ArrayList();
          JSONArray localJSONArray = new JSONArray(((JSONObject)localObject).optString("points"));
          int i = 0;
          while (i < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.getJSONObject(i);
            float f1 = bk.getFloat(localJSONObject.optString("latitude"), 0.0F);
            float f2 = bk.getFloat(localJSONObject.optString("longitude"), 0.0F);
            paramJSONObject.add(new e.1(this, f1, f2));
            i += 1;
          }
          i = h.bd(((JSONObject)localObject).optString("fillColor", ""), Color.parseColor("#000000"));
          int j = h.bd(((JSONObject)localObject).optString("strokeColor", ""), Color.parseColor("#000000"));
          int k = h.a((JSONObject)localObject, "strokeWidth", 0);
          int m = ((JSONObject)localObject).optInt("zIndex", 0);
          localObject = new b.s();
          ((b.s)localObject).gus = new ArrayList();
          ((b.s)localObject).gus.addAll(paramJSONObject);
          ((b.s)localObject).fillColor = i;
          ((b.s)localObject).strokeWidth = k;
          ((b.s)localObject).strokeColor = j;
          ((b.s)localObject).zIndex = m;
          parame.a((b.s)localObject);
          paramInt += 1;
        }
      }
      y.e("MicroMsg.JsApiAddMapPolygons", "data has not lines info");
      return true;
    }
    catch (Exception parame)
    {
      y.e("MicroMsg.JsApiAddMapPolygons", "parse lines error, exception : %s", new Object[] { parame });
    }
    return false;
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
      y.e("MicroMsg.JsApiAddMapPolygons", "get mapId error, exception : %s", new Object[] { paramJSONObject });
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.e
 * JD-Core Version:    0.7.0.1
 */