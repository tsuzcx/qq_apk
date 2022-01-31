package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.n;
import com.tencent.mm.protocal.c.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.g;

public final class i
  extends m
  implements k, g
{
  private f dmL;
  private n eWA;
  public o eWB;
  private b eWr;
  
  public i(String paramString1, long paramLong, int paramInt, String paramString2)
  {
    b.a locala = new b.a();
    locala.ecH = new n();
    locala.ecI = new o();
    locala.ecG = 1629;
    locala.uri = "/cgi-bin/mmpay-bin/newaapay";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.eWr = locala.Kt();
    this.eWA = ((n)this.eWr.ecE.ecN);
    this.eWA.srq = paramString1;
    this.eWA.srJ = paramLong;
    this.eWA.scene = paramInt;
    this.eWA.srr = paramString2;
    y.i("MicroMsg.NetSceneAAPay", "NetSceneAAPay, bill_no: %s, pay_amount: %s, scene: %s, groupid: %s", new Object[] { this.eWA.srq, Long.valueOf(this.eWA.srJ), Integer.valueOf(this.eWA.scene), this.eWA.srr });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.eWr, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneAAPay", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.eWB = ((o)((b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneAAPay", "retcode: %s, retmsg: %s, paymsgid:%s", new Object[] { Integer.valueOf(this.eWB.iHq), this.eWB.iHr, this.eWB.bWt });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1629;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.a.i
 * JD-Core Version:    0.7.0.1
 */