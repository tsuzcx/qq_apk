package com.tencent.mm.plugin.appbrand.jsapi.z.c.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.tencent.luggage.k.a.a.a.b.a.a.a;
import com.tencent.luggage.k.a.a.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.z.c.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.z.c.d;
import com.tencent.mm.plugin.appbrand.z.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  private boolean laQ = true;
  
  private static d A(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(206745);
    parama = com.tencent.mm.plugin.appbrand.jsapi.z.b.y(parama);
    if (parama != null)
    {
      parama = (d)parama.as(d.class);
      AppMethodBeat.o(206745);
      return parama;
    }
    AppMethodBeat.o(206745);
    return null;
  }
  
  public final com.tencent.luggage.k.a.a.a.b.a.b ET()
  {
    AppMethodBeat.i(139515);
    b localb = new b();
    AppMethodBeat.o(139515);
    return localb;
  }
  
  public final com.tencent.luggage.k.a.a.a.b.a.c EU()
  {
    AppMethodBeat.i(139516);
    com.tencent.mm.plugin.appbrand.jsapi.z.c.c localc = new com.tencent.mm.plugin.appbrand.jsapi.z.c.c();
    AppMethodBeat.o(139516);
    return localc;
  }
  
  public final void a(com.tencent.luggage.k.a.a.a.b.a parama, com.tencent.luggage.k.a.a parama1)
  {
    AppMethodBeat.i(206741);
    parama1 = A(parama1);
    if (parama1 != null)
    {
      if (parama1.laR == parama)
      {
        parama1.laR = null;
        ac.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "unregisterLivePusher:%s", new Object[] { parama.Et() });
      }
      AppMethodBeat.o(206741);
      return;
    }
    ac.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "unregisterForBackgroundVOIPIfNeed, no state manager");
    AppMethodBeat.o(206741);
  }
  
  public final void a(com.tencent.luggage.k.a.a.a.b.a parama, com.tencent.luggage.k.a.a parama1, Bundle paramBundle)
  {
    AppMethodBeat.i(206739);
    if (paramBundle.getInt("mode", 0) == 6)
    {
      d locald2 = A(parama1);
      d locald1 = locald2;
      if (locald2 == null)
      {
        ac.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "registerForBackgroundVOIPIfNeed, no state manager, create one");
        locald1 = new d();
        com.tencent.mm.plugin.appbrand.jsapi.z.b.y(parama1).a(locald1);
      }
      locald1.laR = parama;
      ac.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "registerLivePusher:%s", new Object[] { parama.Et() });
      this.laQ = paramBundle.getBoolean("enableMic", this.laQ);
      locald1.a(com.tencent.mm.plugin.appbrand.jsapi.z.b.y(parama1), this.laQ);
      AppMethodBeat.o(206739);
      return;
    }
    ac.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "registerForBackgroundVOIPIfNeed, not RTC mode");
    AppMethodBeat.o(206739);
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
      ac.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, bitmap is null");
      parama.cs("fail:snapshot error");
      AppMethodBeat.o(139519);
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
        if (localc.DH().a(new e(str), "jpg", true, locali) == l.jsB) {
          break label255;
        }
        ac.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, save snapshot failed");
        parama.cs("fail:snapshot error");
        AppMethodBeat.o(139519);
        return;
      }
    }
    catch (IOException paramBitmap)
    {
      ac.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, save bitmap exception", new Object[] { paramBitmap });
      parama.cs("fail:snapshot error");
      AppMethodBeat.o(139519);
      return;
    }
    parama.cs("fail");
    AppMethodBeat.o(139519);
    return;
    label255:
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      ac.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "bitmap recycle " + paramBitmap.toString());
      paramBitmap.recycle();
    }
    ac.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, actualPath:%s path:%s", new Object[] { str, locali.value });
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
    Object localObject = parama.Ee();
    final String str = ((JSONObject)localObject).optString("backgroundImage");
    localObject = ((JSONObject)localObject).optString("backgroundMD5");
    if (bs.isNullOrNil(str))
    {
      ac.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertBackgroundImageToLocalPath, url is null");
      AppMethodBeat.o(139517);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.z.c.b.a(parama.jOV, str, (String)localObject, new b.a()
    {
      public final void Jr(String paramAnonymousString)
      {
        AppMethodBeat.i(139513);
        if (parama1 != null) {
          parama1.C(str, paramAnonymousString);
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
    if (bs.isNullOrNil(paramString1))
    {
      ac.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertFilterImageToLocalPath, url is null");
      AppMethodBeat.o(178855);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.z.c.b.a(parama.jOV, paramString1, paramString2, new b.a()
    {
      public final void Jr(String paramAnonymousString)
      {
        AppMethodBeat.i(139514);
        if (parama1 != null) {
          parama1.C(paramString1, paramAnonymousString);
        }
        AppMethodBeat.o(139514);
      }
    });
    AppMethodBeat.o(178855);
  }
  
  public final boolean a(com.tencent.luggage.k.a.a.a.b.a parama, com.tencent.luggage.k.a.a parama1, int paramInt)
  {
    AppMethodBeat.i(206744);
    parama1 = A(parama1);
    if (parama1 != null)
    {
      boolean bool = parama1.a(parama, paramInt);
      AppMethodBeat.o(206744);
      return bool;
    }
    ac.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "shouldInterceptEnterBackground, no state manager");
    AppMethodBeat.o(206744);
    return false;
  }
  
  public final void b(com.tencent.luggage.k.a.a.a.b.a parama, com.tencent.luggage.k.a.a parama1)
  {
    AppMethodBeat.i(206742);
    if (A(parama1) != null)
    {
      parama1 = com.tencent.mm.plugin.appbrand.jsapi.z.b.y(parama1);
      ac.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "onPushBegin, runtime:%s, LivePusher:%s", new Object[] { parama1.mAppId, parama.Et() });
      d.a(parama1, 1);
      AppMethodBeat.o(206742);
      return;
    }
    ac.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "pushBegin, no state manager");
    AppMethodBeat.o(206742);
  }
  
  public final void b(com.tencent.luggage.k.a.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(206740);
    d locald = A(parama);
    if (locald != null)
    {
      this.laQ = paramBundle.getBoolean("enableMic", this.laQ);
      locald.a(com.tencent.mm.plugin.appbrand.jsapi.z.b.y(parama), this.laQ);
      AppMethodBeat.o(206740);
      return;
    }
    ac.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "updateForBackgroundVOIPIfNeed, no state manager");
    AppMethodBeat.o(206740);
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
    final String str = localb.Ee().optString("url");
    if (bs.isNullOrNil(str))
    {
      ac.w("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operatePlayBgm, url is nil");
      parama.cs("fail:invalid data");
      AppMethodBeat.o(139518);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.z.c.b.a(localb.jOV, str, null, new b.a()
    {
      public final void Jr(String paramAnonymousString)
      {
        AppMethodBeat.i(178854);
        if (parama1 != null) {
          parama1.C(str, paramAnonymousString);
        }
        AppMethodBeat.o(178854);
      }
    });
    AppMethodBeat.o(139518);
  }
  
  public final String c(com.tencent.luggage.k.a.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(206746);
    if (paramBundle.getInt("mode", 0) == 6)
    {
      parama = com.tencent.mm.plugin.appbrand.jsapi.z.b.y(parama);
      if (parama != null)
      {
        parama = (c)parama.as(c.class);
        if (parama != null)
        {
          parama = parama.bma();
          ac.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "checkCanInsertLivePusher, can not insert live pusher, message:%s", new Object[] { parama });
          AppMethodBeat.o(206746);
          return parama;
        }
      }
    }
    else
    {
      ac.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "checkCanInsertLivePusher, can for not RTC mode");
    }
    AppMethodBeat.o(206746);
    return null;
  }
  
  public final void c(com.tencent.luggage.k.a.a.a.b.a parama, com.tencent.luggage.k.a.a parama1)
  {
    AppMethodBeat.i(206743);
    d locald = A(parama1);
    if (locald != null)
    {
      parama1 = com.tencent.mm.plugin.appbrand.jsapi.z.b.y(parama1);
      if (parama1 != null)
      {
        ac.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "onPushEnd, runtime:%s, LivePusher:%s", new Object[] { parama1.mAppId, parama.Et() });
        d.a(parama1, 2);
        parama1.b(locald);
      }
      AppMethodBeat.o(206743);
      return;
    }
    ac.d("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "pushEnd, no state manager");
    AppMethodBeat.o(206743);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.c.b.a
 * JD-Core Version:    0.7.0.1
 */