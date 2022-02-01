package com.tencent.mm.plugin.account.friend.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.eyh;
import com.tencent.mm.protocal.protobuf.eyi;

public final class aj
  extends p
  implements m
{
  private h callback;
  private final c rr;
  
  public aj(String paramString)
  {
    AppMethodBeat.i(131142);
    c.a locala = new c.a();
    locala.otE = new eyh();
    locala.otF = new eyi();
    locala.uri = "/cgi-bin/micromsg-bin/sendverifyemail";
    locala.funcId = 108;
    locala.otG = 43;
    locala.respCmdId = 1000000043;
    this.rr = locala.bEF();
    ((eyh)c.b.b(this.rr.otB)).ZqL = new etl().btH(paramString);
    AppMethodBeat.o(131142);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(131143);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(131143);
    return i;
  }
  
  public final int getType()
  {
    return 108;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131144);
    updateDispatchId(paramInt1);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.aj
 * JD-Core Version:    0.7.0.1
 */