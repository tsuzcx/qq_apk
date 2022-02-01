package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.acp;

public final class g
  extends n
  implements k
{
  private f gzH;
  private final b rr;
  
  public g(int paramInt)
  {
    AppMethodBeat.i(150913);
    b.a locala = new b.a();
    locala.hNM = new aco();
    locala.hNN = new acp();
    locala.uri = "/cgi-bin/mmbiz-bin/oauth_delavatar";
    locala.funcId = 2700;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    ((aco)this.rr.hNK.hNQ).GbX = paramInt;
    AppMethodBeat.o(150913);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(150915);
    this.gzH = paramf;
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
    this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.g
 * JD-Core Version:    0.7.0.1
 */