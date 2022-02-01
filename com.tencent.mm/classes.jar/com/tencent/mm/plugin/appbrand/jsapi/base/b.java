package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b<CONTEXT extends e>
  extends d<c>
{
  private void c(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if ((!paramc.aUk()) && (!paramc.isRunning()))
    {
      paramc.h(paramInt, "fail:interrupted");
      return;
    }
    e locale = d(paramc, paramJSONObject);
    if (locale == null)
    {
      ac.w("MicroMsg.BaseRemoveViewJsApi", "invoke JsApi(%s) failed, component view is null", new Object[] { getName() });
      paramc.h(paramInt, e("fail:ComponentView is null.", null));
      return;
    }
    for (;;)
    {
      try
      {
        int i = A(paramJSONObject);
        boolean bool3 = paramJSONObject.optBoolean("independent", false);
        View localView = locale.fC(bool3).getViewById(i);
        if (((localView instanceof CoverViewContainer)) && (paramJSONObject.has("draggable")) && (paramJSONObject.optBoolean("draggable", false))) {
          CoverViewContainer.sA(i);
        }
        if (!locale.fC(bool3).sc(i)) {
          break label319;
        }
        boolean bool2 = locale.fC(bool3).se(i);
        bool1 = bool2;
        if (bool2) {
          bool1 = b(locale, i, localView, paramJSONObject);
        }
        if (bool1) {
          locale.fC(bool3).sb(i);
        }
        ac.i("MicroMsg.BaseRemoveViewJsApi", "remove view(parentId : %s, viewId : %s, r : %s)", new Object[] { Integer.valueOf(paramJSONObject.optInt("parentId", 0)), Integer.valueOf(i), Boolean.valueOf(bool1) });
        if (bool1)
        {
          paramJSONObject = "ok";
          paramc.h(paramInt, e(paramJSONObject, null));
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        ac.e("MicroMsg.BaseRemoveViewJsApi", "get viewId error. exception : %s", new Object[] { paramJSONObject });
        paramc.h(paramInt, e("fail:view id do not exist", null));
        return;
      }
      paramJSONObject = "fail";
      continue;
      label319:
      boolean bool1 = false;
    }
  }
  
  private static e d(c paramc, JSONObject paramJSONObject)
  {
    return ((f)paramc.K(f.class)).c(paramc, paramJSONObject);
  }
  
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    if (ap.isMainThread())
    {
      c(paramc, paramJSONObject, paramInt);
      return;
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140653);
        b.a(b.this, paramc, paramJSONObject, paramInt);
        AppMethodBeat.o(140653);
      }
    });
  }
  
  protected boolean b(CONTEXT paramCONTEXT, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.b
 * JD-Core Version:    0.7.0.1
 */