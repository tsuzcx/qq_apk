package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dfu;
import com.tencent.mm.protocal.protobuf.dfv;
import com.tencent.mm.sdk.platformtools.Log;

public final class o
  extends q
  implements m
{
  private i callback;
  private d rr;
  public dfu yrQ;
  public dfv yrR;
  
  public o(int paramInt1, long paramLong1, int paramInt2, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(25493);
    this.rr = null;
    this.yrQ = null;
    this.yrR = null;
    d.a locala = new d.a();
    locala.iLN = new dfu();
    locala.iLO = new dfv();
    locala.funcId = 819;
    locala.uri = "/cgi-bin/micromsg-bin/pstnsync";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    long l = System.currentTimeMillis();
    this.yrQ = ((dfu)this.rr.iLK.iLR);
    this.yrQ.MKC = z.aTY();
    this.yrQ.LsZ = paramInt1;
    this.yrQ.Lta = paramLong1;
    this.yrQ.MKf = l;
    this.yrQ.MKD = paramInt2;
    this.yrQ.MKi = paramLong2;
    if (!paramBoolean) {}
    for (this.yrQ.MKE = 0;; this.yrQ.MKE = 1)
    {
      Log.i("MicroMsg.NetSceneIPCallSync", "roomId: %d, roomKey: %d, syncKey: %d, callSeq: %d,dataFlag: %d, timestamp: %d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Long.valueOf(paramLong2), Integer.valueOf(this.yrQ.MKE), Long.valueOf(l) });
      AppMethodBeat.o(25493);
      return;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(25494);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(25494);
    return i;
  }
  
  public final int getType()
  {
    return 819;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25495);
    Log.i("MicroMsg.NetSceneIPCallSync", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.yrR = ((dfv)((d)params).iLL.iLR);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(25495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.o
 * JD-Core Version:    0.7.0.1
 */