package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.appbrand.report.l;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;

final class o$1
  implements Runnable
{
  o$1(o paramo, Object[] paramArrayOfObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(132664);
    for (;;)
    {
      try
      {
        str = (String)this.iHq[18];
        if (!bo.isNullOrNil(str))
        {
          i = str.indexOf('?');
          if (i >= 0) {
            continue;
          }
          str = "";
          this.iHq[18] = str;
        }
      }
      catch (Exception localException)
      {
        String str;
        int i;
        this.iHq[18] = "";
        continue;
      }
      h.qsU.e(14992, l.k(this.iHq));
      KVCommCrossProcessReceiver.chN();
      AppMethodBeat.o(132664);
      return;
      str = q.encode(str.substring(i + 1, str.length()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.o.1
 * JD-Core Version:    0.7.0.1
 */