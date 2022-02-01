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
import com.tencent.mm.protocal.protobuf.dff;
import com.tencent.mm.protocal.protobuf.dfg;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends q
  implements m
{
  private i callback;
  private d rr;
  public dff yrn;
  private dfg yro;
  
  public a(int paramInt1, long paramLong1, String paramString1, String paramString2, int paramInt2, long paramLong2)
  {
    AppMethodBeat.i(25451);
    this.rr = null;
    this.yrn = null;
    this.yro = null;
    this.callback = null;
    d.a locala = new d.a();
    locala.iLN = new dff();
    locala.iLO = new dfg();
    locala.funcId = 843;
    locala.uri = "/cgi-bin/micromsg-bin/pstncancelinvite";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    long l = System.currentTimeMillis();
    this.yrn = ((dff)this.rr.iLK.iLR);
    this.yrn.LsZ = paramInt1;
    this.yrn.Lta = paramLong1;
    this.yrn.xNG = paramString1;
    this.yrn.MKf = l;
    this.yrn.MKg = paramInt2;
    this.yrn.MKh = paramString2;
    this.yrn.MKi = paramLong2;
    Log.d("MicroMsg.NetSceneIPCallCancel", "roomId: %d, roomKey: %d, toUsername: %s, timestamp: %d, inviteId: %d, phoneNumber: %s, callseq: %d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), paramString1, Long.valueOf(l), Integer.valueOf(paramInt2), paramString2, Long.valueOf(paramLong2) });
    AppMethodBeat.o(25451);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(25452);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(25452);
    return i;
  }
  
  public final int getType()
  {
    return 843;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25453);
    Log.i("MicroMsg.NetSceneIPCallCancel", "errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.yro = ((dfg)((d)params).iLL.iLR);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.a
 * JD-Core Version:    0.7.0.1
 */