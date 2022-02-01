package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.performance.watchdogs.d;
import com.tencent.mm.plugin.performance.watchdogs.d.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class Shell$28
  implements Shell.a
{
  public final void v(Intent paramIntent)
  {
    AppMethodBeat.i(231968);
    paramIntent = d.gzs();
    d.b localb = paramIntent.af(true, 3);
    Log.i("MicroMsg.MemoryWatchDog", "[AutoCheck] process = %s AppForeground = %s %s", new Object[] { MMApplicationContext.getProcessName(), Boolean.valueOf(paramIntent.eLx), localb });
    paramIntent.h(localb, true);
    AppMethodBeat.o(231968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.console.Shell.28
 * JD-Core Version:    0.7.0.1
 */