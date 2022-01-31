package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.h.c;
import com.tencent.mm.protocal.c.aop;
import com.tencent.mm.protocal.c.ie;
import com.tencent.mm.protocal.c.if;
import com.tencent.mm.sdk.platformtools.y;

public final class m
  extends com.tencent.mm.ah.m
  implements k
{
  private com.tencent.mm.ah.b dmK;
  private com.tencent.mm.ah.f dmL;
  private String jvS;
  private long jvT;
  private String jvU;
  private long jvV;
  
  public m(long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    this.jvT = paramLong1;
    this.jvU = paramString1;
    this.jvS = paramString2;
    this.jvV = paramLong2;
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    paramf = new b.a();
    paramf.ecH = new ie();
    paramf.ecI = new if();
    paramf.uri = "/cgi-bin/mmoc-bin/hardware/bindunauthdevice";
    paramf.ecG = 1262;
    paramf.ecJ = 0;
    paramf.ecK = 0;
    this.dmK = paramf.Kt();
    paramf = (ie)this.dmK.ecE.ecN;
    paramf.mac = com.tencent.mm.plugin.exdevice.j.b.ef(this.jvT);
    paramf.sBZ = this.jvU;
    paramf.sBY = this.jvS;
    paramf.sCa = this.jvV;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneBindUnauthDevice", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    if localif;
    aop localaop;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      localif = (if)this.dmK.ecF.ecN;
      localaop = localif.sBc;
      paramArrayOfByte = null;
      paramq = null;
      if (localaop != null)
      {
        paramArrayOfByte = localaop.hQb;
        paramq = localaop.syI;
      }
      y.d("MicroMsg.NetSceneBindUnauthDevice", "unauth bind deviceId = %s, deviceType = %s", new Object[] { paramArrayOfByte, paramq });
      if (ad.aLL().cR(paramq, paramArrayOfByte) == null) {
        break label279;
      }
      boolean bool = ad.aLL().cS(paramArrayOfByte, paramq);
      y.i("MicroMsg.NetSceneBindUnauthDevice", "delete local deviceinfo : %s, ret : %b", new Object[] { paramq, Boolean.valueOf(bool) });
      if (!bool) {
        break label296;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      paramq = new com.tencent.mm.plugin.exdevice.h.b();
      paramq.field_connProto = this.jvS;
      paramq.field_connStrategy = 1;
      paramq.field_closeStrategy = 1;
      paramq.field_url = "";
      f.a(paramq, localaop, localif.sBd);
      if (paramq.field_mac == 0L)
      {
        y.d("MicroMsg.NetSceneBindUnauthDevice", "onSceneEnd, mac of hardDeviceAttr is 0 so set a local mac.");
        paramq.field_mac = this.jvT;
      }
      if (paramInt1 != 0) {
        ad.aLL().b(paramq);
      }
      for (;;)
      {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
        label279:
        paramInt1 = 1;
        break;
        ad.aLL().e(paramq);
      }
      label296:
      paramInt1 = 0;
    }
  }
  
  public final int getType()
  {
    return 1262;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.m
 * JD-Core Version:    0.7.0.1
 */