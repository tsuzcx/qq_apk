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
import com.tencent.mm.protocal.protobuf.bwn;
import com.tencent.mm.protocal.protobuf.bwo;
import com.tencent.mm.sdk.platformtools.ae;

public final class s
  extends n
  implements k
{
  private f callback;
  public final b rr;
  
  public s()
  {
    AppMethodBeat.i(150937);
    b.a locala = new b.a();
    locala.hQF = new bwn();
    locala.hQG = new bwo();
    locala.uri = "/cgi-bin/micromsg-bin/logout";
    locala.funcId = 282;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ((bwn)this.rr.hQD.hQJ).Scene = 0;
    AppMethodBeat.o(150937);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(150938);
    ae.d("MicroMsg.NetSceneLogout", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(150938);
    return i;
  }
  
  public final int getType()
  {
    return 282;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150939);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ae.d("MicroMsg.NetSceneLogout", "logout Error. ");
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(150939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.s
 * JD-Core Version:    0.7.0.1
 */