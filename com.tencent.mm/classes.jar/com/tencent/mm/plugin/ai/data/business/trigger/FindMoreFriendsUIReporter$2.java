package com.tencent.mm.plugin.ai.data.business.trigger;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.eg;
import com.tencent.mm.autogen.mmdata.rpt.ai;
import com.tencent.mm.plugin.ai.d.d;
import com.tencent.mm.plugin.ai.d.e;
import com.tencent.mm.plugin.ai.data.business.global.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

class FindMoreFriendsUIReporter$2
  extends IListener<eg>
{
  FindMoreFriendsUIReporter$2(a parama, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(267595);
    this.__eventId = eg.class.getName().hashCode();
    AppMethodBeat.o(267595);
  }
  
  private boolean cas()
  {
    AppMethodBeat.i(267609);
    try
    {
      Object localObject = this.qmU;
      b.bZW();
      ((a)localObject).qmQ = b.TM("FinderEntrance");
      localObject = this.qmU;
      b.bZW();
      ((a)localObject).qmR = b.TM("FinderLiveEntrance");
      Log.d("MicroMsg.FindMoreFriendsUIReporter", "enter ui enterUIWithFinderJson[%s]  enterUIWithFinderLiveJson[%s]", new Object[] { this.qmU.qmQ, this.qmU.qmR });
      long l = Util.currentTicks();
      e.caH();
      localObject = d.TV("calendar_statistics_discover");
      if (localObject != null)
      {
        if (((ai)localObject).iog == 0L) {
          ((ai)localObject).es(Util.nowMilliSecond());
        }
        ((ai)localObject).ioi += 1L;
        e.caH();
        d.a("calendar_statistics_discover", (ai)localObject);
        Log.i("MicroMsg.FindMoreFriendsUIReporter", "noteFindMoreFriendsUIInfo struct[%s] cost[%d]", new Object[] { ((ai)localObject).aIE(), Long.valueOf(Util.ticksToNow(l)) });
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.FindMoreFriendsUIReporter", localException, "enter ui but finder reddot json error", new Object[0]);
      }
    }
    AppMethodBeat.o(267609);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.trigger.FindMoreFriendsUIReporter.2
 * JD-Core Version:    0.7.0.1
 */