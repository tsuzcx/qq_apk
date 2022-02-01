package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import com.tencent.mm.plugin.appbrand.n.o;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class d<CONTEXT extends h>
  extends e<f>
{
  private static h d(f paramf, JSONObject paramJSONObject)
  {
    g localg = (g)paramf.T(g.class);
    if (localg == null)
    {
      Log.e("MicroMsg.BaseUpdateViewJsApi", "getComponentView NULL IComponentConverter");
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
    h localh = d(paramf, paramJSONObject);
    if (localh == null)
    {
      paramf.callback(paramInt, ZP("fail:ComponentView is null."));
      return;
    }
    paramf.V(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140654);
        h localh = (h)this.rJo.get();
        if ((localh == null) || (!localh.a(d.this.getName(), paramo)))
        {
          Log.w("MicroMsg.BaseUpdateViewJsApi", "page view has been release.");
          paramf.callback(paramInt, d.this.ZP("fail:page is null"));
          AppMethodBeat.o(140654);
          return;
        }
        if (localh.getCustomViewContainer() == null)
        {
          Log.w("MicroMsg.BaseUpdateViewJsApi", "fail, component custom view container is null");
          paramf.callback(paramInt, d.this.ZP("fail:update view failed"));
          AppMethodBeat.o(140654);
          return;
        }
        int i;
        boolean bool2;
        Object localObject1;
        try
        {
          i = d.this.V(paramJSONObject);
          bool2 = paramJSONObject.optBoolean("independent", false);
          localObject1 = localh.ic(bool2).dU(i);
          if (localObject1 == null)
          {
            Log.w("MicroMsg.BaseUpdateViewJsApi", "get view by viewId(%s) return null.", new Object[] { Integer.valueOf(i) });
            paramf.callback(paramInt, d.this.ZP("fail:got 'null' when get view by the given viewId"));
            AppMethodBeat.o(140654);
            return;
          }
        }
        catch (JSONException localJSONException1)
        {
          paramf.callback(paramInt, d.this.ZP("fail:view id do not exist"));
          AppMethodBeat.o(140654);
          return;
        }
        boolean bool1;
        Object localObject2;
        if (((localObject1 instanceof CoverViewContainer)) && (paramJSONObject.has("draggable")))
        {
          bool1 = paramJSONObject.optBoolean("draggable", false);
          localObject2 = (CoverViewContainer)localObject1;
          ((CoverViewContainer)localObject2).a(bool1, i, ((CoverViewContainer)localObject2).rTu);
          ((CoverViewContainer)localObject1).setDragConfig(paramJSONObject.optString("dragConfig"));
        }
        d.a(d.this, localJSONException1, i, paramJSONObject, bool2);
        try
        {
          localObject2 = d.aa(paramJSONObject);
          int j = d.ab(paramJSONObject);
          Boolean localBoolean1 = d.ac(paramJSONObject);
          Boolean localBoolean2 = d.ad(paramJSONObject);
          bool1 = localJSONException1.ic(bool2).a(i, (float[])localObject2, j, localBoolean1, localBoolean2);
          Log.i("MicroMsg.BaseUpdateViewJsApi", "update view(parentId : %s, viewId : %d), ret : %b", new Object[] { Integer.valueOf(localJSONException1.ic(bool2).Al(i)), Integer.valueOf(i), Integer.valueOf(localObject1.hashCode()), Boolean.valueOf(bool1) });
          boolean bool3 = d.this.cqw();
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
                break label577;
              }
              str = "ok";
              ((f)localObject1).callback(i, ((d)localObject2).ZP(str));
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
            label577:
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
  
  protected boolean c(CONTEXT paramCONTEXT, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    return true;
  }
  
  protected boolean cqw()
  {
    return false;
  }
  
  protected boolean cqx()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.d
 * JD-Core Version:    0.7.0.1
 */