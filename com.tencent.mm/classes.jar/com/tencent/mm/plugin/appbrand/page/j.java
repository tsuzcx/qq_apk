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
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.widget.tabbar.AppBrandTabBarItem;
import com.tencent.mm.plugin.appbrand.widget.tabbar.a.b;
import com.tencent.mm.sdk.platformtools.ae;
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
  private ViewGroup kfr;
  private String lpL;
  private boolean mDestroyed;
  private com.tencent.mm.plugin.appbrand.widget.tabbar.a mdX;
  private FrameLayout mdY;
  private z mdZ;
  private Map<String, z> mea;
  private SparseArray<AppBrandPageFullScreenView> meb;
  private boolean mec;
  private final Runnable med;
  private final Runnable mee;
  private final LinkedList<c> mef;
  
  public j(Context paramContext, t paramt)
  {
    super(paramContext, paramt);
    AppMethodBeat.i(134975);
    this.mea = new HashMap();
    this.meb = new SparseArray();
    this.mec = false;
    this.mDestroyed = false;
    this.med = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134965);
        j.a(j.this);
        AppMethodBeat.o(134965);
      }
    };
    this.mee = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134967);
        if (j.c(j.this))
        {
          AppMethodBeat.o(134967);
          return;
        }
        Object localObject = j.this.getCurrentPageView();
        if (localObject == null)
        {
          AppMethodBeat.o(134967);
          return;
        }
        com.tencent.mm.plugin.appbrand.widget.actionbar.b localb = ((z)localObject).bvi();
        if (localb == null)
        {
          AppMethodBeat.o(134967);
          return;
        }
        localObject = ((z)localObject).mgu;
        int i = localb.getTop();
        ((com.tencent.mm.plugin.appbrand.widget.e.b)localObject).wT(localb.getMeasuredHeight() + i);
        AppMethodBeat.o(134967);
      }
    };
    this.mef = new LinkedList();
    this.mdZ = getContainer().buT();
    AppMethodBeat.o(134975);
  }
  
  /* Error */
  private z TM(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 118
    //   4: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 111	com/tencent/mm/plugin/appbrand/page/j:mdZ	Lcom/tencent/mm/plugin/appbrand/page/z;
    //   11: ifnull +51 -> 62
    //   14: aload_0
    //   15: getfield 111	com/tencent/mm/plugin/appbrand/page/j:mdZ	Lcom/tencent/mm/plugin/appbrand/page/z;
    //   18: astore_2
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 111	com/tencent/mm/plugin/appbrand/page/j:mdZ	Lcom/tencent/mm/plugin/appbrand/page/z;
    //   24: aload_2
    //   25: aload_0
    //   26: putfield 124	com/tencent/mm/plugin/appbrand/page/z:mgv	Lcom/tencent/mm/plugin/appbrand/page/q;
    //   29: aload_0
    //   30: getfield 77	com/tencent/mm/plugin/appbrand/page/j:mea	Ljava/util/Map;
    //   33: aload_1
    //   34: aload_2
    //   35: invokeinterface 130 3 0
    //   40: pop
    //   41: aload_0
    //   42: getfield 132	com/tencent/mm/plugin/appbrand/page/j:mdY	Landroid/widget/FrameLayout;
    //   45: aload_2
    //   46: getfield 134	com/tencent/mm/plugin/appbrand/page/z:kfr	Landroid/view/ViewGroup;
    //   49: iconst_0
    //   50: invokevirtual 140	android/widget/FrameLayout:addView	(Landroid/view/View;I)V
    //   53: ldc 118
    //   55: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_2
    //   61: areturn
    //   62: aload_0
    //   63: invokevirtual 103	com/tencent/mm/plugin/appbrand/page/j:getContainer	()Lcom/tencent/mm/plugin/appbrand/page/t;
    //   66: invokevirtual 109	com/tencent/mm/plugin/appbrand/page/t:buT	()Lcom/tencent/mm/plugin/appbrand/page/z;
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
    //   18	52	2	localz	z
    // Exception table:
    //   from	to	target	type
    //   2	24	73	finally
    //   24	58	73	finally
    //   62	70	73	finally
  }
  
  private void TN(String paramString)
  {
    AppMethodBeat.i(134984);
    this.mec = false;
    z localz2 = (z)this.mea.get(k.dt(paramString));
    localz2.kfr.setVisibility(4);
    paramString = null;
    Iterator localIterator = this.mea.values().iterator();
    if (localIterator.hasNext())
    {
      z localz1 = (z)localIterator.next();
      if ((localz1.kfr.getVisibility() != 0) || (localz2 == localz1)) {
        break label143;
      }
      paramString = localz1;
    }
    label143:
    for (;;)
    {
      break;
      localz2.kfr.bringToFront();
      localz2.kfr.setVisibility(0);
      if (paramString != null) {
        paramString.kfr.setVisibility(4);
      }
      if (paramString != null) {
        paramString.onBackground();
      }
      localz2.onForeground();
      buI();
      AppMethodBeat.o(134984);
      return;
    }
  }
  
  private void buG()
  {
    AppMethodBeat.i(134979);
    if (this.mDestroyed)
    {
      AppMethodBeat.o(134979);
      return;
    }
    post(this.med);
    AppMethodBeat.o(134979);
  }
  
  private void buH()
  {
    AppMethodBeat.i(134980);
    if (this.mDestroyed)
    {
      AppMethodBeat.o(134980);
      return;
    }
    post(this.mee);
    AppMethodBeat.o(134980);
  }
  
  private void buI()
  {
    AppMethodBeat.i(134985);
    if (this.meb.size() <= 0)
    {
      AppMethodBeat.o(134985);
      return;
    }
    int i = 0;
    while (i < this.meb.size())
    {
      ((AppBrandPageFullScreenView)this.meb.valueAt(i)).setVisibility(4);
      i += 1;
    }
    Object localObject = getCurrentPageView();
    if (localObject == null)
    {
      AppMethodBeat.o(134985);
      return;
    }
    localObject = (AppBrandPageFullScreenView)this.meb.get(localObject.hashCode());
    if (localObject != null) {
      ((AppBrandPageFullScreenView)localObject).setVisibility(0);
    }
    AppMethodBeat.o(134985);
  }
  
  private void he(boolean paramBoolean)
  {
    AppMethodBeat.i(134986);
    Iterator localIterator = this.mef.iterator();
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
    this.mef.clear();
    AppMethodBeat.o(134986);
  }
  
  protected final View Dw()
  {
    AppMethodBeat.i(134976);
    Object localObject;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.kfr == null)
    {
      localObject = new RelativeLayout(getContext());
      this.mdY = new FrameLayout(getContext());
      c.a("createTabBar", new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(207784);
          aw localaw = (aw)j.this.getContainer().getRuntime().ab(aw.class);
          j.a(j.this, j.this.a(localaw));
          AppMethodBeat.o(207784);
        }
      });
      if (getContainer().getAppConfig().bep().jZo) {
        this.mdX.setVisibility(8);
      }
      if (!"top".equals(getContainer().getAppConfig().bep().jZk)) {
        break label170;
      }
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(10);
      ((RelativeLayout)localObject).addView(this.mdY, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(10);
      ((RelativeLayout)localObject).addView(this.mdX, localLayoutParams);
    }
    for (;;)
    {
      this.kfr = ((ViewGroup)localObject);
      localObject = this.kfr;
      AppMethodBeat.o(134976);
      return localObject;
      label170:
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(12);
      ((RelativeLayout)localObject).addView(this.mdX, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(2, this.mdX.getId());
      ((RelativeLayout)localObject).addView(this.mdY, localLayoutParams);
    }
  }
  
  protected final void Dx()
  {
    AppMethodBeat.i(134990);
    super.Dx();
    if (this.mdZ != null) {
      this.mdZ.onDestroy();
    }
    Iterator localIterator = this.mea.values().iterator();
    while (localIterator.hasNext()) {
      ((z)localIterator.next()).onDestroy();
    }
    AppMethodBeat.o(134990);
  }
  
  public final void Dy()
  {
    AppMethodBeat.i(134988);
    super.Dy();
    getCurrentPageView().onForeground();
    AppMethodBeat.o(134988);
  }
  
  public final void Dz()
  {
    AppMethodBeat.i(134989);
    super.Dz();
    getCurrentPageView().onBackground();
    AppMethodBeat.o(134989);
  }
  
  protected final com.tencent.mm.plugin.appbrand.widget.tabbar.a a(aw paramaw)
  {
    AppMethodBeat.i(207793);
    Object localObject2 = (com.tencent.mm.plugin.appbrand.widget.tabbar.a)paramaw.aC(com.tencent.mm.plugin.appbrand.widget.tabbar.a.class);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (com.tencent.mm.plugin.appbrand.widget.tabbar.a)getContainer().getDecorWidgetFactory().c(getContext(), com.tencent.mm.plugin.appbrand.widget.tabbar.a.class);
    }
    ((com.tencent.mm.plugin.appbrand.widget.tabbar.a)localObject1).setId(2131296776);
    localObject2 = getContainer().getAppConfig().bep();
    ((com.tencent.mm.plugin.appbrand.widget.tabbar.a)localObject1).setPosition(((a.g)localObject2).jZk);
    ((com.tencent.mm.plugin.appbrand.widget.tabbar.a)localObject1).j(((a.g)localObject2).hDr, ((a.g)localObject2).jZl, ((a.g)localObject2).jZm, ((a.g)localObject2).jZn);
    Iterator localIterator = ((a.g)localObject2).lh.iterator();
    while (localIterator.hasNext())
    {
      a.h localh = (a.h)localIterator.next();
      ((com.tencent.mm.plugin.appbrand.widget.tabbar.a)localObject1).a(localh.url, localh.text, localh.dEM, localh.jZq, (AppBrandTabBarItem)paramaw.aC(AppBrandTabBarItem.class));
    }
    ((com.tencent.mm.plugin.appbrand.widget.tabbar.a)localObject1).setClickListener(new a.b()
    {
      public final void ao(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(207785);
        j.this.getContainer().TS(paramAnonymousString);
        HashMap localHashMap = new HashMap();
        localHashMap.put("pagePath", paramAnonymousString);
        localHashMap.put("text", ((a.h)this.meh.lh.get(paramAnonymousInt)).text);
        localHashMap.put("index", Integer.valueOf(paramAnonymousInt));
        j.this.getCurrentPageView().b(new j.a().H(localHashMap));
        AppMethodBeat.o(207785);
      }
    });
    AppMethodBeat.o(207793);
    return localObject1;
  }
  
  protected final void a(z paramz, AppBrandPageFullScreenView paramAppBrandPageFullScreenView)
  {
    AppMethodBeat.i(134994);
    if (paramz == null)
    {
      ae.e("MicroMsg.AppBrandMultiplePage", "getCurrentFullScreenView err, pageView is null");
      AppMethodBeat.o(134994);
      return;
    }
    if ((paramAppBrandPageFullScreenView != null) && (paramAppBrandPageFullScreenView.getParent() == null) && ((this.kfr instanceof ViewGroup)))
    {
      this.kfr.addView(paramAppBrandPageFullScreenView, new ViewGroup.LayoutParams(-1, -1));
      this.meb.put(paramz.hashCode(), paramAppBrandPageFullScreenView);
    }
    AppMethodBeat.o(134994);
  }
  
  public final void a(final String paramString, final b paramb)
  {
    AppMethodBeat.i(207794);
    ae.i("MicroMsg.AppBrandMultiplePage", "AppBrandPageProfile| loadUrl");
    if (paramString.equals(this.lpL))
    {
      if (paramb != null)
      {
        paramb.b(this, paramString);
        paramb.e(this);
      }
      AppMethodBeat.o(207794);
      return;
    }
    int i = this.mdX.Wr(paramString);
    if (i < 0)
    {
      ae.e("MicroMsg.AppBrandMultiplePage", "loadUrl, index not found, appId:%s, url:%s", new Object[] { getAppId(), paramString });
      AppMethodBeat.o(207794);
      return;
    }
    he(true);
    this.lpL = paramString;
    this.mdX.xc(i);
    if (this.mea.get(k.dt(paramString)) == null)
    {
      final z localz = TM(k.dt(paramString));
      if (paramb != null) {
        paramb.b(this, paramString);
      }
      paramb = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(207786);
          if (paramb != null) {
            paramb.e(j.this);
          }
          AppMethodBeat.o(207786);
        }
      };
      ae.i("MicroMsg.AppBrandMultiplePage", "loadAndWait appId[%s] url[%s]", new Object[] { getAppId(), paramString });
      paramb = new c(paramString)
      {
        public final void buK()
        {
          AppMethodBeat.i(207787);
          j.a(j.this, paramString);
          j.this.getContainer().buV();
          if (paramb != null) {
            paramb.run();
          }
          AppMethodBeat.o(207787);
        }
      };
      localz.a(new f.f()
      {
        public final void onReady()
        {
          AppMethodBeat.i(207788);
          localz.b(this);
          paramb.run();
          long l1 = System.currentTimeMillis();
          long l2 = this.coO;
          ae.i("MicroMsg.AppBrandMultiplePage", "Tab[%s][%s] onReady received, time: %d", new Object[] { j.this.getAppId(), this.val$url, Long.valueOf(l1 - l2) });
          AppMethodBeat.o(207788);
        }
      });
      if (this.mea.size() > 1)
      {
        this.mef.addLast(paramb);
        postDelayed(paramb, 500L);
      }
      this.mec = true;
      localz.dm(paramString);
      AppMethodBeat.o(207794);
      return;
    }
    if (paramb != null) {
      paramb.b(this, paramString);
    }
    TN(paramString);
    if (paramb != null) {
      paramb.e(this);
    }
    AppMethodBeat.o(207794);
  }
  
  public final void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(134991);
    if ((this.mdZ != null) && (i(paramArrayOfInt, this.mdZ.aXX()))) {
      this.mdZ.c(paramString1, paramString2, 0);
    }
    Iterator localIterator = this.mea.values().iterator();
    while (localIterator.hasNext())
    {
      z localz = (z)localIterator.next();
      if (i(paramArrayOfInt, localz.aXX())) {
        localz.c(paramString1, paramString2, 0);
      }
    }
    AppMethodBeat.o(134991);
  }
  
  public final Iterator<z> buJ()
  {
    AppMethodBeat.i(134995);
    Iterator local9 = new Iterator()
    {
      private final Iterator<z> mel;
      
      public final boolean hasNext()
      {
        AppMethodBeat.i(207790);
        boolean bool = this.mel.hasNext();
        AppMethodBeat.o(207790);
        return bool;
      }
      
      public final void remove()
      {
        AppMethodBeat.i(207791);
        UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(207791);
        throw localUnsupportedOperationException;
      }
    };
    AppMethodBeat.o(134995);
    return local9;
  }
  
  public final boolean cX(String paramString)
  {
    AppMethodBeat.i(134987);
    if (this.mdX.Wr(paramString) != -1)
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
    if (this.mdZ != null) {
      this.mdZ.cleanup();
    }
    Iterator localIterator = this.mea.values().iterator();
    while (localIterator.hasNext()) {
      ((z)localIterator.next()).cleanup();
    }
    he(false);
    removeCallbacks(this.med);
    removeCallbacks(this.mee);
    AppMethodBeat.o(134992);
  }
  
  /* Error */
  public final z getCurrentPageView()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 560
    //   5: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 111	com/tencent/mm/plugin/appbrand/page/j:mdZ	Lcom/tencent/mm/plugin/appbrand/page/z;
    //   12: ifnull +18 -> 30
    //   15: aload_0
    //   16: getfield 111	com/tencent/mm/plugin/appbrand/page/j:mdZ	Lcom/tencent/mm/plugin/appbrand/page/z;
    //   19: astore_1
    //   20: ldc_w 560
    //   23: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: areturn
    //   30: aload_0
    //   31: getfield 77	com/tencent/mm/plugin/appbrand/page/j:mea	Ljava/util/Map;
    //   34: aload_0
    //   35: getfield 474	com/tencent/mm/plugin/appbrand/page/j:lpL	Ljava/lang/String;
    //   38: invokestatic 149	com/tencent/luggage/h/k:dt	(Ljava/lang/String;)Ljava/lang/String;
    //   41: invokeinterface 153 2 0
    //   46: checkcast 120	com/tencent/mm/plugin/appbrand/page/z
    //   49: astore_1
    //   50: ldc_w 560
    //   53: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: goto -30 -> 26
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	j
    //   19	31	1	localz	z
    //   59	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	59	finally
    //   30	56	59	finally
  }
  
  public final String getCurrentUrl()
  {
    return this.lpL;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.tabbar.a getTabBar()
  {
    return this.mdX;
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
    if ((paramView2 instanceof com.tencent.mm.plugin.appbrand.widget.actionbar.d))
    {
      buG();
      buH();
    }
    AppMethodBeat.o(134978);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134977);
    super.onMeasure(paramInt1, paramInt2);
    buG();
    buH();
    AppMethodBeat.o(134977);
  }
  
  public static final class a
    extends p
  {
    private static final int CTRL_INDEX = 390;
    private static final String NAME = "onTabItemTap";
  }
  
  public static abstract interface b
  {
    public abstract void b(j paramj, String paramString);
    
    public abstract void e(j paramj);
  }
  
  static abstract class c
    implements Runnable
  {
    boolean mCanceled = false;
    private boolean mem = false;
    
    public abstract void buK();
    
    public final void run()
    {
      if ((!this.mem) && (!this.mCanceled)) {}
      for (int i = 1; i == 0; i = 0) {
        return;
      }
      this.mem = true;
      buK();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.j
 * JD-Core Version:    0.7.0.1
 */