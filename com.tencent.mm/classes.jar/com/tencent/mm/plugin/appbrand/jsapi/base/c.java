package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class c<CONTEXT extends com.tencent.mm.plugin.appbrand.jsapi.e>
  extends e<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  private void c(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if ((!paramc.aXt()) && (!paramc.isRunning()))
    {
      paramc.h(paramInt, "fail:interrupted");
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.e locale = d(paramc, paramJSONObject);
    if (locale == null)
    {
      ad.w("MicroMsg.BaseRemoveViewJsApi", "invoke JsApi(%s) failed, component view is null", new Object[] { getName() });
      paramc.h(paramInt, e("fail:ComponentView is null.", null));
      return;
    }
    if (locale.aYi() == null)
    {
      ad.w("MicroMsg.BaseRemoveViewJsApi", "fail, component custom view container is null");
      paramc.h(paramInt, e("fail:remove view failed", null));
      return;
    }
    for (;;)
    {
      try
      {
        int i = A(paramJSONObject);
        boolean bool3 = paramJSONObject.optBoolean("independent", false);
        View localView = locale.fG(bool3).getViewById(i);
        if (((localView instanceof CoverViewContainer)) && (paramJSONObject.has("draggable")) && (paramJSONObject.optBoolean("draggable", false))) {
          CoverViewContainer.tc(i);
        }
        if (!locale.fG(bool3).sE(i)) {
          break label351;
        }
        boolean bool2 = locale.fG(bool3).sG(i);
        bool1 = bool2;
        if (bool2) {
          bool1 = b(locale, i, localView, paramJSONObject);
        }
        if (bool1) {
          locale.fG(bool3).sD(i);
        }
        ad.i("MicroMsg.BaseRemoveViewJsApi", "remove view(parentId : %s, viewId : %s, r : %s)", new Object[] { Integer.valueOf(paramJSONObject.optInt("parentId", 0)), Integer.valueOf(i), Boolean.valueOf(bool1) });
        if (bool1)
        {
          paramJSONObject = "ok";
          paramc.h(paramInt, e(paramJSONObject, null));
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        ad.e("MicroMsg.BaseRemoveViewJsApi", "get viewId error. exception : %s", new Object[] { paramJSONObject });
        paramc.h(paramInt, e("fail:view id do not exist", null));
        return;
      }
      paramJSONObject = "fail";
      continue;
      label351:
      boolean bool1 = false;
    }
  }
  
  private static com.tencent.mm.plugin.appbrand.jsapi.e d(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject)
  {
    return ((g)paramc.K(g.class)).c(paramc, paramJSONObject);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    if (aq.isMainThread())
    {
      c(paramc, paramJSONObject, paramInt);
      return;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140653);
        c.a(c.this, paramc, paramJSONObject, paramInt);
        AppMethodBeat.o(140653);
      }
    });
  }
  
  protected boolean b(CONTEXT paramCONTEXT, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.c
 * JD-Core Version:    0.7.0.1
 */