package com.tencent.mm.plugin.exdevice.ui;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s;

final class ExdeviceConnectWifiUI$9$2
  implements Runnable
{
  ExdeviceConnectWifiUI$9$2(ExdeviceConnectWifiUI.9 param9) {}
  
  public final void run()
  {
    ExdeviceConnectWifiUI.g(this.jCG.jCy).dismiss();
    h.a(this.jCG.jCy.mController.uMN, this.jCG.jCy.mController.uMN.getString(R.l.exdeivce_config_airkiss_timeout), "", this.jCG.jCy.mController.uMN.getString(R.l.exdevice_connect_failed_confirm), "", false, new ExdeviceConnectWifiUI.9.2.1(this), null).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.9.2
 * JD-Core Version:    0.7.0.1
 */