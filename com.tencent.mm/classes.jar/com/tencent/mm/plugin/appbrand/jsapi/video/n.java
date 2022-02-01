package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import com.google.android.exoplayer2.h.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.k;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.l;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;

public class n
  implements g
{
  private static n kPo;
  private boolean icd;
  public boolean kPp;
  private boolean kPq;
  private k kPr;
  
  public n()
  {
    AppMethodBeat.i(194127);
    this.icd = false;
    this.kPp = true;
    this.kPq = false;
    this.kPr = new k()
    {
      public final void bjJ()
      {
        AppMethodBeat.i(194126);
        n.a(n.this);
        AppMethodBeat.o(194126);
      }
      
      public final void sR(int paramAnonymousInt)
      {
        AppMethodBeat.i(194125);
        if (paramAnonymousInt < 0) {
          n.a(n.this);
        }
        AppMethodBeat.o(194125);
      }
    };
    AppMethodBeat.o(194127);
  }
  
  private static String Nj(String paramString)
  {
    AppMethodBeat.i(194130);
    String str2 = b.aph();
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    str1 = str1 + paramString + "/";
    try
    {
      if (!i.aSh(str1))
      {
        ac.w("MicroMsg.SameLayer.VideoCore", "mkdirs fail 1, maybe dir exist:%s", new Object[] { str1 });
        if (!new com.tencent.mm.vfs.e(str1).isDirectory())
        {
          ac.w("MicroMsg.SameLayer.VideoCore", "mkdirs fail 2, not dir:%s", new Object[] { str1 });
          i.deleteFile(str1);
          if (!i.aSh(str1))
          {
            ac.w("MicroMsg.SameLayer.VideoCore", "mkdirs fail 3, no space? dir:%s", new Object[] { str1 });
            AppMethodBeat.o(194130);
            return null;
          }
        }
      }
      ac.i("MicroMsg.SameLayer.VideoCore", "ensureDir %s:%s", new Object[] { paramString, str1 });
      AppMethodBeat.o(194130);
      return str1;
    }
    catch (Throwable paramString)
    {
      ac.e("MicroMsg.SameLayer.VideoCore", "mkdirs exception:%s", new Object[] { paramString });
      AppMethodBeat.o(194130);
    }
    return null;
  }
  
  public static n bjG()
  {
    AppMethodBeat.i(194128);
    if (kPo == null) {}
    try
    {
      if (kPo == null) {
        kPo = new n();
      }
      n localn = kPo;
      AppMethodBeat.o(194128);
      return localn;
    }
    finally
    {
      AppMethodBeat.o(194128);
    }
  }
  
  public final void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.appbrand.jsapi.video.b.d.a parama, f paramf)
  {
    AppMethodBeat.i(194129);
    if (this.icd)
    {
      ac.i("MicroMsg.SameLayer.VideoCore", "init already, current enableProxy:%s", new Object[] { Boolean.valueOf(this.kPp) });
      AppMethodBeat.o(194129);
      return;
    }
    ac.i("MicroMsg.SameLayer.VideoCore", "init, enableProxy:%s, enableHlsProxy:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    long l = bs.eWj();
    this.icd = true;
    this.kPq = paramBoolean2;
    this.kPp = paramBoolean1;
    String str;
    if (this.kPp)
    {
      str = Nj("wxvideocache");
      if (bs.isNullOrNil(str))
      {
        this.kPp = false;
        ac.i("MicroMsg.SameLayer.VideoCore", "init, disableProxy for cache dir make fail");
        parama.sR(-1);
      }
    }
    else
    {
      ac.i("MicroMsg.SameLayer.VideoCore", "init, costTimeMs:%s", new Object[] { Long.valueOf(bs.eWj() - l) });
      AppMethodBeat.o(194129);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.video.b.a.init(paramContext.getApplicationContext());
    paramContext = com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM();
    if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE)) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      paramContext.cuo = paramBoolean1;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM().kPF = 1048576L;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM().kPE = 536870912L;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM().kPx = true;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM().kPy = true;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM().kPz = true;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM().kPA = paramBoolean2;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM().kPB = false;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM().kPG = 3;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM().kPH = new o();
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM().kPJ = new com.tencent.mm.plugin.appbrand.jsapi.video.b.a.g();
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM().kPI = parama;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM().kPK = paramf;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM().kPr = this.kPr;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM().cacheDir = str;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM().kPC = Nj("wxvideotmp");
      l.init();
      break;
    }
  }
  
  public final boolean bjH()
  {
    return this.kPq;
  }
  
  public final boolean bjI()
  {
    return this.kPp;
  }
  
  public final g.a bjs()
  {
    AppMethodBeat.i(194131);
    if (!this.kPp)
    {
      com.google.android.exoplayer2.h.a.e locale = c.bjr().kPd;
      AppMethodBeat.o(194131);
      return locale;
    }
    AppMethodBeat.o(194131);
    return null;
  }
  
  public final long f(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(194134);
    if (!this.kPp)
    {
      paramLong1 = c.bjr().f(paramString, paramLong1, paramLong2);
      AppMethodBeat.o(194134);
      return paramLong1;
    }
    try
    {
      paramLong1 = l.bjV().Nn(paramString);
      AppMethodBeat.o(194134);
      return paramLong1;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.a(6, "MicroMsg.SameLayer.VideoCore", "getCachedBytes exception", paramString);
      AppMethodBeat.o(194134);
    }
    return 0L;
  }
  
  public final String getProxyUrl(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(194132);
    if (!this.kPp)
    {
      paramString = c.bjr().getProxyUrl(paramString);
      AppMethodBeat.o(194132);
      return paramString;
    }
    if (!bs.isNullOrNil(paramString)) {
      if ((bs.isNullOrNil(paramString)) || (!paramString.startsWith("http://127.0.0.1"))) {
        break label67;
      }
    }
    while (i != 0)
    {
      AppMethodBeat.o(194132);
      return paramString;
      label67:
      i = 0;
    }
    try
    {
      String str = l.bjV().kRa.a(paramString, true, true, "video/mp4", 90);
      AppMethodBeat.o(194132);
      return str;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.a(6, "MicroMsg.SameLayer.VideoCore", "getProxyUrl exception", localException);
      AppMethodBeat.o(194132);
    }
    return paramString;
  }
  
  public final void o(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(194133);
    if (!this.kPp)
    {
      c.bjr().o(paramString, paramLong1, paramLong2);
      AppMethodBeat.o(194133);
      return;
    }
    try
    {
      l.bjV().N(paramString, paramLong2);
      AppMethodBeat.o(194133);
      return;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.a(6, "MicroMsg.SameLayer.VideoCore", "preload exception", paramString);
      AppMethodBeat.o(194133);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.n
 * JD-Core Version:    0.7.0.1
 */