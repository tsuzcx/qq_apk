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
import com.tencent.mm.plugin.appbrand.backgroundrunning.h.a;
import com.tencent.mm.plugin.ball.c.f;
import com.tencent.mm.plugin.ball.c.h;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.ball.ui.FloatBallProxyUI;
import com.tencent.mm.plugin.ball.ui.FloatBallProxyUI.a;
import com.tencent.mm.plugin.ball.view.FloatBallView;
import com.tencent.mm.plugin.ball.view.FloatBallView.5;
import com.tencent.mm.plugin.ball.view.FloatBallView.6;
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
  private static d nGx;
  volatile int bjY;
  private final List<BallInfo> nFa;
  private Map<String, ResultReceiver> nGA;
  private volatile BallInfo nGB;
  private volatile BallInfo nGC;
  private volatile boolean nGD;
  volatile boolean nGE;
  volatile boolean nGF;
  volatile boolean nGG;
  private volatile boolean nGH;
  private volatile boolean nGI;
  private volatile long nGJ;
  private volatile int nGK;
  private volatile int nGL;
  private volatile boolean nGM;
  private View nGN;
  private volatile BallInfo nGO;
  private int nGP;
  private Set<com.tencent.mm.plugin.ball.c.e> nGy;
  private SparseArray<Set<f>> nGz;
  
  private d()
  {
    AppMethodBeat.i(106097);
    this.nFa = new Vector();
    this.nGy = new CopyOnWriteArraySet();
    this.nGz = new SparseArray();
    this.nGA = new ConcurrentHashMap();
    this.nGB = null;
    this.nGC = null;
    this.nGD = false;
    this.nGE = false;
    this.nGF = false;
    this.nGG = false;
    this.nGH = false;
    this.nGI = true;
    this.nGJ = 0L;
    this.nGK = 0;
    this.nGL = 0;
    this.bjY = 0;
    this.nGM = false;
    this.nGO = null;
    this.nGP = -1;
    AppMethodBeat.o(106097);
  }
  
  private void A(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(217271);
    ad.d("MicroMsg.FloatBallService", "onFloatBallAdded %s", new Object[] { paramBallInfo });
    com.tencent.mm.plugin.ball.ui.d.bLk().a(this.nFa.size(), paramBallInfo);
    AppMethodBeat.o(217271);
  }
  
  private void B(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(217272);
    com.tencent.mm.plugin.ball.ui.d.bLk().b(this.nFa.size(), paramBallInfo);
    AppMethodBeat.o(217272);
  }
  
  private void C(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(217273);
    int j = this.nGz.size();
    int i = 0;
    while (i < j)
    {
      int k = this.nGz.keyAt(i);
      Object localObject = (Set)this.nGz.get(k);
      if (com.tencent.mm.plugin.ball.f.d.h((Collection)localObject))
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((f)((Iterator)localObject).next()).h(paramBallInfo);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(217273);
  }
  
  private void D(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106133);
    Object localObject = (Set)this.nGz.get(paramBallInfo.type);
    if (com.tencent.mm.plugin.ball.f.d.h((Collection)localObject))
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((f)((Iterator)localObject).next()).d(paramBallInfo);
      }
    }
    AppMethodBeat.o(106133);
  }
  
  private void E(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(217275);
    paramBallInfo = i(paramBallInfo);
    if ((paramBallInfo != null) && (paramBallInfo.nFX))
    {
      ad.i("MicroMsg.FloatBallService", "removeAppBrandPassiveBallInfo, remove existedBallInfo:%s", new Object[] { paramBallInfo });
      paramBallInfo.nFZ.opType = 10;
      m(paramBallInfo);
    }
    AppMethodBeat.o(217275);
  }
  
  private void O(Bundle paramBundle)
  {
    AppMethodBeat.i(217274);
    Iterator localIterator = this.nGA.values().iterator();
    while (localIterator.hasNext()) {
      ((ResultReceiver)localIterator.next()).send(1, paramBundle);
    }
    AppMethodBeat.o(217274);
  }
  
  private void a(com.tencent.mm.plugin.ball.c.e parame)
  {
    AppMethodBeat.i(106138);
    this.nGy.add(parame);
    AppMethodBeat.o(106138);
  }
  
  private boolean a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184580);
    boolean bool = bKP();
    ad.i("MicroMsg.FloatBallService", "updateBallVisibilityByKbHeight isVoipShowing: %b", new Object[] { Boolean.valueOf(bool) });
    if ((bool) && (!this.nGM) && (this.nGH))
    {
      this.nGH = false;
      if ((this.nGN != null) && (this.nGN.getVisibility() != 0))
      {
        ad.d("MicroMsg.FloatBallService", "alvinluo updateBallVisibilityByKbHeight has voip but not visible and delay show animation");
        this.nGN.setVisibility(0);
        this.nGN.setAlpha(0.0F);
        a(true, false, paramAnimatorListenerAdapter);
        AppMethodBeat.o(184580);
        return true;
      }
      ad.d("MicroMsg.FloatBallService", "alvinluo updateBallVisibilityByKbHeight has voip and visible, not need to show");
      AppMethodBeat.o(184580);
      return false;
    }
    int j = bKW();
    int k = com.tencent.mm.plugin.ball.ui.d.bLk().getPositionY();
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
      ad.i("MicroMsg.FloatBallService", "updateBallVisibilityByKbHeight, ballPositionY:[%s, %s], keyboardHeight:%s, screenHeight:%s, extraHeight: %d, hide: %b, checkBottomShadow: %b, checkExtraHeight: %b", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(this.bjY), Integer.valueOf(paramInt2), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      if (!bool) {
        break label290;
      }
      this.nGH = true;
      a(true, paramAnimatorListenerAdapter);
      AppMethodBeat.o(184580);
      return true;
      i = 0;
      break;
    }
    label290:
    if (this.nGH)
    {
      this.nGH = false;
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
    this.nGy.remove(parame);
    AppMethodBeat.o(106139);
  }
  
  private void b(BallInfo paramBallInfo, int paramInt)
  {
    AppMethodBeat.i(106136);
    paramBallInfo = paramBallInfo.bKo();
    ResultReceiver localResultReceiver = (ResultReceiver)this.nGA.get(paramBallInfo);
    if (localResultReceiver != null)
    {
      ad.i("MicroMsg.FloatBallService", "notifyResultReceiver, event:%s, ballInfoHashKey:%s, receiver:%s", new Object[] { Integer.valueOf(paramInt), paramBallInfo, Integer.valueOf(localResultReceiver.hashCode()) });
      localResultReceiver.send(paramInt, new Bundle());
    }
    AppMethodBeat.o(106136);
  }
  
  /* Error */
  public static d bKN()
  {
    // Byte code:
    //   0: ldc_w 342
    //   3: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 344	com/tencent/mm/plugin/ball/service/d:nGx	Lcom/tencent/mm/plugin/ball/service/d;
    //   12: ifnonnull +19 -> 31
    //   15: ldc 2
    //   17: monitorenter
    //   18: new 2	com/tencent/mm/plugin/ball/service/d
    //   21: dup
    //   22: invokespecial 345	com/tencent/mm/plugin/ball/service/d:<init>	()V
    //   25: putstatic 344	com/tencent/mm/plugin/ball/service/d:nGx	Lcom/tencent/mm/plugin/ball/service/d;
    //   28: ldc 2
    //   30: monitorexit
    //   31: ldc 2
    //   33: monitorexit
    //   34: getstatic 344	com/tencent/mm/plugin/ball/service/d:nGx	Lcom/tencent/mm/plugin/ball/service/d;
    //   37: astore_0
    //   38: ldc_w 342
    //   41: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aload_0
    //   45: areturn
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: ldc_w 342
    //   53: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aload_0
    //   57: athrow
    //   58: astore_0
    //   59: ldc 2
    //   61: monitorexit
    //   62: ldc_w 342
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
  
  private BallInfo bKO()
  {
    AppMethodBeat.i(184568);
    if (com.tencent.mm.plugin.ball.f.d.h(this.nFa))
    {
      Iterator localIterator = this.nFa.iterator();
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
  
  private boolean bKP()
  {
    AppMethodBeat.i(184575);
    if ((xS(9)) || (xS(17)))
    {
      AppMethodBeat.o(184575);
      return true;
    }
    AppMethodBeat.o(184575);
    return false;
  }
  
  private void bKQ()
  {
    AppMethodBeat.i(184571);
    BallInfo localBallInfo;
    if (com.tencent.mm.plugin.ball.f.d.h(this.nFa))
    {
      Iterator localIterator = this.nFa.iterator();
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
        m(localBallInfo);
        AppMethodBeat.o(184571);
        return;
      }
      ad.i("MicroMsg.FloatBallService", "removeLocationBackgroundBallInfoIfNeed, ignore");
      AppMethodBeat.o(184571);
      return;
      localBallInfo = null;
    }
  }
  
  private void bKR()
  {
    AppMethodBeat.i(184572);
    if (g.ajx())
    {
      e.bKX();
      List localList = e.bLa();
      bL(localList);
      this.nFa.clear();
      this.nFa.addAll(localList);
      this.nGD = true;
      aq.o(new Runnable()
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
  
  private boolean bKS()
  {
    AppMethodBeat.i(184574);
    BallInfo localBallInfo = i(this.nGO);
    if ((localBallInfo != null) && (com.tencent.mm.plugin.ball.f.d.h(this.nFa)))
    {
      boolean bool = com.tencent.mm.plugin.ball.f.d.f(this.nFa, localBallInfo);
      AppMethodBeat.o(184574);
      return bool;
    }
    AppMethodBeat.o(184574);
    return false;
  }
  
  private int bKT()
  {
    AppMethodBeat.i(106115);
    List localList = com.tencent.mm.plugin.ball.f.d.bQ(this.nFa);
    if (com.tencent.mm.plugin.ball.f.d.h(localList))
    {
      int i = localList.size();
      AppMethodBeat.o(106115);
      return i;
    }
    AppMethodBeat.o(106115);
    return 0;
  }
  
  public static void bKU()
  {
    AppMethodBeat.i(106123);
    com.tencent.mm.plugin.ball.ui.d.bLk().a(false, null);
    AppMethodBeat.o(106123);
  }
  
  private void bKV()
  {
    AppMethodBeat.i(106140);
    List localList = com.tencent.mm.plugin.ball.f.d.bN(new Vector(this.nFa));
    ad.i("MicroMsg.FloatBallService", "notifyFloatBallInfoChanged, originSize: %d, sortedSize: %d, ballInfoList:%s", new Object[] { Integer.valueOf(this.nFa.size()), Integer.valueOf(localList.size()), localList });
    Iterator localIterator = this.nGy.iterator();
    while (localIterator.hasNext())
    {
      ((com.tencent.mm.plugin.ball.c.e)localIterator.next()).a(localList, this.nGO);
      bM(localList);
    }
    AppMethodBeat.o(106140);
  }
  
  private int bKW()
  {
    AppMethodBeat.i(184581);
    int j = com.tencent.mm.plugin.ball.f.e.nIm + com.tencent.mm.plugin.ball.f.e.nIn + com.tencent.mm.plugin.ball.f.e.nIo;
    int i = j;
    if (this.nGN != null) {
      i = Math.max(this.nGN.getMeasuredHeight(), j);
    }
    AppMethodBeat.o(184581);
    return i;
  }
  
  private static void bL(List<BallInfo> paramList)
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
      if ((localBallInfo != null) && (localBallInfo.type == 4) && (localBallInfo.ime != null))
      {
        String str = localBallInfo.ime.getString("processName");
        if (!bt.isNullOrNil(str))
        {
          ad.i("MicroMsg.FloatBallService", "restore with process name: %s", new Object[] { str });
          localBallInfo.ime.putString("processName", "");
        }
      }
    }
    AppMethodBeat.o(184573);
  }
  
  private void bM(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106137);
    if (!this.nGA.isEmpty())
    {
      int i = com.tencent.mm.plugin.ball.f.d.bQ(paramList).size();
      if (this.nGP != i)
      {
        this.nGP = i;
        paramList = new Bundle();
        paramList.putInt("ActiveCount", i);
        Iterator localIterator = this.nGA.values().iterator();
        while (localIterator.hasNext()) {
          ((ResultReceiver)localIterator.next()).send(5, paramList);
        }
      }
    }
    AppMethodBeat.o(106137);
  }
  
  private void iY(boolean paramBoolean)
  {
    AppMethodBeat.i(106107);
    ad.i("MicroMsg.FloatBallService", "markNoFloatBallPage:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.nGE = paramBoolean;
    AppMethodBeat.o(106107);
  }
  
  private void iZ(boolean paramBoolean)
  {
    AppMethodBeat.i(106129);
    Object localObject = i(this.nGO);
    if ((localObject != null) && (com.tencent.mm.plugin.ball.f.d.h(this.nFa)))
    {
      if (com.tencent.mm.plugin.ball.f.d.e(this.nFa, (BallInfo)localObject))
      {
        ad.i("MicroMsg.FloatBallService", "recheckBallInfoList, has other balls, hidden current ball info");
        boolean bool = com.tencent.mm.plugin.ball.ui.d.bLk().bLg();
        ad.i("MicroMsg.FloatBallService", "recheckBallInfoList, canNotShowFloatBall:%s, withFloatBall:%s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
        if ((!bool) && (paramBoolean)) {
          a((BallInfo)localObject, 1.0F);
        }
        Iterator localIterator = this.nFa.iterator();
        while (localIterator.hasNext())
        {
          BallInfo localBallInfo = (BallInfo)localIterator.next();
          if ((!localBallInfo.nFX) && (localBallInfo.nFY) && (!localBallInfo.equals(localObject)))
          {
            localBallInfo.nFY = false;
            b(localBallInfo, 4);
          }
          else if (localBallInfo.equals(localObject))
          {
            localBallInfo.nFY = true;
          }
        }
      }
      if (com.tencent.mm.plugin.ball.f.d.f(this.nFa, (BallInfo)localObject))
      {
        ad.i("MicroMsg.FloatBallService", "recheckBallInfoList, no other balls, make float ball transparent");
        ((BallInfo)localObject).nFY = false;
        a((BallInfo)localObject, 0.0F);
      }
      bKV();
      AppMethodBeat.o(106129);
      return;
    }
    if (this.nGO != null) {}
    for (localObject = this.nGO.bKo();; localObject = "null")
    {
      ad.i("MicroMsg.FloatBallService", "recheckBallInfoList, last enteredBallInfo:%s", new Object[] { localObject });
      break;
    }
  }
  
  private void y(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106117);
    if ((!paramBallInfo.nFX) && (bKT() >= 5))
    {
      ad.i("MicroMsg.FloatBallService", "addBallInfo, already add max count balls:%s", new Object[] { Integer.valueOf(5) });
      if (!paramBallInfo.fJh) {
        b.a(paramBallInfo, this.nFa, true);
      }
      FloatBallProxyUI.a(new FloatBallProxyUI.a()
      {
        public final void xZ(int paramAnonymousInt)
        {
          AppMethodBeat.i(217260);
          ad.i("MicroMsg.FloatBallService", "addBallInfo, show reach count limit callback:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt == 1)
          {
            ad.i("MicroMsg.FloatBallService", "addBallInfo, show float menu view");
            d.bKU();
          }
          AppMethodBeat.o(217260);
        }
      });
      AppMethodBeat.o(106117);
      return;
    }
    if (!this.nFa.contains(paramBallInfo))
    {
      long l = bt.flT();
      paramBallInfo.nFV = l;
      paramBallInfo.createTime = l;
      paramBallInfo.nFZ.opType = -1;
      Object localObject;
      int i;
      if (paramBallInfo.type != 20)
      {
        localObject = paramBallInfo.nFZ;
        if ((paramBallInfo.nFX) && (paramBallInfo.nFZ.nGa == 0)) {
          i = 3;
        }
      }
      for (((BallReportInfo)localObject).nGa = i;; paramBallInfo.nFZ.nGa = 5)
      {
        this.nFa.add(paramBallInfo);
        ad.i("MicroMsg.FloatBallService", "addBallInfo, existed:false, ballInfo:%s", new Object[] { paramBallInfo });
        if (!paramBallInfo.fJh) {
          b.a(paramBallInfo, this.nFa, false);
        }
        A(paramBallInfo);
        iZ(true);
        localObject = new Bundle();
        ((Bundle)localObject).putInt("type", paramBallInfo.type);
        ((Bundle)localObject).putString("key", paramBallInfo.key);
        O((Bundle)localObject);
        C(paramBallInfo);
        ((com.tencent.mm.plugin.handoff.a.a)g.ab(com.tencent.mm.plugin.handoff.a.a.class)).J(paramBallInfo);
        AppMethodBeat.o(106117);
        return;
        i = paramBallInfo.nFZ.nGa;
        break;
      }
    }
    ad.i("MicroMsg.FloatBallService", "addBallInfo, existed:true, replaceExisted: %b, ballInfo:%s", new Object[] { Boolean.valueOf(paramBallInfo.nFW), paramBallInfo });
    if (paramBallInfo.nFW)
    {
      paramBallInfo.nFW = false;
      l(paramBallInfo);
    }
    AppMethodBeat.o(106117);
  }
  
  private void z(final BallInfo paramBallInfo)
  {
    AppMethodBeat.i(217270);
    com.tencent.mm.plugin.ball.ui.d.bLk().c(true, new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(217261);
        super.onAnimationEnd(paramAnonymousAnimator);
        d.this.a(paramBallInfo, 1.0F);
        AppMethodBeat.o(217261);
      }
    });
    AppMethodBeat.o(217270);
  }
  
  public final void a(final int paramInt1, final int paramInt2, boolean paramBoolean, long paramLong)
  {
    boolean bool = false;
    AppMethodBeat.i(184577);
    this.nGK = paramInt1;
    this.nGL = paramInt2;
    this.nGM = paramBoolean;
    if (!com.tencent.mm.plugin.ball.ui.d.bLk().bLl())
    {
      ad.i("MicroMsg.FloatBallService", "KeyboardHeightChanged, no float ball");
      AppMethodBeat.o(184577);
      return;
    }
    if (paramBoolean) {
      iV(true);
    }
    while (paramLong != 0L)
    {
      aq.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(217258);
          d locald = d.this;
          int i = paramInt1;
          int j = paramInt2;
          if (d.b(d.this) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            d.a(locald, i, j, bool);
            AppMethodBeat.o(217258);
            return;
          }
        }
      }, paramLong);
      AppMethodBeat.o(184577);
      return;
      iV(false);
    }
    paramBoolean = bool;
    if (this.nGK != 0) {
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
      Set localSet = (Set)this.nGz.get(paramInt);
      Object localObject = localSet;
      if (localSet == null)
      {
        localObject = new HashSet();
        this.nGz.put(paramInt, localObject);
      }
      ((Set)localObject).add(paramf);
    }
    AppMethodBeat.o(106131);
  }
  
  public final void a(long paramLong, com.tencent.mm.plugin.ball.c.c.a parama)
  {
    int i = 1;
    AppMethodBeat.i(217266);
    if (this.nGC == null)
    {
      ad.w("MicroMsg.FloatBallService", "alvinluo addMessageBall readyMessageBallInfo is invalid");
      if (parama != null) {
        parama.xV(7);
      }
      AppMethodBeat.o(217266);
      return;
    }
    if ((!this.nGI) && (!this.nGG))
    {
      ad.w("MicroMsg.FloatBallService", "alvinluo addMessageBall isWechatForeground: %b", new Object[] { Boolean.valueOf(this.nGI) });
      if (parama != null) {
        parama.xV(6);
      }
      this.nGC = null;
      AppMethodBeat.o(217266);
      return;
    }
    if (!com.tencent.mm.plugin.ball.f.d.a(this.nGC, paramLong))
    {
      ad.w("MicroMsg.FloatBallService", "alvinluo addMessageBall can not add message ball because of time over limit");
      if (parama != null) {
        parama.xV(5);
      }
      this.nGC = null;
      AppMethodBeat.o(217266);
      return;
    }
    if (this.nGB == null)
    {
      this.nGB = new BallInfo(20, this.nGC.key);
      this.nGB.v(this.nGC);
      ad.i("MicroMsg.FloatBallService", "alvinluo addMessageBall existed: false, and add: %s", new Object[] { this.nGB });
      k(this.nGB);
      this.nGC = null;
      if (parama != null) {
        parama.xV(i);
      }
      AppMethodBeat.o(217266);
      return;
    }
    BallInfo localBallInfo = this.nGC;
    if (this.nGB == null) {
      ad.w("MicroMsg.FloatBallService", "alvinluo updateMessageBall messageBallInfo is null and ignore");
    }
    for (;;)
    {
      if ((this.nGB != null) && (!this.nGB.fJh))
      {
        this.nGB.nFZ.nGa = 6;
        b.a(this.nGB, this.nFa, false);
      }
      i = 2;
      break;
      if (i(this.nGB) != null)
      {
        this.nGB.v(localBallInfo);
        this.nGB.key = localBallInfo.key;
        ad.i("MicroMsg.FloatBallService", "alvinluo updateMessageBall existed: true, and update %s", new Object[] { this.nGB });
        l(this.nGB);
      }
      else
      {
        ad.w("MicroMsg.FloatBallService", "alvinluo updateMessageBall messageBallInfo not null but not added!!");
      }
    }
  }
  
  public final void a(ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(217268);
    com.tencent.mm.plugin.ball.ui.d.bLk().a(true, paramResultReceiver);
    AppMethodBeat.o(217268);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(106112);
    if (paramh != null)
    {
      if (com.tencent.mm.plugin.ball.f.d.h(this.nFa))
      {
        paramh.bo(new ArrayList(this.nFa));
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
    if ((paramFloat == 1.0F) || (com.tencent.mm.plugin.ball.f.d.f(this.nFa, paramBallInfo))) {
      aq.f(new com.tencent.mm.plugin.ball.ui.d.2(com.tencent.mm.plugin.ball.ui.d.bLk(), paramFloat));
    }
    AppMethodBeat.o(106122);
  }
  
  public final void a(BallInfo paramBallInfo, ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(106134);
    if ((paramBallInfo != null) && (paramResultReceiver != null))
    {
      paramBallInfo = paramBallInfo.bKo();
      ad.i("MicroMsg.FloatBallService", "registerFloatBallEventReceiver, key:%s, receiver:%s", new Object[] { paramBallInfo, Integer.valueOf(paramResultReceiver.hashCode()) });
      this.nGA.put(paramBallInfo, paramResultReceiver);
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
        paramBallInfo.nFY = bool;
        ad.i("MicroMsg.FloatBallService", "updateBallVisibility, existed:true, visible:%s, ballInfo:%s", new Object[] { Boolean.valueOf(paramBoolean), paramBallInfo });
        bKV();
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
    if ((paramAppBrandBackgroundRunningOperationParcel.dkM == 2) || (paramAppBrandBackgroundRunningOperationParcel.dkM == 3))
    {
      if ((paramAppBrandBackgroundRunningOperationParcel.beO & 0x2) > 0) {
        E(new BallInfo(7, com.tencent.mm.plugin.ball.f.b.cq(paramAppBrandBackgroundRunningOperationParcel.appId, paramAppBrandBackgroundRunningOperationParcel.hQh)));
      }
      if ((paramAppBrandBackgroundRunningOperationParcel.beO & 0x4) > 0)
      {
        paramList = paramAppBrandBackgroundRunningOperationParcel.appId;
        paramInt = paramAppBrandBackgroundRunningOperationParcel.hQh;
        E(new BallInfo(17, String.format(Locale.US, "%s#%d", new Object[] { paramList, Integer.valueOf(paramInt) })));
      }
      if ((paramAppBrandBackgroundRunningOperationParcel.beO & 0x8) > 0) {
        E(new BallInfo(18, com.tencent.mm.plugin.ball.f.b.cp(paramAppBrandBackgroundRunningOperationParcel.appId, paramAppBrandBackgroundRunningOperationParcel.hQh)));
      }
      if ((paramAppBrandBackgroundRunningOperationParcel.beO & 0x10) > 0) {
        E(new BallInfo(19, com.tencent.mm.plugin.ball.f.b.cp(paramAppBrandBackgroundRunningOperationParcel.appId, paramAppBrandBackgroundRunningOperationParcel.hQh)));
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
    if (this.nGG)
    {
      ad.i("MicroMsg.FloatBallService", "hideFloatBall, has marked QB file view page, ignore hiding");
      AppMethodBeat.o(184567);
      return;
    }
    if ((bKP()) && (!this.nGF)) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.FloatBallService", "hideFloatBall forceHide: %b, canShowFloatBall: %b, voipInfo: %s", new Object[] { Boolean.valueOf(this.nGF), Boolean.valueOf(bool), bKO() });
      if (!bool) {
        break;
      }
      AppMethodBeat.o(184567);
      return;
    }
    com.tencent.mm.plugin.ball.ui.d.bLk().e(paramBoolean, paramAnimatorListenerAdapter);
    AppMethodBeat.o(184567);
  }
  
  final void a(boolean paramBoolean1, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184570);
    if (!com.tencent.mm.compatible.d.b.ca(aj.getContext()))
    {
      ad.i("MicroMsg.FloatBallService", "resumeFloatBall, no float window permission");
      bKQ();
      com.tencent.mm.plugin.ball.ui.d.bLk().bLm();
      this.nGD = false;
      this.nFa.clear();
      e.bKX().clear();
      bKV();
      AppMethodBeat.o(184570);
      return;
    }
    if (this.nGD)
    {
      if ((this.nGE) && (!bKP()))
      {
        ad.i("MicroMsg.FloatBallService", "resumeFloatBall, has marked no float ball page, ignore resuming");
        AppMethodBeat.o(184570);
        return;
      }
      if (this.nGF)
      {
        ad.i("MicroMsg.FloatBallService", "resumeFloatBall, has marked forceHideAllFloatBall, ignore resuming");
        AppMethodBeat.o(184570);
        return;
      }
      if (this.nGH)
      {
        ad.i("MicroMsg.FloatBallService", "resumeFloatBall, hasHideForKeyboardHeightChange, ignore resuming");
        AppMethodBeat.o(184570);
        return;
      }
      if (!bKS())
      {
        ad.i("MicroMsg.FloatBallService", "resumeFloatBall not singleBallInfoCondition, withAnimation:%s", new Object[] { Boolean.valueOf(paramBoolean1) });
        com.tencent.mm.plugin.ball.ui.d.bLk().b(paramBoolean1, paramBoolean2, paramAnimatorListenerAdapter);
        AppMethodBeat.o(184570);
        return;
      }
      ad.i("MicroMsg.FloatBallService", "resumeFloatBall singleBallInfoCondition, withAnimation:false");
      com.tencent.mm.plugin.ball.ui.d.bLk().b(false, paramBoolean2, paramAnimatorListenerAdapter);
      c(this.nGO, true);
      AppMethodBeat.o(184570);
      return;
    }
    ad.i("MicroMsg.FloatBallService", "resumeFloatBall, restore data from storage");
    bKR();
    AppMethodBeat.o(184570);
  }
  
  public final void akx()
  {
    AppMethodBeat.i(106099);
    ad.i("MicroMsg.FloatBallService", "onRegister:%s", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(106099);
  }
  
  public final void aky()
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
      Set localSet = (Set)this.nGz.get(paramInt);
      if (localSet != null) {
        localSet.remove(paramf);
      }
    }
    AppMethodBeat.o(106132);
  }
  
  public final void bJV()
  {
    AppMethodBeat.i(106105);
    ad.i("MicroMsg.FloatBallService", "onAccountInitialized:%s", new Object[] { Integer.valueOf(hashCode()) });
    a(com.tencent.mm.plugin.ball.ui.d.bLk());
    a(e.bKX());
    this.nGD = false;
    a(true, true, null);
    AppMethodBeat.o(106105);
  }
  
  public final boolean bJW()
  {
    return this.nGE;
  }
  
  public final boolean bJX()
  {
    return this.nGG;
  }
  
  public final long bJY()
  {
    return this.nGJ;
  }
  
  public final void bJZ()
  {
    AppMethodBeat.i(106109);
    iT(false);
    iY(false);
    if (this.nGO != null)
    {
      ad.i("MicroMsg.FloatBallService", "fixFloatBallIfNeed, lastEnteredBallInfo:%s", new Object[] { this.nGO });
      r(i(this.nGO));
      AppMethodBeat.o(106109);
      return;
    }
    ad.i("MicroMsg.FloatBallService", "fixFloatBallIfNeed, safe");
    AppMethodBeat.o(106109);
  }
  
  public final void bKa()
  {
    AppMethodBeat.i(106111);
    bd.aI(aj.getContext(), 2131766133);
    AppMethodBeat.o(106111);
  }
  
  public final List<BallInfo> bKb()
  {
    return this.nFa;
  }
  
  public final void bKc()
  {
    this.nGN = null;
  }
  
  public final boolean bKd()
  {
    return this.nGF;
  }
  
  public final void bKe()
  {
    AppMethodBeat.i(184565);
    com.tencent.mm.plugin.ball.ui.d locald = com.tencent.mm.plugin.ball.ui.d.bLk();
    if (locald.bLl()) {
      locald.nHJ.bKe();
    }
    AppMethodBeat.o(184565);
  }
  
  public final void bKf()
  {
    AppMethodBeat.i(184566);
    com.tencent.mm.plugin.ball.ui.d locald = com.tencent.mm.plugin.ball.ui.d.bLk();
    if (locald.bLl()) {
      locald.nHJ.bKf();
    }
    AppMethodBeat.o(184566);
  }
  
  public final void bKg()
  {
    AppMethodBeat.i(217263);
    Object localObject = bKO();
    int j;
    if (localObject != null)
    {
      ((BallInfo)localObject).state = 8;
      localObject = com.tencent.mm.plugin.ball.ui.d.bLk().nHJ;
      if (((com.tencent.mm.plugin.ball.ui.a)localObject).nHj != null)
      {
        localObject = ((com.tencent.mm.plugin.ball.ui.a)localObject).nHj;
        ad.i("MicroMsg.FloatBallView", "alvinluo switchVoipVoice");
        ((FloatBallView)localObject).nLt = 80;
        j = ((FloatBallView)localObject).nLt;
        if (!((FloatBallView)localObject).nLh) {
          break label238;
        }
      }
    }
    label238:
    for (int i = 8388611;; i = 8388613)
    {
      ((FloatBallView)localObject).yj(i | j);
      FrameLayout localFrameLayout = ((FloatBallView)localObject).nKB;
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localFrameLayout.getLayoutParams();
      Point localPoint1 = ((FloatBallView)localObject).getVoipVideoViewSize();
      Point localPoint2 = ((FloatBallView)localObject).getVoipAudioViewSize();
      ad.i("MicroMsg.FloatBallView", "alvinluo switchVoipVoice targetWidth: %d, targetHeight: %d, current: %d, %d", new Object[] { Integer.valueOf(localPoint2.x), Integer.valueOf(localPoint2.y), Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator.setDuration(300L);
      localValueAnimator.addListener(new FloatBallView.5((FloatBallView)localObject, localPoint1, localPoint2));
      localValueAnimator.addUpdateListener(new FloatBallView.6((FloatBallView)localObject, localLayoutParams, localPoint1, localPoint2, localFrameLayout));
      localValueAnimator.start();
      AppMethodBeat.o(217263);
      return;
    }
  }
  
  final void c(BallInfo paramBallInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(106127);
    BallInfo localBallInfo = i(paramBallInfo);
    if (localBallInfo != null)
    {
      localBallInfo.nFV = bt.flT();
      this.nGO = localBallInfo;
      ad.i("MicroMsg.FloatBallService", "onEnterBallInfoPage, set lastEnteredBallInfo:%s", new Object[] { this.nGO.bKo() });
      iZ(paramBoolean);
      AppMethodBeat.o(106127);
      return;
    }
    if (paramBallInfo != null) {}
    for (paramBallInfo = paramBallInfo.bKo();; paramBallInfo = "null")
    {
      ad.i("MicroMsg.FloatBallService", "onEnterBallInfoPage, no this ball info:%s", new Object[] { paramBallInfo });
      AppMethodBeat.o(106127);
      return;
    }
  }
  
  public final boolean c(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(184579);
    if (!com.tencent.mm.plugin.ball.ui.d.bLk().bLl())
    {
      ad.i("MicroMsg.FloatBallService", "updateBallVisibilityByPosition, no float ball");
      AppMethodBeat.o(184579);
      return false;
    }
    if (!this.nGM)
    {
      ad.i("MicroMsg.FloatBallService", "updateBallVisibilityByPosition keyboard not show and ignore");
      AppMethodBeat.o(184579);
      return false;
    }
    boolean bool = a(this.nGK, this.nGL, false, false, paramAnimatorListenerAdapter);
    AppMethodBeat.o(184579);
    return bool;
  }
  
  public final void dw(View paramView)
  {
    this.nGN = paramView;
  }
  
  public final Point getBallPosition()
  {
    AppMethodBeat.i(106121);
    Object localObject1 = com.tencent.mm.plugin.ball.ui.d.bLk();
    if (((com.tencent.mm.plugin.ball.ui.d)localObject1).bLl())
    {
      localObject1 = ((com.tencent.mm.plugin.ball.ui.d)localObject1).nHJ;
      if (((com.tencent.mm.plugin.ball.ui.a)localObject1).nHj != null) {
        localObject1 = ((com.tencent.mm.plugin.ball.ui.a)localObject1).nHj.getBallPosition();
      }
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new Point(com.tencent.mm.plugin.ball.f.d.bLt(), com.tencent.mm.plugin.ball.f.d.bLu());
      }
      ad.i("MicroMsg.FloatBallService", "getBallPosition, position:[%s, %s]", new Object[] { Integer.valueOf(((Point)localObject2).x), Integer.valueOf(((Point)localObject2).y) });
      AppMethodBeat.o(106121);
      return localObject2;
      localObject1 = new Point(com.tencent.mm.plugin.ball.f.d.bLt(), com.tencent.mm.plugin.ball.f.d.bLu());
      continue;
      localObject1 = new Point(com.tencent.mm.plugin.ball.f.d.bLt(), com.tencent.mm.plugin.ball.f.d.bLu());
    }
  }
  
  public final BallInfo i(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106113);
    synchronized (this.nFa)
    {
      if (this.nFa.contains(paramBallInfo))
      {
        paramBallInfo = (BallInfo)this.nFa.get(this.nFa.indexOf(paramBallInfo));
        ad.i("MicroMsg.FloatBallService", "getBallInfo, existed:true, responseBallInfo:%s", new Object[] { paramBallInfo });
        AppMethodBeat.o(106113);
        return paramBallInfo;
      }
      ad.i("MicroMsg.FloatBallService", "getBallInfo, existed:false");
      AppMethodBeat.o(106113);
      return null;
    }
  }
  
  public final void iN(boolean paramBoolean)
  {
    AppMethodBeat.i(106101);
    a(paramBoolean, null);
    AppMethodBeat.o(106101);
  }
  
  public final void iO(boolean paramBoolean)
  {
    AppMethodBeat.i(106102);
    a(paramBoolean, true, null);
    AppMethodBeat.o(106102);
  }
  
  public final void iP(boolean paramBoolean)
  {
    AppMethodBeat.i(106103);
    iY(true);
    a(paramBoolean, null);
    AppMethodBeat.o(106103);
  }
  
  public final void iQ(boolean paramBoolean)
  {
    AppMethodBeat.i(106104);
    iY(false);
    a(paramBoolean, true, null);
    AppMethodBeat.o(106104);
  }
  
  public final void iR(boolean paramBoolean)
  {
    AppMethodBeat.i(217264);
    com.tencent.mm.plugin.ball.ui.d.bLk().c(paramBoolean, new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(217257);
        super.onAnimationEnd(paramAnonymousAnimator);
        d.this.a(null, 1.0F);
        AppMethodBeat.o(217257);
      }
    });
    AppMethodBeat.o(217264);
  }
  
  public final void iS(boolean paramBoolean)
  {
    AppMethodBeat.i(176960);
    ad.i("MicroMsg.FloatBallService", "markWechatInForeground, foreground:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.nGI = paramBoolean;
    if (this.nGG)
    {
      ad.i("MicroMsg.FloatBallService", "markWechatInForeground, has marked QB file view page, mark Wechat in foreground");
      com.tencent.mm.plugin.ball.ui.d.bLk().iS(true);
    }
    for (;;)
    {
      if (!this.nGI)
      {
        ad.i("MicroMsg.FloatBallService", "alvinluo resetReadyStatusBallInfo");
        this.nGC = null;
      }
      AppMethodBeat.o(176960);
      return;
      com.tencent.mm.plugin.ball.ui.d.bLk().iS(paramBoolean);
    }
  }
  
  public final void iT(boolean paramBoolean)
  {
    AppMethodBeat.i(106108);
    ad.i("MicroMsg.FloatBallService", "markQBFileViewPage:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.nGG = paramBoolean;
    AppMethodBeat.o(106108);
  }
  
  public final void iU(boolean paramBoolean)
  {
    AppMethodBeat.i(184564);
    com.tencent.mm.plugin.ball.ui.d locald = com.tencent.mm.plugin.ball.ui.d.bLk();
    if (locald.bLl()) {
      locald.nHJ.nHm = paramBoolean;
    }
    AppMethodBeat.o(184564);
  }
  
  public final void iV(boolean paramBoolean)
  {
    AppMethodBeat.i(185124);
    ad.i("MicroMsg.FloatBallService", "markForceHideAllFloatBall %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.nGF = paramBoolean;
    com.tencent.mm.plugin.ball.ui.d.bLk().nGF = paramBoolean;
    AppMethodBeat.o(185124);
  }
  
  public final boolean j(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106114);
    if (bKT() >= 5)
    {
      ad.i("MicroMsg.FloatBallService", "canAddBallInfo, false");
      if (!paramBallInfo.fJh) {
        b.a(paramBallInfo, this.nFa, true);
      }
      AppMethodBeat.o(106114);
      return false;
    }
    ad.i("MicroMsg.FloatBallService", "canAddBallInfo, true");
    AppMethodBeat.o(106114);
    return true;
  }
  
  public final void k(final BallInfo paramBallInfo)
  {
    int j = 0;
    AppMethodBeat.i(106116);
    if ((paramBallInfo.type == 6) && (paramBallInfo.nFZ.nGb == 11)) {}
    for (int i = 1; (i != 0) && (!com.tencent.mm.compatible.d.b.ca(aj.getContext())); i = 0)
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
        public final void ge(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(217259);
          if (paramAnonymousBoolean)
          {
            d.a(d.this, paramBallInfo);
            AppMethodBeat.o(217259);
            return;
          }
          ad.w("MicroMsg.FloatBallService", "no float window permission");
          AppMethodBeat.o(217259);
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
    y(paramBallInfo);
    AppMethodBeat.o(106116);
  }
  
  public final void l(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106118);
    BallInfo localBallInfo = i(paramBallInfo);
    if (localBallInfo != null)
    {
      localBallInfo.v(paramBallInfo);
      ad.i("MicroMsg.FloatBallService", "updateBallInfo, existed:true, ballInfo:%s", new Object[] { localBallInfo });
      bKV();
      AppMethodBeat.o(106118);
      return;
    }
    ad.i("MicroMsg.FloatBallService", "updateBallInfo, existed:false");
    AppMethodBeat.o(106118);
  }
  
  public final void m(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106119);
    if (this.nFa.contains(paramBallInfo))
    {
      if (paramBallInfo.type == 9)
      {
        com.tencent.mm.plugin.ball.ui.d.bLk().bLf();
        paramBallInfo.vd = null;
      }
      this.nFa.remove(paramBallInfo);
      e.bKX().m(paramBallInfo);
      b.b(paramBallInfo, this.nFa.isEmpty());
      ad.i("MicroMsg.FloatBallService", "removeBallInfo, existed:true, ballInfo:%s", new Object[] { paramBallInfo });
      if ((this.nGO != null) && (this.nGO.equals(paramBallInfo)))
      {
        ad.i("MicroMsg.FloatBallService", "removeBallInfo, remove last enteredBallInfo");
        this.nGO = null;
      }
      B(paramBallInfo);
      iZ(true);
      b(paramBallInfo, 3);
      D(paramBallInfo);
      ((com.tencent.mm.plugin.handoff.a.a)g.ab(com.tencent.mm.plugin.handoff.a.a.class)).del(paramBallInfo.key);
      if (paramBallInfo.equals(this.nGB))
      {
        this.nGB = null;
        AppMethodBeat.o(106119);
      }
    }
    else
    {
      ad.i("MicroMsg.FloatBallService", "removeBallInfo, existed:false");
    }
    AppMethodBeat.o(106119);
  }
  
  public final void n(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106124);
    int i = paramBallInfo.nFZ.opType;
    if ((i == 1) || (i == 2) || (i == 3)) {}
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        ad.w("MicroMsg.FloatBallReportLogic", "activeBallTypeReport unexpected opType:%d", new Object[] { Integer.valueOf(paramBallInfo.nFZ.opType) });
        paramBallInfo.nFZ.opType = 3;
      }
      b.a(paramBallInfo, bt.flT() - paramBallInfo.nFV, 0L, 0L, 0L);
      c(paramBallInfo, true);
      int j = paramBallInfo.type;
      i = j;
      if (j == 20) {
        i = paramBallInfo.beN;
      }
      ad.d("MicroMsg.FloatBallService", "alvinluo notifySingleBallInfoClicked type: %d, contentType: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramBallInfo.beN) });
      Object localObject = (Set)this.nGz.get(i);
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
  
  public final void o(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106120);
    if (this.nFa.contains(paramBallInfo))
    {
      Object localObject = (Set)this.nGz.get(paramBallInfo.type);
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
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(106106);
    ad.i("MicroMsg.FloatBallService", "onAccountRelease:%s", new Object[] { Integer.valueOf(hashCode()) });
    b(com.tencent.mm.plugin.ball.ui.d.bLk());
    b(e.bKX());
    this.nGD = false;
    com.tencent.mm.plugin.ball.ui.d.bLk().bLm();
    AppMethodBeat.o(106106);
  }
  
  public final void p(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(221371);
    c(paramBallInfo, true);
    AppMethodBeat.o(221371);
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
    if (this.nGO != null)
    {
      localObject = this.nGO.bKo();
      ad.i("MicroMsg.FloatBallService", "onExitBallInfoPage, lastEnteredBallInfo:%s", new Object[] { localObject });
      this.nGO = null;
      localObject = i(paramBallInfo);
      if (localObject == null) {
        break label147;
      }
      ad.i("MicroMsg.FloatBallService", "onExitBallInfoPage, ballInfo:%s", new Object[] { localObject });
      if (((BallInfo)localObject).nFZ.opType != -1) {
        break label132;
      }
      ((BallInfo)localObject).nFZ.opType = 0;
      label87:
      if (com.tencent.mm.plugin.ball.ui.d.bLk().bLg()) {
        break label139;
      }
      a(paramBallInfo, 1.0F);
    }
    for (;;)
    {
      if (!((BallInfo)localObject).nFY) {
        break label160;
      }
      ((BallInfo)localObject).nFY = false;
      bKV();
      AppMethodBeat.o(106128);
      return;
      localObject = "null";
      break;
      label132:
      b.x((BallInfo)localObject);
      break label87;
      label139:
      z(paramBallInfo);
    }
    label147:
    ad.i("MicroMsg.FloatBallService", "onExitBallInfoPage, no this ball info");
    z(paramBallInfo);
    label160:
    AppMethodBeat.o(106128);
  }
  
  public final void s(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106135);
    String str;
    if (paramBallInfo != null)
    {
      str = paramBallInfo.bKo();
      paramBallInfo = (ResultReceiver)this.nGA.remove(str);
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
  
  public final void setEnableClick(boolean paramBoolean)
  {
    AppMethodBeat.i(217262);
    Object localObject = com.tencent.mm.plugin.ball.ui.d.bLk();
    if (((com.tencent.mm.plugin.ball.ui.d)localObject).bLl())
    {
      localObject = ((com.tencent.mm.plugin.ball.ui.d)localObject).nHJ;
      if (((com.tencent.mm.plugin.ball.ui.a)localObject).nHj != null) {
        ((com.tencent.mm.plugin.ball.ui.a)localObject).nHj.setEnableClick(paramBoolean);
      }
    }
    AppMethodBeat.o(217262);
  }
  
  public final void t(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(217265);
    if (paramBallInfo == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.FloatBallService", "alvinluo markMessageBallInfo ballInfo == null: %b, %s, readyInfo == null: %b", new Object[] { Boolean.valueOf(bool), paramBallInfo, this.nGC });
      if (paramBallInfo != null)
      {
        if (this.nGC == null) {
          this.nGC = new BallInfo(20, paramBallInfo.key);
        }
        this.nGC.v(paramBallInfo);
        this.nGC.key = paramBallInfo.key;
        this.nGC.type = 20;
        this.nGC.state = 256;
        this.nGC.nFY = false;
        this.nGC.nFX = true;
        this.nGC.fMf = System.currentTimeMillis();
        if ((paramBallInfo.type == 4) && (this.nGC.ime != null))
        {
          paramBallInfo = this.nGC.ime.getString("processName");
          if (!bt.isNullOrNil(paramBallInfo))
          {
            ad.d("MicroMsg.FloatBallService", "markMessageBallInfo reset processName: %s", new Object[] { paramBallInfo });
            this.nGC.ime.putString("processName", "");
          }
        }
      }
      AppMethodBeat.o(217265);
      return;
    }
  }
  
  public final void te(long paramLong)
  {
    this.nGJ = paramLong;
  }
  
  public final boolean xS(int paramInt)
  {
    AppMethodBeat.i(184576);
    if (com.tencent.mm.plugin.ball.f.d.h(this.nFa))
    {
      Iterator localIterator = this.nFa.iterator();
      while (localIterator.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)localIterator.next();
        if ((localBallInfo.type == paramInt) && (!localBallInfo.nFY))
        {
          AppMethodBeat.o(184576);
          return true;
        }
      }
    }
    AppMethodBeat.o(184576);
    return false;
  }
  
  public final void xT(int paramInt)
  {
    this.bjY = paramInt;
  }
  
  public final void xU(int paramInt)
  {
    AppMethodBeat.i(217267);
    if ((this.nGB != null) && (this.nGB.beN == paramInt))
    {
      ad.i("MicroMsg.FloatBallService", "alvinluo removeMessageBall type: %d", new Object[] { Integer.valueOf(paramInt) });
      m(this.nGB);
    }
    AppMethodBeat.o(217267);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.d
 * JD-Core Version:    0.7.0.1
 */