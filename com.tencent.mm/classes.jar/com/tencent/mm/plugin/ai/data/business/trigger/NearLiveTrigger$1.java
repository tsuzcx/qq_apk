package com.tencent.mm.plugin.ai.data.business.trigger;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.su;
import com.tencent.mm.autogen.a.su.a;
import com.tencent.mm.autogen.mmdata.rpt.ai;
import com.tencent.mm.plugin.ai.d.b;
import com.tencent.mm.plugin.ai.d.c;
import com.tencent.mm.plugin.ai.d.d;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.extension.reddot.p;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;

class NearLiveTrigger$1
  extends IListener<su>
{
  NearLiveTrigger$1(e parame, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(267571);
    this.__eventId = su.class.getName().hashCode();
    AppMethodBeat.o(267571);
  }
  
  private boolean a(su paramsu)
  {
    AppMethodBeat.i(267589);
    Object localObject;
    int i;
    long l1;
    for (;;)
    {
      try
      {
        localObject = this.qnn;
        Log.d("MicroMsg.NearLiveTrigger", "quit notify live sync toSid [%s] quitControlMap[%s]", new Object[] { paramsu.hWe.hWf, ((e)localObject).qmW });
        if (((e)localObject).qmW.contains(paramsu.hWe.hWf))
        {
          i = Util.getInt(paramsu.hWe.hWf, -1);
          if ((i >= 0) && (i < 255)) {
            continue;
          }
        }
        l1 = Util.currentTicks();
        if ("152".equals(paramsu.hWe.hWf))
        {
          boolean bool = "150".equals(paramsu.hWe.hWf);
          if (!bool) {
            continue;
          }
        }
      }
      catch (Exception paramsu)
      {
        Log.printErrStackTrace("MicroMsg.NearLiveTrigger", paramsu, "", new Object[0]);
        continue;
        localObject = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("FinderLiveEntrance");
        if (localObject != null) {
          break label411;
        }
      }
      AppMethodBeat.o(267589);
      return false;
      ((e)localObject).yL(i);
      String.format("live quit find more friends ui [%d] ", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.plugin.report.service.h.OAn.p(1559L, 210L, 1L);
      continue;
      localObject = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("NearbyEntrance");
      label222:
      if (localObject != null)
      {
        b localb = com.tencent.mm.plugin.ai.d.e.caH().qps.TS(((p)localObject).field_tipsId);
        paramsu = localb;
        if (localb == null) {
          break label414;
        }
        localb.field_enterBusinessMs = Util.nowMilliSecond();
        com.tencent.mm.plugin.ai.d.e.caH().qps.b(localb);
        paramsu = localb;
        break label414;
      }
    }
    for (;;)
    {
      long l2 = Util.currentTicks();
      com.tencent.mm.plugin.ai.d.e.caH();
      localObject = d.TV("calendar_statistics_live");
      if (localObject != null)
      {
        ((ai)localObject).iom += 1L;
        if (i != 0) {
          ((ai)localObject).ion += 1L;
        }
        com.tencent.mm.plugin.ai.d.e.caH();
        d.a("calendar_statistics_live", (ai)localObject);
        Log.i("MicroMsg.NearLiveTrigger", "noteEnterLive info[%s] cost[%d]", new Object[] { ((ai)localObject).aIF(), Long.valueOf(Util.ticksToNow(l2)) });
      }
      l1 = Util.ticksToNow(l1);
      if (paramsu != null) {}
      for (;;)
      {
        Log.i("MicroMsg.NearLiveTrigger", "check if enter finder cost[%d] info[%s]", new Object[] { Long.valueOf(l1), paramsu });
        break;
        paramsu = "null";
      }
      paramsu = null;
      break label414;
      label411:
      break label222;
      label414:
      if (localObject != null) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.trigger.NearLiveTrigger.1
 * JD-Core Version:    0.7.0.1
 */