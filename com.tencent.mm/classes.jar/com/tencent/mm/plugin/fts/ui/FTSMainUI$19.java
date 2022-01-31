package com.tencent.mm.plugin.fts.ui;

import android.widget.ImageButton;
import com.tencent.mm.plugin.fts.ui.widget.FTSSayFooter;
import com.tencent.mm.plugin.fts.ui.widget.FTSSayFooter.a;
import com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl;
import com.tencent.mm.plugin.fts.ui.widget.b.a;
import com.tencent.mm.ui.MMActivity;

final class FTSMainUI$19
  implements b.a
{
  FTSMainUI$19(FTSMainUI paramFTSMainUI) {}
  
  public final void aWs()
  {
    FTSSayFooter localFTSSayFooter = FTSMainUI.c(this.kCm);
    localFTSSayFooter.setVisibility(0);
    if (localFTSSayFooter.kEU.getVisibility() != 0)
    {
      localFTSSayFooter.bER.XM();
      localFTSSayFooter.aWK();
      localFTSSayFooter.kEV.aWr();
      localFTSSayFooter.kEW.setImageResource(n.c.fts_setmode_keyboard_btn);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.19
 * JD-Core Version:    0.7.0.1
 */