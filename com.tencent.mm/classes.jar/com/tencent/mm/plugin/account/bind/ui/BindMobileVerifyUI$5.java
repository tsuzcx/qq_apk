package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.TimerTask;

final class BindMobileVerifyUI$5
  extends TimerTask
{
  BindMobileVerifyUI$5(BindMobileVerifyUI paramBindMobileVerifyUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(13533);
    if (BindMobileVerifyUI.c(this.guw) != null) {
      BindMobileVerifyUI.d(this.guw);
    }
    AppMethodBeat.o(13533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileVerifyUI.5
 * JD-Core Version:    0.7.0.1
 */