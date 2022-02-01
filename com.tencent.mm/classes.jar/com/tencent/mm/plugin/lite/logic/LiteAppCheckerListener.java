package com.tencent.mm.plugin.lite.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.e;
import com.tencent.mm.autogen.a.e.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.threadpool.i;

public class LiteAppCheckerListener
  extends IListener<e>
{
  private static long KaG = 0L;
  private static long KaH = 0L;
  
  public LiteAppCheckerListener()
  {
    super(com.tencent.mm.app.f.hfK);
    AppMethodBeat.i(271369);
    this.__eventId = e.class.getName().hashCode();
    AppMethodBeat.o(271369);
  }
  
  private boolean b(e parame)
  {
    AppMethodBeat.i(271376);
    if (parame.hyJ.hyK)
    {
      AppMethodBeat.o(271376);
      return false;
    }
    if (!com.tencent.mm.kernel.h.baz())
    {
      Log.w("MicroMsg.AppLite.LiteAppCheckerListener", "callback fail. account not ready.");
      AppMethodBeat.o(271376);
      return false;
    }
    if (KaG == 0L) {
      KaG = ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.adgQ, Long.valueOf(0L))).longValue();
    }
    if (KaH == 0L) {
      KaH = ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.adgR, Long.valueOf(0L))).longValue();
    }
    long l1 = System.currentTimeMillis();
    long l2 = l1 - KaG;
    if (l2 >= 43200000L)
    {
      Log.i("MicroMsg.AppLite.LiteAppCheckerListener", "It's time to update lite app.");
      KaG = l1;
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adgQ, Long.valueOf(l1));
      com.tencent.threadpool.h.ahAA.bm(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(271371);
          LiteAppCheckerListener.fUe();
          AppMethodBeat.o(271371);
        }
      });
      if (l1 - KaH < 86400000L) {
        break label265;
      }
      Log.i("MicroMsg.AppLite.LiteAppCheckerListener", "It's time to clean lite app.");
      KaH = l1;
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adgR, Long.valueOf(l1));
      com.tencent.threadpool.h.ahAA.bm(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(271355);
          LiteAppCheckerListener.fUf();
          AppMethodBeat.o(271355);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(271376);
      return false;
      Log.i("MicroMsg.AppLite.LiteAppCheckerListener", "It's not time to update lite app. please wait %d second", new Object[] { Long.valueOf((43200000L - l2) / 100L) });
      break;
      label265:
      Log.i("MicroMsg.AppLite.LiteAppCheckerListener", "It's not time to clean lite app. please wait %d second", new Object[] { Long.valueOf((86400000L - l2) / 100L) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.logic.LiteAppCheckerListener
 * JD-Core Version:    0.7.0.1
 */