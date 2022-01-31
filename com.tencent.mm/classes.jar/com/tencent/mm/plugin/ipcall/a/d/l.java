package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.protocal.c.bge;
import com.tencent.mm.protocal.c.bgf;
import com.tencent.mm.sdk.platformtools.y;

public final class l
  extends m
  implements k
{
  private com.tencent.mm.ah.b dmK = null;
  private f dmL;
  private bge lrL = null;
  private bgf lrM = null;
  
  public l(int paramInt, long paramLong, boolean paramBoolean)
  {
    Object localObject1 = new b.a();
    ((b.a)localObject1).ecH = new bge();
    ((b.a)localObject1).ecI = new bgf();
    ((b.a)localObject1).ecG = 227;
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/pstnreport";
    ((b.a)localObject1).ecJ = 0;
    ((b.a)localObject1).ecK = 0;
    this.dmK = ((b.a)localObject1).Kt();
    this.lrL = ((bge)this.dmK.ecE.ecN);
    this.lrL.sST = paramInt;
    this.lrL.tAE = paramLong;
    localObject1 = this.lrL;
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      ((bge)localObject1).tAX = paramInt;
      y.d("MicroMsg.NetSceneIPCallReport", "NetSceneIPCallReport, roomId: %d, callseq: %d, gotAnswer: %d", new Object[] { Integer.valueOf(this.lrL.sST), Long.valueOf(this.lrL.tAE), Integer.valueOf(this.lrL.tAX) });
      localObject1 = this.lrL;
      Object localObject2 = i.bci();
      localObject2 = ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).lpD + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).lpE + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).lqX + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).fjn + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).lqY + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).lqN + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).lqO + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).lqP + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).lqQ + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).lqR + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).lqS + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).lqT + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).lqU + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).lqV + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).lqW + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).lqZ + "," + c.bdq() + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).lri + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).countryCode + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).lrj + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).lrk + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).lrl + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).lrg + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).lrn;
      y.i("MicroMsg.IPCallReportHelper", "getPstnClientReportString, result: %s", new Object[] { localObject2 });
      ((bge)localObject1).tAU = aa.pj((String)localObject2);
      localObject1 = this.lrL;
      localObject2 = i.bci();
      localObject2 = ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).lpD + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).lpE + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).lqX + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).lrf;
      y.i("MicroMsg.IPCallReportHelper", "getPstnChannelReportString, result: %s", new Object[] { localObject2 });
      ((bge)localObject1).tAV = aa.pj((String)localObject2);
      localObject1 = this.lrL;
      localObject2 = i.bci();
      localObject2 = ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).lpD + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).lpE + "," + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).lqX + ((com.tencent.mm.plugin.ipcall.a.c.b)localObject2).lre;
      y.i("MicroMsg.IPCallReportHelper", "getPstnEngineReport, result: %s", new Object[] { localObject2 });
      ((bge)localObject1).tAW = aa.pj((String)localObject2);
      return;
    }
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneIPCallReport", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.lrM = ((bgf)((com.tencent.mm.ah.b)paramq).ecF.ecN);
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 227;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.d.l
 * JD-Core Version:    0.7.0.1
 */