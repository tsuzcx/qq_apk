package com.tencent.mm.plugin.fts.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cvl;
import com.tencent.mm.protocal.protobuf.cvm;
import com.tencent.mm.sdk.platformtools.ae;

public final class d
  extends n
  implements k
{
  private f callback;
  private b hZD;
  private cvm tNI;
  
  public d(cvl paramcvl)
  {
    AppMethodBeat.i(112160);
    b.a locala = new b.a();
    locala.hQF = paramcvl;
    this.tNI = new cvm();
    locala.hQG = this.tNI;
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/reportsearchwxa";
    locala.funcId = 2678;
    this.hZD = locala.aDS();
    ae.i("MicroMsg.FTS.NetSceneWeAppSearchReport", "Query %s SearchId %s Scene %d SearchId: %d SessionId: %d", new Object[] { paramcvl.ikm, Long.valueOf(paramcvl.HGk), Integer.valueOf(paramcvl.Scene), Long.valueOf(paramcvl.HGk), Long.valueOf(paramcvl.HGp) });
    AppMethodBeat.o(112160);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(112161);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
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
    ae.i("MicroMsg.FTS.NetSceneWeAppSearchReport", "netId %d errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.c.d
 * JD-Core Version:    0.7.0.1
 */