package com.tencent.mm.modelstat;

import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class o$4
  implements am.a
{
  public final boolean tC()
  {
    try
    {
      o.Rz();
      if ((o.access$300() < 2000) && (o.access$300() > 1000))
      {
        o.jm(o.access$300());
        return false;
      }
      o.jn(o.access$300());
      return false;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.NetTypeReporter", "run :%s", new Object[] { bk.j(localException) });
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.o.4
 * JD-Core Version:    0.7.0.1
 */