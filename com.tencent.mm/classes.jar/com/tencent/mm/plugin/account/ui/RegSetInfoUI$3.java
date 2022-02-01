package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RegSetInfoUI$3
  implements TextView.OnEditorActionListener
{
  RegSetInfoUI$3(RegSetInfoUI paramRegSetInfoUI) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128670);
    if ((paramInt == 6) || (paramInt == 5))
    {
      RegSetInfoUI.p(this.njA);
      AppMethodBeat.o(128670);
      return true;
    }
    AppMethodBeat.o(128670);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.3
 * JD-Core Version:    0.7.0.1
 */