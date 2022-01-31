package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.luggage.j.g;
import com.tencent.luggage.l.a.d;
import com.tencent.mm.plugin.appbrand.config.a.f;
import com.tencent.mm.plugin.appbrand.widget.c;
import com.tencent.mm.plugin.appbrand.widget.c.2;
import com.tencent.mm.plugin.appbrand.widget.c.a;
import com.tencent.mm.plugin.appbrand.widget.c.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class d
  extends k
{
  private ViewGroup fSV;
  private String gDP;
  private c gSA;
  private FrameLayout gSB;
  private q gSC = getContainer().getPageViewPrivate();
  private Map<String, q> gSD = new HashMap();
  private LinkedList<d.b> gSE = new LinkedList();
  
  public d(Context paramContext, n paramn)
  {
    super(paramContext, paramn);
  }
  
  private c amS()
  {
    c localc = new c(getContext());
    localc.setId(a.d.app_brand_multi_page_tabbar);
    final com.tencent.mm.plugin.appbrand.config.a.e locale = getContainer().getAppConfig().fND;
    localc.setPosition(locale.fNP);
    localc.h(locale.color, locale.fNQ, locale.fNR, locale.fNS);
    Iterator localIterator = locale.bTS.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (a.f)localIterator.next();
      Object localObject1 = ((a.f)localObject2).url;
      String str1 = ((a.f)localObject2).text;
      String str2 = ((a.f)localObject2).bVO;
      String str3 = ((a.f)localObject2).fNT;
      localObject2 = new c.a((byte)0);
      try
      {
        ((c.a)localObject2).BP = c.wW(str2);
        ((c.a)localObject2).hnU = c.wW(str3);
        ((c.a)localObject2).hnV = str1;
        ((c.a)localObject2).mUrl = ((String)localObject1);
        if ((((c.a)localObject2).hnV == null) && ((((c.a)localObject2).BP == null) || (((c.a)localObject2).hnU == null))) {
          y.e("MicroMsg.AppBrandPageTabBar", "illegal data");
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.e("MicroMsg.AppBrandPageTabBar", localException.getMessage());
        }
        localObject1 = (ViewGroup)LayoutInflater.from(localc.getContext()).inflate(com.tencent.luggage.l.a.e.app_brand_tab_bar_item, localc.hnF, false);
        localc.a((View)localObject1, (c.a)localObject2);
        ((ViewGroup)localObject1).setOnClickListener(new c.2(localc));
        localc.hnK.add(localObject2);
        localc.hnF.addView((View)localObject1);
      }
    }
    localc.setClickListener(new c.b()
    {
      public final void M(int paramAnonymousInt, String paramAnonymousString)
      {
        d.this.getContainer().vF(paramAnonymousString);
        HashMap localHashMap = new HashMap();
        localHashMap.put("pagePath", paramAnonymousString);
        localHashMap.put("text", ((a.f)locale.bTS.get(paramAnonymousInt)).text);
        localHashMap.put("index", Integer.valueOf(paramAnonymousInt));
        d.this.getCurrentPageView().b(new d.a((byte)0).o(localHashMap));
      }
    });
    return localc;
  }
  
  private void amT()
  {
    Iterator localIterator = this.gSE.iterator();
    while (localIterator.hasNext())
    {
      d.b localb = (d.b)localIterator.next();
      removeCallbacks(localb);
      localb.pP = true;
    }
    this.gSE.clear();
  }
  
  /* Error */
  private q vD(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 54	com/tencent/mm/plugin/appbrand/page/d:gSC	Lcom/tencent/mm/plugin/appbrand/page/q;
    //   6: ifnull +41 -> 47
    //   9: aload_0
    //   10: getfield 54	com/tencent/mm/plugin/appbrand/page/d:gSC	Lcom/tencent/mm/plugin/appbrand/page/q;
    //   13: astore_2
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield 54	com/tencent/mm/plugin/appbrand/page/d:gSC	Lcom/tencent/mm/plugin/appbrand/page/q;
    //   19: aload_0
    //   20: getfield 37	com/tencent/mm/plugin/appbrand/page/d:gSD	Ljava/util/Map;
    //   23: aload_1
    //   24: aload_2
    //   25: invokeinterface 263 3 0
    //   30: pop
    //   31: aload_0
    //   32: getfield 265	com/tencent/mm/plugin/appbrand/page/d:gSB	Landroid/widget/FrameLayout;
    //   35: aload_2
    //   36: invokevirtual 271	com/tencent/mm/plugin/appbrand/page/q:getContentView	()Landroid/view/View;
    //   39: iconst_0
    //   40: invokevirtual 276	android/widget/FrameLayout:addView	(Landroid/view/View;I)V
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_2
    //   46: areturn
    //   47: aload_0
    //   48: invokevirtual 46	com/tencent/mm/plugin/appbrand/page/d:getContainer	()Lcom/tencent/mm/plugin/appbrand/page/n;
    //   51: invokevirtual 52	com/tencent/mm/plugin/appbrand/page/n:getPageViewPrivate	()Lcom/tencent/mm/plugin/appbrand/page/q;
    //   54: astore_2
    //   55: goto -36 -> 19
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	d
    //   0	63	1	paramString	String
    //   13	42	2	localq	q
    // Exception table:
    //   from	to	target	type
    //   2	19	58	finally
    //   19	43	58	finally
    //   47	55	58	finally
  }
  
  private void vE(String paramString)
  {
    q localq2 = (q)this.gSD.get(g.bi(paramString));
    localq2.getContentView().setVisibility(4);
    paramString = null;
    Iterator localIterator = this.gSD.values().iterator();
    if (localIterator.hasNext())
    {
      q localq1 = (q)localIterator.next();
      if (localq1.getContentView().getVisibility() != 0) {
        break label116;
      }
      paramString = localq1;
    }
    label116:
    for (;;)
    {
      break;
      localq2.getContentView().setVisibility(0);
      if (paramString != null) {
        paramString.getContentView().setVisibility(4);
      }
      localq2.pY();
      if (paramString != null) {
        paramString.qa();
      }
      super.agJ();
      return;
    }
  }
  
  protected final View agF()
  {
    RelativeLayout localRelativeLayout;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.fSV == null)
    {
      localRelativeLayout = new RelativeLayout(getContext());
      this.gSB = new FrameLayout(getContext());
      this.gSA = amS();
      if (!"top".equals(getContainer().getAppConfig().fND.fNP)) {
        break label125;
      }
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(10);
      localRelativeLayout.addView(this.gSB, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(10);
      localRelativeLayout.addView(this.gSA, localLayoutParams);
    }
    for (;;)
    {
      this.fSV = localRelativeLayout;
      return this.fSV;
      label125:
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(12);
      localRelativeLayout.addView(this.gSA, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(2, this.gSA.getId());
      localRelativeLayout.addView(this.gSB, localLayoutParams);
    }
  }
  
  protected final void agG()
  {
    super.agG();
    if (this.gSC != null) {
      this.gSC.onDestroy();
    }
    Iterator localIterator = this.gSD.values().iterator();
    while (localIterator.hasNext()) {
      ((q)localIterator.next()).onDestroy();
    }
  }
  
  public final void agH()
  {
    super.agH();
    getCurrentPageView().pY();
  }
  
  public final void agI()
  {
    super.agI();
    getCurrentPageView().qa();
  }
  
  protected final void agJ()
  {
    super.agJ();
  }
  
  public final void b(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    if ((this.gSC != null) && (e(paramArrayOfInt, this.gSC.hashCode()))) {
      this.gSC.i(paramString1, paramString2, 0);
    }
    Iterator localIterator = this.gSD.values().iterator();
    while (localIterator.hasNext())
    {
      q localq = (q)localIterator.next();
      if (e(paramArrayOfInt, localq.hashCode())) {
        localq.i(paramString1, paramString2, 0);
      }
    }
  }
  
  public final void cleanup()
  {
    super.cleanup();
    if (this.gSC != null) {
      this.gSC.cleanup();
    }
    Iterator localIterator = this.gSD.values().iterator();
    while (localIterator.hasNext()) {
      ((q)localIterator.next()).cleanup();
    }
    amT();
  }
  
  /* Error */
  public final q getCurrentPageView()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 54	com/tencent/mm/plugin/appbrand/page/d:gSC	Lcom/tencent/mm/plugin/appbrand/page/q;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 54	com/tencent/mm/plugin/appbrand/page/d:gSC	Lcom/tencent/mm/plugin/appbrand/page/q;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: getfield 37	com/tencent/mm/plugin/appbrand/page/d:gSD	Ljava/util/Map;
    //   22: aload_0
    //   23: getfield 384	com/tencent/mm/plugin/appbrand/page/d:gDP	Ljava/lang/String;
    //   26: invokestatic 282	com/tencent/luggage/j/g:bi	(Ljava/lang/String;)Ljava/lang/String;
    //   29: invokeinterface 286 2 0
    //   34: checkcast 267	com/tencent/mm/plugin/appbrand/page/q
    //   37: astore_1
    //   38: goto -24 -> 14
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	d
    //   13	25	1	localq	q
    //   41	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	41	finally
    //   18	38	41	finally
  }
  
  public final String getCurrentUrl()
  {
    return this.gDP;
  }
  
  public final c getTabBar()
  {
    return this.gSA;
  }
  
  public final void loadUrl(String paramString)
  {
    if (paramString.equals(this.gDP)) {}
    int i;
    do
    {
      return;
      i = this.gSA.wX(paramString);
    } while (i < 0);
    this.gDP = paramString;
    this.gSA.mC(i);
    if (this.gSD.get(g.bi(paramString)) == null)
    {
      q localq = vD(g.bi(paramString));
      agK();
      d.2 local2 = new d.2(this, paramString);
      localq.a(new d.3(this, localq, local2, System.currentTimeMillis()));
      if (this.gSD.size() > 1)
      {
        this.gSE.add(local2);
        postDelayed(local2, 500L);
      }
      localq.tB(paramString);
      return;
    }
    amT();
    vE(paramString);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((getCurrentPageView() != null) && ("top".equals(this.gSA.getPosition())) && ((this.gSA.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      Object localObject1 = (ViewGroup.MarginLayoutParams)this.gSA.getLayoutParams();
      Object localObject2 = getCurrentPageView().gTC;
      paramInt1 = ((com.tencent.mm.plugin.appbrand.widget.actionbar.a)localObject2).getTop();
      paramInt1 = ((com.tencent.mm.plugin.appbrand.widget.actionbar.a)localObject2).getMeasuredHeight() + paramInt1;
      if (((ViewGroup.MarginLayoutParams)localObject1).topMargin != paramInt1)
      {
        ((ViewGroup.MarginLayoutParams)localObject1).topMargin = paramInt1;
        this.gSA.requestLayout();
      }
      localObject1 = getCurrentPageView();
      paramInt1 = this.gSA.getMeasuredHeight();
      if ((!((q)localObject1).gTW) && ((((q)localObject1).gTC.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
      {
        localObject2 = (ViewGroup.MarginLayoutParams)((q)localObject1).gTC.getLayoutParams();
        if (((ViewGroup.MarginLayoutParams)localObject2).bottomMargin != paramInt1)
        {
          ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = paramInt1;
          ((q)localObject1).gTC.requestLayout();
        }
      }
    }
  }
  
  public final boolean tz(String paramString)
  {
    return this.gSA.wX(paramString) != -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.d
 * JD-Core Version:    0.7.0.1
 */