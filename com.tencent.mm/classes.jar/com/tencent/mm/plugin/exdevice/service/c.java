package com.tencent.mm.plugin.exdevice.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  implements ServiceConnection
{
  public c.a jyW;
  public volatile boolean jyX;
  private List<Runnable> jyY = new LinkedList();
  
  public final boolean I(Runnable paramRunnable)
  {
    if (this.jyX) {
      paramRunnable.run();
    }
    for (;;)
    {
      return true;
      synchronized (this.jyY)
      {
        this.jyY.add(paramRunnable);
      }
    }
  }
  
  public final void da(Context paramContext)
  {
    if (!d.db(paramContext))
    {
      y.i("MicroMsg.exdevice.ExDeviceServiceConnection", "ensureServiceInstance return false");
      return;
    }
    if (paramContext.bindService(new Intent(paramContext, ExDeviceService.class), this, 1))
    {
      y.i("MicroMsg.exdevice.ExDeviceServiceConnection", "bind exdeviceservice success");
      return;
    }
    y.e("MicroMsg.exdevice.ExDeviceServiceConnection", "bind exdeviceservice failed");
  }
  
  public final void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    y.i("MicroMsg.exdevice.ExDeviceServiceConnection", "onServiceConnected");
    ??? = new x(h.a.t(paramIBinder));
    u.a(???);
    ae.cqZ();
    ???.a(com.tencent.mm.plugin.exdevice.b.a.aLf());
    ???.b(com.tencent.mm.plugin.exdevice.model.a.aLq());
    if (!???.a(ad.aLX())) {
      y.e("MicroMsg.exdevice.ExDeviceServiceConnection", "simpleBluetoothRegistOnRecv error");
    }
    if (this.jyW != null) {
      this.jyW.onServiceConnected();
    }
    this.jyX = true;
    synchronized (this.jyY)
    {
      paramIBinder = new ArrayList(this.jyY);
      this.jyY.clear();
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
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    y.i("MicroMsg.exdevice.ExDeviceServiceConnection", "onServiceDisconnected");
    this.jyX = false;
    u.a(null);
    ae.cqZ();
    if ((au.Hz()) && (!au.CW()))
    {
      da(ae.getContext());
      return;
    }
    y.i("MicroMsg.exdevice.ExDeviceServiceConnection", "no user login, ignore this disconnection");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.c
 * JD-Core Version:    0.7.0.1
 */