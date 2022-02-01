package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bjb;
import com.tencent.mm.protocal.protobuf.bjf;
import com.tencent.mm.protocal.protobuf.cuh;
import com.tencent.mm.protocal.protobuf.cui;
import com.tencent.mm.sdk.platformtools.ac;

public final class w
  extends n
  implements k
{
  public com.tencent.mm.ak.b fYA;
  private g gfX;
  String pzu;
  
  public w(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(23416);
    this.fYA = null;
    this.gfX = null;
    ac.i("MicroMsg.exdevice.NetSceneSendHardDeviceMsg", "NetSceneSendHardDeviceMsg deviceType = %s, deviceId = %s, sessionId = %d, createTime = %d, data length = %d, msgType = %d", new Object[] { paramString1, paramString2, Long.valueOf(paramLong2), Long.valueOf(paramLong3), Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt) });
    this.pzu = paramString2;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cuh();
    ((b.a)localObject).hvu = new cui();
    ((b.a)localObject).funcId = 538;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendharddevicemsg";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.fYA = ((b.a)localObject).aAz();
    localObject = (cuh)this.fYA.hvr.hvw;
    bjb localbjb = new bjb();
    localbjb.DUp = paramString1;
    localbjb.ncU = paramString2;
    ((cuh)localObject).DYb = localbjb;
    paramString1 = new bjf();
    paramString1.EYr = paramLong2;
    paramString1.CreateTime = ((int)paramLong3);
    paramString1.DVs = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    paramString1.ndI = paramInt;
    ((cuh)localObject).FFQ = paramString1;
    if (paramLong1 != 0L)
    {
      ((cuh)localObject).EYm = new SKBuiltinBuffer_t().setBuffer(u.chq().u(paramLong1, 2));
      AppMethodBeat.o(23416);
      return;
    }
    paramString1 = ad.cgP().Zd(paramString2);
    if (paramString1 != null) {
      ((cuh)localObject).EYm = new SKBuiltinBuffer_t().setBuffer(paramString1.field_sessionBuf);
    }
    AppMethodBeat.o(23416);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(23418);
    this.gfX = paramg;
    int i = dispatch(parame, this.fYA, this);
    AppMethodBeat.o(23418);
    return i;
  }
  
  public final int getType()
  {
    return 538;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23417);
    ac.i("MicroMsg.exdevice.NetSceneSendHardDeviceMsg", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.w
 * JD-Core Version:    0.7.0.1
 */