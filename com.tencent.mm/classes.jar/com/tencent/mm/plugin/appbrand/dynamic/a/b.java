package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.c;
import com.tencent.mm.modelappbrand.d;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.Set;

final class b
  implements d
{
  c hnW;
  Runnable hnX;
  Runnable hnY;
  Runnable hnZ;
  
  b(c paramc)
  {
    AppMethodBeat.i(10737);
    this.hnX = new b.1(this);
    this.hnY = new b.2(this);
    this.hnZ = new b.3(this);
    this.hnW = paramc;
    AppMethodBeat.o(10737);
  }
  
  public final void exit()
  {
    AppMethodBeat.i(10738);
    com.tencent.mm.plugin.appbrand.dynamic.b.C(this.hnY);
    AppMethodBeat.o(10738);
  }
  
  public final void qg(String paramString)
  {
    AppMethodBeat.i(10740);
    paramString = this.hnW.aS(paramString);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(10740);
      return;
    }
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      View localView = (View)paramString.next();
      if ((localView != null) && ((localView instanceof IPCDynamicPageView)))
      {
        ab.v("MicroMsg.DynamicPagePerformance", "pauseAllView, do pause view(%s)", new Object[] { Integer.valueOf(localView.hashCode()) });
        ((IPCDynamicPageView)localView).onPause();
      }
    }
    AppMethodBeat.o(10740);
  }
  
  public final void qh(String paramString)
  {
    AppMethodBeat.i(10741);
    paramString = this.hnW.aS(paramString);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(10741);
      return;
    }
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      View localView = (View)paramString.next();
      if ((localView != null) && ((localView instanceof IPCDynamicPageView)))
      {
        ab.v("MicroMsg.DynamicPagePerformance", "pauseAllView, do resume view(%s)", new Object[] { Integer.valueOf(localView.hashCode()) });
        ((IPCDynamicPageView)localView).onResume();
      }
    }
    AppMethodBeat.o(10741);
  }
  
  public final void restart()
  {
    AppMethodBeat.i(10739);
    com.tencent.mm.plugin.appbrand.dynamic.b.C(this.hnZ);
    com.tencent.mm.plugin.appbrand.dynamic.b.l(this.hnX, 2000L);
    AppMethodBeat.o(10739);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a.b
 * JD-Core Version:    0.7.0.1
 */