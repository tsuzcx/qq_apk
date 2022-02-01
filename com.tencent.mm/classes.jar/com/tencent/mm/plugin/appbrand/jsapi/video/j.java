package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import com.google.android.exoplayer2.h.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.l;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

public class j
  implements g
{
  private static j knU;
  private boolean hBC;
  public boolean knV;
  private boolean knW;
  private com.tencent.mm.plugin.appbrand.jsapi.video.b.c.k knX;
  
  public j()
  {
    AppMethodBeat.i(193780);
    this.hBC = false;
    this.knV = true;
    this.knW = false;
    this.knX = new com.tencent.mm.plugin.appbrand.jsapi.video.b.c.k()
    {
      public final void bcN()
      {
        AppMethodBeat.i(193779);
        j.a(j.this);
        AppMethodBeat.o(193779);
      }
      
      public final void sb(int paramAnonymousInt)
      {
        AppMethodBeat.i(193778);
        if (paramAnonymousInt < 0) {
          j.a(j.this);
        }
        AppMethodBeat.o(193778);
      }
    };
    AppMethodBeat.o(193780);
  }
  
  private static String Jf(String paramString)
  {
    AppMethodBeat.i(193783);
    String str2 = b.aih();
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    str1 = str1 + paramString + "/";
    try
    {
      if (!i.aMF(str1))
      {
        ad.w("MicroMsg.SameLayer.VideoCore", "mkdirs fail 1, maybe dir exist:%s", new Object[] { str1 });
        if (!new com.tencent.mm.vfs.e(str1).isDirectory())
        {
          ad.w("MicroMsg.SameLayer.VideoCore", "mkdirs fail 2, not dir:%s", new Object[] { str1 });
          i.deleteFile(str1);
          if (!i.aMF(str1))
          {
            ad.w("MicroMsg.SameLayer.VideoCore", "mkdirs fail 3, no space? dir:%s", new Object[] { str1 });
            AppMethodBeat.o(193783);
            return null;
          }
        }
      }
      ad.i("MicroMsg.SameLayer.VideoCore", "ensureDir %s:%s", new Object[] { paramString, str1 });
      AppMethodBeat.o(193783);
      return str1;
    }
    catch (Throwable paramString)
    {
      ad.e("MicroMsg.SameLayer.VideoCore", "mkdirs exception:%s", new Object[] { paramString });
      AppMethodBeat.o(193783);
    }
    return null;
  }
  
  public static j bcK()
  {
    AppMethodBeat.i(193781);
    if (knU == null) {}
    try
    {
      if (knU == null) {
        knU = new j();
      }
      j localj = knU;
      AppMethodBeat.o(193781);
      return localj;
    }
    finally
    {
      AppMethodBeat.o(193781);
    }
  }
  
  public final void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.appbrand.jsapi.video.b.d.a parama, f paramf)
  {
    AppMethodBeat.i(193782);
    if (this.hBC)
    {
      ad.i("MicroMsg.SameLayer.VideoCore", "init already, current enableProxy:%s", new Object[] { Boolean.valueOf(this.knV) });
      AppMethodBeat.o(193782);
      return;
    }
    ad.i("MicroMsg.SameLayer.VideoCore", "init, enableProxy:%s, enableHlsProxy:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    long l = bt.eGO();
    this.hBC = true;
    this.knW = paramBoolean2;
    this.knV = paramBoolean1;
    String str;
    if (this.knV)
    {
      str = Jf("wxvideocache");
      if (bt.isNullOrNil(str))
      {
        this.knV = false;
        ad.i("MicroMsg.SameLayer.VideoCore", "init, disableProxy for cache dir make fail");
        parama.sb(-1);
      }
    }
    else
    {
      ad.i("MicroMsg.SameLayer.VideoCore", "init, costTimeMs:%s", new Object[] { Long.valueOf(bt.eGO() - l) });
      AppMethodBeat.o(193782);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.video.b.a.init(paramContext.getApplicationContext());
    paramContext = com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bcR();
    if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE)) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      paramContext.cxf = paramBoolean1;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bcR().kom = 1048576L;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bcR().kol = 536870912L;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bcR().kod = true;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bcR().koe = true;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bcR().kof = true;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bcR().kog = paramBoolean2;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bcR().koh = false;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bcR().kon = 3;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bcR().koo = new k();
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bcR().koq = new com.tencent.mm.plugin.appbrand.jsapi.video.b.a.g();
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bcR().kop = parama;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bcR().kor = paramf;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bcR().knX = this.knX;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bcR().koj = str;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bcR().koi = Jf("wxvideotmp");
      l.init();
      break;
    }
  }
  
  public final boolean bcL()
  {
    return this.knW;
  }
  
  public final boolean bcM()
  {
    return this.knV;
  }
  
  public final g.a bcx()
  {
    AppMethodBeat.i(193784);
    if (!this.knV)
    {
      com.google.android.exoplayer2.h.a.e locale = c.bcw().knJ;
      AppMethodBeat.o(193784);
      return locale;
    }
    AppMethodBeat.o(193784);
    return null;
  }
  
  public final long g(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(193787);
    if (!this.knV)
    {
      paramLong1 = c.bcw().g(paramString, paramLong1, paramLong2);
      AppMethodBeat.o(193787);
      return paramLong1;
    }
    try
    {
      paramLong1 = l.bda().Jj(paramString);
      AppMethodBeat.o(193787);
      return paramLong1;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.a(6, "MicroMsg.SameLayer.VideoCore", "getCachedBytes exception", paramString);
      AppMethodBeat.o(193787);
    }
    return 0L;
  }
  
  public final String getProxyUrl(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(193785);
    if (!this.knV)
    {
      paramString = c.bcw().getProxyUrl(paramString);
      AppMethodBeat.o(193785);
      return paramString;
    }
    if (!bt.isNullOrNil(paramString)) {
      if ((bt.isNullOrNil(paramString)) || (!paramString.startsWith("http://127.0.0.1"))) {
        break label67;
      }
    }
    while (i != 0)
    {
      AppMethodBeat.o(193785);
      return paramString;
      label67:
      i = 0;
    }
    try
    {
      String str = l.bda().kpH.a(paramString, true, true, "video/mp4", 90);
      AppMethodBeat.o(193785);
      return str;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.a(6, "MicroMsg.SameLayer.VideoCore", "getProxyUrl exception", localException);
      AppMethodBeat.o(193785);
    }
    return paramString;
  }
  
  public final void r(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(193786);
    if (!this.knV)
    {
      c.bcw().r(paramString, paramLong1, paramLong2);
      AppMethodBeat.o(193786);
      return;
    }
    try
    {
      l.bda().M(paramString, paramLong2);
      AppMethodBeat.o(193786);
      return;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.a(6, "MicroMsg.SameLayer.VideoCore", "preload exception", paramString);
      AppMethodBeat.o(193786);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.j
 * JD-Core Version:    0.7.0.1
 */