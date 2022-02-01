package com.tencent.mm.plugin.exdevice.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class ExdeviceConnectWifiUI$18
  implements TextView.OnEditorActionListener
{
  ExdeviceConnectWifiUI$18(ExdeviceConnectWifiUI paramExdeviceConnectWifiUI) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(179600);
    if ((paramInt == 6) || (paramInt == 5))
    {
      ae.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "on next Key down.");
      ExdeviceConnectWifiUI.k(this.qqc);
      AppMethodBeat.o(179600);
      return true;
    }
    AppMethodBeat.o(179600);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.18
 * JD-Core Version:    0.7.0.1
 */