package com.tencent.mm.modelstat;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bjh;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class o$2
  implements w.a
{
  o$2(long paramLong1, bjh parambjh, String[] paramArrayOfString, float paramFloat1, float paramFloat2, int paramInt, long paramLong2) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.b paramb, m paramm)
  {
    y.d("MicroMsg.NetTypeReporter", "onGYNetEnd errType:%d errCode:%d msg:%s  %d val:%s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Long.valueOf(bk.co(this.eEF)), this.eEG.nFs });
    long l1;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      long l2 = bk.co(o.access$100());
      if (l2 <= 600000L)
      {
        l1 = l2;
        if (l2 >= 0L) {}
      }
      else
      {
        l1 = 0L;
      }
      paramb = h.nFQ;
      paramm = new StringBuilder().append(this.eEH[0]).append("1,").append(this.eyb).append(",").append(this.eyc).append(",").append(this.eyd).append(",").append(this.eEI).append(",");
      if (!com.tencent.mm.sdk.a.b.foreground) {
        break label255;
      }
    }
    label255:
    for (paramString = "1";; paramString = String.valueOf(l1))
    {
      paramb.aC(11747, paramString + "," + this.eEH[1] + "," + this.eEH[2] + "," + this.eEH[3]);
      g.DP().Dz().c(ac.a.uoz, Long.valueOf(bk.UY()));
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelstat.o.2
 * JD-Core Version:    0.7.0.1
 */