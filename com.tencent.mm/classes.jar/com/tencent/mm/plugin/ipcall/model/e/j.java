package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ewm;
import com.tencent.mm.protocal.protobuf.ewn;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
  extends q
  implements m
{
  private i callback;
  private d rr;
  public ewm yrG;
  public ewn yrH;
  
  public j(String paramString)
  {
    AppMethodBeat.i(25478);
    this.rr = null;
    this.yrG = null;
    this.yrH = null;
    this.callback = null;
    d.a locala = new d.a();
    locala.iLN = new ewm();
    locala.iLO = new ewn();
    locala.funcId = 277;
    locala.uri = "/cgi-bin/micromsg-bin/wcopurchasepackage";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    this.yrG = ((ewm)this.rr.iLK.iLR);
    this.yrG.ProductID = paramString;
    Log.i("MicroMsg.NetSceneIPCallPurchasePackage", "NetSceneIPCallPurchasePackage ProductID:%s", new Object[] { this.yrG.ProductID });
    AppMethodBeat.o(25478);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(25479);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(25479);
    return i;
  }
  
  public final int getType()
  {
    return 277;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25480);
    Log.i("MicroMsg.NetSceneIPCallPurchasePackage", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.yrH = ((ewn)((d)params).iLL.iLR);
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