package com.tencent.mm.plugin.gwallet.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.vending.billing.IInAppBillingService;
import com.android.vending.billing.IInAppBillingService.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$1
  implements ServiceConnection
{
  b$1(b paramb, b.a parama) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    AppMethodBeat.i(41692);
    ab.d("MicroMsg.IabHelper", "Billing service connected.");
    this.nGu.nGn = IInAppBillingService.a.f(paramIBinder);
    paramComponentName = this.nGu.mContext.getPackageName();
    try
    {
      ab.d("MicroMsg.IabHelper", "Checking for in-app billing 3 support.");
      int i = this.nGu.nGn.b(3, paramComponentName, "inapp");
      if (i != 0)
      {
        if (this.nGt != null) {
          this.nGt.a(new c(i, "Error checking for billing v3 support."));
        }
        this.nGu.nGq = false;
        AppMethodBeat.o(41692);
        return;
      }
      ab.d("MicroMsg.IabHelper", "In-app billing version 3 supported for ".concat(String.valueOf(paramComponentName)));
      i = this.nGu.nGn.b(3, paramComponentName, "subs");
      if (i == 0)
      {
        ab.d("MicroMsg.IabHelper", "Subscriptions AVAILABLE.");
        this.nGu.nGq = true;
      }
      for (;;)
      {
        this.nGu.nGp = true;
        if (this.nGt != null) {
          this.nGt.a(new c(0, "Setup successful."));
        }
        AppMethodBeat.o(41692);
        return;
        ab.d("MicroMsg.IabHelper", "Subscriptions NOT AVAILABLE. Response: ".concat(String.valueOf(i)));
      }
      return;
    }
    catch (RemoteException paramComponentName)
    {
      if (this.nGt != null) {
        this.nGt.a(new c(-1001, "RemoteException while setting up in-app billing."));
      }
      ab.printErrStackTrace("MicroMsg.IabHelper", paramComponentName, "", new Object[0]);
      AppMethodBeat.o(41692);
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    AppMethodBeat.i(41691);
    ab.d("MicroMsg.IabHelper", "Billing service disconnected.");
    this.nGu.nGn = null;
    AppMethodBeat.o(41691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.a.b.1
 * JD-Core Version:    0.7.0.1
 */