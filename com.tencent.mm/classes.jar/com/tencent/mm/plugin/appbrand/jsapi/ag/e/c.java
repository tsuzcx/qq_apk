package com.tencent.mm.plugin.appbrand.jsapi.ag.e;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Handler;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.ag.e.c.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f.b;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
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
  String currentAppId;
  com.tencent.mm.plugin.appbrand.platform.window.b mKY;
  com.tencent.luggage.xweb_ext.extendplugin.component.video.c mKZ;
  private c.a mKa;
  private com.tencent.mm.plugin.appbrand.jsapi.ag.e.c.a mLa;
  
  public c()
  {
    AppMethodBeat.i(139557);
    this.mKa = new c.4(this);
    com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.c localc = (com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.c)com.tencent.luggage.a.e.M(com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.c.class);
    if (localc != null) {
      this.mKY = localc.bMn();
    }
    this.mLa = new com.tencent.mm.plugin.appbrand.jsapi.ag.e.c.a();
    AppMethodBeat.o(139557);
  }
  
  private com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e bMj()
  {
    if (this.mKZ != null) {
      return this.mKZ.cIZ;
    }
    return null;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.f QC()
  {
    AppMethodBeat.i(139561);
    g localg = new g();
    AppMethodBeat.o(139561);
    return localg;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e QD()
  {
    AppMethodBeat.i(139560);
    f localf = new f();
    AppMethodBeat.o(139560);
    return localf;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c QE()
  {
    AppMethodBeat.i(139558);
    d locald = new d();
    AppMethodBeat.o(139558);
    return locald;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d QF()
  {
    AppMethodBeat.i(139559);
    e locale = new e();
    AppMethodBeat.o(139559);
    return locale;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a QG()
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
  
  public final com.tencent.mm.plugin.appbrand.jsapi.video.e.c a(com.tencent.luggage.xweb_ext.extendplugin.a parama, Handler paramHandler)
  {
    AppMethodBeat.i(215884);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(215884);
      return null;
    }
    long l = System.currentTimeMillis();
    Object localObject = (h)com.tencent.luggage.a.e.M(h.class);
    if (localObject == null)
    {
      parama = new com.tencent.mm.plugin.appbrand.jsapi.video.e.e();
      l = System.currentTimeMillis() - l;
      paramHandler = this.mLa;
      localObject = bMj();
      if ((parama != null) && (localObject != null))
      {
        if (!(parama instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)) {
          break label157;
        }
        ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e)localObject).c(1234L, 3L, 1L);
        ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e)localObject).c(1234L, 4L, l);
        paramHandler.mNm.mEJ = 1;
      }
    }
    for (;;)
    {
      ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e)localObject).c(1234L, 6L, 1L);
      paramHandler.mNm.mNo = l;
      AppMethodBeat.o(215884);
      return parama;
      parama = ((h)localObject).a(parama, paramHandler);
      break;
      label157:
      if ((parama instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.e))
      {
        ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e)localObject).c(1234L, 0L, 1L);
        ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e)localObject).c(1234L, 1L, l);
        paramHandler.mNm.mEJ = 0;
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
      parama.dP("fail:snapshot error");
      AppMethodBeat.o(178857);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.f localf = parama.NN();
    String str = AndroidMediaUtil.getSysCameraDirPath() + String.format(Locale.US, "%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    i locali;
    try
    {
      BitmapUtil.saveBitmapToImage(paramBitmap, 90, Bitmap.CompressFormat.JPEG, str, true);
      locali = new i();
      if (localf.getFileSystem() != null)
      {
        if (localf.getFileSystem().a(new o(str), "jpg", true, locali) == m.kSu) {
          break label257;
        }
        Log.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "operateSnapshot, save snapshot failed");
        parama.dP("fail:snapshot error");
        AppMethodBeat.o(178857);
        return;
      }
    }
    catch (IOException paramBitmap)
    {
      Log.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "operateSnapshot, save bitmap exception", new Object[] { paramBitmap });
      parama.dP("fail:snapshot error");
      AppMethodBeat.o(178857);
      return;
    }
    parama.dP("fail");
    AppMethodBeat.o(178857);
    return;
    label257:
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
    parama.f("ok", paramBitmap);
    AppMethodBeat.o(178857);
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, com.tencent.mm.plugin.appbrand.jsapi.video.e.c paramc)
  {
    AppMethodBeat.i(215893);
    com.tencent.mm.plugin.appbrand.jsapi.ag.e.c.a locala = this.mLa;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e locale = bMj();
    if ((locale != null) && (!Util.isNullOrNil(locala.mNm.videoPath)) && (locala.mNm.mNq > 0L))
    {
      locala.mNm.mNx = Util.nowMilliSecond();
      locala.a(locale, parama, paramc, "onMediaPlayerVideoStop");
    }
    AppMethodBeat.o(215893);
  }
  
  public final void a(f.b paramb)
  {
    AppMethodBeat.i(215892);
    com.tencent.mm.plugin.appbrand.jsapi.ag.e.c.a.a(bMj(), paramb);
    AppMethodBeat.o(215892);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.c paramc, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(215891);
    com.tencent.mm.plugin.appbrand.jsapi.ag.e.c.a locala = this.mLa;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e locale = bMj();
    if ((paramc != null) && (locale != null))
    {
      locale.c(1234L, 65L, 1L);
      Log.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoError, what:%s, extra:%s, msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if (!(paramc instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)) {
        break label169;
      }
      locale.c(1234L, 75L, 1L);
      if (!(paramc instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.e)) {
        break label266;
      }
      if (!Util.isNullOrNil(paramString))
      {
        if (!paramString.equalsIgnoreCase("MEDIA_ERR_NETWORK")) {
          break label193;
        }
        locale.c(1234L, 72L, 1L);
      }
    }
    label266:
    for (;;)
    {
      locala.mNm.mNz = paramInt1;
      locala.mNm.mNA = paramInt2;
      locala.mNm.errorMsg = paramString;
      AppMethodBeat.o(215891);
      return;
      label169:
      if (!(paramc instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.e)) {
        break;
      }
      locale.c(1234L, 70L, 1L);
      break;
      label193:
      if (paramString.equalsIgnoreCase("MEDIA_ERR_DECODE"))
      {
        locale.c(1234L, 73L, 1L);
      }
      else if (paramString.equalsIgnoreCase("MEDIA_ERR_SRC_NOT_SUPPORTED"))
      {
        locale.c(1234L, 71L, 1L);
      }
      else
      {
        locale.c(1234L, 74L, 1L);
        continue;
        com.tencent.mm.plugin.appbrand.jsapi.video.e.b localb = com.tencent.mm.plugin.appbrand.jsapi.video.e.b.el(paramInt1, paramInt2);
        if (localb != null) {
          switch (com.tencent.mm.plugin.appbrand.jsapi.ag.e.c.a.1.mNn[localb.ordinal()])
          {
          default: 
            break;
          case 1: 
            if ((paramc instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)) {
              locale.c(1234L, 116L, 1L);
            }
            break;
          case 2: 
            if ((paramc instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)) {
              locale.c(1234L, 117L, 1L);
            }
            break;
          case 3: 
            if ((paramc instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)) {
              locale.c(1234L, 118L, 1L);
            }
            break;
          case 4: 
            if ((paramc instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)) {
              locale.c(1234L, 119L, 1L);
            }
            break;
          case 5: 
            if ((paramc instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)) {
              locale.c(1234L, 120L, 1L);
            }
            break;
          case 6: 
            if ((paramc instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)) {
              locale.c(1234L, 121L, 1L);
            }
            break;
          case 7: 
            if ((paramc instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)) {
              locale.c(1234L, 122L, 1L);
            }
            break;
          case 8: 
            if ((paramc instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)) {
              locale.c(1234L, 123L, 1L);
            }
            break;
          }
        }
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.c paramc, long paramLong)
  {
    AppMethodBeat.i(215888);
    com.tencent.mm.plugin.appbrand.jsapi.ag.e.c.a locala = this.mLa;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e locale = bMj();
    long l;
    if ((paramc != null) && (locale != null)) {
      if (locala.mNm.mNr <= 0L)
      {
        locala.mNm.mNr = Util.nowMilliSecond();
        locale.c(1234L, 21L, 1L);
        l = locala.mNm.mNr - locala.mNm.mNq;
        locala.mNm.mNs = l;
        locale.c(1234L, 23L, l);
        Log.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoPrepareEnd, prepareTime:%s", new Object[] { Long.valueOf(l) });
        if (!(paramc instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)) {
          break label245;
        }
        locale.c(1234L, 46L, 1L);
        locale.c(1234L, 48L, l);
      }
    }
    for (;;)
    {
      if ((locala.mNm.duration <= 0L) && (paramLong > 0L))
      {
        paramLong = (1.0D * paramLong / 1000.0D);
        locala.mNm.duration = paramLong;
        locale.c(1234L, 35L, 1L);
        Log.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoPrepareEnd, duration:%s", new Object[] { Long.valueOf(paramLong) });
      }
      AppMethodBeat.o(215888);
      return;
      label245:
      if ((paramc instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.e))
      {
        locale.c(1234L, 41L, 1L);
        locale.c(1234L, 43L, l);
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.c paramc, String paramString)
  {
    AppMethodBeat.i(215885);
    long l1 = 0L;
    if (com.tencent.luggage.a.e.M(com.tencent.mm.plugin.appbrand.jsapi.video.g.class) != null) {
      l1 = ((com.tencent.mm.plugin.appbrand.jsapi.video.g)com.tencent.luggage.a.e.M(com.tencent.mm.plugin.appbrand.jsapi.video.g.class)).f(paramString, 0L, 9223372036854775807L);
    }
    if (l1 < 0L) {
      l1 = 0L;
    }
    for (;;)
    {
      Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "onVideoPathChanged, videoPath:%s, cachedSize:%s", new Object[] { paramString, Long.valueOf(l1) });
      if ((this.mKZ != null) && (this.mKZ.cIW != null)) {
        this.mKZ.cIW.aX(l1);
      }
      com.tencent.mm.plugin.appbrand.jsapi.ag.e.c.a locala = this.mLa;
      Object localObject = bMj();
      if ((paramc != null) && (localObject != null) && (!Util.isNullOrNil(paramString)))
      {
        ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e)localObject).c(1234L, 10L, 1L);
        if (l1 > 0L)
        {
          ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e)localObject).c(1234L, 11L, 1L);
          long l2 = BigInteger.valueOf(l1).divide(com.tencent.mm.plugin.appbrand.jsapi.ag.e.c.a.mNl).longValue();
          ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e)localObject).c(1234L, 13L, l2);
          Log.d("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onVideoPathChanged, cachedSize:%s, cachedSizeInKB:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
        }
        localObject = locala.mNm;
        if (Util.isNullOrNil(paramString)) {
          break label275;
        }
        paramc = paramString;
        if (paramString.length() > 512) {
          paramc = paramString.substring(0, 512);
        }
      }
      label275:
      for (((a.a)localObject).videoPath = paramc;; ((a.a)localObject).videoPath = "")
      {
        locala.mNm.mNp = l1;
        AppMethodBeat.o(215885);
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
    parama = parama.NN();
    if ((!Util.isNullOrNil(paramString)) && (parama != null) && (parama.getFileSystem() != null) && (parama.getFileSystem().Vi(paramString)))
    {
      parama = parama.getFileSystem().VY(paramString);
      if (parama == null) {}
      for (;;)
      {
        Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "convertVideoPath, videoPath:%s", new Object[] { paramString });
        AppMethodBeat.o(139564);
        return paramString;
        paramString = "file://" + aa.z(parama.her());
      }
    }
    parama = paramString;
    if (!Util.isNullOrNil(paramString))
    {
      parama = paramString;
      if (com.tencent.luggage.a.e.M(com.tencent.mm.plugin.appbrand.jsapi.video.g.class) != null) {
        parama = ((com.tencent.mm.plugin.appbrand.jsapi.video.g)com.tencent.luggage.a.e.M(com.tencent.mm.plugin.appbrand.jsapi.video.g.class)).getProxyUrl(paramString);
      }
    }
    AppMethodBeat.o(139564);
    return parama;
  }
  
  public final void b(com.tencent.luggage.xweb_ext.extendplugin.a parama, com.tencent.mm.plugin.appbrand.jsapi.video.e.c paramc)
  {
    AppMethodBeat.i(215894);
    com.tencent.mm.plugin.appbrand.jsapi.ag.e.c.a locala = this.mLa;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e locale = bMj();
    if ((locale != null) && (!Util.isNullOrNil(locala.mNm.videoPath)) && (locala.mNm.mNq > 0L))
    {
      locala.mNm.mNy = Util.nowMilliSecond();
      locala.a(locale, parama, paramc, "onMediaPlayerVideoEnd");
    }
    AppMethodBeat.o(215894);
  }
  
  public final void b(com.tencent.luggage.xweb_ext.extendplugin.component.video.c paramc)
  {
    this.mKZ = paramc;
  }
  
  public final void c(com.tencent.mm.plugin.appbrand.jsapi.video.e.c paramc)
  {
    AppMethodBeat.i(215887);
    com.tencent.mm.plugin.appbrand.jsapi.ag.e.c.a locala = this.mLa;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e locale = bMj();
    if ((paramc != null) && (locale != null) && (locala.mNm.mNq <= 0L))
    {
      locala.mNm.mNq = Util.nowMilliSecond();
      locale.c(1234L, 20L, 1L);
      if ((paramc instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f))
      {
        locale.c(1234L, 45L, 1L);
        AppMethodBeat.o(215887);
        return;
      }
      if ((paramc instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.e)) {
        locale.c(1234L, 40L, 1L);
      }
    }
    AppMethodBeat.o(215887);
  }
  
  public final void d(com.tencent.mm.plugin.appbrand.jsapi.video.e.c paramc)
  {
    AppMethodBeat.i(215889);
    com.tencent.mm.plugin.appbrand.jsapi.ag.e.c.a locala = this.mLa;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e locale = bMj();
    if ((paramc != null) && (locale != null) && (locala.mNm.mNv <= 0L))
    {
      a.a locala1 = locala.mNm;
      locala1.mNt += 1;
      locala.mNm.mNv = Util.nowMilliSecond();
      locale.c(1234L, 50L, 1L);
      if ((paramc instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)) {
        locale.c(1234L, 98L, 1L);
      }
    }
    AppMethodBeat.o(215889);
  }
  
  public final void e(com.tencent.mm.plugin.appbrand.jsapi.video.e.c paramc)
  {
    AppMethodBeat.i(215890);
    com.tencent.mm.plugin.appbrand.jsapi.ag.e.c.a locala = this.mLa;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e locale = bMj();
    if ((paramc != null) && (locale != null))
    {
      if (locala.mNm.mNw <= 0L)
      {
        locala.mNm.mNw = Util.nowMilliSecond();
        locale.c(1234L, 51L, 1L);
        long l = locala.mNm.mNw - locala.mNm.mNv;
        a.a locala1 = locala.mNm;
        locala1.mNu += l;
        locale.c(1234L, 53L, l);
        Log.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoBufferEnd, bufferTime:%s", new Object[] { Long.valueOf(l) });
        if ((paramc instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f))
        {
          locale.c(1234L, 99L, 1L);
          locale.c(1234L, 101L, l);
        }
      }
      paramc = locala.mNm;
      paramc.mNv = 0L;
      paramc.mNw = 0L;
    }
    AppMethodBeat.o(215890);
  }
  
  public final boolean j(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139566);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(139566);
      return false;
    }
    Object localObject = parama.Ps();
    com.tencent.mm.plugin.appbrand.jsapi.f localf = ((com.tencent.mm.plugin.appbrand.h.b)parama).lqg;
    parama = null;
    if ((localf instanceof ac)) {
      parama = (ac)localf;
    }
    while (parama == null)
    {
      Log.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, page view is null");
      AppMethodBeat.o(139566);
      return false;
      if ((localf instanceof s)) {
        parama = ((s)localf).getCurrentPageView();
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
            if ((!parama.isRunning()) || (parama.nmX == null))
            {
              Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, invalid state");
              AppMethodBeat.o(139553);
              return;
            }
            com.tencent.mm.plugin.appbrand.platform.window.d locald = parama.nmX.getFullscreenImpl();
            View localView = parama.nmX.getWrapperView();
            if ((locald != null) && (localView != null))
            {
              locald.N(localView, i);
              if (c.this.mKY != null) {
                locald.a(c.this.mKY);
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
    parama = ((com.tencent.mm.plugin.appbrand.h.b)parama).lqg;
    if ((parama instanceof ac)) {
      parama = (ac)parama;
    }
    for (;;)
    {
      if (parama == null)
      {
        Log.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "exitFullscreen, page view is null");
        AppMethodBeat.o(139567);
        return false;
        if ((parama instanceof s)) {
          parama = ((s)parama).getCurrentPageView();
        }
      }
      else
      {
        parama.P(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(139554);
            if ((!parama.isRunning()) || (parama.nmX == null))
            {
              Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "exitFullscreen, invalid state");
              AppMethodBeat.o(139554);
              return;
            }
            com.tencent.mm.plugin.appbrand.platform.window.d locald = parama.nmX.getFullscreenImpl();
            if (locald != null)
            {
              locald.btC();
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
  
  public final boolean t(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139568);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(139568);
      return false;
    }
    Object localObject = parama.Ps();
    parama = ((com.tencent.mm.plugin.appbrand.h.b)parama).lqg;
    if ((parama instanceof ac)) {
      parama = (ac)parama;
    }
    for (;;)
    {
      if (parama == null)
      {
        Log.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "setScreenBrightness, page view is null");
        AppMethodBeat.o(139568);
        return false;
        if ((parama instanceof s)) {
          parama = ((s)parama).getCurrentPageView();
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
          float f = (float)((JSONArray)localObject).optDouble(0, -1.0D);
          if ((Float.isNaN(f)) || (f < 0.0F) || (f > 1.0F))
          {
            AppMethodBeat.o(139568);
            return false;
          }
          if ((parama.getContext() instanceof Activity))
          {
            MMHandlerThread.postToMainThread(new c.3(this, (Activity)parama.getContext(), f));
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
    AppMethodBeat.i(215886);
    if ((parama != null) && ("wxfe02ecfe70800f46".equalsIgnoreCase(parama.getAppId())))
    {
      Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "onMediaPlayerVideoFirstFrame, send play event");
      EventCenter.instance.publish(new com.tencent.mm.plugin.appbrand.jsapi.video.c.a());
    }
    AppMethodBeat.o(215886);
  }
  
  public final void v(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139578);
    if ((parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      parama = parama.NN();
      this.currentAppId = parama.getAppId();
      if (!(parama instanceof s)) {
        break label88;
      }
      parama = ((s)parama).getRuntime();
    }
    for (;;)
    {
      if ((parama != null) && (!"wxfe02ecfe70800f46".equalsIgnoreCase(parama.mAppId)))
      {
        Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "addOnRunningStateChangedListener");
        parama.kAH.a(this.mKa);
      }
      AppMethodBeat.o(139578);
      return;
      label88:
      if ((parama instanceof ac)) {
        parama = ((ac)parama).getRuntime();
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
      parama = parama.NN();
      if ((parama instanceof s)) {
        parama = ((s)parama).getRuntime();
      }
    }
    for (;;)
    {
      if (parama != null)
      {
        if (!"wxfe02ecfe70800f46".equalsIgnoreCase(parama.mAppId))
        {
          Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "removeOnRunningStateChangedListener");
          parama.kAH.b(this.mKa);
        }
        Log.d("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "markVideoPlayerRelease");
        if (this.mKZ == null)
        {
          Log.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "markVideoPlayerRelease, pluginHandler is null");
          AppMethodBeat.o(139579);
          return;
          if ((parama instanceof ac)) {
            parama = ((ac)parama).getRuntime();
          }
        }
        else
        {
          parama = (com.tencent.mm.plugin.appbrand.jsapi.ag.a)parama.aw(com.tencent.mm.plugin.appbrand.jsapi.ag.a.class);
          if (parama == null)
          {
            Log.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "markVideoPlayerRelease, audioOfVideoBackgroundPlayManager is null");
            AppMethodBeat.o(139579);
            return;
          }
          parama.f(this.mKZ);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.e.c
 * JD-Core Version:    0.7.0.1
 */