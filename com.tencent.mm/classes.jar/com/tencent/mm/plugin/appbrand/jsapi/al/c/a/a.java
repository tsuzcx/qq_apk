package com.tencent.mm.plugin.appbrand.jsapi.al.c.a;

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
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.vfs.u;
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
  com.tencent.luggage.xweb_ext.extendplugin.component.live.a.b sPH;
  private com.tencent.mm.plugin.appbrand.h.b sPI;
  private boolean sPJ;
  private volatile boolean sPK;
  private c.a sPL;
  
  public a()
  {
    AppMethodBeat.i(139481);
    this.sPJ = false;
    this.sPK = false;
    this.sPL = new c.a()
    {
      public final void onRunningStateChanged(String paramAnonymousString, com.tencent.mm.plugin.appbrand.b.b paramAnonymousb)
      {
        AppMethodBeat.i(139480);
        if (paramAnonymousString.equalsIgnoreCase(a.this.currentAppId)) {
          if (paramAnonymousb == com.tencent.mm.plugin.appbrand.b.b.qKx)
          {
            if (a.this.sPH != null)
            {
              paramAnonymousb = a.this.sPH;
              int i = com.tencent.mm.plugin.appbrand.jsapi.al.b.acG(paramAnonymousString);
              if (paramAnonymousb.eyJ != null) {
                paramAnonymousb.eyJ.post(new b.7(paramAnonymousb, i));
              }
              AppMethodBeat.o(139480);
            }
          }
          else if ((paramAnonymousb == com.tencent.mm.plugin.appbrand.b.b.qKw) && (a.this.sPH != null))
          {
            paramAnonymousString = a.this.sPH;
            if (paramAnonymousString.eyJ != null) {
              paramAnonymousString.eyJ.post(new b.5(paramAnonymousString));
            }
          }
        }
        AppMethodBeat.o(139480);
      }
    };
    AppMethodBeat.o(139481);
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
      parama.fO("fail:snapshot error");
      AppMethodBeat.o(139486);
      return;
    }
    f localf = ((com.tencent.mm.plugin.appbrand.h.b)parama).rot;
    String str = AndroidMediaUtil.getSysCameraDirPath() + String.format(Locale.US, "%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    k localk;
    try
    {
      BitmapUtil.saveBitmapToImage(paramBitmap, 90, Bitmap.CompressFormat.JPEG, str, true);
      localk = new k();
      if (localf.getFileSystem() != null)
      {
        if (localf.getFileSystem().a(new u(str), "jpg", true, localk) == r.qML) {
          break label255;
        }
        Log.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, save snapshot failed");
        parama.fO("fail:snapshot error");
        AppMethodBeat.o(139486);
        return;
      }
    }
    catch (IOException paramBitmap)
    {
      Log.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, save bitmap exception", new Object[] { paramBitmap });
      parama.fO("fail:snapshot error");
      AppMethodBeat.o(139486);
      return;
    }
    parama.fO("fail");
    AppMethodBeat.o(139486);
    return;
    label255:
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Log.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "bitmap recycle " + paramBitmap.toString());
      paramBitmap.recycle();
    }
    Log.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, actualPath:%s path:%s", new Object[] { str, localk.value });
    paramBitmap = new HashMap();
    paramBitmap.put("tempImagePath", localk.value);
    paramBitmap.put("width", Integer.valueOf(i));
    paramBitmap.put("height", Integer.valueOf(j));
    parama.e("ok", paramBitmap);
    AppMethodBeat.o(139486);
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(327158);
    AppBrandRuntime localAppBrandRuntime = com.tencent.mm.plugin.appbrand.jsapi.al.b.z(parama);
    if (localAppBrandRuntime != null)
    {
      this.currentAppId = localAppBrandRuntime.mAppId;
      localAppBrandRuntime.qsB.a(this.sPL);
      if (paramBundle.getBoolean("isVoip", false))
      {
        this.sPJ = true;
        if (localAppBrandRuntime != null)
        {
          paramBundle = (com.tencent.mm.plugin.appbrand.jsapi.al.c.e)localAppBrandRuntime.aO(com.tencent.mm.plugin.appbrand.jsapi.al.c.e.class);
          parama = paramBundle;
          if (paramBundle == null)
          {
            Log.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "registerForBackgroundVOIPIfNeed, no state manager, create one");
            parama = new com.tencent.mm.plugin.appbrand.jsapi.al.c.e();
            localAppBrandRuntime.a(parama);
          }
          paramBundle = this.sPH;
          parama.sPA.add(paramBundle);
          Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "registerLivePlayer:%s", new Object[] { paramBundle.atL() });
          AppMethodBeat.o(327158);
        }
      }
      else
      {
        this.sPJ = false;
        Log.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "registerForBackgroundVOIPIfNeed, not voip mode");
      }
    }
    AppMethodBeat.o(327158);
  }
  
  public final boolean a(com.tencent.luggage.xweb_ext.extendplugin.component.live.a.b paramb, com.tencent.luggage.xweb_ext.extendplugin.a parama, int paramInt)
  {
    AppMethodBeat.i(327140);
    parama = com.tencent.mm.plugin.appbrand.jsapi.al.b.z(parama);
    if (parama != null) {}
    for (parama = (com.tencent.mm.plugin.appbrand.jsapi.al.c.e)parama.aO(com.tencent.mm.plugin.appbrand.jsapi.al.c.e.class); parama != null; parama = null)
    {
      boolean bool = parama.a(paramb, paramInt);
      AppMethodBeat.o(327140);
      return bool;
    }
    Log.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "shouldInterceptEnterBackground, no state manager");
    AppMethodBeat.o(327140);
    return false;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.b aug()
  {
    AppMethodBeat.i(139482);
    b localb = new b();
    AppMethodBeat.o(139482);
    return localb;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.c auh()
  {
    AppMethodBeat.i(139483);
    com.tencent.mm.plugin.appbrand.jsapi.al.c.c localc = new com.tencent.mm.plugin.appbrand.jsapi.al.c.c();
    AppMethodBeat.o(139483);
    return localc;
  }
  
  public final void b(com.tencent.luggage.xweb_ext.extendplugin.component.live.a.b paramb)
  {
    this.sPH = paramb;
  }
  
  public final boolean j(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139484);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(139484);
      return false;
    }
    Object localObject = parama.atw();
    f localf = ((com.tencent.mm.plugin.appbrand.h.b)parama).rot;
    parama = null;
    if ((localf instanceof ad)) {
      parama = (ad)localf;
    }
    while (parama == null)
    {
      Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, page view is null");
      AppMethodBeat.o(139484);
      return false;
      if ((localf instanceof y)) {
        parama = ((y)localf).getCurrentPageView();
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
        parama.V(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(139478);
            if ((!parama.isRunning()) || (parama.tti == null))
            {
              Log.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, invalid state");
              AppMethodBeat.o(139478);
              return;
            }
            d locald = parama.tti.getFullscreenImpl();
            View localView = parama.tti.getWrapperView();
            if ((locald != null) && (localView != null))
            {
              locald.T(localView, i);
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
    parama = ((com.tencent.mm.plugin.appbrand.h.b)parama).rot;
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
        if ((parama instanceof y)) {
          parama = ((y)parama).getCurrentPageView();
        }
      }
      else
      {
        parama.V(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(139479);
            if ((!parama.isRunning()) || (parama.tti == null))
            {
              Log.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "exitFullscreen, invalid state");
              AppMethodBeat.o(139479);
              return;
            }
            d locald = parama.tti.getFullscreenImpl();
            if (locald != null)
            {
              locald.cdL();
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
    parama = com.tencent.mm.plugin.appbrand.jsapi.al.b.z(parama);
    if (parama != null)
    {
      parama.qsB.b(this.sPL);
      if (parama != null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.al.c.e locale = (com.tencent.mm.plugin.appbrand.jsapi.al.c.e)parama.aO(com.tencent.mm.plugin.appbrand.jsapi.al.c.e.class);
        if (locale == null) {
          break label118;
        }
        com.tencent.luggage.xweb_ext.extendplugin.component.live.a.b localb = this.sPH;
        locale.sPA.remove(localb);
        Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "unregisterLivePlayer:%s", new Object[] { localb.atL() });
      }
      Log.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease");
      if (!this.sPJ) {
        break label129;
      }
      Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease, is voip mode");
    }
    for (;;)
    {
      this.sPK = true;
      AppMethodBeat.o(139488);
      return;
      label118:
      Log.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "unregisterForBackgroundVOIPIfNeed, no state manager");
      break;
      label129:
      if (this.sPH == null)
      {
        Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease, pluginHandler is null");
      }
      else
      {
        parama = (com.tencent.mm.plugin.appbrand.jsapi.al.a)parama.aO(com.tencent.mm.plugin.appbrand.jsapi.al.a.class);
        if (parama == null) {
          Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayerRelease, audioOfVideoBackgroundPlayManager is null");
        } else {
          parama.f(this.sPH);
        }
      }
    }
  }
  
  public final void m(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    if ((parama instanceof com.tencent.mm.plugin.appbrand.h.b)) {
      this.sPI = ((com.tencent.mm.plugin.appbrand.h.b)parama);
    }
  }
  
  public final void mD(int paramInt)
  {
    AppMethodBeat.i(327163);
    Log.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "onXWebLivePlayerEvent, errCode: ".concat(String.valueOf(paramInt)));
    if (this.sPK)
    {
      Log.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "onXWebLivePlayerEvent, released");
      AppMethodBeat.o(327163);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(327163);
      return;
      Log.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart");
      if (this.sPJ)
      {
        Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart, is voip mode");
        AppMethodBeat.o(327163);
        return;
      }
      if ((this.sPH == null) || (this.sPI == null))
      {
        Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart, mPluginHandler or mInvokeContext is null");
        AppMethodBeat.o(327163);
        return;
      }
      com.tencent.mm.plugin.appbrand.jsapi.al.a locala = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(this.sPI);
      if (locala == null)
      {
        Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayStart, audioOfVideoBackgroundPlayManager is null");
        AppMethodBeat.o(327163);
        return;
      }
      locala.d(this.sPH);
      AppMethodBeat.o(327163);
      return;
      Log.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop");
      if (this.sPJ)
      {
        Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop, is voip mode");
        AppMethodBeat.o(327163);
        return;
      }
      if ((this.sPH == null) || (this.sPI == null))
      {
        Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop, pluginHandler or invokeContext is null");
        AppMethodBeat.o(327163);
        return;
      }
      locala = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(this.sPI);
      if (locala == null)
      {
        Log.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "markVideoPlayPauseOrStop, audioOfVideoBackgroundPlayManager is null");
        AppMethodBeat.o(327163);
        return;
      }
      locala.e(this.sPH);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.c.a.a
 * JD-Core Version:    0.7.0.1
 */