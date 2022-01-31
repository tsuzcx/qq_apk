package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

final class RegByEmailUI$10
  implements TextView.OnEditorActionListener
{
  RegByEmailUI$10(RegByEmailUI paramRegByEmailUI) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (((paramInt != 6) && (paramInt != 5)) || (!RegByEmailUI.d(this.fqk).isChecked())) {
      return false;
    }
    RegByEmailUI.c(this.fqk);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByEmailUI.10
 * JD-Core Version:    0.7.0.1
 */