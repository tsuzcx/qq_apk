package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.preload.a;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class TmplWebViewToolUI$b$c
  implements Runnable
{
  TmplWebViewToolUI$b$c(TmplWebViewToolUI.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(15050);
    if (!TmplWebViewToolUI.b(this.keJ.keI).kdy)
    {
      a.kS(92);
      this.keJ.keD.kbo = true;
      this.keJ.keD.kbp = true;
      TmplWebViewToolUI.a(this.keJ.keI);
      this.keJ.aYV();
      ab.e(TmplWebViewToolUI.c(this.keJ.keI), "check notifyPage timeout");
    }
    AppMethodBeat.o(15050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI.b.c
 * JD-Core Version:    0.7.0.1
 */