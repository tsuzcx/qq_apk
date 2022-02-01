package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bfj;
import com.tencent.mm.protocal.protobuf.bfn;
import com.tencent.mm.protocal.protobuf.cpa;
import com.tencent.mm.protocal.protobuf.cpb;

public final class w
  extends n
  implements k
{
  public com.tencent.mm.al.b fUF;
  private g gbr;
  String oWj;
  
  public w(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(23416);
    this.fUF = null;
    this.gbr = null;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.NetSceneSendHardDeviceMsg", "NetSceneSendHardDeviceMsg deviceType = %s, deviceId = %s, sessionId = %d, createTime = %d, data length = %d, msgType = %d", new Object[] { paramString1, paramString2, Long.valueOf(paramLong2), Long.valueOf(paramLong3), Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt) });
    this.oWj = paramString2;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cpa();
    ((b.a)localObject).gUV = new cpb();
    ((b.a)localObject).funcId = 538;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendharddevicemsg";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.fUF = ((b.a)localObject).atI();
    localObject = (cpa)this.fUF.gUS.gUX;
    bfj localbfj = new bfj();
    localbfj.CBS = paramString1;
    localbfj.mAT = paramString2;
    ((cpa)localObject).CFB = localbfj;
    paramString1 = new bfn();
    paramString1.DCV = paramLong2;
    paramString1.CreateTime = ((int)paramLong3);
    paramString1.CCV = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    paramString1.mBH = paramInt;
    ((cpa)localObject).EiS = paramString1;
    if (paramLong1 != 0L)
    {
      ((cpa)localObject).DCQ = new SKBuiltinBuffer_t().setBuffer(u.cah().t(paramLong1, 2));
      AppMethodBeat.o(23416);
      return;
    }
    paramString1 = ad.bZG().UR(paramString2);
    if (paramString1 != null) {
      ((cpa)localObject).DCQ = new SKBuiltinBuffer_t().setBuffer(paramString1.field_sessionBuf);
    }
    AppMethodBeat.o(23416);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(23418);
    this.gbr = paramg;
    int i = dispatch(parame, this.fUF, this);
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.NetSceneSendHardDeviceMsg", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.gbr.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.w
 * JD-Core Version:    0.7.0.1
 */