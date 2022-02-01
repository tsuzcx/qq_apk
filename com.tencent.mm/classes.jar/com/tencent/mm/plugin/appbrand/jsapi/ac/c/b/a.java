package com.tencent.mm.plugin.appbrand.jsapi.ac.c.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.a.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.ac.c.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.ac.c.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class a
  implements com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.a
{
  private boolean lxQ = true;
  
  private static d A(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(186934);
    parama = com.tencent.mm.plugin.appbrand.jsapi.ac.b.y(parama);
    if (parama != null)
    {
      parama = (d)parama.as(d.class);
      AppMethodBeat.o(186934);
      return parama;
    }
    AppMethodBeat.o(186934);
    return null;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.b Go()
  {
    AppMethodBeat.i(139515);
    b localb = new b();
    AppMethodBeat.o(139515);
    return localb;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.c Gp()
  {
    AppMethodBeat.i(139516);
    com.tencent.mm.plugin.appbrand.jsapi.ac.c.c localc = new com.tencent.mm.plugin.appbrand.jsapi.ac.c.c();
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
      ad.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, bitmap is null");
      parama.du("fail:snapshot error");
      AppMethodBeat.o(139519);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.c localc = ((com.tencent.mm.plugin.appbrand.h.b)parama).kjg;
    String str = com.tencent.mm.loader.j.b.asg() + String.format(Locale.US, "%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    com.tencent.mm.plugin.appbrand.z.i locali;
    try
    {
      g.a(paramBitmap, 90, Bitmap.CompressFormat.JPEG, str, true);
      locali = new com.tencent.mm.plugin.appbrand.z.i();
      if (localc.Fg() != null)
      {
        if (localc.Fg().a(new e(str), "jpg", true, locali) == l.jMv) {
          break label255;
        }
        ad.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, save snapshot failed");
        parama.du("fail:snapshot error");
        AppMethodBeat.o(139519);
        return;
      }
    }
    catch (IOException paramBitmap)
    {
      ad.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, save bitmap exception", new Object[] { paramBitmap });
      parama.du("fail:snapshot error");
      AppMethodBeat.o(139519);
      return;
    }
    parama.du("fail");
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
    parama.e("ok", paramBitmap);
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
    Object localObject = parama.FD();
    final String str = ((JSONObject)localObject).optString("backgroundImage");
    localObject = ((JSONObject)localObject).optString("backgroundMD5");
    if (bt.isNullOrNil(str))
    {
      ad.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertBackgroundImageToLocalPath, url is null");
      AppMethodBeat.o(139517);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.ac.c.b.a(parama.kjg, str, (String)localObject, new b.a()
    {
      public final void MK(String paramAnonymousString)
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
    if (bt.isNullOrNil(paramString1))
    {
      ad.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertFilterImageToLocalPath, url is null");
      AppMethodBeat.o(178855);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.ac.c.b.a(parama.kjg, paramString1, paramString2, new b.a()
    {
      public final void MK(String paramAnonymousString)
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
    AppMethodBeat.i(186930);
    parama1 = A(parama1);
    if (parama1 != null)
    {
      if (parama1.lxR == parama)
      {
        parama1.lxR = null;
        ad.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "unregisterLivePusher:%s", new Object[] { parama.FS() });
      }
      AppMethodBeat.o(186930);
      return;
    }
    ad.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "unregisterForBackgroundVOIPIfNeed, no state manager");
    AppMethodBeat.o(186930);
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a parama, com.tencent.luggage.xweb_ext.extendplugin.a parama1, Bundle paramBundle)
  {
    AppMethodBeat.i(186928);
    if (paramBundle.getInt("mode", 0) == 6)
    {
      d locald2 = A(parama1);
      d locald1 = locald2;
      if (locald2 == null)
      {
        ad.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "registerForBackgroundVOIPIfNeed, no state manager, create one");
        locald1 = new d();
        com.tencent.mm.plugin.appbrand.jsapi.ac.b.y(parama1).a(locald1);
      }
      locald1.lxR = parama;
      ad.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "registerLivePusher:%s", new Object[] { parama.FS() });
      this.lxQ = paramBundle.getBoolean("enableMic", this.lxQ);
      locald1.a(com.tencent.mm.plugin.appbrand.jsapi.ac.b.y(parama1), this.lxQ);
      AppMethodBeat.o(186928);
      return;
    }
    ad.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "registerForBackgroundVOIPIfNeed, not RTC mode");
    AppMethodBeat.o(186928);
  }
  
  public final boolean a(com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a parama, com.tencent.luggage.xweb_ext.extendplugin.a parama1, int paramInt)
  {
    AppMethodBeat.i(186933);
    parama1 = A(parama1);
    if (parama1 != null)
    {
      boolean bool = parama1.a(parama, paramInt);
      AppMethodBeat.o(186933);
      return bool;
    }
    ad.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "shouldInterceptEnterBackground, no state manager");
    AppMethodBeat.o(186933);
    return false;
  }
  
  public final void b(com.tencent.luggage.xweb_ext.extendplugin.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(186929);
    d locald = A(parama);
    if (locald != null)
    {
      this.lxQ = paramBundle.getBoolean("enableMic", this.lxQ);
      locald.a(com.tencent.mm.plugin.appbrand.jsapi.ac.b.y(parama), this.lxQ);
      AppMethodBeat.o(186929);
      return;
    }
    ad.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "updateForBackgroundVOIPIfNeed, no state manager");
    AppMethodBeat.o(186929);
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
    final String str = localb.FD().optString("url");
    if (bt.isNullOrNil(str))
    {
      ad.w("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operatePlayBgm, url is nil");
      parama.du("fail:invalid data");
      AppMethodBeat.o(139518);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.ac.c.b.a(localb.kjg, str, null, new b.a()
    {
      public final void MK(String paramAnonymousString)
      {
        AppMethodBeat.i(178854);
        if (parama1 != null) {
          parama1.F(str, com.tencent.mm.vfs.i.k(paramAnonymousString, false));
        }
        AppMethodBeat.o(178854);
      }
    });
    AppMethodBeat.o(139518);
  }
  
  public final void b(com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a parama, com.tencent.luggage.xweb_ext.extendplugin.a parama1)
  {
    AppMethodBeat.i(186931);
    if (A(parama1) != null)
    {
      parama1 = com.tencent.mm.plugin.appbrand.jsapi.ac.b.y(parama1);
      ad.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "onPushBegin, runtime:%s, LivePusher:%s", new Object[] { parama1.mAppId, parama.FS() });
      d.b(parama1, 1);
      AppMethodBeat.o(186931);
      return;
    }
    ad.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "pushBegin, no state manager");
    AppMethodBeat.o(186931);
  }
  
  public final String c(com.tencent.luggage.xweb_ext.extendplugin.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(186935);
    if (paramBundle.getInt("mode", 0) == 6)
    {
      parama = com.tencent.mm.plugin.appbrand.jsapi.ac.b.y(parama);
      if (parama != null)
      {
        parama = (c)parama.as(c.class);
        if (parama != null)
        {
          parama = parama.bpL();
          ad.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "checkCanInsertLivePusher, can not insert live pusher, message:%s", new Object[] { parama });
          AppMethodBeat.o(186935);
          return parama;
        }
      }
    }
    else
    {
      ad.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "checkCanInsertLivePusher, can for not RTC mode");
    }
    AppMethodBeat.o(186935);
    return null;
  }
  
  public final void c(com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a parama, com.tencent.luggage.xweb_ext.extendplugin.a parama1)
  {
    AppMethodBeat.i(186932);
    d locald = A(parama1);
    if (locald != null)
    {
      parama1 = com.tencent.mm.plugin.appbrand.jsapi.ac.b.y(parama1);
      if (parama1 != null)
      {
        ad.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "onPushEnd, runtime:%s, LivePusher:%s", new Object[] { parama1.mAppId, parama.FS() });
        d.b(parama1, 2);
        parama1.b(locald);
      }
      AppMethodBeat.o(186932);
      return;
    }
    ad.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "pushEnd, no state manager");
    AppMethodBeat.o(186932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.c.b.a
 * JD-Core Version:    0.7.0.1
 */