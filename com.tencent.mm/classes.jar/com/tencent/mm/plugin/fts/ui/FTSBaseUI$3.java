package com.tencent.mm.plugin.fts.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

final class FTSBaseUI$3
  extends ak
{
  FTSBaseUI$3(FTSBaseUI paramFTSBaseUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(61781);
    if ((paramMessage.what == 1) && (!bo.isNullOrNil(FTSBaseUI.b(this.mWQ)))) {
      this.mWQ.bCz();
    }
    AppMethodBeat.o(61781);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSBaseUI.3
 * JD-Core Version:    0.7.0.1
 */