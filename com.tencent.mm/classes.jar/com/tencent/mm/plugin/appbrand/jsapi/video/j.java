package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import com.google.android.exoplayer2.h.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.l;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.m;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class j
  implements g
{
  private static j llR;
  private boolean ivz;
  public boolean llS;
  private boolean llT;
  private com.tencent.mm.plugin.appbrand.jsapi.video.b.c.k llU;
  
  public j()
  {
    AppMethodBeat.i(205939);
    this.ivz = false;
    this.llS = true;
    this.llT = false;
    this.llU = new com.tencent.mm.plugin.appbrand.jsapi.video.b.c.k()
    {
      public final void bnu()
      {
        AppMethodBeat.i(205938);
        j.a(j.this);
        AppMethodBeat.o(205938);
      }
      
      public final void tu(int paramAnonymousInt)
      {
        AppMethodBeat.i(205937);
        if (paramAnonymousInt < 0) {
          j.a(j.this);
        }
        AppMethodBeat.o(205937);
      }
    };
    AppMethodBeat.o(205939);
  }
  
  private static String QG(String paramString)
  {
    AppMethodBeat.i(205942);
    String str2 = b.arU();
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    str1 = str1 + paramString + "/";
    try
    {
      if (!com.tencent.mm.vfs.i.aYg(str1))
      {
        ad.w("MicroMsg.SameLayer.VideoCore", "mkdirs fail 1, maybe dir exist:%s", new Object[] { str1 });
        if (!new com.tencent.mm.vfs.e(str1).isDirectory())
        {
          ad.w("MicroMsg.SameLayer.VideoCore", "mkdirs fail 2, not dir:%s", new Object[] { str1 });
          com.tencent.mm.vfs.i.deleteFile(str1);
          if (!com.tencent.mm.vfs.i.aYg(str1))
          {
            ad.w("MicroMsg.SameLayer.VideoCore", "mkdirs fail 3, no space? dir:%s", new Object[] { str1 });
            AppMethodBeat.o(205942);
            return null;
          }
        }
      }
      ad.i("MicroMsg.SameLayer.VideoCore", "ensureDir %s:%s", new Object[] { paramString, str1 });
      AppMethodBeat.o(205942);
      return str1;
    }
    catch (Throwable paramString)
    {
      ad.e("MicroMsg.SameLayer.VideoCore", "mkdirs exception:%s", new Object[] { paramString });
      AppMethodBeat.o(205942);
    }
    return null;
  }
  
  public static j bnr()
  {
    AppMethodBeat.i(205940);
    if (llR == null) {}
    try
    {
      if (llR == null) {
        llR = new j();
      }
      j localj = llR;
      AppMethodBeat.o(205940);
      return localj;
    }
    finally
    {
      AppMethodBeat.o(205940);
    }
  }
  
  public final void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.appbrand.jsapi.video.b.d.a parama, f paramf)
  {
    AppMethodBeat.i(205941);
    if (this.ivz)
    {
      ad.i("MicroMsg.SameLayer.VideoCore", "init already, current enableProxy:%s", new Object[] { Boolean.valueOf(this.llS) });
      AppMethodBeat.o(205941);
      return;
    }
    ad.i("MicroMsg.SameLayer.VideoCore", "init, enableProxy:%s, enableHlsProxy:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    long l = bt.flT();
    this.ivz = true;
    this.llT = paramBoolean2;
    this.llS = paramBoolean1;
    String str;
    if (this.llS)
    {
      str = QG("wxvideocache");
      if (bt.isNullOrNil(str))
      {
        this.llS = false;
        ad.i("MicroMsg.SameLayer.VideoCore", "init, disableProxy for cache dir make fail");
        parama.tu(-1);
      }
    }
    else
    {
      ad.i("MicroMsg.SameLayer.VideoCore", "init, costTimeMs:%s", new Object[] { Long.valueOf(bt.flT() - l) });
      AppMethodBeat.o(205941);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.video.b.a.init(paramContext.getApplicationContext());
    paramContext = com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bnx();
    if ((com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE)) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      paramContext.cFj = paramBoolean1;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bnx().lmg = 1048576L;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bnx().lmf = 536870912L;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bnx().llZ = true;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bnx().lma = true;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bnx().lmb = true;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bnx().lmc = paramBoolean2;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bnx().lmd = false;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bnx().lmh = 3;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bnx().lmi = new k();
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bnx().lmk = new com.tencent.mm.plugin.appbrand.jsapi.video.b.a.g();
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bnx().lmj = parama;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bnx().lml = paramf;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bnx().llU = this.llU;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bnx().cacheDir = str;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bnx().tmpDir = QG("wxvideotmp");
      l.init();
      break;
    }
  }
  
  public final g.a bne()
  {
    AppMethodBeat.i(205943);
    if (!this.llS)
    {
      com.google.android.exoplayer2.h.a.e locale = c.bnd().llG;
      AppMethodBeat.o(205943);
      return locale;
    }
    AppMethodBeat.o(205943);
    return null;
  }
  
  public final boolean bns()
  {
    return this.llT;
  }
  
  public final boolean bnt()
  {
    return this.llS;
  }
  
  public final long f(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(205946);
    if (!this.llS)
    {
      paramLong1 = c.bnd().f(paramString, paramLong1, paramLong2);
      AppMethodBeat.o(205946);
      return paramLong1;
    }
    try
    {
      paramLong1 = l.bnG().QK(paramString);
      AppMethodBeat.o(205946);
      return paramLong1;
    }
    catch (Exception paramString)
    {
      h.a(6, "MicroMsg.SameLayer.VideoCore", "getCachedBytes exception", paramString);
      AppMethodBeat.o(205946);
    }
    return 0L;
  }
  
  public final String getProxyUrl(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(205944);
    if (!this.llS)
    {
      paramString = c.bnd().getProxyUrl(paramString);
      AppMethodBeat.o(205944);
      return paramString;
    }
    if (!bt.isNullOrNil(paramString)) {
      if ((bt.isNullOrNil(paramString)) || (!paramString.startsWith("http://127.0.0.1"))) {
        break label67;
      }
    }
    while (i != 0)
    {
      AppMethodBeat.o(205944);
      return paramString;
      label67:
      i = 0;
    }
    try
    {
      String str = l.bnG().lnB.a(paramString, true, true, "video/mp4", 90);
      AppMethodBeat.o(205944);
      return str;
    }
    catch (Exception localException)
    {
      h.a(6, "MicroMsg.SameLayer.VideoCore", "getProxyUrl exception", localException);
      AppMethodBeat.o(205944);
    }
    return paramString;
  }
  
  public final void o(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(205945);
    if (!this.llS)
    {
      c.bnd().o(paramString, paramLong1, paramLong2);
      AppMethodBeat.o(205945);
      return;
    }
    try
    {
      l.bnG().U(paramString, paramLong2);
      AppMethodBeat.o(205945);
      return;
    }
    catch (Exception paramString)
    {
      h.a(6, "MicroMsg.SameLayer.VideoCore", "preload exception", paramString);
      AppMethodBeat.o(205945);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.j
 * JD-Core Version:    0.7.0.1
 */