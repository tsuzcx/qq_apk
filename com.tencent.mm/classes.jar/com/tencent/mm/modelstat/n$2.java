package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.protocal.protobuf.dto;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

final class n$2
  implements aa.a
{
  n$2(long paramLong1, dto paramdto, String[] paramArrayOfString, float paramFloat1, float paramFloat2, int paramInt, long paramLong2) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, d paramd, q paramq)
  {
    AppMethodBeat.i(151111);
    Log.d("MicroMsg.NetTypeReporter", "onGYNetEnd errType:%d errCode:%d msg:%s  %d val:%s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Long.valueOf(Util.milliSecondsToNow(this.mex)), this.mey.Izj });
    long l1;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      long l2 = Util.milliSecondsToNow(n.access$100());
      if (l2 <= 600000L)
      {
        l1 = l2;
        if (l2 >= 0L) {}
      }
      else
      {
        l1 = 0L;
      }
      paramd = com.tencent.mm.plugin.report.service.h.IzE;
      paramq = new StringBuilder().append(this.mez[0]).append("1,").append(this.meA).append(",").append(this.meB).append(",").append(this.meC).append(",").append(this.meD).append(",");
      if (!CrashReportFactory.foreground) {
        break label265;
      }
    }
    label265:
    for (paramString = "1";; paramString = String.valueOf(l1))
    {
      paramd.kvStat(11747, paramString + "," + this.mez[1] + "," + this.mez[2] + "," + this.mez[3]);
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vhu, Long.valueOf(Util.nowMilliSecond()));
      AppMethodBeat.o(151111);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelstat.n.2
 * JD-Core Version:    0.7.0.1
 */