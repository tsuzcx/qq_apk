package com.tencent.luggage.game.e.b;

import com.tencent.luggage.game.widget.input.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.r;

final class d$1
  implements Runnable
{
  d$1(d paramd, r paramr) {}
  
  public final void run()
  {
    AppMethodBeat.i(140471);
    Object localObject = this.bAW.getCurrentPageView();
    if (localObject == null)
    {
      AppMethodBeat.o(140471);
      return;
    }
    localObject = a.cf(((v)localObject).hmw);
    if (localObject != null) {
      ((a)localObject).hide();
    }
    AppMethodBeat.o(140471);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.e.b.d.1
 * JD-Core Version:    0.7.0.1
 */