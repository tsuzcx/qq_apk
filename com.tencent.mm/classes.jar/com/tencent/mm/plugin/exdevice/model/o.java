package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bjx;
import com.tencent.mm.protocal.protobuf.bjy;
import com.tencent.mm.sdk.platformtools.Log;

public final class o
  extends q
  implements m
{
  private i callback;
  d rr;
  
  public o()
  {
    AppMethodBeat.i(23391);
    this.callback = null;
    this.rr = null;
    d.a locala = new d.a();
    locala.iLN = new bjx();
    locala.iLO = new bjy();
    locala.uri = "/cgi-bin/micromsg-bin/getboundharddevices";
    locala.funcId = 539;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((bjx)this.rr.iLK.iLR).Version = 1;
    AppMethodBeat.o(23391);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(23393);
    this.callback = parami;
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
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.o
 * JD-Core Version:    0.7.0.1
 */