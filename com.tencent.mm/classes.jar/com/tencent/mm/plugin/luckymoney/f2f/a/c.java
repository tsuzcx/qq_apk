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
import com.tencent.mm.protocal.c.bjg;
import com.tencent.mm.protocal.c.xb;
import com.tencent.mm.protocal.c.xc;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  extends m
  implements k
{
  public int amount;
  public int bIC;
  public int cec;
  private f dmL;
  private b eWr;
  public String lMg;
  private xb lNk;
  private xc lNl;
  public int lNm;
  public String lNn;
  public bjg lNo;
  public int lNp;
  public String lNq;
  public String lNr;
  public String lNs;
  public int lNt;
  
  public c(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new xb();
    locala.ecI = new xc();
    locala.ecG = 1997;
    locala.ecJ = 0;
    locala.ecK = 0;
    locala.uri = "/cgi-bin/mmpay-bin/ftfhb/ffopenwxhb";
    this.eWr = locala.Kt();
    this.lNk = ((xb)this.eWr.ecE.ecN);
    this.lNk.jxR = paramString;
    paramString = i.bVj();
    if (paramString != null)
    {
      this.lNk.cCB = paramString.cCB;
      this.lNk.cCA = paramString.cCA;
      this.lNk.sTK = paramString.sun;
      this.lNk.sTL = paramString.suo;
      this.lNk.sTM = paramString.sum;
      this.lNk.sTN = paramString.latitude;
      this.lNk.sTO = paramString.longitude;
    }
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.eWr, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    this.lNl = ((xc)((b)paramq).ecF.ecN);
    y.i("NetSceneF2FLuckyMoneyOpen", "errType %d, retCode %d, retMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(this.lNl.iHq), this.lNl.iHr });
    this.lMg = this.lNl.lMg;
    this.cec = this.lNl.cec;
    this.lNm = this.lNl.ced;
    this.bIC = this.lNl.bIC;
    this.lNn = this.lNl.lQp;
    this.amount = this.lNl.amount;
    this.lNo = this.lNl.sTP;
    this.lNp = this.lNl.lNp;
    this.lNq = this.lNl.lNq;
    this.lNr = this.lNl.lNr;
    this.lNs = this.lNl.lNs;
    this.lNt = this.lNl.lNt;
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, this.lNl.iHq, this.lNl.iHr, this);
    }
  }
  
  public final int getType()
  {
    return 1997;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.c
 * JD-Core Version:    0.7.0.1
 */