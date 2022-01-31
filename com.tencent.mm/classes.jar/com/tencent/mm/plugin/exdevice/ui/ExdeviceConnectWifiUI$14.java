package com.tencent.mm.plugin.exdevice.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ExdeviceConnectWifiUI$14
  implements TextView.OnEditorActionListener
{
  ExdeviceConnectWifiUI$14(ExdeviceConnectWifiUI paramExdeviceConnectWifiUI) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(19890);
    if ((paramInt == 6) || (paramInt == 5))
    {
      ab.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "on next Key down.");
      ExdeviceConnectWifiUI.k(this.lLW);
      AppMethodBeat.o(19890);
      return true;
    }
    AppMethodBeat.o(19890);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.14
 * JD-Core Version:    0.7.0.1
 */