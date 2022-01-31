package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bng;
import com.tencent.mm.protocal.c.bnh;
import com.tencent.mm.sdk.platformtools.y;

public final class t
  extends m
  implements k
{
  private b dmK = null;
  private f dmL = null;
  
  public t(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bng();
    ((b.a)localObject).ecI = new bnh();
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/hardware/searchbleharddevice";
    ((b.a)localObject).ecG = 1706;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bng)this.dmK.ecE.ecN;
    ((bng)localObject).mac = paramString1;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    ((bng)localObject).userName = paramString1;
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    ((bng)localObject).category = paramString1;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.exdevice.NetSceneSearchBLEHardDevice", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final bnh aLH()
  {
    return (bnh)this.dmK.ecF.ecN;
  }
  
  public final int getType()
  {
    return 1706;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.t
 * JD-Core Version:    0.7.0.1
 */