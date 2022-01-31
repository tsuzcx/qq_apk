package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

final class MobileInputUI$9
  implements View.OnKeyListener
{
  MobileInputUI$9(MobileInputUI paramMobileInputUI) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((66 == paramInt) && (paramKeyEvent.getAction() == 0)) {
      return MobileInputUI.f(this.foH);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI.9
 * JD-Core Version:    0.7.0.1
 */