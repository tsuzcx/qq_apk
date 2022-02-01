package com.tencent.mm.plugin.appbrand.jsapi.z.e;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.luggage.k.a.a.b.b.11;
import com.tencent.luggage.k.a.a.b.b.13;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.z.e.c.a.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ay;
import com.tencent.mm.plugin.appbrand.z.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  String laV;
  private c.a laW;
  com.tencent.mm.plugin.appbrand.r.a.b lbS;
  com.tencent.luggage.k.a.a.b.b lbT;
  private com.tencent.mm.plugin.appbrand.jsapi.z.e.c.a lbU;
  
  public c()
  {
    AppMethodBeat.i(139557);
    this.laW = new c.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.b.b paramAnonymousb)
      {
        AppMethodBeat.i(139556);
        if (paramAnonymousString.equalsIgnoreCase(c.this.laV)) {
          if (paramAnonymousb == com.tencent.mm.plugin.appbrand.b.b.jqV)
          {
            if (c.this.lbT != null)
            {
              paramAnonymousString = c.this.lbT;
              paramAnonymousString.k(new b.13(paramAnonymousString));
              AppMethodBeat.o(139556);
            }
          }
          else if ((paramAnonymousb == com.tencent.mm.plugin.appbrand.b.b.jqU) && (c.this.lbT != null))
          {
            paramAnonymousString = c.this.lbT;
            paramAnonymousString.k(new b.11(paramAnonymousString));
          }
        }
        AppMethodBeat.o(139556);
      }
    };
    com.tencent.mm.plugin.appbrand.jsapi.z.e.a.c localc = (com.tencent.mm.plugin.appbrand.jsapi.z.e.a.c)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.z.e.a.c.class);
    if (localc != null) {
      this.lbS = localc.bmh();
    }
    this.lbU = new com.tencent.mm.plugin.appbrand.jsapi.z.e.c.a();
    AppMethodBeat.o(139557);
  }
  
  private com.tencent.luggage.k.a.a.b.b.e bmd()
  {
    if (this.lbT != null) {
      return this.lbT.cjY;
    }
    return null;
  }
  
  public final com.tencent.luggage.k.a.a.b.b.f Fj()
  {
    AppMethodBeat.i(139561);
    g localg = new g();
    AppMethodBeat.o(139561);
    return localg;
  }
  
  public final com.tencent.luggage.k.a.a.b.b.e Fk()
  {
    AppMethodBeat.i(139560);
    f localf = new f();
    AppMethodBeat.o(139560);
    return localf;
  }
  
  public final com.tencent.luggage.k.a.a.b.b.c Fl()
  {
    AppMethodBeat.i(139558);
    d locald = new d();
    AppMethodBeat.o(139558);
    return locald;
  }
  
  public final com.tencent.luggage.k.a.a.b.b.d Fm()
  {
    AppMethodBeat.i(139559);
    e locale = new e();
    AppMethodBeat.o(139559);
    return locale;
  }
  
  public final com.tencent.luggage.k.a.a.b.b.a Fn()
  {
    AppMethodBeat.i(139577);
    a locala = new a();
    AppMethodBeat.o(139577);
    return locala;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.video.e.b a(com.tencent.luggage.k.a.a parama, Handler paramHandler)
  {
    AppMethodBeat.i(206750);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      AppMethodBeat.o(206750);
      return null;
    }
    long l = System.currentTimeMillis();
    Object localObject = (h)com.tencent.luggage.a.e.K(h.class);
    if (localObject == null)
    {
      parama = new com.tencent.mm.plugin.appbrand.jsapi.video.e.d();
      l = System.currentTimeMillis() - l;
      paramHandler = this.lbU;
      localObject = bmd();
      if ((parama != null) && (localObject != null))
      {
        if (!(parama instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.d)) {
          break label171;
        }
        ((com.tencent.luggage.k.a.a.b.b.e)localObject).c(1234L, 0L, 1L);
        ((com.tencent.luggage.k.a.a.b.b.e)localObject).c(1234L, 1L, l);
        label107:
        ((com.tencent.luggage.k.a.a.b.b.e)localObject).c(1234L, 6L, 1L);
        localObject = paramHandler.lef;
        if (!(parama instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)) {
          break label210;
        }
      }
    }
    label171:
    label210:
    for (int i = 1;; i = 0)
    {
      ((a.a)localObject).kWn = i;
      paramHandler.lef.leg = l;
      AppMethodBeat.o(206750);
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
  
  public final b a(com.tencent.luggage.k.a.a.b.b.a parama, com.tencent.luggage.k.a.a parama1)
  {
    AppMethodBeat.i(139562);
    parama = new b(parama, parama1);
    AppMethodBeat.o(139562);
    return parama;
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
      ac.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "operateSnapshot, bitmap is null");
      parama.cs("fail:snapshot error");
      AppMethodBeat.o(178857);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.c localc = parama.CM();
    String str = com.tencent.mm.loader.j.b.aps() + String.format(Locale.US, "%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    i locali;
    try
    {
      com.tencent.mm.sdk.platformtools.f.a(paramBitmap, 90, Bitmap.CompressFormat.JPEG, str, true);
      locali = new i();
      if (localc.DH() != null)
      {
        if (localc.DH().a(new com.tencent.mm.vfs.e(str), "jpg", true, locali) == l.jsB) {
          break label257;
        }
        ac.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "operateSnapshot, save snapshot failed");
        parama.cs("fail:snapshot error");
        AppMethodBeat.o(178857);
        return;
      }
    }
    catch (IOException paramBitmap)
    {
      ac.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "operateSnapshot, save bitmap exception", new Object[] { paramBitmap });
      parama.cs("fail:snapshot error");
      AppMethodBeat.o(178857);
      return;
    }
    parama.cs("fail");
    AppMethodBeat.o(178857);
    return;
    label257:
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      ac.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "bitmap recycle " + paramBitmap.toString());
      paramBitmap.recycle();
    }
    ac.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "operateSnapshot, actualPath:%s path:%s", new Object[] { str, locali.value });
    paramBitmap = new HashMap();
    paramBitmap.put("tempImagePath", locali.value);
    paramBitmap.put("width", Integer.valueOf(i));
    paramBitmap.put("height", Integer.valueOf(j));
    parama.d("ok", paramBitmap);
    AppMethodBeat.o(178857);
  }
  
  public final void a(com.tencent.luggage.k.a.a parama, com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramb)
  {
    AppMethodBeat.i(206758);
    com.tencent.mm.plugin.appbrand.jsapi.z.e.c.a locala = this.lbU;
    com.tencent.luggage.k.a.a.b.b.e locale = bmd();
    if ((locale != null) && (!bs.isNullOrNil(locala.lef.videoPath)) && (locala.lef.lei > 0L))
    {
      locala.lef.leq = bs.eWj();
      locala.a(locale, parama, paramb, "onMediaPlayerVideoStop");
    }
    AppMethodBeat.o(206758);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramb, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(206757);
    com.tencent.mm.plugin.appbrand.jsapi.z.e.c.a locala = this.lbU;
    com.tencent.luggage.k.a.a.b.b.e locale = bmd();
    if ((paramb != null) && (locale != null))
    {
      locale.c(1234L, 65L, 1L);
      ac.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoError, what:%s, extra:%s, msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if (!(paramb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.d)) {
        break label183;
      }
      locale.c(1234L, 70L, 1L);
      if (!bs.isNullOrNil(paramString))
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
      locala.lef.les = paramInt1;
      locala.lef.let = paramInt2;
      locala.lef.errorMsg = paramString;
      AppMethodBeat.o(206757);
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
    AppMethodBeat.i(206754);
    com.tencent.mm.plugin.appbrand.jsapi.z.e.c.a locala = this.lbU;
    com.tencent.luggage.k.a.a.b.b.e locale = bmd();
    long l;
    if ((paramb != null) && (locale != null)) {
      if (locala.lef.lej <= 0L)
      {
        locala.lef.lej = bs.eWj();
        locale.c(1234L, 21L, 1L);
        l = locala.lef.lej - locala.lef.lei;
        locala.lef.lek = l;
        locale.c(1234L, 23L, l);
        ac.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoPrepareEnd, prepareTime:%s", new Object[] { Long.valueOf(l) });
        if (!(paramb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.d)) {
          break label259;
        }
        locale.c(1234L, 41L, 1L);
        locale.c(1234L, 43L, l);
      }
    }
    for (;;)
    {
      if ((locala.lef.duration <= 0L) && (paramLong > 0L))
      {
        paramLong = (1.0D * paramLong / 1000.0D);
        locala.lef.duration = paramLong;
        locale.c(1234L, 35L, 1L);
        locale.c(1234L, 38L, paramLong);
        ac.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoPrepareEnd, duration:%s", new Object[] { Long.valueOf(paramLong) });
      }
      AppMethodBeat.o(206754);
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
    AppMethodBeat.i(206751);
    long l1 = 0L;
    if (com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.video.g.class) != null) {
      l1 = ((com.tencent.mm.plugin.appbrand.jsapi.video.g)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.video.g.class)).f(paramString, 0L, 9223372036854775807L);
    }
    if (l1 < 0L) {
      l1 = 0L;
    }
    for (;;)
    {
      ac.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "onVideoPathChanged, videoPath:%s, cachedSize:%s", new Object[] { paramString, Long.valueOf(l1) });
      if ((this.lbT != null) && (this.lbT.cjV != null)) {
        this.lbT.cjV.aL(l1);
      }
      com.tencent.mm.plugin.appbrand.jsapi.z.e.c.a locala = this.lbU;
      Object localObject = bmd();
      if ((paramb != null) && (localObject != null) && (!bs.isNullOrNil(paramString)))
      {
        ((com.tencent.luggage.k.a.a.b.b.e)localObject).c(1234L, 10L, 1L);
        if (l1 > 0L)
        {
          ((com.tencent.luggage.k.a.a.b.b.e)localObject).c(1234L, 11L, 1L);
          long l2 = BigInteger.valueOf(l1).divide(com.tencent.mm.plugin.appbrand.jsapi.z.e.c.a.lee).longValue();
          ((com.tencent.luggage.k.a.a.b.b.e)localObject).c(1234L, 13L, l2);
          ac.d("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onVideoPathChanged, cachedSize:%s, cachedSizeInKB:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
        }
        localObject = locala.lef;
        if (bs.isNullOrNil(paramString)) {
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
        locala.lef.leh = l1;
        AppMethodBeat.o(206751);
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
    if ((!bs.isNullOrNil(paramString)) && (paramString.startsWith("cloud://")))
    {
      AppMethodBeat.o(139564);
      return null;
    }
    parama = parama.CM();
    if ((!bs.isNullOrNil(paramString)) && (parama != null) && (parama.DH() != null) && (parama.DH().Ie(paramString)))
    {
      parama = parama.DH().IS(paramString);
      if (parama == null) {}
      for (;;)
      {
        ac.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "convertVideoPath, videoPath:%s", new Object[] { paramString });
        AppMethodBeat.o(139564);
        return paramString;
        paramString = "file://" + com.tencent.mm.vfs.q.B(parama.fxV());
      }
    }
    parama = paramString;
    if (!bs.isNullOrNil(paramString))
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
    this.lbT = paramb;
  }
  
  public final void b(com.tencent.luggage.k.a.a parama, com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramb)
  {
    AppMethodBeat.i(206759);
    com.tencent.mm.plugin.appbrand.jsapi.z.e.c.a locala = this.lbU;
    com.tencent.luggage.k.a.a.b.b.e locale = bmd();
    if ((locale != null) && (!bs.isNullOrNil(locala.lef.videoPath)) && (locala.lef.lei > 0L))
    {
      locala.lef.ler = bs.eWj();
      locala.a(locale, parama, paramb, "onMediaPlayerVideoEnd");
    }
    AppMethodBeat.o(206759);
  }
  
  public final void c(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramb)
  {
    AppMethodBeat.i(206753);
    com.tencent.mm.plugin.appbrand.jsapi.z.e.c.a locala = this.lbU;
    com.tencent.luggage.k.a.a.b.b.e locale = bmd();
    if ((paramb != null) && (locale != null) && (locala.lef.lei <= 0L))
    {
      locala.lef.lei = bs.eWj();
      locale.c(1234L, 20L, 1L);
      if ((paramb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.d))
      {
        locale.c(1234L, 40L, 1L);
        AppMethodBeat.o(206753);
        return;
      }
      if ((paramb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)) {
        locale.c(1234L, 45L, 1L);
      }
    }
    AppMethodBeat.o(206753);
  }
  
  public final void d(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramb)
  {
    AppMethodBeat.i(206755);
    com.tencent.mm.plugin.appbrand.jsapi.z.e.c.a locala = this.lbU;
    com.tencent.luggage.k.a.a.b.b.e locale = bmd();
    if ((paramb != null) && (locale != null) && (locala.lef.leo <= 0L))
    {
      paramb = locala.lef;
      paramb.lel += 1;
      locala.lef.leo = bs.eWj();
      locale.c(1234L, 20L, 1L);
    }
    AppMethodBeat.o(206755);
  }
  
  public final void e(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramb)
  {
    AppMethodBeat.i(206756);
    com.tencent.mm.plugin.appbrand.jsapi.z.e.c.a locala = this.lbU;
    com.tencent.luggage.k.a.a.b.b.e locale = bmd();
    if ((paramb != null) && (locale != null))
    {
      if (locala.lef.lep <= 0L)
      {
        locala.lef.lep = bs.eWj();
        locale.c(1234L, 21L, 1L);
        long l = locala.lef.lep - locala.lef.leo;
        paramb = locala.lef;
        paramb.lem += l;
        locale.c(1234L, 23L, l);
        ac.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoBufferEnd, bufferTime:%s", new Object[] { Long.valueOf(l) });
      }
      paramb = locala.lef;
      paramb.leo = 0L;
      paramb.lep = 0L;
    }
    AppMethodBeat.o(206756);
  }
  
  public final boolean j(final com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(139566);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      AppMethodBeat.o(139566);
      return false;
    }
    Object localObject = parama.Ee();
    com.tencent.mm.plugin.appbrand.jsapi.c localc = ((com.tencent.mm.plugin.appbrand.i.b)parama).jOV;
    parama = null;
    if ((localc instanceof aa)) {
      parama = (aa)localc;
    }
    while (parama == null)
    {
      ac.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, page view is null");
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
        ac.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, data array is null");
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
        parama.N(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(139553);
            if ((!parama.isRunning()) || (parama.lyE == null))
            {
              ac.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, invalid state");
              AppMethodBeat.o(139553);
              return;
            }
            com.tencent.mm.plugin.appbrand.r.a.d locald = parama.lyE.getFullscreenImpl();
            View localView = parama.lyE.getWrapperView();
            if ((locald != null) && (localView != null))
            {
              locald.O(localView, i);
              if (c.this.lbS != null) {
                locald.a(c.this.lbS);
              }
              ac.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, target orientation:%s", new Object[] { Integer.valueOf(i) });
              AppMethodBeat.o(139553);
              return;
            }
            ac.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, state error, FullscreenImp[%s], fullscreenWebView[%s]", new Object[] { locald, localView });
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
  
  public final boolean k(final com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(139567);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      AppMethodBeat.o(139567);
      return false;
    }
    parama = ((com.tencent.mm.plugin.appbrand.i.b)parama).jOV;
    if ((parama instanceof aa)) {
      parama = (aa)parama;
    }
    for (;;)
    {
      if (parama == null)
      {
        ac.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "exitFullscreen, page view is null");
        AppMethodBeat.o(139567);
        return false;
        if ((parama instanceof com.tencent.mm.plugin.appbrand.q)) {
          parama = ((com.tencent.mm.plugin.appbrand.q)parama).getCurrentPageView();
        }
      }
      else
      {
        parama.N(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(139554);
            if ((!parama.isRunning()) || (parama.lyE == null))
            {
              ac.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "exitFullscreen, invalid state");
              AppMethodBeat.o(139554);
              return;
            }
            com.tencent.mm.plugin.appbrand.r.a.d locald = parama.lyE.getFullscreenImpl();
            if (locald != null)
            {
              locald.aUJ();
              ac.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "exitFullscreen");
              AppMethodBeat.o(139554);
              return;
            }
            ac.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "exitFullscreen, state error");
            AppMethodBeat.o(139554);
          }
        });
        AppMethodBeat.o(139567);
        return true;
      }
      parama = null;
    }
  }
  
  public final boolean t(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(139568);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      AppMethodBeat.o(139568);
      return false;
    }
    Object localObject = parama.Ee();
    parama = ((com.tencent.mm.plugin.appbrand.i.b)parama).jOV;
    if ((parama instanceof aa)) {
      parama = (aa)parama;
    }
    for (;;)
    {
      if (parama == null)
      {
        ac.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "setScreenBrightness, page view is null");
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
            ac.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "setScreenBrightness, data array is null");
            AppMethodBeat.o(139568);
            return false;
          }
          final float f = (float)((JSONArray)localObject).optDouble(0, -1.0D);
          if ((Float.isNaN(f)) || (f < 0.0F) || (f > 1.0F))
          {
            AppMethodBeat.o(139568);
            return false;
          }
          if ((parama.getContext() instanceof Activity))
          {
            ap.f(new Runnable()
            {
              public final void run()
              {
                float f = 0.01F;
                AppMethodBeat.i(139555);
                WindowManager.LayoutParams localLayoutParams = this.val$activity.getWindow().getAttributes();
                if (f < 0.01F) {}
                for (;;)
                {
                  localLayoutParams.screenBrightness = f;
                  this.val$activity.getWindow().setAttributes(localLayoutParams);
                  ac.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "setScreenBrightness, brightness:%s", new Object[] { Float.valueOf(localLayoutParams.screenBrightness) });
                  AppMethodBeat.o(139555);
                  return;
                  f = f;
                }
              }
            });
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
  
  public final void u(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(206752);
    if ((parama != null) && ("wxfe02ecfe70800f46".equalsIgnoreCase(parama.getAppId())))
    {
      ac.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "onMediaPlayerVideoFirstFrame, send play event");
      com.tencent.mm.sdk.b.a.GpY.l(new com.tencent.mm.plugin.appbrand.jsapi.video.c.a());
    }
    AppMethodBeat.o(206752);
  }
  
  public final void v(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(139578);
    if ((parama instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      parama = parama.CM();
      this.laV = parama.getAppId();
      if (!(parama instanceof com.tencent.mm.plugin.appbrand.q)) {
        break label80;
      }
      parama = ((com.tencent.mm.plugin.appbrand.q)parama).getRuntime();
    }
    for (;;)
    {
      if ((parama != null) && (!"wxfe02ecfe70800f46".equalsIgnoreCase(parama.mAppId))) {
        parama.jdK.a(this.laW);
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
  
  public final void w(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(139579);
    if ((parama instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      parama = parama.CM();
      if ((parama instanceof com.tencent.mm.plugin.appbrand.q)) {
        parama = ((com.tencent.mm.plugin.appbrand.q)parama).getRuntime();
      }
    }
    for (;;)
    {
      if (parama != null)
      {
        if (!"wxfe02ecfe70800f46".equalsIgnoreCase(parama.mAppId)) {
          parama.jdK.b(this.laW);
        }
        ac.d("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "markVideoPlayerRelease");
        if (this.lbT == null)
        {
          ac.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "markVideoPlayerRelease, pluginHandler is null");
          AppMethodBeat.o(139579);
          return;
          if ((parama instanceof aa)) {
            parama = ((aa)parama).getRuntime();
          }
        }
        else
        {
          parama = (com.tencent.mm.plugin.appbrand.jsapi.z.a)parama.as(com.tencent.mm.plugin.appbrand.jsapi.z.a.class);
          if (parama == null)
          {
            ac.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "markVideoPlayerRelease, audioOfVideoBackgroundPlayManager is null");
            AppMethodBeat.o(139579);
            return;
          }
          parama.f(this.lbT);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.e.c
 * JD-Core Version:    0.7.0.1
 */