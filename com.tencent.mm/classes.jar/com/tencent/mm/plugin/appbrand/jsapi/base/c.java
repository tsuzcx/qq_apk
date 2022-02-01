package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class c<CONTEXT extends h>
  extends e<f>
{
  private void c(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    if ((!paramf.bsV()) && (!paramf.isRunning()))
    {
      paramf.i(paramInt, "fail:interrupted");
      return;
    }
    h localh = d(paramf, paramJSONObject);
    if (localh == null)
    {
      Log.w("MicroMsg.BaseRemoveViewJsApi", "invoke JsApi(%s) failed, component view is null", new Object[] { getName() });
      paramf.i(paramInt, h("fail:ComponentView is null.", null));
      return;
    }
    if (localh.getCustomViewContainer() == null)
    {
      Log.w("MicroMsg.BaseRemoveViewJsApi", "fail, component custom view container is null");
      paramf.i(paramInt, h("fail:remove view failed", null));
      return;
    }
    for (;;)
    {
      try
      {
        int i = H(paramJSONObject);
        boolean bool3 = paramJSONObject.optBoolean("independent", false);
        View localView = localh.gA(bool3).getViewById(i);
        if (((localView instanceof CoverViewContainer)) && (paramJSONObject.has("draggable")) && (paramJSONObject.optBoolean("draggable", false))) {
          CoverViewContainer.xb(i);
        }
        if (!localh.gA(bool3).wD(i)) {
          break label351;
        }
        boolean bool2 = localh.gA(bool3).wF(i);
        bool1 = bool2;
        if (bool2) {
          bool1 = b(localh, i, localView, paramJSONObject);
        }
        if (bool1) {
          localh.gA(bool3).wC(i);
        }
        Log.i("MicroMsg.BaseRemoveViewJsApi", "remove view(parentId : %s, viewId : %s, r : %s)", new Object[] { Integer.valueOf(paramJSONObject.optInt("parentId", 0)), Integer.valueOf(i), Boolean.valueOf(bool1) });
        if (bool1)
        {
          paramJSONObject = "ok";
          paramf.i(paramInt, h(paramJSONObject, null));
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        Log.e("MicroMsg.BaseRemoveViewJsApi", "get viewId error. exception : %s", new Object[] { paramJSONObject });
        paramf.i(paramInt, h("fail:view id do not exist", null));
        return;
      }
      paramJSONObject = "fail";
      continue;
      label351:
      boolean bool1 = false;
    }
  }
  
  private static h d(f paramf, JSONObject paramJSONObject)
  {
    g localg = (g)paramf.M(g.class);
    if (localg == null)
    {
      Log.e("MicroMsg.BaseRemoveViewJsApi", "getComponentView NULL IComponentConverter");
      return null;
    }
    return localg.c(paramf, paramJSONObject);
  }
  
  public final void a(final f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    if (MMHandlerThread.isMainThread())
    {
      c(paramf, paramJSONObject, paramInt);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140653);
        c.a(c.this, paramf, paramJSONObject, paramInt);
        AppMethodBeat.o(140653);
      }
    });
  }
  
  protected boolean b(CONTEXT paramCONTEXT, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.c
 * JD-Core Version:    0.7.0.1
 */