package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ah.m.a;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.ak.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.ach;
import com.tencent.mm.protocal.c.ayt;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.ih;
import com.tencent.mm.sdk.platformtools.y;

public final class v
  extends p
  implements k, b
{
  private final q edR = new h();
  private long jNe = -1L;
  private byte[] jNf = null;
  
  public v(int paramInt1, int paramInt2)
  {
    i.a locala = (i.a)this.edR.Kv();
    locala.jMG.tbj = p.jMZ;
    locala.jMG.hQR = 1;
    locala.jMG.pyo = paramInt1;
    locala.jMG.tbk = paramInt2;
  }
  
  final void Cl(String paramString)
  {
    ((i.a)this.edR.Kv()).jMG.tbj = paramString;
  }
  
  protected final int Ka()
  {
    return 3;
  }
  
  protected final void a(m.a parama) {}
  
  public final long aNT()
  {
    return this.jNe;
  }
  
  public final byte[] aNU()
  {
    return this.jNf;
  }
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.d("MicroMsg.NetSceneGetBioConfigRsa", "hy: onGYNetEnd  errType:" + paramInt1 + " errCode:" + paramInt2);
    i.b localb;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      localb = (i.b)paramq.HF();
      this.jNe = localb.jMH.tbl;
      if (localb.jMH.tbm != null) {
        this.jNf = localb.jMH.tbm.oY;
      }
      if (localb.jMH.tbo != null)
      {
        if ((localb.jMH.tbo.sCg == null) || (localb.jMH.tbo.sCg.tFK <= 0)) {
          break label383;
        }
        y.i("MicroMsg.NetSceneGetBioConfigRsa", "summersafecdn onGYNetEnd cdnrule:%d", new Object[] { Integer.valueOf(localb.jMH.tbo.sCg.tFK) });
      }
    }
    label383:
    for (paramq = aa.a(localb.jMH.tbo.sCg);; paramq = null)
    {
      if ((localb.jMH.tbo.sCh != null) && (localb.jMH.tbo.sCh.tFK > 0)) {
        y.i("MicroMsg.NetSceneGetBioConfigRsa", "summersafecdn onGYNetEnd safecdnrule:%d", new Object[] { Integer.valueOf(localb.jMH.tbo.sCh.tFK) });
      }
      for (byte[] arrayOfByte = aa.a(localb.jMH.tbo.sCh);; arrayOfByte = null)
      {
        com.tencent.mm.ak.f.Ne().a(localb.jMH.tbo.sCd, localb.jMH.tbo.sCe, localb.jMH.tbo.sCf, paramq, arrayOfByte, localb.jMH.tbo.sCi);
        long l = this.jNe;
        if (this.jNf == null) {}
        for (int i = 0;; i = this.jNf.length)
        {
          y.i("MicroMsg.NetSceneGetBioConfigRsa", "hy: get bio config: bioId: %s, bioConfigSize: %d", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
          this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
          return;
        }
      }
    }
  }
  
  final int g(e parame)
  {
    return a(parame, this.edR, this);
  }
  
  protected final ayt g(q paramq)
  {
    return ((i.b)paramq.HF()).jMH.tbn;
  }
  
  public final int getType()
  {
    return 733;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.v
 * JD-Core Version:    0.7.0.1
 */