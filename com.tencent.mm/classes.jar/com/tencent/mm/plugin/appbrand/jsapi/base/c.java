package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class c<CONTEXT extends com.tencent.mm.plugin.appbrand.jsapi.g>
  extends e<com.tencent.mm.plugin.appbrand.jsapi.e>
{
  private void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, com.tencent.mm.plugin.appbrand.m.o paramo, JSONObject paramJSONObject, int paramInt)
  {
    if (!parame.a(getName(), paramo))
    {
      parame.j(paramInt, "fail:interrupted");
      return;
    }
    paramo = d(parame, paramJSONObject);
    if (paramo == null)
    {
      Log.w("MicroMsg.BaseRemoveViewJsApi", "invoke JsApi(%s) failed, component view is null", new Object[] { getName() });
      parame.j(paramInt, h("fail:ComponentView is null.", null));
      return;
    }
    if (paramo.getCustomViewContainer() == null)
    {
      Log.w("MicroMsg.BaseRemoveViewJsApi", "fail, component custom view container is null");
      parame.j(paramInt, h("fail:remove view failed", null));
      return;
    }
    for (;;)
    {
      try
      {
        int i = K(paramJSONObject);
        boolean bool3 = paramJSONObject.optBoolean("independent", false);
        View localView = paramo.hl(bool3).bg(i);
        if (((localView instanceof CoverViewContainer)) && (paramJSONObject.has("draggable")) && (paramJSONObject.optBoolean("draggable", false))) {
          CoverViewContainer.Ar(i);
        }
        if (!paramo.hl(bool3).zS(i)) {
          break label344;
        }
        boolean bool2 = paramo.hl(bool3).zU(i);
        bool1 = bool2;
        if (bool2) {
          bool1 = b(paramo, i, localView, paramJSONObject);
        }
        if (bool1) {
          paramo.hl(bool3).zR(i);
        }
        Log.i("MicroMsg.BaseRemoveViewJsApi", "remove view(parentId : %s, viewId : %s, r : %s)", new Object[] { Integer.valueOf(paramJSONObject.optInt("parentId", 0)), Integer.valueOf(i), Boolean.valueOf(bool1) });
        if (bool1)
        {
          paramo = "ok";
          parame.j(paramInt, h(paramo, null));
          return;
        }
      }
      catch (JSONException paramo)
      {
        Log.e("MicroMsg.BaseRemoveViewJsApi", "get viewId error. exception : %s", new Object[] { paramo });
        parame.j(paramInt, h("fail:view id do not exist", null));
        return;
      }
      paramo = "fail";
      continue;
      label344:
      boolean bool1 = false;
    }
  }
  
  private static com.tencent.mm.plugin.appbrand.jsapi.g d(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject)
  {
    g localg = (g)parame.K(g.class);
    if (localg == null)
    {
      Log.e("MicroMsg.BaseRemoveViewJsApi", "getComponentView NULL IComponentConverter");
      return null;
    }
    return localg.c(parame, paramJSONObject);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, int paramInt)
  {
    a(parame, paramJSONObject, paramInt, parame.getJsRuntime());
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, final JSONObject paramJSONObject, final int paramInt, final com.tencent.mm.plugin.appbrand.m.o paramo)
  {
    if (MMHandlerThread.isMainThread())
    {
      a(parame, paramo, paramJSONObject, paramInt);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140653);
        c.a(c.this, parame, paramo, paramJSONObject, paramInt);
        AppMethodBeat.o(140653);
      }
    });
  }
  
  protected boolean b(CONTEXT paramCONTEXT, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.c
 * JD-Core Version:    0.7.0.1
 */