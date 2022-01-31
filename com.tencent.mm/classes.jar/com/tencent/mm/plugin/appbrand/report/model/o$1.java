package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;

final class o$1
  implements Runnable
{
  o$1(o paramo, Object[] paramArrayOfObject) {}
  
  public final void run()
  {
    for (;;)
    {
      try
      {
        str = (String)this.gZa[18];
        if (!bk.bl(str))
        {
          i = str.indexOf('?');
          if (i >= 0) {
            continue;
          }
          str = "";
          this.gZa[18] = str;
        }
      }
      catch (Exception localException)
      {
        String str;
        int i;
        this.gZa[18] = "";
        continue;
      }
      h.nFQ.f(14992, i.j(this.gZa));
      KVCommCrossProcessReceiver.bwU();
      return;
      str = q.encode(str.substring(i + 1, str.length()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.o.1
 * JD-Core Version:    0.7.0.1
 */