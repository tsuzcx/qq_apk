package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bt;

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
        str = (String)this.mte[18];
        if (!bt.isNullOrNil(str))
        {
          i = str.indexOf('?');
          if (i >= 0) {
            continue;
          }
          str = "";
          this.mte[18] = str;
        }
      }
      catch (Exception localException)
      {
        String str;
        int i;
        this.mte[18] = "";
        continue;
      }
      g.yhR.f(14992, com.tencent.mm.plugin.appbrand.report.p.l(this.mte));
      KVCommCrossProcessReceiver.dKl();
      AppMethodBeat.o(48173);
      return;
      str = q.encode(str.substring(i + 1, str.length()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.p.1
 * JD-Core Version:    0.7.0.1
 */