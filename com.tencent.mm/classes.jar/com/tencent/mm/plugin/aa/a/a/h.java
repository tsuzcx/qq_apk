package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.l;
import com.tencent.mm.sdk.platformtools.y;

public final class h
  extends com.tencent.mm.ah.m
  implements k
{
  private f dmL;
  private b eWr;
  private l eWy;
  public com.tencent.mm.protocal.c.m eWz;
  
  public h()
  {
    b.a locala = new b.a();
    locala.ecH = new l();
    locala.ecI = new com.tencent.mm.protocal.c.m();
    locala.ecG = 1698;
    locala.uri = "/cgi-bin/mmpay-bin/newaaoperation";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.eWr = locala.Kt();
    this.eWy = ((l)this.eWr.ecE.ecN);
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.eWr, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneAAOperation", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.eWz = ((com.tencent.mm.protocal.c.m)((b)paramq).ecF.ecN);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      y.i("MicroMsg.NetSceneAAOperation", "retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s", new Object[] { Integer.valueOf(this.eWz.iHq), this.eWz.iHr, Integer.valueOf(this.eWz.srE), Integer.valueOf(this.eWz.srF), Integer.valueOf(this.eWz.srG), Long.valueOf(this.eWz.srH), Long.valueOf(this.eWz.srI), this.eWz.iHC, this.eWz.iHD });
    }
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1698;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.a.h
 * JD-Core Version:    0.7.0.1
 */