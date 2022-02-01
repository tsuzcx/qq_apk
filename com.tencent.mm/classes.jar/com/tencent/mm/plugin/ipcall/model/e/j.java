package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ecf;
import com.tencent.mm.protocal.protobuf.ecg;
import com.tencent.mm.sdk.platformtools.ae;

public final class j
  extends n
  implements k
{
  private f callback;
  private b rr;
  public ecf uZg;
  public ecg uZh;
  
  public j(String paramString)
  {
    AppMethodBeat.i(25478);
    this.rr = null;
    this.uZg = null;
    this.uZh = null;
    this.callback = null;
    b.a locala = new b.a();
    locala.hQF = new ecf();
    locala.hQG = new ecg();
    locala.funcId = 277;
    locala.uri = "/cgi-bin/micromsg-bin/wcopurchasepackage";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    this.uZg = ((ecf)this.rr.hQD.hQJ);
    this.uZg.ProductID = paramString;
    ae.i("MicroMsg.NetSceneIPCallPurchasePackage", "NetSceneIPCallPurchasePackage ProductID:%s", new Object[] { this.uZg.ProductID });
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
    ae.i("MicroMsg.NetSceneIPCallPurchasePackage", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.uZh = ((ecg)((b)paramq).hQE.hQJ);
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