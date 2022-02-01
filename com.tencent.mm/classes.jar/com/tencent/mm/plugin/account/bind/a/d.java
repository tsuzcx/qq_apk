package com.tencent.mm.plugin.account.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ela;
import com.tencent.mm.protocal.protobuf.elb;

public final class d
  extends q
  implements m
{
  private i callback;
  private com.tencent.mm.ak.d rr;
  
  public d(String paramString)
  {
    AppMethodBeat.i(109752);
    d.a locala = new d.a();
    locala.iLN = new ela();
    locala.iLO = new elb();
    locala.uri = "/cgi-bin/micromsg-bin/unbindqq";
    locala.funcId = 253;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((ela)this.rr.iLK.iLR).Bri = paramString;
    AppMethodBeat.o(109752);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(109753);
    this.callback = parami;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.a.d
 * JD-Core Version:    0.7.0.1
 */