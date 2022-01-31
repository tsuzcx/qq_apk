package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.bgi;
import com.tencent.mm.protocal.c.bgj;
import com.tencent.mm.sdk.platformtools.y;

public final class o
  extends m
  implements k
{
  private b dmK = null;
  private f dmL;
  public bgi lrR = null;
  public bgj lrS = null;
  
  public o(int paramInt1, long paramLong1, int paramInt2, long paramLong2, boolean paramBoolean)
  {
    b.a locala = new b.a();
    locala.ecH = new bgi();
    locala.ecI = new bgj();
    locala.ecG = 819;
    locala.uri = "/cgi-bin/micromsg-bin/pstnsync";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    long l = System.currentTimeMillis();
    this.lrR = ((bgi)this.dmK.ecE.ecN);
    this.lrR.tAY = com.tencent.mm.model.q.Gj();
    this.lrR.sST = paramInt1;
    this.lrR.sSU = paramLong1;
    this.lrR.tAB = l;
    this.lrR.tAZ = paramInt2;
    this.lrR.tAE = paramLong2;
    if (!paramBoolean) {}
    for (this.lrR.tBa = 0;; this.lrR.tBa = 1)
    {
      y.i("MicroMsg.NetSceneIPCallSync", "roomId: %d, roomKey: %d, syncKey: %d, callSeq: %d,dataFlag: %d, timestamp: %d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Long.valueOf(paramLong2), Integer.valueOf(this.lrR.tBa), Long.valueOf(l) });
      return;
    }
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneIPCallSync", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.lrS = ((bgj)((b)paramq).ecF.ecN);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 819;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.d.o
 * JD-Core Version:    0.7.0.1
 */