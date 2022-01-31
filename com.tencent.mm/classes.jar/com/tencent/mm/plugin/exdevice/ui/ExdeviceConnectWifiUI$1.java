package com.tencent.mm.plugin.exdevice.ui;

import android.text.Editable;
import android.text.Selection;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class ExdeviceConnectWifiUI$1
  implements Runnable
{
  ExdeviceConnectWifiUI$1(ExdeviceConnectWifiUI paramExdeviceConnectWifiUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(19871);
    if (!bo.isNullOrNil(ExdeviceConnectWifiUI.a(this.lLW)))
    {
      ab.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "User has input password.");
      AppMethodBeat.o(19871);
      return;
    }
    ExdeviceConnectWifiUI.c(this.lLW).setText(ExdeviceConnectWifiUI.b(this.lLW).lGy);
    Editable localEditable = ExdeviceConnectWifiUI.c(this.lLW).getText();
    if (localEditable != null) {
      Selection.setSelection(localEditable, localEditable.length());
    }
    AppMethodBeat.o(19871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.1
 * JD-Core Version:    0.7.0.1
 */