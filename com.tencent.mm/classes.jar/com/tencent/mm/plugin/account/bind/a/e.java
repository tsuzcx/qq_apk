package com.tencent.mm.plugin.account.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fqt;
import com.tencent.mm.protocal.protobuf.fqu;

public final class e
  extends p
  implements m
{
  private h callback;
  private c rr;
  
  public e(String paramString)
  {
    AppMethodBeat.i(109752);
    c.a locala = new c.a();
    locala.otE = new fqt();
    locala.otF = new fqu();
    locala.uri = "/cgi-bin/micromsg-bin/unbindqq";
    locala.funcId = 253;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    ((fqt)c.b.b(this.rr.otB)).Njp = paramString;
    AppMethodBeat.o(109752);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(109753);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(109753);
    return i;
  }
  
  public final int getType()
  {
    return 253;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109754);
    updateDispatchId(paramInt1);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(109754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.a.e
 * JD-Core Version:    0.7.0.1
 */