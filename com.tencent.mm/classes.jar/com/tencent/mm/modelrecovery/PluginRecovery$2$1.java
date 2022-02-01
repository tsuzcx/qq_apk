package com.tencent.mm.modelrecovery;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bz.f;
import com.tencent.mm.bz.g.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

final class PluginRecovery$2$1
  implements Runnable
{
  PluginRecovery$2$1(PluginRecovery.2 param2) {}
  
  public final void run()
  {
    boolean bool = true;
    AppMethodBeat.i(195940);
    if (com.tencent.mm.kernel.g.agS().gic.giw)
    {
      Object localObject = ai.getContext();
      try
      {
        b localb = (b)com.tencent.mm.kernel.g.ab(b.class);
        g.a locala;
        int i;
        if (localb != null)
        {
          locala = g.a.hH((Context)localObject);
          i = localb.a(b.a.pZE, 1);
          if (i <= 0) {
            break label280;
          }
        }
        for (;;)
        {
          locala.mEnabled = bool;
          locala.GiL.cA("enable", locala.mEnabled).eRS();
          ac.i("MicroMsg.recovery.reporter", "online config, enabled = ".concat(String.valueOf(i)));
          localObject = com.tencent.mm.bz.g.hG((Context)localObject);
          i = localb.a(b.a.pZF, ((com.tencent.mm.bz.g)localObject).GiG);
          int j = localb.a(b.a.pZG, ((com.tencent.mm.bz.g)localObject).GiH);
          long l = localb.a(b.a.pZH, ((com.tencent.mm.bz.g)localObject).GiK);
          if (i >= 2) {
            ((com.tencent.mm.bz.g)localObject).GiG = i;
          }
          if (j >= ((com.tencent.mm.bz.g)localObject).GiG) {
            ((com.tencent.mm.bz.g)localObject).GiH = j;
          }
          if (l >= 5000L) {
            ((com.tencent.mm.bz.g)localObject).GiK = l;
          }
          ((com.tencent.mm.bz.g)localObject).GiL.fH("setting_threshold_1", ((com.tencent.mm.bz.g)localObject).GiG).fH("setting_threshold_2", ((com.tencent.mm.bz.g)localObject).GiH).bN("setting_crash_interval", ((com.tencent.mm.bz.g)localObject).GiI).bN("setting_crash_minimal_interval", ((com.tencent.mm.bz.g)localObject).GiJ).bN("setting_reset_delay", ((com.tencent.mm.bz.g)localObject).GiK).eRS();
          AppMethodBeat.o(195940);
          return;
          label280:
          bool = false;
        }
        AppMethodBeat.o(195940);
      }
      catch (Throwable localThrowable)
      {
        ac.printErrStackTrace("MicroMsg.recovery.reporter", localThrowable, "pull abtest config for recovery fail", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.PluginRecovery.2.1
 * JD-Core Version:    0.7.0.1
 */