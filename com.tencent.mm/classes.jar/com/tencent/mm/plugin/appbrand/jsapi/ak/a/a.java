package com.tencent.mm.plugin.appbrand.jsapi.ak.a;

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
  private static volatile boolean sNB = false;
  private static a sNC = null;
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(325789);
    Log.i("MicroMsg.AppBrand.ConnectWifiEvents", "addListener");
    if (sNC != null)
    {
      sNC.mListeners.add(paramb);
      AppMethodBeat.o(325789);
      return;
    }
    Log.w("MicroMsg.AppBrand.ConnectWifiEvents", "addListener, receiver is null");
    AppMethodBeat.o(325789);
  }
  
  public static void b(b paramb)
  {
    AppMethodBeat.i(325793);
    Log.i("MicroMsg.AppBrand.ConnectWifiEvents", "removeListener");
    if (sNC != null)
    {
      sNC.mListeners.remove(paramb);
      AppMethodBeat.o(325793);
      return;
    }
    Log.w("MicroMsg.AppBrand.ConnectWifiEvents", "addListener, receiver is null");
    AppMethodBeat.o(325793);
  }
  
  public static void eU(Context paramContext)
  {
    AppMethodBeat.i(325778);
    Log.i("MicroMsg.AppBrand.ConnectWifiEvents", "enable");
    if (sNB)
    {
      Log.i("MicroMsg.AppBrand.ConnectWifiEvents", "enable, already enabled");
      AppMethodBeat.o(325778);
      return;
    }
    sNB = true;
    if (sNC == null)
    {
      a locala = new a((byte)0);
      sNC = locala;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
      localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      localIntentFilter.setPriority(2147483647);
      paramContext.registerReceiver(locala, localIntentFilter);
      AppMethodBeat.o(325778);
      return;
    }
    Log.w("MicroMsg.AppBrand.ConnectWifiEvents", "enable, receiver is not null");
    AppMethodBeat.o(325778);
  }
  
  public static void eV(Context paramContext)
  {
    AppMethodBeat.i(325782);
    Log.i("MicroMsg.AppBrand.ConnectWifiEvents", "disable");
    if (!sNB)
    {
      Log.i("MicroMsg.AppBrand.ConnectWifiEvents", "disable, not enable");
      AppMethodBeat.o(325782);
      return;
    }
    sNB = false;
    a locala;
    if (sNC != null) {
      locala = sNC;
    }
    try
    {
      paramContext.unregisterReceiver(locala);
      label50:
      sNC = null;
      AppMethodBeat.o(325782);
      return;
      Log.w("MicroMsg.AppBrand.ConnectWifiEvents", "enable, receiver is null");
      AppMethodBeat.o(325782);
      return;
    }
    catch (IllegalArgumentException paramContext)
    {
      break label50;
    }
  }
  
  static final class a
    extends BroadcastReceiver
  {
    final List<a.b> mListeners;
    
    private a()
    {
      AppMethodBeat.i(325781);
      this.mListeners = new CopyOnWriteArrayList();
      AppMethodBeat.o(325781);
    }
    
    private void c(e parame)
    {
      AppMethodBeat.i(325783);
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext()) {
        ((a.b)localIterator.next()).b(parame);
      }
      AppMethodBeat.o(325783);
    }
    
    private void cyd()
    {
      AppMethodBeat.i(325787);
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext()) {
        ((a.b)localIterator.next()).onDisconnect();
      }
      AppMethodBeat.o(325787);
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(325796);
      if (paramIntent == null)
      {
        AppMethodBeat.o(325796);
        return;
      }
      paramContext = paramIntent.getAction();
      if (TextUtils.isEmpty(paramContext))
      {
        AppMethodBeat.o(325796);
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
          break label300;
        }
        paramContext = paramIntent.getParcelableExtra("networkInfo");
        if (paramContext == null) {
          break label300;
        }
        paramContext = (NetworkInfo)paramContext;
        if (paramContext.getState() == NetworkInfo.State.CONNECTED)
        {
          i = 1;
          if (paramContext.getType() != 1) {
            break label242;
          }
          j = 1;
        }
        break;
      }
      for (;;)
      {
        if ((i != 0) && (j != 0))
        {
          paramContext = b.sND;
          paramContext = b.cyf();
          Log.i("MicroMsg.AppBrand.ConnectWifiEvents", "[mWiFiEventReceiver]currentWifi:%s", new Object[] { paramContext });
          if (paramContext == null)
          {
            Log.e("MicroMsg.AppBrand.ConnectWifiEvents", "[CONNECTIVITY_ACTION]currentWIfi is null, try incomplete");
            paramContext = b.sND;
            paramContext = b.jS(true);
            if (paramContext != null)
            {
              Log.i("MicroMsg.AppBrand.ConnectWifiEvents", "[mWiFiEventReceiver]currentWifi:%s", new Object[] { paramContext });
              c(paramContext);
            }
            AppMethodBeat.o(325796);
            return;
            cyd();
            break;
            i = 0;
            break label137;
            label242:
            j = 0;
            continue;
          }
          paramIntent = this.mListeners.iterator();
          while (paramIntent.hasNext()) {
            ((a.b)paramIntent.next()).a(paramContext);
          }
          c(paramContext);
          AppMethodBeat.o(325796);
          return;
        }
      }
      cyd();
      label300:
      AppMethodBeat.o(325796);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(e parame);
    
    public abstract void b(e parame);
    
    public abstract void onDisconnect();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ak.a.a
 * JD-Core Version:    0.7.0.1
 */