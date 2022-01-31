package com.tencent.mm.plugin.account.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cmb;
import com.tencent.mm.protocal.protobuf.cmc;

public final class d
  extends m
  implements k
{
  private f callback;
  private b rr;
  
  public d(String paramString)
  {
    AppMethodBeat.i(13327);
    b.a locala = new b.a();
    locala.fsX = new cmb();
    locala.fsY = new cmc();
    locala.uri = "/cgi-bin/micromsg-bin/unbindqq";
    locala.funcId = 253;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ((cmb)this.rr.fsV.fta).wQf = paramString;
    AppMethodBeat.o(13327);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(13328);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(13328);
    return i;
  }
  
  public final int getType()
  {
    return 253;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(13329);
    updateDispatchId(paramInt1);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(13329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.a.d
 * JD-Core Version:    0.7.0.1
 */