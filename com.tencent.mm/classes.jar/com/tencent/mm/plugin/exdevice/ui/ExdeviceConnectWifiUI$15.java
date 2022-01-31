package com.tencent.mm.plugin.exdevice.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ExdeviceConnectWifiUI$15
  implements View.OnKeyListener
{
  ExdeviceConnectWifiUI$15(ExdeviceConnectWifiUI paramExdeviceConnectWifiUI) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(19891);
    if ((66 == paramInt) && (paramKeyEvent.getAction() == 0))
    {
      ExdeviceConnectWifiUI.k(this.lLW);
      AppMethodBeat.o(19891);
      return true;
    }
    AppMethodBeat.o(19891);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.15
 * JD-Core Version:    0.7.0.1
 */