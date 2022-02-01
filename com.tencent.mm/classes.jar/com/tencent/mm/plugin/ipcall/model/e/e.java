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
import com.tencent.mm.protocal.protobuf.bxw;
import com.tencent.mm.protocal.protobuf.bxx;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends q
  implements m
{
  private i callback;
  private d rr;
  private bxw yrv;
  public bxx yrw;
  
  public e()
  {
    AppMethodBeat.i(25463);
    this.rr = null;
    this.yrv = null;
    this.yrw = null;
    this.callback = null;
    d.a locala = new d.a();
    locala.iLN = new bxw();
    locala.iLO = new bxx();
    locala.funcId = 831;
    locala.uri = "/cgi-bin/micromsg-bin/getwcopackageproductlist";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    this.yrv = ((bxw)this.rr.iLK.iLR);
    Log.i("MicroMsg.NetSceneIPCallGetPackageProductList", "NetSceneIPCallGetPackageProductList");
    AppMethodBeat.o(25463);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(25464);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(25464);
    return i;
  }
  
  public final int getType()
  {
    return 831;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25465);
    Log.i("MicroMsg.NetSceneIPCallGetPackageProductList", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.yrw = ((bxx)((d)params).iLL.iLR);
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