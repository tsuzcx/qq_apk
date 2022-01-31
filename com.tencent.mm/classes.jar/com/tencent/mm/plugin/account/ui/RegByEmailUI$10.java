package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RegByEmailUI$10
  implements TextView.OnEditorActionListener
{
  RegByEmailUI$10(RegByEmailUI paramRegByEmailUI) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(125310);
    if ((paramInt == 6) || (paramInt == 5))
    {
      if (!RegByEmailUI.d(this.gHH).isChecked())
      {
        AppMethodBeat.o(125310);
        return false;
      }
      RegByEmailUI.c(this.gHH);
      AppMethodBeat.o(125310);
      return true;
    }
    AppMethodBeat.o(125310);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByEmailUI.10
 * JD-Core Version:    0.7.0.1
 */