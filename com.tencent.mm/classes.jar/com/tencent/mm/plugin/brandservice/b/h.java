package com.tencent.mm.plugin.brandservice.b;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bnn;
import com.tencent.mm.protocal.c.bno;
import com.tencent.mm.protocal.c.kq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class h
  extends m
  implements k
{
  private String bGm;
  private f dmL;
  private String fTF;
  private com.tencent.mm.ah.b icb;
  private bno icc;
  private long icd;
  private int offset;
  private int scene;
  
  public h(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2)
  {
    this.bGm = paramString1;
    this.icd = paramLong;
    this.offset = paramInt1;
    this.scene = paramInt2;
    this.fTF = paramString2;
    y.i("MicroMsg.NetSceneSearchDetailPageNew", "Constructors: keyword = (%s) , LSB exist () , businessType is (%d) , offset is (%d) , scene is (%d), searchId(%s).", new Object[] { paramString1, Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    if (!bk.bl(this.bGm))
    {
      paramf = new b.a();
      paramf.ecG = 1071;
      paramf.uri = "/cgi-bin/mmbiz-bin/bizsearch/detailpage";
      paramf.ecH = new bnn();
      paramf.ecI = new bno();
      paramf.ecJ = 0;
      paramf.ecK = 0;
      this.icb = paramf.Kt();
      paramf = (bnn)this.icb.ecE.ecN;
      paramf.tqT = b.Jx();
      paramf.tcJ = this.bGm;
      paramf.sFC = this.icd;
      paramf.sDT = this.offset;
      paramf.tGx = this.scene;
      paramf.sFF = this.fTF;
      return a(parame, this.icb, this);
    }
    y.e("MicroMsg.NetSceneSearchDetailPageNew", "keyword is unavailable.");
    return -1;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneSearchDetailPageNew", "netId (%d) , errType (%d) , errCode (%d) , errMsg (%s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (this.icb != null)) {
      this.icc = ((bno)this.icb.ecF.ecN);
    }
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final kq axv()
  {
    if (this.icc == null) {
      return null;
    }
    return this.icc.tGz;
  }
  
  public final int getType()
  {
    return 1071;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.h
 * JD-Core Version:    0.7.0.1
 */