package com.c.a.a;

import android.net.wifi.WifiManager;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ac
  extends e
{
  private final WifiManager bSR;
  
  ac(WifiManager paramWifiManager, Handler paramHandler)
  {
    super(paramHandler);
    this.bSR = paramWifiManager;
  }
  
  final void yI()
  {
    AppMethodBeat.i(87960);
    this.bSR.startScan();
    AppMethodBeat.o(87960);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.c.a.a.ac
 * JD-Core Version:    0.7.0.1
 */