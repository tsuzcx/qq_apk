package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMFalseProgressBar;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class TmplWebViewToolUI$b$i
  implements Runnable
{
  TmplWebViewToolUI$b$i(TmplWebViewToolUI.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(15057);
    if (TmplWebViewToolUI.h(this.keJ.keI))
    {
      AppMethodBeat.o(15057);
      return;
    }
    MMFalseProgressBar localMMFalseProgressBar = TmplWebViewToolUI.m(this.keJ.keI);
    if (localMMFalseProgressBar != null)
    {
      localMMFalseProgressBar.start();
      AppMethodBeat.o(15057);
      return;
    }
    AppMethodBeat.o(15057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI.b.i
 * JD-Core Version:    0.7.0.1
 */