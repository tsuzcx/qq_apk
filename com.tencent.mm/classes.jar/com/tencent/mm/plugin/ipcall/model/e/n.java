package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.protocal.protobuf.cif;
import com.tencent.mm.sdk.platformtools.ac;

public final class n
  extends com.tencent.mm.ak.n
  implements k
{
  private g callback;
  private b rr;
  public cie tKO;
  private cif tKP;
  
  public n(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(25490);
    this.rr = null;
    this.tKO = null;
    this.tKP = null;
    this.callback = null;
    b.a locala = new b.a();
    locala.hvt = new cie();
    locala.hvu = new cif();
    locala.funcId = 723;
    locala.uri = "/cgi-bin/micromsg-bin/pstnshutdown";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    long l = System.currentTimeMillis();
    this.tKO = ((cie)this.rr.hvr.hvw);
    this.tKO.tlK = u.axw();
    this.tKO.Exf = paramInt1;
    this.tKO.Exg = paramLong1;
    this.tKO.FvT = paramLong2;
    this.tKO.ndj = paramInt2;
    this.tKO.FvQ = l;
    ac.i("MicroMsg.NetSceneIPCallShutDown", "roomId: %d, roomKey: %d, callSeq: %d, status: %d, timestamp: %d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Long.valueOf(l) });
    AppMethodBeat.o(25490);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(25491);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(25491);
    return i;
  }
  
  public final int getType()
  {
    return 723;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25492);
    ac.i("MicroMsg.NetSceneIPCallShutDown", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.tKP = ((cif)((b)paramq).hvs.hvw);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.n
 * JD-Core Version:    0.7.0.1
 */