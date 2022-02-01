package com.tencent.mm.booter;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class CoreService$3
  implements Runnable
{
  CoreService$3(CoreService paramCoreService) {}
  
  public final void run()
  {
    AppMethodBeat.i(131840);
    if (Build.VERSION.SDK_INT > 23) {
      ad.i("MicroMsg.CoreService", "KeepAliveService.scheduleKeepAliveJob() flag:%s", new Object[] { Boolean.valueOf(KeepAliveService.Tu()) });
    }
    AppMethodBeat.o(131840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.CoreService.3
 * JD-Core Version:    0.7.0.1
 */