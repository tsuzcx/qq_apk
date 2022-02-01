package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Looper;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.e.h;
import com.tencent.luggage.k.e;
import com.tencent.luggage.k.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.aq;
import com.tencent.mm.plugin.appbrand.config.b;
import com.tencent.mm.plugin.appbrand.config.b.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.SwipeBackLayout.a;
import me.imid.swipebacklayout.lib.a;
import org.json.JSONObject;

public abstract class u
  extends SwipeBackLayout
{
  private View mContentView;
  public boolean mSwiping = false;
  private x ntB;
  public boolean qqA = false;
  private boolean qqr = true;
  private boolean qqs = false;
  private boolean qqt = false;
  private final Map<com.tencent.mm.plugin.appbrand.page.b.i, com.tencent.mm.plugin.appbrand.page.b.g> qqu = new HashMap();
  private final Set<Runnable> qqv = new HashSet();
  private int qqw;
  private int qqx;
  final boolean[] qqy = { false };
  private final SwipeBackLayout.a qqz = new a()
  {
    private int qqC = -1;
    
    public final int cc(boolean paramAnonymousBoolean)
    {
      return 1;
    }
    
    public final void j(int paramAnonymousInt, float paramAnonymousFloat)
    {
      AppMethodBeat.i(243304);
      if ((u.this.getContainer() == null) || (u.this.getContainer().getCurrentPage() != u.this))
      {
        u.this.setEnableGesture(false);
        AppMethodBeat.o(243304);
        return;
      }
      if (u.g(u.this).b("scene_swipe_back", null))
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPage", "[onScrollStateChange] navigate back be intercepted");
        u.this.iUp();
        AppMethodBeat.o(243304);
        return;
      }
      Object localObject = u.this.getContainer();
      u localu = u.g(u.this).l(u.this);
      if (localObject == null)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandPage", "onScrollStateChange, null == pageContainer");
        if (paramAnonymousInt == 0) {
          break label413;
        }
        u.a(u.this, true);
        label132:
        if (Float.compare(1.0F, paramAnonymousFloat) > 0) {
          break label430;
        }
        if (u.this.qqy[0] == 0)
        {
          if (localu != null) {
            u.cT(u.i(localu));
          }
          localObject = u.this;
          com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandPage", "onSwipeBack %s", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
          ((u)localObject).mSwiping = true;
          ((u)localObject).post(new u.6((u)localObject));
          u.this.qqy[0] = true;
        }
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.AppBrandPage", "scrollPercent %f", new Object[] { Float.valueOf(paramAnonymousFloat) });
        if ((u.this.getContainer().getPageCount() == 1) && (u.this.getContainer().getRuntime().ntZ) && (u.this.getContainer().getRuntime().ntY != null)) {
          u.this.getContainer().getRuntime().ntY.yN(paramAnonymousInt);
        }
        AppMethodBeat.o(243304);
        return;
        int i = (int)Math.ceil(100.0F * paramAnonymousFloat);
        if ((i == 0) || (-1 == this.qqC)) {
          if (u.h(u.this)) {
            ((x)localObject).c(ca.qwz, u.this, localu);
          }
        }
        for (;;)
        {
          this.qqC = i;
          break;
          ((x)localObject).a(ca.qwz, u.this, localu);
          continue;
          if (100 > i) {
            ((x)localObject).a(ca.qwz, u.this, localu, paramAnonymousFloat * 100.0F);
          }
        }
        label413:
        u.a(u.this, false);
        this.qqC = -1;
        break label132;
        label430:
        if (localu != null) {
          u.a(localu, paramAnonymousFloat);
        }
      }
    }
  };
  
  public u(Context paramContext, x paramx)
  {
    super(paramContext);
    this.ntB = paramx;
    com.tencent.luggage.sdk.h.d.a("AppBrandPageProfile| " + getLocalClassName() + " <init>:initView()", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135005);
        u.f(u.this);
        AppMethodBeat.o(135005);
      }
    });
  }
  
  private void a(String paramString, ca paramca, x.h paramh)
  {
    HashMap localHashMap = new HashMap();
    String str1 = getCurrentUrl();
    String str2 = l.eo(str1);
    Map localMap = l.ep(str1);
    localHashMap.put("path", str2);
    localHashMap.put("query", localMap);
    localHashMap.put("rawPath", str1);
    if (paramca != null) {
      localHashMap.put("openType", paramca.toString());
    }
    if (paramh != null) {
      localHashMap.put("pipMode", paramh.name);
    }
    if ("onAppRoute".equals(paramString))
    {
      paramh = (com.tencent.mm.plugin.appbrand.page.a.d)getCurrentPageView().R(com.tencent.mm.plugin.appbrand.page.a.d.class);
      if ((paramh == null) || (!paramh.PQ())) {
        break label341;
      }
    }
    label341:
    for (boolean bool = true;; bool = false)
    {
      localHashMap.put("resizing", Boolean.valueOf(bool));
      if (ca.qwz != paramca)
      {
        if (this.ntB.getAppConfig().bKY() != null) {
          localHashMap.put("page", this.ntB.getAppConfig().bKY().opt(str2));
        }
        if (this.ntB.getAppConfig().bKZ() != null)
        {
          paramh = org.apache.commons.b.g.bh(str2, 0, str2.lastIndexOf(".html"));
          localHashMap.put("preloadRule", this.ntB.getAppConfig().bKZ().opt(paramh));
        }
      }
      getCurrentPageView().a(localHashMap, paramca);
      e.e(localHashMap);
      paramh = new JSONObject(localHashMap).toString();
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPage", "dispatchRoute, appId:%s, event:%s, type:%s, webviewId:%d, rawPath:%s, data:%s", new Object[] { getAppId(), paramString, paramca.toString(), Integer.valueOf(getCurrentPageView().getComponentId()), str1, paramh });
      getCurrentPageView().b(paramString, paramh, null);
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
    if (this.qqr) {
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
    if (this.qqr)
    {
      if (paramFloat < 0.0F) {
        break label40;
      }
      setVisibility(0);
    }
    for (;;)
    {
      t(this, getWidth() / 4.0F * (1.0F - paramFloat) * -1.0F);
      return;
      label40:
      hide();
    }
  }
  
  private static void t(View paramView, float paramFloat)
  {
    paramView.clearAnimation();
    paramView.setTranslationX(paramFloat);
  }
  
  protected abstract View PL();
  
  protected void PM()
  {
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandPage", "onPageDestroy: %s", new Object[] { getCurrentUrl() });
  }
  
  protected void PN()
  {
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandPage", "onPageForeground: %s", new Object[] { getCurrentUrl() });
    cdF();
    setVisibility(0);
  }
  
  protected void PO()
  {
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandPage", "onPageBackground: %s", new Object[] { getCurrentUrl() });
  }
  
  public final void QO()
  {
    cleanup();
  }
  
  public final com.tencent.mm.plugin.appbrand.page.b.g a(com.tencent.mm.plugin.appbrand.page.b.i parami)
  {
    synchronized (this.qqu)
    {
      parami = (com.tencent.mm.plugin.appbrand.page.b.g)this.qqu.get(parami);
      return parami;
    }
  }
  
  protected void a(ad paramad, AppBrandPageFullScreenView paramAppBrandPageFullScreenView)
  {
    if ((paramAppBrandPageFullScreenView != null) && (paramAppBrandPageFullScreenView.getParent() == null) && ((this.mContentView instanceof ViewGroup))) {
      ((ViewGroup)this.mContentView).addView(paramAppBrandPageFullScreenView, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.page.b.i parami, com.tencent.mm.plugin.appbrand.page.b.g paramg)
  {
    if (parami == null) {
      return;
    }
    Map localMap = this.qqu;
    if (paramg == null) {}
    for (;;)
    {
      try
      {
        this.qqu.remove(parami);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPage", "[registerNavigateBackInterceptionInfo] remove ".concat(String.valueOf(parami)));
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPage", "[registerNavigateBackInterceptionInfo] navigateBackInterceptionInfos size=" + this.qqu.size());
        return;
      }
      finally {}
      this.qqu.put(parami, paramg);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPage", "[registerNavigateBackInterceptionInfo] add ".concat(String.valueOf(parami)));
    }
  }
  
  public final void a(ca paramca, x.h paramh)
  {
    a("onAppRoute", paramca, paramh);
  }
  
  public abstract void a(String paramString, ca paramca);
  
  public abstract void a(String paramString1, String paramString2, int[] paramArrayOfInt);
  
  public final void ai(final Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      h.ZvG.bc(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(176558);
          u.this.ai(paramRunnable);
          AppMethodBeat.o(176558);
        }
      });
      return;
    }
    Object localObject = getTag(x.qqJ);
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
    this.qqv.add(paramRunnable);
  }
  
  public void alw(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void c(ca paramca)
  {
    a("onAppRouteDone", paramca, null);
    if (this.ntB.qqX.v(getCurrentPageView())) {
      this.ntB.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(242681);
          u.g(u.this).alF("initReady");
          AppMethodBeat.o(242681);
        }
      }, 200L);
    }
  }
  
  public final int cdB()
  {
    if (this.ntB == null) {
      return -1;
    }
    return this.ntB.m(this);
  }
  
  final void cdC()
  {
    Object localObject = getCurrentPageView();
    if (localObject != null)
    {
      localObject = ((d)localObject).qpj.osw.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
    }
  }
  
  final void cdD()
  {
    if (this.qqr)
    {
      this.qqr = false;
      this.qqs = false;
      PN();
    }
  }
  
  final void cdE()
  {
    if (!this.qqr)
    {
      this.qqr = true;
      PO();
    }
  }
  
  public final void cdF()
  {
    if (this.ntB.getRuntime().nub) {
      setEnableGesture(false);
    }
    for (;;)
    {
      setEdgeTrackingEnabled(1);
      onSwipe(1.0F);
      this.qqy[0] = false;
      this.mSwiping = false;
      super.iUp();
      return;
      setEnableGesture(this.ntB.cdM());
    }
  }
  
  protected void cleanup() {}
  
  public abstract boolean dP(String paramString);
  
  public String getAppId()
  {
    return this.ntB.getAppId();
  }
  
  protected x getContainer()
  {
    return this.ntB;
  }
  
  public abstract ad getCurrentPageView();
  
  public abstract String getCurrentUrl();
  
  public b.d getPageConfig()
  {
    return getCurrentPageView().getPageConfig();
  }
  
  protected final void hideVKB()
  {
    com.tencent.luggage.k.g.aK(getContext());
  }
  
  public abstract ad iL(int paramInt);
  
  protected final boolean isInBackground()
  {
    return this.qqr;
  }
  
  protected final void onAnimationEnd()
  {
    super.onAnimationEnd();
    Iterator localIterator = this.qqv.iterator();
    while (localIterator.hasNext()) {
      ((Runnable)localIterator.next()).run();
    }
    this.qqv.clear();
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.qqr) {
      this.qqs = true;
    }
    ad localad = getCurrentPageView();
    if (localad != null) {
      localad.onConfigurationChanged(paramConfiguration);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((!this.qqt) && (this.qqr) && (!this.qqs) && (this.qqw > 0) && (this.qqx > 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.qqw, 1073741824), View.MeasureSpec.makeMeasureSpec(this.qqx, 1073741824));
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
    this.qqw = getMeasuredWidth();
    this.qqx = getMeasuredHeight();
  }
  
  public final void performDestroy()
  {
    PM();
  }
  
  public void setForceDisableMeasureCache(boolean paramBoolean)
  {
    this.qqt = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.u
 * JD-Core Version:    0.7.0.1
 */