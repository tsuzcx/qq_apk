package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.mm.plugin.fts.ui.widget.FTSSayFooter;

final class FTSMainUI$12$2
  implements Runnable
{
  FTSMainUI$12$2(FTSMainUI.12 param12) {}
  
  public final void run()
  {
    FTSSayFooter localFTSSayFooter = FTSMainUI.c(this.kCn.kCm);
    if (!localFTSSayFooter.aWH()) {
      localFTSSayFooter.setVisibility(8);
    }
    FTSMainUI.c(this.kCn.kCm).postInvalidate();
    FTSMainUI.e(this.kCn.kCm).postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.12.2
 * JD-Core Version:    0.7.0.1
 */