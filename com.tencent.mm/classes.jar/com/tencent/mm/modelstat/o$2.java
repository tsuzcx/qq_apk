package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.brz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class o$2
  implements w.a
{
  o$2(long paramLong1, brz parambrz, String[] paramArrayOfString, float paramFloat1, float paramFloat2, int paramInt, long paramLong2) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.b paramb, m paramm)
  {
    AppMethodBeat.i(78768);
    ab.d("MicroMsg.NetTypeReporter", "onGYNetEnd errType:%d errCode:%d msg:%s  %d val:%s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Long.valueOf(bo.hl(this.fUw)), this.fUx.qsu });
    long l1;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      long l2 = bo.hl(o.access$100());
      if (l2 <= 600000L)
      {
        l1 = l2;
        if (l2 >= 0L) {}
      }
      else
      {
        l1 = 0L;
      }
      paramb = h.qsU;
      paramm = new StringBuilder().append(this.fUy[0]).append("1,").append(this.fNQ).append(",").append(this.fNR).append(",").append(this.fNS).append(",").append(this.fUz).append(",");
      if (!com.tencent.mm.sdk.a.b.foreground) {
        break label265;
      }
    }
    label265:
    for (paramString = "1";; paramString = String.valueOf(l1))
    {
      paramb.kvStat(11747, paramString + "," + this.fUy[1] + "," + this.fUy[2] + "," + this.fUy[3]);
      g.RL().Ru().set(ac.a.yyv, Long.valueOf(bo.aoy()));
      AppMethodBeat.o(78768);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.o.2
 * JD-Core Version:    0.7.0.1
 */