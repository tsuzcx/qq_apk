package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.graphics.Color;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.v;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.v.a;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.v.b;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b
  extends d
{
  protected static b.v a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    b.v localv = new b.v();
    if (paramJSONObject2.has("joinCluster")) {
      localv.maN = paramJSONObject2.optBoolean("joinCluster", false);
    }
    if (paramJSONObject2.has("clusterId")) {
      localv.mao = paramJSONObject2.optInt("clusterId", -1);
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
    if ((!Util.isNullOrNil((String)localObject1)) && (paramf.M(com.tencent.mm.plugin.appbrand.f.b.class) != null))
    {
      localv.mav = ((com.tencent.mm.plugin.appbrand.f.b)paramf.M(com.tencent.mm.plugin.appbrand.f.b.class)).b(paramf, (String)localObject1);
      localv.maO = f1;
      localv.maP = f2;
    }
    localv.mat = ((float)paramJSONObject2.optDouble("rotate", 0.0D));
    localv.alpha = ((float)paramJSONObject2.optDouble("alpha", 1.0D));
    localv.data = paramJSONObject2.optString("data");
    localv.maQ = paramJSONObject2.optString("ariaLabel");
    if (paramJSONObject2.has("anchor")) {}
    try
    {
      localObject1 = new JSONObject(paramJSONObject2.optString("anchor"));
      if (localObject1 != null)
      {
        localv.M((float)((JSONObject)localObject1).optDouble("x", 0.5D), (float)((JSONObject)localObject1).optDouble("y", 1.0D));
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
          i = com.tencent.mm.plugin.appbrand.ac.g.cu(((JSONObject)localObject1).optString("color", "#000000"), Color.parseColor("#000000"));
          j = ((JSONObject)localObject1).optInt("fontSize", 12);
          k = com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject1, "anchorX", com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject1, "x", 0));
          m = com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject1, "anchorY", com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject1, "y", 0));
          n = com.tencent.mm.plugin.appbrand.ac.g.f((JSONObject)localObject1, "borderRadius");
          int i1 = com.tencent.mm.plugin.appbrand.ac.g.f((JSONObject)localObject1, "borderWidth");
          int i2 = com.tencent.mm.plugin.appbrand.ac.g.afD(((JSONObject)localObject1).optString("borderColor"));
          int i3 = com.tencent.mm.plugin.appbrand.ac.g.cu(((JSONObject)localObject1).optString("bgColor", ""), Color.parseColor("#000000"));
          int i4 = com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject1, "padding", 0);
          String str2 = ((JSONObject)localObject1).optString("textAlign", "");
          int i5 = com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject1, "width", -1);
          int i6 = com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject1, "height", -1);
          localv.maS = new b.v.b(str1, i, j, k, m, i3, n, i1, i2, str2, i4);
          localv.maS.width = i5;
          localv.maS.height = i6;
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
            i = com.tencent.mm.plugin.appbrand.ac.g.cu(((JSONObject)localObject1).optString("color", "#000000"), Color.parseColor("#000000"));
            j = ((JSONObject)localObject1).optInt("fontSize", 12);
            k = com.tencent.mm.plugin.appbrand.ac.g.f((JSONObject)localObject1, "borderRadius");
            m = com.tencent.mm.plugin.appbrand.ac.g.f((JSONObject)localObject1, "borderWidth");
            n = com.tencent.mm.plugin.appbrand.ac.g.afD(((JSONObject)localObject1).optString("borderColor"));
            localv.maR = new b.v.a(str1, i, j, k, com.tencent.mm.plugin.appbrand.ac.g.cu(((JSONObject)localObject1).optString("bgColor", "#000000"), Color.parseColor("#000000")), m, n, com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject1, "padding", 0), com.tencent.mm.plugin.appbrand.ac.g.cu(((JSONObject)localObject1).optString("shadowColor", "#000000"), Color.parseColor("#000000")), ((JSONObject)localObject1).optInt("shadowOpacity"), com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject1, "shadowOffsetX", 0), com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject1, "shadowOffsetY", 0), ((JSONObject)localObject1).optInt("display", 0), ((JSONObject)localObject1).optString("textAlign", ""), com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject1, "anchorX", 0), com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject1, "anchorY", 0));
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
                paramf = ((com.tencent.mm.plugin.appbrand.jsapi.base.g)paramf.M(com.tencent.mm.plugin.appbrand.jsapi.base.g.class)).c(paramf, paramJSONObject1).gA(bool).getViewById(i);
                if (paramf == null) {
                  break;
                }
                bool = true;
                Log.i("MicroMsg.BaseMapJsApi", "viewId:%d view is %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
                if (paramf != null)
                {
                  localv.maR = new b.v.a();
                  localv.maR.view = paramf;
                  localv.maR.maY = j;
                  localv.maR.maZ = k;
                  localv.maR.mba = m;
                }
              }
              paramf = paramJSONObject2.optString("buildingId");
              paramJSONObject1 = paramJSONObject2.optString("floorName");
              localv.buildingId = paramf;
              localv.floorName = paramJSONObject1;
              return localv;
              localJSONException1 = localJSONException1;
              Object localObject2 = null;
              continue;
              localv.M(0.5F, 1.0F);
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
  
  protected final void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramf.i(paramInt, paramString);
    e.e(getName(), paramBoolean1, paramBoolean2);
  }
  
  public void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, int paramInt)
  {
    e.ZZ(getName());
  }
  
  protected final com.tencent.mm.plugin.appbrand.jsapi.k.a.b h(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject)
  {
    if ((paramf instanceof h)) {
      return com.tencent.mm.plugin.appbrand.jsapi.k.a.g.dz(paramf.getAppId(), com.tencent.mm.plugin.appbrand.jsapi.k.a.f.i(paramf, paramJSONObject));
    }
    if (paramf.M(com.tencent.mm.plugin.appbrand.jsapi.base.g.class) == null)
    {
      Log.e("MicroMsg.BaseMapJsApi", "name:%s IComponentConverter is null, return", new Object[] { getName() });
      return null;
    }
    paramf = ((com.tencent.mm.plugin.appbrand.jsapi.base.g)paramf.M(com.tencent.mm.plugin.appbrand.jsapi.base.g.class)).c(paramf, paramJSONObject);
    if (paramf == null)
    {
      Log.e("MicroMsg.BaseMapJsApi", "name:%s is not componentView", new Object[] { getName() });
      return null;
    }
    return com.tencent.mm.plugin.appbrand.jsapi.k.a.g.dz(paramf.getAppId(), com.tencent.mm.plugin.appbrand.jsapi.k.a.f.i(paramf, paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.b
 * JD-Core Version:    0.7.0.1
 */