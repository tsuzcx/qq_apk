package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.protocal.protobuf.aaz;
import com.tencent.mm.protocal.protobuf.cbu;
import com.tencent.mm.protocal.protobuf.cbv;
import com.tencent.mm.protocal.protobuf.vh;
import com.tencent.mm.sdk.platformtools.Log;

public class h
  extends c<cbv>
{
  public h(int paramInt1, aaz paramaaz, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(44681);
    Log.i("MicroMsg.Recommend.CgiGetRecommendWxa", "pageNum:%d, filterType:%d, sessionId:%d, strategy:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(5), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    d.a locala = new d.a();
    cbu localcbu = new cbu();
    localcbu.Tkg = paramInt1;
    localcbu.Tkh = 5;
    localcbu.Tki = new vh();
    localcbu.Tkj = paramLong;
    localcbu.Tkk = paramaaz;
    localcbu.Tkl = paramInt2;
    locala.lBU = localcbu;
    locala.lBV = new cbv();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getrecommendwxa";
    locala.funcId = 2778;
    c(locala.bgN());
    AppMethodBeat.o(44681);
  }
  
  public static void a(int paramInt1, final aaz paramaaz, final long paramLong, final a parama, int paramInt2)
  {
    AppMethodBeat.i(44682);
    final long l = System.currentTimeMillis() / 1000L;
    com.tencent.mm.plugin.appbrand.utils.h.clV().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44680);
        new h(this.nRJ, paramaaz, paramLong, l) {}.bhW();
        AppMethodBeat.o(44680);
      }
    });
    AppMethodBeat.o(44682);
  }
  
  public static abstract interface a
  {
    public abstract void a(cbv paramcbv);
    
    public abstract void bKb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.h
 * JD-Core Version:    0.7.0.1
 */