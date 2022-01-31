package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bgc;
import com.tencent.mm.protocal.c.bgd;
import com.tencent.mm.sdk.platformtools.y;

public final class k
  extends m
  implements com.tencent.mm.network.k
{
  private b dmK = null;
  private f dmL = null;
  public bgc lrJ = null;
  public bgd lrK = null;
  
  public k(int paramInt, long paramLong1, long paramLong2)
  {
    b.a locala = new b.a();
    locala.ecH = new bgc();
    locala.ecI = new bgd();
    locala.ecG = 726;
    locala.uri = "/cgi-bin/micromsg-bin/pstnredirect";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.lrJ = ((bgc)this.dmK.ecE.ecN);
    this.lrJ.sST = paramInt;
    this.lrJ.sSU = paramLong1;
    this.lrJ.tAE = paramLong2;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneIPCallRedirect", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.lrK = ((bgd)((b)paramq).ecF.ecN);
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 726;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.d.k
 * JD-Core Version:    0.7.0.1
 */