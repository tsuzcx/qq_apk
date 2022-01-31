package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.w;
import org.b.a;

final class d$2$1
  implements Runnable
{
  d$2$1(d.2 param2) {}
  
  public final void run()
  {
    try
    {
      if ((this.gOR.gjp.gTF instanceof w)) {
        a.cz(((w)this.gOR.gjp.gTF).getX5WebViewExtension()).y("notifyMemoryPressure", new Object[] { Integer.valueOf(80) });
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.d.2.1
 * JD-Core Version:    0.7.0.1
 */