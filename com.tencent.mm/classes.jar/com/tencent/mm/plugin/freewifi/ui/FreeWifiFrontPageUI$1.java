package com.tencent.mm.plugin.freewifi.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class FreeWifiFrontPageUI$1
  extends ak
{
  FreeWifiFrontPageUI$1(FreeWifiFrontPageUI paramFreeWifiFrontPageUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(20959);
    paramMessage = (FreeWifiFrontPageUI.c)paramMessage.obj;
    switch (FreeWifiFrontPageUI.3.mNE[paramMessage.mNC.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(20959);
      return;
      this.mND.bBx();
      AppMethodBeat.o(20959);
      return;
      this.mND.bBy();
      AppMethodBeat.o(20959);
      return;
      this.mND.bL(paramMessage.data);
      AppMethodBeat.o(20959);
      return;
      this.mND.bM(paramMessage.data);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.1
 * JD-Core Version:    0.7.0.1
 */