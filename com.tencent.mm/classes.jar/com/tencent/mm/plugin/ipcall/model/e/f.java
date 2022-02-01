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
import com.tencent.mm.protocal.protobuf.bxy;
import com.tencent.mm.protocal.protobuf.bxz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class f
  extends q
  implements m
{
  private i callback;
  private d rr;
  private bxy yrx;
  public bxz yry;
  public boolean yrz;
  
  public f(String paramString1, String paramString2)
  {
    AppMethodBeat.i(25466);
    this.rr = null;
    this.yrx = null;
    this.yry = null;
    this.yrz = true;
    if (Util.isNullOrNil(paramString2))
    {
      this.yrz = true;
      paramString2 = "";
    }
    for (;;)
    {
      d.a locala = new d.a();
      locala.iLN = new bxy();
      locala.iLO = new bxz();
      locala.funcId = 929;
      locala.uri = "/cgi-bin/micromsg-bin/getwcoproductlist";
      locala.iLP = 0;
      locala.respCmdId = 0;
      this.rr = locala.aXF();
      this.yrx = ((bxy)this.rr.iLK.iLR);
      this.yrx.Mdu = paramString1;
      this.yrx.Mdv = paramString2;
      Log.i("MicroMsg.NetSceneIPCallGetProductList", "NetSceneIPCallGetProductList");
      AppMethodBeat.o(25466);
      return;
      this.yrz = false;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(25467);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(25467);
    return i;
  }
  
  public final int getType()
  {
    return 929;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25468);
    Log.i("MicroMsg.NetSceneIPCallGetProductList", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.yry = ((bxz)((d)params).iLL.iLR);
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