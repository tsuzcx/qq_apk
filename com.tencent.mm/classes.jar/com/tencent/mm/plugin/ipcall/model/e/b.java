package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ccq;
import com.tencent.mm.protocal.protobuf.ccr;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends n
  implements k
{
  private g callback;
  private com.tencent.mm.al.b rr;
  private ccq sCH;
  public ccr sCI;
  
  public b(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(25454);
    this.rr = null;
    this.sCH = null;
    this.sCI = null;
    b.a locala = new b.a();
    locala.gUU = new ccq();
    locala.gUV = new ccr();
    locala.funcId = 807;
    locala.uri = "/cgi-bin/micromsg-bin/pstnchecknumber";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    this.sCH = ((ccq)this.rr.gUS.gUX);
    this.sCH.DYY = paramString1;
    this.sCH.DZa = paramString2;
    this.sCH.DZc = paramString3;
    this.sCH.DZb = paramString4;
    this.sCH.DZd = paramInt;
    ad.i("MicroMsg.NetSceneIPCallCheckNumber", "NetSceneIPCallCheckNumber pureNumber:%s,lastCountry:%s,osCountry:%s,simCountry:%s,dialScene:%d", new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(paramInt) });
    AppMethodBeat.o(25454);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(25455);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(25455);
    return i;
  }
  
  public final int getType()
  {
    return 807;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25456);
    ad.i("MicroMsg.NetSceneIPCallCheckNumber", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.sCI = ((ccr)((com.tencent.mm.al.b)paramq).gUT.gUX);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25456);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.b
 * JD-Core Version:    0.7.0.1
 */