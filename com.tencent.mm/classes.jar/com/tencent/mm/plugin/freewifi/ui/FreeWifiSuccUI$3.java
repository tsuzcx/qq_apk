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
    AppMethodBeat.i(25147);
    if (paramBoolean)
    {
      FreeWifiSuccUI.a(this.tqZ, true);
      AppMethodBeat.o(25147);
      return;
    }
    FreeWifiSuccUI.a(this.tqZ, false);
    AppMethodBeat.o(25147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiSuccUI.3
 * JD-Core Version:    0.7.0.1
 */