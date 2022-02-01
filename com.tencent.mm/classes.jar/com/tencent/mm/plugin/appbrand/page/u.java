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
import com.tencent.luggage.l.d;
import com.tencent.luggage.l.f;
import com.tencent.luggage.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.av;
import com.tencent.mm.plugin.appbrand.config.b;
import com.tencent.mm.plugin.appbrand.config.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.page.b.g;
import com.tencent.threadpool.h;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import junit.framework.Assert;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.SwipeBackLayout.a;
import me.imid.swipebacklayout.lib.a;
import org.json.JSONObject;

public abstract class u
  extends SwipeBackLayout
{
  private View mContentView;
  public boolean mSwiping = false;
  x qsj;
  boolean tuT = true;
  private boolean tuU = false;
  private boolean tuV = false;
  private final Map<com.tencent.mm.plugin.appbrand.page.b.i, g> tuW = new HashMap();
  private final Set<Runnable> tuX = new HashSet();
  private int tuY;
  private int tuZ;
  final boolean[] tva = { false };
  private final SwipeBackLayout.a tvb = new a()
  {
    private int tve = -1;
    
    public final int cI(boolean paramAnonymousBoolean)
    {
      return 1;
    }
    
    public final void n(int paramAnonymousInt, float paramAnonymousFloat)
    {
      AppMethodBeat.i(176561);
      if ((u.this.getContainer() == null) || (u.this.getContainer().getCurrentPage() != u.this))
      {
        u.this.setEnableGesture(false);
        AppMethodBeat.o(176561);
        return;
      }
      if (u.h(u.this).b("scene_swipe_back", null))
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPage", "[onScrollStateChange] navigate back be intercepted");
        u.this.kFQ();
        AppMethodBeat.o(176561);
        return;
      }
      Object localObject = u.this.getContainer();
      u localu = u.h(u.this).l(u.this);
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
        if (u.this.tva[0] == 0)
        {
          if (localu != null) {
            u.dA(localu.getContentView());
          }
          localObject = u.this;
          com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandPage", "onSwipeBack %s", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
          ((u)localObject).mSwiping = true;
          ((u)localObject).post(new u.5((u)localObject));
          u.this.tva[0] = true;
        }
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.AppBrandPage", "scrollPercent %f", new Object[] { Float.valueOf(paramAnonymousFloat) });
        if ((u.this.getContainer().getPageCount() == 1) && (u.this.getContainer().getRuntime().qsJ) && (u.this.getContainer().getRuntime().qsI != null)) {
          u.this.getContainer().getRuntime().qsI.yW(paramAnonymousInt);
        }
        AppMethodBeat.o(176561);
        return;
        int i = (int)Math.ceil(100.0F * paramAnonymousFloat);
        if ((i == 0) || (-1 == this.tve)) {
          if (u.i(u.this)) {
            ((x)localObject).c(cb.tBo, u.this, localu);
          }
        }
        for (;;)
        {
          this.tve = i;
          break;
          ((x)localObject).a(cb.tBo, u.this, localu);
          continue;
          if (100 > i) {
            ((x)localObject).a(cb.tBo, u.this, localu, paramAnonymousFloat * 100.0F);
          }
        }
        label413:
        u.a(u.this, false);
        this.tve = -1;
        break label132;
        label430:
        if (localu != null) {
          u.a(localu, paramAnonymousFloat);
        }
      }
    }
  };
  public boolean tvc = false;
  
  public u(Context paramContext, x paramx)
  {
    super(paramContext);
    this.qsj = paramx;
  }
  
  private void a(String paramString, cb paramcb, x.h paramh, JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    String str1 = getCurrentUrl();
    String str2 = m.fL(str1);
    Map localMap = m.fM(str1);
    localHashMap.put("path", str2);
    localHashMap.put("query", localMap);
    localHashMap.put("rawPath", str1);
    if (paramcb != null) {
      localHashMap.put("openType", paramcb.toString());
    }
    if (paramh != null) {
      localHashMap.put("pipMode", paramh.name);
    }
    if ("onAppRoute".equals(paramString))
    {
      localHashMap.put("resizing", Boolean.valueOf(getCurrentPageView().cET()));
      if (cb.tBo != paramcb)
      {
        if (this.qsj.getAppConfig().ckw() != null) {
          localHashMap.put("page", this.qsj.getAppConfig().ckw().opt(str2));
        }
        if (this.qsj.getAppConfig().ckx() != null)
        {
          paramh = org.apache.commons.c.i.bD(str2, 0, str2.lastIndexOf(".html"));
          localHashMap.put("preloadRule", this.qsj.getAppConfig().ckx().opt(paramh));
        }
      }
      getCurrentPageView().a(localHashMap, paramcb, paramJSONObject);
    }
    d.k(localHashMap);
    paramh = new JSONObject(localHashMap).toString();
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPage", "dispatchRoute, appId:%s, event:%s, type:%s, webviewId:%d, rawPath:%s, data:%s", new Object[] { getAppId(), paramString, paramcb.toString(), Integer.valueOf(getCurrentPageView().getComponentId()), str1, paramh });
    getCurrentPageView().b(paramString, paramh, null);
  }
  
  private boolean cEf()
  {
    return getCurrentPageView().getCurrentRenderPagesCount() > 1;
  }
  
  private void hide()
  {
    if (this.tuT) {
      setVisibility(4);
    }
  }
  
  private void onSwipe(float paramFloat)
  {
    if (this.tuT)
    {
      if (paramFloat < 0.0F) {
        break label40;
      }
      setVisibility(0);
    }
    for (;;)
    {
      u(this, getWidth() / 4.0F * (1.0F - paramFloat) * -1.0F);
      return;
      label40:
      hide();
    }
  }
  
  private static void u(View paramView, float paramFloat)
  {
    paramView.clearAnimation();
    paramView.setTranslationX(paramFloat);
  }
  
  protected static boolean v(int[] paramArrayOfInt, int paramInt)
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
  
  public abstract ad L(int paramInt, boolean paramBoolean);
  
  public final int a(int paramInt, JSONObject paramJSONObject, boolean paramBoolean)
  {
    ad localad = getCurrentPageView();
    if ((localad == null) || (!localad.cEI())) {
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      i = localad.ag(paramInt, paramBoolean);
      paramInt = i;
    } while (!paramBoolean);
    a("onAppRoute", cb.tBo, null, paramJSONObject);
    return i;
  }
  
  public final g a(com.tencent.mm.plugin.appbrand.page.b.i parami)
  {
    synchronized (this.tuW)
    {
      parami = (g)this.tuW.get(parami);
      return parami;
    }
  }
  
  protected void a(ad paramad, AppBrandPageFullScreenView paramAppBrandPageFullScreenView)
  {
    if ((paramAppBrandPageFullScreenView != null) && (paramAppBrandPageFullScreenView.getParent() == null) && ((this.mContentView instanceof ViewGroup))) {
      ((ViewGroup)this.mContentView).addView(paramAppBrandPageFullScreenView, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.page.b.i parami, g paramg)
  {
    if (parami == null) {
      return;
    }
    Map localMap = this.tuW;
    if (paramg == null) {}
    for (;;)
    {
      try
      {
        this.tuW.remove(parami);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPage", "[registerNavigateBackInterceptionInfo] remove ".concat(String.valueOf(parami)));
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPage", "[registerNavigateBackInterceptionInfo] navigateBackInterceptionInfos size=" + this.tuW.size());
        return;
      }
      finally {}
      this.tuW.put(parami, paramg);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPage", "[registerNavigateBackInterceptionInfo] add ".concat(String.valueOf(parami)));
    }
  }
  
  public final void a(cb paramcb, x.h paramh)
  {
    a("onAppRoute", paramcb, paramh, null);
  }
  
  public final void a(cb paramcb, JSONObject paramJSONObject)
  {
    Assert.assertTrue(getCurrentPageView().cEI());
    a("onAppRouteDone", paramcb, null, paramJSONObject);
    cEj();
  }
  
  protected abstract void a(String paramString, ad paramad);
  
  public abstract void a(String paramString, cb paramcb);
  
  public abstract void a(String paramString1, String paramString2, int[] paramArrayOfInt);
  
  public boolean a(String paramString, cb paramcb, JSONObject paramJSONObject)
  {
    Assert.assertTrue(getCurrentPageView().cEI());
    if (getCurrentPageView().a(paramString, paramcb, paramJSONObject, true))
    {
      a(paramString, getCurrentPageView());
      a("onAppRoute", paramcb, null, paramJSONObject);
      return true;
    }
    return false;
  }
  
  public void aeA(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void ao(final Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      h.ahAA.bk(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135005);
          u.this.ao(paramRunnable);
          AppMethodBeat.o(135005);
        }
      });
      return;
    }
    Object localObject = getTag(x.tvm);
    if ((localObject instanceof Animator))
    {
      ((Animator)localObject).addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(324871);
          super.onAnimationCancel(paramAnonymousAnimator);
          paramRunnable.run();
          AppMethodBeat.o(324871);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(324875);
          super.onAnimationEnd(paramAnonymousAnimator);
          paramRunnable.run();
          AppMethodBeat.o(324875);
        }
      });
      return;
    }
    if (getAnimation() == null)
    {
      paramRunnable.run();
      return;
    }
    this.tuX.add(paramRunnable);
  }
  
  protected void apV()
  {
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandPage", "onPageDestroy: %s", new Object[] { getCurrentUrl() });
  }
  
  protected void apW()
  {
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandPage", "onPageForeground: %s", new Object[] { getCurrentUrl() });
    cEj();
    setVisibility(0);
  }
  
  protected void apX()
  {
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandPage", "onPageBackground: %s", new Object[] { getCurrentUrl() });
  }
  
  public final void arb()
  {
    cleanup();
  }
  
  protected void cEb() {}
  
  final void cEg()
  {
    Object localObject = getCurrentPageView();
    if (localObject != null)
    {
      localObject = ((e)localObject).ttM.rwq.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
    }
  }
  
  final void cEh()
  {
    if (this.tuT)
    {
      this.tuT = false;
      this.tuU = false;
      apW();
    }
  }
  
  final void cEi()
  {
    if (!this.tuT)
    {
      this.tuT = true;
      apX();
    }
  }
  
  public final void cEj()
  {
    if ((this.qsj.getRuntime().qsL) || (cEf())) {
      setEnableGesture(false);
    }
    for (;;)
    {
      setEdgeTrackingEnabled(1);
      onSwipe(1.0F);
      this.tva[0] = false;
      this.mSwiping = false;
      super.kFQ();
      return;
      setEnableGesture(this.qsj.cEq());
    }
  }
  
  protected void cleanup() {}
  
  protected abstract View createContentView();
  
  public final void e(cb paramcb)
  {
    cEb();
    a("onAppRouteDone", paramcb, null, null);
    this.qsj.j(getCurrentPageView());
  }
  
  public abstract boolean fa(String paramString);
  
  public String getAppId()
  {
    return this.qsj.getAppId();
  }
  
  protected x getContainer()
  {
    return this.qsj;
  }
  
  final View getContentView()
  {
    return this.mContentView;
  }
  
  public abstract ad getCurrentPageView();
  
  final int getCurrentRenderPagesCount()
  {
    ad localad = getCurrentPageView();
    if (localad == null) {
      return 1;
    }
    return localad.getCurrentRenderPagesCount();
  }
  
  public abstract String getCurrentUrl();
  
  String getLocalClassName()
  {
    return getClass().getName().replaceFirst(Pattern.quote("com.tencent.mm.plugin.appbrand"), "");
  }
  
  public b.d getPageConfig()
  {
    return getCurrentPageView().getPageConfig();
  }
  
  public final x getPageContainer()
  {
    return this.qsj;
  }
  
  public final AppBrandRuntime getRuntime()
  {
    return this.qsj.getRuntime();
  }
  
  protected final void hideVKB()
  {
    f.bv(getContext());
  }
  
  protected final void onAnimationEnd()
  {
    super.onAnimationEnd();
    Iterator localIterator = this.tuX.iterator();
    while (localIterator.hasNext()) {
      ((Runnable)localIterator.next()).run();
    }
    this.tuX.clear();
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.tuT) {
      this.tuU = true;
    }
    ad localad = getCurrentPageView();
    if (localad != null) {
      localad.onConfigurationChanged(paramConfiguration);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((!this.tuV) && (this.tuT) && (!this.tuU) && (this.tuY > 0) && (this.tuZ > 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.tuY, 1073741824), View.MeasureSpec.makeMeasureSpec(this.tuZ, 1073741824));
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
    this.tuY = getMeasuredWidth();
    this.tuZ = getMeasuredHeight();
  }
  
  public final void performDestroy()
  {
    apV();
  }
  
  public void setForceDisableMeasureCache(boolean paramBoolean)
  {
    this.tuV = paramBoolean;
  }
  
  protected abstract void setInitialUrl(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.u
 * JD-Core Version:    0.7.0.1
 */