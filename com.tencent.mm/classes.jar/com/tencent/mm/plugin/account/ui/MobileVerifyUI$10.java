package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MobileVerifyUI$10
  implements TextView.OnEditorActionListener
{
  MobileVerifyUI$10(MobileVerifyUI paramMobileVerifyUI) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128449);
    if ((paramInt == 6) || (paramInt == 5))
    {
      MobileVerifyUI.e(this.jod);
      AppMethodBeat.o(128449);
      return true;
    }
    AppMethodBeat.o(128449);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileVerifyUI.10
 * JD-Core Version:    0.7.0.1
 */