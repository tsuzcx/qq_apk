package com.tencent.mm.plugin.forcenotify.ui;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.plugin.forcenotify.c.b;
import com.tencent.mm.vending.c.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class ForceNotifyAcceptUI$c
  implements Runnable
{
  ForceNotifyAcceptUI$c(ForceNotifyAcceptUI paramForceNotifyAcceptUI, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(140603);
    new b(this.mHA).adl().b((a)new ForceNotifyAcceptUI.c.1(this));
    AppMethodBeat.o(140603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyAcceptUI.c
 * JD-Core Version:    0.7.0.1
 */