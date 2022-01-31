package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RegSetInfoUI$2
  implements View.OnKeyListener
{
  RegSetInfoUI$2(RegSetInfoUI paramRegSetInfoUI) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(125508);
    if ((66 == paramInt) && (paramKeyEvent.getAction() == 0))
    {
      RegSetInfoUI.p(this.gJQ);
      AppMethodBeat.o(125508);
      return true;
    }
    AppMethodBeat.o(125508);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.2
 * JD-Core Version:    0.7.0.1
 */