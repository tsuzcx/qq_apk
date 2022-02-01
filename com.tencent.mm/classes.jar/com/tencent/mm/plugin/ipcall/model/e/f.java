package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bgp;
import com.tencent.mm.protocal.protobuf.bgq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class f
  extends n
  implements k
{
  private g callback;
  private b rr;
  private bgp tKx;
  public bgq tKy;
  public boolean tKz;
  
  public f(String paramString1, String paramString2)
  {
    AppMethodBeat.i(25466);
    this.rr = null;
    this.tKx = null;
    this.tKy = null;
    this.tKz = true;
    if (bs.isNullOrNil(paramString2))
    {
      this.tKz = true;
      paramString2 = "";
    }
    for (;;)
    {
      b.a locala = new b.a();
      locala.hvt = new bgp();
      locala.hvu = new bgq();
      locala.funcId = 929;
      locala.uri = "/cgi-bin/micromsg-bin/getwcoproductlist";
      locala.reqCmdId = 0;
      locala.respCmdId = 0;
      this.rr = locala.aAz();
      this.tKx = ((bgp)this.rr.hvr.hvw);
      this.tKx.EVE = paramString1;
      this.tKx.EVF = paramString2;
      ac.i("MicroMsg.NetSceneIPCallGetProductList", "NetSceneIPCallGetProductList");
      AppMethodBeat.o(25466);
      return;
      this.tKz = false;
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
    ac.i("MicroMsg.NetSceneIPCallGetProductList", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.tKy = ((bgq)((b)paramq).hvs.hvw);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25468);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.f
 * JD-Core Version:    0.7.0.1
 */