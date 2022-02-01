package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class d<CONTEXT extends com.tencent.mm.plugin.appbrand.jsapi.e>
  extends e<c>
{
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    com.tencent.mm.plugin.appbrand.jsapi.e locale = ((g)paramc.K(g.class)).c(paramc, paramJSONObject);
    if (locale == null)
    {
      paramc.h(paramInt, e("fail:ComponentView is null.", null));
      return;
    }
    paramc.M(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140654);
        com.tencent.mm.plugin.appbrand.jsapi.e locale = (com.tencent.mm.plugin.appbrand.jsapi.e)this.kCj.get();
        if ((locale == null) || (!locale.isRunning()))
        {
          ad.w("MicroMsg.BaseUpdateViewJsApi", "page view has been release.");
          paramc.h(paramInt, d.this.e("fail:page is null", null));
          AppMethodBeat.o(140654);
          return;
        }
        if (locale.aYi() == null)
        {
          ad.w("MicroMsg.BaseUpdateViewJsApi", "fail, component custom view container is null");
          paramc.h(paramInt, d.this.e("fail:update view failed", null));
          AppMethodBeat.o(140654);
          return;
        }
        int i;
        boolean bool2;
        Object localObject1;
        try
        {
          i = d.this.A(paramJSONObject);
          bool2 = paramJSONObject.optBoolean("independent", false);
          localObject1 = locale.fG(bool2).getViewById(i);
          if (localObject1 == null)
          {
            ad.w("MicroMsg.BaseUpdateViewJsApi", "get view by viewId(%s) return null.", new Object[] { Integer.valueOf(i) });
            paramc.h(paramInt, d.this.e("fail:got 'null' when get view by the given viewId", null));
            AppMethodBeat.o(140654);
            return;
          }
        }
        catch (JSONException localJSONException1)
        {
          paramc.h(paramInt, d.this.e("fail:view id do not exist", null));
          AppMethodBeat.o(140654);
          return;
        }
        boolean bool1;
        Object localObject2;
        if (((localObject1 instanceof CoverViewContainer)) && (paramJSONObject.has("draggable")))
        {
          bool1 = paramJSONObject.optBoolean("draggable", false);
          localObject2 = (CoverViewContainer)localObject1;
          ((CoverViewContainer)localObject2).a(bool1, i, ((CoverViewContainer)localObject2).kKQ);
          ((CoverViewContainer)localObject1).setDragConfig(paramJSONObject.optString("dragConfig"));
        }
        d.a(d.this, localJSONException1, i, paramJSONObject, bool2);
        try
        {
          localObject2 = d.E(paramJSONObject);
          int j = d.F(paramJSONObject);
          Boolean localBoolean1 = d.G(paramJSONObject);
          Boolean localBoolean2 = d.H(paramJSONObject);
          bool1 = localJSONException1.fG(bool2).a(i, (float[])localObject2, j, localBoolean1, localBoolean2);
          ad.i("MicroMsg.BaseUpdateViewJsApi", "update view(parentId : %s, viewId : %d), ret : %b", new Object[] { Integer.valueOf(localJSONException1.fG(bool2).sF(i)), Integer.valueOf(i), Integer.valueOf(localObject1.hashCode()), Boolean.valueOf(bool1) });
          boolean bool3 = d.this.biW();
          bool2 = bool1;
          if (bool1)
          {
            if (bool3) {
              bool2 = d.this.b(localJSONException1, i, (View)localObject1, paramJSONObject, new i(paramc, paramInt));
            }
          }
          else
          {
            if (!bool3)
            {
              localObject1 = paramc;
              i = paramInt;
              localObject2 = d.this;
              if (!bool2) {
                break label571;
              }
              str = "ok";
              ((c)localObject1).h(i, ((m)localObject2).e(str, null));
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
  
  protected boolean biW()
  {
    return false;
  }
  
  protected boolean biX()
  {
    return false;
  }
  
  protected boolean c(CONTEXT paramCONTEXT, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.d
 * JD-Core Version:    0.7.0.1
 */