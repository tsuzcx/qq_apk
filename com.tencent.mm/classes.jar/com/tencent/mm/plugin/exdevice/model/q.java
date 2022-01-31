package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.aqb;
import com.tencent.mm.protocal.protobuf.aqc;
import com.tencent.mm.sdk.platformtools.ab;

public final class q
  extends m
  implements k
{
  private f callback = null;
  public b rr = null;
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(19328);
    this.callback = paramf;
    paramf = new b.a();
    paramf.fsX = new aqb();
    paramf.fsY = new aqc();
    paramf.uri = "/cgi-bin/mmbiz-bin/rank/getsportdevicelist";
    paramf.funcId = getType();
    paramf.reqCmdId = 0;
    paramf.respCmdId = 0;
    this.rr = paramf.ado();
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(19328);
    return i;
  }
  
  public final int getType()
  {
    return 1267;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19327);
    ab.i("MicroMsg.exdevice.NetSceneGetSportDeviceList", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(19327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.q
 * JD-Core Version:    0.7.0.1
 */