package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.protocal.protobuf.eer;

public final class am
  extends q
  implements m
{
  private i callback;
  private final d rr;
  
  public am(String paramString)
  {
    AppMethodBeat.i(131142);
    d.a locala = new d.a();
    locala.lBU = new eeq();
    locala.lBV = new eer();
    locala.uri = "/cgi-bin/micromsg-bin/sendverifyemail";
    locala.funcId = 108;
    locala.lBW = 43;
    locala.respCmdId = 1000000043;
    this.rr = locala.bgN();
    ((eeq)d.b.b(this.rr.lBR)).SrH = new eaf().btQ(paramString);
    AppMethodBeat.o(131142);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(131143);
    this.callback = parami;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.am
 * JD-Core Version:    0.7.0.1
 */