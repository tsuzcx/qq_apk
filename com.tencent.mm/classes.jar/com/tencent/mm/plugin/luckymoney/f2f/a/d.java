package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.mm.ah.b;
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
import com.tencent.mm.protocal.c.xf;
import com.tencent.mm.protocal.c.xg;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.g;

public final class d
  extends m
  implements k, g
{
  public String bMX;
  private f dmL;
  private b eWr;
  public String lMg;
  private xf lNu;
  private xg lNv;
  public String lNw;
  
  public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new xf();
    ((b.a)localObject).ecI = new xg();
    ((b.a)localObject).ecG = 1970;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/ftfhb/ffrequestwxhb";
    this.eWr = ((b.a)localObject).Kt();
    this.lNu = ((xf)this.eWr.ecE.ecN);
    this.lNu.iHi = paramInt1;
    this.lNu.mUh = paramInt2;
    this.lNu.lPR = paramInt3;
    this.lNu.sTR = paramInt4;
    localObject = i.bVj();
    if (localObject != null)
    {
      this.lNu.latitude = ((aw)localObject).latitude;
      this.lNu.longitude = ((aw)localObject).longitude;
    }
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.eWr, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("NetSceneF2FLuckyMoneyPrepare", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.lNv = ((xg)((b)paramq).ecF.ecN);
    this.bMX = this.lNv.lRA;
    this.lMg = this.lNv.lMg;
    this.lNw = this.lNv.lRH;
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1970;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.d
 * JD-Core Version:    0.7.0.1
 */