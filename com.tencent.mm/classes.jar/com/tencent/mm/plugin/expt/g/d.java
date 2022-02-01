package com.tencent.mm.plugin.expt.g;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.k;
import com.tencent.mm.g.a.lr;
import com.tencent.mm.g.b.a.de;
import com.tencent.mm.g.b.a.dr;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.expt.b.e.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class d
  implements Application.ActivityLifecycleCallbacks, com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.expt.b.e
{
  private static int[] raC = { 10, 1000, 10000, 100000 };
  private static boolean raD = false;
  private static d raE;
  private com.tencent.mm.sdk.b.c<k> appListener;
  private boolean raF;
  private boolean raG;
  private String raH;
  private HashSet<String> raI;
  private com.tencent.mm.sdk.b.c raJ;
  
  private d()
  {
    AppMethodBeat.i(122370);
    this.raF = false;
    this.raG = false;
    this.raH = "";
    this.raI = new HashSet();
    this.appListener = new com.tencent.mm.sdk.b.c() {};
    this.raJ = new com.tencent.mm.sdk.b.c()
    {
      private boolean cro()
      {
        AppMethodBeat.i(122367);
        ad.i("MicroMsg.MMPageFlowService", "manual force login");
        if (!d.a(d.this))
        {
          d.b(d.this);
          com.tencent.mm.plugin.expt.hellhound.a.c.c.a(105, null, 0, System.currentTimeMillis());
          com.tencent.mm.plugin.expt.hellhound.a.c.c.cpn();
          com.tencent.mm.plugin.expt.hellhound.a.c.a.Di(7);
          com.tencent.mm.plugin.expt.hellhound.core.b.a.a.CS(7);
        }
        AppMethodBeat.o(122367);
        return false;
      }
    };
    if (!aj.cnC()) {
      raD = true;
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
    long l1 = bt.HI();
    if (!aj.cnC())
    {
      if (c.raA == null) {
        c.raA = new c();
      }
      Object localObject1 = c.raA;
      ad.i("MicroMsg.MMPageFlowSenderByIPCInvoker", "%s send page flow [%s-%d-%d] [%s]", new Object[] { localObject1.hashCode(), paramString, Integer.valueOf(paramInt1), Long.valueOf(paramLong), parama });
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("key_page_flow_type", parama.value);
      ((Bundle)localObject1).putString("key_page_flow_name", paramString);
      ((Bundle)localObject1).putInt("key_page_flow_hashcode", paramInt1);
      ((Bundle)localObject1).putLong("key_page_flow_time_stamp", paramLong);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(932L, 100L, 1L, false);
      Object localObject3 = ((Bundle)localObject1).getString("key_page_flow_name");
      int i = ((Bundle)localObject1).getInt("key_page_flow_type");
      int j = ((Bundle)localObject1).getInt("key_page_flow_hashcode", 0);
      long l2 = ((Bundle)localObject1).getLong("key_page_flow_time_stamp", 0L);
      String str = new StringBuilder().append(j).append("_").append(l2).toString().hashCode();
      Object localObject2 = new de();
      ((de)localObject2).eeA = j;
      localObject3 = ((de)localObject2).ms((String)localObject3);
      ((de)localObject3).dYD = i;
      ((de)localObject3).jp(l2);
      localObject3 = b.crk();
      localObject2 = ((de)localObject2).RD();
      localObject3 = ((b)localObject3).Lv();
      if (localObject3 != null) {
        ((ax)localObject3).putString(str, (String)localObject2);
      }
      com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", (Parcelable)localObject1, c.a.class, null);
      ad.d("MicroMsg.MMPageFlowService", "reportPageFlow: mm-process NOT");
      raD = true;
    }
    if (!raD)
    {
      ad.e("MicroMsg.MMPageFlowService", "reportPageFlow: mm-process isAccReady = FALSE");
      AppMethodBeat.o(122375);
      return;
    }
    ad.d("MicroMsg.MMPageFlowService", "reportPageFlow: mm-process YES");
    if (aj.cnC()) {
      crn();
    }
    a(paramString, parama, paramInt1, paramLong, paramInt2);
    ad.v("MicroMsg.MMPageFlowService", "report page Flow cost[%d]", new Object[] { Long.valueOf(bt.aO(l1)) });
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
      if (parama == e.a.qPh) {
        this.raG = true;
      }
      if (parama == e.a.qPi) {
        this.raG = false;
      }
      Object localObject = new dr();
      ((dr)localObject).dXl = paramInt2;
      paramString = ((dr)localObject).nb(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajz().ajb()).mProcessName).nc(paramString);
      localObject = raC;
      paramInt2 = localObject[i];
      localObject[i] = (paramInt2 + 1);
      paramString.egV = paramInt2;
      paramString.dYD = parama.value;
      paramString = paramString.jS(paramLong);
      paramString.eeA = paramInt1;
      e.crp().a(paramString);
      ad.d("MicroMsg.MMPageFlowService", "%s pure report [%s]", new Object[] { info(), paramString.RE() });
      if ((parama == e.a.qPh) || (parama == e.a.qPi)) {
        ad.i("MicroMsg.MMPageFlowService", "habbyge-mali, %s frontback-pure-report [%s]", new Object[] { info(), paramString.RE() });
      }
      if ((aj.cnC()) && ((parama == e.a.qPh) || (parama == e.a.qPi)))
      {
        r(paramLong, this.raG);
        com.tencent.mm.plugin.expt.hellhound.a.c.b.Dj(raC[3]);
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
  
  public static d crl()
  {
    AppMethodBeat.i(122371);
    if (raE == null) {
      raE = new d();
    }
    d locald = raE;
    AppMethodBeat.o(122371);
    return locald;
  }
  
  public static boolean crm()
  {
    return raD;
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
    if (!raD)
    {
      AppMethodBeat.o(122385);
      return;
    }
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.quD, 0);
    if (i <= 0)
    {
      AppMethodBeat.o(122385);
      return;
    }
    long l = com.tencent.mm.kernel.g.ajC().ajl().a(al.a.IFw, 0L);
    if (bt.aQJ() - l < i)
    {
      AppMethodBeat.o(122385);
      return;
    }
    com.tencent.e.h.LTJ.aZz("calc_unread_task");
    com.tencent.e.h.LTJ.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(122369);
        d.a(d.this, paramLong, this.cNz);
        AppMethodBeat.o(122369);
      }
    }, 5000L, "calc_unread_task");
    AppMethodBeat.o(122385);
  }
  
  private static void reset()
  {
    raC = new int[] { 10, 1000, 10000, 100000 };
    raD = false;
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
  
  protected final void crn()
  {
    AppMethodBeat.i(122377);
    if (!aj.cnC())
    {
      AppMethodBeat.o(122377);
      return;
    }
    long l = bt.HI();
    Object localObject1 = b.crk().allKeys();
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      int j = localObject1.length;
      int i = 0;
      if (i < j)
      {
        localObject2 = localObject1[i];
        if (!this.raI.contains(localObject2))
        {
          String str = b.crk().get((String)localObject2, "");
          if (!bt.isNullOrNil(str))
          {
            de localde = new de(str);
            if ((localde.eeA > 0L) && (localde.eez > 0L))
            {
              localArrayList.add(new de(str));
              this.raI.add(localObject2);
            }
            b.crk().remove((String)localObject2);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          b.crk().remove((String)localObject2);
        }
      }
    }
    if (!localArrayList.isEmpty())
    {
      Collections.sort(localArrayList, new Comparator() {});
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (de)((Iterator)localObject1).next();
        a(((de)localObject2).eey, e.a.CO((int)((de)localObject2).dYD), (int)((de)localObject2).eeA, ((de)localObject2).eez);
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(932L, 102L, localArrayList.size(), false);
      ad.i("MicroMsg.MMPageFlowService", "check mmkv list[%d] cost[%d]", new Object[] { Integer.valueOf(localArrayList.size()), Long.valueOf(bt.aO(l)) });
    }
    ad.d("MicroMsg.MMPageFlowService", "check mm kv cost[%d]", new Object[] { Long.valueOf(bt.aO(l)) });
    AppMethodBeat.o(122377);
  }
  
  public final void logout()
  {
    AppMethodBeat.i(122374);
    raD = false;
    com.tencent.mm.plugin.expt.hellhound.a.c.c.a(106, null, 0, System.currentTimeMillis());
    com.tencent.mm.plugin.expt.hellhound.a.c.c.cpn();
    com.tencent.mm.plugin.expt.hellhound.a.c.a.Di(8);
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.CS(8);
    com.tencent.mm.plugin.expt.hellhound.a.c.a.la(true);
    ad.i("MicroMsg.MMPageFlowService", "habbyge-mali, MMPageFlowService: logout补偿上报");
    AppMethodBeat.o(122374);
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    int i = 1;
    AppMethodBeat.i(122380);
    reset();
    raD = true;
    com.tencent.mm.plugin.expt.i.c.crR();
    if (bt.getInt(com.tencent.mm.plugin.expt.i.c.b(b.a.quL, ""), 0) > 0) {}
    for (;;)
    {
      if (i != 0) {
        com.tencent.mm.sdk.b.a.IbL.b(this.appListener);
      }
      com.tencent.mm.sdk.b.a.IbL.b(this.raJ);
      AppMethodBeat.o(122380);
      return;
      i = 0;
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(122381);
    reset();
    com.tencent.mm.sdk.b.a.IbL.d(this.appListener);
    com.tencent.mm.sdk.b.a.IbL.d(this.raJ);
    this.raF = false;
    AppMethodBeat.o(122381);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(122384);
    String str = paramActivity.getComponentName().getClassName();
    if ((raD) && ("com.tencent.mm.ui.LauncherUI".equals(str)) && (this.raG))
    {
      str = info();
      if (paramActivity == null) {
        break label82;
      }
    }
    label82:
    for (int i = paramActivity.hashCode();; i = -1)
    {
      ad.i("MicroMsg.MMPageFlowService", "%s launcher ui ondestroyed but wechat in foreground hashcode[%d]", new Object[] { str, Integer.valueOf(i) });
      AppMethodBeat.o(122384);
      return;
    }
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(122383);
    a(paramActivity, e.a.qPe);
    AppMethodBeat.o(122383);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(122382);
    a(paramActivity, e.a.qPd);
    AppMethodBeat.o(122382);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.g.d
 * JD-Core Version:    0.7.0.1
 */