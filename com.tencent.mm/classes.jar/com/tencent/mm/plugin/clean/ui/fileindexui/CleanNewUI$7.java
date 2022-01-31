package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CleanNewUI$7
  implements Runnable
{
  CleanNewUI$7(CleanNewUI paramCleanNewUI, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(18819);
    CleanNewUI.k(this.kIY).setText(this.kIY.getString(2131296534, new Object[] { this.gQj * 100 / this.fFB + "%" }));
    AppMethodBeat.o(18819);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.7
 * JD-Core Version:    0.7.0.1
 */