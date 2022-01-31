package com.tencent.mm.plugin.exdevice.ui;

import android.net.wifi.WifiManager.MulticastLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class ExdeviceConnectWifiUI$9
  implements j.a
{
  ExdeviceConnectWifiUI$9(ExdeviceConnectWifiUI paramExdeviceConnectWifiUI) {}
  
  public final void g(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(19885);
    if ((paramInt != 0) || (paramVarArgs == null) || (paramVarArgs.length < 2) || (!(paramVarArgs[0] instanceof Integer)) || (!(paramVarArgs[1] instanceof Integer)))
    {
      AppMethodBeat.o(19885);
      return;
    }
    paramInt = ((Integer)paramVarArgs[0]).intValue();
    int i = ((Integer)paramVarArgs[1]).intValue();
    if (ExdeviceConnectWifiUI.f(this.lLW).isHeld()) {
      ExdeviceConnectWifiUI.f(this.lLW).release();
    }
    ab.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "AirKiss jni callback (%d, %d)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if ((paramInt == 0) && (i == 0))
    {
      al.d(new ExdeviceConnectWifiUI.9.1(this));
      AppMethodBeat.o(19885);
      return;
    }
    this.lLW.runOnUiThread(new ExdeviceConnectWifiUI.9.2(this));
    AppMethodBeat.o(19885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.9
 * JD-Core Version:    0.7.0.1
 */