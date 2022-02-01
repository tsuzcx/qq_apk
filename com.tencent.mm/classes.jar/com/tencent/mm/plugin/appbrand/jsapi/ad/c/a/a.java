package com.tencent.mm.plugin.appbrand.jsapi.ad.c.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.tencent.luggage.xweb_ext.extendplugin.component.e;
import com.tencent.luggage.xweb_ext.extendplugin.component.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.page.ax;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.vfs.k;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
  implements com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a.a
{
  private boolean csK;
  com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a lCr;
  private com.tencent.mm.plugin.appbrand.h.b lCs;
  String lCt;
  private volatile boolean lCu;
  private c.a lCv;
  
  public a()
  {
    AppMethodBeat.i(139481);
    this.csK = false;
    this.lCu = false;
    this.lCv = new c.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.a.b paramAnonymousb)
      {
        AppMethodBeat.i(139480);
        if (paramAnonymousString.equalsIgnoreCase(a.this.lCt)) {
          if (paramAnonymousb == com.tencent.mm.plugin.appbrand.a.b.jOb)
          {
            if (a.this.lCr != null)
            {
              paramAnonymousb = a.this.lCr;
              int i = com.tencent.mm.plugin.appbrand.jsapi.ad.b.Sg(paramAnonymousString);
              if (paramAnonymousb.csz != null) {
                paramAnonymousb.csz.post(new com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a.3(paramAnonymousb, i));
              }
              AppMethodBeat.o(139480);
            }
          }
          else if ((paramAnonymousb == com.tencent.mm.plugin.appbrand.a.b.jOa) && (a.this.lCr != null))
          {
            paramAnonymousString = a.this.lCr;
            if (paramAnonymousString.csz != null) {
              paramAnonymousString.csz.post(new com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a.2(paramAnonymousString));
            }
          }
        }
        AppMethodBeat.o(139480);
      }
    };
    AppMethodBeat.o(139481);
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a.b Gr()
  {
    AppMethodBeat.i(139482);
    b localb = new b();
    AppMethodBeat.o(139482);
    return localb;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a.c Gs()
  {
    AppMethodBeat.i(139483);
    com.tencent.mm.plugin.appbrand.jsapi.ad.c.c localc = new com.tencent.mm.plugin.appbrand.jsapi.ad.c.c();
    AppMethodBeat.o(139483);
    return localc;
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, Bitmap paramBitmap)
  {
    AppMethodBeat.i(139486);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(139486);
      return;
    }
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      ae.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, bitmap is null");
      parama.dw("fail:snapshot error");
      AppMethodBeat.o(139486);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.c localc = ((com.tencent.mm.plugin.appbrand.h.b)parama).kmw;
    String str = com.tencent.mm.loader.j.b.asv() + String.format(Locale.US, "%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    i locali;
    try
    {
      h.a(paramBitmap, 90, Bitmap.CompressFormat.JPEG, str, true);
      locali = new i();
      if (localc.Fl() != null)
      {
        if (localc.Fl().a(new k(str), "jpg", true, locali) == m.jPM) {
          break label255;
        }
        ae.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, save snapshot failed");
        parama.dw("fail:snapshot error");
        AppMethodBeat.o(139486);
        return;
      }
    }
    catch (IOException paramBitmap)
    {
      ae.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, save bitmap exception", new Object[] { paramBitmap });
      parama.dw("fail:snapshot error");
      AppMethodBeat.o(139486);
      return;
    }
    parama.dw("fail");
    AppMethodBeat.o(139486);
    return;
    label255:
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      ae.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "bitmap recycle " + paramBitmap.toString());
      paramBitmap.recycle();
    }
    ae.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, actualPath:%s path:%s", new Object[] { str, locali.value });
    paramBitmap = new HashMap();
    paramBitmap.put("tempImagePath", locali.value);
    paramBitmap.put("width", Integer.valueOf(i));
    paramBitmap.put("height", Integer.valueOf(j));
    parama.f("ok", paramBitmap);
    AppMethodBeat.o(139486);
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(220617);
    AppBrandRuntime localAppBrandRuntime = com.tencent.mm.plugin.appbrand.jsapi.ad.b.y(parama);
    if (localAppBrandRuntime != null)
    {
      this.lCt = localAppBrandRuntime.mAppId;
      localAppBrandRuntime.jzQ.a(this.lCv);
      if (paramBundle.getInt("mode", 0) == 2)
      {
        this.csK = true;
        if (localAppBrandRuntime != null)
        {
          paramBundle = (com.tencent.mm.plugin.appbrand.jsapi.ad.c.d)localAppBrandRuntime.as(com.tencent.mm.plugin.appbrand.jsapi.ad.c.d.class);
          parama = paramBundle;
          if (paramBundle == null)
          {
            ae.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "registerForBackgroundVOIPIfNeed, no state manager, create one");
            parama = new com.tencent.mm.plugin.appbrand.jsapi.ad.c.d();
            localAppBrandRuntime.a(parama);
          }
          paramBundle = this.lCr;
          parama.lCq.add(paramBundle);
          ae.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "registerLivePlayer:%s", new Object[] { paramBundle.FY() });
          AppMethodBeat.o(220617);
        }
      }
      else
      {
        this.csK = false;
        ae.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "registerForBackgroundVOIPIfNeed, not RTC mode");
      }
    }
    AppMethodBeat.o(220617);
  }
  
  public final boolean a(com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a parama, com.tencent.luggage.xweb_ext.extendplugin.a parama1, int paramInt)
  {
    AppMethodBeat.i(220616);
    parama1 = com.tencent.mm.plugin.appbrand.jsapi.ad.b.y(parama1);
    if (parama1 != null) {}
    for (parama1 = (com.tencent.mm.plugin.appbrand.jsapi.ad.c.d)parama1.as(com.tencent.mm.plugin.appbrand.jsapi.ad.c.d.class); parama1 != null; parama1 = null)
    {
      boolean bool = parama1.a(parama, paramInt);
      AppMethodBeat.o(220616);
      return bool;
    }
    ae.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "shouldInterceptEnterBackground, no state manager");
    AppMethodBeat.o(220616);
    return false;
  }
  
  public final void b(com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a parama)
  {
    this.lCr = parama;
  }
  
  public final void gJ(int paramInt)
  {
    AppMethodBeat.i(220618);
    ae.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "onXWebLivePlayerEvent, errCode: ".concat(String.valueOf(paramInt)));
    if (this.lCu)
    {
      ae.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "onXWebLivePlayerEvent, released");
      AppMethodBeat.o(220618);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(220618);
      return;
      ae.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart");
      if (this.csK)
      {
        ae.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart, mIsRTCMode");
        AppMethodBeat.o(220618);
        return;
      }
      if ((this.lCr == null) || (this.lCs == null))
      {
        ae.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart, mPluginHandler or mInvokeContext is null");
        AppMethodBeat.o(220618);
        return;
      }
      com.tencent.mm.plugin.appbrand.jsapi.ad.a locala = e.f(this.lCs);
      if (locala == null)
      {
        ae.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart, audioOfVideoBackgroundPlayManager is null");
        AppMethodBeat.o(220618);
        return;
      }
      locala.d(this.lCr);
      AppMethodBeat.o(220618);
      return;
      ae.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop");
      if (this.csK)
      {
        ae.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop, isRTCMode");
        AppMethodBeat.o(220618);
        return;
      }
      if ((this.lCr == null) || (this.lCs == null))
      {
        ae.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop, pluginHandler or invokeContext is null");
        AppMethodBeat.o(220618);
        return;
      }
      locala = e.f(this.lCs);
      if (locala == null)
      {
        ae.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop, audioOfVideoBackgroundPlayManager is null");
        AppMethodBeat.o(220618);
        return;
      }
      locala.e(this.lCr);
    }
  }
  
  public final boolean j(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139484);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(139484);
      return false;
    }
    Object localObject = parama.FJ();
    com.tencent.mm.plugin.appbrand.jsapi.c localc = ((com.tencent.mm.plugin.appbrand.h.b)parama).kmw;
    parama = null;
    if ((localc instanceof z)) {
      parama = (z)localc;
    }
    while (parama == null)
    {
      ae.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, page view is null");
      AppMethodBeat.o(139484);
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
        ae.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, data array is null");
        AppMethodBeat.o(139484);
        return false;
      }
      final int i;
      switch (((JSONArray)localObject).optInt(0, 0))
      {
      default: 
        i = 90;
      }
      for (;;)
      {
        parama.K(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(139478);
            if ((!parama.isRunning()) || (parama.mcJ == null))
            {
              ae.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, invalid state");
              AppMethodBeat.o(139478);
              return;
            }
            com.tencent.mm.plugin.appbrand.platform.window.d locald = parama.mcJ.getFullscreenImpl();
            View localView = parama.mcJ.getWrapperView();
            if ((locald != null) && (localView != null))
            {
              locald.O(localView, i);
              ae.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, target orientation:%s", new Object[] { Integer.valueOf(i) });
              AppMethodBeat.o(139478);
              return;
            }
            ae.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, state error, FullscreenImp[%s], fullscreenWebView[%s]", new Object[] { locald, localView });
            AppMethodBeat.o(139478);
          }
        });
        AppMethodBeat.o(139484);
        return true;
        i = 90;
        continue;
        i = -90;
        continue;
        i = 0;
      }
    }
    AppMethodBeat.o(139484);
    return false;
  }
  
  public final boolean k(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139485);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(139485);
      return false;
    }
    parama = ((com.tencent.mm.plugin.appbrand.h.b)parama).kmw;
    if ((parama instanceof z)) {
      parama = (z)parama;
    }
    for (;;)
    {
      if (parama == null)
      {
        ae.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "exitFullscreen, page view is null");
        AppMethodBeat.o(139485);
        return false;
        if ((parama instanceof r)) {
          parama = ((r)parama).getCurrentPageView();
        }
      }
      else
      {
        parama.K(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(139479);
            if ((!parama.isRunning()) || (parama.mcJ == null))
            {
              ae.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "exitFullscreen, invalid state");
              AppMethodBeat.o(139479);
              return;
            }
            com.tencent.mm.plugin.appbrand.platform.window.d locald = parama.mcJ.getFullscreenImpl();
            if (locald != null)
            {
              locald.aYo();
              ae.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "exitFullscreen");
              AppMethodBeat.o(139479);
              return;
            }
            ae.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "exitFullscreen, state error");
            AppMethodBeat.o(139479);
          }
        });
        AppMethodBeat.o(139485);
        return true;
      }
      parama = null;
    }
  }
  
  public final void l(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139488);
    parama = com.tencent.mm.plugin.appbrand.jsapi.ad.b.y(parama);
    if (parama != null)
    {
      parama.jzQ.b(this.lCv);
      if (parama != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.ad.c.d locald = (com.tencent.mm.plugin.appbrand.jsapi.ad.c.d)parama.as(com.tencent.mm.plugin.appbrand.jsapi.ad.c.d.class);
        if (locald == null) {
          break label118;
        }
        com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a locala = this.lCr;
        locald.lCq.remove(locala);
        ae.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "unregisterLivePlayer:%s", new Object[] { locala.FY() });
      }
      ae.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease");
      if (!this.csK) {
        break label129;
      }
      ae.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease, isRTCMode");
    }
    for (;;)
    {
      this.lCu = true;
      AppMethodBeat.o(139488);
      return;
      label118:
      ae.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "unregisterForBackgroundVOIPIfNeed, no state manager");
      break;
      label129:
      if (this.lCr == null)
      {
        ae.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease, pluginHandler is null");
      }
      else
      {
        parama = (com.tencent.mm.plugin.appbrand.jsapi.ad.a)parama.as(com.tencent.mm.plugin.appbrand.jsapi.ad.a.class);
        if (parama == null) {
          ae.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease, audioOfVideoBackgroundPlayManager is null");
        } else {
          parama.f(this.lCr);
        }
      }
    }
  }
  
  public final void m(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    if ((parama instanceof com.tencent.mm.plugin.appbrand.h.b)) {
      this.lCs = ((com.tencent.mm.plugin.appbrand.h.b)parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.c.a.a
 * JD-Core Version:    0.7.0.1
 */