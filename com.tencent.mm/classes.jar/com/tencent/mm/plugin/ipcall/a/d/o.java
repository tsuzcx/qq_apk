package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.bop;
import com.tencent.mm.sdk.platformtools.ab;

public final class o
  extends m
  implements k
{
  private f callback;
  public boo nPn;
  public bop nPo;
  private b rr;
  
  public o(int paramInt1, long paramLong1, int paramInt2, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(21878);
    this.rr = null;
    this.nPn = null;
    this.nPo = null;
    b.a locala = new b.a();
    locala.fsX = new boo();
    locala.fsY = new bop();
    locala.funcId = 819;
    locala.uri = "/cgi-bin/micromsg-bin/pstnsync";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    long l = System.currentTimeMillis();
    this.nPn = ((boo)this.rr.fsV.fta);
    this.nPn.xCG = r.Zn();
    this.nPn.wQP = paramInt1;
    this.nPn.wQQ = paramLong1;
    this.nPn.xCj = l;
    this.nPn.xCH = paramInt2;
    this.nPn.xCm = paramLong2;
    if (!paramBoolean) {}
    for (this.nPn.xCI = 0;; this.nPn.xCI = 1)
    {
      ab.i("MicroMsg.NetSceneIPCallSync", "roomId: %d, roomKey: %d, syncKey: %d, callSeq: %d,dataFlag: %d, timestamp: %d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Long.valueOf(paramLong2), Integer.valueOf(this.nPn.xCI), Long.valueOf(l) });
      AppMethodBeat.o(21878);
      return;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(21879);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(21879);
    return i;
  }
  
  public final int getType()
  {
    return 819;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21880);
    ab.i("MicroMsg.NetSceneIPCallSync", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.nPo = ((bop)((b)paramq).fsW.fta);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(21880);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.d.o
 * JD-Core Version:    0.7.0.1
 */