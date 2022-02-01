package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.protocal.protobuf.cpm;

public final class h
  extends n
  implements k
{
  private g callback;
  private final b rr;
  
  public h(cpl paramcpl)
  {
    AppMethodBeat.i(127835);
    this.callback = null;
    b.a locala = new b.a();
    locala.gUU = paramcpl;
    locala.gUV = new cpm();
    locala.uri = "/cgi-bin/micromsg-bin/sendphoto2fbwall";
    locala.funcId = 433;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    AppMethodBeat.o(127835);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(127836);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(127836);
    return i;
  }
  
  public final int getType()
  {
    return 433;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
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