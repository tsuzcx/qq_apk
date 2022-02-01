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
import com.tencent.mm.protocal.protobuf.eki;
import com.tencent.mm.protocal.protobuf.ekj;

public final class v
  extends p
  implements m
{
  private h callback;
  public int oST;
  public int oSU;
  private c rr;
  
  public v(int paramInt)
  {
    AppMethodBeat.i(134182);
    this.oST = 1;
    c.a locala = new c.a();
    locala.otE = new eki();
    locala.otF = new ekj();
    locala.uri = "/cgi-bin/micromsg-bin/queryhaspasswd";
    locala.funcId = 255;
    locala.otG = 132;
    locala.respCmdId = 1000000132;
    this.rr = locala.bEF();
    ((eki)c.b.b(this.rr.otB)).IJG = paramInt;
    this.oSU = paramInt;
    AppMethodBeat.o(134182);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(134183);
    this.callback = paramh;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsimple.v
 * JD-Core Version:    0.7.0.1
 */