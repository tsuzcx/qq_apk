package com.tencent.mm.plugin.appbrand.jsapi.al.c.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.tencent.luggage.xweb_ext.extendplugin.component.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.jsapi.al.c.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.al.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.capsulebar.m.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class a
  implements com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a
{
  private volatile boolean mIsPushing = false;
  private AppBrandRuntime qwG = null;
  private m.a rDP = null;
  private boolean sPV = false;
  private boolean sPy = true;
  
  private static e A(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(327128);
    parama = com.tencent.mm.plugin.appbrand.jsapi.al.b.z(parama);
    if (parama != null)
    {
      parama = (e)parama.aO(e.class);
      AppMethodBeat.o(327128);
      return parama;
    }
    AppMethodBeat.o(327128);
    return null;
  }
  
  private void cyK()
  {
    AppMethodBeat.i(327131);
    if ((this.mIsPushing) && (this.sPy))
    {
      cyL();
      AppMethodBeat.o(327131);
      return;
    }
    cyM();
    AppMethodBeat.o(327131);
  }
  
  private void cyL()
  {
    AppMethodBeat.i(327133);
    if (this.rDP != null)
    {
      Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "blinkCapsuleBar, already blink");
      AppMethodBeat.o(327133);
      return;
    }
    if (this.qwG != null)
    {
      Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "blinkCapsuleBar");
      this.rDP = com.tencent.mm.plugin.appbrand.page.capsulebar.a.a.av(this.qwG).a(com.tencent.mm.plugin.appbrand.page.capsulebar.a.b.tBL);
    }
    AppMethodBeat.o(327133);
  }
  
  private void cyM()
  {
    AppMethodBeat.i(327134);
    if (this.rDP != null)
    {
      Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "dismissBlink");
      this.rDP.dismiss();
      this.rDP = null;
    }
    AppMethodBeat.o(327134);
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, Bitmap paramBitmap)
  {
    AppMethodBeat.i(139519);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(139519);
      return;
    }
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      Log.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, bitmap is null");
      parama.fO("fail:snapshot error");
      AppMethodBeat.o(139519);
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
        if (localf.getFileSystem().a(new u(str), "jpg", true, localk) == com.tencent.mm.plugin.appbrand.appstorage.r.qML) {
          break label255;
        }
        Log.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, save snapshot failed");
        parama.fO("fail:snapshot error");
        AppMethodBeat.o(139519);
        return;
      }
    }
    catch (IOException paramBitmap)
    {
      Log.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, save bitmap exception", new Object[] { paramBitmap });
      parama.fO("fail:snapshot error");
      AppMethodBeat.o(139519);
      return;
    }
    parama.fO("fail");
    AppMethodBeat.o(139519);
    return;
    label255:
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Log.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "bitmap recycle " + paramBitmap.toString());
      paramBitmap.recycle();
    }
    Log.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, actualPath:%s path:%s", new Object[] { str, localk.value });
    paramBitmap = new HashMap();
    paramBitmap.put("tempImagePath", localk.value);
    paramBitmap.put("width", Integer.valueOf(i));
    paramBitmap.put("height", Integer.valueOf(j));
    parama.e("ok", paramBitmap);
    AppMethodBeat.o(139519);
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, final com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a.a parama1)
  {
    AppMethodBeat.i(139517);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(139517);
      return;
    }
    parama = (com.tencent.mm.plugin.appbrand.h.b)parama;
    Object localObject = parama.atw();
    final String str = ((JSONObject)localObject).optString("backgroundImage");
    localObject = ((JSONObject)localObject).optString("backgroundMD5");
    if (Util.isNullOrNil(str))
    {
      Log.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertBackgroundImageToLocalPath, url is null");
      AppMethodBeat.o(139517);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.al.c.b.a(parama.rot, str, (String)localObject, new b.a()
    {
      public final void onLoad(String paramAnonymousString)
      {
        AppMethodBeat.i(139513);
        if (parama1 != null) {
          parama1.N(str, paramAnonymousString);
        }
        AppMethodBeat.o(139513);
      }
    });
    AppMethodBeat.o(139517);
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, final String paramString1, String paramString2, final com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a.a parama1)
  {
    AppMethodBeat.i(178855);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(178855);
      return;
    }
    parama = (com.tencent.mm.plugin.appbrand.h.b)parama;
    if (Util.isNullOrNil(paramString1))
    {
      Log.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertFilterImageToLocalPath, url is null");
      AppMethodBeat.o(178855);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.al.c.b.a(parama.rot, paramString1, paramString2, new b.a()
    {
      public final void onLoad(String paramAnonymousString)
      {
        AppMethodBeat.i(139514);
        if (parama1 != null) {
          parama1.N(paramString1, paramAnonymousString);
        }
        AppMethodBeat.o(139514);
      }
    });
    AppMethodBeat.o(178855);
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, final String paramString1, String paramString2, boolean paramBoolean, final com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a.b paramb)
  {
    AppMethodBeat.i(327162);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      Log.w("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertResourcePathToLocalPath, invokeContext is not AppBrandInvokeContext");
      paramb.auo();
      AppMethodBeat.o(327162);
      return;
    }
    if (Util.isNullOrNil(paramString1))
    {
      Log.w("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertResourcePathToLocalPath, resourcePath is null");
      paramb.auo();
      AppMethodBeat.o(327162);
      return;
    }
    parama = parama.aqX();
    if (parama == null)
    {
      Log.w("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertResourcePathToLocalPath, component is null");
      paramb.auo();
      AppMethodBeat.o(327162);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.al.c.b.a(parama, paramString1, paramBoolean, paramString2, new b.a()
    {
      public final void onLoad(String paramAnonymousString)
      {
        AppMethodBeat.i(178854);
        if (paramb != null)
        {
          if (paramAnonymousString == null)
          {
            paramb.auo();
            AppMethodBeat.o(178854);
            return;
          }
          paramb.N(paramString1, y.n(paramAnonymousString, false));
        }
        AppMethodBeat.o(178854);
      }
    });
    AppMethodBeat.o(327162);
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.r paramr, com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(327147);
    parama = A(parama);
    if (parama != null)
    {
      if (parama.sPz == paramr)
      {
        parama.sPz = null;
        Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "unregisterLivePusher:%s", new Object[] { paramr.atL() });
      }
      AppMethodBeat.o(327147);
      return;
    }
    Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "unregisterForBackgroundVOIPIfNeed, no state manager");
    AppMethodBeat.o(327147);
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.r paramr, com.tencent.luggage.xweb_ext.extendplugin.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(327139);
    this.sPy = paramBundle.getBoolean("enableMic", this.sPy);
    cyK();
    if (paramBundle.getBoolean("isVoip", false))
    {
      paramBundle = A(parama);
      if (paramBundle != null) {
        break label166;
      }
      Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "registerForBackgroundVOIPIfNeed, no state manager, create one");
      paramBundle = new e();
      com.tencent.mm.plugin.appbrand.jsapi.al.b.z(parama).a(paramBundle);
    }
    label166:
    for (int i = 1;; i = 0)
    {
      if (paramr != null)
      {
        paramBundle.sPz = paramr;
        Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "registerLivePusher:%s", new Object[] { paramr.atL() });
      }
      paramBundle.c(com.tencent.mm.plugin.appbrand.jsapi.al.b.z(parama), this.sPy);
      if ((i != 0) && (this.mIsPushing))
      {
        Log.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "registerForBackgroundVOIPIfNeed, is pushing");
        e.a(com.tencent.mm.plugin.appbrand.jsapi.al.b.z(parama), paramr);
      }
      AppMethodBeat.o(327139);
      return;
      Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "registerForBackgroundVOIPIfNeed, not voip");
      AppMethodBeat.o(327139);
      return;
    }
  }
  
  public final boolean a(com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.r paramr, com.tencent.luggage.xweb_ext.extendplugin.a parama, int paramInt)
  {
    AppMethodBeat.i(327154);
    parama = A(parama);
    if (parama != null)
    {
      boolean bool = parama.a(paramr, paramInt);
      AppMethodBeat.o(327154);
      return bool;
    }
    Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "shouldInterceptEnterBackground, no state manager");
    AppMethodBeat.o(327154);
    return false;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.b auw()
  {
    AppMethodBeat.i(139515);
    b localb = new b();
    AppMethodBeat.o(139515);
    return localb;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.c aux()
  {
    AppMethodBeat.i(139516);
    com.tencent.mm.plugin.appbrand.jsapi.al.c.c localc = new com.tencent.mm.plugin.appbrand.jsapi.al.c.c();
    AppMethodBeat.o(139516);
    return localc;
  }
  
  public final void b(com.tencent.luggage.xweb_ext.extendplugin.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(327145);
    this.sPy = paramBundle.getBoolean("enableMic", this.sPy);
    cyK();
    paramBundle = A(parama);
    if (paramBundle != null)
    {
      paramBundle.c(com.tencent.mm.plugin.appbrand.jsapi.al.b.z(parama), this.sPy);
      AppMethodBeat.o(327145);
      return;
    }
    Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "updateForBackgroundVOIPIfNeed, no state manager");
    AppMethodBeat.o(327145);
  }
  
  public final void b(com.tencent.luggage.xweb_ext.extendplugin.a parama, final com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a.a parama1)
  {
    AppMethodBeat.i(139518);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(139518);
      return;
    }
    com.tencent.mm.plugin.appbrand.h.b localb = (com.tencent.mm.plugin.appbrand.h.b)parama;
    final String str = localb.atw().optString("url");
    if (Util.isNullOrNil(str))
    {
      Log.w("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operatePlayBgm, url is nil");
      parama.fO("fail:invalid data");
      AppMethodBeat.o(139518);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.al.c.b.a(localb.rot, str, null, new b.a()
    {
      public final void onLoad(String paramAnonymousString)
      {
        AppMethodBeat.i(327122);
        if (parama1 != null) {
          parama1.N(str, y.n(paramAnonymousString, false));
        }
        AppMethodBeat.o(327122);
      }
    });
    AppMethodBeat.o(139518);
  }
  
  public final void b(com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.r paramr, com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(327149);
    this.mIsPushing = true;
    this.qwG = com.tencent.mm.plugin.appbrand.jsapi.al.b.z(parama);
    cyK();
    if (A(parama) != null)
    {
      e.a(com.tencent.mm.plugin.appbrand.jsapi.al.b.z(parama), paramr);
      AppMethodBeat.o(327149);
      return;
    }
    Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "pushBegin, no state manager");
    AppMethodBeat.o(327149);
  }
  
  public final String c(com.tencent.luggage.xweb_ext.extendplugin.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(327169);
    boolean bool1 = this.sPV;
    boolean bool2 = paramBundle.getBoolean("isVoip", bool1);
    Log.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "checkCanInsertLivePusher, oldIsVoip: %b, newIsVoip: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    this.sPV = bool2;
    if ((bool2) && (!bool1))
    {
      parama = com.tencent.mm.plugin.appbrand.jsapi.al.b.z(parama);
      if (parama != null)
      {
        paramBundle = (c)parama.aO(c.class);
        if (paramBundle != null)
        {
          parama = paramBundle.cP(parama.mAppId, parama.qsh.eul);
          Log.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "checkCanInsertLivePusher, can not insert live pusher, message:%s", new Object[] { parama });
          AppMethodBeat.o(327169);
          return parama;
        }
      }
    }
    else
    {
      Log.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "checkCanInsertLivePusher, can for not voip mode");
    }
    AppMethodBeat.o(327169);
    return null;
  }
  
  public final void c(com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.r paramr, com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(327151);
    this.mIsPushing = false;
    cyK();
    e locale = A(parama);
    if (locale != null)
    {
      parama = com.tencent.mm.plugin.appbrand.jsapi.al.b.z(parama);
      if (parama != null)
      {
        Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "onPushEnd, runtime:%s, LivePusher:%s", new Object[] { parama.mAppId, paramr.atL() });
        e.b(parama, 2);
        parama.b(locale);
      }
      AppMethodBeat.o(327151);
      return;
    }
    Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "pushEnd, no state manager");
    AppMethodBeat.o(327151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.c.b.a
 * JD-Core Version:    0.7.0.1
 */