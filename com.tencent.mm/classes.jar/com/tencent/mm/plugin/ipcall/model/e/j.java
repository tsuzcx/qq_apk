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
import com.tencent.mm.protocal.protobuf.duu;
import com.tencent.mm.protocal.protobuf.duv;
import com.tencent.mm.sdk.platformtools.ac;

public final class j
  extends n
  implements k
{
  private g callback;
  private b rr;
  public duu tKG;
  public duv tKH;
  
  public j(String paramString)
  {
    AppMethodBeat.i(25478);
    this.rr = null;
    this.tKG = null;
    this.tKH = null;
    this.callback = null;
    b.a locala = new b.a();
    locala.hvt = new duu();
    locala.hvu = new duv();
    locala.funcId = 277;
    locala.uri = "/cgi-bin/micromsg-bin/wcopurchasepackage";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    this.tKG = ((duu)this.rr.hvr.hvw);
    this.tKG.ProductID = paramString;
    ac.i("MicroMsg.NetSceneIPCallPurchasePackage", "NetSceneIPCallPurchasePackage ProductID:%s", new Object[] { this.tKG.ProductID });
    AppMethodBeat.o(25478);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(25479);
    this.callback = paramg;
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
    ac.i("MicroMsg.NetSceneIPCallPurchasePackage", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.tKH = ((duv)((b)paramq).hvs.hvw);
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