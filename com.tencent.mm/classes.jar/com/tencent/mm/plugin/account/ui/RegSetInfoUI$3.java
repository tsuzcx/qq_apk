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
    AppMethodBeat.i(125509);
    if ((paramInt == 6) || (paramInt == 5))
    {
      RegSetInfoUI.p(this.gJQ);
      AppMethodBeat.o(125509);
      return true;
    }
    AppMethodBeat.o(125509);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.3
 * JD-Core Version:    0.7.0.1
 */