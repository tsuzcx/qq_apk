package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ahw;
import com.tencent.mm.protocal.protobuf.ahx;

public final class j
  extends p
  implements m
{
  private h mAY;
  private final c rr;
  
  public j(int paramInt)
  {
    AppMethodBeat.i(150913);
    c.a locala = new c.a();
    locala.otE = new ahw();
    locala.otF = new ahx();
    locala.uri = "/cgi-bin/mmbiz-bin/oauth_delavatar";
    locala.funcId = 2700;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    ((ahw)c.b.b(this.rr.otB)).ZqK = paramInt;
    AppMethodBeat.o(150913);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(150915);
    this.mAY = paramh;
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
    this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsimple.j
 * JD-Core Version:    0.7.0.1
 */