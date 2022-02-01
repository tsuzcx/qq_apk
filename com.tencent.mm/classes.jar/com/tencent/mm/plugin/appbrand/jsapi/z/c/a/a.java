package com.tencent.mm.plugin.appbrand.jsapi.z.c.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.tencent.luggage.k.a.a.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ay;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.z.i;
import com.tencent.mm.sdk.platformtools.ac;
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
  private boolean chS;
  com.tencent.luggage.k.a.a.a.a.a laT;
  private com.tencent.mm.plugin.appbrand.i.b laU;
  String laV;
  private c.a laW;
  
  public a()
  {
    AppMethodBeat.i(139481);
    this.chS = false;
    this.laW = new c.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.b.b paramAnonymousb)
      {
        AppMethodBeat.i(139480);
        if (paramAnonymousString.equalsIgnoreCase(a.this.laV)) {
          if (paramAnonymousb == com.tencent.mm.plugin.appbrand.b.b.jqV)
          {
            if (a.this.laT != null)
            {
              paramAnonymousb = a.this.laT;
              int i = com.tencent.mm.plugin.appbrand.jsapi.z.b.NY(paramAnonymousString);
              if (paramAnonymousb.chE != null) {
                paramAnonymousb.chE.post(new com.tencent.luggage.k.a.a.a.a.a.3(paramAnonymousb, i));
              }
              AppMethodBeat.o(139480);
            }
          }
          else if ((paramAnonymousb == com.tencent.mm.plugin.appbrand.b.b.jqU) && (a.this.laT != null))
          {
            paramAnonymousString = a.this.laT;
            if (paramAnonymousString.chE != null) {
              paramAnonymousString.chE.post(new com.tencent.luggage.k.a.a.a.a.a.2(paramAnonymousString));
            }
          }
        }
        AppMethodBeat.o(139480);
      }
    };
    AppMethodBeat.o(139481);
  }
  
  public final com.tencent.luggage.k.a.a.a.a.a.b EQ()
  {
    AppMethodBeat.i(139482);
    b localb = new b();
    AppMethodBeat.o(139482);
    return localb;
  }
  
  public final com.tencent.luggage.k.a.a.a.a.a.c ER()
  {
    AppMethodBeat.i(139483);
    com.tencent.mm.plugin.appbrand.jsapi.z.c.c localc = new com.tencent.mm.plugin.appbrand.jsapi.z.c.c();
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
      ac.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, bitmap is null");
      parama.cs("fail:snapshot error");
      AppMethodBeat.o(139486);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.c localc = ((com.tencent.mm.plugin.appbrand.i.b)parama).jOV;
    String str = com.tencent.mm.loader.j.b.aps() + String.format(Locale.US, "%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    i locali;
    try
    {
      f.a(paramBitmap, 90, Bitmap.CompressFormat.JPEG, str, true);
      locali = new i();
      if (localc.DH() != null)
      {
        if (localc.DH().a(new com.tencent.mm.vfs.e(str), "jpg", true, locali) == l.jsB) {
          break label255;
        }
        ac.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, save snapshot failed");
        parama.cs("fail:snapshot error");
        AppMethodBeat.o(139486);
        return;
      }
    }
    catch (IOException paramBitmap)
    {
      ac.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, save bitmap exception", new Object[] { paramBitmap });
      parama.cs("fail:snapshot error");
      AppMethodBeat.o(139486);
      return;
    }
    parama.cs("fail");
    AppMethodBeat.o(139486);
    return;
    label255:
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      ac.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "bitmap recycle " + paramBitmap.toString());
      paramBitmap.recycle();
    }
    ac.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, actualPath:%s path:%s", new Object[] { str, locali.value });
    paramBitmap = new HashMap();
    paramBitmap.put("tempImagePath", locali.value);
    paramBitmap.put("width", Integer.valueOf(i));
    paramBitmap.put("height", Integer.valueOf(j));
    parama.d("ok", paramBitmap);
    AppMethodBeat.o(139486);
  }
  
  public final void a(com.tencent.luggage.k.a.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(206731);
    AppBrandRuntime localAppBrandRuntime = com.tencent.mm.plugin.appbrand.jsapi.z.b.y(parama);
    if (localAppBrandRuntime != null)
    {
      this.laV = localAppBrandRuntime.mAppId;
      localAppBrandRuntime.jdK.a(this.laW);
      if (paramBundle.getInt("mode", 0) == 2)
      {
        this.chS = true;
        if (localAppBrandRuntime != null)
        {
          paramBundle = (com.tencent.mm.plugin.appbrand.jsapi.z.c.d)localAppBrandRuntime.as(com.tencent.mm.plugin.appbrand.jsapi.z.c.d.class);
          parama = paramBundle;
          if (paramBundle == null)
          {
            ac.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "registerForBackgroundVOIPIfNeed, no state manager, create one");
            parama = new com.tencent.mm.plugin.appbrand.jsapi.z.c.d();
            localAppBrandRuntime.a(parama);
          }
          paramBundle = this.laT;
          parama.laS.add(paramBundle);
          ac.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "registerLivePlayer:%s", new Object[] { paramBundle.Et() });
          AppMethodBeat.o(206731);
        }
      }
      else
      {
        this.chS = false;
        ac.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "registerForBackgroundVOIPIfNeed, not RTC mode");
      }
    }
    AppMethodBeat.o(206731);
  }
  
  public final boolean a(com.tencent.luggage.k.a.a.a.a.a parama, com.tencent.luggage.k.a.a parama1, int paramInt)
  {
    AppMethodBeat.i(206730);
    parama1 = com.tencent.mm.plugin.appbrand.jsapi.z.b.y(parama1);
    if (parama1 != null) {}
    for (parama1 = (com.tencent.mm.plugin.appbrand.jsapi.z.c.d)parama1.as(com.tencent.mm.plugin.appbrand.jsapi.z.c.d.class); parama1 != null; parama1 = null)
    {
      boolean bool = parama1.a(parama, paramInt);
      AppMethodBeat.o(206730);
      return bool;
    }
    ac.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "shouldInterceptEnterBackground, no state manager");
    AppMethodBeat.o(206730);
    return false;
  }
  
  public final void b(com.tencent.luggage.k.a.a.a.a.a parama)
  {
    this.laT = parama;
  }
  
  public final void gD(int paramInt)
  {
    AppMethodBeat.i(206732);
    ac.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "onXWebLivePlayerEvent, errCode: ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(206732);
      return;
      ac.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart");
      if (this.chS)
      {
        ac.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart, mIsRTCMode");
        AppMethodBeat.o(206732);
        return;
      }
      if ((this.laT == null) || (this.laU == null))
      {
        ac.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart, mPluginHandler or mInvokeContext is null");
        AppMethodBeat.o(206732);
        return;
      }
      com.tencent.mm.plugin.appbrand.jsapi.z.a locala = com.tencent.luggage.k.a.a.e.f(this.laU);
      if (locala == null)
      {
        ac.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart, audioOfVideoBackgroundPlayManager is null");
        AppMethodBeat.o(206732);
        return;
      }
      locala.d(this.laT);
      AppMethodBeat.o(206732);
      return;
      ac.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop");
      if (this.chS)
      {
        ac.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop, isRTCMode");
        AppMethodBeat.o(206732);
        return;
      }
      if ((this.laT == null) || (this.laU == null))
      {
        ac.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop, pluginHandler or invokeContext is null");
        AppMethodBeat.o(206732);
        return;
      }
      locala = com.tencent.luggage.k.a.a.e.f(this.laU);
      if (locala == null)
      {
        ac.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop, audioOfVideoBackgroundPlayManager is null");
        AppMethodBeat.o(206732);
        return;
      }
      locala.e(this.laT);
    }
  }
  
  public final boolean j(final com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(139484);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      AppMethodBeat.o(139484);
      return false;
    }
    Object localObject = parama.Ee();
    com.tencent.mm.plugin.appbrand.jsapi.c localc = ((com.tencent.mm.plugin.appbrand.i.b)parama).jOV;
    parama = null;
    if ((localc instanceof aa)) {
      parama = (aa)localc;
    }
    while (parama == null)
    {
      ac.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, page view is null");
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
        ac.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, data array is null");
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
        parama.N(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(139478);
            if ((!parama.isRunning()) || (parama.lyE == null))
            {
              ac.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, invalid state");
              AppMethodBeat.o(139478);
              return;
            }
            com.tencent.mm.plugin.appbrand.r.a.d locald = parama.lyE.getFullscreenImpl();
            View localView = parama.lyE.getWrapperView();
            if ((locald != null) && (localView != null))
            {
              locald.O(localView, i);
              ac.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, target orientation:%s", new Object[] { Integer.valueOf(i) });
              AppMethodBeat.o(139478);
              return;
            }
            ac.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, state error, FullscreenImp[%s], fullscreenWebView[%s]", new Object[] { locald, localView });
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
  
  public final boolean k(final com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(139485);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      AppMethodBeat.o(139485);
      return false;
    }
    parama = ((com.tencent.mm.plugin.appbrand.i.b)parama).jOV;
    if ((parama instanceof aa)) {
      parama = (aa)parama;
    }
    for (;;)
    {
      if (parama == null)
      {
        ac.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "exitFullscreen, page view is null");
        AppMethodBeat.o(139485);
        return false;
        if ((parama instanceof q)) {
          parama = ((q)parama).getCurrentPageView();
        }
      }
      else
      {
        parama.N(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(139479);
            if ((!parama.isRunning()) || (parama.lyE == null))
            {
              ac.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "exitFullscreen, invalid state");
              AppMethodBeat.o(139479);
              return;
            }
            com.tencent.mm.plugin.appbrand.r.a.d locald = parama.lyE.getFullscreenImpl();
            if (locald != null)
            {
              locald.aUJ();
              ac.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "exitFullscreen");
              AppMethodBeat.o(139479);
              return;
            }
            ac.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "exitFullscreen, state error");
            AppMethodBeat.o(139479);
          }
        });
        AppMethodBeat.o(139485);
        return true;
      }
      parama = null;
    }
  }
  
  public final void l(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(139488);
    parama = com.tencent.mm.plugin.appbrand.jsapi.z.b.y(parama);
    if (parama != null)
    {
      parama.jdK.b(this.laW);
      if (parama != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.z.c.d locald = (com.tencent.mm.plugin.appbrand.jsapi.z.c.d)parama.as(com.tencent.mm.plugin.appbrand.jsapi.z.c.d.class);
        if (locald == null) {
          break label113;
        }
        com.tencent.luggage.k.a.a.a.a.a locala = this.laT;
        locald.laS.remove(locala);
        ac.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "unregisterLivePlayer:%s", new Object[] { locala.Et() });
      }
      for (;;)
      {
        ac.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease");
        if (!this.chS) {
          break;
        }
        ac.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease, isRTCMode");
        AppMethodBeat.o(139488);
        return;
        label113:
        ac.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "unregisterForBackgroundVOIPIfNeed, no state manager");
      }
      if (this.laT == null)
      {
        ac.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease, pluginHandler is null");
        AppMethodBeat.o(139488);
        return;
      }
      parama = (com.tencent.mm.plugin.appbrand.jsapi.z.a)parama.as(com.tencent.mm.plugin.appbrand.jsapi.z.a.class);
      if (parama == null)
      {
        ac.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease, audioOfVideoBackgroundPlayManager is null");
        AppMethodBeat.o(139488);
        return;
      }
      parama.f(this.laT);
    }
    AppMethodBeat.o(139488);
  }
  
  public final void m(com.tencent.luggage.k.a.a parama)
  {
    if ((parama instanceof com.tencent.mm.plugin.appbrand.i.b)) {
      this.laU = ((com.tencent.mm.plugin.appbrand.i.b)parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.c.a.a
 * JD-Core Version:    0.7.0.1
 */