package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MobileInputUI$8
  implements View.OnKeyListener
{
  MobileInputUI$8(MobileInputUI paramMobileInputUI) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(125168);
    if ((66 == paramInt) && (paramKeyEvent.getAction() == 0))
    {
      boolean bool = this.gGb.arB();
      AppMethodBeat.o(125168);
      return bool;
    }
    AppMethodBeat.o(125168);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI.8
 * JD-Core Version:    0.7.0.1
 */