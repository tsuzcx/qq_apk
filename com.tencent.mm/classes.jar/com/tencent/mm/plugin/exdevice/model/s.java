package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.h.c;
import com.tencent.mm.protocal.c.aow;
import com.tencent.mm.protocal.c.aox;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.sdk.platformtools.y;

public final class s
  extends m
  implements k
{
  private f dIJ = null;
  private String juL = null;
  private com.tencent.mm.ah.b jvY = null;
  
  public s(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new aow();
    ((b.a)localObject).ecI = new aox();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/device/subscribestatus";
    ((b.a)localObject).ecG = 1090;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.jvY = ((b.a)localObject).Kt();
    localObject = (aow)this.jvY.ecE.ecN;
    ((aow)localObject).sAm = com.tencent.mm.bv.b.Xp(paramString2);
    ((aow)localObject).sAk = com.tencent.mm.bv.b.Xp(paramString3);
    ((aow)localObject).kTS = paramInt;
    this.juL = paramString1;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dIJ = paramf;
    return a(parame, this.jvY, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.exdevice.NetSceneHardDeviceStatusSubscribe", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    ad.aLL().BG(this.juL);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = ((aox)this.jvY.ecF.ecN).tFx;
      paramInt1 = paramq.sze;
      if (paramq.sAn.tFP) {
        paramq = paramq.sAn.tFO;
      }
      y.i("MicroMsg.exdevice.NetSceneHardDeviceStatusSubscribe", "HardDeviceStatusSubResponse: ret=" + paramInt1 + ",msg=" + paramString);
    }
    this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1090;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.s
 * JD-Core Version:    0.7.0.1
 */