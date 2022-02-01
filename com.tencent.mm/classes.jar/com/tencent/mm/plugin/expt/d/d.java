package com.tencent.mm.plugin.expt.d;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.k;
import com.tencent.mm.g.a.li;
import com.tencent.mm.g.b.a.cm;
import com.tencent.mm.g.b.a.cy;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.expt.a.e.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class d
  implements Application.ActivityLifecycleCallbacks, com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.expt.a.e
{
  private static int[] qrj = { 10, 1000, 10000, 100000 };
  private static boolean qrk = false;
  private static d qrl;
  private com.tencent.mm.sdk.b.c<k> appListener;
  private boolean qrm;
  private boolean qrn;
  private String qro;
  private HashSet<String> qrp;
  private com.tencent.mm.sdk.b.c qrq;
  
  private d()
  {
    AppMethodBeat.i(122370);
    this.qrm = false;
    this.qrn = false;
    this.qro = "";
    this.qrp = new HashSet();
    this.appListener = new com.tencent.mm.sdk.b.c() {};
    this.qrq = new com.tencent.mm.sdk.b.c()
    {
      private boolean clR()
      {
        AppMethodBeat.i(122367);
        ac.i("MicroMsg.MMPageFlowService", "manual force login");
        if (!d.a(d.this))
        {
          d.b(d.this);
          com.tencent.mm.plugin.expt.hellhound.a.c.c.b(105, null, null, System.currentTimeMillis());
          com.tencent.mm.plugin.expt.hellhound.a.c.c.cjZ();
          com.tencent.mm.plugin.expt.hellhound.a.c.a.Cv(7);
          com.tencent.mm.plugin.expt.hellhound.core.b.a.a.Ch(7);
        }
        AppMethodBeat.o(122367);
        return false;
      }
    };
    if (!ai.ciE()) {
      qrk = true;
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
    long l1 = bs.Gn();
    if (!ai.ciE())
    {
      if (c.qrh == null) {
        c.qrh = new c();
      }
      Object localObject1 = c.qrh;
      ac.i("MicroMsg.MMPageFlowSenderByIPCInvoker", "%s send page flow [%s-%d-%d] [%s]", new Object[] { localObject1.hashCode(), paramString, Integer.valueOf(paramInt1), Long.valueOf(paramLong), parama });
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("key_page_flow_type", parama.value);
      ((Bundle)localObject1).putString("key_page_flow_name", paramString);
      ((Bundle)localObject1).putInt("key_page_flow_hashcode", paramInt1);
      ((Bundle)localObject1).putLong("key_page_flow_time_stamp", paramLong);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(932L, 100L, 1L, false);
      Object localObject3 = ((Bundle)localObject1).getString("key_page_flow_name");
      int i = ((Bundle)localObject1).getInt("key_page_flow_type");
      int j = ((Bundle)localObject1).getInt("key_page_flow_hashcode", 0);
      long l2 = ((Bundle)localObject1).getLong("key_page_flow_time_stamp", 0L);
      String str = new StringBuilder().append(j).append("_").append(l2).toString().hashCode();
      Object localObject2 = new cm();
      ((cm)localObject2).dPl = j;
      localObject3 = ((cm)localObject2).kw((String)localObject3);
      ((cm)localObject3).dKB = i;
      ((cm)localObject3).hH(l2);
      localObject3 = b.clN();
      localObject2 = ((cm)localObject2).PR();
      localObject3 = ((b)localObject3).JW();
      if (localObject3 != null) {
        ((aw)localObject3).putString(str, (String)localObject2);
      }
      com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", (Parcelable)localObject1, c.a.class, null);
      ac.d("MicroMsg.MMPageFlowService", "reportPageFlow: mm-process NOT");
      qrk = true;
    }
    if (!qrk)
    {
      ac.e("MicroMsg.MMPageFlowService", "reportPageFlow: mm-process isAccReady = FALSE");
      AppMethodBeat.o(122375);
      return;
    }
    ac.d("MicroMsg.MMPageFlowService", "reportPageFlow: mm-process YES");
    if (ai.ciE()) {
      clQ();
    }
    a(paramString, parama, paramInt1, paramLong, paramInt2);
    ac.v("MicroMsg.MMPageFlowService", "report page Flow cost[%d]", new Object[] { Long.valueOf(bs.aO(l1)) });
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
      if (parama == e.a.qiu) {
        this.qrn = true;
      }
      if (parama == e.a.qiv) {
        this.qrn = false;
      }
      Object localObject = new cy();
      ((cy)localObject).dJu = paramInt2;
      paramString = ((cy)localObject).kY(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.agO().agp()).mProcessName).kZ(paramString);
      localObject = qrj;
      paramInt2 = localObject[i];
      localObject[i] = (paramInt2 + 1);
      paramString.dRy = paramInt2;
      paramString.dKB = parama.value;
      paramString = paramString.ih(paramLong);
      paramString.dPl = paramInt1;
      e.clS().a(paramString);
      ac.d("MicroMsg.MMPageFlowService", "%s pure report [%s]", new Object[] { info(), paramString.PS() });
      if ((parama == e.a.qiu) || (parama == e.a.qiv)) {
        ac.i("MicroMsg.MMPageFlowService", "habbyge-mali, %s frontback-pure-report [%s]", new Object[] { info(), paramString.PS() });
      }
      if ((ai.ciE()) && ((parama == e.a.qiu) || (parama == e.a.qiv)))
      {
        r(paramLong, this.qrn);
        com.tencent.mm.plugin.expt.hellhound.a.c.b.Cw(qrj[3]);
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
  
  public static d clO()
  {
    AppMethodBeat.i(122371);
    if (qrl == null) {
      qrl = new d();
    }
    d locald = qrl;
    AppMethodBeat.o(122371);
    return locald;
  }
  
  public static boolean clP()
  {
    return qrk;
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
    if (!qrk)
    {
      AppMethodBeat.o(122385);
      return;
    }
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pQo, 0);
    if (i <= 0)
    {
      AppMethodBeat.o(122385);
      return;
    }
    long l = com.tencent.mm.kernel.g.agR().agA().a(ah.a.GSR, 0L);
    if (bs.aNx() - l < i)
    {
      AppMethodBeat.o(122385);
      return;
    }
    com.tencent.e.h.JZN.aTz("calc_unread_task");
    com.tencent.e.h.JZN.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(122369);
        d.a(d.this, paramLong, this.cCB);
        AppMethodBeat.o(122369);
      }
    }, 5000L, "calc_unread_task");
    AppMethodBeat.o(122385);
  }
  
  private static void reset()
  {
    qrj = new int[] { 10, 1000, 10000, 100000 };
    qrk = false;
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
  
  protected final void clQ()
  {
    AppMethodBeat.i(122377);
    if (!ai.ciE())
    {
      AppMethodBeat.o(122377);
      return;
    }
    long l = bs.Gn();
    Object localObject1 = b.clN().allKeys();
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      int j = localObject1.length;
      int i = 0;
      if (i < j)
      {
        localObject2 = localObject1[i];
        if (!this.qrp.contains(localObject2))
        {
          String str = b.clN().get((String)localObject2, "");
          if (!bs.isNullOrNil(str))
          {
            cm localcm = new cm(str);
            if ((localcm.dPl > 0L) && (localcm.dPk > 0L))
            {
              localArrayList.add(new cm(str));
              this.qrp.add(localObject2);
            }
            b.clN().remove((String)localObject2);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          b.clN().remove((String)localObject2);
        }
      }
    }
    if (!localArrayList.isEmpty())
    {
      Collections.sort(localArrayList, new Comparator() {});
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (cm)((Iterator)localObject1).next();
        a(((cm)localObject2).dPj, e.a.Ce((int)((cm)localObject2).dKB), (int)((cm)localObject2).dPl, ((cm)localObject2).dPk);
      }
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(932L, 102L, localArrayList.size(), false);
      ac.i("MicroMsg.MMPageFlowService", "check mmkv list[%d] cost[%d]", new Object[] { Integer.valueOf(localArrayList.size()), Long.valueOf(bs.aO(l)) });
    }
    ac.d("MicroMsg.MMPageFlowService", "check mm kv cost[%d]", new Object[] { Long.valueOf(bs.aO(l)) });
    AppMethodBeat.o(122377);
  }
  
  public final void logout()
  {
    AppMethodBeat.i(122374);
    qrk = false;
    com.tencent.mm.plugin.expt.hellhound.a.c.c.b(106, null, null, System.currentTimeMillis());
    com.tencent.mm.plugin.expt.hellhound.a.c.c.cjZ();
    com.tencent.mm.plugin.expt.hellhound.a.c.a.Cv(8);
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.Ch(8);
    com.tencent.mm.plugin.expt.hellhound.a.c.a.kI(true);
    ac.i("MicroMsg.MMPageFlowService", "habbyge-mali, MMPageFlowService: logout补偿上报");
    AppMethodBeat.o(122374);
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    int i = 1;
    AppMethodBeat.i(122380);
    reset();
    qrk = true;
    com.tencent.mm.plugin.expt.f.c.cmm();
    if (bs.getInt(com.tencent.mm.plugin.expt.f.c.b(b.a.pQw, ""), 0) > 0) {}
    for (;;)
    {
      if (i != 0) {
        com.tencent.mm.sdk.b.a.GpY.b(this.appListener);
      }
      com.tencent.mm.sdk.b.a.GpY.b(this.qrq);
      AppMethodBeat.o(122380);
      return;
      i = 0;
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(122381);
    reset();
    com.tencent.mm.sdk.b.a.GpY.d(this.appListener);
    com.tencent.mm.sdk.b.a.GpY.d(this.qrq);
    this.qrm = false;
    AppMethodBeat.o(122381);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(122384);
    String str = paramActivity.getComponentName().getClassName();
    if ((qrk) && ("com.tencent.mm.ui.LauncherUI".equals(str)) && (this.qrn))
    {
      str = info();
      if (paramActivity == null) {
        break label82;
      }
    }
    label82:
    for (int i = paramActivity.hashCode();; i = -1)
    {
      ac.i("MicroMsg.MMPageFlowService", "%s launcher ui ondestroyed but wechat in foreground hashcode[%d]", new Object[] { str, Integer.valueOf(i) });
      AppMethodBeat.o(122384);
      return;
    }
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(122383);
    a(paramActivity, e.a.qir);
    AppMethodBeat.o(122383);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(122382);
    a(paramActivity, e.a.qiq);
    AppMethodBeat.o(122382);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.d
 * JD-Core Version:    0.7.0.1
 */