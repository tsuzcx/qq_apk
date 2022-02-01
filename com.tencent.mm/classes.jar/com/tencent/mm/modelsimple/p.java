package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bht;
import com.tencent.mm.protocal.protobuf.bhu;

public final class p
  extends n
  implements k
{
  private f callback;
  public final b hWL;
  
  public p()
  {
    AppMethodBeat.i(20635);
    b.a locala = new b.a();
    locala.hNM = new bht();
    locala.hNN = new bhu();
    locala.uri = "/cgi-bin/micromsg-bin/getremind";
    locala.funcId = 866;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.hWL = locala.aDC();
    AppMethodBeat.o(20635);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(20636);
    this.callback = paramf;
    int i = dispatch(parame, this.hWL, this);
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