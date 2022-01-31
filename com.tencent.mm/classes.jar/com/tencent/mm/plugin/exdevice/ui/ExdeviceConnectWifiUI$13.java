package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ExdeviceConnectWifiUI$13
  implements View.OnClickListener
{
  ExdeviceConnectWifiUI$13(ExdeviceConnectWifiUI paramExdeviceConnectWifiUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(19889);
    ab.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "onClick connectBtn.");
    ExdeviceConnectWifiUI.k(this.lLW);
    AppMethodBeat.o(19889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.13
 * JD-Core Version:    0.7.0.1
 */