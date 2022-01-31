package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CleanChattingUI$7
  implements Runnable
{
  CleanChattingUI$7(CleanChattingUI paramCleanChattingUI, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(18786);
    CleanChattingUI.g(this.kIi).setMessage(this.kIi.getString(2131298394, new Object[] { this.fzv * 100 / this.fFB + "%" }));
    AppMethodBeat.o(18786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI.7
 * JD-Core Version:    0.7.0.1
 */