package com.tencent.mm.plugin.ball.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class a
{
  public long owx = -1L;
  public List<BallInfo> vjU;
  
  public final void FH(int paramInt)
  {
    AppMethodBeat.i(106060);
    if ((this.vjU != null) && (!this.vjU.isEmpty())) {}
    long l;
    StringBuilder localStringBuilder;
    int k;
    int i;
    for (String str = ((BallInfo)this.vjU.get(0)).vjI.vjR;; str = null)
    {
      l = Util.nowMilliSecond();
      localStringBuilder = new StringBuilder();
      if (this.vjU == null) {
        break label264;
      }
      k = this.vjU.size();
      j = 0;
      i = 0;
      while (j < k)
      {
        i |= ((BallInfo)this.vjU.get(j)).cYd();
        if (j != 0) {
          localStringBuilder.append(";");
        }
        localStringBuilder.append(((BallInfo)this.vjU.get(j)).vjI.vjQ);
        j += 1;
      }
    }
    int j = k;
    for (;;)
    {
      str = String.format("%s,%d,%d,%d,%d,%d,%s", new Object[] { str, Long.valueOf(this.owx), Long.valueOf(l), Integer.valueOf(paramInt), Integer.valueOf(j), Integer.valueOf(i), localStringBuilder.toString() });
      Log.v("MicroMsg.FloatMenuReportHelper", "whenHideMenu reportStr:%s", new Object[] { str });
      h.OAn.kvStat(17603, str);
      this.owx = -1L;
      AppMethodBeat.o(106060);
      return;
      label264:
      j = 0;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.e.a
 * JD-Core Version:    0.7.0.1
 */