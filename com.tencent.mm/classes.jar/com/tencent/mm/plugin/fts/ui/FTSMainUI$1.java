package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class FTSMainUI$1
  implements Runnable
{
  FTSMainUI$1(FTSMainUI paramFTSMainUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(61866);
    ab.i("MicroMsg.FTS.FTSMainUI", "showSearchNetworkLayoutRunnable canShow %b", new Object[] { Boolean.valueOf(FTSMainUI.a(this.mYi)) });
    if (FTSMainUI.a(this.mYi)) {
      FTSMainUI.b(this.mYi).setVisibility(0);
    }
    AppMethodBeat.o(61866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.1
 * JD-Core Version:    0.7.0.1
 */