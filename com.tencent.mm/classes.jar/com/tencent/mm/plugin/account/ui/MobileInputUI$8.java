package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

final class MobileInputUI$8
  implements TextView.OnEditorActionListener
{
  MobileInputUI$8(MobileInputUI paramMobileInputUI) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 6) || (paramInt == 5)) {
      return MobileInputUI.f(this.foH);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI.8
 * JD-Core Version:    0.7.0.1
 */