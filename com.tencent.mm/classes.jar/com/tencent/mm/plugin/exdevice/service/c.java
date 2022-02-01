package com.tencent.mm.plugin.exdevice.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  implements ServiceConnection
{
  public c.a vjh;
  public volatile boolean vji;
  private List<Runnable> vjj;
  
  public c()
  {
    AppMethodBeat.i(23639);
    this.vjj = new LinkedList();
    AppMethodBeat.o(23639);
  }
  
  public final boolean as(Runnable paramRunnable)
  {
    AppMethodBeat.i(23643);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(23643);
      return false;
    }
    if (this.vji) {
      paramRunnable.run();
    }
    for (;;)
    {
      AppMethodBeat.o(23643);
      return true;
      synchronized (this.vjj)
      {
        this.vjj.add(paramRunnable);
      }
    }
  }
  
  public final void fg(Context paramContext)
  {
    AppMethodBeat.i(23642);
    if (!d.fh(paramContext))
    {
      Log.i("MicroMsg.exdevice.ExDeviceServiceConnection", "ensureServiceInstance return false");
      AppMethodBeat.o(23642);
      return;
    }
    if (com.tencent.mm.by.c.a(new Intent(paramContext, ExDeviceService.class), this, "exdevice"))
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
    ??? = new x(h.a.z(paramIBinder));
    u.a(???);
    MMApplicationContext.isExdeviceProcess();
    ???.a(com.tencent.mm.plugin.exdevice.c.a.cYO());
    ???.b(com.tencent.mm.plugin.exdevice.model.a.cYZ());
    if (!???.a(ae.cZK())) {
      Log.e("MicroMsg.exdevice.ExDeviceServiceConnection", "simpleBluetoothRegistOnRecv error");
    }
    if (this.vjh != null) {
      this.vjh.cZf();
    }
    this.vji = true;
    synchronized (this.vjj)
    {
      paramIBinder = new ArrayList(this.vjj);
      this.vjj.clear();
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
    this.vji = false;
    u.a(null);
    MMApplicationContext.isExdeviceProcess();
    if ((bh.beJ()) && (!bh.aGE()))
    {
      fg(MMApplicationContext.getContext());
      AppMethodBeat.o(23641);
      return;
    }
    Log.i("MicroMsg.exdevice.ExDeviceServiceConnection", "no user login, ignore this disconnection");
    AppMethodBeat.o(23641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.c
 * JD-Core Version:    0.7.0.1
 */