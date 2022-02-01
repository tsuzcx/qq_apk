package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.bji;
import com.tencent.mm.protocal.protobuf.bjj;
import com.tencent.mm.sdk.platformtools.ae;

public final class q
  extends n
  implements k
{
  private f callback = null;
  public b rr = null;
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(23397);
    this.callback = paramf;
    paramf = new b.a();
    paramf.hQF = new bji();
    paramf.hQG = new bjj();
    paramf.uri = "/cgi-bin/mmbiz-bin/rank/getsportdevicelist";
    paramf.funcId = getType();
    paramf.hQH = 0;
    paramf.respCmdId = 0;
    this.rr = paramf.aDS();
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(23397);
    return i;
  }
  
  public final int getType()
  {
    return 1267;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23396);
    ae.i("MicroMsg.exdevice.NetSceneGetSportDeviceList", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23396);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.q
 * JD-Core Version:    0.7.0.1
 */