package com.tencent.mm.plugin.fts.ui;

import android.app.Dialog;

final class FTSMainUI$8
  implements Runnable
{
  FTSMainUI$8(FTSMainUI paramFTSMainUI) {}
  
  public final void run()
  {
    if (FTSMainUI.r(this.kCm) != null)
    {
      FTSMainUI.r(this.kCm).dismiss();
      FTSMainUI.q(this.kCm);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.8
 * JD-Core Version:    0.7.0.1
 */