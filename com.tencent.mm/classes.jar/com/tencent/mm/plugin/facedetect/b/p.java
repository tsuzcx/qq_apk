package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.apl;
import com.tencent.mm.protocal.c.ays;
import com.tencent.mm.protocal.c.ayt;
import com.tencent.mm.protocal.c.jv;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;

public abstract class p
  extends n
  implements k
{
  static String jMZ = null;
  protected f dmL = null;
  
  public static void Cm(String paramString)
  {
    jMZ = paramString;
  }
  
  protected static String NJ()
  {
    return jMZ;
  }
  
  abstract void Cl(String paramString);
  
  public final void KD()
  {
    if (this.dmL != null) {
      this.dmL.onSceneEnd(3, -1, "", this);
    }
  }
  
  public final f KE()
  {
    return this.dmL;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    if (!bk.bl(jMZ))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneFaceRsaBase", "hy: has ticket: %s", new Object[] { jMZ });
      Cl(jMZ);
      return g(parame);
    }
    return getType();
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneFaceRsaBase", "hy: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 4) && (paramInt2 == -102))
    {
      paramInt1 = paramq.Kv().spM.ver;
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneFaceRsaBase", "hy: summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      g.DS().O(new p.1(this, paramInt1));
      return;
    }
    c(paramInt1, paramInt2, paramString, paramq);
  }
  
  public final jv c(q paramq)
  {
    paramq = g(paramq);
    if (paramq != null) {
      return paramq.sBE;
    }
    return null;
  }
  
  abstract void c(int paramInt1, int paramInt2, String paramString, q paramq);
  
  public final ays d(q paramq)
  {
    paramq = g(paramq);
    if (paramq != null) {
      return paramq.sBF;
    }
    return null;
  }
  
  public final apl e(q paramq)
  {
    paramq = g(paramq);
    if (paramq != null) {
      return paramq.sBD;
    }
    return null;
  }
  
  abstract int g(e parame);
  
  protected abstract ayt g(q paramq);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.p
 * JD-Core Version:    0.7.0.1
 */