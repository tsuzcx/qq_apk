package com.tencent.mm.plugin.appbrand.jsapi.f;

import android.graphics.Color;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b.t;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b.t.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b.t.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b
  extends a
{
  protected static b.t a(c paramc, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    b.t localt = new b.t();
    if ((paramJSONObject2.has("latitude")) && (paramJSONObject2.has("longitude")))
    {
      double d1 = bs.getDouble(paramJSONObject2.optString("latitude"), 0.0D);
      double d2 = bs.getDouble(paramJSONObject2.optString("longitude"), 0.0D);
      localt.latitude = d1;
      localt.longitude = d2;
    }
    Object localObject1 = paramJSONObject2.optString("iconPath");
    float f1 = com.tencent.mm.plugin.appbrand.z.g.a(paramJSONObject2, "width", 0.0F);
    float f2 = com.tencent.mm.plugin.appbrand.z.g.a(paramJSONObject2, "height", 0.0F);
    if ((!bs.isNullOrNil((String)localObject1)) && (paramc.K(com.tencent.mm.plugin.appbrand.g.b.class) != null))
    {
      localt.kvC = ((com.tencent.mm.plugin.appbrand.g.b)paramc.K(com.tencent.mm.plugin.appbrand.g.b.class)).b(paramc, (String)localObject1);
      localt.kvR = f1;
      localt.kvS = f2;
    }
    localt.kvB = ((float)paramJSONObject2.optDouble("rotate", 0.0D));
    localt.alpha = ((float)paramJSONObject2.optDouble("alpha", 1.0D));
    localt.data = paramJSONObject2.optString("data");
    localt.kvT = paramJSONObject2.optString("ariaLabel");
    if (paramJSONObject2.has("anchor")) {}
    try
    {
      localObject1 = new JSONObject(paramJSONObject2.optString("anchor"));
      if (localObject1 != null)
      {
        localt.H((float)((JSONObject)localObject1).optDouble("x", 0.5D), (float)((JSONObject)localObject1).optDouble("y", 1.0D));
        localt.zIndex = paramJSONObject2.optInt("zIndex", 0);
        localObject1 = paramJSONObject2.optString("label");
        if (bs.isNullOrNil((String)localObject1)) {}
      }
    }
    catch (JSONException localJSONException3)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if (localObject1 != null)
        {
          str = ((JSONObject)localObject1).optString("content");
          i = com.tencent.mm.plugin.appbrand.z.g.cd(((JSONObject)localObject1).optString("color", "#000000"), Color.parseColor("#000000"));
          j = ((JSONObject)localObject1).optInt("fontSize", 12);
          k = com.tencent.mm.plugin.appbrand.z.g.a((JSONObject)localObject1, "anchorX", com.tencent.mm.plugin.appbrand.z.g.a((JSONObject)localObject1, "x", 0));
          m = com.tencent.mm.plugin.appbrand.z.g.a((JSONObject)localObject1, "anchorY", com.tencent.mm.plugin.appbrand.z.g.a((JSONObject)localObject1, "y", 0));
          n = ((JSONObject)localObject1).optInt("borderRadius", 0);
          int i1 = com.tencent.mm.plugin.appbrand.z.g.e((JSONObject)localObject1, "borderWidth");
          int i2 = com.tencent.mm.plugin.appbrand.z.g.Rq(((JSONObject)localObject1).optString("borderColor"));
          int i3 = com.tencent.mm.plugin.appbrand.z.g.cd(((JSONObject)localObject1).optString("bgColor", ""), Color.parseColor("#000000"));
          int i4 = com.tencent.mm.plugin.appbrand.z.g.a((JSONObject)localObject1, "padding", 0);
          localt.kvV = new b.t.b(str, i, j, k, m, i3, n, i1, i2, ((JSONObject)localObject1).optString("textAlign", ""), i4);
        }
        localObject1 = paramJSONObject2.optString("callout");
        if (bs.isNullOrNil((String)localObject1)) {}
      }
      catch (JSONException localJSONException3)
      {
        try
        {
          String str;
          int n;
          localObject1 = new JSONObject((String)localObject1);
          if (localObject1 != null)
          {
            str = ((JSONObject)localObject1).optString("content");
            i = com.tencent.mm.plugin.appbrand.z.g.cd(((JSONObject)localObject1).optString("color", "#000000"), Color.parseColor("#000000"));
            j = ((JSONObject)localObject1).optInt("fontSize", 12);
            k = ((JSONObject)localObject1).optInt("borderRadius", 0);
            m = com.tencent.mm.plugin.appbrand.z.g.e((JSONObject)localObject1, "borderWidth");
            n = com.tencent.mm.plugin.appbrand.z.g.Rq(((JSONObject)localObject1).optString("borderColor"));
            localt.kvU = new b.t.a(str, i, j, k, com.tencent.mm.plugin.appbrand.z.g.cd(((JSONObject)localObject1).optString("bgColor", "#000000"), Color.parseColor("#000000")), m, n, com.tencent.mm.plugin.appbrand.z.g.a((JSONObject)localObject1, "padding", 0), com.tencent.mm.plugin.appbrand.z.g.cd(((JSONObject)localObject1).optString("shadowColor", "#000000"), Color.parseColor("#000000")), ((JSONObject)localObject1).optInt("shadowOpacity"), ((JSONObject)localObject1).optInt("shadowOffsetX"), ((JSONObject)localObject1).optInt("shadowOffsetY"), ((JSONObject)localObject1).optInt("display", 0), ((JSONObject)localObject1).optString("textAlign", ""), ((JSONObject)localObject1).optInt("anchorX", 0), ((JSONObject)localObject1).optInt("anchorY", 0));
          }
          localObject1 = paramJSONObject2.optString("customCallout");
          if (bs.isNullOrNil((String)localObject1)) {}
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
                paramc = ((com.tencent.mm.plugin.appbrand.jsapi.base.f)paramc.K(com.tencent.mm.plugin.appbrand.jsapi.base.f.class)).c(paramc, paramJSONObject1).fC(bool).getViewById(i);
                if (paramc == null) {
                  break;
                }
                bool = true;
                ac.i("MicroMsg.BaseMapJsApi", "viewId:%d view is %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
                if (paramc != null)
                {
                  localt.kvU = new b.t.a();
                  localt.kvU.view = paramc;
                  localt.kvU.kwb = j;
                  localt.kvU.kwc = k;
                  localt.kvU.kwd = m;
                }
              }
              paramc = paramJSONObject2.optString("buildingId");
              paramJSONObject1 = paramJSONObject2.optString("floorName");
              localt.buildingId = paramc;
              localt.floorName = paramJSONObject1;
              return localt;
              localJSONException1 = localJSONException1;
              Object localObject2 = null;
              continue;
              localt.H(0.5F, 1.0F);
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
    com.tencent.mm.plugin.appbrand.jsapi.f.a.e.c(getName(), paramBoolean1, paramBoolean2);
  }
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    com.tencent.mm.plugin.appbrand.jsapi.f.a.e.Mr(getName());
  }
  
  protected final com.tencent.mm.plugin.appbrand.jsapi.f.a.b h(c paramc, JSONObject paramJSONObject)
  {
    if ((paramc instanceof com.tencent.mm.plugin.appbrand.jsapi.e)) {
      return com.tencent.mm.plugin.appbrand.jsapi.f.a.g.dg(paramc.getAppId(), com.tencent.mm.plugin.appbrand.jsapi.f.a.f.i(paramc, paramJSONObject));
    }
    if (paramc.K(com.tencent.mm.plugin.appbrand.jsapi.base.f.class) == null)
    {
      ac.e("MicroMsg.BaseMapJsApi", "name:%s IComponentConverter is null, return", new Object[] { getName() });
      return null;
    }
    paramc = ((com.tencent.mm.plugin.appbrand.jsapi.base.f)paramc.K(com.tencent.mm.plugin.appbrand.jsapi.base.f.class)).c(paramc, paramJSONObject);
    if (paramc == null)
    {
      ac.e("MicroMsg.BaseMapJsApi", "name:%s is not componentView", new Object[] { getName() });
      return null;
    }
    return com.tencent.mm.plugin.appbrand.jsapi.f.a.g.dg(paramc.getAppId(), com.tencent.mm.plugin.appbrand.jsapi.f.a.f.i(paramc, paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.b
 * JD-Core Version:    0.7.0.1
 */