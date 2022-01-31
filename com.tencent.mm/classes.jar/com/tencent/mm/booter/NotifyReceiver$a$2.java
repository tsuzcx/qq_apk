package com.tencent.mm.booter;

import android.os.Process;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.plugin.zero.a.b;
import com.tencent.mm.sdk.platformtools.y;

final class NotifyReceiver$a$2
  implements Runnable
{
  NotifyReceiver$a$2(NotifyReceiver.a parama) {}
  
  public final void run()
  {
    y.i("MicroMsg.NotifyReceiver", "checkKillProcess, canKillProcess :%b", new Object[] { Boolean.valueOf(NotifyReceiver.access$900()) });
    synchronized (NotifyReceiver.vZ())
    {
      if (NotifyReceiver.wa() != null) {
        NotifyReceiver.wa().unLock();
      }
      NotifyReceiver.a(null);
      if (NotifyReceiver.access$900())
      {
        ??? = (PluginZero)g.t(PluginZero.class);
        if (((PluginZero)???).rSe != null) {
          ((PluginZero)???).rSe.awj();
        }
        y.cqM();
        Process.killProcess(Process.myPid());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.booter.NotifyReceiver.a.2
 * JD-Core Version:    0.7.0.1
 */