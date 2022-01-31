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
import com.tencent.mm.protocal.c.wx;
import com.tencent.mm.protocal.c.wy;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends m
  implements k
{
  private f dmL;
  private b eWr;
  private wx lNg;
  private wy lNh;
  
  public a(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new wx();
    locala.ecI = new wy();
    locala.ecG = 1987;
    locala.ecJ = 0;
    locala.ecK = 0;
    locala.uri = "/cgi-bin/mmpay-bin/ftfhb/ffclearwxhb";
    this.eWr = locala.Kt();
    this.lNg = ((wx)this.eWr.ecE.ecN);
    this.lNg.lMg = paramString;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.eWr, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    this.lNh = ((wy)((b)paramq).ecF.ecN);
    y.i("NetSceneF2FLuckyMoneyClear", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(this.lNh.iHq), this.lNh.iHr });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, this.lNh.iHq, this.lNh.iHr, this);
    }
  }
  
  public final int getType()
  {
    return 1987;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.a
 * JD-Core Version:    0.7.0.1
 */