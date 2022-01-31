package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class h
{
  boolean hTl = false;
  h.a koM;
  BroadcastReceiver koN = new h.1(this);
  
  public final boolean a(h.a parama)
  {
    if (this.hTl) {
      return false;
    }
    this.hTl = true;
    this.koM = parama;
    parama = (WifiManager)ae.getContext().getSystemService("wifi");
    if (parama == null)
    {
      y.e("MicroMsg.FreeWifi.WifiScanReceiver", "wifiDetectingTask, get wifi manager failed");
      return false;
    }
    IntentFilter localIntentFilter = new IntentFilter("android.net.wifi.SCAN_RESULTS");
    ae.getContext().registerReceiver(this.koN, localIntentFilter);
    parama.startScan();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.h
 * JD-Core Version:    0.7.0.1
 */