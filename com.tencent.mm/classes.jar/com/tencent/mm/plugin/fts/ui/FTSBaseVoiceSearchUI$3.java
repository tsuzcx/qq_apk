package com.tencent.mm.plugin.fts.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;

final class FTSBaseVoiceSearchUI$3
  extends ah
{
  FTSBaseVoiceSearchUI$3(FTSBaseVoiceSearchUI paramFTSBaseVoiceSearchUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && (!bk.bl(FTSBaseVoiceSearchUI.a(this.kBc)))) {
      this.kBc.aVW();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI.3
 * JD-Core Version:    0.7.0.1
 */