package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MobileInputUI$6
  implements TextView.OnEditorActionListener
{
  MobileInputUI$6(MobileInputUI paramMobileInputUI) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(305185);
    if ((paramInt == 6) || (paramInt == 5))
    {
      boolean bool = this.qcW.bYo();
      AppMethodBeat.o(305185);
      return bool;
    }
    AppMethodBeat.o(305185);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI.6
 * JD-Core Version:    0.7.0.1
 */