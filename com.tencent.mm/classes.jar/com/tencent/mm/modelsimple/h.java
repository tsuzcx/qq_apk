package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.afa;
import com.tencent.mm.protocal.protobuf.afb;

public final class h
  extends q
  implements m
{
  private i heq;
  private final d rr;
  
  public h(int paramInt)
  {
    AppMethodBeat.i(150913);
    d.a locala = new d.a();
    locala.iLN = new afa();
    locala.iLO = new afb();
    locala.uri = "/cgi-bin/mmbiz-bin/oauth_delavatar";
    locala.funcId = 2700;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((afa)this.rr.iLK.iLR).Lqj = paramInt;
    AppMethodBeat.o(150913);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(150915);
    this.heq = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(150915);
    return i;
  }
  
  public final int getType()
  {
    return 2700;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150914);
    this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.h
 * JD-Core Version:    0.7.0.1
 */