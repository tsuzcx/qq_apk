package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.mp;
import com.tencent.mm.protocal.c.mq;
import com.tencent.mm.sdk.platformtools.y;

public final class j
  extends m
  implements k
{
  private f dmL;
  private b eWr;
  public mq iHn;
  
  public j()
  {
    b.a locala = new b.a();
    locala.ecH = new mp();
    locala.ecI = new mq();
    locala.ecG = 1256;
    locala.uri = "/cgi-bin/mmpay-bin/f2fannounce";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.eWr = locala.Kt();
    y.d("MicroMsg.NetSceneF2fAnnouce", "do cgi");
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.eWr, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneF2fAnnouce", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.iHn = ((mq)((b)paramq).ecF.ecN);
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1256;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.b.j
 * JD-Core Version:    0.7.0.1
 */