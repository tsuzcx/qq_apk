package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SimpleLoginUI$16
  implements TextView.OnEditorActionListener
{
  SimpleLoginUI$16(SimpleLoginUI paramSimpleLoginUI) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(125612);
    if ((paramInt == 6) || (paramInt == 5))
    {
      SimpleLoginUI.b(this.gKt);
      AppMethodBeat.o(125612);
      return true;
    }
    AppMethodBeat.o(125612);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.SimpleLoginUI.16
 * JD-Core Version:    0.7.0.1
 */