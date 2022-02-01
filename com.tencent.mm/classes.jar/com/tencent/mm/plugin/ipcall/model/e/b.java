package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cht;
import com.tencent.mm.protocal.protobuf.chu;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
  extends n
  implements k
{
  private g callback;
  private com.tencent.mm.ak.b rr;
  private cht tKp;
  public chu tKq;
  
  public b(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(25454);
    this.rr = null;
    this.tKp = null;
    this.tKq = null;
    b.a locala = new b.a();
    locala.hvt = new cht();
    locala.hvu = new chu();
    locala.funcId = 807;
    locala.uri = "/cgi-bin/micromsg-bin/pstnchecknumber";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    this.tKp = ((cht)this.rr.hvr.hvw);
    this.tKp.FvU = paramString1;
    this.tKp.FvW = paramString2;
    this.tKp.FvY = paramString3;
    this.tKp.FvX = paramString4;
    this.tKp.FvZ = paramInt;
    ac.i("MicroMsg.NetSceneIPCallCheckNumber", "NetSceneIPCallCheckNumber pureNumber:%s,lastCountry:%s,osCountry:%s,simCountry:%s,dialScene:%d", new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(paramInt) });
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
    ac.i("MicroMsg.NetSceneIPCallCheckNumber", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.tKq = ((chu)((com.tencent.mm.ak.b)paramq).hvs.hvw);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25456);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.b
 * JD-Core Version:    0.7.0.1
 */