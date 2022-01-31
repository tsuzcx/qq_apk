package com.tencent.luggage.sdk.b.a.b;

import android.content.Context;
import android.content.res.Configuration;
import com.tencent.luggage.sdk.b.a.a.a;
import com.tencent.luggage.sdk.b.a.c;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public abstract class a<PAGE extends c>
  extends a.a<PAGE>
  implements x
{
  public a(PAGE paramPAGE)
  {
    super(paramPAGE);
  }
  
  public final void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    Iterator localIterator = wi().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof com.tencent.mm.plugin.appbrand.page.b.a)) {
        ((com.tencent.mm.plugin.appbrand.page.b.a)localObject).onConfigurationChanged(paramConfiguration);
      }
    }
  }
  
  public void dispatchDestroy()
  {
    ??? = wi().iterator();
    while (((Iterator)???).hasNext())
    {
      Object localObject2 = ((Iterator)???).next();
      if ((localObject2 instanceof com.tencent.mm.plugin.appbrand.page.b.a)) {
        ((com.tencent.mm.plugin.appbrand.page.b.a)localObject2).onDestroy();
      }
    }
    synchronized (this.bDO)
    {
      this.bDO.clear();
      return;
    }
  }
  
  public void dispatchStart() {}
  
  public final Context getContext()
  {
    Context localContext2 = ((c)this.bDN).getContext();
    Context localContext1 = localContext2;
    if (localContext2 == null) {
      localContext1 = ah.getContext();
    }
    return localContext1;
  }
  
  public void vD()
  {
    Iterator localIterator = wi().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof com.tencent.mm.plugin.appbrand.page.b.a)) {
        ((com.tencent.mm.plugin.appbrand.page.b.a)localObject).onForeground();
      }
    }
  }
  
  public void vE()
  {
    Iterator localIterator = wi().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof com.tencent.mm.plugin.appbrand.page.b.a)) {
        ((com.tencent.mm.plugin.appbrand.page.b.a)localObject).onBackground();
      }
    }
  }
  
  public com.tencent.luggage.sdk.d.b wj()
  {
    return ((c)this.bDN).wj();
  }
  
  public final <T extends com.tencent.luggage.a.b> T y(Class<T> paramClass)
  {
    return ((c)this.bDN).q(paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.b.a
 * JD-Core Version:    0.7.0.1
 */