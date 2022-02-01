package com.tencent.luggage.sdk.b.a.b;

import android.content.Context;
import android.content.res.Configuration;
import com.tencent.luggage.sdk.b.a.a.a;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.bs;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public abstract class a<PAGE extends com.tencent.luggage.sdk.b.a.c>
  extends a.a<PAGE>
  implements ac
{
  public a(PAGE paramPAGE)
  {
    super(paramPAGE);
  }
  
  public void DE()
  {
    Iterator localIterator = Em().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof com.tencent.mm.plugin.appbrand.page.b.b)) {
        ((com.tencent.mm.plugin.appbrand.page.b.b)localObject).onForeground();
      }
    }
  }
  
  public void DF()
  {
    Iterator localIterator = Em().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof com.tencent.mm.plugin.appbrand.page.b.b)) {
        ((com.tencent.mm.plugin.appbrand.page.b.b)localObject).onBackground();
      }
    }
  }
  
  public com.tencent.luggage.sdk.d.c En()
  {
    com.tencent.luggage.sdk.b.a.c localc = (com.tencent.luggage.sdk.b.a.c)El();
    if (localc == null) {
      return null;
    }
    return localc.En();
  }
  
  public final <T extends com.tencent.luggage.a.b> T R(Class<T> paramClass)
  {
    return ((com.tencent.luggage.sdk.b.a.c)El()).K(paramClass);
  }
  
  public void a(Map<String, Object> paramMap, bs parambs) {}
  
  public void b(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    Iterator localIterator = Em().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof com.tencent.mm.plugin.appbrand.page.b.b)) {
        ((com.tencent.mm.plugin.appbrand.page.b.b)localObject).a(paramb);
      }
    }
  }
  
  public final void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    Iterator localIterator = Em().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof com.tencent.mm.plugin.appbrand.page.b.b)) {
        ((com.tencent.mm.plugin.appbrand.page.b.b)localObject).onConfigurationChanged(paramConfiguration);
      }
    }
  }
  
  public void dispatchDestroy()
  {
    ??? = Em().iterator();
    while (((Iterator)???).hasNext())
    {
      Object localObject3 = ((Iterator)???).next();
      if ((localObject3 instanceof com.tencent.mm.plugin.appbrand.page.b.b)) {
        ((com.tencent.mm.plugin.appbrand.page.b.b)localObject3).onDestroy();
      }
    }
    synchronized (this.cnm)
    {
      this.cnm.clear();
    }
  }
  
  public void dispatchStart() {}
  
  public final Context getContext()
  {
    Context localContext2 = ((com.tencent.luggage.sdk.b.a.c)El()).getContext();
    Context localContext1 = localContext2;
    if (localContext2 == null) {
      localContext1 = aj.getContext();
    }
    return localContext1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.b.a
 * JD-Core Version:    0.7.0.1
 */