package com.tencent.mm.plugin.appbrand.jsapi.video.b.b;

import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.g;

public final class i
  implements com.tencent.mm.plugin.appbrand.jsapi.video.b.c.a
{
  private com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a kos;
  private k kpc;
  private j kpd;
  private com.tencent.mm.plugin.appbrand.jsapi.video.b.a.b kpe;
  private com.tencent.mm.plugin.appbrand.jsapi.video.b.c.n kpf;
  private b kpg;
  
  public i(com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a parama, com.tencent.mm.plugin.appbrand.jsapi.video.b.c.e parame, com.tencent.mm.plugin.appbrand.jsapi.video.b.c.n paramn)
  {
    AppMethodBeat.i(193878);
    if (this.kpg == null) {
      this.kpg = new h((byte)0);
    }
    this.kpd = new n("com.tencent.mm.video", new g(), this.kpg, parame, new d(paramn.kqC, paramn.EE()), paramn);
    this.kpc = new k();
    this.kos = parama;
    if (parama != null) {
      this.kpe = new com.tencent.mm.plugin.appbrand.jsapi.video.b.a.b(parama, com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bcR().kom);
    }
    this.kpf = paramn;
    AppMethodBeat.o(193878);
  }
  
  public final e dj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(193879);
    this.kpd.Jk(paramString2);
    if (this.kpe != null) {
      this.kpe.kox = paramString2;
    }
    this.kpc.Jk(paramString2);
    int i;
    boolean bool2;
    if (!URLUtil.isNetworkUrl(paramString1))
    {
      i = 1;
      boolean bool1 = com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.JB(paramString1);
      bool2 = com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.JC(paramString1);
      if (!bool1) {
        break label127;
      }
      paramString1 = new a(com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bcR().kob);
      paramString1.Jk(paramString2);
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, paramString2 + "DataSourceBuilder", "play asset file, dataSource:".concat(String.valueOf(paramString1)));
    }
    for (;;)
    {
      AppMethodBeat.o(193879);
      return paramString1;
      i = 0;
      break;
      label127:
      if (bool2)
      {
        paramString1 = new o(com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bcR().kob);
        paramString1.Jk(paramString2);
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, paramString2 + "DataSourceBuilder", "play raw file, dataSource:".concat(String.valueOf(paramString1)));
      }
      else if (i != 0)
      {
        paramString1 = this.kpc;
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, paramString2 + "DataSourceBuilder", "play local file, dataSource:".concat(String.valueOf(paramString1)));
      }
      else
      {
        if ((this.kos != null) && (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bcR().koe)) {
          break label288;
        }
        paramString1 = this.kpd;
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(5, paramString2 + "DataSourceBuilder", "cache disabled, dataSource:".concat(String.valueOf(paramString1)));
      }
    }
    label288:
    a locala = new a();
    com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a locala1 = this.kos;
    j localj = this.kpd;
    k localk = this.kpc;
    if (this.kpf.kqz) {}
    for (paramString1 = this.kpe;; paramString1 = null)
    {
      paramString1 = new c(locala1, localj, localk, paramString1, locala);
      paramString1.Jk(paramString2);
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, paramString2 + "DataSourceBuilder", "cache enabled, dataSource:".concat(String.valueOf(paramString1)));
      break;
    }
  }
  
  public final class a
    implements c.a
  {
    public a() {}
    
    public final void a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(193877);
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(3, "DataSourceBuilder", String.format("downloadSizeAndDuration, uuid:%s, totalUpstreamBytesRead:%s, totalUpstreamReadCost:%s, totalLength:%s, totalCachedBytesRead:%s", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) }));
      if (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bcR().kop != null) {
        com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bcR();
      }
      AppMethodBeat.o(193877);
    }
    
    public final void b(String paramString, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(193876);
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(3, "DataSourceBuilder", String.format("onHttpUpstreamServerCost, videoUuid:%s, httpDnsCost:%s, httpConnectCost:%s, httpFirstRecvCost:%s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) }));
      if (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bcR().kop != null) {
        com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bcR();
      }
      AppMethodBeat.o(193876);
    }
    
    public final void m(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(193875);
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(3, "DataSourceBuilder", String.format("onCachedBytesRead, cacheSizeBytes:%s, cachedBytesRead:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
      AppMethodBeat.o(193875);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.i
 * JD-Core Version:    0.7.0.1
 */