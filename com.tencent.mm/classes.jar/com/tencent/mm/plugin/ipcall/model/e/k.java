package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cia;
import com.tencent.mm.protocal.protobuf.cib;
import com.tencent.mm.sdk.platformtools.ac;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private g callback;
  private b rr;
  public cia tKI;
  public cib tKJ;
  
  public k(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(25481);
    this.rr = null;
    this.tKI = null;
    this.tKJ = null;
    this.callback = null;
    b.a locala = new b.a();
    locala.hvt = new cia();
    locala.hvu = new cib();
    locala.funcId = 726;
    locala.uri = "/cgi-bin/micromsg-bin/pstnredirect";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    this.tKI = ((cia)this.rr.hvr.hvw);
    this.tKI.Exf = paramInt;
    this.tKI.Exg = paramLong1;
    this.tKI.FvT = paramLong2;
    AppMethodBeat.o(25481);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(25482);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(25482);
    return i;
  }
  
  public final int getType()
  {
    return 726;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25483);
    ac.i("MicroMsg.NetSceneIPCallRedirect", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.tKJ = ((cib)((b)paramq).hvs.hvw);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.k
 * JD-Core Version:    0.7.0.1
 */