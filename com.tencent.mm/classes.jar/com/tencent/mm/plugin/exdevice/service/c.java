package com.tencent.mm.plugin.exdevice.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  implements ServiceConnection
{
  public a qfW;
  public volatile boolean qfX;
  private List<Runnable> qfY;
  
  public c()
  {
    AppMethodBeat.i(23639);
    this.qfY = new LinkedList();
    AppMethodBeat.o(23639);
  }
  
  public final boolean aj(Runnable paramRunnable)
  {
    AppMethodBeat.i(23643);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(23643);
      return false;
    }
    if (this.qfX) {
      paramRunnable.run();
    }
    for (;;)
    {
      AppMethodBeat.o(23643);
      return true;
      synchronized (this.qfY)
      {
        this.qfY.add(paramRunnable);
      }
    }
  }
  
  public final void eE(Context paramContext)
  {
    AppMethodBeat.i(23642);
    if (!d.eF(paramContext))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExDeviceServiceConnection", "ensureServiceInstance return false");
      AppMethodBeat.o(23642);
      return;
    }
    if (com.tencent.mm.bs.d.a(new Intent(paramContext, ExDeviceService.class), this, "exdevice"))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExDeviceServiceConnection", "bind exdeviceservice success");
      AppMethodBeat.o(23642);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExDeviceServiceConnection", "bind exdeviceservice failed");
    AppMethodBeat.o(23642);
  }
  
  public final void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    AppMethodBeat.i(23640);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExDeviceServiceConnection", "onServiceConnected");
    ??? = new x(h.a.v(paramIBinder));
    u.a(???);
    aj.fkL();
    ???.a(com.tencent.mm.plugin.exdevice.c.a.ckM());
    ???.b(com.tencent.mm.plugin.exdevice.model.a.ckX());
    if (!???.a(com.tencent.mm.plugin.exdevice.model.ad.clF())) {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExDeviceServiceConnection", "simpleBluetoothRegistOnRecv error");
    }
    if (this.qfW != null) {
      this.qfW.onServiceConnected();
    }
    this.qfX = true;
    synchronized (this.qfY)
    {
      paramIBinder = new ArrayList(this.qfY);
      this.qfY.clear();
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExDeviceServiceConnection", "onServiceDisconnected");
    this.qfX = false;
    u.a(null);
    aj.fkL();
    if ((ba.aBR()) && (!ba.aiE()))
    {
      eE(aj.getContext());
      AppMethodBeat.o(23641);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExDeviceServiceConnection", "no user login, ignore this disconnection");
    AppMethodBeat.o(23641);
  }
  
  public static abstract class a
  {
    public int dpM;
    
    public a(int paramInt)
    {
      this.dpM = paramInt;
    }
    
    public abstract void onServiceConnected();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.c
 * JD-Core Version:    0.7.0.1
 */