package com.tencent.mm.plugin.lite.b;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.d;
import com.tencent.mm.f.a.d.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class b
  extends IListener<d>
{
  private static long Egm = 0L;
  private static long Egn = 0L;
  
  public b()
  {
    AppMethodBeat.i(233615);
    this.__eventId = d.class.getName().hashCode();
    AppMethodBeat.o(233615);
  }
  
  private boolean a(d paramd)
  {
    AppMethodBeat.i(233617);
    if (paramd.fur.fus)
    {
      AppMethodBeat.o(233617);
      return false;
    }
    if (!com.tencent.mm.kernel.h.aHB())
    {
      Log.w("MicroMsg.AppLite.LiteAppCheckerListener", "callback fail. account not ready.");
      AppMethodBeat.o(233617);
      return false;
    }
    if (Egm == 0L) {
      Egm = ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VDP, Long.valueOf(0L))).longValue();
    }
    if (Egn == 0L) {
      Egn = ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VDQ, Long.valueOf(0L))).longValue();
    }
    long l1 = System.currentTimeMillis();
    long l2 = l1 - Egm;
    if (l2 >= 43200000L)
    {
      Log.i("MicroMsg.AppLite.LiteAppCheckerListener", "It's time to update lite app.");
      Egm = l1;
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VDP, Long.valueOf(l1));
      com.tencent.e.h.ZvG.be(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(233851);
          b.eLD();
          AppMethodBeat.o(233851);
        }
      });
      if (l1 - Egn < 86400000L) {
        break label265;
      }
      Log.i("MicroMsg.AppLite.LiteAppCheckerListener", "It's time to clean lite app.");
      Egn = l1;
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VDQ, Long.valueOf(l1));
      com.tencent.e.h.ZvG.be(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(234081);
          b.eLE();
          AppMethodBeat.o(234081);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(233617);
      return false;
      Log.i("MicroMsg.AppLite.LiteAppCheckerListener", "It's not time to update lite app. please wait %d second", new Object[] { Long.valueOf((43200000L - l2) / 100L) });
      break;
      label265:
      Log.i("MicroMsg.AppLite.LiteAppCheckerListener", "It's not time to clean lite app. please wait %d second", new Object[] { Long.valueOf((86400000L - l2) / 100L) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.b.b
 * JD-Core Version:    0.7.0.1
 */