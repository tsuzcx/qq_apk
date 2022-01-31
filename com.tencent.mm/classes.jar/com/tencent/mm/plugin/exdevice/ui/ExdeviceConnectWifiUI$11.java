package com.tencent.mm.plugin.exdevice.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

final class ExdeviceConnectWifiUI$11
  implements TextWatcher
{
  ExdeviceConnectWifiUI$11(ExdeviceConnectWifiUI paramExdeviceConnectWifiUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.length() > 31)
    {
      ExdeviceConnectWifiUI.i(this.jCy).setVisibility(0);
      ExdeviceConnectWifiUI.j(this.jCy).setEnabled(false);
      return;
    }
    ExdeviceConnectWifiUI.i(this.jCy).setVisibility(8);
    ExdeviceConnectWifiUI.j(this.jCy).setEnabled(true);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.11
 * JD-Core Version:    0.7.0.1
 */