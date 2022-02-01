package com.tencent.mm.plugin.ai.data.business.trigger.edge;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.eg;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

class DiscoverExposeEdgeTrigger$1
  extends IListener<eg>
{
  DiscoverExposeEdgeTrigger$1(b paramb, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(267682);
    this.__eventId = eg.class.getName().hashCode();
    AppMethodBeat.o(267682);
  }
  
  private boolean a(final eg parameg)
  {
    AppMethodBeat.i(267688);
    try
    {
      h.ahAA.g(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(267684);
          try
          {
            DiscoverExposeEdgeTrigger.1.this.qnL.dJ(parameg);
            AppMethodBeat.o(267684);
            return;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.DiscoverExposeEdgeTrigger", localException, "discover expose edge trigger error.", new Object[0]);
            AppMethodBeat.o(267684);
          }
        }
      }, "Ai_thread");
      label25:
      AppMethodBeat.o(267688);
      return false;
    }
    catch (Exception parameg)
    {
      break label25;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.trigger.edge.DiscoverExposeEdgeTrigger.1
 * JD-Core Version:    0.7.0.1
 */