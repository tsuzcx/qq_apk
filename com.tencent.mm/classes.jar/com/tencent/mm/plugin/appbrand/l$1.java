package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.ui.base.b;

final class l$1
  implements Runnable
{
  l$1(l paraml, Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(143030);
    this.bFi.run();
    if ((this.gQN.atG() != null) && (!p.m(this.gQN.atG())))
    {
      l locall = this.gQN;
      if ((locall.gQx instanceof AppBrandPluginUI)) {
        b.a(locall.gQx, null);
      }
    }
    AppMethodBeat.o(143030);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.l.1
 * JD-Core Version:    0.7.0.1
 */