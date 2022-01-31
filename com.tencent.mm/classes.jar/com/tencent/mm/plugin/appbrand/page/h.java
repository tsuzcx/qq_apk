package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.a.f;
import com.tencent.mm.plugin.appbrand.config.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@SuppressLint({"ViewConstructor"})
public final class h
  extends o
{
  private ViewGroup hmw;
  private String icS;
  private com.tencent.mm.plugin.appbrand.widget.i.a ivH;
  private FrameLayout ivI;
  private v ivJ;
  private Map<String, v> ivK;
  private SparseArray<AppBrandPageFullScreenView> ivL;
  private boolean ivM;
  private final Runnable ivN;
  private final Runnable ivO;
  private final LinkedList<h.b> ivP;
  
  public h(Context paramContext, r paramr)
  {
    super(paramContext, paramr);
    AppMethodBeat.i(87042);
    this.ivK = new HashMap();
    this.ivL = new SparseArray();
    this.ivM = false;
    this.ivN = new h.1(this);
    this.ivO = new h.3(this);
    this.ivP = new LinkedList();
    this.ivJ = getContainer().aJb();
    AppMethodBeat.o(87042);
  }
  
  /* Error */
  private v Ee(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 96
    //   4: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 89	com/tencent/mm/plugin/appbrand/page/h:ivJ	Lcom/tencent/mm/plugin/appbrand/page/v;
    //   11: ifnull +51 -> 62
    //   14: aload_0
    //   15: getfield 89	com/tencent/mm/plugin/appbrand/page/h:ivJ	Lcom/tencent/mm/plugin/appbrand/page/v;
    //   18: astore_2
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 89	com/tencent/mm/plugin/appbrand/page/h:ivJ	Lcom/tencent/mm/plugin/appbrand/page/v;
    //   24: aload_2
    //   25: aload_0
    //   26: putfield 102	com/tencent/mm/plugin/appbrand/page/v:ixs	Lcom/tencent/mm/plugin/appbrand/page/o;
    //   29: aload_0
    //   30: getfield 53	com/tencent/mm/plugin/appbrand/page/h:ivK	Ljava/util/Map;
    //   33: aload_1
    //   34: aload_2
    //   35: invokeinterface 108 3 0
    //   40: pop
    //   41: aload_0
    //   42: getfield 110	com/tencent/mm/plugin/appbrand/page/h:ivI	Landroid/widget/FrameLayout;
    //   45: aload_2
    //   46: getfield 112	com/tencent/mm/plugin/appbrand/page/v:hmw	Landroid/view/ViewGroup;
    //   49: iconst_0
    //   50: invokevirtual 118	android/widget/FrameLayout:addView	(Landroid/view/View;I)V
    //   53: ldc 96
    //   55: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_2
    //   61: areturn
    //   62: aload_0
    //   63: invokevirtual 81	com/tencent/mm/plugin/appbrand/page/h:getContainer	()Lcom/tencent/mm/plugin/appbrand/page/r;
    //   66: invokevirtual 87	com/tencent/mm/plugin/appbrand/page/r:aJb	()Lcom/tencent/mm/plugin/appbrand/page/v;
    //   69: astore_2
    //   70: goto -46 -> 24
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	h
    //   0	78	1	paramString	String
    //   18	52	2	localv	v
    // Exception table:
    //   from	to	target	type
    //   2	24	73	finally
    //   24	58	73	finally
    //   62	70	73	finally
  }
  
  private void Ef(String paramString)
  {
    AppMethodBeat.i(87050);
    this.ivM = false;
    v localv2 = (v)this.ivK.get(com.tencent.luggage.g.h.cg(paramString));
    localv2.hmw.setVisibility(4);
    paramString = null;
    Iterator localIterator = this.ivK.values().iterator();
    if (localIterator.hasNext())
    {
      v localv1 = (v)localIterator.next();
      if ((localv1.hmw.getVisibility() != 0) || (localv2 == localv1)) {
        break label143;
      }
      paramString = localv1;
    }
    label143:
    for (;;)
    {
      break;
      localv2.hmw.bringToFront();
      localv2.hmw.setVisibility(0);
      if (paramString != null) {
        paramString.hmw.setVisibility(4);
      }
      if (paramString != null) {
        paramString.onBackground();
      }
      localv2.onForeground();
      aIR();
      AppMethodBeat.o(87050);
      return;
    }
  }
  
  private void aIO()
  {
    AppMethodBeat.i(87046);
    post(this.ivN);
    AppMethodBeat.o(87046);
  }
  
  private void aIP()
  {
    AppMethodBeat.i(141658);
    post(this.ivO);
    AppMethodBeat.o(141658);
  }
  
  private com.tencent.mm.plugin.appbrand.widget.i.a aIQ()
  {
    AppMethodBeat.i(87047);
    com.tencent.mm.plugin.appbrand.widget.i.a locala = (com.tencent.mm.plugin.appbrand.widget.i.a)getContainer().getDecorWidgetFactory().b(getContext(), com.tencent.mm.plugin.appbrand.widget.i.a.class);
    locala.setId(2131820565);
    a.f localf = getContainer().getAppConfig().hgO;
    locala.setPosition(localf.hhf);
    locala.g(localf.color, localf.hhg, localf.hhh, localf.hhi);
    Iterator localIterator = localf.cBy.iterator();
    while (localIterator.hasNext())
    {
      a.g localg = (a.g)localIterator.next();
      locala.h(localg.url, localg.text, localg.cDz, localg.hhk);
    }
    locala.setClickListener(new h.4(this, localf));
    AppMethodBeat.o(87047);
    return locala;
  }
  
  private void aIR()
  {
    AppMethodBeat.i(87051);
    if (this.ivL.size() <= 0)
    {
      AppMethodBeat.o(87051);
      return;
    }
    int i = 0;
    while (i < this.ivL.size())
    {
      ((AppBrandPageFullScreenView)this.ivL.valueAt(i)).setVisibility(4);
      i += 1;
    }
    Object localObject = getCurrentPageView();
    if (localObject == null)
    {
      AppMethodBeat.o(87051);
      return;
    }
    localObject = (AppBrandPageFullScreenView)this.ivL.get(localObject.hashCode());
    if (localObject != null) {
      ((AppBrandPageFullScreenView)localObject).setVisibility(0);
    }
    AppMethodBeat.o(87051);
  }
  
  private void eA(boolean paramBoolean)
  {
    AppMethodBeat.i(141659);
    Iterator localIterator = this.ivP.iterator();
    while (localIterator.hasNext())
    {
      h.b localb = (h.b)localIterator.next();
      removeCallbacks(localb);
      if (paramBoolean) {
        localb.run();
      } else {
        localb.qM = true;
      }
    }
    this.ivP.clear();
    AppMethodBeat.o(141659);
  }
  
  protected final void a(v paramv, AppBrandPageFullScreenView paramAppBrandPageFullScreenView)
  {
    AppMethodBeat.i(138230);
    if (paramv == null)
    {
      ab.e("MicroMsg.AppBrandMultiplePage", "getCurrentFullScreenView err, pageView is null");
      AppMethodBeat.o(138230);
      return;
    }
    if ((paramAppBrandPageFullScreenView != null) && (paramAppBrandPageFullScreenView.getParent() == null) && ((this.hmw instanceof ViewGroup)))
    {
      this.hmw.addView(paramAppBrandPageFullScreenView, new ViewGroup.LayoutParams(-1, -1));
      this.ivL.put(paramv.hashCode(), paramAppBrandPageFullScreenView);
    }
    AppMethodBeat.o(138230);
  }
  
  public final void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(87057);
    if ((this.ivJ != null) && (f(paramArrayOfInt, this.ivJ.hashCode()))) {
      this.ivJ.c(paramString1, paramString2, 0);
    }
    Iterator localIterator = this.ivK.values().iterator();
    while (localIterator.hasNext())
    {
      v localv = (v)localIterator.next();
      if (f(paramArrayOfInt, localv.hashCode())) {
        localv.c(paramString1, paramString2, 0);
      }
    }
    AppMethodBeat.o(87057);
  }
  
  public final boolean bV(String paramString)
  {
    AppMethodBeat.i(87053);
    if (this.ivH.Gc(paramString) != -1)
    {
      AppMethodBeat.o(87053);
      return true;
    }
    AppMethodBeat.o(87053);
    return false;
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(87058);
    super.cleanup();
    if (this.ivJ != null) {
      this.ivJ.cleanup();
    }
    Iterator localIterator = this.ivK.values().iterator();
    while (localIterator.hasNext()) {
      ((v)localIterator.next()).cleanup();
    }
    eA(false);
    AppMethodBeat.o(87058);
  }
  
  /* Error */
  public final v getCurrentPageView()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 418
    //   5: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 89	com/tencent/mm/plugin/appbrand/page/h:ivJ	Lcom/tencent/mm/plugin/appbrand/page/v;
    //   12: ifnull +18 -> 30
    //   15: aload_0
    //   16: getfield 89	com/tencent/mm/plugin/appbrand/page/h:ivJ	Lcom/tencent/mm/plugin/appbrand/page/v;
    //   19: astore_1
    //   20: ldc_w 418
    //   23: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: areturn
    //   30: aload_0
    //   31: getfield 53	com/tencent/mm/plugin/appbrand/page/h:ivK	Ljava/util/Map;
    //   34: aload_0
    //   35: getfield 420	com/tencent/mm/plugin/appbrand/page/h:icS	Ljava/lang/String;
    //   38: invokestatic 127	com/tencent/luggage/g/h:cg	(Ljava/lang/String;)Ljava/lang/String;
    //   41: invokeinterface 131 2 0
    //   46: checkcast 98	com/tencent/mm/plugin/appbrand/page/v
    //   49: astore_1
    //   50: ldc_w 418
    //   53: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: goto -30 -> 26
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	h
    //   19	31	1	localv	v
    //   59	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	59	finally
    //   30	56	59	finally
  }
  
  public final String getCurrentUrl()
  {
    return this.icS;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.i.a getTabBar()
  {
    return this.ivH;
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(87048);
    if (paramString.equals(this.icS))
    {
      AppMethodBeat.o(87048);
      return;
    }
    int i = this.ivH.Gc(paramString);
    if (i < 0)
    {
      AppMethodBeat.o(87048);
      return;
    }
    eA(true);
    this.icS = paramString;
    this.ivH.qX(i);
    if (this.ivK.get(com.tencent.luggage.g.h.cg(paramString)) == null)
    {
      v localv = Ee(com.tencent.luggage.g.h.cg(paramString));
      ab.i("MicroMsg.AppBrandMultiplePage", "loadAndWait appId[%s] url[%s]", new Object[] { getAppId(), paramString });
      h.5 local5 = new h.5(this, paramString);
      localv.a(new h.6(this, localv, local5, System.currentTimeMillis(), paramString));
      if (this.ivK.size() > 1)
      {
        this.ivP.addLast(local5);
        postDelayed(local5, 500L);
      }
      this.ivM = true;
      localv.Em(paramString);
      AppMethodBeat.o(87048);
      return;
    }
    Ef(paramString);
    AppMethodBeat.o(87048);
  }
  
  public final void onDescendantInvalidated(View paramView1, View paramView2)
  {
    AppMethodBeat.i(87045);
    super.onDescendantInvalidated(paramView1, paramView2);
    if ((paramView2 instanceof com.tencent.mm.plugin.appbrand.widget.actionbar.d))
    {
      aIO();
      aIP();
    }
    AppMethodBeat.o(87045);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(87044);
    super.onMeasure(paramInt1, paramInt2);
    aIO();
    aIP();
    AppMethodBeat.o(87044);
  }
  
  protected final View vs()
  {
    AppMethodBeat.i(87043);
    Object localObject;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.hmw == null)
    {
      localObject = new RelativeLayout(getContext());
      this.ivI = new FrameLayout(getContext());
      this.ivH = aIQ();
      if (getContainer().getAppConfig().hgO.hhj) {
        this.ivH.setVisibility(8);
      }
      if (!"top".equals(getContainer().getAppConfig().hgO.hhf)) {
        break label163;
      }
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(10);
      ((RelativeLayout)localObject).addView(this.ivI, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(10);
      ((RelativeLayout)localObject).addView(this.ivH, localLayoutParams);
    }
    for (;;)
    {
      this.hmw = ((ViewGroup)localObject);
      localObject = this.hmw;
      AppMethodBeat.o(87043);
      return localObject;
      label163:
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(12);
      ((RelativeLayout)localObject).addView(this.ivH, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(2, this.ivH.getId());
      ((RelativeLayout)localObject).addView(this.ivI, localLayoutParams);
    }
  }
  
  protected final void vt()
  {
    AppMethodBeat.i(87056);
    super.vt();
    if (this.ivJ != null) {
      this.ivJ.onDestroy();
    }
    Iterator localIterator = this.ivK.values().iterator();
    while (localIterator.hasNext()) {
      ((v)localIterator.next()).onDestroy();
    }
    AppMethodBeat.o(87056);
  }
  
  public final void vu()
  {
    AppMethodBeat.i(87054);
    super.vu();
    getCurrentPageView().onForeground();
    AppMethodBeat.o(87054);
  }
  
  public final void vv()
  {
    AppMethodBeat.i(87055);
    super.vv();
    getCurrentPageView().onBackground();
    AppMethodBeat.o(87055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.h
 * JD-Core Version:    0.7.0.1
 */