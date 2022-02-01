package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.azv;
import com.tencent.mm.protocal.protobuf.azw;

public final class p
  extends n
  implements k
{
  private g callback;
  public final b hdD;
  
  public p()
  {
    AppMethodBeat.i(20635);
    b.a locala = new b.a();
    locala.gUU = new azv();
    locala.gUV = new azw();
    locala.uri = "/cgi-bin/micromsg-bin/getremind";
    locala.funcId = 866;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.hdD = locala.atI();
    AppMethodBeat.o(20635);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(20636);
    this.callback = paramg;
    int i = dispatch(parame, this.hdD, this);
    AppMethodBeat.o(20636);
    return i;
  }
  
  public final int getType()
  {
    return 866;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20637);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.p
 * JD-Core Version:    0.7.0.1
 */