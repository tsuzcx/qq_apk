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
import com.tencent.e.i;
import com.tencent.luggage.h.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.al;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.SwipeBackLayout.a;
import org.json.JSONObject;

public abstract class r
  extends SwipeBackLayout
{
  private u jwI;
  private boolean lZU = true;
  private boolean lZV = false;
  private final Map<com.tencent.mm.plugin.appbrand.page.c.h, com.tencent.mm.plugin.appbrand.page.c.f> lZW = new HashMap();
  private final Set<Runnable> lZX = new HashSet();
  private int lZY;
  private int lZZ;
  private View mContentView;
  public boolean mSwiping = false;
  final boolean[] maa = { false };
  private final SwipeBackLayout.a mab = new me.imid.swipebacklayout.lib.a()
  {
    private int maf = -1;
    
    public final int bq(boolean paramAnonymousBoolean)
    {
      return 1;
    }
    
    public final void i(int paramAnonymousInt, float paramAnonymousFloat)
    {
      AppMethodBeat.i(176561);
      if ((r.this.getContainer() == null) || (r.this.getContainer().getCurrentPage() != r.this))
      {
        r.this.setEnableGesture(false);
        AppMethodBeat.o(176561);
        return;
      }
      if (r.f(r.this).c("scene_swipe_back", null))
      {
        ad.i("MicroMsg.AppBrandPage", "[onScrollStateChange] navigate back be intercepted");
        r.this.gxz();
        AppMethodBeat.o(176561);
        return;
      }
      Object localObject = r.this.getContainer();
      r localr1 = r.f(r.this).j(r.this);
      if (localObject == null)
      {
        ad.w("MicroMsg.AppBrandPage", "onScrollStateChange, null == pageContainer");
        if (paramAnonymousInt == 0) {
          break label530;
        }
        r.a(r.this, true);
        label132:
        if (Float.compare(1.0F, paramAnonymousFloat) > 0) {
          break label547;
        }
        if (r.this.maa[0] == 0)
        {
          if (localr1 != null) {
            r.cG(r.h(localr1));
          }
          localObject = r.this;
          ad.d("MicroMsg.AppBrandPage", "onSwipeBack %s", new Object[] { Log.getStackTraceString(new Throwable()) });
          ((r)localObject).mSwiping = true;
          ((r)localObject).post(new r.5((r)localObject));
          r.this.maa[0] = true;
        }
      }
      for (;;)
      {
        ad.v("MicroMsg.AppBrandPage", "scrollPercent %f", new Object[] { Float.valueOf(paramAnonymousFloat) });
        if ((r.this.getContainer().getPageCount() == 1) && (r.this.getContainer().getRuntime().jwY) && (r.this.getContainer().getRuntime().jwX != null)) {
          r.this.getContainer().getRuntime().jwX.rG(paramAnonymousInt);
        }
        AppMethodBeat.o(176561);
        return;
        int i = (int)Math.ceil(100.0F * paramAnonymousFloat);
        bs localbs;
        r localr2;
        if ((i == 0) || (-1 == this.maf)) {
          if (r.g(r.this))
          {
            localbs = bs.mfN;
            localr2 = r.this;
            if (((u)localObject).maD != null)
            {
              ((u)localObject).maD.d(localbs, localr2, localr1);
              ((u)localObject).maC = false;
            }
          }
        }
        for (;;)
        {
          this.maf = i;
          break;
          localbs = bs.mfN;
          localr2 = r.this;
          if ((((u)localObject).maD != null) && (!((u)localObject).maC))
          {
            ((u)localObject).maB = ((u)localObject).maD.b(localbs, localr2, localr1);
            ((u)localObject).maC = true;
            continue;
            if (100 > i)
            {
              localbs = bs.mfN;
              localr2 = r.this;
              if (((u)localObject).maD != null)
              {
                if (!((u)localObject).maC)
                {
                  ((u)localObject).maB = ((u)localObject).maD.b(localbs, localr2, localr1);
                  ((u)localObject).maC = true;
                }
                ((u)localObject).maD.aG(paramAnonymousFloat * 100.0F);
              }
            }
          }
        }
        label530:
        r.a(r.this, false);
        this.maf = -1;
        break label132;
        label547:
        if (localr1 != null) {
          r.a(localr1, paramAnonymousFloat);
        }
      }
    }
  };
  public boolean mad = false;
  
  public r(Context paramContext, u paramu)
  {
    super(paramContext);
    this.jwI = paramu;
    com.tencent.luggage.sdk.g.c.a("AppBrandPageProfile| " + getLocalClassName() + " <init>:initView()", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135005);
        r.e(r.this);
        AppMethodBeat.o(135005);
      }
    });
  }
  
  private void a(String paramString, bs parambs, u.h paramh)
  {
    HashMap localHashMap = new HashMap();
    String str2 = getCurrentUrl();
    String str1 = k.dr(str2);
    Map localMap = k.ds(str2);
    localHashMap.put("path", str1);
    localHashMap.put("query", localMap);
    localHashMap.put("rawPath", str2);
    if (parambs != null) {
      localHashMap.put("openType", parambs.toString());
    }
    if (paramh != null) {
      localHashMap.put("pipMode", paramh.name);
    }
    if ("onAppRoute".equals(paramString))
    {
      paramh = (com.tencent.mm.plugin.appbrand.page.b.d)getCurrentPageView().Q(com.tencent.mm.plugin.appbrand.page.b.d.class);
      if ((paramh == null) || (!paramh.Dy())) {
        break label286;
      }
    }
    label286:
    for (boolean bool = true;; bool = false)
    {
      localHashMap.put("resizing", Boolean.valueOf(bool));
      if (bs.mfN != parambs)
      {
        if (this.jwI.getAppConfig().bdM() != null) {
          localHashMap.put("page", this.jwI.getAppConfig().bdM().opt(str1));
        }
        if (this.jwI.getAppConfig().bdN() != null)
        {
          paramh = org.apache.commons.b.g.hy(str1, str1.lastIndexOf(".html"));
          localHashMap.put("preloadRule", this.jwI.getAppConfig().bdN().opt(paramh));
        }
      }
      getCurrentPageView().a(localHashMap, parambs);
      com.tencent.luggage.h.d.d(localHashMap);
      getCurrentPageView().b(paramString, new JSONObject(localHashMap).toString(), null);
      return;
    }
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
    if (this.lZU) {
      setVisibility(4);
    }
  }
  
  protected static boolean i(int[] paramArrayOfInt, int paramInt)
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
  
  private void onSwipe(float paramFloat)
  {
    if (this.lZU)
    {
      if (paramFloat < 0.0F) {
        break label40;
      }
      setVisibility(0);
    }
    for (;;)
    {
      p(this, getWidth() / 4.0F * (1.0F - paramFloat) * -1.0F);
      return;
      label40:
      hide();
    }
  }
  
  private static void p(View paramView, float paramFloat)
  {
    paramView.clearAnimation();
    paramView.setTranslationX(paramFloat);
  }
  
  protected abstract View Dt();
  
  protected void Du()
  {
    ad.d("MicroMsg.AppBrandPage", "onPageDestroy: %s", new Object[] { getCurrentUrl() });
  }
  
  protected void Dv()
  {
    ad.d("MicroMsg.AppBrandPage", "onPageForeground: %s", new Object[] { getCurrentUrl() });
    if (this.jwI.getRuntime().jxa) {}
    for (;;)
    {
      for (boolean bool = false;; bool = true)
      {
        setEnableGesture(bool);
        setEdgeTrackingEnabled(1);
        onSwipe(1.0F);
        this.maa[0] = false;
        this.mSwiping = false;
        super.gxz();
        setVisibility(0);
        return;
        u localu = this.jwI;
        if ((localu.getActualPageStackSize() <= 1) && (!localu.getRuntime().jwY)) {
          break;
        }
      }
    }
  }
  
  protected void Dw()
  {
    ad.d("MicroMsg.AppBrandPage", "onPageBackground: %s", new Object[] { getCurrentUrl() });
  }
  
  public final void Eq()
  {
    cleanup();
  }
  
  public void Tf(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public final com.tencent.mm.plugin.appbrand.page.c.f a(com.tencent.mm.plugin.appbrand.page.c.h paramh)
  {
    synchronized (this.lZW)
    {
      paramh = (com.tencent.mm.plugin.appbrand.page.c.f)this.lZW.get(paramh);
      return paramh;
    }
  }
  
  protected void a(aa paramaa, AppBrandPageFullScreenView paramAppBrandPageFullScreenView)
  {
    if ((paramAppBrandPageFullScreenView != null) && (paramAppBrandPageFullScreenView.getParent() == null) && ((this.mContentView instanceof ViewGroup))) {
      ((ViewGroup)this.mContentView).addView(paramAppBrandPageFullScreenView, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  public final void a(bs parambs, u.h paramh)
  {
    a("onAppRoute", parambs, paramh);
    ad.i("MicroMsg.AppBrandPage", "onAppRoute: %s, %s", new Object[] { parambs.toString(), getCurrentUrl() });
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.page.c.h paramh, com.tencent.mm.plugin.appbrand.page.c.f paramf)
  {
    if (paramh == null) {
      return;
    }
    Map localMap = this.lZW;
    if (paramf == null) {}
    for (;;)
    {
      try
      {
        this.lZW.remove(paramh);
        ad.i("MicroMsg.AppBrandPage", "[registerNavigateBackInterceptionInfo] remove ".concat(String.valueOf(paramh)));
        ad.i("MicroMsg.AppBrandPage", "[registerNavigateBackInterceptionInfo] navigateBackInterceptionInfos size=" + this.lZW.size());
        return;
      }
      finally {}
      this.lZW.put(paramh, paramf);
      ad.i("MicroMsg.AppBrandPage", "[registerNavigateBackInterceptionInfo] add ".concat(String.valueOf(paramh)));
    }
  }
  
  public abstract void a(String paramString1, String paramString2, int[] paramArrayOfInt);
  
  public final void aa(final Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      com.tencent.e.h.LTJ.aP(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(176558);
          r.this.aa(paramRunnable);
          AppMethodBeat.o(176558);
        }
      });
      return;
    }
    Object localObject = getTag(u.mak);
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
    this.lZX.add(paramRunnable);
  }
  
  public final int bua()
  {
    if (this.jwI == null) {
      return -1;
    }
    return this.jwI.k(this);
  }
  
  final void bub()
  {
    Object localObject = getCurrentPageView();
    if (localObject != null)
    {
      localObject = ((c)localObject).lYR.kqE.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
    }
  }
  
  final void buc()
  {
    if (this.lZU)
    {
      this.lZU = false;
      this.lZV = false;
      Dv();
    }
  }
  
  final void bud()
  {
    if (!this.lZU)
    {
      this.lZU = true;
      Dw();
    }
  }
  
  public final void bue()
  {
    a("onAppRouteDone", null, null);
    ad.i("MicroMsg.AppBrandPage", "onAppRouteDone: %s", new Object[] { getCurrentUrl() });
  }
  
  public abstract boolean cV(String paramString);
  
  protected void cleanup() {}
  
  public String getAppId()
  {
    return this.jwI.getAppId();
  }
  
  protected u getContainer()
  {
    return this.jwI;
  }
  
  public abstract aa getCurrentPageView();
  
  public abstract String getCurrentUrl();
  
  public a.d getPageConfig()
  {
    return getCurrentPageView().getPageConfig();
  }
  
  protected final void hideVKB()
  {
    com.tencent.luggage.h.f.aC(getContext());
  }
  
  protected final boolean isInBackground()
  {
    return this.lZU;
  }
  
  public abstract void loadUrl(String paramString);
  
  protected final void onAnimationEnd()
  {
    super.onAnimationEnd();
    Iterator localIterator = this.lZX.iterator();
    while (localIterator.hasNext()) {
      ((Runnable)localIterator.next()).run();
    }
    this.lZX.clear();
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.lZU) {
      this.lZV = true;
    }
    aa localaa = getCurrentPageView();
    if (localaa != null) {
      localaa.onConfigurationChanged(paramConfiguration);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.lZU) && (!this.lZV) && (this.lZY > 0) && (this.lZZ > 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.lZY, 1073741824), View.MeasureSpec.makeMeasureSpec(this.lZZ, 1073741824));
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
    this.lZY = getMeasuredWidth();
    this.lZZ = getMeasuredHeight();
  }
  
  public final void performDestroy()
  {
    Du();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.r
 * JD-Core Version:    0.7.0.1
 */