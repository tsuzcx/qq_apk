package com.tencent.mm.plugin.ball.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.List;

public final class a
{
  public long nfL = -1L;
  public List<BallInfo> nfM;
  
  public final void xq(int paramInt)
  {
    AppMethodBeat.i(106060);
    if ((this.nfM != null) && (!this.nfM.isEmpty())) {}
    long l;
    StringBuilder localStringBuilder;
    int k;
    int i;
    for (String str = ((BallInfo)this.nfM.get(0)).nfD.nfJ;; str = null)
    {
      l = bs.eWj();
      localStringBuilder = new StringBuilder();
      if (this.nfM == null) {
        break label264;
      }
      k = this.nfM.size();
      j = 0;
      i = 0;
      while (j < k)
      {
        i |= ((BallInfo)this.nfM.get(j)).bGe();
        if (j != 0) {
          localStringBuilder.append(";");
        }
        localStringBuilder.append(((BallInfo)this.nfM.get(j)).nfD.nfI);
        j += 1;
      }
    }
    int j = k;
    for (;;)
    {
      str = String.format("%s,%d,%d,%d,%d,%d,%s", new Object[] { str, Long.valueOf(this.nfL), Long.valueOf(l), Integer.valueOf(paramInt), Integer.valueOf(j), Integer.valueOf(i), localStringBuilder.toString() });
      ac.v("MicroMsg.FloatMenuReportHelper", "reportStr:%s", new Object[] { str });
      h.wUl.kvStat(17603, str);
      this.nfL = -1L;
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