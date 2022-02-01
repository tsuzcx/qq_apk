package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.cyx;
import com.tencent.mm.protocal.protobuf.czb;
import com.tencent.mm.protocal.protobuf.exi;
import com.tencent.mm.protocal.protobuf.exj;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;

public final class z
  extends p
  implements m
{
  private h mAY;
  public com.tencent.mm.am.c mtC;
  String yse;
  
  public z(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(23416);
    this.mtC = null;
    this.mAY = null;
    Log.i("MicroMsg.exdevice.NetSceneSendHardDeviceMsg", "NetSceneSendHardDeviceMsg deviceType = %s, deviceId = %s, sessionId = %d, createTime = %d, data length = %d, msgType = %d", new Object[] { paramString1, paramString2, Long.valueOf(paramLong2), Long.valueOf(paramLong3), Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt) });
    this.yse = paramString2;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new exi();
    ((c.a)localObject).otF = new exj();
    ((c.a)localObject).funcId = 538;
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/sendharddevicemsg";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.mtC = ((c.a)localObject).bEF();
    localObject = (exi)c.b.b(this.mtC.otB);
    cyx localcyx = new cyx();
    localcyx.YJY = paramString1;
    localcyx.vgV = paramString2;
    ((exi)localObject).YNR = localcyx;
    paramString1 = new czb();
    paramString1.aaEe = paramLong2;
    paramString1.CreateTime = ((int)paramLong3);
    paramString1.YLa = new gol().df(paramArrayOfByte);
    paramString1.vhJ = paramInt;
    ((exi)localObject).abzm = paramString1;
    if (paramLong1 != 0L)
    {
      ((exi)localObject).aaDZ = new gol().df(u.dGD().C(paramLong1, 2));
      AppMethodBeat.o(23416);
      return;
    }
    paramString1 = ah.dFO().apI(paramString2);
    if (paramString1 != null) {
      ((exi)localObject).aaDZ = new gol().df(paramString1.field_sessionBuf);
    }
    AppMethodBeat.o(23416);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(23418);
    this.mAY = paramh;
    int i = dispatch(paramg, this.mtC, this);
    AppMethodBeat.o(23418);
    return i;
  }
  
  public final int getType()
  {
    return 538;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23417);
    Log.i("MicroMsg.exdevice.NetSceneSendHardDeviceMsg", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.z
 * JD-Core Version:    0.7.0.1
 */