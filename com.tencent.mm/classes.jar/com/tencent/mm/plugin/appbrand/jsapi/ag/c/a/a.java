package com.tencent.mm.plugin.appbrand.jsapi.ag.c.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.5;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.7;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
  implements com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.a
{
  String currentAppId;
  com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a mJW;
  private com.tencent.mm.plugin.appbrand.h.b mJX;
  private boolean mJY;
  private volatile boolean mJZ;
  private c.a mKa;
  
  public a()
  {
    AppMethodBeat.i(139481);
    this.mJY = false;
    this.mJZ = false;
    this.mKa = new c.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.a.b paramAnonymousb)
      {
        AppMethodBeat.i(139480);
        if (paramAnonymousString.equalsIgnoreCase(a.this.currentAppId)) {
          if (paramAnonymousb == com.tencent.mm.plugin.appbrand.a.b.kQI)
          {
            if (a.this.mJW != null)
            {
              paramAnonymousb = a.this.mJW;
              int i = com.tencent.mm.plugin.appbrand.jsapi.ag.b.abL(paramAnonymousString);
              if (paramAnonymousb.cEP != null) {
                paramAnonymousb.cEP.post(new a.7(paramAnonymousb, i));
              }
              AppMethodBeat.o(139480);
            }
          }
          else if ((paramAnonymousb == com.tencent.mm.plugin.appbrand.a.b.kQH) && (a.this.mJW != null))
          {
            paramAnonymousString = a.this.mJW;
            if (paramAnonymousString.cEP != null) {
              paramAnonymousString.cEP.post(new a.5(paramAnonymousString));
            }
          }
        }
        AppMethodBeat.o(139480);
      }
    };
    AppMethodBeat.o(139481);
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.b Qa()
  {
    AppMethodBeat.i(139482);
    b localb = new b();
    AppMethodBeat.o(139482);
    return localb;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.c Qb()
  {
    AppMethodBeat.i(139483);
    com.tencent.mm.plugin.appbrand.jsapi.ag.c.c localc = new com.tencent.mm.plugin.appbrand.jsapi.ag.c.c();
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
      Log.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, bitmap is null");
      parama.dP("fail:snapshot error");
      AppMethodBeat.o(139486);
      return;
    }
    f localf = ((com.tencent.mm.plugin.appbrand.h.b)parama).lqg;
    String str = AndroidMediaUtil.getSysCameraDirPath() + String.format(Locale.US, "%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    i locali;
    try
    {
      BitmapUtil.saveBitmapToImage(paramBitmap, 90, Bitmap.CompressFormat.JPEG, str, true);
      locali = new i();
      if (localf.getFileSystem() != null)
      {
        if (localf.getFileSystem().a(new com.tencent.mm.vfs.o(str), "jpg", true, locali) == m.kSu) {
          break label255;
        }
        Log.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, save snapshot failed");
        parama.dP("fail:snapshot error");
        AppMethodBeat.o(139486);
        return;
      }
    }
    catch (IOException paramBitmap)
    {
      Log.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, save bitmap exception", new Object[] { paramBitmap });
      parama.dP("fail:snapshot error");
      AppMethodBeat.o(139486);
      return;
    }
    parama.dP("fail");
    AppMethodBeat.o(139486);
    return;
    label255:
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Log.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "bitmap recycle " + paramBitmap.toString());
      paramBitmap.recycle();
    }
    Log.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, actualPath:%s path:%s", new Object[] { str, locali.value });
    paramBitmap = new HashMap();
    paramBitmap.put("tempImagePath", locali.value);
    paramBitmap.put("width", Integer.valueOf(i));
    paramBitmap.put("height", Integer.valueOf(j));
    parama.f("ok", paramBitmap);
    AppMethodBeat.o(139486);
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(215861);
    AppBrandRuntime localAppBrandRuntime = com.tencent.mm.plugin.appbrand.jsapi.ag.b.y(parama);
    if (localAppBrandRuntime != null)
    {
      this.currentAppId = localAppBrandRuntime.mAppId;
      localAppBrandRuntime.kAH.a(this.mKa);
      if (paramBundle.getBoolean("isVoip", false))
      {
        this.mJY = true;
        if (localAppBrandRuntime != null)
        {
          paramBundle = (com.tencent.mm.plugin.appbrand.jsapi.ag.c.e)localAppBrandRuntime.aw(com.tencent.mm.plugin.appbrand.jsapi.ag.c.e.class);
          parama = paramBundle;
          if (paramBundle == null)
          {
            Log.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "registerForBackgroundVOIPIfNeed, no state manager, create one");
            parama = new com.tencent.mm.plugin.appbrand.jsapi.ag.c.e();
            localAppBrandRuntime.a(parama);
          }
          paramBundle = this.mJW;
          parama.mJP.add(paramBundle);
          Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "registerLivePlayer:%s", new Object[] { paramBundle.PH() });
          AppMethodBeat.o(215861);
        }
      }
      else
      {
        this.mJY = false;
        Log.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "registerForBackgroundVOIPIfNeed, not voip mode");
      }
    }
    AppMethodBeat.o(215861);
  }
  
  public final boolean a(com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a parama, com.tencent.luggage.xweb_ext.extendplugin.a parama1, int paramInt)
  {
    AppMethodBeat.i(215860);
    parama1 = com.tencent.mm.plugin.appbrand.jsapi.ag.b.y(parama1);
    if (parama1 != null) {}
    for (parama1 = (com.tencent.mm.plugin.appbrand.jsapi.ag.c.e)parama1.aw(com.tencent.mm.plugin.appbrand.jsapi.ag.c.e.class); parama1 != null; parama1 = null)
    {
      boolean bool = parama1.a(parama, paramInt);
      AppMethodBeat.o(215860);
      return bool;
    }
    Log.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "shouldInterceptEnterBackground, no state manager");
    AppMethodBeat.o(215860);
    return false;
  }
  
  public final void b(com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a parama)
  {
    this.mJW = parama;
  }
  
  public final void hY(int paramInt)
  {
    AppMethodBeat.i(215862);
    Log.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "onXWebLivePlayerEvent, errCode: ".concat(String.valueOf(paramInt)));
    if (this.mJZ)
    {
      Log.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "onXWebLivePlayerEvent, released");
      AppMethodBeat.o(215862);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(215862);
      return;
      Log.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart");
      if (this.mJY)
      {
        Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart, is voip mode");
        AppMethodBeat.o(215862);
        return;
      }
      if ((this.mJW == null) || (this.mJX == null))
      {
        Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart, mPluginHandler or mInvokeContext is null");
        AppMethodBeat.o(215862);
        return;
      }
      com.tencent.mm.plugin.appbrand.jsapi.ag.a locala = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(this.mJX);
      if (locala == null)
      {
        Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart, audioOfVideoBackgroundPlayManager is null");
        AppMethodBeat.o(215862);
        return;
      }
      locala.d(this.mJW);
      AppMethodBeat.o(215862);
      return;
      Log.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop");
      if (this.mJY)
      {
        Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop, is voip mode");
        AppMethodBeat.o(215862);
        return;
      }
      if ((this.mJW == null) || (this.mJX == null))
      {
        Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop, pluginHandler or invokeContext is null");
        AppMethodBeat.o(215862);
        return;
      }
      locala = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(this.mJX);
      if (locala == null)
      {
        Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop, audioOfVideoBackgroundPlayManager is null");
        AppMethodBeat.o(215862);
        return;
      }
      locala.e(this.mJW);
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
    Object localObject = parama.Ps();
    f localf = ((com.tencent.mm.plugin.appbrand.h.b)parama).lqg;
    parama = null;
    if ((localf instanceof ac)) {
      parama = (ac)localf;
    }
    while (parama == null)
    {
      Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, page view is null");
      AppMethodBeat.o(139484);
      return false;
      if ((localf instanceof s)) {
        parama = ((s)localf).getCurrentPageView();
      }
    }
    if ((localObject != null) && (((JSONObject)localObject).has("data")))
    {
      localObject = ((JSONObject)localObject).optJSONArray("data");
      if ((localObject == null) || (((JSONArray)localObject).length() == 0))
      {
        Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, data array is null");
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
        parama.P(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(139478);
            if ((!parama.isRunning()) || (parama.nmX == null))
            {
              Log.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, invalid state");
              AppMethodBeat.o(139478);
              return;
            }
            d locald = parama.nmX.getFullscreenImpl();
            View localView = parama.nmX.getWrapperView();
            if ((locald != null) && (localView != null))
            {
              locald.N(localView, i);
              Log.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, target orientation:%s", new Object[] { Integer.valueOf(i) });
              AppMethodBeat.o(139478);
              return;
            }
            Log.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, state error, FullscreenImp[%s], fullscreenWebView[%s]", new Object[] { locald, localView });
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
    parama = ((com.tencent.mm.plugin.appbrand.h.b)parama).lqg;
    if ((parama instanceof ac)) {
      parama = (ac)parama;
    }
    for (;;)
    {
      if (parama == null)
      {
        Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "exitFullscreen, page view is null");
        AppMethodBeat.o(139485);
        return false;
        if ((parama instanceof s)) {
          parama = ((s)parama).getCurrentPageView();
        }
      }
      else
      {
        parama.P(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(139479);
            if ((!parama.isRunning()) || (parama.nmX == null))
            {
              Log.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "exitFullscreen, invalid state");
              AppMethodBeat.o(139479);
              return;
            }
            d locald = parama.nmX.getFullscreenImpl();
            if (locald != null)
            {
              locald.btC();
              Log.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "exitFullscreen");
              AppMethodBeat.o(139479);
              return;
            }
            Log.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "exitFullscreen, state error");
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
    parama = com.tencent.mm.plugin.appbrand.jsapi.ag.b.y(parama);
    if (parama != null)
    {
      parama.kAH.b(this.mKa);
      if (parama != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.ag.c.e locale = (com.tencent.mm.plugin.appbrand.jsapi.ag.c.e)parama.aw(com.tencent.mm.plugin.appbrand.jsapi.ag.c.e.class);
        if (locale == null) {
          break label118;
        }
        com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a locala = this.mJW;
        locale.mJP.remove(locala);
        Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "unregisterLivePlayer:%s", new Object[] { locala.PH() });
      }
      Log.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease");
      if (!this.mJY) {
        break label129;
      }
      Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease, is voip mode");
    }
    for (;;)
    {
      this.mJZ = true;
      AppMethodBeat.o(139488);
      return;
      label118:
      Log.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "unregisterForBackgroundVOIPIfNeed, no state manager");
      break;
      label129:
      if (this.mJW == null)
      {
        Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease, pluginHandler is null");
      }
      else
      {
        parama = (com.tencent.mm.plugin.appbrand.jsapi.ag.a)parama.aw(com.tencent.mm.plugin.appbrand.jsapi.ag.a.class);
        if (parama == null) {
          Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease, audioOfVideoBackgroundPlayManager is null");
        } else {
          parama.f(this.mJW);
        }
      }
    }
  }
  
  public final void m(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    if ((parama instanceof com.tencent.mm.plugin.appbrand.h.b)) {
      this.mJX = ((com.tencent.mm.plugin.appbrand.h.b)parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a
 * JD-Core Version:    0.7.0.1
 */