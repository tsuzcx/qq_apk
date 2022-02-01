package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public class FreeWifiNetworkReceiver
  extends BroadcastReceiver
{
  public b squ;
  public a sqv;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(24806);
    if (paramIntent == null)
    {
      ac.e("MicroMsg.FreeWifi.WifiStateChangedReceiver", "intent is null");
      AppMethodBeat.o(24806);
      return;
    }
    paramContext = paramIntent.getAction();
    ac.i("MicroMsg.FreeWifi.WifiStateChangedReceiver", "FreeWifiNetworkReceiver action : %s", new Object[] { paramContext });
    if (bs.isNullOrNil(paramContext))
    {
      ac.e("MicroMsg.FreeWifi.WifiStateChangedReceiver", "action is null");
      AppMethodBeat.o(24806);
      return;
    }
    if (paramContext.equals("android.net.wifi.WIFI_STATE_CHANGED"))
    {
      int i = paramIntent.getIntExtra("wifi_state", 0);
      ac.i("MicroMsg.FreeWifi.WifiStateChangedReceiver", "now wifi state : %d", new Object[] { Integer.valueOf(i) });
      if (this.squ != null) {
        this.squ.Fu(i);
      }
      AppMethodBeat.o(24806);
      return;
    }
    if (paramContext.equals("android.net.wifi.STATE_CHANGE"))
    {
      paramContext = paramIntent.getParcelableExtra("networkInfo");
      if (paramContext != null)
      {
        paramContext = (NetworkInfo)paramContext;
        if ((paramContext != null) && (this.sqv != null)) {
          this.sqv.a(paramContext.getState());
        }
      }
    }
    AppMethodBeat.o(24806);
  }
  
  public static abstract interface a
  {
    public abstract void a(NetworkInfo.State paramState);
  }
  
  public static abstract interface b
  {
    public abstract void Fu(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver
 * JD-Core Version:    0.7.0.1
 */