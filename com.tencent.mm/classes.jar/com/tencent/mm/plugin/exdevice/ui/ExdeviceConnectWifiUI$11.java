package com.tencent.mm.plugin.exdevice.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ExdeviceConnectWifiUI$11
  implements TextWatcher
{
  ExdeviceConnectWifiUI$11(ExdeviceConnectWifiUI paramExdeviceConnectWifiUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(19887);
    if (paramEditable.length() > 31)
    {
      ExdeviceConnectWifiUI.i(this.lLW).setVisibility(0);
      ExdeviceConnectWifiUI.j(this.lLW).setEnabled(false);
      AppMethodBeat.o(19887);
      return;
    }
    ExdeviceConnectWifiUI.i(this.lLW).setVisibility(8);
    ExdeviceConnectWifiUI.j(this.lLW).setEnabled(true);
    AppMethodBeat.o(19887);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.11
 * JD-Core Version:    0.7.0.1
 */