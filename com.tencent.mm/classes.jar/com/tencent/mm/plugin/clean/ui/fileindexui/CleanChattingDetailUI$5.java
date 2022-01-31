package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CleanChattingDetailUI$5
  implements Runnable
{
  CleanChattingDetailUI$5(CleanChattingDetailUI paramCleanChattingDetailUI, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(18770);
    CleanChattingDetailUI.c(this.kIa).setMessage(this.kIa.getString(2131298394, new Object[] { this.fzv * 100 / this.fFB + "%" }));
    AppMethodBeat.o(18770);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingDetailUI.5
 * JD-Core Version:    0.7.0.1
 */