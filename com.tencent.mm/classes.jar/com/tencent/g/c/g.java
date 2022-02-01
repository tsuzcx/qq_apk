package com.tencent.g.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Proxy;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class g
{
  public static byte oH(Context paramContext)
  {
    AppMethodBeat.i(212029);
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo != null)
      {
        if (localNetworkInfo.getState() != NetworkInfo.State.CONNECTING)
        {
          NetworkInfo.State localState1 = localNetworkInfo.getState();
          NetworkInfo.State localState2 = NetworkInfo.State.CONNECTED;
          if (localState1 == localState2) {}
        }
      }
      else
      {
        AppMethodBeat.o(212029);
        return -1;
      }
      int i = localNetworkInfo.getType();
      if (i == 1)
      {
        AppMethodBeat.o(212029);
        return 0;
      }
      if (localNetworkInfo.getType() == 0)
      {
        if (Proxy.getDefaultHost() == null)
        {
          paramContext = Proxy.getHost(paramContext);
          if (paramContext == null) {}
        }
        else
        {
          AppMethodBeat.o(212029);
          return 2;
        }
        AppMethodBeat.o(212029);
        return 1;
      }
      if (Build.VERSION.SDK_INT >= 13)
      {
        i = localNetworkInfo.getType();
        if (i == 9)
        {
          AppMethodBeat.o(212029);
          return 0;
        }
      }
    }
    finally
    {
      i.e("sensor_NetworkUtil", paramContext);
      AppMethodBeat.o(212029);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.g.c.g
 * JD-Core Version:    0.7.0.1
 */