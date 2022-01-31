package com.tencent.mm.plugin.exdevice.ui;

import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class ExdeviceConnectWifiUI$5
  implements Runnable
{
  ExdeviceConnectWifiUI$5(ExdeviceConnectWifiUI paramExdeviceConnectWifiUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(19877);
    ExdeviceConnectWifiUI localExdeviceConnectWifiUI = this.lLW;
    AppCompatActivity localAppCompatActivity = this.lLW.getContext();
    this.lLW.getString(2131297087);
    ExdeviceConnectWifiUI.a(localExdeviceConnectWifiUI, h.b(localAppCompatActivity, this.lLW.getString(2131299474), true, new ExdeviceConnectWifiUI.5.1(this)));
    AppMethodBeat.o(19877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.5
 * JD-Core Version:    0.7.0.1
 */