package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.widget.TextView;
import com.tencent.mm.R.l;

final class CleanNewUI$7
  implements Runnable
{
  CleanNewUI$7(CleanNewUI paramCleanNewUI, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    CleanNewUI.k(this.iDR).setText(this.iDR.getString(R.l.analyse_file_profress, new Object[] { this.fyT * 100 / this.epd + "%" }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.7
 * JD-Core Version:    0.7.0.1
 */