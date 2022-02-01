package com.tencent.mm.plugin.ai.data.business.trigger;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.adq.a;
import com.tencent.mm.autogen.a.su;
import com.tencent.mm.autogen.a.su.a;
import com.tencent.mm.autogen.mmdata.rpt.cj;
import com.tencent.mm.plugin.ai.data.business.global.b;
import com.tencent.mm.plugin.ai.data.business.global.c;
import com.tencent.mm.plugin.expt.b.d;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.text.SimpleDateFormat;
import java.util.HashMap;

class FindMoreFriendsUIReporter$1
  extends IListener<su>
{
  FindMoreFriendsUIReporter$1(a parama, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(267592);
    this.__eventId = su.class.getName().hashCode();
    AppMethodBeat.o(267592);
  }
  
  private boolean a(su paramsu)
  {
    int m = 1;
    AppMethodBeat.i(267625);
    int j;
    label69:
    int i;
    label82:
    long l;
    label132:
    label145:
    label157:
    label321:
    label346:
    try
    {
      localObject1 = this.qmU;
      if (Util.isEqual(paramsu.hWe.hWf, "143")) {
        break label928;
      }
      if (!Util.isEqual(paramsu.hWe.hWf, "155")) {
        break label941;
      }
    }
    catch (Exception paramsu) {}
    Object localObject2 = new com.tencent.mm.plugin.ai.d.f();
    int k;
    Object localObject3;
    label410:
    label496:
    cj localcj;
    if (!Util.isNullOrNil(((a)localObject1).qmQ))
    {
      j = 1;
      if (Util.isNullOrNil(((a)localObject1).qmR)) {
        break label952;
      }
      i = 1;
      l = Util.nowMilliSecond();
      ((com.tencent.mm.plugin.ai.d.f)localObject2).field_ds = Util.getInt(com.tencent.mm.plugin.ai.b.a.cav().format(Long.valueOf(l)), -1);
      ((com.tencent.mm.plugin.ai.d.f)localObject2).field_actionMs = l;
      ((com.tencent.mm.plugin.ai.d.f)localObject2).field_hour = com.tencent.mm.plugin.ai.b.a.jv(l);
      if (k == 0) {
        break label957;
      }
      k = 1;
      ((com.tencent.mm.plugin.ai.d.f)localObject2).field_isGoToFinderUI = k;
      if (j == 0) {
        break label963;
      }
      j = 1;
      ((com.tencent.mm.plugin.ai.d.f)localObject2).field_hadFinderRedDot = j;
      if (i == 0) {
        break label968;
      }
      i = 1;
      ((com.tencent.mm.plugin.ai.d.f)localObject2).field_hadFinderLiveRedDot = i;
      com.tencent.threadpool.h.ahAA.g(new a.1((a)localObject1, (com.tencent.mm.plugin.ai.d.f)localObject2), "Ai_thread");
      localObject2 = this.qmU;
      l = Util.currentTicks();
      localObject1 = c.caj().cak();
      localObject3 = new StringBuffer();
      ((StringBuffer)localObject3).append(paramsu.hWe.hEa).append(",");
      ((StringBuffer)localObject3).append("2,");
      ((StringBuffer)localObject3).append(paramsu.hWe.hWf).append(",");
      ((StringBuffer)localObject3).append(paramsu.hWe.hWg).append(",");
      ((StringBuffer)localObject3).append(paramsu.hWe.hWh).append(",");
      ((StringBuffer)localObject3).append(paramsu.hWe.hWh - paramsu.hWe.hWg).append(",");
      i = 0;
      if (i < localObject1.length)
      {
        if (i != 12)
        {
          if (localObject1[i] == 0) {
            break label973;
          }
          j = localObject1[i];
          ((StringBuffer)localObject3).append(j).append(",");
        }
        else
        {
          if (((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().fgE())
          {
            if (localObject1[i] != 0) {}
            for (j = localObject1[i];; j = 2)
            {
              ((StringBuffer)localObject3).append(j).append(",");
              break;
              AppMethodBeat.o(267625);
              return false;
            }
          }
          ((StringBuffer)localObject3).append(-1).append(",");
        }
      }
      else
      {
        localObject3 = new cj(((StringBuffer)localObject3).toString());
        ((cj)localObject3).lz("").lA("").lB("");
        localObject1 = (adq.a)c.caj().qmn.get(Integer.valueOf(2));
        if (localObject1 == null)
        {
          localObject1 = "";
          ((cj)localObject3).lC((String)localObject1);
          if ((Util.isEqual("1", ((cj)localObject3).iwr)) && (Util.isNullOrNil(((a)localObject2).qmQ)))
          {
            b.bZW();
            ((a)localObject2).qmQ = b.TM("FinderEntrance");
          }
          if ((Util.isEqual("1", ((cj)localObject3).iws)) && (Util.isNullOrNil(((a)localObject2).qmR)))
          {
            b.bZW();
            ((a)localObject2).qmR = b.TM("FinderLiveEntrance");
          }
          localcj = ((cj)localObject3).lD(((a)localObject2).qmQ).lE(((a)localObject2).qmR).lF(((d)com.tencent.mm.kernel.h.ax(d.class)).dHN());
          b.bZW();
          if (!b.bZX()) {
            break label983;
          }
          localObject1 = "1";
          label633:
          localcj = localcj.lG((String)localObject1);
          b.bZW();
          if (!b.bZY()) {
            break label991;
          }
          localObject1 = "1";
          label656:
          localcj = localcj.lH((String)localObject1);
          b.bZW();
          if (!b.cae()) {
            break label999;
          }
          localObject1 = "1";
          label679:
          localcj = localcj.lI((String)localObject1);
          b.bZW();
          if (!b.caf()) {
            break label1007;
          }
        }
      }
    }
    label928:
    label941:
    label952:
    label957:
    label963:
    label968:
    label973:
    label978:
    label983:
    label991:
    label999:
    label1007:
    for (Object localObject1 = "1";; localObject1 = "0")
    {
      localcj.lJ((String)localObject1);
      ((cj)localObject3).bMH();
      ((a)localObject2).qmR = "";
      ((a)localObject2).qmQ = "";
      Log.i("MicroMsg.FindMoreFriendsUIReporter", "report find friend getSessionId[%s] IsShowFinderEntrance[%s] IsShowFinderLiveEntrance[%s]IsShowFinderRedDot[%s] IsShowFinderLiveRedDot[%s]", new Object[] { ((cj)localObject3).ijk, ((cj)localObject3).iwz, ((cj)localObject3).iwB, ((cj)localObject3).iwA, ((cj)localObject3).iwC });
      Log.i("MicroMsg.FindMoreFriendsUIReporter", "report find friend cost[%d] [%s]", new Object[] { Long.valueOf(Util.ticksToNow(l)), ((cj)localObject3).aIF() });
      i = Util.getInt(paramsu.hWe.hWf, -1);
      if ((i < 0) || (i >= 255))
      {
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1437L, 255L, 1L, false);
        break label410;
        j = ((adq.a)localObject1).idY;
        if (!((adq.a)localObject1).ihQ) {
          break label978;
        }
      }
      for (i = m;; i = 0)
      {
        localObject1 = String.format("{\"tabId\":%d;\"redDot\":%d;\"unread\":%d}", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(((adq.a)localObject1).ihR) });
        break label496;
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1437L, i, 1L, false);
        break label410;
        k = 1;
        break;
        i += 1;
        break label321;
        k = 0;
        break;
        j = 0;
        break label69;
        i = 0;
        break label82;
        k = 0;
        break label132;
        j = 0;
        break label145;
        i = 0;
        break label157;
        j = 2;
        break label346;
      }
      localObject1 = "0";
      break label633;
      localObject1 = "0";
      break label656;
      localObject1 = "0";
      break label679;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.trigger.FindMoreFriendsUIReporter.1
 * JD-Core Version:    0.7.0.1
 */