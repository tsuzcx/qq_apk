package com.tencent.mm.plugin.fts.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.protocal.protobuf.bur;

public final class d
  extends m
  implements k
{
  private f callback;
  private b fBd;
  private bur naF;
  
  public d(buq parambuq)
  {
    AppMethodBeat.i(152176);
    b.a locala = new b.a();
    locala.fsX = parambuq;
    this.naF = new bur();
    locala.fsY = this.naF;
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/reportsearchwxa";
    locala.funcId = 2678;
    this.fBd = locala.ado();
    com.tencent.luggage.g.d.i("MicroMsg.FTS.NetSceneWeAppSearchReport", "Query %s SearchId %s Scene %d SearchId: %d SessionId: %d", new Object[] { parambuq.fKw, Long.valueOf(parambuq.xIh), Integer.valueOf(parambuq.Scene), Long.valueOf(parambuq.xIh), Long.valueOf(parambuq.xIm) });
    AppMethodBeat.o(152176);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(152177);
    this.callback = paramf;
    int i = dispatch(parame, this.fBd, this);
    AppMethodBeat.o(152177);
    return i;
  }
  
  public final int getType()
  {
    return 2678;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(152178);
    com.tencent.luggage.g.d.i("MicroMsg.FTS.NetSceneWeAppSearchReport", "netId %d errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(152178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.c.d
 * JD-Core Version:    0.7.0.1
 */