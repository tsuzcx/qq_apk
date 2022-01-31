package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.y;

final class ExdeviceConnectWifiUI$5$1
  implements DialogInterface.OnCancelListener
{
  ExdeviceConnectWifiUI$5$1(ExdeviceConnectWifiUI.5 param5) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    y.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "On progress cancel, stop airkiss");
    if (ExdeviceConnectWifiUI.d(this.jCD.jCy) != ExdeviceConnectWifiUI.b.jCL) {
      ExdeviceConnectWifiUI.r(this.jCD.jCy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.5.1
 * JD-Core Version:    0.7.0.1
 */