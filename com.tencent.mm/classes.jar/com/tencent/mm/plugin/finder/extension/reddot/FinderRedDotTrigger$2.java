package com.tencent.mm.plugin.finder.extension.reddot;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.su;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

class FinderRedDotTrigger$2
  extends IListener<su>
{
  FinderRedDotTrigger$2(o paramo, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(366871);
    this.__eventId = su.class.getName().hashCode();
    AppMethodBeat.o(366871);
  }
  
  private boolean a(su paramsu)
  {
    AppMethodBeat.i(366881);
    long l = Util.currentTicks();
    if ((paramsu == null) || (paramsu.hWe == null))
    {
      AppMethodBeat.o(366881);
      return false;
    }
    try
    {
      o.a(this.ASv, paramsu, "FinderEntrance", 143);
      o.a(this.ASv, paramsu, "NearbyEntrance", 150);
      o.a(this.ASv, paramsu, "FinderLiveEntrance", 152);
      Log.i("MicroMsg.FinderRedDotTrigger", "Finder Reddot Trigger handle quit event cost[%d]", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      AppMethodBeat.o(366881);
      return false;
    }
    catch (Exception paramsu)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.FinderRedDotTrigger", paramsu, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.FinderRedDotTrigger.2
 * JD-Core Version:    0.7.0.1
 */