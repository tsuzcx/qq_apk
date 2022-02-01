package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.plugin.appbrand.utils.e;
import com.tencent.mm.plugin.appbrand.z.m.a;
import com.tencent.mm.protocal.protobuf.bhm;
import com.tencent.mm.protocal.protobuf.bhn;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.protocal.protobuf.zb;
import com.tencent.mm.sdk.platformtools.ad;

public class h
  extends a<bhn>
{
  public h(int paramInt1, zb paramzb, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(44681);
    ad.i("MicroMsg.Recommend.CgiGetRecommendWxa", "pageNum:%d, filterType:%d, sessionId:%d, strategy:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(5), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    b.a locala = new b.a();
    bhm localbhm = new bhm();
    localbhm.GCN = paramInt1;
    localbhm.GCO = 5;
    localbhm.GCP = new ty();
    localbhm.cbe = paramLong;
    localbhm.GCQ = paramzb;
    localbhm.GCR = paramInt2;
    locala.hNM = localbhm;
    locala.hNN = new bhn();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getrecommendwxa";
    locala.funcId = 2778;
    c(locala.aDC());
    AppMethodBeat.o(44681);
  }
  
  public static void a(int paramInt1, final zb paramzb, final long paramLong, final a parama, int paramInt2)
  {
    AppMethodBeat.i(44682);
    final long l = System.currentTimeMillis() / 1000L;
    e.bBp().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44680);
        new h(this.jRj, paramzb, paramLong, l) {}.aED();
        AppMethodBeat.o(44680);
      }
    });
    AppMethodBeat.o(44682);
  }
  
  public static abstract interface a
  {
    public abstract void a(bhn parambhn);
    
    public abstract void bcQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.h
 * JD-Core Version:    0.7.0.1
 */