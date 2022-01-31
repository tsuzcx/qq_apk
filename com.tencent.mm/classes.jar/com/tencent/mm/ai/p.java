package com.tencent.mm.ai;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.il;
import com.tencent.mm.protocal.c.im;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class p
  extends m
  implements k
{
  private String djD;
  com.tencent.mm.ah.b dmK;
  private f dmL;
  private p.a<p> egJ;
  
  private p(String paramString1, String paramString2)
  {
    this.djD = paramString1;
    y.i("MicroMsg.NetSceneBizAttrSync", "[BizAttr] NetSceneBizAttrSync (%s)", new Object[] { paramString1 });
    paramString1 = new b.a();
    paramString1.ecG = 1075;
    paramString1.uri = "/cgi-bin/mmbiz-bin/bizattr/bizattrsync";
    paramString1.ecH = new il();
    paramString1.ecI = new im();
    paramString1.ecJ = 0;
    paramString1.ecK = 0;
    this.dmK = paramString1.Kt();
    paramString1 = (il)this.dmK.ecE.ecN;
    paramString1.sCE = this.djD;
    paramString1.sCF = new com.tencent.mm.bv.b(bk.ZM(bk.pm(paramString2)));
  }
  
  public p(String paramString1, String paramString2, p.a<p> parama)
  {
    this(paramString1, paramString2);
    this.egJ = parama;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneBizAttrSync", "[BizAttr] onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.egJ != null) {
      this.egJ.a(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1075;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ai.p
 * JD-Core Version:    0.7.0.1
 */