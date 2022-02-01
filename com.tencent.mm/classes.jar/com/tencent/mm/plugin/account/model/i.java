package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dua;
import com.tencent.mm.protocal.protobuf.dub;

public final class i
  extends q
  implements m
{
  private com.tencent.mm.ak.i callback;
  private final d rr;
  
  public i(dua paramdua)
  {
    AppMethodBeat.i(127835);
    this.callback = null;
    d.a locala = new d.a();
    locala.iLN = paramdua;
    locala.iLO = new dub();
    locala.uri = "/cgi-bin/micromsg-bin/sendphoto2fbwall";
    locala.funcId = 433;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    AppMethodBeat.o(127835);
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(127836);
    this.callback = parami;
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
 * Qualified Name:     com.tencent.mm.plugin.account.model.i
 * JD-Core Version:    0.7.0.1
 */