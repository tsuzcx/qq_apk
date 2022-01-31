package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b<CONTEXT extends e>
  extends d<c>
{
  private void b(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (!paramc.isRunning())
    {
      paramc.h(paramInt, "fail:interrupted");
      return;
    }
    e locale = o(paramc);
    if (locale == null)
    {
      ab.w("MicroMsg.BaseRemoveViewJsApi", "invoke JsApi(%s) failed, component view is null", new Object[] { getName() });
      paramc.h(paramInt, j("fail:ComponentView is null.", null));
      return;
    }
    for (;;)
    {
      try
      {
        int i = w(paramJSONObject);
        View localView = locale.vC().getViewById(i);
        if (!locale.vC().pi(i)) {
          break label252;
        }
        boolean bool2 = locale.vC().pf(i);
        bool1 = bool2;
        if (bool2) {
          bool1 = b(locale, i, localView, paramJSONObject);
        }
        if (bool1) {
          locale.vC().pj(i);
        }
        ab.i("MicroMsg.BaseRemoveViewJsApi", "remove view(parentId : %s, viewId : %s, r : %s)", new Object[] { Integer.valueOf(paramJSONObject.optInt("parentId", 0)), Integer.valueOf(i), Boolean.valueOf(bool1) });
        if (bool1)
        {
          paramJSONObject = "ok";
          paramc.h(paramInt, j(paramJSONObject, null));
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        ab.e("MicroMsg.BaseRemoveViewJsApi", "get viewId error. exception : %s", new Object[] { paramJSONObject });
        paramc.h(paramInt, j("fail:view id do not exist", null));
        return;
      }
      paramJSONObject = "fail";
      continue;
      label252:
      boolean bool1 = false;
    }
  }
  
  private static e o(c paramc)
  {
    return ((f)paramc.q(f.class)).d(paramc);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (al.isMainThread())
    {
      b(paramc, paramJSONObject, paramInt);
      return;
    }
    al.d(new b.1(this, paramc, paramJSONObject, paramInt));
  }
  
  protected boolean b(CONTEXT paramCONTEXT, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.b
 * JD-Core Version:    0.7.0.1
 */