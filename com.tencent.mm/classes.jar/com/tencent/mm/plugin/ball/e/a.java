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
  public long iOB = -1L;
  public List<BallInfo> oWD;
  
  public final void BF(int paramInt)
  {
    AppMethodBeat.i(106060);
    if ((this.oWD != null) && (!this.oWD.isEmpty())) {}
    long l;
    StringBuilder localStringBuilder;
    int k;
    int i;
    for (String str = ((BallInfo)this.oWD.get(0)).oWs.oWB;; str = null)
    {
      l = Util.nowMilliSecond();
      localStringBuilder = new StringBuilder();
      if (this.oWD == null) {
        break label264;
      }
      k = this.oWD.size();
      j = 0;
      i = 0;
      while (j < k)
      {
        i |= ((BallInfo)this.oWD.get(j)).cig();
        if (j != 0) {
          localStringBuilder.append(";");
        }
        localStringBuilder.append(((BallInfo)this.oWD.get(j)).oWs.oWA);
        j += 1;
      }
    }
    int j = k;
    for (;;)
    {
      str = String.format("%s,%d,%d,%d,%d,%d,%s", new Object[] { str, Long.valueOf(this.iOB), Long.valueOf(l), Integer.valueOf(paramInt), Integer.valueOf(j), Integer.valueOf(i), localStringBuilder.toString() });
      Log.v("MicroMsg.FloatMenuReportHelper", "whenHideMenu reportStr:%s", new Object[] { str });
      h.CyF.kvStat(17603, str);
      this.iOB = -1L;
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