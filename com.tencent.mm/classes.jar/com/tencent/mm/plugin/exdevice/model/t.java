package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cur;
import com.tencent.mm.protocal.protobuf.cus;
import com.tencent.mm.sdk.platformtools.Log;

public final class t
  extends p
  implements m
{
  private h callback;
  c rr;
  
  public t()
  {
    AppMethodBeat.i(274603);
    this.callback = null;
    this.rr = null;
    c.a locala = new c.a();
    locala.otE = new cur();
    locala.otF = new cus();
    locala.uri = "/cgi-bin/micromsg-bin/get_user_bind_iot_device_info";
    locala.funcId = 6693;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    AppMethodBeat.o(274603);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(274609);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(274609);
    return i;
  }
  
  public final int getType()
  {
    return 6693;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(274605);
    Log.i("MicroMsg.exdevice.NetSceneGetUserBindIotDeviceInfo", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(274605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.t
 * JD-Core Version:    0.7.0.1
 */