package com.tencent.mm.plugin.appbrand.jsapi.aa.c.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.tencent.luggage.k.a.a.a.b.a.a.a;
import com.tencent.luggage.k.a.a.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.aa.i;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.aa.c.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.aa.c.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class a
  implements com.tencent.luggage.k.a.a.a.b.a.a
{
  private boolean kzz = true;
  
  private static d B(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(195102);
    parama = com.tencent.mm.plugin.appbrand.jsapi.aa.b.z(parama);
    if (parama != null)
    {
      parama = (d)parama.as(d.class);
      AppMethodBeat.o(195102);
      return parama;
    }
    AppMethodBeat.o(195102);
    return null;
  }
  
  public final com.tencent.luggage.k.a.a.a.b.a.b Fl()
  {
    AppMethodBeat.i(139515);
    b localb = new b();
    AppMethodBeat.o(139515);
    return localb;
  }
  
  public final com.tencent.luggage.k.a.a.a.b.a.c Fm()
  {
    AppMethodBeat.i(139516);
    com.tencent.mm.plugin.appbrand.jsapi.aa.c.c localc = new com.tencent.mm.plugin.appbrand.jsapi.aa.c.c();
    AppMethodBeat.o(139516);
    return localc;
  }
  
  public final void a(com.tencent.luggage.k.a.a.a.b.a parama, com.tencent.luggage.k.a.a parama1)
  {
    AppMethodBeat.i(195098);
    parama1 = B(parama1);
    if (parama1 != null)
    {
      if (parama1.kzA == parama)
      {
        parama1.kzA = null;
        ad.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "unregisterLivePusher:%s", new Object[] { parama.EP() });
      }
      AppMethodBeat.o(195098);
      return;
    }
    ad.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "unregisterForBackgroundVOIPIfNeed, no state manager");
    AppMethodBeat.o(195098);
  }
  
  public final void a(com.tencent.luggage.k.a.a.a.b.a parama, com.tencent.luggage.k.a.a parama1, Bundle paramBundle)
  {
    AppMethodBeat.i(195096);
    if (paramBundle.getInt("mode", 0) == 6)
    {
      d locald2 = B(parama1);
      d locald1 = locald2;
      if (locald2 == null)
      {
        ad.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "registerForBackgroundVOIPIfNeed, no state manager, create one");
        locald1 = new d();
        com.tencent.mm.plugin.appbrand.jsapi.aa.b.z(parama1).a(locald1);
      }
      locald1.kzA = parama;
      ad.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "registerLivePusher:%s", new Object[] { parama.EP() });
      this.kzz = paramBundle.getBoolean("enableMic", this.kzz);
      locald1.a(com.tencent.mm.plugin.appbrand.jsapi.aa.b.z(parama1), this.kzz);
      AppMethodBeat.o(195096);
      return;
    }
    ad.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "registerForBackgroundVOIPIfNeed, not RTC mode");
    AppMethodBeat.o(195096);
  }
  
  public final void a(com.tencent.luggage.k.a.a parama, Bitmap paramBitmap)
  {
    AppMethodBeat.i(139519);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      AppMethodBeat.o(139519);
      return;
    }
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      ad.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, bitmap is null");
      parama.cD("fail:snapshot error");
      AppMethodBeat.o(139519);
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
        if (localc.Ee().a(new e(str), "jpg", true, locali) == l.iSq) {
          break label255;
        }
        ad.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, save snapshot failed");
        parama.cD("fail:snapshot error");
        AppMethodBeat.o(139519);
        return;
      }
    }
    catch (IOException paramBitmap)
    {
      ad.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, save bitmap exception", new Object[] { paramBitmap });
      parama.cD("fail:snapshot error");
      AppMethodBeat.o(139519);
      return;
    }
    parama.cD("fail");
    AppMethodBeat.o(139519);
    return;
    label255:
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      ad.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "bitmap recycle " + paramBitmap.toString());
      paramBitmap.recycle();
    }
    ad.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, actualPath:%s path:%s", new Object[] { str, locali.value });
    paramBitmap = new HashMap();
    paramBitmap.put("tempImagePath", locali.value);
    paramBitmap.put("width", Integer.valueOf(i));
    paramBitmap.put("height", Integer.valueOf(j));
    parama.d("ok", paramBitmap);
    AppMethodBeat.o(139519);
  }
  
  public final void a(com.tencent.luggage.k.a.a parama, final a.a parama1)
  {
    AppMethodBeat.i(139517);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      AppMethodBeat.o(139517);
      return;
    }
    parama = (com.tencent.mm.plugin.appbrand.i.b)parama;
    Object localObject = parama.EB();
    final String str = ((JSONObject)localObject).optString("backgroundImage");
    localObject = ((JSONObject)localObject).optString("backgroundMD5");
    if (bt.isNullOrNil(str))
    {
      ad.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertBackgroundImageToLocalPath, url is null");
      AppMethodBeat.o(139517);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.aa.c.b.a(parama.joJ, str, (String)localObject, new b.a()
    {
      public final void Fn(String paramAnonymousString)
      {
        AppMethodBeat.i(139513);
        if (parama1 != null) {
          parama1.B(str, paramAnonymousString);
        }
        AppMethodBeat.o(139513);
      }
    });
    AppMethodBeat.o(139517);
  }
  
  public final void a(com.tencent.luggage.k.a.a parama, final String paramString1, String paramString2, final a.a parama1)
  {
    AppMethodBeat.i(178855);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      AppMethodBeat.o(178855);
      return;
    }
    parama = (com.tencent.mm.plugin.appbrand.i.b)parama;
    if (bt.isNullOrNil(paramString1))
    {
      ad.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertFilterImageToLocalPath, url is null");
      AppMethodBeat.o(178855);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.aa.c.b.a(parama.joJ, paramString1, paramString2, new b.a()
    {
      public final void Fn(String paramAnonymousString)
      {
        AppMethodBeat.i(139514);
        if (parama1 != null) {
          parama1.B(paramString1, paramAnonymousString);
        }
        AppMethodBeat.o(139514);
      }
    });
    AppMethodBeat.o(178855);
  }
  
  public final boolean a(com.tencent.luggage.k.a.a.a.b.a parama, com.tencent.luggage.k.a.a parama1, int paramInt)
  {
    AppMethodBeat.i(195101);
    parama1 = B(parama1);
    if (parama1 != null)
    {
      boolean bool = parama1.a(parama, paramInt);
      AppMethodBeat.o(195101);
      return bool;
    }
    ad.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "shouldInterceptEnterBackground, no state manager");
    AppMethodBeat.o(195101);
    return false;
  }
  
  public final void b(com.tencent.luggage.k.a.a.a.b.a parama, com.tencent.luggage.k.a.a parama1)
  {
    AppMethodBeat.i(195099);
    if (B(parama1) != null)
    {
      parama1 = com.tencent.mm.plugin.appbrand.jsapi.aa.b.z(parama1);
      ad.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "onPushBegin, runtime:%s, LivePusher:%s", new Object[] { parama1.mAppId, parama.EP() });
      d.a(parama1, 1);
      AppMethodBeat.o(195099);
      return;
    }
    ad.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "pushBegin, no state manager");
    AppMethodBeat.o(195099);
  }
  
  public final void b(com.tencent.luggage.k.a.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(195097);
    d locald = B(parama);
    if (locald != null)
    {
      this.kzz = paramBundle.getBoolean("enableMic", this.kzz);
      locald.a(com.tencent.mm.plugin.appbrand.jsapi.aa.b.z(parama), this.kzz);
      AppMethodBeat.o(195097);
      return;
    }
    ad.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "updateForBackgroundVOIPIfNeed, no state manager");
    AppMethodBeat.o(195097);
  }
  
  public final void b(com.tencent.luggage.k.a.a parama, final a.a parama1)
  {
    AppMethodBeat.i(139518);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      AppMethodBeat.o(139518);
      return;
    }
    com.tencent.mm.plugin.appbrand.i.b localb = (com.tencent.mm.plugin.appbrand.i.b)parama;
    final String str = localb.EB().optString("url");
    if (bt.isNullOrNil(str))
    {
      ad.w("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operatePlayBgm, url is nil");
      parama.cD("fail:invalid data");
      AppMethodBeat.o(139518);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.aa.c.b.a(localb.joJ, str, null, new b.a()
    {
      public final void Fn(String paramAnonymousString)
      {
        AppMethodBeat.i(178854);
        if (parama1 != null) {
          parama1.B(str, paramAnonymousString);
        }
        AppMethodBeat.o(178854);
      }
    });
    AppMethodBeat.o(139518);
  }
  
  public final String c(com.tencent.luggage.k.a.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(195103);
    if (paramBundle.getInt("mode", 0) == 6)
    {
      parama = com.tencent.mm.plugin.appbrand.jsapi.aa.b.z(parama);
      if (parama != null)
      {
        parama = (c)parama.as(c.class);
        if (parama != null)
        {
          parama = parama.bfg();
          ad.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "checkCanInsertLivePusher, can not insert live pusher, message:%s", new Object[] { parama });
          AppMethodBeat.o(195103);
          return parama;
        }
      }
    }
    else
    {
      ad.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "checkCanInsertLivePusher, can for not RTC mode");
    }
    AppMethodBeat.o(195103);
    return null;
  }
  
  public final void c(com.tencent.luggage.k.a.a.a.b.a parama, com.tencent.luggage.k.a.a parama1)
  {
    AppMethodBeat.i(195100);
    d locald = B(parama1);
    if (locald != null)
    {
      parama1 = com.tencent.mm.plugin.appbrand.jsapi.aa.b.z(parama1);
      if (parama1 != null)
      {
        ad.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "onPushEnd, runtime:%s, LivePusher:%s", new Object[] { parama1.mAppId, parama.EP() });
        d.a(parama1, 2);
        parama1.b(locald);
      }
      AppMethodBeat.o(195100);
      return;
    }
    ad.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "pushEnd, no state manager");
    AppMethodBeat.o(195100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.c.b.a
 * JD-Core Version:    0.7.0.1
 */