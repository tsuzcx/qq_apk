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
  private k lmV;
  private j lmW;
  private com.tencent.mm.plugin.appbrand.jsapi.video.b.a.b lmX;
  private com.tencent.mm.plugin.appbrand.jsapi.video.b.c.n lmY;
  private b lmZ;
  private com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a lmm;
  
  public i(com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a parama, com.tencent.mm.plugin.appbrand.jsapi.video.b.c.e parame, com.tencent.mm.plugin.appbrand.jsapi.video.b.c.n paramn)
  {
    AppMethodBeat.i(206037);
    if (this.lmZ == null) {
      this.lmZ = new h((byte)0);
    }
    this.lmW = new n("com.tencent.mm.video", new g(), this.lmZ, parame, new d(paramn.loy, paramn.getLogTag()), paramn);
    this.lmV = new k();
    this.lmm = parama;
    if (parama != null) {
      this.lmX = new com.tencent.mm.plugin.appbrand.jsapi.video.b.a.b(parama, com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bnx().lmg);
    }
    this.lmY = paramn;
    AppMethodBeat.o(206037);
  }
  
  public final e dx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(206038);
    this.lmW.QL(paramString2);
    if (this.lmX != null) {
      this.lmX.lmq = paramString2;
    }
    this.lmV.QL(paramString2);
    int i;
    boolean bool2;
    if (!URLUtil.isNetworkUrl(paramString1))
    {
      i = 1;
      boolean bool1 = com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.Rc(paramString1);
      bool2 = com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.Rd(paramString1);
      if (!bool1) {
        break label127;
      }
      paramString1 = new a(com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bnx().appContext);
      paramString1.QL(paramString2);
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, paramString2 + "DataSourceBuilder", "play asset file, dataSource:".concat(String.valueOf(paramString1)));
    }
    for (;;)
    {
      AppMethodBeat.o(206038);
      return paramString1;
      i = 0;
      break;
      label127:
      if (bool2)
      {
        paramString1 = new o(com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bnx().appContext);
        paramString1.QL(paramString2);
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, paramString2 + "DataSourceBuilder", "play raw file, dataSource:".concat(String.valueOf(paramString1)));
      }
      else if (i != 0)
      {
        paramString1 = this.lmV;
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, paramString2 + "DataSourceBuilder", "play local file, dataSource:".concat(String.valueOf(paramString1)));
      }
      else
      {
        if ((this.lmm != null) && (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bnx().lma)) {
          break label288;
        }
        paramString1 = this.lmW;
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(5, paramString2 + "DataSourceBuilder", "cache disabled, dataSource:".concat(String.valueOf(paramString1)));
      }
    }
    label288:
    a locala = new a();
    com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a locala1 = this.lmm;
    j localj = this.lmW;
    k localk = this.lmV;
    if (this.lmY.lov) {}
    for (paramString1 = this.lmX;; paramString1 = null)
    {
      paramString1 = new c(locala1, localj, localk, paramString1, locala);
      paramString1.QL(paramString2);
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
      AppMethodBeat.i(206036);
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(3, "DataSourceBuilder", String.format("downloadSizeAndDuration, uuid:%s, totalUpstreamBytesRead:%s, totalUpstreamReadCost:%s, totalLength:%s, totalCachedBytesRead:%s", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) }));
      if (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bnx().lmj != null) {
        com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bnx();
      }
      AppMethodBeat.o(206036);
    }
    
    public final void b(String paramString, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(206035);
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(3, "DataSourceBuilder", String.format("onHttpUpstreamServerCost, videoUuid:%s, httpDnsCost:%s, httpConnectCost:%s, httpFirstRecvCost:%s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) }));
      if (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bnx().lmj != null) {
        com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bnx();
      }
      AppMethodBeat.o(206035);
    }
    
    public final void k(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(206034);
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(3, "DataSourceBuilder", String.format("onCachedBytesRead, cacheSizeBytes:%s, cachedBytesRead:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
      AppMethodBeat.o(206034);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.i
 * JD-Core Version:    0.7.0.1
 */