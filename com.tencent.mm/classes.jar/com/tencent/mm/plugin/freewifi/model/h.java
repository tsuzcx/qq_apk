package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class h
{
  boolean nPq;
  a tmY;
  BroadcastReceiver tmZ;
  
  private h()
  {
    AppMethodBeat.i(24809);
    this.nPq = false;
    this.tmZ = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        int i = 0;
        AppMethodBeat.i(24807);
        if ((paramAnonymousContext == null) || (paramAnonymousIntent == null))
        {
          ad.e("MicroMsg.FreeWifi.WifiScanReceiver", "context is null or intent null");
          AppMethodBeat.o(24807);
          return;
        }
        h.this.nPq = false;
        paramAnonymousContext.unregisterReceiver(h.this.tmZ);
        if ("android.net.wifi.SCAN_RESULTS".equals(paramAnonymousIntent.getAction()))
        {
          paramAnonymousContext = (WifiManager)aj.getContext().getSystemService("wifi");
          if (paramAnonymousContext == null)
          {
            ad.e("MicroMsg.FreeWifi.WifiScanReceiver", "bran, WifiScanReceiver onReceive, get wifi manager failed");
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
            ad.i("MicroMsg.FreeWifi.WifiScanReceiver", i);
            if (h.this.tmY != null) {
              h.this.tmY.dQ(paramAnonymousIntent);
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
            ad.e("MicroMsg.FreeWifi.WifiScanReceiver", "wifiManager.getScanResults() throws security exception. " + paramAnonymousIntent.getMessage());
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
    if (this.nPq)
    {
      AppMethodBeat.o(24810);
      return false;
    }
    this.nPq = true;
    this.tmY = parama;
    parama = (WifiManager)aj.getContext().getSystemService("wifi");
    if (parama == null)
    {
      ad.e("MicroMsg.FreeWifi.WifiScanReceiver", "wifiDetectingTask, get wifi manager failed");
      AppMethodBeat.o(24810);
      return false;
    }
    IntentFilter localIntentFilter = new IntentFilter("android.net.wifi.SCAN_RESULTS");
    aj.getContext().registerReceiver(this.tmZ, localIntentFilter);
    parama.startScan();
    AppMethodBeat.o(24810);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void dQ(List<ScanResult> paramList);
  }
  
  public static final class b
  {
    private static h tnb;
    
    static
    {
      AppMethodBeat.i(24808);
      tnb = new h((byte)0);
      AppMethodBeat.o(24808);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.h
 * JD-Core Version:    0.7.0.1
 */