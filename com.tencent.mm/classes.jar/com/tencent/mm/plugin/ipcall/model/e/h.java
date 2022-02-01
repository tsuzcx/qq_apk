package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.chv;
import com.tencent.mm.protocal.protobuf.chw;
import com.tencent.mm.sdk.platformtools.ac;

public final class h
  extends n
  implements k
{
  private g callback;
  private b rr;
  public chv tKC;
  private chw tKD;
  
  public h(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(25472);
    this.rr = null;
    this.tKC = null;
    this.tKD = null;
    this.callback = null;
    b.a locala = new b.a();
    locala.hvt = new chv();
    locala.hvu = new chw();
    locala.funcId = 824;
    locala.uri = "/cgi-bin/micromsg-bin/pstnheartbeat";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    long l = System.currentTimeMillis();
    this.tKC = ((chv)this.rr.hvr.hvw);
    this.tKC.Exf = paramInt;
    this.tKC.Exg = paramLong1;
    this.tKC.FvT = paramLong2;
    this.tKC.FvQ = l;
    ac.d("MicroMsg.NetSceneIPCallHeartBeat", "heartbeat, roomId: %d, roomKey: %d, callSeq: %d, timestamp: %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(l) });
    AppMethodBeat.o(25472);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(25473);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(25473);
    return i;
  }
  
  public final int getType()
  {
    return 824;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25474);
    ac.i("MicroMsg.NetSceneIPCallHeartBeat", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.tKD = ((chw)((b)paramq).hvs.hvw);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25474);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.h
 * JD-Core Version:    0.7.0.1
 */