package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.cco;
import com.tencent.mm.protocal.c.ccp;
import com.tencent.mm.sdk.platformtools.y;

public final class s
  extends m
  implements k, e
{
  private b dmK;
  private f dmL;
  private boolean jMT = false;
  
  public s(long paramLong, String paramString1, String paramString2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new cco();
    ((b.a)localObject).ecI = new ccp();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyface";
    ((b.a)localObject).ecG = 797;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (cco)this.dmK.ecE.ecN;
    ((cco)localObject).tbl = paramLong;
    ((cco)localObject).tDR = paramString1;
    ((cco)localObject).tDS = paramString2;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramq = (ccp)((b)paramq).ecF.ecN;
    boolean bool;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      if (paramq.tDU == 0)
      {
        bool = true;
        this.jMT = bool;
        paramInt1 = paramq.tDU;
        y.i("MicroMsg.NetSceneFaceVerifyFace", "hy: is Verified: %b", new Object[] { Boolean.valueOf(this.jMT) });
      }
    }
    for (;;)
    {
      if (this.dmL != null) {
        this.dmL.onSceneEnd(paramInt2, paramInt1, paramString, this);
      }
      return;
      bool = false;
      break;
      paramInt1 = paramInt3;
      if (paramq != null)
      {
        paramInt1 = paramInt3;
        if (paramq.tDU != 0)
        {
          y.i("MicroMsg.NetSceneFaceVerifyFace", "hy: has DetailRet, use it");
          paramInt1 = paramq.tDU;
        }
      }
    }
  }
  
  public final boolean aNV()
  {
    return true;
  }
  
  public final String aNW()
  {
    return null;
  }
  
  public final int getType()
  {
    return 797;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.s
 * JD-Core Version:    0.7.0.1
 */