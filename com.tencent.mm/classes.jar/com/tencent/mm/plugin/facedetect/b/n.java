package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bkc;
import com.tencent.mm.protocal.c.bkd;
import com.tencent.mm.sdk.platformtools.y;

public final class n
  extends m
  implements k, e
{
  private b dmK;
  private f dmL;
  private boolean jMT = false;
  private String jMX = null;
  
  public n(long paramLong, String paramString1, String paramString2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bkc();
    ((b.a)localObject).ecI = new bkd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/registerface";
    ((b.a)localObject).ecG = 918;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bkc)this.dmK.ecE.ecN;
    ((bkc)localObject).tbl = paramLong;
    ((bkc)localObject).tDR = paramString1;
    ((bkc)localObject).tDS = paramString2;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramq = (bkd)((b)paramq).ecF.ecN;
    boolean bool;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      if (paramq.tDU == 0)
      {
        bool = true;
        this.jMT = bool;
        this.jMX = paramq.tDT;
        paramInt1 = paramq.tDU;
        y.i("MicroMsg.NetSceneFaceRegFace", "hy: is Verified: %b", new Object[] { Boolean.valueOf(this.jMT) });
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
          y.i("MicroMsg.NetSceneFaceRegFace", "hy: has detail ret. use");
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
    return this.jMX;
  }
  
  public final int getType()
  {
    return 918;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.n
 * JD-Core Version:    0.7.0.1
 */