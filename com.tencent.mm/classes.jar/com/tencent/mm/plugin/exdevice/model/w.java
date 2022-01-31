package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.h.c;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.aop;
import com.tencent.mm.protocal.c.aot;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.protocal.c.boz;
import com.tencent.mm.sdk.platformtools.y;

public final class w
  extends m
  implements k
{
  private com.tencent.mm.ah.f dIJ = null;
  public com.tencent.mm.ah.b jvQ = null;
  String jvZ;
  
  public w(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3, byte[] paramArrayOfByte, int paramInt)
  {
    y.i("MicroMsg.exdevice.NetSceneSendHardDeviceMsg", "NetSceneSendHardDeviceMsg deviceType = %s, deviceId = %s, sessionId = %d, createTime = %d, data length = %d, msgType = %d", new Object[] { paramString1, paramString2, Long.valueOf(paramLong2), Long.valueOf(paramLong3), Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt) });
    this.jvZ = paramString2;
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new boy();
    ((b.a)localObject).ecI = new boz();
    ((b.a)localObject).ecG = 538;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendharddevicemsg";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.jvQ = ((b.a)localObject).Kt();
    localObject = (boy)this.jvQ.ecE.ecN;
    aop localaop = new aop();
    localaop.syI = paramString1;
    localaop.hQb = paramString2;
    ((boy)localObject).sBc = localaop;
    paramString1 = new aot();
    paramString1.tkJ = paramLong2;
    paramString1.mPL = ((int)paramLong3);
    paramString1.szp = new bmk().bs(paramArrayOfByte);
    paramString1.hQR = paramInt;
    ((boy)localObject).tHf = paramString1;
    if (paramLong1 != 0L) {
      ((boy)localObject).tkE = new bmk().bs(u.aMm().l(paramLong1, 2));
    }
    do
    {
      return;
      paramString1 = ad.aLL().BG(paramString2);
    } while (paramString1 == null);
    ((boy)localObject).tkE = new bmk().bs(paramString1.field_sessionBuf);
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dIJ = paramf;
    return a(parame, this.jvQ, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.exdevice.NetSceneSendHardDeviceMsg", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 538;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.w
 * JD-Core Version:    0.7.0.1
 */