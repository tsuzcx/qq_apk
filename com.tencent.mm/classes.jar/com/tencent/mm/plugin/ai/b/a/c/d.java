package com.tencent.mm.plugin.ai.b.a.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.dx;
import com.tencent.mm.f.a.dx.a;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.f.a.me;
import com.tencent.mm.plugin.ai.f.f;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pointers.PFloat;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public final class d
  implements c
{
  private IListener<me> noa;
  HashSet<String> npj;
  private IListener<fw> npp;
  long npr;
  long nps;
  private IListener<dx> npt;
  
  protected d()
  {
    AppMethodBeat.i(240305);
    this.npr = 0L;
    this.nps = 300000L;
    this.npj = null;
    this.noa = new d.1(this);
    this.npt = new IListener()
    {
      private boolean a(dx paramAnonymousdx)
      {
        AppMethodBeat.i(239153);
        for (;;)
        {
          try
          {
            locald = d.this;
            if (locald.npj != null)
            {
              i = locald.npj.size();
              if (i > 0) {
                continue;
              }
            }
          }
          catch (Exception paramAnonymousdx)
          {
            d locald;
            int i;
            continue;
          }
          AppMethodBeat.o(239153);
          return false;
          if (locald.npj.contains(paramAnonymousdx.fzu.fzr))
          {
            i = Util.getInt(paramAnonymousdx.fzu.fzr, -1);
            if ((i >= 0) && (i < 255)) {
              if (Util.milliSecondsToNow(locald.npr) <= locald.nps)
              {
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1559L, 221L, 1L, false);
              }
              else
              {
                locald.npr = Util.nowMilliSecond();
                com.tencent.e.h.ZvG.d(new d.4(locald, paramAnonymousdx), "Ai_thread");
              }
            }
          }
        }
      }
    };
    this.npp = new d.3(this);
    bBe();
    AppMethodBeat.o(240305);
  }
  
  static String L(String paramString, long paramLong)
  {
    AppMethodBeat.i(240319);
    long l = Util.currentTicks();
    Object localObject;
    try
    {
      com.tencent.mm.ad.i locali = new com.tencent.mm.ad.i();
      locali.g("lastSid", paramString);
      locali.s("lastSidStayMs", paramLong);
      paramString = new ArrayList();
      com.tencent.mm.plugin.ai.b.a.b.c.bBc();
      localObject = com.tencent.mm.plugin.ai.b.a.b.c.bBd();
      if (((ArrayList)localObject).size() <= 0) {
        break label197;
      }
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.f.b.a.i locali1 = (com.tencent.mm.f.b.a.i)((Iterator)localObject).next();
        paramString.add(String.format("{\"index\":%d,\"type\":%s,\"isTop\":%d,\"lastTime\":%d,\"sil\":%d,\"unread\":%d}", new Object[] { Long.valueOf(locali1.gdX), locali1.gdY, Long.valueOf(locali1.gdZ), Long.valueOf(locali1.gea), Long.valueOf(locali1.geb), Long.valueOf(locali1.gec) }));
      }
      Log.printErrStackTrace("MicroMsg.LiveNotifyMsgTrigger", localException1, "checkDataToNotify error", new Object[0]);
    }
    catch (Exception localException1)
    {
      paramString = "";
    }
    AppMethodBeat.o(240319);
    return paramString;
    label197:
    localException1.g("sessions", paramString);
    int i = 0;
    paramString = com.tencent.mm.plugin.audio.c.a.crn().audioManager;
    if (paramString != null) {
      if (!paramString.isWiredHeadsetOn()) {
        break label480;
      }
    }
    label228:
    boolean bool;
    for (i = 3;; i = 1)
    {
      Log.i("MicroMsg.AiDeviceData", "get current audio mode [%d]", new Object[] { Integer.valueOf(i) });
      localException1.al("headset", 0);
      localException1.al("netType", NetStatusUtil.getIOSOldNetType(MMApplicationContext.getContext()));
      if (!com.tencent.mm.plugin.ai.b.a.b.c.bBc().npc) {
        break label635;
      }
      i = 1;
      label280:
      localException1.al("dueToNotification", i);
      com.tencent.mm.plugin.ai.b.a.b.c.bBc();
      localException1.al("onlineDevice", ((o)com.tencent.mm.kernel.h.ae(o.class)).boa());
      paramString = new PFloat();
      localObject = new IntentFilter("android.intent.action.BATTERY_CHANGED");
      localObject = MMApplicationContext.getContext().registerReceiver(null, (IntentFilter)localObject);
      if (localObject != null) {
        break;
      }
      Log.w("MicroMsg.AiDeviceData", "get battery charge intent is null");
      bool = false;
      label360:
      localException1.g("battery", String.format("%.2f", new Object[] { Float.valueOf(paramString.value) }));
      if (!bool) {
        break label615;
      }
      i = 1;
      label396:
      localException1.al("isCharge", i);
      i = com.tencent.mm.plugin.ai.c.a.He(Util.nowMilliSecond());
      localException1.s("weekHourStayMs", com.tencent.mm.plugin.ai.f.b.bBr().nqH.yI(i));
      paramLong = Util.ticksToNow(l);
      localException1.s("cost", paramLong);
      paramString = localException1.toString();
      label480:
      try
      {
        Log.i("MicroMsg.LiveNotifyMsgTrigger", "checkDataToNotify cost[%d]", new Object[] { Long.valueOf(paramLong) });
        AppMethodBeat.o(240319);
        return paramString;
      }
      catch (Exception localException2) {}
      if ((paramString.isBluetoothA2dpOn()) || (paramString.isBluetoothScoOn())) {
        break label625;
      }
      if (!paramString.isSpeakerphoneOn()) {
        break label630;
      }
    }
    i = ((Intent)localObject).getIntExtra("status", -1);
    if (i != 2) {
      if (i == 5) {
        break label640;
      }
    }
    for (;;)
    {
      i = ((Intent)localObject).getIntExtra("level", -1);
      int j = ((Intent)localObject).getIntExtra("scale", -1);
      if ((i >= 0) && (j > 0)) {
        paramString.value = (i * 1.0F / (j * 1.0F));
      }
      Log.i("MicroMsg.AiDeviceData", "get battery charge and level charging[%b] level[%f]", new Object[] { Boolean.valueOf(bool), Float.valueOf(paramString.value) });
      break label360;
      bool = false;
      continue;
      label615:
      i = 0;
      break label396;
      break;
      label625:
      i = 4;
      break label228;
      label630:
      i = 2;
      break label228;
      label635:
      i = 0;
      break label280;
      label640:
      bool = true;
    }
  }
  
  private static HashSet<String> abt(String paramString)
  {
    AppMethodBeat.i(240311);
    HashSet localHashSet = new HashSet();
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(240311);
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
    AppMethodBeat.o(240311);
    return localHashSet;
  }
  
  public final void OO()
  {
    AppMethodBeat.i(240306);
    EventCenter.instance.add(this.npt);
    EventCenter.instance.add(this.npp);
    EventCenter.instance.add(this.noa);
    AppMethodBeat.o(240306);
  }
  
  final void bBe()
  {
    AppMethodBeat.i(240309);
    this.npj = abt(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vYw, ""));
    this.nps = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vYx, 300000L);
    Log.i("MicroMsg.LiveNotifyMsgTrigger", "reset control enterControlMap[%s] reqFreqControl[%d]", new Object[] { this.npj, Long.valueOf(this.nps) });
    AppMethodBeat.o(240309);
  }
  
  public final void unRegister()
  {
    AppMethodBeat.i(240307);
    EventCenter.instance.removeListener(this.npt);
    EventCenter.instance.removeListener(this.npp);
    EventCenter.instance.removeListener(this.noa);
    AppMethodBeat.o(240307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.b.a.c.d
 * JD-Core Version:    0.7.0.1
 */