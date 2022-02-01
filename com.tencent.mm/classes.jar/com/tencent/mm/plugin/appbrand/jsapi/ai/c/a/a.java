package com.tencent.mm.plugin.appbrand.jsapi.ai.c.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.a.b.5;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.a.b.7;
import com.tencent.luggage.xweb_ext.extendplugin.component.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.vfs.q;
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
  com.tencent.luggage.xweb_ext.extendplugin.component.live.a.b pKO;
  private com.tencent.mm.plugin.appbrand.h.b pKP;
  private boolean pKQ;
  private volatile boolean pKR;
  private c.a pKS;
  
  public a()
  {
    AppMethodBeat.i(139481);
    this.pKQ = false;
    this.pKR = false;
    this.pKS = new c.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.a.b paramAnonymousb)
      {
        AppMethodBeat.i(139480);
        if (paramAnonymousString.equalsIgnoreCase(a.this.currentAppId)) {
          if (paramAnonymousb == com.tencent.mm.plugin.appbrand.a.b.nKQ)
          {
            if (a.this.pKO != null)
            {
              paramAnonymousb = a.this.pKO;
              int i = com.tencent.mm.plugin.appbrand.jsapi.ai.b.ajG(paramAnonymousString);
              if (paramAnonymousb.cFv != null) {
                paramAnonymousb.cFv.post(new b.7(paramAnonymousb, i));
              }
              AppMethodBeat.o(139480);
            }
          }
          else if ((paramAnonymousb == com.tencent.mm.plugin.appbrand.a.b.nKP) && (a.this.pKO != null))
          {
            paramAnonymousString = a.this.pKO;
            if (paramAnonymousString.cFv != null) {
              paramAnonymousString.cFv.post(new b.5(paramAnonymousString));
            }
          }
        }
        AppMethodBeat.o(139480);
      }
    };
    AppMethodBeat.o(139481);
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.b TB()
  {
    AppMethodBeat.i(139482);
    b localb = new b();
    AppMethodBeat.o(139482);
    return localb;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.c TC()
  {
    AppMethodBeat.i(139483);
    com.tencent.mm.plugin.appbrand.jsapi.ai.c.c localc = new com.tencent.mm.plugin.appbrand.jsapi.ai.c.c();
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
      parama.er("fail:snapshot error");
      AppMethodBeat.o(139486);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.e locale = ((com.tencent.mm.plugin.appbrand.h.b)parama).okQ;
    String str = AndroidMediaUtil.getSysCameraDirPath() + String.format(Locale.US, "%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    i locali;
    try
    {
      BitmapUtil.saveBitmapToImage(paramBitmap, 90, Bitmap.CompressFormat.JPEG, str, true);
      locali = new i();
      if (locale.getFileSystem() != null)
      {
        if (locale.getFileSystem().a(new q(str), "jpg", true, locali) == m.nMR) {
          break label255;
        }
        Log.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, save snapshot failed");
        parama.er("fail:snapshot error");
        AppMethodBeat.o(139486);
        return;
      }
    }
    catch (IOException paramBitmap)
    {
      Log.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, save bitmap exception", new Object[] { paramBitmap });
      parama.er("fail:snapshot error");
      AppMethodBeat.o(139486);
      return;
    }
    parama.er("fail");
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
    parama.e("ok", paramBitmap);
    AppMethodBeat.o(139486);
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(228703);
    AppBrandRuntime localAppBrandRuntime = com.tencent.mm.plugin.appbrand.jsapi.ai.b.z(parama);
    if (localAppBrandRuntime != null)
    {
      this.currentAppId = localAppBrandRuntime.mAppId;
      localAppBrandRuntime.ntR.a(this.pKS);
      if (paramBundle.getBoolean("isVoip", false))
      {
        this.pKQ = true;
        if (localAppBrandRuntime != null)
        {
          paramBundle = (com.tencent.mm.plugin.appbrand.jsapi.ai.c.e)localAppBrandRuntime.av(com.tencent.mm.plugin.appbrand.jsapi.ai.c.e.class);
          parama = paramBundle;
          if (paramBundle == null)
          {
            Log.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "registerForBackgroundVOIPIfNeed, no state manager, create one");
            parama = new com.tencent.mm.plugin.appbrand.jsapi.ai.c.e();
            localAppBrandRuntime.a(parama);
          }
          paramBundle = this.pKO;
          parama.pKH.add(paramBundle);
          Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "registerLivePlayer:%s", new Object[] { paramBundle.Tg() });
          AppMethodBeat.o(228703);
        }
      }
      else
      {
        this.pKQ = false;
        Log.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "registerForBackgroundVOIPIfNeed, not voip mode");
      }
    }
    AppMethodBeat.o(228703);
  }
  
  public final boolean a(com.tencent.luggage.xweb_ext.extendplugin.component.live.a.b paramb, com.tencent.luggage.xweb_ext.extendplugin.a parama, int paramInt)
  {
    AppMethodBeat.i(228656);
    parama = com.tencent.mm.plugin.appbrand.jsapi.ai.b.z(parama);
    if (parama != null) {}
    for (parama = (com.tencent.mm.plugin.appbrand.jsapi.ai.c.e)parama.av(com.tencent.mm.plugin.appbrand.jsapi.ai.c.e.class); parama != null; parama = null)
    {
      boolean bool = parama.a(paramb, paramInt);
      AppMethodBeat.o(228656);
      return bool;
    }
    Log.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "shouldInterceptEnterBackground, no state manager");
    AppMethodBeat.o(228656);
    return false;
  }
  
  public final void b(com.tencent.luggage.xweb_ext.extendplugin.component.live.a.b paramb)
  {
    this.pKO = paramb;
  }
  
  public final boolean j(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139484);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(139484);
      return false;
    }
    Object localObject = parama.SR();
    com.tencent.mm.plugin.appbrand.jsapi.e locale = ((com.tencent.mm.plugin.appbrand.h.b)parama).okQ;
    parama = null;
    if ((locale instanceof ad)) {
      parama = (ad)locale;
    }
    while (parama == null)
    {
      Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, page view is null");
      AppMethodBeat.o(139484);
      return false;
      if ((locale instanceof v)) {
        parama = ((v)locale).getCurrentPageView();
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
            if ((!parama.isRunning()) || (parama.qoF == null))
            {
              Log.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, invalid state");
              AppMethodBeat.o(139478);
              return;
            }
            d locald = parama.qoF.getFullscreenImpl();
            View localView = parama.qoF.getWrapperView();
            if ((locald != null) && (localView != null))
            {
              locald.O(localView, i);
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
  
  public final void jb(int paramInt)
  {
    AppMethodBeat.i(228712);
    Log.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "onXWebLivePlayerEvent, errCode: ".concat(String.valueOf(paramInt)));
    if (this.pKR)
    {
      Log.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "onXWebLivePlayerEvent, released");
      AppMethodBeat.o(228712);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(228712);
      return;
      Log.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart");
      if (this.pKQ)
      {
        Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart, is voip mode");
        AppMethodBeat.o(228712);
        return;
      }
      if ((this.pKO == null) || (this.pKP == null))
      {
        Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart, mPluginHandler or mInvokeContext is null");
        AppMethodBeat.o(228712);
        return;
      }
      com.tencent.mm.plugin.appbrand.jsapi.ai.a locala = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(this.pKP);
      if (locala == null)
      {
        Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart, audioOfVideoBackgroundPlayManager is null");
        AppMethodBeat.o(228712);
        return;
      }
      locala.d(this.pKO);
      AppMethodBeat.o(228712);
      return;
      Log.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop");
      if (this.pKQ)
      {
        Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop, is voip mode");
        AppMethodBeat.o(228712);
        return;
      }
      if ((this.pKO == null) || (this.pKP == null))
      {
        Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop, pluginHandler or invokeContext is null");
        AppMethodBeat.o(228712);
        return;
      }
      locala = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(this.pKP);
      if (locala == null)
      {
        Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop, audioOfVideoBackgroundPlayManager is null");
        AppMethodBeat.o(228712);
        return;
      }
      locala.e(this.pKO);
    }
  }
  
  public final boolean k(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139485);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(139485);
      return false;
    }
    parama = ((com.tencent.mm.plugin.appbrand.h.b)parama).okQ;
    if ((parama instanceof ad)) {
      parama = (ad)parama;
    }
    for (;;)
    {
      if (parama == null)
      {
        Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "exitFullscreen, page view is null");
        AppMethodBeat.o(139485);
        return false;
        if ((parama instanceof v)) {
          parama = ((v)parama).getCurrentPageView();
        }
      }
      else
      {
        parama.P(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(139479);
            if ((!parama.isRunning()) || (parama.qoF == null))
            {
              Log.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "exitFullscreen, invalid state");
              AppMethodBeat.o(139479);
              return;
            }
            d locald = parama.qoF.getFullscreenImpl();
            if (locald != null)
            {
              locald.bEz();
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
    parama = com.tencent.mm.plugin.appbrand.jsapi.ai.b.z(parama);
    if (parama != null)
    {
      parama.ntR.b(this.pKS);
      if (parama != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.ai.c.e locale = (com.tencent.mm.plugin.appbrand.jsapi.ai.c.e)parama.av(com.tencent.mm.plugin.appbrand.jsapi.ai.c.e.class);
        if (locale == null) {
          break label118;
        }
        com.tencent.luggage.xweb_ext.extendplugin.component.live.a.b localb = this.pKO;
        locale.pKH.remove(localb);
        Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "unregisterLivePlayer:%s", new Object[] { localb.Tg() });
      }
      Log.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease");
      if (!this.pKQ) {
        break label129;
      }
      Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease, is voip mode");
    }
    for (;;)
    {
      this.pKR = true;
      AppMethodBeat.o(139488);
      return;
      label118:
      Log.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "unregisterForBackgroundVOIPIfNeed, no state manager");
      break;
      label129:
      if (this.pKO == null)
      {
        Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease, pluginHandler is null");
      }
      else
      {
        parama = (com.tencent.mm.plugin.appbrand.jsapi.ai.a)parama.av(com.tencent.mm.plugin.appbrand.jsapi.ai.a.class);
        if (parama == null) {
          Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease, audioOfVideoBackgroundPlayManager is null");
        } else {
          parama.f(this.pKO);
        }
      }
    }
  }
  
  public final void m(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    if ((parama instanceof com.tencent.mm.plugin.appbrand.h.b)) {
      this.pKP = ((com.tencent.mm.plugin.appbrand.h.b)parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.c.a.a
 * JD-Core Version:    0.7.0.1
 */