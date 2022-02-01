package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.acx;
import com.tencent.mm.protocal.protobuf.acy;

public final class h
  extends n
  implements k
{
  private f gCo;
  private final b rr;
  
  public h(int paramInt)
  {
    AppMethodBeat.i(150913);
    b.a locala = new b.a();
    locala.hQF = new acx();
    locala.hQG = new acy();
    locala.uri = "/cgi-bin/mmbiz-bin/oauth_delavatar";
    locala.funcId = 2700;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ((acx)this.rr.hQD.hQJ).GuE = paramInt;
    AppMethodBeat.o(150913);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(150915);
    this.gCo = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(150915);
    return i;
  }
  
  public final int getType()
  {
    return 2700;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150914);
    this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.h
 * JD-Core Version:    0.7.0.1
 */