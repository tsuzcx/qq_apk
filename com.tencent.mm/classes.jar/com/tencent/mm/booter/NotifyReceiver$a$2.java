package com.tencent.mm.booter;

import android.os.Process;
import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.plugin.zero.a.b;
import com.tencent.mm.sdk.platformtools.ab;

final class NotifyReceiver$a$2
  implements Runnable
{
  NotifyReceiver$a$2(NotifyReceiver.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(57781);
    ab.i("MicroMsg.NotifyReceiver", "checkKillProcess, canKillProcess :%b", new Object[] { Boolean.valueOf(NotifyReceiver.access$900()) });
    synchronized (NotifyReceiver.Io())
    {
      if (NotifyReceiver.Ip() != null) {
        NotifyReceiver.Ip().unLock();
      }
      NotifyReceiver.a(null);
      if (NotifyReceiver.access$900())
      {
        ??? = (PluginZero)g.G(PluginZero.class);
        if (((PluginZero)???).vIZ != null) {
          ((PluginZero)???).vIZ.aVN();
        }
        ab.dsJ();
        Process.killProcess(Process.myPid());
      }
      AppMethodBeat.o(57781);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.booter.NotifyReceiver.a.2
 * JD-Core Version:    0.7.0.1
 */