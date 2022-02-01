package com.tencent.luggage.sdk.b.a.b;

import android.content.Context;
import android.content.res.Configuration;
import com.tencent.luggage.sdk.b.a.a.a;
import com.tencent.luggage.sdk.b.a.c;
import com.tencent.luggage.sdk.e.d;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.plugin.appbrand.page.ca;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public abstract class a<PAGE extends c>
  extends a.a<PAGE>
  implements af
{
  public a(PAGE paramPAGE)
  {
    super(paramPAGE);
  }
  
  public void PV()
  {
    Iterator localIterator = QL().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof com.tencent.mm.plugin.appbrand.page.a.b)) {
        ((com.tencent.mm.plugin.appbrand.page.a.b)localObject).onForeground();
      }
    }
  }
  
  public void PW()
  {
    Iterator localIterator = QL().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof com.tencent.mm.plugin.appbrand.page.a.b)) {
        ((com.tencent.mm.plugin.appbrand.page.a.b)localObject).onBackground();
      }
    }
  }
  
  public d QM()
  {
    c localc = (c)QK();
    if (localc == null) {
      return null;
    }
    return localc.QM();
  }
  
  public final <T extends com.tencent.luggage.a.b> T S(Class<T> paramClass)
  {
    return ((c)QK()).K(paramClass);
  }
  
  public void a(Map<String, Object> paramMap, ca paramca) {}
  
  public void b(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    Iterator localIterator = QL().iterator();
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
    Iterator localIterator = QL().iterator();
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
    Iterator localIterator = QL().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof com.tencent.mm.plugin.appbrand.page.a.b)) {
        ((com.tencent.mm.plugin.appbrand.page.a.b)localObject).onDestroy();
      }
    }
    super.cleanup();
  }
  
  public void dispatchStart() {}
  
  public final String getAppId()
  {
    e locale = QK();
    if (locale == null)
    {
      Log.printErrStackTrace("Luggage.AbstractPageViewRenderer", new Throwable(), "getAppId", new Object[0]);
      return null;
    }
    return locale.getAppId();
  }
  
  public final Context getContext()
  {
    Context localContext2 = ((c)QK()).getContext();
    Context localContext1 = localContext2;
    if (localContext2 == null) {
      localContext1 = MMApplicationContext.getContext();
    }
    return localContext1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.b.a
 * JD-Core Version:    0.7.0.1
 */