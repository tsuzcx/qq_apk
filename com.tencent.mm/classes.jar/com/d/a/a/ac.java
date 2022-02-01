package com.d.a.a;

import android.net.wifi.WifiManager;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ac
  extends e
{
  private final WifiManager cde;
  
  ac(WifiManager paramWifiManager, Handler paramHandler)
  {
    super(paramHandler);
    this.cde = paramWifiManager;
  }
  
  final void Ag()
  {
    AppMethodBeat.i(87960);
    this.cde.startScan();
    AppMethodBeat.o(87960);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.a.ac
 * JD-Core Version:    0.7.0.1
 */