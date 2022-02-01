package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cig;
import com.tencent.mm.protocal.protobuf.cih;
import com.tencent.mm.sdk.platformtools.ac;

public final class o
  extends n
  implements k
{
  private g callback;
  private b rr;
  public cig tKQ;
  public cih tKR;
  
  public o(int paramInt1, long paramLong1, int paramInt2, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(25493);
    this.rr = null;
    this.tKQ = null;
    this.tKR = null;
    b.a locala = new b.a();
    locala.hvt = new cig();
    locala.hvu = new cih();
    locala.funcId = 819;
    locala.uri = "/cgi-bin/micromsg-bin/pstnsync";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    long l = System.currentTimeMillis();
    this.tKQ = ((cig)this.rr.hvr.hvw);
    this.tKQ.Fwn = u.axw();
    this.tKQ.Exf = paramInt1;
    this.tKQ.Exg = paramLong1;
    this.tKQ.FvQ = l;
    this.tKQ.Fwo = paramInt2;
    this.tKQ.FvT = paramLong2;
    if (!paramBoolean) {}
    for (this.tKQ.Fwp = 0;; this.tKQ.Fwp = 1)
    {
      ac.i("MicroMsg.NetSceneIPCallSync", "roomId: %d, roomKey: %d, syncKey: %d, callSeq: %d,dataFlag: %d, timestamp: %d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Long.valueOf(paramLong2), Integer.valueOf(this.tKQ.Fwp), Long.valueOf(l) });
      AppMethodBeat.o(25493);
      return;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(25494);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(25494);
    return i;
  }
  
  public final int getType()
  {
    return 819;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25495);
    ac.i("MicroMsg.NetSceneIPCallSync", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.tKR = ((cih)((b)paramq).hvs.hvw);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(25495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.o
 * JD-Core Version:    0.7.0.1
 */