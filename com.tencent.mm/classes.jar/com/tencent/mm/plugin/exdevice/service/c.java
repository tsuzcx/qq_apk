package com.tencent.mm.plugin.exdevice.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  implements ServiceConnection
{
  public c.a lIv;
  public volatile boolean lIw;
  private List<Runnable> lIx;
  
  public c()
  {
    AppMethodBeat.i(19571);
    this.lIx = new LinkedList();
    AppMethodBeat.o(19571);
  }
  
  public final boolean R(Runnable paramRunnable)
  {
    AppMethodBeat.i(19575);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(19575);
      return false;
    }
    if (this.lIw) {
      paramRunnable.run();
    }
    for (;;)
    {
      AppMethodBeat.o(19575);
      return true;
      synchronized (this.lIx)
      {
        this.lIx.add(paramRunnable);
      }
    }
  }
  
  public final void dM(Context paramContext)
  {
    AppMethodBeat.i(19574);
    if (!d.dN(paramContext))
    {
      ab.i("MicroMsg.exdevice.ExDeviceServiceConnection", "ensureServiceInstance return false");
      AppMethodBeat.o(19574);
      return;
    }
    if (com.tencent.mm.bq.d.a(new Intent(paramContext, ExDeviceService.class), this, "exdevice"))
    {
      ab.i("MicroMsg.exdevice.ExDeviceServiceConnection", "bind exdeviceservice success");
      AppMethodBeat.o(19574);
      return;
    }
    ab.e("MicroMsg.exdevice.ExDeviceServiceConnection", "bind exdeviceservice failed");
    AppMethodBeat.o(19574);
  }
  
  public final void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    AppMethodBeat.i(19572);
    ab.i("MicroMsg.exdevice.ExDeviceServiceConnection", "onServiceConnected");
    ??? = new x(h.a.t(paramIBinder));
    u.a(???);
    ah.dsY();
    ???.a(com.tencent.mm.plugin.exdevice.b.a.bps());
    ???.b(com.tencent.mm.plugin.exdevice.model.a.bpD());
    if (!???.a(ad.bqk())) {
      ab.e("MicroMsg.exdevice.ExDeviceServiceConnection", "simpleBluetoothRegistOnRecv error");
    }
    if (this.lIv != null) {
      this.lIv.onServiceConnected();
    }
    this.lIw = true;
    synchronized (this.lIx)
    {
      paramIBinder = new ArrayList(this.lIx);
      this.lIx.clear();
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
    AppMethodBeat.o(19572);
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    AppMethodBeat.i(19573);
    ab.i("MicroMsg.exdevice.ExDeviceServiceConnection", "onServiceDisconnected");
    this.lIw = false;
    u.a(null);
    ah.dsY();
    if ((aw.aaB()) && (!aw.QP()))
    {
      dM(ah.getContext());
      AppMethodBeat.o(19573);
      return;
    }
    ab.i("MicroMsg.exdevice.ExDeviceServiceConnection", "no user login, ignore this disconnection");
    AppMethodBeat.o(19573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.c
 * JD-Core Version:    0.7.0.1
 */