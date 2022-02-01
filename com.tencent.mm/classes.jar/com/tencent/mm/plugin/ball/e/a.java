package com.tencent.mm.plugin.ball.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

public final class a
{
  public long mDF = -1L;
  public List<BallInfo> mDG;
  
  public final void wz(int paramInt)
  {
    AppMethodBeat.i(106060);
    if ((this.mDG != null) && (!this.mDG.isEmpty())) {}
    long l;
    StringBuilder localStringBuilder;
    int k;
    int i;
    for (String str = ((BallInfo)this.mDG.get(0)).mDw.mDD;; str = null)
    {
      l = bt.eGO();
      localStringBuilder = new StringBuilder();
      if (this.mDG == null) {
        break label264;
      }
      k = this.mDG.size();
      j = 0;
      i = 0;
      while (j < k)
      {
        i |= ((BallInfo)this.mDG.get(j)).bzi();
        if (j != 0) {
          localStringBuilder.append(";");
        }
        localStringBuilder.append(((BallInfo)this.mDG.get(j)).mDw.mDC);
        j += 1;
      }
    }
    int j = k;
    for (;;)
    {
      str = String.format("%s,%d,%d,%d,%d,%d,%s", new Object[] { str, Long.valueOf(this.mDF), Long.valueOf(l), Integer.valueOf(paramInt), Integer.valueOf(j), Integer.valueOf(i), localStringBuilder.toString() });
      ad.v("MicroMsg.FloatMenuReportHelper", "reportStr:%s", new Object[] { str });
      h.vKh.kvStat(17603, str);
      this.mDF = -1L;
      AppMethodBeat.o(106060);
      return;
      label264:
      j = 0;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.e.a
 * JD-Core Version:    0.7.0.1
 */