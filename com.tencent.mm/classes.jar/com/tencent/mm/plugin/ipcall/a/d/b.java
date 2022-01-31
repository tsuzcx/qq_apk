package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bfv;
import com.tencent.mm.protocal.c.bfw;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends m
  implements k
{
  private com.tencent.mm.ah.b dmK = null;
  private f dmL;
  private bfv lrq = null;
  public bfw lrr = null;
  
  public b(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    b.a locala = new b.a();
    locala.ecH = new bfv();
    locala.ecI = new bfw();
    locala.ecG = 807;
    locala.uri = "/cgi-bin/micromsg-bin/pstnchecknumber";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.lrq = ((bfv)this.dmK.ecE.ecN);
    this.lrq.tAF = paramString1;
    this.lrq.tAH = paramString2;
    this.lrq.tAJ = paramString3;
    this.lrq.tAI = paramString4;
    this.lrq.tAK = paramInt;
    y.i("MicroMsg.NetSceneIPCallCheckNumber", "NetSceneIPCallCheckNumber pureNumber:%s,lastCountry:%s,osCountry:%s,simCountry:%s,dialScene:%d", new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(paramInt) });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneIPCallCheckNumber", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.lrr = ((bfw)((com.tencent.mm.ah.b)paramq).ecF.ecN);
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 807;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.d.b
 * JD-Core Version:    0.7.0.1
 */