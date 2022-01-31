package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Comparator;

public final class h
{
  boolean jNf;
  BroadcastReceiver mKA;
  h.a mKz;
  
  private h()
  {
    AppMethodBeat.i(20732);
    this.jNf = false;
    this.mKA = new h.1(this);
    AppMethodBeat.o(20732);
  }
  
  public final boolean a(h.a parama)
  {
    AppMethodBeat.i(20733);
    if (this.jNf)
    {
      AppMethodBeat.o(20733);
      return false;
    }
    this.jNf = true;
    this.mKz = parama;
    parama = (WifiManager)ah.getContext().getSystemService("wifi");
    if (parama == null)
    {
      ab.e("MicroMsg.FreeWifi.WifiScanReceiver", "wifiDetectingTask, get wifi manager failed");
      AppMethodBeat.o(20733);
      return false;
    }
    IntentFilter localIntentFilter = new IntentFilter("android.net.wifi.SCAN_RESULTS");
    ah.getContext().registerReceiver(this.mKA, localIntentFilter);
    parama.startScan();
    AppMethodBeat.o(20733);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.h
 * JD-Core Version:    0.7.0.1
 */