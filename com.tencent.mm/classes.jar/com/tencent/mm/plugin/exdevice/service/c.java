package com.tencent.mm.plugin.exdevice.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.exdevice.model.ah;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  implements ServiceConnection
{
  private List<Runnable> BI;
  public c.a yvg;
  public volatile boolean yvh;
  
  public c()
  {
    AppMethodBeat.i(23639);
    this.BI = new LinkedList();
    AppMethodBeat.o(23639);
  }
  
  public final boolean aA(Runnable paramRunnable)
  {
    AppMethodBeat.i(23643);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(23643);
      return false;
    }
    if (this.yvh) {
      paramRunnable.run();
    }
    for (;;)
    {
      AppMethodBeat.o(23643);
      return true;
      synchronized (this.BI)
      {
        this.BI.add(paramRunnable);
      }
    }
  }
  
  public final void gd(Context paramContext)
  {
    AppMethodBeat.i(23642);
    if (!d.ge(paramContext))
    {
      Log.i("MicroMsg.exdevice.ExDeviceServiceConnection", "ensureServiceInstance return false");
      AppMethodBeat.o(23642);
      return;
    }
    if (com.tencent.mm.br.c.a(new Intent(paramContext, ExDeviceService.class), this, "exdevice"))
    {
      Log.i("MicroMsg.exdevice.ExDeviceServiceConnection", "bind exdeviceservice success");
      AppMethodBeat.o(23642);
      return;
    }
    Log.e("MicroMsg.exdevice.ExDeviceServiceConnection", "bind exdeviceservice failed");
    AppMethodBeat.o(23642);
  }
  
  public final void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    AppMethodBeat.i(23640);
    Log.i("MicroMsg.exdevice.ExDeviceServiceConnection", "onServiceConnected");
    ??? = new x(h.a.E(paramIBinder));
    u.a(???);
    MMApplicationContext.isExdeviceProcess();
    ???.a(com.tencent.mm.plugin.exdevice.c.a.dFf());
    ???.b(com.tencent.mm.plugin.exdevice.model.a.dFq());
    if (!???.a(ah.dGd())) {
      Log.e("MicroMsg.exdevice.ExDeviceServiceConnection", "simpleBluetoothRegistOnRecv error");
    }
    if (this.yvg != null) {
      this.yvg.dFw();
    }
    this.yvh = true;
    synchronized (this.BI)
    {
      paramIBinder = new ArrayList(this.BI);
      this.BI.clear();
      int i = 0;
      if (i < paramIBinder.size())
      {
        ??? = (Runnable)paramIBinder.get(i);
        if (??? != null) {
          ???.run();
        }
        i += 1;
      }
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    AppMethodBeat.i(23641);
    Log.i("MicroMsg.exdevice.ExDeviceServiceConnection", "onServiceDisconnected");
    this.yvh = false;
    u.a(null);
    MMApplicationContext.isExdeviceProcess();
    if ((bh.bCA()) && (!bh.aZG()))
    {
      gd(MMApplicationContext.getContext());
      AppMethodBeat.o(23641);
      return;
    }
    Log.i("MicroMsg.exdevice.ExDeviceServiceConnection", "no user login, ignore this disconnection");
    AppMethodBeat.o(23641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.c
 * JD-Core Version:    0.7.0.1
 */