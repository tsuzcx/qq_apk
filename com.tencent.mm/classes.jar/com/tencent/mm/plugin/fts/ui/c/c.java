package com.tencent.mm.plugin.fts.ui.c;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.byh;
import com.tencent.mm.protocal.protobuf.byi;

public final class c
  extends m
  implements k
{
  private f callback;
  private b fBd;
  public byi naE;
  
  public c(byh parambyh)
  {
    AppMethodBeat.i(152173);
    b.a locala = new b.a();
    locala.fsX = parambyh;
    locala.fsY = new byi();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/searchwxa";
    locala.funcId = 2599;
    this.fBd = locala.ado();
    d.i("MicroMsg.FTS.NetSceneWeAppSearch", "Query %s Scene %d SearchId: %d SessionId: %d", new Object[] { parambyh.xHR, Long.valueOf(parambyh.xKD), Long.valueOf(parambyh.xIh), Long.valueOf(parambyh.xIm) });
    AppMethodBeat.o(152173);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(152174);
    this.callback = paramf;
    int i = dispatch(parame, this.fBd, this);
    AppMethodBeat.o(152174);
    return i;
  }
  
  public final int getType()
  {
    return 2599;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(152175);
    d.i("MicroMsg.FTS.NetSceneWeAppSearch", "netId %d errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.naE = ((byi)this.fBd.fsW.fta);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(152175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.c.c
 * JD-Core Version:    0.7.0.1
 */