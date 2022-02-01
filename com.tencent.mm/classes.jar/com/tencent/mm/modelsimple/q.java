package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.buk;
import com.tencent.mm.protocal.protobuf.bul;

public final class q
  extends com.tencent.mm.ak.q
  implements m
{
  private i callback;
  public final d iUB;
  
  public q()
  {
    AppMethodBeat.i(20635);
    d.a locala = new d.a();
    locala.iLN = new buk();
    locala.iLO = new bul();
    locala.uri = "/cgi-bin/micromsg-bin/getremind";
    locala.funcId = 866;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.iUB = locala.aXF();
    AppMethodBeat.o(20635);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(20636);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(20636);
    return i;
  }
  
  public final int getType()
  {
    return 866;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20637);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.q
 * JD-Core Version:    0.7.0.1
 */