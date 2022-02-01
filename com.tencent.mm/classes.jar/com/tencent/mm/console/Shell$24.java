package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.performance.watchdogs.c;
import com.tencent.mm.plugin.performance.watchdogs.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class Shell$24
  implements Shell.a
{
  public final void u(Intent paramIntent)
  {
    AppMethodBeat.i(285909);
    paramIntent = c.fou();
    c.b localb = paramIntent.ad(true, 3);
    Log.i("MicroMsg.MemoryWatchDog", "[AutoCheck] process = %s AppForeground = %s %s", new Object[] { MMApplicationContext.getProcessName(), Boolean.valueOf(paramIntent.cQt), localb });
    paramIntent.c(localb, true);
    AppMethodBeat.o(285909);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.console.Shell.24
 * JD-Core Version:    0.7.0.1
 */