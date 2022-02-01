package com.tencent.mm.plugin.ball.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.List;

public final class a
{
  public long nLI = -1L;
  public List<BallInfo> nLJ;
  
  public final void ya(int paramInt)
  {
    AppMethodBeat.i(106060);
    if ((this.nLJ != null) && (!this.nLJ.isEmpty())) {}
    long l;
    StringBuilder localStringBuilder;
    int k;
    int i;
    for (String str = ((BallInfo)this.nLJ.get(0)).nLw.nLG;; str = null)
    {
      l = bu.fpO();
      localStringBuilder = new StringBuilder();
      if (this.nLJ == null) {
        break label264;
      }
      k = this.nLJ.size();
      j = 0;
      i = 0;
      while (j < k)
      {
        i |= ((BallInfo)this.nLJ.get(j)).bLm();
        if (j != 0) {
          localStringBuilder.append(";");
        }
        localStringBuilder.append(((BallInfo)this.nLJ.get(j)).nLw.nLF);
        j += 1;
      }
    }
    int j = k;
    for (;;)
    {
      str = String.format("%s,%d,%d,%d,%d,%d,%s", new Object[] { str, Long.valueOf(this.nLI), Long.valueOf(l), Integer.valueOf(paramInt), Integer.valueOf(j), Integer.valueOf(i), localStringBuilder.toString() });
      ae.v("MicroMsg.FloatMenuReportHelper", "whenHideMenu reportStr:%s", new Object[] { str });
      g.yxI.kvStat(17603, str);
      this.nLI = -1L;
      AppMethodBeat.o(106060);
      return;
      label264:
      j = 0;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.e.a
 * JD-Core Version:    0.7.0.1
 */