package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.page.y.b;
import org.json.JSONException;
import org.json.JSONObject;

final class c$1
  implements Runnable
{
  c$1(c paramc, e parame, com.tencent.mm.plugin.appbrand.jsapi.c paramc1, int paramInt, JSONObject paramJSONObject) {}
  
  public final void run()
  {
    i = 0;
    if (this.glb == null)
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.BaseUpdateViewJsApi", "page view has been release.");
      this.ggE.C(this.dIS, this.glc.h("fail:page is null", null));
      return;
    }
    try
    {
      j = this.glc.p(this.gbZ);
      View localView = this.glb.agW().mg(j);
      if (localView == null)
      {
        com.tencent.mm.sdk.platformtools.y.w("MicroMsg.BaseUpdateViewJsApi", "get view by viewId(%s) return null.", new Object[] { Integer.valueOf(j) });
        this.ggE.C(this.dIS, this.glc.h("fail:got 'null' when get view by the given viewId", null));
        return;
      }
    }
    catch (JSONException localJSONException1)
    {
      this.ggE.C(this.dIS, this.glc.h("fail:view id do not exist", null));
      return;
    }
    Object localObject2 = this.glc;
    e locale = this.glb;
    Object localObject1 = this.gbZ;
    if (((c)localObject2).aii()) {}
    for (;;)
    {
      try
      {
        localObject2 = locale.agW().F(j, false);
        if (localObject2 != null)
        {
          bool2 = ((JSONObject)localObject1).getBoolean("disableScroll");
          if (!((u.b)localObject2).ik("isTouching")) {
            continue;
          }
          if (bool2) {
            continue;
          }
          bool1 = true;
          if (((u.b)localObject2).getBoolean("disableScroll", bool1) != bool2) {
            ((u.b)localObject2).w("disableScroll-nextState", bool2);
          }
        }
      }
      catch (JSONException localJSONException2)
      {
        int k;
        boolean bool3;
        continue;
        i = localJSONException2.gVA;
        continue;
      }
      try
      {
        localObject1 = c.q(this.gbZ);
        k = c.r(this.gbZ);
        localObject2 = c.s(this.gbZ);
        bool1 = this.glb.agW().a(j, (float[])localObject1, k, (Boolean)localObject2);
        localObject1 = this.glb.agW().me(j);
        if (localObject1 != null) {
          continue;
        }
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BaseUpdateViewJsApi", "update view(parentId : %s, viewId : %d), ret : %b", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localJSONException1.hashCode()), Boolean.valueOf(bool1) });
      }
      catch (JSONException localJSONException3)
      {
        bool1 = true;
        continue;
        bool2 = this.glc.c(this.glb, j, str, this.gbZ);
        continue;
        str = "fail";
        continue;
      }
      bool3 = this.glc.aik();
      bool2 = bool1;
      if (bool1)
      {
        if (!bool3) {
          break label493;
        }
        bool2 = this.glc.a(this.glb, j, localJSONException1, this.gbZ, new g(this.ggE, this.dIS));
      }
      if (bool3) {
        break;
      }
      localObject1 = this.ggE;
      i = this.dIS;
      localObject2 = this.glc;
      if (!bool2) {
        break label516;
      }
      str = "ok";
      ((com.tencent.mm.plugin.appbrand.jsapi.c)localObject1).C(i, ((i)localObject2).h(str, null));
      return;
      bool1 = false;
      continue;
      ((u.b)localObject2).w("disableScroll", bool2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.c.1
 * JD-Core Version:    0.7.0.1
 */