package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.aop;
import com.tencent.mm.protocal.c.aor;
import com.tencent.mm.protocal.c.aos;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.sdk.platformtools.y;

public final class r
  extends com.tencent.mm.ah.m
  implements k
{
  private String bJw;
  private com.tencent.mm.ah.b dmK = null;
  private com.tencent.mm.ah.f dmL = null;
  String jvX;
  
  public r(String paramString1, String paramString2, String paramString3, int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new aor();
    ((b.a)localObject).ecI = new aos();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/harddeviceauth";
    ((b.a)localObject).ecG = 541;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (aor)this.dmK.ecE.ecN;
    aop localaop = new aop();
    localaop.syI = paramString2;
    localaop.hQb = paramString3;
    ((aor)localObject).sBc = localaop;
    ((aor)localObject).tkC = paramInt;
    ((aor)localObject).tkD = new bmk().bs(paramArrayOfByte);
    this.jvX = paramString3;
    this.bJw = paramString1;
  }
  
  private byte[] Dj()
  {
    Object localObject = (aos)this.dmK.ecF.ecN;
    try
    {
      localObject = ((aos)localObject).syh.tFM.oY;
      return localObject;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", localException, "", new Object[0]);
    }
    return null;
  }
  
  private byte[] aLG()
  {
    Object localObject = (aos)this.dmK.ecF.ecN;
    try
    {
      localObject = ((aos)localObject).tkE.tFM.oY;
      return localObject;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", localException, "", new Object[0]);
    }
    return null;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.exdevice.NetSceneHardDeviceAuth", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    paramq = ad.aLL().BG(this.jvX);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Object localObject = (aos)this.dmK.ecF.ecN;
      if (paramq != null)
      {
        paramArrayOfByte = aLF();
        if (paramArrayOfByte != null) {
          paramq.field_authBuf = paramArrayOfByte;
        }
        paramq.cMQ = ((aos)localObject).tkH;
        paramq.cyX = true;
        paramq.cMP = ((aos)localObject).tkG;
        paramq.cyX = true;
        localObject = Dj();
        if (localObject != null)
        {
          u.aMm().b(paramq.field_mac, (byte[])localObject, 2);
          if (u.aMn().jtr != null) {
            u.aMn().jtr.setChannelSessionKey(paramq.field_mac, (byte[])localObject);
          }
          paramq.field_sessionKey = ((byte[])localObject);
        }
        localObject = aLG();
        if (localObject != null)
        {
          u.aMm().b(paramq.field_mac, (byte[])localObject, 3);
          paramq.field_sessionBuf = ((byte[])localObject);
        }
        localObject = aLF();
        if (paramArrayOfByte != null)
        {
          u.aMm().b(paramq.field_mac, (byte[])localObject, 1);
          paramq.field_authBuf = paramArrayOfByte;
        }
        paramq.cMR = (System.currentTimeMillis() / 1000L);
        paramq.cyX = true;
        if (2 == u.aMm().dS(paramq.field_mac))
        {
          ad.aLW();
          e.c(this.bJw, paramq.field_url, 2, paramq.field_deviceID);
        }
        u.aMm().dV(paramq.field_mac);
        y.i("MicroMsg.exdevice.NetSceneHardDeviceAuth", "update local device auth infos = %b", new Object[] { Boolean.valueOf(ad.aLL().c(paramq, new String[0])) });
      }
    }
    for (;;)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      y.e("MicroMsg.exdevice.NetSceneHardDeviceAuth", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceIdServer == null");
      continue;
      if (paramq != null)
      {
        u.aMm().dW(paramq.field_mac);
        ad.aLW();
        e.c(this.bJw, paramq.field_url, 4, paramq.field_deviceID);
      }
      ad.aLW();
      e.by(this.bJw, 3);
    }
  }
  
  public final byte[] aLF()
  {
    Object localObject = (aos)this.dmK.ecF.ecN;
    try
    {
      localObject = ((aos)localObject).tkF.tFM.oY;
      return localObject;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", localException, "", new Object[0]);
    }
    return null;
  }
  
  public final int getType()
  {
    return 541;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.r
 * JD-Core Version:    0.7.0.1
 */