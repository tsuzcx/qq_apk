package com.tencent.mm.plugin.location.model;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ahf;
import com.tencent.mm.protocal.c.ahg;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class g
  extends m
  implements k
{
  public final com.tencent.mm.ah.b dmK;
  private f dmL;
  private byte[] lCU;
  String lCV;
  
  public g(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ahf();
    ((b.a)localObject).ecI = new ahg();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getlocimg";
    ((b.a)localObject).ecG = 648;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (ahf)this.dmK.ecE.ecN;
    ((ahf)localObject).jxi = paramString2;
    if (bk.fV(ae.getContext())) {}
    for (((ahf)localObject).teV = 1;; ((ahf)localObject).teV = 0)
    {
      ((ahf)localObject).sGK = paramFloat1;
      ((ahf)localObject).sGJ = paramFloat2;
      ((ahf)localObject).teW = paramInt1;
      y.i("MicroMsg.NetSceneGetLocImg", "src w %d h %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      while (paramInt2 * paramInt3 > 270000)
      {
        paramInt2 = (int)(paramInt2 / 1.2D);
        paramInt3 = (int)(paramInt3 / 1.2D);
      }
    }
    y.i("MicroMsg.NetSceneGetLocImg", "NetSceneGetLocImg %f %f %d w = %d h = %d lan=%s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), ((ahf)localObject).jxi });
    ((ahf)localObject).Height = paramInt3;
    ((ahf)localObject).Width = paramInt2;
    this.lCV = paramString1;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneGetLocImg", "onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramq = (ahg)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    try
    {
      this.lCU = paramq.svJ.tFM.oY;
      com.tencent.mm.vfs.e.b(this.lCV, this.lCU, this.lCU.length);
      if (this.dmL != null) {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      return;
    }
    catch (Exception paramq)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.NetSceneGetLocImg", paramq, "", new Object[0]);
      }
    }
  }
  
  public final int getType()
  {
    return 648;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.g
 * JD-Core Version:    0.7.0.1
 */