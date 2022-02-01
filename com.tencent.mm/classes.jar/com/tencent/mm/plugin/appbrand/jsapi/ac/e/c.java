package com.tencent.mm.plugin.appbrand.jsapi.ac.e;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Handler;
import android.view.View;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.c.11;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.c.13;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e.c.a.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ay;
import com.tencent.mm.plugin.appbrand.z.i;
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
  implements com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b
{
  String lxV;
  private c.a lxX;
  com.tencent.mm.plugin.appbrand.r.a.b lyS;
  com.tencent.luggage.xweb_ext.extendplugin.component.video.c lyT;
  private com.tencent.mm.plugin.appbrand.jsapi.ac.e.c.a lyU;
  
  public c()
  {
    AppMethodBeat.i(139557);
    this.lxX = new c.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.a.b paramAnonymousb)
      {
        AppMethodBeat.i(139556);
        if (paramAnonymousString.equalsIgnoreCase(c.this.lxV)) {
          if (paramAnonymousb == com.tencent.mm.plugin.appbrand.a.b.jKP)
          {
            if (c.this.lyT != null)
            {
              paramAnonymousString = c.this.lyT;
              paramAnonymousString.k(new c.13(paramAnonymousString));
              AppMethodBeat.o(139556);
            }
          }
          else if ((paramAnonymousb == com.tencent.mm.plugin.appbrand.a.b.jKO) && (c.this.lyT != null))
          {
            paramAnonymousString = c.this.lyT;
            paramAnonymousString.k(new c.11(paramAnonymousString));
          }
        }
        AppMethodBeat.o(139556);
      }
    };
    com.tencent.mm.plugin.appbrand.jsapi.ac.e.a.c localc = (com.tencent.mm.plugin.appbrand.jsapi.ac.e.a.c)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.ac.e.a.c.class);
    if (localc != null) {
      this.lyS = localc.bpS();
    }
    this.lyU = new com.tencent.mm.plugin.appbrand.jsapi.ac.e.c.a();
    AppMethodBeat.o(139557);
  }
  
  private com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e bpO()
  {
    if (this.lyT != null) {
      return this.lyT.cuy;
    }
    return null;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.f GD()
  {
    AppMethodBeat.i(139561);
    g localg = new g();
    AppMethodBeat.o(139561);
    return localg;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e GE()
  {
    AppMethodBeat.i(139560);
    f localf = new f();
    AppMethodBeat.o(139560);
    return localf;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c GF()
  {
    AppMethodBeat.i(139558);
    d locald = new d();
    AppMethodBeat.o(139558);
    return locald;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d GG()
  {
    AppMethodBeat.i(139559);
    e locale = new e();
    AppMethodBeat.o(139559);
    return locale;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a GH()
  {
    AppMethodBeat.i(139577);
    a locala = new a();
    AppMethodBeat.o(139577);
    return locala;
  }
  
  public final b a(com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a parama, com.tencent.luggage.xweb_ext.extendplugin.a parama1)
  {
    AppMethodBeat.i(139562);
    parama = new b(parama, parama1);
    AppMethodBeat.o(139562);
    return parama;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.video.e.b a(com.tencent.luggage.xweb_ext.extendplugin.a parama, Handler paramHandler)
  {
    AppMethodBeat.i(186938);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(186938);
      return null;
    }
    long l = System.currentTimeMillis();
    Object localObject = (h)com.tencent.luggage.a.e.K(h.class);
    if (localObject == null)
    {
      parama = new com.tencent.mm.plugin.appbrand.jsapi.video.e.d();
      l = System.currentTimeMillis() - l;
      paramHandler = this.lyU;
      localObject = bpO();
      if ((parama != null) && (localObject != null))
      {
        if (!(parama instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.d)) {
          break label171;
        }
        ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e)localObject).c(1234L, 0L, 1L);
        ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e)localObject).c(1234L, 1L, l);
        label107:
        ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e)localObject).c(1234L, 6L, 1L);
        localObject = paramHandler.lBf;
        if (!(parama instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)) {
          break label210;
        }
      }
    }
    label171:
    label210:
    for (int i = 1;; i = 0)
    {
      ((a.a)localObject).ltm = i;
      paramHandler.lBf.lBg = l;
      AppMethodBeat.o(186938);
      return parama;
      parama = ((h)localObject).a(parama, paramHandler);
      break;
      if (!(parama instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)) {
        break label107;
      }
      ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e)localObject).c(1234L, 3L, 1L);
      ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e)localObject).c(1234L, 4L, l);
      break label107;
    }
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, Bitmap paramBitmap)
  {
    AppMethodBeat.i(178857);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(178857);
      return;
    }
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      ad.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "operateSnapshot, bitmap is null");
      parama.du("fail:snapshot error");
      AppMethodBeat.o(178857);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.c localc = parama.El();
    String str = com.tencent.mm.loader.j.b.asg() + String.format(Locale.US, "%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    i locali;
    try
    {
      com.tencent.mm.sdk.platformtools.g.a(paramBitmap, 90, Bitmap.CompressFormat.JPEG, str, true);
      locali = new i();
      if (localc.Fg() != null)
      {
        if (localc.Fg().a(new com.tencent.mm.vfs.e(str), "jpg", true, locali) == l.jMv) {
          break label257;
        }
        ad.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "operateSnapshot, save snapshot failed");
        parama.du("fail:snapshot error");
        AppMethodBeat.o(178857);
        return;
      }
    }
    catch (IOException paramBitmap)
    {
      ad.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "operateSnapshot, save bitmap exception", new Object[] { paramBitmap });
      parama.du("fail:snapshot error");
      AppMethodBeat.o(178857);
      return;
    }
    parama.du("fail");
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
    parama.e("ok", paramBitmap);
    AppMethodBeat.o(178857);
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramb)
  {
    AppMethodBeat.i(186946);
    com.tencent.mm.plugin.appbrand.jsapi.ac.e.c.a locala = this.lyU;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e locale = bpO();
    if ((locale != null) && (!bt.isNullOrNil(locala.lBf.videoPath)) && (locala.lBf.lBi > 0L))
    {
      locala.lBf.lBp = bt.flT();
      locala.a(locale, parama, paramb, "onMediaPlayerVideoStop");
    }
    AppMethodBeat.o(186946);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramb, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(186945);
    com.tencent.mm.plugin.appbrand.jsapi.ac.e.c.a locala = this.lyU;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e locale = bpO();
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
      locala.lBf.lBr = paramInt1;
      locala.lBf.lBs = paramInt2;
      locala.lBf.errorMsg = paramString;
      AppMethodBeat.o(186945);
      return;
      label183:
      if (!(paramb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)) {
        break;
      }
      locale.c(1234L, 75L, 1L);
      break;
      label207:
      if ((paramb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c))
      {
        locale.c(1234L, 77L, 1L);
        continue;
        label231:
        if (paramString.equalsIgnoreCase("MEDIA_ERR_DECODE"))
        {
          locale.c(1234L, 68L, 1L);
          if ((paramb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.d)) {
            locale.c(1234L, 73L, 1L);
          } else if ((paramb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)) {
            locale.c(1234L, 78L, 1L);
          }
        }
        else if (paramString.equalsIgnoreCase("MEDIA_ERR_SRC_NOT_SUPPORTED"))
        {
          locale.c(1234L, 66L, 1L);
          if ((paramb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.d)) {
            locale.c(1234L, 71L, 1L);
          } else if ((paramb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)) {
            locale.c(1234L, 76L, 1L);
          }
        }
        else
        {
          locale.c(1234L, 69L, 1L);
          if ((paramb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.d)) {
            locale.c(1234L, 74L, 1L);
          } else if ((paramb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)) {
            locale.c(1234L, 79L, 1L);
          }
        }
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramb, long paramLong)
  {
    AppMethodBeat.i(186942);
    com.tencent.mm.plugin.appbrand.jsapi.ac.e.c.a locala = this.lyU;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e locale = bpO();
    long l;
    if ((paramb != null) && (locale != null)) {
      if (locala.lBf.lBj <= 0L)
      {
        locala.lBf.lBj = bt.flT();
        locale.c(1234L, 21L, 1L);
        l = locala.lBf.lBj - locala.lBf.lBi;
        locala.lBf.lBk = l;
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
      if ((locala.lBf.duration <= 0L) && (paramLong > 0L))
      {
        paramLong = (1.0D * paramLong / 1000.0D);
        locala.lBf.duration = paramLong;
        locale.c(1234L, 35L, 1L);
        locale.c(1234L, 38L, paramLong);
        ad.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoPrepareEnd, duration:%s", new Object[] { Long.valueOf(paramLong) });
      }
      AppMethodBeat.o(186942);
      return;
      label259:
      if ((paramb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c))
      {
        locale.c(1234L, 46L, 1L);
        locale.c(1234L, 48L, l);
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramb, String paramString)
  {
    AppMethodBeat.i(186939);
    long l1 = 0L;
    if (com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.video.g.class) != null) {
      l1 = ((com.tencent.mm.plugin.appbrand.jsapi.video.g)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.video.g.class)).f(paramString, 0L, 9223372036854775807L);
    }
    if (l1 < 0L) {
      l1 = 0L;
    }
    for (;;)
    {
      ad.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "onVideoPathChanged, videoPath:%s, cachedSize:%s", new Object[] { paramString, Long.valueOf(l1) });
      if ((this.lyT != null) && (this.lyT.cuv != null)) {
        this.lyT.cuv.aL(l1);
      }
      com.tencent.mm.plugin.appbrand.jsapi.ac.e.c.a locala = this.lyU;
      Object localObject = bpO();
      if ((paramb != null) && (localObject != null) && (!bt.isNullOrNil(paramString)))
      {
        ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e)localObject).c(1234L, 10L, 1L);
        if (l1 > 0L)
        {
          ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e)localObject).c(1234L, 11L, 1L);
          long l2 = BigInteger.valueOf(l1).divide(com.tencent.mm.plugin.appbrand.jsapi.ac.e.c.a.lBe).longValue();
          ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e)localObject).c(1234L, 13L, l2);
          ad.d("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onVideoPathChanged, cachedSize:%s, cachedSizeInKB:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
        }
        localObject = locala.lBf;
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
        locala.lBf.lBh = l1;
        AppMethodBeat.o(186939);
        return;
      }
    }
  }
  
  public final String b(com.tencent.luggage.xweb_ext.extendplugin.a parama, String paramString)
  {
    AppMethodBeat.i(139564);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(139564);
      return paramString;
    }
    if ((!bt.isNullOrNil(paramString)) && (paramString.startsWith("cloud://")))
    {
      AppMethodBeat.o(139564);
      return null;
    }
    parama = parama.El();
    if ((!bt.isNullOrNil(paramString)) && (parama != null) && (parama.Fg() != null) && (parama.Fg().Lw(paramString)))
    {
      parama = parama.Fg().Mj(paramString);
      if (parama == null) {}
      for (;;)
      {
        ad.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "convertVideoPath, videoPath:%s", new Object[] { paramString });
        AppMethodBeat.o(139564);
        return paramString;
        paramString = "file://" + com.tencent.mm.vfs.q.B(parama.fOK());
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
  
  public final void b(com.tencent.luggage.xweb_ext.extendplugin.a parama, com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramb)
  {
    AppMethodBeat.i(186947);
    com.tencent.mm.plugin.appbrand.jsapi.ac.e.c.a locala = this.lyU;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e locale = bpO();
    if ((locale != null) && (!bt.isNullOrNil(locala.lBf.videoPath)) && (locala.lBf.lBi > 0L))
    {
      locala.lBf.lBq = bt.flT();
      locala.a(locale, parama, paramb, "onMediaPlayerVideoEnd");
    }
    AppMethodBeat.o(186947);
  }
  
  public final void b(com.tencent.luggage.xweb_ext.extendplugin.component.video.c paramc)
  {
    this.lyT = paramc;
  }
  
  public final void c(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramb)
  {
    AppMethodBeat.i(186941);
    com.tencent.mm.plugin.appbrand.jsapi.ac.e.c.a locala = this.lyU;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e locale = bpO();
    if ((paramb != null) && (locale != null) && (locala.lBf.lBi <= 0L))
    {
      locala.lBf.lBi = bt.flT();
      locale.c(1234L, 20L, 1L);
      if ((paramb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.d))
      {
        locale.c(1234L, 40L, 1L);
        AppMethodBeat.o(186941);
        return;
      }
      if ((paramb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)) {
        locale.c(1234L, 45L, 1L);
      }
    }
    AppMethodBeat.o(186941);
  }
  
  public final void d(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramb)
  {
    AppMethodBeat.i(186943);
    com.tencent.mm.plugin.appbrand.jsapi.ac.e.c.a locala = this.lyU;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e locale = bpO();
    if ((paramb != null) && (locale != null) && (locala.lBf.lBn <= 0L))
    {
      paramb = locala.lBf;
      paramb.lBl += 1;
      locala.lBf.lBn = bt.flT();
      locale.c(1234L, 20L, 1L);
    }
    AppMethodBeat.o(186943);
  }
  
  public final void e(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramb)
  {
    AppMethodBeat.i(186944);
    com.tencent.mm.plugin.appbrand.jsapi.ac.e.c.a locala = this.lyU;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e locale = bpO();
    if ((paramb != null) && (locale != null))
    {
      if (locala.lBf.lBo <= 0L)
      {
        locala.lBf.lBo = bt.flT();
        locale.c(1234L, 21L, 1L);
        long l = locala.lBf.lBo - locala.lBf.lBn;
        paramb = locala.lBf;
        paramb.lBm += l;
        locale.c(1234L, 23L, l);
        ad.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoBufferEnd, bufferTime:%s", new Object[] { Long.valueOf(l) });
      }
      paramb = locala.lBf;
      paramb.lBn = 0L;
      paramb.lBo = 0L;
    }
    AppMethodBeat.o(186944);
  }
  
  public final boolean j(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139566);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(139566);
      return false;
    }
    Object localObject = parama.FD();
    com.tencent.mm.plugin.appbrand.jsapi.c localc = ((com.tencent.mm.plugin.appbrand.h.b)parama).kjg;
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
      final int i;
      switch (((JSONArray)localObject).optInt(0, 90))
      {
      default: 
        i = 90;
      }
      for (;;)
      {
        parama.M(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(139553);
            if ((!parama.isRunning()) || (parama.lYc == null))
            {
              ad.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, invalid state");
              AppMethodBeat.o(139553);
              return;
            }
            com.tencent.mm.plugin.appbrand.r.a.d locald = parama.lYc.getFullscreenImpl();
            View localView = parama.lYc.getWrapperView();
            if ((locald != null) && (localView != null))
            {
              locald.O(localView, i);
              if (c.this.lyS != null) {
                locald.a(c.this.lyS);
              }
              ad.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, target orientation:%s", new Object[] { Integer.valueOf(i) });
              AppMethodBeat.o(139553);
              return;
            }
            ad.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, state error, FullscreenImp[%s], fullscreenWebView[%s]", new Object[] { locald, localView });
            AppMethodBeat.o(139553);
          }
        });
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
  
  public final boolean k(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139567);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(139567);
      return false;
    }
    parama = ((com.tencent.mm.plugin.appbrand.h.b)parama).kjg;
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
        parama.M(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(139554);
            if ((!parama.isRunning()) || (parama.lYc == null))
            {
              ad.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "exitFullscreen, invalid state");
              AppMethodBeat.o(139554);
              return;
            }
            com.tencent.mm.plugin.appbrand.r.a.d locald = parama.lYc.getFullscreenImpl();
            if (locald != null)
            {
              locald.aXV();
              ad.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "exitFullscreen");
              AppMethodBeat.o(139554);
              return;
            }
            ad.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "exitFullscreen, state error");
            AppMethodBeat.o(139554);
          }
        });
        AppMethodBeat.o(139567);
        return true;
      }
      parama = null;
    }
  }
  
  public final boolean t(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139568);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(139568);
      return false;
    }
    Object localObject = parama.FD();
    parama = ((com.tencent.mm.plugin.appbrand.h.b)parama).kjg;
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
  
  public final void u(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(186940);
    if ((parama != null) && ("wxfe02ecfe70800f46".equalsIgnoreCase(parama.getAppId())))
    {
      ad.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "onMediaPlayerVideoFirstFrame, send play event");
      com.tencent.mm.sdk.b.a.IbL.l(new com.tencent.mm.plugin.appbrand.jsapi.video.c.a());
    }
    AppMethodBeat.o(186940);
  }
  
  public final void v(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139578);
    if ((parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      parama = parama.El();
      this.lxV = parama.getAppId();
      if (!(parama instanceof com.tencent.mm.plugin.appbrand.q)) {
        break label80;
      }
      parama = ((com.tencent.mm.plugin.appbrand.q)parama).getRuntime();
    }
    for (;;)
    {
      if ((parama != null) && (!"wxfe02ecfe70800f46".equalsIgnoreCase(parama.mAppId))) {
        parama.jwS.a(this.lxX);
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
  
  public final void w(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139579);
    if ((parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      parama = parama.El();
      if ((parama instanceof com.tencent.mm.plugin.appbrand.q)) {
        parama = ((com.tencent.mm.plugin.appbrand.q)parama).getRuntime();
      }
    }
    for (;;)
    {
      if (parama != null)
      {
        if (!"wxfe02ecfe70800f46".equalsIgnoreCase(parama.mAppId)) {
          parama.jwS.b(this.lxX);
        }
        ad.d("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "markVideoPlayerRelease");
        if (this.lyT == null)
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
          parama = (com.tencent.mm.plugin.appbrand.jsapi.ac.a)parama.as(com.tencent.mm.plugin.appbrand.jsapi.ac.a.class);
          if (parama == null)
          {
            ad.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "markVideoPlayerRelease, audioOfVideoBackgroundPlayManager is null");
            AppMethodBeat.o(139579);
            return;
          }
          parama.f(this.lyT);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.e.c
 * JD-Core Version:    0.7.0.1
 */