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
import com.tencent.luggage.h.f;
import com.tencent.luggage.h.k;
import com.tencent.luggage.sdk.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.al;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.SwipeBackLayout.a;
import org.json.JSONObject;

public abstract class q
  extends SwipeBackLayout
{
  private t jzE;
  private View mContentView;
  public boolean mSwiping = false;
  private boolean meo = true;
  private boolean mep = false;
  private final Map<com.tencent.mm.plugin.appbrand.page.b.i, com.tencent.mm.plugin.appbrand.page.b.g> meq = new HashMap();
  private final Set<Runnable> mer = new HashSet();
  private int mes;
  private int met;
  final boolean[] meu = { false };
  private final SwipeBackLayout.a mev = new me.imid.swipebacklayout.lib.a()
  {
    private int mey = -1;
    
    public final int bq(boolean paramAnonymousBoolean)
    {
      return 1;
    }
    
    public final void i(int paramAnonymousInt, float paramAnonymousFloat)
    {
      AppMethodBeat.i(176561);
      if ((q.this.getContainer() == null) || (q.this.getContainer().getCurrentPage() != q.this))
      {
        q.this.setEnableGesture(false);
        AppMethodBeat.o(176561);
        return;
      }
      if (q.f(q.this).c("scene_swipe_back", null))
      {
        ae.i("MicroMsg.AppBrandPage", "[onScrollStateChange] navigate back be intercepted");
        q.this.gCb();
        AppMethodBeat.o(176561);
        return;
      }
      Object localObject = q.this.getContainer();
      q localq1 = q.f(q.this).j(q.this);
      if (localObject == null)
      {
        ae.w("MicroMsg.AppBrandPage", "onScrollStateChange, null == pageContainer");
        if (paramAnonymousInt == 0) {
          break label530;
        }
        q.a(q.this, true);
        label132:
        if (Float.compare(1.0F, paramAnonymousFloat) > 0) {
          break label547;
        }
        if (q.this.meu[0] == 0)
        {
          if (localq1 != null) {
            q.cH(q.h(localq1));
          }
          localObject = q.this;
          ae.d("MicroMsg.AppBrandPage", "onSwipeBack %s", new Object[] { Log.getStackTraceString(new Throwable()) });
          ((q)localObject).mSwiping = true;
          ((q)localObject).post(new q.5((q)localObject));
          q.this.meu[0] = true;
        }
      }
      for (;;)
      {
        ae.v("MicroMsg.AppBrandPage", "scrollPercent %f", new Object[] { Float.valueOf(paramAnonymousFloat) });
        if ((q.this.getContainer().getPageCount() == 1) && (q.this.getContainer().getRuntime().jzW) && (q.this.getContainer().getRuntime().jzV != null)) {
          q.this.getContainer().getRuntime().jzV.rI(paramAnonymousInt);
        }
        AppMethodBeat.o(176561);
        return;
        int i = (int)Math.ceil(100.0F * paramAnonymousFloat);
        br localbr;
        q localq2;
        if ((i == 0) || (-1 == this.mey)) {
          if (q.g(q.this))
          {
            localbr = br.mki;
            localq2 = q.this;
            if (((t)localObject).meU != null)
            {
              ((t)localObject).meU.d(localbr, localq2, localq1);
              ((t)localObject).meT = false;
            }
          }
        }
        for (;;)
        {
          this.mey = i;
          break;
          localbr = br.mki;
          localq2 = q.this;
          if ((((t)localObject).meU != null) && (!((t)localObject).meT))
          {
            ((t)localObject).meS = ((t)localObject).meU.b(localbr, localq2, localq1);
            ((t)localObject).meT = true;
            continue;
            if (100 > i)
            {
              localbr = br.mki;
              localq2 = q.this;
              if (((t)localObject).meU != null)
              {
                if (!((t)localObject).meT)
                {
                  ((t)localObject).meS = ((t)localObject).meU.b(localbr, localq2, localq1);
                  ((t)localObject).meT = true;
                }
                ((t)localObject).meU.aG(paramAnonymousFloat * 100.0F);
              }
            }
          }
        }
        label530:
        q.a(q.this, false);
        this.mey = -1;
        break label132;
        label547:
        if (localq1 != null) {
          q.a(localq1, paramAnonymousFloat);
        }
      }
    }
  };
  public boolean mew = false;
  
  public q(Context paramContext, t paramt)
  {
    super(paramContext);
    this.jzE = paramt;
    c.a("AppBrandPageProfile| " + getLocalClassName() + " <init>:initView()", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135005);
        q.e(q.this);
        AppMethodBeat.o(135005);
      }
    });
  }
  
  private void a(String paramString, br parambr, t.h paramh)
  {
    HashMap localHashMap = new HashMap();
    String str2 = getCurrentUrl();
    String str1 = k.dt(str2);
    Map localMap = k.du(str2);
    localHashMap.put("path", str1);
    localHashMap.put("query", localMap);
    localHashMap.put("rawPath", str2);
    if (parambr != null) {
      localHashMap.put("openType", parambr.toString());
    }
    if (paramh != null) {
      localHashMap.put("pipMode", paramh.name);
    }
    if ("onAppRoute".equals(paramString))
    {
      paramh = (com.tencent.mm.plugin.appbrand.page.a.d)getCurrentPageView().Q(com.tencent.mm.plugin.appbrand.page.a.d.class);
      if ((paramh == null) || (!paramh.DB())) {
        break label286;
      }
    }
    label286:
    for (boolean bool = true;; bool = false)
    {
      localHashMap.put("resizing", Boolean.valueOf(bool));
      if (br.mki != parambr)
      {
        if (this.jzE.getAppConfig().bes() != null) {
          localHashMap.put("page", this.jzE.getAppConfig().bes().opt(str1));
        }
        if (this.jzE.getAppConfig().bet() != null)
        {
          paramh = org.apache.commons.b.g.hH(str1, str1.lastIndexOf(".html"));
          localHashMap.put("preloadRule", this.jzE.getAppConfig().bet().opt(paramh));
        }
      }
      getCurrentPageView().a(localHashMap, parambr);
      com.tencent.luggage.h.d.k(localHashMap);
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
    if (this.meo) {
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
    if (this.meo)
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
  
  protected abstract View Dw();
  
  protected void Dx()
  {
    ae.d("MicroMsg.AppBrandPage", "onPageDestroy: %s", new Object[] { getCurrentUrl() });
  }
  
  protected void Dy()
  {
    ae.d("MicroMsg.AppBrandPage", "onPageForeground: %s", new Object[] { getCurrentUrl() });
    if (this.jzE.getRuntime().jzY) {}
    for (;;)
    {
      for (boolean bool = false;; bool = true)
      {
        setEnableGesture(bool);
        setEdgeTrackingEnabled(1);
        onSwipe(1.0F);
        this.meu[0] = false;
        this.mSwiping = false;
        super.gCb();
        setVisibility(0);
        return;
        t localt = this.jzE;
        if ((localt.getActualPageStackSize() <= 1) && (!localt.getRuntime().jzW)) {
          break;
        }
      }
    }
  }
  
  protected void Dz()
  {
    ae.d("MicroMsg.AppBrandPage", "onPageBackground: %s", new Object[] { getCurrentUrl() });
  }
  
  public final void Es()
  {
    cleanup();
  }
  
  public void TO(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void Y(final Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      h.MqF.aM(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(176558);
          q.this.Y(paramRunnable);
          AppMethodBeat.o(176558);
        }
      });
      return;
    }
    Object localObject = getTag(t.meD);
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
    this.mer.add(paramRunnable);
  }
  
  public final com.tencent.mm.plugin.appbrand.page.b.g a(com.tencent.mm.plugin.appbrand.page.b.i parami)
  {
    synchronized (this.meq)
    {
      parami = (com.tencent.mm.plugin.appbrand.page.b.g)this.meq.get(parami);
      return parami;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.page.b.i parami, com.tencent.mm.plugin.appbrand.page.b.g paramg)
  {
    if (parami == null) {
      return;
    }
    Map localMap = this.meq;
    if (paramg == null) {}
    for (;;)
    {
      try
      {
        this.meq.remove(parami);
        ae.i("MicroMsg.AppBrandPage", "[registerNavigateBackInterceptionInfo] remove ".concat(String.valueOf(parami)));
        ae.i("MicroMsg.AppBrandPage", "[registerNavigateBackInterceptionInfo] navigateBackInterceptionInfos size=" + this.meq.size());
        return;
      }
      finally {}
      this.meq.put(parami, paramg);
      ae.i("MicroMsg.AppBrandPage", "[registerNavigateBackInterceptionInfo] add ".concat(String.valueOf(parami)));
    }
  }
  
  public final void a(br parambr, t.h paramh)
  {
    a("onAppRoute", parambr, paramh);
    ae.i("MicroMsg.AppBrandPage", "onAppRoute: %s, %s", new Object[] { parambr.toString(), getCurrentUrl() });
  }
  
  protected void a(z paramz, AppBrandPageFullScreenView paramAppBrandPageFullScreenView)
  {
    if ((paramAppBrandPageFullScreenView != null) && (paramAppBrandPageFullScreenView.getParent() == null) && ((this.mContentView instanceof ViewGroup))) {
      ((ViewGroup)this.mContentView).addView(paramAppBrandPageFullScreenView, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  public abstract void a(String paramString1, String paramString2, int[] paramArrayOfInt);
  
  public final int buL()
  {
    if (this.jzE == null) {
      return -1;
    }
    return this.jzE.k(this);
  }
  
  final void buM()
  {
    Object localObject = getCurrentPageView();
    if (localObject != null)
    {
      localObject = ((b)localObject).mdk.ktT.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
    }
  }
  
  final void buN()
  {
    if (this.meo)
    {
      this.meo = false;
      this.mep = false;
      Dy();
    }
  }
  
  final void buO()
  {
    if (!this.meo)
    {
      this.meo = true;
      Dz();
    }
  }
  
  public final void buP()
  {
    a("onAppRouteDone", null, null);
    ae.i("MicroMsg.AppBrandPage", "onAppRouteDone: %s", new Object[] { getCurrentUrl() });
  }
  
  public abstract boolean cX(String paramString);
  
  protected void cleanup() {}
  
  public String getAppId()
  {
    return this.jzE.getAppId();
  }
  
  protected t getContainer()
  {
    return this.jzE;
  }
  
  public abstract z getCurrentPageView();
  
  public abstract String getCurrentUrl();
  
  public a.d getPageConfig()
  {
    return getCurrentPageView().getPageConfig();
  }
  
  protected final void hideVKB()
  {
    f.aD(getContext());
  }
  
  protected final boolean isInBackground()
  {
    return this.meo;
  }
  
  public abstract void loadUrl(String paramString);
  
  protected final void onAnimationEnd()
  {
    super.onAnimationEnd();
    Iterator localIterator = this.mer.iterator();
    while (localIterator.hasNext()) {
      ((Runnable)localIterator.next()).run();
    }
    this.mer.clear();
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.meo) {
      this.mep = true;
    }
    z localz = getCurrentPageView();
    if (localz != null) {
      localz.onConfigurationChanged(paramConfiguration);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.meo) && (!this.mep) && (this.mes > 0) && (this.met > 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mes, 1073741824), View.MeasureSpec.makeMeasureSpec(this.met, 1073741824));
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
    this.mes = getMeasuredWidth();
    this.met = getMeasuredHeight();
  }
  
  public final void performDestroy()
  {
    Dx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.q
 * JD-Core Version:    0.7.0.1
 */