package com.tencent.mm.plugin.expt.pageflow;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.n;
import com.tencent.mm.autogen.mmdata.rpt.jk;
import com.tencent.mm.autogen.mmdata.rpt.ll;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.expt.b.f.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class d
  implements Application.ActivityLifecycleCallbacks, com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.expt.b.f
{
  private static int[] zMk = { 10, 1000, 10000, 100000 };
  private static boolean zMl = false;
  private static d zMm;
  private IListener<n> appListener;
  private boolean zMn;
  private boolean zMo;
  private String zMp;
  private HashSet<String> zMq;
  private IListener zMr;
  
  private d()
  {
    AppMethodBeat.i(122370);
    this.zMn = false;
    this.zMo = false;
    this.zMp = "";
    this.zMq = new HashSet();
    this.appListener = new MMPageFlowService.2(this, com.tencent.mm.app.f.hfK);
    this.zMr = new MMPageFlowService.3(this, com.tencent.mm.app.f.hfK);
    if (!MMApplicationContext.isMMProcess()) {
      zMl = true;
    }
    AppMethodBeat.o(122370);
  }
  
  private void a(Activity paramActivity, f.a parama)
  {
    AppMethodBeat.i(122373);
    if (paramActivity != null) {
      b(paramActivity.getComponentName().getClassName(), parama, paramActivity.hashCode(), System.currentTimeMillis());
    }
    AppMethodBeat.o(122373);
  }
  
  private void a(String paramString, f.a parama, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(122375);
    long l1 = Util.currentTicks();
    if (!MMApplicationContext.isMMProcess())
    {
      if (c.zMi == null) {
        c.zMi = new c();
      }
      Object localObject1 = c.zMi;
      Log.i("MicroMsg.MMPageFlowSenderByIPCInvoker", "%s send page flow [%s-%d-%d] [%s]", new Object[] { localObject1.hashCode(), paramString, Integer.valueOf(paramInt1), Long.valueOf(paramLong), parama });
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("key_page_flow_type", parama.value);
      ((Bundle)localObject1).putString("key_page_flow_name", paramString);
      ((Bundle)localObject1).putInt("key_page_flow_hashcode", paramInt1);
      ((Bundle)localObject1).putLong("key_page_flow_time_stamp", paramLong);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(932L, 100L, 1L, false);
      Object localObject3 = ((Bundle)localObject1).getString("key_page_flow_name");
      int i = ((Bundle)localObject1).getInt("key_page_flow_type");
      int j = ((Bundle)localObject1).getInt("key_page_flow_hashcode", 0);
      long l2 = ((Bundle)localObject1).getLong("key_page_flow_time_stamp", 0L);
      String str = new StringBuilder().append(j).append("_").append(l2).toString().hashCode();
      Object localObject2 = new jk();
      ((jk)localObject2).iSW = j;
      localObject3 = ((jk)localObject2).sh((String)localObject3);
      ((jk)localObject3).ixB = i;
      ((jk)localObject3).fh(l2);
      localObject3 = b.dMZ();
      localObject2 = ((jk)localObject2).aIE();
      localObject3 = ((b)localObject3).aBP();
      if (localObject3 != null) {
        ((MultiProcessMMKV)localObject3).putString(str, (String)localObject2);
      }
      j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localObject1, c.a.class, null);
      Log.d("MicroMsg.MMPageFlowService", "reportPageFlow: mm-process NOT");
      zMl = true;
    }
    if (!zMl)
    {
      Log.e("MicroMsg.MMPageFlowService", "reportPageFlow: mm-process isAccReady = FALSE");
      AppMethodBeat.o(122375);
      return;
    }
    Log.d("MicroMsg.MMPageFlowService", "reportPageFlow: mm-process YES");
    if (MMApplicationContext.isMMProcess()) {
      dNc();
    }
    a(paramString, parama, paramInt1, paramLong, paramInt2);
    Log.v("MicroMsg.MMPageFlowService", "report page Flow cost[%d]", new Object[] { Long.valueOf(Util.ticksToNow(l1)) });
    AppMethodBeat.o(122375);
  }
  
  private void a(String paramString, f.a parama, int paramInt1, long paramLong, int paramInt2)
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
      if (parama == f.a.zxz) {
        this.zMo = true;
      }
      if (parama == f.a.zxA) {
        this.zMo = false;
      }
      Object localObject = new ll();
      ((ll)localObject).iAo = paramInt2;
      paramString = ((ll)localObject).ur(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).mProcessName).us(paramString);
      localObject = zMk;
      paramInt2 = localObject[i];
      localObject[i] = (paramInt2 + 1);
      paramString.iZX = paramInt2;
      paramString.ixB = parama.value;
      paramString = paramString.fl(paramLong);
      paramString.iSW = paramInt1;
      e.dNe().a(paramString);
      Log.d("MicroMsg.MMPageFlowService", "%s pure report [%s]", new Object[] { info(), paramString.aIF() });
      if ((parama == f.a.zxz) || (parama == f.a.zxA)) {
        Log.i("MicroMsg.MMPageFlowService", "habbyge-mali, %s frontback-pure-report [%s]", new Object[] { info(), paramString.aIF() });
      }
      if ((MMApplicationContext.isMMProcess()) && ((parama == f.a.zxz) || (parama == f.a.zxA)))
      {
        x(paramLong, this.zMo);
        com.tencent.mm.plugin.expt.hellhound.ext.c.b.LS(zMk[3]);
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
  
  public static d dNa()
  {
    AppMethodBeat.i(122371);
    if (zMm == null) {
      zMm = new d();
    }
    d locald = zMm;
    AppMethodBeat.o(122371);
    return locald;
  }
  
  public static boolean dNb()
  {
    return zMl;
  }
  
  private String info()
  {
    AppMethodBeat.i(122372);
    String str = hashCode();
    AppMethodBeat.o(122372);
    return str;
  }
  
  private static void reset()
  {
    zMk = new int[] { 10, 1000, 10000, 100000 };
    zMl = false;
  }
  
  private void x(final long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(122385);
    if (!zMl)
    {
      AppMethodBeat.o(122385);
      return;
    }
    int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yOE, 0);
    if (i <= 0)
    {
      AppMethodBeat.o(122385);
      return;
    }
    long l = com.tencent.mm.kernel.h.baE().ban().a(at.a.acYD, 0L);
    if (Util.nowSecond() - l < i)
    {
      AppMethodBeat.o(122385);
      return;
    }
    com.tencent.threadpool.h.ahAA.bFQ("calc_unread_task");
    com.tencent.threadpool.h.ahAA.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(122369);
        d.a(d.this, paramLong, this.fiz);
        AppMethodBeat.o(122369);
      }
    }, 5000L, "calc_unread_task");
    AppMethodBeat.o(122385);
  }
  
  public final void a(String paramString, f.a parama, int paramInt, long paramLong)
  {
    AppMethodBeat.i(122379);
    a(paramString, parama, paramInt, paramLong, Process.myPid());
    AppMethodBeat.o(122379);
  }
  
  public final void b(String paramString, f.a parama, int paramInt, long paramLong)
  {
    AppMethodBeat.i(184399);
    a(paramString, parama, paramInt, Process.myPid(), paramLong);
    AppMethodBeat.o(184399);
  }
  
  public final void dHR()
  {
    AppMethodBeat.i(122374);
    zMl = false;
    com.tencent.mm.plugin.expt.hellhound.ext.c.c.a(106, null, 0, System.currentTimeMillis());
    com.tencent.mm.plugin.expt.hellhound.ext.c.c.dLg();
    com.tencent.mm.plugin.expt.hellhound.ext.c.a.LR(8);
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.LA(8);
    com.tencent.mm.plugin.expt.hellhound.ext.c.a.oV(true);
    Log.i("MicroMsg.MMPageFlowService", "habbyge-mali, MMPageFlowService: logout补偿上报");
    AppMethodBeat.o(122374);
  }
  
  protected final void dNc()
  {
    AppMethodBeat.i(122377);
    if (!MMApplicationContext.isMMProcess())
    {
      AppMethodBeat.o(122377);
      return;
    }
    long l = Util.currentTicks();
    Object localObject1 = b.dMZ().allKeys();
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      int j = localObject1.length;
      int i = 0;
      if (i < j)
      {
        localObject2 = localObject1[i];
        if (!this.zMq.contains(localObject2))
        {
          String str = b.dMZ().O((String)localObject2, "");
          if (!Util.isNullOrNil(str))
          {
            jk localjk = new jk(str);
            if ((localjk.iSW > 0L) && (localjk.iSV > 0L))
            {
              localArrayList.add(new jk(str));
              this.zMq.add(localObject2);
            }
            b.dMZ().remove((String)localObject2);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          b.dMZ().remove((String)localObject2);
        }
      }
    }
    if (!localArrayList.isEmpty())
    {
      Collections.sort(localArrayList, new Comparator() {});
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (jk)((Iterator)localObject1).next();
        a(((jk)localObject2).iSU, f.a.Ls((int)((jk)localObject2).ixB), (int)((jk)localObject2).iSW, ((jk)localObject2).iSV);
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(932L, 102L, localArrayList.size(), false);
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
    zMl = true;
    com.tencent.mm.plugin.expt.f.c.dNK();
    if (Util.getInt(com.tencent.mm.plugin.expt.f.c.c(com.tencent.mm.plugin.expt.b.c.a.yOM, ""), 0) > 0) {}
    for (;;)
    {
      if (i != 0) {
        this.appListener.alive();
      }
      this.zMr.alive();
      AppMethodBeat.o(122380);
      return;
      i = 0;
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(122381);
    reset();
    this.appListener.dead();
    this.zMr.dead();
    this.zMn = false;
    AppMethodBeat.o(122381);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(122384);
    String str = paramActivity.getComponentName().getClassName();
    if ((zMl) && ("com.tencent.mm.ui.LauncherUI".equals(str)) && (this.zMo))
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
    a(paramActivity, f.a.zxw);
    AppMethodBeat.o(122383);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(122382);
    a(paramActivity, f.a.zxv);
    AppMethodBeat.o(122382);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.pageflow.d
 * JD-Core Version:    0.7.0.1
 */