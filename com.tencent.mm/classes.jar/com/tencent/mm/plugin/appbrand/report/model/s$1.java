package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.plugin.appbrand.report.v;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;

final class s$1
  implements Runnable
{
  s$1(s params, Object[] paramArrayOfObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(48173);
    for (;;)
    {
      try
      {
        str = (String)this.tPW[18];
        if (!Util.isNullOrNil(str))
        {
          i = str.indexOf('?');
          if (i >= 0) {
            continue;
          }
          str = "";
          this.tPW[18] = str;
        }
      }
      catch (Exception localException)
      {
        String str;
        int i;
        this.tPW[18] = "";
        continue;
      }
      h.OAn.b(14992, v.l(this.tPW));
      KVCommCrossProcessReceiver.gNR();
      AppMethodBeat.o(48173);
      return;
      str = r.cg(str.substring(i + 1, str.length()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.s.1
 * JD-Core Version:    0.7.0.1
 */