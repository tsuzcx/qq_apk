package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.u;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.luggage.h.l;
import com.tencent.luggage.sdk.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.b.g;
import com.tencent.mm.plugin.appbrand.config.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.jsapi.i.f;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.widget.actionbar.d;
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
public final class m
  extends t
{
  private ViewGroup lja;
  private boolean mDestroyed;
  private String mwq;
  private a nop;
  private FrameLayout noq;
  private ac nor;
  private Map<String, ac> nos;
  private SparseArray<AppBrandPageFullScreenView> not;
  private boolean nou;
  private final Runnable nov;
  private final Runnable now;
  private final LinkedList<c> nox;
  
  public m(Context paramContext, w paramw)
  {
    super(paramContext, paramw);
    AppMethodBeat.i(134975);
    this.nos = new HashMap();
    this.not = new SparseArray();
    this.nou = false;
    this.mDestroyed = false;
    this.nov = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134965);
        m.a(m.this);
        AppMethodBeat.o(134965);
      }
    };
    this.now = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134967);
        if (m.c(m.this))
        {
          AppMethodBeat.o(134967);
          return;
        }
        Object localObject = m.this.getCurrentPageView();
        if (localObject == null)
        {
          AppMethodBeat.o(134967);
          return;
        }
        com.tencent.mm.plugin.appbrand.widget.actionbar.b localb = ((ac)localObject).bRi();
        if (localb == null)
        {
          AppMethodBeat.o(134967);
          return;
        }
        localObject = ((ac)localObject).nqT;
        int i = localb.getTop();
        ((com.tencent.mm.plugin.appbrand.widget.f.b)localObject).AB(localb.getMeasuredHeight() + i);
        AppMethodBeat.o(134967);
      }
    };
    this.nox = new LinkedList();
    this.nor = getContainer().bQT();
    AppMethodBeat.o(134975);
  }
  
  private void adA(String paramString)
  {
    AppMethodBeat.i(134984);
    this.nou = false;
    ac localac2 = (ac)this.nos.get(l.dM(paramString));
    localac2.getContentView().setVisibility(4);
    paramString = null;
    Iterator localIterator = this.nos.values().iterator();
    if (localIterator.hasNext())
    {
      ac localac1 = (ac)localIterator.next();
      if ((localac1.getContentView().getVisibility() != 0) || (localac2 == localac1)) {
        break label143;
      }
      paramString = localac1;
    }
    label143:
    for (;;)
    {
      break;
      localac2.getContentView().bringToFront();
      localac2.getContentView().setVisibility(0);
      if (paramString != null) {
        paramString.getContentView().setVisibility(4);
      }
      if (paramString != null) {
        paramString.onBackground();
      }
      localac2.onForeground();
      bQI();
      AppMethodBeat.o(134984);
      return;
    }
  }
  
  /* Error */
  private ac adz(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 242
    //   4: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 113	com/tencent/mm/plugin/appbrand/page/m:nor	Lcom/tencent/mm/plugin/appbrand/page/ac;
    //   11: ifnull +51 -> 62
    //   14: aload_0
    //   15: getfield 113	com/tencent/mm/plugin/appbrand/page/m:nor	Lcom/tencent/mm/plugin/appbrand/page/ac;
    //   18: astore_2
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 113	com/tencent/mm/plugin/appbrand/page/m:nor	Lcom/tencent/mm/plugin/appbrand/page/ac;
    //   24: aload_2
    //   25: aload_0
    //   26: putfield 246	com/tencent/mm/plugin/appbrand/page/ac:nqU	Lcom/tencent/mm/plugin/appbrand/page/t;
    //   29: aload_0
    //   30: getfield 79	com/tencent/mm/plugin/appbrand/page/m:nos	Ljava/util/Map;
    //   33: aload_1
    //   34: aload_2
    //   35: invokeinterface 250 3 0
    //   40: pop
    //   41: aload_0
    //   42: getfield 252	com/tencent/mm/plugin/appbrand/page/m:noq	Landroid/widget/FrameLayout;
    //   45: aload_2
    //   46: invokevirtual 199	com/tencent/mm/plugin/appbrand/page/ac:getContentView	()Landroid/view/View;
    //   49: iconst_0
    //   50: invokevirtual 258	android/widget/FrameLayout:addView	(Landroid/view/View;I)V
    //   53: ldc 242
    //   55: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_2
    //   61: areturn
    //   62: aload_0
    //   63: invokevirtual 105	com/tencent/mm/plugin/appbrand/page/m:getContainer	()Lcom/tencent/mm/plugin/appbrand/page/w;
    //   66: invokevirtual 111	com/tencent/mm/plugin/appbrand/page/w:bQT	()Lcom/tencent/mm/plugin/appbrand/page/ac;
    //   69: astore_2
    //   70: goto -46 -> 24
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	m
    //   0	78	1	paramString	String
    //   18	52	2	localac	ac
    // Exception table:
    //   from	to	target	type
    //   2	24	73	finally
    //   24	58	73	finally
    //   62	70	73	finally
  }
  
  private void bQG()
  {
    AppMethodBeat.i(134979);
    if (this.mDestroyed)
    {
      AppMethodBeat.o(134979);
      return;
    }
    post(this.nov);
    AppMethodBeat.o(134979);
  }
  
  private void bQH()
  {
    AppMethodBeat.i(134980);
    if (this.mDestroyed)
    {
      AppMethodBeat.o(134980);
      return;
    }
    post(this.now);
    AppMethodBeat.o(134980);
  }
  
  private void bQI()
  {
    AppMethodBeat.i(134985);
    if (this.not.size() <= 0)
    {
      AppMethodBeat.o(134985);
      return;
    }
    int i = 0;
    while (i < this.not.size())
    {
      ((AppBrandPageFullScreenView)this.not.valueAt(i)).setVisibility(4);
      i += 1;
    }
    Object localObject = getCurrentPageView();
    if (localObject == null)
    {
      AppMethodBeat.o(134985);
      return;
    }
    localObject = (AppBrandPageFullScreenView)this.not.get(localObject.hashCode());
    if (localObject != null) {
      ((AppBrandPageFullScreenView)localObject).setVisibility(0);
    }
    AppMethodBeat.o(134985);
  }
  
  private void jdMethod_if(boolean paramBoolean)
  {
    AppMethodBeat.i(134986);
    Iterator localIterator = this.nox.iterator();
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
    this.nox.clear();
    AppMethodBeat.o(134986);
  }
  
  protected final View MT()
  {
    AppMethodBeat.i(134976);
    Object localObject;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.lja == null)
    {
      localObject = new RelativeLayout(getContext());
      this.noq = new FrameLayout(getContext());
      c.a("createTabBar", new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(219358);
          ba localba = (ba)m.this.getContainer().getRuntime().af(ba.class);
          m.a(m.this, m.this.a(localba));
          AppMethodBeat.o(219358);
        }
      });
      if (getContainer().getAppConfig().bzG().lcq) {
        this.nop.setVisibility(8);
      }
      if (!"top".equals(getContainer().getAppConfig().bzG().lcm)) {
        break label170;
      }
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(10);
      ((RelativeLayout)localObject).addView(this.noq, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(10);
      ((RelativeLayout)localObject).addView(this.nop, localLayoutParams);
    }
    for (;;)
    {
      this.lja = ((ViewGroup)localObject);
      localObject = this.lja;
      AppMethodBeat.o(134976);
      return localObject;
      label170:
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(12);
      ((RelativeLayout)localObject).addView(this.nop, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(2, this.nop.getId());
      ((RelativeLayout)localObject).addView(this.noq, localLayoutParams);
    }
  }
  
  protected final void MU()
  {
    AppMethodBeat.i(134990);
    super.MU();
    if (this.nor != null) {
      this.nor.onDestroy();
    }
    Iterator localIterator = this.nos.values().iterator();
    while (localIterator.hasNext()) {
      ((ac)localIterator.next()).onDestroy();
    }
    AppMethodBeat.o(134990);
  }
  
  public final void MV()
  {
    AppMethodBeat.i(134988);
    super.MV();
    getCurrentPageView().onForeground();
    AppMethodBeat.o(134988);
  }
  
  public final void MW()
  {
    AppMethodBeat.i(134989);
    super.MW();
    getCurrentPageView().onBackground();
    AppMethodBeat.o(134989);
  }
  
  protected final a a(ba paramba)
  {
    AppMethodBeat.i(219368);
    Object localObject2 = (a)paramba.a(a.class, getContext());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (a)getContainer().getDecorWidgetFactory().d(getContext(), a.class);
    }
    ((a)localObject1).setId(2131296858);
    localObject2 = getContainer().getAppConfig().bzG();
    ((a)localObject1).setPosition(((b.g)localObject2).lcm);
    ((a)localObject1).j(((b.g)localObject2).ixw, ((b.g)localObject2).lcn, ((b.g)localObject2).lco, ((b.g)localObject2).lcp);
    Iterator localIterator = ((b.g)localObject2).lj.iterator();
    while (localIterator.hasNext())
    {
      b.h localh = (b.h)localIterator.next();
      ((a)localObject1).a(localh.url, localh.text, localh.icon, localh.lcs, (AppBrandTabBarItem)paramba.a(AppBrandTabBarItem.class, getContext()));
    }
    ((a)localObject1).setClickListener(new a.b()
    {
      public final void aq(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(219359);
        m.this.getContainer().adE(paramAnonymousString);
        HashMap localHashMap = new HashMap();
        localHashMap.put("pagePath", paramAnonymousString);
        localHashMap.put("text", ((b.h)this.noz.lj.get(paramAnonymousInt)).text);
        localHashMap.put("index", Integer.valueOf(paramAnonymousInt));
        m.this.getCurrentPageView().a(new m.a().K(localHashMap), null);
        AppMethodBeat.o(219359);
      }
    });
    AppMethodBeat.o(219368);
    return localObject1;
  }
  
  protected final void a(ac paramac, AppBrandPageFullScreenView paramAppBrandPageFullScreenView)
  {
    AppMethodBeat.i(134994);
    if (paramac == null)
    {
      Log.e("MicroMsg.AppBrandMultiplePage", "getCurrentFullScreenView err, pageView is null");
      AppMethodBeat.o(134994);
      return;
    }
    if ((paramAppBrandPageFullScreenView != null) && (paramAppBrandPageFullScreenView.getParent() == null) && ((this.lja instanceof ViewGroup)))
    {
      this.lja.addView(paramAppBrandPageFullScreenView, new ViewGroup.LayoutParams(-1, -1));
      this.not.put(paramac.hashCode(), paramAppBrandPageFullScreenView);
    }
    AppMethodBeat.o(134994);
  }
  
  public final void a(final String paramString, final b paramb)
  {
    AppMethodBeat.i(219369);
    Log.i("MicroMsg.AppBrandMultiplePage", "AppBrandPageProfile| loadUrl, appId:%s, url:%s", new Object[] { getAppId(), paramString });
    if (paramString.equals(this.mwq))
    {
      if (paramb != null)
      {
        paramb.b(this, paramString);
        paramb.e(this);
      }
      AppMethodBeat.o(219369);
      return;
    }
    int i = this.nop.agk(paramString);
    if (i < 0)
    {
      Log.e("MicroMsg.AppBrandMultiplePage", "loadUrl, index not found, appId:%s, url:%s", new Object[] { getAppId(), paramString });
      AppMethodBeat.o(219369);
      return;
    }
    jdMethod_if(true);
    this.mwq = paramString;
    this.nop.AI(i);
    if (this.nos.get(l.dM(paramString)) == null)
    {
      final ac localac = adz(l.dM(paramString));
      final boolean[] arrayOfBoolean = new boolean[1];
      Object localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(219361);
          if (paramb != null)
          {
            if (arrayOfBoolean[0] == 0)
            {
              m.this.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(219360);
                  m.6.this.noA.e(m.this);
                  AppMethodBeat.o(219360);
                }
              });
              AppMethodBeat.o(219361);
              return;
            }
            paramb.e(m.this);
          }
          AppMethodBeat.o(219361);
        }
      };
      Log.i("MicroMsg.AppBrandMultiplePage", "loadAndWait appId[%s] url[%s]", new Object[] { getAppId(), paramString });
      localObject = new c(paramString)
      {
        public final void bQK()
        {
          AppMethodBeat.i(219362);
          m.a(m.this, paramString);
          if (this.noD != null) {
            this.noD.run();
          }
          AppMethodBeat.o(219362);
        }
      };
      localac.a(new i.f()
      {
        public final void onReady()
        {
          AppMethodBeat.i(219363);
          localac.b(this);
          this.noE.run();
          long l1 = System.currentTimeMillis();
          long l2 = this.cBb;
          Log.i("MicroMsg.AppBrandMultiplePage", "Tab[%s][%s] onReady received, time: %d", new Object[] { m.this.getAppId(), this.val$url, Long.valueOf(l1 - l2) });
          AppMethodBeat.o(219363);
        }
      });
      if (this.nos.size() > 1)
      {
        this.nox.addLast(localObject);
        postDelayed((Runnable)localObject, 500L);
      }
      this.nou = true;
      localac.dE(paramString);
      if (paramb != null)
      {
        paramb.b(this, paramString);
        arrayOfBoolean[0] = true;
      }
      AppMethodBeat.o(219369);
      return;
    }
    if (paramb != null) {
      paramb.b(this, paramString);
    }
    adA(paramString);
    if (paramb != null) {
      paramb.e(this);
    }
    AppMethodBeat.o(219369);
  }
  
  public final void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(134991);
    if ((this.nor != null) && (i(paramArrayOfInt, this.nor.getComponentId()))) {
      this.nor.c(paramString1, paramString2, 0);
    }
    Iterator localIterator = this.nos.values().iterator();
    while (localIterator.hasNext())
    {
      ac localac = (ac)localIterator.next();
      if (i(paramArrayOfInt, localac.getComponentId())) {
        localac.c(paramString1, paramString2, 0);
      }
    }
    AppMethodBeat.o(134991);
  }
  
  public final Iterator<ac> bQJ()
  {
    AppMethodBeat.i(134995);
    Iterator local9 = new Iterator()
    {
      private final Iterator<ac> noF;
      
      public final boolean hasNext()
      {
        AppMethodBeat.i(219365);
        boolean bool = this.noF.hasNext();
        AppMethodBeat.o(219365);
        return bool;
      }
      
      public final void remove()
      {
        AppMethodBeat.i(219366);
        UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(219366);
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
    if (this.nor != null) {
      this.nor.cleanup();
    }
    Iterator localIterator = this.nos.values().iterator();
    while (localIterator.hasNext()) {
      ((ac)localIterator.next()).cleanup();
    }
    jdMethod_if(false);
    removeCallbacks(this.nov);
    removeCallbacks(this.now);
    AppMethodBeat.o(134992);
  }
  
  public final boolean dw(String paramString)
  {
    AppMethodBeat.i(134987);
    if (this.nop.agk(paramString) != -1)
    {
      AppMethodBeat.o(134987);
      return true;
    }
    AppMethodBeat.o(134987);
    return false;
  }
  
  /* Error */
  public final ac getCurrentPageView()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 561
    //   5: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 113	com/tencent/mm/plugin/appbrand/page/m:nor	Lcom/tencent/mm/plugin/appbrand/page/ac;
    //   12: ifnull +18 -> 30
    //   15: aload_0
    //   16: getfield 113	com/tencent/mm/plugin/appbrand/page/m:nor	Lcom/tencent/mm/plugin/appbrand/page/ac;
    //   19: astore_1
    //   20: ldc_w 561
    //   23: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: areturn
    //   30: aload_0
    //   31: getfield 79	com/tencent/mm/plugin/appbrand/page/m:nos	Ljava/util/Map;
    //   34: aload_0
    //   35: getfield 481	com/tencent/mm/plugin/appbrand/page/m:mwq	Ljava/lang/String;
    //   38: invokestatic 189	com/tencent/luggage/h/l:dM	(Ljava/lang/String;)Ljava/lang/String;
    //   41: invokeinterface 195 2 0
    //   46: checkcast 146	com/tencent/mm/plugin/appbrand/page/ac
    //   49: astore_1
    //   50: ldc_w 561
    //   53: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: goto -30 -> 26
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	m
    //   19	31	1	localac	ac
    //   59	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	59	finally
    //   30	56	59	finally
  }
  
  public final String getCurrentUrl()
  {
    return this.mwq;
  }
  
  public final a getTabBar()
  {
    return this.nop;
  }
  
  public final ac hL(int paramInt)
  {
    AppMethodBeat.i(219370);
    Iterator localIterator = this.nos.values().iterator();
    while (localIterator.hasNext())
    {
      ac localac = (ac)localIterator.next();
      if (localac.getComponentId() == paramInt)
      {
        AppMethodBeat.o(219370);
        return localac;
      }
    }
    AppMethodBeat.o(219370);
    return null;
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(134982);
    a(paramString, null);
    AppMethodBeat.o(134982);
  }
  
  public final void onDescendantInvalidated(View paramView1, View paramView2)
  {
    AppMethodBeat.i(134978);
    super.onDescendantInvalidated(paramView1, paramView2);
    if ((paramView2 instanceof d))
    {
      bQG();
      bQH();
    }
    AppMethodBeat.o(134978);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134977);
    super.onMeasure(paramInt1, paramInt2);
    bQG();
    bQH();
    AppMethodBeat.o(134977);
  }
  
  public static final class a
    extends s
  {
    private static final int CTRL_INDEX = 390;
    private static final String NAME = "onTabItemTap";
  }
  
  public static abstract interface b
  {
    public abstract void b(m paramm, String paramString);
    
    public abstract void e(m paramm);
  }
  
  static abstract class c
    implements Runnable
  {
    boolean mCanceled = false;
    private boolean noG = false;
    
    public abstract void bQK();
    
    public final void run()
    {
      if ((!this.noG) && (!this.mCanceled)) {}
      for (int i = 1; i == 0; i = 0) {
        return;
      }
      this.noG = true;
      bQK();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.m
 * JD-Core Version:    0.7.0.1
 */