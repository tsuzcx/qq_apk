package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bgn;
import com.tencent.mm.protocal.protobuf.bgo;
import com.tencent.mm.sdk.platformtools.ac;

public final class e
  extends n
  implements k
{
  private g callback;
  private b rr;
  private bgn tKv;
  public bgo tKw;
  
  public e()
  {
    AppMethodBeat.i(25463);
    this.rr = null;
    this.tKv = null;
    this.tKw = null;
    this.callback = null;
    b.a locala = new b.a();
    locala.hvt = new bgn();
    locala.hvu = new bgo();
    locala.funcId = 831;
    locala.uri = "/cgi-bin/micromsg-bin/getwcopackageproductlist";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    this.tKv = ((bgn)this.rr.hvr.hvw);
    ac.i("MicroMsg.NetSceneIPCallGetPackageProductList", "NetSceneIPCallGetPackageProductList");
    AppMethodBeat.o(25463);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(25464);
    this.callback = paramg;
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
    ac.i("MicroMsg.NetSceneIPCallGetPackageProductList", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.tKw = ((bgo)((b)paramq).hvs.hvw);
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