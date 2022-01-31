package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ah.m.a;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ayt;
import com.tencent.mm.protocal.c.bkd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class o
  extends p
  implements k, e
{
  private final q edR = new f();
  private boolean jMT = false;
  private String jMY = "";
  
  public o(long paramLong, String paramString1, String paramString2)
  {
    j.a locala = (j.a)this.edR.Kv();
    locala.jMI.tbj = p.jMZ;
    locala.jMI.tbl = paramLong;
    locala.jMI.tDR = paramString1;
    locala.jMI.tDS = paramString2;
  }
  
  final void Cl(String paramString)
  {
    ((j.a)this.edR.Kv()).jMI.tbj = paramString;
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
    y.d("MicroMsg.NetSceneFaceRegFaceRsa", "hy: onGYNetEnd  errType:" + paramInt1 + " errCode:" + paramInt2);
    paramq = (j.b)paramq.HF();
    boolean bool1;
    int i;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (paramq.jMJ.tDU == 0)
      {
        bool1 = true;
        this.jMT = bool1;
        this.jMY = paramq.jMJ.tDT;
        i = paramq.jMJ.tDU;
        boolean bool3 = this.jMT;
        paramInt2 = paramq.jMJ.tDU;
        if (bk.bl(this.jMY)) {
          break label179;
        }
        bool1 = bool2;
        label124:
        y.i("MicroMsg.NetSceneFaceRegFaceRsa", "hy: is verify ok: %b, youtuRet; %d, has random pwd: %b", new Object[] { Boolean.valueOf(bool3), Integer.valueOf(paramInt2), Boolean.valueOf(bool1) });
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
      break label124;
      i = paramInt2;
      if (paramq != null)
      {
        i = paramInt2;
        if (paramq.jMJ != null)
        {
          i = paramInt2;
          if (paramq.jMJ.tDU != 0)
          {
            y.i("MicroMsg.NetSceneFaceRegFaceRsa", "hy: has detail ret. use");
            i = paramq.jMJ.tDU;
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
    return ((j.b)paramq.HF()).jMJ.tbn;
  }
  
  public final int getType()
  {
    return 930;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.o
 * JD-Core Version:    0.7.0.1
 */