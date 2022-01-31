package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SimpleLoginUI$17
  implements View.OnKeyListener
{
  SimpleLoginUI$17(SimpleLoginUI paramSimpleLoginUI) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(125613);
    if ((66 == paramInt) && (paramKeyEvent.getAction() == 0))
    {
      SimpleLoginUI.b(this.gKt);
      AppMethodBeat.o(125613);
      return true;
    }
    AppMethodBeat.o(125613);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.SimpleLoginUI.17
 * JD-Core Version:    0.7.0.1
 */