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
import com.tencent.mm.protocal.protobuf.dfs;
import com.tencent.mm.protocal.protobuf.dft;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
  extends q
  implements m
{
  private i callback;
  private d rr;
  public dfs yrO;
  private dft yrP;
  
  public n(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(25490);
    this.rr = null;
    this.yrO = null;
    this.yrP = null;
    this.callback = null;
    d.a locala = new d.a();
    locala.iLN = new dfs();
    locala.iLO = new dft();
    locala.funcId = 723;
    locala.uri = "/cgi-bin/micromsg-bin/pstnshutdown";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    long l = System.currentTimeMillis();
    this.yrO = ((dfs)this.rr.iLK.iLR);
    this.yrO.xNH = z.aTY();
    this.yrO.LsZ = paramInt1;
    this.yrO.Lta = paramLong1;
    this.yrO.MKi = paramLong2;
    this.yrO.oTW = paramInt2;
    this.yrO.MKf = l;
    Log.i("MicroMsg.NetSceneIPCallShutDown", "roomId: %d, roomKey: %d, callSeq: %d, status: %d, timestamp: %d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Long.valueOf(l) });
    AppMethodBeat.o(25490);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(25491);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(25491);
    return i;
  }
  
  public final int getType()
  {
    return 723;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25492);
    Log.i("MicroMsg.NetSceneIPCallShutDown", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.yrP = ((dft)((d)params).iLL.iLR);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.n
 * JD-Core Version:    0.7.0.1
 */