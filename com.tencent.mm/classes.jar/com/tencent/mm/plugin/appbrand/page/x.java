package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.tencent.luggage.l.m;
import com.tencent.luggage.wxa.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.i.f;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.page.b.f;
import com.tencent.mm.plugin.appbrand.page.b.i;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
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
import kotlin.g.a.a;
import org.json.JSONObject;

public class x
  extends FrameLayout
{
  static final int tvm = a.d.app_brand_page_attached_animator;
  private String mAppId;
  private volatile boolean mDestroyed;
  private AppBrandRuntime qwG;
  private long tvA;
  final az tvB;
  private boolean tvC;
  private f tvD;
  private i tvE;
  private h tvF;
  private boolean tvG;
  private e tvH;
  private boolean tvn;
  private boolean tvo;
  private a tvp;
  private b tvq;
  private final Map<i, com.tencent.mm.plugin.appbrand.page.b.e> tvr;
  final byte[] tvs;
  private final LinkedList<u> tvt;
  private final LinkedList<u> tvu;
  final LinkedList<c> tvv;
  private ad tvw;
  private boolean tvx;
  private u tvy;
  private ca tvz;
  
  public x(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramContext);
    AppMethodBeat.i(135048);
    this.mDestroyed = false;
    this.tvn = false;
    this.tvo = false;
    this.tvr = new HashMap();
    this.tvs = new byte[0];
    this.tvt = new LinkedList();
    this.tvu = new LinkedList();
    this.tvv = new LinkedList();
    this.tvx = false;
    this.tvA = 500L;
    this.tvB = new az();
    this.tvC = true;
    this.tvE = null;
    this.tvF = null;
    this.tvG = false;
    this.tvH = null;
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "AppBrandPageContainerProfile| <init> appId[%s]", new Object[] { paramAppBrandRuntime.mAppId });
    this.qwG = paramAppBrandRuntime;
    this.mAppId = paramAppBrandRuntime.mAppId;
    this.tvz = new ca.a();
    AppMethodBeat.o(135048);
  }
  
  private Object a(final u paramu, final cb paramcb, boolean paramBoolean)
  {
    AppMethodBeat.i(324958);
    if (paramu == null)
    {
      AppMethodBeat.o(324958);
      return null;
    }
    synchronized (this.tvs)
    {
      this.tvt.remove(paramu);
      this.tvt.push(paramu);
      this.tvu.remove(paramu);
      paramu.bringToFront();
      requestLayout();
      invalidate();
      paramu.cEh();
      paramcb = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(176570);
          paramu.e(paramcb);
          AppMethodBeat.o(176570);
        }
      };
      if (paramBoolean)
      {
        paramu = a(paramu, n(paramu), paramcb);
        AppMethodBeat.o(324958);
        return paramu;
      }
    }
    r(paramu);
    paramcb.run();
    AppMethodBeat.o(324958);
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
      paramu.setTag(tvm, localObject);
      ((Animator)localObject).addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(325075);
          paramu.setTag(x.tvm, null);
          if (paramRunnable != null)
          {
            x.this.removeCallbacks(paramRunnable);
            if (!x.f(x.this)) {
              paramRunnable.run();
            }
          }
          AppMethodBeat.o(325075);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(325079);
          paramu.setTag(x.tvm, null);
          if (paramRunnable != null) {
            x.this.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(324858);
                if (!x.f(x.this)) {
                  x.20.this.val$runnable.run();
                }
                AppMethodBeat.o(324858);
              }
            });
          }
          AppMethodBeat.o(325079);
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
            AppMethodBeat.i(325077);
            if (paramRunnable != null)
            {
              Runnable local1 = new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(325072);
                  if (!x.f(x.this)) {
                    x.21.this.val$runnable.run();
                  }
                  x.21.this.tvJ.setTag(x.tvm, null);
                  AppMethodBeat.o(325072);
                }
              };
              if (paramAnonymousAnimation.getStartTime() == -9223372036854775808L)
              {
                local1.run();
                AppMethodBeat.o(325077);
                return;
              }
              if (!x.f(x.this)) {
                x.this.post(local1);
              }
              AppMethodBeat.o(325077);
              return;
            }
            paramu.setTag(x.tvm, null);
            AppMethodBeat.o(325077);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
        r(paramu);
        paramu.setTag(tvm, localObject);
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
    AppMethodBeat.i(324972);
    paramu = a(paramu, p(paramu), paramRunnable);
    AppMethodBeat.o(324972);
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
    synchronized (this.tvs)
    {
      this.tvt.remove(paramu);
      this.tvu.remove(paramu);
      paramu.cEi();
      ??? = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(176569);
          if (paramBoolean2) {
            x.a(x.this, paramu);
          }
          AppMethodBeat.o(176569);
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
  
  private void a(final cb paramcb, final u paramu1, final u paramu2, final x.g paramg)
  {
    AppMethodBeat.i(176599);
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandPageContainer", "processPageSwitchResult, pageSwitchResult: ".concat(String.valueOf(paramg)));
    paramg = paramg.twj;
    if ((paramg instanceof ValueAnimator))
    {
      paramg = (ValueAnimator)paramg;
      paramg.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(325076);
          super.onAnimationCancel(paramAnonymousAnimator);
          x.this.f(paramcb, paramu1, paramu2);
          if (x.g(x.this) != null) {
            x.g(x.this).f(paramcb, paramu1, paramu2);
          }
          x.h(x.this);
          AppMethodBeat.o(325076);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(325073);
          super.onAnimationEnd(paramAnonymousAnimator);
          x.a(x.this, paramcb, paramu1, paramu2);
          AppMethodBeat.o(325073);
        }
      });
      paramg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(325067);
          int i = (int)(paramAnonymousValueAnimator.getAnimatedFraction() * 100.0F);
          x.this.b(paramcb, paramu1, paramu2, i);
          if (x.g(x.this) != null) {
            x.g(x.this).bR(i);
          }
          AppMethodBeat.o(325067);
        }
      });
      AppMethodBeat.o(176599);
      return;
    }
    if ((paramg instanceof Animation))
    {
      paramg = (Animation)paramg;
      long l = paramg.getDuration();
      paramcb = new Choreographer.FrameCallback()
      {
        public final void doFrame(long paramAnonymousLong)
        {
          AppMethodBeat.i(325069);
          float f = ((float)(SystemClock.elapsedRealtime() - this.twa) + 0.0F) / (float)paramcb;
          if (1.0F <= f)
          {
            x.a(x.this, paramu2, paramg, this.tvZ);
            AppMethodBeat.o(325069);
            return;
          }
          int i = (int)(this.twb.getInterpolator().getInterpolation(f) * 100.0F);
          x.this.b(paramu2, paramg, this.tvZ, i);
          if (x.g(x.this) != null) {
            x.g(x.this).bR(i);
          }
          Choreographer.getInstance().postFrameCallback(this);
          AppMethodBeat.o(325069);
        }
      };
      Choreographer.getInstance().postFrameCallback(paramcb);
      AppMethodBeat.o(176599);
      return;
    }
    b(paramcb, paramu1, paramu2);
    AppMethodBeat.o(176599);
  }
  
  private void a(final u paramu1, final u paramu2, final cb paramcb, h paramh)
  {
    Object localObject2 = null;
    AppMethodBeat.i(176594);
    for (;;)
    {
      synchronized (this.tvs)
      {
        this.tvt.remove(paramu2);
        this.tvu.remove(paramu2);
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
              AppMethodBeat.i(135033);
              x.a(x.this, paramu2);
              AppMethodBeat.o(135033);
            }
          });
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "switchPageClear, in: %s out: %s", new Object[] { paramu1.getCurrentUrl(), paramu2.getCurrentUrl() });
          com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandPageContainer", "switchPageClear, dispatchRoute, type: %s, pipMode: %s", new Object[] { paramcb, paramh });
          paramu1.a(paramcb, paramh);
          paramu1.cEh();
          if (i == 0) {
            break label204;
          }
          paramh = a(paramu1, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(135035);
              paramu1.e(paramcb);
              AppMethodBeat.o(135035);
            }
          });
          a(paramcb, paramu2, paramu1, new x.g(paramh, ???));
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
      paramu1.e(paramcb);
      paramh = localObject2;
    }
  }
  
  private boolean a(String paramString, cb paramcb, d paramd)
  {
    AppMethodBeat.i(324932);
    if (this.tvp != null)
    {
      boolean bool = this.tvp.a(paramString, paramcb, this, paramd);
      AppMethodBeat.o(324932);
      return bool;
    }
    AppMethodBeat.o(324932);
    return false;
  }
  
  private boolean aeF(String arg1)
  {
    AppMethodBeat.i(324944);
    final u localu = getCurrentPage();
    n localn = aeG(???);
    if (localn != null)
    {
      localn.a(???, new n.b()
      {
        public final void b(n paramAnonymousn, String paramAnonymousString)
        {
          AppMethodBeat.i(325023);
          paramAnonymousString = x.this.a(localu, paramAnonymousn, cb.tBt, paramAnonymousString, cc.g(cb.tBt));
          this.tvP[0] = paramAnonymousString;
          paramAnonymousn.a(cb.tBt, this.tvP[0]);
          AppMethodBeat.o(325023);
        }
        
        public final void f(n paramAnonymousn)
        {
          AppMethodBeat.i(325026);
          paramAnonymousn.e(cb.tBt);
          x.a(x.this, cb.tBt, localu, paramAnonymousn);
          x.this.a(localu, paramAnonymousn, cb.tBt);
          AppMethodBeat.o(325026);
        }
      }, cb.tBt);
      AppMethodBeat.o(324944);
      return true;
    }
    localn = aeH(???);
    if (localn != null)
    {
      final h[] arrayOfh = new h[1];
      localn.a(???, new n.b()
      {
        public final void b(n paramAnonymousn, String paramAnonymousString)
        {
          AppMethodBeat.i(324849);
          paramAnonymousn = x.this.a(localu, paramAnonymousn, cb.tBt, paramAnonymousString, cc.g(cb.tBt));
          arrayOfh[0] = paramAnonymousn;
          AppMethodBeat.o(324849);
        }
        
        public final void f(n paramAnonymousn)
        {
          AppMethodBeat.i(324853);
          x.this.a(localu, paramAnonymousn, cb.tBt);
          AppMethodBeat.o(324853);
        }
      }, cb.tBt);
      synchronized (this.tvs)
      {
        localu = (u)this.tvt.getFirst();
        c(localu, localn);
        a(localn, localu, cb.tBt, arrayOfh[0]);
        AppMethodBeat.o(324944);
        return true;
      }
    }
    AppMethodBeat.o(324944);
    return false;
  }
  
  private n aeG(String paramString)
  {
    AppMethodBeat.i(324961);
    synchronized (this.tvs)
    {
      u localu = (u)this.tvt.peekFirst();
      if (((localu instanceof n)) && (localu.fa(paramString)))
      {
        paramString = (n)localu;
        AppMethodBeat.o(324961);
        return paramString;
      }
      AppMethodBeat.o(324961);
      return null;
    }
  }
  
  private n aeH(String paramString)
  {
    AppMethodBeat.i(324964);
    synchronized (this.tvs)
    {
      if (this.tvt.size() < 2)
      {
        AppMethodBeat.o(324964);
        return null;
      }
      ListIterator localListIterator = this.tvt.listIterator(1);
      while (localListIterator.hasNext())
      {
        u localu = (u)localListIterator.next();
        if (((localu instanceof n)) && (localu.fa(paramString)))
        {
          paramString = (n)localu;
          AppMethodBeat.o(324964);
          return paramString;
        }
      }
      AppMethodBeat.o(324964);
      return null;
    }
  }
  
  private ad aeJ(String paramString)
  {
    AppMethodBeat.i(324970);
    if (this.tvp != null)
    {
      paramString = this.tvp.a(this, paramString);
      if (paramString != null)
      {
        AppMethodBeat.o(324970);
        return paramString;
      }
    }
    AppMethodBeat.o(324970);
    return null;
  }
  
  private String aeL(String paramString)
  {
    AppMethodBeat.i(324981);
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = this.qwG.getAppConfig().ckv();
    }
    paramString = str;
    if (str.startsWith("?")) {
      paramString = this.qwG.getAppConfig().ckv() + str;
    }
    AppMethodBeat.o(324981);
    return paramString;
  }
  
  private Object b(u paramu, Runnable paramRunnable)
  {
    AppMethodBeat.i(324974);
    paramu = a(paramu, q(paramu), paramRunnable);
    AppMethodBeat.o(324974);
    return paramu;
  }
  
  private void b(cb paramcb, u paramu1, u paramu2)
  {
    AppMethodBeat.i(176600);
    if (!this.tvG)
    {
      d(paramcb, paramu1, paramu2);
      if (this.tvH != null) {
        this.tvF = this.tvH.g(paramcb, paramu1, paramu2);
      }
      this.tvG = true;
    }
    e(paramcb, paramu1, paramu2);
    if (this.tvH != null) {
      this.tvH.e(paramcb, paramu1, paramu2);
    }
    this.tvG = false;
    AppMethodBeat.o(176600);
  }
  
  private void b(final String paramString, final cb paramcb, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(324938);
    if (this.qwG == null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandPageContainer", "navigateToImpl destroyed, url[%s], type[%s]", new Object[] { paramString, paramcb });
      AppMethodBeat.o(324938);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "navigateTo: %s, type[%s]", new Object[] { paramString, paramcb });
    paramString = aeL(paramString);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "navigateTo: %s fixed, type[%s]", new Object[] { paramString, paramcb });
    cEo();
    if ((paramcb != cb.tBt) || (!aeF(paramString)))
    {
      paramJSONObject = new d()
      {
        private boolean mCanceled = false;
        private boolean twe = false;
        private boolean twf = false;
        
        public final void cEt()
        {
          this.twf = true;
        }
        
        public final void cancel()
        {
          this.mCanceled = true;
        }
        
        public final void proceed()
        {
          AppMethodBeat.i(135045);
          if (this.mCanceled)
          {
            AppMethodBeat.o(135045);
            return;
          }
          if (x.b(x.this) == null)
          {
            com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandPageContainer", "attempt to proceed but destroyed, url[%s], type[%s]", new Object[] { paramString, paramcb });
            AppMethodBeat.o(135045);
            return;
          }
          if (!this.twe)
          {
            x.a(x.this, paramString, paramcb, this.twf, paramJSONObject);
            this.twe = true;
          }
          AppMethodBeat.o(135045);
        }
      };
      if (!a(paramString, paramcb, paramJSONObject)) {
        paramJSONObject.proceed();
      }
    }
    AppMethodBeat.o(324938);
  }
  
  private void c(u paramu1, u paramu2)
  {
    AppMethodBeat.i(135071);
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.tvs)
    {
      Iterator localIterator = this.tvt.iterator();
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
            this.tvu.remove(localu);
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
  
  private void cEo()
  {
    AppMethodBeat.i(176593);
    synchronized (this.tvs)
    {
      Object localObject2 = new LinkedList(this.tvv);
      this.tvv.clear();
      ??? = ((LinkedList)localObject2).descendingIterator();
      if (((Iterator)???).hasNext())
      {
        localObject2 = (c)((Iterator)???).next();
        ((c)localObject2).ko(true);
        ((c)localObject2).run();
        ((Iterator)???).remove();
      }
    }
  }
  
  private u d(String paramString, cb paramcb)
  {
    AppMethodBeat.i(135065);
    if (e(paramString, paramcb))
    {
      paramString = new n(getContext(), this);
      AppMethodBeat.o(135065);
      return paramString;
    }
    paramString = new al(getContext(), this);
    AppMethodBeat.o(135065);
    return paramString;
  }
  
  private boolean e(String paramString, cb paramcb)
  {
    AppMethodBeat.i(135069);
    if (paramcb == cb.tBt)
    {
      AppMethodBeat.o(135069);
      return true;
    }
    if ((paramcb == cb.tBr) || (paramcb == cb.tBs))
    {
      boolean bool = this.qwG.getAppConfig().cku().Xm(paramString);
      AppMethodBeat.o(135069);
      return bool;
    }
    for (;;)
    {
      synchronized (this.tvs)
      {
        if (paramcb == cb.tBp) {
          break label169;
        }
        if (paramcb == cb.tBq)
        {
          break label169;
          int j = this.tvt.size();
          if (i != 0)
          {
            i = 1;
            if ((!this.qwG.getAppConfig().cku().Xm(paramString)) || (j + 1 - i != 1)) {
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
  
  private void k(u paramu)
  {
    AppMethodBeat.i(135076);
    if (this.tvE != null) {
      this.tvE.s(paramu);
    }
    paramu.setVisibility(8);
    paramu.cEi();
    if (!paramu.tvc) {
      paramu.performDestroy();
    }
    removeView(paramu);
    if (!paramu.tvc) {
      paramu.arb();
    }
    if ((getRuntime() != null) && (AndroidContextUtil.castActivityOrNull(getRuntime().mContext) != null) && (com.tencent.mm.plugin.appbrand.widget.input.n.Q(AndroidContextUtil.castActivityOrNull(getRuntime().mContext)) != null)) {
      com.tencent.mm.plugin.appbrand.widget.input.n.Q(AndroidContextUtil.castActivityOrNull(getRuntime().mContext)).requestLayout();
    }
    AppMethodBeat.o(135076);
  }
  
  private static void r(u paramu)
  {
    AppMethodBeat.i(135094);
    paramu.clearAnimation();
    paramu = paramu.getTag(tvm);
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
  
  public final ad L(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(325151);
    Object localObject1 = new LinkedList();
    synchronized (this.tvs)
    {
      ((LinkedList)localObject1).addAll(this.tvu);
      ((LinkedList)localObject1).addAll(this.tvt);
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (u)((Iterator)localObject1).next();
        if (localObject3 != null)
        {
          localObject3 = ((u)localObject3).L(paramInt, paramBoolean);
          if (localObject3 != null)
          {
            AppMethodBeat.o(325151);
            return localObject3;
          }
        }
      }
      AppMethodBeat.o(325151);
      return null;
    }
  }
  
  public h a(u paramu1, u paramu2, cb paramcb, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(325178);
    String str2 = getAppId();
    if (paramu1 == null) {}
    for (String str1 = null;; str1 = m.fL(paramu1.getCurrentUrl()))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "onNavigateStart, appId[%s] out[%s], in[%s], mActuallyVisible[%b], type[%s]", new Object[] { str2, str1, m.fL(paramString), Boolean.valueOf(this.tvn), paramcb });
      if (paramu1 != null) {
        paramu1.hideVKB();
      }
      paramString = this.tvF;
      str1 = paramString;
      if (!this.tvG)
      {
        d(paramcb, paramu1, paramu2);
        if (this.tvH != null) {
          paramString = this.tvH.g(paramcb, paramu1, paramu2);
        }
        this.tvG = true;
        str1 = paramString;
      }
      if (cb.tBm == paramcb)
      {
        getRuntime().qsp.a(paramu2.getCurrentPageView(), paramcb);
        k(paramu2.getCurrentPageView());
      }
      if ((paramu1 != null) && (paramu1.getCurrentPageView() != null) && (paramu1.getCurrentPageView().getFullscreenImpl() != null) && (paramu1.getCurrentPageView().getFullscreenImpl().cHN())) {
        paramu1.getCurrentPageView().getFullscreenImpl().cdL();
      }
      AppMethodBeat.o(325178);
      return str1;
    }
  }
  
  public final void a(final int paramInt, final String paramString, final JSONObject paramJSONObject, final f paramf)
  {
    AppMethodBeat.i(325163);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135047);
        x.a(x.this, paramInt, paramString, paramJSONObject, paramf);
        AppMethodBeat.o(135047);
      }
    });
    AppMethodBeat.o(325163);
  }
  
  public final void a(i parami, com.tencent.mm.plugin.appbrand.page.b.e parame)
  {
    AppMethodBeat.i(325088);
    if (parami == null)
    {
      AppMethodBeat.o(325088);
      return;
    }
    synchronized (this.tvr)
    {
      this.tvr.put(parami, parame);
      AppMethodBeat.o(325088);
      return;
    }
  }
  
  final void a(cb paramcb, u paramu1, u paramu2)
  {
    AppMethodBeat.i(325245);
    if (!this.tvG)
    {
      d(paramcb, paramu1, paramu2);
      if (this.tvH != null) {
        this.tvF = this.tvH.g(paramcb, paramu1, paramu2);
      }
      this.tvG = true;
    }
    AppMethodBeat.o(325245);
  }
  
  final void a(cb paramcb, u paramu1, u paramu2, float paramFloat)
  {
    AppMethodBeat.i(325250);
    if (!this.tvG)
    {
      d(paramcb, paramu1, paramu2);
      if (this.tvH != null) {
        this.tvF = this.tvH.g(paramcb, paramu1, paramu2);
      }
      this.tvG = true;
    }
    b(paramcb, paramu1, paramu2, paramFloat);
    if (this.tvH != null) {
      this.tvH.bR(paramFloat);
    }
    AppMethodBeat.o(325250);
  }
  
  public void a(u paramu1, u paramu2, cb paramcb)
  {
    AppMethodBeat.i(135067);
    String str2 = getAppId();
    if (paramu1 == null) {}
    for (String str1 = null;; str1 = m.fL(paramu1.getCurrentUrl()))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "onNavigateEnd, appId[%s] out[%s], in[%s], mActuallyVisible[%b], type[%s]", new Object[] { str2, str1, m.fL(paramu2.getCurrentUrl()), Boolean.valueOf(this.tvn), paramcb });
      if (this.tvn) {
        paramu2.getCurrentPageView().cEL();
      }
      if (cb.tBm != paramcb) {
        getRuntime().qsp.a(paramu2.getCurrentPageView(), paramcb);
      }
      if (e(paramu2)) {
        paramu2.getCurrentPageView().cEX();
      }
      if ((paramu1 != null) && (paramu1.getCurrentPageView() != null) && (paramu1.getCurrentPageView().txj != null)) {
        paramu1.getCurrentPageView().txj.lL(false);
      }
      k(paramu2.getCurrentPageView());
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
        AppMethodBeat.i(135024);
        int i = x.this.m(paramu);
        if (i < 0)
        {
          com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandPageContainer", "navigateBack with appId(%s) Page(%s), but already off stack, maybe frequent clicks were performed", new Object[] { x.this.getAppId(), paramu.getCurrentUrl() });
          AppMethodBeat.o(135024);
          return;
        }
        x.a(x.this, i + 1, paramString, null, null);
        AppMethodBeat.o(135024);
      }
    });
    AppMethodBeat.o(176589);
  }
  
  public final boolean aE(int paramInt, String paramString)
  {
    AppMethodBeat.i(325148);
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
        AppMethodBeat.o(325148);
        return false;
      }
    }
    else
    {
      localad2 = L(paramInt, false);
      localad1 = localad2;
      if (localad2 == null)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandPageContainer", "rewriteRoute invalid page appId:%s, webviewId:%d, url:%s", new Object[] { getAppId(), Integer.valueOf(paramInt), paramString });
        AppMethodBeat.o(325148);
        return false;
      }
    }
    boolean bool = localad1.aeM(paramString);
    AppMethodBeat.o(325148);
    return bool;
  }
  
  public final void aM(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(135057);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135042);
        x localx = x.this;
        String str = paramString;
        if (paramBoolean) {}
        for (cb localcb = cb.tBs;; localcb = cb.tBr)
        {
          x.a(localx, str, localcb);
          AppMethodBeat.o(135042);
          return;
        }
      }
    });
    AppMethodBeat.o(135057);
  }
  
  public final void aeB(String paramString)
  {
    AppMethodBeat.i(135056);
    l(paramString, null);
    AppMethodBeat.o(135056);
  }
  
  public final void aeC(final String paramString)
  {
    AppMethodBeat.i(135059);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135044);
        x.a(x.this, paramString, cb.tBt);
        AppMethodBeat.o(135044);
      }
    });
    AppMethodBeat.o(135059);
  }
  
  public final void aeD(final String paramString)
  {
    AppMethodBeat.i(176587);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135046);
        x.this.aeE(paramString);
        AppMethodBeat.o(135046);
      }
    });
    AppMethodBeat.o(176587);
  }
  
  public final void aeE(String paramString)
  {
    AppMethodBeat.i(325166);
    a(1, paramString, null, null);
    AppMethodBeat.o(325166);
  }
  
  public final ad aeI(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(325198);
    int i;
    if (!this.tvx)
    {
      i = 1;
      this.tvx = true;
      if (this.tvp == null) {
        break label113;
      }
      bool = this.tvp.a(this.tvw, paramString);
    }
    for (;;)
    {
      if (bool) {
        break label125;
      }
      ad localad = aeJ(paramString);
      paramString = localad;
      if (localad == null) {
        paramString = new ad();
      }
      if (i != 0) {
        paramString.txm = true;
      }
      paramString.tvz = getDecorWidgetFactory();
      paramString.a(getContext(), this.qwG);
      AppMethodBeat.o(325198);
      return paramString;
      i = 0;
      break;
      label113:
      if (this.tvw != null) {
        bool = true;
      }
    }
    label125:
    paramString = this.tvw;
    this.tvw = null;
    if (i != 0) {
      paramString.txm = true;
    }
    paramString.show();
    removeView(paramString.getContentView());
    AppMethodBeat.o(325198);
    return paramString;
  }
  
  public final void aeK(final String paramString)
  {
    AppMethodBeat.i(325206);
    if (!MMHandlerThread.isMainThread())
    {
      getRuntime().i(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(324851);
          x.this.aeK(paramString);
          AppMethodBeat.o(324851);
        }
      }, 0L);
      AppMethodBeat.o(325206);
      return;
    }
    if (this.mDestroyed)
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandPageContainer", "preloadNext, destroyed, appId:%s, reason:%s", new Object[] { getAppId(), paramString });
      AppMethodBeat.o(325206);
      return;
    }
    if (!this.tvn)
    {
      this.tvo = true;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "preloadNext, deferred, appId:%s, reason:%s", new Object[] { getAppId(), paramString });
      AppMethodBeat.o(325206);
      return;
    }
    this.tvo = false;
    if ((this.tvp != null) && (this.tvp.apY()))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "preloadNext, intercepted, appId:%s, reason:%s", new Object[] { getAppId(), paramString });
      AppMethodBeat.o(325206);
      return;
    }
    if (this.tvw != null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "preloadNext, already preloaded, appId:%s, reason:%s", new Object[] { getAppId(), paramString });
      AppMethodBeat.o(325206);
      return;
    }
    long l = System.currentTimeMillis();
    ad localad2 = aeJ("preload");
    ad localad1 = localad2;
    if (localad2 == null) {
      localad1 = new ad();
    }
    localad1.tvz = getDecorWidgetFactory();
    localad1.a(getContext(), this.qwG);
    localad1.hide();
    addView(localad1.getContentView(), 0);
    this.tvw = localad1;
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "preloadNextPageView: appId:%s, cost:%d, reason:%s", new Object[] { getAppId(), Long.valueOf(System.currentTimeMillis() - l), paramString });
    AppMethodBeat.o(325206);
  }
  
  protected h b(u paramu1, u paramu2)
  {
    AppMethodBeat.i(176591);
    Objects.requireNonNull(paramu2);
    Object localObject2 = getAppId();
    if (paramu1 == null) {}
    for (Object localObject1 = null;; localObject1 = m.fL(paramu1.getCurrentUrl()))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "onNavigateBack, appId[%s] out[%s], in[%s], mActuallyVisible[%b]", new Object[] { localObject2, localObject1, m.fL(paramu2.getCurrentUrl()), Boolean.valueOf(this.tvn) });
      if (this.tvn) {
        paramu2.getCurrentPageView().cEL();
      }
      if (paramu1 != null) {
        paramu1.hideVKB();
      }
      getRuntime().qsp.a(paramu2.getCurrentPageView(), cb.tBo);
      k(paramu2.getCurrentPageView());
      localObject1 = this.tvF;
      localObject2 = localObject1;
      if (!this.tvG)
      {
        d(cb.tBo, paramu1, paramu2);
        if (this.tvH != null) {
          localObject1 = this.tvH.g(cb.tBo, paramu1, paramu2);
        }
        this.tvG = true;
        localObject2 = localObject1;
      }
      AppMethodBeat.o(176591);
      return localObject2;
    }
  }
  
  protected void b(cb paramcb, u paramu1, u paramu2, float paramFloat) {}
  
  public final void b(final u paramu, final String paramString)
  {
    AppMethodBeat.i(176590);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176564);
        int i = x.this.m(paramu);
        x.a(x.this, i, paramString, null, null);
        AppMethodBeat.o(176564);
      }
    });
    AppMethodBeat.o(176590);
  }
  
  public final boolean b(String paramString, Runnable paramRunnable)
  {
    boolean bool1 = false;
    AppMethodBeat.i(325170);
    Object localObject = getNavigateBackInterceptorChain();
    if (localObject == null)
    {
      AppMethodBeat.o(325170);
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
    AppMethodBeat.o(325170);
    return bool1;
  }
  
  final void c(cb paramcb, u paramu1, u paramu2)
  {
    AppMethodBeat.i(325257);
    f(paramcb, paramu1, paramu2);
    if (this.tvH != null) {
      this.tvH.f(paramcb, paramu1, paramu2);
    }
    this.tvG = false;
    AppMethodBeat.o(325257);
  }
  
  protected void c(u paramu, cb paramcb) {}
  
  public final void c(final String paramString1, final String paramString2, final int[] paramArrayOfInt)
  {
    AppMethodBeat.i(135077);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(324854);
        x.a(x.this, paramString1, paramString2, paramArrayOfInt);
        AppMethodBeat.o(324854);
      }
    });
    AppMethodBeat.o(135077);
  }
  
  public final Iterator<u> cEm()
  {
    AppMethodBeat.i(135054);
    Iterator local12 = new Iterator()
    {
      final ListIterator<u> tvQ;
      
      public final boolean hasNext()
      {
        AppMethodBeat.i(324842);
        boolean bool = this.tvQ.hasNext();
        AppMethodBeat.o(324842);
        return bool;
      }
      
      public final void remove()
      {
        AppMethodBeat.i(324844);
        UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(324844);
        throw localUnsupportedOperationException;
      }
    };
    AppMethodBeat.o(135054);
    return local12;
  }
  
  public final void cEn()
  {
    AppMethodBeat.i(135060);
    aM(this.qwG.getAppConfig().ckv(), true);
    AppMethodBeat.o(135060);
  }
  
  protected final void cEp()
  {
    AppMethodBeat.i(135089);
    if (this.qwG == null)
    {
      AppMethodBeat.o(135089);
      return;
    }
    if (this.tvC)
    {
      if (this.tvD != null) {
        this.tvD.cbS();
      }
      onReady();
      this.tvC = false;
    }
    AppMethodBeat.o(135089);
  }
  
  final boolean cEq()
  {
    AppMethodBeat.i(325236);
    if ((getActualPageStackSize() > 1) || (getRuntime().qsJ))
    {
      AppMethodBeat.o(325236);
      return true;
    }
    AppMethodBeat.o(325236);
    return false;
  }
  
  public boolean cEr()
  {
    return false;
  }
  
  protected boolean cEs()
  {
    AppMethodBeat.i(325303);
    try
    {
      AccessibilityManager localAccessibilityManager = (AccessibilityManager)MMApplicationContext.getContext().getSystemService("accessibility");
      if ((localAccessibilityManager.isEnabled()) && (localAccessibilityManager.isTouchExplorationEnabled()))
      {
        AppMethodBeat.o(325303);
        return true;
      }
      AppMethodBeat.o(325303);
      return false;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandPageContainer", "check isAccessibilityEnable fail since ".concat(String.valueOf(localException)));
      AppMethodBeat.o(325303);
    }
    return false;
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(135081);
    this.mDestroyed = true;
    onDestroy();
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.tvt)
    {
      localLinkedList.addAll(this.tvt);
      localLinkedList.addAll(this.tvu);
      this.tvt.clear();
      this.tvu.clear();
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext())
      {
        u localu = (u)((Iterator)???).next();
        localu.cEi();
        localu.performDestroy();
        localu.arb();
        r(localu);
      }
    }
    try
    {
      this.tvw.onDestroy();
      try
      {
        label136:
        this.tvw.cleanup();
        label143:
        removeAllViews();
        this.tvD = null;
        this.qwG = null;
        this.tvE = null;
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
  
  protected void d(cb paramcb, u paramu1, u paramu2)
  {
    AppMethodBeat.i(325263);
    if (paramu1 != paramu2)
    {
      if (paramu2 == null)
      {
        AppMethodBeat.o(325263);
        return;
      }
      if (cEs())
      {
        paramcb = paramu2.getContentView();
        if (paramcb == null)
        {
          AppMethodBeat.o(325263);
          return;
        }
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "fixAccessibilityPageSwitchIssueOnStart, show: " + paramu2.getCurrentUrl());
        paramcb.setVisibility(0);
      }
    }
    AppMethodBeat.o(325263);
  }
  
  protected void e(cb paramcb, u paramu1, u paramu2)
  {
    AppMethodBeat.i(325275);
    if (paramu1 != paramu2)
    {
      if (paramu1 == null)
      {
        AppMethodBeat.o(325275);
        return;
      }
      if (cEs())
      {
        paramcb = paramu1.getContentView();
        if (paramcb == null)
        {
          AppMethodBeat.o(325275);
          return;
        }
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "fixAccessibilityPageSwitchIssueOnEnd, hide: " + paramu1.getCurrentUrl());
        paramcb.setVisibility(4);
      }
    }
    AppMethodBeat.o(325275);
  }
  
  protected boolean e(u paramu)
  {
    boolean bool2 = false;
    AppMethodBeat.i(325189);
    ad localad = paramu.getCurrentPageView();
    if (localad == null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandPageContainer", "shouldShowActionBarHomeButton, appId:%s, page:%s, get NULL PageView", new Object[] { getAppId(), paramu.getCurrentUrl() });
      AppMethodBeat.o(325189);
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
      if (str.startsWith(getRuntime().getAppConfig().ckv())) {
        break label206;
      }
      j = 1;
      if ((localad.cEC() == null) || (localad.cEC().cOX())) {
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
      AppMethodBeat.o(325189);
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
  
  protected void f(cb paramcb, u paramu1, u paramu2) {}
  
  public final int getActualPageStackSize()
  {
    AppMethodBeat.i(176586);
    synchronized (this.tvs)
    {
      int i = this.tvt.size();
      AppMethodBeat.o(176586);
      return i;
    }
  }
  
  public final com.tencent.mm.plugin.appbrand.config.b getAppConfig()
  {
    AppMethodBeat.i(135086);
    com.tencent.mm.plugin.appbrand.config.b localb = this.qwG.getAppConfig();
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
    //   6: ldc_w 1227
    //   9: invokestatic 165	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: aload_0
    //   13: getfield 179	com/tencent/mm/plugin/appbrand/page/x:tvs	[B
    //   16: astore 4
    //   18: aload 4
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 186	com/tencent/mm/plugin/appbrand/page/x:tvu	Ljava/util/LinkedList;
    //   25: invokevirtual 1230	java/util/LinkedList:isEmpty	()Z
    //   28: ifne +126 -> 154
    //   31: aload_0
    //   32: getfield 186	com/tencent/mm/plugin/appbrand/page/x:tvu	Ljava/util/LinkedList;
    //   35: invokevirtual 716	java/util/LinkedList:getFirst	()Ljava/lang/Object;
    //   38: checkcast 247	com/tencent/mm/plugin/appbrand/page/u
    //   41: astore 5
    //   43: aload_0
    //   44: getfield 226	com/tencent/mm/plugin/appbrand/page/x:qwG	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   47: ifnull +90 -> 137
    //   50: aload_0
    //   51: getfield 226	com/tencent/mm/plugin/appbrand/page/x:qwG	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   54: invokevirtual 1233	com/tencent/mm/plugin/appbrand/AppBrandRuntime:cbD	()Z
    //   57: ifeq +92 -> 149
    //   60: aload_0
    //   61: getfield 226	com/tencent/mm/plugin/appbrand/page/x:qwG	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   64: getfield 1236	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mInitialized	Z
    //   67: ifne +82 -> 149
    //   70: aload 5
    //   72: ifnonnull +65 -> 137
    //   75: iload_1
    //   76: ifne +61 -> 137
    //   79: ldc 211
    //   81: ldc_w 1238
    //   84: iconst_4
    //   85: anewarray 215	java/lang/Object
    //   88: dup
    //   89: iconst_0
    //   90: aload_0
    //   91: invokevirtual 623	com/tencent/mm/plugin/appbrand/page/x:getAppId	()Ljava/lang/String;
    //   94: aastore
    //   95: dup
    //   96: iconst_1
    //   97: aload_0
    //   98: getfield 186	com/tencent/mm/plugin/appbrand/page/x:tvu	Ljava/util/LinkedList;
    //   101: invokevirtual 493	java/util/LinkedList:size	()I
    //   104: invokestatic 445	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: aastore
    //   108: dup
    //   109: iconst_2
    //   110: aload_0
    //   111: getfield 184	com/tencent/mm/plugin/appbrand/page/x:tvt	Ljava/util/LinkedList;
    //   114: invokevirtual 493	java/util/LinkedList:size	()I
    //   117: invokestatic 445	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   120: aastore
    //   121: dup
    //   122: iconst_3
    //   123: new 589	java/lang/Throwable
    //   126: dup
    //   127: invokespecial 590	java/lang/Throwable:<init>	()V
    //   130: invokestatic 1244	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   133: aastore
    //   134: invokestatic 775	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: aload 4
    //   139: monitorexit
    //   140: ldc_w 1227
    //   143: invokestatic 235	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aload 5
    //   148: areturn
    //   149: iconst_0
    //   150: istore_1
    //   151: goto -81 -> 70
    //   154: aload_0
    //   155: getfield 184	com/tencent/mm/plugin/appbrand/page/x:tvt	Ljava/util/LinkedList;
    //   158: invokevirtual 541	java/util/LinkedList:peekFirst	()Ljava/lang/Object;
    //   161: checkcast 247	com/tencent/mm/plugin/appbrand/page/u
    //   164: astore 5
    //   166: aload_0
    //   167: getfield 226	com/tencent/mm/plugin/appbrand/page/x:qwG	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   170: ifnull +92 -> 262
    //   173: aload_0
    //   174: getfield 226	com/tencent/mm/plugin/appbrand/page/x:qwG	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   177: invokevirtual 1233	com/tencent/mm/plugin/appbrand/AppBrandRuntime:cbD	()Z
    //   180: ifeq +94 -> 274
    //   183: aload_0
    //   184: getfield 226	com/tencent/mm/plugin/appbrand/page/x:qwG	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   187: getfield 1236	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mInitialized	Z
    //   190: ifne +84 -> 274
    //   193: iload_2
    //   194: istore_1
    //   195: aload 5
    //   197: ifnonnull +65 -> 262
    //   200: iload_1
    //   201: ifne +61 -> 262
    //   204: ldc 211
    //   206: ldc_w 1238
    //   209: iconst_4
    //   210: anewarray 215	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: aload_0
    //   216: invokevirtual 623	com/tencent/mm/plugin/appbrand/page/x:getAppId	()Ljava/lang/String;
    //   219: aastore
    //   220: dup
    //   221: iconst_1
    //   222: aload_0
    //   223: getfield 186	com/tencent/mm/plugin/appbrand/page/x:tvu	Ljava/util/LinkedList;
    //   226: invokevirtual 493	java/util/LinkedList:size	()I
    //   229: invokestatic 445	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   232: aastore
    //   233: dup
    //   234: iconst_2
    //   235: aload_0
    //   236: getfield 184	com/tencent/mm/plugin/appbrand/page/x:tvt	Ljava/util/LinkedList;
    //   239: invokevirtual 493	java/util/LinkedList:size	()I
    //   242: invokestatic 445	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   245: aastore
    //   246: dup
    //   247: iconst_3
    //   248: new 589	java/lang/Throwable
    //   251: dup
    //   252: invokespecial 590	java/lang/Throwable:<init>	()V
    //   255: invokestatic 1244	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   258: aastore
    //   259: invokestatic 775	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   262: aload 4
    //   264: monitorexit
    //   265: ldc_w 1227
    //   268: invokestatic 235	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   271: aload 5
    //   273: areturn
    //   274: iconst_0
    //   275: istore_1
    //   276: goto -81 -> 195
    //   279: astore 5
    //   281: aload_0
    //   282: getfield 226	com/tencent/mm/plugin/appbrand/page/x:qwG	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   285: ifnull +91 -> 376
    //   288: aload_0
    //   289: getfield 226	com/tencent/mm/plugin/appbrand/page/x:qwG	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   292: invokevirtual 1233	com/tencent/mm/plugin/appbrand/AppBrandRuntime:cbD	()Z
    //   295: ifeq +104 -> 399
    //   298: aload_0
    //   299: getfield 226	com/tencent/mm/plugin/appbrand/page/x:qwG	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   302: getfield 1236	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mInitialized	Z
    //   305: ifne +94 -> 399
    //   308: iload_3
    //   309: istore_1
    //   310: iconst_0
    //   311: ifne +65 -> 376
    //   314: iload_1
    //   315: ifne +61 -> 376
    //   318: ldc 211
    //   320: ldc_w 1238
    //   323: iconst_4
    //   324: anewarray 215	java/lang/Object
    //   327: dup
    //   328: iconst_0
    //   329: aload_0
    //   330: invokevirtual 623	com/tencent/mm/plugin/appbrand/page/x:getAppId	()Ljava/lang/String;
    //   333: aastore
    //   334: dup
    //   335: iconst_1
    //   336: aload_0
    //   337: getfield 186	com/tencent/mm/plugin/appbrand/page/x:tvu	Ljava/util/LinkedList;
    //   340: invokevirtual 493	java/util/LinkedList:size	()I
    //   343: invokestatic 445	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   346: aastore
    //   347: dup
    //   348: iconst_2
    //   349: aload_0
    //   350: getfield 184	com/tencent/mm/plugin/appbrand/page/x:tvt	Ljava/util/LinkedList;
    //   353: invokevirtual 493	java/util/LinkedList:size	()I
    //   356: invokestatic 445	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   359: aastore
    //   360: dup
    //   361: iconst_3
    //   362: new 589	java/lang/Throwable
    //   365: dup
    //   366: invokespecial 590	java/lang/Throwable:<init>	()V
    //   369: invokestatic 1244	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   372: aastore
    //   373: invokestatic 775	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   376: ldc_w 1227
    //   379: invokestatic 235	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   382: aload 5
    //   384: athrow
    //   385: astore 5
    //   387: aload 4
    //   389: monitorexit
    //   390: ldc_w 1227
    //   393: invokestatic 235	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public ca getDecorWidgetFactory()
  {
    return this.tvz;
  }
  
  public List<com.tencent.mm.plugin.appbrand.page.b.e> getNavigateBackInterceptorChain()
  {
    AppMethodBeat.i(325085);
    synchronized (this.tvr)
    {
      if ((this.tvr.size() == 0) || (getCurrentPage() == null))
      {
        AppMethodBeat.o(325085);
        return null;
      }
      ArrayList localArrayList = new ArrayList(this.tvr.values());
      Collections.sort(localArrayList, new Comparator() {});
      AppMethodBeat.o(325085);
      return localArrayList;
    }
  }
  
  public final int getPageCount()
  {
    AppMethodBeat.i(135053);
    synchronized (this.tvs)
    {
      int i = this.tvt.size();
      int j = this.tvu.size();
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
    boolean bool = this.qwG.qsQ;
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
    return this.tvw;
  }
  
  public final int getRenderPagesCount()
  {
    AppMethodBeat.i(325122);
    byte[] arrayOfByte = this.tvs;
    int i = 0;
    try
    {
      Iterator localIterator = this.tvt.iterator();
      while (localIterator.hasNext()) {
        i += ((u)localIterator.next()).getCurrentPageView().getCurrentRenderPagesCount();
      }
      localIterator = this.tvu.iterator();
      while (localIterator.hasNext()) {
        i = ((u)localIterator.next()).getCurrentPageView().getCurrentRenderPagesCount() + i;
      }
      return i;
    }
    finally
    {
      AppMethodBeat.o(325122);
    }
  }
  
  public AppBrandRuntime getRuntime()
  {
    return this.qwG;
  }
  
  public final void i(final ad paramad)
  {
    AppMethodBeat.i(325203);
    if (!MMHandlerThread.isMainThread())
    {
      getRuntime().i(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(324852);
          x.this.i(paramad);
          AppMethodBeat.o(324852);
        }
      }, 0L);
      AppMethodBeat.o(325203);
      return;
    }
    if ((this.tvB.v(paramad)) && (paramad.txk != null)) {}
    synchronized (this.tvs)
    {
      if (!this.tvu.contains(paramad.txk))
      {
        i = 1;
        if (i != 0) {
          j(paramad);
        }
        AppMethodBeat.o(325203);
        return;
      }
      int i = 0;
    }
  }
  
  public void init(String paramString)
  {
    AppMethodBeat.i(135055);
    Assert.assertSame(Looper.getMainLooper(), Looper.myLooper());
    b(paramString, cb.tBm, null);
    AppMethodBeat.o(135055);
  }
  
  public final int j(u paramu)
  {
    AppMethodBeat.i(325126);
    int i = 0;
    while (i < this.tvt.size())
    {
      if (paramu == this.tvt.get(i))
      {
        int j = this.tvt.size();
        AppMethodBeat.o(325126);
        return j - 1 - i;
      }
      i += 1;
    }
    AppMethodBeat.o(325126);
    return -1;
  }
  
  final void j(ad paramad)
  {
    AppMethodBeat.i(325204);
    if (this.tvB.w(paramad)) {
      postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(324850);
          x.this.aeK("initReady");
          AppMethodBeat.o(324850);
        }
      }, 200L);
    }
    AppMethodBeat.o(325204);
  }
  
  public final void k(final ad paramad)
  {
    AppMethodBeat.i(325289);
    getRuntime().qsP.setFullscreenImpl(paramad.getFullscreenImpl());
    getRuntime().qsP.a(new bf()
    {
      public final void a(AppBrandPageFullScreenView paramAnonymousAppBrandPageFullScreenView)
      {
        AppMethodBeat.i(325065);
        paramad.txk.a(paramad, paramAnonymousAppBrandPageFullScreenView);
        AppMethodBeat.o(325065);
      }
    });
    AppMethodBeat.o(325289);
  }
  
  public final u l(u paramu)
  {
    AppMethodBeat.i(135079);
    synchronized (this.tvs)
    {
      if (this.tvu.contains(paramu))
      {
        paramu = (u)this.tvt.peekFirst();
        AppMethodBeat.o(135079);
        return paramu;
      }
      int i = this.tvt.indexOf(paramu);
      if (i >= this.tvt.size() - 1)
      {
        AppMethodBeat.o(135079);
        return null;
      }
      paramu = (u)this.tvt.get(i + 1);
      AppMethodBeat.o(135079);
      return paramu;
    }
  }
  
  public final void l(final String paramString, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(325137);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135041);
        x.a(x.this, paramString, cb.tBn, paramJSONObject);
        AppMethodBeat.o(135041);
      }
    });
    AppMethodBeat.o(325137);
  }
  
  final int m(u paramu)
  {
    AppMethodBeat.i(176597);
    synchronized (this.tvs)
    {
      int i = this.tvt.indexOf(paramu);
      AppMethodBeat.o(176597);
      return i;
    }
  }
  
  public final void m(final String paramString, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(325144);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135043);
        x.a(x.this, paramString, cb.tBp, paramJSONObject);
        AppMethodBeat.o(135043);
      }
    });
    AppMethodBeat.o(325144);
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
    synchronized (this.tvs)
    {
      int i;
      if (!this.tvu.isEmpty())
      {
        i = 1;
        if ((i != 0) || (localu.getTag(tvm) != null))
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
    aeD("scene_back_key_pressed");
    AppMethodBeat.o(135096);
  }
  
  public void onBackground()
  {
    AppMethodBeat.i(135088);
    synchronized (this.tvs)
    {
      u localu = (u)this.tvt.peekFirst();
      if (localu == null)
      {
        AppMethodBeat.o(135088);
        return;
      }
    }
    localObject.cEi();
    AppMethodBeat.o(135088);
  }
  
  protected void onDestroy() {}
  
  public void onForeground()
  {
    AppMethodBeat.i(135087);
    synchronized (this.tvs)
    {
      u localu = (u)this.tvt.peekFirst();
      if (localu == null)
      {
        AppMethodBeat.o(135087);
        return;
      }
    }
    localObject.cEh();
    if (this.tvn)
    {
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandPageContainer", "onForeground, call onUserVisible, appId[%s] url[%s]", new Object[] { getAppId(), localObject.getCurrentPageView().cgR() });
      localObject.getCurrentPageView().cEL();
    }
    AppMethodBeat.o(135087);
  }
  
  protected void onReady() {}
  
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
    if (this.qwG == null)
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandPageContainer", "runOnUiThread but mRuntime==NULL, appId:%s, stack:%s", new Object[] { getAppId(), android.util.Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(135052);
      return;
    }
    this.qwG.i(paramRunnable, 0L);
    AppMethodBeat.o(135052);
  }
  
  public void setActuallyVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(135051);
    if (this.tvn != paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.tvn = paramBoolean;
      if ((paramBoolean) && (i != 0))
      {
        getCurrentPage().getCurrentPageView().cEL();
        super.setVisibility(0);
        if (this.tvo) {
          aeK("setActuallyVisible");
        }
      }
      if ((!paramBoolean) && (i != 0)) {
        super.setVisibility(4);
      }
      AppMethodBeat.o(135051);
      return;
    }
  }
  
  public void setDecorWidgetFactory(ca paramca)
  {
    AppMethodBeat.i(135049);
    if (paramca == null)
    {
      paramca = new NullPointerException("Should not be null");
      AppMethodBeat.o(135049);
      throw paramca;
    }
    this.tvz = paramca;
    AppMethodBeat.o(135049);
  }
  
  public final void setDelegate(a parama)
  {
    AppMethodBeat.i(135050);
    if (this.tvp != null)
    {
      parama = new IllegalAccessError("Duplicated call!!!");
      AppMethodBeat.o(135050);
      throw parama;
    }
    a locala = parama;
    if (this.tvq != null) {
      locala = this.tvq.a(parama);
    }
    this.tvp = locala;
    AppMethodBeat.o(135050);
  }
  
  public void setDelegateWrapperFactory(b paramb)
  {
    AppMethodBeat.i(176584);
    this.tvq = paramb;
    if (this.tvp != null) {
      this.tvp = paramb.a(this.tvp);
    }
    AppMethodBeat.o(176584);
  }
  
  public void setOnPageSwitchListener(e parame)
  {
    AppMethodBeat.i(176601);
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandPageContainer", "setOnPageSwitchListener, onPageSwitchListener: ".concat(String.valueOf(parame)));
    this.tvH = parame;
    AppMethodBeat.o(176601);
  }
  
  public void setOnReadyListener(f paramf)
  {
    this.tvD = paramf;
  }
  
  public void setPageNavigationPushTimeout(long paramLong)
  {
    AppMethodBeat.i(325064);
    this.tvA = Math.max(0L, paramLong);
    AppMethodBeat.o(325064);
  }
  
  public void setPipPageLifeCycleListener(i parami)
  {
    this.tvE = parami;
  }
  
  public void setPipVideoRelatedPage(u paramu)
  {
    AppMethodBeat.i(325068);
    if (paramu != null) {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "setPipVideoRelatedPage, page(%s)", new Object[] { paramu.getCurrentUrl() });
    }
    for (;;)
    {
      this.tvy = paramu;
      AppMethodBeat.o(325068);
      return;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "setPipVideoRelatedPage, page is null");
    }
  }
  
  public static abstract interface a
  {
    public abstract ad a(x paramx, String paramString);
    
    public abstract u a(String paramString, cb paramcb, x paramx, Callable<u> paramCallable);
    
    public abstract boolean a(ad paramad, String paramString);
    
    public abstract boolean a(String paramString, cb paramcb, x paramx, x.d paramd);
    
    public abstract boolean apY();
  }
  
  public static abstract interface b
  {
    public abstract x.a a(x.a parama);
  }
  
  static abstract interface c
    extends Runnable
  {
    public abstract void ko(boolean paramBoolean);
  }
  
  public static abstract interface d
  {
    public abstract void cEt();
    
    public abstract void cancel();
    
    public abstract void proceed();
  }
  
  public static abstract interface e
  {
    public abstract void bR(float paramFloat);
    
    public abstract void e(cb paramcb, u paramu1, u paramu2);
    
    public abstract void f(cb paramcb, u paramu1, u paramu2);
    
    public abstract x.h g(cb paramcb, u paramu1, u paramu2);
  }
  
  public static abstract interface f
  {
    public abstract void cbS();
  }
  
  public static enum h
  {
    public final String name;
    
    static
    {
      AppMethodBeat.i(176583);
      twl = new h("MIN", 0, "min");
      twm = new h("MAX", 1, "max");
      twn = new h[] { twl, twm };
      AppMethodBeat.o(176583);
    }
    
    private h(String paramString)
    {
      this.name = paramString;
    }
  }
  
  public static abstract interface i
  {
    public abstract void s(u paramu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.x
 * JD-Core Version:    0.7.0.1
 */