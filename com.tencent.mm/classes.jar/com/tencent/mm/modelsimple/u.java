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
import com.tencent.mm.protocal.protobuf.cpu;
import com.tencent.mm.protocal.protobuf.cpv;

public final class u
  extends n
  implements k
{
  private f callback;
  public int ioZ;
  public int ipa;
  private b rr;
  
  public u(int paramInt)
  {
    AppMethodBeat.i(134182);
    this.ioZ = 1;
    b.a locala = new b.a();
    locala.hQF = new cpu();
    locala.hQG = new cpv();
    locala.uri = "/cgi-bin/micromsg-bin/queryhaspasswd";
    locala.funcId = 255;
    locala.hQH = 132;
    locala.respCmdId = 1000000132;
    this.rr = locala.aDS();
    ((cpu)this.rr.hQD.hQJ).Scene = paramInt;
    this.ipa = paramInt;
    AppMethodBeat.o(134182);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(134183);
    this.callback = paramf;
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
 * Qualified Name:     com.tencent.mm.modelsimple.u
 * JD-Core Version:    0.7.0.1
 */