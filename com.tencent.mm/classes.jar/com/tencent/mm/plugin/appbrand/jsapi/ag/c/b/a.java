package com.tencent.mm.plugin.appbrand.jsapi.ag.c.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.ag.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.capsulebar.i.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class a
  implements com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a
{
  private AppBrandRuntime kEc = null;
  private i.a lEv = null;
  private volatile boolean mIsPushing = false;
  private boolean mJN = true;
  private boolean mKk = false;
  
  private void bMd()
  {
    AppMethodBeat.i(215877);
    if ((this.mIsPushing) && (this.mJN))
    {
      bMe();
      AppMethodBeat.o(215877);
      return;
    }
    bMf();
    AppMethodBeat.o(215877);
  }
  
  private void bMe()
  {
    AppMethodBeat.i(215878);
    if (this.lEv != null)
    {
      Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "blinkCapsuleBar, already blink");
      AppMethodBeat.o(215878);
      return;
    }
    if (this.kEc != null)
    {
      Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "blinkCapsuleBar");
      this.lEv = com.tencent.mm.plugin.appbrand.page.capsulebar.a.a.ah(this.kEc).a(com.tencent.mm.plugin.appbrand.page.capsulebar.a.b.nuR);
    }
    AppMethodBeat.o(215878);
  }
  
  private void bMf()
  {
    AppMethodBeat.i(215879);
    if (this.lEv != null)
    {
      Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "dismissBlink");
      this.lEv.dismiss();
      this.lEv = null;
    }
    AppMethodBeat.o(215879);
  }
  
  private static e z(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(215876);
    parama = com.tencent.mm.plugin.appbrand.jsapi.ag.b.y(parama);
    if (parama != null)
    {
      parama = (e)parama.aw(e.class);
      AppMethodBeat.o(215876);
      return parama;
    }
    AppMethodBeat.o(215876);
    return null;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.b Qm()
  {
    AppMethodBeat.i(139515);
    b localb = new b();
    AppMethodBeat.o(139515);
    return localb;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.c Qn()
  {
    AppMethodBeat.i(139516);
    com.tencent.mm.plugin.appbrand.jsapi.ag.c.c localc = new com.tencent.mm.plugin.appbrand.jsapi.ag.c.c();
    AppMethodBeat.o(139516);
    return localc;
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
      parama.dP("fail:snapshot error");
      AppMethodBeat.o(139519);
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
        Log.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, save snapshot failed");
        parama.dP("fail:snapshot error");
        AppMethodBeat.o(139519);
        return;
      }
    }
    catch (IOException paramBitmap)
    {
      Log.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, save bitmap exception", new Object[] { paramBitmap });
      parama.dP("fail:snapshot error");
      AppMethodBeat.o(139519);
      return;
    }
    parama.dP("fail");
    AppMethodBeat.o(139519);
    return;
    label255:
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Log.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "bitmap recycle " + paramBitmap.toString());
      paramBitmap.recycle();
    }
    Log.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, actualPath:%s path:%s", new Object[] { str, locali.value });
    paramBitmap = new HashMap();
    paramBitmap.put("tempImagePath", locali.value);
    paramBitmap.put("width", Integer.valueOf(i));
    paramBitmap.put("height", Integer.valueOf(j));
    parama.f("ok", paramBitmap);
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
    Object localObject = parama.Ps();
    final String str = ((JSONObject)localObject).optString("backgroundImage");
    localObject = ((JSONObject)localObject).optString("backgroundMD5");
    if (Util.isNullOrNil(str))
    {
      Log.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertBackgroundImageToLocalPath, url is null");
      AppMethodBeat.o(139517);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.a(parama.lqg, str, (String)localObject, new b.a()
    {
      public final void Wz(String paramAnonymousString)
      {
        AppMethodBeat.i(139513);
        if (parama1 != null) {
          parama1.F(str, paramAnonymousString);
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
    com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.a(parama.lqg, paramString1, paramString2, new b.a()
    {
      public final void Wz(String paramAnonymousString)
      {
        AppMethodBeat.i(139514);
        if (parama1 != null) {
          parama1.F(paramString1, paramAnonymousString);
        }
        AppMethodBeat.o(139514);
      }
    });
    AppMethodBeat.o(178855);
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, final String paramString1, String paramString2, boolean paramBoolean, final com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a.b paramb)
  {
    AppMethodBeat.i(215880);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      Log.w("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertResourcePathToLocalPath, invokeContext is not AppBrandInvokeContext");
      paramb.Qi();
      AppMethodBeat.o(215880);
      return;
    }
    if (Util.isNullOrNil(paramString1))
    {
      Log.w("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertResourcePathToLocalPath, resourcePath is null");
      paramb.Qi();
      AppMethodBeat.o(215880);
      return;
    }
    parama = parama.NN();
    if (parama == null)
    {
      Log.w("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertResourcePathToLocalPath, component is null");
      paramb.Qi();
      AppMethodBeat.o(215880);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.a(parama, paramString1, paramBoolean, paramString2, new b.a()
    {
      public final void Wz(String paramAnonymousString)
      {
        AppMethodBeat.i(178854);
        if (paramb != null)
        {
          if (paramAnonymousString == null)
          {
            paramb.Qi();
            AppMethodBeat.o(178854);
            return;
          }
          paramb.F(paramString1, paramAnonymousString);
        }
        AppMethodBeat.o(178854);
      }
    });
    AppMethodBeat.o(215880);
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o paramo, com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(215872);
    parama = z(parama);
    if (parama != null)
    {
      if (parama.mJO == paramo)
      {
        parama.mJO = null;
        Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "unregisterLivePusher:%s", new Object[] { paramo.PH() });
      }
      AppMethodBeat.o(215872);
      return;
    }
    Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "unregisterForBackgroundVOIPIfNeed, no state manager");
    AppMethodBeat.o(215872);
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o paramo, com.tencent.luggage.xweb_ext.extendplugin.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(215870);
    this.mJN = paramBundle.getBoolean("enableMic", this.mJN);
    bMd();
    if (paramBundle.getBoolean("isVoip", false))
    {
      paramBundle = z(parama);
      if (paramBundle != null) {
        break label166;
      }
      Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "registerForBackgroundVOIPIfNeed, no state manager, create one");
      paramBundle = new e();
      com.tencent.mm.plugin.appbrand.jsapi.ag.b.y(parama).a(paramBundle);
    }
    label166:
    for (int i = 1;; i = 0)
    {
      if (paramo != null)
      {
        paramBundle.mJO = paramo;
        Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "registerLivePusher:%s", new Object[] { paramo.PH() });
      }
      paramBundle.c(com.tencent.mm.plugin.appbrand.jsapi.ag.b.y(parama), this.mJN);
      if ((i != 0) && (this.mIsPushing))
      {
        Log.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "registerForBackgroundVOIPIfNeed, is pushing");
        e.a(com.tencent.mm.plugin.appbrand.jsapi.ag.b.y(parama), paramo);
      }
      AppMethodBeat.o(215870);
      return;
      Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "registerForBackgroundVOIPIfNeed, not voip");
      AppMethodBeat.o(215870);
      return;
    }
  }
  
  public final boolean a(com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o paramo, com.tencent.luggage.xweb_ext.extendplugin.a parama, int paramInt)
  {
    AppMethodBeat.i(215875);
    parama = z(parama);
    if (parama != null)
    {
      boolean bool = parama.a(paramo, paramInt);
      AppMethodBeat.o(215875);
      return bool;
    }
    Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "shouldInterceptEnterBackground, no state manager");
    AppMethodBeat.o(215875);
    return false;
  }
  
  public final void b(com.tencent.luggage.xweb_ext.extendplugin.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(215871);
    this.mJN = paramBundle.getBoolean("enableMic", this.mJN);
    bMd();
    paramBundle = z(parama);
    if (paramBundle != null)
    {
      paramBundle.c(com.tencent.mm.plugin.appbrand.jsapi.ag.b.y(parama), this.mJN);
      AppMethodBeat.o(215871);
      return;
    }
    Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "updateForBackgroundVOIPIfNeed, no state manager");
    AppMethodBeat.o(215871);
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
    final String str = localb.Ps().optString("url");
    if (Util.isNullOrNil(str))
    {
      Log.w("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operatePlayBgm, url is nil");
      parama.dP("fail:invalid data");
      AppMethodBeat.o(139518);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.a(localb.lqg, str, null, new b.a()
    {
      public final void Wz(String paramAnonymousString)
      {
        AppMethodBeat.i(215869);
        if (parama1 != null) {
          parama1.F(str, s.k(paramAnonymousString, false));
        }
        AppMethodBeat.o(215869);
      }
    });
    AppMethodBeat.o(139518);
  }
  
  public final void b(com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o paramo, com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(215873);
    this.mIsPushing = true;
    this.kEc = com.tencent.mm.plugin.appbrand.jsapi.ag.b.y(parama);
    bMd();
    if (z(parama) != null)
    {
      e.a(com.tencent.mm.plugin.appbrand.jsapi.ag.b.y(parama), paramo);
      AppMethodBeat.o(215873);
      return;
    }
    Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "pushBegin, no state manager");
    AppMethodBeat.o(215873);
  }
  
  public final String c(com.tencent.luggage.xweb_ext.extendplugin.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(215881);
    boolean bool1 = this.mKk;
    boolean bool2 = paramBundle.getBoolean("isVoip", bool1);
    Log.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "checkCanInsertLivePusher, oldIsVoip: %b, newIsVoip: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    this.mKk = bool2;
    if ((bool2) && (!bool1))
    {
      parama = com.tencent.mm.plugin.appbrand.jsapi.ag.b.y(parama);
      if (parama != null)
      {
        parama = (c)parama.aw(c.class);
        if (parama != null)
        {
          parama = parama.bMg();
          Log.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "checkCanInsertLivePusher, can not insert live pusher, message:%s", new Object[] { parama });
          AppMethodBeat.o(215881);
          return parama;
        }
      }
    }
    else
    {
      Log.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "checkCanInsertLivePusher, can for not voip mode");
    }
    AppMethodBeat.o(215881);
    return null;
  }
  
  public final void c(com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o paramo, com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(215874);
    this.mIsPushing = false;
    bMd();
    e locale = z(parama);
    if (locale != null)
    {
      parama = com.tencent.mm.plugin.appbrand.jsapi.ag.b.y(parama);
      if (parama != null)
      {
        Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "onPushEnd, runtime:%s, LivePusher:%s", new Object[] { parama.mAppId, paramo.PH() });
        e.b(parama, 2);
        parama.b(locale);
      }
      AppMethodBeat.o(215874);
      return;
    }
    Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "pushEnd, no state manager");
    AppMethodBeat.o(215874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.a
 * JD-Core Version:    0.7.0.1
 */