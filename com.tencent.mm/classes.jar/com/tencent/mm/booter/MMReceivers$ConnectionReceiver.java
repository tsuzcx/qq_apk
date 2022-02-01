package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.m;
import com.tencent.mm.network.ag;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

@m
public class MMReceivers$ConnectionReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(131890);
    new StringBuilder("onReceive process: ").append(Process.myPid());
    Log.i("MicroMsg.ConnectionReceiver", "onReceive threadID: " + Thread.currentThread().getId());
    if (paramContext == null)
    {
      AppMethodBeat.o(131890);
      return;
    }
    if (!b.c(paramContext, "connection", true))
    {
      MMReceivers.AlarmReceiver.cS(paramContext);
      Log.appenderFlush();
      AppMethodBeat.o(131890);
      return;
    }
    if (ag.bRw())
    {
      AppMethodBeat.o(131890);
      return;
    }
    paramIntent = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
    paramContext = null;
    try
    {
      paramIntent = paramIntent.getActiveNetworkInfo();
      paramContext = paramIntent;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        Log.e("MicroMsg.ConnectionReceiver", "getActiveNetworkInfo failed. exception: %s", new Object[] { paramIntent.getMessage() });
        continue;
        paramIntent = paramContext.getState();
      }
      Log.i("MicroMsg.ConnectionReceiver", "NetworkAvailable: true");
      paramContext.getTypeName();
      paramContext.getSubtypeName();
      ag.hD(true);
      AppMethodBeat.o(131890);
    }
    if ((paramContext == null) || (paramContext.getState() != NetworkInfo.State.CONNECTED)) {
      if (paramContext == null)
      {
        paramIntent = "null";
        Log.i("MicroMsg.ConnectionReceiver", "NetworkAvailable: false, state:%s", new Object[] { paramIntent });
        if (paramContext != null) {
          paramContext.getTypeName();
        }
        if (paramContext != null) {
          paramContext.getSubtypeName();
        }
        ag.hD(false);
        AppMethodBeat.o(131890);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.booter.MMReceivers.ConnectionReceiver
 * JD-Core Version:    0.7.0.1
 */