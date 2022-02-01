package com.tencent.mm.plugin.ai.data.business.finder;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aan;
import com.tencent.mm.autogen.a.aan.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

class AiFinderLogic$4
  extends IListener<aan>
{
  AiFinderLogic$4(e parame, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(267493);
    this.__eventId = aan.class.getName().hashCode();
    AppMethodBeat.o(267493);
  }
  
  private boolean a(aan paramaan)
  {
    AppMethodBeat.i(267504);
    try
    {
      e locale;
      if (paramaan.idX.idY == 2)
      {
        locale = this.qmd;
        paramaan = paramaan.idX;
        if (locale.qlR > 0)
        {
          Log.i("MicroMsg.AiFinderLogic", "tabRedDotChangeToNotifyFinderSync [%b %d] [%b %d]", new Object[] { Boolean.valueOf(paramaan.idZ), Integer.valueOf(paramaan.iea), Boolean.valueOf(paramaan.ieb), Integer.valueOf(paramaan.iec) });
          if ((paramaan.idZ) || (!paramaan.ieb)) {
            break label147;
          }
          i = locale.qlR;
        }
      }
      for (;;)
      {
        if ((i > 0) && (locale.qlU.size() <= 3))
        {
          locale.yJ(locale.qlR);
          h.OAn.p(1559L, 192L, 1L);
        }
        AppMethodBeat.o(267504);
        return false;
        label147:
        if ((!paramaan.idZ) && (paramaan.iea == 0) && (paramaan.iec > 0))
        {
          i = locale.qlR;
        }
        else
        {
          if (paramaan.iea == paramaan.iec) {
            break;
          }
          i = locale.qlR;
        }
      }
    }
    catch (Exception paramaan)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.AiFinderLogic", paramaan, "", new Object[0]);
        continue;
        int i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.finder.AiFinderLogic.4
 * JD-Core Version:    0.7.0.1
 */