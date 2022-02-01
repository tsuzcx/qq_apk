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
import com.tencent.mm.protocal.protobuf.dao;
import com.tencent.mm.protocal.protobuf.fpg;
import com.tencent.mm.protocal.protobuf.fph;
import com.tencent.mm.sdk.platformtools.Log;

public final class aa
  extends p
  implements m
{
  private h callback;
  private c rr;
  ae ysf;
  
  public aa(dao paramdao, ae paramae)
  {
    AppMethodBeat.i(274583);
    this.callback = null;
    this.rr = null;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fpg();
    ((c.a)localObject).otF = new fph();
    ((c.a)localObject).uri = "/cgi-bin/mmiot-bin/mmiot/mmiot_transfermsgtodevice";
    ((c.a)localObject).funcId = 6844;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    Log.i("MicroMsg.exdevice.NetSceneTransferToIotDevice", "deviceid %s", new Object[] { paramae.deviceID });
    localObject = (fpg)c.b.b(this.rr.otB);
    ((fpg)localObject).abcm = paramae.hFT;
    ((fpg)localObject).ZoO = paramae.deviceID;
    ((fpg)localObject).abPi = paramdao;
    this.ysf = paramae;
    AppMethodBeat.o(274583);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(274586);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(274586);
    return i;
  }
  
  public final int getType()
  {
    return 6844;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(274585);
    Log.i("MicroMsg.exdevice.NetSceneTransferToIotDevice", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(274585);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.aa
 * JD-Core Version:    0.7.0.1
 */