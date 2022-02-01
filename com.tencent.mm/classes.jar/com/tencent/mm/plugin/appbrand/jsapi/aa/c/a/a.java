package com.tencent.mm.plugin.appbrand.jsapi.aa.c.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.tencent.luggage.k.a.a.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.aa.i;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.f;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
  implements com.tencent.luggage.k.a.a.a.a.a.a
{
  private boolean ckQ;
  com.tencent.luggage.k.a.a.a.a.a kzC;
  private com.tencent.mm.plugin.appbrand.i.b kzD;
  String kzE;
  private c.a kzF;
  
  public a()
  {
    AppMethodBeat.i(139481);
    this.ckQ = false;
    this.kzF = new c.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.b.b paramAnonymousb)
      {
        AppMethodBeat.i(139480);
        if (paramAnonymousString.equalsIgnoreCase(a.this.kzE)) {
          if (paramAnonymousb == com.tencent.mm.plugin.appbrand.b.b.iQL)
          {
            if (a.this.kzC != null)
            {
              paramAnonymousb = a.this.kzC;
              int i = com.tencent.mm.plugin.appbrand.jsapi.aa.b.JR(paramAnonymousString);
              if (paramAnonymousb.ckF != null) {
                paramAnonymousb.ckF.post(new com.tencent.luggage.k.a.a.a.a.a.3(paramAnonymousb, i));
              }
              AppMethodBeat.o(139480);
            }
          }
          else if ((paramAnonymousb == com.tencent.mm.plugin.appbrand.b.b.iQK) && (a.this.kzC != null))
          {
            paramAnonymousString = a.this.kzC;
            if (paramAnonymousString.ckF != null) {
              paramAnonymousString.ckF.post(new com.tencent.luggage.k.a.a.a.a.a.2(paramAnonymousString));
            }
          }
        }
        AppMethodBeat.o(139480);
      }
    };
    AppMethodBeat.o(139481);
  }
  
  public final com.tencent.luggage.k.a.a.a.a.a.b Fi()
  {
    AppMethodBeat.i(139482);
    b localb = new b();
    AppMethodBeat.o(139482);
    return localb;
  }
  
  public final com.tencent.luggage.k.a.a.a.a.a.c Fj()
  {
    AppMethodBeat.i(139483);
    com.tencent.mm.plugin.appbrand.jsapi.aa.c.c localc = new com.tencent.mm.plugin.appbrand.jsapi.aa.c.c();
    AppMethodBeat.o(139483);
    return localc;
  }
  
  public final void a(com.tencent.luggage.k.a.a parama, Bitmap paramBitmap)
  {
    AppMethodBeat.i(139486);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      AppMethodBeat.o(139486);
      return;
    }
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      ad.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, bitmap is null");
      parama.cD("fail:snapshot error");
      AppMethodBeat.o(139486);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.c localc = ((com.tencent.mm.plugin.appbrand.i.b)parama).joJ;
    String str = com.tencent.mm.loader.j.b.ais() + String.format(Locale.US, "%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    i locali;
    try
    {
      f.a(paramBitmap, 90, Bitmap.CompressFormat.JPEG, str, true);
      locali = new i();
      if (localc.Ee() != null)
      {
        if (localc.Ee().a(new com.tencent.mm.vfs.e(str), "jpg", true, locali) == l.iSq) {
          break label255;
        }
        ad.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, save snapshot failed");
        parama.cD("fail:snapshot error");
        AppMethodBeat.o(139486);
        return;
      }
    }
    catch (IOException paramBitmap)
    {
      ad.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, save bitmap exception", new Object[] { paramBitmap });
      parama.cD("fail:snapshot error");
      AppMethodBeat.o(139486);
      return;
    }
    parama.cD("fail");
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
    parama.d("ok", paramBitmap);
    AppMethodBeat.o(139486);
  }
  
  public final void a(com.tencent.luggage.k.a.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(195088);
    AppBrandRuntime localAppBrandRuntime = com.tencent.mm.plugin.appbrand.jsapi.aa.b.z(parama);
    if (localAppBrandRuntime != null)
    {
      this.kzE = localAppBrandRuntime.mAppId;
      localAppBrandRuntime.iDK.a(this.kzF);
      if (paramBundle.getInt("mode", 0) == 2)
      {
        this.ckQ = true;
        if (localAppBrandRuntime != null)
        {
          paramBundle = (com.tencent.mm.plugin.appbrand.jsapi.aa.c.d)localAppBrandRuntime.as(com.tencent.mm.plugin.appbrand.jsapi.aa.c.d.class);
          parama = paramBundle;
          if (paramBundle == null)
          {
            ad.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "registerForBackgroundVOIPIfNeed, no state manager, create one");
            parama = new com.tencent.mm.plugin.appbrand.jsapi.aa.c.d();
            localAppBrandRuntime.a(parama);
          }
          paramBundle = this.kzC;
          parama.kzB.add(paramBundle);
          ad.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "registerLivePlayer:%s", new Object[] { paramBundle.EP() });
          AppMethodBeat.o(195088);
        }
      }
      else
      {
        this.ckQ = false;
        ad.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "registerForBackgroundVOIPIfNeed, not RTC mode");
      }
    }
    AppMethodBeat.o(195088);
  }
  
  public final boolean a(com.tencent.luggage.k.a.a.a.a.a parama, com.tencent.luggage.k.a.a parama1, int paramInt)
  {
    AppMethodBeat.i(195087);
    parama1 = com.tencent.mm.plugin.appbrand.jsapi.aa.b.z(parama1);
    if (parama1 != null) {}
    for (parama1 = (com.tencent.mm.plugin.appbrand.jsapi.aa.c.d)parama1.as(com.tencent.mm.plugin.appbrand.jsapi.aa.c.d.class); parama1 != null; parama1 = null)
    {
      boolean bool = parama1.a(parama, paramInt);
      AppMethodBeat.o(195087);
      return bool;
    }
    ad.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "shouldInterceptEnterBackground, no state manager");
    AppMethodBeat.o(195087);
    return false;
  }
  
  public final void b(com.tencent.luggage.k.a.a.a.a.a parama)
  {
    this.kzC = parama;
  }
  
  public final void gT(int paramInt)
  {
    AppMethodBeat.i(195089);
    ad.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "onXWebLivePlayerEvent, errCode: ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(195089);
      return;
      ad.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart");
      if (this.ckQ)
      {
        ad.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart, mIsRTCMode");
        AppMethodBeat.o(195089);
        return;
      }
      if ((this.kzC == null) || (this.kzD == null))
      {
        ad.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart, mPluginHandler or mInvokeContext is null");
        AppMethodBeat.o(195089);
        return;
      }
      com.tencent.mm.plugin.appbrand.jsapi.aa.a locala = com.tencent.luggage.k.a.a.e.g(this.kzD);
      if (locala == null)
      {
        ad.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart, audioOfVideoBackgroundPlayManager is null");
        AppMethodBeat.o(195089);
        return;
      }
      locala.d(this.kzC);
      AppMethodBeat.o(195089);
      return;
      ad.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop");
      if (this.ckQ)
      {
        ad.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop, isRTCMode");
        AppMethodBeat.o(195089);
        return;
      }
      if ((this.kzC == null) || (this.kzD == null))
      {
        ad.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop, pluginHandler or invokeContext is null");
        AppMethodBeat.o(195089);
        return;
      }
      locala = com.tencent.luggage.k.a.a.e.g(this.kzD);
      if (locala == null)
      {
        ad.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop, audioOfVideoBackgroundPlayManager is null");
        AppMethodBeat.o(195089);
        return;
      }
      locala.e(this.kzC);
    }
  }
  
  public final boolean k(final com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(139484);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      AppMethodBeat.o(139484);
      return false;
    }
    Object localObject = parama.EB();
    com.tencent.mm.plugin.appbrand.jsapi.c localc = ((com.tencent.mm.plugin.appbrand.i.b)parama).joJ;
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
        parama.L(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(139478);
            if ((!parama.isRunning()) || (parama.kWU == null))
            {
              ad.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, invalid state");
              AppMethodBeat.o(139478);
              return;
            }
            com.tencent.mm.plugin.appbrand.s.a.d locald = parama.kWU.getFullscreenImpl();
            View localView = parama.kWU.getWrapperView();
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
  
  public final boolean l(final com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(139485);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      AppMethodBeat.o(139485);
      return false;
    }
    parama = ((com.tencent.mm.plugin.appbrand.i.b)parama).joJ;
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
        parama.L(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(139479);
            if ((!parama.isRunning()) || (parama.kWU == null))
            {
              ad.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "exitFullscreen, invalid state");
              AppMethodBeat.o(139479);
              return;
            }
            com.tencent.mm.plugin.appbrand.s.a.d locald = parama.kWU.getFullscreenImpl();
            if (locald != null)
            {
              locald.aNT();
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
  
  public final void m(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(139488);
    parama = com.tencent.mm.plugin.appbrand.jsapi.aa.b.z(parama);
    if (parama != null)
    {
      parama.iDK.b(this.kzF);
      if (parama != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.aa.c.d locald = (com.tencent.mm.plugin.appbrand.jsapi.aa.c.d)parama.as(com.tencent.mm.plugin.appbrand.jsapi.aa.c.d.class);
        if (locald == null) {
          break label113;
        }
        com.tencent.luggage.k.a.a.a.a.a locala = this.kzC;
        locald.kzB.remove(locala);
        ad.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "unregisterLivePlayer:%s", new Object[] { locala.EP() });
      }
      for (;;)
      {
        ad.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease");
        if (!this.ckQ) {
          break;
        }
        ad.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease, isRTCMode");
        AppMethodBeat.o(139488);
        return;
        label113:
        ad.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "unregisterForBackgroundVOIPIfNeed, no state manager");
      }
      if (this.kzC == null)
      {
        ad.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease, pluginHandler is null");
        AppMethodBeat.o(139488);
        return;
      }
      parama = (com.tencent.mm.plugin.appbrand.jsapi.aa.a)parama.as(com.tencent.mm.plugin.appbrand.jsapi.aa.a.class);
      if (parama == null)
      {
        ad.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease, audioOfVideoBackgroundPlayManager is null");
        AppMethodBeat.o(139488);
        return;
      }
      parama.f(this.kzC);
    }
    AppMethodBeat.o(139488);
  }
  
  public final void n(com.tencent.luggage.k.a.a parama)
  {
    if ((parama instanceof com.tencent.mm.plugin.appbrand.i.b)) {
      this.kzD = ((com.tencent.mm.plugin.appbrand.i.b)parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.c.a.a
 * JD-Core Version:    0.7.0.1
 */