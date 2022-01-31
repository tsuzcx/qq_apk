package com.tencent.mm.aq;

import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.openim.b.r;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Queue;

final class c$5
  implements w.a
{
  c$5(c paramc, String paramString) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.b paramb, m paramm)
  {
    if (paramm.getType() != 881) {
      return 0;
    }
    this.emx.ebb = false;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e("MicroMsg.GetContactService", "tryStartNetscene onSceneEnd openImUser errType: %s  errCode: %s username %s will retry/del ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this.emA });
      if (paramInt1 == 4) {
        d.Oo().lU(this.emA);
      }
      this.emx.emv.S(10000L, 10000L);
      this.emx.E(this.emA, false);
      return 0;
    }
    if ((!this.emx.emq.isEmpty()) && (this.emx.emv.crl())) {
      this.emx.emv.S(500L, 500L);
    }
    r.a((aib)paramb.ecF.ecN);
    y.i("MicroMsg.GetContactService", "getopenimcontact onResult %s %s", new Object[] { Boolean.valueOf(d.Oo().lU(this.emA)), this.emA });
    this.emx.E(this.emA, true);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.aq.c.5
 * JD-Core Version:    0.7.0.1
 */