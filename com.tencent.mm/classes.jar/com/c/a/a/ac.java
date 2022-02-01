package com.c.a.a;

import android.net.wifi.WifiManager;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ac
  extends e
{
  private final WifiManager bVj;
  
  ac(WifiManager paramWifiManager, Handler paramHandler)
  {
    super(paramHandler);
    this.bVj = paramWifiManager;
  }
  
  final void yV()
  {
    AppMethodBeat.i(87960);
    this.bVj.startScan();
    AppMethodBeat.o(87960);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.c.a.a.ac
 * JD-Core Version:    0.7.0.1
 */