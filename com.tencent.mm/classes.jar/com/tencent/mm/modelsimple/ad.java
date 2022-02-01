package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bms;
import com.tencent.mm.protocal.protobuf.bmt;

public final class ad
  extends n
  implements k
{
  private g callback;
  private final b rr;
  
  public ad(int paramInt)
  {
    AppMethodBeat.i(150963);
    b.a locala = new b.a();
    locala.gUU = new bms();
    locala.gUV = new bmt();
    locala.uri = "/cgi-bin/micromsg-bin/logoutwebwx";
    locala.funcId = 281;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    ((bms)this.rr.gUS.gUX).OpCode = paramInt;
    AppMethodBeat.o(150963);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(150964);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneWebWXLogout", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(150964);
    return i;
  }
  
  public final int getType()
  {
    return 281;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150965);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneWebWXLogout", "logout Error. ");
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(150965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ad
 * JD-Core Version:    0.7.0.1
 */