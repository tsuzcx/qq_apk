package com.d.a.a;

import android.net.wifi.WifiManager;
import android.os.Handler;

final class ac
  extends e
{
  private final WifiManager bci;
  
  ac(WifiManager paramWifiManager, Handler paramHandler)
  {
    super(paramHandler);
    this.bci = paramWifiManager;
  }
  
  final void pb()
  {
    this.bci.startScan();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.d.a.a.ac
 * JD-Core Version:    0.7.0.1
 */