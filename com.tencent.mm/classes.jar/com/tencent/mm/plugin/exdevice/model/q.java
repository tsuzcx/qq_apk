package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cfx;
import com.tencent.mm.protocal.protobuf.cfy;
import com.tencent.mm.sdk.platformtools.Log;

public final class q
  extends p
  implements m
{
  private h callback;
  c rr;
  
  public q()
  {
    AppMethodBeat.i(23391);
    this.callback = null;
    this.rr = null;
    c.a locala = new c.a();
    locala.otE = new cfx();
    locala.otF = new cfy();
    locala.uri = "/cgi-bin/micromsg-bin/getboundharddevices";
    locala.funcId = 539;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    ((cfx)c.b.b(this.rr.otB)).crz = 1;
    AppMethodBeat.o(23391);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(23393);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(23393);
    return i;
  }
  
  public final int getType()
  {
    return 539;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23392);
    Log.i("MicroMsg.exdevice.NetSceneGetBoundHardDevices", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.q
 * JD-Core Version:    0.7.0.1
 */