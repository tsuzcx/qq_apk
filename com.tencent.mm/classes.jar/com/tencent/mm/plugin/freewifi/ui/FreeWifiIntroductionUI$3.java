package com.tencent.mm.plugin.freewifi.ui;

import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FreeWifiIntroductionUI$3
  implements CompoundButton.OnCheckedChangeListener
{
  FreeWifiIntroductionUI$3(FreeWifiIntroductionUI paramFreeWifiIntroductionUI) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(21000);
    if (paramBoolean)
    {
      FreeWifiIntroductionUI.a(this.mNV).setEnabled(true);
      AppMethodBeat.o(21000);
      return;
    }
    FreeWifiIntroductionUI.a(this.mNV).setEnabled(false);
    AppMethodBeat.o(21000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiIntroductionUI.3
 * JD-Core Version:    0.7.0.1
 */