package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bxo;
import com.tencent.mm.protocal.protobuf.bxp;
import com.tencent.mm.sdk.platformtools.ab;

public final class u
  extends m
  implements k
{
  private f callback;
  b rr;
  
  public u(String paramString)
  {
    AppMethodBeat.i(19341);
    this.callback = null;
    this.rr = null;
    b.a locala = new b.a();
    locala.fsX = new bxo();
    locala.fsY = new bxp();
    locala.uri = "/cgi-bin/micromsg-bin/searchharddevice";
    locala.funcId = 540;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ((bxo)this.rr.fsV.fta).xKq = paramString;
    AppMethodBeat.o(19341);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(19343);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(19343);
    return i;
  }
  
  public final int getType()
  {
    return 540;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19342);
    ab.i("MicroMsg.exdevice.NetSceneSearchHardDevice", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(19342);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.u
 * JD-Core Version:    0.7.0.1
 */