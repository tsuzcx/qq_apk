package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cnn;
import com.tencent.mm.protocal.protobuf.cno;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
  extends n
  implements k
{
  private f callback;
  private com.tencent.mm.ak.b rr;
  private cnn uYP;
  public cno uYQ;
  
  public b(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(25454);
    this.rr = null;
    this.uYP = null;
    this.uYQ = null;
    b.a locala = new b.a();
    locala.hQF = new cnn();
    locala.hQG = new cno();
    locala.funcId = 807;
    locala.uri = "/cgi-bin/micromsg-bin/pstnchecknumber";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    this.uYP = ((cnn)this.rr.hQD.hQJ);
    this.uYP.HzA = paramString1;
    this.uYP.HzC = paramString2;
    this.uYP.HzE = paramString3;
    this.uYP.HzD = paramString4;
    this.uYP.HzF = paramInt;
    ae.i("MicroMsg.NetSceneIPCallCheckNumber", "NetSceneIPCallCheckNumber pureNumber:%s,lastCountry:%s,osCountry:%s,simCountry:%s,dialScene:%d", new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(paramInt) });
    AppMethodBeat.o(25454);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(25455);
    this.callback = paramf;
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
    ae.i("MicroMsg.NetSceneIPCallCheckNumber", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.uYQ = ((cno)((com.tencent.mm.ak.b)paramq).hQE.hQJ);
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