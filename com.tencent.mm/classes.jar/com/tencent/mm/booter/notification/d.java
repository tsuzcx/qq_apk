package com.tencent.mm.booter.notification;

import android.app.Notification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.notification.b.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  implements a
{
  private final String TAG = "MicroMsg.MMNotificationService";
  
  public final void aKX()
  {
    AppMethodBeat.i(238924);
    com.tencent.mm.plugin.notification.d locald = com.tencent.mm.plugin.notification.d.MvM;
    com.tencent.mm.plugin.notification.d.aKX();
    AppMethodBeat.o(238924);
  }
  
  public final void e(Notification paramNotification)
  {
    AppMethodBeat.i(238922);
    if (h.baC().aZN())
    {
      bh.getNotification().c(48, paramNotification);
      AppMethodBeat.o(238922);
      return;
    }
    Log.i("MicroMsg.MMNotificationService", "notify no login ");
    AppMethodBeat.o(238922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.d
 * JD-Core Version:    0.7.0.1
 */