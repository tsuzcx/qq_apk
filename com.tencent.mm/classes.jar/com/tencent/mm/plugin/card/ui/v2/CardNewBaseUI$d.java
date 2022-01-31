package com.tencent.mm.plugin.card.ui.v2;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class CardNewBaseUI$d
  implements Runnable
{
  CardNewBaseUI$d(CardNewBaseUI paramCardNewBaseUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(89286);
    ab.i("MicroMsg.CardNewBaseUI", "remove location in task");
    CardNewBaseUI.a(this.kAs);
    AppMethodBeat.o(89286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI.d
 * JD-Core Version:    0.7.0.1
 */