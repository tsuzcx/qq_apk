package com.tencent.mm.plugin.ball.service;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Point;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.SparseArray;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningApp;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.h.a;
import com.tencent.mm.plugin.ball.c.f;
import com.tencent.mm.plugin.ball.c.h;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.ball.ui.FloatBallProxyUI;
import com.tencent.mm.plugin.ball.ui.FloatBallProxyUI.a;
import com.tencent.mm.plugin.ball.view.FloatBallView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class d
  implements com.tencent.mm.kernel.c.b, h.a, com.tencent.mm.plugin.ball.c.c
{
  private static d ngb;
  volatile int aZD;
  private final List<BallInfo> neE;
  private Set<com.tencent.mm.plugin.ball.c.e> ngc;
  private SparseArray<Set<f>> ngd;
  private Map<String, ResultReceiver> nge;
  private volatile BallInfo ngf;
  private volatile BallInfo ngg;
  private volatile boolean ngh;
  volatile boolean ngi;
  volatile boolean ngj;
  volatile boolean ngk;
  private volatile boolean ngl;
  private volatile boolean ngm;
  private volatile long ngn;
  private volatile int ngo;
  private volatile int ngp;
  private volatile boolean ngq;
  private View ngr;
  private volatile BallInfo ngs;
  private int ngt;
  
  private d()
  {
    AppMethodBeat.i(106097);
    this.neE = new Vector();
    this.ngc = new CopyOnWriteArraySet();
    this.ngd = new SparseArray();
    this.nge = new ConcurrentHashMap();
    this.ngf = null;
    this.ngg = null;
    this.ngh = false;
    this.ngi = false;
    this.ngj = false;
    this.ngk = false;
    this.ngl = false;
    this.ngm = true;
    this.ngn = 0L;
    this.ngo = 0;
    this.ngp = 0;
    this.aZD = 0;
    this.ngq = false;
    this.ngs = null;
    this.ngt = -1;
    AppMethodBeat.o(106097);
  }
  
  private void A(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(207989);
    com.tencent.mm.plugin.ball.ui.d.bHa().b(this.neE.size(), paramBallInfo);
    AppMethodBeat.o(207989);
  }
  
  private void B(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(207990);
    int j = this.ngd.size();
    int i = 0;
    while (i < j)
    {
      int k = this.ngd.keyAt(i);
      Object localObject = (Set)this.ngd.get(k);
      if (com.tencent.mm.plugin.ball.f.d.h((Collection)localObject))
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((f)((Iterator)localObject).next()).g(paramBallInfo);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(207990);
  }
  
  private void C(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106133);
    Object localObject = (Set)this.ngd.get(paramBallInfo.type);
    if (com.tencent.mm.plugin.ball.f.d.h((Collection)localObject))
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((f)((Iterator)localObject).next()).d(paramBallInfo);
      }
    }
    AppMethodBeat.o(106133);
  }
  
  private void D(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(207992);
    paramBallInfo = h(paramBallInfo);
    if ((paramBallInfo != null) && (paramBallInfo.nfB))
    {
      ac.i("MicroMsg.FloatBallService", "removeAppBrandPassiveBallInfo, remove existedBallInfo:%s", new Object[] { paramBallInfo });
      paramBallInfo.nfD.opType = 10;
      l(paramBallInfo);
    }
    AppMethodBeat.o(207992);
  }
  
  private void M(Bundle paramBundle)
  {
    AppMethodBeat.i(207991);
    Iterator localIterator = this.nge.values().iterator();
    while (localIterator.hasNext()) {
      ((ResultReceiver)localIterator.next()).send(1, paramBundle);
    }
    AppMethodBeat.o(207991);
  }
  
  private void a(com.tencent.mm.plugin.ball.c.e parame)
  {
    AppMethodBeat.i(106138);
    this.ngc.add(parame);
    AppMethodBeat.o(106138);
  }
  
  private boolean a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184580);
    boolean bool = bGF();
    ac.i("MicroMsg.FloatBallService", "updateBallVisibilityByKbHeight isVoipShowing: %b", new Object[] { Boolean.valueOf(bool) });
    if ((bool) && (!this.ngq) && (this.ngl))
    {
      this.ngl = false;
      if ((this.ngr != null) && (this.ngr.getVisibility() != 0))
      {
        ac.d("MicroMsg.FloatBallService", "alvinluo updateBallVisibilityByKbHeight has voip but not visible and delay show animation");
        this.ngr.setVisibility(0);
        this.ngr.setAlpha(0.0F);
        a(true, false, paramAnimatorListenerAdapter);
        AppMethodBeat.o(184580);
        return true;
      }
      ac.d("MicroMsg.FloatBallService", "alvinluo updateBallVisibilityByKbHeight has voip and visible, not need to show");
      AppMethodBeat.o(184580);
      return false;
    }
    int j = bGM();
    int k = com.tencent.mm.plugin.ball.ui.d.bHa().getPositionY();
    int i;
    if (paramBoolean2)
    {
      i = paramInt2;
      if ((i + (k + j + paramInt1) < this.aZD) || (paramInt1 <= 0)) {
        break label280;
      }
    }
    label280:
    for (bool = true;; bool = false)
    {
      ac.i("MicroMsg.FloatBallService", "updateBallVisibilityByKbHeight, ballPositionY:[%s, %s], keyboardHeight:%s, screenHeight:%s, extraHeight: %d, hide: %b, checkBottomShadow: %b, checkExtraHeight: %b", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(this.aZD), Integer.valueOf(paramInt2), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      if (!bool) {
        break label286;
      }
      this.ngl = true;
      a(true, paramAnimatorListenerAdapter);
      AppMethodBeat.o(184580);
      return true;
      i = 0;
      break;
    }
    label286:
    if (this.ngl)
    {
      this.ngl = false;
      a(true, true, paramAnimatorListenerAdapter);
      AppMethodBeat.o(184580);
      return true;
    }
    AppMethodBeat.o(184580);
    return false;
  }
  
  private void b(com.tencent.mm.plugin.ball.c.e parame)
  {
    AppMethodBeat.i(106139);
    this.ngc.remove(parame);
    AppMethodBeat.o(106139);
  }
  
  private void b(BallInfo paramBallInfo, int paramInt)
  {
    AppMethodBeat.i(106136);
    paramBallInfo = paramBallInfo.bGd();
    ResultReceiver localResultReceiver = (ResultReceiver)this.nge.get(paramBallInfo);
    if (localResultReceiver != null)
    {
      ac.i("MicroMsg.FloatBallService", "notifyResultReceiver, event:%s, ballInfoHashKey:%s, receiver:%s", new Object[] { Integer.valueOf(paramInt), paramBallInfo, Integer.valueOf(localResultReceiver.hashCode()) });
      localResultReceiver.send(paramInt, new Bundle());
    }
    AppMethodBeat.o(106136);
  }
  
  /* Error */
  public static d bGD()
  {
    // Byte code:
    //   0: ldc_w 335
    //   3: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 337	com/tencent/mm/plugin/ball/service/d:ngb	Lcom/tencent/mm/plugin/ball/service/d;
    //   12: ifnonnull +19 -> 31
    //   15: ldc 2
    //   17: monitorenter
    //   18: new 2	com/tencent/mm/plugin/ball/service/d
    //   21: dup
    //   22: invokespecial 338	com/tencent/mm/plugin/ball/service/d:<init>	()V
    //   25: putstatic 337	com/tencent/mm/plugin/ball/service/d:ngb	Lcom/tencent/mm/plugin/ball/service/d;
    //   28: ldc 2
    //   30: monitorexit
    //   31: ldc 2
    //   33: monitorexit
    //   34: getstatic 337	com/tencent/mm/plugin/ball/service/d:ngb	Lcom/tencent/mm/plugin/ball/service/d;
    //   37: astore_0
    //   38: ldc_w 335
    //   41: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aload_0
    //   45: areturn
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: ldc_w 335
    //   53: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aload_0
    //   57: athrow
    //   58: astore_0
    //   59: ldc 2
    //   61: monitorexit
    //   62: ldc_w 335
    //   65: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: aload_0
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   37	8	0	locald	d
    //   46	11	0	localObject1	Object
    //   58	11	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   18	31	46	finally
    //   47	50	46	finally
    //   9	18	58	finally
    //   31	34	58	finally
    //   50	58	58	finally
    //   59	62	58	finally
  }
  
  private BallInfo bGE()
  {
    AppMethodBeat.i(184568);
    if (com.tencent.mm.plugin.ball.f.d.h(this.neE))
    {
      Iterator localIterator = this.neE.iterator();
      while (localIterator.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)localIterator.next();
        if (localBallInfo.type == 9)
        {
          AppMethodBeat.o(184568);
          return localBallInfo;
        }
      }
    }
    AppMethodBeat.o(184568);
    return null;
  }
  
  private boolean bGF()
  {
    AppMethodBeat.i(184575);
    if ((xm(9)) || (xm(17)))
    {
      AppMethodBeat.o(184575);
      return true;
    }
    AppMethodBeat.o(184575);
    return false;
  }
  
  private void bGG()
  {
    AppMethodBeat.i(184571);
    BallInfo localBallInfo;
    if (com.tencent.mm.plugin.ball.f.d.h(this.neE))
    {
      Iterator localIterator = this.neE.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localBallInfo = (BallInfo)localIterator.next();
      } while (localBallInfo.type != 7);
    }
    for (;;)
    {
      if (localBallInfo != null)
      {
        ac.i("MicroMsg.FloatBallService", "removeLocationBackgroundBallInfoIfNeed, removed");
        l(localBallInfo);
        AppMethodBeat.o(184571);
        return;
      }
      ac.i("MicroMsg.FloatBallService", "removeLocationBackgroundBallInfoIfNeed, ignore");
      AppMethodBeat.o(184571);
      return;
      localBallInfo = null;
    }
  }
  
  private void bGH()
  {
    AppMethodBeat.i(184572);
    if (g.agM())
    {
      e.bGN();
      List localList = e.bGQ();
      bK(localList);
      this.neE.clear();
      this.neE.addAll(localList);
      this.ngh = true;
      ap.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(184561);
          d.a(d.this);
          AppMethodBeat.o(184561);
        }
      }, 1000L);
      AppMethodBeat.o(184572);
      return;
    }
    ac.i("MicroMsg.FloatBallService", "restoreDataFromStorage, account not ready");
    AppMethodBeat.o(184572);
  }
  
  private boolean bGI()
  {
    AppMethodBeat.i(184574);
    BallInfo localBallInfo = h(this.ngs);
    if ((localBallInfo != null) && (com.tencent.mm.plugin.ball.f.d.h(this.neE)))
    {
      boolean bool = com.tencent.mm.plugin.ball.f.d.f(this.neE, localBallInfo);
      AppMethodBeat.o(184574);
      return bool;
    }
    AppMethodBeat.o(184574);
    return false;
  }
  
  private int bGJ()
  {
    AppMethodBeat.i(106115);
    List localList = com.tencent.mm.plugin.ball.f.d.bP(this.neE);
    if (com.tencent.mm.plugin.ball.f.d.h(localList))
    {
      int i = localList.size();
      AppMethodBeat.o(106115);
      return i;
    }
    AppMethodBeat.o(106115);
    return 0;
  }
  
  public static void bGK()
  {
    AppMethodBeat.i(106123);
    com.tencent.mm.plugin.ball.ui.d.bHa().a(false, null);
    AppMethodBeat.o(106123);
  }
  
  private void bGL()
  {
    AppMethodBeat.i(106140);
    List localList = com.tencent.mm.plugin.ball.f.d.bM(new Vector(this.neE));
    ac.i("MicroMsg.FloatBallService", "notifyFloatBallInfoChanged, originSize: %d, sortedSize: %d, ballInfoList:%s", new Object[] { Integer.valueOf(this.neE.size()), Integer.valueOf(localList.size()), localList });
    Iterator localIterator = this.ngc.iterator();
    while (localIterator.hasNext())
    {
      ((com.tencent.mm.plugin.ball.c.e)localIterator.next()).a(localList, this.ngs);
      bL(localList);
    }
    AppMethodBeat.o(106140);
  }
  
  private int bGM()
  {
    AppMethodBeat.i(184581);
    int j = com.tencent.mm.plugin.ball.f.e.nhQ + com.tencent.mm.plugin.ball.f.e.nhR + com.tencent.mm.plugin.ball.f.e.nhS;
    int i = j;
    if (this.ngr != null) {
      i = Math.max(this.ngr.getMeasuredHeight(), j);
    }
    AppMethodBeat.o(184581);
    return i;
  }
  
  private static void bK(List<BallInfo> paramList)
  {
    AppMethodBeat.i(184573);
    ac.i("MicroMsg.FloatBallService", "restoreProcessNameWithFileType");
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(184573);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BallInfo localBallInfo = (BallInfo)paramList.next();
      if ((localBallInfo != null) && (localBallInfo.type == 4) && (localBallInfo.hSN != null))
      {
        String str = localBallInfo.hSN.getString("processName");
        if (!bs.isNullOrNil(str))
        {
          ac.i("MicroMsg.FloatBallService", "restore with process name: %s", new Object[] { str });
          localBallInfo.hSN.putString("processName", "");
        }
      }
    }
    AppMethodBeat.o(184573);
  }
  
  private void bL(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106137);
    if (!this.nge.isEmpty())
    {
      int i = com.tencent.mm.plugin.ball.f.d.bP(paramList).size();
      if (this.ngt != i)
      {
        this.ngt = i;
        paramList = new Bundle();
        paramList.putInt("ActiveCount", i);
        Iterator localIterator = this.nge.values().iterator();
        while (localIterator.hasNext()) {
          ((ResultReceiver)localIterator.next()).send(5, paramList);
        }
      }
    }
    AppMethodBeat.o(106137);
  }
  
  private void iP(boolean paramBoolean)
  {
    AppMethodBeat.i(106107);
    ac.i("MicroMsg.FloatBallService", "markNoFloatBallPage:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.ngi = paramBoolean;
    AppMethodBeat.o(106107);
  }
  
  private void iQ(boolean paramBoolean)
  {
    AppMethodBeat.i(106129);
    Object localObject = h(this.ngs);
    if ((localObject != null) && (com.tencent.mm.plugin.ball.f.d.h(this.neE)))
    {
      if (com.tencent.mm.plugin.ball.f.d.e(this.neE, (BallInfo)localObject))
      {
        ac.i("MicroMsg.FloatBallService", "recheckBallInfoList, has other balls, hidden current ball info");
        boolean bool = com.tencent.mm.plugin.ball.ui.d.bHa().bGW();
        ac.i("MicroMsg.FloatBallService", "recheckBallInfoList, canNotShowFloatBall:%s, withFloatBall:%s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
        if ((!bool) && (paramBoolean)) {
          a((BallInfo)localObject, 1.0F);
        }
        Iterator localIterator = this.neE.iterator();
        while (localIterator.hasNext())
        {
          BallInfo localBallInfo = (BallInfo)localIterator.next();
          if ((!localBallInfo.nfB) && (localBallInfo.nfC) && (!localBallInfo.equals(localObject)))
          {
            localBallInfo.nfC = false;
            b(localBallInfo, 4);
          }
          else if (localBallInfo.equals(localObject))
          {
            localBallInfo.nfC = true;
          }
        }
      }
      if (com.tencent.mm.plugin.ball.f.d.f(this.neE, (BallInfo)localObject))
      {
        ac.i("MicroMsg.FloatBallService", "recheckBallInfoList, no other balls, make float ball transparent");
        ((BallInfo)localObject).nfC = false;
        a((BallInfo)localObject, 0.0F);
      }
      bGL();
      AppMethodBeat.o(106129);
      return;
    }
    if (this.ngs != null) {}
    for (localObject = this.ngs.bGd();; localObject = "null")
    {
      ac.i("MicroMsg.FloatBallService", "recheckBallInfoList, last enteredBallInfo:%s", new Object[] { localObject });
      break;
    }
  }
  
  private void x(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106117);
    if ((!paramBallInfo.nfB) && (bGJ() >= 5))
    {
      ac.i("MicroMsg.FloatBallService", "addBallInfo, already add max count balls:%s", new Object[] { Integer.valueOf(5) });
      if (!paramBallInfo.fra) {
        b.a(paramBallInfo, this.neE, true);
      }
      FloatBallProxyUI.a(new FloatBallProxyUI.a()
      {
        public final void xt(int paramAnonymousInt)
        {
          AppMethodBeat.i(207978);
          ac.i("MicroMsg.FloatBallService", "addBallInfo, show reach count limit callback:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt == 1)
          {
            ac.i("MicroMsg.FloatBallService", "addBallInfo, show float menu view");
            d.bGK();
          }
          AppMethodBeat.o(207978);
        }
      });
      AppMethodBeat.o(106117);
      return;
    }
    if (!this.neE.contains(paramBallInfo))
    {
      long l = bs.eWj();
      paramBallInfo.nfz = l;
      paramBallInfo.createTime = l;
      paramBallInfo.nfD.opType = -1;
      Object localObject;
      int i;
      if (paramBallInfo.type != 20)
      {
        localObject = paramBallInfo.nfD;
        if ((paramBallInfo.nfB) && (paramBallInfo.nfD.nfE == 0)) {
          i = 3;
        }
      }
      for (((BallReportInfo)localObject).nfE = i;; paramBallInfo.nfD.nfE = 5)
      {
        this.neE.add(paramBallInfo);
        ac.i("MicroMsg.FloatBallService", "addBallInfo, existed:false, ballInfo:%s", new Object[] { paramBallInfo });
        if (!paramBallInfo.fra) {
          b.a(paramBallInfo, this.neE, false);
        }
        z(paramBallInfo);
        iQ(true);
        localObject = new Bundle();
        ((Bundle)localObject).putInt("type", paramBallInfo.type);
        ((Bundle)localObject).putString("key", paramBallInfo.key);
        M((Bundle)localObject);
        B(paramBallInfo);
        ((com.tencent.mm.plugin.handoff.a.a)g.ab(com.tencent.mm.plugin.handoff.a.a.class)).I(paramBallInfo);
        AppMethodBeat.o(106117);
        return;
        i = paramBallInfo.nfD.nfE;
        break;
      }
    }
    ac.i("MicroMsg.FloatBallService", "addBallInfo, existed:true, replaceExisted: %b, ballInfo:%s", new Object[] { Boolean.valueOf(paramBallInfo.nfA), paramBallInfo });
    if (paramBallInfo.nfA)
    {
      paramBallInfo.nfA = false;
      k(paramBallInfo);
    }
    AppMethodBeat.o(106117);
  }
  
  private void y(final BallInfo paramBallInfo)
  {
    AppMethodBeat.i(207987);
    com.tencent.mm.plugin.ball.ui.d.bHa().c(true, new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(207979);
        super.onAnimationEnd(paramAnonymousAnimator);
        d.this.a(paramBallInfo, 1.0F);
        AppMethodBeat.o(207979);
      }
    });
    AppMethodBeat.o(207987);
  }
  
  private void z(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(207988);
    ac.d("MicroMsg.FloatBallService", "onFloatBallAdded %s", new Object[] { paramBallInfo });
    com.tencent.mm.plugin.ball.ui.d.bHa().a(this.neE.size(), paramBallInfo);
    AppMethodBeat.o(207988);
  }
  
  public final void a(final int paramInt1, final int paramInt2, boolean paramBoolean, long paramLong)
  {
    boolean bool = false;
    AppMethodBeat.i(184577);
    this.ngo = paramInt1;
    this.ngp = paramInt2;
    this.ngq = paramBoolean;
    if (!com.tencent.mm.plugin.ball.ui.d.bHa().bHb())
    {
      ac.i("MicroMsg.FloatBallService", "KeyboardHeightChanged, no float ball");
      AppMethodBeat.o(184577);
      return;
    }
    if (paramBoolean) {
      iM(true);
    }
    while (paramLong != 0L)
    {
      ap.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(207976);
          d locald = d.this;
          int i = paramInt1;
          int j = paramInt2;
          if (d.b(d.this) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            d.a(locald, i, j, bool);
            AppMethodBeat.o(207976);
            return;
          }
        }
      }, paramLong);
      AppMethodBeat.o(184577);
      return;
      iM(false);
    }
    paramBoolean = bool;
    if (this.ngo != 0) {
      paramBoolean = true;
    }
    a(paramInt1, paramInt2, true, paramBoolean, null);
    AppMethodBeat.o(184577);
  }
  
  public final void a(int paramInt, f paramf)
  {
    AppMethodBeat.i(106131);
    ac.i("MicroMsg.FloatBallService", "addFloatBallInfoEventListener, type:%s", new Object[] { Integer.valueOf(paramInt) });
    if (paramf != null)
    {
      Set localSet = (Set)this.ngd.get(paramInt);
      Object localObject = localSet;
      if (localSet == null)
      {
        localObject = new HashSet();
        this.ngd.put(paramInt, localObject);
      }
      ((Set)localObject).add(paramf);
    }
    AppMethodBeat.o(106131);
  }
  
  public final void a(long paramLong, com.tencent.mm.plugin.ball.c.c.a parama)
  {
    int i = 1;
    AppMethodBeat.i(207983);
    if (this.ngg == null)
    {
      ac.w("MicroMsg.FloatBallService", "alvinluo addMessageBall readyMessageBallInfo is invalid");
      if (parama != null) {
        parama.xp(7);
      }
      AppMethodBeat.o(207983);
      return;
    }
    if ((!this.ngm) && (!this.ngk))
    {
      ac.w("MicroMsg.FloatBallService", "alvinluo addMessageBall isWechatForeground: %b", new Object[] { Boolean.valueOf(this.ngm) });
      if (parama != null) {
        parama.xp(6);
      }
      this.ngg = null;
      AppMethodBeat.o(207983);
      return;
    }
    if (!com.tencent.mm.plugin.ball.f.d.a(this.ngg, paramLong))
    {
      ac.w("MicroMsg.FloatBallService", "alvinluo addMessageBall can not add message ball because of time over limit");
      if (parama != null) {
        parama.xp(5);
      }
      this.ngg = null;
      AppMethodBeat.o(207983);
      return;
    }
    if (this.ngf == null)
    {
      this.ngf = new BallInfo(20, this.ngg.key);
      this.ngf.u(this.ngg);
      ac.i("MicroMsg.FloatBallService", "alvinluo addMessageBall existed: false, and add: %s", new Object[] { this.ngf });
      j(this.ngf);
      this.ngg = null;
      if (parama != null) {
        parama.xp(i);
      }
      AppMethodBeat.o(207983);
      return;
    }
    BallInfo localBallInfo = this.ngg;
    if (this.ngf == null) {
      ac.w("MicroMsg.FloatBallService", "alvinluo updateMessageBall messageBallInfo is null and ignore");
    }
    for (;;)
    {
      if ((this.ngf != null) && (!this.ngf.fra))
      {
        this.ngf.nfD.nfE = 6;
        b.a(this.ngf, this.neE, false);
      }
      i = 2;
      break;
      if (h(this.ngf) != null)
      {
        this.ngf.u(localBallInfo);
        this.ngf.key = localBallInfo.key;
        ac.i("MicroMsg.FloatBallService", "alvinluo updateMessageBall existed: true, and update %s", new Object[] { this.ngf });
        k(this.ngf);
      }
      else
      {
        ac.w("MicroMsg.FloatBallService", "alvinluo updateMessageBall messageBallInfo not null but not added!!");
      }
    }
  }
  
  public final void a(ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(207985);
    com.tencent.mm.plugin.ball.ui.d.bHa().a(true, paramResultReceiver);
    AppMethodBeat.o(207985);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(106112);
    if (paramh != null)
    {
      if (com.tencent.mm.plugin.ball.f.d.h(this.neE))
      {
        paramh.bm(new ArrayList(this.neE));
        AppMethodBeat.o(106112);
        return;
      }
      paramh.bm(new ArrayList());
    }
    AppMethodBeat.o(106112);
  }
  
  public final void a(BallInfo paramBallInfo, float paramFloat)
  {
    AppMethodBeat.i(106122);
    if ((paramFloat == 1.0F) || (com.tencent.mm.plugin.ball.f.d.f(this.neE, paramBallInfo))) {
      ap.f(new com.tencent.mm.plugin.ball.ui.d.2(com.tencent.mm.plugin.ball.ui.d.bHa(), paramFloat));
    }
    AppMethodBeat.o(106122);
  }
  
  public final void a(BallInfo paramBallInfo, ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(106134);
    if ((paramBallInfo != null) && (paramResultReceiver != null))
    {
      paramBallInfo = paramBallInfo.bGd();
      ac.i("MicroMsg.FloatBallService", "registerFloatBallEventReceiver, key:%s, receiver:%s", new Object[] { paramBallInfo, Integer.valueOf(paramResultReceiver.hashCode()) });
      this.nge.put(paramBallInfo, paramResultReceiver);
    }
    AppMethodBeat.o(106134);
  }
  
  public final void a(BallInfo paramBallInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(106130);
    paramBallInfo = h(paramBallInfo);
    if (paramBallInfo != null)
    {
      if (!paramBoolean) {}
      for (boolean bool = true;; bool = false)
      {
        paramBallInfo.nfC = bool;
        ac.i("MicroMsg.FloatBallService", "updateBallVisibility, existed:true, visible:%s, ballInfo:%s", new Object[] { Boolean.valueOf(paramBoolean), paramBallInfo });
        bGL();
        AppMethodBeat.o(106130);
        return;
      }
    }
    ac.i("MicroMsg.FloatBallService", "updateBallVisibility, existed:false");
    AppMethodBeat.o(106130);
  }
  
  public final void a(List<AppBrandBackgroundRunningApp> paramList, AppBrandBackgroundRunningOperationParcel paramAppBrandBackgroundRunningOperationParcel, int paramInt)
  {
    AppMethodBeat.i(106141);
    ac.i("MicroMsg.FloatBallService", "onBackgroundRunningAppChanged, operation:%s, change:%s", new Object[] { paramAppBrandBackgroundRunningOperationParcel, Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      AppMethodBeat.o(106141);
      return;
    }
    if ((paramAppBrandBackgroundRunningOperationParcel.cZu == 2) || (paramAppBrandBackgroundRunningOperationParcel.cZu == 3))
    {
      if ((paramAppBrandBackgroundRunningOperationParcel.aUu & 0x2) > 0) {
        D(new BallInfo(7, com.tencent.mm.plugin.ball.f.b.cn(paramAppBrandBackgroundRunningOperationParcel.appId, paramAppBrandBackgroundRunningOperationParcel.hxM)));
      }
      if ((paramAppBrandBackgroundRunningOperationParcel.aUu & 0x4) > 0)
      {
        paramList = paramAppBrandBackgroundRunningOperationParcel.appId;
        paramInt = paramAppBrandBackgroundRunningOperationParcel.hxM;
        D(new BallInfo(17, String.format(Locale.US, "%s#%d", new Object[] { paramList, Integer.valueOf(paramInt) })));
      }
      if ((paramAppBrandBackgroundRunningOperationParcel.aUu & 0x8) > 0) {
        D(new BallInfo(18, com.tencent.mm.plugin.ball.f.b.cm(paramAppBrandBackgroundRunningOperationParcel.appId, paramAppBrandBackgroundRunningOperationParcel.hxM)));
      }
      if ((paramAppBrandBackgroundRunningOperationParcel.aUu & 0x10) > 0) {
        D(new BallInfo(19, com.tencent.mm.plugin.ball.f.b.cm(paramAppBrandBackgroundRunningOperationParcel.appId, paramAppBrandBackgroundRunningOperationParcel.hxM)));
      }
      AppMethodBeat.o(106141);
      return;
    }
    ac.i("MicroMsg.FloatBallService", "onBackgroundRunningAppChanged, operation ignored");
    AppMethodBeat.o(106141);
  }
  
  public final void a(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184567);
    if (this.ngk)
    {
      ac.i("MicroMsg.FloatBallService", "hideFloatBall, has marked QB file view page, ignore hiding");
      AppMethodBeat.o(184567);
      return;
    }
    if ((bGF()) && (!this.ngj)) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.FloatBallService", "hideFloatBall forceHide: %b, canShowFloatBall: %b, voipInfo: %s", new Object[] { Boolean.valueOf(this.ngj), Boolean.valueOf(bool), bGE() });
      if (!bool) {
        break;
      }
      AppMethodBeat.o(184567);
      return;
    }
    com.tencent.mm.plugin.ball.ui.d.bHa().e(paramBoolean, paramAnimatorListenerAdapter);
    AppMethodBeat.o(184567);
  }
  
  final void a(boolean paramBoolean1, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184570);
    if (!com.tencent.mm.compatible.d.b.cc(ai.getContext()))
    {
      ac.i("MicroMsg.FloatBallService", "resumeFloatBall, no float window permission");
      bGG();
      com.tencent.mm.plugin.ball.ui.d.bHa().bHc();
      this.ngh = false;
      this.neE.clear();
      e.bGN().clear();
      bGL();
      AppMethodBeat.o(184570);
      return;
    }
    if (this.ngh)
    {
      if ((this.ngi) && (!bGF()))
      {
        ac.i("MicroMsg.FloatBallService", "resumeFloatBall, has marked no float ball page, ignore resuming");
        AppMethodBeat.o(184570);
        return;
      }
      if (this.ngj)
      {
        ac.i("MicroMsg.FloatBallService", "resumeFloatBall, has marked forceHideAllFloatBall, ignore resuming");
        AppMethodBeat.o(184570);
        return;
      }
      if (this.ngl)
      {
        ac.i("MicroMsg.FloatBallService", "resumeFloatBall, hasHideForKeyboardHeightChange, ignore resuming");
        AppMethodBeat.o(184570);
        return;
      }
      if (!bGI())
      {
        ac.i("MicroMsg.FloatBallService", "resumeFloatBall not singleBallInfoCondition, withAnimation:%s", new Object[] { Boolean.valueOf(paramBoolean1) });
        com.tencent.mm.plugin.ball.ui.d.bHa().b(paramBoolean1, paramBoolean2, paramAnimatorListenerAdapter);
        AppMethodBeat.o(184570);
        return;
      }
      ac.i("MicroMsg.FloatBallService", "resumeFloatBall singleBallInfoCondition, withAnimation:false");
      com.tencent.mm.plugin.ball.ui.d.bHa().b(false, paramBoolean2, paramAnimatorListenerAdapter);
      c(this.ngs, true);
      AppMethodBeat.o(184570);
      return;
    }
    ac.i("MicroMsg.FloatBallService", "resumeFloatBall, restore data from storage");
    bGH();
    AppMethodBeat.o(184570);
  }
  
  public final void ahM()
  {
    AppMethodBeat.i(106099);
    ac.i("MicroMsg.FloatBallService", "onRegister:%s", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(106099);
  }
  
  public final void ahN()
  {
    AppMethodBeat.i(106100);
    ac.i("MicroMsg.FloatBallService", "onUnregister:%s", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(106100);
  }
  
  public final void b(int paramInt, f paramf)
  {
    AppMethodBeat.i(106132);
    ac.i("MicroMsg.FloatBallService", "removeFloatBallInfoEventListener, type:%s", new Object[] { Integer.valueOf(paramInt) });
    if (paramf != null)
    {
      Set localSet = (Set)this.ngd.get(paramInt);
      if (localSet != null) {
        localSet.remove(paramf);
      }
    }
    AppMethodBeat.o(106132);
  }
  
  public final void bFL()
  {
    AppMethodBeat.i(106105);
    ac.i("MicroMsg.FloatBallService", "onAccountInitialized:%s", new Object[] { Integer.valueOf(hashCode()) });
    a(com.tencent.mm.plugin.ball.ui.d.bHa());
    a(e.bGN());
    this.ngh = false;
    a(true, true, null);
    AppMethodBeat.o(106105);
  }
  
  public final boolean bFM()
  {
    return this.ngi;
  }
  
  public final boolean bFN()
  {
    return this.ngk;
  }
  
  public final long bFO()
  {
    return this.ngn;
  }
  
  public final void bFP()
  {
    AppMethodBeat.i(106109);
    iK(false);
    iP(false);
    if (this.ngs != null)
    {
      ac.i("MicroMsg.FloatBallService", "fixFloatBallIfNeed, lastEnteredBallInfo:%s", new Object[] { this.ngs });
      q(h(this.ngs));
      AppMethodBeat.o(106109);
      return;
    }
    ac.i("MicroMsg.FloatBallService", "fixFloatBallIfNeed, safe");
    AppMethodBeat.o(106109);
  }
  
  public final void bFQ()
  {
    AppMethodBeat.i(106111);
    bc.aF(ai.getContext(), 2131766133);
    AppMethodBeat.o(106111);
  }
  
  public final List<BallInfo> bFR()
  {
    return this.neE;
  }
  
  public final void bFS()
  {
    this.ngr = null;
  }
  
  public final boolean bFT()
  {
    return this.ngj;
  }
  
  public final void bFU()
  {
    AppMethodBeat.i(184565);
    com.tencent.mm.plugin.ball.ui.d locald = com.tencent.mm.plugin.ball.ui.d.bHa();
    if (locald.bHb()) {
      locald.nhn.bFU();
    }
    AppMethodBeat.o(184565);
  }
  
  public final void bFV()
  {
    AppMethodBeat.i(184566);
    com.tencent.mm.plugin.ball.ui.d locald = com.tencent.mm.plugin.ball.ui.d.bHa();
    if (locald.bHb()) {
      locald.nhn.bFV();
    }
    AppMethodBeat.o(184566);
  }
  
  final void c(BallInfo paramBallInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(106127);
    BallInfo localBallInfo = h(paramBallInfo);
    if (localBallInfo != null)
    {
      localBallInfo.nfz = bs.eWj();
      this.ngs = localBallInfo;
      ac.i("MicroMsg.FloatBallService", "onEnterBallInfoPage, set lastEnteredBallInfo:%s", new Object[] { this.ngs.bGd() });
      iQ(paramBoolean);
      AppMethodBeat.o(106127);
      return;
    }
    if (paramBallInfo != null) {}
    for (paramBallInfo = paramBallInfo.bGd();; paramBallInfo = "null")
    {
      ac.i("MicroMsg.FloatBallService", "onEnterBallInfoPage, no this ball info:%s", new Object[] { paramBallInfo });
      AppMethodBeat.o(106127);
      return;
    }
  }
  
  public final boolean c(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184579);
    if (!com.tencent.mm.plugin.ball.ui.d.bHa().bHb())
    {
      ac.i("MicroMsg.FloatBallService", "updateBallVisibilityByPosition, no float ball");
      AppMethodBeat.o(184579);
      return false;
    }
    if (!this.ngq)
    {
      ac.i("MicroMsg.FloatBallService", "updateBallVisibilityByPosition keyboard not show and ignore");
      AppMethodBeat.o(184579);
      return false;
    }
    boolean bool = a(this.ngo, this.ngp, false, false, paramAnimatorListenerAdapter);
    AppMethodBeat.o(184579);
    return bool;
  }
  
  public final void du(View paramView)
  {
    this.ngr = paramView;
  }
  
  public final Point getBallPosition()
  {
    AppMethodBeat.i(106121);
    Object localObject1 = com.tencent.mm.plugin.ball.ui.d.bHa();
    if (((com.tencent.mm.plugin.ball.ui.d)localObject1).bHb())
    {
      localObject1 = ((com.tencent.mm.plugin.ball.ui.d)localObject1).nhn;
      if (((com.tencent.mm.plugin.ball.ui.a)localObject1).ngN != null) {
        localObject1 = ((com.tencent.mm.plugin.ball.ui.a)localObject1).ngN.getBallPosition();
      }
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new Point(com.tencent.mm.plugin.ball.f.d.bHj(), com.tencent.mm.plugin.ball.f.d.bHk());
      }
      ac.i("MicroMsg.FloatBallService", "getBallPosition, position:[%s, %s]", new Object[] { Integer.valueOf(((Point)localObject2).x), Integer.valueOf(((Point)localObject2).y) });
      AppMethodBeat.o(106121);
      return localObject2;
      localObject1 = new Point(com.tencent.mm.plugin.ball.f.d.bHj(), com.tencent.mm.plugin.ball.f.d.bHk());
      continue;
      localObject1 = new Point(com.tencent.mm.plugin.ball.f.d.bHj(), com.tencent.mm.plugin.ball.f.d.bHk());
    }
  }
  
  public final BallInfo h(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106113);
    synchronized (this.neE)
    {
      if (this.neE.contains(paramBallInfo))
      {
        paramBallInfo = (BallInfo)this.neE.get(this.neE.indexOf(paramBallInfo));
        ac.i("MicroMsg.FloatBallService", "getBallInfo, existed:true, responseBallInfo:%s", new Object[] { paramBallInfo });
        AppMethodBeat.o(106113);
        return paramBallInfo;
      }
      ac.i("MicroMsg.FloatBallService", "getBallInfo, existed:false");
      AppMethodBeat.o(106113);
      return null;
    }
  }
  
  public final boolean i(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106114);
    if (bGJ() >= 5)
    {
      ac.i("MicroMsg.FloatBallService", "canAddBallInfo, false");
      if (!paramBallInfo.fra) {
        b.a(paramBallInfo, this.neE, true);
      }
      AppMethodBeat.o(106114);
      return false;
    }
    ac.i("MicroMsg.FloatBallService", "canAddBallInfo, true");
    AppMethodBeat.o(106114);
    return true;
  }
  
  public final void iE(boolean paramBoolean)
  {
    AppMethodBeat.i(106101);
    a(paramBoolean, null);
    AppMethodBeat.o(106101);
  }
  
  public final void iF(boolean paramBoolean)
  {
    AppMethodBeat.i(106102);
    a(paramBoolean, true, null);
    AppMethodBeat.o(106102);
  }
  
  public final void iG(boolean paramBoolean)
  {
    AppMethodBeat.i(106103);
    iP(true);
    a(paramBoolean, null);
    AppMethodBeat.o(106103);
  }
  
  public final void iH(boolean paramBoolean)
  {
    AppMethodBeat.i(106104);
    iP(false);
    a(paramBoolean, true, null);
    AppMethodBeat.o(106104);
  }
  
  public final void iI(boolean paramBoolean)
  {
    AppMethodBeat.i(207981);
    com.tencent.mm.plugin.ball.ui.d.bHa().c(paramBoolean, new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(207975);
        super.onAnimationEnd(paramAnonymousAnimator);
        d.this.a(null, 1.0F);
        AppMethodBeat.o(207975);
      }
    });
    AppMethodBeat.o(207981);
  }
  
  public final void iJ(boolean paramBoolean)
  {
    AppMethodBeat.i(176960);
    ac.i("MicroMsg.FloatBallService", "markWechatInForeground, foreground:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.ngm = paramBoolean;
    if (this.ngk)
    {
      ac.i("MicroMsg.FloatBallService", "markWechatInForeground, has marked QB file view page, mark Wechat in foreground");
      com.tencent.mm.plugin.ball.ui.d.bHa().iJ(true);
    }
    for (;;)
    {
      if (!this.ngm)
      {
        ac.i("MicroMsg.FloatBallService", "alvinluo resetReadyStatusBallInfo");
        this.ngg = null;
      }
      AppMethodBeat.o(176960);
      return;
      com.tencent.mm.plugin.ball.ui.d.bHa().iJ(paramBoolean);
    }
  }
  
  public final void iK(boolean paramBoolean)
  {
    AppMethodBeat.i(106108);
    ac.i("MicroMsg.FloatBallService", "markQBFileViewPage:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.ngk = paramBoolean;
    AppMethodBeat.o(106108);
  }
  
  public final void iL(boolean paramBoolean)
  {
    AppMethodBeat.i(184564);
    com.tencent.mm.plugin.ball.ui.d locald = com.tencent.mm.plugin.ball.ui.d.bHa();
    if (locald.bHb()) {
      locald.nhn.ngQ = paramBoolean;
    }
    AppMethodBeat.o(184564);
  }
  
  public final void iM(boolean paramBoolean)
  {
    AppMethodBeat.i(185124);
    ac.i("MicroMsg.FloatBallService", "markForceHideAllFloatBall %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.ngj = paramBoolean;
    com.tencent.mm.plugin.ball.ui.d.bHa().ngj = paramBoolean;
    AppMethodBeat.o(185124);
  }
  
  public final void j(final BallInfo paramBallInfo)
  {
    int j = 0;
    AppMethodBeat.i(106116);
    if ((paramBallInfo.type == 6) && (paramBallInfo.nfD.nfF == 11)) {}
    for (int i = 1; (i != 0) && (!com.tencent.mm.compatible.d.b.cc(ai.getContext())); i = 0)
    {
      ac.i("MicroMsg.FloatBallService", "isAskForPermissionAlready, no permission & no ask for");
      AppMethodBeat.o(106116);
      return;
    }
    i = paramBallInfo.type;
    if (i == 7)
    {
      ac.i("MicroMsg.FloatBallService", "shouldCheckPermissionWhenAddBallInfo, ignore for ballType: location");
      i = j;
    }
    while (i != 0)
    {
      com.tencent.mm.plugin.ball.f.c.a(ai.getContext(), paramBallInfo.type, true, new com.tencent.mm.plugin.ball.f.c.a()
      {
        public final void fZ(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(207977);
          if (paramAnonymousBoolean)
          {
            d.a(d.this, paramBallInfo);
            AppMethodBeat.o(207977);
            return;
          }
          ac.w("MicroMsg.FloatBallService", "no float window permission");
          AppMethodBeat.o(207977);
        }
      });
      AppMethodBeat.o(106116);
      return;
      if (i == 17)
      {
        ac.i("MicroMsg.FloatBallService", "shouldCheckPermissionWhenAddBallInfo, ignore for ballType: appbrand_voip");
        i = j;
      }
      else if (i == 18)
      {
        ac.i("MicroMsg.FloatBallService", "shouldCheckPermissionWhenAddBallInfo, ignore for ballType: audio_of_video_background_play");
        i = j;
      }
      else
      {
        i = 1;
      }
    }
    x(paramBallInfo);
    AppMethodBeat.o(106116);
  }
  
  public final void k(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106118);
    BallInfo localBallInfo = h(paramBallInfo);
    if (localBallInfo != null)
    {
      localBallInfo.u(paramBallInfo);
      ac.i("MicroMsg.FloatBallService", "updateBallInfo, existed:true, ballInfo:%s", new Object[] { localBallInfo });
      bGL();
      AppMethodBeat.o(106118);
      return;
    }
    ac.i("MicroMsg.FloatBallService", "updateBallInfo, existed:false");
    AppMethodBeat.o(106118);
  }
  
  public final void l(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106119);
    if (this.neE.contains(paramBallInfo))
    {
      if (paramBallInfo.type == 9)
      {
        com.tencent.mm.plugin.ball.ui.d.bHa().bGV();
        paramBallInfo.tk = null;
      }
      this.neE.remove(paramBallInfo);
      e.bGN().l(paramBallInfo);
      b.b(paramBallInfo, this.neE.isEmpty());
      ac.i("MicroMsg.FloatBallService", "removeBallInfo, existed:true, ballInfo:%s", new Object[] { paramBallInfo });
      if ((this.ngs != null) && (this.ngs.equals(paramBallInfo)))
      {
        ac.i("MicroMsg.FloatBallService", "removeBallInfo, remove last enteredBallInfo");
        this.ngs = null;
      }
      A(paramBallInfo);
      iQ(true);
      b(paramBallInfo, 3);
      C(paramBallInfo);
      ((com.tencent.mm.plugin.handoff.a.a)g.ab(com.tencent.mm.plugin.handoff.a.a.class)).del(paramBallInfo.key);
      if (paramBallInfo.equals(this.ngf))
      {
        this.ngf = null;
        AppMethodBeat.o(106119);
      }
    }
    else
    {
      ac.i("MicroMsg.FloatBallService", "removeBallInfo, existed:false");
    }
    AppMethodBeat.o(106119);
  }
  
  public final void m(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106124);
    int i = paramBallInfo.nfD.opType;
    if ((i == 1) || (i == 2) || (i == 3)) {}
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        ac.w("MicroMsg.FloatBallReportLogic", "activeBallTypeReport unexpected opType:%d", new Object[] { Integer.valueOf(paramBallInfo.nfD.opType) });
        paramBallInfo.nfD.opType = 3;
      }
      b.a(paramBallInfo, bs.eWj() - paramBallInfo.nfz, 0L, 0L, 0L);
      c(paramBallInfo, true);
      int j = paramBallInfo.type;
      i = j;
      if (j == 20) {
        i = paramBallInfo.aUt;
      }
      ac.d("MicroMsg.FloatBallService", "alvinluo notifySingleBallInfoClicked type: %d, contentType: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramBallInfo.aUt) });
      Object localObject = (Set)this.ngd.get(i);
      if (!com.tencent.mm.plugin.ball.f.d.h((Collection)localObject)) {
        break;
      }
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((f)((Iterator)localObject).next()).c(paramBallInfo);
      }
    }
    AppMethodBeat.o(106124);
  }
  
  public final void n(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106120);
    if (this.neE.contains(paramBallInfo))
    {
      Object localObject = (Set)this.ngd.get(paramBallInfo.type);
      if (com.tencent.mm.plugin.ball.f.d.h((Collection)localObject))
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((f)((Iterator)localObject).next()).e(paramBallInfo);
        }
      }
      AppMethodBeat.o(106120);
      return;
    }
    ac.i("MicroMsg.FloatBallService", "exposeBallInfo, existed:false");
    AppMethodBeat.o(106120);
  }
  
  public final void o(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(210517);
    c(paramBallInfo, true);
    AppMethodBeat.o(210517);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(106106);
    ac.i("MicroMsg.FloatBallService", "onAccountRelease:%s", new Object[] { Integer.valueOf(hashCode()) });
    b(com.tencent.mm.plugin.ball.ui.d.bHa());
    b(e.bGN());
    this.ngh = false;
    com.tencent.mm.plugin.ball.ui.d.bHa().bHc();
    AppMethodBeat.o(106106);
  }
  
  public final void p(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106126);
    c(paramBallInfo, false);
    AppMethodBeat.o(106126);
  }
  
  public final void q(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106128);
    Object localObject;
    if (this.ngs != null)
    {
      localObject = this.ngs.bGd();
      ac.i("MicroMsg.FloatBallService", "onExitBallInfoPage, lastEnteredBallInfo:%s", new Object[] { localObject });
      this.ngs = null;
      localObject = h(paramBallInfo);
      if (localObject == null) {
        break label147;
      }
      ac.i("MicroMsg.FloatBallService", "onExitBallInfoPage, ballInfo:%s", new Object[] { localObject });
      if (((BallInfo)localObject).nfD.opType != -1) {
        break label132;
      }
      ((BallInfo)localObject).nfD.opType = 0;
      label87:
      if (com.tencent.mm.plugin.ball.ui.d.bHa().bGW()) {
        break label139;
      }
      a(paramBallInfo, 1.0F);
    }
    for (;;)
    {
      if (!((BallInfo)localObject).nfC) {
        break label160;
      }
      ((BallInfo)localObject).nfC = false;
      bGL();
      AppMethodBeat.o(106128);
      return;
      localObject = "null";
      break;
      label132:
      b.w((BallInfo)localObject);
      break label87;
      label139:
      y(paramBallInfo);
    }
    label147:
    ac.i("MicroMsg.FloatBallService", "onExitBallInfoPage, no this ball info");
    y(paramBallInfo);
    label160:
    AppMethodBeat.o(106128);
  }
  
  public final void r(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106135);
    String str;
    if (paramBallInfo != null)
    {
      str = paramBallInfo.bGd();
      paramBallInfo = (ResultReceiver)this.nge.remove(str);
      if (paramBallInfo == null) {
        break label68;
      }
    }
    label68:
    for (paramBallInfo = Integer.valueOf(paramBallInfo.hashCode());; paramBallInfo = null)
    {
      ac.i("MicroMsg.FloatBallService", "removeFloatBallEventReceiver, key:%s, receiver:%s", new Object[] { str, paramBallInfo });
      AppMethodBeat.o(106135);
      return;
    }
  }
  
  public final void rf(long paramLong)
  {
    this.ngn = paramLong;
  }
  
  public final void s(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(207982);
    if (paramBallInfo == null) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d("MicroMsg.FloatBallService", "alvinluo markMessageBallInfo ballInfo == null: %b, %s, readyInfo == null: %b", new Object[] { Boolean.valueOf(bool), paramBallInfo, this.ngg });
      if (paramBallInfo != null)
      {
        if (this.ngg == null) {
          this.ngg = new BallInfo(20, paramBallInfo.key);
        }
        this.ngg.u(paramBallInfo);
        this.ngg.key = paramBallInfo.key;
        this.ngg.type = 20;
        this.ngg.state = 256;
        this.ngg.nfC = false;
        this.ngg.nfB = true;
        this.ngg.fto = System.currentTimeMillis();
        if ((paramBallInfo.type == 4) && (this.ngg.hSN != null))
        {
          paramBallInfo = this.ngg.hSN.getString("processName");
          if (!bs.isNullOrNil(paramBallInfo))
          {
            ac.d("MicroMsg.FloatBallService", "markMessageBallInfo reset processName: %s", new Object[] { paramBallInfo });
            this.ngg.hSN.putString("processName", "");
          }
        }
      }
      AppMethodBeat.o(207982);
      return;
    }
  }
  
  public final void setEnableClick(boolean paramBoolean)
  {
    AppMethodBeat.i(207980);
    Object localObject = com.tencent.mm.plugin.ball.ui.d.bHa();
    if (((com.tencent.mm.plugin.ball.ui.d)localObject).bHb())
    {
      localObject = ((com.tencent.mm.plugin.ball.ui.d)localObject).nhn;
      if (((com.tencent.mm.plugin.ball.ui.a)localObject).ngN != null) {
        ((com.tencent.mm.plugin.ball.ui.a)localObject).ngN.setEnableClick(paramBoolean);
      }
    }
    AppMethodBeat.o(207980);
  }
  
  public final boolean xm(int paramInt)
  {
    AppMethodBeat.i(184576);
    if (com.tencent.mm.plugin.ball.f.d.h(this.neE))
    {
      Iterator localIterator = this.neE.iterator();
      while (localIterator.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)localIterator.next();
        if ((localBallInfo.type == paramInt) && (!localBallInfo.nfC))
        {
          AppMethodBeat.o(184576);
          return true;
        }
      }
    }
    AppMethodBeat.o(184576);
    return false;
  }
  
  public final void xn(int paramInt)
  {
    this.aZD = paramInt;
  }
  
  public final void xo(int paramInt)
  {
    AppMethodBeat.i(207984);
    if ((this.ngf != null) && (this.ngf.aUt == paramInt))
    {
      ac.i("MicroMsg.FloatBallService", "alvinluo removeMessageBall type: %d", new Object[] { Integer.valueOf(paramInt) });
      l(this.ngf);
    }
    AppMethodBeat.o(207984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.d
 * JD-Core Version:    0.7.0.1
 */