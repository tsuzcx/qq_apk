package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bkx;
import com.tencent.mm.protocal.protobuf.bky;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class f
  extends n
  implements k
{
  private com.tencent.mm.al.f callback;
  private b rr;
  private bkx uNk;
  public bky uNl;
  public boolean uNm;
  
  public f(String paramString1, String paramString2)
  {
    AppMethodBeat.i(25466);
    this.rr = null;
    this.uNk = null;
    this.uNl = null;
    this.uNm = true;
    if (bt.isNullOrNil(paramString2))
    {
      this.uNm = true;
      paramString2 = "";
    }
    for (;;)
    {
      b.a locala = new b.a();
      locala.hNM = new bkx();
      locala.hNN = new bky();
      locala.funcId = 929;
      locala.uri = "/cgi-bin/micromsg-bin/getwcoproductlist";
      locala.hNO = 0;
      locala.respCmdId = 0;
      this.rr = locala.aDC();
      this.uNk = ((bkx)this.rr.hNK.hNQ);
      this.uNk.GFc = paramString1;
      this.uNk.GFd = paramString2;
      ad.i("MicroMsg.NetSceneIPCallGetProductList", "NetSceneIPCallGetProductList");
      AppMethodBeat.o(25466);
      return;
      this.uNm = false;
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(25467);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(25467);
    return i;
  }
  
  public final int getType()
  {
    return 929;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25468);
    ad.i("MicroMsg.NetSceneIPCallGetProductList", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.uNl = ((bky)((b)paramq).hNL.hNQ);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25468);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.f
 * JD-Core Version:    0.7.0.1
 */