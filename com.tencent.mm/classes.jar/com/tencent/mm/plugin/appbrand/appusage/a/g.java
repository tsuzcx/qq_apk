package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.plugin.appbrand.af.o.a;
import com.tencent.mm.plugin.appbrand.utils.l;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.crb;
import com.tencent.mm.protocal.protobuf.crc;
import com.tencent.mm.protocal.protobuf.wy;
import com.tencent.mm.sdk.platformtools.Log;

public class g
  extends b<crc>
{
  public g(int paramInt1, acz paramacz, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(44681);
    Log.i("MicroMsg.Recommend.CgiGetRecommendWxa", "pageNum:%d, filterType:%d, sessionId:%d, strategy:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(5), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    c.a locala = new c.a();
    crb localcrb = new crb();
    localcrb.aaxJ = paramInt1;
    localcrb.aaxK = 5;
    localcrb.aaxL = new wy();
    localcrb.aaxM = paramLong;
    localcrb.aaxN = paramacz;
    localcrb.aaxO = paramInt2;
    locala.otE = localcrb;
    locala.otF = new crc();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getrecommendwxa";
    locala.funcId = 2778;
    c(locala.bEF());
    AppMethodBeat.o(44681);
  }
  
  public static void a(int paramInt1, final acz paramacz, final long paramLong, final a parama, int paramInt2)
  {
    AppMethodBeat.i(44682);
    final long l = System.currentTimeMillis() / 1000L;
    l.cNm().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44680);
        new g(this.qRt, paramacz, paramLong, l) {}.bFJ();
        AppMethodBeat.o(44680);
      }
    });
    AppMethodBeat.o(44682);
  }
  
  public static abstract interface a
  {
    public abstract void a(crc paramcrc);
    
    public abstract void cjC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.g
 * JD-Core Version:    0.7.0.1
 */