package com.tencent.mm.plugin.ai.data.business.trigger;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.su;
import com.tencent.mm.autogen.a.su.a;
import com.tencent.mm.autogen.mmdata.rpt.ai;
import com.tencent.mm.autogen.mmdata.rpt.ip;
import com.tencent.mm.plugin.ai.d.c;
import com.tencent.mm.plugin.ai.d.d;
import com.tencent.mm.plugin.ai.d.e;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.extension.reddot.p;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;

class FinderTrigger$1
  extends IListener<su>
{
  FinderTrigger$1(b paramb, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(267651);
    this.__eventId = su.class.getName().hashCode();
    AppMethodBeat.o(267651);
  }
  
  private boolean a(su paramsu)
  {
    AppMethodBeat.i(267676);
    for (;;)
    {
      Object localObject3;
      Object localObject1;
      boolean bool;
      int i;
      try
      {
        Object localObject2 = this.qnh;
        long l1 = Util.currentTicks();
        if (paramsu.hWe.hWf.equals("143"))
        {
          localObject3 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("FinderEntrance");
          if (localObject3 == null) {
            continue;
          }
          localObject1 = e.caH().qps.TS(((p)localObject3).field_tipsId);
          if (localObject1 != null)
          {
            com.tencent.mm.plugin.ai.data.business.global.b.bZW();
            bxq localbxq = com.tencent.mm.plugin.ai.data.business.global.b.a((p)localObject3);
            if ((localbxq != null) && (localbxq.aagu != null))
            {
              ((com.tencent.mm.plugin.ai.d.b)localObject1).field_exposeCount = localbxq.aagu.ZlK;
              ((com.tencent.mm.plugin.ai.d.b)localObject1).field_exposeFirstMs = localbxq.aagu.ZlM;
              ((com.tencent.mm.plugin.ai.d.b)localObject1).field_exposeLastMs = localbxq.aagu.ZlO;
            }
            ((com.tencent.mm.plugin.ai.d.b)localObject1).field_enterBusinessMs = Util.nowMilliSecond();
            e.caH().qps.b((com.tencent.mm.plugin.ai.d.b)localObject1);
          }
          if (((p)localObject3).field_aiScene < 10000L) {
            continue;
          }
          com.tencent.mm.plugin.report.service.h.OAn.p(1559L, 243L, 1L);
          break label670;
          long l2 = Util.currentTicks();
          e.caH();
          localObject3 = d.TV("calendar_statistics_finder");
          if (localObject3 != null)
          {
            ((ai)localObject3).iom += 1L;
            if (bool) {
              ((ai)localObject3).ion += 1L;
            }
            e.caH();
            d.a("calendar_statistics_finder", (ai)localObject3);
            ((b)localObject2).qnc = bool;
            Log.i("MicroMsg.FinderTrigger", "noteEnterFinder info[%s] isEnterFinderWithRedDot[%b] cost[%d]", new Object[] { ((ai)localObject3).aIF(), Boolean.valueOf(((b)localObject2).qnc), Long.valueOf(Util.ticksToNow(l2)) });
          }
          l1 = Util.ticksToNow(l1);
          if (localObject1 == null) {
            break label687;
          }
          Log.i("MicroMsg.FinderTrigger", "check if enter finder cost[%d] info[%s]", new Object[] { Long.valueOf(l1), localObject1 });
        }
        localObject1 = new ip();
        ((ip)localObject1).ixm = ((ip)localObject1).F("Sessionid", paramsu.hWe.hWf, true);
        ((ip)localObject1).fc(paramsu.hWe.hWh);
        localObject2 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("FinderEntrance");
        localObject3 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("FinderEntrance");
        if (localObject3 != null)
        {
          ((ip)localObject1).ira = ((ip)localObject1).F("RedDotTipsID", ((p)localObject3).field_tipsId, true);
          ((ip)localObject1).iJM = ((p)localObject3).field_ctrInfo.type;
          ((ip)localObject1).iQu = ((p)localObject3).field_aiScene;
        }
        if (localObject2 != null) {
          ((ip)localObject1).iJP = ((bxq)localObject2).show_type;
        }
        ((ip)localObject1).bMH();
        Log.i("MicroMsg.FinderTrigger", "reportFinderRedDotInfo [%s]", new Object[] { ((ip)localObject1).aIF() });
        localObject1 = this.qnh;
        Log.d("MicroMsg.FinderTrigger", "quit notify live sync toSid [%s] quitControlMap[%s]", new Object[] { paramsu.hWe.hWf, ((b)localObject1).qmW });
        if (((b)localObject1).qmW.contains(paramsu.hWe.hWf))
        {
          i = Util.getInt(paramsu.hWe.hWf, -1);
          if (i >= 0) {
            if (i < 255) {
              break label630;
            }
          }
        }
      }
      catch (Exception paramsu)
      {
        Log.printErrStackTrace("MicroMsg.FinderTrigger", paramsu, "", new Object[0]);
        continue;
        com.tencent.mm.plugin.report.service.h.OAn.p(1559L, 241L, 1L);
        localObject1 = null;
      }
      AppMethodBeat.o(267676);
      return false;
      com.tencent.mm.plugin.report.service.h.OAn.p(1559L, 242L, 1L);
      break label670;
      label630:
      ((b)localObject1).yK(i);
      String.format("finder quit find more friends ui [%d] ", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.plugin.report.service.h.OAn.p(1559L, 200L, 1L);
      continue;
      label670:
      if (localObject3 != null)
      {
        bool = true;
      }
      else
      {
        bool = false;
        continue;
        label687:
        localObject1 = "null";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.trigger.FinderTrigger.1
 * JD-Core Version:    0.7.0.1
 */