package com.tencent.mm.plugin.fts.ui;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.KeyboardLinearLayout.a;

final class FTSMainUI$12
  implements KeyboardLinearLayout.a
{
  FTSMainUI$12(FTSMainUI paramFTSMainUI) {}
  
  public final void rD(int paramInt)
  {
    if (paramInt == -3)
    {
      y.d("MicroMsg.FTS.FTSMainUI", "KEYBOARD_STATE_SHOW");
      new ah().postDelayed(new FTSMainUI.12.1(this), 100L);
    }
    while (paramInt != -2) {
      return;
    }
    new ah().postDelayed(new FTSMainUI.12.2(this), 200L);
    y.d("MicroMsg.FTS.FTSMainUI", "KEYBOARD_STATE_HIDE");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.12
 * JD-Core Version:    0.7.0.1
 */