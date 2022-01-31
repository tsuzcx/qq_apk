package com.tencent.mm.plugin.account.ui;

import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RegSetInfoUI$12
  implements Runnable
{
  RegSetInfoUI$12(RegSetInfoUI paramRegSetInfoUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(125518);
    RegSetInfoUI.i(this.gJQ).requestFocus();
    RegSetInfoUI.b(this.gJQ).clearFocus();
    AppMethodBeat.o(125518);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.12
 * JD-Core Version:    0.7.0.1
 */