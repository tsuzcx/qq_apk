package com.tencent.mm.plugin.finder.extension.reddot;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.eg;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.j;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

class FinderRedDotTrigger$1
  extends IListener<eg>
{
  FinderRedDotTrigger$1(o paramo, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(366859);
    this.__eventId = eg.class.getName().hashCode();
    AppMethodBeat.o(366859);
  }
  
  private boolean a(eg parameg)
  {
    AppMethodBeat.i(366873);
    long l = Util.currentTicks();
    if ((parameg == null) || (parameg.hDZ == null))
    {
      AppMethodBeat.o(366873);
      return false;
    }
    try
    {
      o.avI("FinderEntrance");
      o.avI("NearbyEntrance");
      o.avI("FinderLiveEntrance");
      boolean bool1 = this.ASv.avG("FinderEntrance");
      boolean bool2 = this.ASv.avG("NearbyEntrance");
      boolean bool3 = this.ASv.avG("FinderLiveEntrance");
      boolean bool4 = this.ASv.avH("FinderEntrance");
      boolean bool5 = this.ASv.avH("NearbyEntrance");
      bool1 = this.ASv.avH("FinderLiveEntrance") | bool1 | false | bool2 | bool3 | bool4 | bool5;
      if (bool1) {
        ((PluginFinder)h.az(PluginFinder.class)).getFinderSyncExtension().ho(113149, 10);
      }
      Log.i("MicroMsg.FinderRedDotTrigger", "Finder Reddot Trigger handle enter event cost[%d] needSync[%b]", new Object[] { Long.valueOf(Util.ticksToNow(l)), Boolean.valueOf(bool1) });
    }
    catch (Exception parameg)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.FinderRedDotTrigger", parameg, "", new Object[0]);
      }
    }
    AppMethodBeat.o(366873);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.FinderRedDotTrigger.1
 * JD-Core Version:    0.7.0.1
 */