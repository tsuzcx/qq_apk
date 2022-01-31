package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.aop;
import com.tencent.mm.protocal.c.bzk;
import com.tencent.mm.protocal.c.bzl;
import com.tencent.mm.sdk.platformtools.y;

public final class x
  extends com.tencent.mm.ah.m
  implements k
{
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  public aop jwa;
  
  public x(aop paramaop, int paramInt)
  {
    this.jwa = paramaop;
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bzk();
    ((b.a)localObject).ecI = new bzl();
    ((b.a)localObject).ecG = 537;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/unbindharddevice";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bzk)this.dmK.ecE.ecN;
    ((bzk)localObject).sBc = paramaop;
    ((bzk)localObject).svx = paramInt;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.exdevice.NetSceneUnBindHardDevice", "onGYNetEnd netId = %d, errType= %d, errCode = %d , errMsg =%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = i.jvG;
    i.dN(0L);
    paramq = ad.aLL().BG(this.jwa.hQb);
    if (paramq != null)
    {
      if ((u.aMn().jtr != null) && (!u.aMn().jtr.dZ(paramq.field_mac))) {
        y.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "stopChannel Failed!!!");
      }
      if (!ad.aLL().cS(this.jwa.hQb, this.jwa.syI)) {
        y.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "deleteByDeviceId Failed!!!");
      }
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        y.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "scene.getType() = %s", new Object[] { Integer.valueOf(537) });
      }
      if ((this.dmK == null) || (this.dmK.ecF.ecN == null)) {
        break label245;
      }
    }
    label245:
    for (paramq = (bzl)this.dmK.ecF.ecN;; paramq = null)
    {
      if (paramq == null) {
        y.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "UnbindHardDevice resp or req is null");
      }
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      y.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "getByDeviceIdServer Failed!!! DeviceIDServer = %s", new Object[] { this.jwa.hQb });
      break;
    }
  }
  
  public final int getType()
  {
    return 537;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.x
 * JD-Core Version:    0.7.0.1
 */