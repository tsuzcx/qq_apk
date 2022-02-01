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
import com.tencent.mm.plugin.appbrand.widget.tabbar.AppBrandTabBarItem;
import com.tencent.mm.plugin.appbrand.widget.tabbar.a.b;
import com.tencent.mm.sdk.platformtools.ad;
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
  private ViewGroup kca;
  private com.tencent.mm.plugin.appbrand.widget.tabbar.a lZF;
  private FrameLayout lZG;
  private aa lZH;
  private Map<String, aa> lZI;
  private SparseArray<AppBrandPageFullScreenView> lZJ;
  private boolean lZK;
  private final Runnable lZL;
  private final Runnable lZM;
  private final LinkedList<b> lZN;
  private String lln;
  private boolean mDestroyed;
  
  public k(Context paramContext, u paramu)
  {
    super(paramContext, paramu);
    AppMethodBeat.i(134975);
    this.lZI = new HashMap();
    this.lZJ = new SparseArray();
    this.lZK = false;
    this.mDestroyed = false;
    this.lZL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134965);
        k.a(k.this);
        AppMethodBeat.o(134965);
      }
    };
    this.lZM = new Runnable()
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
        com.tencent.mm.plugin.appbrand.widget.actionbar.b localb = ((aa)localObject).bux();
        if (localb == null)
        {
          AppMethodBeat.o(134967);
          return;
        }
        localObject = ((aa)localObject).mcc;
        int i = localb.getTop();
        ((com.tencent.mm.plugin.appbrand.widget.e.b)localObject).wO(localb.getMeasuredHeight() + i);
        AppMethodBeat.o(134967);
      }
    };
    this.lZN = new LinkedList();
    this.lZH = getContainer().bui();
    AppMethodBeat.o(134975);
  }
  
  /* Error */
  private aa Td(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 112
    //   4: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 105	com/tencent/mm/plugin/appbrand/page/k:lZH	Lcom/tencent/mm/plugin/appbrand/page/aa;
    //   11: ifnull +51 -> 62
    //   14: aload_0
    //   15: getfield 105	com/tencent/mm/plugin/appbrand/page/k:lZH	Lcom/tencent/mm/plugin/appbrand/page/aa;
    //   18: astore_2
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 105	com/tencent/mm/plugin/appbrand/page/k:lZH	Lcom/tencent/mm/plugin/appbrand/page/aa;
    //   24: aload_2
    //   25: aload_0
    //   26: putfield 118	com/tencent/mm/plugin/appbrand/page/aa:mcd	Lcom/tencent/mm/plugin/appbrand/page/r;
    //   29: aload_0
    //   30: getfield 71	com/tencent/mm/plugin/appbrand/page/k:lZI	Ljava/util/Map;
    //   33: aload_1
    //   34: aload_2
    //   35: invokeinterface 124 3 0
    //   40: pop
    //   41: aload_0
    //   42: getfield 126	com/tencent/mm/plugin/appbrand/page/k:lZG	Landroid/widget/FrameLayout;
    //   45: aload_2
    //   46: getfield 128	com/tencent/mm/plugin/appbrand/page/aa:kca	Landroid/view/ViewGroup;
    //   49: iconst_0
    //   50: invokevirtual 134	android/widget/FrameLayout:addView	(Landroid/view/View;I)V
    //   53: ldc 112
    //   55: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_2
    //   61: areturn
    //   62: aload_0
    //   63: invokevirtual 97	com/tencent/mm/plugin/appbrand/page/k:getContainer	()Lcom/tencent/mm/plugin/appbrand/page/u;
    //   66: invokevirtual 103	com/tencent/mm/plugin/appbrand/page/u:bui	()Lcom/tencent/mm/plugin/appbrand/page/aa;
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
  
  private void Te(String paramString)
  {
    AppMethodBeat.i(134984);
    this.lZK = false;
    aa localaa2 = (aa)this.lZI.get(com.tencent.luggage.h.k.dr(paramString));
    localaa2.kca.setVisibility(4);
    paramString = null;
    Iterator localIterator = this.lZI.values().iterator();
    if (localIterator.hasNext())
    {
      aa localaa1 = (aa)localIterator.next();
      if ((localaa1.kca.getVisibility() != 0) || (localaa2 == localaa1)) {
        break label143;
      }
      paramString = localaa1;
    }
    label143:
    for (;;)
    {
      break;
      localaa2.kca.bringToFront();
      localaa2.kca.setVisibility(0);
      if (paramString != null) {
        paramString.kca.setVisibility(4);
      }
      if (paramString != null) {
        paramString.onBackground();
      }
      localaa2.onForeground();
      btX();
      AppMethodBeat.o(134984);
      return;
    }
  }
  
  private void btV()
  {
    AppMethodBeat.i(134979);
    if (this.mDestroyed)
    {
      AppMethodBeat.o(134979);
      return;
    }
    post(this.lZL);
    AppMethodBeat.o(134979);
  }
  
  private void btW()
  {
    AppMethodBeat.i(134980);
    if (this.mDestroyed)
    {
      AppMethodBeat.o(134980);
      return;
    }
    post(this.lZM);
    AppMethodBeat.o(134980);
  }
  
  private void btX()
  {
    AppMethodBeat.i(134985);
    if (this.lZJ.size() <= 0)
    {
      AppMethodBeat.o(134985);
      return;
    }
    int i = 0;
    while (i < this.lZJ.size())
    {
      ((AppBrandPageFullScreenView)this.lZJ.valueAt(i)).setVisibility(4);
      i += 1;
    }
    Object localObject = getCurrentPageView();
    if (localObject == null)
    {
      AppMethodBeat.o(134985);
      return;
    }
    localObject = (AppBrandPageFullScreenView)this.lZJ.get(localObject.hashCode());
    if (localObject != null) {
      ((AppBrandPageFullScreenView)localObject).setVisibility(0);
    }
    AppMethodBeat.o(134985);
  }
  
  private void hd(boolean paramBoolean)
  {
    AppMethodBeat.i(134986);
    Iterator localIterator = this.lZN.iterator();
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
    this.lZN.clear();
    AppMethodBeat.o(134986);
  }
  
  protected final View Dt()
  {
    AppMethodBeat.i(134976);
    Object localObject;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.kca == null)
    {
      localObject = new RelativeLayout(getContext());
      this.lZG = new FrameLayout(getContext());
      c.a("createTabBar", new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(197297);
          ax localax = (ax)k.this.getContainer().getRuntime().ab(ax.class);
          k.a(k.this, k.this.a(localax));
          AppMethodBeat.o(197297);
        }
      });
      if (getContainer().getAppConfig().bdK().jVZ) {
        this.lZF.setVisibility(8);
      }
      if (!"top".equals(getContainer().getAppConfig().bdK().jVV)) {
        break label170;
      }
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(10);
      ((RelativeLayout)localObject).addView(this.lZG, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(10);
      ((RelativeLayout)localObject).addView(this.lZF, localLayoutParams);
    }
    for (;;)
    {
      this.kca = ((ViewGroup)localObject);
      localObject = this.kca;
      AppMethodBeat.o(134976);
      return localObject;
      label170:
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(12);
      ((RelativeLayout)localObject).addView(this.lZF, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(2, this.lZF.getId());
      ((RelativeLayout)localObject).addView(this.lZG, localLayoutParams);
    }
  }
  
  protected final void Du()
  {
    AppMethodBeat.i(134990);
    super.Du();
    if (this.lZH != null) {
      this.lZH.onDestroy();
    }
    Iterator localIterator = this.lZI.values().iterator();
    while (localIterator.hasNext()) {
      ((aa)localIterator.next()).onDestroy();
    }
    AppMethodBeat.o(134990);
  }
  
  public final void Dv()
  {
    AppMethodBeat.i(134988);
    super.Dv();
    getCurrentPageView().onForeground();
    AppMethodBeat.o(134988);
  }
  
  public final void Dw()
  {
    AppMethodBeat.i(134989);
    super.Dw();
    getCurrentPageView().onBackground();
    AppMethodBeat.o(134989);
  }
  
  protected final com.tencent.mm.plugin.appbrand.widget.tabbar.a a(ax paramax)
  {
    AppMethodBeat.i(197305);
    Object localObject2 = (com.tencent.mm.plugin.appbrand.widget.tabbar.a)paramax.aC(com.tencent.mm.plugin.appbrand.widget.tabbar.a.class);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (com.tencent.mm.plugin.appbrand.widget.tabbar.a)getContainer().getDecorWidgetFactory().c(getContext(), com.tencent.mm.plugin.appbrand.widget.tabbar.a.class);
    }
    ((com.tencent.mm.plugin.appbrand.widget.tabbar.a)localObject1).setId(2131296776);
    localObject2 = getContainer().getAppConfig().bdK();
    ((com.tencent.mm.plugin.appbrand.widget.tabbar.a)localObject1).setPosition(((a.g)localObject2).jVV);
    ((com.tencent.mm.plugin.appbrand.widget.tabbar.a)localObject1).j(((a.g)localObject2).hAD, ((a.g)localObject2).jVW, ((a.g)localObject2).jVX, ((a.g)localObject2).jVY);
    Iterator localIterator = ((a.g)localObject2).lh.iterator();
    while (localIterator.hasNext())
    {
      a.h localh = (a.h)localIterator.next();
      ((com.tencent.mm.plugin.appbrand.widget.tabbar.a)localObject1).a(localh.url, localh.text, localh.dDH, localh.jWb, (AppBrandTabBarItem)paramax.aC(AppBrandTabBarItem.class));
    }
    ((com.tencent.mm.plugin.appbrand.widget.tabbar.a)localObject1).setClickListener(new a.b()
    {
      public final void ao(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(197298);
        k.this.getContainer().Tj(paramAnonymousString);
        HashMap localHashMap = new HashMap();
        localHashMap.put("pagePath", paramAnonymousString);
        localHashMap.put("text", ((a.h)this.lZP.lh.get(paramAnonymousInt)).text);
        localHashMap.put("index", Integer.valueOf(paramAnonymousInt));
        k.this.getCurrentPageView().b(new k.a().A(localHashMap));
        AppMethodBeat.o(197298);
      }
    });
    AppMethodBeat.o(197305);
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
    if ((paramAppBrandPageFullScreenView != null) && (paramAppBrandPageFullScreenView.getParent() == null) && ((this.kca instanceof ViewGroup)))
    {
      this.kca.addView(paramAppBrandPageFullScreenView, new ViewGroup.LayoutParams(-1, -1));
      this.lZJ.put(paramaa.hashCode(), paramAppBrandPageFullScreenView);
    }
    AppMethodBeat.o(134994);
  }
  
  public final void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(134991);
    if ((this.lZH != null) && (i(paramArrayOfInt, this.lZH.aXC()))) {
      this.lZH.c(paramString1, paramString2, 0);
    }
    Iterator localIterator = this.lZI.values().iterator();
    while (localIterator.hasNext())
    {
      aa localaa = (aa)localIterator.next();
      if (i(paramArrayOfInt, localaa.aXC())) {
        localaa.c(paramString1, paramString2, 0);
      }
    }
    AppMethodBeat.o(134991);
  }
  
  public final Iterator<aa> btY()
  {
    AppMethodBeat.i(134995);
    Iterator local8 = new Iterator()
    {
      private final Iterator<aa> lZR;
      
      public final boolean hasNext()
      {
        AppMethodBeat.i(197302);
        boolean bool = this.lZR.hasNext();
        AppMethodBeat.o(197302);
        return bool;
      }
      
      public final void remove()
      {
        AppMethodBeat.i(197303);
        UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(197303);
        throw localUnsupportedOperationException;
      }
    };
    AppMethodBeat.o(134995);
    return local8;
  }
  
  public final boolean cV(String paramString)
  {
    AppMethodBeat.i(134987);
    if (this.lZF.VF(paramString) != -1)
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
    if (this.lZH != null) {
      this.lZH.cleanup();
    }
    Iterator localIterator = this.lZI.values().iterator();
    while (localIterator.hasNext()) {
      ((aa)localIterator.next()).cleanup();
    }
    hd(false);
    removeCallbacks(this.lZL);
    removeCallbacks(this.lZM);
    AppMethodBeat.o(134992);
  }
  
  /* Error */
  public final aa getCurrentPageView()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 495
    //   5: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 105	com/tencent/mm/plugin/appbrand/page/k:lZH	Lcom/tencent/mm/plugin/appbrand/page/aa;
    //   12: ifnull +18 -> 30
    //   15: aload_0
    //   16: getfield 105	com/tencent/mm/plugin/appbrand/page/k:lZH	Lcom/tencent/mm/plugin/appbrand/page/aa;
    //   19: astore_1
    //   20: ldc_w 495
    //   23: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: areturn
    //   30: aload_0
    //   31: getfield 71	com/tencent/mm/plugin/appbrand/page/k:lZI	Ljava/util/Map;
    //   34: aload_0
    //   35: getfield 497	com/tencent/mm/plugin/appbrand/page/k:lln	Ljava/lang/String;
    //   38: invokestatic 143	com/tencent/luggage/h/k:dr	(Ljava/lang/String;)Ljava/lang/String;
    //   41: invokeinterface 147 2 0
    //   46: checkcast 114	com/tencent/mm/plugin/appbrand/page/aa
    //   49: astore_1
    //   50: ldc_w 495
    //   53: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    return this.lln;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.tabbar.a getTabBar()
  {
    return this.lZF;
  }
  
  public final void loadUrl(final String paramString)
  {
    AppMethodBeat.i(134982);
    ad.i("MicroMsg.AppBrandMultiplePage", "AppBrandPageProfile| loadUrl");
    if (paramString.equals(this.lln))
    {
      AppMethodBeat.o(134982);
      return;
    }
    int i = this.lZF.VF(paramString);
    if (i < 0)
    {
      AppMethodBeat.o(134982);
      return;
    }
    hd(true);
    this.lln = paramString;
    this.lZF.wX(i);
    if (this.lZI.get(com.tencent.luggage.h.k.dr(paramString)) == null)
    {
      final aa localaa = Td(com.tencent.luggage.h.k.dr(paramString));
      ad.i("MicroMsg.AppBrandMultiplePage", "loadAndWait appId[%s] url[%s]", new Object[] { getAppId(), paramString });
      final b local6 = new b(paramString)
      {
        public final void btZ()
        {
          AppMethodBeat.i(197299);
          k.a(k.this, paramString);
          k.this.getContainer().buk();
          AppMethodBeat.o(197299);
        }
      };
      localaa.a(new f.f()
      {
        public final void onReady()
        {
          AppMethodBeat.i(197300);
          localaa.b(this);
          local6.run();
          long l1 = System.currentTimeMillis();
          long l2 = this.coM;
          ad.i("MicroMsg.AppBrandMultiplePage", "Tab[%s][%s] onReady received, time: %d", new Object[] { k.this.getAppId(), this.val$url, Long.valueOf(l1 - l2) });
          AppMethodBeat.o(197300);
        }
      });
      if (this.lZI.size() > 1)
      {
        this.lZN.addLast(local6);
        postDelayed(local6, 500L);
      }
      this.lZK = true;
      localaa.dk(paramString);
      AppMethodBeat.o(134982);
      return;
    }
    Te(paramString);
    AppMethodBeat.o(134982);
  }
  
  public final void onDescendantInvalidated(View paramView1, View paramView2)
  {
    AppMethodBeat.i(134978);
    super.onDescendantInvalidated(paramView1, paramView2);
    if ((paramView2 instanceof com.tencent.mm.plugin.appbrand.widget.actionbar.d))
    {
      btV();
      btW();
    }
    AppMethodBeat.o(134978);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134977);
    super.onMeasure(paramInt1, paramInt2);
    btV();
    btW();
    AppMethodBeat.o(134977);
  }
  
  static abstract class b
    implements Runnable
  {
    private boolean lZS = false;
    boolean mCanceled = false;
    
    public abstract void btZ();
    
    public final void run()
    {
      if ((!this.lZS) && (!this.mCanceled)) {}
      for (int i = 1; i == 0; i = 0) {
        return;
      }
      this.lZS = true;
      btZ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.k
 * JD-Core Version:    0.7.0.1
 */