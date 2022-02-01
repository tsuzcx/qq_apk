package com.tencent.mm.plugin.expt.g;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.l;
import com.tencent.mm.f.a.mz;
import com.tencent.mm.f.b.a.hm;
import com.tencent.mm.f.b.a.jb;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.f.c;
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
  private static int[] wqi = { 10, 1000, 10000, 100000 };
  private static boolean wqj = false;
  private static d wqk;
  private IListener<l> appListener;
  private boolean wql;
  private boolean wqm;
  private String wqn;
  private HashSet<String> wqo;
  private IListener wqp;
  
  private d()
  {
    AppMethodBeat.i(122370);
    this.wql = false;
    this.wqm = false;
    this.wqn = "";
    this.wqo = new HashSet();
    this.appListener = new IListener() {};
    this.wqp = new IListener()
    {
      private boolean dgs()
      {
        AppMethodBeat.i(122367);
        Log.i("MicroMsg.MMPageFlowService", "manual force login");
        if (!d.a(d.this))
        {
          d.b(d.this);
          com.tencent.mm.plugin.expt.hellhound.a.c.c.a(105, null, 0, System.currentTimeMillis());
          com.tencent.mm.plugin.expt.hellhound.a.c.c.der();
          com.tencent.mm.plugin.expt.hellhound.a.c.a.KS(7);
          com.tencent.mm.plugin.expt.hellhound.core.b.a.a.KA(7);
        }
        AppMethodBeat.o(122367);
        return false;
      }
    };
    if (!MMApplicationContext.isMMProcess()) {
      wqj = true;
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
      if (c.wqg == null) {
        c.wqg = new c();
      }
      Object localObject1 = c.wqg;
      Log.i("MicroMsg.MMPageFlowSenderByIPCInvoker", "%s send page flow [%s-%d-%d] [%s]", new Object[] { localObject1.hashCode(), paramString, Integer.valueOf(paramInt1), Long.valueOf(paramLong), parama });
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("key_page_flow_type", parama.value);
      ((Bundle)localObject1).putString("key_page_flow_name", paramString);
      ((Bundle)localObject1).putInt("key_page_flow_hashcode", paramInt1);
      ((Bundle)localObject1).putLong("key_page_flow_time_stamp", paramLong);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(932L, 100L, 1L, false);
      Object localObject3 = ((Bundle)localObject1).getString("key_page_flow_name");
      int i = ((Bundle)localObject1).getInt("key_page_flow_type");
      int j = ((Bundle)localObject1).getInt("key_page_flow_hashcode", 0);
      long l2 = ((Bundle)localObject1).getLong("key_page_flow_time_stamp", 0L);
      String str = new StringBuilder().append(j).append("_").append(l2).toString().hashCode();
      Object localObject2 = new hm();
      ((hm)localObject2).gFY = j;
      localObject3 = ((hm)localObject2).wy((String)localObject3);
      ((hm)localObject3).goe = i;
      ((hm)localObject3).rA(l2);
      localObject3 = b.dgo();
      localObject2 = ((hm)localObject2).agH();
      localObject3 = ((b)localObject3).aal();
      if (localObject3 != null) {
        ((MultiProcessMMKV)localObject3).putString(str, (String)localObject2);
      }
      j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localObject1, c.a.class, null);
      Log.d("MicroMsg.MMPageFlowService", "reportPageFlow: mm-process NOT");
      wqj = true;
    }
    if (!wqj)
    {
      Log.e("MicroMsg.MMPageFlowService", "reportPageFlow: mm-process isAccReady = FALSE");
      AppMethodBeat.o(122375);
      return;
    }
    Log.d("MicroMsg.MMPageFlowService", "reportPageFlow: mm-process YES");
    if (MMApplicationContext.isMMProcess()) {
      dgr();
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
      if (parama == e.a.wcI) {
        this.wqm = true;
      }
      if (parama == e.a.wcJ) {
        this.wqm = false;
      }
      Object localObject = new jb();
      ((jb)localObject).gqB = paramInt2;
      paramString = ((jb)localObject).Ag(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).mProcessName).Ah(paramString);
      localObject = wqi;
      paramInt2 = localObject[i];
      localObject[i] = (paramInt2 + 1);
      paramString.gKH = paramInt2;
      paramString.goe = parama.value;
      paramString = paramString.uo(paramLong);
      paramString.gFY = paramInt1;
      e.dgt().a(paramString);
      Log.d("MicroMsg.MMPageFlowService", "%s pure report [%s]", new Object[] { info(), paramString.agI() });
      if ((parama == e.a.wcI) || (parama == e.a.wcJ)) {
        Log.i("MicroMsg.MMPageFlowService", "habbyge-mali, %s frontback-pure-report [%s]", new Object[] { info(), paramString.agI() });
      }
      if ((MMApplicationContext.isMMProcess()) && ((parama == e.a.wcI) || (parama == e.a.wcJ)))
      {
        r(paramLong, this.wqm);
        com.tencent.mm.plugin.expt.hellhound.a.c.b.KT(wqi[3]);
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
  
  public static d dgp()
  {
    AppMethodBeat.i(122371);
    if (wqk == null) {
      wqk = new d();
    }
    d locald = wqk;
    AppMethodBeat.o(122371);
    return locald;
  }
  
  public static boolean dgq()
  {
    return wqj;
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
    if (!wqj)
    {
      AppMethodBeat.o(122385);
      return;
    }
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vAQ, 0);
    if (i <= 0)
    {
      AppMethodBeat.o(122385);
      return;
    }
    long l = com.tencent.mm.kernel.h.aHG().aHp().a(ar.a.VwS, 0L);
    if (Util.nowSecond() - l < i)
    {
      AppMethodBeat.o(122385);
      return;
    }
    com.tencent.e.h.ZvG.bDh("calc_unread_task");
    com.tencent.e.h.ZvG.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(122369);
        d.a(d.this, paramLong, this.diM);
        AppMethodBeat.o(122369);
      }
    }, 5000L, "calc_unread_task");
    AppMethodBeat.o(122385);
  }
  
  private static void reset()
  {
    wqi = new int[] { 10, 1000, 10000, 100000 };
    wqj = false;
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
  
  public final void dbv()
  {
    AppMethodBeat.i(122374);
    wqj = false;
    com.tencent.mm.plugin.expt.hellhound.a.c.c.a(106, null, 0, System.currentTimeMillis());
    com.tencent.mm.plugin.expt.hellhound.a.c.c.der();
    com.tencent.mm.plugin.expt.hellhound.a.c.a.KS(8);
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.KA(8);
    com.tencent.mm.plugin.expt.hellhound.a.c.a.nv(true);
    Log.i("MicroMsg.MMPageFlowService", "habbyge-mali, MMPageFlowService: logout补偿上报");
    AppMethodBeat.o(122374);
  }
  
  protected final void dgr()
  {
    AppMethodBeat.i(122377);
    if (!MMApplicationContext.isMMProcess())
    {
      AppMethodBeat.o(122377);
      return;
    }
    long l = Util.currentTicks();
    Object localObject1 = b.dgo().allKeys();
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      int j = localObject1.length;
      int i = 0;
      if (i < j)
      {
        localObject2 = localObject1[i];
        if (!this.wqo.contains(localObject2))
        {
          String str = b.dgo().L((String)localObject2, "");
          if (!Util.isNullOrNil(str))
          {
            hm localhm = new hm(str);
            if ((localhm.gFY > 0L) && (localhm.gFX > 0L))
            {
              localArrayList.add(new hm(str));
              this.wqo.add(localObject2);
            }
            b.dgo().remove((String)localObject2);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          b.dgo().remove((String)localObject2);
        }
      }
    }
    if (!localArrayList.isEmpty())
    {
      Collections.sort(localArrayList, new Comparator() {});
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (hm)((Iterator)localObject1).next();
        a(((hm)localObject2).gFW, e.a.Kt((int)((hm)localObject2).goe), (int)((hm)localObject2).gFY, ((hm)localObject2).gFX);
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(932L, 102L, localArrayList.size(), false);
      Log.i("MicroMsg.MMPageFlowService", "check mmkv list[%d] cost[%d]", new Object[] { Integer.valueOf(localArrayList.size()), Long.valueOf(Util.ticksToNow(l)) });
    }
    Log.d("MicroMsg.MMPageFlowService", "check mm kv cost[%d]", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(122377);
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    int i = 1;
    AppMethodBeat.i(122380);
    reset();
    wqj = true;
    com.tencent.mm.plugin.expt.i.c.dgZ();
    if (Util.getInt(com.tencent.mm.plugin.expt.i.c.c(b.a.vAY, ""), 0) > 0) {}
    for (;;)
    {
      if (i != 0) {
        EventCenter.instance.add(this.appListener);
      }
      EventCenter.instance.add(this.wqp);
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
    EventCenter.instance.removeListener(this.wqp);
    this.wql = false;
    AppMethodBeat.o(122381);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(122384);
    String str = paramActivity.getComponentName().getClassName();
    if ((wqj) && ("com.tencent.mm.ui.LauncherUI".equals(str)) && (this.wqm))
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
    a(paramActivity, e.a.wcF);
    AppMethodBeat.o(122383);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(122382);
    a(paramActivity, e.a.wcE);
    AppMethodBeat.o(122382);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.g.d
 * JD-Core Version:    0.7.0.1
 */