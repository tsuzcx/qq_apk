package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.a;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.akv;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.x;

public final class ad
  extends m
  implements k
{
  f dmL = null;
  public final q edR = new ad.a();
  
  public ad(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    t.a locala = (t.a)this.edR.Kv();
    locala.fgc.tgR = paramString1;
    locala.fgc.tgS = paramString2;
    locala.fgc.hRf = paramString3;
    locala.fgc.tgT = paramString4;
    locala.fgc.tgU = paramString5;
    locala.fgc.tgV = paramString6;
    locala.fgc.tgW = paramInt;
    locala.fgc.jxi = x.cqJ();
    paramString1 = locala.fgc;
    g.DN();
    paramString1.syH = a.Df();
  }
  
  protected final int Ka()
  {
    return 3;
  }
  
  public final byte[] QA()
  {
    return aa.a(((t.b)this.edR.HF()).fgd.tgX, new byte[0]);
  }
  
  public final String Qz()
  {
    return ((t.b)this.edR.HF()).fgd.tgU;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.edR, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 == 4) && (paramInt3 == -102))
    {
      paramInt1 = paramq.Kv().spM.ver;
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneGetSuggestAlias", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      g.DS().O(new ad.1(this, paramInt1));
      return;
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  protected final void a(m.a parama) {}
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 429;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ad
 * JD-Core Version:    0.7.0.1
 */