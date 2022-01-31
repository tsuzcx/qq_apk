package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.graphics.Color;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.p;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.p.a;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.p.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.f;
import com.tencent.mm.plugin.appbrand.u.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends c
{
  public static final int CTRL_INDEX = 133;
  public static final String NAME = "addMapMarkers";
  
  protected final boolean c(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiAddMapMarkers", "data is null");
      return false;
    }
    y.i("MicroMsg.JsApiAddMapMarkers", "onUpdateView, data:%s", new Object[] { paramJSONObject.toString() });
    com.tencent.mm.plugin.appbrand.jsapi.g.a.b localb = f.o(parame.getAppId(), parame.ahJ(), p(paramJSONObject));
    if (localb == null)
    {
      y.e("MicroMsg.JsApiAddMapMarkers", "mapView is null, return");
      return false;
    }
    boolean bool = paramJSONObject.optBoolean("clear", true);
    y.i("MicroMsg.JsApiAddMapMarkers", "clear:%b", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      localb.ajo();
    }
    if (paramJSONObject.has("markers"))
    {
      try
      {
        paramView = new JSONArray(paramJSONObject.optString("markers"));
        if (paramView == null)
        {
          y.e("MicroMsg.JsApiAddMapMarkers", "markersArray is null, return");
          return false;
        }
      }
      catch (JSONException paramView)
      {
        for (;;)
        {
          paramView = null;
        }
        paramInt = 0;
      }
      for (;;)
      {
        if (paramInt < paramView.length()) {
          try
          {
            paramJSONObject = (JSONObject)paramView.get(paramInt);
            if (paramJSONObject != null)
            {
              localp = new b.p();
              str1 = paramJSONObject.optString("id");
              float f1 = bk.getFloat(paramJSONObject.optString("latitude"), 0.0F);
              float f2 = bk.getFloat(paramJSONObject.optString("longitude"), 0.0F);
              double d1 = f1;
              double d2 = f2;
              localp.latitude = d1;
              localp.longitude = d2;
              localObject1 = paramJSONObject.optString("iconPath");
              f1 = h.a(paramJSONObject, "width", 0.0F);
              f2 = h.a(paramJSONObject, "height", 0.0F);
              if (!bk.bl((String)localObject1))
              {
                localp.gum = ((com.tencent.mm.plugin.appbrand.d.b)parame.i(com.tencent.mm.plugin.appbrand.d.b.class)).b(parame, (String)localObject1);
                localp.guy = f1;
                localp.guz = f2;
              }
              localp.rotate = ((float)paramJSONObject.optDouble("rotate", 0.0D));
              localp.alpha = ((float)paramJSONObject.optDouble("alpha", 1.0D));
              localp.data = paramJSONObject.optString("data");
              if (!paramJSONObject.has("anchor")) {}
            }
          }
          catch (JSONException localJSONException2)
          {
            try
            {
              localObject1 = new JSONObject(paramJSONObject.optString("anchor"));
              if (localObject1 != null)
              {
                localp.H((float)((JSONObject)localObject1).optDouble("x", 0.5D), (float)((JSONObject)localObject1).optDouble("y", 1.0D));
                localp.zIndex = paramJSONObject.optInt("zIndex", 0);
                localObject1 = paramJSONObject.optString("label");
                if (bk.bl((String)localObject1)) {}
              }
            }
            catch (JSONException localJSONException2)
            {
              try
              {
                localObject1 = new JSONObject((String)localObject1);
                if (localObject1 != null)
                {
                  String str2 = ((JSONObject)localObject1).optString("content");
                  i = h.bd(((JSONObject)localObject1).optString("color", "#000000"), Color.parseColor("#000000"));
                  j = ((JSONObject)localObject1).optInt("fontSize", 12);
                  k = h.a((JSONObject)localObject1, "anchorX", h.a((JSONObject)localObject1, "x", 0));
                  m = h.a((JSONObject)localObject1, "anchorY", h.a((JSONObject)localObject1, "y", 0));
                  n = ((JSONObject)localObject1).optInt("borderRadius", 0);
                  int i1 = h.h((JSONObject)localObject1, "borderWidth");
                  int i2 = h.wE(((JSONObject)localObject1).optString("borderColor"));
                  int i3 = h.bd(((JSONObject)localObject1).optString("bgColor", ""), Color.parseColor("#000000"));
                  int i4 = h.a((JSONObject)localObject1, "padding", 0);
                  localp.guB = new b.p.b(str2, i, j, k, m, i3, n, i1, i2, ((JSONObject)localObject1).optString("textAlign", ""), i4);
                }
                paramJSONObject = paramJSONObject.optString("callout");
                if (bk.bl(paramJSONObject)) {}
              }
              catch (JSONException localJSONException2)
              {
                try
                {
                  for (;;)
                  {
                    b.p localp;
                    String str1;
                    Object localObject1;
                    int i;
                    int j;
                    int k;
                    int m;
                    int n;
                    paramJSONObject = new JSONObject(paramJSONObject);
                    if (paramJSONObject != null)
                    {
                      localObject1 = paramJSONObject.optString("content");
                      i = h.bd(paramJSONObject.optString("color", "#000000"), Color.parseColor("#000000"));
                      j = paramJSONObject.optInt("fontSize", 12);
                      k = paramJSONObject.optInt("borderRadius", 0);
                      m = h.h(paramJSONObject, "borderWidth");
                      n = h.wE(paramJSONObject.optString("borderColor"));
                      localp.guA = new b.p.a((String)localObject1, i, j, k, h.bd(paramJSONObject.optString("bgColor", "#000000"), Color.parseColor("#000000")), m, n, h.a(paramJSONObject, "padding", 0), h.bd(paramJSONObject.optString("shadowColor", "#000000"), Color.parseColor("#000000")), paramJSONObject.optInt("shadowOpacity"), paramJSONObject.optInt("shadowOffsetX"), paramJSONObject.optInt("shadowOffsetY"), paramJSONObject.optInt("display", 0), paramJSONObject.optString("textAlign", ""));
                    }
                    localb.a(str1, localp);
                    paramInt += 1;
                    break;
                    paramJSONObject = paramJSONObject;
                    y.printErrStackTrace("MicroMsg.JsApiAddMapMarkers", paramJSONObject, "", new Object[0]);
                    paramJSONObject = null;
                    continue;
                    localJSONException1 = localJSONException1;
                    Object localObject2 = null;
                    continue;
                    localp.H(0.5F, 1.0F);
                  }
                  localJSONException2 = localJSONException2;
                  Object localObject3 = null;
                }
                catch (JSONException paramJSONObject)
                {
                  for (;;)
                  {
                    paramJSONObject = null;
                  }
                }
              }
            }
          }
        }
      }
    }
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
      y.e("MicroMsg.JsApiAddMapMarkers", "get mapId error, exception : %s", new Object[] { paramJSONObject });
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.d
 * JD-Core Version:    0.7.0.1
 */