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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningApp;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.g.a;
import com.tencent.mm.plugin.ball.c.f;
import com.tencent.mm.plugin.ball.c.i;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallInfo.a;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.ball.ui.FloatBallProxyUI;
import com.tencent.mm.plugin.ball.ui.FloatBallProxyUI.a;
import com.tencent.mm.plugin.ball.view.FloatBallView;
import com.tencent.mm.plugin.ball.view.FloatBallView.5;
import com.tencent.mm.plugin.ball.view.FloatBallView.6;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bu;
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
  implements com.tencent.mm.kernel.c.b, g.a, com.tencent.mm.plugin.ball.c.c
{
  private static d nLZ;
  volatile int bjY;
  final List<BallInfo> nKv;
  private Set<com.tencent.mm.plugin.ball.c.e> nMa;
  private SparseArray<Set<f>> nMb;
  private Map<String, ResultReceiver> nMc;
  private volatile BallInfo nMd;
  private volatile BallInfo nMe;
  private volatile boolean nMf;
  volatile boolean nMg;
  volatile boolean nMh;
  volatile boolean nMi;
  private volatile boolean nMj;
  private volatile boolean nMk;
  private volatile long nMl;
  private volatile int nMm;
  private volatile int nMn;
  private volatile boolean nMo;
  private View nMp;
  private volatile BallInfo nMq;
  private int nMr;
  
  private d()
  {
    AppMethodBeat.i(106097);
    this.nKv = new Vector();
    this.nMa = new CopyOnWriteArraySet();
    this.nMb = new SparseArray();
    this.nMc = new ConcurrentHashMap();
    this.nMd = null;
    this.nMe = null;
    this.nMf = false;
    this.nMg = false;
    this.nMh = false;
    this.nMi = false;
    this.nMj = false;
    this.nMk = true;
    this.nMl = 0L;
    this.nMm = 0;
    this.nMn = 0;
    this.bjY = 0;
    this.nMo = false;
    this.nMq = null;
    this.nMr = -1;
    AppMethodBeat.o(106097);
  }
  
  private void A(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106117);
    if ((!paramBallInfo.nLu) && (bLQ() >= 5))
    {
      ae.i("MicroMsg.FloatBallService", "addBallInfo, already add max count balls:%s", new Object[] { Integer.valueOf(5) });
      FloatBallProxyUI.a(new FloatBallProxyUI.a()
      {
        public final void eH(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(209447);
          ae.i("MicroMsg.FloatBallService", "addBallInfo, show reach count limit callback:%s, proxyMode: %d", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1) });
          if (paramAnonymousInt2 == 1)
          {
            ae.i("MicroMsg.FloatBallService", "addBallInfo, show float menu view");
            d.bLR();
          }
          AppMethodBeat.o(209447);
        }
      });
      AppMethodBeat.o(106117);
      return;
    }
    if (!this.nKv.contains(paramBallInfo))
    {
      long l = bu.fpO();
      paramBallInfo.nLs = l;
      paramBallInfo.createTime = l;
      paramBallInfo.nLw.opType = -1;
      Object localObject;
      int i;
      if (paramBallInfo.type != 20)
      {
        localObject = paramBallInfo.nLw;
        if ((paramBallInfo.nLu) && (paramBallInfo.nLw.nLA == 0)) {
          i = 3;
        }
      }
      for (((BallReportInfo)localObject).nLA = i;; paramBallInfo.nLw.nLA = 5)
      {
        this.nKv.add(paramBallInfo);
        ae.i("MicroMsg.FloatBallService", "addBallInfo, existed:false, ballInfo:%s", new Object[] { paramBallInfo });
        if (!paramBallInfo.fLk) {
          b.a(paramBallInfo, this.nKv);
        }
        C(paramBallInfo);
        iY(true);
        localObject = new Bundle();
        ((Bundle)localObject).putInt("type", paramBallInfo.type);
        ((Bundle)localObject).putString("key", paramBallInfo.key);
        P((Bundle)localObject);
        E(paramBallInfo);
        ((com.tencent.mm.plugin.handoff.a.a)g.ab(com.tencent.mm.plugin.handoff.a.a.class)).L(paramBallInfo);
        AppMethodBeat.o(106117);
        return;
        i = paramBallInfo.nLw.nLA;
        break;
      }
    }
    ae.i("MicroMsg.FloatBallService", "addBallInfo, existed:true, replaceExisted: %b, ballInfo:%s", new Object[] { Boolean.valueOf(paramBallInfo.nLt), paramBallInfo });
    if (paramBallInfo.nLt)
    {
      paramBallInfo.nLt = false;
      l(paramBallInfo);
    }
    AppMethodBeat.o(106117);
  }
  
  private void B(final BallInfo paramBallInfo)
  {
    AppMethodBeat.i(209458);
    com.tencent.mm.plugin.ball.ui.d.bMh().c(true, new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(209448);
        super.onAnimationEnd(paramAnonymousAnimator);
        d.this.a(paramBallInfo, 1.0F);
        AppMethodBeat.o(209448);
      }
    });
    AppMethodBeat.o(209458);
  }
  
  private void C(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(209459);
    ae.d("MicroMsg.FloatBallService", "onFloatBallAdded %s", new Object[] { paramBallInfo });
    com.tencent.mm.plugin.ball.ui.d.bMh().a(this.nKv.size(), paramBallInfo);
    AppMethodBeat.o(209459);
  }
  
  private void D(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(209460);
    com.tencent.mm.plugin.ball.ui.d.bMh().b(this.nKv.size(), paramBallInfo);
    AppMethodBeat.o(209460);
  }
  
  private void E(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(209461);
    int j = this.nMb.size();
    int i = 0;
    while (i < j)
    {
      int k = this.nMb.keyAt(i);
      Object localObject = (Set)this.nMb.get(k);
      if (com.tencent.mm.plugin.ball.f.d.h((Collection)localObject))
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((f)((Iterator)localObject).next()).h(paramBallInfo);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(209461);
  }
  
  private void F(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106133);
    Object localObject = (Set)this.nMb.get(paramBallInfo.type);
    if (com.tencent.mm.plugin.ball.f.d.h((Collection)localObject))
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((f)((Iterator)localObject).next()).d(paramBallInfo);
      }
    }
    localObject = (Set)this.nMb.get(0);
    if (com.tencent.mm.plugin.ball.f.d.h((Collection)localObject))
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((f)((Iterator)localObject).next()).d(paramBallInfo);
      }
    }
    AppMethodBeat.o(106133);
  }
  
  private void G(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(209463);
    paramBallInfo = i(paramBallInfo);
    if ((paramBallInfo != null) && (paramBallInfo.nLu))
    {
      ae.i("MicroMsg.FloatBallService", "removeAppBrandPassiveBallInfo, remove existedBallInfo:%s", new Object[] { paramBallInfo });
      paramBallInfo.nLw.opType = 10;
      m(paramBallInfo);
    }
    AppMethodBeat.o(209463);
  }
  
  private void P(Bundle paramBundle)
  {
    AppMethodBeat.i(209462);
    Iterator localIterator = this.nMc.values().iterator();
    while (localIterator.hasNext()) {
      ((ResultReceiver)localIterator.next()).send(1, paramBundle);
    }
    AppMethodBeat.o(209462);
  }
  
  private void a(com.tencent.mm.plugin.ball.c.e parame)
  {
    AppMethodBeat.i(106138);
    this.nMa.add(parame);
    AppMethodBeat.o(106138);
  }
  
  private boolean a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184580);
    boolean bool = bLM();
    ae.i("MicroMsg.FloatBallService", "updateBallVisibilityByKbHeight isVoipShowing: %b", new Object[] { Boolean.valueOf(bool) });
    if ((bool) && (!this.nMo) && (this.nMj))
    {
      this.nMj = false;
      if ((this.nMp != null) && (this.nMp.getVisibility() != 0))
      {
        ae.d("MicroMsg.FloatBallService", "alvinluo updateBallVisibilityByKbHeight has voip but not visible and delay show animation");
        this.nMp.setVisibility(0);
        this.nMp.setAlpha(0.0F);
        a(true, false, paramAnimatorListenerAdapter);
        AppMethodBeat.o(184580);
        return true;
      }
      ae.d("MicroMsg.FloatBallService", "alvinluo updateBallVisibilityByKbHeight has voip and visible, not need to show");
      AppMethodBeat.o(184580);
      return false;
    }
    int j = bLT();
    int k = com.tencent.mm.plugin.ball.ui.d.bMh().getPositionY();
    int i;
    if (paramBoolean2)
    {
      i = paramInt2;
      if ((i + (k + j + paramInt1) < this.bjY) || (paramInt1 <= 0)) {
        break label284;
      }
    }
    label284:
    for (bool = true;; bool = false)
    {
      ae.i("MicroMsg.FloatBallService", "updateBallVisibilityByKbHeight, ballPositionY:[%s, %s], keyboardHeight:%s, screenHeight:%s, extraHeight: %d, hide: %b, checkBottomShadow: %b, checkExtraHeight: %b", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(this.bjY), Integer.valueOf(paramInt2), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      if (!bool) {
        break label290;
      }
      this.nMj = true;
      a(true, paramAnimatorListenerAdapter);
      AppMethodBeat.o(184580);
      return true;
      i = 0;
      break;
    }
    label290:
    if (this.nMj)
    {
      this.nMj = false;
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
    this.nMa.remove(parame);
    AppMethodBeat.o(106139);
  }
  
  private void b(BallInfo paramBallInfo, int paramInt)
  {
    AppMethodBeat.i(106136);
    paramBallInfo = paramBallInfo.bLl();
    ResultReceiver localResultReceiver = (ResultReceiver)this.nMc.get(paramBallInfo);
    if (localResultReceiver != null)
    {
      ae.i("MicroMsg.FloatBallService", "notifyResultReceiver, event:%s, ballInfoHashKey:%s, receiver:%s", new Object[] { Integer.valueOf(paramInt), paramBallInfo, Integer.valueOf(localResultReceiver.hashCode()) });
      localResultReceiver.send(paramInt, new Bundle());
    }
    AppMethodBeat.o(106136);
  }
  
  /* Error */
  public static d bLK()
  {
    // Byte code:
    //   0: ldc_w 433
    //   3: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 435	com/tencent/mm/plugin/ball/service/d:nLZ	Lcom/tencent/mm/plugin/ball/service/d;
    //   12: ifnonnull +19 -> 31
    //   15: ldc 2
    //   17: monitorenter
    //   18: new 2	com/tencent/mm/plugin/ball/service/d
    //   21: dup
    //   22: invokespecial 436	com/tencent/mm/plugin/ball/service/d:<init>	()V
    //   25: putstatic 435	com/tencent/mm/plugin/ball/service/d:nLZ	Lcom/tencent/mm/plugin/ball/service/d;
    //   28: ldc 2
    //   30: monitorexit
    //   31: ldc 2
    //   33: monitorexit
    //   34: getstatic 435	com/tencent/mm/plugin/ball/service/d:nLZ	Lcom/tencent/mm/plugin/ball/service/d;
    //   37: astore_0
    //   38: ldc_w 433
    //   41: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aload_0
    //   45: areturn
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: ldc_w 433
    //   53: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aload_0
    //   57: athrow
    //   58: astore_0
    //   59: ldc 2
    //   61: monitorexit
    //   62: ldc_w 433
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
  
  private BallInfo bLL()
  {
    AppMethodBeat.i(184568);
    if (com.tencent.mm.plugin.ball.f.d.h(this.nKv))
    {
      Iterator localIterator = this.nKv.iterator();
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
  
  private boolean bLM()
  {
    AppMethodBeat.i(184575);
    if ((xW(9)) || (xW(17)))
    {
      AppMethodBeat.o(184575);
      return true;
    }
    AppMethodBeat.o(184575);
    return false;
  }
  
  private void bLN()
  {
    AppMethodBeat.i(184571);
    BallInfo localBallInfo;
    if (com.tencent.mm.plugin.ball.f.d.h(this.nKv))
    {
      Iterator localIterator = this.nKv.iterator();
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
        ae.i("MicroMsg.FloatBallService", "removeLocationBackgroundBallInfoIfNeed, removed");
        m(localBallInfo);
        AppMethodBeat.o(184571);
        return;
      }
      ae.i("MicroMsg.FloatBallService", "removeLocationBackgroundBallInfoIfNeed, ignore");
      AppMethodBeat.o(184571);
      return;
      localBallInfo = null;
    }
  }
  
  private void bLO()
  {
    AppMethodBeat.i(184572);
    if (g.ajM())
    {
      e.bLU();
      List localList = e.bLX();
      bN(localList);
      this.nKv.clear();
      this.nKv.addAll(localList);
      this.nMf = true;
      ar.o(new Runnable()
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
    ae.i("MicroMsg.FloatBallService", "restoreDataFromStorage, account not ready");
    AppMethodBeat.o(184572);
  }
  
  private boolean bLP()
  {
    AppMethodBeat.i(184574);
    BallInfo localBallInfo = i(this.nMq);
    if ((localBallInfo != null) && (com.tencent.mm.plugin.ball.f.d.h(this.nKv)))
    {
      boolean bool = com.tencent.mm.plugin.ball.f.d.f(this.nKv, localBallInfo);
      AppMethodBeat.o(184574);
      return bool;
    }
    AppMethodBeat.o(184574);
    return false;
  }
  
  private int bLQ()
  {
    AppMethodBeat.i(106115);
    List localList = com.tencent.mm.plugin.ball.f.d.bS(this.nKv);
    if (com.tencent.mm.plugin.ball.f.d.h(localList))
    {
      int i = localList.size();
      AppMethodBeat.o(106115);
      return i;
    }
    AppMethodBeat.o(106115);
    return 0;
  }
  
  public static void bLR()
  {
    AppMethodBeat.i(106123);
    com.tencent.mm.plugin.ball.ui.d.bMh().a(false, null);
    AppMethodBeat.o(106123);
  }
  
  private void bLS()
  {
    AppMethodBeat.i(106140);
    List localList = com.tencent.mm.plugin.ball.f.d.bP(new Vector(this.nKv));
    ae.i("MicroMsg.FloatBallService", "notifyFloatBallInfoChanged, originSize: %d, sortedSize: %d, ballInfoList:%s", new Object[] { Integer.valueOf(this.nKv.size()), Integer.valueOf(localList.size()), localList });
    Iterator localIterator = this.nMa.iterator();
    while (localIterator.hasNext())
    {
      ((com.tencent.mm.plugin.ball.c.e)localIterator.next()).a(localList, this.nMq);
      bO(localList);
    }
    AppMethodBeat.o(106140);
  }
  
  private int bLT()
  {
    AppMethodBeat.i(184581);
    int j = com.tencent.mm.plugin.ball.f.e.nNP + com.tencent.mm.plugin.ball.f.e.nNQ + com.tencent.mm.plugin.ball.f.e.nNR;
    int i = j;
    if (this.nMp != null) {
      i = Math.max(this.nMp.getMeasuredHeight(), j);
    }
    AppMethodBeat.o(184581);
    return i;
  }
  
  private static void bN(List<BallInfo> paramList)
  {
    AppMethodBeat.i(184573);
    ae.i("MicroMsg.FloatBallService", "restoreProcessNameWithFileType");
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(184573);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BallInfo localBallInfo = (BallInfo)paramList.next();
      if ((localBallInfo != null) && (localBallInfo.type == 4) && (localBallInfo.ioY != null))
      {
        String str = localBallInfo.ioY.getString("processName");
        if (!bu.isNullOrNil(str))
        {
          ae.i("MicroMsg.FloatBallService", "restore with process name: %s", new Object[] { str });
          localBallInfo.ioY.putString("processName", "");
        }
      }
    }
    AppMethodBeat.o(184573);
  }
  
  private void bO(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106137);
    if (!this.nMc.isEmpty())
    {
      int i = com.tencent.mm.plugin.ball.f.d.bS(paramList).size();
      if (this.nMr != i)
      {
        this.nMr = i;
        paramList = new Bundle();
        paramList.putInt("ActiveCount", i);
        Iterator localIterator = this.nMc.values().iterator();
        while (localIterator.hasNext()) {
          ((ResultReceiver)localIterator.next()).send(5, paramList);
        }
      }
    }
    AppMethodBeat.o(106137);
  }
  
  private void iX(boolean paramBoolean)
  {
    AppMethodBeat.i(106107);
    ae.i("MicroMsg.FloatBallService", "markNoFloatBallPage:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.nMg = paramBoolean;
    AppMethodBeat.o(106107);
  }
  
  private void iY(boolean paramBoolean)
  {
    AppMethodBeat.i(106129);
    Object localObject = i(this.nMq);
    if ((localObject != null) && (com.tencent.mm.plugin.ball.f.d.h(this.nKv)))
    {
      if (com.tencent.mm.plugin.ball.f.d.e(this.nKv, (BallInfo)localObject))
      {
        ae.i("MicroMsg.FloatBallService", "recheckBallInfoList, has other balls, hidden current ball info");
        boolean bool = com.tencent.mm.plugin.ball.ui.d.bMh().bMd();
        ae.i("MicroMsg.FloatBallService", "recheckBallInfoList, canNotShowFloatBall:%s, withFloatBall:%s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
        if ((!bool) && (paramBoolean)) {
          a((BallInfo)localObject, 1.0F);
        }
        Iterator localIterator = this.nKv.iterator();
        while (localIterator.hasNext())
        {
          BallInfo localBallInfo = (BallInfo)localIterator.next();
          if ((!localBallInfo.nLu) && (localBallInfo.nLv) && (!localBallInfo.equals(localObject)))
          {
            localBallInfo.nLv = false;
            b(localBallInfo, 4);
          }
          else if (localBallInfo.equals(localObject))
          {
            localBallInfo.nLv = true;
          }
        }
      }
      if (com.tencent.mm.plugin.ball.f.d.f(this.nKv, (BallInfo)localObject))
      {
        ae.i("MicroMsg.FloatBallService", "recheckBallInfoList, no other balls, make float ball transparent");
        ((BallInfo)localObject).nLv = false;
        a((BallInfo)localObject, 0.0F);
      }
      bLS();
      AppMethodBeat.o(106129);
      return;
    }
    if (this.nMq != null) {}
    for (localObject = this.nMq.bLl();; localObject = "null")
    {
      ae.i("MicroMsg.FloatBallService", "recheckBallInfoList, last enteredBallInfo:%s", new Object[] { localObject });
      break;
    }
  }
  
  public final void a(final int paramInt1, final int paramInt2, boolean paramBoolean, long paramLong)
  {
    boolean bool = false;
    AppMethodBeat.i(184577);
    this.nMm = paramInt1;
    this.nMn = paramInt2;
    this.nMo = paramBoolean;
    if (!com.tencent.mm.plugin.ball.ui.d.bMh().bMi())
    {
      ae.i("MicroMsg.FloatBallService", "KeyboardHeightChanged, no float ball");
      AppMethodBeat.o(184577);
      return;
    }
    if (paramBoolean) {
      iU(true);
    }
    while (paramLong != 0L)
    {
      ar.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(209445);
          d locald = d.this;
          int i = paramInt1;
          int j = paramInt2;
          if (d.b(d.this) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            d.a(locald, i, j, bool);
            AppMethodBeat.o(209445);
            return;
          }
        }
      }, paramLong);
      AppMethodBeat.o(184577);
      return;
      iU(false);
    }
    paramBoolean = bool;
    if (this.nMm != 0) {
      paramBoolean = true;
    }
    a(paramInt1, paramInt2, true, paramBoolean, null);
    AppMethodBeat.o(184577);
  }
  
  public final void a(int paramInt, f paramf)
  {
    AppMethodBeat.i(106131);
    ae.i("MicroMsg.FloatBallService", "addFloatBallInfoEventListener, type:%s", new Object[] { Integer.valueOf(paramInt) });
    if (paramf != null)
    {
      Set localSet = (Set)this.nMb.get(paramInt);
      Object localObject = localSet;
      if (localSet == null)
      {
        localObject = new HashSet();
        this.nMb.put(paramInt, localObject);
      }
      ((Set)localObject).add(paramf);
    }
    AppMethodBeat.o(106131);
  }
  
  public final void a(long paramLong, com.tencent.mm.plugin.ball.c.c.a parama)
  {
    int i = 1;
    AppMethodBeat.i(209453);
    if (this.nMe == null)
    {
      ae.w("MicroMsg.FloatBallService", "alvinluo addMessageBall readyMessageBallInfo is invalid");
      if (parama != null) {
        parama.xZ(7);
      }
      AppMethodBeat.o(209453);
      return;
    }
    if ((!this.nMk) && (!this.nMi))
    {
      ae.w("MicroMsg.FloatBallService", "alvinluo addMessageBall isWechatForeground: %b", new Object[] { Boolean.valueOf(this.nMk) });
      if (parama != null) {
        parama.xZ(6);
      }
      this.nMe = null;
      AppMethodBeat.o(209453);
      return;
    }
    if (!com.tencent.mm.plugin.ball.f.d.a(this.nMe, paramLong))
    {
      ae.w("MicroMsg.FloatBallService", "alvinluo addMessageBall can not add message ball because of time over limit");
      if (parama != null) {
        parama.xZ(5);
      }
      this.nMe = null;
      AppMethodBeat.o(209453);
      return;
    }
    if (this.nMd == null)
    {
      this.nMd = new BallInfo(20, this.nMe.key);
      this.nMd.x(this.nMe);
      ae.i("MicroMsg.FloatBallService", "alvinluo addMessageBall existed: false, and add: %s", new Object[] { this.nMd });
      k(this.nMd);
      this.nMe = null;
      if (parama != null) {
        parama.xZ(i);
      }
      AppMethodBeat.o(209453);
      return;
    }
    BallInfo localBallInfo = this.nMe;
    if (this.nMd == null) {
      ae.w("MicroMsg.FloatBallService", "alvinluo updateMessageBall messageBallInfo is null and ignore");
    }
    for (;;)
    {
      if ((this.nMd != null) && (!this.nMd.fLk))
      {
        this.nMd.nLw.nLA = 6;
        b.a(this.nMd, this.nKv);
      }
      i = 2;
      break;
      if (i(this.nMd) != null)
      {
        this.nMd.x(localBallInfo);
        this.nMd.key = localBallInfo.key;
        ae.i("MicroMsg.FloatBallService", "alvinluo updateMessageBall existed: true, and update %s", new Object[] { this.nMd });
        l(this.nMd);
      }
      else
      {
        ae.w("MicroMsg.FloatBallService", "alvinluo updateMessageBall messageBallInfo not null but not added!!");
      }
    }
  }
  
  public final void a(ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(209455);
    com.tencent.mm.plugin.ball.ui.d.bMh().a(true, paramResultReceiver);
    AppMethodBeat.o(209455);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(106112);
    if (parami != null)
    {
      if (com.tencent.mm.plugin.ball.f.d.h(this.nKv))
      {
        parami.bq(new ArrayList(this.nKv));
        AppMethodBeat.o(106112);
        return;
      }
      parami.bq(new ArrayList());
    }
    AppMethodBeat.o(106112);
  }
  
  public final void a(BallInfo paramBallInfo, float paramFloat)
  {
    AppMethodBeat.i(106122);
    if ((paramFloat == 1.0F) || (com.tencent.mm.plugin.ball.f.d.f(this.nKv, paramBallInfo))) {
      ar.f(new com.tencent.mm.plugin.ball.ui.d.2(com.tencent.mm.plugin.ball.ui.d.bMh(), paramFloat));
    }
    AppMethodBeat.o(106122);
  }
  
  public final void a(BallInfo paramBallInfo, ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(106134);
    if ((paramBallInfo != null) && (paramResultReceiver != null))
    {
      paramBallInfo = paramBallInfo.bLl();
      ae.i("MicroMsg.FloatBallService", "registerFloatBallEventReceiver, key:%s, receiver:%s", new Object[] { paramBallInfo, Integer.valueOf(paramResultReceiver.hashCode()) });
      this.nMc.put(paramBallInfo, paramResultReceiver);
    }
    AppMethodBeat.o(106134);
  }
  
  public final void a(BallInfo paramBallInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(106130);
    paramBallInfo = i(paramBallInfo);
    if (paramBallInfo != null)
    {
      if (!paramBoolean) {}
      for (boolean bool = true;; bool = false)
      {
        paramBallInfo.nLv = bool;
        ae.i("MicroMsg.FloatBallService", "updateBallVisibility, existed:true, visible:%s, ballInfo:%s", new Object[] { Boolean.valueOf(paramBoolean), paramBallInfo });
        bLS();
        AppMethodBeat.o(106130);
        return;
      }
    }
    ae.i("MicroMsg.FloatBallService", "updateBallVisibility, existed:false");
    AppMethodBeat.o(106130);
  }
  
  public final void a(List<AppBrandBackgroundRunningApp> paramList, AppBrandBackgroundRunningOperationParcel paramAppBrandBackgroundRunningOperationParcel, int paramInt)
  {
    AppMethodBeat.i(106141);
    ae.i("MicroMsg.FloatBallService", "onBackgroundRunningAppChanged, operation:%s, change:%s", new Object[] { paramAppBrandBackgroundRunningOperationParcel, Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      AppMethodBeat.o(106141);
      return;
    }
    if ((paramAppBrandBackgroundRunningOperationParcel.dlO == 2) || (paramAppBrandBackgroundRunningOperationParcel.dlO == 3))
    {
      if ((paramAppBrandBackgroundRunningOperationParcel.beO & 0x2) > 0) {
        G(new BallInfo(7, com.tencent.mm.plugin.ball.f.b.cu(paramAppBrandBackgroundRunningOperationParcel.appId, paramAppBrandBackgroundRunningOperationParcel.hSZ)));
      }
      if ((paramAppBrandBackgroundRunningOperationParcel.beO & 0x4) > 0)
      {
        paramList = paramAppBrandBackgroundRunningOperationParcel.appId;
        paramInt = paramAppBrandBackgroundRunningOperationParcel.hSZ;
        G(new BallInfo(17, String.format(Locale.US, "%s#%d", new Object[] { paramList, Integer.valueOf(paramInt) })));
      }
      if ((paramAppBrandBackgroundRunningOperationParcel.beO & 0x8) > 0) {
        G(new BallInfo(18, com.tencent.mm.plugin.ball.f.b.ct(paramAppBrandBackgroundRunningOperationParcel.appId, paramAppBrandBackgroundRunningOperationParcel.hSZ)));
      }
      if ((paramAppBrandBackgroundRunningOperationParcel.beO & 0x10) > 0) {
        G(new BallInfo(19, com.tencent.mm.plugin.ball.f.b.ct(paramAppBrandBackgroundRunningOperationParcel.appId, paramAppBrandBackgroundRunningOperationParcel.hSZ)));
      }
      AppMethodBeat.o(106141);
      return;
    }
    ae.i("MicroMsg.FloatBallService", "onBackgroundRunningAppChanged, operation ignored");
    AppMethodBeat.o(106141);
  }
  
  public final void a(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184567);
    if (this.nMi)
    {
      ae.i("MicroMsg.FloatBallService", "hideFloatBall, has marked QB file view page, ignore hiding");
      AppMethodBeat.o(184567);
      return;
    }
    if ((bLM()) && (!this.nMh)) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.FloatBallService", "hideFloatBall forceHide: %b, canShowFloatBall: %b, voipInfo: %s", new Object[] { Boolean.valueOf(this.nMh), Boolean.valueOf(bool), bLL() });
      if (!bool) {
        break;
      }
      AppMethodBeat.o(184567);
      return;
    }
    com.tencent.mm.plugin.ball.ui.d.bMh().e(paramBoolean, paramAnimatorListenerAdapter);
    AppMethodBeat.o(184567);
  }
  
  final void a(boolean paramBoolean1, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184570);
    if (!com.tencent.mm.compatible.d.b.cc(ak.getContext()))
    {
      ae.i("MicroMsg.FloatBallService", "resumeFloatBall, no float window permission");
      bLN();
      com.tencent.mm.plugin.ball.ui.d.bMh().bMj();
      this.nMf = false;
      this.nKv.clear();
      e.bLU().clear();
      bLS();
      AppMethodBeat.o(184570);
      return;
    }
    if (this.nMf)
    {
      if ((this.nMg) && (!bLM()))
      {
        ae.i("MicroMsg.FloatBallService", "resumeFloatBall, has marked no float ball page, ignore resuming");
        AppMethodBeat.o(184570);
        return;
      }
      if (this.nMh)
      {
        ae.i("MicroMsg.FloatBallService", "resumeFloatBall, has marked forceHideAllFloatBall, ignore resuming");
        AppMethodBeat.o(184570);
        return;
      }
      if (this.nMj)
      {
        ae.i("MicroMsg.FloatBallService", "resumeFloatBall, hasHideForKeyboardHeightChange, ignore resuming");
        AppMethodBeat.o(184570);
        return;
      }
      if (!bLP())
      {
        ae.i("MicroMsg.FloatBallService", "resumeFloatBall not singleBallInfoCondition, withAnimation:%s", new Object[] { Boolean.valueOf(paramBoolean1) });
        com.tencent.mm.plugin.ball.ui.d.bMh().b(paramBoolean1, paramBoolean2, paramAnimatorListenerAdapter);
        AppMethodBeat.o(184570);
        return;
      }
      ae.i("MicroMsg.FloatBallService", "resumeFloatBall singleBallInfoCondition, withAnimation:false");
      com.tencent.mm.plugin.ball.ui.d.bMh().b(false, paramBoolean2, paramAnimatorListenerAdapter);
      c(this.nMq, true);
      AppMethodBeat.o(184570);
      return;
    }
    ae.i("MicroMsg.FloatBallService", "resumeFloatBall, restore data from storage");
    bLO();
    AppMethodBeat.o(184570);
  }
  
  public final void akM()
  {
    AppMethodBeat.i(106099);
    ae.i("MicroMsg.FloatBallService", "onRegister:%s", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(106099);
  }
  
  public final void akN()
  {
    AppMethodBeat.i(106100);
    ae.i("MicroMsg.FloatBallService", "onUnregister:%s", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(106100);
  }
  
  public final void b(int paramInt, f paramf)
  {
    AppMethodBeat.i(106132);
    ae.i("MicroMsg.FloatBallService", "removeFloatBallInfoEventListener, type:%s", new Object[] { Integer.valueOf(paramInt) });
    if (paramf != null)
    {
      Set localSet = (Set)this.nMb.get(paramInt);
      if (localSet != null) {
        localSet.remove(paramf);
      }
    }
    AppMethodBeat.o(106132);
  }
  
  public final void bKT()
  {
    AppMethodBeat.i(106105);
    ae.i("MicroMsg.FloatBallService", "onAccountInitialized:%s", new Object[] { Integer.valueOf(hashCode()) });
    a(com.tencent.mm.plugin.ball.ui.d.bMh());
    a(e.bLU());
    this.nMf = false;
    a(true, true, null);
    AppMethodBeat.o(106105);
  }
  
  public final boolean bKU()
  {
    return this.nMg;
  }
  
  public final boolean bKV()
  {
    return this.nMi;
  }
  
  public final long bKW()
  {
    return this.nMl;
  }
  
  public final void bKX()
  {
    AppMethodBeat.i(106109);
    iS(false);
    iX(false);
    if (this.nMq != null)
    {
      ae.i("MicroMsg.FloatBallService", "fixFloatBallIfNeed, lastEnteredBallInfo:%s", new Object[] { this.nMq });
      r(i(this.nMq));
      AppMethodBeat.o(106109);
      return;
    }
    ae.i("MicroMsg.FloatBallService", "fixFloatBallIfNeed, safe");
    AppMethodBeat.o(106109);
  }
  
  public final void bKY()
  {
    AppMethodBeat.i(106111);
    be.aI(ak.getContext(), 2131766133);
    AppMethodBeat.o(106111);
  }
  
  public final List<BallInfo> bKZ()
  {
    return this.nKv;
  }
  
  public final void bLa()
  {
    this.nMp = null;
  }
  
  public final boolean bLb()
  {
    return this.nMh;
  }
  
  public final void bLc()
  {
    AppMethodBeat.i(184565);
    com.tencent.mm.plugin.ball.ui.d locald = com.tencent.mm.plugin.ball.ui.d.bMh();
    if (locald.bMi()) {
      locald.nNm.bLc();
    }
    AppMethodBeat.o(184565);
  }
  
  public final void bLd()
  {
    AppMethodBeat.i(184566);
    com.tencent.mm.plugin.ball.ui.d locald = com.tencent.mm.plugin.ball.ui.d.bMh();
    if (locald.bMi()) {
      locald.nNm.bLd();
    }
    AppMethodBeat.o(184566);
  }
  
  final void c(BallInfo paramBallInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(106127);
    BallInfo localBallInfo = i(paramBallInfo);
    if (localBallInfo != null)
    {
      localBallInfo.nLs = bu.fpO();
      this.nMq = localBallInfo;
      ae.i("MicroMsg.FloatBallService", "onEnterBallInfoPage, set lastEnteredBallInfo:%s", new Object[] { this.nMq.bLl() });
      iY(paramBoolean);
      AppMethodBeat.o(106127);
      return;
    }
    if (paramBallInfo != null) {}
    for (paramBallInfo = paramBallInfo.bLl();; paramBallInfo = "null")
    {
      ae.i("MicroMsg.FloatBallService", "onEnterBallInfoPage, no this ball info:%s", new Object[] { paramBallInfo });
      AppMethodBeat.o(106127);
      return;
    }
  }
  
  public final boolean c(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184579);
    if (!com.tencent.mm.plugin.ball.ui.d.bMh().bMi())
    {
      ae.i("MicroMsg.FloatBallService", "updateBallVisibilityByPosition, no float ball");
      AppMethodBeat.o(184579);
      return false;
    }
    if (!this.nMo)
    {
      ae.i("MicroMsg.FloatBallService", "updateBallVisibilityByPosition keyboard not show and ignore");
      AppMethodBeat.o(184579);
      return false;
    }
    boolean bool = a(this.nMm, this.nMn, false, false, paramAnimatorListenerAdapter);
    AppMethodBeat.o(184579);
    return bool;
  }
  
  public final void dw(View paramView)
  {
    this.nMp = paramView;
  }
  
  public final Point getBallPosition()
  {
    AppMethodBeat.i(106121);
    Object localObject1 = com.tencent.mm.plugin.ball.ui.d.bMh();
    if (((com.tencent.mm.plugin.ball.ui.d)localObject1).bMi())
    {
      localObject1 = ((com.tencent.mm.plugin.ball.ui.d)localObject1).nNm;
      if (((com.tencent.mm.plugin.ball.ui.a)localObject1).nML != null) {
        localObject1 = ((com.tencent.mm.plugin.ball.ui.a)localObject1).nML.getBallPosition();
      }
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new Point(com.tencent.mm.plugin.ball.f.d.bMq(), com.tencent.mm.plugin.ball.f.d.bMr());
      }
      ae.i("MicroMsg.FloatBallService", "getBallPosition, position:[%s, %s]", new Object[] { Integer.valueOf(((Point)localObject2).x), Integer.valueOf(((Point)localObject2).y) });
      AppMethodBeat.o(106121);
      return localObject2;
      localObject1 = new Point(com.tencent.mm.plugin.ball.f.d.bMq(), com.tencent.mm.plugin.ball.f.d.bMr());
      continue;
      localObject1 = new Point(com.tencent.mm.plugin.ball.f.d.bMq(), com.tencent.mm.plugin.ball.f.d.bMr());
    }
  }
  
  public final BallInfo i(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106113);
    synchronized (this.nKv)
    {
      if (this.nKv.contains(paramBallInfo))
      {
        paramBallInfo = (BallInfo)this.nKv.get(this.nKv.indexOf(paramBallInfo));
        ae.i("MicroMsg.FloatBallService", "getBallInfo, existed:true, responseBallInfo:%s", new Object[] { paramBallInfo });
        AppMethodBeat.o(106113);
        return paramBallInfo;
      }
      ae.i("MicroMsg.FloatBallService", "getBallInfo, existed:false");
      AppMethodBeat.o(106113);
      return null;
    }
  }
  
  public final void iM(boolean paramBoolean)
  {
    AppMethodBeat.i(106101);
    a(paramBoolean, null);
    AppMethodBeat.o(106101);
  }
  
  public final void iN(boolean paramBoolean)
  {
    AppMethodBeat.i(106102);
    a(paramBoolean, true, null);
    AppMethodBeat.o(106102);
  }
  
  public final void iO(boolean paramBoolean)
  {
    AppMethodBeat.i(106103);
    iX(true);
    a(paramBoolean, null);
    AppMethodBeat.o(106103);
  }
  
  public final void iP(boolean paramBoolean)
  {
    AppMethodBeat.i(106104);
    iX(false);
    a(paramBoolean, true, null);
    AppMethodBeat.o(106104);
  }
  
  public final void iQ(boolean paramBoolean)
  {
    AppMethodBeat.i(209451);
    com.tencent.mm.plugin.ball.ui.d.bMh().c(paramBoolean, new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(209444);
        super.onAnimationEnd(paramAnonymousAnimator);
        d.this.a(null, 1.0F);
        AppMethodBeat.o(209444);
      }
    });
    AppMethodBeat.o(209451);
  }
  
  public final void iR(boolean paramBoolean)
  {
    AppMethodBeat.i(176960);
    ae.i("MicroMsg.FloatBallService", "markWechatInForeground, foreground:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.nMk = paramBoolean;
    if (this.nMi)
    {
      ae.i("MicroMsg.FloatBallService", "markWechatInForeground, has marked QB file view page, mark Wechat in foreground");
      com.tencent.mm.plugin.ball.ui.d.bMh().iR(true);
    }
    for (;;)
    {
      if (!this.nMk)
      {
        ae.i("MicroMsg.FloatBallService", "alvinluo resetReadyStatusBallInfo");
        this.nMe = null;
      }
      AppMethodBeat.o(176960);
      return;
      com.tencent.mm.plugin.ball.ui.d.bMh().iR(paramBoolean);
    }
  }
  
  public final void iS(boolean paramBoolean)
  {
    AppMethodBeat.i(106108);
    ae.i("MicroMsg.FloatBallService", "markQBFileViewPage:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.nMi = paramBoolean;
    AppMethodBeat.o(106108);
  }
  
  public final void iT(boolean paramBoolean)
  {
    AppMethodBeat.i(184564);
    com.tencent.mm.plugin.ball.ui.d locald = com.tencent.mm.plugin.ball.ui.d.bMh();
    if (locald.bMi()) {
      locald.nNm.nMO = paramBoolean;
    }
    AppMethodBeat.o(184564);
  }
  
  public final void iU(boolean paramBoolean)
  {
    AppMethodBeat.i(185124);
    ae.i("MicroMsg.FloatBallService", "markForceHideAllFloatBall %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.nMh = paramBoolean;
    com.tencent.mm.plugin.ball.ui.d.bMh().nMh = paramBoolean;
    AppMethodBeat.o(185124);
  }
  
  public final boolean j(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106114);
    if (bLQ() >= 5)
    {
      ae.i("MicroMsg.FloatBallService", "canAddBallInfo, false");
      AppMethodBeat.o(106114);
      return false;
    }
    ae.i("MicroMsg.FloatBallService", "canAddBallInfo, true");
    AppMethodBeat.o(106114);
    return true;
  }
  
  public final void k(final BallInfo paramBallInfo)
  {
    int j = 0;
    AppMethodBeat.i(106116);
    if ((paramBallInfo.type == 6) && (paramBallInfo.nLw.nLB == 11)) {}
    for (int i = 1; (i != 0) && (!com.tencent.mm.compatible.d.b.cc(ak.getContext())); i = 0)
    {
      ae.i("MicroMsg.FloatBallService", "isAskForPermissionAlready, no permission & no ask for");
      AppMethodBeat.o(106116);
      return;
    }
    i = paramBallInfo.type;
    if (i == 7)
    {
      ae.i("MicroMsg.FloatBallService", "shouldCheckPermissionWhenAddBallInfo, ignore for ballType: location");
      i = j;
    }
    while (i != 0)
    {
      com.tencent.mm.plugin.ball.f.c.a(ak.getContext(), paramBallInfo.type, true, new com.tencent.mm.plugin.ball.f.c.a()
      {
        public final void gd(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(209446);
          if (paramAnonymousBoolean)
          {
            d.a(d.this, paramBallInfo);
            AppMethodBeat.o(209446);
            return;
          }
          ae.w("MicroMsg.FloatBallService", "no float window permission");
          AppMethodBeat.o(209446);
        }
      });
      AppMethodBeat.o(106116);
      return;
      if (i == 17)
      {
        ae.i("MicroMsg.FloatBallService", "shouldCheckPermissionWhenAddBallInfo, ignore for ballType: appbrand_voip");
        i = j;
      }
      else if (i == 18)
      {
        ae.i("MicroMsg.FloatBallService", "shouldCheckPermissionWhenAddBallInfo, ignore for ballType: audio_of_video_background_play");
        i = j;
      }
      else
      {
        i = 1;
      }
    }
    A(paramBallInfo);
    AppMethodBeat.o(106116);
  }
  
  public final void l(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106118);
    BallInfo localBallInfo = i(paramBallInfo);
    if (localBallInfo != null)
    {
      localBallInfo.x(paramBallInfo);
      ae.i("MicroMsg.FloatBallService", "updateBallInfo, existed:true, ballInfo:%s", new Object[] { localBallInfo });
      bLS();
      AppMethodBeat.o(106118);
      return;
    }
    ae.i("MicroMsg.FloatBallService", "updateBallInfo, existed:false");
    AppMethodBeat.o(106118);
  }
  
  public final void m(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106119);
    if (this.nKv.contains(paramBallInfo))
    {
      if (paramBallInfo.type == 9)
      {
        com.tencent.mm.plugin.ball.ui.d.bMh().bMc();
        paramBallInfo.vd = null;
      }
      this.nKv.remove(paramBallInfo);
      e.bLU().m(paramBallInfo);
      b.b(paramBallInfo, this.nKv.isEmpty());
      ae.i("MicroMsg.FloatBallService", "removeBallInfo, existed:true, ballInfo:%s", new Object[] { paramBallInfo });
      if ((this.nMq != null) && (this.nMq.equals(paramBallInfo)))
      {
        ae.i("MicroMsg.FloatBallService", "removeBallInfo, remove last enteredBallInfo");
        this.nMq = null;
      }
      D(paramBallInfo);
      iY(true);
      b(paramBallInfo, 3);
      F(paramBallInfo);
      ((com.tencent.mm.plugin.handoff.a.a)g.ab(com.tencent.mm.plugin.handoff.a.a.class)).del(paramBallInfo.key);
      if (paramBallInfo.equals(this.nMd))
      {
        this.nMd = null;
        AppMethodBeat.o(106119);
      }
    }
    else
    {
      ae.i("MicroMsg.FloatBallService", "removeBallInfo, existed:false");
    }
    AppMethodBeat.o(106119);
  }
  
  public final void n(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106124);
    int i = paramBallInfo.nLw.opType;
    if ((i == 1) || (i == 2) || (i == 3)) {}
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        ae.w("MicroMsg.FloatBallReportLogic", "activeBallTypeReport unexpected opType:%d", new Object[] { Integer.valueOf(paramBallInfo.nLw.opType) });
        paramBallInfo.nLw.opType = 3;
      }
      b.a(paramBallInfo, bu.fpO() - paramBallInfo.nLs, 0L, 0L, 0L);
      c(paramBallInfo, true);
      int j = paramBallInfo.type;
      i = j;
      if (j == 20) {
        i = paramBallInfo.beN;
      }
      ae.d("MicroMsg.FloatBallService", "alvinluo notifySingleBallInfoClicked type: %d, contentType: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramBallInfo.beN) });
      localObject = (Set)this.nMb.get(i);
      if (!com.tencent.mm.plugin.ball.f.d.h((Collection)localObject)) {
        break;
      }
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((f)((Iterator)localObject).next()).c(paramBallInfo);
      }
    }
    Object localObject = (Set)this.nMb.get(0);
    if (com.tencent.mm.plugin.ball.f.d.h((Collection)localObject))
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((f)((Iterator)localObject).next()).c(paramBallInfo);
      }
    }
    AppMethodBeat.o(106124);
  }
  
  public final void o(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106120);
    if (this.nKv.contains(paramBallInfo))
    {
      Object localObject = (Set)this.nMb.get(paramBallInfo.type);
      if (com.tencent.mm.plugin.ball.f.d.h((Collection)localObject))
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((f)((Iterator)localObject).next()).e(paramBallInfo);
        }
      }
      localObject = (Set)this.nMb.get(0);
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
    ae.i("MicroMsg.FloatBallService", "exposeBallInfo, existed:false");
    AppMethodBeat.o(106120);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(106106);
    ae.i("MicroMsg.FloatBallService", "onAccountRelease:%s", new Object[] { Integer.valueOf(hashCode()) });
    b(com.tencent.mm.plugin.ball.ui.d.bMh());
    b(e.bLU());
    this.nMf = false;
    com.tencent.mm.plugin.ball.ui.d.bMh().bMj();
    AppMethodBeat.o(106106);
  }
  
  public final void p(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(224571);
    c(paramBallInfo, true);
    AppMethodBeat.o(224571);
  }
  
  public final void q(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106126);
    c(paramBallInfo, false);
    AppMethodBeat.o(106126);
  }
  
  public final void r(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106128);
    Object localObject;
    if (this.nMq != null)
    {
      localObject = this.nMq.bLl();
      ae.i("MicroMsg.FloatBallService", "onExitBallInfoPage, lastEnteredBallInfo:%s", new Object[] { localObject });
      this.nMq = null;
      localObject = i(paramBallInfo);
      if (localObject == null) {
        break label147;
      }
      ae.i("MicroMsg.FloatBallService", "onExitBallInfoPage, ballInfo:%s", new Object[] { localObject });
      if (((BallInfo)localObject).nLw.opType != -1) {
        break label132;
      }
      ((BallInfo)localObject).nLw.opType = 0;
      label87:
      if (com.tencent.mm.plugin.ball.ui.d.bMh().bMd()) {
        break label139;
      }
      a(paramBallInfo, 1.0F);
    }
    for (;;)
    {
      if (!((BallInfo)localObject).nLv) {
        break label160;
      }
      ((BallInfo)localObject).nLv = false;
      bLS();
      AppMethodBeat.o(106128);
      return;
      localObject = "null";
      break;
      label132:
      b.z((BallInfo)localObject);
      break label87;
      label139:
      B(paramBallInfo);
    }
    label147:
    ae.i("MicroMsg.FloatBallService", "onExitBallInfoPage, no this ball info");
    B(paramBallInfo);
    label160:
    AppMethodBeat.o(106128);
  }
  
  public final void s(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(209456);
    if (paramBallInfo != null) {
      b.a(paramBallInfo, this.nKv);
    }
    AppMethodBeat.o(209456);
  }
  
  public final void setEnableClick(boolean paramBoolean)
  {
    AppMethodBeat.i(209449);
    Object localObject = com.tencent.mm.plugin.ball.ui.d.bMh();
    if (((com.tencent.mm.plugin.ball.ui.d)localObject).bMi())
    {
      localObject = ((com.tencent.mm.plugin.ball.ui.d)localObject).nNm;
      if (((com.tencent.mm.plugin.ball.ui.a)localObject).nML != null) {
        ((com.tencent.mm.plugin.ball.ui.a)localObject).nML.setEnableClick(paramBoolean);
      }
    }
    AppMethodBeat.o(209449);
  }
  
  public final void t(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106135);
    String str;
    if (paramBallInfo != null)
    {
      str = paramBallInfo.bLl();
      paramBallInfo = (ResultReceiver)this.nMc.remove(str);
      if (paramBallInfo == null) {
        break label68;
      }
    }
    label68:
    for (paramBallInfo = Integer.valueOf(paramBallInfo.hashCode());; paramBallInfo = null)
    {
      ae.i("MicroMsg.FloatBallService", "removeFloatBallEventReceiver, key:%s, receiver:%s", new Object[] { str, paramBallInfo });
      AppMethodBeat.o(106135);
      return;
    }
  }
  
  public final void ts(long paramLong)
  {
    this.nMl = paramLong;
  }
  
  public final void u(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(209452);
    if (paramBallInfo == null) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.FloatBallService", "alvinluo markMessageBallInfo ballInfo == null: %b, %s, readyInfo == null: %b", new Object[] { Boolean.valueOf(bool), paramBallInfo, this.nMe });
      if (paramBallInfo != null)
      {
        if (this.nMe == null) {
          this.nMe = new BallInfo(20, paramBallInfo.key);
        }
        this.nMe.x(paramBallInfo);
        this.nMe.key = paramBallInfo.key;
        this.nMe.type = 20;
        this.nMe.state = 256;
        this.nMe.nLv = false;
        this.nMe.nLu = true;
        this.nMe.fOl = System.currentTimeMillis();
        if ((paramBallInfo.type == 4) && (this.nMe.ioY != null))
        {
          paramBallInfo = this.nMe.ioY.getString("processName");
          if (!bu.isNullOrNil(paramBallInfo))
          {
            ae.d("MicroMsg.FloatBallService", "markMessageBallInfo reset processName: %s", new Object[] { paramBallInfo });
            this.nMe.ioY.putString("processName", "");
          }
        }
      }
      AppMethodBeat.o(209452);
      return;
    }
  }
  
  public final void v(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(209450);
    BallInfo localBallInfo = bLL();
    Point localPoint1;
    Point localPoint2;
    label263:
    int j;
    if (localBallInfo != null)
    {
      localBallInfo.state = paramBallInfo.state;
      localBallInfo.nLx = paramBallInfo.nLx;
      paramBallInfo = com.tencent.mm.plugin.ball.ui.d.bMh().nNm;
      if (paramBallInfo.nML != null)
      {
        paramBallInfo = paramBallInfo.nML;
        ae.i("MicroMsg.FloatBallView", "alvinluo switchVoipVoice");
        if (localBallInfo.nLx == null)
        {
          ae.w("MicroMsg.FloatBallView", "switchVoip animationInfo invalid and ignore");
          AppMethodBeat.o(209450);
          return;
        }
        localPoint1 = new Point(localBallInfo.nLx.nLy);
        if (paramBallInfo.yw(paramBallInfo.nPg))
        {
          boolean bool1 = FloatBallView.yB(paramBallInfo.nPg);
          boolean bool2 = FloatBallView.yE(paramBallInfo.nPg);
          localPoint1.x = paramBallInfo.h(bool1, bool2, true);
          localPoint1.y = paramBallInfo.a(paramBallInfo.nPg, bool1, bool2, true);
        }
        localPoint2 = new Point(localBallInfo.nLx.nLz);
        if (paramBallInfo.yw(paramBallInfo.nPg))
        {
          if (localBallInfo.state != 8) {
            break label263;
          }
          localPoint2.x = (FloatBallView.nPL + FloatBallView.nPX * 2);
          localPoint2.y = (FloatBallView.nPM + FloatBallView.nPX * 2);
        }
        while ((!FloatBallView.g(localPoint1)) || (!FloatBallView.g(localPoint2)))
        {
          ae.w("MicroMsg.FloatBallView", "switchVoip animationInfo size invalid and ignore");
          AppMethodBeat.o(209450);
          return;
          if (localBallInfo.state == 512)
          {
            i = FloatBallView.nPH + FloatBallView.nPX * 2;
            if (localPoint2.x < i) {
              localPoint2.x = i;
            }
          }
        }
        paramBallInfo.nQY = 80;
        j = paramBallInfo.nQY;
        if (!paramBallInfo.nQK) {
          break label481;
        }
      }
    }
    label481:
    for (int i = 8388611;; i = 8388613)
    {
      paramBallInfo.R(i | j, true);
      FrameLayout localFrameLayout = paramBallInfo.nQg;
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localFrameLayout.getLayoutParams();
      ae.i("MicroMsg.FloatBallView", "alvinluo animateVoipSwitch state: %d, startSize: %s, endSize: %s, current: %d, %d", new Object[] { Integer.valueOf(localBallInfo.state), localPoint1, localPoint2, Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator.setDuration(300L);
      localValueAnimator.addListener(new FloatBallView.5(paramBallInfo, localBallInfo, localPoint1, localPoint2));
      localValueAnimator.addUpdateListener(new FloatBallView.6(paramBallInfo, localLayoutParams, localPoint1, localPoint2, localFrameLayout));
      localValueAnimator.start();
      AppMethodBeat.o(209450);
      return;
    }
  }
  
  public final boolean xW(int paramInt)
  {
    AppMethodBeat.i(184576);
    if (com.tencent.mm.plugin.ball.f.d.h(this.nKv))
    {
      Iterator localIterator = this.nKv.iterator();
      while (localIterator.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)localIterator.next();
        if ((localBallInfo.type == paramInt) && (!localBallInfo.nLv))
        {
          AppMethodBeat.o(184576);
          return true;
        }
      }
    }
    AppMethodBeat.o(184576);
    return false;
  }
  
  public final void xX(int paramInt)
  {
    this.bjY = paramInt;
  }
  
  public final void xY(int paramInt)
  {
    AppMethodBeat.i(209454);
    if ((this.nMd != null) && (this.nMd.beN == paramInt))
    {
      ae.i("MicroMsg.FloatBallService", "alvinluo removeMessageBall type: %d", new Object[] { Integer.valueOf(paramInt) });
      m(this.nMd);
    }
    AppMethodBeat.o(209454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.d
 * JD-Core Version:    0.7.0.1
 */