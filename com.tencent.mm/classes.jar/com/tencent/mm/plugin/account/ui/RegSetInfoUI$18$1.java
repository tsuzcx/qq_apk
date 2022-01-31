package com.tencent.mm.plugin.account.ui;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RegSetInfoUI$18$1
  implements Runnable
{
  RegSetInfoUI$18$1(RegSetInfoUI.18 param18) {}
  
  public final void run()
  {
    AppMethodBeat.i(125525);
    RegSetInfoUI.a(this.gJW.gJQ).clearFocus();
    RegSetInfoUI.a(this.gJW.gJQ).requestFocus();
    AppMethodBeat.o(125525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.18.1
 * JD-Core Version:    0.7.0.1
 */