package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.plugin.appbrand.aa.l.a;
import com.tencent.mm.plugin.appbrand.utils.e;
import com.tencent.mm.protocal.protobuf.azo;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.protocal.protobuf.ru;
import com.tencent.mm.protocal.protobuf.wq;
import com.tencent.mm.sdk.platformtools.ad;

public class h
  extends c<azp>
{
  public h(int paramInt1, wq paramwq, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(44681);
    ad.i("MicroMsg.Recommend.CgiGetRecommendWxa", "pageNum:%d, filterType:%d, sessionId:%d, strategy:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(5), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    b.a locala = new b.a();
    azo localazo = new azo();
    localazo.DxX = paramInt1;
    localazo.DxY = 5;
    localazo.DxZ = new ru();
    localazo.bTj = paramLong;
    localazo.Dya = paramwq;
    localazo.Dyb = paramInt2;
    locala.gUU = localazo;
    locala.gUV = new azp();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getrecommendwxa";
    locala.funcId = 2778;
    this.rr = locala.atI();
    AppMethodBeat.o(44681);
  }
  
  public static void a(int paramInt1, final wq paramwq, final long paramLong, final a parama, int paramInt2)
  {
    AppMethodBeat.i(44682);
    final long l = System.currentTimeMillis() / 1000L;
    e.bqm().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44680);
        new h(this.iWX, paramwq, paramLong, l) {}.auK();
        AppMethodBeat.o(44680);
      }
    });
    AppMethodBeat.o(44682);
  }
  
  public static abstract interface a
  {
    public abstract void a(azp paramazp);
    
    public abstract void aSv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.h
 * JD-Core Version:    0.7.0.1
 */