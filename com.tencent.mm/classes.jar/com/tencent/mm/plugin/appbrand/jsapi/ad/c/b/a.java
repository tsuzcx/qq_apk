package com.tencent.mm.plugin.appbrand.jsapi.ad.c.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.ad.c.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.ad.c.d;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.vfs.k;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class a
  implements com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.a
{
  private boolean lCo = true;
  
  private static d A(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(220631);
    parama = com.tencent.mm.plugin.appbrand.jsapi.ad.b.y(parama);
    if (parama != null)
    {
      parama = (d)parama.as(d.class);
      AppMethodBeat.o(220631);
      return parama;
    }
    AppMethodBeat.o(220631);
    return null;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.b Gu()
  {
    AppMethodBeat.i(139515);
    b localb = new b();
    AppMethodBeat.o(139515);
    return localb;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.c Gv()
  {
    AppMethodBeat.i(139516);
    com.tencent.mm.plugin.appbrand.jsapi.ad.c.c localc = new com.tencent.mm.plugin.appbrand.jsapi.ad.c.c();
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
      ae.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, bitmap is null");
      parama.dw("fail:snapshot error");
      AppMethodBeat.o(139519);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.c localc = ((com.tencent.mm.plugin.appbrand.h.b)parama).kmw;
    String str = com.tencent.mm.loader.j.b.asv() + String.format(Locale.US, "%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    i locali;
    try
    {
      h.a(paramBitmap, 90, Bitmap.CompressFormat.JPEG, str, true);
      locali = new i();
      if (localc.Fl() != null)
      {
        if (localc.Fl().a(new k(str), "jpg", true, locali) == m.jPM) {
          break label255;
        }
        ae.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, save snapshot failed");
        parama.dw("fail:snapshot error");
        AppMethodBeat.o(139519);
        return;
      }
    }
    catch (IOException paramBitmap)
    {
      ae.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, save bitmap exception", new Object[] { paramBitmap });
      parama.dw("fail:snapshot error");
      AppMethodBeat.o(139519);
      return;
    }
    parama.dw("fail");
    AppMethodBeat.o(139519);
    return;
    label255:
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      ae.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "bitmap recycle " + paramBitmap.toString());
      paramBitmap.recycle();
    }
    ae.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, actualPath:%s path:%s", new Object[] { str, locali.value });
    paramBitmap = new HashMap();
    paramBitmap.put("tempImagePath", locali.value);
    paramBitmap.put("width", Integer.valueOf(i));
    paramBitmap.put("height", Integer.valueOf(j));
    parama.f("ok", paramBitmap);
    AppMethodBeat.o(139519);
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, final a.a parama1)
  {
    AppMethodBeat.i(139517);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(139517);
      return;
    }
    parama = (com.tencent.mm.plugin.appbrand.h.b)parama;
    Object localObject = parama.FJ();
    final String str = ((JSONObject)localObject).optString("backgroundImage");
    localObject = ((JSONObject)localObject).optString("backgroundMD5");
    if (bu.isNullOrNil(str))
    {
      ae.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertBackgroundImageToLocalPath, url is null");
      AppMethodBeat.o(139517);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.ad.c.b.a(parama.kmw, str, (String)localObject, new b.a()
    {
      public final void Nr(String paramAnonymousString)
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
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, final String paramString1, String paramString2, final a.a parama1)
  {
    AppMethodBeat.i(178855);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(178855);
      return;
    }
    parama = (com.tencent.mm.plugin.appbrand.h.b)parama;
    if (bu.isNullOrNil(paramString1))
    {
      ae.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertFilterImageToLocalPath, url is null");
      AppMethodBeat.o(178855);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.ad.c.b.a(parama.kmw, paramString1, paramString2, new b.a()
    {
      public final void Nr(String paramAnonymousString)
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
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a parama, com.tencent.luggage.xweb_ext.extendplugin.a parama1)
  {
    AppMethodBeat.i(220627);
    parama1 = A(parama1);
    if (parama1 != null)
    {
      if (parama1.lCp == parama)
      {
        parama1.lCp = null;
        ae.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "unregisterLivePusher:%s", new Object[] { parama.FY() });
      }
      AppMethodBeat.o(220627);
      return;
    }
    ae.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "unregisterForBackgroundVOIPIfNeed, no state manager");
    AppMethodBeat.o(220627);
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a parama, com.tencent.luggage.xweb_ext.extendplugin.a parama1, Bundle paramBundle)
  {
    AppMethodBeat.i(220625);
    if (paramBundle.getInt("mode", 0) == 6)
    {
      d locald2 = A(parama1);
      d locald1 = locald2;
      if (locald2 == null)
      {
        ae.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "registerForBackgroundVOIPIfNeed, no state manager, create one");
        locald1 = new d();
        com.tencent.mm.plugin.appbrand.jsapi.ad.b.y(parama1).a(locald1);
      }
      locald1.lCp = parama;
      ae.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "registerLivePusher:%s", new Object[] { parama.FY() });
      this.lCo = paramBundle.getBoolean("enableMic", this.lCo);
      locald1.a(com.tencent.mm.plugin.appbrand.jsapi.ad.b.y(parama1), this.lCo);
      AppMethodBeat.o(220625);
      return;
    }
    ae.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "registerForBackgroundVOIPIfNeed, not RTC mode");
    AppMethodBeat.o(220625);
  }
  
  public final boolean a(com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a parama, com.tencent.luggage.xweb_ext.extendplugin.a parama1, int paramInt)
  {
    AppMethodBeat.i(220630);
    parama1 = A(parama1);
    if (parama1 != null)
    {
      boolean bool = parama1.a(parama, paramInt);
      AppMethodBeat.o(220630);
      return bool;
    }
    ae.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "shouldInterceptEnterBackground, no state manager");
    AppMethodBeat.o(220630);
    return false;
  }
  
  public final void b(com.tencent.luggage.xweb_ext.extendplugin.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(220626);
    d locald = A(parama);
    if (locald != null)
    {
      this.lCo = paramBundle.getBoolean("enableMic", this.lCo);
      locald.a(com.tencent.mm.plugin.appbrand.jsapi.ad.b.y(parama), this.lCo);
      AppMethodBeat.o(220626);
      return;
    }
    ae.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "updateForBackgroundVOIPIfNeed, no state manager");
    AppMethodBeat.o(220626);
  }
  
  public final void b(com.tencent.luggage.xweb_ext.extendplugin.a parama, final a.a parama1)
  {
    AppMethodBeat.i(139518);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(139518);
      return;
    }
    com.tencent.mm.plugin.appbrand.h.b localb = (com.tencent.mm.plugin.appbrand.h.b)parama;
    final String str = localb.FJ().optString("url");
    if (bu.isNullOrNil(str))
    {
      ae.w("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operatePlayBgm, url is nil");
      parama.dw("fail:invalid data");
      AppMethodBeat.o(139518);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.ad.c.b.a(localb.kmw, str, null, new b.a()
    {
      public final void Nr(String paramAnonymousString)
      {
        AppMethodBeat.i(178854);
        if (parama1 != null) {
          parama1.F(str, com.tencent.mm.vfs.o.k(paramAnonymousString, false));
        }
        AppMethodBeat.o(178854);
      }
    });
    AppMethodBeat.o(139518);
  }
  
  public final void b(com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a parama, com.tencent.luggage.xweb_ext.extendplugin.a parama1)
  {
    AppMethodBeat.i(220628);
    if (A(parama1) != null)
    {
      parama1 = com.tencent.mm.plugin.appbrand.jsapi.ad.b.y(parama1);
      ae.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "onPushBegin, runtime:%s, LivePusher:%s", new Object[] { parama1.mAppId, parama.FY() });
      d.b(parama1, 1);
      AppMethodBeat.o(220628);
      return;
    }
    ae.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "pushBegin, no state manager");
    AppMethodBeat.o(220628);
  }
  
  public final String c(com.tencent.luggage.xweb_ext.extendplugin.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(220632);
    if (paramBundle.getInt("mode", 0) == 6)
    {
      parama = com.tencent.mm.plugin.appbrand.jsapi.ad.b.y(parama);
      if (parama != null)
      {
        parama = (c)parama.as(c.class);
        if (parama != null)
        {
          parama = parama.bqv();
          ae.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "checkCanInsertLivePusher, can not insert live pusher, message:%s", new Object[] { parama });
          AppMethodBeat.o(220632);
          return parama;
        }
      }
    }
    else
    {
      ae.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "checkCanInsertLivePusher, can for not RTC mode");
    }
    AppMethodBeat.o(220632);
    return null;
  }
  
  public final void c(com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a parama, com.tencent.luggage.xweb_ext.extendplugin.a parama1)
  {
    AppMethodBeat.i(220629);
    d locald = A(parama1);
    if (locald != null)
    {
      parama1 = com.tencent.mm.plugin.appbrand.jsapi.ad.b.y(parama1);
      if (parama1 != null)
      {
        ae.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "onPushEnd, runtime:%s, LivePusher:%s", new Object[] { parama1.mAppId, parama.FY() });
        d.b(parama1, 2);
        parama1.b(locald);
      }
      AppMethodBeat.o(220629);
      return;
    }
    ae.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "pushEnd, no state manager");
    AppMethodBeat.o(220629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.c.b.a
 * JD-Core Version:    0.7.0.1
 */