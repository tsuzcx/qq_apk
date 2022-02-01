package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.t;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.luggage.sdk.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.a.g;
import com.tencent.mm.plugin.appbrand.config.a.h;
import com.tencent.mm.plugin.appbrand.jsapi.f.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.widget.tabbar.AppBrandTabBarItem;
import com.tencent.mm.plugin.appbrand.widget.tabbar.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@SuppressLint({"ViewConstructor"})
public final class k
  extends r
{
  private ViewGroup jHO;
  private String kOK;
  private com.tencent.mm.plugin.appbrand.widget.tabbar.a lAh;
  private FrameLayout lAi;
  private aa lAj;
  private Map<String, aa> lAk;
  private SparseArray<AppBrandPageFullScreenView> lAl;
  private boolean lAm;
  private final Runnable lAn;
  private final Runnable lAo;
  private final LinkedList<b> lAp;
  private boolean mDestroyed;
  
  public k(Context paramContext, u paramu)
  {
    super(paramContext, paramu);
    AppMethodBeat.i(134975);
    this.lAk = new HashMap();
    this.lAl = new SparseArray();
    this.lAm = false;
    this.mDestroyed = false;
    this.lAn = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134965);
        k.a(k.this);
        AppMethodBeat.o(134965);
      }
    };
    this.lAo = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134967);
        if (k.c(k.this))
        {
          AppMethodBeat.o(134967);
          return;
        }
        Object localObject = k.this.getCurrentPageView();
        if (localObject == null)
        {
          AppMethodBeat.o(134967);
          return;
        }
        com.tencent.mm.plugin.appbrand.widget.actionbar.b localb = ((aa)localObject).bqy();
        if (localb == null)
        {
          AppMethodBeat.o(134967);
          return;
        }
        localObject = ((aa)localObject).lCB;
        int i = localb.getTop();
        ((com.tencent.mm.plugin.appbrand.widget.e.b)localObject).wj(localb.getMeasuredHeight() + i);
        AppMethodBeat.o(134967);
      }
    };
    this.lAp = new LinkedList();
    this.lAj = getContainer().bqi();
    AppMethodBeat.o(134975);
  }
  
  /* Error */
  private aa PA(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 113
    //   4: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 106	com/tencent/mm/plugin/appbrand/page/k:lAj	Lcom/tencent/mm/plugin/appbrand/page/aa;
    //   11: ifnull +51 -> 62
    //   14: aload_0
    //   15: getfield 106	com/tencent/mm/plugin/appbrand/page/k:lAj	Lcom/tencent/mm/plugin/appbrand/page/aa;
    //   18: astore_2
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 106	com/tencent/mm/plugin/appbrand/page/k:lAj	Lcom/tencent/mm/plugin/appbrand/page/aa;
    //   24: aload_2
    //   25: aload_0
    //   26: putfield 119	com/tencent/mm/plugin/appbrand/page/aa:lCC	Lcom/tencent/mm/plugin/appbrand/page/r;
    //   29: aload_0
    //   30: getfield 72	com/tencent/mm/plugin/appbrand/page/k:lAk	Ljava/util/Map;
    //   33: aload_1
    //   34: aload_2
    //   35: invokeinterface 125 3 0
    //   40: pop
    //   41: aload_0
    //   42: getfield 127	com/tencent/mm/plugin/appbrand/page/k:lAi	Landroid/widget/FrameLayout;
    //   45: aload_2
    //   46: getfield 129	com/tencent/mm/plugin/appbrand/page/aa:jHO	Landroid/view/ViewGroup;
    //   49: iconst_0
    //   50: invokevirtual 135	android/widget/FrameLayout:addView	(Landroid/view/View;I)V
    //   53: ldc 113
    //   55: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_2
    //   61: areturn
    //   62: aload_0
    //   63: invokevirtual 98	com/tencent/mm/plugin/appbrand/page/k:getContainer	()Lcom/tencent/mm/plugin/appbrand/page/u;
    //   66: invokevirtual 104	com/tencent/mm/plugin/appbrand/page/u:bqi	()Lcom/tencent/mm/plugin/appbrand/page/aa;
    //   69: astore_2
    //   70: goto -46 -> 24
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	k
    //   0	78	1	paramString	String
    //   18	52	2	localaa	aa
    // Exception table:
    //   from	to	target	type
    //   2	24	73	finally
    //   24	58	73	finally
    //   62	70	73	finally
  }
  
  private void PB(String paramString)
  {
    AppMethodBeat.i(134984);
    this.lAm = false;
    aa localaa2 = (aa)this.lAk.get(com.tencent.luggage.h.k.cp(paramString));
    localaa2.jHO.setVisibility(4);
    paramString = null;
    Iterator localIterator = this.lAk.values().iterator();
    if (localIterator.hasNext())
    {
      aa localaa1 = (aa)localIterator.next();
      if ((localaa1.jHO.getVisibility() != 0) || (localaa2 == localaa1)) {
        break label143;
      }
      paramString = localaa1;
    }
    label143:
    for (;;)
    {
      break;
      localaa2.jHO.bringToFront();
      localaa2.jHO.setVisibility(0);
      if (paramString != null) {
        paramString.jHO.setVisibility(4);
      }
      if (paramString != null) {
        paramString.onBackground();
      }
      localaa2.onForeground();
      bpX();
      AppMethodBeat.o(134984);
      return;
    }
  }
  
  private void bpV()
  {
    AppMethodBeat.i(134979);
    if (this.mDestroyed)
    {
      AppMethodBeat.o(134979);
      return;
    }
    post(this.lAn);
    AppMethodBeat.o(134979);
  }
  
  private void bpW()
  {
    AppMethodBeat.i(134980);
    if (this.mDestroyed)
    {
      AppMethodBeat.o(134980);
      return;
    }
    post(this.lAo);
    AppMethodBeat.o(134980);
  }
  
  private void bpX()
  {
    AppMethodBeat.i(134985);
    if (this.lAl.size() <= 0)
    {
      AppMethodBeat.o(134985);
      return;
    }
    int i = 0;
    while (i < this.lAl.size())
    {
      ((AppBrandPageFullScreenView)this.lAl.valueAt(i)).setVisibility(4);
      i += 1;
    }
    Object localObject = getCurrentPageView();
    if (localObject == null)
    {
      AppMethodBeat.o(134985);
      return;
    }
    localObject = (AppBrandPageFullScreenView)this.lAl.get(localObject.hashCode());
    if (localObject != null) {
      ((AppBrandPageFullScreenView)localObject).setVisibility(0);
    }
    AppMethodBeat.o(134985);
  }
  
  private void gU(boolean paramBoolean)
  {
    AppMethodBeat.i(134986);
    Iterator localIterator = this.lAp.iterator();
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
    this.lAp.clear();
    AppMethodBeat.o(134986);
  }
  
  protected final View BU()
  {
    AppMethodBeat.i(134976);
    Object localObject;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jHO == null)
    {
      localObject = new RelativeLayout(getContext());
      this.lAi = new FrameLayout(getContext());
      c.a("createTabBar", new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(193404);
          ax localax = (ax)k.this.getContainer().getRuntime().ab(ax.class);
          k.a(k.this, k.this.a(localax));
          AppMethodBeat.o(193404);
        }
      });
      if (getContainer().getAppConfig().bal().jBZ) {
        this.lAh.setVisibility(8);
      }
      if (!"top".equals(getContainer().getAppConfig().bal().jBV)) {
        break label170;
      }
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(10);
      ((RelativeLayout)localObject).addView(this.lAi, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(10);
      ((RelativeLayout)localObject).addView(this.lAh, localLayoutParams);
    }
    for (;;)
    {
      this.jHO = ((ViewGroup)localObject);
      localObject = this.jHO;
      AppMethodBeat.o(134976);
      return localObject;
      label170:
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(12);
      ((RelativeLayout)localObject).addView(this.lAh, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(2, this.lAh.getId());
      ((RelativeLayout)localObject).addView(this.lAi, localLayoutParams);
    }
  }
  
  protected final void BV()
  {
    AppMethodBeat.i(134990);
    super.BV();
    if (this.lAj != null) {
      this.lAj.onDestroy();
    }
    Iterator localIterator = this.lAk.values().iterator();
    while (localIterator.hasNext()) {
      ((aa)localIterator.next()).onDestroy();
    }
    AppMethodBeat.o(134990);
  }
  
  public final void BW()
  {
    AppMethodBeat.i(134988);
    super.BW();
    getCurrentPageView().onForeground();
    AppMethodBeat.o(134988);
  }
  
  public final void BX()
  {
    AppMethodBeat.i(134989);
    super.BX();
    getCurrentPageView().onBackground();
    AppMethodBeat.o(134989);
  }
  
  protected final com.tencent.mm.plugin.appbrand.widget.tabbar.a a(ax paramax)
  {
    AppMethodBeat.i(193412);
    Object localObject2 = (com.tencent.mm.plugin.appbrand.widget.tabbar.a)paramax.aC(com.tencent.mm.plugin.appbrand.widget.tabbar.a.class);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (com.tencent.mm.plugin.appbrand.widget.tabbar.a)getContainer().getDecorWidgetFactory().c(getContext(), com.tencent.mm.plugin.appbrand.widget.tabbar.a.class);
    }
    ((com.tencent.mm.plugin.appbrand.widget.tabbar.a)localObject1).setId(2131296776);
    localObject2 = getContainer().getAppConfig().bal();
    ((com.tencent.mm.plugin.appbrand.widget.tabbar.a)localObject1).setPosition(((a.g)localObject2).jBV);
    ((com.tencent.mm.plugin.appbrand.widget.tabbar.a)localObject1).k(((a.g)localObject2).hiu, ((a.g)localObject2).jBW, ((a.g)localObject2).jBX, ((a.g)localObject2).jBY);
    Iterator localIterator = ((a.g)localObject2).jq.iterator();
    while (localIterator.hasNext())
    {
      a.h localh = (a.h)localIterator.next();
      ((com.tencent.mm.plugin.appbrand.widget.tabbar.a)localObject1).a(localh.url, localh.text, localh.drM, localh.jCb, (AppBrandTabBarItem)paramax.aC(AppBrandTabBarItem.class));
    }
    ((com.tencent.mm.plugin.appbrand.widget.tabbar.a)localObject1).setClickListener(new a.b()
    {
      public final void am(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(193405);
        k.this.getContainer().PG(paramAnonymousString);
        HashMap localHashMap = new HashMap();
        localHashMap.put("pagePath", paramAnonymousString);
        localHashMap.put("text", ((a.h)this.lAr.jq.get(paramAnonymousInt)).text);
        localHashMap.put("index", Integer.valueOf(paramAnonymousInt));
        k.this.getCurrentPageView().b(new k.a().A(localHashMap));
        AppMethodBeat.o(193405);
      }
    });
    AppMethodBeat.o(193412);
    return localObject1;
  }
  
  protected final void a(aa paramaa, AppBrandPageFullScreenView paramAppBrandPageFullScreenView)
  {
    AppMethodBeat.i(134994);
    if (paramaa == null)
    {
      ac.e("MicroMsg.AppBrandMultiplePage", "getCurrentFullScreenView err, pageView is null");
      AppMethodBeat.o(134994);
      return;
    }
    if ((paramAppBrandPageFullScreenView != null) && (paramAppBrandPageFullScreenView.getParent() == null) && ((this.jHO instanceof ViewGroup)))
    {
      this.jHO.addView(paramAppBrandPageFullScreenView, new ViewGroup.LayoutParams(-1, -1));
      this.lAl.put(paramaa.hashCode(), paramAppBrandPageFullScreenView);
    }
    AppMethodBeat.o(134994);
  }
  
  public final void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(134991);
    if ((this.lAj != null) && (i(paramArrayOfInt, this.lAj.aUT()))) {
      this.lAj.c(paramString1, paramString2, 0);
    }
    Iterator localIterator = this.lAk.values().iterator();
    while (localIterator.hasNext())
    {
      aa localaa = (aa)localIterator.next();
      if (i(paramArrayOfInt, localaa.aUT())) {
        localaa.c(paramString1, paramString2, 0);
      }
    }
    AppMethodBeat.o(134991);
  }
  
  public final Iterator<aa> bpY()
  {
    AppMethodBeat.i(134995);
    Iterator local8 = new Iterator()
    {
      private final Iterator<aa> lAt;
      
      public final boolean hasNext()
      {
        AppMethodBeat.i(193409);
        boolean bool = this.lAt.hasNext();
        AppMethodBeat.o(193409);
        return bool;
      }
      
      public final void remove()
      {
        AppMethodBeat.i(193410);
        UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(193410);
        throw localUnsupportedOperationException;
      }
    };
    AppMethodBeat.o(134995);
    return local8;
  }
  
  public final boolean cb(String paramString)
  {
    AppMethodBeat.i(134987);
    if (this.lAh.Si(paramString) != -1)
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
    if (this.lAj != null) {
      this.lAj.cleanup();
    }
    Iterator localIterator = this.lAk.values().iterator();
    while (localIterator.hasNext()) {
      ((aa)localIterator.next()).cleanup();
    }
    gU(false);
    removeCallbacks(this.lAn);
    removeCallbacks(this.lAo);
    AppMethodBeat.o(134992);
  }
  
  /* Error */
  public final aa getCurrentPageView()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 495
    //   5: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 106	com/tencent/mm/plugin/appbrand/page/k:lAj	Lcom/tencent/mm/plugin/appbrand/page/aa;
    //   12: ifnull +18 -> 30
    //   15: aload_0
    //   16: getfield 106	com/tencent/mm/plugin/appbrand/page/k:lAj	Lcom/tencent/mm/plugin/appbrand/page/aa;
    //   19: astore_1
    //   20: ldc_w 495
    //   23: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: areturn
    //   30: aload_0
    //   31: getfield 72	com/tencent/mm/plugin/appbrand/page/k:lAk	Ljava/util/Map;
    //   34: aload_0
    //   35: getfield 497	com/tencent/mm/plugin/appbrand/page/k:kOK	Ljava/lang/String;
    //   38: invokestatic 144	com/tencent/luggage/h/k:cp	(Ljava/lang/String;)Ljava/lang/String;
    //   41: invokeinterface 148 2 0
    //   46: checkcast 115	com/tencent/mm/plugin/appbrand/page/aa
    //   49: astore_1
    //   50: ldc_w 495
    //   53: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: goto -30 -> 26
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	k
    //   19	31	1	localaa	aa
    //   59	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	59	finally
    //   30	56	59	finally
  }
  
  public final String getCurrentUrl()
  {
    return this.kOK;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.tabbar.a getTabBar()
  {
    return this.lAh;
  }
  
  public final void loadUrl(final String paramString)
  {
    AppMethodBeat.i(134982);
    ac.i("MicroMsg.AppBrandMultiplePage", "AppBrandPageProfile| loadUrl");
    if (paramString.equals(this.kOK))
    {
      AppMethodBeat.o(134982);
      return;
    }
    int i = this.lAh.Si(paramString);
    if (i < 0)
    {
      AppMethodBeat.o(134982);
      return;
    }
    gU(true);
    this.kOK = paramString;
    this.lAh.ws(i);
    if (this.lAk.get(com.tencent.luggage.h.k.cp(paramString)) == null)
    {
      final aa localaa = PA(com.tencent.luggage.h.k.cp(paramString));
      ac.i("MicroMsg.AppBrandMultiplePage", "loadAndWait appId[%s] url[%s]", new Object[] { getAppId(), paramString });
      final b local6 = new b(paramString)
      {
        public final void bpZ()
        {
          AppMethodBeat.i(193406);
          k.a(k.this, paramString);
          k.this.getContainer().bqk();
          AppMethodBeat.o(193406);
        }
      };
      localaa.a(new f.f()
      {
        public final void onReady()
        {
          AppMethodBeat.i(193407);
          localaa.b(this);
          local6.run();
          long l1 = System.currentTimeMillis();
          long l2 = this.cev;
          ac.i("MicroMsg.AppBrandMultiplePage", "Tab[%s][%s] onReady received, time: %d", new Object[] { k.this.getAppId(), this.val$url, Long.valueOf(l1 - l2) });
          AppMethodBeat.o(193407);
        }
      });
      if (this.lAk.size() > 1)
      {
        this.lAp.addLast(local6);
        postDelayed(local6, 500L);
      }
      this.lAm = true;
      localaa.ci(paramString);
      AppMethodBeat.o(134982);
      return;
    }
    PB(paramString);
    AppMethodBeat.o(134982);
  }
  
  public final void onDescendantInvalidated(View paramView1, View paramView2)
  {
    AppMethodBeat.i(134978);
    super.onDescendantInvalidated(paramView1, paramView2);
    if ((paramView2 instanceof com.tencent.mm.plugin.appbrand.widget.actionbar.d))
    {
      bpV();
      bpW();
    }
    AppMethodBeat.o(134978);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134977);
    super.onMeasure(paramInt1, paramInt2);
    bpV();
    bpW();
    AppMethodBeat.o(134977);
  }
  
  public static final class a
    extends p
  {
    private static final int CTRL_INDEX = 390;
    private static final String NAME = "onTabItemTap";
  }
  
  static abstract class b
    implements Runnable
  {
    private boolean lAu = false;
    boolean mCanceled = false;
    
    public abstract void bpZ();
    
    public final void run()
    {
      if ((!this.lAu) && (!this.mCanceled)) {}
      for (int i = 1; i == 0; i = 0) {
        return;
      }
      this.lAu = true;
      bpZ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.k
 * JD-Core Version:    0.7.0.1
 */