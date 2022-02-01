package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aao;
import com.tencent.mm.protocal.protobuf.aap;

public final class g
  extends n
  implements k
{
  private com.tencent.mm.ak.g gfX;
  private final b rr;
  
  public g(int paramInt)
  {
    AppMethodBeat.i(150913);
    b.a locala = new b.a();
    locala.hvt = new aao();
    locala.hvu = new aap();
    locala.uri = "/cgi-bin/mmbiz-bin/oauth_delavatar";
    locala.funcId = 2700;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ((aao)this.rr.hvr.hvw).EuD = paramInt;
    AppMethodBeat.o(150913);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(150915);
    this.gfX = paramg;
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
    this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.g
 * JD-Core Version:    0.7.0.1
 */