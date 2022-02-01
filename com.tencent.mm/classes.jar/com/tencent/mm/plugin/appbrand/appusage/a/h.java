package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.protocal.protobuf.buc;
import com.tencent.mm.protocal.protobuf.bud;
import com.tencent.mm.protocal.protobuf.vf;
import com.tencent.mm.sdk.platformtools.Log;

public class h
  extends c<bud>
{
  public h(int paramInt1, aat paramaat, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(44681);
    Log.i("MicroMsg.Recommend.CgiGetRecommendWxa", "pageNum:%d, filterType:%d, sessionId:%d, strategy:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(5), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    d.a locala = new d.a();
    buc localbuc = new buc();
    localbuc.MaL = paramInt1;
    localbuc.MaM = 5;
    localbuc.MaN = new vf();
    localbuc.clK = paramLong;
    localbuc.MaO = paramaat;
    localbuc.MaP = paramInt2;
    locala.iLN = localbuc;
    locala.iLO = new bud();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getrecommendwxa";
    locala.funcId = 2778;
    c(locala.aXF());
    AppMethodBeat.o(44681);
  }
  
  public static void a(int paramInt1, final aat paramaat, final long paramLong, final a parama, int paramInt2)
  {
    AppMethodBeat.i(44682);
    final long l = System.currentTimeMillis() / 1000L;
    f.bZn().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44680);
        new h(this.kXx, paramaat, paramLong, l) {}.aYI();
        AppMethodBeat.o(44680);
      }
    });
    AppMethodBeat.o(44682);
  }
  
  public static abstract interface a
  {
    public abstract void a(bud parambud);
    
    public abstract void byN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.h
 * JD-Core Version:    0.7.0.1
 */