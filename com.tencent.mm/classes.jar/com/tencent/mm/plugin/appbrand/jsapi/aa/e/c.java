package com.tencent.mm.plugin.appbrand.jsapi.aa.e;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Handler;
import com.tencent.luggage.k.a.a.b.b.11;
import com.tencent.luggage.k.a.a.b.b.13;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.aa.i;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.aa.e.c.a.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
  implements com.tencent.luggage.k.a.a.b.b.b
{
  com.tencent.mm.plugin.appbrand.s.a.b kAA;
  com.tencent.luggage.k.a.a.b.b kAB;
  private com.tencent.mm.plugin.appbrand.jsapi.aa.e.c.a kAC;
  String kzE;
  private c.a kzF;
  
  public c()
  {
    AppMethodBeat.i(139557);
    this.kzF = new c.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.b.b paramAnonymousb)
      {
        AppMethodBeat.i(139556);
        if (paramAnonymousString.equalsIgnoreCase(c.this.kzE)) {
          if (paramAnonymousb == com.tencent.mm.plugin.appbrand.b.b.iQL)
          {
            if (c.this.kAB != null)
            {
              paramAnonymousString = c.this.kAB;
              paramAnonymousString.k(new b.13(paramAnonymousString));
              AppMethodBeat.o(139556);
            }
          }
          else if ((paramAnonymousb == com.tencent.mm.plugin.appbrand.b.b.iQK) && (c.this.kAB != null))
          {
            paramAnonymousString = c.this.kAB;
            paramAnonymousString.k(new b.11(paramAnonymousString));
          }
        }
        AppMethodBeat.o(139556);
      }
    };
    com.tencent.mm.plugin.appbrand.jsapi.aa.e.a.c localc = (com.tencent.mm.plugin.appbrand.jsapi.aa.e.a.c)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.aa.e.a.c.class);
    if (localc != null) {
      this.kAA = localc.bfn();
    }
    this.kAC = new com.tencent.mm.plugin.appbrand.jsapi.aa.e.c.a();
    AppMethodBeat.o(139557);
  }
  
  private com.tencent.luggage.k.a.a.b.b.e bfj()
  {
    if (this.kAB != null) {
      return this.kAB.cmW;
    }
    return null;
  }
  
  public final com.tencent.luggage.k.a.a.b.b.f FB()
  {
    AppMethodBeat.i(139561);
    g localg = new g();
    AppMethodBeat.o(139561);
    return localg;
  }
  
  public final com.tencent.luggage.k.a.a.b.b.e FC()
  {
    AppMethodBeat.i(139560);
    f localf = new f();
    AppMethodBeat.o(139560);
    return localf;
  }
  
  public final com.tencent.luggage.k.a.a.b.b.c FD()
  {
    AppMethodBeat.i(139558);
    d locald = new d();
    AppMethodBeat.o(139558);
    return locald;
  }
  
  public final com.tencent.luggage.k.a.a.b.b.d FE()
  {
    AppMethodBeat.i(139559);
    e locale = new e();
    AppMethodBeat.o(139559);
    return locale;
  }
  
  public final com.tencent.luggage.k.a.a.b.b.a FF()
  {
    AppMethodBeat.i(139577);
    a locala = new a();
    AppMethodBeat.o(139577);
    return locala;
  }
  
  public final b a(com.tencent.luggage.k.a.a.b.b.a parama, com.tencent.luggage.k.a.a parama1)
  {
    AppMethodBeat.i(139562);
    parama = new b(parama, parama1);
    AppMethodBeat.o(139562);
    return parama;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.video.e.b a(com.tencent.luggage.k.a.a parama, Handler paramHandler)
  {
    AppMethodBeat.i(195106);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      AppMethodBeat.o(195106);
      return null;
    }
    long l = System.currentTimeMillis();
    Object localObject = (h)com.tencent.luggage.a.e.K(h.class);
    if (localObject == null)
    {
      parama = new com.tencent.mm.plugin.appbrand.jsapi.video.e.d();
      l = System.currentTimeMillis() - l;
      paramHandler = this.kAC;
      localObject = bfj();
      if ((parama != null) && (localObject != null))
      {
        if (!(parama instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.d)) {
          break label171;
        }
        ((com.tencent.luggage.k.a.a.b.b.e)localObject).c(1234L, 0L, 1L);
        ((com.tencent.luggage.k.a.a.b.b.e)localObject).c(1234L, 1L, l);
        label107:
        ((com.tencent.luggage.k.a.a.b.b.e)localObject).c(1234L, 6L, 1L);
        localObject = paramHandler.kCO;
        if (!(parama instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)) {
          break label210;
        }
      }
    }
    label171:
    label210:
    for (int i = 1;; i = 0)
    {
      ((a.a)localObject).kuZ = i;
      paramHandler.kCO.kCP = l;
      AppMethodBeat.o(195106);
      return parama;
      parama = ((h)localObject).a(parama, paramHandler);
      break;
      if (!(parama instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)) {
        break label107;
      }
      ((com.tencent.luggage.k.a.a.b.b.e)localObject).c(1234L, 3L, 1L);
      ((com.tencent.luggage.k.a.a.b.b.e)localObject).c(1234L, 4L, l);
      break label107;
    }
  }
  
  public final void a(com.tencent.luggage.k.a.a parama, Bitmap paramBitmap)
  {
    AppMethodBeat.i(178857);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      AppMethodBeat.o(178857);
      return;
    }
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      ad.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "operateSnapshot, bitmap is null");
      parama.cD("fail:snapshot error");
      AppMethodBeat.o(178857);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.c localc = parama.Dj();
    String str = com.tencent.mm.loader.j.b.ais() + String.format(Locale.US, "%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    i locali;
    try
    {
      com.tencent.mm.sdk.platformtools.f.a(paramBitmap, 90, Bitmap.CompressFormat.JPEG, str, true);
      locali = new i();
      if (localc.Ee() != null)
      {
        if (localc.Ee().a(new com.tencent.mm.vfs.e(str), "jpg", true, locali) == l.iSq) {
          break label257;
        }
        ad.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "operateSnapshot, save snapshot failed");
        parama.cD("fail:snapshot error");
        AppMethodBeat.o(178857);
        return;
      }
    }
    catch (IOException paramBitmap)
    {
      ad.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "operateSnapshot, save bitmap exception", new Object[] { paramBitmap });
      parama.cD("fail:snapshot error");
      AppMethodBeat.o(178857);
      return;
    }
    parama.cD("fail");
    AppMethodBeat.o(178857);
    return;
    label257:
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      ad.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "bitmap recycle " + paramBitmap.toString());
      paramBitmap.recycle();
    }
    ad.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "operateSnapshot, actualPath:%s path:%s", new Object[] { str, locali.value });
    paramBitmap = new HashMap();
    paramBitmap.put("tempImagePath", locali.value);
    paramBitmap.put("width", Integer.valueOf(i));
    paramBitmap.put("height", Integer.valueOf(j));
    parama.d("ok", paramBitmap);
    AppMethodBeat.o(178857);
  }
  
  public final void a(com.tencent.luggage.k.a.a parama, com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramb)
  {
    AppMethodBeat.i(195114);
    com.tencent.mm.plugin.appbrand.jsapi.aa.e.c.a locala = this.kAC;
    com.tencent.luggage.k.a.a.b.b.e locale = bfj();
    if ((locale != null) && (!bt.isNullOrNil(locala.kCO.videoPath)) && (locala.kCO.kCR > 0L))
    {
      locala.kCO.kCY = bt.eGO();
      locala.a(locale, parama, paramb, "onMediaPlayerVideoStop");
    }
    AppMethodBeat.o(195114);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramb, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(195113);
    com.tencent.mm.plugin.appbrand.jsapi.aa.e.c.a locala = this.kAC;
    com.tencent.luggage.k.a.a.b.b.e locale = bfj();
    if ((paramb != null) && (locale != null))
    {
      locale.c(1234L, 65L, 1L);
      ad.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoError, what:%s, extra:%s, msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if (!(paramb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.d)) {
        break label183;
      }
      locale.c(1234L, 70L, 1L);
      if (!bt.isNullOrNil(paramString))
      {
        if (!paramString.equalsIgnoreCase("MEDIA_ERR_NETWORK")) {
          break label231;
        }
        locale.c(1234L, 67L, 1L);
        if (!(paramb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.d)) {
          break label207;
        }
        locale.c(1234L, 72L, 1L);
      }
    }
    for (;;)
    {
      locala.kCO.kDa = paramInt1;
      locala.kCO.kDb = paramInt2;
      locala.kCO.errorMsg = paramString;
      AppMethodBeat.o(195113);
      return;
      label183:
      if (!(paramb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)) {
        break;
      }
      locale.c(1234L, 75L, 1L);
      break;
      label207:
      if ((paramb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c))
      {
        locale.c(1234L, 77L, 1L);
        continue;
        label231:
        if (paramString.equalsIgnoreCase("MEDIA_ERR_DECODE"))
        {
          locale.c(1234L, 68L, 1L);
          if ((paramb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.d)) {
            locale.c(1234L, 73L, 1L);
          } else if ((paramb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)) {
            locale.c(1234L, 78L, 1L);
          }
        }
        else if (paramString.equalsIgnoreCase("MEDIA_ERR_SRC_NOT_SUPPORTED"))
        {
          locale.c(1234L, 66L, 1L);
          if ((paramb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.d)) {
            locale.c(1234L, 71L, 1L);
          } else if ((paramb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)) {
            locale.c(1234L, 76L, 1L);
          }
        }
        else
        {
          locale.c(1234L, 69L, 1L);
          if ((paramb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.d)) {
            locale.c(1234L, 74L, 1L);
          } else if ((paramb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)) {
            locale.c(1234L, 79L, 1L);
          }
        }
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramb, long paramLong)
  {
    AppMethodBeat.i(195110);
    com.tencent.mm.plugin.appbrand.jsapi.aa.e.c.a locala = this.kAC;
    com.tencent.luggage.k.a.a.b.b.e locale = bfj();
    long l;
    if ((paramb != null) && (locale != null)) {
      if (locala.kCO.kCS <= 0L)
      {
        locala.kCO.kCS = bt.eGO();
        locale.c(1234L, 21L, 1L);
        l = locala.kCO.kCS - locala.kCO.kCR;
        locala.kCO.kCT = l;
        locale.c(1234L, 23L, l);
        ad.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoPrepareEnd, prepareTime:%s", new Object[] { Long.valueOf(l) });
        if (!(paramb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.d)) {
          break label259;
        }
        locale.c(1234L, 41L, 1L);
        locale.c(1234L, 43L, l);
      }
    }
    for (;;)
    {
      if ((locala.kCO.duration <= 0L) && (paramLong > 0L))
      {
        paramLong = (1.0D * paramLong / 1000.0D);
        locala.kCO.duration = paramLong;
        locale.c(1234L, 35L, 1L);
        locale.c(1234L, 38L, paramLong);
        ad.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoPrepareEnd, duration:%s", new Object[] { Long.valueOf(paramLong) });
      }
      AppMethodBeat.o(195110);
      return;
      label259:
      if ((paramb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c))
      {
        locale.c(1234L, 46L, 1L);
        locale.c(1234L, 48L, l);
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramb, String paramString)
  {
    AppMethodBeat.i(195107);
    long l1 = 0L;
    if (com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.video.g.class) != null) {
      l1 = ((com.tencent.mm.plugin.appbrand.jsapi.video.g)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.video.g.class)).g(paramString, 0L, 9223372036854775807L);
    }
    if (l1 < 0L) {
      l1 = 0L;
    }
    for (;;)
    {
      ad.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "onVideoPathChanged, videoPath:%s, cachedSize:%s", new Object[] { paramString, Long.valueOf(l1) });
      if ((this.kAB != null) && (this.kAB.cmT != null)) {
        this.kAB.cmT.aP(l1);
      }
      com.tencent.mm.plugin.appbrand.jsapi.aa.e.c.a locala = this.kAC;
      Object localObject = bfj();
      if ((paramb != null) && (localObject != null) && (!bt.isNullOrNil(paramString)))
      {
        ((com.tencent.luggage.k.a.a.b.b.e)localObject).c(1234L, 10L, 1L);
        if (l1 > 0L)
        {
          ((com.tencent.luggage.k.a.a.b.b.e)localObject).c(1234L, 11L, 1L);
          long l2 = BigInteger.valueOf(l1).divide(com.tencent.mm.plugin.appbrand.jsapi.aa.e.c.a.kCN).longValue();
          ((com.tencent.luggage.k.a.a.b.b.e)localObject).c(1234L, 13L, l2);
          ad.d("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onVideoPathChanged, cachedSize:%s, cachedSizeInKB:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
        }
        localObject = locala.kCO;
        if (bt.isNullOrNil(paramString)) {
          break label275;
        }
        paramb = paramString;
        if (paramString.length() > 512) {
          paramb = paramString.substring(0, 512);
        }
      }
      label275:
      for (((a.a)localObject).videoPath = paramb;; ((a.a)localObject).videoPath = "")
      {
        locala.kCO.kCQ = l1;
        AppMethodBeat.o(195107);
        return;
      }
    }
  }
  
  public final String b(com.tencent.luggage.k.a.a parama, String paramString)
  {
    AppMethodBeat.i(139564);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      AppMethodBeat.o(139564);
      return paramString;
    }
    if ((!bt.isNullOrNil(paramString)) && (paramString.startsWith("cloud://")))
    {
      AppMethodBeat.o(139564);
      return null;
    }
    parama = parama.Dj();
    if ((!bt.isNullOrNil(paramString)) && (parama != null) && (parama.Ee() != null) && (parama.Ee().Eb(paramString)))
    {
      parama = parama.Ee().EP(paramString);
      if (parama == null) {}
      for (;;)
      {
        ad.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "convertVideoPath, videoPath:%s", new Object[] { paramString });
        AppMethodBeat.o(139564);
        return paramString;
        paramString = "file://" + com.tencent.mm.vfs.q.B(parama.fhU());
      }
    }
    parama = paramString;
    if (!bt.isNullOrNil(paramString))
    {
      parama = paramString;
      if (com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.video.g.class) != null) {
        parama = ((com.tencent.mm.plugin.appbrand.jsapi.video.g)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.video.g.class)).getProxyUrl(paramString);
      }
    }
    AppMethodBeat.o(139564);
    return parama;
  }
  
  public final void b(com.tencent.luggage.k.a.a.b.b paramb)
  {
    this.kAB = paramb;
  }
  
  public final void b(com.tencent.luggage.k.a.a parama, com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramb)
  {
    AppMethodBeat.i(195115);
    com.tencent.mm.plugin.appbrand.jsapi.aa.e.c.a locala = this.kAC;
    com.tencent.luggage.k.a.a.b.b.e locale = bfj();
    if ((locale != null) && (!bt.isNullOrNil(locala.kCO.videoPath)) && (locala.kCO.kCR > 0L))
    {
      locala.kCO.kCZ = bt.eGO();
      locala.a(locale, parama, paramb, "onMediaPlayerVideoEnd");
    }
    AppMethodBeat.o(195115);
  }
  
  public final void c(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramb)
  {
    AppMethodBeat.i(195109);
    com.tencent.mm.plugin.appbrand.jsapi.aa.e.c.a locala = this.kAC;
    com.tencent.luggage.k.a.a.b.b.e locale = bfj();
    if ((paramb != null) && (locale != null) && (locala.kCO.kCR <= 0L))
    {
      locala.kCO.kCR = bt.eGO();
      locale.c(1234L, 20L, 1L);
      if ((paramb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.d))
      {
        locale.c(1234L, 40L, 1L);
        AppMethodBeat.o(195109);
        return;
      }
      if ((paramb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)) {
        locale.c(1234L, 45L, 1L);
      }
    }
    AppMethodBeat.o(195109);
  }
  
  public final void d(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramb)
  {
    AppMethodBeat.i(195111);
    com.tencent.mm.plugin.appbrand.jsapi.aa.e.c.a locala = this.kAC;
    com.tencent.luggage.k.a.a.b.b.e locale = bfj();
    if ((paramb != null) && (locale != null) && (locala.kCO.kCW <= 0L))
    {
      paramb = locala.kCO;
      paramb.kCU += 1;
      locala.kCO.kCW = bt.eGO();
      locale.c(1234L, 20L, 1L);
    }
    AppMethodBeat.o(195111);
  }
  
  public final void e(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramb)
  {
    AppMethodBeat.i(195112);
    com.tencent.mm.plugin.appbrand.jsapi.aa.e.c.a locala = this.kAC;
    com.tencent.luggage.k.a.a.b.b.e locale = bfj();
    if ((paramb != null) && (locale != null))
    {
      if (locala.kCO.kCX <= 0L)
      {
        locala.kCO.kCX = bt.eGO();
        locale.c(1234L, 21L, 1L);
        long l = locala.kCO.kCX - locala.kCO.kCW;
        paramb = locala.kCO;
        paramb.kCV += l;
        locale.c(1234L, 23L, l);
        ad.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoBufferEnd, bufferTime:%s", new Object[] { Long.valueOf(l) });
      }
      paramb = locala.kCO;
      paramb.kCW = 0L;
      paramb.kCX = 0L;
    }
    AppMethodBeat.o(195112);
  }
  
  public final boolean k(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(139566);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      AppMethodBeat.o(139566);
      return false;
    }
    Object localObject = parama.EB();
    com.tencent.mm.plugin.appbrand.jsapi.c localc = ((com.tencent.mm.plugin.appbrand.i.b)parama).joJ;
    parama = null;
    if ((localc instanceof aa)) {
      parama = (aa)localc;
    }
    while (parama == null)
    {
      ad.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, page view is null");
      AppMethodBeat.o(139566);
      return false;
      if ((localc instanceof com.tencent.mm.plugin.appbrand.q)) {
        parama = ((com.tencent.mm.plugin.appbrand.q)localc).getCurrentPageView();
      }
    }
    if ((localObject != null) && (((JSONObject)localObject).has("data")))
    {
      localObject = ((JSONObject)localObject).optJSONArray("data");
      if ((localObject == null) || (((JSONArray)localObject).length() == 0))
      {
        ad.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, data array is null");
        AppMethodBeat.o(139566);
        return false;
      }
      int i;
      switch (((JSONArray)localObject).optInt(0, 90))
      {
      default: 
        i = 90;
      }
      for (;;)
      {
        parama.L(new c.1(this, parama, i));
        AppMethodBeat.o(139566);
        return true;
        i = 90;
        continue;
        i = -90;
        continue;
        i = 0;
      }
    }
    AppMethodBeat.o(139566);
    return false;
  }
  
  public final boolean l(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(139567);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      AppMethodBeat.o(139567);
      return false;
    }
    parama = ((com.tencent.mm.plugin.appbrand.i.b)parama).joJ;
    if ((parama instanceof aa)) {
      parama = (aa)parama;
    }
    for (;;)
    {
      if (parama == null)
      {
        ad.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "exitFullscreen, page view is null");
        AppMethodBeat.o(139567);
        return false;
        if ((parama instanceof com.tencent.mm.plugin.appbrand.q)) {
          parama = ((com.tencent.mm.plugin.appbrand.q)parama).getCurrentPageView();
        }
      }
      else
      {
        parama.L(new c.2(this, parama));
        AppMethodBeat.o(139567);
        return true;
      }
      parama = null;
    }
  }
  
  public final boolean u(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(139568);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      AppMethodBeat.o(139568);
      return false;
    }
    Object localObject = parama.EB();
    parama = ((com.tencent.mm.plugin.appbrand.i.b)parama).joJ;
    if ((parama instanceof aa)) {
      parama = (aa)parama;
    }
    for (;;)
    {
      if (parama == null)
      {
        ad.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "setScreenBrightness, page view is null");
        AppMethodBeat.o(139568);
        return false;
        if ((parama instanceof com.tencent.mm.plugin.appbrand.q)) {
          parama = ((com.tencent.mm.plugin.appbrand.q)parama).getCurrentPageView();
        }
      }
      else
      {
        if ((localObject != null) && (((JSONObject)localObject).has("data")))
        {
          localObject = ((JSONObject)localObject).optJSONArray("data");
          if ((localObject == null) || (((JSONArray)localObject).length() == 0))
          {
            ad.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "setScreenBrightness, data array is null");
            AppMethodBeat.o(139568);
            return false;
          }
          float f = (float)((JSONArray)localObject).optDouble(0, -1.0D);
          if ((Float.isNaN(f)) || (f < 0.0F) || (f > 1.0F))
          {
            AppMethodBeat.o(139568);
            return false;
          }
          if ((parama.getContext() instanceof Activity))
          {
            aq.f(new c.3(this, (Activity)parama.getContext(), f));
            AppMethodBeat.o(139568);
            return true;
          }
        }
        AppMethodBeat.o(139568);
        return false;
      }
      parama = null;
    }
  }
  
  public final void v(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(195108);
    if ((parama != null) && ("wxfe02ecfe70800f46".equalsIgnoreCase(parama.getAppId())))
    {
      ad.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "onMediaPlayerVideoFirstFrame, send play event");
      com.tencent.mm.sdk.b.a.ESL.l(new com.tencent.mm.plugin.appbrand.jsapi.video.c.a());
    }
    AppMethodBeat.o(195108);
  }
  
  public final void w(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(139578);
    if ((parama instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      parama = parama.Dj();
      this.kzE = parama.getAppId();
      if (!(parama instanceof com.tencent.mm.plugin.appbrand.q)) {
        break label80;
      }
      parama = ((com.tencent.mm.plugin.appbrand.q)parama).getRuntime();
    }
    for (;;)
    {
      if ((parama != null) && (!"wxfe02ecfe70800f46".equalsIgnoreCase(parama.mAppId))) {
        parama.iDK.a(this.kzF);
      }
      AppMethodBeat.o(139578);
      return;
      label80:
      if ((parama instanceof aa)) {
        parama = ((aa)parama).getRuntime();
      } else {
        parama = null;
      }
    }
  }
  
  public final void x(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(139579);
    if ((parama instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      parama = parama.Dj();
      if ((parama instanceof com.tencent.mm.plugin.appbrand.q)) {
        parama = ((com.tencent.mm.plugin.appbrand.q)parama).getRuntime();
      }
    }
    for (;;)
    {
      if (parama != null)
      {
        if (!"wxfe02ecfe70800f46".equalsIgnoreCase(parama.mAppId)) {
          parama.iDK.b(this.kzF);
        }
        ad.d("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "markVideoPlayerRelease");
        if (this.kAB == null)
        {
          ad.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "markVideoPlayerRelease, pluginHandler is null");
          AppMethodBeat.o(139579);
          return;
          if ((parama instanceof aa)) {
            parama = ((aa)parama).getRuntime();
          }
        }
        else
        {
          parama = (com.tencent.mm.plugin.appbrand.jsapi.aa.a)parama.as(com.tencent.mm.plugin.appbrand.jsapi.aa.a.class);
          if (parama == null)
          {
            ad.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "markVideoPlayerRelease, audioOfVideoBackgroundPlayManager is null");
            AppMethodBeat.o(139579);
            return;
          }
          parama.f(this.kAB);
        }
      }
      else
      {
        AppMethodBeat.o(139579);
        return;
      }
      parama = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.e.c
 * JD-Core Version:    0.7.0.1
 */