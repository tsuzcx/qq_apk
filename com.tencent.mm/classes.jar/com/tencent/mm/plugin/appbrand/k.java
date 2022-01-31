package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import org.a.a;

public class k<RUNTIME extends i>
  implements ad
{
  boolean bFa;
  boolean bFb;
  public final HashMap<String, RUNTIME> gQA;
  public final com.tencent.mm.plugin.appbrand.task.i gQB;
  private Class<? extends RUNTIME> gQC;
  public Activity gQx;
  FrameLayout gQy;
  public final LinkedList<RUNTIME> gQz;
  
  public k(com.tencent.mm.plugin.appbrand.task.i parami, Class<? extends RUNTIME> paramClass)
  {
    AppMethodBeat.i(86718);
    this.bFa = false;
    this.bFb = false;
    this.gQx = parami.getContext();
    this.gQz = new LinkedList();
    this.gQA = new HashMap();
    this.gQy = parami.aLW();
    this.gQB = parami;
    this.gQC = paramClass;
    this.gQx.getApplication().registerActivityLifecycleCallbacks(new k.1(this));
    AppMethodBeat.o(86718);
  }
  
  public void a(WindowManager.LayoutParams paramLayoutParams) {}
  
  public void a(i parami, MiniProgramNavigationBackResult paramMiniProgramNavigationBackResult)
  {
    AppMethodBeat.i(86722);
    if (parami == null)
    {
      AppMethodBeat.o(86722);
      return;
    }
    this.gQB.getContext().runOnUiThread(new k.2(this, parami, paramMiniProgramNavigationBackResult));
    AppMethodBeat.o(86722);
  }
  
  public void a(RUNTIME paramRUNTIME1, RUNTIME paramRUNTIME2, AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(86719);
    paramRUNTIME2.gPy = paramRUNTIME1;
    paramRUNTIME2.d(paramAppBrandInitConfig);
    this.gQz.push(paramRUNTIME2);
    this.gQy.addView(paramRUNTIME2.gPC);
    if (paramRUNTIME1 != null) {
      paramRUNTIME1.atv();
    }
    paramRUNTIME2.atg();
    AppMethodBeat.o(86719);
  }
  
  public final RUNTIME atG()
  {
    AppMethodBeat.i(86724);
    i locali = (i)this.gQz.peek();
    AppMethodBeat.o(86724);
    return locali;
  }
  
  public final int atH()
  {
    AppMethodBeat.i(156863);
    int i = this.gQz.size();
    AppMethodBeat.o(156863);
    return i;
  }
  
  public final void atI()
  {
    AppMethodBeat.i(86735);
    Iterator localIterator = this.gQz.iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      locali.gPC.setVisibility(8);
      this.gQA.put(locali.mAppId, locali);
      locali.atA();
    }
    this.gQz.clear();
    AppMethodBeat.o(86735);
  }
  
  protected final LinkedList<RUNTIME> atJ()
  {
    AppMethodBeat.i(86737);
    LinkedList localLinkedList = new LinkedList(this.gQz);
    AppMethodBeat.o(86737);
    return localLinkedList;
  }
  
  public final com.tencent.mm.plugin.appbrand.task.i atK()
  {
    return this.gQB;
  }
  
  public void b(RUNTIME paramRUNTIME1, RUNTIME paramRUNTIME2, AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(86721);
    k(paramRUNTIME2);
    j(paramRUNTIME2);
    paramRUNTIME2.gPy = paramRUNTIME1;
    paramRUNTIME2.e(paramAppBrandInitConfig);
    if (paramRUNTIME1 != null)
    {
      paramRUNTIME1.atv();
      paramRUNTIME2.atw();
    }
    AppMethodBeat.o(86721);
  }
  
  public void b(i parami1, i parami2, Runnable paramRunnable)
  {
    AppMethodBeat.i(86723);
    if (parami1 == null) {}
    for (parami1 = "null";; parami1 = parami1.mAppId)
    {
      com.tencent.luggage.g.d.i("MicroMsg.AppBrandRuntimeContainer", "onRuntimeClose entered, in.appId[%s], out.appId[%s]", new Object[] { parami1, parami2.mAppId });
      paramRunnable.run();
      AppMethodBeat.o(86723);
      return;
    }
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(141639);
    Object localObject = new LinkedList();
    ((LinkedList)localObject).addAll(this.gQz);
    ((LinkedList)localObject).addAll(this.gQA.values());
    atI();
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      i locali = (i)((Iterator)localObject).next();
      locali.gPR = false;
      h(locali);
    }
    com.tencent.luggage.g.d.i("MicroMsg.AppBrandRuntimeContainer", "cleanup");
    AppMethodBeat.o(141639);
  }
  
  public final RUNTIME f(i parami)
  {
    AppMethodBeat.i(86725);
    if (parami == null)
    {
      parami = new NullPointerException("Null runtime");
      AppMethodBeat.o(86725);
      throw parami;
    }
    ListIterator localListIterator = this.gQz.listIterator();
    int i = 0;
    while (localListIterator.hasNext())
    {
      i locali = (i)localListIterator.next();
      if (locali == parami)
      {
        i = 1;
      }
      else if (i != 0)
      {
        AppMethodBeat.o(86725);
        return locali;
      }
    }
    if (i == 0)
    {
      parami = new IllegalAccessError(String.format("Runtime not in stack %s", new Object[] { parami.mAppId }));
      AppMethodBeat.o(86725);
      throw parami;
    }
    AppMethodBeat.o(86725);
    return null;
  }
  
  public RUNTIME g(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(86720);
    paramAppBrandInitConfig = (i)a.ba(this.gQC).ac(new Object[] { this.gQx, this }).object;
    AppMethodBeat.o(86720);
    return paramAppBrandInitConfig;
  }
  
  public final boolean g(i parami)
  {
    AppMethodBeat.i(86727);
    boolean bool = this.gQz.contains(parami);
    AppMethodBeat.o(86727);
    return bool;
  }
  
  public final void h(i parami)
  {
    AppMethodBeat.i(86731);
    if (parami == null)
    {
      AppMethodBeat.o(86731);
      return;
    }
    this.gQx.runOnUiThread(new k.6(this, parami));
    AppMethodBeat.o(86731);
  }
  
  protected final boolean i(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(86732);
    if (this.gQz.peekFirst() == paramRUNTIME)
    {
      AppMethodBeat.o(86732);
      return true;
    }
    AppMethodBeat.o(86732);
    return false;
  }
  
  final void j(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(86733);
    this.gQz.remove(paramRUNTIME);
    this.gQz.push(paramRUNTIME);
    paramRUNTIME.gPC.setVisibility(0);
    this.gQy.bringChildToFront(paramRUNTIME.gPC);
    AppMethodBeat.o(86733);
  }
  
  final void k(RUNTIME paramRUNTIME)
  {
    AppMethodBeat.i(86734);
    if (this.gQz.contains(paramRUNTIME))
    {
      AppMethodBeat.o(86734);
      return;
    }
    this.gQz.push(paramRUNTIME);
    if (this.gQy.indexOfChild(paramRUNTIME.gPC) == -1) {
      this.gQy.addView(paramRUNTIME.gPC);
    }
    this.gQA.remove(paramRUNTIME.mAppId);
    AppMethodBeat.o(86734);
  }
  
  public final void l(i parami)
  {
    AppMethodBeat.i(86736);
    if (parami == null)
    {
      AppMethodBeat.o(86736);
      return;
    }
    this.gQz.remove(parami);
    AppMethodBeat.o(86736);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(86729);
    i locali = atG();
    if (locali != null) {}
    for (;;)
    {
      try
      {
        if (locali.gPD == null)
        {
          com.tencent.mm.plugin.appbrand.widget.b.e locale = locali.gPE;
          com.tencent.mm.plugin.appbrand.widget.b.k localk = (com.tencent.mm.plugin.appbrand.widget.b.k)locale.jjm.peekLast();
          if (localk == null)
          {
            locale.setVisibility(8);
            i = 0;
            if ((i == 0) && (locali.gPB != null))
            {
              locali.gPB.onBackPressed();
              AppMethodBeat.o(86729);
            }
          }
          else
          {
            if (!localk.isCancelable()) {
              break label160;
            }
            localk.onCancel();
            locale.c(localk);
            break label160;
          }
        }
        else
        {
          e.a(locali.mAppId, e.d.gPf);
          locali.finish();
        }
        AppMethodBeat.o(86729);
        return;
      }
      catch (Exception localException)
      {
        com.tencent.luggage.g.d.e("MicroMsg.AppBrandRuntimeContainer", "onBackPressed e = %s", new Object[] { localException });
        al.d(new Runnable()
        {
          public final void run()
          {
            throw localException;
          }
        });
      }
      AppMethodBeat.o(86729);
      return;
      label160:
      int i = 1;
    }
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(86730);
    if (this.gQz != null)
    {
      Iterator localIterator = this.gQz.iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).onConfigurationChanged(paramConfiguration);
      }
    }
    AppMethodBeat.o(86730);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(86728);
    com.tencent.luggage.g.d.i("MicroMsg.AppBrandRuntimeContainer", "onResume tid = %d", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
    this.gQx.runOnUiThread(new k.4(this));
    AppMethodBeat.o(86728);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k
 * JD-Core Version:    0.7.0.1
 */