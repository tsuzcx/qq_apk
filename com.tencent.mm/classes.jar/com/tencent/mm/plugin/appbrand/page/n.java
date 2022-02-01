package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.core.g.z;
import com.tencent.luggage.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.b.h;
import com.tencent.mm.plugin.appbrand.config.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.i.f;
import com.tencent.mm.plugin.appbrand.widget.tabbar.a;
import com.tencent.mm.plugin.appbrand.widget.tabbar.a.a;
import com.tencent.mm.plugin.appbrand.widget.tabbar.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.apache.commons.c.i;

public final class n
  extends u
{
  private ViewGroup ewc;
  private boolean mDestroyed;
  private String szW;
  private final SparseIntArray tuB;
  private a tuC;
  private FrameLayout tuD;
  private ad tuE;
  private Map<String, ad> tuF;
  private SparseArray<AppBrandPageFullScreenView> tuG;
  private boolean tuH;
  private final Runnable tuI;
  private final Runnable tuJ;
  private final LinkedList<c> tuK;
  
  public n(Context paramContext, x paramx)
  {
    super(paramContext, paramx);
    AppMethodBeat.i(134975);
    this.tuB = new SparseIntArray();
    this.tuF = new HashMap();
    this.tuG = new SparseArray();
    this.tuH = false;
    this.mDestroyed = false;
    this.tuI = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(134965);
        n.a(n.this);
        AppMethodBeat.o(134965);
      }
    };
    this.tuJ = new Runnable()
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
        com.tencent.mm.plugin.appbrand.widget.actionbar.b localb = ((ad)localObject).cEC();
        if (localb == null)
        {
          AppMethodBeat.o(134967);
          return;
        }
        localObject = ((ad)localObject).txj;
        int i = localb.getTop();
        ((com.tencent.mm.plugin.appbrand.widget.h.b)localObject).EI(localb.getMeasuredHeight() + i);
        AppMethodBeat.o(134967);
      }
    };
    this.tuK = new LinkedList();
    AppMethodBeat.o(134975);
  }
  
  /* Error */
  private ad aey(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 296
    //   5: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 298	com/tencent/mm/plugin/appbrand/page/n:tuE	Lcom/tencent/mm/plugin/appbrand/page/ad;
    //   12: ifnull +47 -> 59
    //   15: aload_0
    //   16: getfield 298	com/tencent/mm/plugin/appbrand/page/n:tuE	Lcom/tencent/mm/plugin/appbrand/page/ad;
    //   19: astore_2
    //   20: aload_0
    //   21: aconst_null
    //   22: putfield 298	com/tencent/mm/plugin/appbrand/page/n:tuE	Lcom/tencent/mm/plugin/appbrand/page/ad;
    //   25: aload_0
    //   26: getfield 85	com/tencent/mm/plugin/appbrand/page/n:tuF	Ljava/util/Map;
    //   29: aload_1
    //   30: aload_2
    //   31: invokeinterface 304 3 0
    //   36: pop
    //   37: aload_0
    //   38: getfield 306	com/tencent/mm/plugin/appbrand/page/n:tuD	Landroid/widget/FrameLayout;
    //   41: aload_2
    //   42: invokevirtual 310	com/tencent/mm/plugin/appbrand/page/ad:getContentView	()Landroid/view/View;
    //   45: iconst_0
    //   46: invokevirtual 316	android/widget/FrameLayout:addView	(Landroid/view/View;I)V
    //   49: ldc_w 296
    //   52: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_2
    //   58: areturn
    //   59: aload_0
    //   60: invokevirtual 118	com/tencent/mm/plugin/appbrand/page/n:getContainer	()Lcom/tencent/mm/plugin/appbrand/page/x;
    //   63: aload_1
    //   64: invokevirtual 319	com/tencent/mm/plugin/appbrand/page/x:aeI	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/page/ad;
    //   67: astore_2
    //   68: aload_2
    //   69: aload_0
    //   70: invokevirtual 323	com/tencent/mm/plugin/appbrand/page/ad:t	(Lcom/tencent/mm/plugin/appbrand/page/u;)V
    //   73: goto -48 -> 25
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	n
    //   0	81	1	paramString	String
    //   19	50	2	localad	ad
    // Exception table:
    //   from	to	target	type
    //   2	25	76	finally
    //   25	55	76	finally
    //   59	73	76	finally
  }
  
  private void aez(String paramString)
  {
    AppMethodBeat.i(134984);
    this.tuH = false;
    ad localad2 = (ad)this.tuF.get(m.fL(paramString));
    localad2.getContentView().setVisibility(4);
    Iterator localIterator = this.tuF.values().iterator();
    Object localObject = null;
    if (localIterator.hasNext())
    {
      ad localad1 = (ad)localIterator.next();
      if ((localad1.getContentView().getVisibility() != 0) || (localad2 == localad1)) {
        break label186;
      }
      localObject = localad1;
    }
    label186:
    for (;;)
    {
      break;
      localad2.getContentView().bringToFront();
      localad2.getContentView().setVisibility(0);
      if (localObject != null) {
        localObject.getContentView().setVisibility(4);
      }
      if (localObject != null) {
        localObject.onBackground();
      }
      if ((localad2.cEI()) && (!i.qA(localad2.cgR(), m.fL(paramString)))) {
        localad2.a(paramString, cb.tBt, null, false);
      }
      localad2.onForeground();
      cDZ();
      AppMethodBeat.o(134984);
      return;
    }
  }
  
  private void cDX()
  {
    AppMethodBeat.i(134979);
    if (this.mDestroyed)
    {
      AppMethodBeat.o(134979);
      return;
    }
    post(this.tuI);
    AppMethodBeat.o(134979);
  }
  
  private void cDY()
  {
    AppMethodBeat.i(134980);
    if (this.mDestroyed)
    {
      AppMethodBeat.o(134980);
      return;
    }
    post(this.tuJ);
    AppMethodBeat.o(134980);
  }
  
  private void cDZ()
  {
    AppMethodBeat.i(134985);
    if (this.tuG.size() <= 0)
    {
      AppMethodBeat.o(134985);
      return;
    }
    int i = 0;
    while (i < this.tuG.size())
    {
      ((AppBrandPageFullScreenView)this.tuG.valueAt(i)).setVisibility(4);
      i += 1;
    }
    Object localObject = getCurrentPageView();
    if (localObject == null)
    {
      AppMethodBeat.o(134985);
      return;
    }
    localObject = (AppBrandPageFullScreenView)this.tuG.get(localObject.hashCode());
    if (localObject != null) {
      ((AppBrandPageFullScreenView)localObject).setVisibility(0);
    }
    AppMethodBeat.o(134985);
  }
  
  private void kl(boolean paramBoolean)
  {
    AppMethodBeat.i(134986);
    Iterator localIterator = this.tuK.iterator();
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
    this.tuK.clear();
    AppMethodBeat.o(134986);
  }
  
  /* Error */
  private ad km(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 427
    //   5: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: iload_1
    //   9: ifne +25 -> 34
    //   12: aload_0
    //   13: getfield 298	com/tencent/mm/plugin/appbrand/page/n:tuE	Lcom/tencent/mm/plugin/appbrand/page/ad;
    //   16: ifnull +18 -> 34
    //   19: aload_0
    //   20: getfield 298	com/tencent/mm/plugin/appbrand/page/n:tuE	Lcom/tencent/mm/plugin/appbrand/page/ad;
    //   23: astore_2
    //   24: ldc_w 427
    //   27: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_2
    //   33: areturn
    //   34: aload_0
    //   35: getfield 85	com/tencent/mm/plugin/appbrand/page/n:tuF	Ljava/util/Map;
    //   38: aload_0
    //   39: getfield 429	com/tencent/mm/plugin/appbrand/page/n:szW	Ljava/lang/String;
    //   42: invokestatic 330	com/tencent/luggage/l/m:fL	(Ljava/lang/String;)Ljava/lang/String;
    //   45: invokeinterface 334 2 0
    //   50: checkcast 259	com/tencent/mm/plugin/appbrand/page/ad
    //   53: astore_2
    //   54: ldc_w 427
    //   57: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: goto -30 -> 30
    //   63: astore_2
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_2
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	n
    //   0	68	1	paramBoolean	boolean
    //   23	31	2	localad	ad
    //   63	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	8	63	finally
    //   12	30	63	finally
    //   34	60	63	finally
  }
  
  public final ad L(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(324980);
    Iterator localIterator = this.tuF.values().iterator();
    while (localIterator.hasNext())
    {
      ad localad = (ad)localIterator.next();
      if ((paramBoolean) && (localad.cEI()))
      {
        if (localad.CE(paramInt))
        {
          AppMethodBeat.o(324980);
          return localad;
        }
      }
      else if (localad.getComponentId() == paramInt)
      {
        AppMethodBeat.o(324980);
        return localad;
      }
    }
    AppMethodBeat.o(324980);
    return null;
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
    if ((paramAppBrandPageFullScreenView != null) && (paramAppBrandPageFullScreenView.getParent() == null) && ((this.ewc instanceof ViewGroup)))
    {
      this.ewc.addView(paramAppBrandPageFullScreenView, new ViewGroup.LayoutParams(-1, -1));
      this.tuG.put(paramad.hashCode(), paramAppBrandPageFullScreenView);
    }
    AppMethodBeat.o(134994);
  }
  
  protected final void a(String paramString, ad paramad)
  {
    AppMethodBeat.i(324962);
    this.szW = paramString;
    this.tuB.put(paramString.hashCode(), 1);
    this.tuF.put(m.fL(paramString), paramad);
    AppMethodBeat.o(324962);
  }
  
  public final void a(String paramString, cb paramcb)
  {
    AppMethodBeat.i(324959);
    a(paramString, null, paramcb);
    AppMethodBeat.o(324959);
  }
  
  public final void a(final String paramString, final b paramb, cb paramcb)
  {
    AppMethodBeat.i(324957);
    Log.i("MicroMsg.AppBrandMultiplePage", "AppBrandPageProfile| loadUrl, appId:%s, url:%s", new Object[] { getAppId(), paramString });
    if ((i.qA(paramString, this.szW)) && (this.tuB.get(paramString.hashCode(), 0) == 1))
    {
      if (paramb != null)
      {
        paramb.b(this, paramString);
        paramb.f(this);
      }
      AppMethodBeat.o(324957);
      return;
    }
    int i = this.tuC.ahl(paramString);
    if (i < 0)
    {
      Log.e("MicroMsg.AppBrandMultiplePage", "loadUrl, index not found, appId:%s, url:%s", new Object[] { getAppId(), paramString });
      AppMethodBeat.o(324957);
      return;
    }
    kl(true);
    final ad localad = km(true);
    this.szW = paramString;
    this.tuB.put(paramString.hashCode(), 1);
    this.tuC.EO(i);
    if (this.tuF.get(m.fL(paramString)) == null)
    {
      final boolean[] arrayOfBoolean;
      if ((localad != null) && (localad.cEI()) && (localad.cEJ()))
      {
        this.tuF.put(m.fL(paramString), localad);
        arrayOfBoolean = new boolean[1];
        Object localObject = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(325172);
            if (paramb != null)
            {
              if (arrayOfBoolean[0] == 0)
              {
                n.this.post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(325159);
                    n.6.this.tuN.f(n.this);
                    AppMethodBeat.o(325159);
                  }
                });
                AppMethodBeat.o(325172);
                return;
              }
              paramb.f(n.this);
            }
            AppMethodBeat.o(325172);
          }
        };
        Log.i("MicroMsg.AppBrandMultiplePage", "loadAndWait appId[%s] url[%s]", new Object[] { getAppId(), paramString });
        localObject = new c(paramString)
        {
          public final void cEc()
          {
            AppMethodBeat.i(325181);
            n.a(n.this, paramString);
            if (this.val$onComplete != null) {
              this.val$onComplete.run();
            }
            AppMethodBeat.o(325181);
          }
        };
        localad.a(new i.f()
        {
          public final void onReady()
          {
            AppMethodBeat.i(325179);
            localad.b(this);
            this.tuQ.run();
            long l1 = System.currentTimeMillis();
            long l2 = this.esF;
            Log.i("MicroMsg.AppBrandMultiplePage", "Tab[%s][%s] onReady received, time: %d", new Object[] { n.this.getAppId(), this.val$url, Long.valueOf(l1 - l2) });
            AppMethodBeat.o(325179);
          }
        });
        if (this.tuF.size() > 1)
        {
          this.tuK.addLast(localObject);
          postDelayed((Runnable)localObject, 500L);
        }
        this.tuH = true;
        if ((!localad.cEI()) || (i.hm(m.fL(localad.txo)))) {
          break label405;
        }
        localad.a(paramString, cb.tBt, null, false);
      }
      for (;;)
      {
        if (paramb != null)
        {
          paramb.b(this, paramString);
          arrayOfBoolean[0] = true;
        }
        AppMethodBeat.o(324957);
        return;
        localad = aey(m.fL(paramString));
        break;
        label405:
        localad.c(paramString, paramcb);
      }
    }
    if (paramb != null) {
      paramb.b(this, paramString);
    }
    aez(paramString);
    if (paramb != null) {
      paramb.f(this);
    }
    AppMethodBeat.o(324957);
  }
  
  public final void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(134991);
    if ((this.tuE != null) && (v(paramArrayOfInt, this.tuE.getComponentId()))) {
      this.tuE.cJ(paramString1, paramString2);
    }
    Iterator localIterator = this.tuF.values().iterator();
    while (localIterator.hasNext())
    {
      ad localad = (ad)localIterator.next();
      if (v(paramArrayOfInt, localad.getComponentId())) {
        localad.cJ(paramString1, paramString2);
      }
    }
    AppMethodBeat.o(134991);
  }
  
  protected final void apV()
  {
    AppMethodBeat.i(134990);
    super.apV();
    if (this.tuE != null) {
      this.tuE.onDestroy();
    }
    Iterator localIterator = this.tuF.values().iterator();
    while (localIterator.hasNext()) {
      ((ad)localIterator.next()).onDestroy();
    }
    AppMethodBeat.o(134990);
  }
  
  public final void apW()
  {
    AppMethodBeat.i(134988);
    super.apW();
    getCurrentPageView().onForeground();
    AppMethodBeat.o(134988);
  }
  
  public final void apX()
  {
    AppMethodBeat.i(134989);
    super.apX();
    getCurrentPageView().onBackground();
    AppMethodBeat.o(134989);
  }
  
  public final Iterator<ad> cEa()
  {
    AppMethodBeat.i(134995);
    Iterator local9 = new Iterator()
    {
      private final Iterator<ad> aDi;
      
      public final boolean hasNext()
      {
        AppMethodBeat.i(325182);
        boolean bool = this.aDi.hasNext();
        AppMethodBeat.o(325182);
        return bool;
      }
      
      public final void remove()
      {
        AppMethodBeat.i(325185);
        UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(325185);
        throw localUnsupportedOperationException;
      }
    };
    AppMethodBeat.o(134995);
    return local9;
  }
  
  protected final void cEb()
  {
    AppMethodBeat.i(324988);
    getCurrentPageView().cEb();
    AppMethodBeat.o(324988);
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(134992);
    this.mDestroyed = true;
    super.cleanup();
    if (this.tuE != null) {
      this.tuE.cleanup();
    }
    Iterator localIterator = this.tuF.values().iterator();
    while (localIterator.hasNext()) {
      ((ad)localIterator.next()).cleanup();
    }
    kl(false);
    removeCallbacks(this.tuI);
    removeCallbacks(this.tuJ);
    AppMethodBeat.o(134992);
  }
  
  protected final View createContentView()
  {
    AppMethodBeat.i(134976);
    Object localObject;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.ewc == null)
    {
      localObject = new d(getContext());
      this.tuD = new FrameLayout(getContext());
      com.tencent.luggage.sdk.h.d.a("createTabBar", new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(325169);
          bc localbc = (bc)n.this.getContainer().getRuntime().ax(bc.class);
          n.a(n.this, n.a(n.this, localbc));
          AppMethodBeat.o(325169);
        }
      });
      if (getContainer().getAppConfig().cku().qWm) {
        this.tuC.setVisibility(8);
      }
      if (!"top".equals(getContainer().getAppConfig().cku().qWi)) {
        break label194;
      }
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(10);
      ((RelativeLayout)localObject).addView(this.tuD, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(10);
      ((RelativeLayout)localObject).addView(this.tuC, localLayoutParams);
    }
    for (;;)
    {
      this.ewc = ((ViewGroup)localObject);
      this.tuE = getContainer().aeI(this.szW);
      this.tuE.t(this);
      localObject = this.ewc;
      AppMethodBeat.o(134976);
      return localObject;
      label194:
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(12);
      ((RelativeLayout)localObject).addView(this.tuC, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(2, this.tuC.getId());
      localLayoutParams.removeRule(12);
      ((RelativeLayout)localObject).addView(this.tuD, localLayoutParams);
    }
  }
  
  public final boolean fa(String paramString)
  {
    AppMethodBeat.i(134987);
    if (this.tuC.ahl(paramString) != -1)
    {
      AppMethodBeat.o(134987);
      return true;
    }
    AppMethodBeat.o(134987);
    return false;
  }
  
  public final ad getCurrentPageView()
  {
    try
    {
      AppMethodBeat.i(134993);
      ad localad = km(false);
      AppMethodBeat.o(134993);
      return localad;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String getCurrentUrl()
  {
    return this.szW;
  }
  
  public final a getTabBar()
  {
    return this.tuC;
  }
  
  public final void onDescendantInvalidated(View paramView1, View paramView2)
  {
    AppMethodBeat.i(134978);
    super.onDescendantInvalidated(paramView1, paramView2);
    if ((paramView2 instanceof com.tencent.mm.plugin.appbrand.widget.actionbar.d))
    {
      cDX();
      cDY();
    }
    AppMethodBeat.o(134978);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134977);
    super.onMeasure(paramInt1, paramInt2);
    cDX();
    cDY();
    AppMethodBeat.o(134977);
  }
  
  protected final void setInitialUrl(String paramString)
  {
    this.szW = paramString;
  }
  
  public static abstract interface b
  {
    public abstract void b(n paramn, String paramString);
    
    public abstract void f(n paramn);
  }
  
  static abstract class c
    implements Runnable
  {
    boolean mCanceled = false;
    private boolean tuR = false;
    
    public abstract void cEc();
    
    public final void run()
    {
      if ((!this.tuR) && (!this.mCanceled)) {}
      for (int i = 1; i == 0; i = 0) {
        return;
      }
      this.tuR = true;
      cEc();
    }
  }
  
  final class d
    extends RelativeLayout
    implements a.a
  {
    public d(Context paramContext)
    {
      super();
    }
    
    public final void cEd()
    {
      AppMethodBeat.i(325107);
      n.b(n.this).bringToFront();
      AppMethodBeat.o(325107);
    }
    
    public final void cEe()
    {
      AppMethodBeat.i(325113);
      if ((n.e(n.this) != null) && ((n.e(n.this).getLayoutParams() instanceof RelativeLayout.LayoutParams)))
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)n.e(n.this).getLayoutParams();
        if ((Build.VERSION.SDK_INT < 23) || (localLayoutParams.getRule(2) != n.b(n.this).getId()))
        {
          localLayoutParams.addRule(2, n.b(n.this).getId());
          localLayoutParams.removeRule(12);
          n.e(n.this).requestLayout();
        }
      }
      AppMethodBeat.o(325113);
    }
    
    public final void kn(boolean paramBoolean)
    {
      AppMethodBeat.i(325101);
      if ((paramBoolean) && (!"top".equals(n.this.getContainer().getAppConfig().cku().qWi)) && (n.e(n.this) != null) && ((n.e(n.this).getLayoutParams() instanceof RelativeLayout.LayoutParams)))
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)n.e(n.this).getLayoutParams();
        localLayoutParams.removeRule(2);
        localLayoutParams.addRule(12);
        n.b(n.this).bringToFront();
        n.e(n.this).requestLayout();
      }
      AppMethodBeat.o(325101);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.n
 * JD-Core Version:    0.7.0.1
 */