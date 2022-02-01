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
import com.tencent.luggage.h.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.b.g;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.i.f;
import com.tencent.mm.plugin.appbrand.page.b.f;
import com.tencent.mm.plugin.appbrand.page.b.i;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
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

@SuppressLint({"ViewConstructor"})
public class w
  extends FrameLayout
{
  static final int noX = 2131296859;
  private AppBrandRuntime kEc;
  private String mAppId;
  private volatile boolean mDestroyed;
  private boolean noY;
  private boolean noZ;
  private a npa;
  private b npb;
  private final Map<i, com.tencent.mm.plugin.appbrand.page.b.e> npc;
  private final byte[] npd;
  private final LinkedList<t> npe;
  private final LinkedList<t> npf;
  private final LinkedList<c> npg;
  private ac nph;
  private boolean npi;
  private t npj;
  private bw npk;
  final ax npl;
  private boolean npm;
  private f npn;
  private i npo;
  h npp;
  boolean npq;
  e npr;
  
  public w(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramContext);
    AppMethodBeat.i(135048);
    this.mDestroyed = false;
    this.noY = false;
    this.noZ = false;
    this.npc = new HashMap();
    this.npd = new byte[0];
    this.npe = new LinkedList();
    this.npf = new LinkedList();
    this.npg = new LinkedList();
    this.npi = false;
    this.npl = new ax();
    this.npm = true;
    this.npo = null;
    this.npp = null;
    this.npq = false;
    this.npr = null;
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "AppBrandPageContainerProfile| <init> appId[%s]", new Object[] { paramAppBrandRuntime.mAppId });
    this.kEc = paramAppBrandRuntime;
    this.mAppId = paramAppBrandRuntime.mAppId;
    this.npk = new bw.a();
    AppMethodBeat.o(135048);
  }
  
  private t a(String paramString, bx parambx)
  {
    AppMethodBeat.i(135065);
    if (b(paramString, parambx))
    {
      paramString = new m(getContext(), this);
      AppMethodBeat.o(135065);
      return paramString;
    }
    paramString = new ak(getContext(), this);
    AppMethodBeat.o(135065);
    return paramString;
  }
  
  private Object a(final t paramt, final bx parambx, boolean paramBoolean)
  {
    AppMethodBeat.i(219413);
    if (paramt == null)
    {
      AppMethodBeat.o(219413);
      return null;
    }
    synchronized (this.npd)
    {
      this.npe.remove(paramt);
      this.npe.push(paramt);
      this.npf.remove(paramt);
      paramt.bringToFront();
      requestLayout();
      invalidate();
      paramt.bQN();
      parambx = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(219386);
          paramt.b(parambx);
          AppMethodBeat.o(219386);
        }
      };
      if (paramBoolean)
      {
        paramt = a(paramt, m(paramt), parambx);
        AppMethodBeat.o(219413);
        return paramt;
      }
    }
    q(paramt);
    parambx.run();
    AppMethodBeat.o(219413);
    return null;
  }
  
  private Object a(final t paramt, Object paramObject, final Runnable paramRunnable)
  {
    AppMethodBeat.i(176598);
    Object localObject;
    if ((paramObject instanceof Animator))
    {
      localObject = (Animator)paramObject;
      q(paramt);
      paramt.setTag(noX, localObject);
      ((Animator)localObject).addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(219391);
          paramt.setTag(w.noX, null);
          if (paramRunnable != null)
          {
            w.this.removeCallbacks(paramRunnable);
            if (!w.g(w.this)) {
              paramRunnable.run();
            }
          }
          AppMethodBeat.o(219391);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(219392);
          paramt.setTag(w.noX, null);
          if (paramRunnable != null) {
            w.this.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(219390);
                if (!w.g(w.this)) {
                  w.20.this.val$runnable.run();
                }
                AppMethodBeat.o(219390);
              }
            });
          }
          AppMethodBeat.o(219392);
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
            AppMethodBeat.i(219394);
            if (paramRunnable != null)
            {
              Runnable local1 = new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(219393);
                  if (!w.g(w.this)) {
                    w.21.this.val$runnable.run();
                  }
                  w.21.this.npv.setTag(w.noX, null);
                  AppMethodBeat.o(219393);
                }
              };
              if (paramAnonymousAnimation.getStartTime() == -9223372036854775808L)
              {
                local1.run();
                AppMethodBeat.o(219394);
                return;
              }
              if (!w.g(w.this)) {
                w.this.post(local1);
              }
              AppMethodBeat.o(219394);
              return;
            }
            paramt.setTag(w.noX, null);
            AppMethodBeat.o(219394);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
        q(paramt);
        paramt.setTag(noX, localObject);
        paramt.startAnimation((Animation)localObject);
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
    paramt = new IllegalArgumentException("Page animation should be Animator or Animation");
    AppMethodBeat.o(176598);
    throw paramt;
  }
  
  private Object a(t paramt, Runnable paramRunnable)
  {
    AppMethodBeat.i(219418);
    paramt = a(paramt, o(paramt), paramRunnable);
    AppMethodBeat.o(219418);
    return paramt;
  }
  
  private Object a(final t paramt, boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(176595);
    if (paramt == null)
    {
      AppMethodBeat.o(176595);
      return null;
    }
    if (paramBoolean2) {}
    synchronized (this.npd)
    {
      this.npe.remove(paramt);
      this.npf.remove(paramt);
      paramt.bQO();
      ??? = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(176570);
          if (paramBoolean2) {
            w.a(w.this, paramt);
          }
          AppMethodBeat.o(176570);
        }
      };
      if (paramBoolean1)
      {
        paramt = a(paramt, n(paramt), (Runnable)???);
        AppMethodBeat.o(176595);
        return paramt;
      }
    }
    q(paramt);
    ((Runnable)???).run();
    AppMethodBeat.o(176595);
    return null;
  }
  
  private void a(bx parambx, t paramt1, t paramt2)
  {
    AppMethodBeat.i(176600);
    if (this.npr == null)
    {
      AppMethodBeat.o(176600);
      return;
    }
    if (!this.npq)
    {
      this.npp = this.npr.b(parambx, paramt1, paramt2);
      this.npq = true;
    }
    this.npr.c(parambx, paramt1, paramt2);
    this.npq = false;
    AppMethodBeat.o(176600);
  }
  
  private void a(final bx parambx, final t paramt1, final t paramt2, final w.g paramg)
  {
    AppMethodBeat.i(176599);
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandPageContainer", "processPageSwitchResult, pageSwitchResult: ".concat(String.valueOf(paramg)));
    if (this.npr == null)
    {
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandPageContainer", "processPageSwitchResult, null == mOnPageSwitchListener");
      AppMethodBeat.o(176599);
      return;
    }
    paramg = paramg.npT;
    if ((paramg instanceof ValueAnimator))
    {
      paramg = (ValueAnimator)paramg;
      paramg.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(219396);
          super.onAnimationCancel(paramAnonymousAnimator);
          w.h(w.this).d(parambx, paramt1, paramt2);
          w.i(w.this);
          AppMethodBeat.o(219396);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(219395);
          super.onAnimationEnd(paramAnonymousAnimator);
          w.a(w.this, parambx, paramt1, paramt2);
          AppMethodBeat.o(219395);
        }
      });
      paramg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(219397);
          int i = (int)(paramAnonymousValueAnimator.getAnimatedFraction() * 100.0F);
          w.h(w.this).aQ(i);
          AppMethodBeat.o(219397);
        }
      });
      AppMethodBeat.o(176599);
      return;
    }
    if ((paramg instanceof Animation))
    {
      paramg = (Animation)paramg;
      long l = paramg.getDuration();
      parambx = new Choreographer.FrameCallback()
      {
        public final void doFrame(long paramAnonymousLong)
        {
          AppMethodBeat.i(219398);
          float f = ((float)(SystemClock.elapsedRealtime() - this.npL) + 0.0F) / (float)parambx;
          if (1.0F <= f)
          {
            w.a(w.this, paramt2, paramg, this.npK);
            AppMethodBeat.o(219398);
            return;
          }
          int i = (int)(this.npM.getInterpolator().getInterpolation(f) * 100.0F);
          w.h(w.this).aQ(i);
          Choreographer.getInstance().postFrameCallback(this);
          AppMethodBeat.o(219398);
        }
      };
      Choreographer.getInstance().postFrameCallback(parambx);
      AppMethodBeat.o(176599);
      return;
    }
    a(parambx, paramt1, paramt2);
    AppMethodBeat.o(176599);
  }
  
  private void a(final t paramt1, final t paramt2, final bx parambx, h paramh)
  {
    Object localObject2 = null;
    AppMethodBeat.i(176594);
    for (;;)
    {
      synchronized (this.npd)
      {
        this.npe.remove(paramt2);
        this.npf.remove(paramt2);
        if (!paramt2.mSwiping)
        {
          i = 1;
          if (i == 0) {
            break label193;
          }
          ??? = b(paramt2, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(135035);
              w.a(w.this, paramt2);
              AppMethodBeat.o(135035);
            }
          });
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "switchPageClear, in: %s out: %s", new Object[] { paramt1.getCurrentUrl(), paramt2.getCurrentUrl() });
          com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandPageContainer", "switchPageClear, dispatchRoute, type: %s, pipMode: %s", new Object[] { parambx, paramh });
          paramt1.a(parambx, paramh);
          paramt1.bQN();
          if (i == 0) {
            break label204;
          }
          paramh = a(paramt1, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(176569);
              paramt1.b(parambx);
              AppMethodBeat.o(176569);
            }
          });
          a(parambx, paramt2, paramt1, new w.g(paramh, ???));
          AppMethodBeat.o(176594);
          return;
        }
      }
      int i = 0;
      continue;
      label193:
      j(paramt2);
      ??? = null;
      continue;
      label204:
      paramt1.b(parambx);
      paramh = localObject2;
    }
  }
  
  private boolean adH(String arg1)
  {
    AppMethodBeat.i(219412);
    final t localt = getCurrentPage();
    m localm = adI(???);
    if (localm != null)
    {
      localm.a(???, new m.b()
      {
        public final void b(m paramAnonymousm, String paramAnonymousString)
        {
          AppMethodBeat.i(219378);
          paramAnonymousString = w.this.a(localt, paramAnonymousm, bx.nuK, paramAnonymousString, by.c(bx.nuK));
          this.npB[0] = paramAnonymousString;
          paramAnonymousm.a(bx.nuK, this.npB[0]);
          AppMethodBeat.o(219378);
        }
        
        public final void e(m paramAnonymousm)
        {
          AppMethodBeat.i(219379);
          paramAnonymousm.b(bx.nuK);
          w.a(w.this, bx.nuK, localt, paramAnonymousm);
          w.this.a(localt, paramAnonymousm, bx.nuK);
          AppMethodBeat.o(219379);
        }
      });
      AppMethodBeat.o(219412);
      return true;
    }
    localm = adJ(???);
    if (localm != null)
    {
      final h[] arrayOfh = new h[1];
      localm.a(???, new m.b()
      {
        public final void b(m paramAnonymousm, String paramAnonymousString)
        {
          AppMethodBeat.i(219380);
          paramAnonymousm = w.this.a(localt, paramAnonymousm, bx.nuK, paramAnonymousString, by.c(bx.nuK));
          arrayOfh[0] = paramAnonymousm;
          AppMethodBeat.o(219380);
        }
        
        public final void e(m paramAnonymousm)
        {
          AppMethodBeat.i(219381);
          w.this.a(localt, paramAnonymousm, bx.nuK);
          AppMethodBeat.o(219381);
        }
      });
      synchronized (this.npd)
      {
        localt = (t)this.npe.getFirst();
        b(localt, localm);
        a(localm, localt, bx.nuK, arrayOfh[0]);
        AppMethodBeat.o(219412);
        return true;
      }
    }
    AppMethodBeat.o(219412);
    return false;
  }
  
  private m adI(String paramString)
  {
    AppMethodBeat.i(219414);
    synchronized (this.npd)
    {
      t localt = (t)this.npe.peekFirst();
      if (((localt instanceof m)) && (localt.dw(paramString)))
      {
        paramString = (m)localt;
        AppMethodBeat.o(219414);
        return paramString;
      }
      AppMethodBeat.o(219414);
      return null;
    }
  }
  
  private m adJ(String paramString)
  {
    AppMethodBeat.i(219415);
    synchronized (this.npd)
    {
      if (this.npe.size() < 2)
      {
        AppMethodBeat.o(219415);
        return null;
      }
      ListIterator localListIterator = this.npe.listIterator(1);
      while (localListIterator.hasNext())
      {
        t localt = (t)localListIterator.next();
        if (((localt instanceof m)) && (localt.dw(paramString)))
        {
          paramString = (m)localt;
          AppMethodBeat.o(219415);
          return paramString;
        }
      }
      AppMethodBeat.o(219415);
      return null;
    }
  }
  
  private Object b(t paramt, Runnable paramRunnable)
  {
    AppMethodBeat.i(219419);
    paramt = a(paramt, p(paramt), paramRunnable);
    AppMethodBeat.o(219419);
    return paramt;
  }
  
  private void b(t paramt1, t paramt2)
  {
    AppMethodBeat.i(135071);
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.npd)
    {
      Iterator localIterator = this.npe.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        t localt = (t)localIterator.next();
        if (localt == paramt1) {
          i = 1;
        } else if (localt != paramt2) {
          if (i != 0)
          {
            localLinkedList.add(localt);
            localIterator.remove();
            this.npf.remove(localt);
          }
        }
      }
    }
    paramt1 = localLinkedList.iterator();
    while (paramt1.hasNext())
    {
      paramt2 = (t)paramt1.next();
      q(paramt2);
      j(paramt2);
    }
    AppMethodBeat.o(135071);
  }
  
  private boolean b(String paramString, bx parambx)
  {
    AppMethodBeat.i(135069);
    if (parambx == bx.nuK)
    {
      AppMethodBeat.o(135069);
      return true;
    }
    if ((parambx == bx.nuI) || (parambx == bx.nuJ))
    {
      boolean bool = this.kEc.getAppConfig().bzG().WX(paramString);
      AppMethodBeat.o(135069);
      return bool;
    }
    for (;;)
    {
      synchronized (this.npd)
      {
        if (parambx == bx.nuG) {
          break label169;
        }
        if (parambx == bx.nuH)
        {
          break label169;
          int j = this.npe.size();
          if (i != 0)
          {
            i = 1;
            if ((!this.kEc.getAppConfig().bzG().WX(paramString)) || (j + 1 - i != 1)) {
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
  
  private void bQS()
  {
    AppMethodBeat.i(176593);
    synchronized (this.npd)
    {
      Object localObject2 = new LinkedList(this.npg);
      this.npg.clear();
      ??? = ((LinkedList)localObject2).descendingIterator();
      if (((Iterator)???).hasNext())
      {
        localObject2 = (c)((Iterator)???).next();
        ((c)localObject2).ig(true);
        ((c)localObject2).run();
        ((Iterator)???).remove();
      }
    }
    AppMethodBeat.o(176593);
  }
  
  private ac bQU()
  {
    AppMethodBeat.i(135083);
    if (this.npa != null)
    {
      ac localac = this.npa.a(this);
      if (localac != null)
      {
        AppMethodBeat.o(135083);
        return localac;
      }
    }
    AppMethodBeat.o(135083);
    return null;
  }
  
  private int getActualPageStackSize()
  {
    AppMethodBeat.i(176586);
    synchronized (this.npd)
    {
      int i = this.npe.size();
      AppMethodBeat.o(176586);
      return i;
    }
  }
  
  private ac hL(int paramInt)
  {
    AppMethodBeat.i(219406);
    Object localObject1 = new LinkedList();
    synchronized (this.npd)
    {
      ((LinkedList)localObject1).addAll(this.npf);
      ((LinkedList)localObject1).addAll(this.npe);
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (t)((Iterator)localObject1).next();
        if (localObject3 != null)
        {
          localObject3 = ((t)localObject3).hL(paramInt);
          if (localObject3 != null)
          {
            AppMethodBeat.o(219406);
            return localObject3;
          }
        }
      }
      AppMethodBeat.o(219406);
      return null;
    }
  }
  
  private void j(t paramt)
  {
    AppMethodBeat.i(135076);
    if (this.npo != null) {
      this.npo.r(paramt);
    }
    paramt.setVisibility(8);
    paramt.bQO();
    if (!paramt.noQ) {
      paramt.performDestroy();
    }
    removeView(paramt);
    if (!paramt.noQ) {
      paramt.NR();
    }
    AppMethodBeat.o(135076);
  }
  
  private static void q(t paramt)
  {
    AppMethodBeat.i(135094);
    paramt.clearAnimation();
    paramt = paramt.getTag(noX);
    if ((paramt instanceof Animator))
    {
      paramt = (Animator)paramt;
      paramt.cancel();
      paramt.removeAllListeners();
      AppMethodBeat.o(135094);
      return;
    }
    if ((paramt instanceof Animation))
    {
      paramt = (Animation)paramt;
      paramt.setAnimationListener(null);
      paramt.cancel();
    }
    AppMethodBeat.o(135094);
  }
  
  protected h a(t paramt1, t paramt2)
  {
    AppMethodBeat.i(176591);
    Objects.requireNonNull(paramt2);
    Object localObject2 = getAppId();
    if (paramt1 == null) {}
    for (Object localObject1 = null;; localObject1 = l.dM(paramt1.getCurrentUrl()))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "onNavigateBack, appId[%s] out[%s], in[%s], mActuallyVisible[%b]", new Object[] { localObject2, localObject1, l.dM(paramt2.getCurrentUrl()), Boolean.valueOf(this.noY) });
      if (this.noY) {
        paramt2.getCurrentPageView().bRp();
      }
      if (paramt1 != null) {
        paramt1.hideVKB();
      }
      getRuntime().kAx.a(paramt2.getCurrentPageView(), bx.nuF);
      j(paramt2.getCurrentPageView());
      localObject2 = this.npp;
      localObject1 = localObject2;
      if (this.npr != null)
      {
        localObject1 = localObject2;
        if (!this.npq)
        {
          localObject1 = this.npr.b(bx.nuF, paramt1, paramt2);
          this.npq = true;
        }
      }
      AppMethodBeat.o(176591);
      return localObject1;
    }
  }
  
  public h a(t paramt1, t paramt2, bx parambx, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(219410);
    String str = getAppId();
    if (paramt1 == null) {}
    for (Object localObject = null;; localObject = l.dM(paramt1.getCurrentUrl()))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "onNavigateStart, appId[%s] out[%s], in[%s], mActuallyVisible[%b], type[%s]", new Object[] { str, localObject, l.dM(paramString), Boolean.valueOf(this.noY), parambx });
      if (paramt1 != null) {
        paramt1.hideVKB();
      }
      localObject = this.npp;
      paramString = (String)localObject;
      if (this.npr != null)
      {
        paramString = (String)localObject;
        if (!this.npq)
        {
          paramString = this.npr.b(parambx, paramt1, paramt2);
          this.npq = true;
        }
      }
      if (bx.nuD == parambx)
      {
        getRuntime().kAx.a(paramt2.getCurrentPageView(), parambx);
        j(paramt2.getCurrentPageView());
      }
      if ((paramt1 != null) && (paramt1.getCurrentPageView() != null) && (paramt1.getCurrentPageView().getFullscreenImpl() != null) && (paramt1.getCurrentPageView().getFullscreenImpl().bTK())) {
        paramt1.getCurrentPageView().getFullscreenImpl().btC();
      }
      AppMethodBeat.o(219410);
      return paramString;
    }
  }
  
  public final void a(final int paramInt, final String paramString, final f paramf)
  {
    AppMethodBeat.i(219407);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135024);
        w.a(w.this, paramInt, paramString, paramf);
        AppMethodBeat.o(135024);
      }
    });
    AppMethodBeat.o(219407);
  }
  
  public final void a(i parami, com.tencent.mm.plugin.appbrand.page.b.e parame)
  {
    AppMethodBeat.i(219404);
    if (parami == null)
    {
      AppMethodBeat.o(219404);
      return;
    }
    synchronized (this.npc)
    {
      this.npc.put(parami, parame);
      AppMethodBeat.o(219404);
      return;
    }
  }
  
  public void a(t paramt1, t paramt2, bx parambx)
  {
    AppMethodBeat.i(135067);
    String str = getAppId();
    if (paramt1 == null) {}
    for (paramt1 = null;; paramt1 = l.dM(paramt1.getCurrentUrl()))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "onNavigateEnd, appId[%s] out[%s], in[%s], mActuallyVisible[%b], type[%s]", new Object[] { str, paramt1, l.dM(paramt2.getCurrentUrl()), Boolean.valueOf(this.noY), parambx });
      if (this.noY) {
        paramt2.getCurrentPageView().bRp();
      }
      if (bx.nuD != parambx) {
        getRuntime().kAx.a(paramt2.getCurrentPageView(), parambx);
      }
      if (e(paramt2)) {
        paramt2.getCurrentPageView().bRD();
      }
      j(paramt2.getCurrentPageView());
      AppMethodBeat.o(135067);
      return;
    }
  }
  
  public final void a(final t paramt, final String paramString)
  {
    AppMethodBeat.i(176589);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176564);
        int i = w.this.l(paramt);
        if (i < 0)
        {
          com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandPageContainer", "navigateBack with appId(%s) Page(%s), but already off stack, maybe frequent clicks were performed", new Object[] { w.this.getAppId(), paramt.getCurrentUrl() });
          AppMethodBeat.o(176564);
          return;
        }
        w.a(w.this, i + 1, paramString, null);
        AppMethodBeat.o(176564);
      }
    });
    AppMethodBeat.o(176589);
  }
  
  public final void adC(final String paramString)
  {
    AppMethodBeat.i(135056);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135042);
        w.a(w.this, paramString, bx.nuE);
        AppMethodBeat.o(135042);
      }
    });
    AppMethodBeat.o(135056);
  }
  
  public final void adD(final String paramString)
  {
    AppMethodBeat.i(135058);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135044);
        w.a(w.this, paramString, bx.nuG);
        AppMethodBeat.o(135044);
      }
    });
    AppMethodBeat.o(135058);
  }
  
  public final void adE(final String paramString)
  {
    AppMethodBeat.i(135059);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219400);
        w.a(w.this, paramString, bx.nuK);
        AppMethodBeat.o(219400);
      }
    });
    AppMethodBeat.o(135059);
  }
  
  public final void adF(final String paramString)
  {
    AppMethodBeat.i(176587);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135047);
        w.this.adG(paramString);
        AppMethodBeat.o(135047);
      }
    });
    AppMethodBeat.o(176587);
  }
  
  public final void adG(String paramString)
  {
    AppMethodBeat.i(219408);
    a(1, paramString, null);
    AppMethodBeat.o(219408);
  }
  
  public final void adK(final String paramString)
  {
    AppMethodBeat.i(219417);
    if (!MMHandlerThread.isMainThread())
    {
      getRuntime().i(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(219389);
          w.this.adK(paramString);
          AppMethodBeat.o(219389);
        }
      }, 0L);
      AppMethodBeat.o(219417);
      return;
    }
    if (this.mDestroyed)
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandPageContainer", "preloadNext, destroyed, appId:%s, reason:%s", new Object[] { getAppId(), paramString });
      AppMethodBeat.o(219417);
      return;
    }
    if (!this.noY)
    {
      this.noZ = true;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "preloadNext, deferred, appId:%s, reason:%s", new Object[] { getAppId(), paramString });
      AppMethodBeat.o(219417);
      return;
    }
    this.noZ = false;
    if ((this.npa != null) && (this.npa.MX()))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "preloadNext, intercepted, appId:%s, reason:%s", new Object[] { getAppId(), paramString });
      AppMethodBeat.o(219417);
      return;
    }
    if (this.nph != null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "preloadNext, already preloaded, appId:%s, reason:%s", new Object[] { getAppId(), paramString });
      AppMethodBeat.o(219417);
      return;
    }
    long l = System.currentTimeMillis();
    ac localac2 = bQU();
    ac localac1 = localac2;
    if (localac2 == null) {
      localac1 = new ac();
    }
    localac1.npk = getDecorWidgetFactory();
    localac1.a(getContext(), this.kEc);
    localac1.hide();
    addView(localac1.getContentView(), 0);
    this.nph = localac1;
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "preloadNextPageView: appId:%s, cost:%d, reason:%s", new Object[] { getAppId(), Long.valueOf(System.currentTimeMillis() - l), paramString });
    AppMethodBeat.o(219417);
  }
  
  public final boolean ar(int paramInt, String paramString)
  {
    AppMethodBeat.i(219405);
    ac localac2;
    ac localac1;
    if (paramInt == 0)
    {
      if (getCurrentPage() != null)
      {
        localac2 = getCurrentPage().getCurrentPageView();
        localac1 = localac2;
        if (localac2 != null) {}
      }
      else
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandPageContainer", "rewriteRoute invalid page appId:%s, url:%s", new Object[] { getAppId(), paramString });
        AppMethodBeat.o(219405);
        return false;
      }
    }
    else
    {
      localac2 = hL(paramInt);
      localac1 = localac2;
      if (localac2 == null)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandPageContainer", "rewriteRoute invalid page appId:%s, webviewId:%d, url:%s", new Object[] { getAppId(), Integer.valueOf(paramInt), paramString });
        AppMethodBeat.o(219405);
        return false;
      }
    }
    boolean bool = localac1.adL(paramString);
    AppMethodBeat.o(219405);
    return bool;
  }
  
  public final void ax(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(135057);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135043);
        w localw = w.this;
        String str = paramString;
        if (paramBoolean) {}
        for (bx localbx = bx.nuJ;; localbx = bx.nuI)
        {
          w.a(localw, str, localbx);
          AppMethodBeat.o(135043);
          return;
        }
      }
    });
    AppMethodBeat.o(135057);
  }
  
  public final void b(final t paramt, final String paramString)
  {
    AppMethodBeat.i(176590);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176565);
        int i = w.this.l(paramt);
        w.a(w.this, i, paramString, null);
        AppMethodBeat.o(176565);
      }
    });
    AppMethodBeat.o(176590);
  }
  
  public final Iterator<t> bQQ()
  {
    AppMethodBeat.i(135054);
    Iterator local12 = new Iterator()
    {
      final ListIterator<t> npC;
      
      public final boolean hasNext()
      {
        AppMethodBeat.i(219383);
        boolean bool = this.npC.hasNext();
        AppMethodBeat.o(219383);
        return bool;
      }
      
      public final void remove()
      {
        AppMethodBeat.i(219384);
        UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(219384);
        throw localUnsupportedOperationException;
      }
    };
    AppMethodBeat.o(135054);
    return local12;
  }
  
  public final void bQR()
  {
    AppMethodBeat.i(135060);
    ax(this.kEc.getAppConfig().bzI(), true);
    AppMethodBeat.o(135060);
  }
  
  public final ac bQT()
  {
    AppMethodBeat.i(135082);
    if (!this.npi) {}
    for (int i = 1;; i = 0)
    {
      this.npi = true;
      if (this.nph != null) {
        break;
      }
      localObject2 = bQU();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ac();
      }
      if (i != 0) {
        ((ac)localObject1).nqW = true;
      }
      ((ac)localObject1).npk = getDecorWidgetFactory();
      ((ac)localObject1).a(getContext(), this.kEc);
      AppMethodBeat.o(135082);
      return localObject1;
    }
    Object localObject1 = this.nph;
    this.nph = null;
    if (i != 0) {
      ((ac)localObject1).nqW = true;
    }
    Object localObject2 = ((d)localObject1).getContentView();
    if (localObject2 != null) {
      ((View)localObject2).setVisibility(0);
    }
    removeView(((ac)localObject1).getContentView());
    AppMethodBeat.o(135082);
    return localObject1;
  }
  
  protected final void bQV()
  {
    AppMethodBeat.i(135089);
    if (this.kEc == null)
    {
      AppMethodBeat.o(135089);
      return;
    }
    if (this.npm)
    {
      if (this.npn != null) {
        this.npn.brP();
      }
      onReady();
      this.npm = false;
    }
    AppMethodBeat.o(135089);
  }
  
  public final boolean bQW()
  {
    AppMethodBeat.i(219420);
    if ((getActualPageStackSize() > 1) || (getRuntime().kAN))
    {
      AppMethodBeat.o(219420);
      return true;
    }
    AppMethodBeat.o(219420);
    return false;
  }
  
  public final void c(final String paramString1, final String paramString2, final int[] paramArrayOfInt)
  {
    AppMethodBeat.i(135077);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219387);
        w.a(w.this, paramString1, paramString2, paramArrayOfInt);
        AppMethodBeat.o(219387);
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
    synchronized (this.npe)
    {
      localLinkedList.addAll(this.npe);
      localLinkedList.addAll(this.npf);
      this.npe.clear();
      this.npf.clear();
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext())
      {
        t localt = (t)((Iterator)???).next();
        localt.bQO();
        localt.performDestroy();
        localt.NR();
        q(localt);
      }
    }
    localObject1.clear();
    if (this.nph != null) {}
    try
    {
      this.nph.onDestroy();
      try
      {
        label136:
        this.nph.cleanup();
        label143:
        removeAllViews();
        this.npn = null;
        this.kEc = null;
        this.npo = null;
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
  
  public final boolean d(String paramString, Runnable paramRunnable)
  {
    AppMethodBeat.i(219409);
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
    AppMethodBeat.o(219409);
    return bool1;
  }
  
  protected boolean e(t paramt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(219411);
    String str = paramt.getCurrentUrl();
    int j;
    label46:
    int k;
    label59:
    int m;
    label75:
    int n;
    label85:
    int i;
    if (getPageCount() == 1)
    {
      bool1 = true;
      if (str.startsWith(getRuntime().getAppConfig().bzI())) {
        break label173;
      }
      j = 1;
      if (paramt.getCurrentPageView().bRi() == null) {
        break label179;
      }
      k = 1;
      if (paramt.getCurrentPageView().bRi().isFullscreenMode()) {
        break label185;
      }
      m = 1;
      if ((paramt instanceof m)) {
        break label191;
      }
      n = 1;
      i = 0;
      label87:
      if (i >= 5) {
        break label204;
      }
      if (new boolean[] { bool1, j, k, m, n }[i] != 0) {
        break label197;
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "[%s,%s]->shouldShowActionBarHomeButton: test fail cause #[%d] condition,", new Object[] { paramt.getAppId(), paramt.getCurrentUrl(), Integer.valueOf(i) });
    }
    label173:
    label179:
    label185:
    label191:
    label197:
    label204:
    for (boolean bool1 = bool2;; bool1 = true)
    {
      AppMethodBeat.o(219411);
      return bool1;
      bool1 = false;
      break;
      j = 0;
      break label46;
      k = 0;
      break label59;
      m = 0;
      break label75;
      n = 0;
      break label85;
      i += 1;
      break label87;
    }
  }
  
  public final com.tencent.mm.plugin.appbrand.config.b getAppConfig()
  {
    AppMethodBeat.i(135086);
    com.tencent.mm.plugin.appbrand.config.b localb = this.kEc.getAppConfig();
    AppMethodBeat.o(135086);
    return localb;
  }
  
  public String getAppId()
  {
    return this.mAppId;
  }
  
  /* Error */
  public t getCurrentPage()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: iconst_1
    //   3: istore_3
    //   4: iconst_1
    //   5: istore_1
    //   6: ldc_w 1090
    //   9: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: aload_0
    //   13: getfield 176	com/tencent/mm/plugin/appbrand/page/w:npd	[B
    //   16: astore 4
    //   18: aload 4
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 183	com/tencent/mm/plugin/appbrand/page/w:npf	Ljava/util/LinkedList;
    //   25: invokevirtual 1093	java/util/LinkedList:isEmpty	()Z
    //   28: ifne +126 -> 154
    //   31: aload_0
    //   32: getfield 183	com/tencent/mm/plugin/appbrand/page/w:npf	Ljava/util/LinkedList;
    //   35: invokevirtual 716	java/util/LinkedList:getFirst	()Ljava/lang/Object;
    //   38: checkcast 257	com/tencent/mm/plugin/appbrand/page/t
    //   41: astore 5
    //   43: aload_0
    //   44: getfield 219	com/tencent/mm/plugin/appbrand/page/w:kEc	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   47: ifnull +90 -> 137
    //   50: aload_0
    //   51: getfield 219	com/tencent/mm/plugin/appbrand/page/w:kEc	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   54: invokevirtual 1096	com/tencent/mm/plugin/appbrand/AppBrandRuntime:bry	()Z
    //   57: ifeq +92 -> 149
    //   60: aload_0
    //   61: getfield 219	com/tencent/mm/plugin/appbrand/page/w:kEc	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   64: getfield 1099	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mInitialized	Z
    //   67: ifne +82 -> 149
    //   70: aload 5
    //   72: ifnonnull +65 -> 137
    //   75: iload_1
    //   76: ifne +61 -> 137
    //   79: ldc 204
    //   81: ldc_w 1101
    //   84: iconst_4
    //   85: anewarray 208	java/lang/Object
    //   88: dup
    //   89: iconst_0
    //   90: aload_0
    //   91: invokevirtual 626	com/tencent/mm/plugin/appbrand/page/w:getAppId	()Ljava/lang/String;
    //   94: aastore
    //   95: dup
    //   96: iconst_1
    //   97: aload_0
    //   98: getfield 183	com/tencent/mm/plugin/appbrand/page/w:npf	Ljava/util/LinkedList;
    //   101: invokevirtual 549	java/util/LinkedList:size	()I
    //   104: invokestatic 559	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: aastore
    //   108: dup
    //   109: iconst_2
    //   110: aload_0
    //   111: getfield 181	com/tencent/mm/plugin/appbrand/page/w:npe	Ljava/util/LinkedList;
    //   114: invokevirtual 549	java/util/LinkedList:size	()I
    //   117: invokestatic 559	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   120: aastore
    //   121: dup
    //   122: iconst_3
    //   123: new 580	java/lang/Throwable
    //   126: dup
    //   127: invokespecial 581	java/lang/Throwable:<init>	()V
    //   130: invokestatic 1107	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   133: aastore
    //   134: invokestatic 490	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: aload 4
    //   139: monitorexit
    //   140: ldc_w 1090
    //   143: invokestatic 228	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aload 5
    //   148: areturn
    //   149: iconst_0
    //   150: istore_1
    //   151: goto -81 -> 70
    //   154: aload_0
    //   155: getfield 181	com/tencent/mm/plugin/appbrand/page/w:npe	Ljava/util/LinkedList;
    //   158: invokevirtual 599	java/util/LinkedList:peekFirst	()Ljava/lang/Object;
    //   161: checkcast 257	com/tencent/mm/plugin/appbrand/page/t
    //   164: astore 5
    //   166: aload_0
    //   167: getfield 219	com/tencent/mm/plugin/appbrand/page/w:kEc	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   170: ifnull +92 -> 262
    //   173: aload_0
    //   174: getfield 219	com/tencent/mm/plugin/appbrand/page/w:kEc	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   177: invokevirtual 1096	com/tencent/mm/plugin/appbrand/AppBrandRuntime:bry	()Z
    //   180: ifeq +94 -> 274
    //   183: aload_0
    //   184: getfield 219	com/tencent/mm/plugin/appbrand/page/w:kEc	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   187: getfield 1099	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mInitialized	Z
    //   190: ifne +84 -> 274
    //   193: iload_2
    //   194: istore_1
    //   195: aload 5
    //   197: ifnonnull +65 -> 262
    //   200: iload_1
    //   201: ifne +61 -> 262
    //   204: ldc 204
    //   206: ldc_w 1101
    //   209: iconst_4
    //   210: anewarray 208	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: aload_0
    //   216: invokevirtual 626	com/tencent/mm/plugin/appbrand/page/w:getAppId	()Ljava/lang/String;
    //   219: aastore
    //   220: dup
    //   221: iconst_1
    //   222: aload_0
    //   223: getfield 183	com/tencent/mm/plugin/appbrand/page/w:npf	Ljava/util/LinkedList;
    //   226: invokevirtual 549	java/util/LinkedList:size	()I
    //   229: invokestatic 559	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   232: aastore
    //   233: dup
    //   234: iconst_2
    //   235: aload_0
    //   236: getfield 181	com/tencent/mm/plugin/appbrand/page/w:npe	Ljava/util/LinkedList;
    //   239: invokevirtual 549	java/util/LinkedList:size	()I
    //   242: invokestatic 559	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   245: aastore
    //   246: dup
    //   247: iconst_3
    //   248: new 580	java/lang/Throwable
    //   251: dup
    //   252: invokespecial 581	java/lang/Throwable:<init>	()V
    //   255: invokestatic 1107	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   258: aastore
    //   259: invokestatic 490	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   262: aload 4
    //   264: monitorexit
    //   265: ldc_w 1090
    //   268: invokestatic 228	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   271: aload 5
    //   273: areturn
    //   274: iconst_0
    //   275: istore_1
    //   276: goto -81 -> 195
    //   279: astore 5
    //   281: aload_0
    //   282: getfield 219	com/tencent/mm/plugin/appbrand/page/w:kEc	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   285: ifnull +91 -> 376
    //   288: aload_0
    //   289: getfield 219	com/tencent/mm/plugin/appbrand/page/w:kEc	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   292: invokevirtual 1096	com/tencent/mm/plugin/appbrand/AppBrandRuntime:bry	()Z
    //   295: ifeq +104 -> 399
    //   298: aload_0
    //   299: getfield 219	com/tencent/mm/plugin/appbrand/page/w:kEc	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   302: getfield 1099	com/tencent/mm/plugin/appbrand/AppBrandRuntime:mInitialized	Z
    //   305: ifne +94 -> 399
    //   308: iload_3
    //   309: istore_1
    //   310: iconst_0
    //   311: ifne +65 -> 376
    //   314: iload_1
    //   315: ifne +61 -> 376
    //   318: ldc 204
    //   320: ldc_w 1101
    //   323: iconst_4
    //   324: anewarray 208	java/lang/Object
    //   327: dup
    //   328: iconst_0
    //   329: aload_0
    //   330: invokevirtual 626	com/tencent/mm/plugin/appbrand/page/w:getAppId	()Ljava/lang/String;
    //   333: aastore
    //   334: dup
    //   335: iconst_1
    //   336: aload_0
    //   337: getfield 183	com/tencent/mm/plugin/appbrand/page/w:npf	Ljava/util/LinkedList;
    //   340: invokevirtual 549	java/util/LinkedList:size	()I
    //   343: invokestatic 559	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   346: aastore
    //   347: dup
    //   348: iconst_2
    //   349: aload_0
    //   350: getfield 181	com/tencent/mm/plugin/appbrand/page/w:npe	Ljava/util/LinkedList;
    //   353: invokevirtual 549	java/util/LinkedList:size	()I
    //   356: invokestatic 559	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   359: aastore
    //   360: dup
    //   361: iconst_3
    //   362: new 580	java/lang/Throwable
    //   365: dup
    //   366: invokespecial 581	java/lang/Throwable:<init>	()V
    //   369: invokestatic 1107	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   372: aastore
    //   373: invokestatic 490	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   376: ldc_w 1090
    //   379: invokestatic 228	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   382: aload 5
    //   384: athrow
    //   385: astore 5
    //   387: aload 4
    //   389: monitorexit
    //   390: ldc_w 1090
    //   393: invokestatic 228	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   396: aload 5
    //   398: athrow
    //   399: iconst_0
    //   400: istore_1
    //   401: goto -91 -> 310
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	404	0	this	w
    //   5	396	1	i	int
    //   1	193	2	j	int
    //   3	306	3	k	int
    //   16	372	4	arrayOfByte	byte[]
    //   41	231	5	localt	t
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
      localObject = ((t)localObject).getCurrentUrl();
      AppMethodBeat.o(135080);
      return localObject;
    }
    AppMethodBeat.o(135080);
    return null;
  }
  
  public bw getDecorWidgetFactory()
  {
    return this.npk;
  }
  
  public List<com.tencent.mm.plugin.appbrand.page.b.e> getNavigateBackInterceptorChain()
  {
    AppMethodBeat.i(219403);
    synchronized (this.npc)
    {
      if ((this.npc.size() == 0) || (getCurrentPage() == null))
      {
        AppMethodBeat.o(219403);
        return null;
      }
      ArrayList localArrayList = new ArrayList(this.npc.values());
      Collections.sort(localArrayList, new Comparator() {});
      AppMethodBeat.o(219403);
      return localArrayList;
    }
  }
  
  public final int getPageCount()
  {
    AppMethodBeat.i(135053);
    synchronized (this.npd)
    {
      int i = this.npe.size();
      int j = this.npf.size();
      AppMethodBeat.o(135053);
      return i + j;
    }
  }
  
  public final ac getPageView()
  {
    AppMethodBeat.i(135084);
    if (this.mDestroyed)
    {
      AppMethodBeat.o(135084);
      return null;
    }
    boolean bool = this.kEc.kAU;
    Object localObject = getCurrentPage();
    if (localObject == null)
    {
      if (bool) {
        Assert.fail("getPageView() assert by NULL page, appId=" + getAppId());
      }
      AppMethodBeat.o(135084);
      return null;
    }
    localObject = ((t)localObject).getCurrentPageView();
    if ((localObject == null) && (bool)) {
      Assert.fail("getPageView() assert by NULL pv, appId=" + getAppId());
    }
    AppMethodBeat.o(135084);
    return localObject;
  }
  
  ac getPreloadedPageView()
  {
    return this.nph;
  }
  
  public AppBrandRuntime getRuntime()
  {
    return this.kEc;
  }
  
  public final void i(final ac paramac)
  {
    AppMethodBeat.i(219416);
    if (!MMHandlerThread.isMainThread())
    {
      getRuntime().i(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(219388);
          w.this.i(paramac);
          AppMethodBeat.o(219388);
        }
      }, 0L);
      AppMethodBeat.o(219416);
      return;
    }
    this.npl.u(paramac);
    AppMethodBeat.o(219416);
  }
  
  public void init(final String paramString)
  {
    AppMethodBeat.i(135055);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135041);
        w.a(w.this, paramString, bx.nuD);
        AppMethodBeat.o(135041);
      }
    });
    AppMethodBeat.o(135055);
  }
  
  public final void j(final ac paramac)
  {
    AppMethodBeat.i(219421);
    getRuntime().kAT.setFullscreenImpl(paramac.getFullscreenImpl());
    getRuntime().kAT.a(new bd()
    {
      public final void a(AppBrandPageFullScreenView paramAnonymousAppBrandPageFullScreenView)
      {
        AppMethodBeat.i(219399);
        paramac.nqU.a(paramac, paramAnonymousAppBrandPageFullScreenView);
        AppMethodBeat.o(219399);
      }
    });
    AppMethodBeat.o(219421);
  }
  
  public final t k(t paramt)
  {
    AppMethodBeat.i(135079);
    synchronized (this.npd)
    {
      if (this.npf.contains(paramt))
      {
        paramt = (t)this.npe.peekFirst();
        AppMethodBeat.o(135079);
        return paramt;
      }
      int i = this.npe.indexOf(paramt);
      if (i >= this.npe.size() - 1)
      {
        AppMethodBeat.o(135079);
        return null;
      }
      paramt = (t)this.npe.get(i + 1);
      AppMethodBeat.o(135079);
      return paramt;
    }
  }
  
  final int l(t paramt)
  {
    AppMethodBeat.i(176597);
    synchronized (this.npd)
    {
      int i = this.npe.indexOf(paramt);
      AppMethodBeat.o(176597);
      return i;
    }
  }
  
  public Object m(t paramt)
  {
    AppMethodBeat.i(135090);
    paramt = ObjectAnimator.ofFloat(paramt, "translationX", new float[] { paramt.getWidth(), 0.0F });
    paramt.setDuration(250L);
    AppMethodBeat.o(135090);
    return paramt;
  }
  
  public Object n(t paramt)
  {
    AppMethodBeat.i(135091);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramt, "translationX", new float[] { 0.0F, -(paramt.getWidth() * 0.25F) });
    localObjectAnimator.setDuration(250L);
    paramt = ObjectAnimator.ofFloat(paramt, "translationX", new float[] { 0.0F });
    paramt.setDuration(0L);
    new AnimatorSet().playSequentially(new Animator[] { localObjectAnimator, paramt });
    AppMethodBeat.o(135091);
    return localObjectAnimator;
  }
  
  public Object o(t paramt)
  {
    AppMethodBeat.i(135092);
    paramt = ObjectAnimator.ofFloat(paramt, "translationX", new float[] { -(paramt.getWidth() * 0.25F), 0.0F });
    paramt.setDuration(250L);
    AppMethodBeat.o(135092);
    return paramt;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(135096);
    t localt = getCurrentPage();
    if (localt == null)
    {
      AppMethodBeat.o(135096);
      return;
    }
    if (localt.getCurrentPageView().onBackPressed())
    {
      AppMethodBeat.o(135096);
      return;
    }
    synchronized (this.npd)
    {
      int i;
      if (!this.npf.isEmpty())
      {
        i = 1;
        if ((i != 0) || (localt.getTag(noX) != null))
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
    adF("scene_back_key_pressed");
    AppMethodBeat.o(135096);
  }
  
  public void onBackground()
  {
    AppMethodBeat.i(135088);
    synchronized (this.npd)
    {
      t localt = (t)this.npe.peekFirst();
      if (localt == null)
      {
        AppMethodBeat.o(135088);
        return;
      }
    }
    localObject.bQO();
    AppMethodBeat.o(135088);
  }
  
  protected void onDestroy() {}
  
  public void onForeground()
  {
    AppMethodBeat.i(135087);
    synchronized (this.npd)
    {
      t localt = (t)this.npe.peekFirst();
      if (localt == null)
      {
        AppMethodBeat.o(135087);
        return;
      }
    }
    localObject.bQN();
    if (this.noY)
    {
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandPageContainer", "onForeground, call onUserVisible, appId[%s] url[%s]", new Object[] { getAppId(), localObject.getCurrentPageView().lBI });
      localObject.getCurrentPageView().bRp();
    }
    AppMethodBeat.o(135087);
  }
  
  protected void onReady() {}
  
  public Object p(t paramt)
  {
    AppMethodBeat.i(135093);
    paramt = ObjectAnimator.ofFloat(paramt, "translationX", new float[] { 0.0F, paramt.getWidth() });
    paramt.setDuration(250L);
    AppMethodBeat.o(135093);
    return paramt;
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
    if (this.kEc == null)
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandPageContainer", "runOnUiThread but mRuntime==NULL, appId:%s, stack:%s", new Object[] { getAppId(), android.util.Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(135052);
      return;
    }
    this.kEc.i(paramRunnable, 0L);
    AppMethodBeat.o(135052);
  }
  
  public void setActuallyVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(135051);
    if (this.noY != paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.noY = paramBoolean;
      if ((paramBoolean) && (i != 0))
      {
        getCurrentPage().getCurrentPageView().bRp();
        super.setVisibility(0);
        if (this.noZ) {
          adK("setActuallyVisible");
        }
      }
      if ((!paramBoolean) && (i != 0)) {
        super.setVisibility(4);
      }
      AppMethodBeat.o(135051);
      return;
    }
  }
  
  public void setDecorWidgetFactory(bw parambw)
  {
    AppMethodBeat.i(135049);
    if (parambw == null)
    {
      parambw = new NullPointerException("Should not be null");
      AppMethodBeat.o(135049);
      throw parambw;
    }
    this.npk = parambw;
    AppMethodBeat.o(135049);
  }
  
  public final void setDelegate(a parama)
  {
    AppMethodBeat.i(135050);
    if (this.npa != null)
    {
      parama = new IllegalAccessError("Duplicated call!!!");
      AppMethodBeat.o(135050);
      throw parama;
    }
    a locala = parama;
    if (this.npb != null) {
      locala = this.npb.a(parama);
    }
    this.npa = locala;
    AppMethodBeat.o(135050);
  }
  
  public void setDelegateWrapperFactory(b paramb)
  {
    AppMethodBeat.i(176584);
    this.npb = paramb;
    if (this.npa != null) {
      this.npa = paramb.a(this.npa);
    }
    AppMethodBeat.o(176584);
  }
  
  public void setOnPageSwitchListener(e parame)
  {
    AppMethodBeat.i(176601);
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandPageContainer", "setOnPageSwitchListener, onPageSwitchListener: ".concat(String.valueOf(parame)));
    this.npr = parame;
    AppMethodBeat.o(176601);
  }
  
  public void setOnReadyListener(f paramf)
  {
    this.npn = paramf;
  }
  
  public void setPipPageLifeCycleListener(i parami)
  {
    this.npo = parami;
  }
  
  public void setPipVideoRelatedPage(t paramt)
  {
    AppMethodBeat.i(219402);
    if (paramt != null) {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "setPipVideoRelatedPage, page(%s)", new Object[] { paramt.getCurrentUrl() });
    }
    for (;;)
    {
      this.npj = paramt;
      AppMethodBeat.o(219402);
      return;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPageContainer", "setPipVideoRelatedPage, page is null");
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean MX();
    
    public abstract ac a(w paramw);
    
    public abstract t a(String paramString, bx parambx, w paramw, Callable<t> paramCallable);
    
    public abstract boolean a(String paramString, bx parambx, w paramw, w.d paramd);
  }
  
  public static abstract interface b
  {
    public abstract w.a a(w.a parama);
  }
  
  static abstract interface c
    extends Runnable
  {
    public abstract void ig(boolean paramBoolean);
  }
  
  public static abstract interface d
  {
    public abstract void bQX();
    
    public abstract void cancel();
    
    public abstract void proceed();
  }
  
  public static abstract interface e
  {
    public abstract void aQ(float paramFloat);
    
    public abstract w.h b(bx parambx, t paramt1, t paramt2);
    
    public abstract void c(bx parambx, t paramt1, t paramt2);
    
    public abstract void d(bx parambx, t paramt1, t paramt2);
  }
  
  public static abstract interface f
  {
    public abstract void brP();
  }
  
  public static enum h
  {
    public final String name;
    
    static
    {
      AppMethodBeat.i(176583);
      npV = new h("MIN", 0, "min");
      npW = new h("MAX", 1, "max");
      npX = new h[] { npV, npW };
      AppMethodBeat.o(176583);
    }
    
    private h(String paramString)
    {
      this.name = paramString;
    }
  }
  
  public static abstract interface i
  {
    public abstract void r(t paramt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.w
 * JD-Core Version:    0.7.0.1
 */