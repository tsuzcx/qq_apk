package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class j$3
  implements Runnable
{
  j$3(j paramj) {}
  
  public final void run()
  {
    AppMethodBeat.i(134967);
    if (j.c(this.kYG))
    {
      AppMethodBeat.o(134967);
      return;
    }
    Object localObject = this.kYG.getCurrentPageView();
    if (localObject == null)
    {
      AppMethodBeat.o(134967);
      return;
    }
    com.tencent.mm.plugin.appbrand.widget.actionbar.b localb = ((aa)localObject).bjH();
    if (localb == null)
    {
      AppMethodBeat.o(134967);
      return;
    }
    localObject = ((aa)localObject).lbc;
    int i = localb.getTop();
    ((com.tencent.mm.plugin.appbrand.widget.e.b)localObject).vs(localb.getMeasuredHeight() + i);
    AppMethodBeat.o(134967);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.j.3
 * JD-Core Version:    0.7.0.1
 */