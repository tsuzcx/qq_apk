package com.tencent.mm.plugin.appbrand.jsapi.ad.e;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Handler;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.ad.e.c.a.a;
import com.tencent.mm.plugin.appbrand.page.ax;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
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
  String lCt;
  private c.a lCv;
  com.tencent.mm.plugin.appbrand.platform.window.b lDq;
  com.tencent.luggage.xweb_ext.extendplugin.component.video.c lDr;
  private com.tencent.mm.plugin.appbrand.jsapi.ad.e.c.a lDs;
  
  public c()
  {
    AppMethodBeat.i(139557);
    this.lCv = new c.4(this);
    com.tencent.mm.plugin.appbrand.jsapi.ad.e.a.c localc = (com.tencent.mm.plugin.appbrand.jsapi.ad.e.a.c)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.ad.e.a.c.class);
    if (localc != null) {
      this.lDq = localc.bqC();
    }
    this.lDs = new com.tencent.mm.plugin.appbrand.jsapi.ad.e.c.a();
    AppMethodBeat.o(139557);
  }
  
  private com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e bqy()
  {
    if (this.lDr != null) {
      return this.lDr.cvb;
    }
    return null;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.f GJ()
  {
    AppMethodBeat.i(139561);
    g localg = new g();
    AppMethodBeat.o(139561);
    return localg;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e GK()
  {
    AppMethodBeat.i(139560);
    f localf = new f();
    AppMethodBeat.o(139560);
    return localf;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c GL()
  {
    AppMethodBeat.i(139558);
    d locald = new d();
    AppMethodBeat.o(139558);
    return locald;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d GM()
  {
    AppMethodBeat.i(139559);
    e locale = new e();
    AppMethodBeat.o(139559);
    return locale;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a GN()
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
    AppMethodBeat.i(220635);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(220635);
      return null;
    }
    long l = System.currentTimeMillis();
    Object localObject = (h)com.tencent.luggage.a.e.K(h.class);
    if (localObject == null)
    {
      parama = new com.tencent.mm.plugin.appbrand.jsapi.video.e.d();
      l = System.currentTimeMillis() - l;
      paramHandler = this.lDs;
      localObject = bqy();
      if ((parama != null) && (localObject != null))
      {
        if (!(parama instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.d)) {
          break label171;
        }
        ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e)localObject).c(1234L, 0L, 1L);
        ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e)localObject).c(1234L, 1L, l);
        label107:
        ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e)localObject).c(1234L, 6L, 1L);
        localObject = paramHandler.lFD;
        if (!(parama instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)) {
          break label210;
        }
      }
    }
    label171:
    label210:
    for (int i = 1;; i = 0)
    {
      ((a.a)localObject).lxL = i;
      paramHandler.lFD.lFE = l;
      AppMethodBeat.o(220635);
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
      ae.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "operateSnapshot, bitmap is null");
      parama.dw("fail:snapshot error");
      AppMethodBeat.o(178857);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.c localc = parama.Eo();
    String str = com.tencent.mm.loader.j.b.asv() + String.format(Locale.US, "%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    i locali;
    try
    {
      com.tencent.mm.sdk.platformtools.h.a(paramBitmap, 90, Bitmap.CompressFormat.JPEG, str, true);
      locali = new i();
      if (localc.Fl() != null)
      {
        if (localc.Fl().a(new k(str), "jpg", true, locali) == m.jPM) {
          break label257;
        }
        ae.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "operateSnapshot, save snapshot failed");
        parama.dw("fail:snapshot error");
        AppMethodBeat.o(178857);
        return;
      }
    }
    catch (IOException paramBitmap)
    {
      ae.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "operateSnapshot, save bitmap exception", new Object[] { paramBitmap });
      parama.dw("fail:snapshot error");
      AppMethodBeat.o(178857);
      return;
    }
    parama.dw("fail");
    AppMethodBeat.o(178857);
    return;
    label257:
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      ae.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "bitmap recycle " + paramBitmap.toString());
      paramBitmap.recycle();
    }
    ae.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "operateSnapshot, actualPath:%s path:%s", new Object[] { str, locali.value });
    paramBitmap = new HashMap();
    paramBitmap.put("tempImagePath", locali.value);
    paramBitmap.put("width", Integer.valueOf(i));
    paramBitmap.put("height", Integer.valueOf(j));
    parama.f("ok", paramBitmap);
    AppMethodBeat.o(178857);
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramb)
  {
    AppMethodBeat.i(220643);
    com.tencent.mm.plugin.appbrand.jsapi.ad.e.c.a locala = this.lDs;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e locale = bqy();
    if ((locale != null) && (!bu.isNullOrNil(locala.lFD.videoPath)) && (locala.lFD.lFG > 0L))
    {
      locala.lFD.lFN = bu.fpO();
      locala.a(locale, parama, paramb, "onMediaPlayerVideoStop");
    }
    AppMethodBeat.o(220643);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramb, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(220642);
    com.tencent.mm.plugin.appbrand.jsapi.ad.e.c.a locala = this.lDs;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e locale = bqy();
    if ((paramb != null) && (locale != null))
    {
      locale.c(1234L, 65L, 1L);
      ae.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoError, what:%s, extra:%s, msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if (!(paramb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.d)) {
        break label183;
      }
      locale.c(1234L, 70L, 1L);
      if (!bu.isNullOrNil(paramString))
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
      locala.lFD.lFP = paramInt1;
      locala.lFD.lFQ = paramInt2;
      locala.lFD.errorMsg = paramString;
      AppMethodBeat.o(220642);
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
    AppMethodBeat.i(220639);
    com.tencent.mm.plugin.appbrand.jsapi.ad.e.c.a locala = this.lDs;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e locale = bqy();
    long l;
    if ((paramb != null) && (locale != null)) {
      if (locala.lFD.lFH <= 0L)
      {
        locala.lFD.lFH = bu.fpO();
        locale.c(1234L, 21L, 1L);
        l = locala.lFD.lFH - locala.lFD.lFG;
        locala.lFD.lFI = l;
        locale.c(1234L, 23L, l);
        ae.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoPrepareEnd, prepareTime:%s", new Object[] { Long.valueOf(l) });
        if (!(paramb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.d)) {
          break label259;
        }
        locale.c(1234L, 41L, 1L);
        locale.c(1234L, 43L, l);
      }
    }
    for (;;)
    {
      if ((locala.lFD.duration <= 0L) && (paramLong > 0L))
      {
        paramLong = (1.0D * paramLong / 1000.0D);
        locala.lFD.duration = paramLong;
        locale.c(1234L, 35L, 1L);
        locale.c(1234L, 38L, paramLong);
        ae.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoPrepareEnd, duration:%s", new Object[] { Long.valueOf(paramLong) });
      }
      AppMethodBeat.o(220639);
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
    AppMethodBeat.i(220636);
    long l1 = 0L;
    if (com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.video.g.class) != null) {
      l1 = ((com.tencent.mm.plugin.appbrand.jsapi.video.g)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.video.g.class)).f(paramString, 0L, 9223372036854775807L);
    }
    if (l1 < 0L) {
      l1 = 0L;
    }
    for (;;)
    {
      ae.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "onVideoPathChanged, videoPath:%s, cachedSize:%s", new Object[] { paramString, Long.valueOf(l1) });
      if ((this.lDr != null) && (this.lDr.cuY != null)) {
        this.lDr.cuY.aL(l1);
      }
      com.tencent.mm.plugin.appbrand.jsapi.ad.e.c.a locala = this.lDs;
      Object localObject = bqy();
      if ((paramb != null) && (localObject != null) && (!bu.isNullOrNil(paramString)))
      {
        ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e)localObject).c(1234L, 10L, 1L);
        if (l1 > 0L)
        {
          ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e)localObject).c(1234L, 11L, 1L);
          long l2 = BigInteger.valueOf(l1).divide(com.tencent.mm.plugin.appbrand.jsapi.ad.e.c.a.lFC).longValue();
          ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e)localObject).c(1234L, 13L, l2);
          ae.d("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onVideoPathChanged, cachedSize:%s, cachedSizeInKB:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
        }
        localObject = locala.lFD;
        if (bu.isNullOrNil(paramString)) {
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
        locala.lFD.lFF = l1;
        AppMethodBeat.o(220636);
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
    if ((!bu.isNullOrNil(paramString)) && (paramString.startsWith("cloud://")))
    {
      AppMethodBeat.o(139564);
      return null;
    }
    parama = parama.Eo();
    if ((!bu.isNullOrNil(paramString)) && (parama != null) && (parama.Fl() != null) && (parama.Fl().LZ(paramString)))
    {
      parama = parama.Fl().MP(paramString);
      if (parama == null) {}
      for (;;)
      {
        ae.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "convertVideoPath, videoPath:%s", new Object[] { paramString });
        AppMethodBeat.o(139564);
        return paramString;
        paramString = "file://" + w.B(parama.fTh());
      }
    }
    parama = paramString;
    if (!bu.isNullOrNil(paramString))
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
    AppMethodBeat.i(220644);
    com.tencent.mm.plugin.appbrand.jsapi.ad.e.c.a locala = this.lDs;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e locale = bqy();
    if ((locale != null) && (!bu.isNullOrNil(locala.lFD.videoPath)) && (locala.lFD.lFG > 0L))
    {
      locala.lFD.lFO = bu.fpO();
      locala.a(locale, parama, paramb, "onMediaPlayerVideoEnd");
    }
    AppMethodBeat.o(220644);
  }
  
  public final void b(com.tencent.luggage.xweb_ext.extendplugin.component.video.c paramc)
  {
    this.lDr = paramc;
  }
  
  public final void c(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramb)
  {
    AppMethodBeat.i(220638);
    com.tencent.mm.plugin.appbrand.jsapi.ad.e.c.a locala = this.lDs;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e locale = bqy();
    if ((paramb != null) && (locale != null) && (locala.lFD.lFG <= 0L))
    {
      locala.lFD.lFG = bu.fpO();
      locale.c(1234L, 20L, 1L);
      if ((paramb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.d))
      {
        locale.c(1234L, 40L, 1L);
        AppMethodBeat.o(220638);
        return;
      }
      if ((paramb instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)) {
        locale.c(1234L, 45L, 1L);
      }
    }
    AppMethodBeat.o(220638);
  }
  
  public final void d(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramb)
  {
    AppMethodBeat.i(220640);
    com.tencent.mm.plugin.appbrand.jsapi.ad.e.c.a locala = this.lDs;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e locale = bqy();
    if ((paramb != null) && (locale != null) && (locala.lFD.lFL <= 0L))
    {
      paramb = locala.lFD;
      paramb.lFJ += 1;
      locala.lFD.lFL = bu.fpO();
      locale.c(1234L, 20L, 1L);
    }
    AppMethodBeat.o(220640);
  }
  
  public final void e(com.tencent.mm.plugin.appbrand.jsapi.video.e.b paramb)
  {
    AppMethodBeat.i(220641);
    com.tencent.mm.plugin.appbrand.jsapi.ad.e.c.a locala = this.lDs;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e locale = bqy();
    if ((paramb != null) && (locale != null))
    {
      if (locala.lFD.lFM <= 0L)
      {
        locala.lFD.lFM = bu.fpO();
        locale.c(1234L, 21L, 1L);
        long l = locala.lFD.lFM - locala.lFD.lFL;
        paramb = locala.lFD;
        paramb.lFK += l;
        locale.c(1234L, 23L, l);
        ae.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoBufferEnd, bufferTime:%s", new Object[] { Long.valueOf(l) });
      }
      paramb = locala.lFD;
      paramb.lFL = 0L;
      paramb.lFM = 0L;
    }
    AppMethodBeat.o(220641);
  }
  
  public final boolean j(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139566);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(139566);
      return false;
    }
    Object localObject = parama.FJ();
    com.tencent.mm.plugin.appbrand.jsapi.c localc = ((com.tencent.mm.plugin.appbrand.h.b)parama).kmw;
    parama = null;
    if ((localc instanceof z)) {
      parama = (z)localc;
    }
    while (parama == null)
    {
      ae.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, page view is null");
      AppMethodBeat.o(139566);
      return false;
      if ((localc instanceof r)) {
        parama = ((r)localc).getCurrentPageView();
      }
    }
    if ((localObject != null) && (((JSONObject)localObject).has("data")))
    {
      localObject = ((JSONObject)localObject).optJSONArray("data");
      if ((localObject == null) || (((JSONArray)localObject).length() == 0))
      {
        ae.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, data array is null");
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
        parama.K(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(139553);
            if ((!parama.isRunning()) || (parama.mcJ == null))
            {
              ae.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, invalid state");
              AppMethodBeat.o(139553);
              return;
            }
            com.tencent.mm.plugin.appbrand.platform.window.d locald = parama.mcJ.getFullscreenImpl();
            View localView = parama.mcJ.getWrapperView();
            if ((locald != null) && (localView != null))
            {
              locald.O(localView, i);
              if (c.this.lDq != null) {
                locald.a(c.this.lDq);
              }
              ae.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, target orientation:%s", new Object[] { Integer.valueOf(i) });
              AppMethodBeat.o(139553);
              return;
            }
            ae.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, state error, FullscreenImp[%s], fullscreenWebView[%s]", new Object[] { locald, localView });
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
    parama = ((com.tencent.mm.plugin.appbrand.h.b)parama).kmw;
    if ((parama instanceof z)) {
      parama = (z)parama;
    }
    for (;;)
    {
      if (parama == null)
      {
        ae.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "exitFullscreen, page view is null");
        AppMethodBeat.o(139567);
        return false;
        if ((parama instanceof r)) {
          parama = ((r)parama).getCurrentPageView();
        }
      }
      else
      {
        parama.K(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(139554);
            if ((!parama.isRunning()) || (parama.mcJ == null))
            {
              ae.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "exitFullscreen, invalid state");
              AppMethodBeat.o(139554);
              return;
            }
            com.tencent.mm.plugin.appbrand.platform.window.d locald = parama.mcJ.getFullscreenImpl();
            if (locald != null)
            {
              locald.aYo();
              ae.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "exitFullscreen");
              AppMethodBeat.o(139554);
              return;
            }
            ae.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "exitFullscreen, state error");
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
    Object localObject = parama.FJ();
    parama = ((com.tencent.mm.plugin.appbrand.h.b)parama).kmw;
    if ((parama instanceof z)) {
      parama = (z)parama;
    }
    for (;;)
    {
      if (parama == null)
      {
        ae.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "setScreenBrightness, page view is null");
        AppMethodBeat.o(139568);
        return false;
        if ((parama instanceof r)) {
          parama = ((r)parama).getCurrentPageView();
        }
      }
      else
      {
        if ((localObject != null) && (((JSONObject)localObject).has("data")))
        {
          localObject = ((JSONObject)localObject).optJSONArray("data");
          if ((localObject == null) || (((JSONArray)localObject).length() == 0))
          {
            ae.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "setScreenBrightness, data array is null");
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
            ar.f(new c.3(this, (Activity)parama.getContext(), f));
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
    AppMethodBeat.i(220637);
    if ((parama != null) && ("wxfe02ecfe70800f46".equalsIgnoreCase(parama.getAppId())))
    {
      ae.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "onMediaPlayerVideoFirstFrame, send play event");
      com.tencent.mm.sdk.b.a.IvT.l(new com.tencent.mm.plugin.appbrand.jsapi.video.c.a());
    }
    AppMethodBeat.o(220637);
  }
  
  public final void v(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139578);
    if ((parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      parama = parama.Eo();
      this.lCt = parama.getAppId();
      if (!(parama instanceof r)) {
        break label88;
      }
      parama = ((r)parama).getRuntime();
    }
    for (;;)
    {
      if ((parama != null) && (!"wxfe02ecfe70800f46".equalsIgnoreCase(parama.mAppId)))
      {
        ae.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "addOnRunningStateChangedListener");
        parama.jzQ.a(this.lCv);
      }
      AppMethodBeat.o(139578);
      return;
      label88:
      if ((parama instanceof z)) {
        parama = ((z)parama).getRuntime();
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
      parama = parama.Eo();
      if ((parama instanceof r)) {
        parama = ((r)parama).getRuntime();
      }
    }
    for (;;)
    {
      if (parama != null)
      {
        if (!"wxfe02ecfe70800f46".equalsIgnoreCase(parama.mAppId))
        {
          ae.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "removeOnRunningStateChangedListener");
          parama.jzQ.b(this.lCv);
        }
        ae.d("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "markVideoPlayerRelease");
        if (this.lDr == null)
        {
          ae.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "markVideoPlayerRelease, pluginHandler is null");
          AppMethodBeat.o(139579);
          return;
          if ((parama instanceof z)) {
            parama = ((z)parama).getRuntime();
          }
        }
        else
        {
          parama = (com.tencent.mm.plugin.appbrand.jsapi.ad.a)parama.as(com.tencent.mm.plugin.appbrand.jsapi.ad.a.class);
          if (parama == null)
          {
            ae.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "markVideoPlayerRelease, audioOfVideoBackgroundPlayManager is null");
            AppMethodBeat.o(139579);
            return;
          }
          parama.f(this.lDr);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.e.c
 * JD-Core Version:    0.7.0.1
 */