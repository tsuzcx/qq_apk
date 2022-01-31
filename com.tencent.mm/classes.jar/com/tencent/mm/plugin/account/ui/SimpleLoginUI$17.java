package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

final class SimpleLoginUI$17
  implements View.OnKeyListener
{
  SimpleLoginUI$17(SimpleLoginUI paramSimpleLoginUI) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((66 == paramInt) && (paramKeyEvent.getAction() == 0))
    {
      SimpleLoginUI.b(this.fsR);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.SimpleLoginUI.17
 * JD-Core Version:    0.7.0.1
 */