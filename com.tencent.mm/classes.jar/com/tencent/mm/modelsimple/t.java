package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cex;
import com.tencent.mm.protocal.protobuf.cey;

public final class t
  extends n
  implements k
{
  private g callback;
  public int hsm;
  public int hsn;
  private b rr;
  
  public t(int paramInt)
  {
    AppMethodBeat.i(134182);
    this.hsm = 1;
    b.a locala = new b.a();
    locala.gUU = new cex();
    locala.gUV = new cey();
    locala.uri = "/cgi-bin/micromsg-bin/queryhaspasswd";
    locala.funcId = 255;
    locala.reqCmdId = 132;
    locala.respCmdId = 1000000132;
    this.rr = locala.atI();
    ((cex)this.rr.gUS.gUX).Scene = paramInt;
    this.hsn = paramInt;
    AppMethodBeat.o(134182);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(134183);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(134183);
    return i;
  }
  
  public final int getType()
  {
    return 255;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134184);
    updateDispatchId(paramInt1);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(134184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.t
 * JD-Core Version:    0.7.0.1
 */