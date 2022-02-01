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
import com.tencent.f.h;
import com.tencent.luggage.h.e;
import com.tencent.luggage.h.l;
import com.tencent.luggage.sdk.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ap;
import com.tencent.mm.plugin.appbrand.config.b;
import com.tencent.mm.plugin.appbrand.config.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.j;
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

public abstract class t
  extends SwipeBackLayout
{
  private w kAs;
  private View mContentView;
  public boolean mSwiping = false;
  private boolean noI = true;
  private boolean noJ = false;
  private final Map<com.tencent.mm.plugin.appbrand.page.b.i, com.tencent.mm.plugin.appbrand.page.b.g> noK = new HashMap();
  private final Set<Runnable> noL = new HashSet();
  private int noM;
  private int noN;
  final boolean[] noO = { false };
  private final SwipeBackLayout.a noP = new a()
  {
    private int noS = -1;
    
    public final int bS(boolean paramAnonymousBoolean)
    {
      return 1;
    }
    
    public final void i(int paramAnonymousInt, float paramAnonymousFloat)
    {
      AppMethodBeat.i(219372);
      if ((t.this.getContainer() == null) || (t.this.getContainer().getCurrentPage() != t.this))
      {
        t.this.setEnableGesture(false);
        AppMethodBeat.o(219372);
        return;
      }
      if (t.g(t.this).d("scene_swipe_back", null))
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPage", "[onScrollStateChange] navigate back be intercepted");
        t.this.hPi();
        AppMethodBeat.o(219372);
        return;
      }
      Object localObject = t.this.getContainer();
      t localt1 = t.g(t.this).k(t.this);
      if (localObject == null)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandPage", "onScrollStateChange, null == pageContainer");
        if (paramAnonymousInt == 0) {
          break label530;
        }
        t.a(t.this, true);
        label132:
        if (Float.compare(1.0F, paramAnonymousFloat) > 0) {
          break label547;
        }
        if (t.this.noO[0] == 0)
        {
          if (localt1 != null) {
            t.cA(t.i(localt1));
          }
          localObject = t.this;
          com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandPage", "onSwipeBack %s", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
          ((t)localObject).mSwiping = true;
          ((t)localObject).post(new t.6((t)localObject));
          t.this.noO[0] = true;
        }
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.AppBrandPage", "scrollPercent %f", new Object[] { Float.valueOf(paramAnonymousFloat) });
        if ((t.this.getContainer().getPageCount() == 1) && (t.this.getContainer().getRuntime().kAN) && (t.this.getContainer().getRuntime().kAM != null)) {
          t.this.getContainer().getRuntime().kAM.vC(paramAnonymousInt);
        }
        AppMethodBeat.o(219372);
        return;
        int i = (int)Math.ceil(100.0F * paramAnonymousFloat);
        bx localbx;
        t localt2;
        if ((i == 0) || (-1 == this.noS)) {
          if (t.h(t.this))
          {
            localbx = bx.nuF;
            localt2 = t.this;
            if (((w)localObject).npr != null)
            {
              ((w)localObject).npr.d(localbx, localt2, localt1);
              ((w)localObject).npq = false;
            }
          }
        }
        for (;;)
        {
          this.noS = i;
          break;
          localbx = bx.nuF;
          localt2 = t.this;
          if ((((w)localObject).npr != null) && (!((w)localObject).npq))
          {
            ((w)localObject).npp = ((w)localObject).npr.b(localbx, localt2, localt1);
            ((w)localObject).npq = true;
            continue;
            if (100 > i)
            {
              localbx = bx.nuF;
              localt2 = t.this;
              if (((w)localObject).npr != null)
              {
                if (!((w)localObject).npq)
                {
                  ((w)localObject).npp = ((w)localObject).npr.b(localbx, localt2, localt1);
                  ((w)localObject).npq = true;
                }
                ((w)localObject).npr.aQ(paramAnonymousFloat * 100.0F);
              }
            }
          }
        }
        label530:
        t.a(t.this, false);
        this.noS = -1;
        break label132;
        label547:
        if (localt1 != null) {
          t.a(localt1, paramAnonymousFloat);
        }
      }
    }
  };
  public boolean noQ = false;
  
  public t(Context paramContext, w paramw)
  {
    super(paramContext);
    this.kAs = paramw;
    c.a("AppBrandPageProfile| " + getLocalClassName() + " <init>:initView()", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135005);
        t.f(t.this);
        AppMethodBeat.o(135005);
      }
    });
  }
  
  private void a(String paramString, bx parambx, w.h paramh)
  {
    HashMap localHashMap = new HashMap();
    String str1 = getCurrentUrl();
    String str2 = l.dM(str1);
    Map localMap = l.dN(str1);
    localHashMap.put("path", str2);
    localHashMap.put("query", localMap);
    localHashMap.put("rawPath", str1);
    if (parambx != null) {
      localHashMap.put("openType", parambx.toString());
    }
    if (paramh != null) {
      localHashMap.put("pipMode", paramh.name);
    }
    if ("onAppRoute".equals(paramString))
    {
      paramh = (com.tencent.mm.plugin.appbrand.page.a.d)getCurrentPageView().S(com.tencent.mm.plugin.appbrand.page.a.d.class);
      if ((paramh == null) || (!paramh.MY())) {
        break label340;
      }
    }
    label340:
    for (boolean bool = true;; bool = false)
    {
      localHashMap.put("resizing", Boolean.valueOf(bool));
      if (bx.nuF != parambx)
      {
        if (this.kAs.getAppConfig().bzJ() != null) {
          localHashMap.put("page", this.kAs.getAppConfig().bzJ().opt(str2));
        }
        if (this.kAs.getAppConfig().bzK() != null)
        {
          paramh = org.apache.commons.b.g.id(str2, str2.lastIndexOf(".html"));
          localHashMap.put("preloadRule", this.kAs.getAppConfig().bzK().opt(paramh));
        }
      }
      getCurrentPageView().a(localHashMap, parambx);
      e.m(localHashMap);
      paramh = new JSONObject(localHashMap).toString();
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPage", "dispatchRoute, appId:%s, event:%s, type:%s, webviewId:%d, rawPath:%s, data:%s", new Object[] { getAppId(), paramString, parambx.toString(), Integer.valueOf(getCurrentPageView().getComponentId()), str1, paramh });
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
    if (this.noI) {
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
    if (this.noI)
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
  
  protected abstract View MT();
  
  protected void MU()
  {
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandPage", "onPageDestroy: %s", new Object[] { getCurrentUrl() });
  }
  
  protected void MV()
  {
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandPage", "onPageForeground: %s", new Object[] { getCurrentUrl() });
    bQP();
    setVisibility(0);
  }
  
  protected void MW()
  {
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandPage", "onPageBackground: %s", new Object[] { getCurrentUrl() });
  }
  
  public final void NR()
  {
    cleanup();
  }
  
  public final com.tencent.mm.plugin.appbrand.page.b.g a(com.tencent.mm.plugin.appbrand.page.b.i parami)
  {
    synchronized (this.noK)
    {
      parami = (com.tencent.mm.plugin.appbrand.page.b.g)this.noK.get(parami);
      return parami;
    }
  }
  
  protected void a(ac paramac, AppBrandPageFullScreenView paramAppBrandPageFullScreenView)
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
    Map localMap = this.noK;
    if (paramg == null) {}
    for (;;)
    {
      try
      {
        this.noK.remove(parami);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPage", "[registerNavigateBackInterceptionInfo] remove ".concat(String.valueOf(parami)));
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPage", "[registerNavigateBackInterceptionInfo] navigateBackInterceptionInfos size=" + this.noK.size());
        return;
      }
      finally {}
      this.noK.put(parami, paramg);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPage", "[registerNavigateBackInterceptionInfo] add ".concat(String.valueOf(parami)));
    }
  }
  
  public final void a(bx parambx, w.h paramh)
  {
    a("onAppRoute", parambx, paramh);
  }
  
  public abstract void a(String paramString1, String paramString2, int[] paramArrayOfInt);
  
  public void adB(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void af(final Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      h.RTc.aV(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(176558);
          t.this.af(paramRunnable);
          AppMethodBeat.o(176558);
        }
      });
      return;
    }
    Object localObject = getTag(w.noX);
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
    this.noL.add(paramRunnable);
  }
  
  public final void b(bx parambx)
  {
    a("onAppRouteDone", parambx, null);
    if (this.kAs.npl.v(getCurrentPageView())) {
      this.kAs.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(219371);
          t.g(t.this).adK("initReady");
          AppMethodBeat.o(219371);
        }
      }, 200L);
    }
  }
  
  public final int bQL()
  {
    if (this.kAs == null) {
      return -1;
    }
    return this.kAs.l(this);
  }
  
  final void bQM()
  {
    Object localObject = getCurrentPageView();
    if (localObject != null)
    {
      localObject = ((d)localObject).nnC.lxJ.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
    }
  }
  
  final void bQN()
  {
    if (this.noI)
    {
      this.noI = false;
      this.noJ = false;
      MV();
    }
  }
  
  final void bQO()
  {
    if (!this.noI)
    {
      this.noI = true;
      MW();
    }
  }
  
  public final void bQP()
  {
    if (this.kAs.getRuntime().kAP) {
      setEnableGesture(false);
    }
    for (;;)
    {
      setEdgeTrackingEnabled(1);
      onSwipe(1.0F);
      this.noO[0] = false;
      this.mSwiping = false;
      super.hPi();
      return;
      setEnableGesture(this.kAs.bQW());
    }
  }
  
  protected void cleanup() {}
  
  public abstract boolean dw(String paramString);
  
  public String getAppId()
  {
    return this.kAs.getAppId();
  }
  
  protected w getContainer()
  {
    return this.kAs;
  }
  
  public abstract ac getCurrentPageView();
  
  public abstract String getCurrentUrl();
  
  public b.d getPageConfig()
  {
    return getCurrentPageView().getPageConfig();
  }
  
  public abstract ac hL(int paramInt);
  
  protected final void hideVKB()
  {
    com.tencent.luggage.h.g.aM(getContext());
  }
  
  protected final boolean isInBackground()
  {
    return this.noI;
  }
  
  public abstract void loadUrl(String paramString);
  
  protected final void onAnimationEnd()
  {
    super.onAnimationEnd();
    Iterator localIterator = this.noL.iterator();
    while (localIterator.hasNext()) {
      ((Runnable)localIterator.next()).run();
    }
    this.noL.clear();
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.noI) {
      this.noJ = true;
    }
    ac localac = getCurrentPageView();
    if (localac != null) {
      localac.onConfigurationChanged(paramConfiguration);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.noI) && (!this.noJ) && (this.noM > 0) && (this.noN > 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.noM, 1073741824), View.MeasureSpec.makeMeasureSpec(this.noN, 1073741824));
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
    this.noM = getMeasuredWidth();
    this.noN = getMeasuredHeight();
  }
  
  public final void performDestroy()
  {
    MU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.t
 * JD-Core Version:    0.7.0.1
 */