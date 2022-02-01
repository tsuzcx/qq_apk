package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eig;
import com.tencent.mm.protocal.protobuf.eih;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
  extends p
  implements m
{
  public eig JJa;
  private eih JJb;
  private h callback;
  private c rr;
  
  public n(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(25490);
    this.rr = null;
    this.JJa = null;
    this.JJb = null;
    this.callback = null;
    c.a locala = new c.a();
    locala.otE = new eig();
    locala.otF = new eih();
    locala.funcId = 723;
    locala.uri = "/cgi-bin/micromsg-bin/pstnshutdown";
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    long l = System.currentTimeMillis();
    this.JJa = ((eig)c.b.b(this.rr.otB));
    this.JJa.IMh = z.bAM();
    this.JJa.Zvz = paramInt1;
    this.JJa.ZvA = paramLong1;
    this.JJa.abmR = paramLong2;
    this.JJa.vhk = paramInt2;
    this.JJa.abmO = l;
    Log.i("MicroMsg.NetSceneIPCallShutDown", "roomId: %d, roomKey: %d, callSeq: %d, status: %d, timestamp: %d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Long.valueOf(l) });
    AppMethodBeat.o(25490);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(25491);
    this.callback = paramh;
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
    this.JJb = ((eih)c.c.b(((c)params).otC));
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