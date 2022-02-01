package com.tencent.mm.plugin.fts.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FTSMainUI$2
  implements Runnable
{
  FTSMainUI$2(FTSMainUI paramFTSMainUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(111963);
    if (FTSMainUI.h(this.sDB) != null)
    {
      FTSMainUI.h(this.sDB).dismiss();
      FTSMainUI.g(this.sDB);
    }
    AppMethodBeat.o(111963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.2
 * JD-Core Version:    0.7.0.1
 */