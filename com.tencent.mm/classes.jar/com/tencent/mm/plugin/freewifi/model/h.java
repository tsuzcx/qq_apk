package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class h
{
  boolean nUW;
  a txQ;
  BroadcastReceiver txR;
  
  private h()
  {
    AppMethodBeat.i(24809);
    this.nUW = false;
    this.txR = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        int i = 0;
        AppMethodBeat.i(24807);
        if ((paramAnonymousContext == null) || (paramAnonymousIntent == null))
        {
          ae.e("MicroMsg.FreeWifi.WifiScanReceiver", "context is null or intent null");
          AppMethodBeat.o(24807);
          return;
        }
        h.this.nUW = false;
        paramAnonymousContext.unregisterReceiver(h.this.txR);
        if ("android.net.wifi.SCAN_RESULTS".equals(paramAnonymousIntent.getAction()))
        {
          paramAnonymousContext = (WifiManager)ak.getContext().getSystemService("wifi");
          if (paramAnonymousContext == null)
          {
            ae.e("MicroMsg.FreeWifi.WifiScanReceiver", "bran, WifiScanReceiver onReceive, get wifi manager failed");
            AppMethodBeat.o(24807);
            return;
          }
        }
        try
        {
          paramAnonymousContext = paramAnonymousContext.getScanResults();
          localh = h.this;
          paramAnonymousIntent = paramAnonymousContext;
          if (paramAnonymousContext != null)
          {
            if (paramAnonymousContext.size() <= 20) {
              paramAnonymousIntent = paramAnonymousContext;
            }
          }
          else
          {
            paramAnonymousContext = new StringBuilder("wifiManager scanResults size = ");
            if (paramAnonymousIntent != null) {
              break label241;
            }
            ae.i("MicroMsg.FreeWifi.WifiScanReceiver", i);
            if (h.this.txQ != null) {
              h.this.txQ.dU(paramAnonymousIntent);
            }
            AppMethodBeat.o(24807);
            return;
          }
        }
        catch (SecurityException paramAnonymousIntent)
        {
          for (;;)
          {
            h localh;
            paramAnonymousContext = new ArrayList(0);
            ae.e("MicroMsg.FreeWifi.WifiScanReceiver", "wifiManager.getScanResults() throws security exception. " + paramAnonymousIntent.getMessage());
            continue;
            Collections.sort(paramAnonymousContext, new h.2(localh));
            paramAnonymousIntent = paramAnonymousContext.subList(0, 20);
            continue;
            label241:
            i = paramAnonymousIntent.size();
          }
        }
      }
    };
    AppMethodBeat.o(24809);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(24810);
    if (this.nUW)
    {
      AppMethodBeat.o(24810);
      return false;
    }
    this.nUW = true;
    this.txQ = parama;
    parama = (WifiManager)ak.getContext().getSystemService("wifi");
    if (parama == null)
    {
      ae.e("MicroMsg.FreeWifi.WifiScanReceiver", "wifiDetectingTask, get wifi manager failed");
      AppMethodBeat.o(24810);
      return false;
    }
    IntentFilter localIntentFilter = new IntentFilter("android.net.wifi.SCAN_RESULTS");
    ak.getContext().registerReceiver(this.txR, localIntentFilter);
    parama.startScan();
    AppMethodBeat.o(24810);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void dU(List<ScanResult> paramList);
  }
  
  public static final class b
  {
    private static h txT;
    
    static
    {
      AppMethodBeat.i(24808);
      txT = new h((byte)0);
      AppMethodBeat.o(24808);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.h
 * JD-Core Version:    0.7.0.1
 */