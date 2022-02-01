package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bcx;
import com.tencent.mm.protocal.protobuf.bcy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class f
  extends n
  implements k
{
  private g callback;
  private b rr;
  private bcx sCP;
  public bcy sCQ;
  public boolean sCR;
  
  public f(String paramString1, String paramString2)
  {
    AppMethodBeat.i(25466);
    this.rr = null;
    this.sCP = null;
    this.sCQ = null;
    this.sCR = true;
    if (bt.isNullOrNil(paramString2))
    {
      this.sCR = true;
      paramString2 = "";
    }
    for (;;)
    {
      b.a locala = new b.a();
      locala.gUU = new bcx();
      locala.gUV = new bcy();
      locala.funcId = 929;
      locala.uri = "/cgi-bin/micromsg-bin/getwcoproductlist";
      locala.reqCmdId = 0;
      locala.respCmdId = 0;
      this.rr = locala.atI();
      this.sCP = ((bcx)this.rr.gUS.gUX);
      this.sCP.DAi = paramString1;
      this.sCP.DAj = paramString2;
      ad.i("MicroMsg.NetSceneIPCallGetProductList", "NetSceneIPCallGetProductList");
      AppMethodBeat.o(25466);
      return;
      this.sCR = false;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(25467);
    this.callback = paramg;
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
    this.sCQ = ((bcy)((b)paramq).gUT.gUX);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25468);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.f
 * JD-Core Version:    0.7.0.1
 */