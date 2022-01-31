package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.graphics.Color;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.f;
import com.tencent.mm.plugin.appbrand.u.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.base.c
{
  public static final int CTRL_INDEX = 134;
  public static final String NAME = "addMapLines";
  
  protected final boolean c(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiAddMapLines", "data is null");
      return false;
    }
    y.d("MicroMsg.JsApiAddMapLines", "onUpdateView, data:%s", new Object[] { paramJSONObject.toString() });
    paramView = f.o(parame.getAppId(), parame.ahJ(), p(paramJSONObject));
    if (paramView == null)
    {
      y.e("MicroMsg.JsApiAddMapLines", "mapView is null, return");
      return false;
    }
    try
    {
      if (paramJSONObject.has("lines"))
      {
        paramView.ajn();
        paramJSONObject = new JSONArray(paramJSONObject.optString("lines"));
        paramInt = 0;
        while (paramInt < paramJSONObject.length())
        {
          Object localObject1 = (JSONObject)paramJSONObject.get(paramInt);
          ArrayList localArrayList = new ArrayList();
          Object localObject2 = new JSONArray(((JSONObject)localObject1).optString("points"));
          int i = 0;
          while (i < ((JSONArray)localObject2).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
            float f1 = bk.getFloat(localJSONObject.optString("latitude"), 0.0F);
            float f2 = bk.getFloat(localJSONObject.optString("longitude"), 0.0F);
            localArrayList.add(new c.1(this, f1, f2));
            i += 1;
          }
          i = h.bd(((JSONObject)localObject1).optString("color", ""), Color.parseColor("#000000"));
          int j = h.a((JSONObject)localObject1, "width", 0);
          boolean bool1 = ((JSONObject)localObject1).optBoolean("dottedLine", false);
          int k = h.bd(((JSONObject)localObject1).optString("borderColor", ""), Color.parseColor("#000000"));
          int m = h.a((JSONObject)localObject1, "borderWidth", 0);
          boolean bool2 = ((JSONObject)localObject1).optBoolean("arrowLine", false);
          localObject1 = ((JSONObject)localObject1).optString("arrowIconPath", "");
          localObject2 = new b.h();
          ((b.h)localObject2).gus = new ArrayList();
          ((b.h)localObject2).gus.addAll(localArrayList);
          ((b.h)localObject2).color = i;
          ((b.h)localObject2).width = j;
          ((b.h)localObject2).gut = bool1;
          ((b.h)localObject2).guu = k;
          ((b.h)localObject2).borderWidth = m;
          ((b.h)localObject2).guv = bool2;
          if (bool2) {
            ((b.h)localObject2).guw = ((com.tencent.mm.plugin.appbrand.d.b)parame.i(com.tencent.mm.plugin.appbrand.d.b.class)).b(parame, (String)localObject1);
          }
          paramView.a((b.h)localObject2);
          paramInt += 1;
        }
      }
      y.e("MicroMsg.JsApiAddMapLines", "data has not lines info");
      return true;
    }
    catch (Exception parame)
    {
      y.e("MicroMsg.JsApiAddMapLines", "parse lines error, exception : %s", new Object[] { parame });
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
      y.e("MicroMsg.JsApiAddMapLines", "get mapId error, exception : %s", new Object[] { paramJSONObject });
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.c
 * JD-Core Version:    0.7.0.1
 */