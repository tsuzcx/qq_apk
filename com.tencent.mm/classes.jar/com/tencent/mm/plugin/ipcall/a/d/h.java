package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bod;
import com.tencent.mm.protocal.protobuf.boe;
import com.tencent.mm.sdk.platformtools.ab;

public final class h
  extends m
  implements k
{
  private f callback;
  public bod nOZ;
  private boe nPa;
  private b rr;
  
  public h(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(21857);
    this.rr = null;
    this.nOZ = null;
    this.nPa = null;
    this.callback = null;
    b.a locala = new b.a();
    locala.fsX = new bod();
    locala.fsY = new boe();
    locala.funcId = 824;
    locala.uri = "/cgi-bin/micromsg-bin/pstnheartbeat";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    long l = System.currentTimeMillis();
    this.nOZ = ((bod)this.rr.fsV.fta);
    this.nOZ.wQP = paramInt;
    this.nOZ.wQQ = paramLong1;
    this.nOZ.xCm = paramLong2;
    this.nOZ.xCj = l;
    ab.d("MicroMsg.NetSceneIPCallHeartBeat", "heartbeat, roomId: %d, roomKey: %d, callSeq: %d, timestamp: %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(l) });
    AppMethodBeat.o(21857);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(21858);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(21858);
    return i;
  }
  
  public final int getType()
  {
    return 824;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21859);
    ab.i("MicroMsg.NetSceneIPCallHeartBeat", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.nPa = ((boe)((b)paramq).fsW.fta);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(21859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.d.h
 * JD-Core Version:    0.7.0.1
 */