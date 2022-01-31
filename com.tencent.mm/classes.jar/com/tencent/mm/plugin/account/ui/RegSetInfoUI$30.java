package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.sdk.platformtools.am;

final class RegSetInfoUI$30
  implements View.OnFocusChangeListener
{
  RegSetInfoUI$30(RegSetInfoUI paramRegSetInfoUI) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      RegSetInfoUI.q(this.fso);
      RegSetInfoUI.m(this.fso).S(200L, 200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.30
 * JD-Core Version:    0.7.0.1
 */