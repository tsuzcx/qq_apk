package com.tencent.mm.plugin.appbrand.jsapi.ai.e;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.c.15;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.c.17;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.ai.e.c.a.1;
import com.tencent.mm.plugin.appbrand.jsapi.ai.e.c.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g.b;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.vfs.q;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class c
  implements com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b
{
  String currentAppId;
  private c.a pKS;
  com.tencent.mm.plugin.appbrand.platform.window.b pLQ;
  com.tencent.luggage.xweb_ext.extendplugin.component.video.c pLR;
  protected final com.tencent.mm.plugin.appbrand.jsapi.ai.e.c.a pLS;
  
  public c()
  {
    AppMethodBeat.i(139557);
    this.pKS = new c.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.a.b paramAnonymousb)
      {
        AppMethodBeat.i(139556);
        if (paramAnonymousString.equalsIgnoreCase(c.this.currentAppId))
        {
          Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "onRunningStateChanged, state: ".concat(String.valueOf(paramAnonymousb)));
          if (paramAnonymousb == com.tencent.mm.plugin.appbrand.a.b.nKQ)
          {
            if (c.this.pLR != null)
            {
              paramAnonymousString = c.this.pLR;
              paramAnonymousString.k(new c.17(paramAnonymousString));
              AppMethodBeat.o(139556);
            }
          }
          else if ((paramAnonymousb == com.tencent.mm.plugin.appbrand.a.b.nKP) && (c.this.pLR != null))
          {
            paramAnonymousString = c.this.pLR;
            paramAnonymousString.k(new c.15(paramAnonymousString));
          }
        }
        AppMethodBeat.o(139556);
      }
    };
    com.tencent.mm.plugin.appbrand.jsapi.ai.e.a.c localc = (com.tencent.mm.plugin.appbrand.jsapi.ai.e.a.c)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.ai.e.a.c.class);
    if (localc != null) {
      this.pLQ = localc.bYE();
    }
    this.pLS = bYz();
    AppMethodBeat.o(139557);
  }
  
  private com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e bYA()
  {
    if (this.pLR != null) {
      return this.pLR.cJD;
    }
    return null;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.f Uj()
  {
    AppMethodBeat.i(139561);
    g localg = new g();
    AppMethodBeat.o(139561);
    return localg;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e Uk()
  {
    AppMethodBeat.i(139560);
    f localf = new f();
    AppMethodBeat.o(139560);
    return localf;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c Ul()
  {
    AppMethodBeat.i(139558);
    d locald = new d();
    AppMethodBeat.o(139558);
    return locald;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d Um()
  {
    AppMethodBeat.i(139559);
    e locale = new e();
    AppMethodBeat.o(139559);
    return locale;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a Un()
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
  
  public final com.tencent.mm.plugin.appbrand.jsapi.video.e.e a(com.tencent.luggage.xweb_ext.extendplugin.a parama, Handler paramHandler)
  {
    AppMethodBeat.i(221259);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(221259);
      return null;
    }
    long l = System.currentTimeMillis();
    Object localObject = (h)com.tencent.luggage.a.e.K(h.class);
    com.tencent.mm.plugin.appbrand.jsapi.ai.e.c.a locala;
    if (localObject == null)
    {
      parama = new com.tencent.mm.plugin.appbrand.jsapi.video.e.i();
      l = System.currentTimeMillis() - l;
      locala = this.pLS;
      paramHandler = bYA();
      if ((parama != null) && (paramHandler != null))
      {
        if (!(parama instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g)) {
          break label264;
        }
        paramHandler.c(1234L, 3L, 1L);
        paramHandler.c(1234L, 4L, l);
        locala.pOe.pDV = 1;
      }
    }
    for (;;)
    {
      paramHandler.c(1234L, 6L, 1L);
      locala.pOe.pOh = l;
      if ((parama instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a))
      {
        com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a locala1 = (com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a)parama;
        a.a locala2 = locala.pOe;
        localObject = locala1.pAD;
        paramHandler = (Handler)localObject;
        if (localObject == null)
        {
          int i = locala1.pAB;
          boolean bool = com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a.b.pBJ;
          paramHandler = com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c.pAQ;
          paramHandler = new a.b(i, bool, com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c.bWu());
          Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "getExtraInfo, extraInfo: ".concat(String.valueOf(paramHandler)));
          locala1.pAD = paramHandler;
        }
        locala2.pOu = paramHandler;
        locala1.pAE = new a.1(locala);
      }
      AppMethodBeat.o(221259);
      return parama;
      parama = ((h)localObject).a(parama, paramHandler);
      break;
      label264:
      if (locala.h(parama))
      {
        paramHandler.c(1234L, 87L, 1L);
        paramHandler.c(1234L, 88L, l);
        locala.pOe.pDV = 2;
      }
      else if ((parama instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.i))
      {
        paramHandler.c(1234L, 0L, 1L);
        paramHandler.c(1234L, 1L, l);
        locala.pOe.pDV = 0;
      }
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
      Log.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "operateSnapshot, bitmap is null");
      parama.er("fail:snapshot error");
      AppMethodBeat.o(178857);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.e locale = parama.QK();
    String str = AndroidMediaUtil.getSysCameraDirPath() + String.format(Locale.US, "%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    com.tencent.mm.plugin.appbrand.ac.i locali;
    try
    {
      BitmapUtil.saveBitmapToImage(paramBitmap, 90, Bitmap.CompressFormat.JPEG, str, true);
      locali = new com.tencent.mm.plugin.appbrand.ac.i();
      if (locale.getFileSystem() != null)
      {
        if (locale.getFileSystem().a(new q(str), "jpg", true, locali) == m.nMR) {
          break label261;
        }
        Log.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "operateSnapshot, save snapshot failed");
        parama.er("fail:snapshot error");
        AppMethodBeat.o(178857);
        return;
      }
    }
    catch (IOException paramBitmap)
    {
      Log.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "operateSnapshot, save bitmap exception", new Object[] { paramBitmap });
      parama.er("fail:snapshot error");
      AppMethodBeat.o(178857);
      return;
    }
    parama.er("fail");
    AppMethodBeat.o(178857);
    return;
    label261:
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "bitmap recycle " + paramBitmap.toString());
      paramBitmap.recycle();
    }
    Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "operateSnapshot, actualPath:%s path:%s", new Object[] { str, locali.value });
    paramBitmap = new HashMap();
    paramBitmap.put("tempImagePath", locali.value);
    paramBitmap.put("width", Integer.valueOf(i));
    paramBitmap.put("height", Integer.valueOf(j));
    parama.e("ok", paramBitmap);
    AppMethodBeat.o(178857);
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, com.tencent.mm.plugin.appbrand.jsapi.video.e.e parame)
  {
    AppMethodBeat.i(221361);
    com.tencent.mm.plugin.appbrand.jsapi.ai.e.c.a locala = this.pLS;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e locale = bYA();
    if ((locale != null) && (!Util.isNullOrNil(locala.pOe.videoPath)) && (locala.pOe.pOj > 0L))
    {
      locala.pOe.pOq = Util.nowMilliSecond();
      locala.a(locale, parama, parame, "onMediaPlayerVideoStop");
    }
    AppMethodBeat.o(221361);
  }
  
  public final void a(g.b paramb)
  {
    AppMethodBeat.i(221355);
    com.tencent.mm.plugin.appbrand.jsapi.ai.e.c.a.a(bYA(), paramb);
    AppMethodBeat.o(221355);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.e parame, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(221351);
    this.pLS.a(bYA(), parame, paramInt1, paramInt2, paramString);
    AppMethodBeat.o(221351);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.e parame, long paramLong)
  {
    AppMethodBeat.i(221338);
    com.tencent.mm.plugin.appbrand.jsapi.ai.e.c.a locala = this.pLS;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e locale = bYA();
    long l;
    if ((parame != null) && (locale != null)) {
      if (locala.pOe.pOk <= 0L)
      {
        locala.pOe.pOk = Util.nowMilliSecond();
        locale.c(1234L, 21L, 1L);
        l = locala.pOe.pOk - locala.pOe.pOj;
        locala.pOe.pOl = l;
        locale.c(1234L, 23L, l);
        Log.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoPrepareEnd, prepareTime:%s", new Object[] { Long.valueOf(l) });
        if (!(parame instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g)) {
          break label245;
        }
        locale.c(1234L, 46L, 1L);
        locale.c(1234L, 48L, l);
      }
    }
    for (;;)
    {
      if ((locala.pOe.duration <= 0L) && (paramLong > 0L))
      {
        paramLong = (1.0D * paramLong / 1000.0D);
        locala.pOe.duration = paramLong;
        locale.c(1234L, 35L, 1L);
        Log.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoPrepareEnd, duration:%s", new Object[] { Long.valueOf(paramLong) });
      }
      AppMethodBeat.o(221338);
      return;
      label245:
      if (locala.h(parame))
      {
        locale.c(1234L, 93L, 1L);
        locale.c(1234L, 95L, l);
      }
      else if ((parame instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.i))
      {
        locale.c(1234L, 41L, 1L);
        locale.c(1234L, 43L, l);
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.e parame, String paramString)
  {
    AppMethodBeat.i(221298);
    long l2 = 0L;
    boolean bool = g(parame);
    long l1 = l2;
    if (bool)
    {
      l1 = l2;
      if (com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.video.f.class) != null) {
        l1 = ((com.tencent.mm.plugin.appbrand.jsapi.video.f)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.video.f.class)).f(paramString, 0L, 9223372036854775807L);
      }
    }
    if (l1 < 0L) {
      l1 = 0L;
    }
    for (;;)
    {
      Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "onVideoPathChanged, videoPath:%s, cachedSize:%s, isSupportGetCachedBytes: %b", new Object[] { paramString, Long.valueOf(l1), Boolean.valueOf(bool) });
      if ((bool) && (this.pLR != null) && (this.pLR.cJA != null)) {
        this.pLR.cJA.bf(l1);
      }
      com.tencent.mm.plugin.appbrand.jsapi.ai.e.c.a locala = this.pLS;
      Object localObject = bYA();
      if ((parame != null) && (localObject != null) && (!Util.isNullOrNil(paramString)))
      {
        ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e)localObject).c(1234L, 10L, 1L);
        if (l1 > 0L)
        {
          ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e)localObject).c(1234L, 11L, 1L);
          l2 = BigInteger.valueOf(l1).divide(com.tencent.mm.plugin.appbrand.jsapi.ai.e.c.a.pOd).longValue();
          ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e)localObject).c(1234L, 13L, l2);
          Log.d("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onVideoPathChanged, cachedSize:%s, cachedSizeInKB:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
        }
        localObject = locala.pOe;
        if (Util.isNullOrNil(paramString)) {
          break label307;
        }
        parame = paramString;
        if (paramString.length() > 512) {
          parame = paramString.substring(0, 512);
        }
      }
      label307:
      for (((a.a)localObject).videoPath = parame;; ((a.a)localObject).videoPath = "")
      {
        locala.pOe.pOi = l1;
        AppMethodBeat.o(221298);
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
    if ((!Util.isNullOrNil(paramString)) && (paramString.startsWith("cloud://")))
    {
      AppMethodBeat.o(139564);
      return null;
    }
    parama = parama.QK();
    if ((!Util.isNullOrNil(paramString)) && (parama != null) && (parama.getFileSystem() != null) && (parama.getFileSystem().acS(paramString)))
    {
      parama = parama.getFileSystem().adL(paramString);
      if (parama == null) {}
      for (;;)
      {
        Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "convertVideoPath, videoPath:%s", new Object[] { paramString });
        AppMethodBeat.o(139564);
        return paramString;
        paramString = "file://" + parama.bOF();
      }
    }
    parama = paramString;
    if (!Util.isNullOrNil(paramString))
    {
      parama = paramString;
      if (com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.video.f.class) != null) {
        parama = ((com.tencent.mm.plugin.appbrand.jsapi.video.f)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.video.f.class)).aQ(paramString);
      }
    }
    AppMethodBeat.o(139564);
    return parama;
  }
  
  public final void b(com.tencent.luggage.xweb_ext.extendplugin.a parama, com.tencent.mm.plugin.appbrand.jsapi.video.e.e parame)
  {
    AppMethodBeat.i(221368);
    com.tencent.mm.plugin.appbrand.jsapi.ai.e.c.a locala = this.pLS;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e locale = bYA();
    if ((locale != null) && (!Util.isNullOrNil(locala.pOe.videoPath)) && (locala.pOe.pOj > 0L))
    {
      locala.pOe.pOr = Util.nowMilliSecond();
      locala.a(locale, parama, parame, "onMediaPlayerVideoEnd");
    }
    AppMethodBeat.o(221368);
  }
  
  protected com.tencent.mm.plugin.appbrand.jsapi.ai.e.c.a bYz()
  {
    AppMethodBeat.i(221229);
    com.tencent.mm.plugin.appbrand.jsapi.ai.e.c.a locala = new com.tencent.mm.plugin.appbrand.jsapi.ai.e.c.a();
    AppMethodBeat.o(221229);
    return locala;
  }
  
  public final void c(com.tencent.mm.plugin.appbrand.jsapi.video.e.e parame)
  {
    AppMethodBeat.i(221336);
    com.tencent.mm.plugin.appbrand.jsapi.ai.e.c.a locala = this.pLS;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e locale = bYA();
    if ((parame != null) && (locale != null) && (locala.pOe.pOj <= 0L))
    {
      locala.pOe.pOj = Util.nowMilliSecond();
      locale.c(1234L, 20L, 1L);
      if ((parame instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g))
      {
        locale.c(1234L, 45L, 1L);
        AppMethodBeat.o(221336);
        return;
      }
      if (locala.h(parame))
      {
        locale.c(1234L, 92L, 1L);
        AppMethodBeat.o(221336);
        return;
      }
      if ((parame instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.i)) {
        locale.c(1234L, 40L, 1L);
      }
    }
    AppMethodBeat.o(221336);
  }
  
  public final void d(com.tencent.mm.plugin.appbrand.jsapi.video.e.e parame)
  {
    AppMethodBeat.i(221340);
    com.tencent.mm.plugin.appbrand.jsapi.ai.e.c.a locala = this.pLS;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e locale = bYA();
    if ((parame != null) && (locale != null) && (locala.pOe.pOo <= 0L))
    {
      a.a locala1 = locala.pOe;
      locala1.pOm += 1;
      locala.pOe.pOo = Util.nowMilliSecond();
      locale.c(1234L, 50L, 1L);
      if ((parame instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g))
      {
        locale.c(1234L, 98L, 1L);
        AppMethodBeat.o(221340);
        return;
      }
      if (locala.h(parame)) {
        locale.c(1234L, 103L, 1L);
      }
    }
    AppMethodBeat.o(221340);
  }
  
  public final void e(com.tencent.mm.plugin.appbrand.jsapi.video.e.e parame)
  {
    AppMethodBeat.i(221350);
    com.tencent.mm.plugin.appbrand.jsapi.ai.e.c.a locala = this.pLS;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e locale = bYA();
    long l;
    if ((parame != null) && (locale != null)) {
      if (locala.pOe.pOp <= 0L)
      {
        locala.pOe.pOp = Util.nowMilliSecond();
        locale.c(1234L, 51L, 1L);
        l = locala.pOe.pOp - locala.pOe.pOo;
        a.a locala1 = locala.pOe;
        locala1.pOn += l;
        locale.c(1234L, 53L, l);
        Log.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoBufferEnd, bufferTime:%s", new Object[] { Long.valueOf(l) });
        if (!(parame instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g)) {
          break label194;
        }
        locale.c(1234L, 99L, 1L);
        locale.c(1234L, 101L, l);
      }
    }
    for (;;)
    {
      parame = locala.pOe;
      parame.pOo = 0L;
      parame.pOp = 0L;
      AppMethodBeat.o(221350);
      return;
      label194:
      if (locala.h(parame))
      {
        locale.c(1234L, 104L, 1L);
        locale.c(1234L, 106L, l);
      }
    }
  }
  
  protected boolean g(com.tencent.mm.plugin.appbrand.jsapi.video.e.e parame)
  {
    return true;
  }
  
  public final boolean j(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139566);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(139566);
      return false;
    }
    Object localObject = parama.SR();
    com.tencent.mm.plugin.appbrand.jsapi.e locale = ((com.tencent.mm.plugin.appbrand.h.b)parama).okQ;
    parama = null;
    if ((locale instanceof ad)) {
      parama = (ad)locale;
    }
    while (parama == null)
    {
      Log.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, page view is null");
      AppMethodBeat.o(139566);
      return false;
      if ((locale instanceof v)) {
        parama = ((v)locale).getCurrentPageView();
      }
    }
    if ((localObject != null) && (((JSONObject)localObject).has("data")))
    {
      localObject = ((JSONObject)localObject).optJSONArray("data");
      if ((localObject == null) || (((JSONArray)localObject).length() == 0))
      {
        Log.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, data array is null");
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
        parama.P(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(139553);
            if ((!parama.isRunning()) || (parama.qoF == null))
            {
              Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, invalid state");
              AppMethodBeat.o(139553);
              return;
            }
            com.tencent.mm.plugin.appbrand.platform.window.d locald = parama.qoF.getFullscreenImpl();
            View localView = parama.qoF.getWrapperView();
            if ((locald != null) && (localView != null))
            {
              locald.O(localView, i);
              if (c.this.pLQ != null) {
                locald.a(c.this.pLQ);
              }
              Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, target orientation:%s", new Object[] { Integer.valueOf(i) });
              AppMethodBeat.o(139553);
              return;
            }
            Log.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, state error, FullscreenImp[%s], fullscreenWebView[%s]", new Object[] { locald, localView });
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
    parama = ((com.tencent.mm.plugin.appbrand.h.b)parama).okQ;
    if ((parama instanceof ad)) {
      parama = (ad)parama;
    }
    for (;;)
    {
      if (parama == null)
      {
        Log.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "exitFullscreen, page view is null");
        AppMethodBeat.o(139567);
        return false;
        if ((parama instanceof v)) {
          parama = ((v)parama).getCurrentPageView();
        }
      }
      else
      {
        parama.P(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(139554);
            if ((!parama.isRunning()) || (parama.qoF == null))
            {
              Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "exitFullscreen, invalid state");
              AppMethodBeat.o(139554);
              return;
            }
            com.tencent.mm.plugin.appbrand.platform.window.d locald = parama.qoF.getFullscreenImpl();
            if (locald != null)
            {
              locald.bEz();
              Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "exitFullscreen");
              AppMethodBeat.o(139554);
              return;
            }
            Log.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "exitFullscreen, state error");
            AppMethodBeat.o(139554);
          }
        });
        AppMethodBeat.o(139567);
        return true;
      }
      parama = null;
    }
  }
  
  public final void m(com.tencent.luggage.xweb_ext.extendplugin.component.video.c paramc)
  {
    this.pLR = paramc;
  }
  
  public final boolean u(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139568);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(139568);
      return false;
    }
    Object localObject = parama.SR();
    parama = ((com.tencent.mm.plugin.appbrand.h.b)parama).okQ;
    if ((parama instanceof ad)) {
      parama = (ad)parama;
    }
    for (;;)
    {
      if (parama == null)
      {
        Log.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "setScreenBrightness, page view is null");
        AppMethodBeat.o(139568);
        return false;
        if ((parama instanceof v)) {
          parama = ((v)parama).getCurrentPageView();
        }
      }
      else
      {
        if ((localObject != null) && (((JSONObject)localObject).has("data")))
        {
          localObject = ((JSONObject)localObject).optJSONArray("data");
          if ((localObject == null) || (((JSONArray)localObject).length() == 0))
          {
            Log.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "setScreenBrightness, data array is null");
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
            MMHandlerThread.postToMainThread(new Runnable()
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
                  Log.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "setScreenBrightness, brightness:%s", new Object[] { Float.valueOf(localLayoutParams.screenBrightness) });
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
  
  public final void v(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(221334);
    if ((parama != null) && ("wxfe02ecfe70800f46".equalsIgnoreCase(parama.getAppId())))
    {
      Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "onMediaPlayerVideoFirstFrame, send play event");
      EventCenter.instance.publish(new com.tencent.mm.plugin.appbrand.jsapi.video.c.a());
    }
    AppMethodBeat.o(221334);
  }
  
  public final void w(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139578);
    if ((parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      parama = parama.QK();
      this.currentAppId = parama.getAppId();
      if (!(parama instanceof v)) {
        break label88;
      }
      parama = ((v)parama).getRuntime();
    }
    for (;;)
    {
      if ((parama != null) && (!"wxfe02ecfe70800f46".equalsIgnoreCase(parama.mAppId)))
      {
        Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "addOnRunningStateChangedListener");
        parama.ntR.a(this.pKS);
      }
      AppMethodBeat.o(139578);
      return;
      label88:
      if ((parama instanceof ad)) {
        parama = ((ad)parama).getRuntime();
      } else {
        parama = null;
      }
    }
  }
  
  public final void x(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139579);
    if ((parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      parama = parama.QK();
      if ((parama instanceof v)) {
        parama = ((v)parama).getRuntime();
      }
    }
    for (;;)
    {
      if (parama != null)
      {
        if (!"wxfe02ecfe70800f46".equalsIgnoreCase(parama.mAppId))
        {
          Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "removeOnRunningStateChangedListener");
          parama.ntR.b(this.pKS);
        }
        Log.d("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "markVideoPlayerRelease");
        if (this.pLR == null)
        {
          Log.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "markVideoPlayerRelease, pluginHandler is null");
          AppMethodBeat.o(139579);
          return;
          if ((parama instanceof ad)) {
            parama = ((ad)parama).getRuntime();
          }
        }
        else
        {
          parama = (com.tencent.mm.plugin.appbrand.jsapi.ai.a)parama.av(com.tencent.mm.plugin.appbrand.jsapi.ai.a.class);
          if (parama == null)
          {
            Log.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "markVideoPlayerRelease, audioOfVideoBackgroundPlayManager is null");
            AppMethodBeat.o(139579);
            return;
          }
          parama.f(this.pLR);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.e.c
 * JD-Core Version:    0.7.0.1
 */