package com.tencent.mm.modelrecovery;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bz.g.b;
import com.tencent.mm.bz.h;
import com.tencent.mm.bz.k.b;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
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
    AppMethodBeat.i(195939);
    Object localObject = ai.getContext();
    ac.i("MicroMsg.recovery.reporter", "do recovery report");
    localObject = h.hJ((Context)localObject);
    if (((h)localObject).GiR)
    {
      ac.i("MicroMsg.recovery.reporter", "not thing to report");
      g.b localb = g.b.hI(ai.getContext());
      localb.eRX();
      String str = localb.eRY();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "nothing";
      }
      ac.i("MicroMsg.recovery.reporter", ">>>>>>>>>> dump recovery internal log: <<<<<<<<<<");
      ac.i("MicroMsg.recovery.reporter", "\n".concat(String.valueOf(localObject)));
      ac.i("MicroMsg.recovery.reporter", ">>>>>>>>>>>>>>>>>>>>>> end <<<<<<<<<<<<<<<<<<<<<<");
      k.b.J(new File(localb.GiM));
      AppMethodBeat.o(195939);
      return;
    }
    int i = ((h)localObject).Giy;
    ac.i("MicroMsg.recovery.reporter", "report crash count = ".concat(String.valueOf(i)));
    if ((i > 0) && (i <= 20))
    {
      e.wTc.idkeyStat(1341L, i + 200, 1L, false);
      if (i >= 5) {
        e.wTc.idkeyStat(1341L, i + 220, 1L, false);
      }
      label187:
      boolean bool = ((h)localObject).GiN;
      ac.i("MicroMsg.recovery.reporter", "report recovery ui launch, result = ".concat(String.valueOf(bool)));
      if (bool) {
        e.wTc.idkeyStat(1341L, 100L, 1L, false);
      }
      bool = ((h)localObject).GiO;
      ac.i("MicroMsg.recovery.reporter", "report recovery ui launch real, result = ".concat(String.valueOf(bool)));
      if (bool) {
        e.wTc.idkeyStat(1341L, 102L, 1L, false);
      }
      bool = ((h)localObject).GiP;
      ac.i("MicroMsg.recovery.reporter", "report if recover from crash, result = ".concat(String.valueOf(bool)));
      if (bool) {
        e.wTc.idkeyStat(1341L, 101L, 1L, false);
      }
      i = ((h)localObject).GiQ;
      ac.i("MicroMsg.recovery.reporter", "recovery status = ".concat(String.valueOf(i)));
      if (i >= 0)
      {
        if (i != 0) {
          break label418;
        }
        e.wTc.idkeyStat(1341L, 103L, 1L, false);
      }
    }
    for (;;)
    {
      ((h)localObject).Giy = 0;
      ((h)localObject).GiN = false;
      ((h)localObject).GiO = false;
      ((h)localObject).GiP = false;
      ((h)localObject).GiQ = -1;
      ((h)localObject).GiR = false;
      ((h)localObject).GiR = true;
      ((h)localObject).save();
      break;
      if (i <= 20) {
        break label187;
      }
      ac.w("MicroMsg.recovery.reporter", "abnormal crash count found, num = ".concat(String.valueOf(i)));
      e.wTc.idkeyStat(1341L, 105L, 1L, false);
      break label187;
      label418:
      e.wTc.idkeyStat(1341L, 104L, 1L, false);
      e.wTc.idkeyStat(1341L, i + 110, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.PluginRecovery.1
 * JD-Core Version:    0.7.0.1
 */