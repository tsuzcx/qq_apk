package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.app.ProgressDialog;
import com.tencent.mm.R.l;

final class CleanChattingUI$7
  implements Runnable
{
  CleanChattingUI$7(CleanChattingUI paramCleanChattingUI, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    CleanChattingUI.g(this.iDb).setMessage(this.iDb.getString(R.l.clean_progress_tip, new Object[] { this.ejr * 100 / this.epd + "%" }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI.7
 * JD-Core Version:    0.7.0.1
 */