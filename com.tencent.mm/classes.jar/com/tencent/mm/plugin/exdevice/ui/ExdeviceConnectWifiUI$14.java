package com.tencent.mm.plugin.exdevice.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.sdk.platformtools.y;

final class ExdeviceConnectWifiUI$14
  implements TextView.OnEditorActionListener
{
  ExdeviceConnectWifiUI$14(ExdeviceConnectWifiUI paramExdeviceConnectWifiUI) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 6) || (paramInt == 5))
    {
      y.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "on next Key down.");
      ExdeviceConnectWifiUI.a(this.jCy, ExdeviceConnectWifiUI.k(this.jCy));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.14
 * JD-Core Version:    0.7.0.1
 */