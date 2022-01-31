package com.tencent.mm.plugin.appbrand.ipc;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class AppBrandMainProcessService$4
  implements ServiceConnection
{
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    AppMethodBeat.i(90986);
    AppBrandMainProcessService.a(c.a.q(paramIBinder));
    AppBrandMainProcessService.aBd();
    ah.getPackageName();
    AppBrandMainProcessService.aBc();
    try
    {
      AppBrandMainProcessService.aBe().a(new Binder(), ah.getProcessName());
      ab.i("MicroMsg.AppBrandMainProcessService", "onServiceConnected(%s)", new Object[] { ah.getProcessName() });
      AppMethodBeat.o(90986);
      return;
    }
    catch (Exception paramComponentName)
    {
      for (;;)
      {
        ab.e("MicroMsg.AppBrandMainProcessService", "onServiceConnected, registerDeathRecipient, %s", new Object[] { paramComponentName });
      }
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    AppMethodBeat.i(90987);
    AppBrandMainProcessService.a(null);
    ah.getPackageName();
    AppBrandMainProcessService.aBb();
    AppBrandMainProcessService.aBa();
    ab.i("MicroMsg.AppBrandMainProcessService", "onServiceDisconnected(%s)", new Object[] { ah.getProcessName() });
    AppMethodBeat.o(90987);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.4
 * JD-Core Version:    0.7.0.1
 */