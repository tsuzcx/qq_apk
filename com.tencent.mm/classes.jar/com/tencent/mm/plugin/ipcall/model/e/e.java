package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bkv;
import com.tencent.mm.protocal.protobuf.bkw;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
  extends n
  implements k
{
  private f callback;
  private b rr;
  private bkv uNi;
  public bkw uNj;
  
  public e()
  {
    AppMethodBeat.i(25463);
    this.rr = null;
    this.uNi = null;
    this.uNj = null;
    this.callback = null;
    b.a locala = new b.a();
    locala.hNM = new bkv();
    locala.hNN = new bkw();
    locala.funcId = 831;
    locala.uri = "/cgi-bin/micromsg-bin/getwcopackageproductlist";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    this.uNi = ((bkv)this.rr.hNK.hNQ);
    ad.i("MicroMsg.NetSceneIPCallGetPackageProductList", "NetSceneIPCallGetPackageProductList");
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
    ad.i("MicroMsg.NetSceneIPCallGetPackageProductList", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.uNj = ((bkw)((b)paramq).hNL.hNQ);
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