package com.tencent.mm.plugin.fts.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;

final class FTSBaseUI$3
  extends ah
{
  FTSBaseUI$3(FTSBaseUI paramFTSBaseUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && (!bk.bl(FTSBaseUI.b(this.kAY)))) {
      this.kAY.aVW();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSBaseUI.3
 * JD-Core Version:    0.7.0.1
 */