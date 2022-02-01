package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bvn;
import com.tencent.mm.protocal.protobuf.bvo;
import com.tencent.mm.sdk.platformtools.Log;

public final class q
  extends com.tencent.mm.ak.q
  implements m
{
  private i callback = null;
  public d rr = null;
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(23397);
    this.callback = parami;
    parami = new d.a();
    parami.iLN = new bvn();
    parami.iLO = new bvo();
    parami.uri = "/cgi-bin/mmbiz-bin/rank/getsportdevicelist";
    parami.funcId = getType();
    parami.iLP = 0;
    parami.respCmdId = 0;
    this.rr = parami.aXF();
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(23397);
    return i;
  }
  
  public final int getType()
  {
    return 1267;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23396);
    Log.i("MicroMsg.exdevice.NetSceneGetSportDeviceList", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23396);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.q
 * JD-Core Version:    0.7.0.1
 */