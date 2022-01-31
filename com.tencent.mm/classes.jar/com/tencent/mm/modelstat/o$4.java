package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;

final class o$4
  implements ap.a
{
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(78770);
    try
    {
      o.akI();
      if ((o.access$300() < 2000) && (o.access$300() > 1000)) {
        o.me(o.access$300());
      }
      for (;;)
      {
        AppMethodBeat.o(78770);
        return false;
        o.mf(o.access$300());
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.NetTypeReporter", "run :%s", new Object[] { bo.l(localException) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.o.4
 * JD-Core Version:    0.7.0.1
 */