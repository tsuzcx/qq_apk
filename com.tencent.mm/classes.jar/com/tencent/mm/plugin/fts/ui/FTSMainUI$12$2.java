package com.tencent.mm.plugin.fts.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.widget.c;

final class FTSMainUI$12$2
  implements Runnable
{
  FTSMainUI$12$2(FTSMainUI.12 param12) {}
  
  public final void run()
  {
    AppMethodBeat.i(61880);
    FTSMainUI.a(this.mYk.mYi, false);
    if (FTSMainUI.c(this.mYk.mYi) != null) {
      FTSMainUI.c(this.mYk.mYi).bDp();
    }
    AppMethodBeat.o(61880);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.12.2
 * JD-Core Version:    0.7.0.1
 */