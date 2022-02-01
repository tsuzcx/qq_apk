package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ext;
import com.tencent.mm.protocal.protobuf.exu;

public final class h
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private final c rr;
  
  public h(ext paramext)
  {
    AppMethodBeat.i(127835);
    this.callback = null;
    c.a locala = new c.a();
    locala.otE = paramext;
    locala.otF = new exu();
    locala.uri = "/cgi-bin/micromsg-bin/sendphoto2fbwall";
    locala.funcId = 433;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    AppMethodBeat.o(127835);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(127836);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(127836);
    return i;
  }
  
  public final int getType()
  {
    return 433;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(127837);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(127837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.h
 * JD-Core Version:    0.7.0.1
 */