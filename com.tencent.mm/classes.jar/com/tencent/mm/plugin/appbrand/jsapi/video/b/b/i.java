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
  private com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a mxs;
  private k myb;
  private j myc;
  private com.tencent.mm.plugin.appbrand.jsapi.video.b.a.b myd;
  private com.tencent.mm.plugin.appbrand.jsapi.video.b.c.n mye;
  private b myf;
  
  public i(com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a parama, com.tencent.mm.plugin.appbrand.jsapi.video.b.c.e parame, com.tencent.mm.plugin.appbrand.jsapi.video.b.c.n paramn)
  {
    AppMethodBeat.i(234733);
    if (this.myf == null) {
      this.myf = new h((byte)0);
    }
    this.myc = new n("com.tencent.mm.video", new g(), this.myf, parame, new d(paramn.mzx, paramn.getLogTag()), paramn);
    this.myb = new k();
    this.mxs = parama;
    if (parama != null) {
      this.myd = new com.tencent.mm.plugin.appbrand.jsapi.video.b.a.b(parama, com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxm);
    }
    this.mye = paramn;
    AppMethodBeat.o(234733);
  }
  
  public final e dO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(234734);
    this.myc.setLogTag(paramString2);
    if (this.myd != null) {
      this.myd.mxw = paramString2;
    }
    this.myb.setLogTag(paramString2);
    int i;
    boolean bool2;
    if (!URLUtil.isNetworkUrl(paramString1))
    {
      i = 1;
      boolean bool1 = com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.abq(paramString1);
      bool2 = com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.abr(paramString1);
      if (!bool1) {
        break label127;
      }
      paramString1 = new a(com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().appContext);
      paramString1.setLogTag(paramString2);
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, paramString2 + "DataSourceBuilder", "play asset file, dataSource:".concat(String.valueOf(paramString1)));
    }
    for (;;)
    {
      AppMethodBeat.o(234734);
      return paramString1;
      i = 0;
      break;
      label127:
      if (bool2)
      {
        paramString1 = new o(com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().appContext);
        paramString1.setLogTag(paramString2);
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, paramString2 + "DataSourceBuilder", "play raw file, dataSource:".concat(String.valueOf(paramString1)));
      }
      else if (i != 0)
      {
        paramString1 = this.myb;
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, paramString2 + "DataSourceBuilder", "play local file, dataSource:".concat(String.valueOf(paramString1)));
      }
      else
      {
        if ((this.mxs != null) && (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxg)) {
          break label288;
        }
        paramString1 = this.myc;
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(5, paramString2 + "DataSourceBuilder", "cache disabled, dataSource:".concat(String.valueOf(paramString1)));
      }
    }
    label288:
    a locala = new a();
    com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a locala1 = this.mxs;
    j localj = this.myc;
    k localk = this.myb;
    if (this.mye.mzv) {}
    for (paramString1 = this.myd;; paramString1 = null)
    {
      paramString1 = new c(locala1, localj, localk, paramString1, locala);
      paramString1.setLogTag(paramString2);
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
      AppMethodBeat.i(234732);
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(3, "DataSourceBuilder", String.format("downloadSizeAndDuration, uuid:%s, totalUpstreamBytesRead:%s, totalUpstreamReadCost:%s, totalLength:%s, totalCachedBytesRead:%s", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) }));
      if (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxp != null) {
        com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK();
      }
      AppMethodBeat.o(234732);
    }
    
    public final void b(String paramString, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(234731);
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(3, "DataSourceBuilder", String.format("onHttpUpstreamServerCost, videoUuid:%s, httpDnsCost:%s, httpConnectCost:%s, httpFirstRecvCost:%s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) }));
      if (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxp != null) {
        com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK();
      }
      AppMethodBeat.o(234731);
    }
    
    public final void k(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(234730);
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(3, "DataSourceBuilder", String.format("onCachedBytesRead, cacheSizeBytes:%s, cachedBytesRead:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
      AppMethodBeat.o(234730);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.i
 * JD-Core Version:    0.7.0.1
 */