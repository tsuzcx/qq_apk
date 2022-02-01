package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class d<CONTEXT extends com.tencent.mm.plugin.appbrand.jsapi.g>
  extends e<com.tencent.mm.plugin.appbrand.jsapi.e>
{
  private static com.tencent.mm.plugin.appbrand.jsapi.g d(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject)
  {
    g localg = (g)parame.K(g.class);
    if (localg == null)
    {
      Log.e("MicroMsg.BaseUpdateViewJsApi", "getComponentView NULL IComponentConverter");
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
    com.tencent.mm.plugin.appbrand.jsapi.g localg = d(parame, paramJSONObject);
    if (localg == null)
    {
      parame.j(paramInt, h("fail:ComponentView is null.", null));
      return;
    }
    parame.P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140654);
        com.tencent.mm.plugin.appbrand.jsapi.g localg = (com.tencent.mm.plugin.appbrand.jsapi.g)this.oGp.get();
        if ((localg == null) || (!localg.a(d.this.getName(), paramo)))
        {
          Log.w("MicroMsg.BaseUpdateViewJsApi", "page view has been release.");
          parame.j(paramInt, d.this.h("fail:page is null", null));
          AppMethodBeat.o(140654);
          return;
        }
        if (localg.getCustomViewContainer() == null)
        {
          Log.w("MicroMsg.BaseUpdateViewJsApi", "fail, component custom view container is null");
          parame.j(paramInt, d.this.h("fail:update view failed", null));
          AppMethodBeat.o(140654);
          return;
        }
        int i;
        boolean bool2;
        Object localObject1;
        try
        {
          i = d.this.K(paramJSONObject);
          bool2 = paramJSONObject.optBoolean("independent", false);
          localObject1 = localg.hl(bool2).bg(i);
          if (localObject1 == null)
          {
            Log.w("MicroMsg.BaseUpdateViewJsApi", "get view by viewId(%s) return null.", new Object[] { Integer.valueOf(i) });
            parame.j(paramInt, d.this.h("fail:got 'null' when get view by the given viewId", null));
            AppMethodBeat.o(140654);
            return;
          }
        }
        catch (JSONException localJSONException1)
        {
          parame.j(paramInt, d.this.h("fail:view id do not exist", null));
          AppMethodBeat.o(140654);
          return;
        }
        boolean bool1;
        Object localObject2;
        if (((localObject1 instanceof CoverViewContainer)) && (paramJSONObject.has("draggable")))
        {
          bool1 = paramJSONObject.optBoolean("draggable", false);
          localObject2 = (CoverViewContainer)localObject1;
          ((CoverViewContainer)localObject2).a(bool1, i, ((CoverViewContainer)localObject2).oPG);
          ((CoverViewContainer)localObject1).setDragConfig(paramJSONObject.optString("dragConfig"));
        }
        d.a(d.this, localJSONException1, i, paramJSONObject, bool2);
        try
        {
          localObject2 = d.P(paramJSONObject);
          int j = d.Q(paramJSONObject);
          Boolean localBoolean1 = d.R(paramJSONObject);
          Boolean localBoolean2 = d.S(paramJSONObject);
          bool1 = localJSONException1.hl(bool2).a(i, (float[])localObject2, j, localBoolean1, localBoolean2);
          Log.i("MicroMsg.BaseUpdateViewJsApi", "update view(parentId : %s, viewId : %d), ret : %b", new Object[] { Integer.valueOf(localJSONException1.hl(bool2).zT(i)), Integer.valueOf(i), Integer.valueOf(localObject1.hashCode()), Boolean.valueOf(bool1) });
          boolean bool3 = d.this.bQz();
          bool2 = bool1;
          if (bool1)
          {
            if (bool3) {
              bool2 = d.this.b(localJSONException1, i, (View)localObject1, paramJSONObject, new i(parame, paramInt));
            }
          }
          else
          {
            if (!bool3)
            {
              localObject1 = parame;
              i = paramInt;
              localObject2 = d.this;
              if (!bool2) {
                break label582;
              }
              str = "ok";
              ((com.tencent.mm.plugin.appbrand.jsapi.e)localObject1).j(i, ((com.tencent.mm.plugin.appbrand.jsapi.o)localObject2).h(str, null));
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
            label582:
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
  
  protected boolean bQA()
  {
    return false;
  }
  
  protected boolean bQz()
  {
    return false;
  }
  
  protected boolean c(CONTEXT paramCONTEXT, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.d
 * JD-Core Version:    0.7.0.1
 */