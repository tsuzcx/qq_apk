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
import com.tencent.mm.sdk.platformtools.ac;
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

public abstract class r
  extends SwipeBackLayout
{
  private u jdz;
  private int lAA;
  private int lAB;
  final boolean[] lAC = { false };
  private final SwipeBackLayout.a lAD = new me.imid.swipebacklayout.lib.a()
  {
    private int lAG = -1;
    
    public final int bp(boolean paramAnonymousBoolean)
    {
      return 1;
    }
    
    public final void h(int paramAnonymousInt, float paramAnonymousFloat)
    {
      AppMethodBeat.i(176561);
      if ((r.this.getContainer() == null) || (r.this.getContainer().getCurrentPage() != r.this))
      {
        r.this.setEnableGesture(false);
        AppMethodBeat.o(176561);
        return;
      }
      Object localObject = r.this.getContainer();
      r localr1 = r.f(r.this).j(r.this);
      if (localObject == null)
      {
        ac.w("MicroMsg.AppBrandPage", "onScrollStateChange, null == pageContainer");
        if (paramAnonymousInt == 0) {
          break label494;
        }
        r.a(r.this, true);
        label96:
        if (Float.compare(1.0F, paramAnonymousFloat) > 0) {
          break label511;
        }
        if (r.this.lAC[0] == 0)
        {
          if (localr1 != null) {
            r.cE(r.h(localr1));
          }
          localObject = r.this;
          ac.d("MicroMsg.AppBrandPage", "onSwipeBack %s", new Object[] { Log.getStackTraceString(new Throwable()) });
          ((r)localObject).mSwiping = true;
          ((r)localObject).post(new r.5((r)localObject));
          r.this.lAC[0] = true;
        }
      }
      for (;;)
      {
        ac.v("MicroMsg.AppBrandPage", "scrollPercent %f", new Object[] { Float.valueOf(paramAnonymousFloat) });
        if ((r.this.getContainer().getPageCount() == 1) && (r.this.getContainer().getRuntime().jdQ) && (r.this.getContainer().getRuntime().jdP != null)) {
          r.this.getContainer().getRuntime().jdP.rf(paramAnonymousInt);
        }
        AppMethodBeat.o(176561);
        return;
        int i = (int)Math.ceil(100.0F * paramAnonymousFloat);
        bt localbt;
        r localr2;
        if ((i == 0) || (-1 == this.lAG)) {
          if (r.g(r.this))
          {
            localbt = bt.lGk;
            localr2 = r.this;
            if (((u)localObject).lBb != null)
            {
              ((u)localObject).lBb.d(localbt, localr2, localr1);
              ((u)localObject).lBa = false;
            }
          }
        }
        for (;;)
        {
          this.lAG = i;
          break;
          localbt = bt.lGk;
          localr2 = r.this;
          if ((((u)localObject).lBb != null) && (!((u)localObject).lBa))
          {
            ((u)localObject).lAZ = ((u)localObject).lBb.b(localbt, localr2, localr1);
            ((u)localObject).lBa = true;
            continue;
            if (100 > i)
            {
              localbt = bt.lGk;
              localr2 = r.this;
              if (((u)localObject).lBb != null)
              {
                if (!((u)localObject).lBa)
                {
                  ((u)localObject).lAZ = ((u)localObject).lBb.b(localbt, localr2, localr1);
                  ((u)localObject).lBa = true;
                }
                ((u)localObject).lBb.aD(paramAnonymousFloat * 100.0F);
              }
            }
          }
        }
        label494:
        r.a(r.this, false);
        this.lAG = -1;
        break label96;
        label511:
        if (localr1 != null) {
          r.a(localr1, paramAnonymousFloat);
        }
      }
    }
  };
  public boolean lAE = false;
  private boolean lAw = true;
  private boolean lAx = false;
  private e lAy = new e(false, "");
  private final Set<Runnable> lAz = new HashSet();
  private View mContentView;
  public boolean mSwiping = false;
  
  public r(Context paramContext, u paramu)
  {
    super(paramContext);
    this.jdz = paramu;
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
  
  private void a(String paramString, bt parambt, u.h paramh)
  {
    HashMap localHashMap = new HashMap();
    String str2 = getCurrentUrl();
    String str1 = k.cp(str2);
    Map localMap = k.cq(str2);
    localHashMap.put("path", str1);
    localHashMap.put("query", localMap);
    localHashMap.put("rawPath", str2);
    if (parambt != null) {
      localHashMap.put("openType", parambt.toString());
    }
    if (paramh != null) {
      localHashMap.put("pipMode", paramh.name);
    }
    if ("onAppRoute".equals(paramString))
    {
      paramh = (com.tencent.mm.plugin.appbrand.page.b.d)getCurrentPageView().Q(com.tencent.mm.plugin.appbrand.page.b.d.class);
      if ((paramh == null) || (!paramh.BZ())) {
        break label286;
      }
    }
    label286:
    for (boolean bool = true;; bool = false)
    {
      localHashMap.put("resizing", Boolean.valueOf(bool));
      if (bt.lGk != parambt)
      {
        if (this.jdz.getAppConfig().ban() != null) {
          localHashMap.put("page", this.jdz.getAppConfig().ban().opt(str1));
        }
        if (this.jdz.getAppConfig().bao() != null)
        {
          paramh = org.apache.commons.b.g.gS(str1, str1.lastIndexOf(".html"));
          localHashMap.put("preloadRule", this.jdz.getAppConfig().bao().opt(paramh));
        }
      }
      getCurrentPageView().a(localHashMap, parambt);
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
    if (this.lAw) {
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
    if (this.lAw)
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
  
  protected abstract View BU();
  
  protected void BV()
  {
    ac.d("MicroMsg.AppBrandPage", "onPageDestroy: %s", new Object[] { getCurrentUrl() });
  }
  
  protected void BW()
  {
    ac.d("MicroMsg.AppBrandPage", "onPageForeground: %s", new Object[] { getCurrentUrl() });
    if (this.jdz.getRuntime().jdS) {}
    for (;;)
    {
      for (boolean bool = false;; bool = true)
      {
        setEnableGesture(bool);
        setEdgeTrackingEnabled(1);
        onSwipe(1.0F);
        this.lAC[0] = false;
        this.mSwiping = false;
        this.Jco = 0.0F;
        this.LUp.cancel();
        this.LUp.be(0);
        if ((this.Jcl != 0) || (this.Jcm != 0))
        {
          this.Jcm = 0;
          this.Jcl = 0;
          requestLayout();
        }
        setVisibility(0);
        return;
        u localu = this.jdz;
        if ((localu.getActualPageStackSize() <= 1) && (!localu.getRuntime().jdQ)) {
          break;
        }
      }
    }
  }
  
  protected void BX()
  {
    ac.d("MicroMsg.AppBrandPage", "onPageBackground: %s", new Object[] { getCurrentUrl() });
  }
  
  public final void CR()
  {
    cleanup();
  }
  
  public void PC(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  protected void a(aa paramaa, AppBrandPageFullScreenView paramAppBrandPageFullScreenView)
  {
    if ((paramAppBrandPageFullScreenView != null) && (paramAppBrandPageFullScreenView.getParent() == null) && ((this.mContentView instanceof ViewGroup))) {
      ((ViewGroup)this.mContentView).addView(paramAppBrandPageFullScreenView, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  public final void a(bt parambt, u.h paramh)
  {
    a("onAppRoute", parambt, paramh);
    ac.i("MicroMsg.AppBrandPage", "onAppRoute: %s, %s", new Object[] { parambt.toString(), getCurrentUrl() });
  }
  
  public abstract void a(String paramString1, String paramString2, int[] paramArrayOfInt);
  
  public final void ab(final Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      h.JZN.aQ(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(176558);
          r.this.ab(paramRunnable);
          AppMethodBeat.o(176558);
        }
      });
      return;
    }
    Object localObject = getTag(u.lAL);
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
    this.lAz.add(paramRunnable);
  }
  
  public final int bqa()
  {
    if (this.jdz == null) {
      return -1;
    }
    return this.jdz.k(this);
  }
  
  final void bqb()
  {
    Object localObject = getCurrentPageView();
    if (localObject != null)
    {
      localObject = ((c)localObject).lzt.jWn.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
    }
  }
  
  final void bqc()
  {
    if (this.lAw)
    {
      this.lAw = false;
      this.lAx = false;
      BW();
    }
  }
  
  final void bqd()
  {
    if (!this.lAw)
    {
      this.lAw = true;
      BX();
    }
  }
  
  public final void bqe()
  {
    a("onAppRouteDone", null, null);
    ac.i("MicroMsg.AppBrandPage", "onAppRouteDone: %s", new Object[] { getCurrentUrl() });
  }
  
  public abstract boolean cb(String paramString);
  
  protected void cleanup() {}
  
  public String getAppId()
  {
    return this.jdz.getAppId();
  }
  
  protected u getContainer()
  {
    return this.jdz;
  }
  
  public abstract aa getCurrentPageView();
  
  public abstract String getCurrentUrl();
  
  public e getNavigateBackInterceptionInfo()
  {
    return this.lAy;
  }
  
  public a.d getPageConfig()
  {
    return getCurrentPageView().getPageConfig();
  }
  
  protected final void hideVKB()
  {
    f.aC(getContext());
  }
  
  protected final boolean isInBackground()
  {
    return this.lAw;
  }
  
  public abstract void loadUrl(String paramString);
  
  protected final void onAnimationEnd()
  {
    super.onAnimationEnd();
    Iterator localIterator = this.lAz.iterator();
    while (localIterator.hasNext()) {
      ((Runnable)localIterator.next()).run();
    }
    this.lAz.clear();
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.lAw) {
      this.lAx = true;
    }
    aa localaa = getCurrentPageView();
    if (localaa != null) {
      localaa.onConfigurationChanged(paramConfiguration);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.lAw) && (!this.lAx) && (this.lAA > 0) && (this.lAB > 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.lAA, 1073741824), View.MeasureSpec.makeMeasureSpec(this.lAB, 1073741824));
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
    this.lAA = getMeasuredWidth();
    this.lAB = getMeasuredHeight();
  }
  
  public final void performDestroy()
  {
    BV();
  }
  
  public void setNetNavigateBackInterceptionInfo(e parame)
  {
    if (parame == null) {
      return;
    }
    this.lAy = parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.r
 * JD-Core Version:    0.7.0.1
 */