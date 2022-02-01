package com.tencent.mm.plugin.appbrand.jsapi.l;

import android.graphics.Color;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.l.a.b.v;
import com.tencent.mm.plugin.appbrand.jsapi.l.a.b.v.a;
import com.tencent.mm.plugin.appbrand.jsapi.l.a.b.v.b;
import com.tencent.mm.plugin.appbrand.jsapi.l.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b
  extends c
{
  protected static b.v a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    b.v localv = new b.v();
    if (paramJSONObject2.has("joinCluster")) {
      localv.oYD = paramJSONObject2.optBoolean("joinCluster", false);
    }
    if (paramJSONObject2.has("clusterId")) {
      localv.oYg = paramJSONObject2.optInt("clusterId", -1);
    }
    if ((paramJSONObject2.has("latitude")) && (paramJSONObject2.has("longitude")))
    {
      double d1 = Util.getDouble(paramJSONObject2.optString("latitude"), 0.0D);
      double d2 = Util.getDouble(paramJSONObject2.optString("longitude"), 0.0D);
      localv.latitude = d1;
      localv.longitude = d2;
    }
    Object localObject1 = paramJSONObject2.optString("iconPath");
    float f1 = com.tencent.mm.plugin.appbrand.ac.g.a(paramJSONObject2, "width", 0.0F);
    float f2 = com.tencent.mm.plugin.appbrand.ac.g.a(paramJSONObject2, "height", 0.0F);
    if ((!Util.isNullOrNil((String)localObject1)) && (parame.K(com.tencent.mm.plugin.appbrand.f.b.class) != null))
    {
      localv.oYm = ((com.tencent.mm.plugin.appbrand.f.b)parame.K(com.tencent.mm.plugin.appbrand.f.b.class)).b(parame, (String)localObject1);
      localv.oYE = f1;
      localv.oYF = f2;
    }
    localv.oYk = ((float)paramJSONObject2.optDouble("rotate", 0.0D));
    localv.alpha = ((float)paramJSONObject2.optDouble("alpha", 1.0D));
    localv.data = paramJSONObject2.optString("data");
    localv.oYG = paramJSONObject2.optString("ariaLabel");
    localv.oYH = paramJSONObject2.optString("collision");
    if (paramJSONObject2.has("anchor")) {}
    try
    {
      localObject1 = new JSONObject(paramJSONObject2.optString("anchor"));
      if (localObject1 != null)
      {
        localv.N((float)((JSONObject)localObject1).optDouble("x", 0.5D), (float)((JSONObject)localObject1).optDouble("y", 1.0D));
        localv.zIndex = paramJSONObject2.optInt("zIndex", 0);
        localObject1 = paramJSONObject2.optString("label");
        if (Util.isNullOrNil((String)localObject1)) {}
      }
    }
    catch (JSONException localJSONException3)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if (localObject1 != null)
        {
          str1 = ((JSONObject)localObject1).optString("content");
          i = com.tencent.mm.plugin.appbrand.ac.g.cO(((JSONObject)localObject1).optString("color", "#000000"), Color.parseColor("#000000"));
          j = ((JSONObject)localObject1).optInt("fontSize", 12);
          k = com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject1, "anchorX", com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject1, "x", 0));
          m = com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject1, "anchorY", com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject1, "y", 0));
          n = com.tencent.mm.plugin.appbrand.ac.g.g((JSONObject)localObject1, "borderRadius");
          int i1 = com.tencent.mm.plugin.appbrand.ac.g.g((JSONObject)localObject1, "borderWidth");
          int i2 = com.tencent.mm.plugin.appbrand.ac.g.anf(((JSONObject)localObject1).optString("borderColor"));
          int i3 = com.tencent.mm.plugin.appbrand.ac.g.cO(((JSONObject)localObject1).optString("bgColor", ""), Color.parseColor("#000000"));
          int i4 = com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject1, "padding", 0);
          String str2 = ((JSONObject)localObject1).optString("textAlign", "");
          int i5 = com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject1, "width", -1);
          int i6 = com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject1, "height", -1);
          localv.oYJ = new b.v.b(str1, i, j, k, m, i3, n, i1, i2, str2, i4);
          localv.oYJ.width = i5;
          localv.oYJ.height = i6;
        }
        localObject1 = paramJSONObject2.optString("callout");
        if (Util.isNullOrNil((String)localObject1)) {}
      }
      catch (JSONException localJSONException3)
      {
        try
        {
          String str1;
          int n;
          localObject1 = new JSONObject((String)localObject1);
          if (localObject1 != null)
          {
            str1 = ((JSONObject)localObject1).optString("content");
            i = com.tencent.mm.plugin.appbrand.ac.g.cO(((JSONObject)localObject1).optString("color", "#000000"), Color.parseColor("#000000"));
            j = ((JSONObject)localObject1).optInt("fontSize", 12);
            k = com.tencent.mm.plugin.appbrand.ac.g.g((JSONObject)localObject1, "borderRadius");
            m = com.tencent.mm.plugin.appbrand.ac.g.g((JSONObject)localObject1, "borderWidth");
            n = com.tencent.mm.plugin.appbrand.ac.g.anf(((JSONObject)localObject1).optString("borderColor"));
            localv.oYI = new b.v.a(str1, i, j, k, com.tencent.mm.plugin.appbrand.ac.g.cO(((JSONObject)localObject1).optString("bgColor", "#000000"), Color.parseColor("#000000")), m, n, com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject1, "padding", 0), com.tencent.mm.plugin.appbrand.ac.g.cO(((JSONObject)localObject1).optString("shadowColor", "#000000"), Color.parseColor("#000000")), ((JSONObject)localObject1).optInt("shadowOpacity"), com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject1, "shadowOffsetX", 0), com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject1, "shadowOffsetY", 0), ((JSONObject)localObject1).optInt("display", 0), ((JSONObject)localObject1).optString("textAlign", ""), com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject1, "anchorX", 0), com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject1, "anchorY", 0));
          }
          localObject1 = paramJSONObject2.optString("customCallout");
          if (Util.isNullOrNil((String)localObject1)) {}
        }
        catch (JSONException localJSONException3)
        {
          try
          {
            for (;;)
            {
              int i;
              int j;
              int k;
              int m;
              localObject1 = new JSONObject((String)localObject1);
              if (localObject1 != null)
              {
                i = ((JSONObject)localObject1).optInt("viewId", 0);
                j = ((JSONObject)localObject1).optInt("display", 0);
                bool = paramJSONObject1.optBoolean("independent", false);
                k = com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject1, "anchorX", 0);
                m = com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject1, "anchorY", 0);
                parame = ((com.tencent.mm.plugin.appbrand.jsapi.base.g)parame.K(com.tencent.mm.plugin.appbrand.jsapi.base.g.class)).c(parame, paramJSONObject1).hl(bool).bg(i);
                if (parame == null) {
                  break;
                }
                bool = true;
                Log.i("MicroMsg.BaseMapJsApi", "viewId:%d view is %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
                if (parame != null)
                {
                  localv.oYI = new b.v.a();
                  localv.oYI.view = parame;
                  localv.oYI.oYP = j;
                  localv.oYI.oYQ = k;
                  localv.oYI.oYR = m;
                }
              }
              parame = paramJSONObject2.optString("buildingId");
              paramJSONObject1 = paramJSONObject2.optString("floorName");
              localv.buildingId = parame;
              localv.floorName = paramJSONObject1;
              return localv;
              localJSONException1 = localJSONException1;
              Object localObject2 = null;
              continue;
              localv.N(0.5F, 1.0F);
              continue;
              localJSONException2 = localJSONException2;
              Object localObject3 = null;
            }
            localJSONException3 = localJSONException3;
            Object localObject4 = null;
          }
          catch (JSONException localJSONException4)
          {
            for (;;)
            {
              Object localObject5 = null;
              continue;
              boolean bool = false;
            }
          }
        }
      }
    }
  }
  
  protected final void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    parame.j(paramInt, paramString);
    com.tencent.mm.plugin.appbrand.jsapi.l.a.e.e(getName(), paramBoolean1, paramBoolean2);
  }
  
  public void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, int paramInt)
  {
    com.tencent.mm.plugin.appbrand.jsapi.l.a.e.ahQ(getName());
  }
  
  protected final com.tencent.mm.plugin.appbrand.jsapi.l.a.b g(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject)
  {
    if ((parame instanceof com.tencent.mm.plugin.appbrand.jsapi.g)) {
      return com.tencent.mm.plugin.appbrand.jsapi.l.a.g.dK(parame.getAppId(), f.h(parame, paramJSONObject));
    }
    if (parame.K(com.tencent.mm.plugin.appbrand.jsapi.base.g.class) == null)
    {
      Log.e("MicroMsg.BaseMapJsApi", "name:%s IComponentConverter is null, return", new Object[] { getName() });
      return null;
    }
    parame = ((com.tencent.mm.plugin.appbrand.jsapi.base.g)parame.K(com.tencent.mm.plugin.appbrand.jsapi.base.g.class)).c(parame, paramJSONObject);
    if (parame == null)
    {
      Log.e("MicroMsg.BaseMapJsApi", "name:%s is not componentView", new Object[] { getName() });
      return null;
    }
    return com.tencent.mm.plugin.appbrand.jsapi.l.a.g.dK(parame.getAppId(), f.h(parame, paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.b
 * JD-Core Version:    0.7.0.1
 */