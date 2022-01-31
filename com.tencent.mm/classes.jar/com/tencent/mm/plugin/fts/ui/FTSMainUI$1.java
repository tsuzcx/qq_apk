package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.mm.sdk.platformtools.y;

final class FTSMainUI$1
  implements Runnable
{
  FTSMainUI$1(FTSMainUI paramFTSMainUI) {}
  
  public final void run()
  {
    y.i("MicroMsg.FTS.FTSMainUI", "showSearchNetworkLayoutRunnable canShow %b", new Object[] { Boolean.valueOf(FTSMainUI.a(this.kCm)) });
    if (FTSMainUI.a(this.kCm)) {
      FTSMainUI.b(this.kCm).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.1
 * JD-Core Version:    0.7.0.1
 */