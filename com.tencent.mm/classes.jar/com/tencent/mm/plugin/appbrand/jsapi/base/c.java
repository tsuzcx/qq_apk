package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import com.tencent.mm.plugin.appbrand.n.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class c<CONTEXT extends h>
  extends e<f>
{
  private void a(f paramf, o paramo, JSONObject paramJSONObject, int paramInt)
  {
    if (!paramf.a(getName(), paramo))
    {
      paramf.callback(paramInt, "fail:interrupted");
      return;
    }
    paramo = d(paramf, paramJSONObject);
    if (paramo == null)
    {
      Log.w("MicroMsg.BaseRemoveViewJsApi", "invoke JsApi(%s) failed, component view is null", new Object[] { getName() });
      paramf.callback(paramInt, ZP("fail:ComponentView is null."));
      return;
    }
    if (paramo.getCustomViewContainer() == null)
    {
      Log.w("MicroMsg.BaseRemoveViewJsApi", "fail, component custom view container is null");
      paramf.callback(paramInt, ZP("fail:remove view failed"));
      return;
    }
    for (;;)
    {
      try
      {
        int i = V(paramJSONObject);
        boolean bool3 = paramJSONObject.optBoolean("independent", false);
        View localView = paramo.ic(bool3).dU(i);
        if (((localView instanceof CoverViewContainer)) && (paramJSONObject.has("draggable")) && (paramJSONObject.optBoolean("draggable", false))) {
          CoverViewContainer.AI(i);
        }
        if (!paramo.ic(bool3).Ak(i)) {
          break label340;
        }
        boolean bool2 = paramo.ic(bool3).Am(i);
        bool1 = bool2;
        if (bool2) {
          bool1 = b(paramo, i, localView, paramJSONObject);
        }
        if (bool1) {
          paramo.ic(bool3).Aj(i);
        }
        Log.i("MicroMsg.BaseRemoveViewJsApi", "remove view(parentId : %s, viewId : %s, r : %s)", new Object[] { Integer.valueOf(paramJSONObject.optInt("parentId", 0)), Integer.valueOf(i), Boolean.valueOf(bool1) });
        if (bool1)
        {
          paramo = "ok";
          paramf.callback(paramInt, ZP(paramo));
          return;
        }
      }
      catch (JSONException paramo)
      {
        Log.e("MicroMsg.BaseRemoveViewJsApi", "get viewId error. exception : %s", new Object[] { paramo });
        paramf.callback(paramInt, ZP("fail:view id do not exist"));
        return;
      }
      paramo = "fail";
      continue;
      label340:
      boolean bool1 = false;
    }
  }
  
  private static h d(f paramf, JSONObject paramJSONObject)
  {
    g localg = (g)paramf.T(g.class);
    if (localg == null)
    {
      Log.e("MicroMsg.BaseRemoveViewJsApi", "getComponentView NULL IComponentConverter");
      return null;
    }
    return localg.c(paramf, paramJSONObject);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    a(paramf, paramJSONObject, paramInt, paramf.getJsRuntime());
  }
  
  public final void a(final f paramf, final JSONObject paramJSONObject, final int paramInt, final o paramo)
  {
    if (MMHandlerThread.isMainThread())
    {
      a(paramf, paramo, paramJSONObject, paramInt);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140653);
        c.a(c.this, paramf, paramo, paramJSONObject, paramInt);
        AppMethodBeat.o(140653);
      }
    });
  }
  
  protected boolean b(CONTEXT paramCONTEXT, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.c
 * JD-Core Version:    0.7.0.1
 */