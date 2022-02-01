package com.tencent.mm.plugin.fts.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ckf;
import com.tencent.mm.protocal.protobuf.ckg;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
  extends n
  implements k
{
  private g callback;
  private b hdD;
  private ckg rxf;
  
  public d(ckf paramckf)
  {
    AppMethodBeat.i(112160);
    b.a locala = new b.a();
    locala.gUU = paramckf;
    this.rxf = new ckg();
    locala.gUV = this.rxf;
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/reportsearchwxa";
    locala.funcId = 2678;
    this.hdD = locala.atI();
    ad.i("MicroMsg.FTS.NetSceneWeAppSearchReport", "Query %s SearchId %s Scene %d SearchId: %d SessionId: %d", new Object[] { paramckf.hnC, Long.valueOf(paramckf.Efv), Integer.valueOf(paramckf.Scene), Long.valueOf(paramckf.Efv), Long.valueOf(paramckf.EfA) });
    AppMethodBeat.o(112160);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(112161);
    this.callback = paramg;
    int i = dispatch(parame, this.hdD, this);
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
    ad.i("MicroMsg.FTS.NetSceneWeAppSearchReport", "netId %d errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.c.d
 * JD-Core Version:    0.7.0.1
 */