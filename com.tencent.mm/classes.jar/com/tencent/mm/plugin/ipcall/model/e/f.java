package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.protocal.protobuf.blq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class f
  extends n
  implements k
{
  private com.tencent.mm.ak.f callback;
  private b rr;
  private blp uYX;
  public blq uYY;
  public boolean uYZ;
  
  public f(String paramString1, String paramString2)
  {
    AppMethodBeat.i(25466);
    this.rr = null;
    this.uYX = null;
    this.uYY = null;
    this.uYZ = true;
    if (bu.isNullOrNil(paramString2))
    {
      this.uYZ = true;
      paramString2 = "";
    }
    for (;;)
    {
      b.a locala = new b.a();
      locala.hQF = new blp();
      locala.hQG = new blq();
      locala.funcId = 929;
      locala.uri = "/cgi-bin/micromsg-bin/getwcoproductlist";
      locala.hQH = 0;
      locala.respCmdId = 0;
      this.rr = locala.aDS();
      this.uYX = ((blp)this.rr.hQD.hQJ);
      this.uYX.GYE = paramString1;
      this.uYX.GYF = paramString2;
      ae.i("MicroMsg.NetSceneIPCallGetProductList", "NetSceneIPCallGetProductList");
      AppMethodBeat.o(25466);
      return;
      this.uYZ = false;
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
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
    ae.i("MicroMsg.NetSceneIPCallGetProductList", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.uYY = ((blq)((b)paramq).hQE.hQJ);
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