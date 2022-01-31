package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.protocal.protobuf.asf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class f
  extends m
  implements k
{
  private com.tencent.mm.ai.f callback;
  private ase nOU;
  public asf nOV;
  public boolean nOW;
  private b rr;
  
  public f(String paramString1, String paramString2)
  {
    AppMethodBeat.i(21851);
    this.rr = null;
    this.nOU = null;
    this.nOV = null;
    this.nOW = true;
    if (bo.isNullOrNil(paramString2))
    {
      this.nOW = true;
      paramString2 = "";
    }
    for (;;)
    {
      b.a locala = new b.a();
      locala.fsX = new ase();
      locala.fsY = new asf();
      locala.funcId = 929;
      locala.uri = "/cgi-bin/micromsg-bin/getwcoproductlist";
      locala.reqCmdId = 0;
      locala.respCmdId = 0;
      this.rr = locala.ado();
      this.nOU = ((ase)this.rr.fsV.fta);
      this.nOU.xhg = paramString1;
      this.nOU.xhh = paramString2;
      ab.i("MicroMsg.NetSceneIPCallGetProductList", "NetSceneIPCallGetProductList");
      AppMethodBeat.o(21851);
      return;
      this.nOW = false;
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(21852);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(21852);
    return i;
  }
  
  public final int getType()
  {
    return 929;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21853);
    ab.i("MicroMsg.NetSceneIPCallGetProductList", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.nOV = ((asf)((b)paramq).fsW.fta);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(21853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.d.f
 * JD-Core Version:    0.7.0.1
 */