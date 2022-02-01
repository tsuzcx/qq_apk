package com.b.a.a;

import android.net.wifi.WifiManager;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ac
  extends e
{
  private final WifiManager cnK;
  
  ac(WifiManager paramWifiManager, Handler paramHandler)
  {
    super(paramHandler);
    this.cnK = paramWifiManager;
  }
  
  final void IZ()
  {
    AppMethodBeat.i(87960);
    this.cnK.startScan();
    AppMethodBeat.o(87960);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.b.a.a.ac
 * JD-Core Version:    0.7.0.1
 */