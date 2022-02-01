package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class d<CONTEXT extends h>
  extends e<f>
{
  public final void a(final f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    Object localObject = (g)paramf.M(g.class);
    if (localObject == null) {
      Log.e("MicroMsg.BaseUpdateViewJsApi", "getComponentView NULL IComponentConverter");
    }
    for (localObject = null; localObject == null; localObject = ((g)localObject).c(paramf, paramJSONObject))
    {
      paramf.i(paramInt, h("fail:ComponentView is null.", null));
      return;
    }
    paramf.P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140654);
        h localh = (h)this.lJZ.get();
        if ((localh == null) || (!localh.isRunning()))
        {
          Log.w("MicroMsg.BaseUpdateViewJsApi", "page view has been release.");
          paramf.i(paramInt, d.this.h("fail:page is null", null));
          AppMethodBeat.o(140654);
          return;
        }
        if (localh.getCustomViewContainer() == null)
        {
          Log.w("MicroMsg.BaseUpdateViewJsApi", "fail, component custom view container is null");
          paramf.i(paramInt, d.this.h("fail:update view failed", null));
          AppMethodBeat.o(140654);
          return;
        }
        int i;
        boolean bool2;
        Object localObject1;
        try
        {
          i = d.this.H(paramJSONObject);
          bool2 = paramJSONObject.optBoolean("independent", false);
          localObject1 = localh.gA(bool2).getViewById(i);
          if (localObject1 == null)
          {
            Log.w("MicroMsg.BaseUpdateViewJsApi", "get view by viewId(%s) return null.", new Object[] { Integer.valueOf(i) });
            paramf.i(paramInt, d.this.h("fail:got 'null' when get view by the given viewId", null));
            AppMethodBeat.o(140654);
            return;
          }
        }
        catch (JSONException localJSONException1)
        {
          paramf.i(paramInt, d.this.h("fail:view id do not exist", null));
          AppMethodBeat.o(140654);
          return;
        }
        boolean bool1;
        Object localObject2;
        if (((localObject1 instanceof CoverViewContainer)) && (paramJSONObject.has("draggable")))
        {
          bool1 = paramJSONObject.optBoolean("draggable", false);
          localObject2 = (CoverViewContainer)localObject1;
          ((CoverViewContainer)localObject2).a(bool1, i, ((CoverViewContainer)localObject2).lSX);
          ((CoverViewContainer)localObject1).setDragConfig(paramJSONObject.optString("dragConfig"));
        }
        d.a(d.this, localJSONException1, i, paramJSONObject, bool2);
        try
        {
          localObject2 = d.L(paramJSONObject);
          int j = d.M(paramJSONObject);
          Boolean localBoolean1 = d.N(paramJSONObject);
          Boolean localBoolean2 = d.O(paramJSONObject);
          bool1 = localJSONException1.gA(bool2).a(i, (float[])localObject2, j, localBoolean1, localBoolean2);
          Log.i("MicroMsg.BaseUpdateViewJsApi", "update view(parentId : %s, viewId : %d), ret : %b", new Object[] { Integer.valueOf(localJSONException1.gA(bool2).wE(i)), Integer.valueOf(i), Integer.valueOf(localObject1.hashCode()), Boolean.valueOf(bool1) });
          boolean bool3 = d.this.bEV();
          bool2 = bool1;
          if (bool1)
          {
            if (bool3) {
              bool2 = d.this.b(localJSONException1, i, (View)localObject1, paramJSONObject, new i(paramf, paramInt));
            }
          }
          else
          {
            if (!bool3)
            {
              localObject1 = paramf;
              i = paramInt;
              localObject2 = d.this;
              if (!bool2) {
                break label571;
              }
              str = "ok";
              ((f)localObject1).i(i, ((p)localObject2).h(str, null));
            }
            AppMethodBeat.o(140654);
            return;
          }
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            bool1 = true;
            continue;
            bool2 = d.this.c(str, i, (View)localObject1, paramJSONObject);
            continue;
            label571:
            String str = "fail";
          }
        }
      }
    });
  }
  
  protected boolean b(CONTEXT paramCONTEXT, int paramInt, View paramView, JSONObject paramJSONObject, i parami)
  {
    return true;
  }
  
  protected boolean bEV()
  {
    return false;
  }
  
  protected boolean bEW()
  {
    return false;
  }
  
  protected boolean c(CONTEXT paramCONTEXT, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.d
 * JD-Core Version:    0.7.0.1
 */