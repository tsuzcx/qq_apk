package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.protocal.protobuf.brh;
import com.tencent.mm.sdk.platformtools.ac;

public final class r
  extends n
  implements k
{
  private g callback;
  public final b rr;
  
  public r()
  {
    AppMethodBeat.i(150937);
    b.a locala = new b.a();
    locala.hvt = new brg();
    locala.hvu = new brh();
    locala.uri = "/cgi-bin/micromsg-bin/logout";
    locala.funcId = 282;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ((brg)this.rr.hvr.hvw).Scene = 0;
    AppMethodBeat.o(150937);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(150938);
    ac.d("MicroMsg.NetSceneLogout", "doScene");
    this.callback = paramg;
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
      ac.d("MicroMsg.NetSceneLogout", "logout Error. ");
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(150939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.r
 * JD-Core Version:    0.7.0.1
 */