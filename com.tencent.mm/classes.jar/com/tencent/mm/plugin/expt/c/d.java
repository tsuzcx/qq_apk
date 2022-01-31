package com.tencent.mm.plugin.expt.c;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.k;
import com.tencent.mm.g.b.a.s;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class d
  implements Application.ActivityLifecycleCallbacks, com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.expt.a.c
{
  private static int[] mcf = { 10, 1000, 10000, 100000 };
  private static boolean mcg = false;
  private static d mch;
  private com.tencent.mm.sdk.b.c<k> appListener;
  private boolean mci;
  private boolean mcj;
  private String mck;
  private HashSet<String> mcl;
  private com.tencent.mm.sdk.b.c mcm;
  
  private d()
  {
    AppMethodBeat.i(73537);
    this.mci = false;
    this.mcj = false;
    this.mck = "";
    this.mcl = new HashSet();
    this.appListener = new d.2(this);
    this.mcm = new d.3(this);
    if (!ah.brt()) {
      mcg = true;
    }
    AppMethodBeat.o(73537);
  }
  
  private void a(Activity paramActivity, com.tencent.mm.plugin.expt.a.c.a parama)
  {
    AppMethodBeat.i(73540);
    if (paramActivity != null) {
      a(paramActivity.getComponentName().getClassName(), parama, paramActivity.hashCode());
    }
    AppMethodBeat.o(73540);
  }
  
  private void a(String paramString, com.tencent.mm.plugin.expt.a.c.a parama, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(73542);
    long l1 = bo.yB();
    if (!ah.brt())
    {
      if (c.mcd == null) {
        c.mcd = new c();
      }
      Object localObject1 = c.mcd;
      ab.i("MicroMsg.MMPageFlowSenderByIPCInvoker", "%s send page flow [%s-%d-%d] [%s]", new Object[] { localObject1.hashCode(), paramString, Integer.valueOf(paramInt1), Long.valueOf(paramLong), parama });
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("key_page_flow_type", parama.value);
      ((Bundle)localObject1).putString("key_page_flow_name", paramString);
      ((Bundle)localObject1).putInt("key_page_flow_hashcode", paramInt1);
      ((Bundle)localObject1).putLong("key_page_flow_time_stamp", paramLong);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(932L, 100L, 1L, false);
      Object localObject3 = ((Bundle)localObject1).getString("key_page_flow_name");
      int i = ((Bundle)localObject1).getInt("key_page_flow_type");
      int j = ((Bundle)localObject1).getInt("key_page_flow_hashcode", 0);
      long l2 = ((Bundle)localObject1).getLong("key_page_flow_time_stamp", 0L);
      String str = new StringBuilder().append(j).append("_").append(l2).toString().hashCode();
      Object localObject2 = new s();
      ((s)localObject2).cSJ = j;
      localObject3 = ((s)localObject2).fp((String)localObject3);
      ((s)localObject3).cSH = i;
      ((s)localObject3).bx(l2);
      localObject3 = b.bsO();
      localObject2 = ((s)localObject2).Ff();
      localObject3 = ((b)localObject3).aND();
      if (localObject3 != null) {
        ((as)localObject3).putString(str, (String)localObject2);
      }
      f.a("com.tencent.mm", (Parcelable)localObject1, c.a.class, null);
      ab.d("MicroMsg.MMPageFlowService", "reportPageFlow: mm-process NOT");
      mcg = true;
    }
    if (!mcg)
    {
      ab.e("MicroMsg.MMPageFlowService", "reportPageFlow: mm-process isAccReady = FALSE");
      AppMethodBeat.o(73542);
      return;
    }
    ab.d("MicroMsg.MMPageFlowService", "reportPageFlow: mm-process YES");
    if (ah.brt()) {
      bsR();
    }
    a(paramString, parama, paramInt1, paramLong, paramInt2);
    ab.v("MicroMsg.MMPageFlowService", "report page Flow cost[%d]", new Object[] { Long.valueOf(bo.av(l1)) });
    AppMethodBeat.o(73542);
  }
  
  private void a(String paramString, com.tencent.mm.plugin.expt.a.c.a parama, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(73545);
    if ((paramString.contains("WeChatSplashActivity")) || (paramString.contains("FakeSwitchAccountUI")))
    {
      AppMethodBeat.o(73545);
      return;
    }
    int i;
    if (parama.value <= 2) {
      i = 0;
    }
    for (;;)
    {
      if (parama == com.tencent.mm.plugin.expt.a.c.a.lZt) {
        this.mcj = true;
      }
      if (parama == com.tencent.mm.plugin.expt.a.c.a.lZu) {
        this.mcj = false;
      }
      Object localObject = new y();
      ((y)localObject).cRR = paramInt2;
      paramString = ((y)localObject).fu(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).mProcessName).fv(paramString);
      localObject = mcf;
      paramInt2 = localObject[i];
      localObject[i] = (paramInt2 + 1);
      paramString.cTR = paramInt2;
      paramString.cSH = parama.value;
      paramString = paramString.by(paramLong);
      paramString.cSJ = paramInt1;
      e.bsT().a(paramString);
      ab.d("MicroMsg.MMPageFlowService", "%s pure report [%s]", new Object[] { bau(), paramString.Fg() });
      if ((parama == com.tencent.mm.plugin.expt.a.c.a.lZt) || (parama == com.tencent.mm.plugin.expt.a.c.a.lZu)) {
        ab.i("MicroMsg.MMPageFlowService", "habbyge-mali, %s frontback-pure-report [%s]", new Object[] { bau(), paramString.Fg() });
      }
      if ((ah.brt()) && ((parama == com.tencent.mm.plugin.expt.a.c.a.lZt) || (parama == com.tencent.mm.plugin.expt.a.c.a.lZu)))
      {
        r(paramLong, this.mcj);
        com.tencent.mm.plugin.expt.hellhound.a.a.b.vr(mcf[3]);
      }
      AppMethodBeat.o(73545);
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
  
  private String bau()
  {
    AppMethodBeat.i(73539);
    String str = hashCode();
    AppMethodBeat.o(73539);
    return str;
  }
  
  public static d bsP()
  {
    AppMethodBeat.i(73538);
    if (mch == null) {
      mch = new d();
    }
    d locald = mch;
    AppMethodBeat.o(73538);
    return locald;
  }
  
  public static boolean bsQ()
  {
    return mcg;
  }
  
  private void r(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(73552);
    if (!mcg)
    {
      AppMethodBeat.o(73552);
      return;
    }
    int i = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lUy, 0);
    if (i <= 0)
    {
      AppMethodBeat.o(73552);
      return;
    }
    long l = com.tencent.mm.kernel.g.RL().Ru().a(ac.a.yLB, 0L);
    if (bo.aox() - l < i)
    {
      AppMethodBeat.o(73552);
      return;
    }
    com.tencent.mm.sdk.g.d.ysm.remove("calc_unread_task");
    com.tencent.mm.sdk.g.d.ysm.b(new d.4(this, paramLong, paramBoolean), "calc_unread_task", 5000L);
    AppMethodBeat.o(73552);
  }
  
  private static void reset()
  {
    mcf = new int[] { 10, 1000, 10000, 100000 };
    mcg = false;
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.expt.a.c.a parama, int paramInt)
  {
    AppMethodBeat.i(73543);
    a(paramString, parama, paramInt, Process.myPid(), System.currentTimeMillis());
    AppMethodBeat.o(73543);
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.expt.a.c.a parama, int paramInt, long paramLong)
  {
    AppMethodBeat.i(73546);
    a(paramString, parama, paramInt, paramLong, Process.myPid());
    AppMethodBeat.o(73546);
  }
  
  protected final void bsR()
  {
    AppMethodBeat.i(73544);
    if (!ah.brt())
    {
      AppMethodBeat.o(73544);
      return;
    }
    long l = bo.yB();
    Object localObject1 = b.bsO().allKeys();
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      int j = localObject1.length;
      int i = 0;
      if (i < j)
      {
        localObject2 = localObject1[i];
        if (!this.mcl.contains(localObject2))
        {
          String str = b.bsO().get((String)localObject2, "");
          if (!bo.isNullOrNil(str))
          {
            s locals = new s(str);
            if ((locals.cSJ > 0L) && (locals.cSI > 0L))
            {
              localArrayList.add(new s(str));
              this.mcl.add(localObject2);
            }
            b.bsO().remove((String)localObject2);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          b.bsO().remove((String)localObject2);
        }
      }
    }
    if (!localArrayList.isEmpty())
    {
      Collections.sort(localArrayList, new d.1(this));
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (s)((Iterator)localObject1).next();
        a(((s)localObject2).cSG, com.tencent.mm.plugin.expt.a.c.a.vk((int)((s)localObject2).cSH), (int)((s)localObject2).cSJ, ((s)localObject2).cSI);
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(932L, 102L, localArrayList.size(), false);
      ab.i("MicroMsg.MMPageFlowService", "check mmkv list[%d] cost[%d]", new Object[] { Integer.valueOf(localArrayList.size()), Long.valueOf(bo.av(l)) });
    }
    ab.d("MicroMsg.MMPageFlowService", "check mm kv cost[%d]", new Object[] { Long.valueOf(bo.av(l)) });
    AppMethodBeat.o(73544);
  }
  
  public final void logout()
  {
    AppMethodBeat.i(73541);
    mcg = false;
    com.tencent.mm.plugin.expt.hellhound.a.a.c.s(106, null, null);
    com.tencent.mm.plugin.expt.hellhound.a.a.c.brV();
    com.tencent.mm.plugin.expt.hellhound.a.a.a.vq(8);
    com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.vm(8);
    com.tencent.mm.plugin.expt.hellhound.a.a.a.hi(true);
    ab.i("MicroMsg.MMPageFlowService", "habbyge-mali, MMPageFlowService: logout补偿上报");
    AppMethodBeat.o(73541);
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    int i = 1;
    AppMethodBeat.i(73547);
    reset();
    mcg = true;
    com.tencent.mm.plugin.expt.e.c.btm();
    if (bo.getInt(com.tencent.mm.plugin.expt.e.c.a(a.a.lUG, "", false), 0) > 0) {}
    for (;;)
    {
      if (i != 0) {
        com.tencent.mm.sdk.b.a.ymk.b(this.appListener);
      }
      com.tencent.mm.sdk.b.a.ymk.b(this.mcm);
      AppMethodBeat.o(73547);
      return;
      i = 0;
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(73548);
    reset();
    com.tencent.mm.sdk.b.a.ymk.d(this.appListener);
    com.tencent.mm.sdk.b.a.ymk.d(this.mcm);
    this.mci = false;
    AppMethodBeat.o(73548);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(73551);
    String str = paramActivity.getComponentName().getClassName();
    if ((mcg) && ("com.tencent.mm.ui.LauncherUI".equals(str)) && (this.mcj))
    {
      str = bau();
      if (paramActivity == null) {
        break label82;
      }
    }
    label82:
    for (int i = paramActivity.hashCode();; i = -1)
    {
      ab.i("MicroMsg.MMPageFlowService", "%s launcher ui ondestroyed but wechat in foreground hashcode[%d]", new Object[] { str, Integer.valueOf(i) });
      AppMethodBeat.o(73551);
      return;
    }
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(73550);
    a(paramActivity, com.tencent.mm.plugin.expt.a.c.a.lZq);
    AppMethodBeat.o(73550);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(73549);
    a(paramActivity, com.tencent.mm.plugin.expt.a.c.a.lZp);
    AppMethodBeat.o(73549);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.c.d
 * JD-Core Version:    0.7.0.1
 */