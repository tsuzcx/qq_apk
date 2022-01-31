package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.appbrand.report.l;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class j$1
  implements Runnable
{
  j$1(j paramj, Object[] paramArrayOfObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(132630);
    for (;;)
    {
      try
      {
        str1 = (String)this.iHq[19];
        if (!bo.isNullOrNil(str1))
        {
          i = str1.indexOf('?');
          if (i >= 0) {
            continue;
          }
          str1 = "";
          this.iHq[19] = str1;
        }
        str1 = (String)this.iHq[19];
        if (bo.nullAsNil(str1).length() > 1024)
        {
          str1 = str1.substring(0, 1024);
          this.iHq[19] = str1;
        }
      }
      catch (Exception localException)
      {
        String str1;
        int i;
        int j;
        this.iHq[19] = "";
        String str2 = (String)this.iHq[19];
        if (bo.nullAsNil(str2).length() <= 1024) {
          continue;
        }
        str2 = str2.substring(0, 1024);
        this.iHq[19] = str2;
        continue;
      }
      finally
      {
        String str3 = (String)this.iHq[19];
        if (bo.nullAsNil(str3).length() <= 1024) {
          continue;
        }
        str3 = str3.substring(0, 1024);
        this.iHq[19] = str3;
        AppMethodBeat.o(132630);
      }
      i = 0;
      if (i >= 3) {
        break label285;
      }
      j = new int[] { 1, 11, 13 }[i];
      str1 = (String)this.iHq[j];
      if (bo.nullAsNil(str1).length() > 1024)
      {
        str1 = str1.substring(0, 1024);
        this.iHq[j] = str1;
      }
      i += 1;
      continue;
      str1 = q.encode(str1.substring(i + 1, str1.length()));
    }
    label285:
    ab.d("MicroMsg.AppBrand.Report.kv_13536", "report " + toString());
    h.qsU.e(13536, l.k(this.iHq));
    KVCommCrossProcessReceiver.chN();
    AppMethodBeat.o(132630);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.j.1
 * JD-Core Version:    0.7.0.1
 */