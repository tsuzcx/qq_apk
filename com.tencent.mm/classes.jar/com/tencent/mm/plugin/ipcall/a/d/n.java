package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.bgg;
import com.tencent.mm.protocal.c.bgh;
import com.tencent.mm.sdk.platformtools.y;

public final class n
  extends m
  implements k
{
  private b dmK = null;
  private f dmL = null;
  public bgg lrP = null;
  private bgh lrQ = null;
  
  public n(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    b.a locala = new b.a();
    locala.ecH = new bgg();
    locala.ecI = new bgh();
    locala.ecG = 723;
    locala.uri = "/cgi-bin/micromsg-bin/pstnshutdown";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    long l = System.currentTimeMillis();
    this.lrP = ((bgg)this.dmK.ecE.ecN);
    this.lrP.kWn = com.tencent.mm.model.q.Gj();
    this.lrP.sST = paramInt1;
    this.lrP.sSU = paramLong1;
    this.lrP.tAE = paramLong2;
    this.lrP.hQq = paramInt2;
    this.lrP.tAB = l;
    y.i("MicroMsg.NetSceneIPCallShutDown", "roomId: %d, roomKey: %d, callSeq: %d, status: %d, timestamp: %d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Long.valueOf(l) });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneIPCallShutDown", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.lrQ = ((bgh)((b)paramq).ecF.ecN);
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 723;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.d.n
 * JD-Core Version:    0.7.0.1
 */