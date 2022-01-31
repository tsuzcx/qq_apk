package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bft;
import com.tencent.mm.protocal.c.bfu;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends m
  implements k
{
  private b dmK = null;
  private f dmL = null;
  public bft lro = null;
  private bfu lrp = null;
  
  public a(int paramInt1, long paramLong1, String paramString1, String paramString2, int paramInt2, long paramLong2)
  {
    b.a locala = new b.a();
    locala.ecH = new bft();
    locala.ecI = new bfu();
    locala.ecG = 843;
    locala.uri = "/cgi-bin/micromsg-bin/pstncancelinvite";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    long l = System.currentTimeMillis();
    this.lro = ((bft)this.dmK.ecE.ecN);
    this.lro.sST = paramInt1;
    this.lro.sSU = paramLong1;
    this.lro.kWm = paramString1;
    this.lro.tAB = l;
    this.lro.tAC = paramInt2;
    this.lro.tAD = paramString2;
    this.lro.tAE = paramLong2;
    y.d("MicroMsg.NetSceneIPCallCancel", "roomId: %d, roomKey: %d, toUsername: %s, timestamp: %d, inviteId: %d, phoneNumber: %s, callseq: %d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), paramString1, Long.valueOf(l), Integer.valueOf(paramInt2), paramString2, Long.valueOf(paramLong2) });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneIPCallCancel", "errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.lrp = ((bfu)((b)paramq).ecF.ecN);
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 843;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.d.a
 * JD-Core Version:    0.7.0.1
 */