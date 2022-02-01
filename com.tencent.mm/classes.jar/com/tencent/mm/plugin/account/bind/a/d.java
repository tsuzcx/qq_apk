package com.tencent.mm.plugin.account.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dfb;
import com.tencent.mm.protocal.protobuf.dfc;

public final class d
  extends n
  implements k
{
  private g callback;
  private b rr;
  
  public d(String paramString)
  {
    AppMethodBeat.i(109752);
    b.a locala = new b.a();
    locala.gUU = new dfb();
    locala.gUV = new dfc();
    locala.uri = "/cgi-bin/micromsg-bin/unbindqq";
    locala.funcId = 253;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    ((dfb)this.rr.gUS.gUX).Ddo = paramString;
    AppMethodBeat.o(109752);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(109753);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(109753);
    return i;
  }
  
  public final int getType()
  {
    return 253;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
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