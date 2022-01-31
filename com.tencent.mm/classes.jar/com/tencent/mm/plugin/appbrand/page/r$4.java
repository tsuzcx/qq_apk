package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.e;

final class r$4
  implements f.e
{
  r$4(r paramr, o paramo, Runnable paramRunnable) {}
  
  public final void onReady()
  {
    AppMethodBeat.i(141665);
    this.iwt.getCurrentPageView().b(this);
    this.iwq.removeCallbacks(this.iwu);
    this.iwq.post(this.iwu);
    this.iwq.aJe();
    AppMethodBeat.o(141665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.r.4
 * JD-Core Version:    0.7.0.1
 */