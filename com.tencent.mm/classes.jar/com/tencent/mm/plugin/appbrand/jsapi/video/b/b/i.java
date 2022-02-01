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
  private com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a sAS;
  private k sBB;
  private j sBC;
  private com.tencent.mm.plugin.appbrand.jsapi.video.b.a.b sBD;
  private com.tencent.mm.plugin.appbrand.jsapi.video.b.c.n sBE;
  private b sBF;
  
  public i(com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a parama, com.tencent.mm.plugin.appbrand.jsapi.video.b.c.e parame, com.tencent.mm.plugin.appbrand.jsapi.video.b.c.n paramn)
  {
    AppMethodBeat.i(328511);
    if (this.sBF == null) {
      this.sBF = new h((byte)0);
    }
    this.sBC = new n("com.tencent.mm.video", new g(), this.sBF, parame, new d(paramn.sCX, paramn.getLogTag()), paramn);
    this.sBB = new k();
    this.sAS = parama;
    if (parama != null) {
      this.sBD = new com.tencent.mm.plugin.appbrand.jsapi.video.b.a.b(parama, com.tencent.mm.plugin.appbrand.jsapi.video.b.a.cvH().sAM);
    }
    this.sBE = paramn;
    AppMethodBeat.o(328511);
  }
  
  public final e es(String paramString1, String paramString2)
  {
    AppMethodBeat.i(328529);
    this.sBC.setLogTag(paramString2);
    if (this.sBD != null) {
      this.sBD.sAW = paramString2;
    }
    this.sBB.setLogTag(paramString2);
    int i;
    boolean bool2;
    if (!URLUtil.isNetworkUrl(paramString1))
    {
      i = 1;
      boolean bool1 = com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.ack(paramString1);
      bool2 = com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.acl(paramString1);
      if (!bool1) {
        break label127;
      }
      paramString1 = new a(com.tencent.mm.plugin.appbrand.jsapi.video.b.a.cvH().appContext);
      paramString1.setLogTag(paramString2);
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, paramString2 + "DataSourceBuilder", "play asset file, dataSource:".concat(String.valueOf(paramString1)));
    }
    for (;;)
    {
      AppMethodBeat.o(328529);
      return paramString1;
      i = 0;
      break;
      label127:
      if (bool2)
      {
        paramString1 = new o(com.tencent.mm.plugin.appbrand.jsapi.video.b.a.cvH().appContext);
        paramString1.setLogTag(paramString2);
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, paramString2 + "DataSourceBuilder", "play raw file, dataSource:".concat(String.valueOf(paramString1)));
      }
      else if (i != 0)
      {
        paramString1 = this.sBB;
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, paramString2 + "DataSourceBuilder", "play local file, dataSource:".concat(String.valueOf(paramString1)));
      }
      else
      {
        if ((this.sAS != null) && (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.cvH().sAG)) {
          break label288;
        }
        paramString1 = this.sBC;
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(5, paramString2 + "DataSourceBuilder", "cache disabled, dataSource:".concat(String.valueOf(paramString1)));
      }
    }
    label288:
    a locala = new a();
    com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a locala1 = this.sAS;
    j localj = this.sBC;
    k localk = this.sBB;
    if (this.sBE.sCV) {}
    for (paramString1 = this.sBD;; paramString1 = null)
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
    
    public final void H(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(328512);
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(3, "DataSourceBuilder", String.format("onCachedBytesRead, cacheSizeBytes:%s, cachedBytesRead:%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
      AppMethodBeat.o(328512);
    }
    
    public final void a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(328530);
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(3, "DataSourceBuilder", String.format("downloadSizeAndDuration, uuid:%s, totalUpstreamBytesRead:%s, totalUpstreamReadCost:%s, totalLength:%s, totalCachedBytesRead:%s", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) }));
      if (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.cvH().sAP != null) {
        com.tencent.mm.plugin.appbrand.jsapi.video.b.a.cvH();
      }
      AppMethodBeat.o(328530);
    }
    
    public final void c(String paramString, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(328519);
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(3, "DataSourceBuilder", String.format("onHttpUpstreamServerCost, videoUuid:%s, httpDnsCost:%s, httpConnectCost:%s, httpFirstRecvCost:%s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) }));
      if (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.cvH().sAP != null) {
        com.tencent.mm.plugin.appbrand.jsapi.video.b.a.cvH();
      }
      AppMethodBeat.o(328519);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.i
 * JD-Core Version:    0.7.0.1
 */