package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.plugin.appbrand.utils.e;
import com.tencent.mm.plugin.appbrand.z.l.a;
import com.tencent.mm.protocal.protobuf.bdg;
import com.tencent.mm.protocal.protobuf.bdh;
import com.tencent.mm.protocal.protobuf.se;
import com.tencent.mm.protocal.protobuf.xc;
import com.tencent.mm.sdk.platformtools.ac;

public class h
  extends c<bdh>
{
  public h(int paramInt1, xc paramxc, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(44681);
    ac.i("MicroMsg.Recommend.CgiGetRecommendWxa", "pageNum:%d, filterType:%d, sessionId:%d, strategy:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(5), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    b.a locala = new b.a();
    bdg localbdg = new bdg();
    localbdg.ETt = paramInt1;
    localbdg.ETu = 5;
    localbdg.ETv = new se();
    localbdg.bQR = paramLong;
    localbdg.ETw = paramxc;
    localbdg.ETx = paramInt2;
    locala.hvt = localbdg;
    locala.hvu = new bdh();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getrecommendwxa";
    locala.funcId = 2778;
    this.rr = locala.aAz();
    AppMethodBeat.o(44681);
  }
  
  public static void a(int paramInt1, final xc paramxc, final long paramLong, final a parama, int paramInt2)
  {
    AppMethodBeat.i(44682);
    final long l = System.currentTimeMillis() / 1000L;
    e.bxj().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44680);
        new h(this.jxn, paramxc, paramLong, l) {}.aBB();
        AppMethodBeat.o(44680);
      }
    });
    AppMethodBeat.o(44682);
  }
  
  public static abstract interface a
  {
    public abstract void a(bdh parambdh);
    
    public abstract void aZs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.h
 * JD-Core Version:    0.7.0.1
 */