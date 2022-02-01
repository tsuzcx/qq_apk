package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cne;
import com.tencent.mm.protocal.protobuf.cnf;
import com.tencent.mm.sdk.platformtools.ad;

public final class n
  extends com.tencent.mm.al.n
  implements k
{
  private f callback;
  private b rr;
  public cne uNB;
  private cnf uNC;
  
  public n(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(25490);
    this.rr = null;
    this.uNB = null;
    this.uNC = null;
    this.callback = null;
    b.a locala = new b.a();
    locala.hNM = new cne();
    locala.hNN = new cnf();
    locala.funcId = 723;
    locala.uri = "/cgi-bin/micromsg-bin/pstnshutdown";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    long l = System.currentTimeMillis();
    this.uNB = ((cne)this.rr.hNK.hNQ);
    this.uNB.ukj = u.aAm();
    this.uNB.GeI = paramInt1;
    this.uNB.GeJ = paramLong1;
    this.uNB.HfZ = paramLong2;
    this.uNB.nDG = paramInt2;
    this.uNB.HfW = l;
    ad.i("MicroMsg.NetSceneIPCallShutDown", "roomId: %d, roomKey: %d, callSeq: %d, status: %d, timestamp: %d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Long.valueOf(l) });
    AppMethodBeat.o(25490);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(25491);
    this.callback = paramf;
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
    ad.i("MicroMsg.NetSceneIPCallShutDown", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.uNC = ((cnf)((b)paramq).hNL.hNQ);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.n
 * JD-Core Version:    0.7.0.1
 */