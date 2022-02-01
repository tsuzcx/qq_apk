package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.bij;
import com.tencent.mm.protocal.protobuf.bik;

public final class q
  extends n
  implements k
{
  private f callback;
  public final b hZD;
  
  public q()
  {
    AppMethodBeat.i(20635);
    b.a locala = new b.a();
    locala.hQF = new bij();
    locala.hQG = new bik();
    locala.uri = "/cgi-bin/micromsg-bin/getremind";
    locala.funcId = 866;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.hZD = locala.aDS();
    AppMethodBeat.o(20635);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(20636);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
    AppMethodBeat.o(20636);
    return i;
  }
  
  public final int getType()
  {
    return 866;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20637);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.q
 * JD-Core Version:    0.7.0.1
 */