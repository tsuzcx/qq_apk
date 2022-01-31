package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bqc;
import com.tencent.mm.protocal.protobuf.bqd;

public final class t
  extends m
  implements k
{
  private f callback;
  public int fPH;
  public int fPI;
  private b rr;
  
  public t(int paramInt)
  {
    AppMethodBeat.i(123457);
    this.fPH = 1;
    b.a locala = new b.a();
    locala.fsX = new bqc();
    locala.fsY = new bqd();
    locala.uri = "/cgi-bin/micromsg-bin/queryhaspasswd";
    locala.funcId = 255;
    locala.reqCmdId = 132;
    locala.respCmdId = 1000000132;
    this.rr = locala.ado();
    ((bqc)this.rr.fsV.fta).Scene = paramInt;
    this.fPI = paramInt;
    AppMethodBeat.o(123457);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(123458);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(123458);
    return i;
  }
  
  public final int getType()
  {
    return 255;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(123459);
    updateDispatchId(paramInt1);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(123459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.t
 * JD-Core Version:    0.7.0.1
 */