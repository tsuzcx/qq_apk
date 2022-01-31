package com.tencent.mm.plugin.exdevice.ui;

import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class ExdeviceConnectWifiUI$5
  implements Runnable
{
  ExdeviceConnectWifiUI$5(ExdeviceConnectWifiUI paramExdeviceConnectWifiUI) {}
  
  public final void run()
  {
    ExdeviceConnectWifiUI localExdeviceConnectWifiUI = this.jCy;
    AppCompatActivity localAppCompatActivity = this.jCy.mController.uMN;
    this.jCy.getString(R.l.app_tip);
    ExdeviceConnectWifiUI.a(localExdeviceConnectWifiUI, h.b(localAppCompatActivity, this.jCy.getString(R.l.exdevice_setting_status), true, new ExdeviceConnectWifiUI.5.1(this)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.5
 * JD-Core Version:    0.7.0.1
 */