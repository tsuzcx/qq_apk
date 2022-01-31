package com.tencent.mm.plugin.appbrand.ipc;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class AppBrandMainProcessService$4
  implements ServiceConnection
{
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    AppBrandMainProcessService.a(c.a.q(paramIBinder));
    AppBrandMainProcessService.ahw();
    AppBrandMainProcessService.ahv();
    try
    {
      AppBrandMainProcessService.ahx().a(new Binder(), ae.getProcessName());
      y.i("MicroMsg.AppBrandMainProcessService", "onServiceConnected(%s)", new Object[] { ae.getProcessName() });
      return;
    }
    catch (Exception paramComponentName)
    {
      for (;;)
      {
        y.e("MicroMsg.AppBrandMainProcessService", "onServiceConnected, registerDeathRecipient, %s", new Object[] { paramComponentName });
      }
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    AppBrandMainProcessService.a(null);
    AppBrandMainProcessService.ahu();
    AppBrandMainProcessService.aht();
    y.i("MicroMsg.AppBrandMainProcessService", "onServiceDisconnected(%s)", new Object[] { ae.getProcessName() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.4
 * JD-Core Version:    0.7.0.1
 */