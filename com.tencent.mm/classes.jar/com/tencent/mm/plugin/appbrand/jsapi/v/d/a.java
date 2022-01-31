package com.tencent.mm.plugin.appbrand.jsapi.v.d;

import android.app.Activity;
import android.view.View;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
  implements com.tencent.luggage.xweb_ext.extendplugin.component.video.a.a
{
  public final String a(com.tencent.luggage.xweb_ext.extendplugin.a parama, String paramString)
  {
    AppMethodBeat.i(140072);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.f.b))
    {
      AppMethodBeat.o(140072);
      return paramString;
    }
    parama = ((com.tencent.mm.plugin.appbrand.f.b)parama).hrA;
    if ((!bo.isNullOrNil(paramString)) && (parama != null) && (parama.wX() != null) && (parama.wX().bL(paramString)))
    {
      parama = parama.wX().zg(paramString);
      if (parama == null) {}
      for (;;)
      {
        ab.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "convertVideoPath, videoPath:%s", new Object[] { paramString });
        AppMethodBeat.o(140072);
        return paramString;
        paramString = "file://" + parama.getAbsolutePath();
      }
    }
    AppMethodBeat.o(140072);
    return paramString;
  }
  
  public final boolean b(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(140073);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.f.b))
    {
      AppMethodBeat.o(140073);
      return false;
    }
    Object localObject = parama.xk();
    com.tencent.mm.plugin.appbrand.jsapi.c localc = ((com.tencent.mm.plugin.appbrand.f.b)parama).hrA;
    parama = null;
    if ((localc instanceof v)) {
      parama = (v)localc;
    }
    while (parama == null)
    {
      ab.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, page view is null");
      AppMethodBeat.o(140073);
      return false;
      if ((localc instanceof r)) {
        parama = ((r)localc).getCurrentPageView();
      }
    }
    if ((localObject != null) && (((JSONObject)localObject).has("data")))
    {
      localObject = ((JSONObject)localObject).optJSONArray("data");
      if ((localObject == null) || (((JSONArray)localObject).length() == 0))
      {
        ab.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, data array is null");
        AppMethodBeat.o(140073);
        return false;
      }
      final int i;
      switch (((JSONArray)localObject).optInt(0, 90))
      {
      default: 
        i = 90;
      }
      for (;;)
      {
        parama.A(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(140064);
            com.tencent.mm.plugin.appbrand.page.d locald = parama.iuy.getFullscreenImpl();
            View localView = parama.iuy.getWrapperView();
            if ((locald != null) && (localView != null))
            {
              locald.J(localView, i);
              ab.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, target orientation:%s", new Object[] { Integer.valueOf(i) });
              AppMethodBeat.o(140064);
              return;
            }
            ab.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, state error, FullscreenImp[%s], fullscreenWebView[%s]", new Object[] { locald, localView });
            AppMethodBeat.o(140064);
          }
        });
        AppMethodBeat.o(140073);
        return true;
        i = 90;
        continue;
        i = -90;
        continue;
        i = 0;
      }
    }
    AppMethodBeat.o(140073);
    return false;
  }
  
  public final boolean c(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(140074);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.f.b))
    {
      AppMethodBeat.o(140074);
      return false;
    }
    parama = ((com.tencent.mm.plugin.appbrand.f.b)parama).hrA;
    if ((parama instanceof v)) {
      parama = (v)parama;
    }
    for (;;)
    {
      if (parama == null)
      {
        ab.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "exitFullscreen, page view is null");
        AppMethodBeat.o(140074);
        return false;
        if ((parama instanceof r)) {
          parama = ((r)parama).getCurrentPageView();
        }
      }
      else
      {
        parama.A(new a.2(this, parama));
        AppMethodBeat.o(140074);
        return true;
      }
      parama = null;
    }
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b g(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(140071);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.f.b))
    {
      AppMethodBeat.o(140071);
      return null;
    }
    Object localObject = ((com.tencent.mm.plugin.appbrand.f.b)parama).hrA;
    if (localObject != null) {}
    for (localObject = (com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c)((com.tencent.mm.plugin.appbrand.jsapi.c)localObject).V(com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c.class);; localObject = null)
    {
      if (localObject == null) {}
      for (parama = c.b.ya().g(null);; parama = ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c)localObject).g(parama))
      {
        AppMethodBeat.o(140071);
        return parama;
      }
    }
  }
  
  public final boolean h(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(140075);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.f.b))
    {
      AppMethodBeat.o(140075);
      return false;
    }
    Object localObject = parama.xk();
    parama = ((com.tencent.mm.plugin.appbrand.f.b)parama).hrA;
    if ((parama instanceof v)) {
      parama = (v)parama;
    }
    for (;;)
    {
      if (parama == null)
      {
        ab.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "setScreenBrightness, page view is null");
        AppMethodBeat.o(140075);
        return false;
        if ((parama instanceof r)) {
          parama = ((r)parama).getCurrentPageView();
        }
      }
      else
      {
        if ((localObject != null) && (((JSONObject)localObject).has("data")))
        {
          localObject = ((JSONObject)localObject).optJSONArray("data");
          if ((localObject == null) || (((JSONArray)localObject).length() == 0))
          {
            ab.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "setScreenBrightness, data array is null");
            AppMethodBeat.o(140075);
            return false;
          }
          float f = (float)((JSONArray)localObject).optDouble(0, -1.0D);
          if ((Float.isNaN(f)) || (f < 0.0F) || (f > 1.0F))
          {
            AppMethodBeat.o(140075);
            return false;
          }
          if ((parama.getContext() instanceof Activity))
          {
            al.d(new a.3(this, (Activity)parama.getContext(), f));
            AppMethodBeat.o(140075);
            return true;
          }
        }
        AppMethodBeat.o(140075);
        return false;
      }
      parama = null;
    }
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.a.e xP()
  {
    AppMethodBeat.i(140070);
    f localf = new f();
    AppMethodBeat.o(140070);
    return localf;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.a.d xQ()
  {
    AppMethodBeat.i(140069);
    e locale = new e();
    AppMethodBeat.o(140069);
    return locale;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.a.b xR()
  {
    AppMethodBeat.i(140067);
    b localb = new b();
    AppMethodBeat.o(140067);
    return localb;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.a.c xS()
  {
    AppMethodBeat.i(140068);
    c localc = new c();
    AppMethodBeat.o(140068);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.d.a
 * JD-Core Version:    0.7.0.1
 */