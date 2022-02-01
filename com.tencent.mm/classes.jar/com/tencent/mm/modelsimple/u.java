package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.drn;
import com.tencent.mm.protocal.protobuf.dro;

public final class u
  extends q
  implements m
{
  private i callback;
  public int mad;
  public int mae;
  private d rr;
  
  public u(int paramInt)
  {
    AppMethodBeat.i(134182);
    this.mad = 1;
    d.a locala = new d.a();
    locala.lBU = new drn();
    locala.lBV = new dro();
    locala.uri = "/cgi-bin/micromsg-bin/queryhaspasswd";
    locala.funcId = 255;
    locala.lBW = 132;
    locala.respCmdId = 1000000132;
    this.rr = locala.bgN();
    ((drn)d.b.b(this.rr.lBR)).CPw = paramInt;
    this.mae = paramInt;
    AppMethodBeat.o(134182);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(134183);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(134183);
    return i;
  }
  
  public final int getType()
  {
    return 255;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134184);
    updateDispatchId(paramInt1);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(134184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.u
 * JD-Core Version:    0.7.0.1
 */