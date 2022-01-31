package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import android.widget.ImageButton;
import com.tencent.mm.plugin.fts.ui.widget.FTSSayFooter;
import com.tencent.mm.sdk.platformtools.x;

final class FTSMainUI$12$1
  implements Runnable
{
  FTSMainUI$12$1(FTSMainUI.12 param12) {}
  
  public final void run()
  {
    if ((x.cqF()) || (x.cqJ().equals("en"))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        FTSSayFooter localFTSSayFooter = FTSMainUI.c(this.kCn.kCm);
        localFTSSayFooter.setVisibility(0);
        localFTSSayFooter.aWJ();
        if (localFTSSayFooter.kEW != null) {
          localFTSSayFooter.kEW.setImageResource(n.c.fts_setmode_voice_btn);
        }
        FTSMainUI.c(this.kCn.kCm).postInvalidate();
        FTSMainUI.d(this.kCn.kCm).postInvalidate();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.12.1
 * JD-Core Version:    0.7.0.1
 */