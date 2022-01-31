package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class n$1
  implements Runnable
{
  n$1(n paramn) {}
  
  public final void run()
  {
    int i = 0;
    AppMethodBeat.i(126663);
    if (n.b(this.jmf) == null)
    {
      AppMethodBeat.o(126663);
      return;
    }
    ab.i("MicroMsg.AppBrandUIdRootFrameLayout", "hideInactivePanelView, mPanel %s", new Object[] { n.b(this.jmf).getClass().getSimpleName() });
    while (i < this.jmf.getChildCount())
    {
      View localView = this.jmf.getChildAt(i);
      if ((localView != null) && (localView != n.c(this.jmf)) && (localView != n.b(this.jmf))) {
        n.cM(localView);
      }
      i += 1;
    }
    AppMethodBeat.o(126663);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.n.1
 * JD-Core Version:    0.7.0.1
 */