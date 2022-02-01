package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.tencent.luggage.k.l;
import com.tencent.luggage.wxa.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.h.f;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.page.b.f;
import com.tencent.mm.plugin.appbrand.page.b.i;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import junit.framework.Assert;
import kotlin.g.a.a;

@SuppressLint({"ViewConstructor"})
public class x
  extends FrameLayout
{
  static final int qqJ = a.d.app_brand_page_attached_animator;
  private String mAppId;
  private volatile boolean mDestroyed;
  private AppBrandRuntime nxs;
  private boolean qqK;
  private boolean qqL;
  private a qqM;
  private b qqN;
  private final Map<i, com.tencent.mm.plugin.appbrand.page.b.e> qqO;
  private final byte[] qqP;
  private final LinkedList<u> qqQ;
  private final LinkedList<u> qqR;
  private final LinkedList<c> qqS;
  private ad qqT;
  private boolean qqU;
  private u qqV;
  private bz qqW;
  final az qqX;
  private boolean qqY;
  private f qqZ;
  private i qra;
  private x.h qrb;
  private boolean qrc;
  private e qrd;
  
  public x(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramContext);
    AppMethodBeat.i(135048);
    this.mDestroyed = false;
    this.qqK = false;
    this.qqL = false;
    this.qqO = new HashMap();
    this.qqP = new byte[0];
    this.qqQ = new LinkedList();
    this.qqR = new LinkedList();
    this.qqS = new LinkedList();
    this.qqU = false;
    this.qqX = new az();
    this.qqY = true;
    this.qra = null;
    this.qrb = null;
    this.qrc = false;
    this.qrd = null;
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "AppBrandPageContainerProfile| <init> appId[%s]", new Object[] { paramAppBrandRuntime.mAppId });
    this.nxs = paramAppBrandRuntime;
    this.mAppId = paramAppBrandRuntime.mAppId;
    this.qqW = new bz.a();
    AppMethodBeat.o(135048);
  }
  
  private Object a(final u paramu, final ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(245817);
    if (paramu == null)
    {
      AppMethodBeat.o(245817);
      return null;
    }
    synchronized (this.qqP)
    {
      this.qqQ.remove(paramu);
      this.qqQ.push(paramu);
      this.qqR.remove(paramu);
      paramu.bringToFront();
      requestLayout();
      invalidate();
      paramu.cdD();
      paramca = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(244251);
          paramu.c(paramca);
          AppMethodBeat.o(244251);
        }
      };
      if (paramBoolean)
      {
        paramu = a(paramu, n(paramu), paramca);
        AppMethodBeat.o(245817);
        return paramu;
      }
    }
    r(paramu);
    paramca.run();
    AppMethodBeat.o(245817);
    return null;
  }
  
  private Object a(final u paramu, Object paramObject, final Runnable paramRunnable)
  {
    AppMethodBeat.i(176598);
    Object localObject;
    if ((paramObject instanceof Animator))
    {
      localObject = (Animator)paramObject;
      r(paramu);
      paramu.setTag(qqJ, localObject);
      ((Animator)localObject).addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(246776);
          paramu.setTag(x.qqJ, null);
          if (paramRunnable != null)
          {
            x.this.removeCallbacks(paramRunnable);
            if (!x.f(x.this)) {
              paramRunnable.run();
            }
          }
          AppMethodBeat.o(246776);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(246778);
          paramu.setTag(x.qqJ, null);
          if (paramRunnable != null) {
            x.this.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(245736);
                if (!x.f(x.this)) {
                  x.20.this.val$runnable.run();
                }
                AppMethodBeat.o(245736);
              }
            });
          }
          AppMethodBeat.o(246778);
        }
      });
      ((Animator)localObject).start();
    }
    for (;;)
    {
      AppMethodBeat.o(176598);
      return paramObject;
      if ((paramObject instanceof Animation))
      {
        localObject = (Animation)paramObject;
        ((Animation)localObject).setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(246488);
            if (paramRunnable != null)
            {
              Runnable local1 = new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(242590);
                  if (!x.f(x.this)) {
                    x.21.this.val$runnable.run();
                  }
                  x.21.this.qrh.setTag(x.qqJ, null);
                  AppMethodBeat.o(242590);
                }
              };
              if (paramAnonymousAnimation.getStartTime() == -9223372036854775808L)
              {
                local1.run();
                AppMethodBeat.o(246488);
                return;
              }
              if (!x.f(x.this)) {
                x.this.post(local1);
              }
              AppMethodBeat.o(246488);
              return;
            }
            paramu.setTag(x.qqJ, null);
            AppMethodBeat.o(246488);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
        r(paramu);
        paramu.setTag(qqJ, localObject);
        paramu.startAnimation((Animation)localObject);
      }
      else
      {
        if (paramObject != null) {
          break;
        }
        if (paramRunnable != null) {
          paramRunnable.run();
        }
      }
    }
    paramu = new IllegalArgumentException("Page animation should be Animator or Animation");
    AppMethodBeat.o(176598);
    throw paramu;
  }
  
  private Object a(u paramu, Runnable paramRunnable)
  {
    AppMethodBeat.i(245829);
    paramu = a(paramu, p(paramu), paramRunnable);
    AppMethodBeat.o(245829);
    return paramu;
  }
  
  private Object a(final u paramu, boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(176595);
    if (paramu == null)
    {
      AppMethodBeat.o(176595);
      return null;
    }
    if (paramBoolean2) {}
    synchronized (this.qqP)
    {
      this.qqQ.remove(paramu);
      this.qqR.remove(paramu);
      paramu.cdE();
      ??? = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(176570);
          if (paramBoolean2) {
            x.a(x.this, paramu);
          }
          AppMethodBeat.o(176570);
        }
      };
      if (paramBoolean1)
      {
        paramu = a(paramu, o(paramu), (Runnable)???);
        AppMethodBeat.o(176595);
        return paramu;
      }
    }
    r(paramu);
    ((Runnable)???).run();
    AppMethodBeat.o(176595);
    return null;
  }
  
  private void a(final ca paramca, final u paramu1, final u paramu2, final x.g paramg)
  {
    AppMethodBeat.i(176599);
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandPageContainer", "processPageSwitchResult, pageSwitchResult: ".concat(String.valueOf(paramg)));
    paramg = paramg.qrF;
    if ((paramg instanceof ValueAnimator))
    {
      paramg = (ValueAnimator)paramg;
      paramg.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(245595);
          super.onAnimationCancel(paramAnonymousAnimator);
          if (x.g(x.this) != null)
          {
            x.g(x.this).f(paramca, paramu1, paramu2);
            x.h(x.this);
          }
          x.this.f(paramca, paramu1, paramu2);
          AppMethodBeat.o(245595);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(245594);
          super.onAnimationEnd(paramAnonymousAnimator);
          x.a(x.this, paramca, paramu1, paramu2);
          AppMethodBeat.o(245594);
        }
      });
      paramg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(243385);
          int i = (int)(paramAnonymousValueAnimator.getAnimatedFraction() * 100.0F);
          if (x.g(x.this) != null) {
            x.g(x.this).aR(i);
          }
          x.this.b(paramca, paramu1, paramu2, i);
          AppMethodBeat.o(243385);
        }
      });
      AppMethodBeat.o(176599);
      return;
    }
    if ((paramg instanceof Animation))
    {
      paramg = (Animation)paramg;
      long l = paramg.getDuration();
      paramca = new Choreographer.FrameCallback()
      {
        public final void doFrame(long paramAnonymousLong)
        {
          AppMethodBeat.i(244188);
          float f = ((float)(SystemClock.elapsedRealtime() - this.qrx) + 0.0F) / (float)paramca;
          if (1.0F <= f)
          {
            x.a(x.this, paramu2, paramg, this.qrw);
            AppMethodBeat.o(244188);
            return;
          }
          int i = (int)(this.qry.getInterpolator().getInterpolation(f) * 100.0F);
          if (x.g(x.this) != null) {
            x.g(x.this).aR(i);
          }
          x.this.b(paramu2, paramg, this.qrw, i);
          Choreographer.getInstance().postFrameCallback(this);
          AppMethodBeat.o(244188);
        }
      };
      Choreographer.getInstance().postFrameCallback(paramca);
      AppMethodBeat.o(176599);
      return;
    }
    b(paramca, paramu1, paramu2);
    AppMethodBeat.o(176599);
  }
  
  private void a(final u paramu1, final u paramu2, final ca paramca, x.h paramh)
  {
    Object localObject2 = null;
    AppMethodBeat.i(176594);
    for (;;)
    {
      synchronized (this.qqP)
      {
        this.qqQ.remove(paramu2);
        this.qqR.remove(paramu2);
        if (!paramu2.mSwiping)
        {
          i = 1;
          if (i == 0) {
            break label193;
          }
          ??? = b(paramu2, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(135035);
              x.a(x.this, paramu2);
              AppMethodBeat.o(135035);
            }
          });
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "switchPageClear, in: %s out: %s", new Object[] { paramu1.getCurrentUrl(), paramu2.getCurrentUrl() });
          com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandPageContainer", "switchPageClear, dispatchRoute, type: %s, pipMode: %s", new Object[] { paramca, paramh });
          paramu1.a(paramca, paramh);
          paramu1.cdD();
          if (i == 0) {
            break label204;
          }
          paramh = a(paramu1, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(176569);
              paramu1.c(paramca);
              AppMethodBeat.o(176569);
            }
          });
          a(paramca, paramu2, paramu1, new x.g(paramh, ???));
          AppMethodBeat.o(176594);
          return;
        }
      }
      int i = 0;
      continue;
      label193:
      k(paramu2);
      ??? = null;
      continue;
      label204:
      paramu1.c(paramca);
      paramh = localObject2;
    }
  }
  
  private boolean alC(String arg1)
  {
    AppMethodBeat.i(245814);
    final u localu = getCurrentPage();
    n localn = alD(???);
    if (localn != null)
    {
      localn.a(???, new n.b()
      {
        public final void b(n paramAnonymousn, String paramAnonymousString)
        {
          AppMethodBeat.i(243762);
          paramAnonymousString = x.this.a(localu, paramAnonymousn, ca.qwE, paramAnonymousString, cb.d(ca.qwE));
          this.qrn[0] = paramAnonymousString;
          paramAnonymousn.a(ca.qwE, this.qrn[0]);
          AppMethodBeat.o(243762);
        }
        
        public final void e(n paramAnonymousn)
        {
          AppMethodBeat.i(243763);
          paramAnonymousn.c(ca.qwE);
          x.a(x.this, ca.qwE, localu, paramAnonymousn);
          x.this.a(localu, paramAnonymousn, ca.qwE);
          AppMethodBeat.o(243763);
        }
      }, ca.qwE);
      AppMethodBeat.o(245814);
      return true;
    }
    localn = alE(???);
    if (localn != null)
    {
      final x.h[] arrayOfh = new x.h[1];
      localn.a(???, new n.b()
      {
        public final void b(n paramAnonymousn, String paramAnonymousString)
        {
          AppMethodBeat.i(243597);
          paramAnonymousn = x.this.a(localu, paramAnonymousn, ca.qwE, paramAnonymousString, cb.d(ca.qwE));
          arrayOfh[0] = paramAnonymousn;
          AppMethodBeat.o(243597);
        }
        
        public final void e(n paramAnonymousn)
        {
          AppMethodBeat.i(243598);
          x.this.a(localu, paramAnonymousn, ca.qwE);
          AppMethodBeat.o(243598);
        }
      }, ca.qwE);
      synchronized (this.qqP)
      {
        localu = (u)this.qqQ.getFirst();
        b(localu, localn);
        a(localn, localu, ca.qwE, arrayOfh[0]);
        AppMethodBeat.o(245814);
        return true;
      }
    }
    AppMethodBeat.o(245814);
    return false;
  }
  
  private n alD(String paramString)
  {
    AppMethodBeat.i(245818);
    synchronized (this.qqP)
    {
      u localu = (u)this.qqQ.peekFirst();
      if (((localu instanceof n)) && (localu.dP(paramString)))
      {
        paramString = (n)localu;
        AppMethodBeat.o(245818);
        return paramString;
      }
      AppMethodBeat.o(245818);
      return null;
    }
  }
  
  private n alE(String paramString)
  {
    AppMethodBeat.i(245819);
    synchronized (this.qqP)
    {
      if (this.qqQ.size() < 2)
      {
        AppMethodBeat.o(245819);
        return null;
      }
      ListIterator localListIterator = this.qqQ.listIterator(1);
      while (localListIterator.hasNext())
      {
        u localu = (u)localListIterator.next();
        if (((localu instanceof n)) && (localu.dP(paramString)))
        {
          paramString = (n)localu;
          AppMethodBeat.o(245819);
          return paramString;
        }
      }
      AppMethodBeat.o(245819);
      return null;
    }
  }
  
  private Object b(u paramu, Runnable paramRunnable)
  {
    AppMethodBeat.i(245830);
    paramu = a(paramu, q(paramu), paramRunnable);
    AppMethodBeat.o(245830);
    return paramu;
  }
  
  private void b(ca paramca, u paramu1, u paramu2)
  {
    AppMethodBeat.i(176600);
    e(paramca, paramu1, paramu2);
    if (this.qrd == null)
    {
      AppMethodBeat.o(176600);
      return;
    }
    if (!this.qrc)
    {
      this.qrb = this.qrd.g(paramca, paramu1, paramu2);
      this.qrc = true;
    }
    this.qrd.e(paramca, paramu1, paramu2);
    this.qrc = false;
    AppMethodBeat.o(176600);
  }
  
  private void b(u paramu1, u paramu2)
  {
    AppMethodBeat.i(135071);
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.qqP)
    {
      Iterator localIterator = this.qqQ.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        u localu = (u)localIterator.next();
        if (localu == paramu1) {
          i = 1;
        } else if (localu != paramu2) {
          if (i != 0)
          {
            localLinkedList.add(localu);
            localIterator.remove();
            this.qqR.remove(localu);
          }
        }
      }
    }
    paramu1 = localLinkedList.iterator();
    while (paramu1.hasNext())
    {
      paramu2 = (u)paramu1.next();
      r(paramu2);
      k(paramu2);
    }
    AppMethodBeat.o(135071);
  }
  
  private void cdI()
  {
    AppMethodBeat.i(176593);
    synchronized (this.qqP)
    {
      Object localObject2 = new LinkedList(this.qqS);
      this.qqS.clear();
      ??? = ((LinkedList)localObject2).descendingIterator();
      if (((Iterator)???).hasNext())
      {
        localObject2 = (c)((Iterator)???).next();
        ((c)localObject2).jd(true);
        ((c)localObject2).run();
        ((Iterator)???).remove();
      }
    }
  }
  
  private ad cdK()
  {
    AppMethodBeat.i(135083);
    if (this.qqM != null)
    {
      ad localad = this.qqM.a(this);
      if (localad != null)
      {
        AppMethodBeat.o(135083);
        return localad;
      }
    }
    AppMethodBeat.o(135083);
    return null;
  }
  
  private u d(String paramString, ca paramca)
  {
    AppMethodBeat.i(135065);
    if (e(paramString, paramca))
    {
      paramString = new n(getContext(), this);
      AppMethodBeat.o(135065);
      return paramString;
    }
    paramString = new al(getContext(), this);
    AppMethodBeat.o(135065);
    return paramString;
  }
  
  private boolean e(String paramString, ca paramca)
  {
    AppMethodBeat.i(135069);
    if (paramca == ca.qwE)
    {
      AppMethodBeat.o(135069);
      return true;
    }
    if ((paramca == ca.qwC) || (paramca == ca.qwD))
    {
      boolean bool = this.nxs.getAppConfig().bKV().aeK(paramString);
      AppMethodBeat.o(135069);
      return bool;
    }
    for (;;)
    {
      synchronized (this.qqP)
      {
        if (paramca == ca.qwA) {
          break label169;
        }
        if (paramca == ca.qwB)
        {
          break label169;
          int j = this.qqQ.size();
          if (i != 0)
          {
            i = 1;
            if ((!this.nxs.getAppConfig().bKV().aeK(paramString)) || (j + 1 - i != 1)) {
              break label161;
            }
            AppMethodBeat.o(135069);
            return true;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        i = 0;
      }
      label161:
      AppMethodBeat.o(135069);
      return false;
      label169:
      int i = 1;
    }
  }
  
  private ad iL(int paramInt)
  {
    AppMethodBeat.i(245793);
    Object localObject1 = new LinkedList();
    synchronized (this.qqP)
    {
      ((LinkedList)localObject1).addAll(this.qqR);
      ((LinkedList)localObject1).addAll(this.qqQ);
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (u)((Iterator)localObject1).next();
        if (localObject3 != null)
        {
          localObject3 = ((u)localObject3).iL(paramInt);
          if (localObject3 != null)
          {
            AppMethodBeat.o(245793);
            return localObject3;
          }
        }
      }
      AppMethodBeat.o(245793);
      return null;
    }
  }
  
  private void k(u paramu)
  {
    AppMethodBeat.i(135076);
    if (this.qra != null) {
      this.qra.s(paramu);
    }
    paramu.setVisibility(8);
    paramu.cdE();
    if (!paramu.qqA) {
      paramu.performDestroy();
    }
    removeView(paramu);
    if (!paramu.qqA) {
      paramu.QO();
    }
    AppMethodBeat.o(135076);
  }
  
  private static void r(u paramu)
  {
    AppMethodBeat.i(135094);
    paramu.clearAnimation();
    paramu = paramu.getTag(qqJ);
    if ((paramu instanceof Animator))
    {
      paramu = (Animator)paramu;
      paramu.cancel();
      paramu.removeAllListeners();
      AppMethodBeat.o(135094);
      return;
    }
    if ((paramu instanceof Animation))
    {
      paramu = (Animation)paramu;
      paramu.setAnimationListener(null);
      paramu.cancel();
    }
    AppMethodBeat.o(135094);
  }
  
  protected void NR() {}
  
  protected x.h a(u paramu1, u paramu2)
  {
    AppMethodBeat.i(176591);
    Objects.requireNonNull(paramu2);
    Object localObject2 = getAppId();
    if (paramu1 == null) {}
    for (Object localObject1 = null;; localObject1 = l.eo(paramu1.getCurrentUrl()))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "onNavigateBack, appId[%s] out[%s], in[%s], mActuallyVisible[%b]", new Object[] { localObject2, localObject1, l.eo(paramu2.getCurrentUrl()), Boolean.valueOf(this.qqK) });
      if (this.qqK) {
        paramu2.getCurrentPageView().ceg();
      }
      if (paramu1 != null) {
        paramu1.hideVKB();
      }
      getRuntime().ntG.a(paramu2.getCurrentPageView(), ca.qwz);
      j(paramu2.getCurrentPageView());
      localObject2 = this.qrb;
      localObject1 = localObject2;
      if (this.qrd != null)
      {
        localObject1 = localObject2;
        if (!this.qrc)
        {
          localObject1 = this.qrd.g(ca.qwz, paramu1, paramu2);
          this.qrc = true;
        }
      }
      AppMethodBeat.o(176591);
      return localObject1;
    }
  }
  
  public x.h a(u paramu1, u paramu2, ca paramca, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(245808);
    String str = getAppId();
    if (paramu1 == null) {}
    for (Object localObject = null;; localObject = l.eo(paramu1.getCurrentUrl()))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "onNavigateStart, appId[%s] out[%s], in[%s], mActuallyVisible[%b], type[%s]", new Object[] { str, localObject, l.eo(paramString), Boolean.valueOf(this.qqK), paramca });
      if (paramu1 != null) {
        paramu1.hideVKB();
      }
      localObject = this.qrb;
      paramString = (String)localObject;
      if (this.qrd != null)
      {
        paramString = (String)localObject;
        if (!this.qrc)
        {
          paramString = this.qrd.g(paramca, paramu1, paramu2);
          this.qrc = true;
        }
      }
      d(paramca, paramu1, paramu2);
      if (ca.qwx == paramca)
      {
        getRuntime().ntG.a(paramu2.getCurrentPageView(), paramca);
        j(paramu2.getCurrentPageView());
      }
      if ((paramu1 != null) && (paramu1.getCurrentPageView() != null) && (paramu1.getCurrentPageView().getFullscreenImpl() != null) && (paramu1.getCurrentPageView().getFullscreenImpl().cgP())) {
        paramu1.getCurrentPageView().getFullscreenImpl().bEz();
      }
      AppMethodBeat.o(245808);
      return paramString;
    }
  }
  
  public final void a(final int paramInt, final String paramString, final f paramf)
  {
    AppMethodBeat.i(245797);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135024);
        x.a(x.this, paramInt, paramString, paramf);
        AppMethodBeat.o(135024);
      }
    });
    AppMethodBeat.o(245797);
  }
  
  public final void a(i parami, com.tencent.mm.plugin.appbrand.page.b.e parame)
  {
    AppMethodBeat.i(245787);
    if (parami == null)
    {
      AppMethodBeat.o(245787);
      return;
    }
    synchronized (this.qqO)
    {
      this.qqO.put(parami, parame);
      AppMethodBeat.o(245787);
      return;
    }
  }
  
  final void a(ca paramca, u paramu1, u paramu2)
  {
    AppMethodBeat.i(245834);
    d(paramca, paramu1, paramu2);
    if ((this.qrd != null) && (!this.qrc))
    {
      this.qrb = this.qrd.g(paramca, paramu1, paramu2);
      this.qrc = true;
    }
    AppMethodBeat.o(245834);
  }
  
  final void a(ca paramca, u paramu1, u paramu2, float paramFloat)
  {
    AppMethodBeat.i(245835);
    b(paramca, paramu1, paramu2, paramFloat);
    if (this.qrd == null)
    {
      AppMethodBeat.o(245835);
      return;
    }
    if (!this.qrc)
    {
      this.qrb = this.qrd.g(paramca, paramu1, paramu2);
      this.qrc = true;
    }
    this.qrd.aR(paramFloat);
    AppMethodBeat.o(245835);
  }
  
  public void a(u paramu1, u paramu2, ca paramca)
  {
    AppMethodBeat.i(135067);
    String str = getAppId();
    if (paramu1 == null) {}
    for (paramu1 = null;; paramu1 = l.eo(paramu1.getCurrentUrl()))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "onNavigateEnd, appId[%s] out[%s], in[%s], mActuallyVisible[%b], type[%s]", new Object[] { str, paramu1, l.eo(paramu2.getCurrentUrl()), Boolean.valueOf(this.qqK), paramca });
      if (this.qqK) {
        paramu2.getCurrentPageView().ceg();
      }
      if (ca.qwx != paramca) {
        getRuntime().ntG.a(paramu2.getCurrentPageView(), paramca);
      }
      if (e(paramu2)) {
        paramu2.getCurrentPageView().ceu();
      }
      j(paramu2.getCurrentPageView());
      AppMethodBeat.o(135067);
      return;
    }
  }
  
  public final void a(final u paramu, final String paramString)
  {
    AppMethodBeat.i(176589);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176564);
        int i = x.this.m(paramu);
        if (i < 0)
        {
          com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandPageContainer", "navigateBack with appId(%s) Page(%s), but already off stack, maybe frequent clicks were performed", new Object[] { x.this.getAppId(), paramu.getCurrentUrl() });
          AppMethodBeat.o(176564);
          return;
        }
        x.a(x.this, i + 1, paramString, null);
        AppMethodBeat.o(176564);
      }
    });
    AppMethodBeat.o(176589);
  }
  
  public final void alA(final String paramString)
  {
    AppMethodBeat.i(176587);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135047);
        x.this.alB(paramString);
        AppMethodBeat.o(135047);
      }
    });
    AppMethodBeat.o(176587);
  }
  
  public final void alB(String paramString)
  {
    AppMethodBeat.i(245799);
    a(1, paramString, null);
    AppMethodBeat.o(245799);
  }
  
  public final void alF(final String paramString)
  {
    AppMethodBeat.i(245828);
    if (!MMHandlerThread.isMainThread())
    {
      getRuntime().h(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(246060);
          x.this.alF(paramString);
          AppMethodBeat.o(246060);
        }
      }, 0L);
      AppMethodBeat.o(245828);
      return;
    }
    if (this.mDestroyed)
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandPageContainer", "preloadNext, destroyed, appId:%s, reason:%s", new Object[] { getAppId(), paramString });
      AppMethodBeat.o(245828);
      return;
    }
    if (!this.qqK)
    {
      this.qqL = true;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "preloadNext, deferred, appId:%s, reason:%s", new Object[] { getAppId(), paramString });
      AppMethodBeat.o(245828);
      return;
    }
    this.qqL = false;
    if ((this.qqM != null) && (this.qqM.PP()))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "preloadNext, intercepted, appId:%s, reason:%s", new Object[] { getAppId(), paramString });
      AppMethodBeat.o(245828);
      return;
    }
    if (this.qqT != null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "preloadNext, already preloaded, appId:%s, reason:%s", new Object[] { getAppId(), paramString });
      AppMethodBeat.o(245828);
      return;
    }
    long l = System.currentTimeMillis();
    ad localad2 = cdK();
    ad localad1 = localad2;
    if (localad2 == null) {
      localad1 = new ad();
    }
    localad1.qqW = getDecorWidgetFactory();
    localad1.a(getContext(), this.nxs);
    localad1.hide();
    addView(localad1.getContentView(), 0);
    this.qqT = localad1;
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "preloadNextPageView: appId:%s, cost:%d, reason:%s", new Object[] { getAppId(), Long.valueOf(System.currentTimeMillis() - l), paramString });
    AppMethodBeat.o(245828);
  }
  
  public final void alx(final String paramString)
  {
    AppMethodBeat.i(135056);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135042);
        x.a(x.this, paramString, ca.qwy);
        AppMethodBeat.o(135042);
      }
    });
    AppMethodBeat.o(135056);
  }
  
  public final void aly(final String paramString)
  {
    AppMethodBeat.i(135058);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135044);
        x.a(x.this, paramString, ca.qwA);
        AppMethodBeat.o(135044);
      }
    });
    AppMethodBeat.o(135058);
  }
  
  public final void alz(final String paramString)
  {
    AppMethodBeat.i(135059);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(243747);
        x.a(x.this, paramString, ca.qwE);
        AppMethodBeat.o(243747);
      }
    });
    AppMethodBeat.o(135059);
  }
  
  public final boolean at(int paramInt, String paramString)
  {
    AppMethodBeat.i(245792);
    ad localad2;
    ad localad1;
    if (paramInt == 0)
    {
      if (getCurrentPage() != null)
      {
        localad2 = getCurrentPage().getCurrentPageView();
        localad1 = localad2;
        if (localad2 != null) {}
      }
      else
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandPageContainer", "rewriteRoute invalid page appId:%s, url:%s", new Object[] { getAppId(), paramString });
        AppMethodBeat.o(245792);
        return false;
      }
    }
    else
    {
      localad2 = iL(paramInt);
      localad1 = localad2;
      if (localad2 == null)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandPageContainer", "rewriteRoute invalid page appId:%s, webviewId:%d, url:%s", new Object[] { getAppId(), Integer.valueOf(paramInt), paramString });
        AppMethodBeat.o(245792);
        return false;
      }
    }
    boolean bool = localad1.alG(paramString);
    AppMethodBeat.o(245792);
    return bool;
  }
  
  public final void az(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(135057);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135043);
        x localx = x.this;
        String str = paramString;
        if (paramBoolean) {}
        for (ca localca = ca.qwD;; localca = ca.qwC)
        {
          x.a(localx, str, localca);
          AppMethodBeat.o(135043);
          return;
        }
      }
    });
    AppMethodBeat.o(135057);
  }
  
  protected void b(ca paramca, u paramu1, u paramu2, float paramFloat) {}
  
  protected void b(u paramu, ca paramca) {}
  
  public final void b(final u paramu, final String paramString)
  {
    AppMethodBeat.i(176590);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176565);
        int i = x.this.m(paramu);
        x.a(x.this, i, paramString, null);
        AppMethodBeat.o(176565);
      }
    });
    AppMethodBeat.o(176590);
  }
  
  public final boolean b(String paramString, Runnable paramRunnable)
  {
    boolean bool1 = false;
    AppMethodBeat.i(245804);
    Object localObject = getNavigateBackInterceptorChain();
    if (localObject == null)
    {
      AppMethodBeat.o(245804);
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      boolean bool2 = ((com.tencent.mm.plugin.appbrand.page.b.e)((Iterator)localObject).next()).a(getRuntime(), paramString, paramRunnable);
      bool1 = bool2;
      if (bool2) {
        bool1 = bool2;
      }
    }
    AppMethodBeat.o(245804);
    return bool1;
  }
  
  final void c(ca paramca, u paramu1, u paramu2)
  {
    AppMethodBeat.i(245836);
    f(paramca, paramu1, paramu2);
    if (this.qrd != null)
    {
      this.qrd.f(paramca, paramu1, paramu2);
      this.qrc = false;
    }
    AppMethodBeat.o(245836);
  }
  
  public final void c(final String paramString1, final String paramString2, final int[] paramArrayOfInt)
  {
    AppMethodBeat.i(135077);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(245630);
        x.a(x.this, paramString1, paramString2, paramArrayOfInt);
        AppMethodBeat.o(245630);
      }
    });
    AppMethodBeat.o(135077);
  }
  
  public final Iterator<u> cdG()
  {
    AppMethodBeat.i(135054);
    Iterator local12 = new Iterator()
    {
      final ListIterator<u> qro;
      
      public final boolean hasNext()
      {
        AppMethodBeat.i(243489);
        boolean bool = this.qro.hasNext();
        AppMethodBeat.o(243489);
        return bool;
      }
      
      public final void remove()
      {
        AppMethodBeat.i(243491);
        UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(243491);
        throw localUnsupportedOperationException;
      }
    };
    AppMethodBeat.o(135054);
    return local12;
  }
  
  public final void cdH()
  {
    AppMethodBeat.i(135060);
    az(this.nxs.getAppConfig().bKX(), true);
    AppMethodBeat.o(135060);
  }
  
  public final ad cdJ()
  {
    AppMethodBeat.i(135082);
    if (!this.qqU) {}
    for (int i = 1;; i = 0)
    {
      this.qqU = true;
      if (this.qqT != null) {
        break;
      }
      localObject2 = cdK();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ad();
      }
      if (i != 0) {
        ((ad)localObject1).qsI = true;
      }
      ((ad)localObject1).qqW = getDecorWidgetFactory();
      ((ad)localObject1).a(getContext(), this.nxs);
      AppMethodBeat.o(135082);
      return localObject1;
    }
    Object localObject1 = this.qqT;
    this.qqT = null;
    if (i != 0) {
      ((ad)localObject1).qsI = true;
    }
    Object localObject2 = ((d)localObject1).getContentView();
    if (localObject2 != null) {
      ((View)localObject2).setVisibility(0);
    }
    removeView(((ad)localObject1).getContentView());
    AppMethodBeat.o(135082);
    return localObject1;
  }
  
  protected final void cdL()
  {
    AppMethodBeat.i(135089);
    if (this.nxs == null)
    {
      AppMethodBeat.o(135089);
      return;
    }
    if (this.qqY)
    {
      if (this.qqZ != null) {
        this.qqZ.bCF();
      }
      NR();
      this.qqY = false;
    }
    AppMethodBeat.o(135089);
  }
  
  public final boolean cdM()
  {
    AppMethodBeat.i(245832);
    if ((getActualPageStackSize() > 1) || (getRuntime().ntZ))
    {
      AppMethodBeat.o(245832);
      return true;
    }
    AppMethodBeat.o(245832);
    return false;
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(135081);
    this.mDestroyed = true;
    onDestroy();
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.qqQ)
    {
      localLinkedList.addAll(this.qqQ);
      localLinkedList.addAll(this.qqR);
      this.qqQ.clear();
      this.qqR.clear();
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext())
      {
        u localu = (u)((Iterator)???).next();
        localu.cdE();
        localu.performDestroy();
        localu.QO();
        r(localu);
      }
    }
    try
    {
      this.qqT.onDestroy();
      try
      {
        label136:
        this.qqT.cleanup();
        label143:
        removeAllViews();
        this.qqZ = null;
        this.nxs = null;
        this.qra = null;
        AppMethodBeat.o(135081);
        return;
      }
      catch (Exception localException1)
      {
        break label143;
      }
    }
    catch (Exception localException2)
    {
      break label136;
    }
  }
  
  protected void d(ca paramca, u paramu1, u paramu2) {}
  
  protected void e(ca paramca, u paramu1, u paramu2) {}
  
  protected boolean e(u paramu)
  {
    boolean bool2 = false;
    AppMethodBeat.i(245812);
    ad localad = paramu.getCurrentPageView();
    if (localad == null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandPageContainer", "shouldShowActionBarHomeButton, appId:%s, page:%s, get NULL PageView", new Object[] { getAppId(), paramu.getCurrentUrl() });
      AppMethodBeat.o(245812);
      return false;
    }
    String str = paramu.getCurrentUrl();
    int j;
    label91:
    int k;
    label113:
    int m;
    label123:
    int i;
    if (getPageCount() == 1)
    {
      bool1 = true;
      if (str.startsWith(getRuntime().getAppConfig().bKX())) {
        break label206;
      }
      j = 1;
      if ((localad.cdY() == null) || (localad.cdY().cne())) {
        break label212;
      }
      k = 1;
      if ((paramu instanceof n)) {
        break label218;
      }
      m = 1;
      i = 0;
      label125:
      if (i >= 4) {
        break label231;
      }
      if (new boolean[] { bool1, j, k, m }[i] != 0) {
        break label224;
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "[%s,%s]->shouldShowActionBarHomeButton: test fail cause #[%d] condition,", new Object[] { paramu.getAppId(), paramu.getCurrentUrl(), Integer.valueOf(i) });
    }
    label206:
    label212:
    label218:
    label224:
    label231:
    for (boolean bool1 = bool2;; bool1 = true)
    {
      AppMethodBeat.o(245812);
      return bool1;
      bool1 = false;
      break;
      j = 0;
      break label91;
      k = 0;
      break label113;
      m = 0;
      break label123;
      i += 1;
      break label125;
    }
  }
  
  protected void f(ca paramca, u paramu1, u paramu2) {}
  
  public final int getActualPageStackSize()
  {
    AppMethodBeat.i(176586);
    synchronized (this.qqP)
    {
      int i = this.qqQ.size();
      AppMethodBeat.o(176586);
      return i;
    }
  }
  
  public final com.tencent.mm.plugin.appbrand.config.b getAppConfig()
  {
    AppMethodBeat.i(135086);
    com.tencent.mm.plugin.appbrand.config.b localb = this.nxs.getAppConfig();
    AppMethodBeat.o(135086);
    return localb;
  }
  
  public String getAppId()
  {
    return this.mAppId;
  }
  
  /* Error */
  public u getCurrentPage()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: iconst_1
    //   3: istore_3
    //   4: iconst_1
    //   5: istore_1
    //   6: ldc_w 1109
    //   9: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: aload_0
    //   13: getfield 177	com/tencent/mm/plugin/appbrand/page/x:qqP	[B
    //   16: astore 4
    //   18: aload 4
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 184	com/tencent/mm/plugin/appbrand/page/x:qqR	Ljava/util/LinkedList;
    //   25: invokevirtual 1112	java/util/LinkedList:isEmpty	()Z
    //   28: ifne +126 -> 154
    //   31: aload_0
    //   32: getfield 184	com/tencent/mm/plugin/appbrand/page/x:qqR	Ljava/util/LinkedList;
    //   35: invokevirtual 695	java/util/LinkedList:getFirst	()Ljava/lang/Object;
    //   38: checkcast 241	com/tencent/mm/plugin/appbrand/page/u
    //   41: astore 5
    //   43: aload_0
    //   44: getfield 220	com/tencent/mm/plugin/appbrand/page/x:nxs	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   47: ifnull +90 -> 137
    //   50: aload_0
    //   51: getfield 220	com/tencent/mm/plugin/appbrand/page/x:nxs	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   54: invokevirtual 1115	com/tencent/mm/plugin/appbrand/AppBrandRuntime:bCo	()Z
    //   57: ifeq +92 -> 149
    //   60: aload_0
    //   61: getfield 220	com/tencent/mm/plugin/appbrand/page/x:nxs	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   64: getfield 1118	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mInitialized	Z
    //   67: ifne +82 -> 149
    //   70: aload 5
    //   72: ifnonnull +65 -> 137
    //   75: iload_1
    //   76: ifne +61 -> 137
    //   79: ldc 205
    //   81: ldc_w 1120
    //   84: iconst_4
    //   85: anewarray 209	java/lang/Object
    //   88: dup
    //   89: iconst_0
    //   90: aload_0
    //   91: invokevirtual 602	com/tencent/mm/plugin/appbrand/page/x:getAppId	()Ljava/lang/String;
    //   94: aastore
    //   95: dup
    //   96: iconst_1
    //   97: aload_0
    //   98: getfield 184	com/tencent/mm/plugin/appbrand/page/x:qqR	Ljava/util/LinkedList;
    //   101: invokevirtual 525	java/util/LinkedList:size	()I
    //   104: invokestatic 535	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: aastore
    //   108: dup
    //   109: iconst_2
    //   110: aload_0
    //   111: getfield 182	com/tencent/mm/plugin/appbrand/page/x:qqQ	Ljava/util/LinkedList;
    //   114: invokevirtual 525	java/util/LinkedList:size	()I
    //   117: invokestatic 535	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   120: aastore
    //   121: dup
    //   122: iconst_3
    //   123: new 556	java/lang/Throwable
    //   126: dup
    //   127: invokespecial 557	java/lang/Throwable:<init>	()V
    //   130: invokestatic 1126	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   133: aastore
    //   134: invokestatic 466	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: aload 4
    //   139: monitorexit
    //   140: ldc_w 1109
    //   143: invokestatic 229	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aload 5
    //   148: areturn
    //   149: iconst_0
    //   150: istore_1
    //   151: goto -81 -> 70
    //   154: aload_0
    //   155: getfield 182	com/tencent/mm/plugin/appbrand/page/x:qqQ	Ljava/util/LinkedList;
    //   158: invokevirtual 575	java/util/LinkedList:peekFirst	()Ljava/lang/Object;
    //   161: checkcast 241	com/tencent/mm/plugin/appbrand/page/u
    //   164: astore 5
    //   166: aload_0
    //   167: getfield 220	com/tencent/mm/plugin/appbrand/page/x:nxs	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   170: ifnull +92 -> 262
    //   173: aload_0
    //   174: getfield 220	com/tencent/mm/plugin/appbrand/page/x:nxs	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   177: invokevirtual 1115	com/tencent/mm/plugin/appbrand/AppBrandRuntime:bCo	()Z
    //   180: ifeq +94 -> 274
    //   183: aload_0
    //   184: getfield 220	com/tencent/mm/plugin/appbrand/page/x:nxs	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   187: getfield 1118	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mInitialized	Z
    //   190: ifne +84 -> 274
    //   193: iload_2
    //   194: istore_1
    //   195: aload 5
    //   197: ifnonnull +65 -> 262
    //   200: iload_1
    //   201: ifne +61 -> 262
    //   204: ldc 205
    //   206: ldc_w 1120
    //   209: iconst_4
    //   210: anewarray 209	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: aload_0
    //   216: invokevirtual 602	com/tencent/mm/plugin/appbrand/page/x:getAppId	()Ljava/lang/String;
    //   219: aastore
    //   220: dup
    //   221: iconst_1
    //   222: aload_0
    //   223: getfield 184	com/tencent/mm/plugin/appbrand/page/x:qqR	Ljava/util/LinkedList;
    //   226: invokevirtual 525	java/util/LinkedList:size	()I
    //   229: invokestatic 535	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   232: aastore
    //   233: dup
    //   234: iconst_2
    //   235: aload_0
    //   236: getfield 182	com/tencent/mm/plugin/appbrand/page/x:qqQ	Ljava/util/LinkedList;
    //   239: invokevirtual 525	java/util/LinkedList:size	()I
    //   242: invokestatic 535	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   245: aastore
    //   246: dup
    //   247: iconst_3
    //   248: new 556	java/lang/Throwable
    //   251: dup
    //   252: invokespecial 557	java/lang/Throwable:<init>	()V
    //   255: invokestatic 1126	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   258: aastore
    //   259: invokestatic 466	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   262: aload 4
    //   264: monitorexit
    //   265: ldc_w 1109
    //   268: invokestatic 229	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   271: aload 5
    //   273: areturn
    //   274: iconst_0
    //   275: istore_1
    //   276: goto -81 -> 195
    //   279: astore 5
    //   281: aload_0
    //   282: getfield 220	com/tencent/mm/plugin/appbrand/page/x:nxs	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   285: ifnull +91 -> 376
    //   288: aload_0
    //   289: getfield 220	com/tencent/mm/plugin/appbrand/page/x:nxs	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   292: invokevirtual 1115	com/tencent/mm/plugin/appbrand/AppBrandRuntime:bCo	()Z
    //   295: ifeq +104 -> 399
    //   298: aload_0
    //   299: getfield 220	com/tencent/mm/plugin/appbrand/page/x:nxs	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   302: getfield 1118	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mInitialized	Z
    //   305: ifne +94 -> 399
    //   308: iload_3
    //   309: istore_1
    //   310: iconst_0
    //   311: ifne +65 -> 376
    //   314: iload_1
    //   315: ifne +61 -> 376
    //   318: ldc 205
    //   320: ldc_w 1120
    //   323: iconst_4
    //   324: anewarray 209	java/lang/Object
    //   327: dup
    //   328: iconst_0
    //   329: aload_0
    //   330: invokevirtual 602	com/tencent/mm/plugin/appbrand/page/x:getAppId	()Ljava/lang/String;
    //   333: aastore
    //   334: dup
    //   335: iconst_1
    //   336: aload_0
    //   337: getfield 184	com/tencent/mm/plugin/appbrand/page/x:qqR	Ljava/util/LinkedList;
    //   340: invokevirtual 525	java/util/LinkedList:size	()I
    //   343: invokestatic 535	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   346: aastore
    //   347: dup
    //   348: iconst_2
    //   349: aload_0
    //   350: getfield 182	com/tencent/mm/plugin/appbrand/page/x:qqQ	Ljava/util/LinkedList;
    //   353: invokevirtual 525	java/util/LinkedList:size	()I
    //   356: invokestatic 535	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   359: aastore
    //   360: dup
    //   361: iconst_3
    //   362: new 556	java/lang/Throwable
    //   365: dup
    //   366: invokespecial 557	java/lang/Throwable:<init>	()V
    //   369: invokestatic 1126	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   372: aastore
    //   373: invokestatic 466	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   376: ldc_w 1109
    //   379: invokestatic 229	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   382: aload 5
    //   384: athrow
    //   385: astore 5
    //   387: aload 4
    //   389: monitorexit
    //   390: ldc_w 1109
    //   393: invokestatic 229	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   396: aload 5
    //   398: athrow
    //   399: iconst_0
    //   400: istore_1
    //   401: goto -91 -> 310
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	404	0	this	x
    //   5	396	1	i	int
    //   1	193	2	j	int
    //   3	306	3	k	int
    //   16	372	4	arrayOfByte	byte[]
    //   41	231	5	localu	u
    //   279	104	5	localObject1	Object
    //   385	12	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   21	43	279	finally
    //   154	166	279	finally
    //   43	70	385	finally
    //   79	137	385	finally
    //   137	140	385	finally
    //   166	193	385	finally
    //   204	262	385	finally
    //   262	265	385	finally
    //   281	308	385	finally
    //   318	376	385	finally
    //   376	385	385	finally
    //   387	390	385	finally
  }
  
  public String getCurrentUrl()
  {
    AppMethodBeat.i(135080);
    Object localObject = getCurrentPage();
    if (localObject != null)
    {
      localObject = ((u)localObject).getCurrentUrl();
      AppMethodBeat.o(135080);
      return localObject;
    }
    AppMethodBeat.o(135080);
    return null;
  }
  
  public bz getDecorWidgetFactory()
  {
    return this.qqW;
  }
  
  public List<com.tencent.mm.plugin.appbrand.page.b.e> getNavigateBackInterceptorChain()
  {
    AppMethodBeat.i(245785);
    synchronized (this.qqO)
    {
      if ((this.qqO.size() == 0) || (getCurrentPage() == null))
      {
        AppMethodBeat.o(245785);
        return null;
      }
      ArrayList localArrayList = new ArrayList(this.qqO.values());
      Collections.sort(localArrayList, new x.1(this));
      AppMethodBeat.o(245785);
      return localArrayList;
    }
  }
  
  public final int getPageCount()
  {
    AppMethodBeat.i(135053);
    synchronized (this.qqP)
    {
      int i = this.qqQ.size();
      int j = this.qqR.size();
      AppMethodBeat.o(135053);
      return i + j;
    }
  }
  
  public final ad getPageView()
  {
    AppMethodBeat.i(135084);
    if (this.mDestroyed)
    {
      AppMethodBeat.o(135084);
      return null;
    }
    boolean bool = this.nxs.nug;
    Object localObject = getCurrentPage();
    if (localObject == null)
    {
      if (bool) {
        Assert.fail("getPageView() assert by NULL page, appId=" + getAppId());
      }
      AppMethodBeat.o(135084);
      return null;
    }
    localObject = ((u)localObject).getCurrentPageView();
    if ((localObject == null) && (bool)) {
      Assert.fail("getPageView() assert by NULL pv, appId=" + getAppId());
    }
    AppMethodBeat.o(135084);
    return localObject;
  }
  
  ad getPreloadedPageView()
  {
    return this.qqT;
  }
  
  public AppBrandRuntime getRuntime()
  {
    return this.nxs;
  }
  
  public final void i(final ad paramad)
  {
    AppMethodBeat.i(245827);
    if (!MMHandlerThread.isMainThread())
    {
      getRuntime().h(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(246511);
          x.this.i(paramad);
          AppMethodBeat.o(246511);
        }
      }, 0L);
      AppMethodBeat.o(245827);
      return;
    }
    this.qqX.u(paramad);
    AppMethodBeat.o(245827);
  }
  
  public void init(final String paramString)
  {
    AppMethodBeat.i(135055);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135041);
        x.a(x.this, paramString, ca.qwx);
        AppMethodBeat.o(135041);
      }
    });
    AppMethodBeat.o(135055);
  }
  
  public final int j(u paramu)
  {
    AppMethodBeat.i(245791);
    int i = 0;
    while (i < this.qqQ.size())
    {
      if (paramu == this.qqQ.get(i))
      {
        int j = this.qqQ.size();
        AppMethodBeat.o(245791);
        return j - 1 - i;
      }
      i += 1;
    }
    AppMethodBeat.o(245791);
    return -1;
  }
  
  public final void j(final ad paramad)
  {
    AppMethodBeat.i(245843);
    getRuntime().nuf.setFullscreenImpl(paramad.getFullscreenImpl());
    getRuntime().nuf.a(new bf()
    {
      public final void a(AppBrandPageFullScreenView paramAnonymousAppBrandPageFullScreenView)
      {
        AppMethodBeat.i(244164);
        paramad.qsG.a(paramad, paramAnonymousAppBrandPageFullScreenView);
        AppMethodBeat.o(244164);
      }
    });
    AppMethodBeat.o(245843);
  }
  
  public final u l(u paramu)
  {
    AppMethodBeat.i(135079);
    synchronized (this.qqP)
    {
      if (this.qqR.contains(paramu))
      {
        paramu = (u)this.qqQ.peekFirst();
        AppMethodBeat.o(135079);
        return paramu;
      }
      int i = this.qqQ.indexOf(paramu);
      if (i >= this.qqQ.size() - 1)
      {
        AppMethodBeat.o(135079);
        return null;
      }
      paramu = (u)this.qqQ.get(i + 1);
      AppMethodBeat.o(135079);
      return paramu;
    }
  }
  
  final int m(u paramu)
  {
    AppMethodBeat.i(176597);
    synchronized (this.qqP)
    {
      int i = this.qqQ.indexOf(paramu);
      AppMethodBeat.o(176597);
      return i;
    }
  }
  
  public Object n(u paramu)
  {
    AppMethodBeat.i(135090);
    paramu = ObjectAnimator.ofFloat(paramu, "translationX", new float[] { paramu.getWidth(), 0.0F });
    paramu.setDuration(250L);
    AppMethodBeat.o(135090);
    return paramu;
  }
  
  public Object o(u paramu)
  {
    AppMethodBeat.i(135091);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramu, "translationX", new float[] { 0.0F, -(paramu.getWidth() * 0.25F) });
    localObjectAnimator.setDuration(250L);
    paramu = ObjectAnimator.ofFloat(paramu, "translationX", new float[] { 0.0F });
    paramu.setDuration(0L);
    new AnimatorSet().playSequentially(new Animator[] { localObjectAnimator, paramu });
    AppMethodBeat.o(135091);
    return localObjectAnimator;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(135096);
    u localu = getCurrentPage();
    if (localu == null)
    {
      AppMethodBeat.o(135096);
      return;
    }
    if (localu.getCurrentPageView().onBackPressed())
    {
      AppMethodBeat.o(135096);
      return;
    }
    synchronized (this.qqP)
    {
      int i;
      if (!this.qqR.isEmpty())
      {
        i = 1;
        if ((i != 0) || (localu.getTag(qqJ) != null))
        {
          com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandPageContainer", "onBackPressed, has navigating pages, skip");
          AppMethodBeat.o(135096);
        }
      }
      else
      {
        i = 0;
      }
    }
    alA("scene_back_key_pressed");
    AppMethodBeat.o(135096);
  }
  
  public void onBackground()
  {
    AppMethodBeat.i(135088);
    synchronized (this.qqP)
    {
      u localu = (u)this.qqQ.peekFirst();
      if (localu == null)
      {
        AppMethodBeat.o(135088);
        return;
      }
    }
    localObject.cdE();
    AppMethodBeat.o(135088);
  }
  
  protected void onDestroy() {}
  
  public void onForeground()
  {
    AppMethodBeat.i(135087);
    synchronized (this.qqP)
    {
      u localu = (u)this.qqQ.peekFirst();
      if (localu == null)
      {
        AppMethodBeat.o(135087);
        return;
      }
    }
    localObject.cdD();
    if (this.qqK)
    {
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandPageContainer", "onForeground, call onUserVisible, appId[%s] url[%s]", new Object[] { getAppId(), localObject.getCurrentPageView().oxe });
      localObject.getCurrentPageView().ceg();
    }
    AppMethodBeat.o(135087);
  }
  
  public Object p(u paramu)
  {
    AppMethodBeat.i(135092);
    paramu = ObjectAnimator.ofFloat(paramu, "translationX", new float[] { -(paramu.getWidth() * 0.25F), 0.0F });
    paramu.setDuration(250L);
    AppMethodBeat.o(135092);
    return paramu;
  }
  
  public Object q(u paramu)
  {
    AppMethodBeat.i(135093);
    paramu = ObjectAnimator.ofFloat(paramu, "translationX", new float[] { 0.0F, paramu.getWidth() });
    paramu.setDuration(250L);
    AppMethodBeat.o(135093);
    return paramu;
  }
  
  protected final void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(135052);
    if ((Looper.myLooper() != null) && (Looper.myLooper() == Looper.getMainLooper()))
    {
      paramRunnable.run();
      AppMethodBeat.o(135052);
      return;
    }
    if (this.nxs == null)
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandPageContainer", "runOnUiThread but mRuntime==NULL, appId:%s, stack:%s", new Object[] { getAppId(), android.util.Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(135052);
      return;
    }
    this.nxs.h(paramRunnable, 0L);
    AppMethodBeat.o(135052);
  }
  
  public void setActuallyVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(135051);
    if (this.qqK != paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.qqK = paramBoolean;
      if ((paramBoolean) && (i != 0))
      {
        getCurrentPage().getCurrentPageView().ceg();
        super.setVisibility(0);
        if (this.qqL) {
          alF("setActuallyVisible");
        }
      }
      if ((!paramBoolean) && (i != 0)) {
        super.setVisibility(4);
      }
      AppMethodBeat.o(135051);
      return;
    }
  }
  
  public void setDecorWidgetFactory(bz parambz)
  {
    AppMethodBeat.i(135049);
    if (parambz == null)
    {
      parambz = new NullPointerException("Should not be null");
      AppMethodBeat.o(135049);
      throw parambz;
    }
    this.qqW = parambz;
    AppMethodBeat.o(135049);
  }
  
  public final void setDelegate(a parama)
  {
    AppMethodBeat.i(135050);
    if (this.qqM != null)
    {
      parama = new IllegalAccessError("Duplicated call!!!");
      AppMethodBeat.o(135050);
      throw parama;
    }
    a locala = parama;
    if (this.qqN != null) {
      locala = this.qqN.a(parama);
    }
    this.qqM = locala;
    AppMethodBeat.o(135050);
  }
  
  public void setDelegateWrapperFactory(b paramb)
  {
    AppMethodBeat.i(176584);
    this.qqN = paramb;
    if (this.qqM != null) {
      this.qqM = paramb.a(this.qqM);
    }
    AppMethodBeat.o(176584);
  }
  
  public void setOnPageSwitchListener(e parame)
  {
    AppMethodBeat.i(176601);
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandPageContainer", "setOnPageSwitchListener, onPageSwitchListener: ".concat(String.valueOf(parame)));
    this.qrd = parame;
    AppMethodBeat.o(176601);
  }
  
  public void setOnReadyListener(f paramf)
  {
    this.qqZ = paramf;
  }
  
  public void setPipPageLifeCycleListener(i parami)
  {
    this.qra = parami;
  }
  
  public void setPipVideoRelatedPage(u paramu)
  {
    AppMethodBeat.i(245784);
    if (paramu != null) {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "setPipVideoRelatedPage, page(%s)", new Object[] { paramu.getCurrentUrl() });
    }
    for (;;)
    {
      this.qqV = paramu;
      AppMethodBeat.o(245784);
      return;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "setPipVideoRelatedPage, page is null");
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean PP();
    
    public abstract ad a(x paramx);
    
    public abstract u a(String paramString, ca paramca, x paramx, Callable<u> paramCallable);
    
    public abstract boolean a(String paramString, ca paramca, x paramx, x.d paramd);
  }
  
  public static abstract interface b
  {
    public abstract x.a a(x.a parama);
  }
  
  static abstract interface c
    extends Runnable
  {
    public abstract void jd(boolean paramBoolean);
  }
  
  public static abstract interface d
  {
    public abstract void cancel();
    
    public abstract void cdN();
    
    public abstract void proceed();
  }
  
  public static abstract interface e
  {
    public abstract void aR(float paramFloat);
    
    public abstract void e(ca paramca, u paramu1, u paramu2);
    
    public abstract void f(ca paramca, u paramu1, u paramu2);
    
    public abstract x.h g(ca paramca, u paramu1, u paramu2);
  }
  
  public static abstract interface f
  {
    public abstract void bCF();
  }
  
  public static abstract interface i
  {
    public abstract void s(u paramu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.x
 * JD-Core Version:    0.7.0.1
 */