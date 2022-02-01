package com.tencent.mm.plugin.ball.service;

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
import com.tencent.mm.plugin.ball.c.b.a;
import com.tencent.mm.plugin.ball.c.i;
import com.tencent.mm.plugin.ball.f.c;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallInfo.a;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.ball.ui.FloatBallProxyUI;
import com.tencent.mm.plugin.ball.ui.FloatBallProxyUI.a;
import com.tencent.mm.plugin.ball.view.FloatBallView;
import com.tencent.mm.plugin.ball.view.FloatBallView.6;
import com.tencent.mm.plugin.ball.view.FloatBallView.7;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
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

public class d
  implements com.tencent.mm.kernel.c.b, g.a, com.tencent.mm.plugin.ball.c.b
{
  private static d oWT;
  volatile int displayHeight;
  final List<BallInfo> oVq;
  private final List<BallInfo> oWU;
  private Set<com.tencent.mm.plugin.ball.c.d> oWV;
  private Set<com.tencent.mm.plugin.ball.c.g> oWW;
  private SparseArray<Set<com.tencent.mm.plugin.ball.c.e>> oWX;
  private Map<String, ResultReceiver> oWY;
  private volatile BallInfo oWZ;
  private volatile BallInfo oXa;
  private volatile boolean oXb;
  volatile boolean oXc;
  volatile boolean oXd;
  volatile boolean oXe;
  private volatile boolean oXf;
  private volatile boolean oXg;
  private volatile long oXh;
  private volatile int oXi;
  private volatile int oXj;
  private volatile boolean oXk;
  private View oXl;
  private volatile BallInfo oXm;
  private int oXn;
  
  private d()
  {
    AppMethodBeat.i(106097);
    this.oVq = new CopyOnWriteArrayList();
    this.oWU = new CopyOnWriteArrayList();
    this.oWV = new CopyOnWriteArraySet();
    this.oWW = new CopyOnWriteArraySet();
    this.oWX = new SparseArray();
    this.oWY = new ConcurrentHashMap();
    this.oWZ = null;
    this.oXa = null;
    this.oXb = false;
    this.oXc = false;
    this.oXd = false;
    this.oXe = false;
    this.oXf = false;
    this.oXg = true;
    this.oXh = 0L;
    this.oXi = 0;
    this.oXj = 0;
    this.displayHeight = 0;
    this.oXk = false;
    this.oXm = null;
    this.oXn = -1;
    AppMethodBeat.o(106097);
  }
  
  private void A(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(217002);
    com.tencent.mm.plugin.ball.ui.d.ciX().c(true, new d.6(this, paramBallInfo));
    AppMethodBeat.o(217002);
  }
  
  private void B(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(217003);
    Log.d("MicroMsg.FloatBallService", "onFloatBallAdded %s", new Object[] { paramBallInfo });
    com.tencent.mm.plugin.ball.ui.d.ciX().a(this.oVq.size(), paramBallInfo);
    AppMethodBeat.o(217003);
  }
  
  private void C(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(217004);
    com.tencent.mm.plugin.ball.ui.d.ciX().b(this.oVq.size(), paramBallInfo);
    AppMethodBeat.o(217004);
  }
  
  private void D(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(217005);
    int j = this.oWX.size();
    int i = 0;
    while (i < j)
    {
      int k = this.oWX.keyAt(i);
      Object localObject = (Set)this.oWX.get(k);
      if (com.tencent.mm.plugin.ball.f.d.h((Collection)localObject))
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((com.tencent.mm.plugin.ball.c.e)((Iterator)localObject).next()).g(paramBallInfo);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(217005);
  }
  
  private void E(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106133);
    Object localObject = (Set)this.oWX.get(paramBallInfo.type);
    if (com.tencent.mm.plugin.ball.f.d.h((Collection)localObject))
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.plugin.ball.c.e)((Iterator)localObject).next()).c(paramBallInfo);
      }
    }
    localObject = (Set)this.oWX.get(0);
    if (com.tencent.mm.plugin.ball.f.d.h((Collection)localObject))
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
    AppMethodBeat.i(217010);
    paramBallInfo = h(paramBallInfo);
    if ((paramBallInfo != null) && (paramBallInfo.oWr))
    {
      Log.i("MicroMsg.FloatBallService", "removeAppBrandPassiveBallInfo, remove existedBallInfo:%s", new Object[] { paramBallInfo });
      paramBallInfo.oWs.opType = 10;
      l(paramBallInfo);
    }
    AppMethodBeat.o(217010);
  }
  
  private void V(Bundle paramBundle)
  {
    AppMethodBeat.i(217006);
    Iterator localIterator = this.oWY.values().iterator();
    while (localIterator.hasNext()) {
      ((ResultReceiver)localIterator.next()).send(1, paramBundle);
    }
    AppMethodBeat.o(217006);
  }
  
  private boolean a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184580);
    boolean bool = chN();
    Log.i("MicroMsg.FloatBallService", "updateBallVisibilityByKbHeight needShowFloatBall: %b", new Object[] { Boolean.valueOf(bool) });
    if ((bool) && (!this.oXk) && (this.oXf))
    {
      this.oXf = false;
      if ((this.oXl != null) && (this.oXl.getVisibility() != 0))
      {
        Log.d("MicroMsg.FloatBallService", "alvinluo updateBallVisibilityByKbHeight has voip but not visible and delay show animation");
        this.oXl.setVisibility(0);
        this.oXl.setAlpha(0.0F);
        a(true, false, paramAnimatorListenerAdapter);
        AppMethodBeat.o(184580);
        return true;
      }
      Log.d("MicroMsg.FloatBallService", "alvinluo updateBallVisibilityByKbHeight has voip and visible, not need to show");
      AppMethodBeat.o(184580);
      return false;
    }
    int j = ciI();
    int k = com.tencent.mm.plugin.ball.ui.d.ciX().getPositionY();
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
      this.oXf = true;
      a(true, paramAnimatorListenerAdapter);
      AppMethodBeat.o(184580);
      return true;
      i = 0;
      break;
    }
    label290:
    if (this.oXf)
    {
      this.oXf = false;
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
    paramBallInfo = paramBallInfo.cif();
    ResultReceiver localResultReceiver = (ResultReceiver)this.oWY.get(paramBallInfo);
    if (localResultReceiver != null)
    {
      Log.i("MicroMsg.FloatBallService", "notifyResultReceiver, event:%s, ballInfoHashKey:%s, receiver:%s", new Object[] { Integer.valueOf(paramInt), paramBallInfo, Integer.valueOf(localResultReceiver.hashCode()) });
      localResultReceiver.send(paramInt, new Bundle());
    }
    AppMethodBeat.o(106136);
  }
  
  private static void cb(List<BallInfo> paramList)
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
      if ((localBallInfo != null) && (localBallInfo.type == 4) && (localBallInfo.jkf != null))
      {
        String str = localBallInfo.jkf.getString("processName");
        if (!Util.isNullOrNil(str))
        {
          Log.i("MicroMsg.FloatBallService", "restore with process name: %s", new Object[] { str });
          localBallInfo.jkf.putString("processName", "");
        }
      }
    }
    AppMethodBeat.o(184573);
  }
  
  private void cc(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106137);
    if (!this.oWY.isEmpty())
    {
      int i = com.tencent.mm.plugin.ball.f.d.cg(paramList).size();
      if (this.oXn != i)
      {
        this.oXn = i;
        paramList = new Bundle();
        paramList.putInt("ActiveCount", i);
        Iterator localIterator = this.oWY.values().iterator();
        while (localIterator.hasNext()) {
          ((ResultReceiver)localIterator.next()).send(5, paramList);
        }
      }
    }
    AppMethodBeat.o(106137);
  }
  
  /* Error */
  public static d ciB()
  {
    // Byte code:
    //   0: ldc_w 392
    //   3: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 394	com/tencent/mm/plugin/ball/service/d:oWT	Lcom/tencent/mm/plugin/ball/service/d;
    //   12: ifnonnull +19 -> 31
    //   15: ldc 2
    //   17: monitorenter
    //   18: new 2	com/tencent/mm/plugin/ball/service/d
    //   21: dup
    //   22: invokespecial 395	com/tencent/mm/plugin/ball/service/d:<init>	()V
    //   25: putstatic 394	com/tencent/mm/plugin/ball/service/d:oWT	Lcom/tencent/mm/plugin/ball/service/d;
    //   28: ldc 2
    //   30: monitorexit
    //   31: ldc 2
    //   33: monitorexit
    //   34: getstatic 394	com/tencent/mm/plugin/ball/service/d:oWT	Lcom/tencent/mm/plugin/ball/service/d;
    //   37: astore_0
    //   38: ldc_w 392
    //   41: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aload_0
    //   45: areturn
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: ldc_w 392
    //   53: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aload_0
    //   57: athrow
    //   58: astore_0
    //   59: ldc 2
    //   61: monitorexit
    //   62: ldc_w 392
    //   65: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private BallInfo ciC()
  {
    AppMethodBeat.i(216992);
    if (com.tencent.mm.plugin.ball.f.d.h(this.oVq))
    {
      Iterator localIterator = this.oVq.iterator();
      while (localIterator.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)localIterator.next();
        if (com.tencent.mm.plugin.ball.f.d.H(localBallInfo))
        {
          AppMethodBeat.o(216992);
          return localBallInfo;
        }
      }
    }
    AppMethodBeat.o(216992);
    return null;
  }
  
  private void ciD()
  {
    AppMethodBeat.i(184571);
    BallInfo localBallInfo;
    if (com.tencent.mm.plugin.ball.f.d.h(this.oVq))
    {
      Iterator localIterator = this.oVq.iterator();
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
  
  private void ciE()
  {
    AppMethodBeat.i(184572);
    if (com.tencent.mm.kernel.g.aAc())
    {
      e.ciJ();
      List localList1 = e.ciN();
      cb(localList1);
      this.oVq.clear();
      if (ao.isMultiTaskMode())
      {
        List localList2 = com.tencent.mm.plugin.ball.f.d.ch(localList1);
        this.oVq.addAll(localList2);
      }
      for (;;)
      {
        localList1 = com.tencent.mm.plugin.ball.f.d.cg(localList1);
        this.oWU.clear();
        this.oWU.addAll(localList1);
        this.oXb = true;
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
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
        this.oVq.addAll(localList1);
      }
    }
    Log.i("MicroMsg.FloatBallService", "restoreDataFromStorage, account not ready");
    AppMethodBeat.o(184572);
  }
  
  private boolean ciF()
  {
    AppMethodBeat.i(184574);
    BallInfo localBallInfo = h(this.oXm);
    if ((localBallInfo != null) && (com.tencent.mm.plugin.ball.f.d.h(this.oVq)))
    {
      boolean bool = com.tencent.mm.plugin.ball.f.d.f(this.oVq, localBallInfo);
      AppMethodBeat.o(184574);
      return bool;
    }
    AppMethodBeat.o(184574);
    return false;
  }
  
  public static void ciG()
  {
    AppMethodBeat.i(106123);
    com.tencent.mm.plugin.ball.ui.d.ciX().a(false, null);
    AppMethodBeat.o(106123);
  }
  
  private void ciH()
  {
    AppMethodBeat.i(106140);
    List localList = com.tencent.mm.plugin.ball.f.d.cd(new Vector(this.oVq));
    Log.i("MicroMsg.FloatBallService", "notifyFloatBallInfoChanged, originSize: %d, sortedSize: %d, ballInfoList:%s", new Object[] { Integer.valueOf(this.oVq.size()), Integer.valueOf(localList.size()), localList });
    Iterator localIterator = this.oWV.iterator();
    while (localIterator.hasNext())
    {
      ((com.tencent.mm.plugin.ball.c.d)localIterator.next()).a(localList, this.oXm);
      cc(localList);
    }
    AppMethodBeat.o(106140);
  }
  
  private int ciI()
  {
    AppMethodBeat.i(184581);
    int j = com.tencent.mm.plugin.ball.f.e.oYK + com.tencent.mm.plugin.ball.f.e.oYL + com.tencent.mm.plugin.ball.f.e.oYM;
    int i = j;
    if (this.oXl != null) {
      i = Math.max(this.oXl.getMeasuredHeight(), j);
    }
    AppMethodBeat.o(184581);
    return i;
  }
  
  private int cip()
  {
    AppMethodBeat.i(106115);
    List localList = com.tencent.mm.plugin.ball.f.d.cg(this.oVq);
    if (com.tencent.mm.plugin.ball.f.d.h(localList))
    {
      int i = localList.size();
      AppMethodBeat.o(106115);
      return i;
    }
    AppMethodBeat.o(106115);
    return 0;
  }
  
  private void jV(boolean paramBoolean)
  {
    AppMethodBeat.i(106107);
    Log.i("MicroMsg.FloatBallService", "markNoFloatBallPage:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.oXc = paramBoolean;
    AppMethodBeat.o(106107);
  }
  
  private void jW(boolean paramBoolean)
  {
    AppMethodBeat.i(106129);
    Object localObject = h(this.oXm);
    if ((localObject != null) && (com.tencent.mm.plugin.ball.f.d.h(this.oVq)))
    {
      if (com.tencent.mm.plugin.ball.f.d.e(this.oVq, (BallInfo)localObject))
      {
        Log.i("MicroMsg.FloatBallService", "recheckBallInfoList, has other balls, hidden current ball info");
        boolean bool = com.tencent.mm.plugin.ball.ui.d.ciX().ciT();
        Log.i("MicroMsg.FloatBallService", "recheckBallInfoList, canNotShowFloatBall:%s, withFloatBall:%s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
        if ((!bool) && (paramBoolean)) {
          a((BallInfo)localObject, 1.0F);
        }
        Iterator localIterator = this.oVq.iterator();
        while (localIterator.hasNext())
        {
          BallInfo localBallInfo = (BallInfo)localIterator.next();
          if ((!localBallInfo.oWr) && (localBallInfo.nno) && (!localBallInfo.equals(localObject)))
          {
            localBallInfo.nno = false;
            b(localBallInfo, 4);
          }
          else if (localBallInfo.equals(localObject))
          {
            localBallInfo.nno = true;
          }
        }
      }
      if (com.tencent.mm.plugin.ball.f.d.f(this.oVq, (BallInfo)localObject))
      {
        Log.i("MicroMsg.FloatBallService", "recheckBallInfoList, no other balls, make float ball transparent");
        ((BallInfo)localObject).nno = false;
        a((BallInfo)localObject, 0.0F);
      }
      ciH();
      AppMethodBeat.o(106129);
      return;
    }
    if (this.oXm != null) {}
    for (localObject = this.oXm.cif();; localObject = "null")
    {
      Log.i("MicroMsg.FloatBallService", "recheckBallInfoList, last enteredBallInfo:%s", new Object[] { localObject });
      break;
    }
  }
  
  private void z(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106117);
    if ((!paramBallInfo.oWr) && (cip() >= 5))
    {
      Log.i("MicroMsg.FloatBallService", "addBallInfo, already add max count balls:%s", new Object[] { Integer.valueOf(5) });
      FloatBallProxyUI.a(1, new FloatBallProxyUI.a()
      {
        public final void eU(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(216989);
          Log.i("MicroMsg.FloatBallService", "addBallInfo, show reach count limit callback:%s, proxyMode: %d", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1) });
          if (paramAnonymousInt2 == 1)
          {
            Log.i("MicroMsg.FloatBallService", "addBallInfo, show float menu view");
            d.ciG();
          }
          AppMethodBeat.o(216989);
        }
      });
      AppMethodBeat.o(106117);
      return;
    }
    if (!this.oVq.contains(paramBallInfo))
    {
      if ((com.tencent.mm.plugin.ball.f.d.H(paramBallInfo)) && (com.tencent.mm.plugin.ball.f.d.cn(this.oVq)))
      {
        Log.e("MicroMsg.FloatBallService", "addBallInfo video ball is already exist and can not add more");
        AppMethodBeat.o(106117);
        return;
      }
      long l = Util.nowMilliSecond();
      paramBallInfo.oWp = l;
      paramBallInfo.createTime = l;
      paramBallInfo.oWs.opType = -1;
      Object localObject;
      int i;
      if (paramBallInfo.type != 20)
      {
        localObject = paramBallInfo.oWs;
        if ((paramBallInfo.oWr) && (paramBallInfo.oWs.hCZ == 0)) {
          i = 3;
        }
      }
      for (((BallReportInfo)localObject).hCZ = i;; paramBallInfo.oWs.hCZ = 5)
      {
        this.oVq.add(paramBallInfo);
        Log.i("MicroMsg.FloatBallService", "addBallInfo, existed:false, ballInfo:%s", new Object[] { paramBallInfo });
        if (!paramBallInfo.gqx) {
          b.a(paramBallInfo, this.oVq);
        }
        B(paramBallInfo);
        jW(true);
        localObject = new Bundle();
        ((Bundle)localObject).putInt("type", paramBallInfo.type);
        ((Bundle)localObject).putString("key", paramBallInfo.key);
        V((Bundle)localObject);
        D(paramBallInfo);
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).O(paramBallInfo);
        AppMethodBeat.o(106117);
        return;
        i = paramBallInfo.oWs.hCZ;
        break;
      }
    }
    Log.i("MicroMsg.FloatBallService", "addBallInfo, existed:true, replaceExisted: %b, ballInfo:%s", new Object[] { Boolean.valueOf(paramBallInfo.oWq), paramBallInfo });
    if (paramBallInfo.oWq)
    {
      paramBallInfo.oWq = false;
      k(paramBallInfo);
    }
    AppMethodBeat.o(106117);
  }
  
  public final void BC(int paramInt)
  {
    this.displayHeight = paramInt;
  }
  
  public final void BD(int paramInt)
  {
    AppMethodBeat.i(216998);
    if ((this.oWZ != null) && (this.oWZ.beK == paramInt))
    {
      Log.i("MicroMsg.FloatBallService", "alvinluo removeMessageBall type: %d", new Object[] { Integer.valueOf(paramInt) });
      l(this.oWZ);
    }
    AppMethodBeat.o(216998);
  }
  
  public final void By(long paramLong)
  {
    this.oXh = paramLong;
  }
  
  public final void Dw(boolean paramBoolean)
  {
    AppMethodBeat.i(106108);
    Log.i("MicroMsg.FloatBallService", "markQBFileViewPage:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.oXe = paramBoolean;
    AppMethodBeat.o(106108);
  }
  
  public final void a(final int paramInt1, final int paramInt2, boolean paramBoolean, long paramLong)
  {
    boolean bool = false;
    AppMethodBeat.i(184577);
    this.oXi = paramInt1;
    this.oXj = paramInt2;
    this.oXk = paramBoolean;
    if (!com.tencent.mm.plugin.ball.ui.d.ciX().ciY())
    {
      Log.i("MicroMsg.FloatBallService", "KeyboardHeightChanged, no float ball");
      AppMethodBeat.o(184577);
      return;
    }
    if (paramBoolean) {
      jS(true);
    }
    while (paramLong != 0L)
    {
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(216987);
          d locald = d.this;
          int i = paramInt1;
          int j = paramInt2;
          if (d.b(d.this) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            d.a(locald, i, j, bool);
            AppMethodBeat.o(216987);
            return;
          }
        }
      }, paramLong);
      AppMethodBeat.o(184577);
      return;
      jS(false);
    }
    paramBoolean = bool;
    if (this.oXi != 0) {
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
      Set localSet = (Set)this.oWX.get(paramInt);
      Object localObject = localSet;
      if (localSet == null)
      {
        localObject = new HashSet();
        this.oWX.put(paramInt, localObject);
      }
      ((Set)localObject).add(parame);
    }
    AppMethodBeat.o(106131);
  }
  
  public final void a(long paramLong, b.a parama)
  {
    int i = 1;
    AppMethodBeat.i(216997);
    if (this.oXa == null)
    {
      Log.w("MicroMsg.FloatBallService", "alvinluo addMessageBall readyMessageBallInfo is invalid");
      if (parama != null) {
        parama.BE(7);
      }
      AppMethodBeat.o(216997);
      return;
    }
    if ((!this.oXg) && (!this.oXe))
    {
      Log.w("MicroMsg.FloatBallService", "alvinluo addMessageBall isWechatForeground: %b", new Object[] { Boolean.valueOf(this.oXg) });
      if (parama != null) {
        parama.BE(6);
      }
      this.oXa = null;
      AppMethodBeat.o(216997);
      return;
    }
    if (!com.tencent.mm.plugin.ball.f.d.a(this.oXa, paramLong))
    {
      Log.w("MicroMsg.FloatBallService", "alvinluo addMessageBall can not add message ball because of time over limit");
      if (parama != null) {
        parama.BE(5);
      }
      this.oXa = null;
      AppMethodBeat.o(216997);
      return;
    }
    if (this.oWZ == null)
    {
      this.oWZ = new BallInfo(20, this.oXa.key);
      this.oWZ.w(this.oXa);
      Log.i("MicroMsg.FloatBallService", "alvinluo addMessageBall existed: false, and add: %s", new Object[] { this.oWZ });
      j(this.oWZ);
      this.oXa = null;
      if (parama != null) {
        parama.BE(i);
      }
      AppMethodBeat.o(216997);
      return;
    }
    BallInfo localBallInfo = this.oXa;
    if (this.oWZ == null) {
      Log.w("MicroMsg.FloatBallService", "alvinluo updateMessageBall messageBallInfo is null and ignore");
    }
    for (;;)
    {
      if ((this.oWZ != null) && (!this.oWZ.gqx))
      {
        this.oWZ.oWs.hCZ = 6;
        b.a(this.oWZ, this.oVq);
      }
      i = 2;
      break;
      if (h(this.oWZ) != null)
      {
        this.oWZ.w(localBallInfo);
        this.oWZ.key = localBallInfo.key;
        Log.i("MicroMsg.FloatBallService", "alvinluo updateMessageBall existed: true, and update %s", new Object[] { this.oWZ });
        k(this.oWZ);
      }
      else
      {
        Log.w("MicroMsg.FloatBallService", "alvinluo updateMessageBall messageBallInfo not null but not added!!");
      }
    }
  }
  
  public final void a(ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(216999);
    com.tencent.mm.plugin.ball.ui.d.ciX().a(true, paramResultReceiver);
    AppMethodBeat.o(216999);
  }
  
  public final void a(com.tencent.mm.plugin.ball.c.d paramd)
  {
    AppMethodBeat.i(106138);
    this.oWV.add(paramd);
    AppMethodBeat.o(106138);
  }
  
  public final void a(com.tencent.mm.plugin.ball.c.g paramg)
  {
    AppMethodBeat.i(217007);
    this.oWW.add(paramg);
    com.tencent.mm.plugin.ball.ui.d locald = com.tencent.mm.plugin.ball.ui.d.ciX();
    if (locald.ciY()) {
      locald.oYi.a(paramg);
    }
    AppMethodBeat.o(217007);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(106112);
    if (com.tencent.mm.plugin.ball.f.d.h(this.oVq))
    {
      parami.bH(new ArrayList(this.oVq));
      AppMethodBeat.o(106112);
      return;
    }
    parami.bH(new ArrayList());
    AppMethodBeat.o(106112);
  }
  
  public final void a(BallInfo paramBallInfo, float paramFloat)
  {
    AppMethodBeat.i(106122);
    if ((paramFloat == 1.0F) || (com.tencent.mm.plugin.ball.f.d.f(this.oVq, paramBallInfo))) {
      MMHandlerThread.postToMainThread(new com.tencent.mm.plugin.ball.ui.d.2(com.tencent.mm.plugin.ball.ui.d.ciX(), paramFloat));
    }
    AppMethodBeat.o(106122);
  }
  
  public final void a(BallInfo paramBallInfo, ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(106134);
    if ((paramBallInfo != null) && (paramResultReceiver != null))
    {
      paramBallInfo = paramBallInfo.cif();
      Log.i("MicroMsg.FloatBallService", "registerFloatBallEventReceiver, key:%s, receiver:%s", new Object[] { paramBallInfo, Integer.valueOf(paramResultReceiver.hashCode()) });
      this.oWY.put(paramBallInfo, paramResultReceiver);
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
        paramBallInfo.nno = bool;
        Log.i("MicroMsg.FloatBallService", "updateBallVisibility, existed:true, visible:%s, ballInfo:%s", new Object[] { Boolean.valueOf(paramBoolean), paramBallInfo });
        ciH();
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
    if ((paramAppBrandBackgroundRunningOperationParcel.dDe == 2) || (paramAppBrandBackgroundRunningOperationParcel.dDe == 3))
    {
      if ((paramAppBrandBackgroundRunningOperationParcel.beL & 0x2) > 0) {
        F(new BallInfo(7, com.tencent.mm.plugin.ball.f.b.cB(paramAppBrandBackgroundRunningOperationParcel.appId, paramAppBrandBackgroundRunningOperationParcel.iOo)));
      }
      if ((paramAppBrandBackgroundRunningOperationParcel.beL & 0x4) > 0)
      {
        paramList = paramAppBrandBackgroundRunningOperationParcel.appId;
        paramInt = paramAppBrandBackgroundRunningOperationParcel.iOo;
        F(new BallInfo(17, String.format(Locale.US, "%s#%d", new Object[] { paramList, Integer.valueOf(paramInt) })));
      }
      if ((paramAppBrandBackgroundRunningOperationParcel.beL & 0x8) > 0) {
        F(new BallInfo(18, com.tencent.mm.plugin.ball.f.b.cA(paramAppBrandBackgroundRunningOperationParcel.appId, paramAppBrandBackgroundRunningOperationParcel.iOo)));
      }
      if ((paramAppBrandBackgroundRunningOperationParcel.beL & 0x10) > 0) {
        F(new BallInfo(19, com.tencent.mm.plugin.ball.f.b.cA(paramAppBrandBackgroundRunningOperationParcel.appId, paramAppBrandBackgroundRunningOperationParcel.iOo)));
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
    if (this.oXe)
    {
      Log.i("MicroMsg.FloatBallService", "hideFloatBall, has marked QB file view page, ignore hiding");
      AppMethodBeat.o(184567);
      return;
    }
    if ((chN()) && (!this.oXd)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.FloatBallService", "hideFloatBall forceHide: %b, canShowFloatBall: %b, videoBallInfo: %s", new Object[] { Boolean.valueOf(this.oXd), Boolean.valueOf(bool), ciC() });
      if (!bool) {
        break;
      }
      AppMethodBeat.o(184567);
      return;
    }
    com.tencent.mm.plugin.ball.ui.d.ciX().e(paramBoolean, paramAnimatorListenerAdapter);
    AppMethodBeat.o(184567);
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184570);
    if (!com.tencent.mm.compatible.e.b.cx(MMApplicationContext.getContext()))
    {
      Log.i("MicroMsg.FloatBallService", "resumeFloatBall, no float window permission");
      ciD();
      com.tencent.mm.plugin.ball.ui.d.ciX().ciZ();
      this.oXb = false;
      this.oVq.clear();
      e.ciJ().clear();
      ciH();
      AppMethodBeat.o(184570);
      return;
    }
    if (this.oXb)
    {
      if ((this.oXc) && (!chN()))
      {
        Log.i("MicroMsg.FloatBallService", "resumeFloatBall, has marked no float ball page, ignore resuming");
        AppMethodBeat.o(184570);
        return;
      }
      if (this.oXd)
      {
        Log.i("MicroMsg.FloatBallService", "resumeFloatBall, has marked forceHideAllFloatBall, ignore resuming");
        AppMethodBeat.o(184570);
        return;
      }
      if (this.oXf)
      {
        Log.i("MicroMsg.FloatBallService", "resumeFloatBall, hasHideForKeyboardHeightChange, ignore resuming");
        AppMethodBeat.o(184570);
        return;
      }
      if (!ciF())
      {
        Log.i("MicroMsg.FloatBallService", "resumeFloatBall not singleBallInfoCondition, withAnimation:%s", new Object[] { Boolean.valueOf(paramBoolean1) });
        com.tencent.mm.plugin.ball.ui.d.ciX().b(paramBoolean1, paramBoolean2, paramAnimatorListenerAdapter);
        AppMethodBeat.o(184570);
        return;
      }
      Log.i("MicroMsg.FloatBallService", "resumeFloatBall singleBallInfoCondition, withAnimation:false");
      com.tencent.mm.plugin.ball.ui.d.ciX().b(false, paramBoolean2, paramAnimatorListenerAdapter);
      c(this.oXm, true);
      AppMethodBeat.o(184570);
      return;
    }
    Log.i("MicroMsg.FloatBallService", "resumeFloatBall, restore data from storage");
    ciE();
    AppMethodBeat.o(184570);
  }
  
  public final void aBc()
  {
    AppMethodBeat.i(106099);
    Log.i("MicroMsg.FloatBallService", "onRegister:%s", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(106099);
  }
  
  public final void aBd()
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
      Set localSet = (Set)this.oWX.get(paramInt);
      if (localSet != null) {
        localSet.remove(parame);
      }
    }
    AppMethodBeat.o(106132);
  }
  
  public final void b(com.tencent.mm.plugin.ball.c.d paramd)
  {
    AppMethodBeat.i(106139);
    this.oWV.remove(paramd);
    AppMethodBeat.o(106139);
  }
  
  public final void b(com.tencent.mm.plugin.ball.c.g paramg)
  {
    AppMethodBeat.i(217008);
    this.oWW.remove(paramg);
    Object localObject = com.tencent.mm.plugin.ball.ui.d.ciX();
    if (((com.tencent.mm.plugin.ball.ui.d)localObject).ciY())
    {
      localObject = ((com.tencent.mm.plugin.ball.ui.d)localObject).oYi;
      if (((com.tencent.mm.plugin.ball.ui.a)localObject).oXH != null) {
        ((com.tencent.mm.plugin.ball.ui.a)localObject).oXH.listeners.remove(paramg);
      }
    }
    AppMethodBeat.o(217008);
  }
  
  final void c(BallInfo paramBallInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(106127);
    BallInfo localBallInfo = h(paramBallInfo);
    if (localBallInfo != null)
    {
      localBallInfo.oWp = Util.nowMilliSecond();
      this.oXm = localBallInfo;
      Log.i("MicroMsg.FloatBallService", "onEnterBallInfoPage, set lastEnteredBallInfo:%s", new Object[] { this.oXm.cif() });
      jW(paramBoolean);
      AppMethodBeat.o(106127);
      return;
    }
    if (paramBallInfo != null) {}
    for (paramBallInfo = paramBallInfo.cif();; paramBallInfo = "null")
    {
      Log.i("MicroMsg.FloatBallService", "onEnterBallInfoPage, no this ball info:%s", new Object[] { paramBallInfo });
      AppMethodBeat.o(106127);
      return;
    }
  }
  
  public final boolean c(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184579);
    if (!com.tencent.mm.plugin.ball.ui.d.ciX().ciY())
    {
      Log.i("MicroMsg.FloatBallService", "updateBallVisibilityByPosition, no float ball");
      AppMethodBeat.o(184579);
      return false;
    }
    if (!this.oXk)
    {
      Log.i("MicroMsg.FloatBallService", "updateBallVisibilityByPosition keyboard not show and ignore");
      AppMethodBeat.o(184579);
      return false;
    }
    boolean bool = a(this.oXi, this.oXj, false, false, paramAnimatorListenerAdapter);
    AppMethodBeat.o(184579);
    return bool;
  }
  
  public final void chL()
  {
    AppMethodBeat.i(106105);
    Log.i("MicroMsg.FloatBallService", "onAccountInitialized:%s", new Object[] { Integer.valueOf(hashCode()) });
    a(com.tencent.mm.plugin.ball.ui.d.ciX());
    a(e.ciJ());
    this.oXb = false;
    a(true, true, null);
    AppMethodBeat.o(106105);
  }
  
  public final boolean chM()
  {
    return this.oXc;
  }
  
  public final boolean chN()
  {
    AppMethodBeat.i(216995);
    if (com.tencent.mm.plugin.ball.f.d.h(this.oVq))
    {
      Iterator localIterator = this.oVq.iterator();
      while (localIterator.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)localIterator.next();
        if ((!localBallInfo.nno) && ((com.tencent.mm.plugin.ball.f.d.H(localBallInfo)) || (com.tencent.mm.plugin.ball.f.d.I(localBallInfo))))
        {
          AppMethodBeat.o(216995);
          return true;
        }
      }
    }
    AppMethodBeat.o(216995);
    return false;
  }
  
  public final boolean chO()
  {
    return this.oXe;
  }
  
  public final void chP()
  {
    AppMethodBeat.i(106109);
    Dw(false);
    jV(false);
    if (this.oXm != null)
    {
      Log.i("MicroMsg.FloatBallService", "fixFloatBallIfNeed, lastEnteredBallInfo:%s", new Object[] { this.oXm });
      q(h(this.oXm));
      AppMethodBeat.o(106109);
      return;
    }
    Log.i("MicroMsg.FloatBallService", "fixFloatBallIfNeed, safe");
    AppMethodBeat.o(106109);
  }
  
  public final List<BallInfo> chQ()
  {
    return this.oVq;
  }
  
  public final List<BallInfo> chR()
  {
    return this.oWU;
  }
  
  public final Set<com.tencent.mm.plugin.ball.c.g> chS()
  {
    return this.oWW;
  }
  
  public final boolean chT()
  {
    AppMethodBeat.i(217009);
    Object localObject = com.tencent.mm.plugin.ball.ui.d.ciX();
    if (((com.tencent.mm.plugin.ball.ui.d)localObject).ciY())
    {
      localObject = ((com.tencent.mm.plugin.ball.ui.d)localObject).oYi;
      if (((com.tencent.mm.plugin.ball.ui.a)localObject).oXH != null)
      {
        bool = ((com.tencent.mm.plugin.ball.ui.a)localObject).oXH.pbC;
        AppMethodBeat.o(217009);
        return bool;
      }
      AppMethodBeat.o(217009);
      return false;
    }
    e.ciJ();
    boolean bool = e.ciM();
    AppMethodBeat.o(217009);
    return bool;
  }
  
  public final void chU()
  {
    this.oXl = null;
  }
  
  public final boolean chV()
  {
    return this.oXd;
  }
  
  public final void chW()
  {
    AppMethodBeat.i(184565);
    com.tencent.mm.plugin.ball.ui.d locald = com.tencent.mm.plugin.ball.ui.d.ciX();
    if (locald.ciY()) {
      locald.oYi.chW();
    }
    AppMethodBeat.o(184565);
  }
  
  public final void chX()
  {
    AppMethodBeat.i(184566);
    com.tencent.mm.plugin.ball.ui.d locald = com.tencent.mm.plugin.ball.ui.d.ciX();
    if (locald.ciY()) {
      locald.oYi.chX();
    }
    AppMethodBeat.o(184566);
  }
  
  public final void dn(View paramView)
  {
    this.oXl = paramView;
  }
  
  public final long fvY()
  {
    return this.oXh;
  }
  
  public final void fwa()
  {
    AppMethodBeat.i(106111);
    PlaySound.play(MMApplicationContext.getContext(), 2131768604);
    AppMethodBeat.o(106111);
  }
  
  public final Point getBallPosition()
  {
    AppMethodBeat.i(106121);
    Object localObject1 = com.tencent.mm.plugin.ball.ui.d.ciX();
    if (((com.tencent.mm.plugin.ball.ui.d)localObject1).ciY())
    {
      localObject1 = ((com.tencent.mm.plugin.ball.ui.d)localObject1).oYi;
      if (((com.tencent.mm.plugin.ball.ui.a)localObject1).oXH != null) {
        localObject1 = ((com.tencent.mm.plugin.ball.ui.a)localObject1).oXH.getBallPosition();
      }
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new Point(com.tencent.mm.plugin.ball.f.d.cjg(), com.tencent.mm.plugin.ball.f.d.cjh());
      }
      Log.i("MicroMsg.FloatBallService", "getBallPosition, position:[%s, %s]", new Object[] { Integer.valueOf(((Point)localObject2).x), Integer.valueOf(((Point)localObject2).y) });
      AppMethodBeat.o(106121);
      return localObject2;
      localObject1 = new Point(com.tencent.mm.plugin.ball.f.d.cjg(), com.tencent.mm.plugin.ball.f.d.cjh());
      continue;
      localObject1 = new Point(com.tencent.mm.plugin.ball.f.d.cjg(), com.tencent.mm.plugin.ball.f.d.cjh());
    }
  }
  
  public final BallInfo h(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106113);
    synchronized (this.oVq)
    {
      if (this.oVq.contains(paramBallInfo))
      {
        int i = this.oVq.indexOf(paramBallInfo);
        if ((i < 0) || (i >= this.oVq.size()))
        {
          AppMethodBeat.o(106113);
          return null;
        }
        paramBallInfo = (BallInfo)this.oVq.get(i);
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
    if (cip() >= 5)
    {
      Log.i("MicroMsg.FloatBallService", "canAddBallInfo, false");
      AppMethodBeat.o(106114);
      return false;
    }
    Log.i("MicroMsg.FloatBallService", "canAddBallInfo, true");
    AppMethodBeat.o(106114);
    return true;
  }
  
  public final void j(BallInfo paramBallInfo)
  {
    int j = 0;
    AppMethodBeat.i(106116);
    if ((paramBallInfo.type == 6) && (paramBallInfo.oWs.oWx == 11)) {}
    for (int i = 1; (i != 0) && (!com.tencent.mm.compatible.e.b.cx(MMApplicationContext.getContext())); i = 0)
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
      c.a(MMApplicationContext.getContext(), paramBallInfo.type, true, new d.4(this, paramBallInfo));
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
  
  public final void jL(boolean paramBoolean)
  {
    AppMethodBeat.i(106101);
    a(paramBoolean, null);
    AppMethodBeat.o(106101);
  }
  
  public final void jM(boolean paramBoolean)
  {
    AppMethodBeat.i(106102);
    a(paramBoolean, true, null);
    AppMethodBeat.o(106102);
  }
  
  public final void jN(boolean paramBoolean)
  {
    AppMethodBeat.i(106103);
    jV(true);
    a(paramBoolean, null);
    AppMethodBeat.o(106103);
  }
  
  public final void jO(boolean paramBoolean)
  {
    AppMethodBeat.i(106104);
    jV(false);
    a(paramBoolean, true, null);
    AppMethodBeat.o(106104);
  }
  
  public final void jP(boolean paramBoolean)
  {
    AppMethodBeat.i(216994);
    com.tencent.mm.plugin.ball.ui.d.ciX().c(paramBoolean, new d.1(this));
    AppMethodBeat.o(216994);
  }
  
  public final void jQ(boolean paramBoolean)
  {
    AppMethodBeat.i(176960);
    Log.i("MicroMsg.FloatBallService", "markWechatInForeground, foreground:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.oXg = paramBoolean;
    if (this.oXe)
    {
      Log.i("MicroMsg.FloatBallService", "markWechatInForeground, has marked QB file view page, mark Wechat in foreground");
      com.tencent.mm.plugin.ball.ui.d.ciX().jQ(true);
    }
    for (;;)
    {
      if (!this.oXg)
      {
        Log.i("MicroMsg.FloatBallService", "alvinluo resetReadyStatusBallInfo");
        this.oXa = null;
      }
      AppMethodBeat.o(176960);
      return;
      com.tencent.mm.plugin.ball.ui.d.ciX().jQ(paramBoolean);
    }
  }
  
  public final void jR(boolean paramBoolean)
  {
    AppMethodBeat.i(184564);
    com.tencent.mm.plugin.ball.ui.d locald = com.tencent.mm.plugin.ball.ui.d.ciX();
    if (locald.ciY()) {
      locald.oYi.oXK = paramBoolean;
    }
    AppMethodBeat.o(184564);
  }
  
  public final void jS(boolean paramBoolean)
  {
    AppMethodBeat.i(185124);
    Log.i("MicroMsg.FloatBallService", "markForceHideAllFloatBall %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.oXd = paramBoolean;
    com.tencent.mm.plugin.ball.ui.d.ciX().oXd = paramBoolean;
    AppMethodBeat.o(185124);
  }
  
  public final void k(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106118);
    BallInfo localBallInfo = h(paramBallInfo);
    if (localBallInfo != null)
    {
      localBallInfo.w(paramBallInfo);
      Log.i("MicroMsg.FloatBallService", "updateBallInfo, existed:true, ballInfo:%s", new Object[] { localBallInfo });
      ciH();
      AppMethodBeat.o(106118);
      return;
    }
    Log.i("MicroMsg.FloatBallService", "updateBallInfo, existed:false");
    AppMethodBeat.o(106118);
  }
  
  public final void l(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106119);
    if (this.oVq.contains(paramBallInfo))
    {
      if (com.tencent.mm.plugin.ball.f.d.H(paramBallInfo))
      {
        com.tencent.mm.plugin.ball.ui.d.ciX().ciS();
        paramBallInfo.vk = null;
      }
      this.oVq.remove(paramBallInfo);
      e.ciJ().l(paramBallInfo);
      b.b(paramBallInfo, this.oVq.isEmpty());
      Log.i("MicroMsg.FloatBallService", "removeBallInfo, existed:true, ballInfo:%s", new Object[] { paramBallInfo });
      if ((this.oXm != null) && (this.oXm.equals(paramBallInfo)))
      {
        Log.i("MicroMsg.FloatBallService", "removeBallInfo, remove last enteredBallInfo");
        this.oXm = null;
      }
      C(paramBallInfo);
      jW(true);
      b(paramBallInfo, 3);
      E(paramBallInfo);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).del(paramBallInfo.key);
      if (paramBallInfo.equals(this.oWZ))
      {
        this.oWZ = null;
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
    int i = paramBallInfo.oWs.opType;
    if ((i == 1) || (i == 2) || (i == 3)) {}
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        Log.w("MicroMsg.FloatBallReportLogic", "activeBallTypeReport unexpected opType:%d", new Object[] { Integer.valueOf(paramBallInfo.oWs.opType) });
        paramBallInfo.oWs.opType = 3;
      }
      b.a(paramBallInfo, Util.nowMilliSecond() - paramBallInfo.oWp, 0L, 0L, 0L);
      c(paramBallInfo, true);
      int j = paramBallInfo.type;
      i = j;
      if (j == 20) {
        i = paramBallInfo.beK;
      }
      Log.d("MicroMsg.FloatBallService", "alvinluo notifySingleBallInfoClicked type: %d, contentType: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramBallInfo.beK) });
      localObject = (Set)this.oWX.get(i);
      if (!com.tencent.mm.plugin.ball.f.d.h((Collection)localObject)) {
        break;
      }
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.plugin.ball.c.e)((Iterator)localObject).next()).b(paramBallInfo);
      }
    }
    Object localObject = (Set)this.oWX.get(0);
    if (com.tencent.mm.plugin.ball.f.d.h((Collection)localObject))
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
    if (this.oVq.contains(paramBallInfo))
    {
      Object localObject = (Set)this.oWX.get(paramBallInfo.type);
      if (com.tencent.mm.plugin.ball.f.d.h((Collection)localObject))
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((com.tencent.mm.plugin.ball.c.e)((Iterator)localObject).next()).d(paramBallInfo);
        }
      }
      localObject = (Set)this.oWX.get(0);
      if (com.tencent.mm.plugin.ball.f.d.h((Collection)localObject))
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
    AppMethodBeat.i(258575);
    c(paramBallInfo, true);
    AppMethodBeat.o(258575);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(106106);
    Log.i("MicroMsg.FloatBallService", "onAccountRelease:%s", new Object[] { Integer.valueOf(hashCode()) });
    b(com.tencent.mm.plugin.ball.ui.d.ciX());
    b(e.ciJ());
    this.oXb = false;
    com.tencent.mm.plugin.ball.ui.d.ciX().ciZ();
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
    if (this.oXm != null)
    {
      localObject = this.oXm.cif();
      Log.i("MicroMsg.FloatBallService", "onExitBallInfoPage, lastEnteredBallInfo:%s", new Object[] { localObject });
      this.oXm = null;
      localObject = h(paramBallInfo);
      if (localObject == null) {
        break label154;
      }
      Log.i("MicroMsg.FloatBallService", "onExitBallInfoPage, ballInfo:%s", new Object[] { localObject });
      if (((BallInfo)localObject).oWs.opType != -1) {
        break label139;
      }
      ((BallInfo)localObject).oWs.opType = 0;
      label87:
      if (com.tencent.mm.plugin.ball.ui.d.ciX().ciT()) {
        break label146;
      }
      if (!this.oXd) {
        a(paramBallInfo, 1.0F);
      }
    }
    for (;;)
    {
      if (!((BallInfo)localObject).nno) {
        break label167;
      }
      ((BallInfo)localObject).nno = false;
      ciH();
      AppMethodBeat.o(106128);
      return;
      localObject = "null";
      break;
      label139:
      b.y((BallInfo)localObject);
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
    AppMethodBeat.i(217000);
    if (paramBallInfo != null) {
      b.a(paramBallInfo, this.oVq);
    }
    AppMethodBeat.o(217000);
  }
  
  public final void s(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106135);
    String str;
    if (paramBallInfo != null)
    {
      str = paramBallInfo.cif();
      paramBallInfo = (ResultReceiver)this.oWY.remove(str);
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
    AppMethodBeat.i(216991);
    Object localObject = com.tencent.mm.plugin.ball.ui.d.ciX();
    if (((com.tencent.mm.plugin.ball.ui.d)localObject).ciY())
    {
      localObject = ((com.tencent.mm.plugin.ball.ui.d)localObject).oYi;
      if (((com.tencent.mm.plugin.ball.ui.a)localObject).oXH != null) {
        ((com.tencent.mm.plugin.ball.ui.a)localObject).oXH.setEnableClick(paramBoolean);
      }
    }
    AppMethodBeat.o(216991);
  }
  
  public final void t(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(216996);
    if (paramBallInfo == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.FloatBallService", "alvinluo markMessageBallInfo ballInfo == null: %b, %s, readyInfo == null: %b", new Object[] { Boolean.valueOf(bool), paramBallInfo, this.oXa });
      if (paramBallInfo != null)
      {
        if (this.oXa == null) {
          this.oXa = new BallInfo(20, paramBallInfo.key);
        }
        this.oXa.w(paramBallInfo);
        this.oXa.key = paramBallInfo.key;
        this.oXa.type = 20;
        this.oXa.state = 256;
        this.oXa.nno = false;
        this.oXa.oWr = true;
        this.oXa.crj = System.currentTimeMillis();
        if ((paramBallInfo.type == 4) && (this.oXa.jkf != null))
        {
          paramBallInfo = this.oXa.jkf.getString("processName");
          if (!Util.isNullOrNil(paramBallInfo))
          {
            Log.d("MicroMsg.FloatBallService", "markMessageBallInfo reset processName: %s", new Object[] { paramBallInfo });
            this.oXa.jkf.putString("processName", "");
          }
        }
      }
      AppMethodBeat.o(216996);
      return;
    }
  }
  
  public final void u(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(216993);
    BallInfo localBallInfo = ciC();
    Point localPoint1;
    Point localPoint2;
    label263:
    int j;
    if (localBallInfo != null)
    {
      localBallInfo.state = paramBallInfo.state;
      localBallInfo.oWt = paramBallInfo.oWt;
      paramBallInfo = com.tencent.mm.plugin.ball.ui.d.ciX().oYi;
      if (paramBallInfo.oXH != null)
      {
        paramBallInfo = paramBallInfo.oXH;
        Log.i("MicroMsg.FloatBallView", "alvinluo switchVoipVoice");
        if (localBallInfo.oWt == null)
        {
          Log.w("MicroMsg.FloatBallView", "switchVoip animationInfo invalid and ignore");
          AppMethodBeat.o(216993);
          return;
        }
        localPoint1 = new Point(localBallInfo.oWt.oWv);
        if (paramBallInfo.Cc(paramBallInfo.oZZ))
        {
          boolean bool1 = FloatBallView.Ch(paramBallInfo.oZZ);
          boolean bool2 = FloatBallView.Ck(paramBallInfo.oZZ);
          localPoint1.x = paramBallInfo.h(bool1, bool2, true);
          localPoint1.y = paramBallInfo.a(paramBallInfo.oZZ, bool1, bool2, true);
        }
        localPoint2 = new Point(localBallInfo.oWt.oWw);
        if (paramBallInfo.Cc(paramBallInfo.oZZ))
        {
          if (localBallInfo.state != 8) {
            break label263;
          }
          localPoint2.x = (FloatBallView.paE + FloatBallView.paQ * 2);
          localPoint2.y = (FloatBallView.paF + FloatBallView.paQ * 2);
        }
        while ((!FloatBallView.h(localPoint1)) || (!FloatBallView.h(localPoint2)))
        {
          Log.w("MicroMsg.FloatBallView", "switchVoip animationInfo size invalid and ignore");
          AppMethodBeat.o(216993);
          return;
          if (localBallInfo.state == 512)
          {
            i = FloatBallView.paA + FloatBallView.paQ * 2;
            if (localPoint2.x < i) {
              localPoint2.x = i;
            }
          }
        }
        paramBallInfo.pbQ = 80;
        j = paramBallInfo.pbQ;
        if (!paramBallInfo.pbC) {
          break label481;
        }
      }
    }
    label481:
    for (int i = 8388611;; i = 8388613)
    {
      paramBallInfo.X(i | j, true);
      FrameLayout localFrameLayout = paramBallInfo.paY;
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localFrameLayout.getLayoutParams();
      Log.i("MicroMsg.FloatBallView", "alvinluo animateVoipSwitch state: %d, startSize: %s, endSize: %s, current: %d, %d", new Object[] { Integer.valueOf(localBallInfo.state), localPoint1, localPoint2, Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator.setDuration(300L);
      localValueAnimator.addListener(new FloatBallView.6(paramBallInfo, localBallInfo, localPoint1, localPoint2));
      localValueAnimator.addUpdateListener(new FloatBallView.7(paramBallInfo, localLayoutParams, localPoint1, localPoint2, localFrameLayout));
      localValueAnimator.start();
      AppMethodBeat.o(216993);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.d
 * JD-Core Version:    0.7.0.1
 */