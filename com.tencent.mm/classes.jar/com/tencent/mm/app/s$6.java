package com.tencent.mm.app;

import com.tencent.mm.g.a.fi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;

final class s$6
  extends c<fi>
{
  s$6()
  {
    this.__eventId = fi.class.getName().hashCode();
  }
  
  private static boolean Gw()
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
 * Qualified Name:     com.tencent.mm.app.s.6
 * JD-Core Version:    0.7.0.1
 */