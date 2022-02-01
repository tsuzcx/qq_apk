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
import androidx.core.g.w;
import com.tencent.luggage.k.l;
import com.tencent.luggage.wxa.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.b.g;
import com.tencent.mm.plugin.appbrand.config.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.h.f;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.widget.tabbar.AppBrandTabBarItem;
import com.tencent.mm.plugin.appbrand.widget.tabbar.a;
import com.tencent.mm.plugin.appbrand.widget.tabbar.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@SuppressLint({"ViewConstructor"})
public final class n
  extends u
{
  private boolean mDestroyed;
  private ViewGroup odJ;
  private String puQ;
  private a qpY;
  private FrameLayout qpZ;
  private ad qqa;
  private Map<String, ad> qqb;
  private SparseArray<AppBrandPageFullScreenView> qqc;
  private boolean qqd;
  private final Runnable qqe;
  private final Runnable qqf;
  private final LinkedList<c> qqg;
  
  public n(Context paramContext, x paramx)
  {
    super(paramContext, paramx);
    AppMethodBeat.i(134975);
    this.qqb = new HashMap();
    this.qqc = new SparseArray();
    this.qqd = false;
    this.mDestroyed = false;
    this.qqe = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134965);
        n.a(n.this);
        AppMethodBeat.o(134965);
      }
    };
    this.qqf = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134967);
        if (n.c(n.this))
        {
          AppMethodBeat.o(134967);
          return;
        }
        Object localObject = n.this.getCurrentPageView();
        if (localObject == null)
        {
          AppMethodBeat.o(134967);
          return;
        }
        com.tencent.mm.plugin.appbrand.widget.actionbar.b localb = ((ad)localObject).cdY();
        if (localb == null)
        {
          AppMethodBeat.o(134967);
          return;
        }
        localObject = ((ad)localObject).qsF;
        int i = localb.getTop();
        ((com.tencent.mm.plugin.appbrand.widget.g.b)localObject).Ei(localb.getMeasuredHeight() + i);
        AppMethodBeat.o(134967);
      }
    };
    this.qqg = new LinkedList();
    this.qqa = getContainer().cdJ();
    AppMethodBeat.o(134975);
  }
  
  /* Error */
  private ad alu(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 185
    //   4: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 113	com/tencent/mm/plugin/appbrand/page/n:qqa	Lcom/tencent/mm/plugin/appbrand/page/ad;
    //   11: ifnull +51 -> 62
    //   14: aload_0
    //   15: getfield 113	com/tencent/mm/plugin/appbrand/page/n:qqa	Lcom/tencent/mm/plugin/appbrand/page/ad;
    //   18: astore_2
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 113	com/tencent/mm/plugin/appbrand/page/n:qqa	Lcom/tencent/mm/plugin/appbrand/page/ad;
    //   24: aload_2
    //   25: aload_0
    //   26: putfield 189	com/tencent/mm/plugin/appbrand/page/ad:qsG	Lcom/tencent/mm/plugin/appbrand/page/u;
    //   29: aload_0
    //   30: getfield 79	com/tencent/mm/plugin/appbrand/page/n:qqb	Ljava/util/Map;
    //   33: aload_1
    //   34: aload_2
    //   35: invokeinterface 195 3 0
    //   40: pop
    //   41: aload_0
    //   42: getfield 197	com/tencent/mm/plugin/appbrand/page/n:qpZ	Landroid/widget/FrameLayout;
    //   45: aload_2
    //   46: invokevirtual 201	com/tencent/mm/plugin/appbrand/page/ad:getContentView	()Landroid/view/View;
    //   49: iconst_0
    //   50: invokevirtual 207	android/widget/FrameLayout:addView	(Landroid/view/View;I)V
    //   53: ldc 185
    //   55: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_2
    //   61: areturn
    //   62: aload_0
    //   63: invokevirtual 105	com/tencent/mm/plugin/appbrand/page/n:getContainer	()Lcom/tencent/mm/plugin/appbrand/page/x;
    //   66: invokevirtual 111	com/tencent/mm/plugin/appbrand/page/x:cdJ	()Lcom/tencent/mm/plugin/appbrand/page/ad;
    //   69: astore_2
    //   70: goto -46 -> 24
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	n
    //   0	78	1	paramString	String
    //   18	52	2	localad	ad
    // Exception table:
    //   from	to	target	type
    //   2	24	73	finally
    //   24	58	73	finally
    //   62	70	73	finally
  }
  
  private void alv(String paramString)
  {
    AppMethodBeat.i(134984);
    this.qqd = false;
    ad localad2 = (ad)this.qqb.get(l.eo(paramString));
    localad2.getContentView().setVisibility(4);
    paramString = null;
    Iterator localIterator = this.qqb.values().iterator();
    if (localIterator.hasNext())
    {
      ad localad1 = (ad)localIterator.next();
      if ((localad1.getContentView().getVisibility() != 0) || (localad2 == localad1)) {
        break label143;
      }
      paramString = localad1;
    }
    label143:
    for (;;)
    {
      break;
      localad2.getContentView().bringToFront();
      localad2.getContentView().setVisibility(0);
      if (paramString != null) {
        paramString.getContentView().setVisibility(4);
      }
      if (paramString != null) {
        paramString.onBackground();
      }
      localad2.onForeground();
      cdy();
      AppMethodBeat.o(134984);
      return;
    }
  }
  
  private void cdw()
  {
    AppMethodBeat.i(134979);
    if (this.mDestroyed)
    {
      AppMethodBeat.o(134979);
      return;
    }
    post(this.qqe);
    AppMethodBeat.o(134979);
  }
  
  private void cdx()
  {
    AppMethodBeat.i(134980);
    if (this.mDestroyed)
    {
      AppMethodBeat.o(134980);
      return;
    }
    post(this.qqf);
    AppMethodBeat.o(134980);
  }
  
  private void cdy()
  {
    AppMethodBeat.i(134985);
    if (this.qqc.size() <= 0)
    {
      AppMethodBeat.o(134985);
      return;
    }
    int i = 0;
    while (i < this.qqc.size())
    {
      ((AppBrandPageFullScreenView)this.qqc.valueAt(i)).setVisibility(4);
      i += 1;
    }
    Object localObject = getCurrentPageView();
    if (localObject == null)
    {
      AppMethodBeat.o(134985);
      return;
    }
    localObject = (AppBrandPageFullScreenView)this.qqc.get(localObject.hashCode());
    if (localObject != null) {
      ((AppBrandPageFullScreenView)localObject).setVisibility(0);
    }
    AppMethodBeat.o(134985);
  }
  
  private void jc(boolean paramBoolean)
  {
    AppMethodBeat.i(134986);
    Iterator localIterator = this.qqg.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      removeCallbacks(localc);
      if (paramBoolean) {
        localc.run();
      } else {
        localc.mCanceled = true;
      }
    }
    this.qqg.clear();
    AppMethodBeat.o(134986);
  }
  
  protected final View PL()
  {
    AppMethodBeat.i(134976);
    Object localObject;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.odJ == null)
    {
      localObject = new RelativeLayout(getContext());
      this.qpZ = new FrameLayout(getContext());
      com.tencent.luggage.sdk.h.d.a("createTabBar", new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(242654);
          bc localbc = (bc)n.this.getContainer().getRuntime().ae(bc.class);
          n.a(n.this, n.this.a(localbc));
          AppMethodBeat.o(242654);
        }
      });
      if (getContainer().getAppConfig().bKV().nWz) {
        this.qpY.setVisibility(8);
      }
      if (!"top".equals(getContainer().getAppConfig().bKV().nWv)) {
        break label170;
      }
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(10);
      ((RelativeLayout)localObject).addView(this.qpZ, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(10);
      ((RelativeLayout)localObject).addView(this.qpY, localLayoutParams);
    }
    for (;;)
    {
      this.odJ = ((ViewGroup)localObject);
      localObject = this.odJ;
      AppMethodBeat.o(134976);
      return localObject;
      label170:
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(12);
      ((RelativeLayout)localObject).addView(this.qpY, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(2, this.qpY.getId());
      ((RelativeLayout)localObject).addView(this.qpZ, localLayoutParams);
    }
  }
  
  protected final void PM()
  {
    AppMethodBeat.i(134990);
    super.PM();
    if (this.qqa != null) {
      this.qqa.onDestroy();
    }
    Iterator localIterator = this.qqb.values().iterator();
    while (localIterator.hasNext()) {
      ((ad)localIterator.next()).onDestroy();
    }
    AppMethodBeat.o(134990);
  }
  
  public final void PN()
  {
    AppMethodBeat.i(134988);
    super.PN();
    getCurrentPageView().onForeground();
    AppMethodBeat.o(134988);
  }
  
  public final void PO()
  {
    AppMethodBeat.i(134989);
    super.PO();
    getCurrentPageView().onBackground();
    AppMethodBeat.o(134989);
  }
  
  protected final a a(bc parambc)
  {
    AppMethodBeat.i(244213);
    Object localObject2 = (a)parambc.a(a.class, getContext());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (a)getContainer().getDecorWidgetFactory().d(getContext(), a.class);
    }
    ((a)localObject1).setId(a.d.app_brand_multi_page_tabbar);
    localObject2 = getContainer().getAppConfig().bKV();
    ((a)localObject1).setPosition(((b.g)localObject2).nWv);
    ((a)localObject1).m(((b.g)localObject2).lmL, ((b.g)localObject2).nWw, ((b.g)localObject2).nWx, ((b.g)localObject2).nWy);
    Iterator localIterator = ((b.g)localObject2).bCM.iterator();
    while (localIterator.hasNext())
    {
      b.h localh = (b.h)localIterator.next();
      ((a)localObject1).a(localh.url, localh.text, localh.icon, localh.nWB, (AppBrandTabBarItem)parambc.a(AppBrandTabBarItem.class, getContext()));
    }
    ((a)localObject1).setClickListener(new a.b()
    {
      public final void as(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(243339);
        n.this.getContainer().alz(paramAnonymousString);
        HashMap localHashMap = new HashMap();
        localHashMap.put("pagePath", paramAnonymousString);
        localHashMap.put("text", ((b.h)this.qqi.bCM.get(paramAnonymousInt)).text);
        localHashMap.put("index", Integer.valueOf(paramAnonymousInt));
        n.this.getCurrentPageView().a(new n.a().D(localHashMap), null);
        AppMethodBeat.o(243339);
      }
    });
    AppMethodBeat.o(244213);
    return localObject1;
  }
  
  protected final void a(ad paramad, AppBrandPageFullScreenView paramAppBrandPageFullScreenView)
  {
    AppMethodBeat.i(134994);
    if (paramad == null)
    {
      Log.e("MicroMsg.AppBrandMultiplePage", "getCurrentFullScreenView err, pageView is null");
      AppMethodBeat.o(134994);
      return;
    }
    if ((paramAppBrandPageFullScreenView != null) && (paramAppBrandPageFullScreenView.getParent() == null) && ((this.odJ instanceof ViewGroup)))
    {
      this.odJ.addView(paramAppBrandPageFullScreenView, new ViewGroup.LayoutParams(-1, -1));
      this.qqc.put(paramad.hashCode(), paramAppBrandPageFullScreenView);
    }
    AppMethodBeat.o(134994);
  }
  
  public final void a(String paramString, ca paramca)
  {
    AppMethodBeat.i(244216);
    a(paramString, null, paramca);
    AppMethodBeat.o(244216);
  }
  
  public final void a(final String paramString, final b paramb, ca paramca)
  {
    AppMethodBeat.i(244215);
    Log.i("MicroMsg.AppBrandMultiplePage", "AppBrandPageProfile| loadUrl, appId:%s, url:%s", new Object[] { getAppId(), paramString });
    if (paramString.equals(this.puQ))
    {
      if (paramb != null)
      {
        paramb.b(this, paramString);
        paramb.e(this);
      }
      AppMethodBeat.o(244215);
      return;
    }
    int i = this.qpY.anN(paramString);
    if (i < 0)
    {
      Log.e("MicroMsg.AppBrandMultiplePage", "loadUrl, index not found, appId:%s, url:%s", new Object[] { getAppId(), paramString });
      AppMethodBeat.o(244215);
      return;
    }
    jc(true);
    this.puQ = paramString;
    this.qpY.Eo(i);
    if (this.qqb.get(l.eo(paramString)) == null)
    {
      final ad localad = alu(l.eo(paramString));
      final boolean[] arrayOfBoolean = new boolean[1];
      Object localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(244350);
          if (paramb != null)
          {
            if (arrayOfBoolean[0] == 0)
            {
              n.this.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(244344);
                  n.6.this.qqj.e(n.this);
                  AppMethodBeat.o(244344);
                }
              });
              AppMethodBeat.o(244350);
              return;
            }
            paramb.e(n.this);
          }
          AppMethodBeat.o(244350);
        }
      };
      Log.i("MicroMsg.AppBrandMultiplePage", "loadAndWait appId[%s] url[%s]", new Object[] { getAppId(), paramString });
      localObject = new c(paramString)
      {
        public final void cdA()
        {
          AppMethodBeat.i(243570);
          n.a(n.this, paramString);
          if (this.qqm != null) {
            this.qqm.run();
          }
          AppMethodBeat.o(243570);
        }
      };
      localad.a(new h.f()
      {
        public final void NR()
        {
          AppMethodBeat.i(243676);
          localad.b(this);
          this.qqn.run();
          long l1 = System.currentTimeMillis();
          long l2 = this.cAj;
          Log.i("MicroMsg.AppBrandMultiplePage", "Tab[%s][%s] onReady received, time: %d", new Object[] { n.this.getAppId(), this.val$url, Long.valueOf(l1 - l2) });
          AppMethodBeat.o(243676);
        }
      });
      if (this.qqb.size() > 1)
      {
        this.qqg.addLast(localObject);
        postDelayed((Runnable)localObject, 500L);
      }
      this.qqd = true;
      localad.c(paramString, paramca);
      if (paramb != null)
      {
        paramb.b(this, paramString);
        arrayOfBoolean[0] = true;
      }
      AppMethodBeat.o(244215);
      return;
    }
    if (paramb != null) {
      paramb.b(this, paramString);
    }
    alv(paramString);
    if (paramb != null) {
      paramb.e(this);
    }
    AppMethodBeat.o(244215);
  }
  
  public final void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(134991);
    if ((this.qqa != null) && (i(paramArrayOfInt, this.qqa.getComponentId()))) {
      this.qqa.ct(paramString1, paramString2);
    }
    Iterator localIterator = this.qqb.values().iterator();
    while (localIterator.hasNext())
    {
      ad localad = (ad)localIterator.next();
      if (i(paramArrayOfInt, localad.getComponentId())) {
        localad.ct(paramString1, paramString2);
      }
    }
    AppMethodBeat.o(134991);
  }
  
  public final Iterator<ad> cdz()
  {
    AppMethodBeat.i(134995);
    Iterator local9 = new Iterator()
    {
      private final Iterator<ad> qqo;
      
      public final boolean hasNext()
      {
        AppMethodBeat.i(242665);
        boolean bool = this.qqo.hasNext();
        AppMethodBeat.o(242665);
        return bool;
      }
      
      public final void remove()
      {
        AppMethodBeat.i(242667);
        UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(242667);
        throw localUnsupportedOperationException;
      }
    };
    AppMethodBeat.o(134995);
    return local9;
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(134992);
    this.mDestroyed = true;
    super.cleanup();
    if (this.qqa != null) {
      this.qqa.cleanup();
    }
    Iterator localIterator = this.qqb.values().iterator();
    while (localIterator.hasNext()) {
      ((ad)localIterator.next()).cleanup();
    }
    jc(false);
    removeCallbacks(this.qqe);
    removeCallbacks(this.qqf);
    AppMethodBeat.o(134992);
  }
  
  public final boolean dP(String paramString)
  {
    AppMethodBeat.i(134987);
    if (this.qpY.anN(paramString) != -1)
    {
      AppMethodBeat.o(134987);
      return true;
    }
    AppMethodBeat.o(134987);
    return false;
  }
  
  /* Error */
  public final ad getCurrentPageView()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 567
    //   5: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 113	com/tencent/mm/plugin/appbrand/page/n:qqa	Lcom/tencent/mm/plugin/appbrand/page/ad;
    //   12: ifnull +18 -> 30
    //   15: aload_0
    //   16: getfield 113	com/tencent/mm/plugin/appbrand/page/n:qqa	Lcom/tencent/mm/plugin/appbrand/page/ad;
    //   19: astore_1
    //   20: ldc_w 567
    //   23: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: areturn
    //   30: aload_0
    //   31: getfield 79	com/tencent/mm/plugin/appbrand/page/n:qqb	Ljava/util/Map;
    //   34: aload_0
    //   35: getfield 489	com/tencent/mm/plugin/appbrand/page/n:puQ	Ljava/lang/String;
    //   38: invokestatic 214	com/tencent/luggage/k/l:eo	(Ljava/lang/String;)Ljava/lang/String;
    //   41: invokeinterface 218 2 0
    //   46: checkcast 146	com/tencent/mm/plugin/appbrand/page/ad
    //   49: astore_1
    //   50: ldc_w 567
    //   53: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: goto -30 -> 26
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	n
    //   19	31	1	localad	ad
    //   59	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	59	finally
    //   30	56	59	finally
  }
  
  public final String getCurrentUrl()
  {
    return this.puQ;
  }
  
  public final a getTabBar()
  {
    return this.qpY;
  }
  
  public final ad iL(int paramInt)
  {
    AppMethodBeat.i(244223);
    Iterator localIterator = this.qqb.values().iterator();
    while (localIterator.hasNext())
    {
      ad localad = (ad)localIterator.next();
      if (localad.getComponentId() == paramInt)
      {
        AppMethodBeat.o(244223);
        return localad;
      }
    }
    AppMethodBeat.o(244223);
    return null;
  }
  
  public final void onDescendantInvalidated(View paramView1, View paramView2)
  {
    AppMethodBeat.i(134978);
    super.onDescendantInvalidated(paramView1, paramView2);
    if ((paramView2 instanceof com.tencent.mm.plugin.appbrand.widget.actionbar.d))
    {
      cdw();
      cdx();
    }
    AppMethodBeat.o(134978);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134977);
    super.onMeasure(paramInt1, paramInt2);
    cdw();
    cdx();
    AppMethodBeat.o(134977);
  }
  
  public static final class a
    extends r
  {
    private static final int CTRL_INDEX = 390;
    private static final String NAME = "onTabItemTap";
  }
  
  public static abstract interface b
  {
    public abstract void b(n paramn, String paramString);
    
    public abstract void e(n paramn);
  }
  
  static abstract class c
    implements Runnable
  {
    boolean mCanceled = false;
    private boolean qqp = false;
    
    public abstract void cdA();
    
    public final void run()
    {
      if ((!this.qqp) && (!this.mCanceled)) {}
      for (int i = 1; i == 0; i = 0) {
        return;
      }
      this.qqp = true;
      cdA();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.n
 * JD-Core Version:    0.7.0.1
 */