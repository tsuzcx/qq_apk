package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.view.View;
import com.tencent.mm.modelappbrand.c;
import com.tencent.mm.modelappbrand.d;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.Set;

final class b
  implements d
{
  c fUu;
  Runnable fUv = new b.1(this);
  Runnable fUw = new b.2(this);
  Runnable fUx = new b.3(this);
  
  b(c paramc)
  {
    this.fUu = paramc;
  }
  
  public final void exit()
  {
    com.tencent.mm.plugin.appbrand.dynamic.b.u(this.fUw);
  }
  
  public final void js(String paramString)
  {
    paramString = this.fUu.ay(paramString);
    if ((paramString == null) || (paramString.isEmpty())) {}
    for (;;)
    {
      return;
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        View localView = (View)paramString.next();
        if ((localView != null) && ((localView instanceof IPCDynamicPageView)))
        {
          y.v("MicroMsg.DynamicPagePerformance", "pauseAllView, do pause view(%s)", new Object[] { Integer.valueOf(localView.hashCode()) });
          ((IPCDynamicPageView)localView).onPause();
        }
      }
    }
  }
  
  public final void jt(String paramString)
  {
    paramString = this.fUu.ay(paramString);
    if ((paramString == null) || (paramString.isEmpty())) {}
    for (;;)
    {
      return;
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        View localView = (View)paramString.next();
        if ((localView != null) && ((localView instanceof IPCDynamicPageView)))
        {
          y.v("MicroMsg.DynamicPagePerformance", "pauseAllView, do resume view(%s)", new Object[] { Integer.valueOf(localView.hashCode()) });
          ((IPCDynamicPageView)localView).onResume();
        }
      }
    }
  }
  
  public final void restart()
  {
    com.tencent.mm.plugin.appbrand.dynamic.b.u(this.fUx);
    com.tencent.mm.plugin.appbrand.dynamic.b.h(this.fUv, 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a.b
 * JD-Core Version:    0.7.0.1
 */