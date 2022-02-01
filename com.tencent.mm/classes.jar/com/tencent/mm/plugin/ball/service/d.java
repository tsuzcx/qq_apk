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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bt;
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
  private static d mDV;
  volatile int aYR;
  private final List<BallInfo> mCC;
  private Set<com.tencent.mm.plugin.ball.c.e> mDW;
  private SparseArray<Set<f>> mDX;
  private Map<String, ResultReceiver> mDY;
  private volatile BallInfo mDZ;
  private volatile BallInfo mEa;
  private volatile boolean mEb;
  volatile boolean mEc;
  volatile boolean mEd;
  volatile boolean mEe;
  private volatile boolean mEf;
  private volatile boolean mEg;
  private volatile long mEh;
  private volatile int mEi;
  private volatile int mEj;
  private volatile boolean mEk;
  private View mEl;
  private volatile BallInfo mEm;
  private int mEn;
  
  private d()
  {
    AppMethodBeat.i(106097);
    this.mCC = new Vector();
    this.mDW = new CopyOnWriteArraySet();
    this.mDX = new SparseArray();
    this.mDY = new ConcurrentHashMap();
    this.mDZ = null;
    this.mEa = null;
    this.mEb = false;
    this.mEc = false;
    this.mEd = false;
    this.mEe = false;
    this.mEf = false;
    this.mEg = true;
    this.mEh = 0L;
    this.mEi = 0;
    this.mEj = 0;
    this.aYR = 0;
    this.mEk = false;
    this.mEm = null;
    this.mEn = -1;
    AppMethodBeat.o(106097);
  }
  
  private void A(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(190624);
    com.tencent.mm.plugin.ball.ui.d.bAe().b(this.mCC.size(), paramBallInfo);
    AppMethodBeat.o(190624);
  }
  
  private void B(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(190625);
    int j = this.mDX.size();
    int i = 0;
    while (i < j)
    {
      int k = this.mDX.keyAt(i);
      Object localObject = (Set)this.mDX.get(k);
      if (com.tencent.mm.plugin.ball.f.d.h((Collection)localObject))
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((f)((Iterator)localObject).next()).s(paramBallInfo);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(190625);
  }
  
  private void C(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106133);
    Object localObject = (Set)this.mDX.get(paramBallInfo.type);
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
    AppMethodBeat.i(190627);
    paramBallInfo = g(paramBallInfo);
    if ((paramBallInfo != null) && (paramBallInfo.mDu))
    {
      ad.i("MicroMsg.FloatBallService", "removeAppBrandPassiveBallInfo, remove existedBallInfo:%s", new Object[] { paramBallInfo });
      paramBallInfo.mDw.opType = 10;
      k(paramBallInfo);
    }
    AppMethodBeat.o(190627);
  }
  
  private void M(Bundle paramBundle)
  {
    AppMethodBeat.i(190626);
    Iterator localIterator = this.mDY.values().iterator();
    while (localIterator.hasNext()) {
      ((ResultReceiver)localIterator.next()).send(1, paramBundle);
    }
    AppMethodBeat.o(190626);
  }
  
  private void a(com.tencent.mm.plugin.ball.c.e parame)
  {
    AppMethodBeat.i(106138);
    this.mDW.add(parame);
    AppMethodBeat.o(106138);
  }
  
  private boolean a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184580);
    boolean bool = bzJ();
    ad.i("MicroMsg.FloatBallService", "updateBallVisibilityByKbHeight isVoipShowing: %b", new Object[] { Boolean.valueOf(bool) });
    if ((bool) && (!this.mEk) && (this.mEf))
    {
      this.mEf = false;
      if ((this.mEl != null) && (this.mEl.getVisibility() != 0))
      {
        ad.d("MicroMsg.FloatBallService", "alvinluo updateBallVisibilityByKbHeight has voip but not visible and delay show animation");
        this.mEl.setVisibility(0);
        this.mEl.setAlpha(0.0F);
        a(true, false, paramAnimatorListenerAdapter);
        AppMethodBeat.o(184580);
        return true;
      }
      ad.d("MicroMsg.FloatBallService", "alvinluo updateBallVisibilityByKbHeight has voip and visible, not need to show");
      AppMethodBeat.o(184580);
      return false;
    }
    int j = bzQ();
    int k = com.tencent.mm.plugin.ball.ui.d.bAe().getPositionY();
    int i;
    if (paramBoolean2)
    {
      i = paramInt2;
      if ((i + (k + j + paramInt1) < this.aYR) || (paramInt1 <= 0)) {
        break label284;
      }
    }
    label284:
    for (bool = true;; bool = false)
    {
      ad.i("MicroMsg.FloatBallService", "updateBallVisibilityByKbHeight, ballPositionY:[%s, %s], keyboardHeight:%s, screenHeight:%s, extraHeight: %d, hide: %b, checkBottomShadow: %b, checkExtraHeight: %b", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(this.aYR), Integer.valueOf(paramInt2), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      if (!bool) {
        break label290;
      }
      this.mEf = true;
      a(true, paramAnimatorListenerAdapter);
      AppMethodBeat.o(184580);
      return true;
      i = 0;
      break;
    }
    label290:
    if (this.mEf)
    {
      this.mEf = false;
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
    this.mDW.remove(parame);
    AppMethodBeat.o(106139);
  }
  
  private void b(BallInfo paramBallInfo, int paramInt)
  {
    AppMethodBeat.i(106136);
    paramBallInfo = paramBallInfo.bzh();
    ResultReceiver localResultReceiver = (ResultReceiver)this.mDY.get(paramBallInfo);
    if (localResultReceiver != null)
    {
      ad.i("MicroMsg.FloatBallService", "notifyResultReceiver, event:%s, ballInfoHashKey:%s, receiver:%s", new Object[] { Integer.valueOf(paramInt), paramBallInfo, Integer.valueOf(localResultReceiver.hashCode()) });
      localResultReceiver.send(paramInt, new Bundle());
    }
    AppMethodBeat.o(106136);
  }
  
  private static void bK(List<BallInfo> paramList)
  {
    AppMethodBeat.i(184573);
    ad.i("MicroMsg.FloatBallService", "restoreProcessNameWithFileType");
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(184573);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BallInfo localBallInfo = (BallInfo)paramList.next();
      if ((localBallInfo != null) && (localBallInfo.type == 4) && (localBallInfo.hsl != null))
      {
        String str = localBallInfo.hsl.getString("processName");
        if (!bt.isNullOrNil(str))
        {
          ad.i("MicroMsg.FloatBallService", "restore with process name: %s", new Object[] { str });
          localBallInfo.hsl.putString("processName", "");
        }
      }
    }
    AppMethodBeat.o(184573);
  }
  
  private void bL(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106137);
    if (!this.mDY.isEmpty())
    {
      int i = com.tencent.mm.plugin.ball.f.d.bP(paramList).size();
      if (this.mEn != i)
      {
        this.mEn = i;
        paramList = new Bundle();
        paramList.putInt("ActiveCount", i);
        Iterator localIterator = this.mDY.values().iterator();
        while (localIterator.hasNext()) {
          ((ResultReceiver)localIterator.next()).send(5, paramList);
        }
      }
    }
    AppMethodBeat.o(106137);
  }
  
  /* Error */
  public static d bzH()
  {
    // Byte code:
    //   0: ldc_w 384
    //   3: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 386	com/tencent/mm/plugin/ball/service/d:mDV	Lcom/tencent/mm/plugin/ball/service/d;
    //   12: ifnonnull +19 -> 31
    //   15: ldc 2
    //   17: monitorenter
    //   18: new 2	com/tencent/mm/plugin/ball/service/d
    //   21: dup
    //   22: invokespecial 387	com/tencent/mm/plugin/ball/service/d:<init>	()V
    //   25: putstatic 386	com/tencent/mm/plugin/ball/service/d:mDV	Lcom/tencent/mm/plugin/ball/service/d;
    //   28: ldc 2
    //   30: monitorexit
    //   31: ldc 2
    //   33: monitorexit
    //   34: getstatic 386	com/tencent/mm/plugin/ball/service/d:mDV	Lcom/tencent/mm/plugin/ball/service/d;
    //   37: astore_0
    //   38: ldc_w 384
    //   41: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aload_0
    //   45: areturn
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: ldc_w 384
    //   53: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aload_0
    //   57: athrow
    //   58: astore_0
    //   59: ldc 2
    //   61: monitorexit
    //   62: ldc_w 384
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
  
  private BallInfo bzI()
  {
    AppMethodBeat.i(184568);
    if (com.tencent.mm.plugin.ball.f.d.h(this.mCC))
    {
      Iterator localIterator = this.mCC.iterator();
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
  
  private boolean bzJ()
  {
    AppMethodBeat.i(184575);
    if ((wu(9)) || (wu(17)))
    {
      AppMethodBeat.o(184575);
      return true;
    }
    AppMethodBeat.o(184575);
    return false;
  }
  
  private void bzK()
  {
    AppMethodBeat.i(184571);
    BallInfo localBallInfo;
    if (com.tencent.mm.plugin.ball.f.d.h(this.mCC))
    {
      Iterator localIterator = this.mCC.iterator();
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
        ad.i("MicroMsg.FloatBallService", "removeLocationBackgroundBallInfoIfNeed, removed");
        k(localBallInfo);
        AppMethodBeat.o(184571);
        return;
      }
      ad.i("MicroMsg.FloatBallService", "removeLocationBackgroundBallInfoIfNeed, ignore");
      AppMethodBeat.o(184571);
      return;
      localBallInfo = null;
    }
  }
  
  private void bzL()
  {
    AppMethodBeat.i(184572);
    if (g.afw())
    {
      e.bzR();
      List localList = e.bzU();
      bK(localList);
      this.mCC.clear();
      this.mCC.addAll(localList);
      this.mEb = true;
      aq.n(new Runnable()
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
    ad.i("MicroMsg.FloatBallService", "restoreDataFromStorage, account not ready");
    AppMethodBeat.o(184572);
  }
  
  private boolean bzM()
  {
    AppMethodBeat.i(184574);
    BallInfo localBallInfo = g(this.mEm);
    if ((localBallInfo != null) && (com.tencent.mm.plugin.ball.f.d.h(this.mCC)))
    {
      boolean bool = com.tencent.mm.plugin.ball.f.d.f(this.mCC, localBallInfo);
      AppMethodBeat.o(184574);
      return bool;
    }
    AppMethodBeat.o(184574);
    return false;
  }
  
  private int bzN()
  {
    AppMethodBeat.i(106115);
    List localList = com.tencent.mm.plugin.ball.f.d.bP(this.mCC);
    if (com.tencent.mm.plugin.ball.f.d.h(localList))
    {
      int i = localList.size();
      AppMethodBeat.o(106115);
      return i;
    }
    AppMethodBeat.o(106115);
    return 0;
  }
  
  public static void bzO()
  {
    AppMethodBeat.i(106123);
    com.tencent.mm.plugin.ball.ui.d.bAe().a(false, null);
    AppMethodBeat.o(106123);
  }
  
  private void bzP()
  {
    AppMethodBeat.i(106140);
    List localList = com.tencent.mm.plugin.ball.f.d.bM(new Vector(this.mCC));
    ad.i("MicroMsg.FloatBallService", "notifyFloatBallInfoChanged, originSize: %d, sortedSize: %d, ballInfoList:%s", new Object[] { Integer.valueOf(this.mCC.size()), Integer.valueOf(localList.size()), localList });
    Iterator localIterator = this.mDW.iterator();
    while (localIterator.hasNext())
    {
      ((com.tencent.mm.plugin.ball.c.e)localIterator.next()).a(localList, this.mEm);
      bL(localList);
    }
    AppMethodBeat.o(106140);
  }
  
  private int bzQ()
  {
    AppMethodBeat.i(184581);
    int j = com.tencent.mm.plugin.ball.f.e.mFL + com.tencent.mm.plugin.ball.f.e.mFM + com.tencent.mm.plugin.ball.f.e.mFN;
    int i = j;
    if (this.mEl != null) {
      i = Math.max(this.mEl.getMeasuredHeight(), j);
    }
    AppMethodBeat.o(184581);
    return i;
  }
  
  private void ip(boolean paramBoolean)
  {
    AppMethodBeat.i(106107);
    ad.i("MicroMsg.FloatBallService", "markNoFloatBallPage:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mEc = paramBoolean;
    AppMethodBeat.o(106107);
  }
  
  private void iq(boolean paramBoolean)
  {
    AppMethodBeat.i(106129);
    Object localObject = g(this.mEm);
    if ((localObject != null) && (com.tencent.mm.plugin.ball.f.d.h(this.mCC)))
    {
      if (com.tencent.mm.plugin.ball.f.d.e(this.mCC, (BallInfo)localObject))
      {
        ad.i("MicroMsg.FloatBallService", "recheckBallInfoList, has other balls, hidden current ball info");
        boolean bool = com.tencent.mm.plugin.ball.ui.d.bAe().bAa();
        ad.i("MicroMsg.FloatBallService", "recheckBallInfoList, canNotShowFloatBall:%s, withFloatBall:%s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
        if ((!bool) && (paramBoolean)) {
          a((BallInfo)localObject, 1.0F);
        }
        Iterator localIterator = this.mCC.iterator();
        while (localIterator.hasNext())
        {
          BallInfo localBallInfo = (BallInfo)localIterator.next();
          if ((!localBallInfo.mDu) && (localBallInfo.mDv) && (!localBallInfo.equals(localObject)))
          {
            localBallInfo.mDv = false;
            b(localBallInfo, 4);
          }
          else if (localBallInfo.equals(localObject))
          {
            localBallInfo.mDv = true;
          }
        }
      }
      if (com.tencent.mm.plugin.ball.f.d.f(this.mCC, (BallInfo)localObject))
      {
        ad.i("MicroMsg.FloatBallService", "recheckBallInfoList, no other balls, make float ball transparent");
        ((BallInfo)localObject).mDv = false;
        a((BallInfo)localObject, 0.0F);
      }
      bzP();
      AppMethodBeat.o(106129);
      return;
    }
    if (this.mEm != null) {}
    for (localObject = this.mEm.bzh();; localObject = "null")
    {
      ad.i("MicroMsg.FloatBallService", "recheckBallInfoList, last enteredBallInfo:%s", new Object[] { localObject });
      break;
    }
  }
  
  private void x(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106117);
    if ((!paramBallInfo.mDu) && (bzN() >= 5))
    {
      ad.i("MicroMsg.FloatBallService", "addBallInfo, already add max count balls:%s", new Object[] { Integer.valueOf(5) });
      if (!paramBallInfo.fnG) {
        b.a(paramBallInfo, this.mCC, true);
      }
      FloatBallProxyUI.a(new FloatBallProxyUI.a()
      {
        public final void wC(int paramAnonymousInt)
        {
          AppMethodBeat.i(190613);
          ad.i("MicroMsg.FloatBallService", "addBallInfo, show reach count limit callback:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt == 1)
          {
            ad.i("MicroMsg.FloatBallService", "addBallInfo, show float menu view");
            d.bzO();
          }
          AppMethodBeat.o(190613);
        }
      });
      AppMethodBeat.o(106117);
      return;
    }
    if (!this.mCC.contains(paramBallInfo))
    {
      long l = bt.eGO();
      paramBallInfo.mDs = l;
      paramBallInfo.createTime = l;
      paramBallInfo.mDw.opType = -1;
      Object localObject;
      int i;
      if (paramBallInfo.type != 19)
      {
        localObject = paramBallInfo.mDw;
        if ((paramBallInfo.mDu) && (paramBallInfo.mDw.mDx == 0)) {
          i = 3;
        }
      }
      for (((BallReportInfo)localObject).mDx = i;; paramBallInfo.mDw.mDx = 5)
      {
        this.mCC.add(paramBallInfo);
        ad.i("MicroMsg.FloatBallService", "addBallInfo, existed:false, ballInfo:%s", new Object[] { paramBallInfo });
        if (!paramBallInfo.fnG) {
          b.a(paramBallInfo, this.mCC, false);
        }
        z(paramBallInfo);
        iq(true);
        localObject = new Bundle();
        ((Bundle)localObject).putInt("type", paramBallInfo.type);
        ((Bundle)localObject).putString("key", paramBallInfo.key);
        M((Bundle)localObject);
        B(paramBallInfo);
        ((com.tencent.mm.plugin.handoff.a.a)g.ab(com.tencent.mm.plugin.handoff.a.a.class)).I(paramBallInfo);
        AppMethodBeat.o(106117);
        return;
        i = paramBallInfo.mDw.mDx;
        break;
      }
    }
    ad.i("MicroMsg.FloatBallService", "addBallInfo, existed:true, replaceExisted: %b, ballInfo:%s", new Object[] { Boolean.valueOf(paramBallInfo.mDt), paramBallInfo });
    if (paramBallInfo.mDt)
    {
      paramBallInfo.mDt = false;
      j(paramBallInfo);
    }
    AppMethodBeat.o(106117);
  }
  
  private void y(final BallInfo paramBallInfo)
  {
    AppMethodBeat.i(190622);
    com.tencent.mm.plugin.ball.ui.d.bAe().c(true, new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(190614);
        super.onAnimationEnd(paramAnonymousAnimator);
        d.this.a(paramBallInfo, 1.0F);
        AppMethodBeat.o(190614);
      }
    });
    AppMethodBeat.o(190622);
  }
  
  private void z(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(190623);
    ad.d("MicroMsg.FloatBallService", "onFloatBallAdded %s", new Object[] { paramBallInfo });
    com.tencent.mm.plugin.ball.ui.d.bAe().a(this.mCC.size(), paramBallInfo);
    AppMethodBeat.o(190623);
  }
  
  public final void a(final int paramInt1, final int paramInt2, boolean paramBoolean, long paramLong)
  {
    boolean bool = false;
    AppMethodBeat.i(184577);
    this.mEi = paramInt1;
    this.mEj = paramInt2;
    this.mEk = paramBoolean;
    if (!com.tencent.mm.plugin.ball.ui.d.bAe().bAf())
    {
      ad.i("MicroMsg.FloatBallService", "KeyboardHeightChanged, no float ball");
      AppMethodBeat.o(184577);
      return;
    }
    if (paramBoolean) {
      im(true);
    }
    while (paramLong != 0L)
    {
      aq.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(190611);
          d locald = d.this;
          int i = paramInt1;
          int j = paramInt2;
          if (d.b(d.this) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            d.a(locald, i, j, bool);
            AppMethodBeat.o(190611);
            return;
          }
        }
      }, paramLong);
      AppMethodBeat.o(184577);
      return;
      im(false);
    }
    paramBoolean = bool;
    if (this.mEi != 0) {
      paramBoolean = true;
    }
    a(paramInt1, paramInt2, true, paramBoolean, null);
    AppMethodBeat.o(184577);
  }
  
  public final void a(int paramInt, f paramf)
  {
    AppMethodBeat.i(106131);
    ad.i("MicroMsg.FloatBallService", "addFloatBallInfoEventListener, type:%s", new Object[] { Integer.valueOf(paramInt) });
    if (paramf != null)
    {
      Set localSet = (Set)this.mDX.get(paramInt);
      Object localObject = localSet;
      if (localSet == null)
      {
        localObject = new HashSet();
        this.mDX.put(paramInt, localObject);
      }
      ((Set)localObject).add(paramf);
    }
    AppMethodBeat.o(106131);
  }
  
  public final void a(long paramLong, com.tencent.mm.plugin.ball.c.c.a parama)
  {
    int i = 1;
    AppMethodBeat.i(190618);
    if (this.mEa == null)
    {
      ad.w("MicroMsg.FloatBallService", "alvinluo addMessageBall readyMessageBallInfo is invalid");
      if (parama != null) {
        parama.wx(7);
      }
      AppMethodBeat.o(190618);
      return;
    }
    if ((!this.mEg) && (!this.mEe))
    {
      ad.w("MicroMsg.FloatBallService", "alvinluo addMessageBall isWechatForeground: %b", new Object[] { Boolean.valueOf(this.mEg) });
      if (parama != null) {
        parama.wx(6);
      }
      this.mEa = null;
      AppMethodBeat.o(190618);
      return;
    }
    if (!com.tencent.mm.plugin.ball.f.d.a(this.mEa, paramLong))
    {
      ad.w("MicroMsg.FloatBallService", "alvinluo addMessageBall can not add message ball because of time over limit");
      if (parama != null) {
        parama.wx(5);
      }
      this.mEa = null;
      AppMethodBeat.o(190618);
      return;
    }
    if (this.mDZ == null)
    {
      this.mDZ = new BallInfo(19, this.mEa.key);
      this.mDZ.u(this.mEa);
      ad.i("MicroMsg.FloatBallService", "alvinluo addMessageBall existed: false, and add: %s", new Object[] { this.mDZ });
      i(this.mDZ);
      this.mEa = null;
      if (parama != null) {
        parama.wx(i);
      }
      AppMethodBeat.o(190618);
      return;
    }
    BallInfo localBallInfo = this.mEa;
    if (this.mDZ == null) {
      ad.w("MicroMsg.FloatBallService", "alvinluo updateMessageBall messageBallInfo is null and ignore");
    }
    for (;;)
    {
      if ((this.mDZ != null) && (!this.mDZ.fnG))
      {
        this.mDZ.mDw.mDx = 6;
        b.a(this.mDZ, this.mCC, false);
      }
      i = 2;
      break;
      if (g(this.mDZ) != null)
      {
        this.mDZ.u(localBallInfo);
        this.mDZ.key = localBallInfo.key;
        ad.i("MicroMsg.FloatBallService", "alvinluo updateMessageBall existed: true, and update %s", new Object[] { this.mDZ });
        j(this.mDZ);
      }
      else
      {
        ad.w("MicroMsg.FloatBallService", "alvinluo updateMessageBall messageBallInfo not null but not added!!");
      }
    }
  }
  
  public final void a(ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(190620);
    com.tencent.mm.plugin.ball.ui.d.bAe().a(true, paramResultReceiver);
    AppMethodBeat.o(190620);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(106112);
    if (paramh != null)
    {
      if (com.tencent.mm.plugin.ball.f.d.h(this.mCC))
      {
        paramh.bo(new ArrayList(this.mCC));
        AppMethodBeat.o(106112);
        return;
      }
      paramh.bo(new ArrayList());
    }
    AppMethodBeat.o(106112);
  }
  
  public final void a(BallInfo paramBallInfo, float paramFloat)
  {
    AppMethodBeat.i(106122);
    if ((paramFloat == 1.0F) || (com.tencent.mm.plugin.ball.f.d.f(this.mCC, paramBallInfo))) {
      aq.f(new com.tencent.mm.plugin.ball.ui.d.2(com.tencent.mm.plugin.ball.ui.d.bAe(), paramFloat));
    }
    AppMethodBeat.o(106122);
  }
  
  public final void a(BallInfo paramBallInfo, ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(106134);
    if ((paramBallInfo != null) && (paramResultReceiver != null))
    {
      paramBallInfo = paramBallInfo.bzh();
      ad.i("MicroMsg.FloatBallService", "registerFloatBallEventReceiver, key:%s, receiver:%s", new Object[] { paramBallInfo, Integer.valueOf(paramResultReceiver.hashCode()) });
      this.mDY.put(paramBallInfo, paramResultReceiver);
    }
    AppMethodBeat.o(106134);
  }
  
  public final void a(BallInfo paramBallInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(106130);
    paramBallInfo = g(paramBallInfo);
    if (paramBallInfo != null)
    {
      if (!paramBoolean) {}
      for (boolean bool = true;; bool = false)
      {
        paramBallInfo.mDv = bool;
        ad.i("MicroMsg.FloatBallService", "updateBallVisibility, existed:true, visible:%s, ballInfo:%s", new Object[] { Boolean.valueOf(paramBoolean), paramBallInfo });
        bzP();
        AppMethodBeat.o(106130);
        return;
      }
    }
    ad.i("MicroMsg.FloatBallService", "updateBallVisibility, existed:false");
    AppMethodBeat.o(106130);
  }
  
  public final void a(List<AppBrandBackgroundRunningApp> paramList, AppBrandBackgroundRunningOperationParcel paramAppBrandBackgroundRunningOperationParcel, int paramInt)
  {
    AppMethodBeat.i(106141);
    ad.i("MicroMsg.FloatBallService", "onBackgroundRunningAppChanged, operation:%s, change:%s", new Object[] { paramAppBrandBackgroundRunningOperationParcel, Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      AppMethodBeat.o(106141);
      return;
    }
    if ((paramAppBrandBackgroundRunningOperationParcel.dbV == 2) || (paramAppBrandBackgroundRunningOperationParcel.dbV == 3))
    {
      if ((paramAppBrandBackgroundRunningOperationParcel.aTC & 0x2) > 0) {
        D(new BallInfo(7, com.tencent.mm.plugin.ball.f.b.ci(paramAppBrandBackgroundRunningOperationParcel.appId, paramAppBrandBackgroundRunningOperationParcel.gXn)));
      }
      if ((paramAppBrandBackgroundRunningOperationParcel.aTC & 0x4) > 0)
      {
        paramList = paramAppBrandBackgroundRunningOperationParcel.appId;
        paramInt = paramAppBrandBackgroundRunningOperationParcel.gXn;
        D(new BallInfo(17, String.format(Locale.US, "%s#%d", new Object[] { paramList, Integer.valueOf(paramInt) })));
      }
      if ((paramAppBrandBackgroundRunningOperationParcel.aTC & 0x8) > 0) {
        D(new BallInfo(18, com.tencent.mm.plugin.ball.f.b.ch(paramAppBrandBackgroundRunningOperationParcel.appId, paramAppBrandBackgroundRunningOperationParcel.gXn)));
      }
      AppMethodBeat.o(106141);
      return;
    }
    ad.i("MicroMsg.FloatBallService", "onBackgroundRunningAppChanged, operation ignored");
    AppMethodBeat.o(106141);
  }
  
  public final void a(boolean paramBoolean, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184567);
    if (this.mEe)
    {
      ad.i("MicroMsg.FloatBallService", "hideFloatBall, has marked QB file view page, ignore hiding");
      AppMethodBeat.o(184567);
      return;
    }
    if ((bzJ()) && (!this.mEd)) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.FloatBallService", "hideFloatBall forceHide: %b, canShowFloatBall: %b, voipInfo: %s", new Object[] { Boolean.valueOf(this.mEd), Boolean.valueOf(bool), bzI() });
      if (!bool) {
        break;
      }
      AppMethodBeat.o(184567);
      return;
    }
    com.tencent.mm.plugin.ball.ui.d.bAe().e(paramBoolean, paramAnimatorListenerAdapter);
    AppMethodBeat.o(184567);
  }
  
  final void a(boolean paramBoolean1, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184570);
    if (!com.tencent.mm.compatible.d.b.bZ(aj.getContext()))
    {
      ad.i("MicroMsg.FloatBallService", "resumeFloatBall, no float window permission");
      bzK();
      com.tencent.mm.plugin.ball.ui.d.bAe().bAg();
      this.mEb = false;
      this.mCC.clear();
      e.bzR().clear();
      bzP();
      AppMethodBeat.o(184570);
      return;
    }
    if (this.mEb)
    {
      if ((this.mEc) && (!bzJ()))
      {
        ad.i("MicroMsg.FloatBallService", "resumeFloatBall, has marked no float ball page, ignore resuming");
        AppMethodBeat.o(184570);
        return;
      }
      if (this.mEd)
      {
        ad.i("MicroMsg.FloatBallService", "resumeFloatBall, has marked forceHideAllFloatBall, ignore resuming");
        AppMethodBeat.o(184570);
        return;
      }
      if (this.mEf)
      {
        ad.i("MicroMsg.FloatBallService", "resumeFloatBall, hasHideForKeyboardHeightChange, ignore resuming");
        AppMethodBeat.o(184570);
        return;
      }
      if (!bzM())
      {
        ad.i("MicroMsg.FloatBallService", "resumeFloatBall not singleBallInfoCondition, withAnimation:%s", new Object[] { Boolean.valueOf(paramBoolean1) });
        com.tencent.mm.plugin.ball.ui.d.bAe().b(paramBoolean1, paramBoolean2, paramAnimatorListenerAdapter);
        AppMethodBeat.o(184570);
        return;
      }
      ad.i("MicroMsg.FloatBallService", "resumeFloatBall singleBallInfoCondition, withAnimation:false");
      com.tencent.mm.plugin.ball.ui.d.bAe().b(false, paramBoolean2, paramAnimatorListenerAdapter);
      c(this.mEm, true);
      AppMethodBeat.o(184570);
      return;
    }
    ad.i("MicroMsg.FloatBallService", "resumeFloatBall, restore data from storage");
    bzL();
    AppMethodBeat.o(184570);
  }
  
  public final void agv()
  {
    AppMethodBeat.i(106099);
    ad.i("MicroMsg.FloatBallService", "onRegister:%s", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(106099);
  }
  
  public final void agw()
  {
    AppMethodBeat.i(106100);
    ad.i("MicroMsg.FloatBallService", "onUnregister:%s", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(106100);
  }
  
  public final void b(int paramInt, f paramf)
  {
    AppMethodBeat.i(106132);
    ad.i("MicroMsg.FloatBallService", "removeFloatBallInfoEventListener, type:%s", new Object[] { Integer.valueOf(paramInt) });
    if (paramf != null)
    {
      Set localSet = (Set)this.mDX.get(paramInt);
      if (localSet != null) {
        localSet.remove(paramf);
      }
    }
    AppMethodBeat.o(106132);
  }
  
  public final void byP()
  {
    AppMethodBeat.i(106105);
    ad.i("MicroMsg.FloatBallService", "onAccountInitialized:%s", new Object[] { Integer.valueOf(hashCode()) });
    a(com.tencent.mm.plugin.ball.ui.d.bAe());
    a(e.bzR());
    this.mEb = false;
    a(true, true, null);
    AppMethodBeat.o(106105);
  }
  
  public final boolean byQ()
  {
    return this.mEc;
  }
  
  public final boolean byR()
  {
    return this.mEe;
  }
  
  public final long byS()
  {
    return this.mEh;
  }
  
  public final void byT()
  {
    AppMethodBeat.i(106109);
    ik(false);
    ip(false);
    if (this.mEm != null)
    {
      ad.i("MicroMsg.FloatBallService", "fixFloatBallIfNeed, lastEnteredBallInfo:%s", new Object[] { this.mEm });
      p(g(this.mEm));
      AppMethodBeat.o(106109);
      return;
    }
    ad.i("MicroMsg.FloatBallService", "fixFloatBallIfNeed, safe");
    AppMethodBeat.o(106109);
  }
  
  public final void byU()
  {
    AppMethodBeat.i(106111);
    bd.az(aj.getContext(), 2131766133);
    AppMethodBeat.o(106111);
  }
  
  public final List<BallInfo> byV()
  {
    return this.mCC;
  }
  
  public final void byW()
  {
    this.mEl = null;
  }
  
  public final boolean byX()
  {
    return this.mEd;
  }
  
  public final void byY()
  {
    AppMethodBeat.i(184565);
    com.tencent.mm.plugin.ball.ui.d locald = com.tencent.mm.plugin.ball.ui.d.bAe();
    if (locald.bAf()) {
      locald.mFi.byY();
    }
    AppMethodBeat.o(184565);
  }
  
  public final void byZ()
  {
    AppMethodBeat.i(184566);
    com.tencent.mm.plugin.ball.ui.d locald = com.tencent.mm.plugin.ball.ui.d.bAe();
    if (locald.bAf()) {
      locald.mFi.byZ();
    }
    AppMethodBeat.o(184566);
  }
  
  final void c(BallInfo paramBallInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(106127);
    BallInfo localBallInfo = g(paramBallInfo);
    if (localBallInfo != null)
    {
      localBallInfo.mDs = bt.eGO();
      this.mEm = localBallInfo;
      ad.i("MicroMsg.FloatBallService", "onEnterBallInfoPage, set lastEnteredBallInfo:%s", new Object[] { this.mEm.bzh() });
      iq(paramBoolean);
      AppMethodBeat.o(106127);
      return;
    }
    if (paramBallInfo != null) {}
    for (paramBallInfo = paramBallInfo.bzh();; paramBallInfo = "null")
    {
      ad.i("MicroMsg.FloatBallService", "onEnterBallInfoPage, no this ball info:%s", new Object[] { paramBallInfo });
      AppMethodBeat.o(106127);
      return;
    }
  }
  
  public final boolean c(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184579);
    if (!com.tencent.mm.plugin.ball.ui.d.bAe().bAf())
    {
      ad.i("MicroMsg.FloatBallService", "updateBallVisibilityByPosition, no float ball");
      AppMethodBeat.o(184579);
      return false;
    }
    if (!this.mEk)
    {
      ad.i("MicroMsg.FloatBallService", "updateBallVisibilityByPosition keyboard not show and ignore");
      AppMethodBeat.o(184579);
      return false;
    }
    boolean bool = a(this.mEi, this.mEj, false, false, paramAnimatorListenerAdapter);
    AppMethodBeat.o(184579);
    return bool;
  }
  
  public final void ds(View paramView)
  {
    this.mEl = paramView;
  }
  
  public final BallInfo g(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106113);
    synchronized (this.mCC)
    {
      if (this.mCC.contains(paramBallInfo))
      {
        paramBallInfo = (BallInfo)this.mCC.get(this.mCC.indexOf(paramBallInfo));
        ad.i("MicroMsg.FloatBallService", "getBallInfo, existed:true, responseBallInfo:%s", new Object[] { paramBallInfo });
        AppMethodBeat.o(106113);
        return paramBallInfo;
      }
      ad.i("MicroMsg.FloatBallService", "getBallInfo, existed:false");
      AppMethodBeat.o(106113);
      return null;
    }
  }
  
  public final Point getBallPosition()
  {
    AppMethodBeat.i(106121);
    Object localObject1 = com.tencent.mm.plugin.ball.ui.d.bAe();
    if (((com.tencent.mm.plugin.ball.ui.d)localObject1).bAf())
    {
      localObject1 = ((com.tencent.mm.plugin.ball.ui.d)localObject1).mFi;
      if (((com.tencent.mm.plugin.ball.ui.a)localObject1).mEI != null) {
        localObject1 = ((com.tencent.mm.plugin.ball.ui.a)localObject1).mEI.getBallPosition();
      }
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new Point(com.tencent.mm.plugin.ball.f.d.bAn(), com.tencent.mm.plugin.ball.f.d.bAo());
      }
      ad.i("MicroMsg.FloatBallService", "getBallPosition, position:[%s, %s]", new Object[] { Integer.valueOf(((Point)localObject2).x), Integer.valueOf(((Point)localObject2).y) });
      AppMethodBeat.o(106121);
      return localObject2;
      localObject1 = new Point(com.tencent.mm.plugin.ball.f.d.bAn(), com.tencent.mm.plugin.ball.f.d.bAo());
      continue;
      localObject1 = new Point(com.tencent.mm.plugin.ball.f.d.bAn(), com.tencent.mm.plugin.ball.f.d.bAo());
    }
  }
  
  public final boolean h(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106114);
    if (bzN() >= 5)
    {
      ad.i("MicroMsg.FloatBallService", "canAddBallInfo, false");
      if (!paramBallInfo.fnG) {
        b.a(paramBallInfo, this.mCC, true);
      }
      AppMethodBeat.o(106114);
      return false;
    }
    ad.i("MicroMsg.FloatBallService", "canAddBallInfo, true");
    AppMethodBeat.o(106114);
    return true;
  }
  
  public final void i(final BallInfo paramBallInfo)
  {
    int j = 0;
    AppMethodBeat.i(106116);
    if ((paramBallInfo.type == 6) && (paramBallInfo.mDw.mDy == 11)) {}
    for (int i = 1; (i != 0) && (!com.tencent.mm.compatible.d.b.bZ(aj.getContext())); i = 0)
    {
      ad.i("MicroMsg.FloatBallService", "isAskForPermissionAlready, no permission & no ask for");
      AppMethodBeat.o(106116);
      return;
    }
    i = paramBallInfo.type;
    if (i == 7)
    {
      ad.i("MicroMsg.FloatBallService", "shouldCheckPermissionWhenAddBallInfo, ignore for ballType: location");
      i = j;
    }
    while (i != 0)
    {
      com.tencent.mm.plugin.ball.f.c.a(aj.getContext(), paramBallInfo.type, true, new com.tencent.mm.plugin.ball.f.c.a()
      {
        public final void fD(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(190612);
          if (paramAnonymousBoolean)
          {
            d.a(d.this, paramBallInfo);
            AppMethodBeat.o(190612);
            return;
          }
          ad.w("MicroMsg.FloatBallService", "no float window permission");
          AppMethodBeat.o(190612);
        }
      });
      AppMethodBeat.o(106116);
      return;
      if (i == 17)
      {
        ad.i("MicroMsg.FloatBallService", "shouldCheckPermissionWhenAddBallInfo, ignore for ballType: appbrand_voip");
        i = j;
      }
      else if (i == 18)
      {
        ad.i("MicroMsg.FloatBallService", "shouldCheckPermissionWhenAddBallInfo, ignore for ballType: audio_of_video_background_play");
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
  
  public final void ie(boolean paramBoolean)
  {
    AppMethodBeat.i(106101);
    a(paramBoolean, null);
    AppMethodBeat.o(106101);
  }
  
  public final void jdMethod_if(boolean paramBoolean)
  {
    AppMethodBeat.i(106102);
    a(paramBoolean, true, null);
    AppMethodBeat.o(106102);
  }
  
  public final void ig(boolean paramBoolean)
  {
    AppMethodBeat.i(106103);
    ip(true);
    a(paramBoolean, null);
    AppMethodBeat.o(106103);
  }
  
  public final void ih(boolean paramBoolean)
  {
    AppMethodBeat.i(106104);
    ip(false);
    a(paramBoolean, true, null);
    AppMethodBeat.o(106104);
  }
  
  public final void ii(boolean paramBoolean)
  {
    AppMethodBeat.i(190616);
    com.tencent.mm.plugin.ball.ui.d.bAe().c(paramBoolean, new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(190610);
        super.onAnimationEnd(paramAnonymousAnimator);
        d.this.a(null, 1.0F);
        AppMethodBeat.o(190610);
      }
    });
    AppMethodBeat.o(190616);
  }
  
  public final void ij(boolean paramBoolean)
  {
    AppMethodBeat.i(176960);
    ad.i("MicroMsg.FloatBallService", "markWechatInForeground, foreground:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mEg = paramBoolean;
    if (this.mEe)
    {
      ad.i("MicroMsg.FloatBallService", "markWechatInForeground, has marked QB file view page, mark Wechat in foreground");
      com.tencent.mm.plugin.ball.ui.d.bAe().ij(true);
    }
    for (;;)
    {
      if (!this.mEg)
      {
        ad.i("MicroMsg.FloatBallService", "alvinluo resetReadyStatusBallInfo");
        this.mEa = null;
      }
      AppMethodBeat.o(176960);
      return;
      com.tencent.mm.plugin.ball.ui.d.bAe().ij(paramBoolean);
    }
  }
  
  public final void ik(boolean paramBoolean)
  {
    AppMethodBeat.i(106108);
    ad.i("MicroMsg.FloatBallService", "markQBFileViewPage:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mEe = paramBoolean;
    AppMethodBeat.o(106108);
  }
  
  public final void il(boolean paramBoolean)
  {
    AppMethodBeat.i(184564);
    com.tencent.mm.plugin.ball.ui.d locald = com.tencent.mm.plugin.ball.ui.d.bAe();
    if (locald.bAf()) {
      locald.mFi.mEL = paramBoolean;
    }
    AppMethodBeat.o(184564);
  }
  
  public final void im(boolean paramBoolean)
  {
    AppMethodBeat.i(185124);
    ad.i("MicroMsg.FloatBallService", "markForceHideAllFloatBall %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mEd = paramBoolean;
    com.tencent.mm.plugin.ball.ui.d.bAe().mEd = paramBoolean;
    AppMethodBeat.o(185124);
  }
  
  public final void j(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106118);
    BallInfo localBallInfo = g(paramBallInfo);
    if (localBallInfo != null)
    {
      localBallInfo.u(paramBallInfo);
      ad.i("MicroMsg.FloatBallService", "updateBallInfo, existed:true, ballInfo:%s", new Object[] { localBallInfo });
      bzP();
      AppMethodBeat.o(106118);
      return;
    }
    ad.i("MicroMsg.FloatBallService", "updateBallInfo, existed:false");
    AppMethodBeat.o(106118);
  }
  
  public final void k(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106119);
    if (this.mCC.contains(paramBallInfo))
    {
      if (paramBallInfo.type == 9)
      {
        com.tencent.mm.plugin.ball.ui.d.bAe().bzZ();
        paramBallInfo.sk = null;
      }
      this.mCC.remove(paramBallInfo);
      e.bzR().k(paramBallInfo);
      b.b(paramBallInfo, this.mCC.isEmpty());
      ad.i("MicroMsg.FloatBallService", "removeBallInfo, existed:true, ballInfo:%s", new Object[] { paramBallInfo });
      A(paramBallInfo);
      iq(true);
      b(paramBallInfo, 3);
      C(paramBallInfo);
      ((com.tencent.mm.plugin.handoff.a.a)g.ab(com.tencent.mm.plugin.handoff.a.a.class)).del(paramBallInfo.key);
      if (paramBallInfo.equals(this.mDZ))
      {
        this.mDZ = null;
        AppMethodBeat.o(106119);
      }
    }
    else
    {
      ad.i("MicroMsg.FloatBallService", "removeBallInfo, existed:false");
    }
    AppMethodBeat.o(106119);
  }
  
  public final void l(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106124);
    int i = paramBallInfo.mDw.opType;
    if ((i == 1) || (i == 2) || (i == 3)) {}
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        ad.w("MicroMsg.FloatBallReportLogic", "activeBallTypeReport unexpected opType:%d", new Object[] { Integer.valueOf(paramBallInfo.mDw.opType) });
        paramBallInfo.mDw.opType = 3;
      }
      b.a(paramBallInfo, bt.eGO() - paramBallInfo.mDs, 0L, 0L, 0L);
      c(paramBallInfo, true);
      int j = paramBallInfo.type;
      i = j;
      if (j == 19) {
        i = paramBallInfo.aTB;
      }
      ad.d("MicroMsg.FloatBallService", "alvinluo notifySingleBallInfoClicked type: %d, contentType: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramBallInfo.aTB) });
      Object localObject = (Set)this.mDX.get(i);
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
  
  public final void m(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106120);
    if (this.mCC.contains(paramBallInfo))
    {
      Object localObject = (Set)this.mDX.get(paramBallInfo.type);
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
    ad.i("MicroMsg.FloatBallService", "exposeBallInfo, existed:false");
    AppMethodBeat.o(106120);
  }
  
  public final void n(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(205912);
    c(paramBallInfo, true);
    AppMethodBeat.o(205912);
  }
  
  public final void nt(long paramLong)
  {
    this.mEh = paramLong;
  }
  
  public final void o(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106126);
    c(paramBallInfo, false);
    AppMethodBeat.o(106126);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(106106);
    ad.i("MicroMsg.FloatBallService", "onAccountRelease:%s", new Object[] { Integer.valueOf(hashCode()) });
    b(com.tencent.mm.plugin.ball.ui.d.bAe());
    b(e.bzR());
    this.mEb = false;
    com.tencent.mm.plugin.ball.ui.d.bAe().bAg();
    AppMethodBeat.o(106106);
  }
  
  public final void p(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106128);
    Object localObject;
    if (this.mEm != null)
    {
      localObject = this.mEm.bzh();
      ad.i("MicroMsg.FloatBallService", "onExitBallInfoPage, lastEnteredBallInfo:%s", new Object[] { localObject });
      this.mEm = null;
      localObject = g(paramBallInfo);
      if (localObject == null) {
        break label147;
      }
      ad.i("MicroMsg.FloatBallService", "onExitBallInfoPage, ballInfo:%s", new Object[] { localObject });
      if (((BallInfo)localObject).mDw.opType != -1) {
        break label132;
      }
      ((BallInfo)localObject).mDw.opType = 0;
      label87:
      if (com.tencent.mm.plugin.ball.ui.d.bAe().bAa()) {
        break label139;
      }
      a(paramBallInfo, 1.0F);
    }
    for (;;)
    {
      if (!((BallInfo)localObject).mDv) {
        break label160;
      }
      ((BallInfo)localObject).mDv = false;
      bzP();
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
    ad.i("MicroMsg.FloatBallService", "onExitBallInfoPage, no this ball info");
    y(paramBallInfo);
    label160:
    AppMethodBeat.o(106128);
  }
  
  public final void q(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106135);
    String str;
    if (paramBallInfo != null)
    {
      str = paramBallInfo.bzh();
      paramBallInfo = (ResultReceiver)this.mDY.remove(str);
      if (paramBallInfo == null) {
        break label68;
      }
    }
    label68:
    for (paramBallInfo = Integer.valueOf(paramBallInfo.hashCode());; paramBallInfo = null)
    {
      ad.i("MicroMsg.FloatBallService", "removeFloatBallEventReceiver, key:%s, receiver:%s", new Object[] { str, paramBallInfo });
      AppMethodBeat.o(106135);
      return;
    }
  }
  
  public final void r(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(190617);
    if (paramBallInfo == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.FloatBallService", "alvinluo markMessageBallInfo ballInfo == null: %b, %s, readyInfo == null: %b", new Object[] { Boolean.valueOf(bool), paramBallInfo, this.mEa });
      if (paramBallInfo != null)
      {
        if (this.mEa == null) {
          this.mEa = new BallInfo(19, paramBallInfo.key);
        }
        this.mEa.u(paramBallInfo);
        this.mEa.key = paramBallInfo.key;
        this.mEa.type = 19;
        this.mEa.state = 256;
        this.mEa.mDv = false;
        this.mEa.mDu = true;
        this.mEa.fpL = System.currentTimeMillis();
        if ((paramBallInfo.type == 4) && (this.mEa.hsl != null))
        {
          paramBallInfo = this.mEa.hsl.getString("processName");
          if (!bt.isNullOrNil(paramBallInfo))
          {
            ad.d("MicroMsg.FloatBallService", "markMessageBallInfo reset processName: %s", new Object[] { paramBallInfo });
            this.mEa.hsl.putString("processName", "");
          }
        }
      }
      AppMethodBeat.o(190617);
      return;
    }
  }
  
  public final void setEnableClick(boolean paramBoolean)
  {
    AppMethodBeat.i(190615);
    Object localObject = com.tencent.mm.plugin.ball.ui.d.bAe();
    if (((com.tencent.mm.plugin.ball.ui.d)localObject).bAf())
    {
      localObject = ((com.tencent.mm.plugin.ball.ui.d)localObject).mFi;
      if (((com.tencent.mm.plugin.ball.ui.a)localObject).mEI != null) {
        ((com.tencent.mm.plugin.ball.ui.a)localObject).mEI.setEnableClick(paramBoolean);
      }
    }
    AppMethodBeat.o(190615);
  }
  
  public final boolean wu(int paramInt)
  {
    AppMethodBeat.i(184576);
    if (com.tencent.mm.plugin.ball.f.d.h(this.mCC))
    {
      Iterator localIterator = this.mCC.iterator();
      while (localIterator.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)localIterator.next();
        if ((localBallInfo.type == paramInt) && (!localBallInfo.mDv))
        {
          AppMethodBeat.o(184576);
          return true;
        }
      }
    }
    AppMethodBeat.o(184576);
    return false;
  }
  
  public final void wv(int paramInt)
  {
    this.aYR = paramInt;
  }
  
  public final void ww(int paramInt)
  {
    AppMethodBeat.i(190619);
    if ((this.mDZ != null) && (this.mDZ.aTB == paramInt))
    {
      ad.i("MicroMsg.FloatBallService", "alvinluo removeMessageBall type: %d", new Object[] { Integer.valueOf(paramInt) });
      k(this.mDZ);
    }
    AppMethodBeat.o(190619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.d
 * JD-Core Version:    0.7.0.1
 */