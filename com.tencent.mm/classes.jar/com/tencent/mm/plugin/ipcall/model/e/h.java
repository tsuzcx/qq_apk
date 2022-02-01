package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dfj;
import com.tencent.mm.protocal.protobuf.dfk;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
  extends q
  implements m
{
  private i callback;
  private d rr;
  public dfj yrC;
  private dfk yrD;
  
  public h(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(25472);
    this.rr = null;
    this.yrC = null;
    this.yrD = null;
    this.callback = null;
    d.a locala = new d.a();
    locala.iLN = new dfj();
    locala.iLO = new dfk();
    locala.funcId = 824;
    locala.uri = "/cgi-bin/micromsg-bin/pstnheartbeat";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    long l = System.currentTimeMillis();
    this.yrC = ((dfj)this.rr.iLK.iLR);
    this.yrC.LsZ = paramInt;
    this.yrC.Lta = paramLong1;
    this.yrC.MKi = paramLong2;
    this.yrC.MKf = l;
    Log.d("MicroMsg.NetSceneIPCallHeartBeat", "heartbeat, roomId: %d, roomKey: %d, callSeq: %d, timestamp: %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(l) });
    AppMethodBeat.o(25472);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(25473);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(25473);
    return i;
  }
  
  public final int getType()
  {
    return 824;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25474);
    Log.i("MicroMsg.NetSceneIPCallHeartBeat", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.yrD = ((dfk)((d)params).iLL.iLR);
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