package com.tencent.mm.plugin.exdevice.ui;

import android.text.Editable;
import android.text.Selection;
import android.widget.EditText;
import com.tencent.mm.plugin.exdevice.d.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class ExdeviceConnectWifiUI$1
  implements Runnable
{
  ExdeviceConnectWifiUI$1(ExdeviceConnectWifiUI paramExdeviceConnectWifiUI) {}
  
  public final void run()
  {
    if (!bk.bl(ExdeviceConnectWifiUI.a(this.jCy))) {
      y.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "User has input password.");
    }
    Editable localEditable;
    do
    {
      return;
      ExdeviceConnectWifiUI.c(this.jCy).setText(ExdeviceConnectWifiUI.b(this.jCy).jwZ);
      localEditable = ExdeviceConnectWifiUI.c(this.jCy).getText();
    } while (localEditable == null);
    Selection.setSelection(localEditable, localEditable.length());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.1
 * JD-Core Version:    0.7.0.1
 */