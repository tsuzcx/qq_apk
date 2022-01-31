package com.tencent.mm.plugin.account.security.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.cac;
import com.tencent.mm.protocal.c.cad;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  extends m
  implements k
{
  public String bJp;
  public String bwK;
  public String deviceName;
  private b dmK;
  private f dmL;
  
  public c(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new cac();
    ((b.a)localObject).ecI = new cad();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/updatesafedevice";
    ((b.a)localObject).ecG = 361;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    this.bwK = paramString1;
    this.deviceName = paramString2;
    this.bJp = paramString3;
    localObject = (cac)this.dmK.ecE.ecN;
    ((cac)localObject).sQz = paramString1;
    ((cac)localObject).kRZ = paramString2;
    ((cac)localObject).syI = paramString3;
  }
  
  public final int a(e parame, f paramf)
  {
    if ((bk.bl(this.bwK)) || (bk.bl(this.deviceName)) || (bk.bl(this.bJp)))
    {
      y.e("MicroMsg.NetscenUpdateSafeDevice", "null device is or device name or device type");
      return -1;
    }
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetscenUpdateSafeDevice", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 361;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.a.c
 * JD-Core Version:    0.7.0.1
 */