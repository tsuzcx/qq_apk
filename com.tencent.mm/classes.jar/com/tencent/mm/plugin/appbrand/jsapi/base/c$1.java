package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.plugin.appbrand.page.af.b;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

final class c$1
  implements Runnable
{
  c$1(c paramc, e parame, com.tencent.mm.plugin.appbrand.jsapi.c paramc1, int paramInt, JSONObject paramJSONObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(91047);
    if (this.hER == null)
    {
      ab.w("MicroMsg.BaseUpdateViewJsApi", "page view has been release.");
      this.hza.h(this.bAX, this.hES.j("fail:page is null", null));
      AppMethodBeat.o(91047);
      return;
    }
    try
    {
      j = this.hES.w(this.bBa);
      View localView = this.hER.vC().getViewById(j);
      if (localView == null)
      {
        ab.w("MicroMsg.BaseUpdateViewJsApi", "get view by viewId(%s) return null.", new Object[] { Integer.valueOf(j) });
        this.hza.h(this.bAX, this.hES.j("fail:got 'null' when get view by the given viewId", null));
        AppMethodBeat.o(91047);
        return;
      }
    }
    catch (JSONException localJSONException1)
    {
      this.hza.h(this.bAX, this.hES.j("fail:view id do not exist", null));
      AppMethodBeat.o(91047);
      return;
    }
    c.a(this.hES, this.hER, j, this.bBa);
    for (;;)
    {
      try
      {
        localObject1 = c.x(this.bBa);
        i = c.y(this.bBa);
        localObject2 = c.z(this.bBa);
        Boolean localBoolean = c.A(this.bBa);
        bool1 = this.hER.vC().a(j, (float[])localObject1, i, (Boolean)localObject2, localBoolean);
        localObject1 = this.hER.vC().ph(j);
        if (localObject1 != null) {
          continue;
        }
        i = 0;
        ab.i("MicroMsg.BaseUpdateViewJsApi", "update view(parentId : %s, viewId : %d), ret : %b", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localJSONException1.hashCode()), Boolean.valueOf(bool1) });
      }
      catch (JSONException localJSONException2)
      {
        Object localObject1;
        int i;
        Object localObject2;
        boolean bool3;
        boolean bool1 = true;
        continue;
        boolean bool2 = this.hES.c(this.hER, j, str, this.bBa);
        continue;
        String str = "fail";
        continue;
      }
      bool3 = this.hES.aCb();
      bool2 = bool1;
      if (bool1)
      {
        if (!bool3) {
          continue;
        }
        bool2 = this.hES.b(this.hER, j, localJSONException1, this.bBa, new g(this.hza, this.bAX));
      }
      if (!bool3)
      {
        localObject1 = this.hza;
        i = this.bAX;
        localObject2 = this.hES;
        if (!bool2) {
          continue;
        }
        str = "ok";
        ((com.tencent.mm.plugin.appbrand.jsapi.c)localObject1).h(i, ((m)localObject2).j(str, null));
      }
      AppMethodBeat.o(91047);
      return;
      i = ((af.b)localObject1).parent;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.c.1
 * JD-Core Version:    0.7.0.1
 */