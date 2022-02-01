package com.tencent.mm.plugin.fts.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ctq;
import com.tencent.mm.protocal.protobuf.ctr;
import com.tencent.mm.sdk.platformtools.ac;

public final class c
  extends n
  implements k
{
  private g callback;
  private b hEg;
  public ctr sFW;
  
  public c(ctq paramctq)
  {
    AppMethodBeat.i(112157);
    b.a locala = new b.a();
    locala.hvt = paramctq;
    locala.hvu = new ctr();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/searchwxa";
    locala.funcId = 2599;
    this.hEg = locala.aAz();
    ac.i("MicroMsg.FTS.NetSceneWeAppSearch", "Query %s Scene %d SearchId: %d SessionId: %d", new Object[] { paramctq.Eel, Long.valueOf(paramctq.FFl), Long.valueOf(paramctq.FCv), Long.valueOf(paramctq.FCA) });
    AppMethodBeat.o(112157);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(112158);
    this.callback = paramg;
    int i = dispatch(parame, this.hEg, this);
    AppMethodBeat.o(112158);
    return i;
  }
  
  public final int getType()
  {
    return 2599;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112159);
    ac.i("MicroMsg.FTS.NetSceneWeAppSearch", "netId %d errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.sFW = ((ctr)this.hEg.hvs.hvw);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.c.c
 * JD-Core Version:    0.7.0.1
 */