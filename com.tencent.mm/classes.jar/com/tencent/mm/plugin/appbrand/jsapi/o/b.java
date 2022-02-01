package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.graphics.Color;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.v;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.v.a;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.v.b;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b
  extends c
{
  protected static b.v a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    b.v localv = new b.v();
    if (paramJSONObject2.has("joinCluster")) {
      localv.sed = paramJSONObject2.optBoolean("joinCluster", false);
    }
    if (paramJSONObject2.has("clusterId")) {
      localv.sdH = paramJSONObject2.optInt("clusterId", -1);
    }
    if ((paramJSONObject2.has("latitude")) && (paramJSONObject2.has("longitude")))
    {
      double d1 = Util.getDouble(paramJSONObject2.optString("latitude"), 0.0D);
      double d2 = Util.getDouble(paramJSONObject2.optString("longitude"), 0.0D);
      localv.latitude = d1;
      localv.longitude = d2;
    }
    Object localObject1 = paramJSONObject2.optString("iconPath");
    float f1 = i.a(paramJSONObject2, "width", 0.0F);
    float f2 = i.a(paramJSONObject2, "height", 0.0F);
    if ((!Util.isNullOrNil((String)localObject1)) && (paramf.T(com.tencent.mm.plugin.appbrand.f.b.class) != null))
    {
      localv.sdM = ((com.tencent.mm.plugin.appbrand.f.b)paramf.T(com.tencent.mm.plugin.appbrand.f.b.class)).b(paramf, (String)localObject1);
      localv.see = f1;
      localv.sef = f2;
    }
    localv.aBi = ((float)paramJSONObject2.optDouble("rotate", 0.0D));
    localv.alpha = ((float)paramJSONObject2.optDouble("alpha", 1.0D));
    localv.data = paramJSONObject2.optString("data");
    localv.seg = paramJSONObject2.optString("ariaLabel");
    localv.seh = paramJSONObject2.optString("collision");
    if (paramJSONObject2.has("anchor")) {}
    try
    {
      localObject1 = new JSONObject(paramJSONObject2.optString("anchor"));
      if (localObject1 != null)
      {
        localv.ar((float)((JSONObject)localObject1).optDouble("x", 0.5D), (float)((JSONObject)localObject1).optDouble("y", 1.0D));
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
          i = i.dq(((JSONObject)localObject1).optString("color", "#000000"), Color.parseColor("#000000"));
          j = ((JSONObject)localObject1).optInt("fontSize", 12);
          k = i.a((JSONObject)localObject1, "anchorX", i.a((JSONObject)localObject1, "x", 0));
          m = i.a((JSONObject)localObject1, "anchorY", i.a((JSONObject)localObject1, "y", 0));
          n = i.g((JSONObject)localObject1, "borderRadius");
          int i1 = i.g((JSONObject)localObject1, "borderWidth");
          int i2 = i.agv(((JSONObject)localObject1).optString("borderColor"));
          int i3 = i.dq(((JSONObject)localObject1).optString("bgColor", ""), Color.parseColor("#000000"));
          int i4 = i.a((JSONObject)localObject1, "padding", 0);
          String str2 = ((JSONObject)localObject1).optString("textAlign", "");
          int i5 = i.a((JSONObject)localObject1, "width", -1);
          int i6 = i.a((JSONObject)localObject1, "height", -1);
          localv.sej = new b.v.b(str1, i, j, k, m, i3, n, i1, i2, str2, i4);
          localv.sej.width = i5;
          localv.sej.height = i6;
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
            i = i.dq(((JSONObject)localObject1).optString("color", "#000000"), Color.parseColor("#000000"));
            j = ((JSONObject)localObject1).optInt("fontSize", 12);
            k = i.g((JSONObject)localObject1, "borderRadius");
            m = i.g((JSONObject)localObject1, "borderWidth");
            n = i.agv(((JSONObject)localObject1).optString("borderColor"));
            localv.sei = new b.v.a(str1, i, j, k, i.dq(((JSONObject)localObject1).optString("bgColor", "#000000"), Color.parseColor("#000000")), m, n, i.a((JSONObject)localObject1, "padding", 0), i.dq(((JSONObject)localObject1).optString("shadowColor", "#000000"), Color.parseColor("#000000")), ((JSONObject)localObject1).optInt("shadowOpacity"), i.a((JSONObject)localObject1, "shadowOffsetX", 0), i.a((JSONObject)localObject1, "shadowOffsetY", 0), ((JSONObject)localObject1).optInt("display", 0), ((JSONObject)localObject1).optString("textAlign", ""), i.a((JSONObject)localObject1, "anchorX", 0), i.a((JSONObject)localObject1, "anchorY", 0));
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
                k = i.a((JSONObject)localObject1, "anchorX", 0);
                m = i.a((JSONObject)localObject1, "anchorY", 0);
                paramf = ((com.tencent.mm.plugin.appbrand.jsapi.base.g)paramf.T(com.tencent.mm.plugin.appbrand.jsapi.base.g.class)).c(paramf, paramJSONObject1).ic(bool).dU(i);
                if (paramf == null) {
                  break;
                }
                bool = true;
                Log.i("MicroMsg.BaseMapJsApi", "viewId:%d view is %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
                if (paramf != null)
                {
                  localv.sei = new b.v.a();
                  localv.sei.view = paramf;
                  localv.sei.seo = j;
                  localv.sei.sep = k;
                  localv.sei.ser = m;
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
              localv.ar(0.5F, 1.0F);
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
    paramf.callback(paramInt, paramString);
    e.f(getName(), paramBoolean1, paramBoolean2);
  }
  
  public void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, int paramInt)
  {
    e.aaO(getName());
  }
  
  protected final com.tencent.mm.plugin.appbrand.jsapi.o.a.b g(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject)
  {
    if ((paramf instanceof h)) {
      return com.tencent.mm.plugin.appbrand.jsapi.o.a.g.ed(paramf.getAppId(), com.tencent.mm.plugin.appbrand.jsapi.o.a.f.h(paramf, paramJSONObject));
    }
    if (paramf.T(com.tencent.mm.plugin.appbrand.jsapi.base.g.class) == null)
    {
      Log.e("MicroMsg.BaseMapJsApi", "name:%s IComponentConverter is null, return", new Object[] { getName() });
      return null;
    }
    paramf = ((com.tencent.mm.plugin.appbrand.jsapi.base.g)paramf.T(com.tencent.mm.plugin.appbrand.jsapi.base.g.class)).c(paramf, paramJSONObject);
    if (paramf == null)
    {
      Log.e("MicroMsg.BaseMapJsApi", "name:%s is not componentView", new Object[] { getName() });
      return null;
    }
    return com.tencent.mm.plugin.appbrand.jsapi.o.a.g.ed(paramf.getAppId(), com.tencent.mm.plugin.appbrand.jsapi.o.a.f.h(paramf, paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.b
 * JD-Core Version:    0.7.0.1
 */