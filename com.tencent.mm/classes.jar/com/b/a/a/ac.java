package com.b.a.a;

import android.net.wifi.WifiManager;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ac
  extends e
{
  private final WifiManager bsO;
  
  ac(WifiManager paramWifiManager, Handler paramHandler)
  {
    super(paramHandler);
    this.bsO = paramWifiManager;
  }
  
  final void th()
  {
    AppMethodBeat.i(55615);
    this.bsO.startScan();
    AppMethodBeat.o(55615);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.b.a.a.ac
 * JD-Core Version:    0.7.0.1
 */