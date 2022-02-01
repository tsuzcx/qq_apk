package com.tencent.mm.plugin.ai.data.business.trigger;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.nk;
import com.tencent.mm.autogen.a.nk.a;
import com.tencent.mm.plugin.ai.d.d;
import com.tencent.mm.plugin.ai.d.e;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

class FinderTrigger$4
  extends IListener<nk>
{
  FinderTrigger$4(b paramb, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(267635);
    this.__eventId = nk.class.getName().hashCode();
    AppMethodBeat.o(267635);
  }
  
  private boolean a(nk paramnk)
  {
    AppMethodBeat.i(267645);
    if ((paramnk == null) || (paramnk.hPM == null))
    {
      AppMethodBeat.o(267645);
      return false;
    }
    label77:
    label84:
    do
    {
      try
      {
        if (paramnk.hPM.hPN == 19943L)
        {
          localb = this.qnh;
          paramnk = paramnk.hPM.content;
          if (!Util.isNullOrNil(paramnk))
          {
            paramnk = paramnk.split(",");
            if (paramnk != null)
            {
              i = paramnk.length;
              if (i >= 5) {
                break label84;
              }
            }
          }
        }
      }
      catch (Exception paramnk)
      {
        b localb;
        int i;
        Object localObject;
        int j;
        long l1;
        break label77;
      }
      AppMethodBeat.o(267645);
      return false;
      localObject = paramnk[1];
    } while ((!"143".equals(paramnk[6])) || (!"All".equals(localObject)) || (!localb.qnc));
    com.tencent.mm.plugin.ai.data.business.global.b.bZW();
    i = com.tencent.mm.plugin.ai.data.business.global.b.cac();
    com.tencent.mm.plugin.ai.data.business.global.b.bZW();
    j = com.tencent.mm.plugin.ai.data.business.global.b.cad();
    l1 = Util.getLong(paramnk[2], 0L);
    if (l1 <= localb.qnd)
    {
      j = i + 1;
      i = 0;
    }
    for (;;)
    {
      com.tencent.mm.plugin.ai.data.business.global.b.bZW();
      e.caH().qpt.bt("finder_deep_read_count", i);
      com.tencent.mm.plugin.ai.data.business.global.b.bZW();
      e.caH().qpt.bt("finder_drop_reddot_count", j);
      Log.d("MicroMsg.FinderTrigger", "finder 19943 finderDropRedDotCount[%d]  finderDeepReadCount[%d] curFinderStayTimeMs[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(l1) });
      break;
      long l2 = localb.qne;
      if (l1 < l2) {
        break;
      }
      i = j + 1;
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.trigger.FinderTrigger.4
 * JD-Core Version:    0.7.0.1
 */