package com.tencent.mm.plugin.fts.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.d;

final class FTSMainUI$8
  implements Runnable
{
  FTSMainUI$8(FTSMainUI paramFTSMainUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(111971);
    d.aEL().a(this.sDB, true);
    AppMethodBeat.o(111971);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.8
 * JD-Core Version:    0.7.0.1
 */