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
import com.tencent.mm.kernel.h;
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
import com.tencent.mm.plugin.ball.view.FloatBallView.6;
import com.tencent.mm.plugin.ball.view.FloatBallView.7;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
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
  private static c rYU;
  volatile int displayHeight;
  private volatile int pIk;
  final List<BallInfo> rXp;
  private final List<BallInfo> rYV;
  private Set<com.tencent.mm.plugin.ball.c.d> rYW;
  private Set<g> rYX;
  private SparseArray<Set<com.tencent.mm.plugin.ball.c.e>> rYY;
  private Map<String, ResultReceiver> rYZ;
  private volatile BallInfo rZa;
  private volatile BallInfo rZb;
  private volatile boolean rZc;
  volatile boolean rZd;
  volatile boolean rZe;
  volatile boolean rZf;
  private volatile boolean rZg;
  private volatile boolean rZh;
  private volatile long rZi;
  private volatile int rZj;
  private volatile boolean rZk;
  private View rZl;
  private volatile BallInfo rZm;
  private int rZn;
  
  private c()
  {
    AppMethodBeat.i(106097);
    this.rXp = new CopyOnWriteArrayList();
    this.rYV = new CopyOnWriteArrayList();
    this.rYW = new CopyOnWriteArraySet();
    this.rYX = new CopyOnWriteArraySet();
    this.rYY = new SparseArray();
    this.rYZ = new ConcurrentHashMap();
    this.rZa = null;
    this.rZb = null;
    this.rZc = false;
    this.rZd = false;
    this.rZe = false;
    this.rZf = false;
    this.rZg = false;
    this.rZh = true;
    this.rZi = 0L;
    this.pIk = 0;
    this.rZj = 0;
    this.displayHeight = 0;
    this.rZk = false;
    this.rZm = null;
    this.rZn = -1;
    AppMethodBeat.o(106097);
  }
  
  private void A(final BallInfo paramBallInfo)
  {
    AppMethodBeat.i(188740);
    com.tencent.mm.plugin.ball.ui.d.cwp().c(true, new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(186732);
        super.onAnimationEnd(paramAnonymousAnimator);
        if (!c.c(c.this)) {
          c.this.a(paramBallInfo, 1.0F);
        }
        AppMethodBeat.o(186732);
      }
    });
    AppMethodBeat.o(188740);
  }
  
  private void B(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(188752);
    Log.d("MicroMsg.FloatBallService", "onFloatBallAdded %s", new Object[] { paramBallInfo });
    com.tencent.mm.plugin.ball.ui.d.cwp().a(this.rXp.size(), paramBallInfo);
    AppMethodBeat.o(188752);
  }
  
  private void C(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(188753);
    com.tencent.mm.plugin.ball.ui.d.cwp().b(this.rXp.size(), paramBallInfo);
    AppMethodBeat.o(188753);
  }
  
  private void D(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(188755);
    int j = this.rYY.size();
    int i = 0;
    while (i < j)
    {
      int k = this.rYY.keyAt(i);
      Object localObject = (Set)this.rYY.get(k);
      if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty((Collection)localObject))
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((com.tencent.mm.plugin.ball.c.e)((Iterator)localObject).next()).g(paramBallInfo);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(188755);
  }
  
  private void E(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106133);
    Object localObject = (Set)this.rYY.get(paramBallInfo.type);
    if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty((Collection)localObject))
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.plugin.ball.c.e)((Iterator)localObject).next()).c(paramBallInfo);
      }
    }
    localObject = (Set)this.rYY.get(0);
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
    AppMethodBeat.i(188776);
    paramBallInfo = h(paramBallInfo);
    if ((paramBallInfo != null) && (paramBallInfo.rYr))
    {
      Log.i("MicroMsg.FloatBallService", "removeAppBrandPassiveBallInfo, remove existedBallInfo:%s", new Object[] { paramBallInfo });
      paramBallInfo.rYs.opType = 10;
      l(paramBallInfo);
    }
    AppMethodBeat.o(188776);
  }
  
  private void X(Bundle paramBundle)
  {
    AppMethodBeat.i(188758);
    Iterator localIterator = this.rYZ.values().iterator();
    while (localIterator.hasNext()) {
      ((ResultReceiver)localIterator.next()).send(1, paramBundle);
    }
    AppMethodBeat.o(188758);
  }
  
  private boolean a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184580);
    boolean bool = cuX();
    Log.i("MicroMsg.FloatBallService", "updateBallVisibilityByKbHeight needShowFloatBall: %b", new Object[] { Boolean.valueOf(bool) });
    if ((bool) && (!this.rZk) && (this.rZg))
    {
      this.rZg = false;
      if ((this.rZl != null) && (this.rZl.getVisibility() != 0))
      {
        Log.d("MicroMsg.FloatBallService", "alvinluo updateBallVisibilityByKbHeight has voip but not visible and delay show animation");
        this.rZl.setVisibility(0);
        this.rZl.setAlpha(0.0F);
        a(true, false, paramAnimatorListenerAdapter);
        AppMethodBeat.o(184580);
        return true;
      }
      Log.d("MicroMsg.FloatBallService", "alvinluo updateBallVisibilityByKbHeight has voip and visible, not need to show");
      AppMethodBeat.o(184580);
      return false;
    }
    int j = cwa();
    int k = com.tencent.mm.plugin.ball.ui.d.cwp().getPositionY();
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
      this.rZg = true;
      a(true, paramAnimatorListenerAdapter);
      AppMethodBeat.o(184580);
      return true;
      i = 0;
      break;
    }
    label290:
    if (this.rZg)
    {
      this.rZg = false;
      a(true, true, paramAnimatorListenerAdapter);
      AppMethodBeat.o(184580);
      return true;
    }
    AppMethodBeat.o(184580);
    return false;
  }
  
  private void b(BallInfo paramBallInfo, int paramInt)
  {
    AppMethodBeat.i(106136);
    paramBallInfo = paramBallInfo.cvr();
    ResultReceiver localResultReceiver = (ResultReceiver)this.rYZ.get(paramBallInfo);
    if (localResultReceiver != null)
    {
      Log.i("MicroMsg.FloatBallService", "notifyResultReceiver, event:%s, ballInfoHashKey:%s, receiver:%s", new Object[] { Integer.valueOf(paramInt), paramBallInfo, Integer.valueOf(localResultReceiver.hashCode()) });
      localResultReceiver.send(paramInt, new Bundle());
    }
    AppMethodBeat.o(106136);
  }
  
  private static void bX(List<BallInfo> paramList)
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
      if ((localBallInfo != null) && (localBallInfo.type == 4) && (localBallInfo.mab != null))
      {
        String str = localBallInfo.mab.getString("processName");
        if (!Util.isNullOrNil(str))
        {
          Log.i("MicroMsg.FloatBallService", "restore with process name: %s", new Object[] { str });
          localBallInfo.mab.putString("processName", "");
        }
      }
    }
    AppMethodBeat.o(184573);
  }
  
  private void bY(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106137);
    if (!this.rYZ.isEmpty())
    {
      int i = com.tencent.mm.plugin.ball.f.d.cc(paramList).size();
      if (this.rZn != i)
      {
        this.rZn = i;
        paramList = new Bundle();
        paramList.putInt("ActiveCount", i);
        Iterator localIterator = this.rYZ.values().iterator();
        while (localIterator.hasNext()) {
          ((ResultReceiver)localIterator.next()).send(5, paramList);
        }
      }
    }
    AppMethodBeat.o(106137);
  }
  
  private int cvC()
  {
    AppMethodBeat.i(106115);
    List localList = com.tencent.mm.plugin.ball.f.d.cc(this.rXp);
    if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(localList))
    {
      int i = localList.size();
      AppMethodBeat.o(106115);
      return i;
    }
    AppMethodBeat.o(106115);
    return 0;
  }
  
  /* Error */
  public static c cvT()
  {
    // Byte code:
    //   0: ldc_w 399
    //   3: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 401	com/tencent/mm/plugin/ball/service/c:rYU	Lcom/tencent/mm/plugin/ball/service/c;
    //   12: ifnonnull +19 -> 31
    //   15: ldc 2
    //   17: monitorenter
    //   18: new 2	com/tencent/mm/plugin/ball/service/c
    //   21: dup
    //   22: invokespecial 402	com/tencent/mm/plugin/ball/service/c:<init>	()V
    //   25: putstatic 401	com/tencent/mm/plugin/ball/service/c:rYU	Lcom/tencent/mm/plugin/ball/service/c;
    //   28: ldc 2
    //   30: monitorexit
    //   31: ldc 2
    //   33: monitorexit
    //   34: getstatic 401	com/tencent/mm/plugin/ball/service/c:rYU	Lcom/tencent/mm/plugin/ball/service/c;
    //   37: astore_0
    //   38: ldc_w 399
    //   41: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aload_0
    //   45: areturn
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: ldc_w 399
    //   53: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aload_0
    //   57: athrow
    //   58: astore_0
    //   59: ldc 2
    //   61: monitorexit
    //   62: ldc_w 399
    //   65: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private BallInfo cvU()
  {
    AppMethodBeat.i(188624);
    if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(this.rXp))
    {
      Iterator localIterator = this.rXp.iterator();
      while (localIterator.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)localIterator.next();
        if (com.tencent.mm.plugin.ball.f.d.H(localBallInfo))
        {
          AppMethodBeat.o(188624);
          return localBallInfo;
        }
      }
    }
    AppMethodBeat.o(188624);
    return null;
  }
  
  private void cvV()
  {
    AppMethodBeat.i(184571);
    BallInfo localBallInfo;
    if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(this.rXp))
    {
      Iterator localIterator = this.rXp.iterator();
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
  
  private void cvW()
  {
    AppMethodBeat.i(184572);
    if (h.aHB())
    {
      d.cwb();
      List localList1 = d.cwf();
      bX(localList1);
      this.rXp.clear();
      if (ar.isMultiTaskMode())
      {
        List localList2 = com.tencent.mm.plugin.ball.f.d.cd(localList1);
        this.rXp.addAll(localList2);
      }
      for (;;)
      {
        localList1 = com.tencent.mm.plugin.ball.f.d.cc(localList1);
        this.rYV.clear();
        this.rYV.addAll(localList1);
        this.rZc = true;
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
        this.rXp.addAll(localList1);
      }
    }
    Log.i("MicroMsg.FloatBallService", "restoreDataFromStorage, account not ready");
    AppMethodBeat.o(184572);
  }
  
  private boolean cvX()
  {
    AppMethodBeat.i(184574);
    BallInfo localBallInfo = h(this.rZm);
    if ((localBallInfo != null) && (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(this.rXp)))
    {
      boolean bool = com.tencent.mm.plugin.ball.f.d.f(this.rXp, localBallInfo);
      AppMethodBeat.o(184574);
      return bool;
    }
    AppMethodBeat.o(184574);
    return false;
  }
  
  public static void cvY()
  {
    AppMethodBeat.i(106123);
    com.tencent.mm.plugin.ball.ui.d.cwp().a(false, null);
    AppMethodBeat.o(106123);
  }
  
  private void cvZ()
  {
    AppMethodBeat.i(106140);
    List localList = com.tencent.mm.plugin.ball.f.d.bZ(new Vector(this.rXp));
    Log.i("MicroMsg.FloatBallService", "notifyFloatBallInfoChanged, originSize: %d, sortedSize: %d, ballInfoList:%s", new Object[] { Integer.valueOf(this.rXp.size()), Integer.valueOf(localList.size()), localList });
    Iterator localIterator = this.rYW.iterator();
    while (localIterator.hasNext())
    {
      ((com.tencent.mm.plugin.ball.c.d)localIterator.next()).a(localList, this.rZm);
      bY(localList);
    }
    AppMethodBeat.o(106140);
  }
  
  private int cwa()
  {
    AppMethodBeat.i(184581);
    int j = com.tencent.mm.plugin.ball.f.e.saL + com.tencent.mm.plugin.ball.f.e.saM + com.tencent.mm.plugin.ball.f.e.saN;
    int i = j;
    if (this.rZl != null) {
      i = Math.max(this.rZl.getMeasuredHeight(), j);
    }
    AppMethodBeat.o(184581);
    return i;
  }
  
  private void lg(boolean paramBoolean)
  {
    AppMethodBeat.i(106107);
    Log.i("MicroMsg.FloatBallService", "markNoFloatBallPage:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.rZd = paramBoolean;
    AppMethodBeat.o(106107);
  }
  
  private void lh(boolean paramBoolean)
  {
    AppMethodBeat.i(106129);
    Object localObject = h(this.rZm);
    if ((localObject != null) && (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(this.rXp)))
    {
      if (com.tencent.mm.plugin.ball.f.d.e(this.rXp, (BallInfo)localObject))
      {
        Log.i("MicroMsg.FloatBallService", "recheckBallInfoList, has other balls, hidden current ball info");
        boolean bool = com.tencent.mm.plugin.ball.ui.d.cwp().cwl();
        Log.i("MicroMsg.FloatBallService", "recheckBallInfoList, canNotShowFloatBall:%s, withFloatBall:%s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
        if ((!bool) && (paramBoolean)) {
          a((BallInfo)localObject, 1.0F);
        }
        Iterator localIterator = this.rXp.iterator();
        while (localIterator.hasNext())
        {
          BallInfo localBallInfo = (BallInfo)localIterator.next();
          if ((!localBallInfo.rYr) && (localBallInfo.qmt) && (!localBallInfo.equals(localObject)))
          {
            localBallInfo.qmt = false;
            b(localBallInfo, 4);
          }
          else if (localBallInfo.equals(localObject))
          {
            localBallInfo.qmt = true;
          }
        }
      }
      if (com.tencent.mm.plugin.ball.f.d.f(this.rXp, (BallInfo)localObject))
      {
        Log.i("MicroMsg.FloatBallService", "recheckBallInfoList, no other balls, make float ball transparent");
        ((BallInfo)localObject).qmt = false;
        a((BallInfo)localObject, 0.0F);
      }
      cvZ();
      AppMethodBeat.o(106129);
      return;
    }
    if (this.rZm != null) {}
    for (localObject = this.rZm.cvr();; localObject = "null")
    {
      Log.i("MicroMsg.FloatBallService", "recheckBallInfoList, last enteredBallInfo:%s", new Object[] { localObject });
      break;
    }
  }
  
  private void z(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106117);
    if ((!paramBallInfo.rYr) && (cvC() >= 5))
    {
      Log.i("MicroMsg.FloatBallService", "addBallInfo, already add max count balls:%s", new Object[] { Integer.valueOf(5) });
      FloatBallProxyUI.a(1, new FloatBallProxyUI.a()
      {
        public final void ft(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(186264);
          Log.i("MicroMsg.FloatBallService", "addBallInfo, show reach count limit callback:%s, proxyMode: %d", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1) });
          if (paramAnonymousInt2 == 1)
          {
            Log.i("MicroMsg.FloatBallService", "addBallInfo, show float menu view");
            c.cvY();
          }
          AppMethodBeat.o(186264);
        }
      });
      AppMethodBeat.o(106117);
      return;
    }
    if (!this.rXp.contains(paramBallInfo))
    {
      if ((com.tencent.mm.plugin.ball.f.d.H(paramBallInfo)) && (com.tencent.mm.plugin.ball.f.d.cj(this.rXp)))
      {
        Log.e("MicroMsg.FloatBallService", "addBallInfo video ball is already exist and can not add more");
        AppMethodBeat.o(106117);
        return;
      }
      long l = Util.nowMilliSecond();
      paramBallInfo.rYp = l;
      paramBallInfo.createTime = l;
      paramBallInfo.rYs.opType = -1;
      Object localObject;
      int i;
      if (paramBallInfo.type != 20)
      {
        localObject = paramBallInfo.rYs;
        if ((paramBallInfo.rYr) && (paramBallInfo.rYs.kqY == 0)) {
          i = 3;
        }
      }
      for (((BallReportInfo)localObject).kqY = i;; paramBallInfo.rYs.kqY = 5)
      {
        this.rXp.add(paramBallInfo);
        Log.i("MicroMsg.FloatBallService", "addBallInfo, existed:false, ballInfo:%s", new Object[] { paramBallInfo });
        if (!paramBallInfo.iUF) {
          a.a(paramBallInfo, this.rXp);
        }
        B(paramBallInfo);
        lh(true);
        localObject = new Bundle();
        ((Bundle)localObject).putInt("type", paramBallInfo.type);
        ((Bundle)localObject).putString("key", paramBallInfo.key);
        X((Bundle)localObject);
        D(paramBallInfo);
        ((com.tencent.mm.plugin.handoff.a.a)h.ae(com.tencent.mm.plugin.handoff.a.a.class)).P(paramBallInfo);
        AppMethodBeat.o(106117);
        return;
        i = paramBallInfo.rYs.kqY;
        break;
      }
    }
    Log.i("MicroMsg.FloatBallService", "addBallInfo, existed:true, replaceExisted: %b, ballInfo:%s", new Object[] { Boolean.valueOf(paramBallInfo.rYq), paramBallInfo });
    if (paramBallInfo.rYq)
    {
      paramBallInfo.rYq = false;
      k(paramBallInfo);
    }
    AppMethodBeat.o(106117);
  }
  
  public final void Fd(int paramInt)
  {
    this.displayHeight = paramInt;
  }
  
  public final void Fe(int paramInt)
  {
    AppMethodBeat.i(188704);
    if ((this.rZa != null) && (this.rZa.aOl == paramInt))
    {
      Log.i("MicroMsg.FloatBallService", "alvinluo removeMessageBall type: %d", new Object[] { Integer.valueOf(paramInt) });
      l(this.rZa);
    }
    AppMethodBeat.o(188704);
  }
  
  public final void HL(long paramLong)
  {
    this.rZi = paramLong;
  }
  
  public final void a(final int paramInt1, final int paramInt2, boolean paramBoolean, long paramLong)
  {
    boolean bool = false;
    AppMethodBeat.i(184577);
    this.pIk = paramInt1;
    this.rZj = paramInt2;
    this.rZk = paramBoolean;
    if (!com.tencent.mm.plugin.ball.ui.d.cwp().cwq())
    {
      Log.i("MicroMsg.FloatBallService", "KeyboardHeightChanged, no float ball");
      AppMethodBeat.o(184577);
      return;
    }
    if (paramBoolean) {
      ld(true);
    }
    while (paramLong != 0L)
    {
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187468);
          c localc = c.this;
          int i = paramInt1;
          int j = paramInt2;
          if (c.b(c.this) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            c.a(localc, i, j, bool);
            AppMethodBeat.o(187468);
            return;
          }
        }
      }, paramLong);
      AppMethodBeat.o(184577);
      return;
      ld(false);
    }
    paramBoolean = bool;
    if (this.pIk != 0) {
      paramBoolean = true;
    }
    a(paramInt1, paramInt2, true, paramBoolean, null);
    AppMethodBeat.o(184577);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.ball.c.e parame)
  {
    AppMethodBeat.i(106131);
    Log.i("MicroMsg.FloatBallService", "addFloatBallInfoEventListener, type:%s", new Object[] { Integer.valueOf(paramInt) });
    if (parame != null)
    {
      Set localSet = (Set)this.rYY.get(paramInt);
      Object localObject = localSet;
      if (localSet == null)
      {
        localObject = new HashSet();
        this.rYY.put(paramInt, localObject);
      }
      ((Set)localObject).add(parame);
    }
    AppMethodBeat.o(106131);
  }
  
  public final void a(long paramLong, b.a parama)
  {
    int i = 1;
    AppMethodBeat.i(188701);
    if (this.rZb == null)
    {
      Log.w("MicroMsg.FloatBallService", "alvinluo addMessageBall readyMessageBallInfo is invalid");
      if (parama != null) {
        parama.Ff(7);
      }
      AppMethodBeat.o(188701);
      return;
    }
    if ((!this.rZh) && (!this.rZf))
    {
      Log.w("MicroMsg.FloatBallService", "alvinluo addMessageBall isWechatForeground: %b", new Object[] { Boolean.valueOf(this.rZh) });
      if (parama != null) {
        parama.Ff(6);
      }
      this.rZb = null;
      AppMethodBeat.o(188701);
      return;
    }
    if (!com.tencent.mm.plugin.ball.f.d.a(this.rZb, paramLong))
    {
      Log.w("MicroMsg.FloatBallService", "alvinluo addMessageBall can not add message ball because of time over limit");
      if (parama != null) {
        parama.Ff(5);
      }
      this.rZb = null;
      AppMethodBeat.o(188701);
      return;
    }
    if (this.rZa == null)
    {
      this.rZa = new BallInfo(20, this.rZb.key);
      this.rZa.w(this.rZb);
      Log.i("MicroMsg.FloatBallService", "alvinluo addMessageBall existed: false, and add: %s", new Object[] { this.rZa });
      j(this.rZa);
      this.rZb = null;
      if (parama != null) {
        parama.Ff(i);
      }
      AppMethodBeat.o(188701);
      return;
    }
    BallInfo localBallInfo = this.rZb;
    if (this.rZa == null) {
      Log.w("MicroMsg.FloatBallService", "alvinluo updateMessageBall messageBallInfo is null and ignore");
    }
    for (;;)
    {
      if ((this.rZa != null) && (!this.rZa.iUF))
      {
        this.rZa.rYs.kqY = 6;
        a.a(this.rZa, this.rXp);
      }
      i = 2;
      break;
      if (h(this.rZa) != null)
      {
        this.rZa.w(localBallInfo);
        this.rZa.key = localBallInfo.key;
        Log.i("MicroMsg.FloatBallService", "alvinluo updateMessageBall existed: true, and update %s", new Object[] { this.rZa });
        k(this.rZa);
      }
      else
      {
        Log.w("MicroMsg.FloatBallService", "alvinluo updateMessageBall messageBallInfo not null but not added!!");
      }
    }
  }
  
  public final void a(ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(188724);
    com.tencent.mm.plugin.ball.ui.d.cwp().a(true, paramResultReceiver);
    AppMethodBeat.o(188724);
  }
  
  public final void a(com.tencent.mm.plugin.ball.c.d paramd)
  {
    AppMethodBeat.i(106138);
    this.rYW.add(paramd);
    AppMethodBeat.o(106138);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(188765);
    this.rYX.add(paramg);
    com.tencent.mm.plugin.ball.ui.d locald = com.tencent.mm.plugin.ball.ui.d.cwp();
    if (locald.cwq()) {
      locald.saj.a(paramg);
    }
    AppMethodBeat.o(188765);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(106112);
    if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(this.rXp))
    {
      parami.bG(new ArrayList(this.rXp));
      AppMethodBeat.o(106112);
      return;
    }
    parami.bG(new ArrayList());
    AppMethodBeat.o(106112);
  }
  
  public final void a(BallInfo paramBallInfo, float paramFloat)
  {
    AppMethodBeat.i(106122);
    if ((paramFloat == 1.0F) || (com.tencent.mm.plugin.ball.f.d.f(this.rXp, paramBallInfo))) {
      MMHandlerThread.postToMainThread(new d.2(com.tencent.mm.plugin.ball.ui.d.cwp(), paramFloat));
    }
    AppMethodBeat.o(106122);
  }
  
  public final void a(BallInfo paramBallInfo, ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(106134);
    if ((paramBallInfo != null) && (paramResultReceiver != null))
    {
      paramBallInfo = paramBallInfo.cvr();
      Log.i("MicroMsg.FloatBallService", "registerFloatBallEventReceiver, key:%s, receiver:%s", new Object[] { paramBallInfo, Integer.valueOf(paramResultReceiver.hashCode()) });
      this.rYZ.put(paramBallInfo, paramResultReceiver);
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
        paramBallInfo.qmt = bool;
        Log.i("MicroMsg.FloatBallService", "updateBallVisibility, existed:true, visible:%s, ballInfo:%s", new Object[] { Boolean.valueOf(paramBoolean), paramBallInfo });
        cvZ();
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
    if ((paramAppBrandBackgroundRunningOperationParcel.fvK == 2) || (paramAppBrandBackgroundRunningOperationParcel.fvK == 3))
    {
      if ((paramAppBrandBackgroundRunningOperationParcel.aOm & 0x2) > 0) {
        F(new BallInfo(7, com.tencent.mm.plugin.ball.f.b.cW(paramAppBrandBackgroundRunningOperationParcel.appId, paramAppBrandBackgroundRunningOperationParcel.cBU)));
      }
      if ((paramAppBrandBackgroundRunningOperationParcel.aOm & 0x4) > 0)
      {
        paramList = paramAppBrandBackgroundRunningOperationParcel.appId;
        paramInt = paramAppBrandBackgroundRunningOperationParcel.cBU;
        F(new BallInfo(17, String.format(Locale.US, "%s#%d", new Object[] { paramList, Integer.valueOf(paramInt) })));
      }
      if ((paramAppBrandBackgroundRunningOperationParcel.aOm & 0x8) > 0) {
        F(new BallInfo(18, com.tencent.mm.plugin.ball.f.b.cV(paramAppBrandBackgroundRunningOperationParcel.appId, paramAppBrandBackgroundRunningOperationParcel.cBU)));
      }
      if ((paramAppBrandBackgroundRunningOperationParcel.aOm & 0x10) > 0) {
        F(new BallInfo(19, com.tencent.mm.plugin.ball.f.b.cV(paramAppBrandBackgroundRunningOperationParcel.appId, paramAppBrandBackgroundRunningOperationParcel.cBU)));
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
    if (this.rZf)
    {
      Log.i("MicroMsg.FloatBallService", "hideFloatBall, has marked QB file view page, ignore hiding");
      AppMethodBeat.o(184567);
      return;
    }
    if ((cuX()) && (!this.rZe)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.FloatBallService", "hideFloatBall forceHide: %b, canShowFloatBall: %b, videoBallInfo: %s", new Object[] { Boolean.valueOf(this.rZe), Boolean.valueOf(bool), cvU() });
      if (!bool) {
        break;
      }
      AppMethodBeat.o(184567);
      return;
    }
    com.tencent.mm.plugin.ball.ui.d.cwp().e(paramBoolean, paramAnimatorListenerAdapter);
    AppMethodBeat.o(184567);
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184570);
    if (!com.tencent.mm.compatible.e.b.ct(MMApplicationContext.getContext()))
    {
      Log.i("MicroMsg.FloatBallService", "resumeFloatBall, no float window permission");
      cvV();
      com.tencent.mm.plugin.ball.ui.d.cwp().cwr();
      this.rZc = false;
      this.rXp.clear();
      d.cwb().clear();
      cvZ();
      AppMethodBeat.o(184570);
      return;
    }
    if (this.rZc)
    {
      if ((this.rZd) && (!cuX()))
      {
        Log.i("MicroMsg.FloatBallService", "resumeFloatBall, has marked no float ball page, ignore resuming");
        AppMethodBeat.o(184570);
        return;
      }
      if (this.rZe)
      {
        Log.i("MicroMsg.FloatBallService", "resumeFloatBall, has marked forceHideAllFloatBall, ignore resuming");
        AppMethodBeat.o(184570);
        return;
      }
      if (this.rZg)
      {
        Log.i("MicroMsg.FloatBallService", "resumeFloatBall, hasHideForKeyboardHeightChange, ignore resuming");
        AppMethodBeat.o(184570);
        return;
      }
      if (!cvX())
      {
        Log.i("MicroMsg.FloatBallService", "resumeFloatBall not singleBallInfoCondition, withAnimation:%s", new Object[] { Boolean.valueOf(paramBoolean1) });
        com.tencent.mm.plugin.ball.ui.d.cwp().b(paramBoolean1, paramBoolean2, paramAnimatorListenerAdapter);
        AppMethodBeat.o(184570);
        return;
      }
      Log.i("MicroMsg.FloatBallService", "resumeFloatBall singleBallInfoCondition, withAnimation:false");
      com.tencent.mm.plugin.ball.ui.d.cwp().b(false, paramBoolean2, paramAnimatorListenerAdapter);
      c(this.rZm, true);
      AppMethodBeat.o(184570);
      return;
    }
    Log.i("MicroMsg.FloatBallService", "resumeFloatBall, restore data from storage");
    cvW();
    AppMethodBeat.o(184570);
  }
  
  public final void aGp()
  {
    AppMethodBeat.i(106105);
    Log.i("MicroMsg.FloatBallService", "onAccountInitialized:%s", new Object[] { Integer.valueOf(hashCode()) });
    a(com.tencent.mm.plugin.ball.ui.d.cwp());
    a(d.cwb());
    this.rZc = false;
    a(true, true, null);
    AppMethodBeat.o(106105);
  }
  
  public final void aIF()
  {
    AppMethodBeat.i(106099);
    Log.i("MicroMsg.FloatBallService", "onRegister:%s", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(106099);
  }
  
  public final void aIG()
  {
    AppMethodBeat.i(106100);
    Log.i("MicroMsg.FloatBallService", "onUnregister:%s", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(106100);
  }
  
  public final void b(int paramInt, com.tencent.mm.plugin.ball.c.e parame)
  {
    AppMethodBeat.i(106132);
    Log.i("MicroMsg.FloatBallService", "removeFloatBallInfoEventListener, type:%s", new Object[] { Integer.valueOf(paramInt) });
    if (parame != null)
    {
      Set localSet = (Set)this.rYY.get(paramInt);
      if (localSet != null) {
        localSet.remove(parame);
      }
    }
    AppMethodBeat.o(106132);
  }
  
  public final void b(com.tencent.mm.plugin.ball.c.d paramd)
  {
    AppMethodBeat.i(106139);
    this.rYW.remove(paramd);
    AppMethodBeat.o(106139);
  }
  
  public final void b(g paramg)
  {
    AppMethodBeat.i(188766);
    this.rYX.remove(paramg);
    Object localObject = com.tencent.mm.plugin.ball.ui.d.cwp();
    if (((com.tencent.mm.plugin.ball.ui.d)localObject).cwq())
    {
      localObject = ((com.tencent.mm.plugin.ball.ui.d)localObject).saj;
      if (((com.tencent.mm.plugin.ball.ui.a)localObject).rZJ != null) {
        ((com.tencent.mm.plugin.ball.ui.a)localObject).rZJ.listeners.remove(paramg);
      }
    }
    AppMethodBeat.o(188766);
  }
  
  final void c(BallInfo paramBallInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(106127);
    BallInfo localBallInfo = h(paramBallInfo);
    if (localBallInfo != null)
    {
      localBallInfo.rYp = Util.nowMilliSecond();
      this.rZm = localBallInfo;
      Log.i("MicroMsg.FloatBallService", "onEnterBallInfoPage, set lastEnteredBallInfo:%s", new Object[] { this.rZm.cvr() });
      lh(paramBoolean);
      AppMethodBeat.o(106127);
      return;
    }
    if (paramBallInfo != null) {}
    for (paramBallInfo = paramBallInfo.cvr();; paramBallInfo = "null")
    {
      Log.i("MicroMsg.FloatBallService", "onEnterBallInfoPage, no this ball info:%s", new Object[] { paramBallInfo });
      AppMethodBeat.o(106127);
      return;
    }
  }
  
  public final boolean c(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184579);
    if (!com.tencent.mm.plugin.ball.ui.d.cwp().cwq())
    {
      Log.i("MicroMsg.FloatBallService", "updateBallVisibilityByPosition, no float ball");
      AppMethodBeat.o(184579);
      return false;
    }
    if (!this.rZk)
    {
      Log.i("MicroMsg.FloatBallService", "updateBallVisibilityByPosition keyboard not show and ignore");
      AppMethodBeat.o(184579);
      return false;
    }
    boolean bool = a(this.pIk, this.rZj, false, false, paramAnimatorListenerAdapter);
    AppMethodBeat.o(184579);
    return bool;
  }
  
  public final boolean cuW()
  {
    return this.rZd;
  }
  
  public final boolean cuX()
  {
    AppMethodBeat.i(188651);
    if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(this.rXp))
    {
      Iterator localIterator = this.rXp.iterator();
      while (localIterator.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)localIterator.next();
        if ((!localBallInfo.qmt) && ((com.tencent.mm.plugin.ball.f.d.H(localBallInfo)) || (com.tencent.mm.plugin.ball.f.d.I(localBallInfo))))
        {
          AppMethodBeat.o(188651);
          return true;
        }
      }
    }
    AppMethodBeat.o(188651);
    return false;
  }
  
  public final boolean cuY()
  {
    return this.rZf;
  }
  
  public final long cuZ()
  {
    return this.rZi;
  }
  
  public final void cva()
  {
    AppMethodBeat.i(106109);
    lb(false);
    lg(false);
    if (this.rZm != null)
    {
      Log.i("MicroMsg.FloatBallService", "fixFloatBallIfNeed, lastEnteredBallInfo:%s", new Object[] { this.rZm });
      q(h(this.rZm));
      AppMethodBeat.o(106109);
      return;
    }
    Log.i("MicroMsg.FloatBallService", "fixFloatBallIfNeed, safe");
    AppMethodBeat.o(106109);
  }
  
  public final void cvb()
  {
    AppMethodBeat.i(106111);
    PlaySound.play(MMApplicationContext.getContext(), a.h.webview_minimize_sound_path);
    AppMethodBeat.o(106111);
  }
  
  public final List<BallInfo> cvc()
  {
    return this.rXp;
  }
  
  public final List<BallInfo> cvd()
  {
    return this.rYV;
  }
  
  public final Set<g> cve()
  {
    return this.rYX;
  }
  
  public final boolean cvf()
  {
    AppMethodBeat.i(188771);
    Object localObject = com.tencent.mm.plugin.ball.ui.d.cwp();
    if (((com.tencent.mm.plugin.ball.ui.d)localObject).cwq())
    {
      localObject = ((com.tencent.mm.plugin.ball.ui.d)localObject).saj;
      if (((com.tencent.mm.plugin.ball.ui.a)localObject).rZJ != null)
      {
        bool = ((com.tencent.mm.plugin.ball.ui.a)localObject).rZJ.sdC;
        AppMethodBeat.o(188771);
        return bool;
      }
      AppMethodBeat.o(188771);
      return false;
    }
    d.cwb();
    boolean bool = d.cwe();
    AppMethodBeat.o(188771);
    return bool;
  }
  
  public final void cvg()
  {
    this.rZl = null;
  }
  
  public final boolean cvh()
  {
    return this.rZe;
  }
  
  public final void cvi()
  {
    AppMethodBeat.i(184565);
    com.tencent.mm.plugin.ball.ui.d locald = com.tencent.mm.plugin.ball.ui.d.cwp();
    if (locald.cwq()) {
      locald.saj.cvi();
    }
    AppMethodBeat.o(184565);
  }
  
  public final void cvj()
  {
    AppMethodBeat.i(184566);
    com.tencent.mm.plugin.ball.ui.d locald = com.tencent.mm.plugin.ball.ui.d.cwp();
    if (locald.cwq()) {
      locald.saj.cvj();
    }
    AppMethodBeat.o(184566);
  }
  
  public final void dK(View paramView)
  {
    this.rZl = paramView;
  }
  
  public final Point getBallPosition()
  {
    AppMethodBeat.i(106121);
    Object localObject1 = com.tencent.mm.plugin.ball.ui.d.cwp();
    if (((com.tencent.mm.plugin.ball.ui.d)localObject1).cwq())
    {
      localObject1 = ((com.tencent.mm.plugin.ball.ui.d)localObject1).saj;
      if (((com.tencent.mm.plugin.ball.ui.a)localObject1).rZJ != null) {
        localObject1 = ((com.tencent.mm.plugin.ball.ui.a)localObject1).rZJ.getBallPosition();
      }
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new Point(com.tencent.mm.plugin.ball.f.d.cwy(), com.tencent.mm.plugin.ball.f.d.cwz());
      }
      Log.i("MicroMsg.FloatBallService", "getBallPosition, position:[%s, %s]", new Object[] { Integer.valueOf(((Point)localObject2).x), Integer.valueOf(((Point)localObject2).y) });
      AppMethodBeat.o(106121);
      return localObject2;
      localObject1 = new Point(com.tencent.mm.plugin.ball.f.d.cwy(), com.tencent.mm.plugin.ball.f.d.cwz());
      continue;
      localObject1 = new Point(com.tencent.mm.plugin.ball.f.d.cwy(), com.tencent.mm.plugin.ball.f.d.cwz());
    }
  }
  
  public final BallInfo h(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106113);
    synchronized (this.rXp)
    {
      if (this.rXp.contains(paramBallInfo))
      {
        int i = this.rXp.indexOf(paramBallInfo);
        if ((i < 0) || (i >= this.rXp.size()))
        {
          AppMethodBeat.o(106113);
          return null;
        }
        paramBallInfo = (BallInfo)this.rXp.get(i);
        Log.i("MicroMsg.FloatBallService", "getBallInfo, existed:true, responseBallInfo:%s", new Object[] { paramBallInfo });
        AppMethodBeat.o(106113);
        return paramBallInfo;
      }
      Log.i("MicroMsg.FloatBallService", "getBallInfo, existed:false");
      AppMethodBeat.o(106113);
      return null;
    }
  }
  
  public final boolean i(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106114);
    if (cvC() >= 5)
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
    if ((paramBallInfo.type == 6) && (paramBallInfo.rYs.rYx == 11)) {}
    for (int i = 1; (i != 0) && (!com.tencent.mm.compatible.e.b.ct(MMApplicationContext.getContext())); i = 0)
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
        public final void hR(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(187218);
          if (paramAnonymousBoolean)
          {
            c.a(c.this, paramBallInfo);
            AppMethodBeat.o(187218);
            return;
          }
          Log.w("MicroMsg.FloatBallService", "no float window permission");
          AppMethodBeat.o(187218);
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
      cvZ();
      AppMethodBeat.o(106118);
      return;
    }
    Log.i("MicroMsg.FloatBallService", "updateBallInfo, existed:false");
    AppMethodBeat.o(106118);
  }
  
  public final void kV(boolean paramBoolean)
  {
    AppMethodBeat.i(106101);
    a(paramBoolean, null);
    AppMethodBeat.o(106101);
  }
  
  public final void kW(boolean paramBoolean)
  {
    AppMethodBeat.i(106102);
    a(paramBoolean, true, null);
    AppMethodBeat.o(106102);
  }
  
  public final void kX(boolean paramBoolean)
  {
    AppMethodBeat.i(106103);
    lg(true);
    a(paramBoolean, null);
    AppMethodBeat.o(106103);
  }
  
  public final void kY(boolean paramBoolean)
  {
    AppMethodBeat.i(106104);
    lg(false);
    a(paramBoolean, true, null);
    AppMethodBeat.o(106104);
  }
  
  public final void kZ(boolean paramBoolean)
  {
    AppMethodBeat.i(188639);
    com.tencent.mm.plugin.ball.ui.d.cwp().c(paramBoolean, new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(186875);
        super.onAnimationEnd(paramAnonymousAnimator);
        c.this.a(null, 1.0F);
        AppMethodBeat.o(186875);
      }
    });
    AppMethodBeat.o(188639);
  }
  
  public final void l(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106119);
    if (this.rXp.contains(paramBallInfo))
    {
      if (com.tencent.mm.plugin.ball.f.d.H(paramBallInfo))
      {
        com.tencent.mm.plugin.ball.ui.d.cwp().cwk();
        paramBallInfo.bFK = null;
      }
      this.rXp.remove(paramBallInfo);
      d.cwb().l(paramBallInfo);
      a.b(paramBallInfo, this.rXp.isEmpty());
      Log.i("MicroMsg.FloatBallService", "removeBallInfo, existed:true, ballInfo:%s", new Object[] { paramBallInfo });
      if ((this.rZm != null) && (this.rZm.equals(paramBallInfo)))
      {
        Log.i("MicroMsg.FloatBallService", "removeBallInfo, remove last enteredBallInfo");
        this.rZm = null;
      }
      C(paramBallInfo);
      lh(true);
      b(paramBallInfo, 3);
      E(paramBallInfo);
      ((com.tencent.mm.plugin.handoff.a.a)h.ae(com.tencent.mm.plugin.handoff.a.a.class)).del(paramBallInfo.key);
      if (paramBallInfo.equals(this.rZa))
      {
        this.rZa = null;
        AppMethodBeat.o(106119);
      }
    }
    else
    {
      Log.i("MicroMsg.FloatBallService", "removeBallInfo, existed:false");
    }
    AppMethodBeat.o(106119);
  }
  
  public final void la(boolean paramBoolean)
  {
    AppMethodBeat.i(176960);
    Log.i("MicroMsg.FloatBallService", "markWechatInForeground, foreground:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.rZh = paramBoolean;
    if (this.rZf)
    {
      Log.i("MicroMsg.FloatBallService", "markWechatInForeground, has marked QB file view page, mark Wechat in foreground");
      com.tencent.mm.plugin.ball.ui.d.cwp().la(true);
    }
    for (;;)
    {
      if (!this.rZh)
      {
        Log.i("MicroMsg.FloatBallService", "alvinluo resetReadyStatusBallInfo");
        this.rZb = null;
      }
      AppMethodBeat.o(176960);
      return;
      com.tencent.mm.plugin.ball.ui.d.cwp().la(paramBoolean);
    }
  }
  
  public final void lb(boolean paramBoolean)
  {
    AppMethodBeat.i(106108);
    Log.i("MicroMsg.FloatBallService", "markQBFileViewPage:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.rZf = paramBoolean;
    AppMethodBeat.o(106108);
  }
  
  public final void lc(boolean paramBoolean)
  {
    AppMethodBeat.i(184564);
    com.tencent.mm.plugin.ball.ui.d locald = com.tencent.mm.plugin.ball.ui.d.cwp();
    if (locald.cwq()) {
      locald.saj.rZM = paramBoolean;
    }
    AppMethodBeat.o(184564);
  }
  
  public final void ld(boolean paramBoolean)
  {
    AppMethodBeat.i(185124);
    Log.i("MicroMsg.FloatBallService", "markForceHideAllFloatBall %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.rZe = paramBoolean;
    com.tencent.mm.plugin.ball.ui.d.cwp().rZe = paramBoolean;
    AppMethodBeat.o(185124);
  }
  
  public final void m(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106124);
    int i = paramBallInfo.rYs.opType;
    if ((i == 1) || (i == 2) || (i == 3)) {}
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        Log.w("MicroMsg.FloatBallReportLogic", "activeBallTypeReport unexpected opType:%d", new Object[] { Integer.valueOf(paramBallInfo.rYs.opType) });
        paramBallInfo.rYs.opType = 3;
      }
      a.a(paramBallInfo, Util.nowMilliSecond() - paramBallInfo.rYp, 0L, 0L, 0L);
      c(paramBallInfo, true);
      int j = paramBallInfo.type;
      i = j;
      if (j == 20) {
        i = paramBallInfo.aOl;
      }
      Log.d("MicroMsg.FloatBallService", "alvinluo notifySingleBallInfoClicked type: %d, contentType: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramBallInfo.aOl) });
      localObject = (Set)this.rYY.get(i);
      if (!com.tencent.mm.plugin.ball.f.d.checkListNotEmpty((Collection)localObject)) {
        break;
      }
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.plugin.ball.c.e)((Iterator)localObject).next()).b(paramBallInfo);
      }
    }
    Object localObject = (Set)this.rYY.get(0);
    if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty((Collection)localObject))
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.plugin.ball.c.e)((Iterator)localObject).next()).b(paramBallInfo);
      }
    }
    AppMethodBeat.o(106124);
  }
  
  public final void n(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106120);
    if (this.rXp.contains(paramBallInfo))
    {
      Object localObject = (Set)this.rYY.get(paramBallInfo.type);
      if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty((Collection)localObject))
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((com.tencent.mm.plugin.ball.c.e)((Iterator)localObject).next()).d(paramBallInfo);
        }
      }
      localObject = (Set)this.rYY.get(0);
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
    AppMethodBeat.i(292747);
    c(paramBallInfo, true);
    AppMethodBeat.o(292747);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(106106);
    Log.i("MicroMsg.FloatBallService", "onAccountRelease:%s", new Object[] { Integer.valueOf(hashCode()) });
    b(com.tencent.mm.plugin.ball.ui.d.cwp());
    b(d.cwb());
    this.rZc = false;
    com.tencent.mm.plugin.ball.ui.d.cwp().cwr();
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
    if (this.rZm != null)
    {
      localObject = this.rZm.cvr();
      Log.i("MicroMsg.FloatBallService", "onExitBallInfoPage, lastEnteredBallInfo:%s", new Object[] { localObject });
      this.rZm = null;
      localObject = h(paramBallInfo);
      if (localObject == null) {
        break label154;
      }
      Log.i("MicroMsg.FloatBallService", "onExitBallInfoPage, ballInfo:%s", new Object[] { localObject });
      if (((BallInfo)localObject).rYs.opType != -1) {
        break label139;
      }
      ((BallInfo)localObject).rYs.opType = 0;
      label87:
      if (com.tencent.mm.plugin.ball.ui.d.cwp().cwl()) {
        break label146;
      }
      if (!this.rZe) {
        a(paramBallInfo, 1.0F);
      }
    }
    for (;;)
    {
      if (!((BallInfo)localObject).qmt) {
        break label167;
      }
      ((BallInfo)localObject).qmt = false;
      cvZ();
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
    AppMethodBeat.i(188728);
    if (paramBallInfo != null) {
      a.a(paramBallInfo, this.rXp);
    }
    AppMethodBeat.o(188728);
  }
  
  public final void s(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106135);
    String str;
    if (paramBallInfo != null)
    {
      str = paramBallInfo.cvr();
      paramBallInfo = (ResultReceiver)this.rYZ.remove(str);
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
    AppMethodBeat.i(188617);
    Object localObject = com.tencent.mm.plugin.ball.ui.d.cwp();
    if (((com.tencent.mm.plugin.ball.ui.d)localObject).cwq())
    {
      localObject = ((com.tencent.mm.plugin.ball.ui.d)localObject).saj;
      if (((com.tencent.mm.plugin.ball.ui.a)localObject).rZJ != null) {
        ((com.tencent.mm.plugin.ball.ui.a)localObject).rZJ.setEnableClick(paramBoolean);
      }
    }
    AppMethodBeat.o(188617);
  }
  
  public final void t(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(188699);
    if (paramBallInfo == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.FloatBallService", "alvinluo markMessageBallInfo ballInfo == null: %b, %s, readyInfo == null: %b", new Object[] { Boolean.valueOf(bool), paramBallInfo, this.rZb });
      if (paramBallInfo != null)
      {
        if (this.rZb == null) {
          this.rZb = new BallInfo(20, paramBallInfo.key);
        }
        this.rZb.w(paramBallInfo);
        this.rZb.key = paramBallInfo.key;
        this.rZb.type = 20;
        this.rZb.state = 256;
        this.rZb.qmt = false;
        this.rZb.rYr = true;
        this.rZb.coZ = System.currentTimeMillis();
        if ((paramBallInfo.type == 4) && (this.rZb.mab != null))
        {
          paramBallInfo = this.rZb.mab.getString("processName");
          if (!Util.isNullOrNil(paramBallInfo))
          {
            Log.d("MicroMsg.FloatBallService", "markMessageBallInfo reset processName: %s", new Object[] { paramBallInfo });
            this.rZb.mab.putString("processName", "");
          }
        }
      }
      AppMethodBeat.o(188699);
      return;
    }
  }
  
  public final void u(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(188631);
    BallInfo localBallInfo = cvU();
    Point localPoint1;
    Point localPoint2;
    label263:
    int j;
    if (localBallInfo != null)
    {
      localBallInfo.state = paramBallInfo.state;
      localBallInfo.rYt = paramBallInfo.rYt;
      paramBallInfo = com.tencent.mm.plugin.ball.ui.d.cwp().saj;
      if (paramBallInfo.rZJ != null)
      {
        paramBallInfo = paramBallInfo.rZJ;
        Log.i("MicroMsg.FloatBallView", "alvinluo switchVoipVoice");
        if (localBallInfo.rYt == null)
        {
          Log.w("MicroMsg.FloatBallView", "switchVoip animationInfo invalid and ignore");
          AppMethodBeat.o(188631);
          return;
        }
        localPoint1 = new Point(localBallInfo.rYt.rYv);
        if (paramBallInfo.FD(paramBallInfo.sca))
        {
          boolean bool1 = FloatBallView.FJ(paramBallInfo.sca);
          boolean bool2 = FloatBallView.FM(paramBallInfo.sca);
          localPoint1.x = paramBallInfo.g(bool1, bool2, true);
          localPoint1.y = paramBallInfo.a(paramBallInfo.sca, bool1, bool2, true);
        }
        localPoint2 = new Point(localBallInfo.rYt.rYw);
        if (paramBallInfo.FD(paramBallInfo.sca))
        {
          if (localBallInfo.state != 8) {
            break label263;
          }
          localPoint2.x = (FloatBallView.scF + FloatBallView.scR * 2);
          localPoint2.y = (FloatBallView.scG + FloatBallView.scR * 2);
        }
        while ((!FloatBallView.h(localPoint1)) || (!FloatBallView.h(localPoint2)))
        {
          Log.w("MicroMsg.FloatBallView", "switchVoip animationInfo size invalid and ignore");
          AppMethodBeat.o(188631);
          return;
          if (localBallInfo.state == 512)
          {
            i = FloatBallView.scB + FloatBallView.scR * 2;
            if (localPoint2.x < i) {
              localPoint2.x = i;
            }
          }
        }
        paramBallInfo.sdQ = 80;
        j = paramBallInfo.sdQ;
        if (!paramBallInfo.sdC) {
          break label481;
        }
      }
    }
    label481:
    for (int i = 8388611;; i = 8388613)
    {
      paramBallInfo.X(i | j, true);
      FrameLayout localFrameLayout = paramBallInfo.scY;
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localFrameLayout.getLayoutParams();
      Log.i("MicroMsg.FloatBallView", "alvinluo animateVoipSwitch state: %d, startSize: %s, endSize: %s, current: %d, %d", new Object[] { Integer.valueOf(localBallInfo.state), localPoint1, localPoint2, Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator.setDuration(300L);
      localValueAnimator.addListener(new FloatBallView.6(paramBallInfo, localBallInfo, localPoint1, localPoint2));
      localValueAnimator.addUpdateListener(new FloatBallView.7(paramBallInfo, localLayoutParams, localPoint1, localPoint2, localFrameLayout));
      localValueAnimator.start();
      AppMethodBeat.o(188631);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.c
 * JD-Core Version:    0.7.0.1
 */