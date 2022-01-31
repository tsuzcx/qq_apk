package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.plugin.appbrand.t.e;
import com.tencent.mm.protocal.protobuf.apb;
import com.tencent.mm.protocal.protobuf.apc;
import com.tencent.mm.protocal.protobuf.pm;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public class h
  extends a<apc>
{
  public h(int paramInt1, ts paramts, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(129750);
    ab.i("MicroMsg.Recommend.CgiGetRecommendWxa", "pageNum:%d, filterType:%d, sessionId:%d, strategy:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(5), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    b.a locala = new b.a();
    apb localapb = new apb();
    localapb.xfb = paramInt1;
    localapb.bxy = 5;
    localapb.xfc = new pm();
    localapb.bqN = paramLong;
    localapb.xfd = paramts;
    localapb.xfe = paramInt2;
    locala.fsX = localapb;
    locala.fsY = new apc();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getrecommendwxa";
    locala.funcId = 2778;
    this.rr = locala.ado();
    AppMethodBeat.o(129750);
  }
  
  public static void a(int paramInt1, ts paramts, long paramLong, a parama, int paramInt2)
  {
    AppMethodBeat.i(129751);
    long l = System.currentTimeMillis() / 1000L;
    e.aNS().ac(new h.1(paramInt1, paramts, paramLong, paramInt2, l, parama));
    AppMethodBeat.o(129751);
  }
  
  public static abstract interface a
  {
    public abstract void a(apc paramapc);
    
    public abstract void axS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.h
 * JD-Core Version:    0.7.0.1
 */