package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.eao;
import com.tencent.mm.protocal.protobuf.eap;
import com.tencent.mm.sdk.platformtools.ad;

public final class j
  extends n
  implements k
{
  private f callback;
  private b rr;
  public eao uNt;
  public eap uNu;
  
  public j(String paramString)
  {
    AppMethodBeat.i(25478);
    this.rr = null;
    this.uNt = null;
    this.uNu = null;
    this.callback = null;
    b.a locala = new b.a();
    locala.hNM = new eao();
    locala.hNN = new eap();
    locala.funcId = 277;
    locala.uri = "/cgi-bin/micromsg-bin/wcopurchasepackage";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    this.uNt = ((eao)this.rr.hNK.hNQ);
    this.uNt.ProductID = paramString;
    ad.i("MicroMsg.NetSceneIPCallPurchasePackage", "NetSceneIPCallPurchasePackage ProductID:%s", new Object[] { this.uNt.ProductID });
    AppMethodBeat.o(25478);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(25479);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(25479);
    return i;
  }
  
  public final int getType()
  {
    return 277;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25480);
    ad.i("MicroMsg.NetSceneIPCallPurchasePackage", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.uNu = ((eap)((b)paramq).hNL.hNQ);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.j
 * JD-Core Version:    0.7.0.1
 */