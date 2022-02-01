package com.tencent.mm.modelrecovery;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ca.g.b;
import com.tencent.mm.ca.h;
import com.tencent.mm.ca.k.b;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.io.File;

final class PluginRecovery$1
  implements Runnable
{
  PluginRecovery$1(PluginRecovery paramPluginRecovery)
  {
    AppMethodBeat.i(161279);
    AppMethodBeat.o(161279);
  }
  
  public final void run()
  {
    AppMethodBeat.i(191137);
    Object localObject = aj.getContext();
    ad.i("MicroMsg.recovery.reporter", "do recovery report");
    localObject = h.hy((Context)localObject);
    if (((h)localObject).ELF)
    {
      ad.i("MicroMsg.recovery.reporter", "not thing to report");
      g.b localb = g.b.hx(aj.getContext());
      localb.eCD();
      String str = localb.eCE();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "nothing";
      }
      ad.i("MicroMsg.recovery.reporter", ">>>>>>>>>> dump recovery internal log: <<<<<<<<<<");
      ad.i("MicroMsg.recovery.reporter", "\n".concat(String.valueOf(localObject)));
      ad.i("MicroMsg.recovery.reporter", ">>>>>>>>>>>>>>>>>>>>>> end <<<<<<<<<<<<<<<<<<<<<<");
      k.b.G(new File(localb.ELA));
      AppMethodBeat.o(191137);
      return;
    }
    int i = ((h)localObject).ELm;
    ad.i("MicroMsg.recovery.reporter", "report crash count = ".concat(String.valueOf(i)));
    if ((i > 0) && (i <= 20))
    {
      e.vIY.idkeyStat(1341L, i + 200, 1L, false);
      if (i >= 5) {
        e.vIY.idkeyStat(1341L, i + 220, 1L, false);
      }
      label187:
      boolean bool = ((h)localObject).ELB;
      ad.i("MicroMsg.recovery.reporter", "report recovery ui launch, result = ".concat(String.valueOf(bool)));
      if (bool) {
        e.vIY.idkeyStat(1341L, 100L, 1L, false);
      }
      bool = ((h)localObject).ELC;
      ad.i("MicroMsg.recovery.reporter", "report recovery ui launch real, result = ".concat(String.valueOf(bool)));
      if (bool) {
        e.vIY.idkeyStat(1341L, 102L, 1L, false);
      }
      bool = ((h)localObject).ELD;
      ad.i("MicroMsg.recovery.reporter", "report if recover from crash, result = ".concat(String.valueOf(bool)));
      if (bool) {
        e.vIY.idkeyStat(1341L, 101L, 1L, false);
      }
      i = ((h)localObject).ELE;
      ad.i("MicroMsg.recovery.reporter", "recovery status = ".concat(String.valueOf(i)));
      if (i >= 0)
      {
        if (i != 0) {
          break label418;
        }
        e.vIY.idkeyStat(1341L, 103L, 1L, false);
      }
    }
    for (;;)
    {
      ((h)localObject).ELm = 0;
      ((h)localObject).ELB = false;
      ((h)localObject).ELC = false;
      ((h)localObject).ELD = false;
      ((h)localObject).ELE = -1;
      ((h)localObject).ELF = false;
      ((h)localObject).ELF = true;
      ((h)localObject).save();
      break;
      if (i <= 20) {
        break label187;
      }
      ad.w("MicroMsg.recovery.reporter", "abnormal crash count found, num = ".concat(String.valueOf(i)));
      e.vIY.idkeyStat(1341L, 105L, 1L, false);
      break label187;
      label418:
      e.vIY.idkeyStat(1341L, 104L, 1L, false);
      e.vIY.idkeyStat(1341L, i + 110, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.PluginRecovery.1
 * JD-Core Version:    0.7.0.1
 */