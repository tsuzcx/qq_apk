package com.tencent.mm.plugin.appbrand.ipc;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

final class AppBrandMainProcessService$2$1
  implements IBinder.DeathRecipient
{
  AppBrandMainProcessService$2$1(AppBrandMainProcessService.2 param2, String paramString, IBinder paramIBinder) {}
  
  public final void binderDied()
  {
    AppMethodBeat.i(90981);
    IBinder.DeathRecipient localDeathRecipient = (IBinder.DeathRecipient)AppBrandMainProcessService.b(this.hvO.hvM).get(this.eDZ);
    if (localDeathRecipient == null)
    {
      AppMethodBeat.o(90981);
      return;
    }
    this.hvN.unlinkToDeath(localDeathRecipient, 0);
    AppBrandMainProcessService.b(this.hvO.hvM).remove(this.eDZ);
    AppBrandMainProcessService.aBb();
    ab.e("MicroMsg.AppBrandMainProcessService", "Client Process Died: %s", new Object[] { this.eDZ });
    AppMethodBeat.o(90981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.2.1
 * JD-Core Version:    0.7.0.1
 */