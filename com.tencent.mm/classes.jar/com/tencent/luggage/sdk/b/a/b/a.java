package com.tencent.luggage.sdk.b.a.b;

import android.content.Context;
import android.content.res.Configuration;
import com.tencent.luggage.sdk.b.a.a.a;
import com.tencent.luggage.sdk.b.a.c;
import com.tencent.luggage.sdk.d.d;
import com.tencent.mm.plugin.appbrand.page.ab;
import com.tencent.mm.plugin.appbrand.page.br;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public abstract class a<PAGE extends c>
  extends a.a<PAGE>
  implements ab
{
  public a(PAGE paramPAGE)
  {
    super(paramPAGE);
  }
  
  public void DH()
  {
    Iterator localIterator = Ep().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof com.tencent.mm.plugin.appbrand.page.a.b)) {
        ((com.tencent.mm.plugin.appbrand.page.a.b)localObject).onForeground();
      }
    }
  }
  
  public void DI()
  {
    Iterator localIterator = Ep().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof com.tencent.mm.plugin.appbrand.page.a.b)) {
        ((com.tencent.mm.plugin.appbrand.page.a.b)localObject).onBackground();
      }
    }
  }
  
  public d Eq()
  {
    c localc = (c)Eo();
    if (localc == null) {
      return null;
    }
    return localc.Eq();
  }
  
  public final <T extends com.tencent.luggage.a.b> T R(Class<T> paramClass)
  {
    return ((c)Eo()).K(paramClass);
  }
  
  public void a(Map<String, Object> paramMap, br parambr) {}
  
  public void b(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    Iterator localIterator = Ep().iterator();
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
    Iterator localIterator = Ep().iterator();
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
    ??? = Ep().iterator();
    while (((Iterator)???).hasNext())
    {
      Object localObject3 = ((Iterator)???).next();
      if ((localObject3 instanceof com.tencent.mm.plugin.appbrand.page.a.b)) {
        ((com.tencent.mm.plugin.appbrand.page.a.b)localObject3).onDestroy();
      }
    }
    synchronized (this.cno)
    {
      this.cno.clear();
    }
  }
  
  public void dispatchStart() {}
  
  public final Context getContext()
  {
    Context localContext2 = ((c)Eo()).getContext();
    Context localContext1 = localContext2;
    if (localContext2 == null) {
      localContext1 = ak.getContext();
    }
    return localContext1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.b.a
 * JD-Core Version:    0.7.0.1
 */