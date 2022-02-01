package com.tencent.mm.plugin.appbrand.jsapi.ai.c.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.p;
import com.tencent.luggage.xweb_ext.extendplugin.component.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.jsapi.ai.c.b.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.i.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class a
  implements com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a
{
  private volatile boolean mIsPushing = false;
  private AppBrandRuntime nxs = null;
  private i.a ozW = null;
  private boolean pKF = true;
  private boolean pLc = false;
  
  private static com.tencent.mm.plugin.appbrand.jsapi.ai.c.e A(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(227903);
    parama = com.tencent.mm.plugin.appbrand.jsapi.ai.b.z(parama);
    if (parama != null)
    {
      parama = (com.tencent.mm.plugin.appbrand.jsapi.ai.c.e)parama.av(com.tencent.mm.plugin.appbrand.jsapi.ai.c.e.class);
      AppMethodBeat.o(227903);
      return parama;
    }
    AppMethodBeat.o(227903);
    return null;
  }
  
  private void bYu()
  {
    AppMethodBeat.i(227905);
    if ((this.mIsPushing) && (this.pKF))
    {
      bYv();
      AppMethodBeat.o(227905);
      return;
    }
    bYw();
    AppMethodBeat.o(227905);
  }
  
  private void bYv()
  {
    AppMethodBeat.i(227908);
    if (this.ozW != null)
    {
      Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "blinkCapsuleBar, already blink");
      AppMethodBeat.o(227908);
      return;
    }
    if (this.nxs != null)
    {
      Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "blinkCapsuleBar");
      this.ozW = com.tencent.mm.plugin.appbrand.page.capsulebar.a.a.ah(this.nxs).a(com.tencent.mm.plugin.appbrand.page.capsulebar.a.b.qwM);
    }
    AppMethodBeat.o(227908);
  }
  
  private void bYw()
  {
    AppMethodBeat.i(227910);
    if (this.ozW != null)
    {
      Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "dismissBlink");
      this.ozW.dismiss();
      this.ozW = null;
    }
    AppMethodBeat.o(227910);
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.b TO()
  {
    AppMethodBeat.i(139515);
    b localb = new b();
    AppMethodBeat.o(139515);
    return localb;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.c TP()
  {
    AppMethodBeat.i(139516);
    com.tencent.mm.plugin.appbrand.jsapi.ai.c.c localc = new com.tencent.mm.plugin.appbrand.jsapi.ai.c.c();
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
      parama.er("fail:snapshot error");
      AppMethodBeat.o(139519);
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
        Log.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, save snapshot failed");
        parama.er("fail:snapshot error");
        AppMethodBeat.o(139519);
        return;
      }
    }
    catch (IOException paramBitmap)
    {
      Log.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, save bitmap exception", new Object[] { paramBitmap });
      parama.er("fail:snapshot error");
      AppMethodBeat.o(139519);
      return;
    }
    parama.er("fail");
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
    Object localObject = parama.SR();
    final String str = ((JSONObject)localObject).optString("backgroundImage");
    localObject = ((JSONObject)localObject).optString("backgroundMD5");
    if (Util.isNullOrNil(str))
    {
      Log.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertBackgroundImageToLocalPath, url is null");
      AppMethodBeat.o(139517);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.ai.c.b.a(parama.okQ, str, (String)localObject, new b.a()
    {
      public final void dR(String paramAnonymousString)
      {
        AppMethodBeat.i(139513);
        if (parama1 != null) {
          parama1.K(str, paramAnonymousString);
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
    com.tencent.mm.plugin.appbrand.jsapi.ai.c.b.a(parama.okQ, paramString1, paramString2, new b.a()
    {
      public final void dR(String paramAnonymousString)
      {
        AppMethodBeat.i(139514);
        if (parama1 != null) {
          parama1.K(paramString1, paramAnonymousString);
        }
        AppMethodBeat.o(139514);
      }
    });
    AppMethodBeat.o(178855);
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, final String paramString1, String paramString2, boolean paramBoolean, final com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a.b paramb)
  {
    AppMethodBeat.i(227921);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      Log.w("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertResourcePathToLocalPath, invokeContext is not AppBrandInvokeContext");
      paramb.TJ();
      AppMethodBeat.o(227921);
      return;
    }
    if (Util.isNullOrNil(paramString1))
    {
      Log.w("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertResourcePathToLocalPath, resourcePath is null");
      paramb.TJ();
      AppMethodBeat.o(227921);
      return;
    }
    parama = parama.QK();
    if (parama == null)
    {
      Log.w("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertResourcePathToLocalPath, component is null");
      paramb.TJ();
      AppMethodBeat.o(227921);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.ai.c.b.a(parama, paramString1, paramBoolean, paramString2, new b.a()
    {
      public final void dR(String paramAnonymousString)
      {
        AppMethodBeat.i(178854);
        if (paramb != null)
        {
          if (paramAnonymousString == null)
          {
            paramb.TJ();
            AppMethodBeat.o(178854);
            return;
          }
          paramb.K(paramString1, paramAnonymousString);
        }
        AppMethodBeat.o(178854);
      }
    });
    AppMethodBeat.o(227921);
  }
  
  public final void a(p paramp, com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(227892);
    parama = A(parama);
    if (parama != null)
    {
      if (parama.pKG == paramp)
      {
        parama.pKG = null;
        Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "unregisterLivePusher:%s", new Object[] { paramp.Tg() });
      }
      AppMethodBeat.o(227892);
      return;
    }
    Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "unregisterForBackgroundVOIPIfNeed, no state manager");
    AppMethodBeat.o(227892);
  }
  
  public final void a(p paramp, com.tencent.luggage.xweb_ext.extendplugin.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(227886);
    this.pKF = paramBundle.getBoolean("enableMic", this.pKF);
    bYu();
    if (paramBundle.getBoolean("isVoip", false))
    {
      paramBundle = A(parama);
      if (paramBundle != null) {
        break label166;
      }
      Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "registerForBackgroundVOIPIfNeed, no state manager, create one");
      paramBundle = new com.tencent.mm.plugin.appbrand.jsapi.ai.c.e();
      com.tencent.mm.plugin.appbrand.jsapi.ai.b.z(parama).a(paramBundle);
    }
    label166:
    for (int i = 1;; i = 0)
    {
      if (paramp != null)
      {
        paramBundle.pKG = paramp;
        Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "registerLivePusher:%s", new Object[] { paramp.Tg() });
      }
      paramBundle.c(com.tencent.mm.plugin.appbrand.jsapi.ai.b.z(parama), this.pKF);
      if ((i != 0) && (this.mIsPushing))
      {
        Log.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "registerForBackgroundVOIPIfNeed, is pushing");
        com.tencent.mm.plugin.appbrand.jsapi.ai.c.e.a(com.tencent.mm.plugin.appbrand.jsapi.ai.b.z(parama), paramp);
      }
      AppMethodBeat.o(227886);
      return;
      Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "registerForBackgroundVOIPIfNeed, not voip");
      AppMethodBeat.o(227886);
      return;
    }
  }
  
  public final boolean a(p paramp, com.tencent.luggage.xweb_ext.extendplugin.a parama, int paramInt)
  {
    AppMethodBeat.i(227899);
    parama = A(parama);
    if (parama != null)
    {
      boolean bool = parama.a(paramp, paramInt);
      AppMethodBeat.o(227899);
      return bool;
    }
    Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "shouldInterceptEnterBackground, no state manager");
    AppMethodBeat.o(227899);
    return false;
  }
  
  public final void b(com.tencent.luggage.xweb_ext.extendplugin.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(227890);
    this.pKF = paramBundle.getBoolean("enableMic", this.pKF);
    bYu();
    paramBundle = A(parama);
    if (paramBundle != null)
    {
      paramBundle.c(com.tencent.mm.plugin.appbrand.jsapi.ai.b.z(parama), this.pKF);
      AppMethodBeat.o(227890);
      return;
    }
    Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "updateForBackgroundVOIPIfNeed, no state manager");
    AppMethodBeat.o(227890);
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
    final String str = localb.SR().optString("url");
    if (Util.isNullOrNil(str))
    {
      Log.w("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operatePlayBgm, url is nil");
      parama.er("fail:invalid data");
      AppMethodBeat.o(139518);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.ai.c.b.a(localb.okQ, str, null, new b.a()
    {
      public final void dR(String paramAnonymousString)
      {
        AppMethodBeat.i(222901);
        if (parama1 != null) {
          parama1.K(str, u.n(paramAnonymousString, false));
        }
        AppMethodBeat.o(222901);
      }
    });
    AppMethodBeat.o(139518);
  }
  
  public final void b(p paramp, com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(227895);
    this.mIsPushing = true;
    this.nxs = com.tencent.mm.plugin.appbrand.jsapi.ai.b.z(parama);
    bYu();
    if (A(parama) != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.ai.c.e.a(com.tencent.mm.plugin.appbrand.jsapi.ai.b.z(parama), paramp);
      AppMethodBeat.o(227895);
      return;
    }
    Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "pushBegin, no state manager");
    AppMethodBeat.o(227895);
  }
  
  public final String c(com.tencent.luggage.xweb_ext.extendplugin.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(227929);
    boolean bool1 = this.pLc;
    boolean bool2 = paramBundle.getBoolean("isVoip", bool1);
    Log.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "checkCanInsertLivePusher, oldIsVoip: %b, newIsVoip: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    this.pLc = bool2;
    if ((bool2) && (!bool1))
    {
      parama = com.tencent.mm.plugin.appbrand.jsapi.ai.b.z(parama);
      if (parama != null)
      {
        paramBundle = (c)parama.av(c.class);
        if (paramBundle != null)
        {
          parama = paramBundle.cp(parama.mAppId, parama.ntz.cBI);
          Log.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "checkCanInsertLivePusher, can not insert live pusher, message:%s", new Object[] { parama });
          AppMethodBeat.o(227929);
          return parama;
        }
      }
    }
    else
    {
      Log.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "checkCanInsertLivePusher, can for not voip mode");
    }
    AppMethodBeat.o(227929);
    return null;
  }
  
  public final void c(p paramp, com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(227898);
    this.mIsPushing = false;
    bYu();
    com.tencent.mm.plugin.appbrand.jsapi.ai.c.e locale = A(parama);
    if (locale != null)
    {
      parama = com.tencent.mm.plugin.appbrand.jsapi.ai.b.z(parama);
      if (parama != null)
      {
        Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "onPushEnd, runtime:%s, LivePusher:%s", new Object[] { parama.mAppId, paramp.Tg() });
        com.tencent.mm.plugin.appbrand.jsapi.ai.c.e.b(parama, 2);
        parama.b(locale);
      }
      AppMethodBeat.o(227898);
      return;
    }
    Log.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "pushEnd, no state manager");
    AppMethodBeat.o(227898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.c.b.a
 * JD-Core Version:    0.7.0.1
 */