package com.tencent.mm.plugin.ai.data.business.trigger;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aan;
import com.tencent.mm.autogen.a.aan.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

class NearLiveTrigger$3
  extends IListener<aan>
{
  NearLiveTrigger$3(e parame, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(267573);
    this.__eventId = aan.class.getName().hashCode();
    AppMethodBeat.o(267573);
  }
  
  private boolean a(aan paramaan)
  {
    int j = 249;
    AppMethodBeat.i(267586);
    for (;;)
    {
      try
      {
        if (paramaan.idX.idY == 2)
        {
          e locale = this.qnn;
          paramaan = paramaan.idX;
          if (locale.qmY)
          {
            Log.i("MicroMsg.NearLiveTrigger", "tabRedDotChangeToNotifyLiveSync [%b %d] [%b %d]", new Object[] { Boolean.valueOf(paramaan.idZ), Integer.valueOf(paramaan.iea), Boolean.valueOf(paramaan.ieb), Integer.valueOf(paramaan.iec) });
            if ((paramaan.idZ) || (!paramaan.ieb)) {
              continue;
            }
            i = j;
            if (i > 0)
            {
              locale.yL(249);
              String.format("live tab red dot change [%d] ", new Object[] { Integer.valueOf(249) });
              h.OAn.p(1559L, 212L, 1L);
            }
          }
        }
      }
      catch (Exception paramaan)
      {
        int i;
        int k;
        int m;
        Log.printErrStackTrace("MicroMsg.NearLiveTrigger", paramaan, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(267586);
      return false;
      if ((!paramaan.idZ) && (paramaan.iea == 0))
      {
        i = j;
        if (paramaan.iec > 0) {}
      }
      else
      {
        k = paramaan.iea;
        m = paramaan.iec;
        i = j;
        if (k == m) {
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.trigger.NearLiveTrigger.3
 * JD-Core Version:    0.7.0.1
 */