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
import com.tencent.mm.g.a.ls;
import com.tencent.mm.g.b.a.de;
import com.tencent.mm.g.b.a.dt;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.expt.b.e.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class d
  implements Application.ActivityLifecycleCallbacks, com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.expt.b.e
{
  private static int[] riI = { 10, 1000, 10000, 100000 };
  private static boolean riJ = false;
  private static d riK;
  private com.tencent.mm.sdk.b.c<k> appListener;
  private boolean riL;
  private boolean riM;
  private String riN;
  private HashSet<String> riO;
  private com.tencent.mm.sdk.b.c riP;
  
  private d()
  {
    AppMethodBeat.i(122370);
    this.riL = false;
    this.riM = false;
    this.riN = "";
    this.riO = new HashSet();
    this.appListener = new com.tencent.mm.sdk.b.c() {};
    this.riP = new com.tencent.mm.sdk.b.c()
    {
      private boolean csQ()
      {
        AppMethodBeat.i(122367);
        ae.i("MicroMsg.MMPageFlowService", "manual force login");
        if (!d.a(d.this))
        {
          d.b(d.this);
          com.tencent.mm.plugin.expt.hellhound.a.c.c.a(105, null, 0, System.currentTimeMillis());
          com.tencent.mm.plugin.expt.hellhound.a.c.c.cqP();
          com.tencent.mm.plugin.expt.hellhound.a.c.a.Dv(7);
          com.tencent.mm.plugin.expt.hellhound.core.b.a.a.Df(7);
        }
        AppMethodBeat.o(122367);
        return false;
      }
    };
    if (!ak.cpe()) {
      riJ = true;
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
    long l1 = bu.HQ();
    if (!ak.cpe())
    {
      if (c.riG == null) {
        c.riG = new c();
      }
      Object localObject1 = c.riG;
      ae.i("MicroMsg.MMPageFlowSenderByIPCInvoker", "%s send page flow [%s-%d-%d] [%s]", new Object[] { localObject1.hashCode(), paramString, Integer.valueOf(paramInt1), Long.valueOf(paramLong), parama });
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("key_page_flow_type", parama.value);
      ((Bundle)localObject1).putString("key_page_flow_name", paramString);
      ((Bundle)localObject1).putInt("key_page_flow_hashcode", paramInt1);
      ((Bundle)localObject1).putLong("key_page_flow_time_stamp", paramLong);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(932L, 100L, 1L, false);
      Object localObject3 = ((Bundle)localObject1).getString("key_page_flow_name");
      int i = ((Bundle)localObject1).getInt("key_page_flow_type");
      int j = ((Bundle)localObject1).getInt("key_page_flow_hashcode", 0);
      long l2 = ((Bundle)localObject1).getLong("key_page_flow_time_stamp", 0L);
      String str = new StringBuilder().append(j).append("_").append(l2).toString().hashCode();
      Object localObject2 = new de();
      ((de)localObject2).ega = j;
      localObject3 = ((de)localObject2).mK((String)localObject3);
      ((de)localObject3).dZW = i;
      ((de)localObject3).jz(l2);
      localObject3 = b.csM();
      localObject2 = ((de)localObject2).RC();
      localObject3 = ((b)localObject3).LD();
      if (localObject3 != null) {
        ((ay)localObject3).putString(str, (String)localObject2);
      }
      com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", (Parcelable)localObject1, c.a.class, null);
      ae.d("MicroMsg.MMPageFlowService", "reportPageFlow: mm-process NOT");
      riJ = true;
    }
    if (!riJ)
    {
      ae.e("MicroMsg.MMPageFlowService", "reportPageFlow: mm-process isAccReady = FALSE");
      AppMethodBeat.o(122375);
      return;
    }
    ae.d("MicroMsg.MMPageFlowService", "reportPageFlow: mm-process YES");
    if (ak.cpe()) {
      csP();
    }
    a(paramString, parama, paramInt1, paramLong, paramInt2);
    ae.v("MicroMsg.MMPageFlowService", "report page Flow cost[%d]", new Object[] { Long.valueOf(bu.aO(l1)) });
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
      if (parama == e.a.qXc) {
        this.riM = true;
      }
      if (parama == e.a.qXd) {
        this.riM = false;
      }
      Object localObject = new dt();
      ((dt)localObject).dYC = paramInt2;
      paramString = ((dt)localObject).nw(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajO().ajq()).mProcessName).nx(paramString);
      localObject = riI;
      paramInt2 = localObject[i];
      localObject[i] = (paramInt2 + 1);
      paramString.eiF = paramInt2;
      paramString.dZW = parama.value;
      paramString = paramString.kd(paramLong);
      paramString.ega = paramInt1;
      e.csR().a(paramString);
      ae.d("MicroMsg.MMPageFlowService", "%s pure report [%s]", new Object[] { info(), paramString.RD() });
      if ((parama == e.a.qXc) || (parama == e.a.qXd)) {
        ae.i("MicroMsg.MMPageFlowService", "habbyge-mali, %s frontback-pure-report [%s]", new Object[] { info(), paramString.RD() });
      }
      if ((ak.cpe()) && ((parama == e.a.qXc) || (parama == e.a.qXd)))
      {
        r(paramLong, this.riM);
        com.tencent.mm.plugin.expt.hellhound.a.c.b.Dw(riI[3]);
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
  
  public static d csN()
  {
    AppMethodBeat.i(122371);
    if (riK == null) {
      riK = new d();
    }
    d locald = riK;
    AppMethodBeat.o(122371);
    return locald;
  }
  
  public static boolean csO()
  {
    return riJ;
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
    if (!riJ)
    {
      AppMethodBeat.o(122385);
      return;
    }
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBw, 0);
    if (i <= 0)
    {
      AppMethodBeat.o(122385);
      return;
    }
    long l = com.tencent.mm.kernel.g.ajR().ajA().a(am.a.IZW, 0L);
    if (bu.aRi() - l < i)
    {
      AppMethodBeat.o(122385);
      return;
    }
    com.tencent.e.h.MqF.bbc("calc_unread_task");
    com.tencent.e.h.MqF.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(122369);
        d.a(d.this, paramLong, this.cOj);
        AppMethodBeat.o(122369);
      }
    }, 5000L, "calc_unread_task");
    AppMethodBeat.o(122385);
  }
  
  private static void reset()
  {
    riI = new int[] { 10, 1000, 10000, 100000 };
    riJ = false;
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
  
  protected final void csP()
  {
    AppMethodBeat.i(122377);
    if (!ak.cpe())
    {
      AppMethodBeat.o(122377);
      return;
    }
    long l = bu.HQ();
    Object localObject1 = b.csM().allKeys();
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      int j = localObject1.length;
      int i = 0;
      if (i < j)
      {
        localObject2 = localObject1[i];
        if (!this.riO.contains(localObject2))
        {
          String str = b.csM().get((String)localObject2, "");
          if (!bu.isNullOrNil(str))
          {
            de localde = new de(str);
            if ((localde.ega > 0L) && (localde.efZ > 0L))
            {
              localArrayList.add(new de(str));
              this.riO.add(localObject2);
            }
            b.csM().remove((String)localObject2);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          b.csM().remove((String)localObject2);
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
        a(((de)localObject2).efY, e.a.Da((int)((de)localObject2).dZW), (int)((de)localObject2).ega, ((de)localObject2).efZ);
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(932L, 102L, localArrayList.size(), false);
      ae.i("MicroMsg.MMPageFlowService", "check mmkv list[%d] cost[%d]", new Object[] { Integer.valueOf(localArrayList.size()), Long.valueOf(bu.aO(l)) });
    }
    ae.d("MicroMsg.MMPageFlowService", "check mm kv cost[%d]", new Object[] { Long.valueOf(bu.aO(l)) });
    AppMethodBeat.o(122377);
  }
  
  public final void logout()
  {
    AppMethodBeat.i(122374);
    riJ = false;
    com.tencent.mm.plugin.expt.hellhound.a.c.c.a(106, null, 0, System.currentTimeMillis());
    com.tencent.mm.plugin.expt.hellhound.a.c.c.cqP();
    com.tencent.mm.plugin.expt.hellhound.a.c.a.Dv(8);
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.Df(8);
    com.tencent.mm.plugin.expt.hellhound.a.c.a.la(true);
    ae.i("MicroMsg.MMPageFlowService", "habbyge-mali, MMPageFlowService: logout补偿上报");
    AppMethodBeat.o(122374);
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    int i = 1;
    AppMethodBeat.i(122380);
    reset();
    riJ = true;
    com.tencent.mm.plugin.expt.i.c.ctt();
    if (bu.getInt(com.tencent.mm.plugin.expt.i.c.b(b.a.qBE, ""), 0) > 0) {}
    for (;;)
    {
      if (i != 0) {
        com.tencent.mm.sdk.b.a.IvT.b(this.appListener);
      }
      com.tencent.mm.sdk.b.a.IvT.b(this.riP);
      AppMethodBeat.o(122380);
      return;
      i = 0;
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(122381);
    reset();
    com.tencent.mm.sdk.b.a.IvT.d(this.appListener);
    com.tencent.mm.sdk.b.a.IvT.d(this.riP);
    this.riL = false;
    AppMethodBeat.o(122381);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(122384);
    String str = paramActivity.getComponentName().getClassName();
    if ((riJ) && ("com.tencent.mm.ui.LauncherUI".equals(str)) && (this.riM))
    {
      str = info();
      if (paramActivity == null) {
        break label82;
      }
    }
    label82:
    for (int i = paramActivity.hashCode();; i = -1)
    {
      ae.i("MicroMsg.MMPageFlowService", "%s launcher ui ondestroyed but wechat in foreground hashcode[%d]", new Object[] { str, Integer.valueOf(i) });
      AppMethodBeat.o(122384);
      return;
    }
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(122383);
    a(paramActivity, e.a.qWZ);
    AppMethodBeat.o(122383);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(122382);
    a(paramActivity, e.a.qWY);
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