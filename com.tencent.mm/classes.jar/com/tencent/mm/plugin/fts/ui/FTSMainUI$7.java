package com.tencent.mm.plugin.fts.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FTSMainUI$7
  implements Runnable
{
  FTSMainUI$7(FTSMainUI paramFTSMainUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(61872);
    if (FTSMainUI.q(this.mYi) != null)
    {
      FTSMainUI.q(this.mYi).dismiss();
      FTSMainUI.p(this.mYi);
    }
    AppMethodBeat.o(61872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.7
 * JD-Core Version:    0.7.0.1
 */