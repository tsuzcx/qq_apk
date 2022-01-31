package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.h.c;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.auh;
import com.tencent.mm.protocal.protobuf.aul;
import com.tencent.mm.protocal.protobuf.byv;
import com.tencent.mm.protocal.protobuf.byw;
import com.tencent.mm.sdk.platformtools.ab;

public final class w
  extends m
  implements k
{
  private com.tencent.mm.ai.f eGj;
  public com.tencent.mm.ai.b lFp;
  String lFy;
  
  public w(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(19347);
    this.lFp = null;
    this.eGj = null;
    ab.i("MicroMsg.exdevice.NetSceneSendHardDeviceMsg", "NetSceneSendHardDeviceMsg deviceType = %s, deviceId = %s, sessionId = %d, createTime = %d, data length = %d, msgType = %d", new Object[] { paramString1, paramString2, Long.valueOf(paramLong2), Long.valueOf(paramLong3), Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt) });
    this.lFy = paramString2;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new byv();
    ((b.a)localObject).fsY = new byw();
    ((b.a)localObject).funcId = 538;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendharddevicemsg";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.lFp = ((b.a)localObject).ado();
    localObject = (byv)this.lFp.fsV.fta;
    auh localauh = new auh();
    localauh.wsq = paramString1;
    localauh.jJD = paramString2;
    ((byv)localObject).wvw = localauh;
    paramString1 = new aul();
    paramString1.xjA = paramLong2;
    paramString1.CreateTime = ((int)paramLong3);
    paramString1.wtq = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    paramString1.jKs = paramInt;
    ((byv)localObject).xLc = paramString1;
    if (paramLong1 != 0L)
    {
      ((byv)localObject).xjv = new SKBuiltinBuffer_t().setBuffer(u.bqz().q(paramLong1, 2));
      AppMethodBeat.o(19347);
      return;
    }
    paramString1 = ad.bpY().LI(paramString2);
    if (paramString1 != null) {
      ((byv)localObject).xjv = new SKBuiltinBuffer_t().setBuffer(paramString1.field_sessionBuf);
    }
    AppMethodBeat.o(19347);
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(19349);
    this.eGj = paramf;
    int i = dispatch(parame, this.lFp, this);
    AppMethodBeat.o(19349);
    return i;
  }
  
  public final int getType()
  {
    return 538;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19348);
    ab.i("MicroMsg.exdevice.NetSceneSendHardDeviceMsg", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(19348);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.w
 * JD-Core Version:    0.7.0.1
 */