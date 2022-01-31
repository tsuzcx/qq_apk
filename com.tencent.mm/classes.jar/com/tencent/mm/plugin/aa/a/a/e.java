package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.d;
import com.tencent.mm.sdk.platformtools.y;

public final class e
  extends m
  implements k
{
  private f dmL;
  private b eWr;
  private d eWs;
  public com.tencent.mm.protocal.c.e eWt;
  public int scene;
  
  public e(String paramString1, int paramInt, String paramString2)
  {
    b.a locala = new b.a();
    locala.ecH = new d();
    locala.ecI = new com.tencent.mm.protocal.c.e();
    locala.ecG = 1530;
    locala.uri = "/cgi-bin/mmpay-bin/newaaclose";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.eWr = locala.Kt();
    this.eWs = ((d)this.eWr.ecE.ecN);
    this.eWs.srr = paramString2;
    this.eWs.srq = paramString1;
    this.eWs.scene = paramInt;
    this.scene = paramInt;
    y.d("MicroMsg.NetSceneAAClose", "NetSceneAAClose, billNo: %s, scene: %s", new Object[] { this.eWs.srq, Integer.valueOf(paramInt) });
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    y.i("MicroMsg.NetSceneAAClose", "doScene");
    this.dmL = paramf;
    return a(parame, this.eWr, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneAAClose", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.eWt = ((com.tencent.mm.protocal.c.e)((b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneAAClose", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.eWt.iHq), this.eWt.iHr });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1530;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.a.e
 * JD-Core Version:    0.7.0.1
 */