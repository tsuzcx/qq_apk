package com.tencent.mm.plugin.expt.g;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.l;
import com.tencent.mm.g.a.mi;
import com.tencent.mm.g.b.a.ft;
import com.tencent.mm.g.b.a.gw;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.expt.b.e.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class d
  implements Application.ActivityLifecycleCallbacks, com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.expt.b.e
{
  private static int[] sKk = { 10, 1000, 10000, 100000 };
  private static boolean sKl = false;
  private static d sKm;
  private IListener<l> appListener;
  private boolean sKn;
  private boolean sKo;
  private String sKp;
  private HashSet<String> sKq;
  private IListener sKr;
  
  private d()
  {
    AppMethodBeat.i(122370);
    this.sKn = false;
    this.sKo = false;
    this.sKp = "";
    this.sKq = new HashSet();
    this.appListener = new IListener() {};
    this.sKr = new IListener()
    {
      private boolean cRx()
      {
        AppMethodBeat.i(122367);
        Log.i("MicroMsg.MMPageFlowService", "manual force login");
        if (!d.a(d.this))
        {
          d.b(d.this);
          com.tencent.mm.plugin.expt.hellhound.a.c.c.a(105, null, 0, System.currentTimeMillis());
          com.tencent.mm.plugin.expt.hellhound.a.c.c.cPx();
          com.tencent.mm.plugin.expt.hellhound.a.c.a.Hi(7);
          com.tencent.mm.plugin.expt.hellhound.core.b.a.a.GQ(7);
        }
        AppMethodBeat.o(122367);
        return false;
      }
    };
    if (!MMApplicationContext.isMMProcess()) {
      sKl = true;
    }
    AppMethodBeat.o(122370);
  }
  
  private void a(Activity paramActivity, e.a parama)
  {
    AppMethodBeat.i(122373);
    if (paramActivity != null) {
      b(paramActivity.getComponentName().getClassName(), parama, paramActivity.hashCode(), System.currentTimeMillis());
    }
    AppMethodBeat.o(122373);
  }
  
  private void a(String paramString, e.a parama, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(122375);
    long l1 = Util.currentTicks();
    if (!MMApplicationContext.isMMProcess())
    {
      if (c.sKi == null) {
        c.sKi = new c();
      }
      Object localObject1 = c.sKi;
      Log.i("MicroMsg.MMPageFlowSenderByIPCInvoker", "%s send page flow [%s-%d-%d] [%s]", new Object[] { localObject1.hashCode(), paramString, Integer.valueOf(paramInt1), Long.valueOf(paramLong), parama });
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("key_page_flow_type", parama.value);
      ((Bundle)localObject1).putString("key_page_flow_name", paramString);
      ((Bundle)localObject1).putInt("key_page_flow_hashcode", paramInt1);
      ((Bundle)localObject1).putLong("key_page_flow_time_stamp", paramLong);
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(932L, 100L, 1L, false);
      Object localObject3 = ((Bundle)localObject1).getString("key_page_flow_name");
      int i = ((Bundle)localObject1).getInt("key_page_flow_type");
      int j = ((Bundle)localObject1).getInt("key_page_flow_hashcode", 0);
      long l2 = ((Bundle)localObject1).getLong("key_page_flow_time_stamp", 0L);
      String str = new StringBuilder().append(j).append("_").append(l2).toString().hashCode();
      Object localObject2 = new ft();
      ((ft)localObject2).eHx = j;
      localObject3 = ((ft)localObject2).sK((String)localObject3);
      ((ft)localObject3).erY = i;
      ((ft)localObject3).pk(l2);
      localObject3 = b.cRt();
      localObject2 = ((ft)localObject2).abV();
      localObject3 = ((b)localObject3).VQ();
      if (localObject3 != null) {
        ((MultiProcessMMKV)localObject3).putString(str, (String)localObject2);
      }
      com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, (Parcelable)localObject1, c.a.class, null);
      Log.d("MicroMsg.MMPageFlowService", "reportPageFlow: mm-process NOT");
      sKl = true;
    }
    if (!sKl)
    {
      Log.e("MicroMsg.MMPageFlowService", "reportPageFlow: mm-process isAccReady = FALSE");
      AppMethodBeat.o(122375);
      return;
    }
    Log.d("MicroMsg.MMPageFlowService", "reportPageFlow: mm-process YES");
    if (MMApplicationContext.isMMProcess()) {
      cRw();
    }
    a(paramString, parama, paramInt1, paramLong, paramInt2);
    Log.v("MicroMsg.MMPageFlowService", "report page Flow cost[%d]", new Object[] { Long.valueOf(Util.ticksToNow(l1)) });
    AppMethodBeat.o(122375);
  }
  
  private void a(String paramString, e.a parama, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(122378);
    if ((paramString.contains("WeChatSplashActivity")) || (paramString.contains("FakeSwitchAccountUI")))
    {
      AppMethodBeat.o(122378);
      return;
    }
    int i;
    if (parama.value <= 2) {
      i = 0;
    }
    for (;;)
    {
      if (parama == e.a.sxg) {
        this.sKo = true;
      }
      if (parama == e.a.sxh) {
        this.sKo = false;
      }
      Object localObject = new gw();
      ((gw)localObject).euv = paramInt2;
      paramString = ((gw)localObject).uJ(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.aAe().azG()).mProcessName).uK(paramString);
      localObject = sKk;
      paramInt2 = localObject[i];
      localObject[i] = (paramInt2 + 1);
      paramString.eLd = paramInt2;
      paramString.erY = parama.value;
      paramString = paramString.qH(paramLong);
      paramString.eHx = paramInt1;
      e.cRy().a(paramString);
      Log.d("MicroMsg.MMPageFlowService", "%s pure report [%s]", new Object[] { info(), paramString.abW() });
      if ((parama == e.a.sxg) || (parama == e.a.sxh)) {
        Log.i("MicroMsg.MMPageFlowService", "habbyge-mali, %s frontback-pure-report [%s]", new Object[] { info(), paramString.abW() });
      }
      if ((MMApplicationContext.isMMProcess()) && ((parama == e.a.sxg) || (parama == e.a.sxh)))
      {
        r(paramLong, this.sKo);
        com.tencent.mm.plugin.expt.hellhound.a.c.b.Hj(sKk[3]);
      }
      AppMethodBeat.o(122378);
      return;
      if (parama.value <= 4) {
        i = 1;
      } else if (parama.value <= 6) {
        i = 2;
      } else {
        i = 3;
      }
    }
  }
  
  public static d cRu()
  {
    AppMethodBeat.i(122371);
    if (sKm == null) {
      sKm = new d();
    }
    d locald = sKm;
    AppMethodBeat.o(122371);
    return locald;
  }
  
  public static boolean cRv()
  {
    return sKl;
  }
  
  private String info()
  {
    AppMethodBeat.i(122372);
    String str = hashCode();
    AppMethodBeat.o(122372);
    return str;
  }
  
  private void r(final long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(122385);
    if (!sKl)
    {
      AppMethodBeat.o(122385);
      return;
    }
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rUg, 0);
    if (i <= 0)
    {
      AppMethodBeat.o(122385);
      return;
    }
    long l = com.tencent.mm.kernel.g.aAh().azQ().a(ar.a.OiC, 0L);
    if (Util.nowSecond() - l < i)
    {
      AppMethodBeat.o(122385);
      return;
    }
    com.tencent.f.h.RTc.bqo("calc_unread_task");
    com.tencent.f.h.RTc.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(122369);
        d.a(d.this, paramLong, this.deI);
        AppMethodBeat.o(122369);
      }
    }, 5000L, "calc_unread_task");
    AppMethodBeat.o(122385);
  }
  
  private static void reset()
  {
    sKk = new int[] { 10, 1000, 10000, 100000 };
    sKl = false;
  }
  
  public final void a(String paramString, e.a parama, int paramInt, long paramLong)
  {
    AppMethodBeat.i(122379);
    a(paramString, parama, paramInt, paramLong, Process.myPid());
    AppMethodBeat.o(122379);
  }
  
  public final void b(String paramString, e.a parama, int paramInt, long paramLong)
  {
    AppMethodBeat.i(184399);
    a(paramString, parama, paramInt, Process.myPid(), paramLong);
    AppMethodBeat.o(184399);
  }
  
  protected final void cRw()
  {
    AppMethodBeat.i(122377);
    if (!MMApplicationContext.isMMProcess())
    {
      AppMethodBeat.o(122377);
      return;
    }
    long l = Util.currentTicks();
    Object localObject1 = b.cRt().allKeys();
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      int j = localObject1.length;
      int i = 0;
      if (i < j)
      {
        localObject2 = localObject1[i];
        if (!this.sKq.contains(localObject2))
        {
          String str = b.cRt().get((String)localObject2, "");
          if (!Util.isNullOrNil(str))
          {
            ft localft = new ft(str);
            if ((localft.eHx > 0L) && (localft.eHw > 0L))
            {
              localArrayList.add(new ft(str));
              this.sKq.add(localObject2);
            }
            b.cRt().remove((String)localObject2);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          b.cRt().remove((String)localObject2);
        }
      }
    }
    if (!localArrayList.isEmpty())
    {
      Collections.sort(localArrayList, new Comparator() {});
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ft)((Iterator)localObject1).next();
        a(((ft)localObject2).eHv, e.a.GL((int)((ft)localObject2).erY), (int)((ft)localObject2).eHx, ((ft)localObject2).eHw);
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(932L, 102L, localArrayList.size(), false);
      Log.i("MicroMsg.MMPageFlowService", "check mmkv list[%d] cost[%d]", new Object[] { Integer.valueOf(localArrayList.size()), Long.valueOf(Util.ticksToNow(l)) });
    }
    Log.d("MicroMsg.MMPageFlowService", "check mm kv cost[%d]", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(122377);
  }
  
  public final void logout()
  {
    AppMethodBeat.i(122374);
    sKl = false;
    com.tencent.mm.plugin.expt.hellhound.a.c.c.a(106, null, 0, System.currentTimeMillis());
    com.tencent.mm.plugin.expt.hellhound.a.c.c.cPx();
    com.tencent.mm.plugin.expt.hellhound.a.c.a.Hi(8);
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.GQ(8);
    com.tencent.mm.plugin.expt.hellhound.a.c.a.mi(true);
    Log.i("MicroMsg.MMPageFlowService", "habbyge-mali, MMPageFlowService: logout补偿上报");
    AppMethodBeat.o(122374);
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    int i = 1;
    AppMethodBeat.i(122380);
    reset();
    sKl = true;
    com.tencent.mm.plugin.expt.i.c.cSa();
    if (Util.getInt(com.tencent.mm.plugin.expt.i.c.c(b.a.rUo, ""), 0) > 0) {}
    for (;;)
    {
      if (i != 0) {
        EventCenter.instance.add(this.appListener);
      }
      EventCenter.instance.add(this.sKr);
      AppMethodBeat.o(122380);
      return;
      i = 0;
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(122381);
    reset();
    EventCenter.instance.removeListener(this.appListener);
    EventCenter.instance.removeListener(this.sKr);
    this.sKn = false;
    AppMethodBeat.o(122381);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(122384);
    String str = paramActivity.getComponentName().getClassName();
    if ((sKl) && ("com.tencent.mm.ui.LauncherUI".equals(str)) && (this.sKo))
    {
      str = info();
      if (paramActivity == null) {
        break label82;
      }
    }
    label82:
    for (int i = paramActivity.hashCode();; i = -1)
    {
      Log.i("MicroMsg.MMPageFlowService", "%s launcher ui ondestroyed but wechat in foreground hashcode[%d]", new Object[] { str, Integer.valueOf(i) });
      AppMethodBeat.o(122384);
      return;
    }
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(122383);
    a(paramActivity, e.a.sxd);
    AppMethodBeat.o(122383);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(122382);
    a(paramActivity, e.a.sxc);
    AppMethodBeat.o(122382);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.g.d
 * JD-Core Version:    0.7.0.1
 */