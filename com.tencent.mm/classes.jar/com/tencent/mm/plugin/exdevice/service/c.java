package com.tencent.mm.plugin.exdevice.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  implements ServiceConnection
{
  public a pCr;
  public volatile boolean pCs;
  private List<Runnable> pCt;
  
  public c()
  {
    AppMethodBeat.i(23639);
    this.pCt = new LinkedList();
    AppMethodBeat.o(23639);
  }
  
  public final boolean ak(Runnable paramRunnable)
  {
    AppMethodBeat.i(23643);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(23643);
      return false;
    }
    if (this.pCs) {
      paramRunnable.run();
    }
    for (;;)
    {
      AppMethodBeat.o(23643);
      return true;
      synchronized (this.pCt)
      {
        this.pCt.add(paramRunnable);
      }
    }
  }
  
  public final void eE(Context paramContext)
  {
    AppMethodBeat.i(23642);
    if (!d.eF(paramContext))
    {
      ac.i("MicroMsg.exdevice.ExDeviceServiceConnection", "ensureServiceInstance return false");
      AppMethodBeat.o(23642);
      return;
    }
    if (com.tencent.mm.br.d.a(new Intent(paramContext, ExDeviceService.class), this, "exdevice"))
    {
      ac.i("MicroMsg.exdevice.ExDeviceServiceConnection", "bind exdeviceservice success");
      AppMethodBeat.o(23642);
      return;
    }
    ac.e("MicroMsg.exdevice.ExDeviceServiceConnection", "bind exdeviceservice failed");
    AppMethodBeat.o(23642);
  }
  
  public final void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    AppMethodBeat.i(23640);
    ac.i("MicroMsg.exdevice.ExDeviceServiceConnection", "onServiceConnected");
    ??? = new x(h.a.v(paramIBinder));
    u.a(???);
    ai.eVg();
    ???.a(com.tencent.mm.plugin.exdevice.c.a.cgi());
    ???.b(com.tencent.mm.plugin.exdevice.model.a.cgt());
    if (!???.a(ad.chb())) {
      ac.e("MicroMsg.exdevice.ExDeviceServiceConnection", "simpleBluetoothRegistOnRecv error");
    }
    if (this.pCr != null) {
      this.pCr.onServiceConnected();
    }
    this.pCs = true;
    synchronized (this.pCt)
    {
      paramIBinder = new ArrayList(this.pCt);
      this.pCt.clear();
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
    ac.i("MicroMsg.exdevice.ExDeviceServiceConnection", "onServiceDisconnected");
    this.pCs = false;
    u.a(null);
    ai.eVg();
    if ((az.ayN()) && (!az.afS()))
    {
      eE(ai.getContext());
      AppMethodBeat.o(23641);
      return;
    }
    ac.i("MicroMsg.exdevice.ExDeviceServiceConnection", "no user login, ignore this disconnection");
    AppMethodBeat.o(23641);
  }
  
  public static abstract class a
  {
    public int deq;
    
    public a(int paramInt)
    {
      this.deq = paramInt;
    }
    
    public abstract void onServiceConnected();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.c
 * JD-Core Version:    0.7.0.1
 */