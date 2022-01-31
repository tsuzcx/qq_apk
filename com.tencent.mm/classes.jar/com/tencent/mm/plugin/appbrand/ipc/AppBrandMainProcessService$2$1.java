package com.tencent.mm.plugin.appbrand.ipc;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class AppBrandMainProcessService$2$1
  implements IBinder.DeathRecipient
{
  AppBrandMainProcessService$2$1(AppBrandMainProcessService.2 param2, IBinder paramIBinder, String paramString) {}
  
  public final void binderDied()
  {
    this.gdQ.unlinkToDeath((IBinder.DeathRecipient)AppBrandMainProcessService.b(this.gdR.gdP).get(this.dGw), 0);
    AppBrandMainProcessService.b(this.gdR.gdP).remove(this.dGw);
    AppBrandMainProcessService.ahu();
    y.e("MicroMsg.AppBrandMainProcessService", "Client Process Died: %s", new Object[] { this.dGw });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.2.1
 * JD-Core Version:    0.7.0.1
 */