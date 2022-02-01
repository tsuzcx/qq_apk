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
import com.tencent.mm.protocal.protobuf.bvt;
import com.tencent.mm.protocal.protobuf.bvu;
import com.tencent.mm.sdk.platformtools.ad;

public final class r
  extends n
  implements k
{
  private f callback;
  public final b rr;
  
  public r()
  {
    AppMethodBeat.i(150937);
    b.a locala = new b.a();
    locala.hNM = new bvt();
    locala.hNN = new bvu();
    locala.uri = "/cgi-bin/micromsg-bin/logout";
    locala.funcId = 282;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    ((bvt)this.rr.hNK.hNQ).Scene = 0;
    AppMethodBeat.o(150937);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(150938);
    ad.d("MicroMsg.NetSceneLogout", "doScene");
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
      ad.d("MicroMsg.NetSceneLogout", "logout Error. ");
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(150939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.r
 * JD-Core Version:    0.7.0.1
 */