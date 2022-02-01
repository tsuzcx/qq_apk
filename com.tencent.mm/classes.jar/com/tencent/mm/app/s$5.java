package com.tencent.mm.app;

import com.tencent.mm.g.a.cj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;

final class s$5
  extends c<cj>
{
  s$5()
  {
    this.__eventId = cj.class.getName().hashCode();
  }
  
  private static boolean KC()
  {
    try
    {
      s.cc(((b)g.ab(b.class)).a(b.a.pZx, false));
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.MMCrashReporter", localException, "Cannot load A/B test", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.s.5
 * JD-Core Version:    0.7.0.1
 */