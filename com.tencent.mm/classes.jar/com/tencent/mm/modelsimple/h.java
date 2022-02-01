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
import com.tencent.mm.protocal.protobuf.afj;
import com.tencent.mm.protocal.protobuf.afk;

public final class h
  extends q
  implements m
{
  private i jQg;
  private final d rr;
  
  public h(int paramInt)
  {
    AppMethodBeat.i(150913);
    d.a locala = new d.a();
    locala.lBU = new afj();
    locala.lBV = new afk();
    locala.uri = "/cgi-bin/mmbiz-bin/oauth_delavatar";
    locala.funcId = 2700;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    ((afj)d.b.b(this.rr.lBR)).SrG = paramInt;
    AppMethodBeat.o(150913);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(150915);
    this.jQg = parami;
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
    this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.h
 * JD-Core Version:    0.7.0.1
 */