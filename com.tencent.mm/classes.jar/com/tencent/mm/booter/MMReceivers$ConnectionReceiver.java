package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import com.jg.JgClassChecked;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.aa.a;
import com.tencent.mm.sdk.platformtools.y;

@JgClassChecked(author=20, fComment="checked", lastDate="20140819", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
public class MMReceivers$ConnectionReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramContext == null) {}
    do
    {
      return;
      y.i("MicroMsg.ConnectionReceiver", "onReceive threadID: " + Thread.currentThread().getId());
      if (!b.s(paramContext, "connection"))
      {
        MMReceivers.AlarmReceiver.aW(paramContext);
        y.cqL();
        return;
      }
    } while (aa.Ut() == null);
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
        y.e("MicroMsg.ConnectionReceiver", "getActiveNetworkInfo failed. exception: %s", new Object[] { paramIntent.getMessage() });
        continue;
        paramIntent = paramContext.getState();
      }
      y.i("MicroMsg.ConnectionReceiver", "NetworkAvailable: true");
      paramIntent = aa.Ut();
      paramContext.getTypeName();
      paramContext.getSubtypeName();
      paramIntent.ba(true);
    }
    if ((paramContext == null) || (paramContext.getState() != NetworkInfo.State.CONNECTED)) {
      if (paramContext == null)
      {
        paramIntent = "null";
        y.i("MicroMsg.ConnectionReceiver", "NetworkAvailable: false, state:%s", new Object[] { paramIntent });
        paramIntent = aa.Ut();
        if (paramContext != null) {
          paramContext.getTypeName();
        }
        if (paramContext != null) {
          paramContext.getSubtypeName();
        }
        paramIntent.ba(false);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.MMReceivers.ConnectionReceiver
 * JD-Core Version:    0.7.0.1
 */