package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.csu;
import com.tencent.mm.sdk.platformtools.Log;

public final class s
  extends p
  implements m
{
  private h callback = null;
  public c rr = null;
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(23397);
    this.callback = paramh;
    paramh = new c.a();
    paramh.otE = new cst();
    paramh.otF = new csu();
    paramh.uri = "/cgi-bin/mmbiz-bin/rank/getsportdevicelist";
    paramh.funcId = getType();
    paramh.otG = 0;
    paramh.respCmdId = 0;
    this.rr = paramh.bEF();
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(23397);
    return i;
  }
  
  public final int getType()
  {
    return 1267;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23396);
    Log.i("MicroMsg.exdevice.NetSceneGetSportDeviceList", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23396);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.s
 * JD-Core Version:    0.7.0.1
 */