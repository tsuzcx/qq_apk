package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.plugin.appbrand.report.v;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

final class n$1
  implements Runnable
{
  n$1(n paramn, Object[] paramArrayOfObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(48135);
    for (;;)
    {
      try
      {
        str1 = (String)this.tPW[19];
        if (!Util.isNullOrNil(str1))
        {
          i = str1.indexOf('?');
          if (i >= 0) {
            continue;
          }
          str1 = "";
          this.tPW[19] = str1;
        }
        str1 = (String)this.tPW[19];
        if (Util.nullAsNil(str1).length() > 1024)
        {
          str1 = str1.substring(0, 1024);
          this.tPW[19] = str1;
        }
      }
      catch (Exception localException)
      {
        String str1;
        int i;
        int j;
        this.tPW[19] = "";
        String str2 = (String)this.tPW[19];
        if (Util.nullAsNil(str2).length() <= 1024) {
          continue;
        }
        str2 = str2.substring(0, 1024);
        this.tPW[19] = str2;
        continue;
      }
      finally
      {
        String str3 = (String)this.tPW[19];
        if (Util.nullAsNil(str3).length() <= 1024) {
          continue;
        }
        str3 = str3.substring(0, 1024);
        this.tPW[19] = str3;
        AppMethodBeat.o(48135);
      }
      i = 0;
      if (i >= 3) {
        break label285;
      }
      j = new int[] { 1, 11, 13 }[i];
      str1 = (String)this.tPW[j];
      if (Util.nullAsNil(str1).length() > 1024)
      {
        str1 = str1.substring(0, 1024);
        this.tPW[j] = str1;
      }
      i += 1;
      continue;
      str1 = r.cg(str1.substring(i + 1, str1.length()));
    }
    label285:
    Log.i("MicroMsg.AppBrand.Report.kv_13536", "report " + Arrays.deepToString(this.tPW));
    h.OAn.b(13536, v.l(this.tPW));
    KVCommCrossProcessReceiver.gNR();
    AppMethodBeat.o(48135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.n.1
 * JD-Core Version:    0.7.0.1
 */