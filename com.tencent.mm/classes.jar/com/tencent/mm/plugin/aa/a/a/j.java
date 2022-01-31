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
import com.tencent.mm.protocal.c.u;
import com.tencent.mm.protocal.c.v;
import com.tencent.mm.sdk.platformtools.y;

public final class j
  extends m
  implements k
{
  private f dmL;
  private u eWC;
  public v eWD;
  private b eWr;
  
  public j(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    b.a locala = new b.a();
    locala.ecH = new u();
    locala.ecI = new v();
    locala.ecG = 1695;
    locala.uri = "/cgi-bin/mmpay-bin/newaaquerydetail";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.eWr = locala.Kt();
    this.eWC = ((u)this.eWr.ecE.ecN);
    this.eWC.srq = paramString1;
    this.eWC.scene = paramInt1;
    this.eWC.srr = paramString2;
    if (paramInt1 == 5)
    {
      y.i("MicroMsg.NetSceneAAQueryDetail", "set sign and ver");
      this.eWC.sign = paramString3;
      this.eWC.ver = paramInt2;
    }
    y.i("MicroMsg.NetSceneAAQueryDetail", "NetSceneAAQueryDetail, billNo: %s, scene: %s, groupId: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2 });
  }
  
  public final int a(e parame, f paramf)
  {
    y.i("MicroMsg.NetSceneAAQueryDetail", "doScene");
    this.dmL = paramf;
    return a(parame, this.eWr, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneAAQueryDetail", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.eWD = ((v)((b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneAAQueryDetail", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.eWD.iHq), this.eWD.iHr });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1695;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.a.j
 * JD-Core Version:    0.7.0.1
 */