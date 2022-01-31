package com.tencent.mm.plugin.brandservice.b;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bnx;
import com.tencent.mm.protocal.c.bny;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class i
  extends m
  implements k
{
  private String bGm;
  private f dmL;
  private com.tencent.mm.ah.b icb;
  private long icd;
  public bny ice;
  private int scene;
  
  public i(String paramString, long paramLong, int paramInt)
  {
    this.bGm = paramString;
    this.icd = paramLong;
    this.scene = paramInt;
    y.i("MicroMsg.NetSceneSearchHomePageNew", "Constructors: keyword (%s) , businessType (%d), scene (%d)", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
  }
  
  public final int a(e parame, f paramf)
  {
    y.i("MicroMsg.NetSceneSearchHomePageNew", "doScene");
    this.dmL = paramf;
    if (!bk.bl(this.bGm))
    {
      paramf = new b.a();
      paramf.ecG = 1070;
      paramf.uri = "/cgi-bin/mmbiz-bin/bizsearch/homepage";
      paramf.ecH = new bnx();
      paramf.ecI = new bny();
      paramf.ecJ = 0;
      paramf.ecK = 0;
      this.icb = paramf.Kt();
      paramf = (bnx)this.icb.ecE.ecN;
      paramf.tcJ = this.bGm;
      paramf.tqT = b.Jx();
      paramf.sFC = this.icd;
      paramf.tGx = this.scene;
      y.i("MicroMsg.NetSceneSearchHomePageNew", "businessTypeList is %d", new Object[] { Long.valueOf(this.icd) });
      return a(parame, this.icb, this);
    }
    y.e("MicroMsg.NetSceneSearchHomePageNew", "keyword is unavailable");
    return -1;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneSearchHomePageNew", "netId (%d) , errType (%d) , errCode (%d) , errMsg (%s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (this.icb != null)) {
      this.ice = ((bny)this.icb.ecF.ecN);
    }
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1070;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.i
 * JD-Core Version:    0.7.0.1
 */