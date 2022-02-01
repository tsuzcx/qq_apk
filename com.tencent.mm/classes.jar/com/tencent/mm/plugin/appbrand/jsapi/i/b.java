package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.graphics.Color;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.v;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.v.a;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.v.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b
  extends a
{
  protected static b.v a(c paramc, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    b.v localv = new b.v();
    if (paramJSONObject2.has("joinCluster")) {
      localv.kRV = paramJSONObject2.optBoolean("joinCluster", false);
    }
    if (paramJSONObject2.has("clusterId")) {
      localv.kRz = paramJSONObject2.optInt("clusterId", -1);
    }
    if ((paramJSONObject2.has("latitude")) && (paramJSONObject2.has("longitude")))
    {
      double d1 = bt.getDouble(paramJSONObject2.optString("latitude"), 0.0D);
      double d2 = bt.getDouble(paramJSONObject2.optString("longitude"), 0.0D);
      localv.latitude = d1;
      localv.longitude = d2;
    }
    Object localObject1 = paramJSONObject2.optString("iconPath");
    float f1 = com.tencent.mm.plugin.appbrand.z.g.a(paramJSONObject2, "width", 0.0F);
    float f2 = com.tencent.mm.plugin.appbrand.z.g.a(paramJSONObject2, "height", 0.0F);
    if ((!bt.isNullOrNil((String)localObject1)) && (paramc.K(com.tencent.mm.plugin.appbrand.f.b.class) != null))
    {
      localv.kRE = ((com.tencent.mm.plugin.appbrand.f.b)paramc.K(com.tencent.mm.plugin.appbrand.f.b.class)).b(paramc, (String)localObject1);
      localv.kRW = f1;
      localv.kRX = f2;
    }
    localv.kRD = ((float)paramJSONObject2.optDouble("rotate", 0.0D));
    localv.alpha = ((float)paramJSONObject2.optDouble("alpha", 1.0D));
    localv.data = paramJSONObject2.optString("data");
    localv.kRY = paramJSONObject2.optString("ariaLabel");
    if (paramJSONObject2.has("anchor")) {}
    try
    {
      localObject1 = new JSONObject(paramJSONObject2.optString("anchor"));
      if (localObject1 != null)
      {
        localv.I((float)((JSONObject)localObject1).optDouble("x", 0.5D), (float)((JSONObject)localObject1).optDouble("y", 1.0D));
        localv.zIndex = paramJSONObject2.optInt("zIndex", 0);
        localObject1 = paramJSONObject2.optString("label");
        if (bt.isNullOrNil((String)localObject1)) {}
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
          i = com.tencent.mm.plugin.appbrand.z.g.cg(((JSONObject)localObject1).optString("color", "#000000"), Color.parseColor("#000000"));
          j = ((JSONObject)localObject1).optInt("fontSize", 12);
          k = com.tencent.mm.plugin.appbrand.z.g.a((JSONObject)localObject1, "anchorX", com.tencent.mm.plugin.appbrand.z.g.a((JSONObject)localObject1, "x", 0));
          m = com.tencent.mm.plugin.appbrand.z.g.a((JSONObject)localObject1, "anchorY", com.tencent.mm.plugin.appbrand.z.g.a((JSONObject)localObject1, "y", 0));
          n = com.tencent.mm.plugin.appbrand.z.g.e((JSONObject)localObject1, "borderRadius");
          int i1 = com.tencent.mm.plugin.appbrand.z.g.e((JSONObject)localObject1, "borderWidth");
          int i2 = com.tencent.mm.plugin.appbrand.z.g.UW(((JSONObject)localObject1).optString("borderColor"));
          int i3 = com.tencent.mm.plugin.appbrand.z.g.cg(((JSONObject)localObject1).optString("bgColor", ""), Color.parseColor("#000000"));
          int i4 = com.tencent.mm.plugin.appbrand.z.g.a((JSONObject)localObject1, "padding", 0);
          String str2 = ((JSONObject)localObject1).optString("textAlign", "");
          int i5 = com.tencent.mm.plugin.appbrand.z.g.a((JSONObject)localObject1, "width", -1);
          int i6 = com.tencent.mm.plugin.appbrand.z.g.a((JSONObject)localObject1, "height", -1);
          localv.kSa = new b.v.b(str1, i, j, k, m, i3, n, i1, i2, str2, i4);
          localv.kSa.width = i5;
          localv.kSa.height = i6;
        }
        localObject1 = paramJSONObject2.optString("callout");
        if (bt.isNullOrNil((String)localObject1)) {}
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
            i = com.tencent.mm.plugin.appbrand.z.g.cg(((JSONObject)localObject1).optString("color", "#000000"), Color.parseColor("#000000"));
            j = ((JSONObject)localObject1).optInt("fontSize", 12);
            k = com.tencent.mm.plugin.appbrand.z.g.e((JSONObject)localObject1, "borderRadius");
            m = com.tencent.mm.plugin.appbrand.z.g.e((JSONObject)localObject1, "borderWidth");
            n = com.tencent.mm.plugin.appbrand.z.g.UW(((JSONObject)localObject1).optString("borderColor"));
            localv.kRZ = new b.v.a(str1, i, j, k, com.tencent.mm.plugin.appbrand.z.g.cg(((JSONObject)localObject1).optString("bgColor", "#000000"), Color.parseColor("#000000")), m, n, com.tencent.mm.plugin.appbrand.z.g.a((JSONObject)localObject1, "padding", 0), com.tencent.mm.plugin.appbrand.z.g.cg(((JSONObject)localObject1).optString("shadowColor", "#000000"), Color.parseColor("#000000")), ((JSONObject)localObject1).optInt("shadowOpacity"), ((JSONObject)localObject1).optInt("shadowOffsetX"), ((JSONObject)localObject1).optInt("shadowOffsetY"), ((JSONObject)localObject1).optInt("display", 0), ((JSONObject)localObject1).optString("textAlign", ""), ((JSONObject)localObject1).optInt("anchorX", 0), ((JSONObject)localObject1).optInt("anchorY", 0));
          }
          localObject1 = paramJSONObject2.optString("customCallout");
          if (bt.isNullOrNil((String)localObject1)) {}
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
                k = ((JSONObject)localObject1).optInt("anchorX", 0);
                m = ((JSONObject)localObject1).optInt("anchorY", 0);
                paramc = ((com.tencent.mm.plugin.appbrand.jsapi.base.g)paramc.K(com.tencent.mm.plugin.appbrand.jsapi.base.g.class)).c(paramc, paramJSONObject1).fG(bool).getViewById(i);
                if (paramc == null) {
                  break;
                }
                bool = true;
                ad.i("MicroMsg.BaseMapJsApi", "viewId:%d view is %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
                if (paramc != null)
                {
                  localv.kRZ = new b.v.a();
                  localv.kRZ.view = paramc;
                  localv.kRZ.kSg = j;
                  localv.kRZ.kSh = k;
                  localv.kRZ.kSi = m;
                }
              }
              paramc = paramJSONObject2.optString("buildingId");
              paramJSONObject1 = paramJSONObject2.optString("floorName");
              localv.buildingId = paramc;
              localv.floorName = paramJSONObject1;
              return localv;
              localJSONException1 = localJSONException1;
              Object localObject2 = null;
              continue;
              localv.I(0.5F, 1.0F);
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
  
  protected final void a(c paramc, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramc.h(paramInt, paramString);
    com.tencent.mm.plugin.appbrand.jsapi.i.a.e.d(getName(), paramBoolean1, paramBoolean2);
  }
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    com.tencent.mm.plugin.appbrand.jsapi.i.a.e.PP(getName());
  }
  
  protected final com.tencent.mm.plugin.appbrand.jsapi.i.a.b h(c paramc, JSONObject paramJSONObject)
  {
    if ((paramc instanceof com.tencent.mm.plugin.appbrand.jsapi.e)) {
      return com.tencent.mm.plugin.appbrand.jsapi.i.a.g.di(paramc.getAppId(), f.i(paramc, paramJSONObject));
    }
    if (paramc.K(com.tencent.mm.plugin.appbrand.jsapi.base.g.class) == null)
    {
      ad.e("MicroMsg.BaseMapJsApi", "name:%s IComponentConverter is null, return", new Object[] { getName() });
      return null;
    }
    paramc = ((com.tencent.mm.plugin.appbrand.jsapi.base.g)paramc.K(com.tencent.mm.plugin.appbrand.jsapi.base.g.class)).c(paramc, paramJSONObject);
    if (paramc == null)
    {
      ad.e("MicroMsg.BaseMapJsApi", "name:%s is not componentView", new Object[] { getName() });
      return null;
    }
    return com.tencent.mm.plugin.appbrand.jsapi.i.a.g.di(paramc.getAppId(), f.i(paramc, paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.b
 * JD-Core Version:    0.7.0.1
 */