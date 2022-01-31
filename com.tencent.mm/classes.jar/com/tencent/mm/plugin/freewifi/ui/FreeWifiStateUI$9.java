package com.tencent.mm.plugin.freewifi.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.freewifi.model.d;

final class FreeWifiStateUI$9
  implements DialogInterface.OnCancelListener
{
  FreeWifiStateUI$9(FreeWifiStateUI paramFreeWifiStateUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    d.a(this.ksM.ssid, 4, this.ksM.getIntent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI.9
 * JD-Core Version:    0.7.0.1
 */