package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.luggage.h.k;
import com.tencent.luggage.sdk.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.a.g;
import com.tencent.mm.plugin.appbrand.config.a.h;
import com.tencent.mm.plugin.appbrand.jsapi.f.f;
import com.tencent.mm.plugin.appbrand.widget.tabbar.AppBrandTabBarItem;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@SuppressLint({"ViewConstructor"})
public final class j
  extends q
{
  private ViewGroup jhz;
  private Map<String, aa> kYA;
  private SparseArray<AppBrandPageFullScreenView> kYB;
  private boolean kYC;
  private final Runnable kYD;
  private final Runnable kYE;
  private final LinkedList<b> kYF;
  private com.tencent.mm.plugin.appbrand.widget.tabbar.a kYx;
  private FrameLayout kYy;
  private aa kYz;
  private String kns;
  private boolean mDestroyed;
  
  public j(Context paramContext, t paramt)
  {
    super(paramContext, paramt);
    AppMethodBeat.i(134975);
    this.kYA = new HashMap();
    this.kYB = new SparseArray();
    this.kYC = false;
    this.mDestroyed = false;
    this.kYD = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134965);
        j.a(j.this);
        AppMethodBeat.o(134965);
      }
    };
    this.kYE = new j.3(this);
    this.kYF = new LinkedList();
    this.kYz = getContainer().bjq();
    AppMethodBeat.o(134975);
  }
  
  /* Error */
  private aa Ls(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 110
    //   4: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 103	com/tencent/mm/plugin/appbrand/page/j:kYz	Lcom/tencent/mm/plugin/appbrand/page/aa;
    //   11: ifnull +51 -> 62
    //   14: aload_0
    //   15: getfield 103	com/tencent/mm/plugin/appbrand/page/j:kYz	Lcom/tencent/mm/plugin/appbrand/page/aa;
    //   18: astore_2
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 103	com/tencent/mm/plugin/appbrand/page/j:kYz	Lcom/tencent/mm/plugin/appbrand/page/aa;
    //   24: aload_2
    //   25: aload_0
    //   26: putfield 116	com/tencent/mm/plugin/appbrand/page/aa:lbd	Lcom/tencent/mm/plugin/appbrand/page/q;
    //   29: aload_0
    //   30: getfield 67	com/tencent/mm/plugin/appbrand/page/j:kYA	Ljava/util/Map;
    //   33: aload_1
    //   34: aload_2
    //   35: invokeinterface 122 3 0
    //   40: pop
    //   41: aload_0
    //   42: getfield 124	com/tencent/mm/plugin/appbrand/page/j:kYy	Landroid/widget/FrameLayout;
    //   45: aload_2
    //   46: getfield 126	com/tencent/mm/plugin/appbrand/page/aa:jhz	Landroid/view/ViewGroup;
    //   49: iconst_0
    //   50: invokevirtual 132	android/widget/FrameLayout:addView	(Landroid/view/View;I)V
    //   53: ldc 110
    //   55: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_2
    //   61: areturn
    //   62: aload_0
    //   63: invokevirtual 95	com/tencent/mm/plugin/appbrand/page/j:getContainer	()Lcom/tencent/mm/plugin/appbrand/page/t;
    //   66: invokevirtual 101	com/tencent/mm/plugin/appbrand/page/t:bjq	()Lcom/tencent/mm/plugin/appbrand/page/aa;
    //   69: astore_2
    //   70: goto -46 -> 24
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	j
    //   0	78	1	paramString	String
    //   18	52	2	localaa	aa
    // Exception table:
    //   from	to	target	type
    //   2	24	73	finally
    //   24	58	73	finally
    //   62	70	73	finally
  }
  
  private void Lt(String paramString)
  {
    AppMethodBeat.i(134984);
    this.kYC = false;
    aa localaa2 = (aa)this.kYA.get(k.cA(paramString));
    localaa2.jhz.setVisibility(4);
    paramString = null;
    Iterator localIterator = this.kYA.values().iterator();
    if (localIterator.hasNext())
    {
      aa localaa1 = (aa)localIterator.next();
      if ((localaa1.jhz.getVisibility() != 0) || (localaa2 == localaa1)) {
        break label143;
      }
      paramString = localaa1;
    }
    label143:
    for (;;)
    {
      break;
      localaa2.jhz.bringToFront();
      localaa2.jhz.setVisibility(0);
      if (paramString != null) {
        paramString.jhz.setVisibility(4);
      }
      if (paramString != null) {
        paramString.onBackground();
      }
      localaa2.onForeground();
      bjf();
      AppMethodBeat.o(134984);
      return;
    }
  }
  
  private void bjd()
  {
    AppMethodBeat.i(134979);
    if (this.mDestroyed)
    {
      AppMethodBeat.o(134979);
      return;
    }
    post(this.kYD);
    AppMethodBeat.o(134979);
  }
  
  private void bje()
  {
    AppMethodBeat.i(134980);
    if (this.mDestroyed)
    {
      AppMethodBeat.o(134980);
      return;
    }
    post(this.kYE);
    AppMethodBeat.o(134980);
  }
  
  private void bjf()
  {
    AppMethodBeat.i(134985);
    if (this.kYB.size() <= 0)
    {
      AppMethodBeat.o(134985);
      return;
    }
    int i = 0;
    while (i < this.kYB.size())
    {
      ((AppBrandPageFullScreenView)this.kYB.valueAt(i)).setVisibility(4);
      i += 1;
    }
    Object localObject = getCurrentPageView();
    if (localObject == null)
    {
      AppMethodBeat.o(134985);
      return;
    }
    localObject = (AppBrandPageFullScreenView)this.kYB.get(localObject.hashCode());
    if (localObject != null) {
      ((AppBrandPageFullScreenView)localObject).setVisibility(0);
    }
    AppMethodBeat.o(134985);
  }
  
  private void gx(boolean paramBoolean)
  {
    AppMethodBeat.i(134986);
    Iterator localIterator = this.kYF.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      removeCallbacks(localb);
      if (paramBoolean) {
        localb.run();
      } else {
        localb.mCanceled = true;
      }
    }
    this.kYF.clear();
    AppMethodBeat.o(134986);
  }
  
  protected final View Cq()
  {
    AppMethodBeat.i(134976);
    Object localObject;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jhz == null)
    {
      localObject = new RelativeLayout(getContext());
      this.kYy = new FrameLayout(getContext());
      c.a("createTabBar", new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194484);
          bc localbc = (bc)j.this.getContainer().getRuntime().ab(bc.class);
          j.a(j.this, j.this.a(localbc));
          AppMethodBeat.o(194484);
        }
      });
      if (getContainer().getAppConfig().aTn().jbM) {
        this.kYx.setVisibility(8);
      }
      if (!"top".equals(getContainer().getAppConfig().aTn().jbI)) {
        break label170;
      }
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(10);
      ((RelativeLayout)localObject).addView(this.kYy, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(10);
      ((RelativeLayout)localObject).addView(this.kYx, localLayoutParams);
    }
    for (;;)
    {
      this.jhz = ((ViewGroup)localObject);
      localObject = this.jhz;
      AppMethodBeat.o(134976);
      return localObject;
      label170:
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(12);
      ((RelativeLayout)localObject).addView(this.kYx, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(2, this.kYx.getId());
      ((RelativeLayout)localObject).addView(this.kYy, localLayoutParams);
    }
  }
  
  protected final void Cr()
  {
    AppMethodBeat.i(134990);
    super.Cr();
    if (this.kYz != null) {
      this.kYz.onDestroy();
    }
    Iterator localIterator = this.kYA.values().iterator();
    while (localIterator.hasNext()) {
      ((aa)localIterator.next()).onDestroy();
    }
    AppMethodBeat.o(134990);
  }
  
  public final void Cs()
  {
    AppMethodBeat.i(134988);
    super.Cs();
    getCurrentPageView().onForeground();
    AppMethodBeat.o(134988);
  }
  
  public final void Ct()
  {
    AppMethodBeat.i(134989);
    super.Ct();
    getCurrentPageView().onBackground();
    AppMethodBeat.o(134989);
  }
  
  protected final com.tencent.mm.plugin.appbrand.widget.tabbar.a a(bc parambc)
  {
    AppMethodBeat.i(194492);
    Object localObject2 = (com.tencent.mm.plugin.appbrand.widget.tabbar.a)parambc.aC(com.tencent.mm.plugin.appbrand.widget.tabbar.a.class);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (com.tencent.mm.plugin.appbrand.widget.tabbar.a)getContainer().getDecorWidgetFactory().c(getContext(), com.tencent.mm.plugin.appbrand.widget.tabbar.a.class);
    }
    ((com.tencent.mm.plugin.appbrand.widget.tabbar.a)localObject1).setId(2131296776);
    localObject2 = getContainer().getAppConfig().aTn();
    ((com.tencent.mm.plugin.appbrand.widget.tabbar.a)localObject1).setPosition(((a.g)localObject2).jbI);
    ((com.tencent.mm.plugin.appbrand.widget.tabbar.a)localObject1).i(((a.g)localObject2).gHT, ((a.g)localObject2).jbJ, ((a.g)localObject2).jbK, ((a.g)localObject2).jbL);
    Iterator localIterator = ((a.g)localObject2).iq.iterator();
    while (localIterator.hasNext())
    {
      a.h localh = (a.h)localIterator.next();
      ((com.tencent.mm.plugin.appbrand.widget.tabbar.a)localObject1).a(localh.url, localh.text, localh.dub, localh.jbO, (AppBrandTabBarItem)parambc.aC(AppBrandTabBarItem.class));
    }
    ((com.tencent.mm.plugin.appbrand.widget.tabbar.a)localObject1).setClickListener(new j.5(this, (a.g)localObject2));
    AppMethodBeat.o(194492);
    return localObject1;
  }
  
  protected final void a(aa paramaa, AppBrandPageFullScreenView paramAppBrandPageFullScreenView)
  {
    AppMethodBeat.i(134994);
    if (paramaa == null)
    {
      ad.e("MicroMsg.AppBrandMultiplePage", "getCurrentFullScreenView err, pageView is null");
      AppMethodBeat.o(134994);
      return;
    }
    if ((paramAppBrandPageFullScreenView != null) && (paramAppBrandPageFullScreenView.getParent() == null) && ((this.jhz instanceof ViewGroup)))
    {
      this.jhz.addView(paramAppBrandPageFullScreenView, new ViewGroup.LayoutParams(-1, -1));
      this.kYB.put(paramaa.hashCode(), paramAppBrandPageFullScreenView);
    }
    AppMethodBeat.o(134994);
  }
  
  public final void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(134991);
    if ((this.kYz != null) && (f(paramArrayOfInt, this.kYz.aOd()))) {
      this.kYz.c(paramString1, paramString2, 0);
    }
    Iterator localIterator = this.kYA.values().iterator();
    while (localIterator.hasNext())
    {
      aa localaa = (aa)localIterator.next();
      if (f(paramArrayOfInt, localaa.aOd())) {
        localaa.c(paramString1, paramString2, 0);
      }
    }
    AppMethodBeat.o(134991);
  }
  
  public final Iterator<aa> bjg()
  {
    AppMethodBeat.i(134995);
    Iterator local8 = new Iterator()
    {
      private final Iterator<aa> kYJ;
      
      public final boolean hasNext()
      {
        AppMethodBeat.i(194489);
        boolean bool = this.kYJ.hasNext();
        AppMethodBeat.o(194489);
        return bool;
      }
      
      public final void remove()
      {
        AppMethodBeat.i(194490);
        UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(194490);
        throw localUnsupportedOperationException;
      }
    };
    AppMethodBeat.o(134995);
    return local8;
  }
  
  public final boolean cl(String paramString)
  {
    AppMethodBeat.i(134987);
    if (this.kYx.NZ(paramString) != -1)
    {
      AppMethodBeat.o(134987);
      return true;
    }
    AppMethodBeat.o(134987);
    return false;
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(134992);
    this.mDestroyed = true;
    super.cleanup();
    if (this.kYz != null) {
      this.kYz.cleanup();
    }
    Iterator localIterator = this.kYA.values().iterator();
    while (localIterator.hasNext()) {
      ((aa)localIterator.next()).cleanup();
    }
    gx(false);
    removeCallbacks(this.kYD);
    removeCallbacks(this.kYE);
    AppMethodBeat.o(134992);
  }
  
  /* Error */
  public final aa getCurrentPageView()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 495
    //   5: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 103	com/tencent/mm/plugin/appbrand/page/j:kYz	Lcom/tencent/mm/plugin/appbrand/page/aa;
    //   12: ifnull +18 -> 30
    //   15: aload_0
    //   16: getfield 103	com/tencent/mm/plugin/appbrand/page/j:kYz	Lcom/tencent/mm/plugin/appbrand/page/aa;
    //   19: astore_1
    //   20: ldc_w 495
    //   23: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: areturn
    //   30: aload_0
    //   31: getfield 67	com/tencent/mm/plugin/appbrand/page/j:kYA	Ljava/util/Map;
    //   34: aload_0
    //   35: getfield 497	com/tencent/mm/plugin/appbrand/page/j:kns	Ljava/lang/String;
    //   38: invokestatic 141	com/tencent/luggage/h/k:cA	(Ljava/lang/String;)Ljava/lang/String;
    //   41: invokeinterface 145 2 0
    //   46: checkcast 112	com/tencent/mm/plugin/appbrand/page/aa
    //   49: astore_1
    //   50: ldc_w 495
    //   53: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: goto -30 -> 26
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	j
    //   19	31	1	localaa	aa
    //   59	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	59	finally
    //   30	56	59	finally
  }
  
  public final String getCurrentUrl()
  {
    return this.kns;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.tabbar.a getTabBar()
  {
    return this.kYx;
  }
  
  public final void loadUrl(final String paramString)
  {
    AppMethodBeat.i(134982);
    ad.i("MicroMsg.AppBrandMultiplePage", "AppBrandPageProfile| loadUrl");
    if (paramString.equals(this.kns))
    {
      AppMethodBeat.o(134982);
      return;
    }
    int i = this.kYx.NZ(paramString);
    if (i < 0)
    {
      AppMethodBeat.o(134982);
      return;
    }
    gx(true);
    this.kns = paramString;
    this.kYx.vB(i);
    if (this.kYA.get(k.cA(paramString)) == null)
    {
      final aa localaa = Ls(k.cA(paramString));
      ad.i("MicroMsg.AppBrandMultiplePage", "loadAndWait appId[%s] url[%s]", new Object[] { getAppId(), paramString });
      final b local6 = new b(paramString)
      {
        public final void bjh()
        {
          AppMethodBeat.i(194486);
          j.a(j.this, paramString);
          j.this.getContainer().bjs();
          AppMethodBeat.o(194486);
        }
      };
      localaa.a(new f.f()
      {
        public final void onReady()
        {
          AppMethodBeat.i(194487);
          localaa.b(this);
          local6.run();
          long l1 = System.currentTimeMillis();
          long l2 = this.chA;
          ad.i("MicroMsg.AppBrandMultiplePage", "Tab[%s][%s] onReady received, time: %d", new Object[] { j.this.getAppId(), this.val$url, Long.valueOf(l1 - l2) });
          AppMethodBeat.o(194487);
        }
      });
      if (this.kYA.size() > 1)
      {
        this.kYF.addLast(local6);
        postDelayed(local6, 500L);
      }
      this.kYC = true;
      localaa.ct(paramString);
      AppMethodBeat.o(134982);
      return;
    }
    Lt(paramString);
    AppMethodBeat.o(134982);
  }
  
  public final void onDescendantInvalidated(View paramView1, View paramView2)
  {
    AppMethodBeat.i(134978);
    super.onDescendantInvalidated(paramView1, paramView2);
    if ((paramView2 instanceof com.tencent.mm.plugin.appbrand.widget.actionbar.d))
    {
      bjd();
      bje();
    }
    AppMethodBeat.o(134978);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134977);
    super.onMeasure(paramInt1, paramInt2);
    bjd();
    bje();
    AppMethodBeat.o(134977);
  }
  
  static abstract class b
    implements Runnable
  {
    private boolean kYK = false;
    boolean mCanceled = false;
    
    public abstract void bjh();
    
    public final void run()
    {
      if ((!this.kYK) && (!this.mCanceled)) {}
      for (int i = 1; i == 0; i = 0) {
        return;
      }
      this.kYK = true;
      bjh();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.j
 * JD-Core Version:    0.7.0.1
 */