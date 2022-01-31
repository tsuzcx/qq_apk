package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.aw;
import com.tencent.mm.protocal.c.xd;
import com.tencent.mm.protocal.c.xe;
import com.tencent.mm.sdk.platformtools.y;

public final class e
  extends m
  implements k
{
  private f dmL;
  private b eWr;
  public String jxR;
  public String lMg;
  public String lNA;
  public int lNB;
  private xd lNx;
  private xe lNy;
  public String lNz;
  
  public e()
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new xd();
    ((b.a)localObject).ecI = new xe();
    ((b.a)localObject).ecG = 1990;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/ftfhb/ffquerydowxhb";
    this.eWr = ((b.a)localObject).Kt();
    this.lNx = ((xd)this.eWr.ecE.ecN);
    this.lNx.timestamp = (System.currentTimeMillis() / 1000L);
    localObject = i.bVj();
    if (localObject != null)
    {
      this.lNx.latitude = ((aw)localObject).latitude;
      this.lNx.longitude = ((aw)localObject).longitude;
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.eWr, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("NetSceneF2FLuckyMoneyQuery", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.lNy = ((xe)((b)paramq).ecF.ecN);
    this.lMg = this.lNy.lMg;
    this.jxR = this.lNy.jxR;
    this.lNB = this.lNy.sTQ;
    this.lNz = this.lNy.lNz;
    this.lNA = this.lNy.lNA;
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, this.lNy.iHq, this.lNy.iHr, this);
    }
  }
  
  public final int getType()
  {
    return 1990;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.e
 * JD-Core Version:    0.7.0.1
 */