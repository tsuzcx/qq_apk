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
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.f.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Callable;
import junit.framework.Assert;

@SuppressLint({"ViewConstructor"})
public class t
  extends FrameLayout
{
  static final int kZb = 2131296777;
  private AppBrandRuntime iGV;
  private bx kPL;
  private boolean kZc;
  private boolean kZd;
  private a kZe;
  private b kZf;
  private com.tencent.mm.plugin.appbrand.page.c.d<AppBrandRuntime> kZg;
  private final byte[] kZh;
  private final LinkedList<q> kZi;
  private final LinkedList<q> kZj;
  private final LinkedList<c> kZk;
  private aa kZl;
  private boolean kZm;
  private t.f kZn;
  private i kZo;
  t.h kZp;
  boolean kZq;
  e kZr;
  private String mAppId;
  private volatile boolean mDestroyed;
  
  public t(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramContext);
    AppMethodBeat.i(135048);
    this.mDestroyed = false;
    this.kZc = false;
    this.kZd = false;
    this.kZg = com.tencent.mm.plugin.appbrand.page.c.a.lgN;
    this.kZh = new byte[0];
    this.kZi = new LinkedList();
    this.kZj = new LinkedList();
    this.kZk = new LinkedList();
    this.kZm = true;
    this.kZo = null;
    this.kZp = null;
    this.kZq = false;
    this.kZr = null;
    ad.i("MicroMsg.AppBrandPageContainer", "AppBrandPageContainerProfile| <init> appId[%s]", new Object[] { paramAppBrandRuntime.mAppId });
    this.iGV = paramAppBrandRuntime;
    this.mAppId = paramAppBrandRuntime.mAppId;
    this.kPL = new bx.a();
    AppMethodBeat.o(135048);
  }
  
  private q LA(String paramString)
  {
    AppMethodBeat.i(135074);
    synchronized (this.kZh)
    {
      q localq = (q)this.kZi.peekFirst();
      if (((localq instanceof j)) && (localq.cl(paramString)))
      {
        AppMethodBeat.o(135074);
        return localq;
      }
      AppMethodBeat.o(135074);
      return null;
    }
  }
  
  private q LB(String paramString)
  {
    AppMethodBeat.i(135075);
    synchronized (this.kZh)
    {
      if (this.kZi.size() < 2)
      {
        AppMethodBeat.o(135075);
        return null;
      }
      ListIterator localListIterator = this.kZi.listIterator(1);
      while (localListIterator.hasNext())
      {
        q localq = (q)localListIterator.next();
        if (((localq instanceof j)) && (localq.cl(paramString)))
        {
          AppMethodBeat.o(135075);
          return localq;
        }
      }
      AppMethodBeat.o(135075);
      return null;
    }
  }
  
  private q a(String paramString, by paramby)
  {
    AppMethodBeat.i(135065);
    if (b(paramString, paramby))
    {
      paramString = new j(getContext(), this);
      AppMethodBeat.o(135065);
      return paramString;
    }
    paramString = new an(getContext(), this);
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
      paramq.setTag(kZb, localObject);
      ((Animator)localObject).addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(176572);
          paramq.setTag(t.kZb, null);
          if (paramRunnable != null)
          {
            t.this.removeCallbacks(paramRunnable);
            if (!t.i(t.this)) {
              paramRunnable.run();
            }
          }
          AppMethodBeat.o(176572);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(176573);
          paramq.setTag(t.kZb, null);
          if (paramRunnable != null) {
            t.this.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(176571);
                if (!t.i(t.this)) {
                  t.16.this.val$runnable.run();
                }
                AppMethodBeat.o(176571);
              }
            });
          }
          AppMethodBeat.o(176573);
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
            AppMethodBeat.i(176575);
            if (paramRunnable != null)
            {
              Runnable local1 = new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(176574);
                  if (!t.i(t.this)) {
                    t.17.this.val$runnable.run();
                  }
                  t.17.this.kZu.setTag(t.kZb, null);
                  AppMethodBeat.o(176574);
                }
              };
              if (paramAnonymousAnimation.getStartTime() == -9223372036854775808L)
              {
                local1.run();
                AppMethodBeat.o(176575);
                return;
              }
              if (!t.i(t.this)) {
                t.this.post(local1);
              }
              AppMethodBeat.o(176575);
              return;
            }
            paramq.setTag(t.kZb, null);
            AppMethodBeat.o(176575);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
        p(paramq);
        paramq.setTag(kZb, localObject);
        paramq.startAnimation((Animation)localObject);
      }
      else
      {
        if (paramObject != null) {
          break;
        }
        paramRunnable.run();
      }
    }
    paramq = new IllegalArgumentException("Page animation should be Animator or Animation");
    AppMethodBeat.o(176598);
    throw paramq;
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
    synchronized (this.kZh)
    {
      this.kZi.remove(paramq);
      this.kZj.remove(paramq);
      paramq.bjl();
      ??? = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135033);
          if (paramBoolean2) {
            t.a(t.this, paramq);
          }
          AppMethodBeat.o(135033);
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
  
  private void a(by paramby, q paramq1, q paramq2)
  {
    AppMethodBeat.i(176600);
    if (this.kZr == null)
    {
      AppMethodBeat.o(176600);
      return;
    }
    if (!this.kZq)
    {
      this.kZp = this.kZr.b(paramby, paramq1, paramq2);
      this.kZq = true;
    }
    this.kZr.c(paramby, paramq1, paramq2);
    this.kZq = false;
    AppMethodBeat.o(176600);
  }
  
  private void a(final by paramby, final q paramq1, final q paramq2, final t.g paramg)
  {
    AppMethodBeat.i(176599);
    ad.d("MicroMsg.AppBrandPageContainer", "processPageSwitchResult, pageSwitchResult: ".concat(String.valueOf(paramg)));
    if (this.kZr == null)
    {
      ad.d("MicroMsg.AppBrandPageContainer", "processPageSwitchResult, null == mOnPageSwitchListener");
      AppMethodBeat.o(176599);
      return;
    }
    paramg = paramg.kZR;
    if ((paramg instanceof ValueAnimator))
    {
      paramg = (ValueAnimator)paramg;
      paramg.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(176577);
          super.onAnimationCancel(paramAnonymousAnimator);
          t.j(t.this).d(paramby, paramq1, paramq2);
          t.k(t.this);
          AppMethodBeat.o(176577);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(176576);
          super.onAnimationEnd(paramAnonymousAnimator);
          t.a(t.this, paramby, paramq1, paramq2);
          AppMethodBeat.o(176576);
        }
      });
      paramg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(176578);
          int i = (int)(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * 100.0F);
          t.j(t.this).az(i);
          AppMethodBeat.o(176578);
        }
      });
      AppMethodBeat.o(176599);
      return;
    }
    if ((paramg instanceof Animation))
    {
      paramg = (Animation)paramg;
      long l = paramg.getDuration();
      paramby = new Choreographer.FrameCallback()
      {
        public final void doFrame(long paramAnonymousLong)
        {
          AppMethodBeat.i(176579);
          float f = ((float)(SystemClock.elapsedRealtime() - this.kZK) + 0.0F) / (float)paramby;
          if (1.0F <= f)
          {
            t.a(t.this, paramq2, paramg, this.kZJ);
            AppMethodBeat.o(176579);
            return;
          }
          int i = (int)(this.kZL.getInterpolator().getInterpolation(f) * 100.0F);
          t.j(t.this).az(i);
          Choreographer.getInstance().postFrameCallback(this);
          AppMethodBeat.o(176579);
        }
      };
      Choreographer.getInstance().postFrameCallback(paramby);
      AppMethodBeat.o(176599);
      return;
    }
    a(paramby, paramq1, paramq2);
    AppMethodBeat.o(176599);
  }
  
  private void a(final q paramq1, final q paramq2, by paramby, t.h paramh)
  {
    Object localObject2 = null;
    AppMethodBeat.i(176594);
    for (;;)
    {
      synchronized (this.kZh)
      {
        this.kZi.remove(paramq2);
        this.kZj.remove(paramq2);
        if (!paramq2.mSwiping)
        {
          i = 1;
          if (i == 0) {
            break label210;
          }
          ??? = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(135031);
              t.a(t.this, paramq2);
              AppMethodBeat.o(135031);
            }
          };
          ??? = a(paramq2, o(paramq2), (Runnable)???);
          ad.i("MicroMsg.AppBrandPageContainer", "switchPageClear, in: %s out: %s", new Object[] { paramq1.getCurrentUrl(), paramq2.getCurrentUrl() });
          ad.d("MicroMsg.AppBrandPageContainer", "switchPageClear, dispatchRoute, type: %s, pipMode: %s", new Object[] { paramby, paramh });
          paramq1.a(paramby, paramh);
          paramq1.bjk();
          if (i == 0) {
            break label221;
          }
          paramh = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(135032);
              paramq1.bjm();
              AppMethodBeat.o(135032);
            }
          };
          paramh = a(paramq1, n(paramq1), paramh);
          a(paramby, paramq2, paramq1, new t.g(paramh, ???));
          AppMethodBeat.o(176594);
          return;
        }
      }
      int i = 0;
      continue;
      label210:
      i(paramq2);
      ??? = null;
      continue;
      label221:
      paramq1.bjm();
      paramh = localObject2;
    }
  }
  
  private Object b(final q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(176596);
    if (paramq == null)
    {
      AppMethodBeat.o(176596);
      return null;
    }
    synchronized (this.kZh)
    {
      this.kZi.remove(paramq);
      this.kZi.push(paramq);
      this.kZj.remove(paramq);
      paramq.bringToFront();
      requestLayout();
      invalidate();
      paramq.bjk();
      ??? = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135035);
          t.this.bjs();
          paramq.bjm();
          AppMethodBeat.o(135035);
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
    synchronized (this.kZh)
    {
      Iterator localIterator = this.kZi.iterator();
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
            this.kZj.remove(localq);
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
  
  private static boolean b(by paramby)
  {
    return (paramby == by.lgr) || (paramby == by.lgs) || (paramby == by.lgv) || (paramby == by.lgt) || (paramby == by.lgu);
  }
  
  private boolean b(String paramString, by paramby)
  {
    AppMethodBeat.i(135069);
    if (paramby == by.lgv)
    {
      AppMethodBeat.o(135069);
      return true;
    }
    if ((paramby == by.lgt) || (paramby == by.lgu))
    {
      boolean bool = this.iGV.getAppConfig().aTn().FL(paramString);
      AppMethodBeat.o(135069);
      return bool;
    }
    for (;;)
    {
      synchronized (this.kZh)
      {
        if (paramby == by.lgr) {
          break label169;
        }
        if (paramby == by.lgs)
        {
          break label169;
          int j = this.kZi.size();
          if (i != 0)
          {
            i = 1;
            if ((!this.iGV.getAppConfig().aTn().FL(paramString)) || (j + 1 - i != 1)) {
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
  
  private void bjp()
  {
    AppMethodBeat.i(176593);
    synchronized (this.kZh)
    {
      Object localObject2 = new LinkedList(this.kZk);
      this.kZk.clear();
      ??? = ((LinkedList)localObject2).descendingIterator();
      if (((Iterator)???).hasNext())
      {
        localObject2 = (c)((Iterator)???).next();
        ((c)localObject2).gy(true);
        ((c)localObject2).run();
        ((Iterator)???).remove();
      }
    }
    AppMethodBeat.o(176593);
  }
  
  private aa bjr()
  {
    AppMethodBeat.i(135083);
    if (this.kZe != null)
    {
      aa localaa = this.kZe.a(this);
      if (localaa != null)
      {
        AppMethodBeat.o(135083);
        return localaa;
      }
    }
    AppMethodBeat.o(135083);
    return null;
  }
  
  private static boolean c(by paramby)
  {
    AppMethodBeat.i(135068);
    boolean bool = com.tencent.mm.compatible.loader.a.contains(new by[] { by.lgv, by.lgt, by.lgu }, paramby);
    AppMethodBeat.o(135068);
    return bool;
  }
  
  private void i(q paramq)
  {
    AppMethodBeat.i(135076);
    if (this.kZo != null) {
      this.kZo.q(paramq);
    }
    paramq.setVisibility(8);
    paramq.bjl();
    if (!paramq.kYU) {
      paramq.performDestroy();
    }
    removeView(paramq);
    if (!paramq.kYU) {
      paramq.Do();
    }
    AppMethodBeat.o(135076);
  }
  
  private static void p(q paramq)
  {
    AppMethodBeat.i(135094);
    paramq.clearAnimation();
    paramq = paramq.getTag(kZb);
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
  
  public void Kx(final String paramString)
  {
    AppMethodBeat.i(135055);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135034);
        t.a(t.this, paramString, by.lgo);
        AppMethodBeat.o(135034);
      }
    });
    AppMethodBeat.o(135055);
  }
  
  public final void Lv(final String paramString)
  {
    AppMethodBeat.i(135056);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135041);
        t.a(t.this, paramString, by.lgp);
        AppMethodBeat.o(135041);
      }
    });
    AppMethodBeat.o(135056);
  }
  
  public final void Lw(final String paramString)
  {
    AppMethodBeat.i(135058);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135043);
        t.a(t.this, paramString, by.lgr);
        AppMethodBeat.o(135043);
      }
    });
    AppMethodBeat.o(135058);
  }
  
  public final boolean Lx(String paramString)
  {
    AppMethodBeat.i(194493);
    aa localaa;
    if (getCurrentPage() != null)
    {
      localaa = getCurrentPage().getCurrentPageView();
      if (localaa != null) {}
    }
    else
    {
      ad.w("MicroMsg.AppBrandPageContainer", "rewriteRoute invalid page appId:%s, url:%s", new Object[] { getAppId(), paramString });
      AppMethodBeat.o(194493);
      return false;
    }
    boolean bool = localaa.Lx(paramString);
    AppMethodBeat.o(194493);
    return bool;
  }
  
  public final void Ly(final String paramString)
  {
    AppMethodBeat.i(135059);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135044);
        t.a(t.this, paramString, by.lgv);
        AppMethodBeat.o(135044);
      }
    });
    AppMethodBeat.o(135059);
  }
  
  public final void Lz(String paramString)
  {
    AppMethodBeat.i(176587);
    runOnUiThread(new t.26(this, paramString));
    AppMethodBeat.o(176587);
  }
  
  protected t.h a(q paramq1, q paramq2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(176591);
    String str = getAppId();
    Object localObject1;
    if (paramq1 == null)
    {
      localObject1 = null;
      if (paramq2 != null) {
        break label148;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.AppBrandPageContainer", "onNavigateBack, appId[%s] out[%s], in[%s], mActuallyVisible[%b]", new Object[] { str, localObject1, localObject2, Boolean.valueOf(this.kZc) });
      if (this.kZc) {
        paramq2.getCurrentPageView().bjL();
      }
      if (paramq1 != null) {
        paramq1.hideVKB();
      }
      localObject2 = this.kZp;
      localObject1 = localObject2;
      if (this.kZr != null)
      {
        localObject1 = localObject2;
        if (!this.kZq)
        {
          localObject1 = this.kZr.b(by.lgq, paramq1, paramq2);
          this.kZq = true;
        }
      }
      AppMethodBeat.o(176591);
      return localObject1;
      localObject1 = k.cA(paramq1.getCurrentUrl());
      break;
      label148:
      localObject2 = k.cA(paramq2.getCurrentUrl());
    }
  }
  
  public t.h a(q paramq1, q paramq2, by paramby, String paramString)
  {
    AppMethodBeat.i(176592);
    String str = getAppId();
    if (paramq1 == null) {}
    for (Object localObject = null;; localObject = k.cA(paramq1.getCurrentUrl()))
    {
      ad.i("MicroMsg.AppBrandPageContainer", "onNavigateStart, appId[%s] out[%s], in[%s], mActuallyVisible[%b], type[%s]", new Object[] { str, localObject, k.cA(paramString), Boolean.valueOf(this.kZc), paramby });
      if (paramq1 != null) {
        paramq1.hideVKB();
      }
      localObject = this.kZp;
      paramString = (String)localObject;
      if (this.kZr != null)
      {
        paramString = (String)localObject;
        if (!this.kZq)
        {
          paramString = this.kZr.b(paramby, paramq1, paramq2);
          this.kZq = true;
        }
      }
      if ((paramq1 != null) && (paramq1.getCurrentPageView() != null) && (paramq1.getCurrentPageView().getFullscreenImpl() != null) && (paramq1.getCurrentPageView().getFullscreenImpl().blI())) {
        paramq1.getCurrentPageView().getFullscreenImpl().aNT();
      }
      AppMethodBeat.o(176592);
      return paramString;
    }
  }
  
  public void a(q paramq1, q paramq2, by paramby)
  {
    AppMethodBeat.i(135067);
    String str = getAppId();
    if (paramq1 == null) {}
    for (paramq1 = null;; paramq1 = k.cA(paramq1.getCurrentUrl()))
    {
      ad.i("MicroMsg.AppBrandPageContainer", "onNavigateEnd, appId[%s] out[%s], in[%s], mActuallyVisible[%b], type[%s]", new Object[] { str, paramq1, k.cA(paramq2.getCurrentUrl()), Boolean.valueOf(this.kZc), paramby });
      if (this.kZc) {
        paramq2.getCurrentPageView().bjL();
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
        AppMethodBeat.i(135024);
        int i = t.this.k(paramq);
        if (i < 0)
        {
          ad.w("MicroMsg.AppBrandPageContainer", "navigateBack with appId(%s) Page(%s), but already off stack, maybe frequent clicks were performed", new Object[] { t.this.getAppId(), paramq.getCurrentUrl() });
          AppMethodBeat.o(135024);
          return;
        }
        t.a(t.this, i + 1, paramString);
        AppMethodBeat.o(135024);
      }
    });
    AppMethodBeat.o(176589);
  }
  
  public final void am(int paramInt, String paramString)
  {
    AppMethodBeat.i(176588);
    runOnUiThread(new t.27(this, paramInt, paramString));
    AppMethodBeat.o(176588);
  }
  
  public final void at(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(135057);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135042);
        t localt = t.this;
        String str = paramString;
        if (paramBoolean) {}
        for (by localby = by.lgu;; localby = by.lgt)
        {
          t.a(localt, str, localby);
          AppMethodBeat.o(135042);
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
        AppMethodBeat.i(176564);
        int i = t.this.k(paramq);
        t.a(t.this, i, paramString);
        AppMethodBeat.o(176564);
      }
    });
    AppMethodBeat.o(176590);
  }
  
  public final Iterator<q> bjn()
  {
    AppMethodBeat.i(135054);
    t.1 local1 = new t.1(this);
    AppMethodBeat.o(135054);
    return local1;
  }
  
  public final void bjo()
  {
    AppMethodBeat.i(135060);
    at(this.iGV.getAppConfig().aTo(), true);
    AppMethodBeat.o(135060);
  }
  
  public final aa bjq()
  {
    AppMethodBeat.i(135082);
    if (this.kZl == null)
    {
      localObject2 = bjr();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new aa();
      }
      ((aa)localObject1).kPL = getDecorWidgetFactory();
      ((aa)localObject1).a(getContext(), this.iGV);
      AppMethodBeat.o(135082);
      return localObject1;
    }
    Object localObject1 = this.kZl;
    this.kZl = null;
    Object localObject2 = ((c)localObject1).getContentView();
    if (localObject2 != null) {
      ((View)localObject2).setVisibility(0);
    }
    removeView(((aa)localObject1).jhz);
    AppMethodBeat.o(135082);
    return localObject1;
  }
  
  final void bjs()
  {
    AppMethodBeat.i(135085);
    if (!this.kZc)
    {
      this.kZd = true;
      AppMethodBeat.o(135085);
      return;
    }
    this.kZd = false;
    if ((this.kZe != null) && (this.kZe.Cu()))
    {
      AppMethodBeat.o(135085);
      return;
    }
    getRuntime().i(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176570);
        if (t.g(t.this) != null)
        {
          AppMethodBeat.o(176570);
          return;
        }
        long l = System.currentTimeMillis();
        Object localObject2 = t.h(t.this);
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new aa();
        }
        ((aa)localObject1).kPL = t.this.getDecorWidgetFactory();
        ((aa)localObject1).a(t.this.getContext(), t.c(t.this));
        localObject2 = ((c)localObject1).getContentView();
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(4);
        }
        t.this.addView(((aa)localObject1).jhz, 0);
        t.a(t.this, (aa)localObject1);
        ad.i("MicroMsg.AppBrandPageContainer", "preloadNextPageView: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(176570);
      }
    }, 200L);
    AppMethodBeat.o(135085);
  }
  
  protected final void bjt()
  {
    AppMethodBeat.i(135089);
    if (this.iGV == null)
    {
      AppMethodBeat.o(135089);
      return;
    }
    if (this.kZm)
    {
      if (this.kZn != null) {
        this.kZn.aMr();
      }
      onReady();
      this.kZm = false;
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
        AppMethodBeat.i(176569);
        t.a(t.this, paramString1, paramString2, paramArrayOfInt);
        AppMethodBeat.o(176569);
      }
    });
    AppMethodBeat.o(135077);
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(135081);
    this.mDestroyed = true;
    onDestroy();
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.kZi)
    {
      localLinkedList.addAll(this.kZi);
      localLinkedList.addAll(this.kZj);
      this.kZi.clear();
      this.kZj.clear();
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext())
      {
        q localq = (q)((Iterator)???).next();
        localq.bjl();
        localq.performDestroy();
        localq.Do();
        p(localq);
      }
    }
    localObject1.clear();
    if (this.kZl != null) {}
    try
    {
      this.kZl.onDestroy();
      try
      {
        label136:
        this.kZl.cleanup();
        label143:
        removeAllViews();
        this.kZn = null;
        this.iGV = null;
        this.kZo = null;
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
    synchronized (this.kZh)
    {
      int i = this.kZi.size();
      AppMethodBeat.o(176586);
      return i;
    }
  }
  
  public final com.tencent.mm.plugin.appbrand.config.a getAppConfig()
  {
    AppMethodBeat.i(135086);
    com.tencent.mm.plugin.appbrand.config.a locala = this.iGV.getAppConfig();
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
    //   6: ldc_w 960
    //   9: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: aload_0
    //   13: getfield 155	com/tencent/mm/plugin/appbrand/page/t:kZh	[B
    //   16: astore 4
    //   18: aload 4
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 163	com/tencent/mm/plugin/appbrand/page/t:kZj	Ljava/util/LinkedList;
    //   25: invokevirtual 963	java/util/LinkedList:isEmpty	()Z
    //   28: ifne +126 -> 154
    //   31: aload_0
    //   32: getfield 163	com/tencent/mm/plugin/appbrand/page/t:kZj	Ljava/util/LinkedList;
    //   35: invokevirtual 531	java/util/LinkedList:getFirst	()Ljava/lang/Object;
    //   38: checkcast 210	com/tencent/mm/plugin/appbrand/page/q
    //   41: astore 5
    //   43: aload_0
    //   44: getfield 192	com/tencent/mm/plugin/appbrand/page/t:iGV	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   47: ifnull +90 -> 137
    //   50: aload_0
    //   51: getfield 192	com/tencent/mm/plugin/appbrand/page/t:iGV	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   54: invokevirtual 966	com/tencent/mm/plugin/appbrand/AppBrandRuntime:aLY	()Z
    //   57: ifeq +92 -> 149
    //   60: aload_0
    //   61: getfield 192	com/tencent/mm/plugin/appbrand/page/t:iGV	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   64: getfield 969	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mInitialized	Z
    //   67: ifne +82 -> 149
    //   70: aload 5
    //   72: ifnonnull +65 -> 137
    //   75: iload_1
    //   76: ifne +61 -> 137
    //   79: ldc 177
    //   81: ldc_w 971
    //   84: iconst_4
    //   85: anewarray 181	java/lang/Object
    //   88: dup
    //   89: iconst_0
    //   90: aload_0
    //   91: invokevirtual 614	com/tencent/mm/plugin/appbrand/page/t:getAppId	()Ljava/lang/String;
    //   94: aastore
    //   95: dup
    //   96: iconst_1
    //   97: aload_0
    //   98: getfield 163	com/tencent/mm/plugin/appbrand/page/t:kZj	Ljava/util/LinkedList;
    //   101: invokevirtual 222	java/util/LinkedList:size	()I
    //   104: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: aastore
    //   108: dup
    //   109: iconst_2
    //   110: aload_0
    //   111: getfield 161	com/tencent/mm/plugin/appbrand/page/t:kZi	Ljava/util/LinkedList;
    //   114: invokevirtual 222	java/util/LinkedList:size	()I
    //   117: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   120: aastore
    //   121: dup
    //   122: iconst_3
    //   123: new 574	java/lang/Throwable
    //   126: dup
    //   127: invokespecial 575	java/lang/Throwable:<init>	()V
    //   130: invokestatic 977	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   133: aastore
    //   134: invokestatic 472	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: aload 4
    //   139: monitorexit
    //   140: ldc_w 960
    //   143: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aload 5
    //   148: areturn
    //   149: iconst_0
    //   150: istore_1
    //   151: goto -81 -> 70
    //   154: aload_0
    //   155: getfield 161	com/tencent/mm/plugin/appbrand/page/t:kZi	Ljava/util/LinkedList;
    //   158: invokevirtual 208	java/util/LinkedList:peekFirst	()Ljava/lang/Object;
    //   161: checkcast 210	com/tencent/mm/plugin/appbrand/page/q
    //   164: astore 5
    //   166: aload_0
    //   167: getfield 192	com/tencent/mm/plugin/appbrand/page/t:iGV	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   170: ifnull +92 -> 262
    //   173: aload_0
    //   174: getfield 192	com/tencent/mm/plugin/appbrand/page/t:iGV	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   177: invokevirtual 966	com/tencent/mm/plugin/appbrand/AppBrandRuntime:aLY	()Z
    //   180: ifeq +94 -> 274
    //   183: aload_0
    //   184: getfield 192	com/tencent/mm/plugin/appbrand/page/t:iGV	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   187: getfield 969	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mInitialized	Z
    //   190: ifne +84 -> 274
    //   193: iload_2
    //   194: istore_1
    //   195: aload 5
    //   197: ifnonnull +65 -> 262
    //   200: iload_1
    //   201: ifne +61 -> 262
    //   204: ldc 177
    //   206: ldc_w 971
    //   209: iconst_4
    //   210: anewarray 181	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: aload_0
    //   216: invokevirtual 614	com/tencent/mm/plugin/appbrand/page/t:getAppId	()Ljava/lang/String;
    //   219: aastore
    //   220: dup
    //   221: iconst_1
    //   222: aload_0
    //   223: getfield 163	com/tencent/mm/plugin/appbrand/page/t:kZj	Ljava/util/LinkedList;
    //   226: invokevirtual 222	java/util/LinkedList:size	()I
    //   229: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   232: aastore
    //   233: dup
    //   234: iconst_2
    //   235: aload_0
    //   236: getfield 161	com/tencent/mm/plugin/appbrand/page/t:kZi	Ljava/util/LinkedList;
    //   239: invokevirtual 222	java/util/LinkedList:size	()I
    //   242: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   245: aastore
    //   246: dup
    //   247: iconst_3
    //   248: new 574	java/lang/Throwable
    //   251: dup
    //   252: invokespecial 575	java/lang/Throwable:<init>	()V
    //   255: invokestatic 977	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   258: aastore
    //   259: invokestatic 472	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   262: aload 4
    //   264: monitorexit
    //   265: ldc_w 960
    //   268: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   271: aload 5
    //   273: areturn
    //   274: iconst_0
    //   275: istore_1
    //   276: goto -81 -> 195
    //   279: astore 5
    //   281: aload_0
    //   282: getfield 192	com/tencent/mm/plugin/appbrand/page/t:iGV	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   285: ifnull +91 -> 376
    //   288: aload_0
    //   289: getfield 192	com/tencent/mm/plugin/appbrand/page/t:iGV	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   292: invokevirtual 966	com/tencent/mm/plugin/appbrand/AppBrandRuntime:aLY	()Z
    //   295: ifeq +104 -> 399
    //   298: aload_0
    //   299: getfield 192	com/tencent/mm/plugin/appbrand/page/t:iGV	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   302: getfield 969	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mInitialized	Z
    //   305: ifne +94 -> 399
    //   308: iload_3
    //   309: istore_1
    //   310: iconst_0
    //   311: ifne +65 -> 376
    //   314: iload_1
    //   315: ifne +61 -> 376
    //   318: ldc 177
    //   320: ldc_w 971
    //   323: iconst_4
    //   324: anewarray 181	java/lang/Object
    //   327: dup
    //   328: iconst_0
    //   329: aload_0
    //   330: invokevirtual 614	com/tencent/mm/plugin/appbrand/page/t:getAppId	()Ljava/lang/String;
    //   333: aastore
    //   334: dup
    //   335: iconst_1
    //   336: aload_0
    //   337: getfield 163	com/tencent/mm/plugin/appbrand/page/t:kZj	Ljava/util/LinkedList;
    //   340: invokevirtual 222	java/util/LinkedList:size	()I
    //   343: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   346: aastore
    //   347: dup
    //   348: iconst_2
    //   349: aload_0
    //   350: getfield 161	com/tencent/mm/plugin/appbrand/page/t:kZi	Ljava/util/LinkedList;
    //   353: invokevirtual 222	java/util/LinkedList:size	()I
    //   356: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   359: aastore
    //   360: dup
    //   361: iconst_3
    //   362: new 574	java/lang/Throwable
    //   365: dup
    //   366: invokespecial 575	java/lang/Throwable:<init>	()V
    //   369: invokestatic 977	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   372: aastore
    //   373: invokestatic 472	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   376: ldc_w 960
    //   379: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   382: aload 5
    //   384: athrow
    //   385: astore 5
    //   387: aload 4
    //   389: monitorexit
    //   390: ldc_w 960
    //   393: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public bx getDecorWidgetFactory()
  {
    return this.kPL;
  }
  
  public final int getPageCount()
  {
    AppMethodBeat.i(135053);
    synchronized (this.kZh)
    {
      int i = this.kZi.size();
      int j = this.kZj.size();
      AppMethodBeat.o(135053);
      return i + j;
    }
  }
  
  public final aa getPageView()
  {
    AppMethodBeat.i(135084);
    if (this.mDestroyed)
    {
      AppMethodBeat.o(135084);
      return null;
    }
    boolean bool = this.iGV.iDV;
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
  
  aa getPreloadedPageView()
  {
    return this.kZl;
  }
  
  public AppBrandRuntime getRuntime()
  {
    return this.iGV;
  }
  
  public final q j(q paramq)
  {
    AppMethodBeat.i(135079);
    synchronized (this.kZh)
    {
      if (this.kZj.indexOf(paramq) >= 0)
      {
        paramq = (q)this.kZi.peekFirst();
        AppMethodBeat.o(135079);
        return paramq;
      }
      int i = this.kZi.indexOf(paramq);
      if (i >= this.kZi.size() - 1)
      {
        AppMethodBeat.o(135079);
        return null;
      }
      paramq = (q)this.kZi.get(i + 1);
      AppMethodBeat.o(135079);
      return paramq;
    }
  }
  
  final int k(q paramq)
  {
    AppMethodBeat.i(176597);
    synchronized (this.kZh)
    {
      int i = this.kZi.indexOf(paramq);
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
    synchronized (this.kZh)
    {
      int i;
      if (!this.kZj.isEmpty())
      {
        i = 1;
        if ((i != 0) || (localq.getTag(kZb) != null))
        {
          ad.w("MicroMsg.AppBrandPageContainer", "onBackPressed, has navigating pages, skip");
          AppMethodBeat.o(135096);
        }
      }
      else
      {
        i = 0;
      }
    }
    Lz("scene_back_key_pressed");
    AppMethodBeat.o(135096);
  }
  
  public void onBackground()
  {
    AppMethodBeat.i(135088);
    synchronized (this.kZh)
    {
      q localq = (q)this.kZi.peekFirst();
      if (localq == null)
      {
        AppMethodBeat.o(135088);
        return;
      }
    }
    localObject.bjl();
    AppMethodBeat.o(135088);
  }
  
  protected void onDestroy() {}
  
  public void onForeground()
  {
    AppMethodBeat.i(135087);
    synchronized (this.kZh)
    {
      q localq = (q)this.kZi.peekFirst();
      if (localq == null)
      {
        AppMethodBeat.o(135087);
        return;
      }
    }
    localObject.bjk();
    if (this.kZc)
    {
      ad.d("MicroMsg.AppBrandPageContainer", "onForeground, call onUserVisible, appId[%s] url[%s]", new Object[] { getAppId(), localObject.getCurrentPageView().jzm });
      localObject.getCurrentPageView().bjL();
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
    if (this.iGV == null)
    {
      ad.w("MicroMsg.AppBrandPageContainer", "runOnUiThread but mRuntime==NULL, appId:%s, stack:%s", new Object[] { getAppId(), Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(135052);
      return;
    }
    this.iGV.i(paramRunnable, 0L);
    AppMethodBeat.o(135052);
  }
  
  public void setActuallyVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(135051);
    if (this.kZc != paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.kZc = paramBoolean;
      if ((paramBoolean) && (i != 0))
      {
        getCurrentPage().getCurrentPageView().bjL();
        super.setVisibility(0);
        if (this.kZd) {
          bjs();
        }
      }
      if ((!paramBoolean) && (i != 0)) {
        super.setVisibility(4);
      }
      AppMethodBeat.o(135051);
      return;
    }
  }
  
  public void setDecorWidgetFactory(bx parambx)
  {
    AppMethodBeat.i(135049);
    if (parambx == null)
    {
      parambx = new NullPointerException("Should not be null");
      AppMethodBeat.o(135049);
      throw parambx;
    }
    this.kPL = parambx;
    AppMethodBeat.o(135049);
  }
  
  public final void setDelegate(a parama)
  {
    AppMethodBeat.i(135050);
    if (this.kZe != null)
    {
      parama = new IllegalAccessError("Duplicated call!!!");
      AppMethodBeat.o(135050);
      throw parama;
    }
    a locala = parama;
    if (this.kZf != null) {
      locala = this.kZf.a(parama);
    }
    this.kZe = locala;
    AppMethodBeat.o(135050);
  }
  
  public void setDelegateWrapperFactory(b paramb)
  {
    AppMethodBeat.i(176584);
    this.kZf = paramb;
    if (this.kZe != null) {
      this.kZe = paramb.a(this.kZe);
    }
    AppMethodBeat.o(176584);
  }
  
  public final void setNavigateInterceptor(com.tencent.mm.plugin.appbrand.page.c.d paramd)
  {
    AppMethodBeat.i(176585);
    if (paramd == null)
    {
      paramd = new NullPointerException("Should not be null");
      AppMethodBeat.o(176585);
      throw paramd;
    }
    this.kZg = paramd;
    AppMethodBeat.o(176585);
  }
  
  public void setOnPageSwitchListener(e parame)
  {
    AppMethodBeat.i(176601);
    ad.d("MicroMsg.AppBrandPageContainer", "setOnPageSwitchListener, onPageSwitchListener: ".concat(String.valueOf(parame)));
    this.kZr = parame;
    AppMethodBeat.o(176601);
  }
  
  public void setOnReadyListener(t.f paramf)
  {
    this.kZn = paramf;
  }
  
  public void setPipPageLifeCycleListener(i parami)
  {
    this.kZo = parami;
  }
  
  public static abstract interface a
  {
    public abstract boolean Cu();
    
    public abstract aa a(t paramt);
    
    public abstract q a(String paramString, by paramby, t paramt, Callable<q> paramCallable);
    
    public abstract boolean a(String paramString, by paramby, t paramt, t.d paramd);
  }
  
  public static abstract interface b
  {
    public abstract t.a a(t.a parama);
  }
  
  static abstract interface c
    extends Runnable
  {
    public abstract void gy(boolean paramBoolean);
  }
  
  public static abstract interface d
  {
    public abstract void bju();
    
    public abstract void cancel();
    
    public abstract void proceed();
  }
  
  public static abstract interface e
  {
    public abstract void az(float paramFloat);
    
    public abstract t.h b(by paramby, q paramq1, q paramq2);
    
    public abstract void c(by paramby, q paramq1, q paramq2);
    
    public abstract void d(by paramby, q paramq1, q paramq2);
  }
  
  public static abstract interface i
  {
    public abstract void q(q paramq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.t
 * JD-Core Version:    0.7.0.1
 */