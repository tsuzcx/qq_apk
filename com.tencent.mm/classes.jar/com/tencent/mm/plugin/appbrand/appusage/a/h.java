package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.plugin.appbrand.y.m.a;
import com.tencent.mm.protocal.protobuf.bic;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.protocal.protobuf.ze;
import com.tencent.mm.sdk.platformtools.ae;

public class h
  extends a<bid>
{
  public h(int paramInt1, ze paramze, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(44681);
    ae.i("MicroMsg.Recommend.CgiGetRecommendWxa", "pageNum:%d, filterType:%d, sessionId:%d, strategy:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(5), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    b.a locala = new b.a();
    bic localbic = new bic();
    localbic.GWn = paramInt1;
    localbic.GWo = 5;
    localbic.GWp = new ua();
    localbic.cbe = paramLong;
    localbic.GWq = paramze;
    localbic.GWr = paramInt2;
    locala.hQF = localbic;
    locala.hQG = new bid();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getrecommendwxa";
    locala.funcId = 2778;
    c(locala.aDS());
    AppMethodBeat.o(44681);
  }
  
  public static void a(int paramInt1, final ze paramze, final long paramLong, final a parama, int paramInt2)
  {
    AppMethodBeat.i(44682);
    final long l = System.currentTimeMillis() / 1000L;
    f.bCj().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44680);
        new h(this.jUB, paramze, paramLong, l) {}.aET();
        AppMethodBeat.o(44680);
      }
    });
    AppMethodBeat.o(44682);
  }
  
  public static abstract interface a
  {
    public abstract void a(bid parambid);
    
    public abstract void bdv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.h
 * JD-Core Version:    0.7.0.1
 */