package com.tencent.mm.plugin.ai.data.business.trigger;

import com.tencent.d.a.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.eh;
import com.tencent.mm.autogen.a.eh.a;
import com.tencent.mm.autogen.a.gh;
import com.tencent.mm.autogen.a.nk;
import com.tencent.mm.autogen.mmdata.rpt.j;
import com.tencent.mm.plugin.ai.d.e;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.pointers.PFloat;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class d
  implements c
{
  private IListener<nk> qlh;
  HashSet<String> qmX;
  private IListener<gh> qng;
  long qni;
  long qnj;
  private IListener<eh> qnk;
  
  protected d()
  {
    AppMethodBeat.i(267611);
    this.qni = 0L;
    this.qnj = 300000L;
    this.qmX = null;
    this.qlh = new LiveNotifyMsgTrigger.1(this, com.tencent.mm.app.f.hfK);
    this.qnk = new LiveNotifyMsgTrigger.2(this, com.tencent.mm.app.f.hfK);
    this.qng = new LiveNotifyMsgTrigger.3(this, com.tencent.mm.app.f.hfK);
    bZN();
    AppMethodBeat.o(267611);
  }
  
  static String P(String paramString, long paramLong)
  {
    AppMethodBeat.i(267643);
    long l = Util.currentTicks();
    try
    {
      com.tencent.mm.ad.i locali = new com.tencent.mm.ad.i();
      locali.m("lastSid", paramString);
      locali.t("lastSidStayMs", paramLong);
      paramString = new ArrayList();
      com.tencent.mm.plugin.ai.data.business.global.f.cao();
      Object localObject = com.tencent.mm.plugin.ai.data.business.global.f.cap();
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          j localj = (j)((Iterator)localObject).next();
          paramString.add(String.format("{\"index\":%d,\"type\":%s,\"isTop\":%d,\"lastTime\":%d,\"sil\":%d,\"unread\":%d}", new Object[] { Long.valueOf(localj.ikr), localj.iks, Long.valueOf(localj.ikt), Long.valueOf(localj.iku), Long.valueOf(localj.ikv), Long.valueOf(localj.ikw) }));
          continue;
          Log.printErrStackTrace("MicroMsg.LiveNotifyMsgTrigger", localException1, "checkDataToNotify error", new Object[0]);
        }
      }
    }
    catch (Exception localException1)
    {
      paramString = "";
    }
    for (;;)
    {
      AppMethodBeat.o(267643);
      return paramString;
      localException1.m("sessions", paramString);
      localException1.au("headset", com.tencent.mm.plugin.ai.data.business.global.a.bZV());
      localException1.au("netType", NetStatusUtil.getIOSOldNetType(MMApplicationContext.getContext()));
      if (com.tencent.mm.plugin.ai.data.business.global.f.cao().qmE)
      {
        i = 1;
        localException1.au("dueToNotification", i);
        com.tencent.mm.plugin.ai.data.business.global.f.cao();
        paramString = ((q)com.tencent.mm.kernel.h.ax(q.class)).bLO();
        if ((paramString == null) || (paramString.size() <= 0)) {
          break label447;
        }
        i = ((Integer)paramString.get(0)).intValue();
        label301:
        localException1.au("onlineDevice", i);
        paramString = new PFloat();
        boolean bool = com.tencent.mm.plugin.ai.data.business.global.a.a(paramString);
        localException1.m("battery", String.format("%.2f", new Object[] { Float.valueOf(paramString.value) }));
        if (!bool) {
          break label452;
        }
      }
      label447:
      label452:
      for (int i = 1;; i = 0)
      {
        localException1.au("isCharge", i);
        i = com.tencent.mm.plugin.ai.b.a.jv(Util.nowMilliSecond());
        localException1.t("weekHourStayMs", e.caH().qpq.yQ(i));
        paramLong = Util.ticksToNow(l);
        localException1.t("cost", paramLong);
        paramString = localException1.toString();
        try
        {
          Log.i("MicroMsg.LiveNotifyMsgTrigger", "checkDataToNotify cost[%d]", new Object[] { Long.valueOf(paramLong) });
          AppMethodBeat.o(267643);
          return paramString;
        }
        catch (Exception localException2) {}
        i = 0;
        break;
        i = 0;
        break label301;
      }
    }
  }
  
  private static HashSet<String> TN(String paramString)
  {
    AppMethodBeat.i(267623);
    HashSet localHashSet = new HashSet();
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(267623);
      return localHashSet;
    }
    paramString = paramString.split(",");
    if ((paramString != null) && (paramString.length > 0))
    {
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        localHashSet.add(paramString[i]);
        i += 1;
      }
    }
    AppMethodBeat.o(267623);
    return localHashSet;
  }
  
  public final void aoW()
  {
    AppMethodBeat.i(267647);
    this.qnk.alive();
    this.qng.alive();
    this.qlh.alive();
    AppMethodBeat.o(267647);
  }
  
  final void bZN()
  {
    AppMethodBeat.i(267667);
    this.qmX = TN(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zry, ""));
    this.qnj = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zrz, 300000L);
    Log.i("MicroMsg.LiveNotifyMsgTrigger", "reset control enterControlMap[%s] reqFreqControl[%d]", new Object[] { this.qmX, Long.valueOf(this.qnj) });
    AppMethodBeat.o(267667);
  }
  
  public final void unRegister()
  {
    AppMethodBeat.i(267655);
    this.qnk.dead();
    this.qng.dead();
    this.qlh.dead();
    AppMethodBeat.o(267655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.trigger.d
 * JD-Core Version:    0.7.0.1
 */