package com.tencent.mm.plugin.exdevice.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  implements ServiceConnection
{
  public a rDx;
  public volatile boolean rDy;
  private List<Runnable> rDz;
  
  public c()
  {
    AppMethodBeat.i(23639);
    this.rDz = new LinkedList();
    AppMethodBeat.o(23639);
  }
  
  public final boolean an(Runnable paramRunnable)
  {
    AppMethodBeat.i(23643);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(23643);
      return false;
    }
    if (this.rDy) {
      paramRunnable.run();
    }
    for (;;)
    {
      AppMethodBeat.o(23643);
      return true;
      synchronized (this.rDz)
      {
        this.rDz.add(paramRunnable);
      }
    }
  }
  
  public final void fc(Context paramContext)
  {
    AppMethodBeat.i(23642);
    if (!d.fd(paramContext))
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
    ??? = new x(h.a.w(paramIBinder));
    u.a(???);
    MMApplicationContext.isExdeviceProcess();
    ???.a(com.tencent.mm.plugin.exdevice.c.a.cKe());
    ???.b(com.tencent.mm.plugin.exdevice.model.a.cKp());
    if (!???.a(ad.cKX())) {
      Log.e("MicroMsg.exdevice.ExDeviceServiceConnection", "simpleBluetoothRegistOnRecv error");
    }
    if (this.rDx != null) {
      this.rDx.onServiceConnected();
    }
    this.rDy = true;
    synchronized (this.rDz)
    {
      paramIBinder = new ArrayList(this.rDz);
      this.rDz.clear();
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
    paramIBinder.clear();
    AppMethodBeat.o(23640);
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    AppMethodBeat.i(23641);
    Log.i("MicroMsg.exdevice.ExDeviceServiceConnection", "onServiceDisconnected");
    this.rDy = false;
    u.a(null);
    MMApplicationContext.isExdeviceProcess();
    if ((bg.aVG()) && (!bg.azj()))
    {
      fc(MMApplicationContext.getContext());
      AppMethodBeat.o(23641);
      return;
    }
    Log.i("MicroMsg.exdevice.ExDeviceServiceConnection", "no user login, ignore this disconnection");
    AppMethodBeat.o(23641);
  }
  
  public static abstract class a
  {
    public int dIe;
    
    public a(int paramInt)
    {
      this.dIe = paramInt;
    }
    
    public abstract void onServiceConnected();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.c
 * JD-Core Version:    0.7.0.1
 */