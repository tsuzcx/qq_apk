package com.tencent.mm.booter;

import com.tencent.mm.app.f.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class g$1
  implements f.a
{
  public final void er(int paramInt)
  {
    y.i("MicroMsg.PostTaskLightweightJob", "CrashStatus report: key %s ", new Object[] { Integer.valueOf(paramInt) });
    h.nFQ.a(25L, paramInt, 1L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.booter.g.1
 * JD-Core Version:    0.7.0.1
 */