package com.tencent.mm.plugin.exdevice.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  implements ServiceConnection
{
  public a qmB;
  public volatile boolean qmC;
  private List<Runnable> qmD;
  
  public c()
  {
    AppMethodBeat.i(23639);
    this.qmD = new LinkedList();
    AppMethodBeat.o(23639);
  }
  
  public final boolean ah(Runnable paramRunnable)
  {
    AppMethodBeat.i(23643);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(23643);
      return false;
    }
    if (this.qmC) {
      paramRunnable.run();
    }
    for (;;)
    {
      AppMethodBeat.o(23643);
      return true;
      synchronized (this.qmD)
      {
        this.qmD.add(paramRunnable);
      }
    }
  }
  
  public final void eI(Context paramContext)
  {
    AppMethodBeat.i(23642);
    if (!d.eJ(paramContext))
    {
      ae.i("MicroMsg.exdevice.ExDeviceServiceConnection", "ensureServiceInstance return false");
      AppMethodBeat.o(23642);
      return;
    }
    if (com.tencent.mm.br.d.a(new Intent(paramContext, ExDeviceService.class), this, "exdevice"))
    {
      ae.i("MicroMsg.exdevice.ExDeviceServiceConnection", "bind exdeviceservice success");
      AppMethodBeat.o(23642);
      return;
    }
    ae.e("MicroMsg.exdevice.ExDeviceServiceConnection", "bind exdeviceservice failed");
    AppMethodBeat.o(23642);
  }
  
  public final void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    AppMethodBeat.i(23640);
    ae.i("MicroMsg.exdevice.ExDeviceServiceConnection", "onServiceConnected");
    ??? = new x(h.a.w(paramIBinder));
    u.a(???);
    ak.foF();
    ???.a(com.tencent.mm.plugin.exdevice.c.a.cmc());
    ???.b(com.tencent.mm.plugin.exdevice.model.a.cmn());
    if (!???.a(ad.cmV())) {
      ae.e("MicroMsg.exdevice.ExDeviceServiceConnection", "simpleBluetoothRegistOnRecv error");
    }
    if (this.qmB != null) {
      this.qmB.onServiceConnected();
    }
    this.qmC = true;
    synchronized (this.qmD)
    {
      paramIBinder = new ArrayList(this.qmD);
      this.qmD.clear();
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
    ae.i("MicroMsg.exdevice.ExDeviceServiceConnection", "onServiceDisconnected");
    this.qmC = false;
    u.a(null);
    ak.foF();
    if ((bc.aCh()) && (!bc.aiT()))
    {
      eI(ak.getContext());
      AppMethodBeat.o(23641);
      return;
    }
    ae.i("MicroMsg.exdevice.ExDeviceServiceConnection", "no user login, ignore this disconnection");
    AppMethodBeat.o(23641);
  }
  
  public static abstract class a
  {
    public int dqR;
    
    public a(int paramInt)
    {
      this.dqR = paramInt;
    }
    
    public abstract void onServiceConnected();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.c
 * JD-Core Version:    0.7.0.1
 */