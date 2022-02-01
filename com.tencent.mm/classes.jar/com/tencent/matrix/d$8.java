package com.tencent.matrix;

import com.tencent.mm.g.a.fl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;

final class d$8
  extends c<fl>
{
  d$8()
  {
    this.__eventId = fl.class.getName().hashCode();
  }
  
  private static boolean HR()
  {
    try
    {
      boolean bool = ((b)g.ab(b.class)).a(b.a.qHp, true);
      ax.flf().encode("clicfg_anr_report_all", bool);
      bool = ((b)g.ab(b.class)).a(b.a.qHq, false);
      ax.flf().encode("clicfg_normal_report", bool);
      bool = ((b)g.ab(b.class)).a(b.a.qHL, true);
      ax.flf().encode("clicfg_detect_dropframe", bool);
      bool = ((b)g.ab(b.class)).a(b.a.qIl, false);
      ax.flf().encode("clicfg_detect_syncbarrier_leak", bool);
      return true;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MatrixDelegate", localException, "Cannot load A/B test", new Object[0]);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.d.8
 * JD-Core Version:    0.7.0.1
 */