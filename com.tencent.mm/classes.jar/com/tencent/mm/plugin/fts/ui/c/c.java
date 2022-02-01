package com.tencent.mm.plugin.fts.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cza;
import com.tencent.mm.protocal.protobuf.czb;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends n
  implements k
{
  private f callback;
  private b hWL;
  public czb tCQ;
  
  public c(cza paramcza)
  {
    AppMethodBeat.i(112157);
    b.a locala = new b.a();
    locala.hNM = paramcza;
    locala.hNN = new czb();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/searchwxa";
    locala.funcId = 2599;
    this.hWL = locala.aDC();
    ad.i("MicroMsg.FTS.NetSceneWeAppSearch", "Query %s Scene %d SearchId: %d SessionId: %d", new Object[] { paramcza.FKK, Long.valueOf(paramcza.HpK), Long.valueOf(paramcza.HmK), Long.valueOf(paramcza.HmP) });
    AppMethodBeat.o(112157);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(112158);
    this.callback = paramf;
    int i = dispatch(parame, this.hWL, this);
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
    ad.i("MicroMsg.FTS.NetSceneWeAppSearch", "netId %d errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.tCQ = ((czb)this.hWL.hNL.hNQ);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.c.c
 * JD-Core Version:    0.7.0.1
 */