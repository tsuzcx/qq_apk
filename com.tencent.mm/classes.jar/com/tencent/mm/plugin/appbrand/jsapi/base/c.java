package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class c<CONTEXT extends e>
  extends d<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    e locale = ((f)paramc.K(f.class)).c(paramc, paramJSONObject);
    if (locale == null)
    {
      paramc.h(paramInt, e("fail:ComponentView is null.", null));
      return;
    }
    paramc.L(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140654);
        e locale = (e)this.jGT.get();
        if ((locale == null) || (!locale.isRunning()))
        {
          ad.w("MicroMsg.BaseUpdateViewJsApi", "page view has been release.");
          paramc.h(paramInt, c.this.e("fail:page is null", null));
          AppMethodBeat.o(140654);
          return;
        }
        int i;
        Object localObject1;
        try
        {
          i = c.this.A(paramJSONObject);
          localObject1 = locale.aOg().getViewById(i);
          if (localObject1 == null)
          {
            ad.w("MicroMsg.BaseUpdateViewJsApi", "get view by viewId(%s) return null.", new Object[] { Integer.valueOf(i) });
            paramc.h(paramInt, c.this.e("fail:got 'null' when get view by the given viewId", null));
            AppMethodBeat.o(140654);
            return;
          }
        }
        catch (JSONException localJSONException1)
        {
          paramc.h(paramInt, c.this.e("fail:view id do not exist", null));
          AppMethodBeat.o(140654);
          return;
        }
        c.a(c.this, localJSONException1, i, paramJSONObject);
        try
        {
          Object localObject2 = c.E(paramJSONObject);
          int j = c.F(paramJSONObject);
          Boolean localBoolean1 = c.G(paramJSONObject);
          Boolean localBoolean2 = c.H(paramJSONObject);
          bool1 = localJSONException1.aOg().a(i, (float[])localObject2, j, localBoolean1, localBoolean2);
          ad.i("MicroMsg.BaseUpdateViewJsApi", "update view(parentId : %s, viewId : %d), ret : %b", new Object[] { Integer.valueOf(localJSONException1.aOg().rq(i)), Integer.valueOf(i), Integer.valueOf(localObject1.hashCode()), Boolean.valueOf(bool1) });
          boolean bool3 = c.this.aYw();
          bool2 = bool1;
          if (bool1)
          {
            if (bool3) {
              bool2 = c.this.b(localJSONException1, i, (View)localObject1, paramJSONObject, new g(paramc, paramInt));
            }
          }
          else
          {
            if (!bool3)
            {
              localObject1 = paramc;
              i = paramInt;
              localObject2 = c.this;
              if (!bool2) {
                break label438;
              }
              str = "ok";
              ((com.tencent.mm.plugin.appbrand.jsapi.c)localObject1).h(i, ((m)localObject2).e(str, null));
            }
            AppMethodBeat.o(140654);
            return;
          }
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            boolean bool1 = true;
            continue;
            boolean bool2 = c.this.c(str, i, (View)localObject1, paramJSONObject);
            continue;
            label438:
            String str = "fail";
          }
        }
      }
    });
  }
  
  protected boolean aYw()
  {
    return false;
  }
  
  protected boolean aYx()
  {
    return false;
  }
  
  protected boolean b(CONTEXT paramCONTEXT, int paramInt, View paramView, JSONObject paramJSONObject, g paramg)
  {
    return true;
  }
  
  protected boolean c(CONTEXT paramCONTEXT, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.c
 * JD-Core Version:    0.7.0.1
 */