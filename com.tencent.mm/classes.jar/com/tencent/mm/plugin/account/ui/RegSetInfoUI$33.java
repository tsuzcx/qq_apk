package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RegSetInfoUI$33
  implements TextView.OnEditorActionListener
{
  RegSetInfoUI$33(RegSetInfoUI paramRegSetInfoUI) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128700);
    if ((paramInt == 6) || (paramInt == 5))
    {
      RegSetInfoUI.p(this.jqJ);
      AppMethodBeat.o(128700);
      return true;
    }
    AppMethodBeat.o(128700);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.33
 * JD-Core Version:    0.7.0.1
 */