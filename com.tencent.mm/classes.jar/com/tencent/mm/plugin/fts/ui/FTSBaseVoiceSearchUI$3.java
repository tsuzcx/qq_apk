package com.tencent.mm.plugin.fts.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

final class FTSBaseVoiceSearchUI$3
  extends ak
{
  FTSBaseVoiceSearchUI$3(FTSBaseVoiceSearchUI paramFTSBaseVoiceSearchUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(61784);
    if ((paramMessage.what == 1) && (!bo.isNullOrNil(FTSBaseVoiceSearchUI.a(this.mWU)))) {
      this.mWU.bCz();
    }
    AppMethodBeat.o(61784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI.3
 * JD-Core Version:    0.7.0.1
 */