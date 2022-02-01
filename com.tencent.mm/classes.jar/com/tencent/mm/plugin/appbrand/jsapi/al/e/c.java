package com.tencent.mm.plugin.appbrand.jsapi.al.e;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Handler;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.al.e.c.a.1;
import com.tencent.mm.plugin.appbrand.jsapi.al.e.c.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.m;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.m.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.j;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
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
  private c.a sPL;
  com.tencent.mm.plugin.appbrand.platform.window.b sQG;
  com.tencent.luggage.xweb_ext.extendplugin.component.video.c sQH;
  protected final com.tencent.mm.plugin.appbrand.jsapi.al.e.c.a sQI;
  
  public c()
  {
    AppMethodBeat.i(139557);
    this.sPL = new c.4(this);
    com.tencent.mm.plugin.appbrand.jsapi.al.e.a.c localc = (com.tencent.mm.plugin.appbrand.jsapi.al.e.a.c)com.tencent.luggage.a.e.T(com.tencent.mm.plugin.appbrand.jsapi.al.e.a.c.class);
    if (localc != null) {
      this.sQG = localc.cyV();
    }
    this.sQI = cyP();
    AppMethodBeat.o(139557);
  }
  
  private com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e cyQ()
  {
    if (this.sQH != null) {
      return this.sQH.eDm;
    }
    return null;
  }
  
  public final b a(com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a parama, com.tencent.luggage.xweb_ext.extendplugin.a parama1)
  {
    AppMethodBeat.i(139562);
    parama = new b(parama, parama1);
    AppMethodBeat.o(139562);
    return parama;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.video.e.g a(com.tencent.luggage.xweb_ext.extendplugin.a parama, Handler paramHandler)
  {
    AppMethodBeat.i(327172);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(327172);
      return null;
    }
    long l = System.currentTimeMillis();
    Object localObject = (h)com.tencent.luggage.a.e.T(h.class);
    com.tencent.mm.plugin.appbrand.jsapi.al.e.c.a locala;
    if (localObject == null)
    {
      parama = new j();
      l = System.currentTimeMillis() - l;
      locala = this.sQI;
      paramHandler = cyQ();
      if ((parama != null) && (paramHandler != null))
      {
        if (!com.tencent.mm.plugin.appbrand.jsapi.video.k.e(parama)) {
          break label269;
        }
        paramHandler.d(1234L, 3L, 1L);
        paramHandler.d(1234L, 4L, l);
        locala.sSC.sJh = 1;
      }
    }
    for (;;)
    {
      paramHandler.d(1234L, 6L, 1L);
      locala.sSC.sSF = l;
      m localm = (m)parama.aU(m.class);
      if (localm != null)
      {
        a.a locala1 = locala.sSC;
        localObject = localm.sGJ;
        paramHandler = (Handler)localObject;
        if (localObject == null)
        {
          int i = localm.sGI;
          boolean bool = com.tencent.mm.plugin.appbrand.jsapi.video.e.c.a.b.sGY;
          paramHandler = com.tencent.mm.plugin.appbrand.jsapi.video.e.c.e.sFN;
          paramHandler = new m.b(i, bool, com.tencent.mm.plugin.appbrand.jsapi.video.e.c.e.cwG());
          Log.i("MicroMsg.SameLayer.ExoMediaPlayer", "getExtraInfo, extraInfo: ".concat(String.valueOf(paramHandler)));
          localm.sGJ = paramHandler;
        }
        locala1.sSS = paramHandler;
        localm.sGK = new a.1(locala);
      }
      AppMethodBeat.o(327172);
      return parama;
      parama = ((h)localObject).a(parama, paramHandler);
      break;
      label269:
      if (locala.g(parama))
      {
        paramHandler.d(1234L, 87L, 1L);
        paramHandler.d(1234L, 88L, l);
        locala.sSC.sJh = 2;
      }
      else if (com.tencent.mm.plugin.appbrand.jsapi.video.k.d(parama))
      {
        paramHandler.d(1234L, 0L, 1L);
        paramHandler.d(1234L, 1L, l);
        locala.sSC.sJh = 0;
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
      parama.fO("fail:snapshot error");
      AppMethodBeat.o(178857);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.f localf = parama.aqX();
    String str = AndroidMediaUtil.getSysCameraDirPath() + String.format(Locale.US, "%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    com.tencent.mm.plugin.appbrand.af.k localk;
    try
    {
      BitmapUtil.saveBitmapToImage(paramBitmap, 90, Bitmap.CompressFormat.JPEG, str, true);
      localk = new com.tencent.mm.plugin.appbrand.af.k();
      if (localf.getFileSystem() != null)
      {
        if (localf.getFileSystem().a(new u(str), "jpg", true, localk) == r.qML) {
          break label261;
        }
        Log.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "operateSnapshot, save snapshot failed");
        parama.fO("fail:snapshot error");
        AppMethodBeat.o(178857);
        return;
      }
    }
    catch (IOException paramBitmap)
    {
      Log.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "operateSnapshot, save bitmap exception", new Object[] { paramBitmap });
      parama.fO("fail:snapshot error");
      AppMethodBeat.o(178857);
      return;
    }
    parama.fO("fail");
    AppMethodBeat.o(178857);
    return;
    label261:
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "bitmap recycle " + paramBitmap.toString());
      paramBitmap.recycle();
    }
    Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "operateSnapshot, actualPath:%s path:%s", new Object[] { str, localk.value });
    paramBitmap = new HashMap();
    paramBitmap.put("tempImagePath", localk.value);
    paramBitmap.put("width", Integer.valueOf(i));
    paramBitmap.put("height", Integer.valueOf(j));
    parama.e("ok", paramBitmap);
    AppMethodBeat.o(178857);
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, com.tencent.mm.plugin.appbrand.jsapi.video.e.g paramg)
  {
    AppMethodBeat.i(327189);
    com.tencent.mm.plugin.appbrand.jsapi.al.e.c.a locala = this.sQI;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e locale = cyQ();
    if ((locale != null) && (!Util.isNullOrNil(locala.sSC.videoPath)) && (locala.sSC.sSH > 0L))
    {
      locala.sSC.sSO = Util.nowMilliSecond();
      locala.a(locale, parama, paramg, "onMediaPlayerVideoStop");
    }
    AppMethodBeat.o(327189);
  }
  
  public final void a(j.b paramb)
  {
    AppMethodBeat.i(327188);
    com.tencent.mm.plugin.appbrand.jsapi.al.e.c.a.a(cyQ(), paramb);
    AppMethodBeat.o(327188);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.g paramg)
  {
    AppMethodBeat.i(327182);
    com.tencent.mm.plugin.appbrand.jsapi.al.e.c.a locala = this.sQI;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e locale = cyQ();
    if ((paramg != null) && (locale != null) && (locala.sSC.sSH <= 0L))
    {
      locala.sSC.sSH = Util.nowMilliSecond();
      locale.d(1234L, 20L, 1L);
      if (com.tencent.mm.plugin.appbrand.jsapi.video.k.e(paramg))
      {
        locale.d(1234L, 45L, 1L);
        AppMethodBeat.o(327182);
        return;
      }
      if (locala.g(paramg))
      {
        locale.d(1234L, 92L, 1L);
        AppMethodBeat.o(327182);
        return;
      }
      if (com.tencent.mm.plugin.appbrand.jsapi.video.k.d(paramg)) {
        locale.d(1234L, 40L, 1L);
      }
    }
    AppMethodBeat.o(327182);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.g paramg, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(327187);
    this.sQI.a(cyQ(), paramg, paramInt1, paramInt2, paramString);
    AppMethodBeat.o(327187);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.g paramg, long paramLong)
  {
    AppMethodBeat.i(327183);
    com.tencent.mm.plugin.appbrand.jsapi.al.e.c.a locala = this.sQI;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e locale = cyQ();
    long l;
    if ((paramg != null) && (locale != null)) {
      if (locala.sSC.sSI <= 0L)
      {
        locala.sSC.sSI = Util.nowMilliSecond();
        locale.d(1234L, 21L, 1L);
        l = locala.sSC.sSI - locala.sSC.sSH;
        locala.sSC.sSJ = l;
        locale.d(1234L, 23L, l);
        Log.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoPrepareEnd, prepareTime:%s", new Object[] { Long.valueOf(l) });
        if (!com.tencent.mm.plugin.appbrand.jsapi.video.k.e(paramg)) {
          break label245;
        }
        locale.d(1234L, 46L, 1L);
        locale.d(1234L, 48L, l);
      }
    }
    for (;;)
    {
      if ((locala.sSC.duration <= 0L) && (paramLong > 0L))
      {
        paramLong = (1.0D * paramLong / 1000.0D);
        locala.sSC.duration = paramLong;
        locale.d(1234L, 35L, 1L);
        Log.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoPrepareEnd, duration:%s", new Object[] { Long.valueOf(paramLong) });
      }
      AppMethodBeat.o(327183);
      return;
      label245:
      if (locala.g(paramg))
      {
        locale.d(1234L, 93L, 1L);
        locale.d(1234L, 95L, l);
      }
      else if (com.tencent.mm.plugin.appbrand.jsapi.video.k.d(paramg))
      {
        locale.d(1234L, 41L, 1L);
        locale.d(1234L, 43L, l);
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.g paramg, String paramString)
  {
    AppMethodBeat.i(327173);
    long l2 = 0L;
    boolean bool = f(paramg);
    long l1 = l2;
    if (bool)
    {
      l1 = l2;
      if (com.tencent.luggage.a.e.T(com.tencent.mm.plugin.appbrand.jsapi.video.f.class) != null) {
        l1 = ((com.tencent.mm.plugin.appbrand.jsapi.video.f)com.tencent.luggage.a.e.T(com.tencent.mm.plugin.appbrand.jsapi.video.f.class)).f(paramString, 0L, 9223372036854775807L);
      }
    }
    if (l1 < 0L) {
      l1 = 0L;
    }
    for (;;)
    {
      Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "onVideoPathChanged, videoPath:%s, cachedSize:%s, isSupportGetCachedBytes: %b", new Object[] { paramString, Long.valueOf(l1), Boolean.valueOf(bool) });
      if ((bool) && (this.sQH != null) && (this.sQH.eDj != null)) {
        this.sQH.eDj.dx(l1);
      }
      com.tencent.mm.plugin.appbrand.jsapi.al.e.c.a locala = this.sQI;
      Object localObject = cyQ();
      if ((paramg != null) && (localObject != null) && (!Util.isNullOrNil(paramString)))
      {
        ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e)localObject).d(1234L, 10L, 1L);
        if (l1 > 0L)
        {
          ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e)localObject).d(1234L, 11L, 1L);
          l2 = BigInteger.valueOf(l1).divide(com.tencent.mm.plugin.appbrand.jsapi.al.e.c.a.sSB).longValue();
          ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e)localObject).d(1234L, 13L, l2);
          Log.d("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onVideoPathChanged, cachedSize:%s, cachedSizeInKB:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
        }
        localObject = locala.sSC;
        if (Util.isNullOrNil(paramString)) {
          break label307;
        }
        paramg = paramString;
        if (paramString.length() > 512) {
          paramg = paramString.substring(0, 512);
        }
      }
      label307:
      for (((a.a)localObject).videoPath = paramg;; ((a.a)localObject).videoPath = "")
      {
        locala.sSC.sSG = l1;
        AppMethodBeat.o(327173);
        return;
      }
    }
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.f auM()
  {
    AppMethodBeat.i(139561);
    g localg = new g();
    AppMethodBeat.o(139561);
    return localg;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e auN()
  {
    AppMethodBeat.i(139560);
    f localf = new f();
    AppMethodBeat.o(139560);
    return localf;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c auO()
  {
    AppMethodBeat.i(139558);
    d locald = new d();
    AppMethodBeat.o(139558);
    return locald;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d auP()
  {
    AppMethodBeat.i(139559);
    e locale = new e();
    AppMethodBeat.o(139559);
    return locale;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a auQ()
  {
    AppMethodBeat.i(139577);
    a locala = new a();
    AppMethodBeat.o(139577);
    return locala;
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
    parama = parama.aqX();
    if ((!Util.isNullOrNil(paramString)) && (parama != null) && (parama.getFileSystem() != null) && (parama.getFileSystem().Vq(paramString)))
    {
      parama = parama.getFileSystem().Wm(paramString);
      if (parama == null) {}
      for (;;)
      {
        Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "convertVideoPath, videoPath:%s", new Object[] { paramString });
        AppMethodBeat.o(139564);
        return paramString;
        paramString = "file://" + ah.v(parama.jKT());
      }
    }
    parama = paramString;
    if (!Util.isNullOrNil(paramString))
    {
      parama = paramString;
      if (com.tencent.luggage.a.e.T(com.tencent.mm.plugin.appbrand.jsapi.video.f.class) != null) {
        parama = ((com.tencent.mm.plugin.appbrand.jsapi.video.f)com.tencent.luggage.a.e.T(com.tencent.mm.plugin.appbrand.jsapi.video.f.class)).cd(paramString);
      }
    }
    AppMethodBeat.o(139564);
    return parama;
  }
  
  public final void b(com.tencent.luggage.xweb_ext.extendplugin.a parama, com.tencent.mm.plugin.appbrand.jsapi.video.e.g paramg)
  {
    AppMethodBeat.i(327192);
    com.tencent.mm.plugin.appbrand.jsapi.al.e.c.a locala = this.sQI;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e locale = cyQ();
    if ((locale != null) && (!Util.isNullOrNil(locala.sSC.videoPath)) && (locala.sSC.sSH > 0L))
    {
      locala.sSC.sSP = Util.nowMilliSecond();
      locala.a(locale, parama, paramg, "onMediaPlayerVideoEnd");
    }
    AppMethodBeat.o(327192);
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.jsapi.video.e.g paramg)
  {
    AppMethodBeat.i(327184);
    com.tencent.mm.plugin.appbrand.jsapi.al.e.c.a locala = this.sQI;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e locale = cyQ();
    if ((paramg != null) && (locale != null) && (locala.sSC.sSM <= 0L))
    {
      a.a locala1 = locala.sSC;
      locala1.sSK += 1;
      locala.sSC.sSM = Util.nowMilliSecond();
      locale.d(1234L, 50L, 1L);
      if (com.tencent.mm.plugin.appbrand.jsapi.video.k.e(paramg))
      {
        locale.d(1234L, 98L, 1L);
        AppMethodBeat.o(327184);
        return;
      }
      if (locala.g(paramg)) {
        locale.d(1234L, 103L, 1L);
      }
    }
    AppMethodBeat.o(327184);
  }
  
  public final void c(com.tencent.mm.plugin.appbrand.jsapi.video.e.g paramg)
  {
    AppMethodBeat.i(327186);
    com.tencent.mm.plugin.appbrand.jsapi.al.e.c.a locala = this.sQI;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e locale = cyQ();
    long l;
    if ((paramg != null) && (locale != null)) {
      if (locala.sSC.sSN <= 0L)
      {
        locala.sSC.sSN = Util.nowMilliSecond();
        locale.d(1234L, 51L, 1L);
        l = locala.sSC.sSN - locala.sSC.sSM;
        a.a locala1 = locala.sSC;
        locala1.sSL += l;
        locale.d(1234L, 53L, l);
        Log.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoBufferEnd, bufferTime:%s", new Object[] { Long.valueOf(l) });
        if (!com.tencent.mm.plugin.appbrand.jsapi.video.k.e(paramg)) {
          break label194;
        }
        locale.d(1234L, 99L, 1L);
        locale.d(1234L, 101L, l);
      }
    }
    for (;;)
    {
      paramg = locala.sSC;
      paramg.sSM = 0L;
      paramg.sSN = 0L;
      AppMethodBeat.o(327186);
      return;
      label194:
      if (locala.g(paramg))
      {
        locale.d(1234L, 104L, 1L);
        locale.d(1234L, 106L, l);
      }
    }
  }
  
  protected com.tencent.mm.plugin.appbrand.jsapi.al.e.c.a cyP()
  {
    AppMethodBeat.i(327155);
    com.tencent.mm.plugin.appbrand.jsapi.al.e.c.a locala = new com.tencent.mm.plugin.appbrand.jsapi.al.e.c.a();
    AppMethodBeat.o(327155);
    return locala;
  }
  
  protected boolean f(com.tencent.mm.plugin.appbrand.jsapi.video.e.g paramg)
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
    Object localObject = parama.atw();
    com.tencent.mm.plugin.appbrand.jsapi.f localf = ((com.tencent.mm.plugin.appbrand.h.b)parama).rot;
    parama = null;
    if ((localf instanceof ad)) {
      parama = (ad)localf;
    }
    while (parama == null)
    {
      Log.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, page view is null");
      AppMethodBeat.o(139566);
      return false;
      if ((localf instanceof y)) {
        parama = ((y)localf).getCurrentPageView();
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
        parama.V(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(139553);
            if ((!parama.isRunning()) || (parama.tti == null))
            {
              Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, invalid state");
              AppMethodBeat.o(139553);
              return;
            }
            com.tencent.mm.plugin.appbrand.platform.window.d locald = parama.tti.getFullscreenImpl();
            View localView = parama.tti.getWrapperView();
            if ((locald != null) && (localView != null))
            {
              locald.T(localView, i);
              if (c.this.sQG != null) {
                locald.a(c.this.sQG);
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
    parama = ((com.tencent.mm.plugin.appbrand.h.b)parama).rot;
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
        if ((parama instanceof y)) {
          parama = ((y)parama).getCurrentPageView();
        }
      }
      else
      {
        parama.V(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(139554);
            if ((!parama.isRunning()) || (parama.tti == null))
            {
              Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "exitFullscreen, invalid state");
              AppMethodBeat.o(139554);
              return;
            }
            com.tencent.mm.plugin.appbrand.platform.window.d locald = parama.tti.getFullscreenImpl();
            if (locald != null)
            {
              locald.cdL();
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
    this.sQH = paramc;
  }
  
  public final boolean u(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139568);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(139568);
      return false;
    }
    Object localObject = parama.atw();
    parama = ((com.tencent.mm.plugin.appbrand.h.b)parama).rot;
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
        if ((parama instanceof y)) {
          parama = ((y)parama).getCurrentPageView();
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
  
  public final void v(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(327179);
    if ((parama != null) && ("wxfe02ecfe70800f46".equalsIgnoreCase(parama.getAppId())))
    {
      Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "onMediaPlayerVideoFirstFrame, send play event");
      new com.tencent.mm.plugin.appbrand.jsapi.video.c.a().publish();
    }
    AppMethodBeat.o(327179);
  }
  
  public final void w(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139578);
    if ((parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      parama = parama.aqX();
      this.currentAppId = parama.getAppId();
      if (!(parama instanceof y)) {
        break label88;
      }
      parama = ((y)parama).getRuntime();
    }
    for (;;)
    {
      if ((parama != null) && (!"wxfe02ecfe70800f46".equalsIgnoreCase(parama.mAppId)))
      {
        Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "addOnRunningStateChangedListener");
        parama.qsB.a(this.sPL);
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
      parama = parama.aqX();
      if ((parama instanceof y)) {
        parama = ((y)parama).getRuntime();
      }
    }
    for (;;)
    {
      if (parama != null)
      {
        if (!"wxfe02ecfe70800f46".equalsIgnoreCase(parama.mAppId))
        {
          Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "removeOnRunningStateChangedListener");
          parama.qsB.b(this.sPL);
        }
        Log.d("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "markVideoPlayerRelease");
        if (this.sQH == null)
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
          parama = (com.tencent.mm.plugin.appbrand.jsapi.al.a)parama.aO(com.tencent.mm.plugin.appbrand.jsapi.al.a.class);
          if (parama == null)
          {
            Log.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "markVideoPlayerRelease, audioOfVideoBackgroundPlayManager is null");
            AppMethodBeat.o(139579);
            return;
          }
          parama.f(this.sQH);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.e.c
 * JD-Core Version:    0.7.0.1
 */