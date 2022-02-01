package com.tencent.mm.plugin.ball.service;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Point;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningApp;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.g.a;
import com.tencent.mm.plugin.ball.a.h;
import com.tencent.mm.plugin.ball.c.b.a;
import com.tencent.mm.plugin.ball.c.g;
import com.tencent.mm.plugin.ball.c.i;
import com.tencent.mm.plugin.ball.f.c.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallInfo.a;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.ball.ui.FloatBallProxyUI;
import com.tencent.mm.plugin.ball.ui.FloatBallProxyUI.a;
import com.tencent.mm.plugin.ball.ui.d.2;
import com.tencent.mm.plugin.ball.view.FloatBallView;
import com.tencent.mm.plugin.ball.view.FloatBallView.8;
import com.tencent.mm.plugin.ball.view.FloatBallView.9;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sensitive.d.f;
import com.tencent.mm.ui.aw;
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
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class c
  implements com.tencent.mm.kernel.c.b, g.a, com.tencent.mm.plugin.ball.c.b
{
  private static c vkk;
  volatile int displayHeight;
  private volatile int sNb;
  public final List<BallInfo> viG;
  private volatile boolean vkA;
  private View vkB;
  private volatile BallInfo vkC;
  private int vkD;
  private final List<BallInfo> vkl;
  private Set<com.tencent.mm.plugin.ball.c.d> vkm;
  private Set<g> vkn;
  private final SparseArray<Set<com.tencent.mm.plugin.ball.c.e>> vko;
  private Map<String, ResultReceiver> vkp;
  private volatile BallInfo vkq;
  private volatile BallInfo vkr;
  private volatile boolean vks;
  volatile boolean vkt;
  volatile boolean vku;
  volatile boolean vkv;
  private volatile boolean vkw;
  private volatile boolean vkx;
  private volatile long vky;
  private volatile int vkz;
  
  private c()
  {
    AppMethodBeat.i(106097);
    this.viG = new CopyOnWriteArrayList();
    this.vkl = new CopyOnWriteArrayList();
    this.vkm = new CopyOnWriteArraySet();
    this.vkn = new CopyOnWriteArraySet();
    this.vko = new SparseArray();
    this.vkp = new ConcurrentHashMap();
    this.vkq = null;
    this.vkr = null;
    this.vks = false;
    this.vkt = false;
    this.vku = false;
    this.vkv = false;
    this.vkw = false;
    this.vkx = true;
    this.vky = 0L;
    this.sNb = 0;
    this.vkz = 0;
    this.displayHeight = 0;
    this.vkA = false;
    this.vkC = null;
    this.vkD = -1;
    AppMethodBeat.o(106097);
  }
  
  private void A(final BallInfo paramBallInfo)
  {
    AppMethodBeat.i(288420);
    com.tencent.mm.plugin.ball.ui.d.cYZ().c(true, new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(288390);
        super.onAnimationEnd(paramAnonymousAnimator);
        if (!c.c(c.this)) {
          c.this.a(paramBallInfo, 1.0F);
        }
        AppMethodBeat.o(288390);
      }
    });
    AppMethodBeat.o(288420);
  }
  
  private void B(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(288425);
    Log.d("MicroMsg.FloatBallService", "onFloatBallAdded %s", new Object[] { paramBallInfo });
    com.tencent.mm.plugin.ball.ui.d.cYZ().a(this.viG.size(), paramBallInfo);
    AppMethodBeat.o(288425);
  }
  
  private void C(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(288426);
    com.tencent.mm.plugin.ball.ui.d.cYZ().b(this.viG.size(), paramBallInfo);
    AppMethodBeat.o(288426);
  }
  
  private void D(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(288428);
    int j = this.vko.size();
    int i = 0;
    while (i < j)
    {
      int k = this.vko.keyAt(i);
      Object localObject = (Set)this.vko.get(k);
      if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty((Collection)localObject))
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((com.tencent.mm.plugin.ball.c.e)((Iterator)localObject).next()).g(paramBallInfo);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(288428);
  }
  
  private void E(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106133);
    Object localObject = (Set)this.vko.get(paramBallInfo.type);
    if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty((Collection)localObject))
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.plugin.ball.c.e)((Iterator)localObject).next()).c(paramBallInfo);
      }
    }
    localObject = (Set)this.vko.get(0);
    if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty((Collection)localObject))
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.plugin.ball.c.e)((Iterator)localObject).next()).c(paramBallInfo);
      }
    }
    AppMethodBeat.o(106133);
  }
  
  private void F(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(288441);
    paramBallInfo = h(paramBallInfo);
    if ((paramBallInfo != null) && (paramBallInfo.vjH))
    {
      Log.i("MicroMsg.FloatBallService", "removeAppBrandPassiveBallInfo, remove existedBallInfo:%s", new Object[] { paramBallInfo });
      paramBallInfo.vjI.opType = 10;
      l(paramBallInfo);
    }
    AppMethodBeat.o(288441);
  }
  
  private boolean a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184580);
    boolean bool = cXH();
    Log.i("MicroMsg.FloatBallService", "updateBallVisibilityByKbHeight needShowFloatBall: %b", new Object[] { Boolean.valueOf(bool) });
    if ((bool) && (!this.vkA) && (this.vkw))
    {
      this.vkw = false;
      if ((this.vkB != null) && (this.vkB.getVisibility() != 0))
      {
        Log.d("MicroMsg.FloatBallService", "alvinluo updateBallVisibilityByKbHeight has voip but not visible and delay show animation");
        this.vkB.setVisibility(0);
        this.vkB.setAlpha(0.0F);
        a(true, false, paramAnimatorListenerAdapter);
        AppMethodBeat.o(184580);
        return true;
      }
      Log.d("MicroMsg.FloatBallService", "alvinluo updateBallVisibilityByKbHeight has voip and visible, not need to show");
      AppMethodBeat.o(184580);
      return false;
    }
    int j = cYJ();
    int k = com.tencent.mm.plugin.ball.ui.d.cYZ().getPositionY();
    int i;
    if (paramBoolean2)
    {
      i = paramInt2;
      if ((i + (k + j + paramInt1) < this.displayHeight) || (paramInt1 <= 0)) {
        break label284;
      }
    }
    label284:
    for (bool = true;; bool = false)
    {
      Log.i("MicroMsg.FloatBallService", "updateBallVisibilityByKbHeight, ballPositionY:[%s, %s], keyboardHeight:%s, screenHeight:%s, extraHeight: %d, hide: %b, checkBottomShadow: %b, checkExtraHeight: %b", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(this.displayHeight), Integer.valueOf(paramInt2), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      if (!bool) {
        break label290;
      }
      this.vkw = true;
      a(true, paramAnimatorListenerAdapter);
      AppMethodBeat.o(184580);
      return true;
      i = 0;
      break;
    }
    label290:
    if (this.vkw)
    {
      this.vkw = false;
      a(true, true, paramAnimatorListenerAdapter);
      AppMethodBeat.o(184580);
      return true;
    }
    AppMethodBeat.o(184580);
    return false;
  }
  
  private void ai(Bundle paramBundle)
  {
    AppMethodBeat.i(288436);
    Iterator localIterator = this.vkp.values().iterator();
    while (localIterator.hasNext()) {
      ((ResultReceiver)localIterator.next()).send(1, paramBundle);
    }
    AppMethodBeat.o(288436);
  }
  
  private void b(BallInfo paramBallInfo, int paramInt)
  {
    AppMethodBeat.i(106136);
    paramBallInfo = paramBallInfo.cYc();
    ResultReceiver localResultReceiver = (ResultReceiver)this.vkp.get(paramBallInfo);
    if (localResultReceiver != null)
    {
      Log.i("MicroMsg.FloatBallService", "notifyResultReceiver, event:%s, ballInfoHashKey:%s, receiver:%s", new Object[] { Integer.valueOf(paramInt), paramBallInfo, Integer.valueOf(localResultReceiver.hashCode()) });
      localResultReceiver.send(paramInt, new Bundle());
    }
    AppMethodBeat.o(106136);
  }
  
  /* Error */
  public static c cYC()
  {
    // Byte code:
    //   0: ldc_w 351
    //   3: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 353	com/tencent/mm/plugin/ball/service/c:vkk	Lcom/tencent/mm/plugin/ball/service/c;
    //   12: ifnonnull +19 -> 31
    //   15: ldc 2
    //   17: monitorenter
    //   18: new 2	com/tencent/mm/plugin/ball/service/c
    //   21: dup
    //   22: invokespecial 354	com/tencent/mm/plugin/ball/service/c:<init>	()V
    //   25: putstatic 353	com/tencent/mm/plugin/ball/service/c:vkk	Lcom/tencent/mm/plugin/ball/service/c;
    //   28: ldc 2
    //   30: monitorexit
    //   31: ldc 2
    //   33: monitorexit
    //   34: getstatic 353	com/tencent/mm/plugin/ball/service/c:vkk	Lcom/tencent/mm/plugin/ball/service/c;
    //   37: astore_0
    //   38: ldc_w 351
    //   41: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aload_0
    //   45: areturn
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: ldc_w 351
    //   53: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aload_0
    //   57: athrow
    //   58: astore_0
    //   59: ldc 2
    //   61: monitorexit
    //   62: ldc_w 351
    //   65: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: aload_0
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   37	8	0	localc	c
    //   46	11	0	localObject1	Object
    //   58	11	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   18	31	46	finally
    //   9	18	58	finally
    //   31	34	58	finally
    //   47	58	58	finally
  }
  
  private BallInfo cYD()
  {
    AppMethodBeat.i(288403);
    if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(this.viG))
    {
      Iterator localIterator = this.viG.iterator();
      while (localIterator.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)localIterator.next();
        if (com.tencent.mm.plugin.ball.f.d.H(localBallInfo))
        {
          AppMethodBeat.o(288403);
          return localBallInfo;
        }
      }
    }
    AppMethodBeat.o(288403);
    return null;
  }
  
  private void cYE()
  {
    AppMethodBeat.i(184571);
    BallInfo localBallInfo;
    if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(this.viG))
    {
      Iterator localIterator = this.viG.iterator();
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
        Log.i("MicroMsg.FloatBallService", "removeLocationBackgroundBallInfoIfNeed, removed");
        l(localBallInfo);
        AppMethodBeat.o(184571);
        return;
      }
      Log.i("MicroMsg.FloatBallService", "removeLocationBackgroundBallInfoIfNeed, ignore");
      AppMethodBeat.o(184571);
      return;
      localBallInfo = null;
    }
  }
  
  private void cYF()
  {
    AppMethodBeat.i(184572);
    if (com.tencent.mm.kernel.h.baz())
    {
      d.cYL();
      List localList1 = d.cYP();
      dP(localList1);
      this.viG.clear();
      if (aw.isMultiTaskMode())
      {
        List localList2 = com.tencent.mm.plugin.ball.f.d.dV(localList1);
        this.viG.addAll(localList2);
      }
      for (;;)
      {
        localList1 = com.tencent.mm.plugin.ball.f.d.dU(localList1);
        this.vkl.clear();
        this.vkl.addAll(localList1);
        this.vks = true;
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(184561);
            c.a(c.this);
            AppMethodBeat.o(184561);
          }
        }, 1000L);
        AppMethodBeat.o(184572);
        return;
        this.viG.addAll(localList1);
      }
    }
    Log.i("MicroMsg.FloatBallService", "restoreDataFromStorage, account not ready");
    AppMethodBeat.o(184572);
  }
  
  private boolean cYG()
  {
    AppMethodBeat.i(184574);
    BallInfo localBallInfo = h(this.vkC);
    if ((localBallInfo != null) && (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(this.viG)))
    {
      boolean bool = com.tencent.mm.plugin.ball.f.d.f(this.viG, localBallInfo);
      AppMethodBeat.o(184574);
      return bool;
    }
    AppMethodBeat.o(184574);
    return false;
  }
  
  public static void cYH()
  {
    AppMethodBeat.i(106123);
    com.tencent.mm.plugin.ball.ui.d.cYZ().a(false, null);
    AppMethodBeat.o(106123);
  }
  
  private void cYI()
  {
    AppMethodBeat.i(106140);
    synchronized (this.viG)
    {
      List localList2 = com.tencent.mm.plugin.ball.f.d.dR(new Vector(this.viG));
      Log.i("MicroMsg.FloatBallService", "notifyFloatBallInfoChanged, originSize: %d, sortedSize: %d, ballInfoList:%s", new Object[] { Integer.valueOf(this.viG.size()), Integer.valueOf(localList2.size()), localList2 });
      Iterator localIterator = this.vkm.iterator();
      if (localIterator.hasNext())
      {
        ((com.tencent.mm.plugin.ball.c.d)localIterator.next()).a(localList2, this.vkC);
        dQ(localList2);
      }
    }
    AppMethodBeat.o(106140);
  }
  
  private int cYJ()
  {
    AppMethodBeat.i(184581);
    int j = com.tencent.mm.plugin.ball.f.e.vmd + com.tencent.mm.plugin.ball.f.e.vme + com.tencent.mm.plugin.ball.f.e.vmf;
    int i = j;
    if (this.vkB != null) {
      i = Math.max(this.vkB.getMeasuredHeight(), j);
    }
    AppMethodBeat.o(184581);
    return i;
  }
  
  private void cYK()
  {
    AppMethodBeat.i(288449);
    Log.i("MicroMsg.FloatBallService", "alvinluo resetReadyStatusBallInfo");
    this.vkr = null;
    AppMethodBeat.o(288449);
  }
  
  private int cYn()
  {
    AppMethodBeat.i(106115);
    List localList = com.tencent.mm.plugin.ball.f.d.dU(this.viG);
    if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(localList))
    {
      int i = localList.size();
      AppMethodBeat.o(106115);
      return i;
    }
    AppMethodBeat.o(106115);
    return 0;
  }
  
  private static void dP(List<BallInfo> paramList)
  {
    AppMethodBeat.i(184573);
    Log.i("MicroMsg.FloatBallService", "restoreProcessNameWithFileType");
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(184573);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BallInfo localBallInfo = (BallInfo)paramList.next();
      if ((localBallInfo != null) && (localBallInfo.type == 4) && (localBallInfo.oSS != null))
      {
        String str = localBallInfo.oSS.getString("processName");
        if (!Util.isNullOrNil(str))
        {
          Log.i("MicroMsg.FloatBallService", "restore with process name: %s", new Object[] { str });
          localBallInfo.oSS.putString("processName", "");
        }
      }
    }
    AppMethodBeat.o(184573);
  }
  
  private void dQ(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106137);
    if (!this.vkp.isEmpty())
    {
      int i = com.tencent.mm.plugin.ball.f.d.dU(paramList).size();
      if (this.vkD != i)
      {
        this.vkD = i;
        paramList = new Bundle();
        paramList.putInt("ActiveCount", i);
        Iterator localIterator = this.vkp.values().iterator();
        while (localIterator.hasNext()) {
          ((ResultReceiver)localIterator.next()).send(5, paramList);
        }
      }
    }
    AppMethodBeat.o(106137);
  }
  
  private void mt(boolean paramBoolean)
  {
    AppMethodBeat.i(106107);
    Log.i("MicroMsg.FloatBallService", "markNoFloatBallPage:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.vkt = paramBoolean;
    AppMethodBeat.o(106107);
  }
  
  private void mu(boolean paramBoolean)
  {
    AppMethodBeat.i(106129);
    Object localObject = h(this.vkC);
    if ((localObject != null) && (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(this.viG)))
    {
      if (com.tencent.mm.plugin.ball.f.d.e(this.viG, (BallInfo)localObject))
      {
        Log.i("MicroMsg.FloatBallService", "recheckBallInfoList, has other balls, hidden current ball info");
        boolean bool = com.tencent.mm.plugin.ball.ui.d.cYZ().cYV();
        Log.i("MicroMsg.FloatBallService", "recheckBallInfoList, canNotShowFloatBall:%s, withFloatBall:%s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
        if ((!bool) && (paramBoolean)) {
          a((BallInfo)localObject, 1.0F);
        }
        Iterator localIterator = this.viG.iterator();
        while (localIterator.hasNext())
        {
          BallInfo localBallInfo = (BallInfo)localIterator.next();
          if ((!localBallInfo.vjH) && (localBallInfo.trn) && (!localBallInfo.equals(localObject)))
          {
            localBallInfo.trn = false;
            b(localBallInfo, 4);
          }
          else if (localBallInfo.equals(localObject))
          {
            localBallInfo.trn = true;
          }
        }
      }
      if (com.tencent.mm.plugin.ball.f.d.f(this.viG, (BallInfo)localObject))
      {
        Log.i("MicroMsg.FloatBallService", "recheckBallInfoList, no other balls, make float ball transparent");
        ((BallInfo)localObject).trn = false;
        a((BallInfo)localObject, 0.0F);
      }
      cYI();
      AppMethodBeat.o(106129);
      return;
    }
    if (this.vkC != null) {}
    for (localObject = this.vkC.cYc();; localObject = "null")
    {
      Log.i("MicroMsg.FloatBallService", "recheckBallInfoList, last enteredBallInfo:%s", new Object[] { localObject });
      break;
    }
  }
  
  private void z(final BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106117);
    int j = paramBallInfo.cIh;
    int i = j;
    if (j == 20) {
      i = paramBallInfo.cIh;
    }
    Object localObject = com.tencent.mm.sensitive.h.actP;
    if (!com.tencent.mm.sensitive.h.a(i, new d.f()
    {
      public final void onOp(Boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(288386);
        if (paramAnonymousBoolean.booleanValue())
        {
          c.a(c.this, paramBallInfo);
          AppMethodBeat.o(288386);
          return;
        }
        if (paramBallInfo.dyK != null) {
          paramBallInfo.dyK.performClick();
        }
        Log.w("MicroMsg.FloatBallService", "no float window business permission");
        AppMethodBeat.o(288386);
      }
    }))
    {
      AppMethodBeat.o(106117);
      return;
    }
    if ((!paramBallInfo.vjH) && (cYn() >= 5))
    {
      Log.i("MicroMsg.FloatBallService", "addBallInfo, already add max count balls:%s", new Object[] { Integer.valueOf(5) });
      FloatBallProxyUI.a(1, new FloatBallProxyUI.a()
      {
        public final void onCallback(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(288381);
          Log.i("MicroMsg.FloatBallService", "addBallInfo, show reach count limit callback:%s, proxyMode: %d", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1) });
          if (paramAnonymousInt2 == 1)
          {
            Log.i("MicroMsg.FloatBallService", "addBallInfo, show float menu view");
            c.cYH();
          }
          AppMethodBeat.o(288381);
        }
      });
      AppMethodBeat.o(106117);
      return;
    }
    if (!this.viG.contains(paramBallInfo))
    {
      if ((com.tencent.mm.plugin.ball.f.d.H(paramBallInfo)) && (com.tencent.mm.plugin.ball.f.d.eb(this.viG)))
      {
        Log.e("MicroMsg.FloatBallService", "addBallInfo video ball is already exist and can not add more");
        AppMethodBeat.o(106117);
        return;
      }
      long l = Util.nowMilliSecond();
      paramBallInfo.vjF = l;
      paramBallInfo.createTime = l;
      paramBallInfo.vjI.opType = -1;
      if (paramBallInfo.type != 20)
      {
        localObject = paramBallInfo.vjI;
        if ((paramBallInfo.vjH) && (paramBallInfo.vjI.mUT == 0)) {}
        for (i = 3;; i = paramBallInfo.vjI.mUT)
        {
          ((BallReportInfo)localObject).mUT = i;
          this.viG.add(paramBallInfo);
          Log.i("MicroMsg.FloatBallService", "addBallInfo, existed:false, ballInfo:%s", new Object[] { paramBallInfo });
          if (!paramBallInfo.lwK) {
            a.a(paramBallInfo, this.viG);
          }
          B(paramBallInfo);
          mu(true);
          localObject = new Bundle();
          ((Bundle)localObject).putInt("type", paramBallInfo.type);
          ((Bundle)localObject).putString("key", paramBallInfo.key);
          ai((Bundle)localObject);
          D(paramBallInfo);
          ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).S(paramBallInfo);
          AppMethodBeat.o(106117);
          return;
        }
      }
      localObject = paramBallInfo.vjI;
      if (paramBallInfo.vjI.mUT != 0) {}
      for (i = paramBallInfo.vjI.mUT;; i = 5)
      {
        ((BallReportInfo)localObject).mUT = i;
        break;
      }
    }
    Log.i("MicroMsg.FloatBallService", "addBallInfo, existed:true, replaceExisted: %b, ballInfo:%s", new Object[] { Boolean.valueOf(paramBallInfo.vjG), paramBallInfo });
    if (paramBallInfo.vjG)
    {
      paramBallInfo.vjG = false;
      k(paramBallInfo);
    }
    AppMethodBeat.o(106117);
  }
  
  public final void FE(int paramInt)
  {
    this.displayHeight = paramInt;
  }
  
  public final void FF(int paramInt)
  {
    AppMethodBeat.i(288576);
    if ((this.vkq != null) && (this.vkq.cIh == paramInt))
    {
      Log.i("MicroMsg.FloatBallService", "alvinluo removeMessageBall type: %d", new Object[] { Integer.valueOf(paramInt) });
      synchronized (this.viG)
      {
        l(this.vkq);
        AppMethodBeat.o(288576);
        return;
      }
    }
    AppMethodBeat.o(288576);
  }
  
  public final void a(final int paramInt1, final int paramInt2, boolean paramBoolean, long paramLong)
  {
    boolean bool = false;
    AppMethodBeat.i(184577);
    this.sNb = paramInt1;
    this.vkz = paramInt2;
    this.vkA = paramBoolean;
    if (!com.tencent.mm.plugin.ball.ui.d.cYZ().cZa())
    {
      Log.i("MicroMsg.FloatBallService", "KeyboardHeightChanged, no float ball");
      AppMethodBeat.o(184577);
      return;
    }
    if (paramBoolean) {
      mq(true);
    }
    while (paramLong != 0L)
    {
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(288382);
          c localc = c.this;
          int i = paramInt1;
          int j = paramInt2;
          if (c.b(c.this) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            c.a(localc, i, j, bool);
            AppMethodBeat.o(288382);
            return;
          }
        }
      }, paramLong);
      AppMethodBeat.o(184577);
      return;
      mq(false);
    }
    paramBoolean = bool;
    if (this.sNb != 0) {
      paramBoolean = true;
    }
    a(paramInt1, paramInt2, true, paramBoolean, null);
    AppMethodBeat.o(184577);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.ball.c.e parame)
  {
    AppMethodBeat.i(106131);
    Log.i("MicroMsg.FloatBallService", "addFloatBallInfoEventListener, type:%s", new Object[] { Integer.valueOf(paramInt) });
    if (parame != null) {
      synchronized (this.vko)
      {
        Set localSet = (Set)this.vko.get(paramInt);
        Object localObject = localSet;
        if (localSet == null)
        {
          localObject = new HashSet();
          this.vko.put(paramInt, localObject);
        }
        ((Set)localObject).add(parame);
        AppMethodBeat.o(106131);
        return;
      }
    }
    AppMethodBeat.o(106131);
  }
  
  public final void a(long paramLong, b.a parama)
  {
    AppMethodBeat.i(288570);
    if (this.vkr == null)
    {
      Log.w("MicroMsg.FloatBallService", "alvinluo addMessageBall readyMessageBallInfo is invalid and ignore");
      AppMethodBeat.o(288570);
      return;
    }
    if ((!this.vkx) && (!this.vkv))
    {
      Log.w("MicroMsg.FloatBallService", "alvinluo addMessageBall isWechatForeground: %b", new Object[] { Boolean.valueOf(this.vkx) });
      if (parama != null) {
        parama.onAddResult(6);
      }
      this.vkr = null;
      AppMethodBeat.o(288570);
      return;
    }
    if (!com.tencent.mm.plugin.ball.f.d.a(this.vkr, paramLong))
    {
      Log.w("MicroMsg.FloatBallService", "alvinluo addMessageBall can not add message ball because of time over limit %s", new Object[] { Integer.valueOf(com.tencent.mm.plugin.ball.f.d.cZj()) });
      if (parama != null) {
        parama.onAddResult(5);
      }
      this.vkr = null;
      AppMethodBeat.o(288570);
      return;
    }
    int i;
    label239:
    Object localObject;
    if ((this.vkq == null) || (h(this.vkq) == null))
    {
      this.vkq = new BallInfo(20, this.vkr.key);
      this.vkq.w(this.vkr);
      i = 1;
      Log.i("MicroMsg.FloatBallService", "alvinluo addMessageBall addResult: %s, and add: %s", new Object[] { Integer.valueOf(i), this.vkq });
      if (i != 1) {
        break label392;
      }
      this.vkr.vjI.mUT = 5;
      localObject = this.vkr;
      int k = ((BallInfo)localObject).type;
      j = k;
      if (k == 20) {
        j = ((BallInfo)localObject).cIh;
      }
      Log.d("MicroMsg.FloatBallService", "alvinluo notifyAddMessageFloatBall type: %d, ball.type: %d, contentType: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(((BallInfo)localObject).type), Integer.valueOf(((BallInfo)localObject).cIh) });
      localObject = (Set)this.vko.get(j);
      if (!com.tencent.mm.plugin.ball.f.d.checkListNotEmpty((Collection)localObject)) {
        break label407;
      }
      localObject = ((Set)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((com.tencent.mm.plugin.ball.c.e)((Iterator)localObject).next()).coy());
    }
    label392:
    label407:
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        break label413;
      }
      AppMethodBeat.o(288570);
      return;
      i = 2;
      break;
      this.vkr.vjI.mUT = 6;
      break label239;
    }
    label413:
    if (i == 1)
    {
      this.vkq.vjI.mUT = 5;
      j(this.vkq);
    }
    label597:
    for (;;)
    {
      this.vkr = null;
      if (parama != null) {
        parama.onAddResult(i);
      }
      AppMethodBeat.o(288570);
      return;
      localObject = this.vkr;
      if (this.vkq == null) {
        Log.w("MicroMsg.FloatBallService", "alvinluo updateMessageBall messageBallInfo is null and ignore");
      }
      for (;;)
      {
        if ((this.vkq == null) || (this.vkq.lwK)) {
          break label597;
        }
        this.vkq.vjI.mUT = 6;
        a.a(this.vkq, this.viG);
        break;
        if (h(this.vkq) != null)
        {
          this.vkq.w((BallInfo)localObject);
          this.vkq.key = ((BallInfo)localObject).key;
          Log.i("MicroMsg.FloatBallService", "alvinluo updateMessageBall existed: true, and update %s", new Object[] { this.vkq });
          k(this.vkq);
        }
        else
        {
          Log.w("MicroMsg.FloatBallService", "alvinluo updateMessageBall messageBallInfo not null but not added!!");
        }
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.ball.c.d paramd)
  {
    AppMethodBeat.i(106138);
    this.vkm.add(paramd);
    AppMethodBeat.o(106138);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(288632);
    this.vkn.add(paramg);
    com.tencent.mm.plugin.ball.ui.d locald = com.tencent.mm.plugin.ball.ui.d.cYZ();
    if (locald.cZa()) {
      locald.vlA.a(paramg);
    }
    AppMethodBeat.o(288632);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(106112);
    if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(this.viG))
    {
      parami.dr(new ArrayList(this.viG));
      AppMethodBeat.o(106112);
      return;
    }
    parami.dr(new ArrayList());
    AppMethodBeat.o(106112);
  }
  
  public final void a(BallInfo paramBallInfo, float paramFloat)
  {
    AppMethodBeat.i(106122);
    if ((paramFloat == 1.0F) || (com.tencent.mm.plugin.ball.f.d.f(this.viG, paramBallInfo))) {
      MMHandlerThread.postToMainThread(new d.2(com.tencent.mm.plugin.ball.ui.d.cYZ(), paramFloat));
    }
    AppMethodBeat.o(106122);
  }
  
  public final void a(BallInfo paramBallInfo, ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(106134);
    if ((paramBallInfo != null) && (paramResultReceiver != null))
    {
      paramBallInfo = paramBallInfo.cYc();
      Log.i("MicroMsg.FloatBallService", "registerFloatBallEventReceiver, key:%s, receiver:%s", new Object[] { paramBallInfo, Integer.valueOf(paramResultReceiver.hashCode()) });
      this.vkp.put(paramBallInfo, paramResultReceiver);
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
        paramBallInfo.trn = bool;
        Log.i("MicroMsg.FloatBallService", "updateBallVisibility, existed:true, visible:%s, ballInfo:%s", new Object[] { Boolean.valueOf(paramBoolean), paramBallInfo });
        cYI();
        AppMethodBeat.o(106130);
        return;
      }
    }
    Log.i("MicroMsg.FloatBallService", "updateBallVisibility, existed:false");
    AppMethodBeat.o(106130);
  }
  
  public final void a(List<AppBrandBackgroundRunningApp> paramList, AppBrandBackgroundRunningOperationParcel paramAppBrandBackgroundRunningOperationParcel, int paramInt)
  {
    AppMethodBeat.i(106141);
    Log.i("MicroMsg.FloatBallService", "onBackgroundRunningAppChanged, operation:%s, change:%s", new Object[] { paramAppBrandBackgroundRunningOperationParcel, Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      AppMethodBeat.o(106141);
      return;
    }
    if ((paramAppBrandBackgroundRunningOperationParcel.hAf == 2) || (paramAppBrandBackgroundRunningOperationParcel.hAf == 3))
    {
      if ((paramAppBrandBackgroundRunningOperationParcel.cIi & 0x2) > 0) {
        F(new BallInfo(7, com.tencent.mm.plugin.ball.f.b.dy(paramAppBrandBackgroundRunningOperationParcel.appId, paramAppBrandBackgroundRunningOperationParcel.euz)));
      }
      if ((paramAppBrandBackgroundRunningOperationParcel.cIi & 0x4) > 0)
      {
        paramList = paramAppBrandBackgroundRunningOperationParcel.appId;
        paramInt = paramAppBrandBackgroundRunningOperationParcel.euz;
        F(new BallInfo(17, String.format(Locale.US, "%s#%d", new Object[] { paramList, Integer.valueOf(paramInt) })));
      }
      if ((paramAppBrandBackgroundRunningOperationParcel.cIi & 0x8) > 0) {
        F(new BallInfo(18, com.tencent.mm.plugin.ball.f.b.dx(paramAppBrandBackgroundRunningOperationParcel.appId, paramAppBrandBackgroundRunningOperationParcel.euz)));
      }
      if ((paramAppBrandBackgroundRunningOperationParcel.cIi & 0x10) > 0) {
        F(new BallInfo(19, com.tencent.mm.plugin.ball.f.b.dx(paramAppBrandBackgroundRunningOperationParcel.appId, paramAppBrandBackgroundRunningOperationParcel.euz)));
      }
      if ((paramAppBrandBackgroundRunningOperationParcel.cIi & 0x20) > 0) {
        F(new BallInfo(33, com.tencent.mm.plugin.ball.f.b.dx(paramAppBrandBackgroundRunningOperationParcel.appId, paramAppBrandBackgroundRunningOperationParcel.euz)));
      }
      AppMethodBeat.o(106141);
      return;
    }
    Log.i("MicroMsg.FloatBallService", "onBackgroundRunningAppChanged, operation ignored");
    AppMethodBeat.o(106141);
  }
  
  public final void a(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184567);
    if (this.vkv)
    {
      Log.i("MicroMsg.FloatBallService", "hideFloatBall, has marked QB file view page, ignore hiding");
      AppMethodBeat.o(184567);
      return;
    }
    if ((cXH()) && (!this.vku)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.FloatBallService", "hideFloatBall forceHide: %b, canShowFloatBall: %b, videoBallInfo: %s", new Object[] { Boolean.valueOf(this.vku), Boolean.valueOf(bool), cYD() });
      if (!bool) {
        break;
      }
      AppMethodBeat.o(184567);
      return;
    }
    com.tencent.mm.plugin.ball.ui.d.cYZ().e(paramBoolean, paramAnimatorListenerAdapter);
    AppMethodBeat.o(184567);
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184570);
    if (!com.tencent.mm.compatible.e.b.dh(MMApplicationContext.getContext()))
    {
      Log.i("MicroMsg.FloatBallService", "resumeFloatBall, no float window permission");
      cYE();
      com.tencent.mm.plugin.ball.ui.d.cYZ().cZb();
      this.vks = false;
      this.viG.clear();
      d.cYL().clear();
      cYI();
      AppMethodBeat.o(184570);
      return;
    }
    if (this.vks)
    {
      if ((this.vkt) && (!cXH()))
      {
        Log.i("MicroMsg.FloatBallService", "resumeFloatBall, has marked no float ball page, ignore resuming");
        AppMethodBeat.o(184570);
        return;
      }
      if (this.vku)
      {
        Log.i("MicroMsg.FloatBallService", "resumeFloatBall, has marked forceHideAllFloatBall, ignore resuming");
        AppMethodBeat.o(184570);
        return;
      }
      if (this.vkw)
      {
        Log.i("MicroMsg.FloatBallService", "resumeFloatBall, hasHideForKeyboardHeightChange, ignore resuming");
        AppMethodBeat.o(184570);
        return;
      }
      if (!cYG())
      {
        Log.i("MicroMsg.FloatBallService", "resumeFloatBall not singleBallInfoCondition, withAnimation:%s", new Object[] { Boolean.valueOf(paramBoolean1) });
        com.tencent.mm.plugin.ball.ui.d.cYZ().b(paramBoolean1, paramBoolean2, paramAnimatorListenerAdapter);
        AppMethodBeat.o(184570);
        return;
      }
      Log.i("MicroMsg.FloatBallService", "resumeFloatBall singleBallInfoCondition, withAnimation:false");
      com.tencent.mm.plugin.ball.ui.d.cYZ().b(false, paramBoolean2, paramAnimatorListenerAdapter);
      c(this.vkC, true);
      AppMethodBeat.o(184570);
      return;
    }
    Log.i("MicroMsg.FloatBallService", "resumeFloatBall, restore data from storage");
    cYF();
    AppMethodBeat.o(184570);
  }
  
  public final void aZq()
  {
    AppMethodBeat.i(106105);
    Log.i("MicroMsg.FloatBallService", "onAccountInitialized:%s", new Object[] { Integer.valueOf(hashCode()) });
    a(com.tencent.mm.plugin.ball.ui.d.cYZ());
    a(d.cYL());
    this.vks = false;
    a(true, true, null);
    AppMethodBeat.o(106105);
  }
  
  public final void b(int paramInt, com.tencent.mm.plugin.ball.c.e parame)
  {
    AppMethodBeat.i(106132);
    Log.i("MicroMsg.FloatBallService", "removeFloatBallInfoEventListener, type:%s", new Object[] { Integer.valueOf(paramInt) });
    if (parame != null) {
      synchronized (this.vko)
      {
        Set localSet = (Set)this.vko.get(paramInt);
        if (localSet != null) {
          localSet.remove(parame);
        }
        AppMethodBeat.o(106132);
        return;
      }
    }
    AppMethodBeat.o(106132);
  }
  
  public final void b(ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(288595);
    com.tencent.mm.plugin.ball.ui.d.cYZ().a(true, paramResultReceiver);
    AppMethodBeat.o(288595);
  }
  
  public final void b(com.tencent.mm.plugin.ball.c.d paramd)
  {
    AppMethodBeat.i(106139);
    this.vkm.remove(paramd);
    AppMethodBeat.o(106139);
  }
  
  public final void b(g paramg)
  {
    AppMethodBeat.i(288635);
    this.vkn.remove(paramg);
    Object localObject = com.tencent.mm.plugin.ball.ui.d.cYZ();
    if (((com.tencent.mm.plugin.ball.ui.d)localObject).cZa())
    {
      localObject = ((com.tencent.mm.plugin.ball.ui.d)localObject).vlA;
      if (((com.tencent.mm.plugin.ball.ui.a)localObject).vla != null) {
        ((com.tencent.mm.plugin.ball.ui.a)localObject).vla.listeners.remove(paramg);
      }
    }
    AppMethodBeat.o(288635);
  }
  
  public final void bbB()
  {
    AppMethodBeat.i(106099);
    Log.i("MicroMsg.FloatBallService", "onRegister:%s", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(106099);
  }
  
  public final void bbC()
  {
    AppMethodBeat.i(106100);
    Log.i("MicroMsg.FloatBallService", "onUnregister:%s", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(106100);
  }
  
  final void c(BallInfo paramBallInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(106127);
    BallInfo localBallInfo = h(paramBallInfo);
    if (localBallInfo != null)
    {
      localBallInfo.vjF = Util.nowMilliSecond();
      this.vkC = localBallInfo;
      Log.i("MicroMsg.FloatBallService", "onEnterBallInfoPage, set lastEnteredBallInfo:%s, withFloatBall: %s", new Object[] { this.vkC.cYc(), Boolean.valueOf(paramBoolean) });
      mu(paramBoolean);
      AppMethodBeat.o(106127);
      return;
    }
    if (paramBallInfo != null) {}
    for (paramBallInfo = paramBallInfo.cYc();; paramBallInfo = "null")
    {
      Log.i("MicroMsg.FloatBallService", "onEnterBallInfoPage, no this ball info:%s, withFloatBall: %s", new Object[] { paramBallInfo, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(106127);
      return;
    }
  }
  
  public final boolean c(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184579);
    if (!com.tencent.mm.plugin.ball.ui.d.cYZ().cZa())
    {
      Log.i("MicroMsg.FloatBallService", "updateBallVisibilityByPosition, no float ball");
      AppMethodBeat.o(184579);
      return false;
    }
    if (!this.vkA)
    {
      Log.i("MicroMsg.FloatBallService", "updateBallVisibilityByPosition keyboard not show and ignore");
      AppMethodBeat.o(184579);
      return false;
    }
    boolean bool = a(this.sNb, this.vkz, false, false, paramAnimatorListenerAdapter);
    AppMethodBeat.o(184579);
    return bool;
  }
  
  public final boolean cXG()
  {
    return this.vkt;
  }
  
  public final boolean cXH()
  {
    AppMethodBeat.i(288517);
    if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(this.viG))
    {
      Iterator localIterator = this.viG.iterator();
      while (localIterator.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)localIterator.next();
        if ((!localBallInfo.trn) && ((com.tencent.mm.plugin.ball.f.d.H(localBallInfo)) || (com.tencent.mm.plugin.ball.f.d.I(localBallInfo))))
        {
          AppMethodBeat.o(288517);
          return true;
        }
      }
    }
    AppMethodBeat.o(288517);
    return false;
  }
  
  public final boolean cXI()
  {
    return this.vkv;
  }
  
  public final long cXJ()
  {
    return this.vky;
  }
  
  public final void cXK()
  {
    AppMethodBeat.i(106109);
    mo(false);
    mt(false);
    if (this.vkC != null)
    {
      Log.i("MicroMsg.FloatBallService", "fixFloatBallIfNeed, lastEnteredBallInfo:%s", new Object[] { this.vkC });
      q(h(this.vkC));
      AppMethodBeat.o(106109);
      return;
    }
    Log.i("MicroMsg.FloatBallService", "fixFloatBallIfNeed, safe");
    AppMethodBeat.o(106109);
  }
  
  public final void cXL()
  {
    AppMethodBeat.i(106111);
    PlaySound.play(MMApplicationContext.getContext(), a.h.webview_minimize_sound_path);
    AppMethodBeat.o(106111);
  }
  
  public final List<BallInfo> cXM()
  {
    return this.viG;
  }
  
  public final List<BallInfo> cXN()
  {
    return this.vkl;
  }
  
  public final Set<g> cXO()
  {
    return this.vkn;
  }
  
  public final boolean cXP()
  {
    AppMethodBeat.i(288638);
    Object localObject = com.tencent.mm.plugin.ball.ui.d.cYZ();
    if (((com.tencent.mm.plugin.ball.ui.d)localObject).cZa())
    {
      localObject = ((com.tencent.mm.plugin.ball.ui.d)localObject).vlA;
      if (((com.tencent.mm.plugin.ball.ui.a)localObject).vla != null)
      {
        bool = ((com.tencent.mm.plugin.ball.ui.a)localObject).vla.vpe;
        AppMethodBeat.o(288638);
        return bool;
      }
      AppMethodBeat.o(288638);
      return false;
    }
    d.cYL();
    boolean bool = d.cYO();
    AppMethodBeat.o(288638);
    return bool;
  }
  
  public final void cXQ()
  {
    this.vkB = null;
  }
  
  public final boolean cXR()
  {
    return this.vku;
  }
  
  public final void cXS()
  {
    AppMethodBeat.i(184565);
    com.tencent.mm.plugin.ball.ui.d locald = com.tencent.mm.plugin.ball.ui.d.cYZ();
    if (locald.cZa()) {
      locald.vlA.cXS();
    }
    AppMethodBeat.o(184565);
  }
  
  public final void cXT()
  {
    AppMethodBeat.i(184566);
    com.tencent.mm.plugin.ball.ui.d locald = com.tencent.mm.plugin.ball.ui.d.cYZ();
    if (locald.cZa()) {
      locald.vlA.cXT();
    }
    AppMethodBeat.o(184566);
  }
  
  public final void cXU()
  {
    AppMethodBeat.i(288560);
    Log.d("MicroMsg.FloatBallService", "clearMessageBallInfo readyMessageBallInfo: %s", new Object[] { this.vkr });
    cYK();
    AppMethodBeat.o(288560);
  }
  
  public final void ex(View paramView)
  {
    this.vkB = paramView;
  }
  
  public final Point getBallPosition()
  {
    AppMethodBeat.i(106121);
    Object localObject1 = com.tencent.mm.plugin.ball.ui.d.cYZ();
    if (((com.tencent.mm.plugin.ball.ui.d)localObject1).cZa())
    {
      localObject1 = ((com.tencent.mm.plugin.ball.ui.d)localObject1).vlA;
      if (((com.tencent.mm.plugin.ball.ui.a)localObject1).vla != null) {
        localObject1 = ((com.tencent.mm.plugin.ball.ui.a)localObject1).vla.getBallPosition();
      }
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new Point(com.tencent.mm.plugin.ball.f.d.cZh(), com.tencent.mm.plugin.ball.f.d.cZi());
      }
      Log.i("MicroMsg.FloatBallService", "getBallPosition, position:[%s, %s]", new Object[] { Integer.valueOf(((Point)localObject2).x), Integer.valueOf(((Point)localObject2).y) });
      AppMethodBeat.o(106121);
      return localObject2;
      localObject1 = new Point(com.tencent.mm.plugin.ball.f.d.cZh(), com.tencent.mm.plugin.ball.f.d.cZi());
      continue;
      localObject1 = new Point(com.tencent.mm.plugin.ball.f.d.cZh(), com.tencent.mm.plugin.ball.f.d.cZi());
    }
  }
  
  public final BallInfo h(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106113);
    synchronized (this.viG)
    {
      if (this.viG.contains(paramBallInfo))
      {
        int i = this.viG.indexOf(paramBallInfo);
        if ((i < 0) || (i >= this.viG.size()))
        {
          AppMethodBeat.o(106113);
          return null;
        }
        try
        {
          paramBallInfo = (BallInfo)this.viG.get(i);
          Log.i("MicroMsg.FloatBallService", "getBallInfo, existed:true, responseBallInfo:%s", new Object[] { paramBallInfo });
          AppMethodBeat.o(106113);
          return paramBallInfo;
        }
        catch (Exception paramBallInfo)
        {
          Log.printErrStackTrace("MicroMsg.FloatBallService", paramBallInfo, "getBallInfo exception", new Object[0]);
          AppMethodBeat.o(106113);
          return null;
        }
      }
      Log.i("MicroMsg.FloatBallService", "getBallInfo, existed:false");
      AppMethodBeat.o(106113);
      return null;
    }
  }
  
  public final boolean i(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106114);
    if (cYn() >= 5)
    {
      Log.i("MicroMsg.FloatBallService", "canAddBallInfo, false");
      AppMethodBeat.o(106114);
      return false;
    }
    Log.i("MicroMsg.FloatBallService", "canAddBallInfo, true");
    AppMethodBeat.o(106114);
    return true;
  }
  
  public final void j(final BallInfo paramBallInfo)
  {
    int j = 0;
    AppMethodBeat.i(106116);
    if ((paramBallInfo.type == 6) && (paramBallInfo.vjI.vjN == 11)) {}
    for (int i = 1; (i != 0) && (!com.tencent.mm.compatible.e.b.dh(MMApplicationContext.getContext())); i = 0)
    {
      Log.i("MicroMsg.FloatBallService", "isAskForPermissionAlready, no permission & no ask for");
      AppMethodBeat.o(106116);
      return;
    }
    i = paramBallInfo.type;
    if (i == 7)
    {
      Log.i("MicroMsg.FloatBallService", "shouldCheckPermissionWhenAddBallInfo, ignore for ballType: location");
      i = j;
    }
    while (i != 0)
    {
      com.tencent.mm.plugin.ball.f.c.a(MMApplicationContext.getContext(), paramBallInfo.type, true, new c.a()
      {
        public final void onCheckResult(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(288387);
          if (paramAnonymousBoolean)
          {
            c.a(c.this, paramBallInfo);
            AppMethodBeat.o(288387);
            return;
          }
          Log.w("MicroMsg.FloatBallService", "no float window permission");
          AppMethodBeat.o(288387);
        }
      });
      AppMethodBeat.o(106116);
      return;
      if (i == 17)
      {
        Log.i("MicroMsg.FloatBallService", "shouldCheckPermissionWhenAddBallInfo, ignore for ballType: appbrand_voip");
        i = j;
      }
      else if (i == 18)
      {
        Log.i("MicroMsg.FloatBallService", "shouldCheckPermissionWhenAddBallInfo, ignore for ballType: audio_of_video_background_play");
        i = j;
      }
      else if (i == 33)
      {
        Log.i("MicroMsg.FloatBallService", "shouldCheckPermissionWhenAddBallInfo, ignore for ballType: appbrand bluetooth");
        i = j;
      }
      else
      {
        i = 1;
      }
    }
    z(paramBallInfo);
    AppMethodBeat.o(106116);
  }
  
  public final void k(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106118);
    BallInfo localBallInfo = h(paramBallInfo);
    if (localBallInfo != null)
    {
      localBallInfo.w(paramBallInfo);
      Log.i("MicroMsg.FloatBallService", "updateBallInfo, existed:true, ballInfo:%s", new Object[] { localBallInfo });
      cYI();
      AppMethodBeat.o(106118);
      return;
    }
    Log.i("MicroMsg.FloatBallService", "updateBallInfo, existed:false");
    AppMethodBeat.o(106118);
  }
  
  public final void kc(long paramLong)
  {
    this.vky = paramLong;
  }
  
  public final void l(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106119);
    if (this.viG.contains(paramBallInfo))
    {
      if (com.tencent.mm.plugin.ball.f.d.H(paramBallInfo))
      {
        com.tencent.mm.plugin.ball.ui.d.cYZ().cYU();
        paramBallInfo.dyK = null;
      }
      this.viG.remove(paramBallInfo);
      d.cYL().l(paramBallInfo);
      a.b(paramBallInfo, this.viG.isEmpty());
      Log.i("MicroMsg.FloatBallService", "removeBallInfo, existed:true, ballInfo:%s", new Object[] { paramBallInfo });
      if ((this.vkC != null) && (this.vkC.equals(paramBallInfo)))
      {
        Log.i("MicroMsg.FloatBallService", "removeBallInfo, remove last enteredBallInfo");
        this.vkC = null;
      }
      C(paramBallInfo);
      mu(true);
      b(paramBallInfo, 3);
      E(paramBallInfo);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).del(paramBallInfo.key);
      if (paramBallInfo.equals(this.vkq))
      {
        this.vkq = null;
        AppMethodBeat.o(106119);
      }
    }
    else
    {
      Log.i("MicroMsg.FloatBallService", "removeBallInfo, existed:false");
    }
    AppMethodBeat.o(106119);
  }
  
  public final void m(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106124);
    int i = paramBallInfo.vjI.opType;
    if ((i == 1) || (i == 2) || (i == 3)) {}
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        Log.w("MicroMsg.FloatBallReportLogic", "activeBallTypeReport unexpected opType:%d", new Object[] { Integer.valueOf(paramBallInfo.vjI.opType) });
        paramBallInfo.vjI.opType = 3;
      }
      a.a(paramBallInfo, Util.nowMilliSecond() - paramBallInfo.vjF, 0L, 0L, 0L);
      c(paramBallInfo, true);
      int j = paramBallInfo.type;
      i = j;
      if (j == 20) {
        i = paramBallInfo.cIh;
      }
      Log.d("MicroMsg.FloatBallService", "alvinluo notifySingleBallInfoClicked type: %d, contentType: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramBallInfo.cIh) });
      localObject = (Set)this.vko.get(i);
      if (!com.tencent.mm.plugin.ball.f.d.checkListNotEmpty((Collection)localObject)) {
        break;
      }
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.plugin.ball.c.e)((Iterator)localObject).next()).b(paramBallInfo);
      }
    }
    Object localObject = (Set)this.vko.get(0);
    if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty((Collection)localObject))
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.plugin.ball.c.e)((Iterator)localObject).next()).b(paramBallInfo);
      }
    }
    AppMethodBeat.o(106124);
  }
  
  public final void mi(boolean paramBoolean)
  {
    AppMethodBeat.i(106101);
    a(paramBoolean, null);
    AppMethodBeat.o(106101);
  }
  
  public final void mj(boolean paramBoolean)
  {
    AppMethodBeat.i(106102);
    a(paramBoolean, true, null);
    AppMethodBeat.o(106102);
  }
  
  public final void mk(boolean paramBoolean)
  {
    AppMethodBeat.i(106103);
    mt(true);
    a(paramBoolean, null);
    AppMethodBeat.o(106103);
  }
  
  public final void ml(boolean paramBoolean)
  {
    AppMethodBeat.i(106104);
    mt(false);
    a(paramBoolean, true, null);
    AppMethodBeat.o(106104);
  }
  
  public final void mm(boolean paramBoolean)
  {
    AppMethodBeat.i(288511);
    com.tencent.mm.plugin.ball.ui.d.cYZ().c(paramBoolean, new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(288375);
        super.onAnimationEnd(paramAnonymousAnimator);
        c.this.a(null, 1.0F);
        AppMethodBeat.o(288375);
      }
    });
    AppMethodBeat.o(288511);
  }
  
  public final void mn(boolean paramBoolean)
  {
    AppMethodBeat.i(176960);
    Log.i("MicroMsg.FloatBallService", "markWechatInForeground, foreground:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.vkx = paramBoolean;
    if (this.vkv)
    {
      Log.i("MicroMsg.FloatBallService", "markWechatInForeground, has marked QB file view page, mark Wechat in foreground");
      com.tencent.mm.plugin.ball.ui.d.cYZ().mn(true);
    }
    for (;;)
    {
      if (!this.vkx) {
        cYK();
      }
      AppMethodBeat.o(176960);
      return;
      com.tencent.mm.plugin.ball.ui.d.cYZ().mn(paramBoolean);
    }
  }
  
  public final void mo(boolean paramBoolean)
  {
    AppMethodBeat.i(106108);
    Log.i("MicroMsg.FloatBallService", "markQBFileViewPage:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.vkv = paramBoolean;
    AppMethodBeat.o(106108);
  }
  
  public final void mp(boolean paramBoolean)
  {
    AppMethodBeat.i(184564);
    com.tencent.mm.plugin.ball.ui.d locald = com.tencent.mm.plugin.ball.ui.d.cYZ();
    if (locald.cZa()) {
      locald.vlA.vld = paramBoolean;
    }
    AppMethodBeat.o(184564);
  }
  
  public final void mq(boolean paramBoolean)
  {
    AppMethodBeat.i(185124);
    Log.i("MicroMsg.FloatBallService", "markForceHideAllFloatBall %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.vku = paramBoolean;
    com.tencent.mm.plugin.ball.ui.d.cYZ().vku = paramBoolean;
    AppMethodBeat.o(185124);
  }
  
  public final void n(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106120);
    if (this.viG.contains(paramBallInfo))
    {
      Object localObject = (Set)this.vko.get(paramBallInfo.type);
      if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty((Collection)localObject))
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((com.tencent.mm.plugin.ball.c.e)((Iterator)localObject).next()).d(paramBallInfo);
        }
      }
      localObject = (Set)this.vko.get(0);
      if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty((Collection)localObject))
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((com.tencent.mm.plugin.ball.c.e)((Iterator)localObject).next()).d(paramBallInfo);
        }
      }
      AppMethodBeat.o(106120);
      return;
    }
    Log.i("MicroMsg.FloatBallService", "exposeBallInfo, existed:false");
    AppMethodBeat.o(106120);
  }
  
  public final void o(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(369820);
    c(paramBallInfo, true);
    AppMethodBeat.o(369820);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(106106);
    Log.i("MicroMsg.FloatBallService", "onAccountRelease:%s", new Object[] { Integer.valueOf(hashCode()) });
    b(com.tencent.mm.plugin.ball.ui.d.cYZ());
    b(d.cYL());
    this.vks = false;
    com.tencent.mm.plugin.ball.ui.d.cYZ().cZb();
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
    if (this.vkC != null)
    {
      localObject = this.vkC.cYc();
      Log.i("MicroMsg.FloatBallService", "onExitBallInfoPage, lastEnteredBallInfo:%s", new Object[] { localObject });
      this.vkC = null;
      localObject = h(paramBallInfo);
      if (localObject == null) {
        break label154;
      }
      Log.i("MicroMsg.FloatBallService", "onExitBallInfoPage, ballInfo:%s", new Object[] { localObject });
      if (((BallInfo)localObject).vjI.opType != -1) {
        break label139;
      }
      ((BallInfo)localObject).vjI.opType = 0;
      label87:
      if (com.tencent.mm.plugin.ball.ui.d.cYZ().cYV()) {
        break label146;
      }
      if (!this.vku) {
        a(paramBallInfo, 1.0F);
      }
    }
    for (;;)
    {
      if (!((BallInfo)localObject).trn) {
        break label167;
      }
      ((BallInfo)localObject).trn = false;
      cYI();
      AppMethodBeat.o(106128);
      return;
      localObject = "null";
      break;
      label139:
      a.y((BallInfo)localObject);
      break label87;
      label146:
      A(paramBallInfo);
    }
    label154:
    Log.i("MicroMsg.FloatBallService", "onExitBallInfoPage, no this ball info");
    A(paramBallInfo);
    label167:
    AppMethodBeat.o(106128);
  }
  
  public final void r(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(288597);
    if (paramBallInfo != null) {
      a.a(paramBallInfo, this.viG);
    }
    AppMethodBeat.o(288597);
  }
  
  public final void s(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106135);
    String str;
    if (paramBallInfo != null)
    {
      str = paramBallInfo.cYc();
      paramBallInfo = (ResultReceiver)this.vkp.remove(str);
      if (paramBallInfo == null) {
        break label68;
      }
    }
    label68:
    for (paramBallInfo = Integer.valueOf(paramBallInfo.hashCode());; paramBallInfo = null)
    {
      Log.i("MicroMsg.FloatBallService", "removeFloatBallEventReceiver, key:%s, receiver:%s", new Object[] { str, paramBallInfo });
      AppMethodBeat.o(106135);
      return;
    }
  }
  
  public final void setEnableClick(boolean paramBoolean)
  {
    AppMethodBeat.i(288483);
    Object localObject = com.tencent.mm.plugin.ball.ui.d.cYZ();
    if (((com.tencent.mm.plugin.ball.ui.d)localObject).cZa())
    {
      localObject = ((com.tencent.mm.plugin.ball.ui.d)localObject).vlA;
      if (((com.tencent.mm.plugin.ball.ui.a)localObject).vla != null) {
        ((com.tencent.mm.plugin.ball.ui.a)localObject).vla.setEnableClick(paramBoolean);
      }
    }
    AppMethodBeat.o(288483);
  }
  
  public final void t(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(288558);
    if (paramBallInfo == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.FloatBallService", "alvinluo markMessageBallInfo ballInfo == null: %b, %s, readyInfo == null: %b", new Object[] { Boolean.valueOf(bool), paramBallInfo, this.vkr });
      if (paramBallInfo != null)
      {
        if (this.vkr == null) {
          this.vkr = new BallInfo(20, paramBallInfo.key);
        }
        this.vkr.w(paramBallInfo);
        this.vkr.key = paramBallInfo.key;
        this.vkr.type = 20;
        this.vkr.state = 256;
        this.vkr.trn = false;
        this.vkr.vjH = false;
        this.vkr.egK = System.currentTimeMillis();
        if ((paramBallInfo.type == 4) && (this.vkr.oSS != null))
        {
          paramBallInfo = this.vkr.oSS.getString("processName");
          if (!Util.isNullOrNil(paramBallInfo))
          {
            Log.d("MicroMsg.FloatBallService", "markMessageBallInfo reset processName: %s", new Object[] { paramBallInfo });
            this.vkr.oSS.putString("processName", "");
          }
        }
      }
      AppMethodBeat.o(288558);
      return;
    }
  }
  
  public final void u(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(288509);
    BallInfo localBallInfo = cYD();
    Point localPoint1;
    Point localPoint2;
    label263:
    int j;
    if (localBallInfo != null)
    {
      localBallInfo.state = paramBallInfo.state;
      localBallInfo.vjJ = paramBallInfo.vjJ;
      paramBallInfo = com.tencent.mm.plugin.ball.ui.d.cYZ().vlA;
      if (paramBallInfo.vla != null)
      {
        paramBallInfo = paramBallInfo.vla;
        Log.i("MicroMsg.FloatBallView", "alvinluo switchVoipVoice");
        if (localBallInfo.vjJ == null)
        {
          Log.w("MicroMsg.FloatBallView", "switchVoip animationInfo invalid and ignore");
          AppMethodBeat.o(288509);
          return;
        }
        localPoint1 = new Point(localBallInfo.vjJ.vjL);
        if (paramBallInfo.Gc(paramBallInfo.vnu))
        {
          boolean bool1 = FloatBallView.Gi(paramBallInfo.vnu);
          boolean bool2 = FloatBallView.Gl(paramBallInfo.vnu);
          localPoint1.x = paramBallInfo.g(bool1, bool2, true);
          localPoint1.y = paramBallInfo.a(paramBallInfo.vnu, bool1, bool2, true);
        }
        localPoint2 = new Point(localBallInfo.vjJ.vjM);
        if (paramBallInfo.Gc(paramBallInfo.vnu))
        {
          if (localBallInfo.state != 8) {
            break label263;
          }
          localPoint2.x = (FloatBallView.vnZ + FloatBallView.vol * 2);
          localPoint2.y = (FloatBallView.voa + FloatBallView.vol * 2);
        }
        while ((!FloatBallView.i(localPoint1)) || (!FloatBallView.i(localPoint2)))
        {
          Log.w("MicroMsg.FloatBallView", "switchVoip animationInfo size invalid and ignore");
          AppMethodBeat.o(288509);
          return;
          if (localBallInfo.state == 512)
          {
            i = FloatBallView.vnV + FloatBallView.vol * 2;
            if (localPoint2.x < i) {
              localPoint2.x = i;
            }
          }
        }
        paramBallInfo.vpt = 80;
        j = paramBallInfo.vpt;
        if (!paramBallInfo.vpe) {
          break label481;
        }
      }
    }
    label481:
    for (int i = 8388611;; i = 8388613)
    {
      paramBallInfo.an(i | j, true);
      FrameLayout localFrameLayout = paramBallInfo.vov;
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localFrameLayout.getLayoutParams();
      Log.i("MicroMsg.FloatBallView", "alvinluo animateVoipSwitch state: %d, startSize: %s, endSize: %s, current: %d, %d", new Object[] { Integer.valueOf(localBallInfo.state), localPoint1, localPoint2, Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator.setDuration(300L);
      localValueAnimator.addListener(new FloatBallView.8(paramBallInfo, localBallInfo, localPoint1, localPoint2));
      localValueAnimator.addUpdateListener(new FloatBallView.9(paramBallInfo, localLayoutParams, localPoint1, localPoint2, localFrameLayout));
      localValueAnimator.start();
      AppMethodBeat.o(288509);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.c
 * JD-Core Version:    0.7.0.1
 */