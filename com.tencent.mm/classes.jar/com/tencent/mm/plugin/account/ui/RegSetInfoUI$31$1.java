package com.tencent.mm.plugin.account.ui;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RegSetInfoUI$31$1
  implements Runnable
{
  RegSetInfoUI$31$1(RegSetInfoUI.31 param31) {}
  
  public final void run()
  {
    AppMethodBeat.i(125536);
    RegSetInfoUI.a(this.gJY.gJQ).clearFocus();
    RegSetInfoUI.a(this.gJY.gJQ).requestFocus();
    AppMethodBeat.o(125536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.31.1
 * JD-Core Version:    0.7.0.1
 */