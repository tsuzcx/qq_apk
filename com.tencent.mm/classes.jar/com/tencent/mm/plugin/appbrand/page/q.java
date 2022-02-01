package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.luggage.h.f;
import com.tencent.luggage.h.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.al;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.page.c.e;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.SwipeBackLayout.a;
import me.imid.swipebacklayout.lib.b;
import org.json.JSONObject;

public abstract class q
  extends SwipeBackLayout
{
  private t iDz;
  private boolean kYM = true;
  private boolean kYN = false;
  private e kYO = new e(false, "");
  private final Set<Runnable> kYP = new HashSet();
  private int kYQ;
  private int kYR;
  final boolean[] kYS = { false };
  private final SwipeBackLayout.a kYT = new me.imid.swipebacklayout.lib.a()
  {
    private int kYW = -1;
    
    public final int bq(boolean paramAnonymousBoolean)
    {
      return 1;
    }
    
    public final void h(int paramAnonymousInt, float paramAnonymousFloat)
    {
      AppMethodBeat.i(176561);
      if ((q.this.getContainer() == null) || (q.this.getContainer().getCurrentPage() != q.this))
      {
        q.this.setEnableGesture(false);
        AppMethodBeat.o(176561);
        return;
      }
      Object localObject = q.this.getContainer();
      q localq1 = q.f(q.this).j(q.this);
      if (localObject == null)
      {
        ad.w("MicroMsg.AppBrandPage", "onScrollStateChange, null == pageContainer");
        if (paramAnonymousInt == 0) {
          break label494;
        }
        q.a(q.this, true);
        label96:
        if (Float.compare(1.0F, paramAnonymousFloat) > 0) {
          break label511;
        }
        if (q.this.kYS[0] == 0)
        {
          if (localq1 != null) {
            q.cC(q.h(localq1));
          }
          localObject = q.this;
          ad.d("MicroMsg.AppBrandPage", "onSwipeBack %s", new Object[] { Log.getStackTraceString(new Throwable()) });
          ((q)localObject).mSwiping = true;
          ((q)localObject).post(new q.5((q)localObject));
          q.this.kYS[0] = true;
        }
      }
      for (;;)
      {
        ad.v("MicroMsg.AppBrandPage", "scrollPercent %f", new Object[] { Float.valueOf(paramAnonymousFloat) });
        if ((q.this.getContainer().getPageCount() == 1) && (q.this.getContainer().getRuntime().iDQ) && (q.this.getContainer().getRuntime().iDP != null)) {
          q.this.getContainer().getRuntime().iDP.qs(paramAnonymousInt);
        }
        AppMethodBeat.o(176561);
        return;
        int i = (int)Math.ceil(100.0F * paramAnonymousFloat);
        by localby;
        q localq2;
        if ((i == 0) || (-1 == this.kYW)) {
          if (q.g(q.this))
          {
            localby = by.lgq;
            localq2 = q.this;
            if (((t)localObject).kZr != null)
            {
              ((t)localObject).kZr.d(localby, localq2, localq1);
              ((t)localObject).kZq = false;
            }
          }
        }
        for (;;)
        {
          this.kYW = i;
          break;
          localby = by.lgq;
          localq2 = q.this;
          if ((((t)localObject).kZr != null) && (!((t)localObject).kZq))
          {
            ((t)localObject).kZp = ((t)localObject).kZr.b(localby, localq2, localq1);
            ((t)localObject).kZq = true;
            continue;
            if (100 > i)
            {
              localby = by.lgq;
              localq2 = q.this;
              if (((t)localObject).kZr != null)
              {
                if (!((t)localObject).kZq)
                {
                  ((t)localObject).kZp = ((t)localObject).kZr.b(localby, localq2, localq1);
                  ((t)localObject).kZq = true;
                }
                ((t)localObject).kZr.az(paramAnonymousFloat * 100.0F);
              }
            }
          }
        }
        label494:
        q.a(q.this, false);
        this.kYW = -1;
        break label96;
        label511:
        if (localq1 != null) {
          q.a(localq1, paramAnonymousFloat);
        }
      }
    }
  };
  boolean kYU = false;
  private View mContentView;
  public boolean mSwiping = false;
  
  public q(Context paramContext, t paramt)
  {
    super(paramContext);
    this.iDz = paramt;
    com.tencent.luggage.sdk.g.c.a("AppBrandPageProfile| " + getLocalClassName() + " <init>:initView()", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135005);
        q.e(q.this);
        AppMethodBeat.o(135005);
      }
    });
  }
  
  private void a(String paramString, by paramby, t.h paramh)
  {
    HashMap localHashMap = new HashMap();
    String str2 = getCurrentUrl();
    String str1 = k.cA(str2);
    Map localMap = k.cB(str2);
    localHashMap.put("path", str1);
    localHashMap.put("query", localMap);
    localHashMap.put("rawPath", str2);
    if (paramby != null) {
      localHashMap.put("openType", paramby.toString());
    }
    if (paramh != null) {
      localHashMap.put("pipMode", paramh.name);
    }
    if ("onAppRoute".equals(paramString))
    {
      paramh = (com.tencent.mm.plugin.appbrand.page.b.d)getCurrentPageView().Q(com.tencent.mm.plugin.appbrand.page.b.d.class);
      if ((paramh == null) || (!paramh.Cv())) {
        break label286;
      }
    }
    label286:
    for (boolean bool = true;; bool = false)
    {
      localHashMap.put("resizing", Boolean.valueOf(bool));
      if (by.lgq != paramby)
      {
        if (this.iDz.getAppConfig().aTp() != null) {
          localHashMap.put("page", this.iDz.getAppConfig().aTp().opt(str1));
        }
        if (this.iDz.getAppConfig().aTq() != null)
        {
          paramh = org.apache.commons.b.g.gM(str1, str1.lastIndexOf(".html"));
          localHashMap.put("preloadRule", this.iDz.getAppConfig().aTq().opt(paramh));
        }
      }
      getCurrentPageView().a(localHashMap, paramby);
      com.tencent.luggage.h.d.e(localHashMap);
      getCurrentPageView().b(paramString, new JSONObject(localHashMap).toString(), null);
      return;
    }
  }
  
  protected static boolean f(int[] paramArrayOfInt, int paramInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
      return true;
    }
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label35;
      }
      if (paramArrayOfInt[i] == paramInt) {
        break;
      }
      i += 1;
    }
    label35:
    return false;
  }
  
  private View getContentView()
  {
    return this.mContentView;
  }
  
  private String getLocalClassName()
  {
    return getClass().getName().replaceFirst(Pattern.quote("com.tencent.mm.plugin.appbrand"), "");
  }
  
  private void hide()
  {
    if (this.kYM) {
      setVisibility(4);
    }
  }
  
  private static void o(View paramView, float paramFloat)
  {
    paramView.clearAnimation();
    paramView.setTranslationX(paramFloat);
  }
  
  private void onSwipe(float paramFloat)
  {
    if (this.kYM)
    {
      if (paramFloat < 0.0F) {
        break label40;
      }
      setVisibility(0);
    }
    for (;;)
    {
      o(this, getWidth() / 4.0F * (1.0F - paramFloat) * -1.0F);
      return;
      label40:
      hide();
    }
  }
  
  protected abstract View Cq();
  
  protected void Cr()
  {
    ad.d("MicroMsg.AppBrandPage", "onPageDestroy: %s", new Object[] { getCurrentUrl() });
  }
  
  protected void Cs()
  {
    ad.d("MicroMsg.AppBrandPage", "onPageForeground: %s", new Object[] { getCurrentUrl() });
    if (this.iDz.getRuntime().iDS) {}
    for (;;)
    {
      for (boolean bool = false;; bool = true)
      {
        setEnableGesture(bool);
        setEdgeTrackingEnabled(1);
        onSwipe(1.0F);
        this.kYS[0] = false;
        this.mSwiping = false;
        this.HBS = 0.0F;
        this.KgF.cancel();
        this.KgF.be(0);
        if ((this.HBP != 0) || (this.HBQ != 0))
        {
          this.HBQ = 0;
          this.HBP = 0;
          requestLayout();
        }
        setVisibility(0);
        return;
        t localt = this.iDz;
        if ((localt.getActualPageStackSize() <= 1) && (!localt.getRuntime().iDQ)) {
          break;
        }
      }
    }
  }
  
  protected void Ct()
  {
    ad.d("MicroMsg.AppBrandPage", "onPageBackground: %s", new Object[] { getCurrentUrl() });
  }
  
  final void Do()
  {
    cleanup();
  }
  
  public void Lu(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void Z(final Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      h.Iye.aN(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(176558);
          q.this.Z(paramRunnable);
          AppMethodBeat.o(176558);
        }
      });
      return;
    }
    Object localObject = getTag(t.kZb);
    if ((localObject instanceof Animator))
    {
      ((Animator)localObject).addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(176559);
          super.onAnimationCancel(paramAnonymousAnimator);
          paramRunnable.run();
          AppMethodBeat.o(176559);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(176560);
          super.onAnimationEnd(paramAnonymousAnimator);
          paramRunnable.run();
          AppMethodBeat.o(176560);
        }
      });
      return;
    }
    if (getAnimation() == null)
    {
      paramRunnable.run();
      return;
    }
    this.kYP.add(paramRunnable);
  }
  
  protected void a(aa paramaa, AppBrandPageFullScreenView paramAppBrandPageFullScreenView)
  {
    if ((paramAppBrandPageFullScreenView != null) && (paramAppBrandPageFullScreenView.getParent() == null) && ((this.mContentView instanceof ViewGroup))) {
      ((ViewGroup)this.mContentView).addView(paramAppBrandPageFullScreenView, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  public final void a(by paramby, t.h paramh)
  {
    a("onAppRoute", paramby, paramh);
    ad.i("MicroMsg.AppBrandPage", "onAppRoute: %s, %s", new Object[] { paramby.toString(), getCurrentUrl() });
  }
  
  public abstract void a(String paramString1, String paramString2, int[] paramArrayOfInt);
  
  public final int bji()
  {
    if (this.iDz == null) {
      return -1;
    }
    return this.iDz.k(this);
  }
  
  final void bjj()
  {
    Object localObject = getCurrentPageView();
    if (localObject != null)
    {
      localObject = ((c)localObject).kXJ.jvR.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
    }
  }
  
  final void bjk()
  {
    if (this.kYM)
    {
      this.kYM = false;
      this.kYN = false;
      Cs();
    }
  }
  
  final void bjl()
  {
    if (!this.kYM)
    {
      this.kYM = true;
      Ct();
    }
  }
  
  public final void bjm()
  {
    a("onAppRouteDone", null, null);
    ad.i("MicroMsg.AppBrandPage", "onAppRouteDone: %s", new Object[] { getCurrentUrl() });
  }
  
  public abstract boolean cl(String paramString);
  
  protected void cleanup() {}
  
  public String getAppId()
  {
    return this.iDz.getAppId();
  }
  
  protected t getContainer()
  {
    return this.iDz;
  }
  
  public abstract aa getCurrentPageView();
  
  public abstract String getCurrentUrl();
  
  public e getNavigateBackInterceptionInfo()
  {
    return this.kYO;
  }
  
  public a.d getPageConfig()
  {
    return getCurrentPageView().getPageConfig();
  }
  
  protected final void hideVKB()
  {
    f.aB(getContext());
  }
  
  protected final boolean isInBackground()
  {
    return this.kYM;
  }
  
  public abstract void loadUrl(String paramString);
  
  protected final void onAnimationEnd()
  {
    super.onAnimationEnd();
    Iterator localIterator = this.kYP.iterator();
    while (localIterator.hasNext()) {
      ((Runnable)localIterator.next()).run();
    }
    this.kYP.clear();
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.kYM) {
      this.kYN = true;
    }
    aa localaa = getCurrentPageView();
    if (localaa != null) {
      localaa.onConfigurationChanged(paramConfiguration);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.kYM) && (!this.kYN) && (this.kYQ > 0) && (this.kYR > 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.kYQ, 1073741824), View.MeasureSpec.makeMeasureSpec(this.kYR, 1073741824));
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
    this.kYQ = getMeasuredWidth();
    this.kYR = getMeasuredHeight();
  }
  
  final void performDestroy()
  {
    Cr();
  }
  
  public void setNetNavigateBackInterceptionInfo(e parame)
  {
    if (parame == null) {
      return;
    }
    this.kYO = parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.q
 * JD-Core Version:    0.7.0.1
 */