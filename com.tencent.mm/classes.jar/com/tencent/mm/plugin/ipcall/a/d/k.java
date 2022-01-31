package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.sdk.platformtools.ab;

public final class k
  extends m
  implements com.tencent.mm.network.k
{
  private f callback;
  public boi nPf;
  public boj nPg;
  private b rr;
  
  public k(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(21866);
    this.rr = null;
    this.nPf = null;
    this.nPg = null;
    this.callback = null;
    b.a locala = new b.a();
    locala.fsX = new boi();
    locala.fsY = new boj();
    locala.funcId = 726;
    locala.uri = "/cgi-bin/micromsg-bin/pstnredirect";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    this.nPf = ((boi)this.rr.fsV.fta);
    this.nPf.wQP = paramInt;
    this.nPf.wQQ = paramLong1;
    this.nPf.xCm = paramLong2;
    AppMethodBeat.o(21866);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(21867);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(21867);
    return i;
  }
  
  public final int getType()
  {
    return 726;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21868);
    ab.i("MicroMsg.NetSceneIPCallRedirect", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.nPg = ((boj)((b)paramq).fsW.fta);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(21868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.d.k
 * JD-Core Version:    0.7.0.1
 */