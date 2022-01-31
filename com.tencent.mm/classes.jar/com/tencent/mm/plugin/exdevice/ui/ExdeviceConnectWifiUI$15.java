package com.tencent.mm.plugin.exdevice.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

final class ExdeviceConnectWifiUI$15
  implements View.OnKeyListener
{
  ExdeviceConnectWifiUI$15(ExdeviceConnectWifiUI paramExdeviceConnectWifiUI) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((66 == paramInt) && (paramKeyEvent.getAction() == 0))
    {
      ExdeviceConnectWifiUI.a(this.jCy, ExdeviceConnectWifiUI.k(this.jCy));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.15
 * JD-Core Version:    0.7.0.1
 */