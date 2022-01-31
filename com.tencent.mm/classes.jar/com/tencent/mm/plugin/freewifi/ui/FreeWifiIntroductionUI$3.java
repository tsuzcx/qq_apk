package com.tencent.mm.plugin.freewifi.ui;

import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final class FreeWifiIntroductionUI$3
  implements CompoundButton.OnCheckedChangeListener
{
  FreeWifiIntroductionUI$3(FreeWifiIntroductionUI paramFreeWifiIntroductionUI) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      FreeWifiIntroductionUI.a(this.ksh).setEnabled(true);
      return;
    }
    FreeWifiIntroductionUI.a(this.ksh).setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiIntroductionUI.3
 * JD-Core Version:    0.7.0.1
 */