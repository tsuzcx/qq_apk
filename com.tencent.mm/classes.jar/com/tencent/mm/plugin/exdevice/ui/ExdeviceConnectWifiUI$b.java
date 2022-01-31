package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ExdeviceConnectWifiUI$b
{
  static
  {
    AppMethodBeat.i(19895);
    lMf = new b("NORMAL", 0);
    lMg = new b("NO_WIFI_CONNECTED", 1);
    lMh = new b("SETTING", 2);
    lMi = new b("FINISH", 3);
    lMj = new b("TIMEOUT", 4);
    lMk = new b[] { lMf, lMg, lMh, lMi, lMj };
    AppMethodBeat.o(19895);
  }
  
  private ExdeviceConnectWifiUI$b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.b
 * JD-Core Version:    0.7.0.1
 */