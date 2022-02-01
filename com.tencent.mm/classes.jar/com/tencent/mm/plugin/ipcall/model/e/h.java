package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cmv;
import com.tencent.mm.protocal.protobuf.cmw;
import com.tencent.mm.sdk.platformtools.ad;

public final class h
  extends n
  implements k
{
  private f callback;
  private b rr;
  public cmv uNp;
  private cmw uNq;
  
  public h(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(25472);
    this.rr = null;
    this.uNp = null;
    this.uNq = null;
    this.callback = null;
    b.a locala = new b.a();
    locala.hNM = new cmv();
    locala.hNN = new cmw();
    locala.funcId = 824;
    locala.uri = "/cgi-bin/micromsg-bin/pstnheartbeat";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    long l = System.currentTimeMillis();
    this.uNp = ((cmv)this.rr.hNK.hNQ);
    this.uNp.GeI = paramInt;
    this.uNp.GeJ = paramLong1;
    this.uNp.HfZ = paramLong2;
    this.uNp.HfW = l;
    ad.d("MicroMsg.NetSceneIPCallHeartBeat", "heartbeat, roomId: %d, roomKey: %d, callSeq: %d, timestamp: %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(l) });
    AppMethodBeat.o(25472);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(25473);
    this.callback = paramf;
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
    ad.i("MicroMsg.NetSceneIPCallHeartBeat", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.uNq = ((cmw)((b)paramq).hNL.hNQ);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25474);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.h
 * JD-Core Version:    0.7.0.1
 */