package com.tencent.mm.plugin.clean.c;

import com.tencent.mm.sdk.platformtools.y;

final class d$1
  implements Runnable
{
  public final void run()
  {
    if (d.access$000() == 0)
    {
      y.i("MicroMsg.CleanLogic", "clean data");
      d.cU(0L);
      d.p(null);
      return;
    }
    y.i("MicroMsg.CleanLogic", "clean data is using");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.d.1
 * JD-Core Version:    0.7.0.1
 */