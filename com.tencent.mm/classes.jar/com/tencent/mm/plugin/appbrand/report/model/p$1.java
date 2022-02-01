package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.appbrand.report.t;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;

final class p$1
  implements Runnable
{
  p$1(p paramp, Object[] paramArrayOfObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(48173);
    for (;;)
    {
      try
      {
        str = (String)this.qLp[18];
        if (!Util.isNullOrNil(str))
        {
          i = str.indexOf('?');
          if (i >= 0) {
            continue;
          }
          str = "";
          this.qLp[18] = str;
        }
      }
      catch (Exception localException)
      {
        String str;
        int i;
        this.qLp[18] = "";
        continue;
      }
      h.IzE.a(14992, t.j(this.qLp));
      KVCommCrossProcessReceiver.fBy();
      AppMethodBeat.o(48173);
      return;
      str = q.aT(str.substring(i + 1, str.length()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.p.1
 * JD-Core Version:    0.7.0.1
 */