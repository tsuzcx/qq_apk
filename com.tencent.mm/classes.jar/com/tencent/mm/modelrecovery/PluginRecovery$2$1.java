package com.tencent.mm.modelrecovery;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ca.f;
import com.tencent.mm.ca.g.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

final class PluginRecovery$2$1
  implements Runnable
{
  PluginRecovery$2$1(PluginRecovery.2 param2) {}
  
  public final void run()
  {
    boolean bool = true;
    AppMethodBeat.i(191138);
    if (com.tencent.mm.kernel.g.afC().gdw.gdQ)
    {
      Object localObject = aj.getContext();
      try
      {
        b localb = (b)com.tencent.mm.kernel.g.ab(b.class);
        g.a locala;
        int i;
        if (localb != null)
        {
          locala = g.a.hw((Context)localObject);
          i = localb.a(b.a.pvq, 1);
          if (i <= 0) {
            break label280;
          }
        }
        for (;;)
        {
          locala.mEnabled = bool;
          locala.ELz.cu("enable", locala.mEnabled).eCx();
          ad.i("MicroMsg.recovery.reporter", "online config, enabled = ".concat(String.valueOf(i)));
          localObject = com.tencent.mm.ca.g.hv((Context)localObject);
          i = localb.a(b.a.pvr, ((com.tencent.mm.ca.g)localObject).ELu);
          int j = localb.a(b.a.pvs, ((com.tencent.mm.ca.g)localObject).ELv);
          long l = localb.a(b.a.pvt, ((com.tencent.mm.ca.g)localObject).ELy);
          if (i >= 2) {
            ((com.tencent.mm.ca.g)localObject).ELu = i;
          }
          if (j >= ((com.tencent.mm.ca.g)localObject).ELu) {
            ((com.tencent.mm.ca.g)localObject).ELv = j;
          }
          if (l >= 5000L) {
            ((com.tencent.mm.ca.g)localObject).ELy = l;
          }
          ((com.tencent.mm.ca.g)localObject).ELz.fC("setting_threshold_1", ((com.tencent.mm.ca.g)localObject).ELu).fC("setting_threshold_2", ((com.tencent.mm.ca.g)localObject).ELv).bL("setting_crash_interval", ((com.tencent.mm.ca.g)localObject).ELw).bL("setting_crash_minimal_interval", ((com.tencent.mm.ca.g)localObject).ELx).bL("setting_reset_delay", ((com.tencent.mm.ca.g)localObject).ELy).eCx();
          AppMethodBeat.o(191138);
          return;
          label280:
          bool = false;
        }
        AppMethodBeat.o(191138);
      }
      catch (Throwable localThrowable)
      {
        ad.printErrStackTrace("MicroMsg.recovery.reporter", localThrowable, "pull abtest config for recovery fail", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.PluginRecovery.2.1
 * JD-Core Version:    0.7.0.1
 */