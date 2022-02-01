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
import com.tencent.mm.g.a.kz;
import com.tencent.mm.g.b.a.ba;
import com.tencent.mm.g.b.a.bk;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.expt.a.e.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class d
  implements Application.ActivityLifecycleCallbacks, com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.expt.a.e
{
  private static int[] pIC = { 10, 1000, 10000, 100000 };
  private static boolean pID = false;
  private static d pIE;
  private com.tencent.mm.sdk.b.c<k> appListener;
  private boolean pIF;
  private boolean pIG;
  private String pIH;
  private HashSet<String> pII;
  private com.tencent.mm.sdk.b.c pIJ;
  
  private d()
  {
    AppMethodBeat.i(122370);
    this.pIF = false;
    this.pIG = false;
    this.pIH = "";
    this.pII = new HashSet();
    this.appListener = new com.tencent.mm.sdk.b.c() {};
    this.pIJ = new com.tencent.mm.sdk.b.c()
    {
      private boolean cek()
      {
        AppMethodBeat.i(122367);
        ad.i("MicroMsg.MMPageFlowService", "manual force login");
        if (!d.a(d.this))
        {
          d.b(d.this);
          com.tencent.mm.plugin.expt.hellhound.a.c.c.b(105, null, null, System.currentTimeMillis());
          com.tencent.mm.plugin.expt.hellhound.a.c.c.ccq();
          com.tencent.mm.plugin.expt.hellhound.a.c.a.BB(7);
          com.tencent.mm.plugin.expt.hellhound.core.b.a.a.Bp(7);
        }
        AppMethodBeat.o(122367);
        return false;
      }
    };
    if (!aj.cbv()) {
      pID = true;
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
    long l1 = bt.GC();
    if (!aj.cbv())
    {
      if (c.pIA == null) {
        c.pIA = new c();
      }
      Object localObject1 = c.pIA;
      ad.i("MicroMsg.MMPageFlowSenderByIPCInvoker", "%s send page flow [%s-%d-%d] [%s]", new Object[] { localObject1.hashCode(), paramString, Integer.valueOf(paramInt1), Long.valueOf(paramLong), parama });
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("key_page_flow_type", parama.value);
      ((Bundle)localObject1).putString("key_page_flow_name", paramString);
      ((Bundle)localObject1).putInt("key_page_flow_hashcode", paramInt1);
      ((Bundle)localObject1).putLong("key_page_flow_time_stamp", paramLong);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(932L, 100L, 1L, false);
      Object localObject3 = ((Bundle)localObject1).getString("key_page_flow_name");
      int i = ((Bundle)localObject1).getInt("key_page_flow_type");
      int j = ((Bundle)localObject1).getInt("key_page_flow_hashcode", 0);
      long l2 = ((Bundle)localObject1).getLong("key_page_flow_time_stamp", 0L);
      String str = new StringBuilder().append(j).append("_").append(l2).toString().hashCode();
      Object localObject2 = new ba();
      ((ba)localObject2).dNK = j;
      localObject3 = ((ba)localObject2).hU((String)localObject3);
      ((ba)localObject3).dNI = i;
      ((ba)localObject3).ey(l2);
      localObject3 = b.ceg();
      localObject2 = ((ba)localObject2).PV();
      localObject3 = ((b)localObject3).Km();
      if (localObject3 != null) {
        ((ax)localObject3).putString(str, (String)localObject2);
      }
      com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", (Parcelable)localObject1, c.a.class, null);
      ad.d("MicroMsg.MMPageFlowService", "reportPageFlow: mm-process NOT");
      pID = true;
    }
    if (!pID)
    {
      ad.e("MicroMsg.MMPageFlowService", "reportPageFlow: mm-process isAccReady = FALSE");
      AppMethodBeat.o(122375);
      return;
    }
    ad.d("MicroMsg.MMPageFlowService", "reportPageFlow: mm-process YES");
    if (aj.cbv()) {
      cej();
    }
    a(paramString, parama, paramInt1, paramLong, paramInt2);
    ad.v("MicroMsg.MMPageFlowService", "report page Flow cost[%d]", new Object[] { Long.valueOf(bt.aS(l1)) });
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
      if (parama == e.a.pDH) {
        this.pIG = true;
      }
      if (parama == e.a.pDI) {
        this.pIG = false;
      }
      Object localObject = new bk();
      ((bk)localObject).dKu = paramInt2;
      paramString = ((bk)localObject).ij(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.afy().aeZ()).mProcessName).ik(paramString);
      localObject = pIC;
      paramInt2 = localObject[i];
      localObject[i] = (paramInt2 + 1);
      paramString.dPH = paramInt2;
      paramString.dNI = parama.value;
      paramString = paramString.eU(paramLong);
      paramString.dNK = paramInt1;
      e.cel().a(paramString);
      ad.d("MicroMsg.MMPageFlowService", "%s pure report [%s]", new Object[] { info(), paramString.PW() });
      if ((parama == e.a.pDH) || (parama == e.a.pDI)) {
        ad.i("MicroMsg.MMPageFlowService", "habbyge-mali, %s frontback-pure-report [%s]", new Object[] { info(), paramString.PW() });
      }
      if ((aj.cbv()) && ((parama == e.a.pDH) || (parama == e.a.pDI)))
      {
        q(paramLong, this.pIG);
        com.tencent.mm.plugin.expt.hellhound.a.c.b.BC(pIC[3]);
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
  
  public static d ceh()
  {
    AppMethodBeat.i(122371);
    if (pIE == null) {
      pIE = new d();
    }
    d locald = pIE;
    AppMethodBeat.o(122371);
    return locald;
  }
  
  public static boolean cei()
  {
    return pID;
  }
  
  private String info()
  {
    AppMethodBeat.i(122372);
    String str = hashCode();
    AppMethodBeat.o(122372);
    return str;
  }
  
  private void q(final long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(122385);
    if (!pID)
    {
      AppMethodBeat.o(122385);
      return;
    }
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pmO, 0);
    if (i <= 0)
    {
      AppMethodBeat.o(122385);
      return;
    }
    long l = com.tencent.mm.kernel.g.afB().afk().a(ae.a.FuX, 0L);
    if (bt.aGK() - l < i)
    {
      AppMethodBeat.o(122385);
      return;
    }
    com.tencent.e.h.Iye.aNW("calc_unread_task");
    com.tencent.e.h.Iye.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(122369);
        d.a(d.this, paramLong, this.cFt);
        AppMethodBeat.o(122369);
      }
    }, 5000L, "calc_unread_task");
    AppMethodBeat.o(122385);
  }
  
  private static void reset()
  {
    pIC = new int[] { 10, 1000, 10000, 100000 };
    pID = false;
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
  
  protected final void cej()
  {
    AppMethodBeat.i(122377);
    if (!aj.cbv())
    {
      AppMethodBeat.o(122377);
      return;
    }
    long l = bt.GC();
    Object localObject1 = b.ceg().allKeys();
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      int j = localObject1.length;
      int i = 0;
      if (i < j)
      {
        localObject2 = localObject1[i];
        if (!this.pII.contains(localObject2))
        {
          String str = b.ceg().get((String)localObject2, "");
          if (!bt.isNullOrNil(str))
          {
            ba localba = new ba(str);
            if ((localba.dNK > 0L) && (localba.dNJ > 0L))
            {
              localArrayList.add(new ba(str));
              this.pII.add(localObject2);
            }
            b.ceg().remove((String)localObject2);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          b.ceg().remove((String)localObject2);
        }
      }
    }
    if (!localArrayList.isEmpty())
    {
      Collections.sort(localArrayList, new Comparator() {});
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ba)((Iterator)localObject1).next();
        a(((ba)localObject2).dNH, e.a.Bm((int)((ba)localObject2).dNI), (int)((ba)localObject2).dNK, ((ba)localObject2).dNJ);
      }
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(932L, 102L, localArrayList.size(), false);
      ad.i("MicroMsg.MMPageFlowService", "check mmkv list[%d] cost[%d]", new Object[] { Integer.valueOf(localArrayList.size()), Long.valueOf(bt.aS(l)) });
    }
    ad.d("MicroMsg.MMPageFlowService", "check mm kv cost[%d]", new Object[] { Long.valueOf(bt.aS(l)) });
    AppMethodBeat.o(122377);
  }
  
  public final void logout()
  {
    AppMethodBeat.i(122374);
    pID = false;
    com.tencent.mm.plugin.expt.hellhound.a.c.c.b(106, null, null, System.currentTimeMillis());
    com.tencent.mm.plugin.expt.hellhound.a.c.c.ccq();
    com.tencent.mm.plugin.expt.hellhound.a.c.a.BB(8);
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.Bp(8);
    com.tencent.mm.plugin.expt.hellhound.a.c.a.ke(true);
    ad.i("MicroMsg.MMPageFlowService", "habbyge-mali, MMPageFlowService: logout补偿上报");
    AppMethodBeat.o(122374);
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    int i = 1;
    AppMethodBeat.i(122380);
    reset();
    pID = true;
    com.tencent.mm.plugin.expt.f.c.ceF();
    if (bt.getInt(com.tencent.mm.plugin.expt.f.c.b(b.a.pmW, ""), 0) > 0) {}
    for (;;)
    {
      if (i != 0) {
        com.tencent.mm.sdk.b.a.ESL.b(this.appListener);
      }
      com.tencent.mm.sdk.b.a.ESL.b(this.pIJ);
      AppMethodBeat.o(122380);
      return;
      i = 0;
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(122381);
    reset();
    com.tencent.mm.sdk.b.a.ESL.d(this.appListener);
    com.tencent.mm.sdk.b.a.ESL.d(this.pIJ);
    this.pIF = false;
    AppMethodBeat.o(122381);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(122384);
    String str = paramActivity.getComponentName().getClassName();
    if ((pID) && ("com.tencent.mm.ui.LauncherUI".equals(str)) && (this.pIG))
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
    a(paramActivity, e.a.pDE);
    AppMethodBeat.o(122383);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(122382);
    a(paramActivity, e.a.pDD);
    AppMethodBeat.o(122382);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.d
 * JD-Core Version:    0.7.0.1
 */