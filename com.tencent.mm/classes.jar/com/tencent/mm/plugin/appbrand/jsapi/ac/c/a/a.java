package com.tencent.mm.plugin.appbrand.jsapi.ac.c.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.tencent.luggage.xweb_ext.extendplugin.component.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ay;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.z.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.g;
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
  private boolean csh;
  com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a lxT;
  private com.tencent.mm.plugin.appbrand.h.b lxU;
  String lxV;
  private volatile boolean lxW;
  private c.a lxX;
  
  public a()
  {
    AppMethodBeat.i(139481);
    this.csh = false;
    this.lxW = false;
    this.lxX = new c.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.a.b paramAnonymousb)
      {
        AppMethodBeat.i(139480);
        if (paramAnonymousString.equalsIgnoreCase(a.this.lxV)) {
          if (paramAnonymousb == com.tencent.mm.plugin.appbrand.a.b.jKP)
          {
            if (a.this.lxT != null)
            {
              paramAnonymousb = a.this.lxT;
              int i = com.tencent.mm.plugin.appbrand.jsapi.ac.b.Rx(paramAnonymousString);
              if (paramAnonymousb.crW != null) {
                paramAnonymousb.crW.post(new com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a.3(paramAnonymousb, i));
              }
              AppMethodBeat.o(139480);
            }
          }
          else if ((paramAnonymousb == com.tencent.mm.plugin.appbrand.a.b.jKO) && (a.this.lxT != null))
          {
            paramAnonymousString = a.this.lxT;
            if (paramAnonymousString.crW != null) {
              paramAnonymousString.crW.post(new com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a.2(paramAnonymousString));
            }
          }
        }
        AppMethodBeat.o(139480);
      }
    };
    AppMethodBeat.o(139481);
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a.b Gl()
  {
    AppMethodBeat.i(139482);
    b localb = new b();
    AppMethodBeat.o(139482);
    return localb;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a.c Gm()
  {
    AppMethodBeat.i(139483);
    com.tencent.mm.plugin.appbrand.jsapi.ac.c.c localc = new com.tencent.mm.plugin.appbrand.jsapi.ac.c.c();
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
      ad.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, bitmap is null");
      parama.du("fail:snapshot error");
      AppMethodBeat.o(139486);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.c localc = ((com.tencent.mm.plugin.appbrand.h.b)parama).kjg;
    String str = com.tencent.mm.loader.j.b.asg() + String.format(Locale.US, "%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    i locali;
    try
    {
      g.a(paramBitmap, 90, Bitmap.CompressFormat.JPEG, str, true);
      locali = new i();
      if (localc.Fg() != null)
      {
        if (localc.Fg().a(new com.tencent.mm.vfs.e(str), "jpg", true, locali) == l.jMv) {
          break label255;
        }
        ad.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, save snapshot failed");
        parama.du("fail:snapshot error");
        AppMethodBeat.o(139486);
        return;
      }
    }
    catch (IOException paramBitmap)
    {
      ad.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, save bitmap exception", new Object[] { paramBitmap });
      parama.du("fail:snapshot error");
      AppMethodBeat.o(139486);
      return;
    }
    parama.du("fail");
    AppMethodBeat.o(139486);
    return;
    label255:
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      ad.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "bitmap recycle " + paramBitmap.toString());
      paramBitmap.recycle();
    }
    ad.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, actualPath:%s path:%s", new Object[] { str, locali.value });
    paramBitmap = new HashMap();
    paramBitmap.put("tempImagePath", locali.value);
    paramBitmap.put("width", Integer.valueOf(i));
    paramBitmap.put("height", Integer.valueOf(j));
    parama.e("ok", paramBitmap);
    AppMethodBeat.o(139486);
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(186920);
    AppBrandRuntime localAppBrandRuntime = com.tencent.mm.plugin.appbrand.jsapi.ac.b.y(parama);
    if (localAppBrandRuntime != null)
    {
      this.lxV = localAppBrandRuntime.mAppId;
      localAppBrandRuntime.jwS.a(this.lxX);
      if (paramBundle.getInt("mode", 0) == 2)
      {
        this.csh = true;
        if (localAppBrandRuntime != null)
        {
          paramBundle = (com.tencent.mm.plugin.appbrand.jsapi.ac.c.d)localAppBrandRuntime.as(com.tencent.mm.plugin.appbrand.jsapi.ac.c.d.class);
          parama = paramBundle;
          if (paramBundle == null)
          {
            ad.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "registerForBackgroundVOIPIfNeed, no state manager, create one");
            parama = new com.tencent.mm.plugin.appbrand.jsapi.ac.c.d();
            localAppBrandRuntime.a(parama);
          }
          paramBundle = this.lxT;
          parama.lxS.add(paramBundle);
          ad.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "registerLivePlayer:%s", new Object[] { paramBundle.FS() });
          AppMethodBeat.o(186920);
        }
      }
      else
      {
        this.csh = false;
        ad.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "registerForBackgroundVOIPIfNeed, not RTC mode");
      }
    }
    AppMethodBeat.o(186920);
  }
  
  public final boolean a(com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a parama, com.tencent.luggage.xweb_ext.extendplugin.a parama1, int paramInt)
  {
    AppMethodBeat.i(186919);
    parama1 = com.tencent.mm.plugin.appbrand.jsapi.ac.b.y(parama1);
    if (parama1 != null) {}
    for (parama1 = (com.tencent.mm.plugin.appbrand.jsapi.ac.c.d)parama1.as(com.tencent.mm.plugin.appbrand.jsapi.ac.c.d.class); parama1 != null; parama1 = null)
    {
      boolean bool = parama1.a(parama, paramInt);
      AppMethodBeat.o(186919);
      return bool;
    }
    ad.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "shouldInterceptEnterBackground, no state manager");
    AppMethodBeat.o(186919);
    return false;
  }
  
  public final void b(com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a parama)
  {
    this.lxT = parama;
  }
  
  public final void gI(int paramInt)
  {
    AppMethodBeat.i(186921);
    ad.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "onXWebLivePlayerEvent, errCode: ".concat(String.valueOf(paramInt)));
    if (this.lxW)
    {
      ad.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "onXWebLivePlayerEvent, released");
      AppMethodBeat.o(186921);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(186921);
      return;
      ad.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart");
      if (this.csh)
      {
        ad.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart, mIsRTCMode");
        AppMethodBeat.o(186921);
        return;
      }
      if ((this.lxT == null) || (this.lxU == null))
      {
        ad.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart, mPluginHandler or mInvokeContext is null");
        AppMethodBeat.o(186921);
        return;
      }
      com.tencent.mm.plugin.appbrand.jsapi.ac.a locala = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(this.lxU);
      if (locala == null)
      {
        ad.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart, audioOfVideoBackgroundPlayManager is null");
        AppMethodBeat.o(186921);
        return;
      }
      locala.d(this.lxT);
      AppMethodBeat.o(186921);
      return;
      ad.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop");
      if (this.csh)
      {
        ad.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop, isRTCMode");
        AppMethodBeat.o(186921);
        return;
      }
      if ((this.lxT == null) || (this.lxU == null))
      {
        ad.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop, pluginHandler or invokeContext is null");
        AppMethodBeat.o(186921);
        return;
      }
      locala = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(this.lxU);
      if (locala == null)
      {
        ad.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop, audioOfVideoBackgroundPlayManager is null");
        AppMethodBeat.o(186921);
        return;
      }
      locala.e(this.lxT);
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
    Object localObject = parama.FD();
    com.tencent.mm.plugin.appbrand.jsapi.c localc = ((com.tencent.mm.plugin.appbrand.h.b)parama).kjg;
    parama = null;
    if ((localc instanceof aa)) {
      parama = (aa)localc;
    }
    while (parama == null)
    {
      ad.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, page view is null");
      AppMethodBeat.o(139484);
      return false;
      if ((localc instanceof q)) {
        parama = ((q)localc).getCurrentPageView();
      }
    }
    if ((localObject != null) && (((JSONObject)localObject).has("data")))
    {
      localObject = ((JSONObject)localObject).optJSONArray("data");
      if ((localObject == null) || (((JSONArray)localObject).length() == 0))
      {
        ad.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, data array is null");
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
        parama.M(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(139478);
            if ((!parama.isRunning()) || (parama.lYc == null))
            {
              ad.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, invalid state");
              AppMethodBeat.o(139478);
              return;
            }
            com.tencent.mm.plugin.appbrand.r.a.d locald = parama.lYc.getFullscreenImpl();
            View localView = parama.lYc.getWrapperView();
            if ((locald != null) && (localView != null))
            {
              locald.O(localView, i);
              ad.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, target orientation:%s", new Object[] { Integer.valueOf(i) });
              AppMethodBeat.o(139478);
              return;
            }
            ad.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, state error, FullscreenImp[%s], fullscreenWebView[%s]", new Object[] { locald, localView });
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
    parama = ((com.tencent.mm.plugin.appbrand.h.b)parama).kjg;
    if ((parama instanceof aa)) {
      parama = (aa)parama;
    }
    for (;;)
    {
      if (parama == null)
      {
        ad.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "exitFullscreen, page view is null");
        AppMethodBeat.o(139485);
        return false;
        if ((parama instanceof q)) {
          parama = ((q)parama).getCurrentPageView();
        }
      }
      else
      {
        parama.M(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(139479);
            if ((!parama.isRunning()) || (parama.lYc == null))
            {
              ad.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "exitFullscreen, invalid state");
              AppMethodBeat.o(139479);
              return;
            }
            com.tencent.mm.plugin.appbrand.r.a.d locald = parama.lYc.getFullscreenImpl();
            if (locald != null)
            {
              locald.aXV();
              ad.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "exitFullscreen");
              AppMethodBeat.o(139479);
              return;
            }
            ad.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "exitFullscreen, state error");
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
    parama = com.tencent.mm.plugin.appbrand.jsapi.ac.b.y(parama);
    if (parama != null)
    {
      parama.jwS.b(this.lxX);
      if (parama != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.ac.c.d locald = (com.tencent.mm.plugin.appbrand.jsapi.ac.c.d)parama.as(com.tencent.mm.plugin.appbrand.jsapi.ac.c.d.class);
        if (locald == null) {
          break label118;
        }
        com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a locala = this.lxT;
        locald.lxS.remove(locala);
        ad.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "unregisterLivePlayer:%s", new Object[] { locala.FS() });
      }
      ad.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease");
      if (!this.csh) {
        break label129;
      }
      ad.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease, isRTCMode");
    }
    for (;;)
    {
      this.lxW = true;
      AppMethodBeat.o(139488);
      return;
      label118:
      ad.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "unregisterForBackgroundVOIPIfNeed, no state manager");
      break;
      label129:
      if (this.lxT == null)
      {
        ad.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease, pluginHandler is null");
      }
      else
      {
        parama = (com.tencent.mm.plugin.appbrand.jsapi.ac.a)parama.as(com.tencent.mm.plugin.appbrand.jsapi.ac.a.class);
        if (parama == null) {
          ad.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease, audioOfVideoBackgroundPlayManager is null");
        } else {
          parama.f(this.lxT);
        }
      }
    }
  }
  
  public final void m(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    if ((parama instanceof com.tencent.mm.plugin.appbrand.h.b)) {
      this.lxU = ((com.tencent.mm.plugin.appbrand.h.b)parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.c.a.a
 * JD-Core Version:    0.7.0.1
 */