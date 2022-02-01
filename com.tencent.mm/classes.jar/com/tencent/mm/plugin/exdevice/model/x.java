package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.ciu;
import com.tencent.mm.protocal.protobuf.ciy;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.edr;
import com.tencent.mm.protocal.protobuf.eds;
import com.tencent.mm.sdk.platformtools.Log;

public final class x
  extends q
  implements m
{
  private i jQg;
  public d jTk;
  String vgg;
  
  public x(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(23416);
    this.jTk = null;
    this.jQg = null;
    Log.i("MicroMsg.exdevice.NetSceneSendHardDeviceMsg", "NetSceneSendHardDeviceMsg deviceType = %s, deviceId = %s, sessionId = %d, createTime = %d, data length = %d, msgType = %d", new Object[] { paramString1, paramString2, Long.valueOf(paramLong2), Long.valueOf(paramLong3), Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt) });
    this.vgg = paramString2;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new edr();
    ((d.a)localObject).lBV = new eds();
    ((d.a)localObject).funcId = 538;
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/sendharddevicemsg";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.jTk = ((d.a)localObject).bgN();
    localObject = (edr)d.b.b(this.jTk.lBR);
    ciu localciu = new ciu();
    localciu.RMK = paramString1;
    localciu.rVF = paramString2;
    ((edr)localObject).RQB = localciu;
    paramString1 = new ciy();
    paramString1.Tqc = paramLong2;
    paramString1.CreateTime = ((int)paramLong3);
    paramString1.RNM = new eae().dc(paramArrayOfByte);
    paramString1.rWu = paramInt;
    ((edr)localObject).UhW = paramString1;
    if (paramLong1 != 0L)
    {
      ((edr)localObject).TpX = new eae().dc(u.dak().t(paramLong1, 2));
      AppMethodBeat.o(23416);
      return;
    }
    paramString1 = ae.cZx().avI(paramString2);
    if (paramString1 != null) {
      ((edr)localObject).TpX = new eae().dc(paramString1.field_sessionBuf);
    }
    AppMethodBeat.o(23416);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(23418);
    this.jQg = parami;
    int i = dispatch(paramg, this.jTk, this);
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
    this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.x
 * JD-Core Version:    0.7.0.1
 */