package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.v;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.coa;
import com.tencent.mm.protocal.protobuf.cob;
import com.tencent.mm.sdk.platformtools.ae;

public final class o
  extends n
  implements k
{
  private f callback;
  private b rr;
  public coa uZq;
  public cob uZr;
  
  public o(int paramInt1, long paramLong1, int paramInt2, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(25493);
    this.rr = null;
    this.uZq = null;
    this.uZr = null;
    b.a locala = new b.a();
    locala.hQF = new coa();
    locala.hQG = new cob();
    locala.funcId = 819;
    locala.uri = "/cgi-bin/micromsg-bin/pstnsync";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    long l = System.currentTimeMillis();
    this.uZq = ((coa)this.rr.hQD.hQJ);
    this.uZq.HzT = v.aAC();
    this.uZq.Gxq = paramInt1;
    this.uZq.Gxr = paramLong1;
    this.uZq.Hzw = l;
    this.uZq.HzU = paramInt2;
    this.uZq.Hzz = paramLong2;
    if (!paramBoolean) {}
    for (this.uZq.HzV = 0;; this.uZq.HzV = 1)
    {
      ae.i("MicroMsg.NetSceneIPCallSync", "roomId: %d, roomKey: %d, syncKey: %d, callSeq: %d,dataFlag: %d, timestamp: %d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Long.valueOf(paramLong2), Integer.valueOf(this.uZq.HzV), Long.valueOf(l) });
      AppMethodBeat.o(25493);
      return;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(25494);
    this.callback = paramf;
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
    ae.i("MicroMsg.NetSceneIPCallSync", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.uZr = ((cob)((b)paramq).hQE.hQJ);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(25495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.o
 * JD-Core Version:    0.7.0.1
 */