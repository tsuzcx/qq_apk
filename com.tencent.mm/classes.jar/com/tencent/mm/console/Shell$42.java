package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.performance.watchdogs.f;
import com.tencent.mm.plugin.performance.watchdogs.f.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.Collection;
import java.util.Iterator;

final class Shell$42
  implements Shell.a
{
  public final void v(Intent paramIntent)
  {
    AppMethodBeat.i(231957);
    if ((!WeChatEnvironment.hasDebugger()) && (!WeChatEnvironment.isMonkeyEnv()))
    {
      Log.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
      AppMethodBeat.o(231957);
      return;
    }
    paramIntent = f.gzG();
    Iterator localIterator = f.gzE().iterator();
    for (int i = 0; localIterator.hasNext(); i = ((f.c)localIterator.next()).getSize() + i) {}
    Log.e("MicroMsg.ThreadWatchDog", "threads:[%s:%s][%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(f.gzF()), paramIntent.toString() });
    AppMethodBeat.o(231957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.console.Shell.42
 * JD-Core Version:    0.7.0.1
 */