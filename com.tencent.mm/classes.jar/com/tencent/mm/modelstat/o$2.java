package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

final class o$2
  implements x.a
{
  o$2(long paramLong1, cmf paramcmf, String[] paramArrayOfString, float paramFloat1, float paramFloat2, int paramInt, long paramLong2) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb, n paramn)
  {
    AppMethodBeat.i(151111);
    ac.d("MicroMsg.NetTypeReporter", "onGYNetEnd errType:%d errCode:%d msg:%s  %d val:%s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Long.valueOf(bs.Ap(this.hXG)), this.hXH.wTM });
    long l1;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      long l2 = bs.Ap(o.access$100());
      if (l2 <= 600000L)
      {
        l1 = l2;
        if (l2 >= 0L) {}
      }
      else
      {
        l1 = 0L;
      }
      paramb = h.wUl;
      paramn = new StringBuilder().append(this.hXI[0]).append("1,").append(this.hRo).append(",").append(this.hRp).append(",").append(this.hRq).append(",").append(this.hXJ).append(",");
      if (!com.tencent.mm.sdk.a.b.foreground) {
        break label265;
      }
    }
    label265:
    for (paramString = "1";; paramString = String.valueOf(l1))
    {
      paramb.kvStat(11747, paramString + "," + this.hXI[1] + "," + this.hXI[2] + "," + this.hXI[3]);
      g.agR().agA().set(ah.a.GEE, Long.valueOf(bs.eWj()));
      AppMethodBeat.o(151111);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelstat.o.2
 * JD-Core Version:    0.7.0.1
 */