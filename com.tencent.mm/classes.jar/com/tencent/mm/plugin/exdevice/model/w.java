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
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.cax;
import com.tencent.mm.protocal.protobuf.dtp;
import com.tencent.mm.protocal.protobuf.dtq;
import com.tencent.mm.sdk.platformtools.Log;

public final class w
  extends q
  implements m
{
  private i heq;
  public d hhm;
  String rAz;
  
  public w(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(23416);
    this.hhm = null;
    this.heq = null;
    Log.i("MicroMsg.exdevice.NetSceneSendHardDeviceMsg", "NetSceneSendHardDeviceMsg deviceType = %s, deviceId = %s, sessionId = %d, createTime = %d, data length = %d, msgType = %d", new Object[] { paramString1, paramString2, Long.valueOf(paramLong2), Long.valueOf(paramLong3), Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt) });
    this.rAz = paramString2;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dtp();
    ((d.a)localObject).iLO = new dtq();
    ((d.a)localObject).funcId = 538;
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/sendharddevicemsg";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.hhm = ((d.a)localObject).aXF();
    localObject = (dtp)this.hhm.iLK.iLR;
    cat localcat = new cat();
    localcat.KLO = paramString1;
    localcat.oTH = paramString2;
    ((dtp)localObject).KPD = localcat;
    paramString1 = new cax();
    paramString1.Mgq = paramLong2;
    paramString1.CreateTime = ((int)paramLong3);
    paramString1.KMS = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    paramString1.oUv = paramInt;
    ((dtp)localObject).MVD = paramString1;
    if (paramLong1 != 0L)
    {
      ((dtp)localObject).Mgl = new SKBuiltinBuffer_t().setBuffer(u.cLx().r(paramLong1, 2));
      AppMethodBeat.o(23416);
      return;
    }
    paramString1 = ad.cKL().anJ(paramString2);
    if (paramString1 != null) {
      ((dtp)localObject).Mgl = new SKBuiltinBuffer_t().setBuffer(paramString1.field_sessionBuf);
    }
    AppMethodBeat.o(23416);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(23418);
    this.heq = parami;
    int i = dispatch(paramg, this.hhm, this);
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
    this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.w
 * JD-Core Version:    0.7.0.1
 */