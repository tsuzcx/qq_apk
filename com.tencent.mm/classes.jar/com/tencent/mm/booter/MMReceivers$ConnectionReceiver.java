package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Process;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.k;
import com.tencent.mm.network.ad.a;

@k
@JgClassChecked(author=20, fComment="checked", lastDate="20140819", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
public class MMReceivers$ConnectionReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(131890);
    new StringBuilder("onReceive process: ").append(Process.myPid());
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ConnectionReceiver", "onReceive threadID: " + Thread.currentThread().getId());
    if (paramContext == null)
    {
      AppMethodBeat.o(131890);
      return;
    }
    if (!b.c(paramContext, "connection", true))
    {
      MMReceivers.AlarmReceiver.bL(paramContext);
      com.tencent.mm.sdk.platformtools.ad.eFw();
      AppMethodBeat.o(131890);
      return;
    }
    if (com.tencent.mm.network.ad.aFn() == null)
    {
      AppMethodBeat.o(131890);
      return;
    }
    paramIntent = (ConnectivityManager)paramContext.getSystemService("connectivity");
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
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ConnectionReceiver", "getActiveNetworkInfo failed. exception: %s", new Object[] { paramIntent.getMessage() });
        continue;
        paramIntent = paramContext.getState();
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ConnectionReceiver", "NetworkAvailable: true");
      paramIntent = com.tencent.mm.network.ad.aFn();
      paramContext.getTypeName();
      paramContext.getSubtypeName();
      paramIntent.cu(true);
      AppMethodBeat.o(131890);
    }
    if ((paramContext == null) || (paramContext.getState() != NetworkInfo.State.CONNECTED)) {
      if (paramContext == null)
      {
        paramIntent = "null";
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ConnectionReceiver", "NetworkAvailable: false, state:%s", new Object[] { paramIntent });
        paramIntent = com.tencent.mm.network.ad.aFn();
        if (paramContext != null) {
          paramContext.getTypeName();
        }
        if (paramContext != null) {
          paramContext.getSubtypeName();
        }
        paramIntent.cu(false);
        AppMethodBeat.o(131890);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.MMReceivers.ConnectionReceiver
 * JD-Core Version:    0.7.0.1
 */