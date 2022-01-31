package com.tencent.mm.plugin.freewifi.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FreeWifiSuccUI$3
  implements CompoundButton.OnCheckedChangeListener
{
  FreeWifiSuccUI$3(FreeWifiSuccUI paramFreeWifiSuccUI) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(21087);
    if (paramBoolean)
    {
      FreeWifiSuccUI.a(this.mOM, true);
      AppMethodBeat.o(21087);
      return;
    }
    FreeWifiSuccUI.a(this.mOM, false);
    AppMethodBeat.o(21087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiSuccUI.3
 * JD-Core Version:    0.7.0.1
 */