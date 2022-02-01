package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cep;
import com.tencent.mm.protocal.protobuf.ceq;
import com.tencent.mm.sdk.platformtools.Log;

public final class r
  extends q
  implements m
{
  private i callback;
  d rr;
  
  public r()
  {
    AppMethodBeat.i(285279);
    this.callback = null;
    this.rr = null;
    d.a locala = new d.a();
    locala.lBU = new cep();
    locala.lBV = new ceq();
    locala.uri = "/cgi-bin/micromsg-bin/get_user_bind_iot_device_info";
    locala.funcId = 6693;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    AppMethodBeat.o(285279);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(285281);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(285281);
    return i;
  }
  
  public final int getType()
  {
    return 6693;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(285280);
    Log.i("MicroMsg.exdevice.NetSceneGetUserBindIotDeviceInfo", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(285280);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.r
 * JD-Core Version:    0.7.0.1
 */