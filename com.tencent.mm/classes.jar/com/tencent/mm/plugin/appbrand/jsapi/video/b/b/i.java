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
  private com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a lqM;
  private k lrv;
  private j lrw;
  private com.tencent.mm.plugin.appbrand.jsapi.video.b.a.b lrx;
  private com.tencent.mm.plugin.appbrand.jsapi.video.b.c.n lry;
  private b lrz;
  
  public i(com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a parama, com.tencent.mm.plugin.appbrand.jsapi.video.b.c.e parame, com.tencent.mm.plugin.appbrand.jsapi.video.b.c.n paramn)
  {
    AppMethodBeat.i(211064);
    if (this.lrz == null) {
      this.lrz = new h((byte)0);
    }
    this.lrw = new n("com.tencent.mm.video", new g(), this.lrz, parame, new d(paramn.lsV, paramn.getLogTag()), paramn);
    this.lrv = new k();
    this.lqM = parama;
    if (parama != null) {
      this.lrx = new com.tencent.mm.plugin.appbrand.jsapi.video.b.a.b(parama, com.tencent.mm.plugin.appbrand.jsapi.video.b.a.boh().lqG);
    }
    this.lry = paramn;
    AppMethodBeat.o(211064);
  }
  
  public final e dz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(211065);
    this.lrw.Ru(paramString2);
    if (this.lrx != null) {
      this.lrx.lqQ = paramString2;
    }
    this.lrv.Ru(paramString2);
    int i;
    boolean bool2;
    if (!URLUtil.isNetworkUrl(paramString1))
    {
      i = 1;
      boolean bool1 = com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.RL(paramString1);
      bool2 = com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.RM(paramString1);
      if (!bool1) {
        break label127;
      }
      paramString1 = new a(com.tencent.mm.plugin.appbrand.jsapi.video.b.a.boh().appContext);
      paramString1.Ru(paramString2);
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, paramString2 + "DataSourceBuilder", "play asset file, dataSource:".concat(String.valueOf(paramString1)));
    }
    for (;;)
    {
      AppMethodBeat.o(211065);
      return paramString1;
      i = 0;
      break;
      label127:
      if (bool2)
      {
        paramString1 = new o(com.tencent.mm.plugin.appbrand.jsapi.video.b.a.boh().appContext);
        paramString1.Ru(paramString2);
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, paramString2 + "DataSourceBuilder", "play raw file, dataSource:".concat(String.valueOf(paramString1)));
      }
      else if (i != 0)
      {
        paramString1 = this.lrv;
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, paramString2 + "DataSourceBuilder", "play local file, dataSource:".concat(String.valueOf(paramString1)));
      }
      else
      {
        if ((this.lqM != null) && (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.boh().lqA)) {
          break label288;
        }
        paramString1 = this.lrw;
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(5, paramString2 + "DataSourceBuilder", "cache disabled, dataSource:".concat(String.valueOf(paramString1)));
      }
    }
    label288:
    a locala = new a();
    com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a locala1 = this.lqM;
    j localj = this.lrw;
    k localk = this.lrv;
    if (this.lry.lsT) {}
    for (paramString1 = this.lrx;; paramString1 = null)
    {
      paramString1 = new c(locala1, localj, localk, paramString1, locala);
      paramString1.Ru(paramString2);
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
      AppMethodBeat.i(211063);
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(3, "DataSourceBuilder", String.format("downloadSizeAndDuration, uuid:%s, totalUpstreamBytesRead:%s, totalUpstreamReadCost:%s, totalLength:%s, totalCachedBytesRead:%s", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) }));
      if (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.boh().lqJ != null) {
        com.tencent.mm.plugin.appbrand.jsapi.video.b.a.boh();
      }
      AppMethodBeat.o(211063);
    }
    
    public final void b(String paramString, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(211062);
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(3, "DataSourceBuilder", String.format("onHttpUpstreamServerCost, videoUuid:%s, httpDnsCost:%s, httpConnectCost:%s, httpFirstRecvCost:%s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) }));
      if (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.boh().lqJ != null) {
        com.tencent.mm.plugin.appbrand.jsapi.video.b.a.boh();
      }
      AppMethodBeat.o(211062);
    }
    
    public final void k(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(211061);
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(3, "DataSourceBuilder", String.format("onCachedBytesRead, cacheSizeBytes:%s, cachedBytesRead:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
      AppMethodBeat.o(211061);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.i
 * JD-Core Version:    0.7.0.1
 */