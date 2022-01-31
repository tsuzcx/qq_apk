package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.aw;
import com.tencent.mm.protocal.c.wz;
import com.tencent.mm.protocal.c.xa;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends m
  implements k
{
  private f dmL;
  private com.tencent.mm.ah.b eWr;
  public int iHq;
  public String iHr;
  private wz lNi;
  private xa lNj;
  
  public b(String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    ((b.a)localObject).ecH = new wz();
    ((b.a)localObject).ecI = new xa();
    ((b.a)localObject).ecG = 1971;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/ftfhb/ffwxhbinvalidateshareurl";
    this.eWr = ((b.a)localObject).Kt();
    this.lNi = ((wz)this.eWr.ecE.ecN);
    localObject = i.bVj();
    if (localObject != null)
    {
      this.lNi.latitude = ((aw)localObject).latitude;
      this.lNi.longitude = ((aw)localObject).longitude;
    }
    this.lNi.sTJ = paramString;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.eWr, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i(" NetSceneF2FLuckyMoneyInvalid", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.lNj = ((xa)((com.tencent.mm.ah.b)paramq).ecF.ecN);
    this.iHq = this.lNj.iHq;
    this.iHr = this.lNj.iHr;
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, this.lNj.iHq, this.lNj.iHr, this);
    }
  }
  
  public final int getType()
  {
    return 1971;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.b
 * JD-Core Version:    0.7.0.1
 */