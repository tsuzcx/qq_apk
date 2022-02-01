package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bln;
import com.tencent.mm.protocal.protobuf.blo;
import com.tencent.mm.sdk.platformtools.ae;

public final class e
  extends n
  implements k
{
  private f callback;
  private b rr;
  private bln uYV;
  public blo uYW;
  
  public e()
  {
    AppMethodBeat.i(25463);
    this.rr = null;
    this.uYV = null;
    this.uYW = null;
    this.callback = null;
    b.a locala = new b.a();
    locala.hQF = new bln();
    locala.hQG = new blo();
    locala.funcId = 831;
    locala.uri = "/cgi-bin/micromsg-bin/getwcopackageproductlist";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    this.uYV = ((bln)this.rr.hQD.hQJ);
    ae.i("MicroMsg.NetSceneIPCallGetPackageProductList", "NetSceneIPCallGetPackageProductList");
    AppMethodBeat.o(25463);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(25464);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(25464);
    return i;
  }
  
  public final int getType()
  {
    return 831;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25465);
    ae.i("MicroMsg.NetSceneIPCallGetPackageProductList", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.uYW = ((blo)((b)paramq).hQE.hQJ);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.e
 * JD-Core Version:    0.7.0.1
 */