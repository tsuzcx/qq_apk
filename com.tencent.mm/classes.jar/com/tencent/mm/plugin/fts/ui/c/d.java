package com.tencent.mm.plugin.fts.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cpm;
import com.tencent.mm.protocal.protobuf.cpn;
import com.tencent.mm.sdk.platformtools.ac;

public final class d
  extends n
  implements k
{
  private g callback;
  private b hEg;
  private cpn sFX;
  
  public d(cpm paramcpm)
  {
    AppMethodBeat.i(112160);
    b.a locala = new b.a();
    locala.hvt = paramcpm;
    this.sFX = new cpn();
    locala.hvu = this.sFX;
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/reportsearchwxa";
    locala.funcId = 2678;
    this.hEg = locala.aAz();
    ac.i("MicroMsg.FTS.NetSceneWeAppSearchReport", "Query %s SearchId %s Scene %d SearchId: %d SessionId: %d", new Object[] { paramcpm.hOf, Long.valueOf(paramcpm.FCv), Integer.valueOf(paramcpm.Scene), Long.valueOf(paramcpm.FCv), Long.valueOf(paramcpm.FCA) });
    AppMethodBeat.o(112160);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(112161);
    this.callback = paramg;
    int i = dispatch(parame, this.hEg, this);
    AppMethodBeat.o(112161);
    return i;
  }
  
  public final int getType()
  {
    return 2678;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112162);
    ac.i("MicroMsg.FTS.NetSceneWeAppSearchReport", "netId %d errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.c.d
 * JD-Core Version:    0.7.0.1
 */