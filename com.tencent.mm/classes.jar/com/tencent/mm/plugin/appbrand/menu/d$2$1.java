package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.v;
import org.a.a;

final class d$2$1
  implements Runnable
{
  d$2$1(d.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(132203);
    try
    {
      if ((this.iqz.hKE.iuy instanceof ad)) {
        a.ep(((ad)this.iqz.hKE.iuy).getX5WebViewExtension()).q("notifyMemoryPressure", new Object[] { Integer.valueOf(80) });
      }
      AppMethodBeat.o(132203);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(132203);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.d.2.1
 * JD-Core Version:    0.7.0.1
 */