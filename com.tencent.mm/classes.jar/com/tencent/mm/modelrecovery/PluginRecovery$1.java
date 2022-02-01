package com.tencent.mm.modelrecovery;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.recoveryv2.h.c;
import com.tencent.mm.recoveryv2.i;
import com.tencent.mm.recoveryv2.l.b;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.File;

final class PluginRecovery$1
  implements Runnable
{
  PluginRecovery$1(PluginRecovery paramPluginRecovery, g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(186365);
    for (;;)
    {
      long l;
      try
      {
        Object localObject = this.cUt.ca;
        ae.i("MicroMsg.recovery.reporter", "do recovery report");
        localObject = i.hX((Context)localObject);
        if (((i)localObject).IoA)
        {
          ae.i("MicroMsg.recovery.reporter", "not thing to report");
          h.c localc = h.c.hW(this.cUt.ca);
          localc.flb();
          String str = localc.flc();
          localObject = str;
          if (TextUtils.isEmpty(str)) {
            localObject = "nothing";
          }
          ae.i("MicroMsg.recovery.reporter", ">>>>>>> dump recovery internal log (:main) <<<<<<<");
          ae.i("MicroMsg.recovery.reporter", "\n".concat(String.valueOf(localObject)));
          ae.i("MicroMsg.recovery.reporter", ">>>>>>>>>>>>>>>>>>>>>> end <<<<<<<<<<<<<<<<<<<<<<<");
          l.b.L(new File(localc.Iov));
          AppMethodBeat.o(186365);
          return;
        }
        i = ((i)localObject).Ioe;
        ae.i("MicroMsg.recovery.reporter", "report crash count = ".concat(String.valueOf(i)));
        if ((i > 0) && (i <= 20))
        {
          e.ywz.idkeyStat(1341L, i + 200, 1L, false);
          if (i >= 5) {
            e.ywz.idkeyStat(1341L, i + 220, 1L, false);
          }
          boolean bool = ((i)localObject).Iow;
          ae.i("MicroMsg.recovery.reporter", "report recovery ui launch, result = ".concat(String.valueOf(bool)));
          if (bool) {
            e.ywz.idkeyStat(1341L, 100L, 1L, false);
          }
          bool = ((i)localObject).Iox;
          ae.i("MicroMsg.recovery.reporter", "report recovery ui launch real, result = ".concat(String.valueOf(bool)));
          if (bool) {
            e.ywz.idkeyStat(1341L, 102L, 1L, false);
          }
          bool = ((i)localObject).Ioy;
          ae.i("MicroMsg.recovery.reporter", "report if recover from crash, result = ".concat(String.valueOf(bool)));
          if (bool) {
            e.ywz.idkeyStat(1341L, 101L, 1L, false);
          }
          i = ((i)localObject).Ioz;
          ae.i("MicroMsg.recovery.reporter", "recovery status = ".concat(String.valueOf(i)));
          if (i >= 0)
          {
            if (i != 0) {
              break label622;
            }
            e.ywz.idkeyStat(1341L, 103L, 1L, false);
          }
          i = ((i)localObject).mFrom;
          ae.i("MicroMsg.recovery.reporter", "recovery from = ".concat(String.valueOf(i)));
          if ((i >= 0) && (i < 10)) {
            e.ywz.idkeyStat(1341L, i + 140, 1L, false);
          }
          i = ((i)localObject).IoB;
          ae.i("MicroMsg.recovery.reporter", "recovery internalStatus = ".concat(String.valueOf(i)));
          if ((i >= 0) && (i < 10)) {
            e.ywz.idkeyStat(1341L, i + 150, 1L, false);
          }
          l = ((i)localObject).IoC;
          if (l <= 0L) {
            break label803;
          }
          if (l > 10000L) {
            break label655;
          }
          i = 0;
          if (i >= 0) {
            e.ywz.idkeyStat(1341L, i + 160, 1L, false);
          }
          ((i)localObject).Ioe = 0;
          ((i)localObject).Iow = false;
          ((i)localObject).Iox = false;
          ((i)localObject).Ioy = false;
          ((i)localObject).Ioz = -1;
          ((i)localObject).mFrom = 0;
          ((i)localObject).IoB = 0;
          ((i)localObject).IoC = 0L;
          ((i)localObject).IoA = false;
          ((i)localObject).IoA = true;
          ((i)localObject).save();
          continue;
        }
        if (i <= 20) {
          continue;
        }
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.recovery.PluginRecovery", localException, "post recovery fail", new Object[0]);
        AppMethodBeat.o(186365);
        return;
      }
      ae.w("MicroMsg.recovery.reporter", "abnormal crash count found, num = ".concat(String.valueOf(i)));
      e.ywz.idkeyStat(1341L, 105L, 1L, false);
      continue;
      label622:
      e.ywz.idkeyStat(1341L, 104L, 1L, false);
      e.ywz.idkeyStat(1341L, i + 110, 1L, false);
      continue;
      label655:
      if (l <= 60000L)
      {
        l /= 10000L;
        if ((l >= 1L) && (l <= 6L)) {
          i = (int)(l + 0L);
        }
      }
      else if (l <= 600000L)
      {
        l /= 60000L;
        if ((l >= 1L) && (l <= 10L)) {
          i = (int)(l + 6L);
        }
      }
      else if (l <= 3600000L)
      {
        l /= 600000L;
        if ((l >= 1L) && (l <= 6L)) {
          i = (int)(l + 16L);
        }
      }
      else
      {
        l /= 3600000L;
        if (l >= 1L)
        {
          if (l <= 6L)
          {
            i = (int)(l + 22L);
            continue;
          }
          i = 29;
          continue;
        }
      }
      label803:
      int i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.PluginRecovery.1
 * JD-Core Version:    0.7.0.1
 */