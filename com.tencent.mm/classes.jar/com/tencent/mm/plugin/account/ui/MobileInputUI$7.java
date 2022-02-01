package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MobileInputUI$7
  implements TextView.OnEditorActionListener
{
  MobileInputUI$7(MobileInputUI paramMobileInputUI) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128340);
    if ((paramInt == 6) || (paramInt == 5))
    {
      boolean bool = this.nfN.bzC();
      AppMethodBeat.o(128340);
      return bool;
    }
    AppMethodBeat.o(128340);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI.7
 * JD-Core Version:    0.7.0.1
 */