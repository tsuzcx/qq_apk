package com.tencent.mm.plugin.account.ui;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RegSetInfoUI$14
  implements Runnable
{
  RegSetInfoUI$14(RegSetInfoUI paramRegSetInfoUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(125520);
    RegSetInfoUI.a(this.gJQ).clearFocus();
    RegSetInfoUI.a(this.gJQ).requestFocus();
    AppMethodBeat.o(125520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.14
 * JD-Core Version:    0.7.0.1
 */