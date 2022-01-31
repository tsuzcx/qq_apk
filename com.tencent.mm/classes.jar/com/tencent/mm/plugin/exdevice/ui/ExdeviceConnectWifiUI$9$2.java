package com.tencent.mm.plugin.exdevice.ui;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

final class ExdeviceConnectWifiUI$9$2
  implements Runnable
{
  ExdeviceConnectWifiUI$9$2(ExdeviceConnectWifiUI.9 param9) {}
  
  public final void run()
  {
    AppMethodBeat.i(19884);
    if (ExdeviceConnectWifiUI.g(this.lMd.lLW) != null) {
      ExdeviceConnectWifiUI.g(this.lMd.lLW).dismiss();
    }
    h.a(this.lMd.lLW.getContext(), this.lMd.lLW.getContext().getString(2131299335), "", this.lMd.lLW.getContext().getString(2131299383), "", false, new ExdeviceConnectWifiUI.9.2.1(this), null).show();
    AppMethodBeat.o(19884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.9.2
 * JD-Core Version:    0.7.0.1
 */