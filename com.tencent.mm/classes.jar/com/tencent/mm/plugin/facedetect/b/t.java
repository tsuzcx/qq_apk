package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m.a;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ayt;
import com.tencent.mm.protocal.c.ccp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class t
  extends p
  implements k, e
{
  private final q edR = new g();
  private boolean jMT = false;
  private String jMY = "";
  
  public t(long paramLong, String paramString1, String paramString2)
  {
    k.a locala = (k.a)this.edR.Kv();
    locala.jMK.tbj = p.jMZ;
    locala.jMK.tbl = paramLong;
    locala.jMK.tDS = paramString2;
    locala.jMK.tDR = paramString1;
  }
  
  final void Cl(String paramString)
  {
    ((k.a)this.edR.Kv()).jMK.tbj = paramString;
  }
  
  protected final int Ka()
  {
    return 3;
  }
  
  protected final void a(m.a parama) {}
  
  public final boolean aNV()
  {
    return true;
  }
  
  public final String aNW()
  {
    return this.jMY;
  }
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    boolean bool2 = true;
    y.d("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: onGYNetEnd  errType:" + paramInt1 + " errCode:" + paramInt2);
    paramq = (k.b)paramq.HF();
    boolean bool1;
    label114:
    int i;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (paramq.jML.tDU == 0)
      {
        bool1 = true;
        this.jMT = bool1;
        this.jMY = paramq.jML.tDT;
        boolean bool3 = this.jMT;
        paramInt2 = paramq.jML.tDU;
        if (bk.bl(this.jMY)) {
          break label179;
        }
        bool1 = bool2;
        y.i("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: is verify ok: %b, youtuRet: %d, has random pwd: %b", new Object[] { Boolean.valueOf(bool3), Integer.valueOf(paramInt2), Boolean.valueOf(bool1) });
        i = paramq.jML.tDU;
      }
    }
    for (;;)
    {
      this.dmL.onSceneEnd(paramInt1, i, paramString, this);
      return;
      bool1 = false;
      break;
      label179:
      bool1 = false;
      break label114;
      i = paramInt2;
      if (paramq != null)
      {
        i = paramInt2;
        if (paramq.jML != null)
        {
          i = paramInt2;
          if (paramq.jML.tDU != 0)
          {
            y.i("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: has detail ret. use");
            i = paramq.jML.tDU;
          }
        }
      }
    }
  }
  
  final int g(com.tencent.mm.network.e parame)
  {
    this.edR.Kv();
    return a(parame, this.edR, this);
  }
  
  protected final ayt g(q paramq)
  {
    return ((k.b)paramq.HF()).jML.tbn;
  }
  
  public final int getType()
  {
    return 930;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.t
 * JD-Core Version:    0.7.0.1
 */