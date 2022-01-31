package com.tencent.mm.plugin.fts.ui;

import android.app.Dialog;

final class FTSAddWw$7
  implements Runnable
{
  FTSAddWw$7(FTSAddWw paramFTSAddWw) {}
  
  public final void run()
  {
    if (FTSAddWw.i(this.kAM) != null)
    {
      FTSAddWw.i(this.kAM).dismiss();
      FTSAddWw.h(this.kAM);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddWw.7
 * JD-Core Version:    0.7.0.1
 */