package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.h.c;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.aop;
import com.tencent.mm.protocal.c.aoq;
import com.tencent.mm.protocal.c.hw;
import com.tencent.mm.protocal.c.hx;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class l
  extends m
  implements k
{
  private com.tencent.mm.ah.b dmK = null;
  private com.tencent.mm.ah.f dmL = null;
  
  public l(String paramString, int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new hw();
    ((b.a)localObject).ecI = new hx();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bindharddevice";
    ((b.a)localObject).ecG = 536;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (hw)this.dmK.ecE.ecN;
    ((hw)localObject).sAJ = bk.pm(paramString);
    ((hw)localObject).sBb = bk.g(Integer.valueOf(paramInt));
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.exdevice.NetSceneBindHardDevice", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = aLE();
      y.i("MicroMsg.exdevice.NetSceneBindHardDevice", "hardDevice : DeviceIdServer = %s, DeviceType = %s", new Object[] { paramArrayOfByte.sBc.hQb, paramArrayOfByte.sBc.syI });
      String str1 = paramArrayOfByte.sBd.syp;
      String str2 = paramArrayOfByte.sBd.tkr;
      String str3 = paramArrayOfByte.sBd.sAE;
      String str4 = paramArrayOfByte.sBd.tks;
      paramInt1 = paramArrayOfByte.sBd.tkt;
      if (paramArrayOfByte.svx != 0) {
        break label450;
      }
      paramq = "sync";
      y.i("MicroMsg.exdevice.NetSceneBindHardDevice", "hardDeviceAttr : AuthKey = %s, BrandName = %s, Mac = %s, connProto = %s, ConnStrategy = %s, bindFlag = %s", new Object[] { str1, str2, str3, str4, Integer.valueOf(paramInt1), paramq });
      if (ad.aLL().cR(paramArrayOfByte.sBd.tkr, paramArrayOfByte.sBc.hQb) == null) {
        break label458;
      }
      boolean bool = ad.aLL().cS(paramArrayOfByte.sBc.hQb, paramArrayOfByte.sBd.tkr);
      y.i("MicroMsg.exdevice.NetSceneBindHardDevice", "delete local deviceinfo : %s, ret : %b", new Object[] { paramArrayOfByte.sBd.tkr, Boolean.valueOf(bool) });
      if (!bool) {
        break label499;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      label282:
      paramq = new com.tencent.mm.plugin.exdevice.h.b();
      f.a(paramq, paramArrayOfByte.sBc, paramArrayOfByte.sBd);
      paramq.field_url = "";
      paramArrayOfByte = u.aMm().dT(paramq.field_mac);
      long l;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.bKp == 2))
      {
        y.i("MicroMsg.exdevice.NetSceneBindHardDevice", "before do bind netscene, stop the channel now");
        ad.aLS();
        d.dH(paramq.field_mac);
        paramArrayOfByte = u.aMm();
        l = paramq.field_mac;
        if (paramArrayOfByte.jzb.containsKey(Long.valueOf(l)))
        {
          paramArrayOfByte.jzb.remove(Long.valueOf(l));
          y.i("MicroMsg.exdevice.ExdeviceInfoManager", "remove the device from map : %d", new Object[] { Long.valueOf(l) });
        }
      }
      else
      {
        label422:
        if (paramInt1 == 0) {
          break label487;
        }
        ad.aLL().b(paramq);
      }
      for (;;)
      {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
        label450:
        paramq = "async";
        break;
        label458:
        paramInt1 = 1;
        break label282;
        y.i("MicroMsg.exdevice.ExdeviceInfoManager", "device id not contains in the map : %d", new Object[] { Long.valueOf(l) });
        break label422;
        label487:
        ad.aLL().e(paramq);
      }
      label499:
      paramInt1 = 0;
    }
  }
  
  public final hx aLE()
  {
    if ((this.dmK != null) && (this.dmK.ecF.ecN != null)) {
      return (hx)this.dmK.ecF.ecN;
    }
    return null;
  }
  
  public final int getType()
  {
    return 536;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.l
 * JD-Core Version:    0.7.0.1
 */