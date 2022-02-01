package com.tencent.luggage.sdk.b.a.b;

import android.content.Context;
import android.content.res.Configuration;
import com.tencent.luggage.sdk.b.a.a.a;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.bt;
import com.tencent.mm.sdk.platformtools.ai;
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
  
  public com.tencent.luggage.sdk.d.c CO()
  {
    com.tencent.luggage.sdk.b.a.c localc = (com.tencent.luggage.sdk.b.a.c)CM();
    if (localc == null) {
      return null;
    }
    return localc.CO();
  }
  
  public void Cf()
  {
    Iterator localIterator = CN().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof com.tencent.mm.plugin.appbrand.page.b.b)) {
        ((com.tencent.mm.plugin.appbrand.page.b.b)localObject).onForeground();
      }
    }
  }
  
  public void Cg()
  {
    Iterator localIterator = CN().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof com.tencent.mm.plugin.appbrand.page.b.b)) {
        ((com.tencent.mm.plugin.appbrand.page.b.b)localObject).onBackground();
      }
    }
  }
  
  public final <T extends com.tencent.luggage.a.b> T R(Class<T> paramClass)
  {
    return ((com.tencent.luggage.sdk.b.a.c)CM()).K(paramClass);
  }
  
  public void a(Map<String, Object> paramMap, bt parambt) {}
  
  public void b(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    Iterator localIterator = CN().iterator();
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
    Iterator localIterator = CN().iterator();
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
    ??? = CN().iterator();
    while (((Iterator)???).hasNext())
    {
      Object localObject3 = ((Iterator)???).next();
      if ((localObject3 instanceof com.tencent.mm.plugin.appbrand.page.b.b)) {
        ((com.tencent.mm.plugin.appbrand.page.b.b)localObject3).onDestroy();
      }
    }
    synchronized (this.ccV)
    {
      this.ccV.clear();
    }
  }
  
  public void dispatchStart() {}
  
  public final Context getContext()
  {
    Context localContext2 = ((com.tencent.luggage.sdk.b.a.c)CM()).getContext();
    Context localContext1 = localContext2;
    if (localContext2 == null) {
      localContext1 = ai.getContext();
    }
    return localContext1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.b.a
 * JD-Core Version:    0.7.0.1
 */