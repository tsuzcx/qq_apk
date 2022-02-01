package com.tencent.mm.plugin.ball.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

public final class a
{
  public long nGh = -1L;
  public List<BallInfo> nGi;
  
  public final void xW(int paramInt)
  {
    AppMethodBeat.i(106060);
    if ((this.nGi != null) && (!this.nGi.isEmpty())) {}
    long l;
    StringBuilder localStringBuilder;
    int k;
    int i;
    for (String str = ((BallInfo)this.nGi.get(0)).nFZ.nGf;; str = null)
    {
      l = bt.flT();
      localStringBuilder = new StringBuilder();
      if (this.nGi == null) {
        break label264;
      }
      k = this.nGi.size();
      j = 0;
      i = 0;
      while (j < k)
      {
        i |= ((BallInfo)this.nGi.get(j)).bKp();
        if (j != 0) {
          localStringBuilder.append(";");
        }
        localStringBuilder.append(((BallInfo)this.nGi.get(j)).nFZ.nGe);
        j += 1;
      }
    }
    int j = k;
    for (;;)
    {
      str = String.format("%s,%d,%d,%d,%d,%d,%s", new Object[] { str, Long.valueOf(this.nGh), Long.valueOf(l), Integer.valueOf(paramInt), Integer.valueOf(j), Integer.valueOf(i), localStringBuilder.toString() });
      ad.v("MicroMsg.FloatMenuReportHelper", "reportStr:%s", new Object[] { str });
      g.yhR.kvStat(17603, str);
      this.nGh = -1L;
      AppMethodBeat.o(106060);
      return;
      label264:
      j = 0;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.e.a
 * JD-Core Version:    0.7.0.1
 */