package com.tencent.luggage.sdk.b.a.b;

import android.content.Context;
import android.content.res.Configuration;
import com.tencent.luggage.sdk.b.a.a.a;
import com.tencent.luggage.sdk.b.a.c;
import com.tencent.luggage.sdk.d.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.bx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public abstract class a<PAGE extends c>
  extends a.a<PAGE>
  implements ae
{
  public a(PAGE paramPAGE)
  {
    super(paramPAGE);
  }
  
  public d NP()
  {
    c localc = (c)NN();
    if (localc == null) {
      return null;
    }
    return localc.NP();
  }
  
  public void Nd()
  {
    Iterator localIterator = NO().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof com.tencent.mm.plugin.appbrand.page.a.b)) {
        ((com.tencent.mm.plugin.appbrand.page.a.b)localObject).onForeground();
      }
    }
  }
  
  public void Ne()
  {
    Iterator localIterator = NO().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof com.tencent.mm.plugin.appbrand.page.a.b)) {
        ((com.tencent.mm.plugin.appbrand.page.a.b)localObject).onBackground();
      }
    }
  }
  
  public final <T extends com.tencent.luggage.a.b> T T(Class<T> paramClass)
  {
    return ((c)NN()).M(paramClass);
  }
  
  public void a(Map<String, Object> paramMap, bx parambx) {}
  
  public void b(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    Iterator localIterator = NO().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof com.tencent.mm.plugin.appbrand.page.a.b)) {
        ((com.tencent.mm.plugin.appbrand.page.a.b)localObject).a(paramb);
      }
    }
  }
  
  public final void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    Iterator localIterator = NO().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof com.tencent.mm.plugin.appbrand.page.a.b)) {
        ((com.tencent.mm.plugin.appbrand.page.a.b)localObject).onConfigurationChanged(paramConfiguration);
      }
    }
  }
  
  public void dispatchDestroy()
  {
    ??? = NO().iterator();
    while (((Iterator)???).hasNext())
    {
      Object localObject3 = ((Iterator)???).next();
      if ((localObject3 instanceof com.tencent.mm.plugin.appbrand.page.a.b)) {
        ((com.tencent.mm.plugin.appbrand.page.a.b)localObject3).onDestroy();
      }
    }
    synchronized (this.czn)
    {
      this.czn.clear();
    }
  }
  
  public void dispatchStart() {}
  
  public final String getAppId()
  {
    f localf = NN();
    if (localf == null)
    {
      Log.printErrStackTrace("Luggage.AbstractPageViewRenderer", new Throwable(), "getAppId", new Object[0]);
      return null;
    }
    return localf.getAppId();
  }
  
  public final Context getContext()
  {
    Context localContext2 = ((c)NN()).getContext();
    Context localContext1 = localContext2;
    if (localContext2 == null) {
      localContext1 = MMApplicationContext.getContext();
    }
    return localContext1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.b.a
 * JD-Core Version:    0.7.0.1
 */