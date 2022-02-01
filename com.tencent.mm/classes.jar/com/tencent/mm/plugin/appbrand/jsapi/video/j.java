package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import com.google.android.exoplayer2.h.a.e;
import com.google.android.exoplayer2.h.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.l;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.m;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;

public class j
  implements g
{
  private static j lqr;
  private boolean iys;
  public boolean lqs;
  private boolean lqt;
  private com.tencent.mm.plugin.appbrand.jsapi.video.b.c.k lqu;
  
  public j()
  {
    AppMethodBeat.i(210966);
    this.iys = false;
    this.lqs = true;
    this.lqt = false;
    this.lqu = new com.tencent.mm.plugin.appbrand.jsapi.video.b.c.k()
    {
      public final void boe()
      {
        AppMethodBeat.i(210965);
        j.a(j.this);
        AppMethodBeat.o(210965);
      }
      
      public final void ty(int paramAnonymousInt)
      {
        AppMethodBeat.i(210964);
        if (paramAnonymousInt < 0) {
          j.a(j.this);
        }
        AppMethodBeat.o(210964);
      }
    };
    AppMethodBeat.o(210966);
  }
  
  private static String Rp(String paramString)
  {
    AppMethodBeat.i(210969);
    String str2 = b.asj();
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    str1 = str1 + paramString + "/";
    try
    {
      if (!o.aZI(str1))
      {
        ae.w("MicroMsg.SameLayer.VideoCore", "mkdirs fail 1, maybe dir exist:%s", new Object[] { str1 });
        if (!new com.tencent.mm.vfs.k(str1).isDirectory())
        {
          ae.w("MicroMsg.SameLayer.VideoCore", "mkdirs fail 2, not dir:%s", new Object[] { str1 });
          o.deleteFile(str1);
          if (!o.aZI(str1))
          {
            ae.w("MicroMsg.SameLayer.VideoCore", "mkdirs fail 3, no space? dir:%s", new Object[] { str1 });
            AppMethodBeat.o(210969);
            return null;
          }
        }
      }
      ae.i("MicroMsg.SameLayer.VideoCore", "ensureDir %s:%s", new Object[] { paramString, str1 });
      AppMethodBeat.o(210969);
      return str1;
    }
    catch (Throwable paramString)
    {
      ae.e("MicroMsg.SameLayer.VideoCore", "mkdirs exception:%s", new Object[] { paramString });
      AppMethodBeat.o(210969);
    }
    return null;
  }
  
  public static j bob()
  {
    AppMethodBeat.i(210967);
    if (lqr == null) {}
    try
    {
      if (lqr == null) {
        lqr = new j();
      }
      j localj = lqr;
      AppMethodBeat.o(210967);
      return localj;
    }
    finally
    {
      AppMethodBeat.o(210967);
    }
  }
  
  public final void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.appbrand.jsapi.video.b.d.a parama, f paramf)
  {
    AppMethodBeat.i(210968);
    if (this.iys)
    {
      ae.i("MicroMsg.SameLayer.VideoCore", "init already, current enableProxy:%s", new Object[] { Boolean.valueOf(this.lqs) });
      AppMethodBeat.o(210968);
      return;
    }
    ae.i("MicroMsg.SameLayer.VideoCore", "init, enableProxy:%s, enableHlsProxy:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    long l = bu.fpO();
    this.iys = true;
    this.lqt = paramBoolean2;
    this.lqs = paramBoolean1;
    String str;
    if (this.lqs)
    {
      str = Rp("wxvideocache");
      if (bu.isNullOrNil(str))
      {
        this.lqs = false;
        ae.i("MicroMsg.SameLayer.VideoCore", "init, disableProxy for cache dir make fail");
        parama.ty(-1);
      }
    }
    else
    {
      ae.i("MicroMsg.SameLayer.VideoCore", "init, costTimeMs:%s", new Object[] { Long.valueOf(bu.fpO() - l) });
      AppMethodBeat.o(210968);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.video.b.a.init(paramContext.getApplicationContext());
    paramContext = com.tencent.mm.plugin.appbrand.jsapi.video.b.a.boh();
    if ((com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE)) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      paramContext.cFS = paramBoolean1;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.boh().lqG = 1048576L;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.boh().lqF = 536870912L;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.boh().lqz = true;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.boh().lqA = true;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.boh().lqB = true;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.boh().lqC = paramBoolean2;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.boh().lqD = false;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.boh().lqH = 3;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.boh().lqI = new k();
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.boh().lqK = new com.tencent.mm.plugin.appbrand.jsapi.video.b.a.g();
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.boh().lqJ = parama;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.boh().lqL = paramf;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.boh().lqu = this.lqu;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.boh().cacheDir = str;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.boh().tmpDir = Rp("wxvideotmp");
      l.init();
      break;
    }
  }
  
  public final g.a bnO()
  {
    AppMethodBeat.i(210970);
    if (!this.lqs)
    {
      e locale = c.bnN().lqg;
      AppMethodBeat.o(210970);
      return locale;
    }
    AppMethodBeat.o(210970);
    return null;
  }
  
  public final boolean boc()
  {
    return this.lqt;
  }
  
  public final boolean bod()
  {
    return this.lqs;
  }
  
  public final long f(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(210973);
    if (!this.lqs)
    {
      paramLong1 = c.bnN().f(paramString, paramLong1, paramLong2);
      AppMethodBeat.o(210973);
      return paramLong1;
    }
    try
    {
      paramLong1 = l.boq().Rt(paramString);
      AppMethodBeat.o(210973);
      return paramLong1;
    }
    catch (Exception paramString)
    {
      h.a(6, "MicroMsg.SameLayer.VideoCore", "getCachedBytes exception", paramString);
      AppMethodBeat.o(210973);
    }
    return 0L;
  }
  
  public final String getProxyUrl(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(210971);
    if (!this.lqs)
    {
      paramString = c.bnN().getProxyUrl(paramString);
      AppMethodBeat.o(210971);
      return paramString;
    }
    if (!bu.isNullOrNil(paramString)) {
      if ((bu.isNullOrNil(paramString)) || (!paramString.startsWith("http://127.0.0.1"))) {
        break label67;
      }
    }
    while (i != 0)
    {
      AppMethodBeat.o(210971);
      return paramString;
      label67:
      i = 0;
    }
    try
    {
      String str = l.boq().lsa.a(paramString, true, true, "video/mp4", 90);
      AppMethodBeat.o(210971);
      return str;
    }
    catch (Exception localException)
    {
      h.a(6, "MicroMsg.SameLayer.VideoCore", "getProxyUrl exception", localException);
      AppMethodBeat.o(210971);
    }
    return paramString;
  }
  
  public final void o(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(210972);
    if (!this.lqs)
    {
      c.bnN().o(paramString, paramLong1, paramLong2);
      AppMethodBeat.o(210972);
      return;
    }
    try
    {
      l.boq().U(paramString, paramLong2);
      AppMethodBeat.o(210972);
      return;
    }
    catch (Exception paramString)
    {
      h.a(6, "MicroMsg.SameLayer.VideoCore", "preload exception", paramString);
      AppMethodBeat.o(210972);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.j
 * JD-Core Version:    0.7.0.1
 */