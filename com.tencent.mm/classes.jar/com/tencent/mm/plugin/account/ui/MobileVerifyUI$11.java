package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MobileVerifyUI$11
  implements View.OnKeyListener
{
  MobileVerifyUI$11(MobileVerifyUI paramMobileVerifyUI) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(125278);
    if ((66 == paramInt) && (paramKeyEvent.getAction() == 0))
    {
      MobileVerifyUI.e(this.gHp);
      AppMethodBeat.o(125278);
      return true;
    }
    AppMethodBeat.o(125278);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileVerifyUI.11
 * JD-Core Version:    0.7.0.1
 */