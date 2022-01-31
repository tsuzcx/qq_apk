package com.tencent.mm.plugin.account.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.TimerTask;

final class MobileVerifyUI$1
  extends TimerTask
{
  MobileVerifyUI$1(MobileVerifyUI paramMobileVerifyUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(125269);
    this.gHp.gGZ.post(new MobileVerifyUI.1.1(this));
    AppMethodBeat.o(125269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileVerifyUI.1
 * JD-Core Version:    0.7.0.1
 */