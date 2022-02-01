package com.tencent.mm.plugin.ai.data.business.trigger;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.eh;
import com.tencent.mm.autogen.a.eh.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.util.HashSet;

class LiveNotifyMsgTrigger$2
  extends IListener<eh>
{
  LiveNotifyMsgTrigger$2(d paramd, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(267646);
    this.__eventId = eh.class.getName().hashCode();
    AppMethodBeat.o(267646);
  }
  
  private boolean a(eh parameh)
  {
    AppMethodBeat.i(267659);
    for (;;)
    {
      try
      {
        locald = this.qnl;
        if (locald.qmX != null)
        {
          i = locald.qmX.size();
          if (i > 0) {
            continue;
          }
        }
      }
      catch (Exception parameh)
      {
        d locald;
        int i;
        continue;
      }
      AppMethodBeat.o(267659);
      return false;
      if (locald.qmX.contains(parameh.hEd.hEa))
      {
        i = Util.getInt(parameh.hEd.hEa, -1);
        if ((i >= 0) && (i < 255)) {
          if (Util.milliSecondsToNow(locald.qni) <= locald.qnj)
          {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1559L, 221L, 1L, false);
          }
          else
          {
            locald.qni = Util.nowMilliSecond();
            com.tencent.threadpool.h.ahAA.g(new d.1(locald, parameh), "Ai_thread");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.trigger.LiveNotifyMsgTrigger.2
 * JD-Core Version:    0.7.0.1
 */