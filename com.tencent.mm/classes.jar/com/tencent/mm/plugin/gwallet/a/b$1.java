package com.tencent.mm.plugin.gwallet.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.a.a.a.a;
import com.a.a.a.a.a;
import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements ServiceConnection
{
  b$1(b paramb, b.a parama) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    y.d("MicroMsg.IabHelper", "Billing service connected.");
    this.ljf.liY = a.a.e(paramIBinder);
    paramComponentName = this.ljf.mContext.getPackageName();
    try
    {
      y.d("MicroMsg.IabHelper", "Checking for in-app billing 3 support.");
      int i = this.ljf.liY.b(3, paramComponentName, "inapp");
      if (i != 0)
      {
        if (this.lje != null) {
          this.lje.a(new c(i, "Error checking for billing v3 support."));
        }
        this.ljf.ljb = false;
        return;
      }
      y.d("MicroMsg.IabHelper", "In-app billing version 3 supported for " + paramComponentName);
      i = this.ljf.liY.b(3, paramComponentName, "subs");
      if (i == 0)
      {
        y.d("MicroMsg.IabHelper", "Subscriptions AVAILABLE.");
        this.ljf.ljb = true;
      }
      for (;;)
      {
        this.ljf.lja = true;
        if (this.lje == null) {
          break;
        }
        this.lje.a(new c(0, "Setup successful."));
        return;
        y.d("MicroMsg.IabHelper", "Subscriptions NOT AVAILABLE. Response: " + i);
      }
      return;
    }
    catch (RemoteException paramComponentName)
    {
      if (this.lje != null) {
        this.lje.a(new c(-1001, "RemoteException while setting up in-app billing."));
      }
      y.printErrStackTrace("MicroMsg.IabHelper", paramComponentName, "", new Object[0]);
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    y.d("MicroMsg.IabHelper", "Billing service disconnected.");
    this.ljf.liY = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.a.b.1
 * JD-Core Version:    0.7.0.1
 */