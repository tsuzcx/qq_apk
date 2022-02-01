package com.tencent.matrix;

import com.tencent.mm.g.a.fi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;

final class d$7
  extends c<fi>
{
  d$7()
  {
    this.__eventId = fi.class.getName().hashCode();
  }
  
  private static boolean Gw()
  {
    try
    {
      boolean bool = ((b)g.ab(b.class)).a(b.a.qbM, true);
      aw.eVy().encode("clicfg_anr_report_all", bool);
      bool = ((b)g.ab(b.class)).a(b.a.qbN, false);
      aw.eVy().encode("clicfg_normal_report", bool);
      return true;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MatrixDelegate", localException, "Cannot load A/B test", new Object[0]);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.d.7
 * JD-Core Version:    0.7.0.1
 */