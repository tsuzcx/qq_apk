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
  public long lER = -1L;
  public List<BallInfo> rYD;
  
  public final void Fg(int paramInt)
  {
    AppMethodBeat.i(106060);
    if ((this.rYD != null) && (!this.rYD.isEmpty())) {}
    long l;
    StringBuilder localStringBuilder;
    int k;
    int i;
    for (String str = ((BallInfo)this.rYD.get(0)).rYs.rYB;; str = null)
    {
      l = Util.nowMilliSecond();
      localStringBuilder = new StringBuilder();
      if (this.rYD == null) {
        break label264;
      }
      k = this.rYD.size();
      j = 0;
      i = 0;
      while (j < k)
      {
        i |= ((BallInfo)this.rYD.get(j)).cvs();
        if (j != 0) {
          localStringBuilder.append(";");
        }
        localStringBuilder.append(((BallInfo)this.rYD.get(j)).rYs.rYA);
        j += 1;
      }
    }
    int j = k;
    for (;;)
    {
      str = String.format("%s,%d,%d,%d,%d,%d,%s", new Object[] { str, Long.valueOf(this.lER), Long.valueOf(l), Integer.valueOf(paramInt), Integer.valueOf(j), Integer.valueOf(i), localStringBuilder.toString() });
      Log.v("MicroMsg.FloatMenuReportHelper", "whenHideMenu reportStr:%s", new Object[] { str });
      h.IzE.kvStat(17603, str);
      this.lER = -1L;
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