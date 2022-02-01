package com.tencent.mm.plugin.appbrand.jsapi.ah.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class a
{
  private static volatile boolean pIJ = false;
  private static a pIK = null;
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(198442);
    Log.i("MicroMsg.AppBrand.ConnectWifiEvents", "addListener");
    if (pIK != null)
    {
      pIK.mListeners.add(paramb);
      AppMethodBeat.o(198442);
      return;
    }
    Log.w("MicroMsg.AppBrand.ConnectWifiEvents", "addListener, receiver is null");
    AppMethodBeat.o(198442);
  }
  
  public static void b(b paramb)
  {
    AppMethodBeat.i(198445);
    Log.i("MicroMsg.AppBrand.ConnectWifiEvents", "removeListener");
    if (pIK != null)
    {
      pIK.mListeners.remove(paramb);
      AppMethodBeat.o(198445);
      return;
    }
    Log.w("MicroMsg.AppBrand.ConnectWifiEvents", "addListener, receiver is null");
    AppMethodBeat.o(198445);
  }
  
  public static void dZ(Context paramContext)
  {
    AppMethodBeat.i(198438);
    Log.i("MicroMsg.AppBrand.ConnectWifiEvents", "enable");
    if (pIJ)
    {
      Log.i("MicroMsg.AppBrand.ConnectWifiEvents", "enable, already enabled");
      AppMethodBeat.o(198438);
      return;
    }
    pIJ = true;
    if (pIK == null)
    {
      a locala = new a((byte)0);
      pIK = locala;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
      localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      localIntentFilter.setPriority(2147483647);
      paramContext.registerReceiver(locala, localIntentFilter);
      AppMethodBeat.o(198438);
      return;
    }
    Log.w("MicroMsg.AppBrand.ConnectWifiEvents", "enable, receiver is not null");
    AppMethodBeat.o(198438);
  }
  
  public static void ea(Context paramContext)
  {
    AppMethodBeat.i(198440);
    Log.i("MicroMsg.AppBrand.ConnectWifiEvents", "disable");
    if (!pIJ)
    {
      Log.i("MicroMsg.AppBrand.ConnectWifiEvents", "disable, not enable");
      AppMethodBeat.o(198440);
      return;
    }
    pIJ = false;
    if (pIK != null)
    {
      paramContext.unregisterReceiver(pIK);
      pIK = null;
      AppMethodBeat.o(198440);
      return;
    }
    Log.w("MicroMsg.AppBrand.ConnectWifiEvents", "enable, receiver is null");
    AppMethodBeat.o(198440);
  }
  
  static final class a
    extends BroadcastReceiver
  {
    final List<a.b> mListeners;
    
    private a()
    {
      AppMethodBeat.i(199466);
      this.mListeners = new CopyOnWriteArrayList();
      AppMethodBeat.o(199466);
    }
    
    private void bXP()
    {
      AppMethodBeat.i(199470);
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext()) {
        ((a.b)localIterator.next()).aFw();
      }
      AppMethodBeat.o(199470);
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(199481);
      if (paramIntent == null)
      {
        AppMethodBeat.o(199481);
        return;
      }
      paramContext = paramIntent.getAction();
      if (TextUtils.isEmpty(paramContext))
      {
        AppMethodBeat.o(199481);
        return;
      }
      Log.i("MicroMsg.AppBrand.ConnectWifiEvents", "actiong:%s", new Object[] { paramContext });
      int i;
      if ("android.net.wifi.WIFI_STATE_CHANGED".equals(paramContext))
      {
        i = paramIntent.getIntExtra("wifi_state", 0);
        Log.i("MicroMsg.AppBrand.ConnectWifiEvents", "wifiState".concat(String.valueOf(i)));
      }
      label137:
      int j;
      switch (i)
      {
      default: 
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext)) {
          break label258;
        }
        paramContext = paramIntent.getParcelableExtra("networkInfo");
        if (paramContext == null) {
          break label258;
        }
        paramContext = (NetworkInfo)paramContext;
        if (paramContext.getState() == NetworkInfo.State.CONNECTED)
        {
          i = 1;
          if (paramContext.getType() != 1) {
            break label205;
          }
          j = 1;
        }
        break;
      }
      for (;;)
      {
        if ((i != 0) && (j != 0))
        {
          paramContext = f.bXR();
          Log.i("MicroMsg.AppBrand.ConnectWifiEvents", "[mWiFiEventReceiver]currentWifi:%s", new Object[] { paramContext });
          if (paramContext == null)
          {
            Log.e("MicroMsg.AppBrand.ConnectWifiEvents", "[CONNECTIVITY_ACTION]currentWIfi is null");
            AppMethodBeat.o(199481);
            return;
            bXP();
            break;
            i = 0;
            break label137;
            label205:
            j = 0;
            continue;
          }
          paramIntent = this.mListeners.iterator();
          while (paramIntent.hasNext()) {
            ((a.b)paramIntent.next()).a(paramContext);
          }
          AppMethodBeat.o(199481);
          return;
        }
      }
      bXP();
      label258:
      AppMethodBeat.o(199481);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(d paramd);
    
    public abstract void aFw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ah.a.a
 * JD-Core Version:    0.7.0.1
 */