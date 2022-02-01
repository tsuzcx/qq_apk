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
import android.util.Log;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.tencent.luggage.h.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.a.g;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.f.f;
import com.tencent.mm.plugin.appbrand.page.b.f;
import com.tencent.mm.plugin.appbrand.page.b.i;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import junit.framework.Assert;

@SuppressLint({"ViewConstructor"})
public class t
  extends FrameLayout
{
  static final int meD = 2131296777;
  private AppBrandRuntime jDb;
  private bq lUV;
  private String mAppId;
  private volatile boolean mDestroyed;
  private boolean mYf;
  private boolean meE;
  private boolean meF;
  private a meG;
  private b meH;
  private final Map<i, com.tencent.mm.plugin.appbrand.page.b.e> meI;
  private final byte[] meJ;
  private final LinkedList<q> meK;
  private final LinkedList<q> meL;
  private final LinkedList<c> meM;
  private z meN;
  private q meO;
  private boolean meP;
  private f meQ;
  private i meR;
  h meS;
  boolean meT;
  e meU;
  
  public t(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramContext);
    AppMethodBeat.i(135048);
    this.mDestroyed = false;
    this.meE = false;
    this.meF = false;
    this.meI = new HashMap();
    this.meJ = new byte[0];
    this.meK = new LinkedList();
    this.meL = new LinkedList();
    this.meM = new LinkedList();
    this.mYf = false;
    this.meP = true;
    this.meR = null;
    this.meS = null;
    this.meT = false;
    this.meU = null;
    ae.i("MicroMsg.AppBrandPageContainer", "AppBrandPageContainerProfile| <init> appId[%s]", new Object[] { paramAppBrandRuntime.mAppId });
    this.jDb = paramAppBrandRuntime;
    this.mAppId = paramAppBrandRuntime.mAppId;
    this.lUV = new bq.a();
    AppMethodBeat.o(135048);
  }
  
  private boolean TV(String arg1)
  {
    AppMethodBeat.i(207829);
    final q localq = getCurrentPage();
    j localj = TW(???);
    final h[] arrayOfh;
    if (localj != null)
    {
      arrayOfh = new h[1];
      localj.a(???, new j.b()
      {
        public final void b(j paramAnonymousj, String paramAnonymousString)
        {
          AppMethodBeat.i(207799);
          paramAnonymousj = t.this.a(localq, paramAnonymousj, br.mkn, paramAnonymousString, bs.b(br.mkn));
          arrayOfh[0] = paramAnonymousj;
          AppMethodBeat.o(207799);
        }
        
        public final void e(j paramAnonymousj)
        {
          AppMethodBeat.i(207800);
          paramAnonymousj.buP();
          t.a(t.this, br.mkn, localq, paramAnonymousj);
          t.this.a(localq, paramAnonymousj, br.mkn);
          AppMethodBeat.o(207800);
        }
      });
      localj.a(br.mkn, arrayOfh[0]);
      AppMethodBeat.o(207829);
      return true;
    }
    localj = TX(???);
    if (localj != null)
    {
      arrayOfh = new h[1];
      localj.a(???, new j.b()
      {
        public final void b(j paramAnonymousj, String paramAnonymousString)
        {
          AppMethodBeat.i(207801);
          paramAnonymousj = t.this.a(localq, paramAnonymousj, br.mkn, paramAnonymousString, bs.b(br.mkn));
          arrayOfh[0] = paramAnonymousj;
          AppMethodBeat.o(207801);
        }
        
        public final void e(j paramAnonymousj)
        {
          AppMethodBeat.i(207802);
          t.this.a(localq, paramAnonymousj, br.mkn);
          AppMethodBeat.o(207802);
        }
      });
      synchronized (this.meJ)
      {
        localq = (q)this.meK.getFirst();
        b(localq, localj);
        a(localj, localq, br.mkn, arrayOfh[0]);
        AppMethodBeat.o(207829);
        return true;
      }
    }
    AppMethodBeat.o(207829);
    return false;
  }
  
  private j TW(String paramString)
  {
    AppMethodBeat.i(207830);
    synchronized (this.meJ)
    {
      q localq = (q)this.meK.peekFirst();
      if (((localq instanceof j)) && (localq.cX(paramString)))
      {
        paramString = (j)localq;
        AppMethodBeat.o(207830);
        return paramString;
      }
      AppMethodBeat.o(207830);
      return null;
    }
  }
  
  private j TX(String paramString)
  {
    AppMethodBeat.i(207831);
    synchronized (this.meJ)
    {
      if (this.meK.size() < 2)
      {
        AppMethodBeat.o(207831);
        return null;
      }
      ListIterator localListIterator = this.meK.listIterator(1);
      while (localListIterator.hasNext())
      {
        q localq = (q)localListIterator.next();
        if (((localq instanceof j)) && (localq.cX(paramString)))
        {
          paramString = (j)localq;
          AppMethodBeat.o(207831);
          return paramString;
        }
      }
      AppMethodBeat.o(207831);
      return null;
    }
  }
  
  private q a(String paramString, br parambr)
  {
    AppMethodBeat.i(135065);
    if (b(paramString, parambr))
    {
      paramString = new j(getContext(), this);
      AppMethodBeat.o(135065);
      return paramString;
    }
    paramString = new ah(getContext(), this);
    AppMethodBeat.o(135065);
    return paramString;
  }
  
  private Object a(final q paramq, Object paramObject, final Runnable paramRunnable)
  {
    AppMethodBeat.i(176598);
    Object localObject;
    if ((paramObject instanceof Animator))
    {
      localObject = (Animator)paramObject;
      p(paramq);
      paramq.setTag(meD, localObject);
      ((Animator)localObject).addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(207811);
          paramq.setTag(t.meD, null);
          if (paramRunnable != null)
          {
            t.this.removeCallbacks(paramRunnable);
            if (!t.i(t.this)) {
              paramRunnable.run();
            }
          }
          AppMethodBeat.o(207811);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(207812);
          paramq.setTag(t.meD, null);
          if (paramRunnable != null) {
            t.this.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(207810);
                if (!t.i(t.this)) {
                  t.19.this.val$runnable.run();
                }
                AppMethodBeat.o(207810);
              }
            });
          }
          AppMethodBeat.o(207812);
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
            AppMethodBeat.i(207814);
            if (paramRunnable != null)
            {
              Runnable local1 = new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(207813);
                  if (!t.i(t.this)) {
                    t.20.this.val$runnable.run();
                  }
                  t.20.this.meY.setTag(t.meD, null);
                  AppMethodBeat.o(207813);
                }
              };
              if (paramAnonymousAnimation.getStartTime() == -9223372036854775808L)
              {
                local1.run();
                AppMethodBeat.o(207814);
                return;
              }
              if (!t.i(t.this)) {
                t.this.post(local1);
              }
              AppMethodBeat.o(207814);
              return;
            }
            paramq.setTag(t.meD, null);
            AppMethodBeat.o(207814);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
        p(paramq);
        paramq.setTag(meD, localObject);
        paramq.startAnimation((Animation)localObject);
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
    paramq = new IllegalArgumentException("Page animation should be Animator or Animation");
    AppMethodBeat.o(176598);
    throw paramq;
  }
  
  private Object a(q paramq, Runnable paramRunnable)
  {
    AppMethodBeat.i(207832);
    paramq = a(paramq, n(paramq), paramRunnable);
    AppMethodBeat.o(207832);
    return paramq;
  }
  
  private Object a(final q paramq, boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(176595);
    if (paramq == null)
    {
      AppMethodBeat.o(176595);
      return null;
    }
    if (paramBoolean2) {}
    synchronized (this.meJ)
    {
      this.meK.remove(paramq);
      this.meL.remove(paramq);
      paramq.buO();
      ??? = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(176570);
          if (paramBoolean2) {
            t.a(t.this, paramq);
          }
          AppMethodBeat.o(176570);
        }
      };
      if (paramBoolean1)
      {
        paramq = a(paramq, m(paramq), (Runnable)???);
        AppMethodBeat.o(176595);
        return paramq;
      }
    }
    p(paramq);
    ((Runnable)???).run();
    AppMethodBeat.o(176595);
    return null;
  }
  
  private void a(br parambr, q paramq1, q paramq2)
  {
    AppMethodBeat.i(176600);
    if (this.meU == null)
    {
      AppMethodBeat.o(176600);
      return;
    }
    if (!this.meT)
    {
      this.meS = this.meU.b(parambr, paramq1, paramq2);
      this.meT = true;
    }
    this.meU.c(parambr, paramq1, paramq2);
    this.meT = false;
    AppMethodBeat.o(176600);
  }
  
  private void a(final br parambr, final q paramq1, final q paramq2, final t.g paramg)
  {
    AppMethodBeat.i(176599);
    ae.d("MicroMsg.AppBrandPageContainer", "processPageSwitchResult, pageSwitchResult: ".concat(String.valueOf(paramg)));
    if (this.meU == null)
    {
      ae.d("MicroMsg.AppBrandPageContainer", "processPageSwitchResult, null == mOnPageSwitchListener");
      AppMethodBeat.o(176599);
      return;
    }
    paramg = paramg.mfv;
    if ((paramg instanceof ValueAnimator))
    {
      paramg = (ValueAnimator)paramg;
      paramg.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(207816);
          super.onAnimationCancel(paramAnonymousAnimator);
          t.j(t.this).d(parambr, paramq1, paramq2);
          t.k(t.this);
          AppMethodBeat.o(207816);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(207815);
          super.onAnimationEnd(paramAnonymousAnimator);
          t.a(t.this, parambr, paramq1, paramq2);
          AppMethodBeat.o(207815);
        }
      });
      paramg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(207817);
          int i = (int)(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * 100.0F);
          t.j(t.this).aG(i);
          AppMethodBeat.o(207817);
        }
      });
      AppMethodBeat.o(176599);
      return;
    }
    if ((paramg instanceof Animation))
    {
      paramg = (Animation)paramg;
      long l = paramg.getDuration();
      parambr = new Choreographer.FrameCallback()
      {
        public final void doFrame(long paramAnonymousLong)
        {
          AppMethodBeat.i(207818);
          float f = ((float)(SystemClock.elapsedRealtime() - this.mfo) + 0.0F) / (float)parambr;
          if (1.0F <= f)
          {
            t.a(t.this, paramq2, paramg, this.mfn);
            AppMethodBeat.o(207818);
            return;
          }
          int i = (int)(this.mfp.getInterpolator().getInterpolation(f) * 100.0F);
          t.j(t.this).aG(i);
          Choreographer.getInstance().postFrameCallback(this);
          AppMethodBeat.o(207818);
        }
      };
      Choreographer.getInstance().postFrameCallback(parambr);
      AppMethodBeat.o(176599);
      return;
    }
    a(parambr, paramq1, paramq2);
    AppMethodBeat.o(176599);
  }
  
  private void a(final q paramq1, final q paramq2, br parambr, h paramh)
  {
    Object localObject2 = null;
    AppMethodBeat.i(176594);
    for (;;)
    {
      synchronized (this.meJ)
      {
        this.meK.remove(paramq2);
        this.meL.remove(paramq2);
        if (!paramq2.mSwiping)
        {
          i = 1;
          if (i == 0) {
            break label192;
          }
          ??? = b(paramq2, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(135035);
              t.a(t.this, paramq2);
              AppMethodBeat.o(135035);
            }
          });
          ae.i("MicroMsg.AppBrandPageContainer", "switchPageClear, in: %s out: %s", new Object[] { paramq1.getCurrentUrl(), paramq2.getCurrentUrl() });
          ae.d("MicroMsg.AppBrandPageContainer", "switchPageClear, dispatchRoute, type: %s, pipMode: %s", new Object[] { parambr, paramh });
          paramq1.a(parambr, paramh);
          paramq1.buN();
          if (i == 0) {
            break label203;
          }
          paramh = a(paramq1, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(176569);
              paramq1.buP();
              AppMethodBeat.o(176569);
            }
          });
          a(parambr, paramq2, paramq1, new t.g(paramh, ???));
          AppMethodBeat.o(176594);
          return;
        }
      }
      int i = 0;
      continue;
      label192:
      i(paramq2);
      ??? = null;
      continue;
      label203:
      paramq1.buP();
      paramh = localObject2;
    }
  }
  
  private Object b(q paramq, Runnable paramRunnable)
  {
    AppMethodBeat.i(207833);
    paramq = a(paramq, o(paramq), paramRunnable);
    AppMethodBeat.o(207833);
    return paramq;
  }
  
  private Object b(final q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(176596);
    if (paramq == null)
    {
      AppMethodBeat.o(176596);
      return null;
    }
    synchronized (this.meJ)
    {
      this.meK.remove(paramq);
      this.meK.push(paramq);
      this.meL.remove(paramq);
      paramq.bringToFront();
      requestLayout();
      invalidate();
      paramq.buN();
      ??? = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(207807);
          t.this.buV();
          paramq.buP();
          AppMethodBeat.o(207807);
        }
      };
      if (paramBoolean)
      {
        paramq = a(paramq, l(paramq), (Runnable)???);
        AppMethodBeat.o(176596);
        return paramq;
      }
    }
    p(paramq);
    ((Runnable)???).run();
    AppMethodBeat.o(176596);
    return null;
  }
  
  private void b(q paramq1, q paramq2)
  {
    AppMethodBeat.i(135071);
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.meJ)
    {
      Iterator localIterator = this.meK.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        q localq = (q)localIterator.next();
        if (localq == paramq1) {
          i = 1;
        } else if (localq != paramq2) {
          if (i != 0)
          {
            localLinkedList.add(localq);
            localIterator.remove();
            this.meL.remove(localq);
          }
        }
      }
    }
    paramq1 = localLinkedList.iterator();
    while (paramq1.hasNext())
    {
      paramq2 = (q)paramq1.next();
      p(paramq2);
      i(paramq2);
    }
    AppMethodBeat.o(135071);
  }
  
  private boolean b(String paramString, br parambr)
  {
    AppMethodBeat.i(135069);
    if (parambr == br.mkn)
    {
      AppMethodBeat.o(135069);
      return true;
    }
    if ((parambr == br.mkl) || (parambr == br.mkm))
    {
      boolean bool = this.jDb.getAppConfig().bep().NP(paramString);
      AppMethodBeat.o(135069);
      return bool;
    }
    for (;;)
    {
      synchronized (this.meJ)
      {
        if (parambr == br.mkj) {
          break label169;
        }
        if (parambr == br.mkk)
        {
          break label169;
          int j = this.meK.size();
          if (i != 0)
          {
            i = 1;
            if ((!this.jDb.getAppConfig().bep().NP(paramString)) || (j + 1 - i != 1)) {
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
  
  private void buS()
  {
    AppMethodBeat.i(176593);
    synchronized (this.meJ)
    {
      Object localObject2 = new LinkedList(this.meM);
      this.meM.clear();
      ??? = ((LinkedList)localObject2).descendingIterator();
      if (((Iterator)???).hasNext())
      {
        localObject2 = (c)((Iterator)???).next();
        ((c)localObject2).hf(true);
        ((c)localObject2).run();
        ((Iterator)???).remove();
      }
    }
    AppMethodBeat.o(176593);
  }
  
  private z buU()
  {
    AppMethodBeat.i(135083);
    if (this.meG != null)
    {
      z localz = this.meG.a(this);
      if (localz != null)
      {
        AppMethodBeat.o(135083);
        return localz;
      }
    }
    AppMethodBeat.o(135083);
    return null;
  }
  
  private void i(q paramq)
  {
    AppMethodBeat.i(135076);
    if (this.meR != null) {
      this.meR.q(paramq);
    }
    paramq.setVisibility(8);
    paramq.buO();
    if (!paramq.mew) {
      paramq.performDestroy();
    }
    removeView(paramq);
    if (!paramq.mew) {
      paramq.Es();
    }
    AppMethodBeat.o(135076);
  }
  
  private static void p(q paramq)
  {
    AppMethodBeat.i(135094);
    paramq.clearAnimation();
    paramq = paramq.getTag(meD);
    if ((paramq instanceof Animator))
    {
      paramq = (Animator)paramq;
      paramq.cancel();
      paramq.removeAllListeners();
      AppMethodBeat.o(135094);
      return;
    }
    if ((paramq instanceof Animation))
    {
      paramq = (Animation)paramq;
      paramq.setAnimationListener(null);
      paramq.cancel();
    }
    AppMethodBeat.o(135094);
  }
  
  public void SM(final String paramString)
  {
    AppMethodBeat.i(135055);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135041);
        t.a(t.this, paramString, br.mkg);
        AppMethodBeat.o(135041);
      }
    });
    AppMethodBeat.o(135055);
  }
  
  public final void TP(final String paramString)
  {
    AppMethodBeat.i(135056);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135042);
        t.a(t.this, paramString, br.mkh);
        AppMethodBeat.o(135042);
      }
    });
    AppMethodBeat.o(135056);
  }
  
  public final void TQ(final String paramString)
  {
    AppMethodBeat.i(135058);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135044);
        t.a(t.this, paramString, br.mkj);
        AppMethodBeat.o(135044);
      }
    });
    AppMethodBeat.o(135058);
  }
  
  public final boolean TR(String paramString)
  {
    AppMethodBeat.i(207824);
    z localz;
    if (getCurrentPage() != null)
    {
      localz = getCurrentPage().getCurrentPageView();
      if (localz != null) {}
    }
    else
    {
      ae.w("MicroMsg.AppBrandPageContainer", "rewriteRoute invalid page appId:%s, url:%s", new Object[] { getAppId(), paramString });
      AppMethodBeat.o(207824);
      return false;
    }
    boolean bool = localz.TR(paramString);
    AppMethodBeat.o(207824);
    return bool;
  }
  
  public final void TS(final String paramString)
  {
    AppMethodBeat.i(135059);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207819);
        t.a(t.this, paramString, br.mkn);
        AppMethodBeat.o(207819);
      }
    });
    AppMethodBeat.o(135059);
  }
  
  public final void TT(final String paramString)
  {
    AppMethodBeat.i(176587);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135047);
        t.this.TU(paramString);
        AppMethodBeat.o(135047);
      }
    });
    AppMethodBeat.o(176587);
  }
  
  public final void TU(String paramString)
  {
    AppMethodBeat.i(207826);
    a(1, paramString, null);
    AppMethodBeat.o(207826);
  }
  
  protected h a(q paramq1, q paramq2)
  {
    AppMethodBeat.i(176591);
    Objects.requireNonNull(paramq2);
    Object localObject2 = getAppId();
    if (paramq1 == null) {}
    for (Object localObject1 = null;; localObject1 = k.dt(paramq1.getCurrentUrl()))
    {
      ae.i("MicroMsg.AppBrandPageContainer", "onNavigateBack, appId[%s] out[%s], in[%s], mActuallyVisible[%b]", new Object[] { localObject2, localObject1, k.dt(paramq2.getCurrentUrl()), Boolean.valueOf(this.meE) });
      if (this.meE) {
        paramq2.getCurrentPageView().bvn();
      }
      if (paramq1 != null) {
        paramq1.hideVKB();
      }
      getRuntime().jzJ.a(paramq2.getCurrentPageView(), br.mki);
      localObject2 = this.meS;
      localObject1 = localObject2;
      if (this.meU != null)
      {
        localObject1 = localObject2;
        if (!this.meT)
        {
          localObject1 = this.meU.b(br.mki, paramq1, paramq2);
          this.meT = true;
        }
      }
      AppMethodBeat.o(176591);
      return localObject1;
    }
  }
  
  public h a(q paramq1, q paramq2, br parambr, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(207828);
    String str = getAppId();
    if (paramq1 == null) {}
    for (Object localObject = null;; localObject = k.dt(paramq1.getCurrentUrl()))
    {
      ae.i("MicroMsg.AppBrandPageContainer", "onNavigateStart, appId[%s] out[%s], in[%s], mActuallyVisible[%b], type[%s]", new Object[] { str, localObject, k.dt(paramString), Boolean.valueOf(this.meE), parambr });
      if (paramq1 != null) {
        paramq1.hideVKB();
      }
      localObject = this.meS;
      paramString = (String)localObject;
      if (this.meU != null)
      {
        paramString = (String)localObject;
        if (!this.meT)
        {
          paramString = this.meU.b(parambr, paramq1, paramq2);
          this.meT = true;
        }
      }
      if (br.mkg == parambr) {
        getRuntime().jzJ.a(paramq2.getCurrentPageView(), parambr);
      }
      if ((paramq1 != null) && (paramq1.getCurrentPageView() != null) && (paramq1.getCurrentPageView().getFullscreenImpl() != null) && (paramq1.getCurrentPageView().getFullscreenImpl().bxz())) {
        paramq1.getCurrentPageView().getFullscreenImpl().aYo();
      }
      AppMethodBeat.o(207828);
      return paramString;
    }
  }
  
  public final void a(final int paramInt, final String paramString, final f paramf)
  {
    AppMethodBeat.i(207825);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135024);
        t.a(t.this, paramInt, paramString, paramf);
        AppMethodBeat.o(135024);
      }
    });
    AppMethodBeat.o(207825);
  }
  
  public final void a(i parami, com.tencent.mm.plugin.appbrand.page.b.e parame)
  {
    AppMethodBeat.i(207823);
    if (parami == null)
    {
      AppMethodBeat.o(207823);
      return;
    }
    synchronized (this.meI)
    {
      this.meI.put(parami, parame);
      AppMethodBeat.o(207823);
      return;
    }
  }
  
  public void a(q paramq1, q paramq2, br parambr)
  {
    AppMethodBeat.i(135067);
    String str = getAppId();
    if (paramq1 == null) {}
    for (paramq1 = null;; paramq1 = k.dt(paramq1.getCurrentUrl()))
    {
      ae.i("MicroMsg.AppBrandPageContainer", "onNavigateEnd, appId[%s] out[%s], in[%s], mActuallyVisible[%b], type[%s]", new Object[] { str, paramq1, k.dt(paramq2.getCurrentUrl()), Boolean.valueOf(this.meE), parambr });
      if (this.meE) {
        paramq2.getCurrentPageView().bvn();
      }
      if (br.mkg != parambr) {
        getRuntime().jzJ.a(paramq2.getCurrentPageView(), parambr);
      }
      AppMethodBeat.o(135067);
      return;
    }
  }
  
  public final void a(final q paramq, final String paramString)
  {
    AppMethodBeat.i(176589);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176564);
        int i = t.this.k(paramq);
        if (i < 0)
        {
          ae.w("MicroMsg.AppBrandPageContainer", "navigateBack with appId(%s) Page(%s), but already off stack, maybe frequent clicks were performed", new Object[] { t.this.getAppId(), paramq.getCurrentUrl() });
          AppMethodBeat.o(176564);
          return;
        }
        t.a(t.this, i + 1, paramString, null);
        AppMethodBeat.o(176564);
      }
    });
    AppMethodBeat.o(176589);
  }
  
  public final void aw(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(135057);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135043);
        t localt = t.this;
        String str = paramString;
        if (paramBoolean) {}
        for (br localbr = br.mkm;; localbr = br.mkl)
        {
          t.a(localt, str, localbr);
          AppMethodBeat.o(135043);
          return;
        }
      }
    });
    AppMethodBeat.o(135057);
  }
  
  public final void b(final q paramq, final String paramString)
  {
    AppMethodBeat.i(176590);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176565);
        int i = t.this.k(paramq);
        t.a(t.this, i, paramString, null);
        AppMethodBeat.o(176565);
      }
    });
    AppMethodBeat.o(176590);
  }
  
  public final Iterator<q> buQ()
  {
    AppMethodBeat.i(135054);
    Iterator local12 = new Iterator()
    {
      final ListIterator<q> mff;
      
      public final boolean hasNext()
      {
        AppMethodBeat.i(207804);
        boolean bool = this.mff.hasNext();
        AppMethodBeat.o(207804);
        return bool;
      }
      
      public final void remove()
      {
        AppMethodBeat.i(207805);
        UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(207805);
        throw localUnsupportedOperationException;
      }
    };
    AppMethodBeat.o(135054);
    return local12;
  }
  
  public final void buR()
  {
    AppMethodBeat.i(135060);
    aw(this.jDb.getAppConfig().ber(), true);
    AppMethodBeat.o(135060);
  }
  
  public final z buT()
  {
    AppMethodBeat.i(135082);
    if (!this.mYf) {}
    for (int i = 1;; i = 0)
    {
      this.mYf = true;
      if (this.meN != null) {
        break;
      }
      localObject2 = buU();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new z();
      }
      if (i != 0) {
        ((z)localObject1).mgx = true;
      }
      ((z)localObject1).lUV = getDecorWidgetFactory();
      ((z)localObject1).a(getContext(), this.jDb);
      AppMethodBeat.o(135082);
      return localObject1;
    }
    Object localObject1 = this.meN;
    this.meN = null;
    if (i != 0) {
      ((z)localObject1).mgx = true;
    }
    Object localObject2 = ((b)localObject1).getContentView();
    if (localObject2 != null) {
      ((View)localObject2).setVisibility(0);
    }
    removeView(((z)localObject1).kfr);
    AppMethodBeat.o(135082);
    return localObject1;
  }
  
  final void buV()
  {
    AppMethodBeat.i(135085);
    if (!this.meE)
    {
      this.meF = true;
      AppMethodBeat.o(135085);
      return;
    }
    this.meF = false;
    if ((this.meG != null) && (this.meG.DA()))
    {
      AppMethodBeat.o(135085);
      return;
    }
    getRuntime().j(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207809);
        if (t.g(t.this) != null)
        {
          AppMethodBeat.o(207809);
          return;
        }
        long l = System.currentTimeMillis();
        Object localObject2 = t.h(t.this);
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new z();
        }
        ((z)localObject1).lUV = t.this.getDecorWidgetFactory();
        ((z)localObject1).a(t.this.getContext(), t.c(t.this));
        localObject2 = ((b)localObject1).getContentView();
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(4);
        }
        t.this.addView(((z)localObject1).kfr, 0);
        t.a(t.this, (z)localObject1);
        ae.i("MicroMsg.AppBrandPageContainer", "preloadNextPageView: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(207809);
      }
    }, 200L);
    AppMethodBeat.o(135085);
  }
  
  protected final void buW()
  {
    AppMethodBeat.i(135089);
    if (this.jDb == null)
    {
      AppMethodBeat.o(135089);
      return;
    }
    if (this.meP)
    {
      if (this.meQ != null) {
        this.meQ.aWR();
      }
      onReady();
      this.meP = false;
    }
    AppMethodBeat.o(135089);
  }
  
  public final void c(final String paramString1, final String paramString2, final int[] paramArrayOfInt)
  {
    AppMethodBeat.i(135077);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207808);
        t.a(t.this, paramString1, paramString2, paramArrayOfInt);
        AppMethodBeat.o(207808);
      }
    });
    AppMethodBeat.o(135077);
  }
  
  public final boolean c(String paramString, Runnable paramRunnable)
  {
    AppMethodBeat.i(207827);
    Object localObject = getNavigateBackInterceptorChain();
    boolean bool1 = false;
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      boolean bool2 = ((com.tencent.mm.plugin.appbrand.page.b.e)((Iterator)localObject).next()).a(getRuntime(), paramString, paramRunnable);
      bool1 = bool2;
      if (bool2) {
        bool1 = bool2;
      }
    }
    AppMethodBeat.o(207827);
    return bool1;
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(135081);
    this.mDestroyed = true;
    onDestroy();
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.meK)
    {
      localLinkedList.addAll(this.meK);
      localLinkedList.addAll(this.meL);
      this.meK.clear();
      this.meL.clear();
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext())
      {
        q localq = (q)((Iterator)???).next();
        localq.buO();
        localq.performDestroy();
        localq.Es();
        p(localq);
      }
    }
    localObject1.clear();
    if (this.meN != null) {}
    try
    {
      this.meN.onDestroy();
      try
      {
        label136:
        this.meN.cleanup();
        label143:
        removeAllViews();
        this.meQ = null;
        this.jDb = null;
        this.meR = null;
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
  
  int getActualPageStackSize()
  {
    AppMethodBeat.i(176586);
    synchronized (this.meJ)
    {
      int i = this.meK.size();
      AppMethodBeat.o(176586);
      return i;
    }
  }
  
  public final com.tencent.mm.plugin.appbrand.config.a getAppConfig()
  {
    AppMethodBeat.i(135086);
    com.tencent.mm.plugin.appbrand.config.a locala = this.jDb.getAppConfig();
    AppMethodBeat.o(135086);
    return locala;
  }
  
  public String getAppId()
  {
    return this.mAppId;
  }
  
  /* Error */
  public q getCurrentPage()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: iconst_1
    //   3: istore_3
    //   4: iconst_1
    //   5: istore_1
    //   6: ldc_w 1024
    //   9: invokestatic 156	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: aload_0
    //   13: getfield 170	com/tencent/mm/plugin/appbrand/page/t:meJ	[B
    //   16: astore 4
    //   18: aload 4
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 177	com/tencent/mm/plugin/appbrand/page/t:meL	Ljava/util/LinkedList;
    //   25: invokevirtual 1027	java/util/LinkedList:isEmpty	()Z
    //   28: ifne +126 -> 154
    //   31: aload_0
    //   32: getfield 177	com/tencent/mm/plugin/appbrand/page/t:meL	Ljava/util/LinkedList;
    //   35: invokevirtual 253	java/util/LinkedList:getFirst	()Ljava/lang/Object;
    //   38: checkcast 255	com/tencent/mm/plugin/appbrand/page/q
    //   41: astore 5
    //   43: aload_0
    //   44: getfield 208	com/tencent/mm/plugin/appbrand/page/t:jDb	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   47: ifnull +90 -> 137
    //   50: aload_0
    //   51: getfield 208	com/tencent/mm/plugin/appbrand/page/t:jDb	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   54: invokevirtual 1030	com/tencent/mm/plugin/appbrand/AppBrandRuntime:aWD	()Z
    //   57: ifeq +92 -> 149
    //   60: aload_0
    //   61: getfield 208	com/tencent/mm/plugin/appbrand/page/t:jDb	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   64: getfield 1033	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mInitialized	Z
    //   67: ifne +82 -> 149
    //   70: aload 5
    //   72: ifnonnull +65 -> 137
    //   75: iload_1
    //   76: ifne +61 -> 137
    //   79: ldc 193
    //   81: ldc_w 1035
    //   84: iconst_4
    //   85: anewarray 197	java/lang/Object
    //   88: dup
    //   89: iconst_0
    //   90: aload_0
    //   91: invokevirtual 643	com/tencent/mm/plugin/appbrand/page/t:getAppId	()Ljava/lang/String;
    //   94: aastore
    //   95: dup
    //   96: iconst_1
    //   97: aload_0
    //   98: getfield 177	com/tencent/mm/plugin/appbrand/page/t:meL	Ljava/util/LinkedList;
    //   101: invokevirtual 273	java/util/LinkedList:size	()I
    //   104: invokestatic 576	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: aastore
    //   108: dup
    //   109: iconst_2
    //   110: aload_0
    //   111: getfield 175	com/tencent/mm/plugin/appbrand/page/t:meK	Ljava/util/LinkedList;
    //   114: invokevirtual 273	java/util/LinkedList:size	()I
    //   117: invokestatic 576	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   120: aastore
    //   121: dup
    //   122: iconst_3
    //   123: new 597	java/lang/Throwable
    //   126: dup
    //   127: invokespecial 598	java/lang/Throwable:<init>	()V
    //   130: invokestatic 1041	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   133: aastore
    //   134: invokestatic 519	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: aload 4
    //   139: monitorexit
    //   140: ldc_w 1024
    //   143: invokestatic 217	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aload 5
    //   148: areturn
    //   149: iconst_0
    //   150: istore_1
    //   151: goto -81 -> 70
    //   154: aload_0
    //   155: getfield 175	com/tencent/mm/plugin/appbrand/page/t:meK	Ljava/util/LinkedList;
    //   158: invokevirtual 265	java/util/LinkedList:peekFirst	()Ljava/lang/Object;
    //   161: checkcast 255	com/tencent/mm/plugin/appbrand/page/q
    //   164: astore 5
    //   166: aload_0
    //   167: getfield 208	com/tencent/mm/plugin/appbrand/page/t:jDb	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   170: ifnull +92 -> 262
    //   173: aload_0
    //   174: getfield 208	com/tencent/mm/plugin/appbrand/page/t:jDb	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   177: invokevirtual 1030	com/tencent/mm/plugin/appbrand/AppBrandRuntime:aWD	()Z
    //   180: ifeq +94 -> 274
    //   183: aload_0
    //   184: getfield 208	com/tencent/mm/plugin/appbrand/page/t:jDb	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   187: getfield 1033	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mInitialized	Z
    //   190: ifne +84 -> 274
    //   193: iload_2
    //   194: istore_1
    //   195: aload 5
    //   197: ifnonnull +65 -> 262
    //   200: iload_1
    //   201: ifne +61 -> 262
    //   204: ldc 193
    //   206: ldc_w 1035
    //   209: iconst_4
    //   210: anewarray 197	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: aload_0
    //   216: invokevirtual 643	com/tencent/mm/plugin/appbrand/page/t:getAppId	()Ljava/lang/String;
    //   219: aastore
    //   220: dup
    //   221: iconst_1
    //   222: aload_0
    //   223: getfield 177	com/tencent/mm/plugin/appbrand/page/t:meL	Ljava/util/LinkedList;
    //   226: invokevirtual 273	java/util/LinkedList:size	()I
    //   229: invokestatic 576	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   232: aastore
    //   233: dup
    //   234: iconst_2
    //   235: aload_0
    //   236: getfield 175	com/tencent/mm/plugin/appbrand/page/t:meK	Ljava/util/LinkedList;
    //   239: invokevirtual 273	java/util/LinkedList:size	()I
    //   242: invokestatic 576	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   245: aastore
    //   246: dup
    //   247: iconst_3
    //   248: new 597	java/lang/Throwable
    //   251: dup
    //   252: invokespecial 598	java/lang/Throwable:<init>	()V
    //   255: invokestatic 1041	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   258: aastore
    //   259: invokestatic 519	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   262: aload 4
    //   264: monitorexit
    //   265: ldc_w 1024
    //   268: invokestatic 217	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   271: aload 5
    //   273: areturn
    //   274: iconst_0
    //   275: istore_1
    //   276: goto -81 -> 195
    //   279: astore 5
    //   281: aload_0
    //   282: getfield 208	com/tencent/mm/plugin/appbrand/page/t:jDb	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   285: ifnull +91 -> 376
    //   288: aload_0
    //   289: getfield 208	com/tencent/mm/plugin/appbrand/page/t:jDb	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   292: invokevirtual 1030	com/tencent/mm/plugin/appbrand/AppBrandRuntime:aWD	()Z
    //   295: ifeq +104 -> 399
    //   298: aload_0
    //   299: getfield 208	com/tencent/mm/plugin/appbrand/page/t:jDb	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   302: getfield 1033	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mInitialized	Z
    //   305: ifne +94 -> 399
    //   308: iload_3
    //   309: istore_1
    //   310: iconst_0
    //   311: ifne +65 -> 376
    //   314: iload_1
    //   315: ifne +61 -> 376
    //   318: ldc 193
    //   320: ldc_w 1035
    //   323: iconst_4
    //   324: anewarray 197	java/lang/Object
    //   327: dup
    //   328: iconst_0
    //   329: aload_0
    //   330: invokevirtual 643	com/tencent/mm/plugin/appbrand/page/t:getAppId	()Ljava/lang/String;
    //   333: aastore
    //   334: dup
    //   335: iconst_1
    //   336: aload_0
    //   337: getfield 177	com/tencent/mm/plugin/appbrand/page/t:meL	Ljava/util/LinkedList;
    //   340: invokevirtual 273	java/util/LinkedList:size	()I
    //   343: invokestatic 576	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   346: aastore
    //   347: dup
    //   348: iconst_2
    //   349: aload_0
    //   350: getfield 175	com/tencent/mm/plugin/appbrand/page/t:meK	Ljava/util/LinkedList;
    //   353: invokevirtual 273	java/util/LinkedList:size	()I
    //   356: invokestatic 576	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   359: aastore
    //   360: dup
    //   361: iconst_3
    //   362: new 597	java/lang/Throwable
    //   365: dup
    //   366: invokespecial 598	java/lang/Throwable:<init>	()V
    //   369: invokestatic 1041	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   372: aastore
    //   373: invokestatic 519	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   376: ldc_w 1024
    //   379: invokestatic 217	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   382: aload 5
    //   384: athrow
    //   385: astore 5
    //   387: aload 4
    //   389: monitorexit
    //   390: ldc_w 1024
    //   393: invokestatic 217	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   396: aload 5
    //   398: athrow
    //   399: iconst_0
    //   400: istore_1
    //   401: goto -91 -> 310
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	404	0	this	t
    //   5	396	1	i	int
    //   1	193	2	j	int
    //   3	306	3	k	int
    //   16	372	4	arrayOfByte	byte[]
    //   41	231	5	localq	q
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
      localObject = ((q)localObject).getCurrentUrl();
      AppMethodBeat.o(135080);
      return localObject;
    }
    AppMethodBeat.o(135080);
    return null;
  }
  
  public bq getDecorWidgetFactory()
  {
    return this.lUV;
  }
  
  public List<com.tencent.mm.plugin.appbrand.page.b.e> getNavigateBackInterceptorChain()
  {
    AppMethodBeat.i(207822);
    synchronized (this.meI)
    {
      if ((this.meI.size() == 0) || (getCurrentPage() == null))
      {
        AppMethodBeat.o(207822);
        return null;
      }
      ArrayList localArrayList = new ArrayList(this.meI.values());
      Collections.sort(localArrayList, new Comparator() {});
      AppMethodBeat.o(207822);
      return localArrayList;
    }
  }
  
  public final int getPageCount()
  {
    AppMethodBeat.i(135053);
    synchronized (this.meJ)
    {
      int i = this.meK.size();
      int j = this.meL.size();
      AppMethodBeat.o(135053);
      return i + j;
    }
  }
  
  public final z getPageView()
  {
    AppMethodBeat.i(135084);
    if (this.mDestroyed)
    {
      AppMethodBeat.o(135084);
      return null;
    }
    boolean bool = this.jDb.jAe;
    Object localObject = getCurrentPage();
    if (localObject == null)
    {
      if (bool) {
        Assert.fail("getPageView() assert by NULL page, appId=" + getAppId());
      }
      AppMethodBeat.o(135084);
      return null;
    }
    localObject = ((q)localObject).getCurrentPageView();
    if ((localObject == null) && (bool)) {
      Assert.fail("getPageView() assert by NULL pv, appId=" + getAppId());
    }
    AppMethodBeat.o(135084);
    return localObject;
  }
  
  z getPreloadedPageView()
  {
    return this.meN;
  }
  
  public AppBrandRuntime getRuntime()
  {
    return this.jDb;
  }
  
  public final q j(q paramq)
  {
    AppMethodBeat.i(135079);
    synchronized (this.meJ)
    {
      if (this.meL.indexOf(paramq) >= 0)
      {
        paramq = (q)this.meK.peekFirst();
        AppMethodBeat.o(135079);
        return paramq;
      }
      int i = this.meK.indexOf(paramq);
      if (i >= this.meK.size() - 1)
      {
        AppMethodBeat.o(135079);
        return null;
      }
      paramq = (q)this.meK.get(i + 1);
      AppMethodBeat.o(135079);
      return paramq;
    }
  }
  
  final int k(q paramq)
  {
    AppMethodBeat.i(176597);
    synchronized (this.meJ)
    {
      int i = this.meK.indexOf(paramq);
      AppMethodBeat.o(176597);
      return i;
    }
  }
  
  public Object l(q paramq)
  {
    AppMethodBeat.i(135090);
    paramq = ObjectAnimator.ofFloat(paramq, "translationX", new float[] { paramq.getWidth(), 0.0F });
    paramq.setDuration(250L);
    AppMethodBeat.o(135090);
    return paramq;
  }
  
  public Object m(q paramq)
  {
    AppMethodBeat.i(135091);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramq, "translationX", new float[] { 0.0F, -(paramq.getWidth() * 0.25F) });
    localObjectAnimator.setDuration(250L);
    paramq = ObjectAnimator.ofFloat(paramq, "translationX", new float[] { 0.0F });
    paramq.setDuration(0L);
    new AnimatorSet().playSequentially(new Animator[] { localObjectAnimator, paramq });
    AppMethodBeat.o(135091);
    return localObjectAnimator;
  }
  
  public Object n(q paramq)
  {
    AppMethodBeat.i(135092);
    paramq = ObjectAnimator.ofFloat(paramq, "translationX", new float[] { -(paramq.getWidth() * 0.25F), 0.0F });
    paramq.setDuration(250L);
    AppMethodBeat.o(135092);
    return paramq;
  }
  
  public Object o(q paramq)
  {
    AppMethodBeat.i(135093);
    paramq = ObjectAnimator.ofFloat(paramq, "translationX", new float[] { 0.0F, paramq.getWidth() });
    paramq.setDuration(250L);
    AppMethodBeat.o(135093);
    return paramq;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(135096);
    q localq = getCurrentPage();
    if (localq == null)
    {
      AppMethodBeat.o(135096);
      return;
    }
    if (localq.getCurrentPageView().onBackPressed())
    {
      AppMethodBeat.o(135096);
      return;
    }
    synchronized (this.meJ)
    {
      int i;
      if (!this.meL.isEmpty())
      {
        i = 1;
        if ((i != 0) || (localq.getTag(meD) != null))
        {
          ae.w("MicroMsg.AppBrandPageContainer", "onBackPressed, has navigating pages, skip");
          AppMethodBeat.o(135096);
        }
      }
      else
      {
        i = 0;
      }
    }
    TT("scene_back_key_pressed");
    AppMethodBeat.o(135096);
  }
  
  public void onBackground()
  {
    AppMethodBeat.i(135088);
    synchronized (this.meJ)
    {
      q localq = (q)this.meK.peekFirst();
      if (localq == null)
      {
        AppMethodBeat.o(135088);
        return;
      }
    }
    localObject.buO();
    AppMethodBeat.o(135088);
  }
  
  protected void onDestroy() {}
  
  public void onForeground()
  {
    AppMethodBeat.i(135087);
    synchronized (this.meJ)
    {
      q localq = (q)this.meK.peekFirst();
      if (localq == null)
      {
        AppMethodBeat.o(135087);
        return;
      }
    }
    localObject.buN();
    if (this.meE)
    {
      ae.d("MicroMsg.AppBrandPageContainer", "onForeground, call onUserVisible, appId[%s] url[%s]", new Object[] { getAppId(), localObject.getCurrentPageView().kxv });
      localObject.getCurrentPageView().bvn();
    }
    AppMethodBeat.o(135087);
  }
  
  protected void onReady() {}
  
  protected final void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(135052);
    if ((Looper.myLooper() != null) && (Looper.myLooper() == Looper.getMainLooper()))
    {
      paramRunnable.run();
      AppMethodBeat.o(135052);
      return;
    }
    if (this.jDb == null)
    {
      ae.w("MicroMsg.AppBrandPageContainer", "runOnUiThread but mRuntime==NULL, appId:%s, stack:%s", new Object[] { getAppId(), Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(135052);
      return;
    }
    this.jDb.j(paramRunnable, 0L);
    AppMethodBeat.o(135052);
  }
  
  public void setActuallyVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(135051);
    if (this.meE != paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.meE = paramBoolean;
      if ((paramBoolean) && (i != 0))
      {
        getCurrentPage().getCurrentPageView().bvn();
        super.setVisibility(0);
        if (this.meF) {
          buV();
        }
      }
      if ((!paramBoolean) && (i != 0)) {
        super.setVisibility(4);
      }
      AppMethodBeat.o(135051);
      return;
    }
  }
  
  public void setDecorWidgetFactory(bq parambq)
  {
    AppMethodBeat.i(135049);
    if (parambq == null)
    {
      parambq = new NullPointerException("Should not be null");
      AppMethodBeat.o(135049);
      throw parambq;
    }
    this.lUV = parambq;
    AppMethodBeat.o(135049);
  }
  
  public final void setDelegate(a parama)
  {
    AppMethodBeat.i(135050);
    if (this.meG != null)
    {
      parama = new IllegalAccessError("Duplicated call!!!");
      AppMethodBeat.o(135050);
      throw parama;
    }
    a locala = parama;
    if (this.meH != null) {
      locala = this.meH.a(parama);
    }
    this.meG = locala;
    AppMethodBeat.o(135050);
  }
  
  public void setDelegateWrapperFactory(b paramb)
  {
    AppMethodBeat.i(176584);
    this.meH = paramb;
    if (this.meG != null) {
      this.meG = paramb.a(this.meG);
    }
    AppMethodBeat.o(176584);
  }
  
  public void setOnPageSwitchListener(e parame)
  {
    AppMethodBeat.i(176601);
    ae.d("MicroMsg.AppBrandPageContainer", "setOnPageSwitchListener, onPageSwitchListener: ".concat(String.valueOf(parame)));
    this.meU = parame;
    AppMethodBeat.o(176601);
  }
  
  public void setOnReadyListener(f paramf)
  {
    this.meQ = paramf;
  }
  
  public void setPipPageLifeCycleListener(i parami)
  {
    this.meR = parami;
  }
  
  public void setPipVideoRelatedPage(q paramq)
  {
    AppMethodBeat.i(207821);
    if (paramq != null) {
      ae.i("MicroMsg.AppBrandPageContainer", "setPipVideoRelatedPage, page(%s)", new Object[] { paramq.getCurrentUrl() });
    }
    for (;;)
    {
      this.meO = paramq;
      AppMethodBeat.o(207821);
      return;
      ae.i("MicroMsg.AppBrandPageContainer", "setPipVideoRelatedPage, page is null");
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean DA();
    
    public abstract q a(String paramString, br parambr, t paramt, Callable<q> paramCallable);
    
    public abstract z a(t paramt);
    
    public abstract boolean a(String paramString, br parambr, t paramt, t.d paramd);
  }
  
  public static abstract interface b
  {
    public abstract t.a a(t.a parama);
  }
  
  static abstract interface c
    extends Runnable
  {
    public abstract void hf(boolean paramBoolean);
  }
  
  public static abstract interface d
  {
    public abstract void buX();
    
    public abstract void cancel();
    
    public abstract void proceed();
  }
  
  public static abstract interface e
  {
    public abstract void aG(float paramFloat);
    
    public abstract t.h b(br parambr, q paramq1, q paramq2);
    
    public abstract void c(br parambr, q paramq1, q paramq2);
    
    public abstract void d(br parambr, q paramq1, q paramq2);
  }
  
  public static abstract interface f
  {
    public abstract void aWR();
  }
  
  public static enum h
  {
    public final String name;
    
    static
    {
      AppMethodBeat.i(176583);
      mfx = new h("MIN", 0, "min");
      mfy = new h("MAX", 1, "max");
      mfz = new h[] { mfx, mfy };
      AppMethodBeat.o(176583);
    }
    
    private h(String paramString)
    {
      this.name = paramString;
    }
  }
  
  public static abstract interface i
  {
    public abstract void q(q paramq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.t
 * JD-Core Version:    0.7.0.1
 */