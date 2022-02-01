package com.tencent.beacon.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import com.tencent.beacon.d.a;

public final class f
  extends BroadcastReceiver
{
  private boolean a = false;
  
  public final void a(Context paramContext)
  {
    if (paramContext == null) {
      a.c(" Context is null!", new Object[0]);
    }
    while (this.a) {
      return;
    }
    this.a = true;
    paramContext.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramContext == null) {}
    try
    {
      a.c(" onReceive context is null!", new Object[0]);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localObject == null)
    {
      a.c(" onReceive ConnectivityManager is null!", new Object[0]);
      return;
    }
    paramIntent = ((ConnectivityManager)localObject).getNetworkInfo(1);
    localObject = ((ConnectivityManager)localObject).getNetworkInfo(0);
    if (paramIntent != null) {}
    for (paramIntent = paramIntent.getState();; paramIntent = null)
    {
      if (localObject != null) {}
      for (localObject = ((NetworkInfo)localObject).getState();; localObject = null)
      {
        if ((paramIntent != null) && (localObject != null) && (NetworkInfo.State.CONNECTED != paramIntent) && (NetworkInfo.State.CONNECTED == localObject))
        {
          h.c(paramContext);
          return;
        }
        if ((paramIntent == null) || (NetworkInfo.State.CONNECTED != paramIntent)) {
          break;
        }
        h.c(paramContext);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.f
 * JD-Core Version:    0.7.0.1
 */