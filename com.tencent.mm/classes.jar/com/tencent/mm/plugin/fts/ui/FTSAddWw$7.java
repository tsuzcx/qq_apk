package com.tencent.mm.plugin.fts.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FTSAddWw$7
  implements Runnable
{
  FTSAddWw$7(FTSAddWw paramFTSAddWw) {}
  
  public final void run()
  {
    AppMethodBeat.i(61759);
    if (FTSAddWw.j(this.mWE) != null)
    {
      FTSAddWw.j(this.mWE).dismiss();
      FTSAddWw.i(this.mWE);
    }
    AppMethodBeat.o(61759);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddWw.7
 * JD-Core Version:    0.7.0.1
 */