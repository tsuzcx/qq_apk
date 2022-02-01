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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.a.g;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.f.f;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Callable;
import junit.framework.Assert;

@SuppressLint({"ViewConstructor"})
public class u
  extends FrameLayout
{
  static final int lAL = 2131296777;
  private AppBrandRuntime jgY;
  private boolean lAM;
  private boolean lAN;
  private a lAO;
  private b lAP;
  private com.tencent.mm.plugin.appbrand.page.c.d<AppBrandRuntime> lAQ;
  private final byte[] lAR;
  private final LinkedList<r> lAS;
  private final LinkedList<r> lAT;
  private final LinkedList<c> lAU;
  private aa lAV;
  private boolean lAW;
  private f lAX;
  private i lAY;
  h lAZ;
  boolean lBa;
  e lBb;
  private bs lrk;
  private String mAppId;
  private volatile boolean mDestroyed;
  
  public u(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramContext);
    AppMethodBeat.i(135048);
    this.mDestroyed = false;
    this.lAM = false;
    this.lAN = false;
    this.lAQ = com.tencent.mm.plugin.appbrand.page.c.a.lGH;
    this.lAR = new byte[0];
    this.lAS = new LinkedList();
    this.lAT = new LinkedList();
    this.lAU = new LinkedList();
    this.lAW = true;
    this.lAY = null;
    this.lAZ = null;
    this.lBa = false;
    this.lBb = null;
    ac.i("MicroMsg.AppBrandPageContainer", "AppBrandPageContainerProfile| <init> appId[%s]", new Object[] { paramAppBrandRuntime.mAppId });
    this.jgY = paramAppBrandRuntime;
    this.mAppId = paramAppBrandRuntime.mAppId;
    this.lrk = new bs.a();
    AppMethodBeat.o(135048);
  }
  
  private r PI(String paramString)
  {
    AppMethodBeat.i(135074);
    synchronized (this.lAR)
    {
      r localr = (r)this.lAS.peekFirst();
      if (((localr instanceof k)) && (localr.cb(paramString)))
      {
        AppMethodBeat.o(135074);
        return localr;
      }
      AppMethodBeat.o(135074);
      return null;
    }
  }
  
  private r PJ(String paramString)
  {
    AppMethodBeat.i(135075);
    synchronized (this.lAR)
    {
      if (this.lAS.size() < 2)
      {
        AppMethodBeat.o(135075);
        return null;
      }
      ListIterator localListIterator = this.lAS.listIterator(1);
      while (localListIterator.hasNext())
      {
        r localr = (r)localListIterator.next();
        if (((localr instanceof k)) && (localr.cb(paramString)))
        {
          AppMethodBeat.o(135075);
          return localr;
        }
      }
      AppMethodBeat.o(135075);
      return null;
    }
  }
  
  private r a(String paramString, bt parambt)
  {
    AppMethodBeat.i(135065);
    if (b(paramString, parambt))
    {
      paramString = new k(getContext(), this);
      AppMethodBeat.o(135065);
      return paramString;
    }
    paramString = new ai(getContext(), this);
    AppMethodBeat.o(135065);
    return paramString;
  }
  
  private Object a(final r paramr, Object paramObject, final Runnable paramRunnable)
  {
    AppMethodBeat.i(176598);
    Object localObject;
    if ((paramObject instanceof Animator))
    {
      localObject = (Animator)paramObject;
      p(paramr);
      paramr.setTag(lAL, localObject);
      ((Animator)localObject).addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(176572);
          paramr.setTag(u.lAL, null);
          if (paramRunnable != null)
          {
            u.this.removeCallbacks(paramRunnable);
            if (!u.i(u.this)) {
              paramRunnable.run();
            }
          }
          AppMethodBeat.o(176572);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(176573);
          paramr.setTag(u.lAL, null);
          if (paramRunnable != null) {
            u.this.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(176571);
                if (!u.i(u.this)) {
                  u.16.this.val$runnable.run();
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
                  if (!u.i(u.this)) {
                    u.17.this.val$runnable.run();
                  }
                  u.17.this.lBe.setTag(u.lAL, null);
                  AppMethodBeat.o(176574);
                }
              };
              if (paramAnonymousAnimation.getStartTime() == -9223372036854775808L)
              {
                local1.run();
                AppMethodBeat.o(176575);
                return;
              }
              if (!u.i(u.this)) {
                u.this.post(local1);
              }
              AppMethodBeat.o(176575);
              return;
            }
            paramr.setTag(u.lAL, null);
            AppMethodBeat.o(176575);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
        p(paramr);
        paramr.setTag(lAL, localObject);
        paramr.startAnimation((Animation)localObject);
      }
      else
      {
        if (paramObject != null) {
          break;
        }
        paramRunnable.run();
      }
    }
    paramr = new IllegalArgumentException("Page animation should be Animator or Animation");
    AppMethodBeat.o(176598);
    throw paramr;
  }
  
  private Object a(final r paramr, boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(176595);
    if (paramr == null)
    {
      AppMethodBeat.o(176595);
      return null;
    }
    if (paramBoolean2) {}
    synchronized (this.lAR)
    {
      this.lAS.remove(paramr);
      this.lAT.remove(paramr);
      paramr.bqd();
      ??? = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135033);
          if (paramBoolean2) {
            u.a(u.this, paramr);
          }
          AppMethodBeat.o(135033);
        }
      };
      if (paramBoolean1)
      {
        paramr = a(paramr, m(paramr), (Runnable)???);
        AppMethodBeat.o(176595);
        return paramr;
      }
    }
    p(paramr);
    ((Runnable)???).run();
    AppMethodBeat.o(176595);
    return null;
  }
  
  private void a(bt parambt, r paramr1, r paramr2)
  {
    AppMethodBeat.i(176600);
    if (this.lBb == null)
    {
      AppMethodBeat.o(176600);
      return;
    }
    if (!this.lBa)
    {
      this.lAZ = this.lBb.b(parambt, paramr1, paramr2);
      this.lBa = true;
    }
    this.lBb.c(parambt, paramr1, paramr2);
    this.lBa = false;
    AppMethodBeat.o(176600);
  }
  
  private void a(final bt parambt, final r paramr1, final r paramr2, final u.g paramg)
  {
    AppMethodBeat.i(176599);
    ac.d("MicroMsg.AppBrandPageContainer", "processPageSwitchResult, pageSwitchResult: ".concat(String.valueOf(paramg)));
    if (this.lBb == null)
    {
      ac.d("MicroMsg.AppBrandPageContainer", "processPageSwitchResult, null == mOnPageSwitchListener");
      AppMethodBeat.o(176599);
      return;
    }
    paramg = paramg.lBB;
    if ((paramg instanceof ValueAnimator))
    {
      paramg = (ValueAnimator)paramg;
      paramg.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(176577);
          super.onAnimationCancel(paramAnonymousAnimator);
          u.j(u.this).d(parambt, paramr1, paramr2);
          u.k(u.this);
          AppMethodBeat.o(176577);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(176576);
          super.onAnimationEnd(paramAnonymousAnimator);
          u.a(u.this, parambt, paramr1, paramr2);
          AppMethodBeat.o(176576);
        }
      });
      paramg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(176578);
          int i = (int)(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * 100.0F);
          u.j(u.this).aD(i);
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
      parambt = new Choreographer.FrameCallback()
      {
        public final void doFrame(long paramAnonymousLong)
        {
          AppMethodBeat.i(176579);
          float f = ((float)(SystemClock.elapsedRealtime() - this.lBu) + 0.0F) / (float)parambt;
          if (1.0F <= f)
          {
            u.a(u.this, paramr2, paramg, this.lBt);
            AppMethodBeat.o(176579);
            return;
          }
          int i = (int)(this.lBv.getInterpolator().getInterpolation(f) * 100.0F);
          u.j(u.this).aD(i);
          Choreographer.getInstance().postFrameCallback(this);
          AppMethodBeat.o(176579);
        }
      };
      Choreographer.getInstance().postFrameCallback(parambt);
      AppMethodBeat.o(176599);
      return;
    }
    a(parambt, paramr1, paramr2);
    AppMethodBeat.o(176599);
  }
  
  private void a(final r paramr1, final r paramr2, bt parambt, h paramh)
  {
    Object localObject2 = null;
    AppMethodBeat.i(176594);
    for (;;)
    {
      synchronized (this.lAR)
      {
        this.lAS.remove(paramr2);
        this.lAT.remove(paramr2);
        if (!paramr2.mSwiping)
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
              u.a(u.this, paramr2);
              AppMethodBeat.o(135031);
            }
          };
          ??? = a(paramr2, o(paramr2), (Runnable)???);
          ac.i("MicroMsg.AppBrandPageContainer", "switchPageClear, in: %s out: %s", new Object[] { paramr1.getCurrentUrl(), paramr2.getCurrentUrl() });
          ac.d("MicroMsg.AppBrandPageContainer", "switchPageClear, dispatchRoute, type: %s, pipMode: %s", new Object[] { parambt, paramh });
          paramr1.a(parambt, paramh);
          paramr1.bqc();
          if (i == 0) {
            break label221;
          }
          paramh = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(135032);
              paramr1.bqe();
              AppMethodBeat.o(135032);
            }
          };
          paramh = a(paramr1, n(paramr1), paramh);
          a(parambt, paramr2, paramr1, new u.g(paramh, ???));
          AppMethodBeat.o(176594);
          return;
        }
      }
      int i = 0;
      continue;
      label210:
      i(paramr2);
      ??? = null;
      continue;
      label221:
      paramr1.bqe();
      paramh = localObject2;
    }
  }
  
  private Object b(final r paramr, boolean paramBoolean)
  {
    AppMethodBeat.i(176596);
    if (paramr == null)
    {
      AppMethodBeat.o(176596);
      return null;
    }
    synchronized (this.lAR)
    {
      this.lAS.remove(paramr);
      this.lAS.push(paramr);
      this.lAT.remove(paramr);
      paramr.bringToFront();
      requestLayout();
      invalidate();
      paramr.bqc();
      ??? = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135035);
          u.this.bqk();
          paramr.bqe();
          AppMethodBeat.o(135035);
        }
      };
      if (paramBoolean)
      {
        paramr = a(paramr, l(paramr), (Runnable)???);
        AppMethodBeat.o(176596);
        return paramr;
      }
    }
    p(paramr);
    ((Runnable)???).run();
    AppMethodBeat.o(176596);
    return null;
  }
  
  private void b(r paramr1, r paramr2)
  {
    AppMethodBeat.i(135071);
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.lAR)
    {
      Iterator localIterator = this.lAS.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        r localr = (r)localIterator.next();
        if (localr == paramr1) {
          i = 1;
        } else if (localr != paramr2) {
          if (i != 0)
          {
            localLinkedList.add(localr);
            localIterator.remove();
            this.lAT.remove(localr);
          }
        }
      }
    }
    paramr1 = localLinkedList.iterator();
    while (paramr1.hasNext())
    {
      paramr2 = (r)paramr1.next();
      p(paramr2);
      i(paramr2);
    }
    AppMethodBeat.o(135071);
  }
  
  private static boolean b(bt parambt)
  {
    return (parambt == bt.lGl) || (parambt == bt.lGm) || (parambt == bt.lGp) || (parambt == bt.lGn) || (parambt == bt.lGo);
  }
  
  private boolean b(String paramString, bt parambt)
  {
    AppMethodBeat.i(135069);
    if (parambt == bt.lGp)
    {
      AppMethodBeat.o(135069);
      return true;
    }
    if ((parambt == bt.lGn) || (parambt == bt.lGo))
    {
      boolean bool = this.jgY.getAppConfig().bal().JP(paramString);
      AppMethodBeat.o(135069);
      return bool;
    }
    for (;;)
    {
      synchronized (this.lAR)
      {
        if (parambt == bt.lGl) {
          break label169;
        }
        if (parambt == bt.lGm)
        {
          break label169;
          int j = this.lAS.size();
          if (i != 0)
          {
            i = 1;
            if ((!this.jgY.getAppConfig().bal().JP(paramString)) || (j + 1 - i != 1)) {
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
  
  private void bqh()
  {
    AppMethodBeat.i(176593);
    synchronized (this.lAR)
    {
      Object localObject2 = new LinkedList(this.lAU);
      this.lAU.clear();
      ??? = ((LinkedList)localObject2).descendingIterator();
      if (((Iterator)???).hasNext())
      {
        localObject2 = (c)((Iterator)???).next();
        ((c)localObject2).gV(true);
        ((c)localObject2).run();
        ((Iterator)???).remove();
      }
    }
    AppMethodBeat.o(176593);
  }
  
  private aa bqj()
  {
    AppMethodBeat.i(135083);
    if (this.lAO != null)
    {
      aa localaa = this.lAO.a(this);
      if (localaa != null)
      {
        AppMethodBeat.o(135083);
        return localaa;
      }
    }
    AppMethodBeat.o(135083);
    return null;
  }
  
  private static boolean c(bt parambt)
  {
    AppMethodBeat.i(135068);
    boolean bool = com.tencent.mm.compatible.loader.a.contains(new bt[] { bt.lGp, bt.lGn, bt.lGo }, parambt);
    AppMethodBeat.o(135068);
    return bool;
  }
  
  private void i(r paramr)
  {
    AppMethodBeat.i(135076);
    if (this.lAY != null) {
      this.lAY.q(paramr);
    }
    paramr.setVisibility(8);
    paramr.bqd();
    if (!paramr.lAE) {
      paramr.performDestroy();
    }
    removeView(paramr);
    if (!paramr.lAE) {
      paramr.CR();
    }
    AppMethodBeat.o(135076);
  }
  
  private static void p(r paramr)
  {
    AppMethodBeat.i(135094);
    paramr.clearAnimation();
    paramr = paramr.getTag(lAL);
    if ((paramr instanceof Animator))
    {
      paramr = (Animator)paramr;
      paramr.cancel();
      paramr.removeAllListeners();
      AppMethodBeat.o(135094);
      return;
    }
    if ((paramr instanceof Animation))
    {
      paramr = (Animation)paramr;
      paramr.setAnimationListener(null);
      paramr.cancel();
    }
    AppMethodBeat.o(135094);
  }
  
  public void OE(final String paramString)
  {
    AppMethodBeat.i(135055);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135034);
        u.a(u.this, paramString, bt.lGi);
        AppMethodBeat.o(135034);
      }
    });
    AppMethodBeat.o(135055);
  }
  
  public final void PD(final String paramString)
  {
    AppMethodBeat.i(135056);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135041);
        u.a(u.this, paramString, bt.lGj);
        AppMethodBeat.o(135041);
      }
    });
    AppMethodBeat.o(135056);
  }
  
  public final void PE(final String paramString)
  {
    AppMethodBeat.i(135058);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135043);
        u.a(u.this, paramString, bt.lGl);
        AppMethodBeat.o(135043);
      }
    });
    AppMethodBeat.o(135058);
  }
  
  public final boolean PF(String paramString)
  {
    AppMethodBeat.i(193413);
    aa localaa;
    if (getCurrentPage() != null)
    {
      localaa = getCurrentPage().getCurrentPageView();
      if (localaa != null) {}
    }
    else
    {
      ac.w("MicroMsg.AppBrandPageContainer", "rewriteRoute invalid page appId:%s, url:%s", new Object[] { getAppId(), paramString });
      AppMethodBeat.o(193413);
      return false;
    }
    boolean bool = localaa.PF(paramString);
    AppMethodBeat.o(193413);
    return bool;
  }
  
  public final void PG(final String paramString)
  {
    AppMethodBeat.i(135059);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135044);
        u.a(u.this, paramString, bt.lGp);
        AppMethodBeat.o(135044);
      }
    });
    AppMethodBeat.o(135059);
  }
  
  public final void PH(final String paramString)
  {
    AppMethodBeat.i(176587);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135046);
        u.this.an(1, paramString);
        AppMethodBeat.o(135046);
      }
    });
    AppMethodBeat.o(176587);
  }
  
  protected h a(r paramr1, r paramr2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(176591);
    String str = getAppId();
    Object localObject1;
    if (paramr1 == null)
    {
      localObject1 = null;
      if (paramr2 != null) {
        break label148;
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.AppBrandPageContainer", "onNavigateBack, appId[%s] out[%s], in[%s], mActuallyVisible[%b]", new Object[] { str, localObject1, localObject2, Boolean.valueOf(this.lAM) });
      if (this.lAM) {
        paramr2.getCurrentPageView().bqC();
      }
      if (paramr1 != null) {
        paramr1.hideVKB();
      }
      localObject2 = this.lAZ;
      localObject1 = localObject2;
      if (this.lBb != null)
      {
        localObject1 = localObject2;
        if (!this.lBa)
        {
          localObject1 = this.lBb.b(bt.lGk, paramr1, paramr2);
          this.lBa = true;
        }
      }
      AppMethodBeat.o(176591);
      return localObject1;
      localObject1 = com.tencent.luggage.h.k.cp(paramr1.getCurrentUrl());
      break;
      label148:
      localObject2 = com.tencent.luggage.h.k.cp(paramr2.getCurrentUrl());
    }
  }
  
  public h a(r paramr1, r paramr2, bt parambt, String paramString)
  {
    AppMethodBeat.i(176592);
    String str = getAppId();
    if (paramr1 == null) {}
    for (Object localObject = null;; localObject = com.tencent.luggage.h.k.cp(paramr1.getCurrentUrl()))
    {
      ac.i("MicroMsg.AppBrandPageContainer", "onNavigateStart, appId[%s] out[%s], in[%s], mActuallyVisible[%b], type[%s]", new Object[] { str, localObject, com.tencent.luggage.h.k.cp(paramString), Boolean.valueOf(this.lAM), parambt });
      if (paramr1 != null) {
        paramr1.hideVKB();
      }
      localObject = this.lAZ;
      paramString = (String)localObject;
      if (this.lBb != null)
      {
        paramString = (String)localObject;
        if (!this.lBa)
        {
          paramString = this.lBb.b(parambt, paramr1, paramr2);
          this.lBa = true;
        }
      }
      if ((paramr1 != null) && (paramr1.getCurrentPageView() != null) && (paramr1.getCurrentPageView().getFullscreenImpl() != null) && (paramr1.getCurrentPageView().getFullscreenImpl().bsE())) {
        paramr1.getCurrentPageView().getFullscreenImpl().aUJ();
      }
      AppMethodBeat.o(176592);
      return paramString;
    }
  }
  
  public void a(r paramr1, r paramr2, bt parambt)
  {
    AppMethodBeat.i(135067);
    String str = getAppId();
    if (paramr1 == null) {}
    for (paramr1 = null;; paramr1 = com.tencent.luggage.h.k.cp(paramr1.getCurrentUrl()))
    {
      ac.i("MicroMsg.AppBrandPageContainer", "onNavigateEnd, appId[%s] out[%s], in[%s], mActuallyVisible[%b], type[%s]", new Object[] { str, paramr1, com.tencent.luggage.h.k.cp(paramr2.getCurrentUrl()), Boolean.valueOf(this.lAM), parambt });
      if (this.lAM) {
        paramr2.getCurrentPageView().bqC();
      }
      AppMethodBeat.o(135067);
      return;
    }
  }
  
  public final void a(final r paramr, final String paramString)
  {
    AppMethodBeat.i(176589);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135024);
        int i = u.this.k(paramr);
        if (i < 0)
        {
          ac.w("MicroMsg.AppBrandPageContainer", "navigateBack with appId(%s) Page(%s), but already off stack, maybe frequent clicks were performed", new Object[] { u.this.getAppId(), paramr.getCurrentUrl() });
          AppMethodBeat.o(135024);
          return;
        }
        u.a(u.this, i + 1, paramString);
        AppMethodBeat.o(135024);
      }
    });
    AppMethodBeat.o(176589);
  }
  
  public final void an(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(176588);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135047);
        u.a(u.this, paramInt, paramString);
        AppMethodBeat.o(135047);
      }
    });
    AppMethodBeat.o(176588);
  }
  
  public final void au(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(135057);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135042);
        u localu = u.this;
        String str = paramString;
        if (paramBoolean) {}
        for (bt localbt = bt.lGo;; localbt = bt.lGn)
        {
          u.a(localu, str, localbt);
          AppMethodBeat.o(135042);
          return;
        }
      }
    });
    AppMethodBeat.o(135057);
  }
  
  public final void b(final r paramr, final String paramString)
  {
    AppMethodBeat.i(176590);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176564);
        int i = u.this.k(paramr);
        u.a(u.this, i, paramString);
        AppMethodBeat.o(176564);
      }
    });
    AppMethodBeat.o(176590);
  }
  
  public final Iterator<r> bqf()
  {
    AppMethodBeat.i(135054);
    Iterator local1 = new Iterator()
    {
      final ListIterator<r> lBc;
      
      public final boolean hasNext()
      {
        AppMethodBeat.i(135021);
        boolean bool = this.lBc.hasNext();
        AppMethodBeat.o(135021);
        return bool;
      }
      
      public final void remove()
      {
        AppMethodBeat.i(135022);
        UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(135022);
        throw localUnsupportedOperationException;
      }
    };
    AppMethodBeat.o(135054);
    return local1;
  }
  
  public final void bqg()
  {
    AppMethodBeat.i(135060);
    au(this.jgY.getAppConfig().bam(), true);
    AppMethodBeat.o(135060);
  }
  
  public final aa bqi()
  {
    AppMethodBeat.i(135082);
    if (this.lAV == null)
    {
      localObject2 = bqj();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new aa();
      }
      ((aa)localObject1).lrk = getDecorWidgetFactory();
      ((aa)localObject1).a(getContext(), this.jgY);
      AppMethodBeat.o(135082);
      return localObject1;
    }
    Object localObject1 = this.lAV;
    this.lAV = null;
    Object localObject2 = ((c)localObject1).getContentView();
    if (localObject2 != null) {
      ((View)localObject2).setVisibility(0);
    }
    removeView(((aa)localObject1).jHO);
    AppMethodBeat.o(135082);
    return localObject1;
  }
  
  final void bqk()
  {
    AppMethodBeat.i(135085);
    if (!this.lAM)
    {
      this.lAN = true;
      AppMethodBeat.o(135085);
      return;
    }
    this.lAN = false;
    if ((this.lAO != null) && (this.lAO.BY()))
    {
      AppMethodBeat.o(135085);
      return;
    }
    getRuntime().i(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176570);
        if (u.g(u.this) != null)
        {
          AppMethodBeat.o(176570);
          return;
        }
        long l = System.currentTimeMillis();
        Object localObject2 = u.h(u.this);
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new aa();
        }
        ((aa)localObject1).lrk = u.this.getDecorWidgetFactory();
        ((aa)localObject1).a(u.this.getContext(), u.c(u.this));
        localObject2 = ((c)localObject1).getContentView();
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(4);
        }
        u.this.addView(((aa)localObject1).jHO, 0);
        u.a(u.this, (aa)localObject1);
        ac.i("MicroMsg.AppBrandPageContainer", "preloadNextPageView: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(176570);
      }
    }, 200L);
    AppMethodBeat.o(135085);
  }
  
  protected final void bql()
  {
    AppMethodBeat.i(135089);
    if (this.jgY == null)
    {
      AppMethodBeat.o(135089);
      return;
    }
    if (this.lAW)
    {
      if (this.lAX != null) {
        this.lAX.aTh();
      }
      onReady();
      this.lAW = false;
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
        u.a(u.this, paramString1, paramString2, paramArrayOfInt);
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
    synchronized (this.lAS)
    {
      localLinkedList.addAll(this.lAS);
      localLinkedList.addAll(this.lAT);
      this.lAS.clear();
      this.lAT.clear();
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext())
      {
        r localr = (r)((Iterator)???).next();
        localr.bqd();
        localr.performDestroy();
        localr.CR();
        p(localr);
      }
    }
    localObject1.clear();
    if (this.lAV != null) {}
    try
    {
      this.lAV.onDestroy();
      try
      {
        label136:
        this.lAV.cleanup();
        label143:
        removeAllViews();
        this.lAX = null;
        this.jgY = null;
        this.lAY = null;
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
    synchronized (this.lAR)
    {
      int i = this.lAS.size();
      AppMethodBeat.o(176586);
      return i;
    }
  }
  
  public final com.tencent.mm.plugin.appbrand.config.a getAppConfig()
  {
    AppMethodBeat.i(135086);
    com.tencent.mm.plugin.appbrand.config.a locala = this.jgY.getAppConfig();
    AppMethodBeat.o(135086);
    return locala;
  }
  
  public String getAppId()
  {
    return this.mAppId;
  }
  
  /* Error */
  public r getCurrentPage()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: iconst_1
    //   3: istore_3
    //   4: iconst_1
    //   5: istore_1
    //   6: ldc_w 960
    //   9: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: aload_0
    //   13: getfield 163	com/tencent/mm/plugin/appbrand/page/u:lAR	[B
    //   16: astore 4
    //   18: aload 4
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 171	com/tencent/mm/plugin/appbrand/page/u:lAT	Ljava/util/LinkedList;
    //   25: invokevirtual 963	java/util/LinkedList:isEmpty	()Z
    //   28: ifne +126 -> 154
    //   31: aload_0
    //   32: getfield 171	com/tencent/mm/plugin/appbrand/page/u:lAT	Ljava/util/LinkedList;
    //   35: invokevirtual 539	java/util/LinkedList:getFirst	()Ljava/lang/Object;
    //   38: checkcast 218	com/tencent/mm/plugin/appbrand/page/r
    //   41: astore 5
    //   43: aload_0
    //   44: getfield 200	com/tencent/mm/plugin/appbrand/page/u:jgY	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   47: ifnull +90 -> 137
    //   50: aload_0
    //   51: getfield 200	com/tencent/mm/plugin/appbrand/page/u:jgY	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   54: invokevirtual 966	com/tencent/mm/plugin/appbrand/AppBrandRuntime:aSO	()Z
    //   57: ifeq +92 -> 149
    //   60: aload_0
    //   61: getfield 200	com/tencent/mm/plugin/appbrand/page/u:jgY	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   64: getfield 969	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mInitialized	Z
    //   67: ifne +82 -> 149
    //   70: aload 5
    //   72: ifnonnull +65 -> 137
    //   75: iload_1
    //   76: ifne +61 -> 137
    //   79: ldc 185
    //   81: ldc_w 971
    //   84: iconst_4
    //   85: anewarray 189	java/lang/Object
    //   88: dup
    //   89: iconst_0
    //   90: aload_0
    //   91: invokevirtual 622	com/tencent/mm/plugin/appbrand/page/u:getAppId	()Ljava/lang/String;
    //   94: aastore
    //   95: dup
    //   96: iconst_1
    //   97: aload_0
    //   98: getfield 171	com/tencent/mm/plugin/appbrand/page/u:lAT	Ljava/util/LinkedList;
    //   101: invokevirtual 230	java/util/LinkedList:size	()I
    //   104: invokestatic 561	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: aastore
    //   108: dup
    //   109: iconst_2
    //   110: aload_0
    //   111: getfield 169	com/tencent/mm/plugin/appbrand/page/u:lAS	Ljava/util/LinkedList;
    //   114: invokevirtual 230	java/util/LinkedList:size	()I
    //   117: invokestatic 561	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   120: aastore
    //   121: dup
    //   122: iconst_3
    //   123: new 582	java/lang/Throwable
    //   126: dup
    //   127: invokespecial 583	java/lang/Throwable:<init>	()V
    //   130: invokestatic 977	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   133: aastore
    //   134: invokestatic 480	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: aload 4
    //   139: monitorexit
    //   140: ldc_w 960
    //   143: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aload 5
    //   148: areturn
    //   149: iconst_0
    //   150: istore_1
    //   151: goto -81 -> 70
    //   154: aload_0
    //   155: getfield 169	com/tencent/mm/plugin/appbrand/page/u:lAS	Ljava/util/LinkedList;
    //   158: invokevirtual 216	java/util/LinkedList:peekFirst	()Ljava/lang/Object;
    //   161: checkcast 218	com/tencent/mm/plugin/appbrand/page/r
    //   164: astore 5
    //   166: aload_0
    //   167: getfield 200	com/tencent/mm/plugin/appbrand/page/u:jgY	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   170: ifnull +92 -> 262
    //   173: aload_0
    //   174: getfield 200	com/tencent/mm/plugin/appbrand/page/u:jgY	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   177: invokevirtual 966	com/tencent/mm/plugin/appbrand/AppBrandRuntime:aSO	()Z
    //   180: ifeq +94 -> 274
    //   183: aload_0
    //   184: getfield 200	com/tencent/mm/plugin/appbrand/page/u:jgY	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   187: getfield 969	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mInitialized	Z
    //   190: ifne +84 -> 274
    //   193: iload_2
    //   194: istore_1
    //   195: aload 5
    //   197: ifnonnull +65 -> 262
    //   200: iload_1
    //   201: ifne +61 -> 262
    //   204: ldc 185
    //   206: ldc_w 971
    //   209: iconst_4
    //   210: anewarray 189	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: aload_0
    //   216: invokevirtual 622	com/tencent/mm/plugin/appbrand/page/u:getAppId	()Ljava/lang/String;
    //   219: aastore
    //   220: dup
    //   221: iconst_1
    //   222: aload_0
    //   223: getfield 171	com/tencent/mm/plugin/appbrand/page/u:lAT	Ljava/util/LinkedList;
    //   226: invokevirtual 230	java/util/LinkedList:size	()I
    //   229: invokestatic 561	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   232: aastore
    //   233: dup
    //   234: iconst_2
    //   235: aload_0
    //   236: getfield 169	com/tencent/mm/plugin/appbrand/page/u:lAS	Ljava/util/LinkedList;
    //   239: invokevirtual 230	java/util/LinkedList:size	()I
    //   242: invokestatic 561	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   245: aastore
    //   246: dup
    //   247: iconst_3
    //   248: new 582	java/lang/Throwable
    //   251: dup
    //   252: invokespecial 583	java/lang/Throwable:<init>	()V
    //   255: invokestatic 977	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   258: aastore
    //   259: invokestatic 480	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   262: aload 4
    //   264: monitorexit
    //   265: ldc_w 960
    //   268: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   271: aload 5
    //   273: areturn
    //   274: iconst_0
    //   275: istore_1
    //   276: goto -81 -> 195
    //   279: astore 5
    //   281: aload_0
    //   282: getfield 200	com/tencent/mm/plugin/appbrand/page/u:jgY	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   285: ifnull +91 -> 376
    //   288: aload_0
    //   289: getfield 200	com/tencent/mm/plugin/appbrand/page/u:jgY	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   292: invokevirtual 966	com/tencent/mm/plugin/appbrand/AppBrandRuntime:aSO	()Z
    //   295: ifeq +104 -> 399
    //   298: aload_0
    //   299: getfield 200	com/tencent/mm/plugin/appbrand/page/u:jgY	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   302: getfield 969	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mInitialized	Z
    //   305: ifne +94 -> 399
    //   308: iload_3
    //   309: istore_1
    //   310: iconst_0
    //   311: ifne +65 -> 376
    //   314: iload_1
    //   315: ifne +61 -> 376
    //   318: ldc 185
    //   320: ldc_w 971
    //   323: iconst_4
    //   324: anewarray 189	java/lang/Object
    //   327: dup
    //   328: iconst_0
    //   329: aload_0
    //   330: invokevirtual 622	com/tencent/mm/plugin/appbrand/page/u:getAppId	()Ljava/lang/String;
    //   333: aastore
    //   334: dup
    //   335: iconst_1
    //   336: aload_0
    //   337: getfield 171	com/tencent/mm/plugin/appbrand/page/u:lAT	Ljava/util/LinkedList;
    //   340: invokevirtual 230	java/util/LinkedList:size	()I
    //   343: invokestatic 561	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   346: aastore
    //   347: dup
    //   348: iconst_2
    //   349: aload_0
    //   350: getfield 169	com/tencent/mm/plugin/appbrand/page/u:lAS	Ljava/util/LinkedList;
    //   353: invokevirtual 230	java/util/LinkedList:size	()I
    //   356: invokestatic 561	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   359: aastore
    //   360: dup
    //   361: iconst_3
    //   362: new 582	java/lang/Throwable
    //   365: dup
    //   366: invokespecial 583	java/lang/Throwable:<init>	()V
    //   369: invokestatic 977	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   372: aastore
    //   373: invokestatic 480	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   376: ldc_w 960
    //   379: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   382: aload 5
    //   384: athrow
    //   385: astore 5
    //   387: aload 4
    //   389: monitorexit
    //   390: ldc_w 960
    //   393: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   396: aload 5
    //   398: athrow
    //   399: iconst_0
    //   400: istore_1
    //   401: goto -91 -> 310
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	404	0	this	u
    //   5	396	1	i	int
    //   1	193	2	j	int
    //   3	306	3	k	int
    //   16	372	4	arrayOfByte	byte[]
    //   41	231	5	localr	r
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
      localObject = ((r)localObject).getCurrentUrl();
      AppMethodBeat.o(135080);
      return localObject;
    }
    AppMethodBeat.o(135080);
    return null;
  }
  
  public bs getDecorWidgetFactory()
  {
    return this.lrk;
  }
  
  public final int getPageCount()
  {
    AppMethodBeat.i(135053);
    synchronized (this.lAR)
    {
      int i = this.lAS.size();
      int j = this.lAT.size();
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
    boolean bool = this.jgY.jdX;
    Object localObject = getCurrentPage();
    if (localObject == null)
    {
      if (bool) {
        Assert.fail("getPageView() assert by NULL page, appId=" + getAppId());
      }
      AppMethodBeat.o(135084);
      return null;
    }
    localObject = ((r)localObject).getCurrentPageView();
    if ((localObject == null) && (bool)) {
      Assert.fail("getPageView() assert by NULL pv, appId=" + getAppId());
    }
    AppMethodBeat.o(135084);
    return localObject;
  }
  
  aa getPreloadedPageView()
  {
    return this.lAV;
  }
  
  public AppBrandRuntime getRuntime()
  {
    return this.jgY;
  }
  
  public final r j(r paramr)
  {
    AppMethodBeat.i(135079);
    synchronized (this.lAR)
    {
      if (this.lAT.indexOf(paramr) >= 0)
      {
        paramr = (r)this.lAS.peekFirst();
        AppMethodBeat.o(135079);
        return paramr;
      }
      int i = this.lAS.indexOf(paramr);
      if (i >= this.lAS.size() - 1)
      {
        AppMethodBeat.o(135079);
        return null;
      }
      paramr = (r)this.lAS.get(i + 1);
      AppMethodBeat.o(135079);
      return paramr;
    }
  }
  
  final int k(r paramr)
  {
    AppMethodBeat.i(176597);
    synchronized (this.lAR)
    {
      int i = this.lAS.indexOf(paramr);
      AppMethodBeat.o(176597);
      return i;
    }
  }
  
  public Object l(r paramr)
  {
    AppMethodBeat.i(135090);
    paramr = ObjectAnimator.ofFloat(paramr, "translationX", new float[] { paramr.getWidth(), 0.0F });
    paramr.setDuration(250L);
    AppMethodBeat.o(135090);
    return paramr;
  }
  
  public Object m(r paramr)
  {
    AppMethodBeat.i(135091);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramr, "translationX", new float[] { 0.0F, -(paramr.getWidth() * 0.25F) });
    localObjectAnimator.setDuration(250L);
    paramr = ObjectAnimator.ofFloat(paramr, "translationX", new float[] { 0.0F });
    paramr.setDuration(0L);
    new AnimatorSet().playSequentially(new Animator[] { localObjectAnimator, paramr });
    AppMethodBeat.o(135091);
    return localObjectAnimator;
  }
  
  public Object n(r paramr)
  {
    AppMethodBeat.i(135092);
    paramr = ObjectAnimator.ofFloat(paramr, "translationX", new float[] { -(paramr.getWidth() * 0.25F), 0.0F });
    paramr.setDuration(250L);
    AppMethodBeat.o(135092);
    return paramr;
  }
  
  public Object o(r paramr)
  {
    AppMethodBeat.i(135093);
    paramr = ObjectAnimator.ofFloat(paramr, "translationX", new float[] { 0.0F, paramr.getWidth() });
    paramr.setDuration(250L);
    AppMethodBeat.o(135093);
    return paramr;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(135096);
    r localr = getCurrentPage();
    if (localr == null)
    {
      AppMethodBeat.o(135096);
      return;
    }
    if (localr.getCurrentPageView().onBackPressed())
    {
      AppMethodBeat.o(135096);
      return;
    }
    synchronized (this.lAR)
    {
      int i;
      if (!this.lAT.isEmpty())
      {
        i = 1;
        if ((i != 0) || (localr.getTag(lAL) != null))
        {
          ac.w("MicroMsg.AppBrandPageContainer", "onBackPressed, has navigating pages, skip");
          AppMethodBeat.o(135096);
        }
      }
      else
      {
        i = 0;
      }
    }
    PH("scene_back_key_pressed");
    AppMethodBeat.o(135096);
  }
  
  public void onBackground()
  {
    AppMethodBeat.i(135088);
    synchronized (this.lAR)
    {
      r localr = (r)this.lAS.peekFirst();
      if (localr == null)
      {
        AppMethodBeat.o(135088);
        return;
      }
    }
    localObject.bqd();
    AppMethodBeat.o(135088);
  }
  
  protected void onDestroy() {}
  
  public void onForeground()
  {
    AppMethodBeat.i(135087);
    synchronized (this.lAR)
    {
      r localr = (r)this.lAS.peekFirst();
      if (localr == null)
      {
        AppMethodBeat.o(135087);
        return;
      }
    }
    localObject.bqc();
    if (this.lAM)
    {
      ac.d("MicroMsg.AppBrandPageContainer", "onForeground, call onUserVisible, appId[%s] url[%s]", new Object[] { getAppId(), localObject.getCurrentPageView().jZJ });
      localObject.getCurrentPageView().bqC();
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
    if (this.jgY == null)
    {
      ac.w("MicroMsg.AppBrandPageContainer", "runOnUiThread but mRuntime==NULL, appId:%s, stack:%s", new Object[] { getAppId(), Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(135052);
      return;
    }
    this.jgY.i(paramRunnable, 0L);
    AppMethodBeat.o(135052);
  }
  
  public void setActuallyVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(135051);
    if (this.lAM != paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.lAM = paramBoolean;
      if ((paramBoolean) && (i != 0))
      {
        getCurrentPage().getCurrentPageView().bqC();
        super.setVisibility(0);
        if (this.lAN) {
          bqk();
        }
      }
      if ((!paramBoolean) && (i != 0)) {
        super.setVisibility(4);
      }
      AppMethodBeat.o(135051);
      return;
    }
  }
  
  public void setDecorWidgetFactory(bs parambs)
  {
    AppMethodBeat.i(135049);
    if (parambs == null)
    {
      parambs = new NullPointerException("Should not be null");
      AppMethodBeat.o(135049);
      throw parambs;
    }
    this.lrk = parambs;
    AppMethodBeat.o(135049);
  }
  
  public final void setDelegate(a parama)
  {
    AppMethodBeat.i(135050);
    if (this.lAO != null)
    {
      parama = new IllegalAccessError("Duplicated call!!!");
      AppMethodBeat.o(135050);
      throw parama;
    }
    a locala = parama;
    if (this.lAP != null) {
      locala = this.lAP.a(parama);
    }
    this.lAO = locala;
    AppMethodBeat.o(135050);
  }
  
  public void setDelegateWrapperFactory(b paramb)
  {
    AppMethodBeat.i(176584);
    this.lAP = paramb;
    if (this.lAO != null) {
      this.lAO = paramb.a(this.lAO);
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
    this.lAQ = paramd;
    AppMethodBeat.o(176585);
  }
  
  public void setOnPageSwitchListener(e parame)
  {
    AppMethodBeat.i(176601);
    ac.d("MicroMsg.AppBrandPageContainer", "setOnPageSwitchListener, onPageSwitchListener: ".concat(String.valueOf(parame)));
    this.lBb = parame;
    AppMethodBeat.o(176601);
  }
  
  public void setOnReadyListener(f paramf)
  {
    this.lAX = paramf;
  }
  
  public void setPipPageLifeCycleListener(i parami)
  {
    this.lAY = parami;
  }
  
  public static abstract interface a
  {
    public abstract boolean BY();
    
    public abstract aa a(u paramu);
    
    public abstract r a(String paramString, bt parambt, u paramu, Callable<r> paramCallable);
    
    public abstract boolean a(String paramString, bt parambt, u paramu, u.d paramd);
  }
  
  public static abstract interface b
  {
    public abstract u.a a(u.a parama);
  }
  
  static abstract interface c
    extends Runnable
  {
    public abstract void gV(boolean paramBoolean);
  }
  
  public static abstract interface d
  {
    public abstract void bqm();
    
    public abstract void cancel();
    
    public abstract void proceed();
  }
  
  public static abstract interface e
  {
    public abstract void aD(float paramFloat);
    
    public abstract u.h b(bt parambt, r paramr1, r paramr2);
    
    public abstract void c(bt parambt, r paramr1, r paramr2);
    
    public abstract void d(bt parambt, r paramr1, r paramr2);
  }
  
  public static abstract interface f
  {
    public abstract void aTh();
  }
  
  public static enum h
  {
    public final String name;
    
    static
    {
      AppMethodBeat.i(176583);
      lBD = new h("MIN", 0, "min");
      lBE = new h("MAX", 1, "max");
      lBF = new h[] { lBD, lBE };
      AppMethodBeat.o(176583);
    }
    
    private h(String paramString)
    {
      this.name = paramString;
    }
  }
  
  public static abstract interface i
  {
    public abstract void q(r paramr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.u
 * JD-Core Version:    0.7.0.1
 */